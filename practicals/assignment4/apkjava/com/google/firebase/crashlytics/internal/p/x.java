package com.google.firebase.crashlytics.internal.p;

import com.google.firebase.crashlytics.internal.p.f0;
import okhttp3.HttpUrl;

/* compiled from: AutoValue_CrashlyticsReport_Session_Event_RolloutAssignment_RolloutVariant.java */
/* loaded from: classes2.dex */
final class x extends f0.e.d.AbstractC0226e.b {
    private final String a;

    /* renamed from: b, reason: collision with root package name */
    private final String f19494b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AutoValue_CrashlyticsReport_Session_Event_RolloutAssignment_RolloutVariant.java */
    /* loaded from: classes2.dex */
    public static final class b extends f0.e.d.AbstractC0226e.b.a {
        private String a;

        /* renamed from: b, reason: collision with root package name */
        private String f19495b;

        @Override // com.google.firebase.crashlytics.h.p.f0.e.d.AbstractC0226e.b.a
        public f0.e.d.AbstractC0226e.b a() {
            String str = this.a;
            String str2 = HttpUrl.FRAGMENT_ENCODE_SET;
            if (str == null) {
                str2 = HttpUrl.FRAGMENT_ENCODE_SET + " rolloutId";
            }
            if (this.f19495b == null) {
                str2 = str2 + " variantId";
            }
            if (str2.isEmpty()) {
                return new x(this.a, this.f19495b);
            }
            throw new IllegalStateException("Missing required properties:" + str2);
        }

        @Override // com.google.firebase.crashlytics.h.p.f0.e.d.AbstractC0226e.b.a
        public f0.e.d.AbstractC0226e.b.a b(String str) {
            if (str != null) {
                this.a = str;
                return this;
            }
            throw new NullPointerException("Null rolloutId");
        }

        @Override // com.google.firebase.crashlytics.h.p.f0.e.d.AbstractC0226e.b.a
        public f0.e.d.AbstractC0226e.b.a c(String str) {
            if (str != null) {
                this.f19495b = str;
                return this;
            }
            throw new NullPointerException("Null variantId");
        }
    }

    @Override // com.google.firebase.crashlytics.h.p.f0.e.d.AbstractC0226e.b
    public String b() {
        return this.a;
    }

    @Override // com.google.firebase.crashlytics.h.p.f0.e.d.AbstractC0226e.b
    public String c() {
        return this.f19494b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof f0.e.d.AbstractC0226e.b)) {
            return false;
        }
        f0.e.d.AbstractC0226e.b bVar = (f0.e.d.AbstractC0226e.b) obj;
        return this.a.equals(bVar.b()) && this.f19494b.equals(bVar.c());
    }

    public int hashCode() {
        return ((this.a.hashCode() ^ 1000003) * 1000003) ^ this.f19494b.hashCode();
    }

    public String toString() {
        return "RolloutVariant{rolloutId=" + this.a + ", variantId=" + this.f19494b + "}";
    }

    private x(String str, String str2) {
        this.a = str;
        this.f19494b = str2;
    }
}
