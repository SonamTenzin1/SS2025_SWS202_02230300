package com.google.android.gms.internal.measurement;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.2.0 */
/* loaded from: classes2.dex */
abstract class h4<T, B> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract B a();

    abstract T b(B b2);

    abstract void c(B b2, int i2, int i3);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void d(B b2, int i2, long j2);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void e(B b2, int i2, zzdu zzduVar);

    abstract void f(B b2, int i2, T t);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void g(T t, y4 y4Var) throws IOException;

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void h(Object obj, T t);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract boolean i(q3 q3Var);

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean j(B b2, q3 q3Var) throws IOException {
        int b3 = q3Var.b();
        int i2 = b3 >>> 3;
        int i3 = b3 & 7;
        if (i3 == 0) {
            d(b2, i2, q3Var.s());
            return true;
        }
        if (i3 == 1) {
            l(b2, i2, q3Var.l());
            return true;
        }
        if (i3 == 2) {
            e(b2, i2, q3Var.f());
            return true;
        }
        if (i3 != 3) {
            if (i3 == 4) {
                return false;
            }
            if (i3 == 5) {
                c(b2, i2, q3Var.v());
                return true;
            }
            throw zzfo.f();
        }
        B a = a();
        int i4 = 4 | (i2 << 3);
        while (q3Var.a() != Integer.MAX_VALUE && j(a, q3Var)) {
        }
        if (i4 == q3Var.b()) {
            f(b2, i2, b(a));
            return true;
        }
        throw zzfo.e();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract T k(Object obj);

    abstract void l(B b2, int i2, long j2);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void m(T t, y4 y4Var) throws IOException;

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void n(Object obj, B b2);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract B o(Object obj);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract T p(T t, T t2);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void q(Object obj);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract int r(T t);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract int s(T t);
}
