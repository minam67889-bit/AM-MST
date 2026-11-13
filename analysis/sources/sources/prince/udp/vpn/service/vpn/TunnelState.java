package prince.udp.vpn.service.vpn;

/* loaded from: classes2.dex */
public class TunnelState {
    private static TunnelState m_tunnelState;
    private TunnelVpnManager m_tunnelManager = null;
    private boolean m_startingTunnelManager = false;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private TunnelState() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static synchronized TunnelState getTunnelState() {
        TunnelState tunnelState;
        synchronized (TunnelState.class) {
            try {
                if (m_tunnelState == null) {
                    m_tunnelState = new TunnelState();
                }
                tunnelState = m_tunnelState;
            } catch (Throwable th) {
                throw th;
            }
        }
        return tunnelState;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Object clone() {
        throw new CloneNotSupportedException();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public synchronized boolean getStartingTunnelManager() {
        return this.m_startingTunnelManager;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public synchronized TunnelVpnManager getTunnelManager() {
        return this.m_tunnelManager;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public synchronized void setStartingTunnelManager() {
        this.m_startingTunnelManager = true;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public synchronized void setTunnelManager(TunnelVpnManager tunnelVpnManager) {
        this.m_tunnelManager = tunnelVpnManager;
        this.m_startingTunnelManager = false;
    }
}
