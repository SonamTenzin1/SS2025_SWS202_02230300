package com.google.android.gms.internal.measurement;

import java.io.PrintStream;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.2.0 */
/* loaded from: classes2.dex */
public final class zzdg {
    private static final d1 a;

    /* renamed from: b, reason: collision with root package name */
    private static final int f17365b;

    /* compiled from: com.google.android.gms:play-services-measurement-base@@17.2.0 */
    /* loaded from: classes2.dex */
    static final class a extends d1 {
        a() {
        }

        @Override // com.google.android.gms.internal.measurement.d1
        public final void a(Throwable th, Throwable th2) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0064  */
    static {
        Integer num;
        d1 aVar;
        try {
            num = a();
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
                f17365b = num != null ? num.intValue() : 1;
            }
            if (num.intValue() >= 19) {
                aVar = new h1();
                a = aVar;
                f17365b = num != null ? num.intValue() : 1;
            }
        }
        if (!Boolean.getBoolean("com.google.devtools.build.android.desugar.runtime.twr_disable_mimic")) {
            aVar = new g1();
        } else {
            aVar = new a();
        }
        a = aVar;
        f17365b = num != null ? num.intValue() : 1;
    }

    private static Integer a() {
        try {
            return (Integer) Class.forName("android.os.Build$VERSION").getField("SDK_INT").get(null);
        } catch (Exception e2) {
            System.err.println("Failed to retrieve value from android.os.Build$VERSION.SDK_INT due to the following exception.");
            e2.printStackTrace(System.err);
            return null;
        }
    }

    public static void b(Throwable th, Throwable th2) {
        a.a(th, th2);
    }
}
