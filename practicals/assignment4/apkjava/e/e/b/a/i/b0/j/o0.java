package e.e.b.a.i.b0.j;

/* compiled from: EventStoreModule_SchemaVersionFactory.java */
/* loaded from: classes2.dex */
public final class o0 implements e.e.b.a.i.x.a.b<Integer> {

    /* compiled from: EventStoreModule_SchemaVersionFactory.java */
    /* loaded from: classes2.dex */
    private static final class a {
        private static final o0 a = new o0();
    }

    public static o0 a() {
        return a.a;
    }

    public static int c() {
        return l0.c();
    }

    @Override // javax.inject.Provider
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public Integer get() {
        return Integer.valueOf(c());
    }
}
