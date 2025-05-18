package com.google.android.gms.internal.ads;

import android.os.SystemClock;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* loaded from: classes2.dex */
public class zzag {
    private static String a = "Volley";

    /* renamed from: b, reason: collision with root package name */
    public static boolean f13871b = Log.isLoggable("Volley", 2);

    /* renamed from: c, reason: collision with root package name */
    private static final String f13872c = zzag.class.getName();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class a {
        public static final boolean a = zzag.f13871b;

        /* renamed from: b, reason: collision with root package name */
        private final List<y> f13873b = new ArrayList();

        /* renamed from: c, reason: collision with root package name */
        private boolean f13874c = false;

        public final synchronized void a(String str, long j2) {
            if (!this.f13874c) {
                this.f13873b.add(new y(str, j2, SystemClock.elapsedRealtime()));
            } else {
                throw new IllegalStateException("Marker added to finished log");
            }
        }

        public final synchronized void b(String str) {
            long j2;
            this.f13874c = true;
            if (this.f13873b.size() == 0) {
                j2 = 0;
            } else {
                long j3 = this.f13873b.get(0).f13590c;
                List<y> list = this.f13873b;
                j2 = list.get(list.size() - 1).f13590c - j3;
            }
            if (j2 <= 0) {
                return;
            }
            long j4 = this.f13873b.get(0).f13590c;
            zzag.a("(%-4d ms) %s", Long.valueOf(j2), str);
            for (y yVar : this.f13873b) {
                long j5 = yVar.f13590c;
                zzag.a("(+%-4d) [%2d] %s", Long.valueOf(j5 - j4), Long.valueOf(yVar.f13589b), yVar.a);
                j4 = j5;
            }
        }

        protected final void finalize() throws Throwable {
            if (this.f13874c) {
                return;
            }
            b("Request on the loose");
            zzag.b("Marker log finalized without finish() - uncaught exit point for request", new Object[0]);
        }
    }

    public static void a(String str, Object... objArr) {
        Log.d(a, d(str, objArr));
    }

    public static void b(String str, Object... objArr) {
        Log.e(a, d(str, objArr));
    }

    public static void c(String str, Object... objArr) {
        if (f13871b) {
            Log.v(a, d(str, objArr));
        }
    }

    private static String d(String str, Object... objArr) {
        String str2;
        if (objArr != null) {
            str = String.format(Locale.US, str, objArr);
        }
        StackTraceElement[] stackTrace = new Throwable().fillInStackTrace().getStackTrace();
        int i2 = 2;
        while (true) {
            if (i2 >= stackTrace.length) {
                str2 = "<unknown>";
                break;
            }
            if (!stackTrace[i2].getClassName().equals(f13872c)) {
                String className = stackTrace[i2].getClassName();
                String substring = className.substring(className.lastIndexOf(46) + 1);
                String substring2 = substring.substring(substring.lastIndexOf(36) + 1);
                String methodName = stackTrace[i2].getMethodName();
                StringBuilder sb = new StringBuilder(String.valueOf(substring2).length() + 1 + String.valueOf(methodName).length());
                sb.append(substring2);
                sb.append(".");
                sb.append(methodName);
                str2 = sb.toString();
                break;
            }
            i2++;
        }
        return String.format(Locale.US, "[%d] %s: %s", Long.valueOf(Thread.currentThread().getId()), str2, str);
    }

    public static void e(Throwable th, String str, Object... objArr) {
        Log.e(a, d(str, objArr), th);
    }
}
