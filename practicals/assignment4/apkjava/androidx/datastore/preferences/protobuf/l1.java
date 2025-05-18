package androidx.datastore.preferences.protobuf;

import java.io.IOException;

/* compiled from: UnknownFieldSchema.java */
/* loaded from: classes.dex */
abstract class l1<T, B> {
    abstract void a(B b2, int i2, int i3);

    abstract void b(B b2, int i2, long j2);

    abstract void c(B b2, int i2, T t);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void d(B b2, int i2, h hVar);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void e(B b2, int i2, long j2);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract B f(Object obj);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract T g(Object obj);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract int h(T t);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract int i(T t);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void j(Object obj);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract T k(T t, T t2);

    final void l(B b2, e1 e1Var) throws IOException {
        while (e1Var.A() != Integer.MAX_VALUE && m(b2, e1Var)) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean m(B b2, e1 e1Var) throws IOException {
        int tag = e1Var.getTag();
        int a = r1.a(tag);
        int b3 = r1.b(tag);
        if (b3 == 0) {
            e(b2, a, e1Var.L());
            return true;
        }
        if (b3 == 1) {
            b(b2, a, e1Var.f());
            return true;
        }
        if (b3 == 2) {
            d(b2, a, e1Var.C());
            return true;
        }
        if (b3 != 3) {
            if (b3 == 4) {
                return false;
            }
            if (b3 == 5) {
                a(b2, a, e1Var.k());
                return true;
            }
            throw InvalidProtocolBufferException.d();
        }
        B n = n();
        int c2 = r1.c(a, 4);
        l(n, e1Var);
        if (c2 == e1Var.getTag()) {
            c(b2, a, r(n));
            return true;
        }
        throw InvalidProtocolBufferException.a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract B n();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void o(Object obj, B b2);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void p(Object obj, T t);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract boolean q(e1 e1Var);

    abstract T r(B b2);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void s(T t, s1 s1Var) throws IOException;

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void t(T t, s1 s1Var) throws IOException;
}
