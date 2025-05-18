package e.e.b.a.i.b0.j;

/* compiled from: EventStoreModule_DbNameFactory.java */
/* loaded from: classes2.dex */
public final class m0 implements e.e.b.a.i.x.a.b<String> {

    /* compiled from: EventStoreModule_DbNameFactory.java */
    /* loaded from: classes2.dex */
    private static final class a {
        private static final m0 a = new m0();
    }

    public static m0 a() {
        return a.a;
    }

    public static String b() {
        return (String) e.e.b.a.i.x.a.d.c(l0.a(), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // javax.inject.Provider
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public String get() {
        return b();
    }
}
