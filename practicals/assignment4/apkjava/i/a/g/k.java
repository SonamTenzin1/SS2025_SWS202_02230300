package i.a.g;

import i.a.b;
import i.a.g.h;
import i.a.g.i;
import i.a.g.n;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collection;
import okhttp3.HttpUrl;

/* compiled from: HostInfo.java */
/* loaded from: classes2.dex */
public class k implements i {

    /* renamed from: f, reason: collision with root package name */
    private static k.b.b f21796f = k.b.c.i(k.class.getName());

    /* renamed from: g, reason: collision with root package name */
    protected String f21797g;

    /* renamed from: h, reason: collision with root package name */
    protected InetAddress f21798h;

    /* renamed from: i, reason: collision with root package name */
    protected NetworkInterface f21799i;

    /* renamed from: j, reason: collision with root package name */
    private final b f21800j;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: HostInfo.java */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[i.a.g.s.e.values().length];
            a = iArr;
            try {
                iArr[i.a.g.s.e.TYPE_A.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[i.a.g.s.e.TYPE_A6.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[i.a.g.s.e.TYPE_AAAA.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: HostInfo.java */
    /* loaded from: classes2.dex */
    public static final class b extends i.b {
        public b(l lVar) {
            q(lVar);
        }
    }

    private k(InetAddress inetAddress, String str, l lVar) {
        this.f21800j = new b(lVar);
        this.f21798h = inetAddress;
        this.f21797g = str;
        if (inetAddress != null) {
            try {
                this.f21799i = NetworkInterface.getByInetAddress(inetAddress);
            } catch (Exception e2) {
                f21796f.f("LocalHostInfo() exception ", e2);
            }
        }
    }

    public static k A(InetAddress inetAddress, l lVar, String str) {
        InetAddress localHost;
        String str2 = str != null ? str : HttpUrl.FRAGMENT_ENCODE_SET;
        if (inetAddress == null) {
            try {
                String property = System.getProperty("net.mdns.interface");
                if (property != null) {
                    localHost = InetAddress.getByName(property);
                } else {
                    localHost = InetAddress.getLocalHost();
                    if (localHost.isLoopbackAddress()) {
                        InetAddress[] a2 = b.a.a().a();
                        if (a2.length > 0) {
                            localHost = a2[0];
                        }
                    }
                }
                if (localHost.isLoopbackAddress()) {
                    f21796f.h("Could not find any address beside the loopback.");
                }
            } catch (IOException e2) {
                f21796f.f("Could not initialize the host network interface on " + inetAddress + "because of an error: " + e2.getMessage(), e2);
                localHost = z();
                if (str == null || str.length() <= 0) {
                    str = "computer";
                }
            }
        } else {
            localHost = inetAddress;
        }
        if (str2.length() == 0) {
            str2 = localHost.getHostName();
        }
        if (str2.contains("in-addr.arpa") || str2.equals(localHost.getHostAddress())) {
            if (str == null || str.length() <= 0) {
                str = localHost.getHostAddress();
            }
            str2 = str;
        }
        int indexOf = str2.indexOf(".local");
        if (indexOf > 0) {
            str2 = str2.substring(0, indexOf);
        }
        return new k(localHost, str2.replaceAll("[:%\\.]", "-") + ".local.", lVar);
    }

    private h.a g(boolean z, int i2) {
        if (o() instanceof Inet4Address) {
            return new h.c(q(), i.a.g.s.d.CLASS_IN, z, i2, o());
        }
        return null;
    }

    private h.e h(boolean z, int i2) {
        if (!(o() instanceof Inet4Address)) {
            return null;
        }
        return new h.e(o().getHostAddress() + ".in-addr.arpa.", i.a.g.s.d.CLASS_IN, z, i2, q());
    }

    private h.a i(boolean z, int i2) {
        if (o() instanceof Inet6Address) {
            return new h.d(q(), i.a.g.s.d.CLASS_IN, z, i2, o());
        }
        return null;
    }

    private h.e j(boolean z, int i2) {
        if (!(o() instanceof Inet6Address)) {
            return null;
        }
        return new h.e(o().getHostAddress() + ".ip6.arpa.", i.a.g.s.d.CLASS_IN, z, i2, q());
    }

    private static InetAddress z() {
        try {
            return InetAddress.getByName(null);
        } catch (UnknownHostException unused) {
            return null;
        }
    }

    public boolean B() {
        return this.f21800j.n();
    }

    public void C(i.a.g.t.a aVar) {
        this.f21800j.o(aVar);
    }

    public boolean D() {
        return this.f21800j.p();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean E(DatagramPacket datagramPacket) {
        InetAddress address;
        boolean z = false;
        if (o() == null || (address = datagramPacket.getAddress()) == null) {
            return false;
        }
        if ((o().isLinkLocalAddress() || o().isMCLinkLocal()) && !address.isLinkLocalAddress()) {
            z = true;
        }
        if (!address.isLoopbackAddress() || o().isLoopbackAddress()) {
            return z;
        }
        return true;
    }

    public boolean F(long j2) {
        return this.f21800j.t(j2);
    }

    public boolean G(long j2) {
        if (this.f21798h == null) {
            return true;
        }
        return this.f21800j.u(j2);
    }

    public Collection<h> a(i.a.g.s.d dVar, boolean z, int i2) {
        ArrayList arrayList = new ArrayList();
        h.a g2 = g(z, i2);
        if (g2 != null && g2.s(dVar)) {
            arrayList.add(g2);
        }
        h.a i3 = i(z, i2);
        if (i3 != null && i3.s(dVar)) {
            arrayList.add(i3);
        }
        return arrayList;
    }

    public void b(i.a.g.t.a aVar, i.a.g.s.g gVar) {
        this.f21800j.a(aVar, gVar);
    }

    public boolean c() {
        return this.f21800j.b();
    }

    @Override // i.a.g.i
    public boolean d(i.a.g.t.a aVar) {
        return this.f21800j.d(aVar);
    }

    public boolean e() {
        return this.f21800j.c();
    }

    public boolean f(h.a aVar) {
        h.a k2 = k(aVar.f(), aVar.p(), 3600);
        return k2 != null && k2.M(aVar) && k2.U(aVar) && !k2.N(aVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public h.a k(i.a.g.s.e eVar, boolean z, int i2) {
        int i3 = a.a[eVar.ordinal()];
        if (i3 == 1) {
            return g(z, i2);
        }
        if (i3 == 2 || i3 == 3) {
            return i(z, i2);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public h.e l(i.a.g.s.e eVar, boolean z, int i2) {
        int i3 = a.a[eVar.ordinal()];
        if (i3 == 1) {
            return h(z, i2);
        }
        if (i3 == 2 || i3 == 3) {
            return j(z, i2);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Inet4Address m() {
        if (o() instanceof Inet4Address) {
            return (Inet4Address) this.f21798h;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Inet6Address n() {
        if (o() instanceof Inet6Address) {
            return (Inet6Address) this.f21798h;
        }
        return null;
    }

    public InetAddress o() {
        return this.f21798h;
    }

    public NetworkInterface p() {
        return this.f21799i;
    }

    public String q() {
        return this.f21797g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized String r() {
        String a2;
        a2 = n.c.a().a(o(), this.f21797g, n.d.HOST);
        this.f21797g = a2;
        return a2;
    }

    public boolean s() {
        return this.f21800j.f();
    }

    public boolean t(i.a.g.t.a aVar, i.a.g.s.g gVar) {
        return this.f21800j.h(aVar, gVar);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(1024);
        sb.append("local host info[");
        sb.append(q() != null ? q() : "no name");
        sb.append(", ");
        sb.append(p() != null ? p().getDisplayName() : "???");
        sb.append(":");
        sb.append(o() != null ? o().getHostAddress() : "no address");
        sb.append(", ");
        sb.append(this.f21800j);
        sb.append("]");
        return sb.toString();
    }

    public boolean u() {
        return this.f21800j.i();
    }

    public boolean v() {
        return this.f21800j.j();
    }

    public boolean w() {
        return this.f21800j.k();
    }

    public boolean x() {
        return this.f21800j.l();
    }

    public boolean y() {
        return this.f21800j.m();
    }
}
