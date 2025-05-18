package h.a.z.e.a;

import java.util.concurrent.Callable;

/* compiled from: CompletableFromCallable.java */
/* loaded from: classes2.dex */
public final class b extends h.a.b {
    final Callable<?> a;

    public b(Callable<?> callable) {
        this.a = callable;
    }

    @Override // h.a.b
    protected void e(h.a.d dVar) {
        h.a.x.c b2 = h.a.x.d.b();
        dVar.b(b2);
        try {
            this.a.call();
            if (b2.q()) {
                return;
            }
            dVar.a();
        } catch (Throwable th) {
            io.reactivex.exceptions.a.a(th);
            if (!b2.q()) {
                dVar.onError(th);
            } else {
                h.a.a0.a.o(th);
            }
        }
    }
}
