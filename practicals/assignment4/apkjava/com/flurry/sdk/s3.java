package com.flurry.sdk;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import okhttp3.HttpUrl;

/* loaded from: classes2.dex */
public final class s3 extends r6 {

    /* renamed from: e, reason: collision with root package name */
    private static final AtomicInteger f11038e = new AtomicInteger(0);

    /* loaded from: classes2.dex */
    public enum a {
        RECOVERABLE_ERROR(1),
        CAUGHT_EXCEPTION(2),
        UNRECOVERABLE_CRASH(3);


        /* renamed from: j, reason: collision with root package name */
        public int f11043j;

        a(int i2) {
            this.f11043j = i2;
        }
    }

    /* loaded from: classes2.dex */
    public enum b {
        NO_LOG(0),
        ANDROID_LOG_ATTACHED(2),
        NATIVE_CRASH_ATTACHED(3);


        /* renamed from: j, reason: collision with root package name */
        public int f11048j;

        b(int i2) {
            this.f11048j = i2;
        }
    }

    private s3(t6 t6Var) {
        super(t6Var);
    }

    public static e.d.a.d h(com.flurry.sdk.b bVar) {
        int i2;
        int i3;
        if (bVar == null) {
            d1.n("StreamingErrorFrame", "Error is null, do not send the frame.");
            return e.d.a.d.kFlurryEventFailed;
        }
        p7 p7Var = p7.UNCAUGHT_EXCEPTION_ID;
        boolean equals = p7Var.f11009i.equals(bVar.a);
        List<m7> list = equals ? bVar.f10634h : null;
        int incrementAndGet = f11038e.incrementAndGet();
        String str = bVar.a;
        long j2 = bVar.f10628b;
        String str2 = bVar.f10629c;
        String str3 = bVar.f10630d;
        String j3 = j(bVar.f10631e);
        String str4 = bVar.a;
        if (bVar.f10631e != null) {
            if (p7Var.f11009i.equals(str4)) {
                i2 = a.UNRECOVERABLE_CRASH.f11043j;
            } else {
                i2 = a.CAUGHT_EXCEPTION.f11043j;
            }
        } else if (p7.NATIVE_CRASH.f11009i.equals(str4)) {
            i2 = a.UNRECOVERABLE_CRASH.f11043j;
        } else {
            i2 = a.RECOVERABLE_ERROR.f11043j;
        }
        int i4 = i2;
        if (bVar.f10631e == null) {
            i3 = b.NO_LOG.f11048j;
        } else {
            i3 = b.ANDROID_LOG_ATTACHED.f11048j;
        }
        s3 s3Var = new s3(new t3(incrementAndGet, str, j2, str2, str3, j3, i4, i3, bVar.f10632f, bVar.f10633g, n7.c(), list, HttpUrl.FRAGMENT_ENCODE_SET, HttpUrl.FRAGMENT_ENCODE_SET));
        if (equals) {
            m2.a().f10913b.a.c(s3Var);
        } else {
            m2.a().b(s3Var);
        }
        return e.d.a.d.kFlurryEventRecorded;
    }

    public static s3 i(t3 t3Var) {
        return new s3(t3Var);
    }

    private static String j(Throwable th) {
        if (th == null) {
            return HttpUrl.FRAGMENT_ENCODE_SET;
        }
        StringBuilder sb = new StringBuilder();
        for (StackTraceElement stackTraceElement : th.getStackTrace()) {
            sb.append(stackTraceElement);
            sb.append(n2.a);
        }
        if (th.getCause() != null) {
            sb.append(n2.a);
            sb.append("Caused by: ");
            for (StackTraceElement stackTraceElement2 : th.getCause().getStackTrace()) {
                sb.append(stackTraceElement2);
                sb.append(n2.a);
            }
        }
        return sb.toString();
    }

    public static AtomicInteger k() {
        return f11038e;
    }

    @Override // com.flurry.sdk.u6
    public final s6 a() {
        return s6.ANALYTICS_ERROR;
    }
}
