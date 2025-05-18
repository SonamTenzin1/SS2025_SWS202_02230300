package com.google.firebase.crashlytics.internal.p;

import com.google.firebase.crashlytics.internal.p.f0;
import okhttp3.HttpUrl;

/* compiled from: AutoValue_CrashlyticsReport_Session_Device.java */
/* loaded from: classes2.dex */
final class k extends f0.e.c {
    private final int a;

    /* renamed from: b, reason: collision with root package name */
    private final String f19396b;

    /* renamed from: c, reason: collision with root package name */
    private final int f19397c;

    /* renamed from: d, reason: collision with root package name */
    private final long f19398d;

    /* renamed from: e, reason: collision with root package name */
    private final long f19399e;

    /* renamed from: f, reason: collision with root package name */
    private final boolean f19400f;

    /* renamed from: g, reason: collision with root package name */
    private final int f19401g;

    /* renamed from: h, reason: collision with root package name */
    private final String f19402h;

    /* renamed from: i, reason: collision with root package name */
    private final String f19403i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AutoValue_CrashlyticsReport_Session_Device.java */
    /* loaded from: classes2.dex */
    public static final class b extends f0.e.c.a {
        private Integer a;

        /* renamed from: b, reason: collision with root package name */
        private String f19404b;

        /* renamed from: c, reason: collision with root package name */
        private Integer f19405c;

        /* renamed from: d, reason: collision with root package name */
        private Long f19406d;

        /* renamed from: e, reason: collision with root package name */
        private Long f19407e;

        /* renamed from: f, reason: collision with root package name */
        private Boolean f19408f;

        /* renamed from: g, reason: collision with root package name */
        private Integer f19409g;

        /* renamed from: h, reason: collision with root package name */
        private String f19410h;

        /* renamed from: i, reason: collision with root package name */
        private String f19411i;

        @Override // com.google.firebase.crashlytics.h.p.f0.e.c.a
        public f0.e.c a() {
            Integer num = this.a;
            String str = HttpUrl.FRAGMENT_ENCODE_SET;
            if (num == null) {
                str = HttpUrl.FRAGMENT_ENCODE_SET + " arch";
            }
            if (this.f19404b == null) {
                str = str + " model";
            }
            if (this.f19405c == null) {
                str = str + " cores";
            }
            if (this.f19406d == null) {
                str = str + " ram";
            }
            if (this.f19407e == null) {
                str = str + " diskSpace";
            }
            if (this.f19408f == null) {
                str = str + " simulator";
            }
            if (this.f19409g == null) {
                str = str + " state";
            }
            if (this.f19410h == null) {
                str = str + " manufacturer";
            }
            if (this.f19411i == null) {
                str = str + " modelClass";
            }
            if (str.isEmpty()) {
                return new k(this.a.intValue(), this.f19404b, this.f19405c.intValue(), this.f19406d.longValue(), this.f19407e.longValue(), this.f19408f.booleanValue(), this.f19409g.intValue(), this.f19410h, this.f19411i);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // com.google.firebase.crashlytics.h.p.f0.e.c.a
        public f0.e.c.a b(int i2) {
            this.a = Integer.valueOf(i2);
            return this;
        }

        @Override // com.google.firebase.crashlytics.h.p.f0.e.c.a
        public f0.e.c.a c(int i2) {
            this.f19405c = Integer.valueOf(i2);
            return this;
        }

        @Override // com.google.firebase.crashlytics.h.p.f0.e.c.a
        public f0.e.c.a d(long j2) {
            this.f19407e = Long.valueOf(j2);
            return this;
        }

        @Override // com.google.firebase.crashlytics.h.p.f0.e.c.a
        public f0.e.c.a e(String str) {
            if (str != null) {
                this.f19410h = str;
                return this;
            }
            throw new NullPointerException("Null manufacturer");
        }

        @Override // com.google.firebase.crashlytics.h.p.f0.e.c.a
        public f0.e.c.a f(String str) {
            if (str != null) {
                this.f19404b = str;
                return this;
            }
            throw new NullPointerException("Null model");
        }

        @Override // com.google.firebase.crashlytics.h.p.f0.e.c.a
        public f0.e.c.a g(String str) {
            if (str != null) {
                this.f19411i = str;
                return this;
            }
            throw new NullPointerException("Null modelClass");
        }

        @Override // com.google.firebase.crashlytics.h.p.f0.e.c.a
        public f0.e.c.a h(long j2) {
            this.f19406d = Long.valueOf(j2);
            return this;
        }

        @Override // com.google.firebase.crashlytics.h.p.f0.e.c.a
        public f0.e.c.a i(boolean z) {
            this.f19408f = Boolean.valueOf(z);
            return this;
        }

        @Override // com.google.firebase.crashlytics.h.p.f0.e.c.a
        public f0.e.c.a j(int i2) {
            this.f19409g = Integer.valueOf(i2);
            return this;
        }
    }

    @Override // com.google.firebase.crashlytics.h.p.f0.e.c
    public int b() {
        return this.a;
    }

    @Override // com.google.firebase.crashlytics.h.p.f0.e.c
    public int c() {
        return this.f19397c;
    }

    @Override // com.google.firebase.crashlytics.h.p.f0.e.c
    public long d() {
        return this.f19399e;
    }

    @Override // com.google.firebase.crashlytics.h.p.f0.e.c
    public String e() {
        return this.f19402h;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof f0.e.c)) {
            return false;
        }
        f0.e.c cVar = (f0.e.c) obj;
        return this.a == cVar.b() && this.f19396b.equals(cVar.f()) && this.f19397c == cVar.c() && this.f19398d == cVar.h() && this.f19399e == cVar.d() && this.f19400f == cVar.j() && this.f19401g == cVar.i() && this.f19402h.equals(cVar.e()) && this.f19403i.equals(cVar.g());
    }

