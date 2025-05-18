package com.google.firebase.crashlytics;

import android.content.Context;
import android.content.pm.PackageManager;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.crashlytics.internal.h;
import com.google.firebase.crashlytics.internal.k;
import com.google.firebase.crashlytics.internal.n.e0;
import com.google.firebase.crashlytics.internal.n.g0;
import com.google.firebase.crashlytics.internal.n.i0;
import com.google.firebase.crashlytics.internal.n.l;
import com.google.firebase.crashlytics.internal.n.q;
import com.google.firebase.crashlytics.internal.n.t;
import com.google.firebase.crashlytics.internal.n.v;
import com.google.firebase.crashlytics.internal.n.y;
import com.google.firebase.installations.i;
import com.google.firebase.j;
import com.google.firebase.sessions.api.FirebaseSessionsDependencies;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;

/* compiled from: FirebaseCrashlytics.java */
/* loaded from: classes2.dex */
public class g {
    final y a;

    /* compiled from: FirebaseCrashlytics.java */
    /* loaded from: classes2.dex */
    class a implements Continuation<Void, Object> {
        a() {
        }

        @Override // com.google.android.gms.tasks.Continuation
        public Object a(Task<Void> task) throws Exception {
            if (task.n()) {
                return null;
            }
            h.f().e("Error fetching settings.", task.i());
            return null;
        }
    }

    /* compiled from: FirebaseCrashlytics.java */
    /* loaded from: classes2.dex */
    class b implements Callable<Void> {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ boolean f18991f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ y f18992g;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ com.google.firebase.crashlytics.internal.t.f f18993h;

        b(boolean z, y yVar, com.google.firebase.crashlytics.internal.t.f fVar) {
            this.f18991f = z;
            this.f18992g = yVar;
            this.f18993h = fVar;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void call() throws Exception {
            if (!this.f18991f) {
                return null;
            }
            this.f18992g.g(this.f18993h);
            return null;
        }
    }

    private g(y yVar) {
        this.a = yVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static g a(j jVar, i iVar, com.google.firebase.s.a<com.google.firebase.crashlytics.internal.d> aVar, com.google.firebase.s.a<com.google.firebase.analytics.a.a> aVar2, com.google.firebase.s.a<com.google.firebase.v.a.a> aVar3) {
        Context i2 = jVar.i();
        String packageName = i2.getPackageName();
        h.f().g("Initializing Firebase Crashlytics " + y.i() + " for " + packageName);
        com.google.firebase.crashlytics.internal.r.f fVar = new com.google.firebase.crashlytics.internal.r.f(i2);
        e0 e0Var = new e0(jVar);
        i0 i0Var = new i0(i2, packageName, iVar, e0Var);
        com.google.firebase.crashlytics.internal.e eVar = new com.google.firebase.crashlytics.internal.e(aVar);
        e eVar2 = new e(aVar2);
        ExecutorService c2 = g0.c("Crashlytics Exception Handler");
        v vVar = new v(e0Var, fVar);
        FirebaseSessionsDependencies.e(vVar);
        y yVar = new y(jVar, i0Var, eVar, e0Var, eVar2.b(), eVar2.a(), fVar, c2, vVar, new k(aVar3));
        String c3 = jVar.l().c();
        String m = t.m(i2);
        List<q> j2 = t.j(i2);
        h.f().b("Mapping file ID is: " + m);
        for (q qVar : j2) {
            h.f().b(String.format("Build id for %s on %s: %s", qVar.c(), qVar.a(), qVar.b()));
        }
        try {
            l a2 = l.a(i2, i0Var, c3, m, j2, new com.google.firebase.crashlytics.internal.g(i2));
            h.f().i("Installer package name is: " + a2.f19058d);
            ExecutorService c4 = g0.c("com.google.firebase.crashlytics.startup");
            com.google.firebase.crashlytics.internal.t.f l = com.google.firebase.crashlytics.internal.t.f.l(i2, c3, i0Var, new com.google.firebase.crashlytics.internal.q.b(), a2.f19060f, a2.f19061g, fVar, e0Var);
            l.p(c4).g(c4, new a());
            Tasks.c(c4, new b(yVar.n(a2, l), yVar, l));
            return new g(yVar);
        } catch (PackageManager.NameNotFoundException e2) {
            h.f().e("Error retrieving app package info.", e2);
            return null;
        }
    }
}
