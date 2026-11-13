package org.yaml.snakeyaml.resolver;

import com.liapp.y;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import org.yaml.snakeyaml.nodes.NodeId;
import org.yaml.snakeyaml.nodes.Tag;

/* loaded from: classes2.dex */
public class Resolver {
    protected Map<Character, List<ResolverTuple>> yamlImplicitResolvers;
    public static final Pattern BOOL = Pattern.compile(y.ܴ٭׮ڱܭ(-366418940));
    public static final Pattern FLOAT = Pattern.compile(y.ۮخݳ٬ۨ(1835721430));
    public static final Pattern INT = Pattern.compile(y.۳׭خ۲ݮ(1787163455));
    public static final Pattern MERGE = Pattern.compile(y.ڮڴجۭݩ(1256578933));
    public static final Pattern NULL = Pattern.compile(y.گ֮۬۲ݮ(2086487971));
    public static final Pattern EMPTY = Pattern.compile(y.ܴٳݴܯޫ(-170298727));
    public static final Pattern TIMESTAMP = Pattern.compile(y.ۮخݳ٬ۨ(1835723702));
    public static final Pattern VALUE = Pattern.compile(y.ۮخݳ٬ۨ(1835725414));
    public static final Pattern YAML = Pattern.compile(y.ۮخݳ٬ۨ(1835725358));

    /* renamed from: org.yaml.snakeyaml.resolver.Resolver$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$yaml$snakeyaml$nodes$NodeId;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static {
            int[] iArr = new int[NodeId.values().length];
            $SwitchMap$org$yaml$snakeyaml$nodes$NodeId = iArr;
            try {
                iArr[NodeId.scalar.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$yaml$snakeyaml$nodes$NodeId[NodeId.sequence.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void addImplicitResolver(Tag tag, Pattern pattern, String str) {
        if (str == null) {
            List<ResolverTuple> list = this.yamlImplicitResolvers.get(null);
            if (list == null) {
                list = new ArrayList<>();
                this.yamlImplicitResolvers.put(null, list);
            }
            list.add(new ResolverTuple(tag, pattern));
            return;
        }
        for (char c : str.toCharArray()) {
            Character valueOf = Character.valueOf(c);
            if (c == 0) {
                valueOf = null;
            }
            List<ResolverTuple> list2 = this.yamlImplicitResolvers.get(valueOf);
            if (list2 == null) {
                list2 = new ArrayList<>();
                this.yamlImplicitResolvers.put(valueOf, list2);
            }
            list2.add(new ResolverTuple(tag, pattern));
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void addImplicitResolvers() {
        addImplicitResolver(Tag.BOOL, BOOL, y.ܴ٭׮ڱܭ(-366415588));
        addImplicitResolver(Tag.INT, INT, y.ڮڴجۭݩ(1256572573));
        addImplicitResolver(Tag.FLOAT, FLOAT, y.ڮڴجۭݩ(1256572525));
        addImplicitResolver(Tag.MERGE, MERGE, y.ۮخݳ٬ۨ(1835672934));
        Tag tag = Tag.NULL;
        addImplicitResolver(tag, NULL, "~nN\u0000");
        addImplicitResolver(tag, EMPTY, null);
        addImplicitResolver(Tag.TIMESTAMP, TIMESTAMP, y.ܴ٭׮ڱܭ(-366411836));
        addImplicitResolver(Tag.VALUE, VALUE, y.۳׭خ۲ݮ(1787195287));
        addImplicitResolver(Tag.YAML, YAML, y.ܴٳݴܯޫ(-170302007));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Tag resolve(NodeId nodeId, String str, boolean z) {
        Map<Character, List<ResolverTuple>> map;
        if (nodeId == NodeId.scalar && z) {
            char c = 0;
            if (str.length() == 0) {
                map = this.yamlImplicitResolvers;
            } else {
                map = this.yamlImplicitResolvers;
                c = str.charAt(0);
            }
            List<ResolverTuple> list = map.get(Character.valueOf(c));
            if (list != null) {
                for (ResolverTuple resolverTuple : list) {
                    Tag tag = resolverTuple.getTag();
                    if (resolverTuple.getRegexp().matcher(str).matches()) {
                        return tag;
                    }
                }
            }
            if (this.yamlImplicitResolvers.containsKey(null)) {
                for (ResolverTuple resolverTuple2 : this.yamlImplicitResolvers.get(null)) {
                    Tag tag2 = resolverTuple2.getTag();
                    if (resolverTuple2.getRegexp().matcher(str).matches()) {
                        return tag2;
                    }
                }
            }
        }
        int i = AnonymousClass1.$SwitchMap$org$yaml$snakeyaml$nodes$NodeId[nodeId.ordinal()];
        return i != 1 ? i != 2 ? Tag.MAP : Tag.SEQ : Tag.STR;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Resolver() {
        this(true);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Resolver(boolean z) {
        this.yamlImplicitResolvers = new HashMap();
        if (z) {
            addImplicitResolvers();
        }
    }
}
