package i.a;

import i.a.g.l;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.util.Collection;
import java.util.Properties;

/* compiled from: JmDNS.java */
/* loaded from: classes2.dex */
public abstract class a implements Closeable {

    /* renamed from: f, reason: collision with root package name */
    public static String f21743f;

    /* compiled from: JmDNS.java */
    /* renamed from: i.a.a$a, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0302a {
        void a(a aVar, Collection<d> collection);
    }

    static {
        try {
            InputStream resourceAsStream = a.class.getClassLoader().getResourceAsStream("version.properties");
            try {
                Properties properties = new Properties();
                properties.load(resourceAsStream);
                f21743f = properties.getProperty("jmdns.version");
                resourceAsStream.close();
            } catch (Throwable th) {
                resourceAsStream.close();
                throw th;
            }
        } catch (Exception unused) {
            f21743f = "VERSION MISSING";
        }
    }

    public static a A(InetAddress inetAddress, String str) throws IOException {
        return new l(inetAddress, str);
    }

    public abstract void B();

    public abstract void z(String str, e eVar);
}
