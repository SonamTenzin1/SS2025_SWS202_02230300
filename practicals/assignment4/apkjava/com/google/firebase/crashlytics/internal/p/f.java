package com.google.firebase.crashlytics.internal.p;

import com.google.firebase.crashlytics.internal.p.f0;
import java.util.List;
import okhttp3.HttpUrl;

/* compiled from: AutoValue_CrashlyticsReport_FilesPayload.java */
/* loaded from: classes2.dex */
final class f extends f0.d {
    private final List<f0.d.b> a;

    /* renamed from: b, reason: collision with root package name */
    private final String f19360b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AutoValue_CrashlyticsReport_FilesPayload.java */
    /* loaded from: classes2.dex */
    public static final class b extends f0.d.a {
        private List<f0.d.b> a;

        /* renamed from: b, reason: collision with root package name */
        private String f19361b;

        @Override // com.google.firebase.crashlytics.h.p.f0.d.a
        public f0.d a() {
            List<f0.d.b> list = this.a;
            String str = HttpUrl.FRAGMENT_ENCODE_SET;
            if (list == null) {
                str = HttpUrl.FRAGMENT_ENCODE_SET + " files";
            }
            if (str.isEmpty()) {
                return new f(this.a, this.f19361b);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // com.google.firebase.crashlytics.h.p.f0.d.a
        public f0.d.a b(List<f0.d.b> list) {
            if (list != null) {
                this.a = list;
                return this;
            }
            throw new NullPointerException("Null files");
        }

        @Override // com.google.firebase.crashlytics.h.p.f0.d.a
        public f0.d.a c(String str) {
            this.f19361b = str;
            return this;
        }
    }

    @Override // com.google.firebase.crashlytics.h.p.f0.d
    public List<f0.d.b> b() {
        return this.a;
    }

    @Override // com.google.firebase.crashlytics.h.p.f0.d
    public String c() {
        return this.f19360b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof f0.d)) {
            return false;
        }
        f0.d dVar = (f0.d) obj;
        if (this.a.equals(dVar.b())) {
            String str = this.f19360b;
            if (str == null) {
                if (dVar.c() == null) {
                    return true;
                }
            } else if (str.equals(dVar.c())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int hashCode = (this.a.hashCode() ^ 1000003) * 1000003;
        String str = this.f19360b;
        return hashCode ^ (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "FilesPayload{files=" + this.a + ", orgId=" + this.f19360b + "}";
    }

    private f(List<f0.d.b> list, String str) {
        this.a = list;
        this.f19360b = str;
    }
}
