package androidx.datastore.preferences.protobuf;

/* compiled from: Android.java */
/* loaded from: classes.dex */
final class d {
    private static final Class<?> a = a("libcore.io.Memory");

    /* renamed from: b, reason: collision with root package name */
    private static final boolean f1276b;

    static {
        f1276b = a("org.robolectric.Robolectric") != null;
    }

    private static <T> Class<T> a(String str) {
        try {
            return (Class<T>) Class.forName(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Class<?> b() {
        return a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean c() {
        return (a == null || f1276b) ? false : true;
    }
}
