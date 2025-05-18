package com.facebook.o0;

/* compiled from: AppEventStore.kt */
/* loaded from: classes.dex */
public final class z {
    public static final z a = new z();

    /* renamed from: b, reason: collision with root package name */
    private static final String f10557b = z.class.getName();

    private z() {
    }

    public static final synchronized void a(t tVar, i0 i0Var) {
        synchronized (z.class) {
            kotlin.jvm.internal.m.f(tVar, "accessTokenAppIdPair");
            kotlin.jvm.internal.m.f(i0Var, "appEvents");
            com.facebook.o0.q0.g gVar = com.facebook.o0.q0.g.a;
            com.facebook.o0.q0.g.b();
            x xVar = x.a;
            h0 a2 = x.a();
            a2.a(tVar, i0Var.d());
            x.b(a2);
        }
    }

    public static final synchronized void b(w wVar) {
        synchronized (z.class) {
            kotlin.jvm.internal.m.f(wVar, "eventsToPersist");
            com.facebook.o0.q0.g gVar = com.facebook.o0.q0.g.a;
            com.facebook.o0.q0.g.b();
            x xVar = x.a;
            h0 a2 = x.a();
            for (t tVar : wVar.f()) {
                i0 c2 = wVar.c(tVar);
                if (c2 != null) {
                    a2.a(tVar, c2.d());
                } else {
                    throw new IllegalStateException("Required value was null.".toString());
                }
            }
            x xVar2 = x.a;
            x.b(a2);
        }
    }
}
