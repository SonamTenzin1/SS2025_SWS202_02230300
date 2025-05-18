package com.google.android.datatransport.cct.f;

import java.io.IOException;

/* compiled from: AutoBatchedLogRequestEncoder.java */
/* loaded from: classes2.dex */
public final class b implements com.google.firebase.encoders.g.a {
    public static final com.google.firebase.encoders.g.a a = new b();

    /* compiled from: AutoBatchedLogRequestEncoder.java */
    /* loaded from: classes2.dex */
    private static final class a implements com.google.firebase.encoders.c<com.google.android.datatransport.cct.f.a> {
        static final a a = new a();

        /* renamed from: b, reason: collision with root package name */
        private static final com.google.firebase.encoders.b f11202b = com.google.firebase.encoders.b.d("sdkVersion");

        /* renamed from: c, reason: collision with root package name */
        private static final com.google.firebase.encoders.b f11203c = com.google.firebase.encoders.b.d("model");

        /* renamed from: d, reason: collision with root package name */
        private static final com.google.firebase.encoders.b f11204d = com.google.firebase.encoders.b.d("hardware");

        /* renamed from: e, reason: collision with root package name */
        private static final com.google.firebase.encoders.b f11205e = com.google.firebase.encoders.b.d("device");

        /* renamed from: f, reason: collision with root package name */
        private static final com.google.firebase.encoders.b f11206f = com.google.firebase.encoders.b.d("product");

        /* renamed from: g, reason: collision with root package name */
        private static final com.google.firebase.encoders.b f11207g = com.google.firebase.encoders.b.d("osBuild");

        /* renamed from: h, reason: collision with root package name */
        private static final com.google.firebase.encoders.b f11208h = com.google.firebase.encoders.b.d("manufacturer");

        /* renamed from: i, reason: collision with root package name */
        private static final com.google.firebase.encoders.b f11209i = com.google.firebase.encoders.b.d("fingerprint");

        /* renamed from: j, reason: collision with root package name */
        private static final com.google.firebase.encoders.b f11210j = com.google.firebase.encoders.b.d("locale");

        /* renamed from: k, reason: collision with root package name */
        private static final com.google.firebase.encoders.b f11211k = com.google.firebase.encoders.b.d("country");
        private static final com.google.firebase.encoders.b l = com.google.firebase.encoders.b.d("mccMnc");
        private static final com.google.firebase.encoders.b m = com.google.firebase.encoders.b.d("applicationBuild");

        private a() {
        }

        @Override // com.google.firebase.encoders.c
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(com.google.android.datatransport.cct.f.a aVar, com.google.firebase.encoders.d dVar) throws IOException {
            dVar.i(f11202b, aVar.m());
            dVar.i(f11203c, aVar.j());
            dVar.i(f11204d, aVar.f());
            dVar.i(f11205e, aVar.d());
            dVar.i(f11206f, aVar.l());
            dVar.i(f11207g, aVar.k());
            dVar.i(f11208h, aVar.h());
            dVar.i(f11209i, aVar.e());
            dVar.i(f11210j, aVar.g());
            dVar.i(f11211k, aVar.c());
            dVar.i(l, aVar.i());
            dVar.i(m, aVar.b());
        }
    }

    /* compiled from: AutoBatchedLogRequestEncoder.java */
    /* renamed from: com.google.android.datatransport.cct.f.b$b, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    private static final class C0170b implements com.google.firebase.encoders.c<j> {
        static final C0170b a = new C0170b();

        /* renamed from: b, reason: collision with root package name */
        private static final com.google.firebase.encoders.b f11212b = com.google.firebase.encoders.b.d("logRequest");

        private C0170b() {
        }

