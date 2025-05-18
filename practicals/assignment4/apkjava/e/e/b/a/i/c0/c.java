package e.e.b.a.i.c0;

/* compiled from: TimeModule_EventClockFactory.java */
/* loaded from: classes2.dex */
public final class c implements e.e.b.a.i.x.a.b<e.e.b.a.i.c0.a> {

    /* compiled from: TimeModule_EventClockFactory.java */
    /* loaded from: classes2.dex */
    private static final class a {
        private static final c a = new c();
    }

    public static c a() {
        return a.a;
    }

    public static e.e.b.a.i.c0.a b() {
        return (e.e.b.a.i.c0.a) e.e.b.a.i.x.a.d.c(b.a(), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // javax.inject.Provider
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public e.e.b.a.i.c0.a get() {
        return b();
    }
}
