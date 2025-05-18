package com.google.firebase.crashlytics.internal.p;

import com.google.firebase.crashlytics.internal.p.f0;
import java.util.List;
import okhttp3.HttpUrl;

/* compiled from: AutoValue_CrashlyticsReport_Session_Event_Application.java */
/* loaded from: classes2.dex */
final class m extends f0.e.d.a {
    private final f0.e.d.a.b a;

    /* renamed from: b, reason: collision with root package name */
    private final List<f0.c> f19422b;

    /* renamed from: c, reason: collision with root package name */
    private final List<f0.c> f19423c;

    /* renamed from: d, reason: collision with root package name */
    private final Boolean f19424d;

    /* renamed from: e, reason: collision with root package name */
    private final f0.e.d.a.c f19425e;

    /* renamed from: f, reason: collision with root package name */
    private final List<f0.e.d.a.c> f19426f;

    /* renamed from: g, reason: collision with root package name */
    private final int f19427g;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AutoValue_CrashlyticsReport_Session_Event_Application.java */
    /* loaded from: classes2.dex */
    public static final class b extends f0.e.d.a.AbstractC0213a {
        private f0.e.d.a.b a;

        /* renamed from: b, reason: collision with root package name */
        private List<f0.c> f19428b;

        /* renamed from: c, reason: collision with root package name */
        private List<f0.c> f19429c;

        /* renamed from: d, reason: collision with root package name */
        private Boolean f19430d;

        /* renamed from: e, reason: collision with root package name */
        private f0.e.d.a.c f19431e;

        /* renamed from: f, reason: collision with root package name */
        private List<f0.e.d.a.c> f19432f;

        /* renamed from: g, reason: collision with root package name */
        private Integer f19433g;

        @Override // com.google.firebase.crashlytics.h.p.f0.e.d.a.AbstractC0213a
        public f0.e.d.a a() {
            f0.e.d.a.b bVar = this.a;
            String str = HttpUrl.FRAGMENT_ENCODE_SET;
            if (bVar == null) {
                str = HttpUrl.FRAGMENT_ENCODE_SET + " execution";
            }
            if (this.f19433g == null) {
                str = str + " uiOrientation";
            }
            if (str.isEmpty()) {
                return new m(this.a, this.f19428b, this.f19429c, this.f19430d, this.f19431e, this.f19432f, this.f19433g.intValue());
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // com.google.firebase.crashlytics.h.p.f0.e.d.a.AbstractC0213a
        public f0.e.d.a.AbstractC0213a b(List<f0.e.d.a.c> list) {
            this.f19432f = list;
            return this;
        }

        @Override // com.google.firebase.crashlytics.h.p.f0.e.d.a.AbstractC0213a
        public f0.e.d.a.AbstractC0213a c(Boolean bool) {
            this.f19430d = bool;
            return this;
        }

        @Override // com.google.firebase.crashlytics.h.p.f0.e.d.a.AbstractC0213a
        public f0.e.d.a.AbstractC0213a d(f0.e.d.a.c cVar) {
            this.f19431e = cVar;
            return this;
        }

        @Override // com.google.firebase.crashlytics.h.p.f0.e.d.a.AbstractC0213a
        public f0.e.d.a.AbstractC0213a e(List<f0.c> list) {
            this.f19428b = list;
            return this;
        }

        @Override // com.google.firebase.crashlytics.h.p.f0.e.d.a.AbstractC0213a
        public f0.e.d.a.AbstractC0213a f(f0.e.d.a.b bVar) {
            if (bVar != null) {
                this.a = bVar;
                return this;
            }
            throw new NullPointerException("Null execution");
        }

        @Override // com.google.firebase.crashlytics.h.p.f0.e.d.a.AbstractC0213a
        public f0.e.d.a.AbstractC0213a g(List<f0.c> list) {
            this.f19429c = list;
            return this;
        }

        @Override // com.google.firebase.crashlytics.h.p.f0.e.d.a.AbstractC0213a
        public f0.e.d.a.AbstractC0213a h(int i2) {
            this.f19433g = Integer.valueOf(i2);
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public b() {
        }

        private b(f0.e.d.a aVar) {
            this.a = aVar.f();
            this.f19428b = aVar.e();
            this.f19429c = aVar.g();
            this.f19430d = aVar.c();
            this.f19431e = aVar.d();
            this.f19432f = aVar.b();
            this.f19433g = Integer.valueOf(aVar.h());
        }
    }

    @Override // com.google.firebase.crashlytics.h.p.f0.e.d.a
    public List<f0.e.d.a.c> b() {
        return this.f19426f;
    }

    @Override // com.google.firebase.crashlytics.h.p.f0.e.d.a
    public Boolean c() {
        return this.f19424d;
    }

    @Override // com.google.firebase.crashlytics.h.p.f0.e.d.a
    public f0.e.d.a.c d() {
        return this.f19425e;
    }

    @Override // com.google.firebase.crashlytics.h.p.f0.e.d.a
    public List<f0.c> e() {
        return this.f19422b;
    }

    public boolean equals(Object obj) {
        List<f0.c> list;
        List<f0.c> list2;
        Boolean bool;
        f0.e.d.a.c cVar;
        List<f0.e.d.a.c> list3;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof f0.e.d.a)) {
            return false;
        }
        f0.e.d.a aVar = (f0.e.d.a) obj;
        return this.a.equals(aVar.f()) && ((list = this.f19422b) != null ? list.equals(aVar.e()) : aVar.e() == null) && ((list2 = this.f19423c) != null ? list2.equals(aVar.g()) : aVar.g() == null) && ((bool = this.f19424d) != null ? bool.equals(aVar.c()) : aVar.c() == null) && ((cVar = this.f19425e) != null ? cVar.equals(aVar.d()) : aVar.d() == null) && ((list3 = this.f19426f) != null ? list3.equals(aVar.b()) : aVar.b() == null) && this.f19427g == aVar.h();
    }

