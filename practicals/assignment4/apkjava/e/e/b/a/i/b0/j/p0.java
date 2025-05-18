package e.e.b.a.i.b0.j;

/* compiled from: EventStoreModule_StoreConfigFactory.java */
/* loaded from: classes2.dex */
public final class p0 implements e.e.b.a.i.x.a.b<k0> {

    /* compiled from: EventStoreModule_StoreConfigFactory.java */
    /* loaded from: classes2.dex */
    private static final class a {
        private static final p0 a = new p0();
    }

    public static p0 a() {
        return a.a;
    }

    public static k0 c() {
        return (k0) e.e.b.a.i.x.a.d.c(l0.d(), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // javax.inject.Provider
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public k0 get() {
        return c();
    }
}
