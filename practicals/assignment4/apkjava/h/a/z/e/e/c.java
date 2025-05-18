package h.a.z.e.e;

import h.a.s;
import h.a.u;

/* compiled from: SingleJust.java */
/* loaded from: classes2.dex */
public final class c<T> extends s<T> {
    final T a;

    public c(T t) {
        this.a = t;
    }

    @Override // h.a.s
    protected void h(u<? super T> uVar) {
        uVar.b(h.a.x.d.a());
        uVar.onSuccess(this.a);
    }
}
