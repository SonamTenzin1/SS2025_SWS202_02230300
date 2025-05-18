package com.google.android.gms.internal.ads;

import java.io.PrintStream;
import java.io.PrintWriter;

/* loaded from: classes2.dex */
public final class zzdmb {
    private static final tt a;

    /* renamed from: b, reason: collision with root package name */
    private static final int f15979b;

    /* loaded from: classes2.dex */
    static final class a extends tt {
        a() {
        }

        @Override // com.google.android.gms.internal.ads.tt
        public final void a(Throwable th, PrintWriter printWriter) {
            th.printStackTrace(printWriter);
        }

        @Override // com.google.android.gms.internal.ads.tt
        public final void b(Throwable th, Throwable th2) {
        }

        @Override // com.google.android.gms.internal.ads.tt
        public final void c(Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0064  */
    static {
        Integer num;
        tt aVar;
        try {
            num = c();
        } catch (Throwable th) {
            th = th;
            num = null;
        }
        if (num != null) {
            try {
            } catch (Throwable th2) {
                th = th2;
                PrintStream printStream = System.err;
                String name = a.class.getName();
                StringBuilder sb = new StringBuilder(name.length() + 133);
                sb.append("An error has occurred when initializing the try-with-resources desuguring strategy. The default strategy ");
                sb.append(name);
                sb.append("will be used. The error is: ");
                printStream.println(sb.toString());
                th.printStackTrace(System.err);
                aVar = new a();
                a = aVar;
                f15979b = num != null ? num.intValue() : 1;
            }
            if (num.intValue() >= 19) {
                aVar = new xt();
                a = aVar;
                f15979b = num != null ? num.intValue() : 1;
            }
        }
        if (!Boolean.getBoolean("com.google.devtools.build.android.desugar.runtime.twr_disable_mimic")) {
            aVar = new wt();
        } else {
            aVar = new a();
        }
        a = aVar;
        f15979b = num != null ? num.intValue() : 1;
    }

    public static void a(Throwable th, PrintWriter printWriter) {
        a.a(th, printWriter);
    }

    public static void b(Throwable th, Throwable th2) {
        a.b(th, th2);
    }

    private static Integer c() {
        try {
            return (Integer) Class.forName("android.os.Build$VERSION").getField("SDK_INT").get(null);
        } catch (Exception e2) {
            System.err.println("Failed to retrieve value from android.os.Build$VERSION.SDK_INT due to the following exception.");
            e2.printStackTrace(System.err);
            return null;
        }
    }

    public static void d(Throwable th) {
        a.c(th);
    }
}
