package com.google.firebase.crashlytics.internal.p;

import com.google.firebase.crashlytics.internal.p.f0;
import okhttp3.HttpUrl;

/* compiled from: AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Thread_Frame.java */
/* loaded from: classes2.dex */
final class s extends f0.e.d.a.b.AbstractC0220e.AbstractC0222b {
    private final long a;

    /* renamed from: b, reason: collision with root package name */
    private final String f19464b;

    /* renamed from: c, reason: collision with root package name */
    private final String f19465c;

    /* renamed from: d, reason: collision with root package name */
    private final long f19466d;

    /* renamed from: e, reason: collision with root package name */
    private final int f19467e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Thread_Frame.java */
    /* loaded from: classes2.dex */
    public static final class b extends f0.e.d.a.b.AbstractC0220e.AbstractC0222b.AbstractC0223a {
        private Long a;

        /* renamed from: b, reason: collision with root package name */
        private String f19468b;

        /* renamed from: c, reason: collision with root package name */
        private String f19469c;

        /* renamed from: d, reason: collision with root package name */
        private Long f19470d;

        /* renamed from: e, reason: collision with root package name */
        private Integer f19471e;

        @Override // com.google.firebase.crashlytics.h.p.f0.e.d.a.b.AbstractC0220e.AbstractC0222b.AbstractC0223a
        public f0.e.d.a.b.AbstractC0220e.AbstractC0222b a() {
            Long l = this.a;
            String str = HttpUrl.FRAGMENT_ENCODE_SET;
            if (l == null) {
                str = HttpUrl.FRAGMENT_ENCODE_SET + " pc";
            }
            if (this.f19468b == null) {
                str = str + " symbol";
            }
            if (this.f19470d == null) {
                str = str + " offset";
            }
            if (this.f19471e == null) {
                str = str + " importance";
            }
            if (str.isEmpty()) {
                return new s(this.a.longValue(), this.f19468b, this.f19469c, this.f19470d.longValue(), this.f19471e.intValue());
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // com.google.firebase.crashlytics.h.p.f0.e.d.a.b.AbstractC0220e.AbstractC0222b.AbstractC0223a
        public f0.e.d.a.b.AbstractC0220e.AbstractC0222b.AbstractC0223a b(String str) {
            this.f19469c = str;
            return this;
        }

        @Override // com.google.firebase.crashlytics.h.p.f0.e.d.a.b.AbstractC0220e.AbstractC0222b.AbstractC0223a
        public f0.e.d.a.b.AbstractC0220e.AbstractC0222b.AbstractC0223a c(int i2) {
            this.f19471e = Integer.valueOf(i2);
            return this;
        }

        @Override // com.google.firebase.crashlytics.h.p.f0.e.d.a.b.AbstractC0220e.AbstractC0222b.AbstractC0223a
        public f0.e.d.a.b.AbstractC0220e.AbstractC0222b.AbstractC0223a d(long j2) {
            this.f19470d = Long.valueOf(j2);
            return this;
        }

        @Override // com.google.firebase.crashlytics.h.p.f0.e.d.a.b.AbstractC0220e.AbstractC0222b.AbstractC0223a
        public f0.e.d.a.b.AbstractC0220e.AbstractC0222b.AbstractC0223a e(long j2) {
            this.a = Long.valueOf(j2);
            return this;
        }

        @Override // com.google.firebase.crashlytics.h.p.f0.e.d.a.b.AbstractC0220e.AbstractC0222b.AbstractC0223a
        public f0.e.d.a.b.AbstractC0220e.AbstractC0222b.AbstractC0223a f(String str) {
            if (str != null) {
                this.f19468b = str;
                return this;
            }
            throw new NullPointerException("Null symbol");
        }
    }

    @Override // com.google.firebase.crashlytics.h.p.f0.e.d.a.b.AbstractC0220e.AbstractC0222b
    public String b() {
        return this.f19465c;
    }

    @Override // com.google.firebase.crashlytics.h.p.f0.e.d.a.b.AbstractC0220e.AbstractC0222b
    public int c() {
        return this.f19467e;
    }

    @Override // com.google.firebase.crashlytics.h.p.f0.e.d.a.b.AbstractC0220e.AbstractC0222b
    public long d() {
        return this.f19466d;
    }

    @Override // com.google.firebase.crashlytics.h.p.f0.e.d.a.b.AbstractC0220e.AbstractC0222b
    public long e() {
        return this.a;
    }

    public boolean equals(Object obj) {
        String str;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof f0.e.d.a.b.AbstractC0220e.AbstractC0222b)) {
            return false;
        }
        f0.e.d.a.b.AbstractC0220e.AbstractC0222b abstractC0222b = (f0.e.d.a.b.AbstractC0220e.AbstractC0222b) obj;
        return this.a == abstractC0222b.e() && this.f19464b.equals(abstractC0222b.f()) && ((str = this.f19465c) != null ? str.equals(abstractC0222b.b()) : abstractC0222b.b() == null) && this.f19466d == abstractC0222b.d() && this.f19467e == abstractC0222b.c();
    }

    @Override // com.google.firebase.crashlytics.h.p.f0.e.d.a.b.AbstractC0220e.AbstractC0222b
    public String f() {
        return this.f19464b;
    }

    public int hashCode() {
        long j2 = this.a;
        int hashCode = (((((int) (j2 ^ (j2 >>> 32))) ^ 1000003) * 1000003) ^ this.f19464b.hashCode()) * 1000003;
        String str = this.f19465c;
        int hashCode2 = (hashCode ^ (str == null ? 0 : str.hashCode())) * 1000003;
        long j3 = this.f19466d;
        return this.f19467e ^ ((hashCode2 ^ ((int) (j3 ^ (j3 >>> 32)))) * 1000003);
    }

    public String toString() {
        return "Frame{pc=" + this.a + ", symbol=" + this.f19464b + ", file=" + this.f19465c + ", offset=" + this.f19466d + ", importance=" + this.f19467e + "}";
    }

    private s(long j2, String str, String str2, long j3, int i2) {
        this.a = j2;
        this.f19464b = str;
        this.f19465c = str2;
        this.f19466d = j3;
        this.f19467e = i2;
    }
}
