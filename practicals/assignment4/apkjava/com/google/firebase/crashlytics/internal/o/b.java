package com.google.firebase.crashlytics.internal.o;

import com.google.firebase.encoders.c;
import com.google.firebase.encoders.d;
import java.io.IOException;

/* compiled from: AutoRolloutAssignmentEncoder.java */
/* loaded from: classes2.dex */
public final class b implements com.google.firebase.encoders.g.a {
    public static final com.google.firebase.encoders.g.a a = new b();

    /* compiled from: AutoRolloutAssignmentEncoder.java */
    /* loaded from: classes2.dex */
    private static final class a implements c<j> {
        static final a a = new a();

        /* renamed from: b, reason: collision with root package name */
        private static final com.google.firebase.encoders.b f19141b = com.google.firebase.encoders.b.d("rolloutId");

        /* renamed from: c, reason: collision with root package name */
        private static final com.google.firebase.encoders.b f19142c = com.google.firebase.encoders.b.d("parameterKey");

        /* renamed from: d, reason: collision with root package name */
        private static final com.google.firebase.encoders.b f19143d = com.google.firebase.encoders.b.d("parameterValue");

        /* renamed from: e, reason: collision with root package name */
        private static final com.google.firebase.encoders.b f19144e = com.google.firebase.encoders.b.d("variantId");

        /* renamed from: f, reason: collision with root package name */
        private static final com.google.firebase.encoders.b f19145f = com.google.firebase.encoders.b.d("templateVersion");

        private a() {
        }

        @Override // com.google.firebase.encoders.c
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(j jVar, d dVar) throws IOException {
            dVar.i(f19141b, jVar.e());
            dVar.i(f19142c, jVar.c());
            dVar.i(f19143d, jVar.d());
            dVar.i(f19144e, jVar.g());
            dVar.b(f19145f, jVar.f());
        }
    }

    private b() {
    }

    @Override // com.google.firebase.encoders.g.a
    public void a(com.google.firebase.encoders.g.b<?> bVar) {
        a aVar = a.a;
        bVar.a(j.class, aVar);
        bVar.a(c.class, aVar);
    }
}
