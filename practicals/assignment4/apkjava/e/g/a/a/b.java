package e.g.a.a;

/* compiled from: Preconditions.java */
/* loaded from: classes2.dex */
public final class b {
    public static <T> T a(T t, String str) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(str);
    }
}
