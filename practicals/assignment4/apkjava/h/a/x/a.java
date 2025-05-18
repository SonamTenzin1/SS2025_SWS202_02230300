package h.a.x;

/* compiled from: ActionDisposable.java */
/* loaded from: classes2.dex */
final class a extends e<h.a.y.a> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public a(h.a.y.a aVar) {
        super(aVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // h.a.x.e
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public void a(h.a.y.a aVar) {
        try {
            aVar.run();
        } catch (Throwable th) {
            throw h.a.z.j.c.c(th);
        }
    }
}