    @Override // com.google.firebase.crashlytics.h.p.f0.e.c
    public String f() {
        return this.f19396b;
    }

    @Override // com.google.firebase.crashlytics.h.p.f0.e.c
    public String g() {
        return this.f19403i;
    }

    @Override // com.google.firebase.crashlytics.h.p.f0.e.c
    public long h() {
        return this.f19398d;
    }

    public int hashCode() {
        int hashCode = (((((this.a ^ 1000003) * 1000003) ^ this.f19396b.hashCode()) * 1000003) ^ this.f19397c) * 1000003;
        long j2 = this.f19398d;
        int i2 = (hashCode ^ ((int) (j2 ^ (j2 >>> 32)))) * 1000003;
        long j3 = this.f19399e;
        return ((((((((i2 ^ ((int) (j3 ^ (j3 >>> 32)))) * 1000003) ^ (this.f19400f ? 1231 : 1237)) * 1000003) ^ this.f19401g) * 1000003) ^ this.f19402h.hashCode()) * 1000003) ^ this.f19403i.hashCode();
    }

    @Override // com.google.firebase.crashlytics.h.p.f0.e.c
    public int i() {
        return this.f19401g;
    }

    @Override // com.google.firebase.crashlytics.h.p.f0.e.c
    public boolean j() {
        return this.f19400f;
    }

    public String toString() {
        return "Device{arch=" + this.a + ", model=" + this.f19396b + ", cores=" + this.f19397c + ", ram=" + this.f19398d + ", diskSpace=" + this.f19399e + ", simulator=" + this.f19400f + ", state=" + this.f19401g + ", manufacturer=" + this.f19402h + ", modelClass=" + this.f19403i + "}";
    }

    private k(int i2, String str, int i3, long j2, long j3, boolean z, int i4, String str2, String str3) {
        this.a = i2;
        this.f19396b = str;
        this.f19397c = i3;
        this.f19398d = j2;
        this.f19399e = j3;
        this.f19400f = z;
        this.f19401g = i4;
        this.f19402h = str2;
        this.f19403i = str3;
    }
}
