package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-base@@17.2.0 */
/* loaded from: classes2.dex */
public final class z1 implements q3 {
    private final zzeg a;

    /* renamed from: b, reason: collision with root package name */
    private int f17297b;

    /* renamed from: c, reason: collision with root package name */
    private int f17298c;

    /* renamed from: d, reason: collision with root package name */
    private int f17299d = 0;

    private z1(zzeg zzegVar) {
        zzeg zzegVar2 = (zzeg) zzff.f(zzegVar, "input");
        this.a = zzegVar2;
        zzegVar2.f17374d = this;
    }

    public static z1 P(zzeg zzegVar) {
        z1 z1Var = zzegVar.f17374d;
        return z1Var != null ? z1Var : new z1(zzegVar);
    }

    private final void Q(int i2) throws IOException {
        if ((this.f17297b & 7) != i2) {
            throw zzfo.f();
        }
    }

    private final void R(List<String> list, boolean z) throws IOException {
        int a;
        int a2;
        if ((this.f17297b & 7) == 2) {
            if ((list instanceof zzfv) && !z) {
                zzfv zzfvVar = (zzfv) list;
                do {
                    zzfvVar.n1(f());
                    if (this.a.A()) {
                        return;
                    } else {
                        a2 = this.a.a();
                    }
                } while (a2 == this.f17297b);
                this.f17299d = a2;
                return;
            }
            do {
                list.add(z ? j() : w());
                if (this.a.A()) {
                    return;
                } else {
                    a = this.a.a();
                }
            } while (a == this.f17297b);
            this.f17299d = a;
            return;
        }
        throw zzfo.f();
    }

    private static void S(int i2) throws IOException {
        if ((i2 & 7) != 0) {
            throw zzfo.g();
        }
    }

