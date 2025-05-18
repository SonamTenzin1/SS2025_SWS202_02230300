package e.g.b;

import e.g.b.e;
import rx.e;

/* compiled from: BehaviorRelay.java */
/* loaded from: classes.dex */
public class a<T> extends d<T, T> {

    /* renamed from: g, reason: collision with root package name */
    private static final Object[] f21193g = new Object[0];

    /* renamed from: h, reason: collision with root package name */
    private final e<T> f21194h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BehaviorRelay.java */
    /* renamed from: e.g.b.a$a, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0270a implements rx.m.b<e.b<T>> {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ e f21195f;

        C0270a(e eVar) {
            this.f21195f = eVar;
        }

        @Override // rx.m.b
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void call(e.b<T> bVar) {
            bVar.b(this.f21195f.d());
        }
    }

    protected a(e.a<T> aVar, e<T> eVar) {
        super(aVar);
        this.f21194h = eVar;
    }

    public static <T> a<T> f1() {
        return g1(null, false);
    }

    private static <T> a<T> g1(T t, boolean z) {
        e eVar = new e();
        if (z) {
            eVar.h(b.b(t));
        }
        eVar.f21200i = new C0270a(eVar);
        return new a<>(eVar, eVar);
    }

    @Override // rx.m.b
    public void call(T t) {
        if (this.f21194h.d() == null || this.f21194h.f21198g) {
            Object b2 = b.b(t);
            for (e.b<T> bVar : this.f21194h.e(b2)) {
                bVar.d(b2);
            }
        }
    }
}
