package com.wireguard.android.backend;

import android.content.Context;
import android.util.Log;
import android.util.Pair;
import com.liapp.y;
import com.wireguard.android.backend.BackendException;
import com.wireguard.android.backend.Tunnel;
import com.wireguard.android.util.RootShell;
import com.wireguard.android.util.ToolsInstaller;
import com.wireguard.config.Config;
import com.wireguard.crypto.Key;
import com.wireguard.util.NonNullForAll;
import defpackage.T60;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

@NonNullForAll
/* loaded from: classes.dex */
public final class WgQuickBackend implements Backend {
    private static final String TAG = "WireGuard/WgQuickBackend";
    private final File localTemporaryDir;
    private boolean multipleTunnels;
    private final RootShell rootShell;
    private final Map<Tunnel, Config> runningConfigs = new HashMap();
    private final ToolsInstaller toolsInstaller;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public WgQuickBackend(Context context, RootShell rootShell, ToolsInstaller toolsInstaller) {
        this.localTemporaryDir = new File(context.getCacheDir(), y.گ֮۬۲ݮ(2086588443));
        this.rootShell = rootShell;
        this.toolsInstaller = toolsInstaller;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static boolean hasKernelSupport() {
        return new File(y.ش۳ֲ׬٨(1672432266)).exists();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.wireguard.android.backend.Backend
    public Tunnel.State getState(Tunnel tunnel) {
        return getRunningTunnelNames().contains(tunnel.getName()) ? Tunnel.State.UP : Tunnel.State.DOWN;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.wireguard.android.backend.Backend
    public Statistics getStatistics(Tunnel tunnel) {
        String str = y.۳׭خ۲ݮ(1787189255);
        Statistics statistics = new Statistics();
        ArrayList arrayList = new ArrayList();
        try {
        } catch (Exception unused) {
        }
        if (this.rootShell.run(arrayList, str + tunnel.getName() + "' dump") != 0) {
            return statistics;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            String[] split = ((String) it.next()).split(y.ܴ٭׮ڱܭ(-366262428));
            if (split.length == 8) {
                try {
                    statistics.add(Key.fromBase64(split[0]), Long.parseLong(split[5]), Long.parseLong(split[6]), 1000 * Long.parseLong(split[4]));
                } catch (Exception unused2) {
                }
            }
        }
        return statistics;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.wireguard.android.backend.Backend
    public String getVersion() {
        ArrayList arrayList = new ArrayList();
        if (this.rootShell.run(arrayList, y.ܴٳݴܯޫ(-170205719)) != 0 || arrayList.isEmpty()) {
            throw new BackendException(BackendException.Reason.UNKNOWN_KERNEL_MODULE_NAME, new Object[0]);
        }
        return (String) arrayList.get(0);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setMultipleTunnels(boolean z) {
        this.multipleTunnels = z;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.wireguard.android.backend.Backend
    public Tunnel.State setState(Tunnel tunnel, Tunnel.State state, Config config) {
        Tunnel.State state2;
        Tunnel.State state3 = getState(tunnel);
        Config config2 = this.runningConfigs.get(tunnel);
        HashMap hashMap = new HashMap(this.runningConfigs);
        if (state == Tunnel.State.TOGGLE && state3 == (state = Tunnel.State.UP)) {
            state = Tunnel.State.DOWN;
        }
        Tunnel.State state4 = Tunnel.State.UP;
        if ((state == state4 && state3 == state4 && config2 != null && config2 == config) || (state == (state2 = Tunnel.State.DOWN) && state3 == state2)) {
            return state3;
        }
        if (state == state4) {
            this.toolsInstaller.ensureToolsAvailable();
            if (!this.multipleTunnels && state3 == state2) {
                LinkedList<Pair> linkedList = new LinkedList();
                try {
                    for (Map.Entry entry : hashMap.entrySet()) {
                        setStateInternal((Tunnel) entry.getKey(), (Config) entry.getValue(), Tunnel.State.DOWN);
                        linkedList.add(Pair.create((Tunnel) entry.getKey(), (Config) entry.getValue()));
                    }
                } catch (Exception e) {
                    try {
                        for (Pair pair : linkedList) {
                            setStateInternal((Tunnel) pair.first, (Config) pair.second, Tunnel.State.UP);
                        }
                    } catch (Exception unused) {
                    }
                    throw e;
                }
            }
            Tunnel.State state5 = Tunnel.State.UP;
            if (state3 == state5) {
                setStateInternal(tunnel, config2 == null ? config : config2, Tunnel.State.DOWN);
            }
            try {
                setStateInternal(tunnel, config, state5);
            } catch (Exception e2) {
                try {
                    Tunnel.State state6 = Tunnel.State.UP;
                    if (state3 == state6 && config2 != null) {
                        setStateInternal(tunnel, config2, state6);
                    }
                    if (!this.multipleTunnels && state3 == Tunnel.State.DOWN) {
                        for (Map.Entry entry2 : hashMap.entrySet()) {
                            setStateInternal((Tunnel) entry2.getKey(), (Config) entry2.getValue(), Tunnel.State.UP);
                        }
                    }
                } catch (Exception unused2) {
                }
                throw e2;
            }
        } else if (state == state2) {
            if (config2 != null) {
                config = config2;
            }
            setStateInternal(tunnel, config, state2);
        }
        return state;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void setStateInternal(Tunnel tunnel, Config config, Tunnel.State state) {
        Log.i(y.ۮخݳ٬ۨ(1835630206), y.گ֮۬۲ݮ(2086590819) + tunnel.getName() + ' ' + state);
        Objects.requireNonNull(config, y.ڮڴجۭݩ(1256606509));
        File file = new File(this.localTemporaryDir, tunnel.getName() + y.ش۳ֲ׬٨(1672433578));
        FileOutputStream fileOutputStream = new FileOutputStream(file, false);
        try {
            fileOutputStream.write(config.toWgQuickString().getBytes(StandardCharsets.UTF_8));
            fileOutputStream.close();
            String y = T60.y(y.گ֮۬۲ݮ(2086589915), state.toString().toLowerCase(Locale.ENGLISH), y.ش۳ֲ׬٨(1672433434), file.getAbsolutePath(), y.ش۳ֲ׬٨(1672433402));
            Tunnel.State state2 = Tunnel.State.UP;
            if (state == state2) {
                y = y.ڮڴجۭݩ(1256606925).concat(y);
            }
            int run = this.rootShell.run(null, y);
            file.delete();
            if (run == 0) {
                if (state == state2) {
                    this.runningConfigs.put(tunnel, config);
                } else {
                    this.runningConfigs.remove(tunnel);
                }
                tunnel.onStateChange(state);
                return;
            }
            throw new BackendException(BackendException.Reason.WG_QUICK_CONFIG_ERROR_CODE, Integer.valueOf(run));
        } catch (Throwable th) {
            try {
                fileOutputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.wireguard.android.backend.Backend
    public Set<String> getRunningTunnelNames() {
        ArrayList arrayList = new ArrayList();
        try {
            this.toolsInstaller.ensureToolsAvailable();
            if (this.rootShell.run(arrayList, "wg show interfaces") == 0 && !arrayList.isEmpty()) {
                String[] split = ((String) arrayList.get(0)).split(y.ۮخݳ٬ۨ(1835629062));
                HashSet hashSet = new HashSet(split.length);
                for (String str : split) {
                    Objects.requireNonNull(str);
                    if (!hashSet.add(str)) {
                        throw new IllegalArgumentException(y.گ֮۬۲ݮ(2086590267) + ((Object) str));
                    }
                }
                return Collections.unmodifiableSet(hashSet);
            }
            return Collections.emptySet();
        } catch (Exception e) {
            Log.w(y.ۮخݳ٬ۨ(1835630206), y.׬ܮ֮ڱܭ(1520063392), e);
            return Collections.emptySet();
        }
    }
}
