package io.sentry;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SentryRuntimeEventProcessor.java */
/* loaded from: classes2.dex */
public final class y4 implements k1 {

    /* renamed from: f, reason: collision with root package name */
    private final String f22822f;

    /* renamed from: g, reason: collision with root package name */
    private final String f22823g;

    public y4(String str, String str2) {
        this.f22822f = str;
        this.f22823g = str2;
    }

    private <T extends c4> T a(T t) {
        if (t.C().d() == null) {
            t.C().m(new io.sentry.protocol.s());
        }
        io.sentry.protocol.s d2 = t.C().d();
        if (d2 != null && d2.d() == null && d2.e() == null) {
            d2.f(this.f22823g);
            d2.h(this.f22822f);
        }
        return t;
    }

    @Override // io.sentry.k1
    public l4 b(l4 l4Var, n1 n1Var) {
        return (l4) a(l4Var);
    }

    @Override // io.sentry.k1
    public io.sentry.protocol.x e(io.sentry.protocol.x xVar, n1 n1Var) {
        return (io.sentry.protocol.x) a(xVar);
    }

    public y4() {
        this(System.getProperty("java.version"), System.getProperty("java.vendor"));
    }
}
