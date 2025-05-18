package e.h.a;

import e.h.a.h0.b;

/* compiled from: FileDownloadConnectListener.java */
/* loaded from: classes2.dex */
public abstract class e extends e.h.a.h0.d {
    private b.a a;

    @Override // e.h.a.h0.d
    public boolean d(e.h.a.h0.c cVar) {
        if (!(cVar instanceof e.h.a.h0.b)) {
            return false;
        }
        b.a b2 = ((e.h.a.h0.b) cVar).b();
        this.a = b2;
        if (b2 == b.a.connected) {
            e();
            return false;
        }
        f();
        return false;
    }

    public abstract void e();

    public abstract void f();

    public b.a g() {
        return this.a;
    }
}
