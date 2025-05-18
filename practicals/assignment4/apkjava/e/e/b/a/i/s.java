package e.e.b.a.i;

/* compiled from: TransportImpl.java */
/* loaded from: classes2.dex */
final class s<T> implements e.e.b.a.f<T> {
    private final q a;

    /* renamed from: b, reason: collision with root package name */
    private final String f20843b;

    /* renamed from: c, reason: collision with root package name */
    private final e.e.b.a.b f20844c;

    /* renamed from: d, reason: collision with root package name */
    private final e.e.b.a.e<T, byte[]> f20845d;

    /* renamed from: e, reason: collision with root package name */
    private final t f20846e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(q qVar, String str, e.e.b.a.b bVar, e.e.b.a.e<T, byte[]> eVar, t tVar) {
        this.a = qVar;
        this.f20843b = str;
        this.f20844c = bVar;
        this.f20845d = eVar;
        this.f20846e = tVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void d(Exception exc) {
    }

    @Override // e.e.b.a.f
    public void a(e.e.b.a.c<T> cVar) {
        b(cVar, new e.e.b.a.h() { // from class: e.e.b.a.i.a
            @Override // e.e.b.a.h
            public final void a(Exception exc) {
                s.d(exc);
            }
        });
    }

    @Override // e.e.b.a.f
    public void b(e.e.b.a.c<T> cVar, e.e.b.a.h hVar) {
        this.f20846e.a(p.a().e(this.a).c(cVar).f(this.f20843b).d(this.f20845d).b(this.f20844c).a(), hVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public q c() {
        return this.a;
    }
}
