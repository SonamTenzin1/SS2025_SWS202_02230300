package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdob;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes2.dex */
final class bw<T> implements lw<T> {
    private final zzdpk a;

    /* renamed from: b, reason: collision with root package name */
    private final cx<?, ?> f12369b;

    /* renamed from: c, reason: collision with root package name */
    private final boolean f12370c;

    /* renamed from: d, reason: collision with root package name */
    private final vu<?> f12371d;

    private bw(cx<?, ?> cxVar, vu<?> vuVar, zzdpk zzdpkVar) {
        this.f12369b = cxVar;
        this.f12370c = vuVar.h(zzdpkVar);
        this.f12371d = vuVar;
        this.a = zzdpkVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> bw<T> k(cx<?, ?> cxVar, vu<?> vuVar, zzdpk zzdpkVar) {
        return new bw<>(cxVar, vuVar, zzdpkVar);
    }

    @Override // com.google.android.gms.internal.ads.lw
    public final void a(T t, T t2) {
        nw.h(this.f12369b, t, t2);
        if (this.f12370c) {
            nw.f(this.f12371d, t, t2);
        }
    }

    @Override // com.google.android.gms.internal.ads.lw
    public final boolean b(T t, T t2) {
        if (!this.f12369b.j(t).equals(this.f12369b.j(t2))) {
            return false;
        }
        if (this.f12370c) {
            return this.f12371d.i(t).equals(this.f12371d.i(t2));
        }
        return true;
    }

    @Override // com.google.android.gms.internal.ads.lw
    public final T c() {
        return (T) this.a.d().a1();
    }

    @Override // com.google.android.gms.internal.ads.lw
    public final int d(T t) {
        int hashCode = this.f12369b.j(t).hashCode();
        return this.f12370c ? (hashCode * 53) + this.f12371d.i(t).hashCode() : hashCode;
    }

    @Override // com.google.android.gms.internal.ads.lw
    public final void e(T t, ux uxVar) throws IOException {
        Iterator<Map.Entry<?, Object>> e2 = this.f12371d.i(t).e();
        while (e2.hasNext()) {
            Map.Entry<?, Object> next = e2.next();
            zzdnu zzdnuVar = (zzdnu) next.getKey();
            if (zzdnuVar.s() == zzdrn.MESSAGE && !zzdnuVar.t() && !zzdnuVar.w()) {
                if (next instanceof iv) {
                    uxVar.G(zzdnuVar.i(), ((iv) next).a().a());
                } else {
                    uxVar.G(zzdnuVar.i(), next.getValue());
                }
            } else {
                throw new IllegalStateException("Found invalid MessageSet item.");
            }
        }
        cx<?, ?> cxVar = this.f12369b;
        cxVar.p(cxVar.j(t), uxVar);
    }

    @Override // com.google.android.gms.internal.ads.lw
    public final void f(T t) {
        this.f12369b.g(t);
        this.f12371d.g(t);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00a8 A[EDGE_INSN: B:27:0x00a8->B:28:0x00a8 BREAK  A[LOOP:1: B:13:0x0062->B:21:0x0062], SYNTHETIC] */
    @Override // com.google.android.gms.internal.ads.lw
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void g(T t, byte[] bArr, int i2, int i3, bu buVar) throws IOException {
        zzdob zzdobVar = (zzdob) t;
        zzdqu zzdquVar = zzdobVar.zzhhd;
        if (zzdquVar == zzdqu.f()) {
            zzdquVar = zzdqu.i();
            zzdobVar.zzhhd = zzdquVar;
        }
        zzdob.zzc zzcVar = (zzdob.zzc) t;
        if (zzcVar.zzhhj.c()) {
            zzcVar.zzhhj = (yu) zzcVar.zzhhj.clone();
        }
        zzdob.zzd zzdVar = null;
        while (i2 < i3) {
            int h2 = au.h(bArr, i2, buVar);
            int i4 = buVar.a;
            if (i4 == 11) {
                int i5 = 0;
                zzdmr zzdmrVar = null;
                while (h2 < i3) {
                    h2 = au.h(bArr, h2, buVar);
                    int i6 = buVar.a;
                    int i7 = i6 >>> 3;
                    int i8 = i6 & 7;
                    if (i7 != 2) {
                        if (i7 == 3) {
                            if (zzdVar != null) {
                                gw.b();
                                throw new NoSuchMethodError();
                            }
                            if (i8 == 2) {
                                h2 = au.m(bArr, h2, buVar);
                                zzdmrVar = (zzdmr) buVar.f12361c;
                            }
                        }
                        if (i6 != 12) {
                            break;
                        } else {
                            h2 = au.a(i6, bArr, h2, i3, buVar);
                        }
                    } else if (i8 == 0) {
                        h2 = au.h(bArr, h2, buVar);
                        i5 = buVar.a;
                        zzdVar = (zzdob.zzd) this.f12371d.b(buVar.f12362d, this.a, i5);
                    } else if (i6 != 12) {
                    }
                }
                if (zzdmrVar != null) {
                    zzdquVar.k((i5 << 3) | 2, zzdmrVar);
                }
                i2 = h2;
            } else if ((i4 & 7) == 2) {
                zzdVar = (zzdob.zzd) this.f12371d.b(buVar.f12362d, this.a, i4 >>> 3);
                if (zzdVar == null) {
                    i2 = au.c(i4, bArr, h2, i3, zzdquVar, buVar);
                } else {
                    gw.b();
                    throw new NoSuchMethodError();
                }
            } else {
                i2 = au.a(i4, bArr, h2, i3, buVar);
            }
        }
        if (i2 != i3) {
            throw zzdok.g();
        }
    }

    @Override // com.google.android.gms.internal.ads.lw
    public final void h(T t, kw kwVar, zzdno zzdnoVar) throws IOException {
        boolean z;
        cx<?, ?> cxVar = this.f12369b;
        vu<?> vuVar = this.f12371d;
        Object k2 = cxVar.k(t);
        yu<?> j2 = vuVar.j(t);
        do {
            try {
                if (kwVar.N() == Integer.MAX_VALUE) {
                    return;
                }
                int tag = kwVar.getTag();
                if (tag == 11) {
                    int i2 = 0;
                    Object obj = null;
                    zzdmr zzdmrVar = null;
                    while (kwVar.N() != Integer.MAX_VALUE) {
                        int tag2 = kwVar.getTag();
                        if (tag2 == 16) {
                            i2 = kwVar.V();
                            obj = vuVar.b(zzdnoVar, this.a, i2);
                        } else if (tag2 == 26) {
                            if (obj != null) {
                                vuVar.e(kwVar, obj, zzdnoVar, j2);
                            } else {
                                zzdmrVar = kwVar.T();
                            }
                        } else if (!kwVar.S()) {
                            break;
                        }
                    }
                    if (kwVar.getTag() != 12) {
                        throw zzdok.e();
                    }
                    if (zzdmrVar != null) {
                        if (obj != null) {
                            vuVar.d(zzdmrVar, obj, zzdnoVar, j2);
                        } else {
                            cxVar.b(k2, i2, zzdmrVar);
                        }
                    }
                } else if ((tag & 7) == 2) {
                    Object b2 = vuVar.b(zzdnoVar, this.a, tag >>> 3);
                    if (b2 != null) {
                        vuVar.e(kwVar, b2, zzdnoVar, j2);
                    } else {
                        z = cxVar.f(k2, kwVar);
                    }
                } else {
                    z = kwVar.S();
                }
                z = true;
            } finally {
                cxVar.r(t, k2);
            }
        } while (z);
    }

    @Override // com.google.android.gms.internal.ads.lw
    public final int i(T t) {
        cx<?, ?> cxVar = this.f12369b;
        int l = cxVar.l(cxVar.j(t)) + 0;
        return this.f12370c ? l + this.f12371d.i(t).o() : l;
    }

    @Override // com.google.android.gms.internal.ads.lw
    public final boolean j(T t) {
        return this.f12371d.i(t).d();
    }
}
