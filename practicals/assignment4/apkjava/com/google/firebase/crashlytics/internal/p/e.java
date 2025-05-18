package com.google.firebase.crashlytics.internal.p;

import com.google.firebase.crashlytics.internal.p.f0;
import okhttp3.HttpUrl;

/* compiled from: AutoValue_CrashlyticsReport_CustomAttribute.java */
/* loaded from: classes2.dex */
final class e extends f0.c {
    private final String a;

    /* renamed from: b, reason: collision with root package name */
    private final String f19356b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AutoValue_CrashlyticsReport_CustomAttribute.java */
    /* loaded from: classes2.dex */
    public static final class b extends f0.c.a {
        private String a;

        /* renamed from: b, reason: collision with root package name */
        private String f19357b;

        @Override // com.google.firebase.crashlytics.h.p.f0.c.a
        public f0.c a() {
            String str = this.a;
            String str2 = HttpUrl.FRAGMENT_ENCODE_SET;
            if (str == null) {
                str2 = HttpUrl.FRAGMENT_ENCODE_SET + " key";
            }
            if (this.f19357b == null) {
                str2 = str2 + " value";
            }
            if (str2.isEmpty()) {
                return new e(this.a, this.f19357b);
            }
            throw new IllegalStateException("Missing required properties:" + str2);
        }

        @Override // com.google.firebase.crashlytics.h.p.f0.c.a
        public f0.c.a b(String str) {
            if (str != null) {
                this.a = str;
                return this;
            }
            throw new NullPointerException("Null key");
        }

        @Override // com.google.firebase.crashlytics.h.p.f0.c.a
        public f0.c.a c(String str) {
            if (str != null) {
                this.f19357b = str;
                return this;
            }
            throw new NullPointerException("Null value");
        }
    }

    @Override // com.google.firebase.crashlytics.h.p.f0.c
    public String b() {
        return this.a;
    }

    @Override // com.google.firebase.crashlytics.h.p.f0.c
    public String c() {
        return this.f19356b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof f0.c)) {
            return false;
        }
        f0.c cVar = (f0.c) obj;
        return this.a.equals(cVar.b()) && this.f19356b.equals(cVar.c());
    }

    public int hashCode() {
        return ((this.a.hashCode() ^ 1000003) * 1000003) ^ this.f19356b.hashCode();
    }

    public String toString() {
        return "CustomAttribute{key=" + this.a + ", value=" + this.f19356b + "}";
    }

    private e(String str, String str2) {
        this.a = str;
        this.f19356b = str2;
    }
}
