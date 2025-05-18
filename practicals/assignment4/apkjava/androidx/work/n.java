package androidx.work;

import android.util.Log;

/* compiled from: Logger.java */
/* loaded from: classes.dex */
public abstract class n {
    private static n a = null;

    /* renamed from: b, reason: collision with root package name */
    private static final int f2655b = 20;

    /* compiled from: Logger.java */
    /* loaded from: classes.dex */
    public static class a extends n {

        /* renamed from: c, reason: collision with root package name */
        private int f2656c;

        public a(int i2) {
            super(i2);
            this.f2656c = i2;
        }

        @Override // androidx.work.n
        public void a(String str, String str2, Throwable... thArr) {
            if (this.f2656c <= 3) {
                if (thArr != null && thArr.length >= 1) {
                    Log.d(str, str2, thArr[0]);
                } else {
                    Log.d(str, str2);
                }
            }
        }

        @Override // androidx.work.n
        public void b(String str, String str2, Throwable... thArr) {
            if (this.f2656c <= 6) {
                if (thArr != null && thArr.length >= 1) {
                    Log.e(str, str2, thArr[0]);
                } else {
                    Log.e(str, str2);
                }
            }
        }

        @Override // androidx.work.n
        public void d(String str, String str2, Throwable... thArr) {
            if (this.f2656c <= 4) {
                if (thArr != null && thArr.length >= 1) {
                    Log.i(str, str2, thArr[0]);
                } else {
                    Log.i(str, str2);
                }
            }
        }

        @Override // androidx.work.n
        public void g(String str, String str2, Throwable... thArr) {
            if (this.f2656c <= 2) {
                if (thArr != null && thArr.length >= 1) {
                    Log.v(str, str2, thArr[0]);
                } else {
                    Log.v(str, str2);
                }
            }
        }

        @Override // androidx.work.n
        public void h(String str, String str2, Throwable... thArr) {
            if (this.f2656c <= 5) {
                if (thArr != null && thArr.length >= 1) {
                    Log.w(str, str2, thArr[0]);
                } else {
                    Log.w(str, str2);
                }
            }
        }
    }

    public n(int i2) {
    }

    public static synchronized n c() {
        n nVar;
        synchronized (n.class) {
            if (a == null) {
                a = new a(3);
            }
            nVar = a;
        }
        return nVar;
    }

    public static synchronized void e(n nVar) {
        synchronized (n.class) {
            a = nVar;
        }
    }

    public static String f(String str) {
        int length = str.length();
        StringBuilder sb = new StringBuilder(23);
        sb.append("WM-");
        int i2 = f2655b;
        if (length >= i2) {
            sb.append(str.substring(0, i2));
        } else {
            sb.append(str);
        }
        return sb.toString();
    }

    public abstract void a(String str, String str2, Throwable... thArr);

    public abstract void b(String str, String str2, Throwable... thArr);

    public abstract void d(String str, String str2, Throwable... thArr);

    public abstract void g(String str, String str2, Throwable... thArr);

    public abstract void h(String str, String str2, Throwable... thArr);
}
