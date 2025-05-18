package com.google.firebase.crashlytics.internal.p;

import com.google.firebase.crashlytics.internal.p.f0;
import okhttp3.HttpUrl;

/* compiled from: AutoValue_CrashlyticsReport_Session_User.java */
/* loaded from: classes2.dex */
final class a0 extends f0.e.f {
    private final String a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AutoValue_CrashlyticsReport_Session_User.java */
    /* loaded from: classes2.dex */
    public static final class b extends f0.e.f.a {
        private String a;

        @Override // com.google.firebase.crashlytics.h.p.f0.e.f.a
        public f0.e.f a() {
            String str = this.a;
            String str2 = HttpUrl.FRAGMENT_ENCODE_SET;
            if (str == null) {
                str2 = HttpUrl.FRAGMENT_ENCODE_SET + " identifier";
            }
            if (str2.isEmpty()) {
                return new a0(this.a);
            }
            throw new IllegalStateException("Missing required properties:" + str2);
        }

        @Override // com.google.firebase.crashlytics.h.p.f0.e.f.a
        public f0.e.f.a b(String str) {
            if (str != null) {
                this.a = str;
                return this;
            }
            throw new NullPointerException("Null identifier");
        }
    }

    @Override // com.google.firebase.crashlytics.h.p.f0.e.f
    public String b() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof f0.e.f) {
            return this.a.equals(((f0.e.f) obj).b());
        }
        return false;
    }

    public int hashCode() {
        return this.a.hashCode() ^ 1000003;
    }

    public String toString() {
        return "User{identifier=" + this.a + "}";
    }

    private a0(String str) {
        this.a = str;
    }
}
