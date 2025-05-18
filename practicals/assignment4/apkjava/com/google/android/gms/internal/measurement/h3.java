package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzfd;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.2.0 */
/* loaded from: classes2.dex */
final class h3<T> implements p3<T> {
    private final zzgo a;

    /* renamed from: b, reason: collision with root package name */
    private final h4<?, ?> f17171b;

    /* renamed from: c, reason: collision with root package name */
    private final boolean f17172c;

    /* renamed from: d, reason: collision with root package name */
    private final d2<?> f17173d;

    private h3(h4<?, ?> h4Var, d2<?> d2Var, zzgo zzgoVar) {
        this.f17171b = h4Var;
        this.f17172c = d2Var.h(zzgoVar);
        this.f17173d = d2Var;
        this.a = zzgoVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> h3<T> k(h4<?, ?> h4Var, d2<?> d2Var, zzgo zzgoVar) {
        return new h3<>(h4Var, d2Var, zzgoVar);
    }

    @Override // com.google.android.gms.internal.measurement.p3
    public final T a() {
        return (T) this.a.f().x();
    }

    @Override // com.google.android.gms.internal.measurement.p3
    public final int b(T t) {
        h4<?, ?> h4Var = this.f17171b;
        int r = h4Var.r(h4Var.k(t)) + 0;
        return this.f17172c ? r + this.f17173d.b(t).r() : r;
    }

    @Override // com.google.android.gms.internal.measurement.p3
    public final int c(T t) {
        int hashCode = this.f17171b.k(t).hashCode();
        return this.f17172c ? (hashCode * 53) + this.f17173d.b(t).hashCode() : hashCode;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0099 A[EDGE_INSN: B:24:0x0099->B:25:0x0099 BREAK  A[LOOP:1: B:10:0x0053->B:18:0x0053], SYNTHETIC] */
    @Override // com.google.android.gms.internal.measurement.p3
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void d(T t, byte[] bArr, int i2, int i3, m1 m1Var) throws IOException {
        zzfd zzfdVar = (zzfd) t;
        zzhy zzhyVar = zzfdVar.zzb;
        if (zzhyVar == zzhy.a()) {
            zzhyVar = zzhy.g();
            zzfdVar.zzb = zzhyVar;
        }
        ((zzfd.zzd) t).B();
        zzfd.zzf zzfVar = null;
        while (i2 < i3) {
            int i4 = j1.i(bArr, i2, m1Var);
            int i5 = m1Var.a;
            if (i5 == 11) {
                int i6 = 0;
                zzdu zzduVar = null;
                while (i4 < i3) {
                    i4 = j1.i(bArr, i4, m1Var);
                    int i7 = m1Var.a;
                    int i8 = i7 >>> 3;
                    int i9 = i7 & 7;
                    if (i8 != 2) {
                        if (i8 == 3) {
                            if (zzfVar != null) {
                                l3.a();
                                throw new NoSuchMethodError();
                            }
                            if (i9 == 2) {
                                i4 = j1.q(bArr, i4, m1Var);
                                zzduVar = (zzdu) m1Var.f17219c;
                            }
                        }
                        if (i7 != 12) {
                            break;
                        } else {
                            i4 = j1.a(i7, bArr, i4, i3, m1Var);
                        }
                    } else if (i9 == 0) {
                        i4 = j1.i(bArr, i4, m1Var);
                        i6 = m1Var.a;
                        zzfVar = (zzfd.zzf) this.f17173d.c(m1Var.f17220d, this.a, i6);
                    } else if (i7 != 12) {
                    }
                }
                if (zzduVar != null) {
                    zzhyVar.c((i6 << 3) | 2, zzduVar);
                }
                i2 = i4;
            } else if ((i5 & 7) == 2) {
                zzfVar = (zzfd.zzf) this.f17173d.c(m1Var.f17220d, this.a, i5 >>> 3);
                if (zzfVar == null) {
                    i2 = j1.c(i5, bArr, i4, i3, zzhyVar, m1Var);
                } else {
                    l3.a();
                    throw new NoSuchMethodError();
                }
            } else {
                i2 = j1.a(i5, bArr, i4, i3, m1Var);
            }
        }
        if (i2 != i3) {
            throw zzfo.g();
        }
    }

    @Override // com.google.android.gms.internal.measurement.p3
    public final boolean e(T t) {
        return this.f17173d.b(t).q();
    }

    @Override // com.google.android.gms.internal.measurement.p3
    public final void f(T t) {
        this.f17171b.q(t);
        this.f17173d.j(t);
    }

    @Override // com.google.android.gms.internal.measurement.p3
    public final boolean g(T t, T t2) {
        if (!this.f17171b.k(t).equals(this.f17171b.k(t2))) {
            return false;
        }
        if (this.f17172c) {
            return this.f17173d.b(t).equals(this.f17173d.b(t2));
        }
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.p3
    public final void h(T t, y4 y4Var) throws IOException {
        Iterator<Map.Entry<?, Object>> o = this.f17173d.b(t).o();
        while (o.hasNext()) {
            Map.Entry<?, Object> next = o.next();
            zzey zzeyVar = (zzey) next.getKey();
            if (zzeyVar.c() == zzip.MESSAGE && !zzeyVar.d() && !zzeyVar.e()) {
                if (next instanceof o2) {
                    y4Var.f(zzeyVar.a(), ((o2) next).a().d());
                } else {
                    y4Var.f(zzeyVar.a(), next.getValue());
                }
            } else {
                throw new IllegalStateException("Found invalid MessageSet item.");
            }
        }
        h4<?, ?> h4Var = this.f17171b;
        h4Var.m(h4Var.k(t), y4Var);
    }

    @Override // com.google.android.gms.internal.measurement.p3
    public final void i(T t, q3 q3Var, zzeq zzeqVar) throws IOException {
        boolean z;
        h4<?, ?> h4Var = this.f17171b;
        d2<?> d2Var = this.f17173d;
        Object o = h4Var.o(t);
        h2<?> i2 = d2Var.i(t);
        do {
            try {
                if (q3Var.a() == Integer.MAX_VALUE) {
                    return;
                }
                int b2 = q3Var.b();
                if (b2 == 11) {
                    int i3 = 0;
                    Object obj = null;
                    zzdu zzduVar = null;
                    while (q3Var.a() != Integer.MAX_VALUE) {
                        int b3 = q3Var.b();
                        if (b3 == 16) {
                            i3 = q3Var.p();
                            obj = d2Var.c(zzeqVar, this.a, i3);
                        } else if (b3 == 26) {
                            if (obj != null) {
                                d2Var.f(q3Var, obj, zzeqVar, i2);
                            } else {
                                zzduVar = q3Var.f();
                            }
                        } else if (!q3Var.c()) {
                            break;
                        }
                    }
                    if (q3Var.b() != 12) {
                        throw zzfo.e();
                    }
                    if (zzduVar != null) {
                        if (obj != null) {
                            d2Var.e(zzduVar, obj, zzeqVar, i2);
                        } else {
                            h4Var.e(o, i3, zzduVar);
                        }
                    }
                } else if ((b2 & 7) == 2) {
                    Object c2 = d2Var.c(zzeqVar, this.a, b2 >>> 3);
                    if (c2 != null) {
                        d2Var.f(q3Var, c2, zzeqVar, i2);
                    } else {
                        z = h4Var.j(o, q3Var);
                    }
                } else {
                    z = q3Var.c();
                }
                z = true;
            } finally {
                h4Var.n(t, o);
            }
        } while (z);
    }

    @Override // com.google.android.gms.internal.measurement.p3
    public final void j(T t, T t2) {
        r3.o(this.f17171b, t, t2);
        if (this.f17172c) {
            r3.m(this.f17173d, t, t2);
        }
    }
}
