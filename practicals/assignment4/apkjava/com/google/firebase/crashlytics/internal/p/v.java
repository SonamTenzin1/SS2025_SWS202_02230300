package com.google.firebase.crashlytics.internal.p;

import com.google.firebase.crashlytics.internal.p.f0;
import okhttp3.HttpUrl;

/* compiled from: AutoValue_CrashlyticsReport_Session_Event_Log.java */
/* loaded from: classes2.dex */
final class v extends f0.e.d.AbstractC0225d {
    private final String a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AutoValue_CrashlyticsReport_Session_Event_Log.java */
    /* loaded from: classes2.dex */
    public static final class b extends f0.e.d.AbstractC0225d.a {
        private String a;

        @Override // com.google.firebase.crashlytics.h.p.f0.e.d.AbstractC0225d.a
        public f0.e.d.AbstractC0225d a() {
            String str = this.a;
            String str2 = HttpUrl.FRAGMENT_ENCODE_SET;
            if (str == null) {
                str2 = HttpUrl.FRAGMENT_ENCODE_SET + " content";
            }
            if (str2.isEmpty()) {
                return new v(this.a);
            }
            throw new IllegalStateException("Missing required properties:" + str2);
        }

        @Override // com.google.firebase.crashlytics.h.p.f0.e.d.AbstractC0225d.a
        public f0.e.d.AbstractC0225d.a b(String str) {
            if (str != null) {
                this.a = str;
                return this;
            }
            throw new NullPointerException("Null content");
        }
    }

    @Override // com.google.firebase.crashlytics.h.p.f0.e.d.AbstractC0225d
    public String b() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof f0.e.d.AbstractC0225d) {
            return this.a.equals(((f0.e.d.AbstractC0225d) obj).b());
        }
        return false;
    }

    public int hashCode() {
        return this.a.hashCode() ^ 1000003;
    }

    public String toString() {
        return "Log{content=" + this.a + "}";
    }

    private v(String str) {
        this.a = str;
    }
}
