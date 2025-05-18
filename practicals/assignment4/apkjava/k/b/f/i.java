package k.b.f;

/* compiled from: Util.java */
/* loaded from: classes3.dex */
public final class i {
    public static final void a(String str) {
        System.err.println("SLF4J: " + str);
    }

    public static final void b(String str, Throwable th) {
        System.err.println(str);
        System.err.println("Reported exception:");
        th.printStackTrace();
    }

    public static boolean c(String str) {
        String d2 = d(str);
        if (d2 == null) {
            return false;
        }
        return d2.equalsIgnoreCase("true");
    }

    public static String d(String str) {
        if (str != null) {
            try {
                return System.getProperty(str);
            } catch (SecurityException unused) {
                return null;
            }
        }
        throw new IllegalArgumentException("null input");
    }
}
