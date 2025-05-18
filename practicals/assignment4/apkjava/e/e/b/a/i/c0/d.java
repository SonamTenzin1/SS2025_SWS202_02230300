package e.e.b.a.i.c0;

/* compiled from: TimeModule_UptimeClockFactory.java */
/* loaded from: classes2.dex */
public final class d implements e.e.b.a.i.x.a.b<e.e.b.a.i.c0.a> {

    /* compiled from: TimeModule_UptimeClockFactory.java */
    /* loaded from: classes2.dex */
    private static final class a {
        private static final d a = new d();
    }

    public static d a() {
        return a.a;
    }

    public static e.e.b.a.i.c0.a c() {
        return (e.e.b.a.i.c0.a) e.e.b.a.i.x.a.d.c(b.b(), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // javax.inject.Provider
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public e.e.b.a.i.c0.a get() {
        return c();
    }
}