        @Override // com.google.firebase.encoders.c
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(j jVar, com.google.firebase.encoders.d dVar) throws IOException {
            dVar.i(f11212b, jVar.c());
        }
    }

    /* compiled from: AutoBatchedLogRequestEncoder.java */
    /* loaded from: classes2.dex */
    private static final class c implements com.google.firebase.encoders.c<k> {
        static final c a = new c();

        /* renamed from: b, reason: collision with root package name */
        private static final com.google.firebase.encoders.b f11213b = com.google.firebase.encoders.b.d("clientType");

        /* renamed from: c, reason: collision with root package name */
        private static final com.google.firebase.encoders.b f11214c = com.google.firebase.encoders.b.d("androidClientInfo");

        private c() {
        }

        @Override // com.google.firebase.encoders.c
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(k kVar, com.google.firebase.encoders.d dVar) throws IOException {
            dVar.i(f11213b, kVar.c());
            dVar.i(f11214c, kVar.b());
        }
    }

    /* compiled from: AutoBatchedLogRequestEncoder.java */
    /* loaded from: classes2.dex */
    private static final class d implements com.google.firebase.encoders.c<l> {
        static final d a = new d();

        /* renamed from: b, reason: collision with root package name */
        private static final com.google.firebase.encoders.b f11215b = com.google.firebase.encoders.b.d("eventTimeMs");

        /* renamed from: c, reason: collision with root package name */
        private static final com.google.firebase.encoders.b f11216c = com.google.firebase.encoders.b.d("eventCode");

        /* renamed from: d, reason: collision with root package name */
        private static final com.google.firebase.encoders.b f11217d = com.google.firebase.encoders.b.d("eventUptimeMs");

        /* renamed from: e, reason: collision with root package name */
        private static final com.google.firebase.encoders.b f11218e = com.google.firebase.encoders.b.d("sourceExtension");

        /* renamed from: f, reason: collision with root package name */
        private static final com.google.firebase.encoders.b f11219f = com.google.firebase.encoders.b.d("sourceExtensionJsonProto3");

        /* renamed from: g, reason: collision with root package name */
        private static final com.google.firebase.encoders.b f11220g = com.google.firebase.encoders.b.d("timezoneOffsetSeconds");

        /* renamed from: h, reason: collision with root package name */
        private static final com.google.firebase.encoders.b f11221h = com.google.firebase.encoders.b.d("networkConnectionInfo");

        private d() {
        }

        @Override // com.google.firebase.encoders.c
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(l lVar, com.google.firebase.encoders.d dVar) throws IOException {
            dVar.b(f11215b, lVar.c());
            dVar.i(f11216c, lVar.b());
            dVar.b(f11217d, lVar.d());
            dVar.i(f11218e, lVar.f());
            dVar.i(f11219f, lVar.g());
            dVar.b(f11220g, lVar.h());
            dVar.i(f11221h, lVar.e());
        }
    }

    /* compiled from: AutoBatchedLogRequestEncoder.java */
    /* loaded from: classes2.dex */
    private static final class e implements com.google.firebase.encoders.c<m> {
        static final e a = new e();

        /* renamed from: b, reason: collision with root package name */
        private static final com.google.firebase.encoders.b f11222b = com.google.firebase.encoders.b.d("requestTimeMs");

        /* renamed from: c, reason: collision with root package name */
        private static final com.google.firebase.encoders.b f11223c = com.google.firebase.encoders.b.d("requestUptimeMs");

        /* renamed from: d, reason: collision with root package name */
        private static final com.google.firebase.encoders.b f11224d = com.google.firebase.encoders.b.d("clientInfo");

        /* renamed from: e, reason: collision with root package name */
        private static final com.google.firebase.encoders.b f11225e = com.google.firebase.encoders.b.d("logSource");

        /* renamed from: f, reason: collision with root package name */
        private static final com.google.firebase.encoders.b f11226f = com.google.firebase.encoders.b.d("logSourceName");

        /* renamed from: g, reason: collision with root package name */
        private static final com.google.firebase.encoders.b f11227g = com.google.firebase.encoders.b.d("logEvent");

        /* renamed from: h, reason: collision with root package name */
        private static final com.google.firebase.encoders.b f11228h = com.google.firebase.encoders.b.d("qosTier");

        private e() {
        }

        @Override // com.google.firebase.encoders.c
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(m mVar, com.google.firebase.encoders.d dVar) throws IOException {
            dVar.b(f11222b, mVar.g());
            dVar.b(f11223c, mVar.h());
            dVar.i(f11224d, mVar.b());
            dVar.i(f11225e, mVar.d());
            dVar.i(f11226f, mVar.e());
            dVar.i(f11227g, mVar.c());
            dVar.i(f11228h, mVar.f());
        }
    }

    /* compiled from: AutoBatchedLogRequestEncoder.java */
    /* loaded from: classes2.dex */
    private static final class f implements com.google.firebase.encoders.c<o> {
        static final f a = new f();

        /* renamed from: b, reason: collision with root package name */
        private static final com.google.firebase.encoders.b f11229b = com.google.firebase.encoders.b.d("networkType");

        /* renamed from: c, reason: collision with root package name */
        private static final com.google.firebase.encoders.b f11230c = com.google.firebase.encoders.b.d("mobileSubtype");

        private f() {
        }

        @Override // com.google.firebase.encoders.c
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(o oVar, com.google.firebase.encoders.d dVar) throws IOException {
            dVar.i(f11229b, oVar.c());
            dVar.i(f11230c, oVar.b());
        }
    }

    private b() {
    }

    @Override // com.google.firebase.encoders.g.a
    public void a(com.google.firebase.encoders.g.b<?> bVar) {
        C0170b c0170b = C0170b.a;
        bVar.a(j.class, c0170b);
        bVar.a(com.google.android.datatransport.cct.f.d.class, c0170b);
        e eVar = e.a;
        bVar.a(m.class, eVar);
        bVar.a(g.class, eVar);
        c cVar = c.a;
        bVar.a(k.class, cVar);
        bVar.a(com.google.android.datatransport.cct.f.e.class, cVar);
        a aVar = a.a;
        bVar.a(com.google.android.datatransport.cct.f.a.class, aVar);
        bVar.a(com.google.android.datatransport.cct.f.c.class, aVar);
        d dVar = d.a;
        bVar.a(l.class, dVar);
        bVar.a(com.google.android.datatransport.cct.f.f.class, dVar);
        f fVar = f.a;
        bVar.a(o.class, fVar);
        bVar.a(i.class, fVar);
    }
}