    private final <T> T T(p3<T> p3Var, zzeq zzeqVar) throws IOException {
        int t = this.a.t();
        zzeg zzegVar = this.a;
        if (zzegVar.a < zzegVar.f17372b) {
            int h2 = zzegVar.h(t);
            T a = p3Var.a();
            this.a.a++;
            p3Var.i(a, this, zzeqVar);
            p3Var.f(a);
            this.a.d(0);
            r5.a--;
            this.a.j(h2);
            return a;
        }
        throw new zzfo("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
    }

    private static void U(int i2) throws IOException {
        if ((i2 & 3) != 0) {
            throw zzfo.g();
        }
    }

    private final <T> T V(p3<T> p3Var, zzeq zzeqVar) throws IOException {
        int i2 = this.f17298c;
        this.f17298c = ((this.f17297b >>> 3) << 3) | 4;
        try {
            T a = p3Var.a();
            p3Var.i(a, this, zzeqVar);
            p3Var.f(a);
            if (this.f17297b == this.f17298c) {
                return a;
            }
            throw zzfo.g();
        } finally {
            this.f17298c = i2;
        }
    }

    private final void W(int i2) throws IOException {
        if (this.a.B() != i2) {
            throw zzfo.a();
        }
    }

    @Override // com.google.android.gms.internal.measurement.q3
    public final void A(List<Float> list) throws IOException {
        int a;
        int a2;
        if (list instanceof l2) {
            l2 l2Var = (l2) list;
            int i2 = this.f17297b & 7;
            if (i2 != 2) {
                if (i2 != 5) {
                    throw zzfo.f();
                }
                do {
                    l2Var.f(this.a.g());
                    if (this.a.A()) {
                        return;
                    } else {
                        a2 = this.a.a();
                    }
                } while (a2 == this.f17297b);
                this.f17299d = a2;
                return;
            }
            int t = this.a.t();
            U(t);
            int B = this.a.B() + t;
            do {
                l2Var.f(this.a.g());
            } while (this.a.B() < B);
            return;
        }
        int i3 = this.f17297b & 7;
        if (i3 != 2) {
            if (i3 != 5) {
                throw zzfo.f();
            }
            do {
                list.add(Float.valueOf(this.a.g()));
                if (this.a.A()) {
                    return;
                } else {
                    a = this.a.a();
                }
            } while (a == this.f17297b);
            this.f17299d = a;
            return;
        }
        int t2 = this.a.t();
        U(t2);
        int B2 = this.a.B() + t2;
        do {
            list.add(Float.valueOf(this.a.g()));
        } while (this.a.B() < B2);
    }

    @Override // com.google.android.gms.internal.measurement.q3
    public final void B(List<Integer> list) throws IOException {
        int a;
        int a2;
        if (list instanceof n2) {
            n2 n2Var = (n2) list;
            int i2 = this.f17297b & 7;
            if (i2 != 2) {
                if (i2 != 5) {
                    throw zzfo.f();
                }
                do {
                    n2Var.h(this.a.v());
                    if (this.a.A()) {
                        return;
                    } else {
                        a2 = this.a.a();
                    }
                } while (a2 == this.f17297b);
                this.f17299d = a2;
                return;
            }
            int t = this.a.t();
            U(t);
            int B = this.a.B() + t;
            do {
                n2Var.h(this.a.v());
            } while (this.a.B() < B);
            return;
        }
        int i3 = this.f17297b & 7;
        if (i3 != 2) {
            if (i3 != 5) {
                throw zzfo.f();
            }
            do {
                list.add(Integer.valueOf(this.a.v()));
                if (this.a.A()) {
                    return;
                } else {
                    a = this.a.a();
                }
            } while (a == this.f17297b);
            this.f17299d = a;
            return;
        }
        int t2 = this.a.t();
        U(t2);
        int B2 = this.a.B() + t2;
        do {
            list.add(Integer.valueOf(this.a.v()));
        } while (this.a.B() < B2);
    }

    @Override // com.google.android.gms.internal.measurement.q3
    public final void C(List<Integer> list) throws IOException {
        int a;
        int a2;
        if (list instanceof n2) {
            n2 n2Var = (n2) list;
            int i2 = this.f17297b & 7;
            if (i2 != 0) {
                if (i2 == 2) {
                    int B = this.a.B() + this.a.t();
                    do {
                        n2Var.h(this.a.u());
                    } while (this.a.B() < B);
                    W(B);
                    return;
                }
                throw zzfo.f();
            }
            do {
                n2Var.h(this.a.u());
                if (this.a.A()) {
                    return;
                } else {
                    a2 = this.a.a();
                }
            } while (a2 == this.f17297b);
            this.f17299d = a2;
            return;
        }
        int i3 = this.f17297b & 7;
        if (i3 != 0) {
            if (i3 == 2) {
                int B2 = this.a.B() + this.a.t();
                do {
                    list.add(Integer.valueOf(this.a.u()));
                } while (this.a.B() < B2);
                W(B2);
                return;
            }
            throw zzfo.f();
        }
        do {
            list.add(Integer.valueOf(this.a.u()));
            if (this.a.A()) {
                return;
            } else {
                a = this.a.a();
            }
        } while (a == this.f17297b);
        this.f17299d = a;
    }

    @Override // com.google.android.gms.internal.measurement.q3
    public final <K, V> void D(Map<K, V> map, z2<K, V> z2Var, zzeq zzeqVar) throws IOException {
        Q(2);
        this.a.h(this.a.t());
        throw null;
    }

    @Override // com.google.android.gms.internal.measurement.q3
    public final void E(List<Boolean> list) throws IOException {
        int a;
        int a2;
        if (list instanceof l1) {
            l1 l1Var = (l1) list;
            int i2 = this.f17297b & 7;
            if (i2 != 0) {
                if (i2 == 2) {
                    int B = this.a.B() + this.a.t();
                    do {
                        l1Var.f(this.a.p());
                    } while (this.a.B() < B);
                    W(B);
                    return;
                }
                throw zzfo.f();
            }
            do {
                l1Var.f(this.a.p());
                if (this.a.A()) {
                    return;
                } else {
                    a2 = this.a.a();
                }
            } while (a2 == this.f17297b);
            this.f17299d = a2;
            return;
        }
        int i3 = this.f17297b & 7;
        if (i3 != 0) {
            if (i3 == 2) {
                int B2 = this.a.B() + this.a.t();
                do {
                    list.add(Boolean.valueOf(this.a.p()));
                } while (this.a.B() < B2);
                W(B2);
                return;
            }
            throw zzfo.f();
        }
        do {
            list.add(Boolean.valueOf(this.a.p()));
            if (this.a.A()) {
                return;
            } else {
                a = this.a.a();
            }
        } while (a == this.f17297b);
        this.f17299d = a;
    }

    @Override // com.google.android.gms.internal.measurement.q3
    public final void F(List<Integer> list) throws IOException {
        int a;
        int a2;
        if (list instanceof n2) {
            n2 n2Var = (n2) list;
            int i2 = this.f17297b & 7;
            if (i2 != 2) {
                if (i2 != 5) {
                    throw zzfo.f();
                }
                do {
                    n2Var.h(this.a.o());
                    if (this.a.A()) {
                        return;
                    } else {
                        a2 = this.a.a();
                    }
                } while (a2 == this.f17297b);
                this.f17299d = a2;
                return;
            }
            int t = this.a.t();
            U(t);
            int B = this.a.B() + t;
            do {
                n2Var.h(this.a.o());
            } while (this.a.B() < B);
            return;
        }
        int i3 = this.f17297b & 7;
        if (i3 != 2) {
            if (i3 != 5) {
                throw zzfo.f();
            }
            do {
                list.add(Integer.valueOf(this.a.o()));
                if (this.a.A()) {
                    return;
                } else {
                    a = this.a.a();
                }
            } while (a == this.f17297b);
            this.f17299d = a;
            return;
        }
        int t2 = this.a.t();
        U(t2);
        int B2 = this.a.B() + t2;
        do {
            list.add(Integer.valueOf(this.a.o()));
        } while (this.a.B() < B2);
    }

    @Override // com.google.android.gms.internal.measurement.q3
    public final void G(List<Long> list) throws IOException {
        int a;
        int a2;
        if (list instanceof w2) {
            w2 w2Var = (w2) list;
            int i2 = this.f17297b & 7;
            if (i2 != 1) {
                if (i2 == 2) {
                    int t = this.a.t();
                    S(t);
                    int B = this.a.B() + t;
                    do {
                        w2Var.G0(this.a.n());
                    } while (this.a.B() < B);
                    return;
                }
                throw zzfo.f();
            }
            do {
                w2Var.G0(this.a.n());
                if (this.a.A()) {
                    return;
                } else {
                    a2 = this.a.a();
                }
            } while (a2 == this.f17297b);
            this.f17299d = a2;
            return;
        }
        int i3 = this.f17297b & 7;
        if (i3 != 1) {
            if (i3 == 2) {
                int t2 = this.a.t();
                S(t2);
                int B2 = this.a.B() + t2;
                do {
                    list.add(Long.valueOf(this.a.n()));
                } while (this.a.B() < B2);
                return;
            }
            throw zzfo.f();
        }
        do {
            list.add(Long.valueOf(this.a.n()));
            if (this.a.A()) {
                return;
            } else {
                a = this.a.a();
            }
        } while (a == this.f17297b);
        this.f17299d = a;
    }

    @Override // com.google.android.gms.internal.measurement.q3
    public final void H(List<Double> list) throws IOException {
        int a;
        int a2;
        if (list instanceof b2) {
            b2 b2Var = (b2) list;
            int i2 = this.f17297b & 7;
            if (i2 != 1) {
                if (i2 == 2) {
                    int t = this.a.t();
                    S(t);
                    int B = this.a.B() + t;
                    do {
                        b2Var.f(this.a.e());
                    } while (this.a.B() < B);
                    return;
                }
                throw zzfo.f();
            }
            do {
                b2Var.f(this.a.e());
                if (this.a.A()) {
                    return;
                } else {
                    a2 = this.a.a();
                }
            } while (a2 == this.f17297b);
            this.f17299d = a2;
            return;
        }
        int i3 = this.f17297b & 7;
        if (i3 != 1) {
            if (i3 == 2) {
                int t2 = this.a.t();
                S(t2);
                int B2 = this.a.B() + t2;
                do {
                    list.add(Double.valueOf(this.a.e()));
                } while (this.a.B() < B2);
                return;
            }
            throw zzfo.f();
        }
        do {
            list.add(Double.valueOf(this.a.e()));
            if (this.a.A()) {
                return;
            } else {
                a = this.a.a();
            }
        } while (a == this.f17297b);
        this.f17299d = a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.measurement.q3
    public final <T> void I(List<T> list, p3<T> p3Var, zzeq zzeqVar) throws IOException {
        int a;
        int i2 = this.f17297b;
        if ((i2 & 7) != 3) {
            throw zzfo.f();
        }
        do {
            list.add(V(p3Var, zzeqVar));
            if (this.a.A() || this.f17299d != 0) {
                return;
            } else {
                a = this.a.a();
            }
        } while (a == i2);
        this.f17299d = a;
    }

    @Override // com.google.android.gms.internal.measurement.q3
    public final <T> T J(p3<T> p3Var, zzeq zzeqVar) throws IOException {
        Q(2);
        return (T) T(p3Var, zzeqVar);
    }

    @Override // com.google.android.gms.internal.measurement.q3
    public final <T> T K(p3<T> p3Var, zzeq zzeqVar) throws IOException {
        Q(3);
        return (T) V(p3Var, zzeqVar);
    }

    @Override // com.google.android.gms.internal.measurement.q3
    public final void L(List<Integer> list) throws IOException {
        int a;
        int a2;
        if (list instanceof n2) {
            n2 n2Var = (n2) list;
            int i2 = this.f17297b & 7;
            if (i2 != 0) {
                if (i2 == 2) {
                    int B = this.a.B() + this.a.t();
                    do {
                        n2Var.h(this.a.m());
                    } while (this.a.B() < B);
                    W(B);
                    return;
                }
                throw zzfo.f();
            }
            do {
                n2Var.h(this.a.m());
                if (this.a.A()) {
                    return;
                } else {
                    a2 = this.a.a();
                }
            } while (a2 == this.f17297b);
            this.f17299d = a2;
            return;
        }
        int i3 = this.f17297b & 7;
        if (i3 != 0) {
            if (i3 == 2) {
                int B2 = this.a.B() + this.a.t();
                do {
                    list.add(Integer.valueOf(this.a.m()));
                } while (this.a.B() < B2);
                W(B2);
                return;
            }
            throw zzfo.f();
        }
        do {
            list.add(Integer.valueOf(this.a.m()));
            if (this.a.A()) {
                return;
            } else {
                a = this.a.a();
            }
        } while (a == this.f17297b);
        this.f17299d = a;
    }

    @Override // com.google.android.gms.internal.measurement.q3
    public final void M(List<Long> list) throws IOException {
        int a;
        int a2;
        if (list instanceof w2) {
            w2 w2Var = (w2) list;
            int i2 = this.f17297b & 7;
            if (i2 != 0) {
                if (i2 == 2) {
                    int B = this.a.B() + this.a.t();
                    do {
                        w2Var.G0(this.a.l());
                    } while (this.a.B() < B);
                    W(B);
                    return;
                }
                throw zzfo.f();
            }
            do {
                w2Var.G0(this.a.l());
                if (this.a.A()) {
                    return;
                } else {
                    a2 = this.a.a();
                }
            } while (a2 == this.f17297b);
            this.f17299d = a2;
            return;
        }
        int i3 = this.f17297b & 7;
        if (i3 != 0) {
            if (i3 == 2) {
                int B2 = this.a.B() + this.a.t();
                do {
                    list.add(Long.valueOf(this.a.l()));
                } while (this.a.B() < B2);
                W(B2);
                return;
            }
            throw zzfo.f();
        }
        do {
            list.add(Long.valueOf(this.a.l()));
            if (this.a.A()) {
                return;
            } else {
                a = this.a.a();
            }
        } while (a == this.f17297b);
        this.f17299d = a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.measurement.q3
    public final <T> void N(List<T> list, p3<T> p3Var, zzeq zzeqVar) throws IOException {
        int a;
        int i2 = this.f17297b;
        if ((i2 & 7) != 2) {
            throw zzfo.f();
        }
        do {
            list.add(T(p3Var, zzeqVar));
            if (this.a.A() || this.f17299d != 0) {
                return;
            } else {
                a = this.a.a();
            }
        } while (a == i2);
        this.f17299d = a;
    }

    @Override // com.google.android.gms.internal.measurement.q3
    public final boolean O() throws IOException {
        Q(0);
        return this.a.p();
    }

    @Override // com.google.android.gms.internal.measurement.q3
    public final int a() throws IOException {
        int i2 = this.f17299d;
        if (i2 != 0) {
            this.f17297b = i2;
            this.f17299d = 0;
        } else {
            this.f17297b = this.a.a();
        }
        int i3 = this.f17297b;
        if (i3 == 0 || i3 == this.f17298c) {
            return Integer.MAX_VALUE;
        }
        return i3 >>> 3;
    }

    @Override // com.google.android.gms.internal.measurement.q3
    public final int b() {
        return this.f17297b;
    }

    @Override // com.google.android.gms.internal.measurement.q3
    public final boolean c() throws IOException {
        int i2;
        if (this.a.A() || (i2 = this.f17297b) == this.f17298c) {
            return false;
        }
        return this.a.f(i2);
    }

    @Override // com.google.android.gms.internal.measurement.q3
    public final double d() throws IOException {
        Q(1);
        return this.a.e();
    }

    @Override // com.google.android.gms.internal.measurement.q3
    public final float e() throws IOException {
        Q(5);
        return this.a.g();
    }

    @Override // com.google.android.gms.internal.measurement.q3
    public final zzdu f() throws IOException {
        Q(2);
        return this.a.s();
    }

    @Override // com.google.android.gms.internal.measurement.q3
    public final int g() throws IOException {
        Q(5);
        return this.a.v();
    }

    @Override // com.google.android.gms.internal.measurement.q3
    public final long h() throws IOException {
        Q(1);
        return this.a.w();
    }

    @Override // com.google.android.gms.internal.measurement.q3
    public final void i(List<Integer> list) throws IOException {
        int a;
        int a2;
        if (list instanceof n2) {
            n2 n2Var = (n2) list;
            int i2 = this.f17297b & 7;
            if (i2 != 0) {
                if (i2 == 2) {
                    int B = this.a.B() + this.a.t();
                    do {
                        n2Var.h(this.a.x());
                    } while (this.a.B() < B);
                    W(B);
                    return;
                }
                throw zzfo.f();
            }
            do {
                n2Var.h(this.a.x());
                if (this.a.A()) {
                    return;
                } else {
                    a2 = this.a.a();
                }
            } while (a2 == this.f17297b);
            this.f17299d = a2;
            return;
        }
        int i3 = this.f17297b & 7;
        if (i3 != 0) {
            if (i3 == 2) {
                int B2 = this.a.B() + this.a.t();
                do {
                    list.add(Integer.valueOf(this.a.x()));
                } while (this.a.B() < B2);
                W(B2);
                return;
            }
            throw zzfo.f();
        }
        do {
            list.add(Integer.valueOf(this.a.x()));
            if (this.a.A()) {
                return;
            } else {
                a = this.a.a();
            }
        } while (a == this.f17297b);
        this.f17299d = a;
    }

    @Override // com.google.android.gms.internal.measurement.q3
    public final String j() throws IOException {
        Q(2);
        return this.a.r();
    }

    @Override // com.google.android.gms.internal.measurement.q3
    public final int k() throws IOException {
        Q(0);
        return this.a.u();
    }

    @Override // com.google.android.gms.internal.measurement.q3
    public final long l() throws IOException {
        Q(1);
        return this.a.n();
    }

    @Override // com.google.android.gms.internal.measurement.q3
    public final int m() throws IOException {
        Q(0);
        return this.a.m();
    }

    @Override // com.google.android.gms.internal.measurement.q3
    public final void n(List<Long> list) throws IOException {
        int a;
        int a2;
        if (list instanceof w2) {
            w2 w2Var = (w2) list;
            int i2 = this.f17297b & 7;
            if (i2 != 1) {
                if (i2 == 2) {
                    int t = this.a.t();
                    S(t);
                    int B = this.a.B() + t;
                    do {
                        w2Var.G0(this.a.w());
                    } while (this.a.B() < B);
                    return;
                }
                throw zzfo.f();
            }
            do {
                w2Var.G0(this.a.w());
                if (this.a.A()) {
                    return;
                } else {
                    a2 = this.a.a();
                }
            } while (a2 == this.f17297b);
            this.f17299d = a2;
            return;
        }
        int i3 = this.f17297b & 7;
        if (i3 != 1) {
            if (i3 == 2) {
                int t2 = this.a.t();
                S(t2);
                int B2 = this.a.B() + t2;
                do {
                    list.add(Long.valueOf(this.a.w()));
                } while (this.a.B() < B2);
                return;
            }
            throw zzfo.f();
        }
        do {
            list.add(Long.valueOf(this.a.w()));
            if (this.a.A()) {
                return;
            } else {
                a = this.a.a();
            }
        } while (a == this.f17297b);
        this.f17299d = a;
    }

    @Override // com.google.android.gms.internal.measurement.q3
    public final void o(List<String> list) throws IOException {
        R(list, true);
    }

    @Override // com.google.android.gms.internal.measurement.q3
    public final int p() throws IOException {
        Q(0);
        return this.a.t();
    }

    @Override // com.google.android.gms.internal.measurement.q3
    public final long q() throws IOException {
        Q(0);
        return this.a.i();
    }

    @Override // com.google.android.gms.internal.measurement.q3
    public final void r(List<String> list) throws IOException {
        R(list, false);
    }

    @Override // com.google.android.gms.internal.measurement.q3
    public final long s() throws IOException {
        Q(0);
        return this.a.l();
    }

    @Override // com.google.android.gms.internal.measurement.q3
    public final void t(List<Long> list) throws IOException {
        int a;
        int a2;
        if (list instanceof w2) {
            w2 w2Var = (w2) list;
            int i2 = this.f17297b & 7;
            if (i2 != 0) {
                if (i2 == 2) {
                    int B = this.a.B() + this.a.t();
                    do {
                        w2Var.G0(this.a.y());
                    } while (this.a.B() < B);
                    W(B);
                    return;
                }
                throw zzfo.f();
            }
            do {
                w2Var.G0(this.a.y());
                if (this.a.A()) {
                    return;
                } else {
                    a2 = this.a.a();
                }
            } while (a2 == this.f17297b);
            this.f17299d = a2;
            return;
        }
        int i3 = this.f17297b & 7;
        if (i3 != 0) {
            if (i3 == 2) {
                int B2 = this.a.B() + this.a.t();
                do {
                    list.add(Long.valueOf(this.a.y()));
                } while (this.a.B() < B2);
                W(B2);
                return;
            }
            throw zzfo.f();
        }
        do {
            list.add(Long.valueOf(this.a.y()));
            if (this.a.A()) {
                return;
            } else {
                a = this.a.a();
            }
        } while (a == this.f17297b);
        this.f17299d = a;
    }

    @Override // com.google.android.gms.internal.measurement.q3
    public final void u(List<Integer> list) throws IOException {
        int a;
        int a2;
        if (list instanceof n2) {
            n2 n2Var = (n2) list;
            int i2 = this.f17297b & 7;
            if (i2 != 0) {
                if (i2 == 2) {
                    int B = this.a.B() + this.a.t();
                    do {
                        n2Var.h(this.a.t());
                    } while (this.a.B() < B);
                    W(B);
                    return;
                }
                throw zzfo.f();
            }
            do {
                n2Var.h(this.a.t());
                if (this.a.A()) {
                    return;
                } else {
                    a2 = this.a.a();
                }
            } while (a2 == this.f17297b);
            this.f17299d = a2;
            return;
        }
        int i3 = this.f17297b & 7;
        if (i3 != 0) {
            if (i3 == 2) {
                int B2 = this.a.B() + this.a.t();
                do {
                    list.add(Integer.valueOf(this.a.t()));
                } while (this.a.B() < B2);
                W(B2);
                return;
            }
            throw zzfo.f();
        }
        do {
            list.add(Integer.valueOf(this.a.t()));
            if (this.a.A()) {
                return;
            } else {
                a = this.a.a();
            }
        } while (a == this.f17297b);
        this.f17299d = a;
    }

    @Override // com.google.android.gms.internal.measurement.q3
    public final void u0(List<Long> list) throws IOException {
        int a;
        int a2;
        if (list instanceof w2) {
            w2 w2Var = (w2) list;
            int i2 = this.f17297b & 7;
            if (i2 != 0) {
                if (i2 == 2) {
                    int B = this.a.B() + this.a.t();
                    do {
                        w2Var.G0(this.a.i());
                    } while (this.a.B() < B);
                    W(B);
                    return;
                }
                throw zzfo.f();
            }
            do {
                w2Var.G0(this.a.i());
                if (this.a.A()) {
                    return;
                } else {
                    a2 = this.a.a();
                }
            } while (a2 == this.f17297b);
            this.f17299d = a2;
            return;
        }
        int i3 = this.f17297b & 7;
        if (i3 != 0) {
            if (i3 == 2) {
                int B2 = this.a.B() + this.a.t();
                do {
                    list.add(Long.valueOf(this.a.i()));
                } while (this.a.B() < B2);
                W(B2);
                return;
            }
            throw zzfo.f();
        }
        do {
            list.add(Long.valueOf(this.a.i()));
            if (this.a.A()) {
                return;
            } else {
                a = this.a.a();
            }
        } while (a == this.f17297b);
        this.f17299d = a;
    }

    @Override // com.google.android.gms.internal.measurement.q3
    public final int v() throws IOException {
        Q(5);
        return this.a.o();
    }

    @Override // com.google.android.gms.internal.measurement.q3
    public final String w() throws IOException {
        Q(2);
        return this.a.q();
    }

    @Override // com.google.android.gms.internal.measurement.q3
    public final int x() throws IOException {
        Q(0);
        return this.a.x();
    }

    @Override // com.google.android.gms.internal.measurement.q3
    public final long y() throws IOException {
        Q(0);
        return this.a.y();
    }

    @Override // com.google.android.gms.internal.measurement.q3
    public final void z(List<zzdu> list) throws IOException {
        int a;
        if ((this.f17297b & 7) != 2) {
            throw zzfo.f();
        }
        do {
            list.add(f());
            if (this.a.A()) {
                return;
            } else {
                a = this.a.a();
            }
        } while (a == this.f17297b);
        this.f17299d = a;
    }
}