    @Override // com.google.firebase.crashlytics.h.p.f0.e.d.a
    public f0.e.d.a.b f() {
        return this.a;
    }

    @Override // com.google.firebase.crashlytics.h.p.f0.e.d.a
    public List<f0.c> g() {
        return this.f19423c;
    }

    @Override // com.google.firebase.crashlytics.h.p.f0.e.d.a
    public int h() {
        return this.f19427g;
    }

    public int hashCode() {
        int hashCode = (this.a.hashCode() ^ 1000003) * 1000003;
        List<f0.c> list = this.f19422b;
        int hashCode2 = (hashCode ^ (list == null ? 0 : list.hashCode())) * 1000003;
        List<f0.c> list2 = this.f19423c;
        int hashCode3 = (hashCode2 ^ (list2 == null ? 0 : list2.hashCode())) * 1000003;
        Boolean bool = this.f19424d;
        int hashCode4 = (hashCode3 ^ (bool == null ? 0 : bool.hashCode())) * 1000003;
        f0.e.d.a.c cVar = this.f19425e;
        int hashCode5 = (hashCode4 ^ (cVar == null ? 0 : cVar.hashCode())) * 1000003;
        List<f0.e.d.a.c> list3 = this.f19426f;
        return ((hashCode5 ^ (list3 != null ? list3.hashCode() : 0)) * 1000003) ^ this.f19427g;
    }

    @Override // com.google.firebase.crashlytics.h.p.f0.e.d.a
    public f0.e.d.a.AbstractC0213a i() {
        return new b(this);
    }

    public String toString() {
        return "Application{execution=" + this.a + ", customAttributes=" + this.f19422b + ", internalKeys=" + this.f19423c + ", background=" + this.f19424d + ", currentProcessDetails=" + this.f19425e + ", appProcessDetails=" + this.f19426f + ", uiOrientation=" + this.f19427g + "}";
    }

    private m(f0.e.d.a.b bVar, List<f0.c> list, List<f0.c> list2, Boolean bool, f0.e.d.a.c cVar, List<f0.e.d.a.c> list3, int i2) {
        this.a = bVar;
        this.f19422b = list;
        this.f19423c = list2;
        this.f19424d = bool;
        this.f19425e = cVar;
        this.f19426f = list3;
        this.f19427g = i2;
    }
}
