package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Stack;

/* loaded from: classes2.dex */
public final class zziv implements zzid, zzio {

    /* renamed from: f, reason: collision with root package name */
    private long f16326f;

    /* renamed from: g, reason: collision with root package name */
    private int f16327g;

    /* renamed from: h, reason: collision with root package name */
    private long f16328h;

    /* renamed from: i, reason: collision with root package name */
    private int f16329i;

    /* renamed from: j, reason: collision with root package name */
    private zzkm f16330j;

    /* renamed from: k, reason: collision with root package name */
    private int f16331k;
    private int l;
    private int m;
    private zzif n;
    private yz[] o;

    /* renamed from: c, reason: collision with root package name */
    private final zzkm f16323c = new zzkm(16);

    /* renamed from: d, reason: collision with root package name */
    private final Stack<zzir> f16324d = new Stack<>();
    private final zzkm a = new zzkm(zzkj.a);

    /* renamed from: b, reason: collision with root package name */
    private final zzkm f16322b = new zzkm(4);

    /* renamed from: e, reason: collision with root package name */
    private int f16325e = 0;

    @Override // com.google.android.gms.internal.ads.zzio
    public final long a(long j2) {
        int i2;
        long j3 = Long.MAX_VALUE;
        int i3 = 0;
        while (true) {
            yz[] yzVarArr = this.o;
            if (i3 >= yzVarArr.length) {
                return j3;
            }
            zz zzVar = yzVarArr[i3].f13664b;
            int a = zzkq.a(zzVar.f13727d, j2, true, false);
            while (true) {
                i2 = -1;
                if (a < 0) {
                    a = -1;
                    break;
                }
                if (zzVar.f13727d[a] <= j2 && (zzVar.f13728e[a] & 1) != 0) {
                    break;
                }
                a--;
            }
            if (a == -1) {
                int h2 = zzkq.h(zzVar.f13727d, j2, true, false);
                while (true) {
                    long[] jArr = zzVar.f13727d;
                    if (h2 < jArr.length) {
                        if (jArr[h2] >= j2 && (zzVar.f13728e[h2] & 1) != 0) {
                            i2 = h2;
                            break;
                        }
                        h2++;
                    } else {
                        break;
                    }
                }
                a = i2;
            }
            yz[] yzVarArr2 = this.o;
            yzVarArr2[i3].f13666d = a;
            long j4 = zzVar.f13725b[yzVarArr2[i3].f13666d];
            if (j4 < j3) {
                j3 = j4;
            }
            i3++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzio
    public final boolean b() {
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzid
    public final int c(zzie zzieVar, zzij zzijVar) throws IOException, InterruptedException {
        yz[] yzVarArr;
        int i2;
        long j2;
        zzir zzirVar;
        boolean z;
        zziv zzivVar;
        ArrayList arrayList;
        int i3;
        zzix a;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        long n;
        zzkm zzkmVar;
        zzkm zzkmVar2;
        int i13;
        zzkm zzkmVar3;
        int i14;
        int i15;
        int i16;
        boolean z2;
        zziv zzivVar2 = this;
        zzie zzieVar2 = zzieVar;
        zzij zzijVar2 = zzijVar;
        while (true) {
            int i17 = zzivVar2.f16325e;
            if (i17 == 0) {
                zziv zzivVar3 = zzivVar2;
                if (zzieVar.b(zzivVar3.f16323c.a, 0, 8, true)) {
                    zzivVar3.f16323c.g(0);
                    zzivVar3.f16328h = zzivVar3.f16323c.k();
                    zzivVar3.f16327g = zzivVar3.f16323c.c();
                    if (zzivVar3.f16328h == 1) {
                        zzieVar.readFully(zzivVar3.f16323c.a, 8, 8);
                        zzivVar3.f16328h = zzivVar3.f16323c.d();
                        zzivVar3.f16326f += 16;
                        zzivVar3.f16329i = 16;
                    } else {
                        zzivVar3.f16326f += 8;
                        zzivVar3.f16329i = 8;
                    }
                    int i18 = zzivVar3.f16327g;
                    if (i18 == vz.p || i18 == vz.r || i18 == vz.s || i18 == vz.t || i18 == vz.u) {
                        if (zzivVar3.f16328h == 1) {
                            zzivVar3.f16324d.add(new zzir(zzivVar3.f16327g, (zzivVar3.f16326f + zzivVar3.f16328h) - zzivVar3.f16329i));
                        } else {
                            zzivVar3.f16324d.add(new zzir(zzivVar3.f16327g, (zzivVar3.f16326f + zzivVar3.f16328h) - zzivVar3.f16329i));
                        }
                        zzivVar3.f16325e = 0;
                    } else {
                        if (i18 == vz.A || i18 == vz.q || i18 == vz.B || i18 == vz.Q || i18 == vz.R || i18 == vz.C || i18 == vz.f13474b || i18 == vz.v || i18 == vz.f13478f || i18 == vz.f13476d || i18 == vz.T || i18 == vz.U || i18 == vz.V || i18 == vz.W || i18 == vz.X || i18 == vz.Y || i18 == vz.Z || i18 == vz.z) {
                            zzkh.d(zzivVar3.f16328h < 2147483647L);
                            zzkm zzkmVar4 = new zzkm((int) zzivVar3.f16328h);
                            zzivVar3.f16330j = zzkmVar4;
                            System.arraycopy(zzivVar3.f16323c.a, 0, zzkmVar4.a, 0, 8);
                            zzivVar3.f16325e = 1;
                        } else {
                            zzivVar3.f16330j = null;
                            zzivVar3.f16325e = 1;
                        }
                    }
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (!z2) {
                    return -1;
                }
                zzijVar2 = zzijVar;
                zzivVar2 = zzivVar3;
                zzieVar2 = zzieVar;
            } else {
                if (i17 != 1) {
                    long j3 = Long.MAX_VALUE;
                    int i19 = 0;
                    int i20 = -1;
                    while (true) {
                        yzVarArr = zzivVar2.o;
                        if (i19 >= yzVarArr.length) {
                            break;
                        }
                        yz yzVar = yzVarArr[i19];
                        int i21 = yzVar.f13666d;
                        zz zzVar = yzVar.f13664b;
                        if (i21 != zzVar.a) {
                            long j4 = zzVar.f13725b[i21];
                            if (j4 < j3) {
                                i20 = i19;
                                j3 = j4;
                            }
                        }
                        i19++;
                    }
                    if (i20 == -1) {
                        return -1;
                    }
                    yz yzVar2 = yzVarArr[i20];
                    int i22 = yzVar2.f13666d;
                    long j5 = yzVar2.f13664b.f13725b[i22];
                    long position = (j5 - zzieVar.getPosition()) + zzivVar2.l;
                    if (position < 0) {
                        i2 = 1;
                        j2 = j5;
                    } else {
                        if (position < 262144) {
                            zzieVar2.a((int) position);
                            zzivVar2.f16331k = yzVar2.f13664b.f13726c[i22];
                            int i23 = yzVar2.a.f16337g;
                            if (i23 == -1) {
                                while (true) {
                                    int i24 = zzivVar2.l;
                                    int i25 = zzivVar2.f16331k;
                                    if (i24 >= i25) {
                                        break;
                                    }
                                    int a2 = yzVar2.f13665c.a(zzieVar2, i25 - i24);
                                    zzivVar2.l += a2;
                                    zzivVar2.m -= a2;
                                }
                            } else {
                                byte[] bArr = zzivVar2.f16322b.a;
                                bArr[0] = 0;
                                bArr[1] = 0;
                                bArr[2] = 0;
                                int i26 = 4 - i23;
                                while (zzivVar2.l < zzivVar2.f16331k) {
                                    int i27 = zzivVar2.m;
                                    if (i27 == 0) {
                                        zzieVar2.readFully(zzivVar2.f16322b.a, i26, i23);
                                        zzivVar2.f16322b.g(0);
                                        zzivVar2.m = zzivVar2.f16322b.m();
                                        zzivVar2.a.g(0);
                                        yzVar2.f13665c.c(zzivVar2.a, 4);
                                        zzivVar2.l += 4;
                                        zzivVar2.f16331k += i26;
                                    } else {
                                        int a3 = yzVar2.f13665c.a(zzieVar2, i27);
                                        zzivVar2.l += a3;
                                        zzivVar2.m -= a3;
                                    }
                                }
                            }
                            zzip zzipVar = yzVar2.f13665c;
                            zz zzVar2 = yzVar2.f13664b;
                            zzipVar.d(zzVar2.f13727d[i22], zzVar2.f13728e[i22], zzivVar2.f16331k, 0, null);
                            yzVar2.f13666d++;
                            zzivVar2.l = 0;
                            zzivVar2.m = 0;
                            return 0;
                        }
                        j2 = j5;
                        i2 = 1;
                    }
                    zzijVar2.a = j2;
                    return i2;
                }
                zzivVar2.f16325e = 0;
                long j6 = zzivVar2.f16326f;
                long j7 = zzivVar2.f16328h;
                int i28 = zzivVar2.f16329i;
                long j8 = j6 + (j7 - i28);
                zzivVar2.f16326f = j8;
                long j9 = j7 - i28;
                zzkm zzkmVar5 = zzivVar2.f16330j;
                boolean z3 = zzkmVar5 == null && (j7 >= 262144 || j7 > 2147483647L);
                if (z3) {
                    zzijVar2.a = j8;
                } else if (zzkmVar5 != null) {
                    zzieVar2.readFully(zzkmVar5.a, i28, (int) j9);
                    if (!zzivVar2.f16324d.isEmpty()) {
                        zzivVar2.f16324d.peek().c0.add(new zzis(zzivVar2.f16327g, zzivVar2.f16330j));
                    }
                } else {
                    zzieVar2.a((int) j9);
                }
                while (!zzivVar2.f16324d.isEmpty() && zzivVar2.f16324d.peek().b0 == zzivVar2.f16326f) {
                    zzir pop = zzivVar2.f16324d.pop();
                    if (pop.a0 == vz.p) {
                        ArrayList arrayList2 = new ArrayList();
                        int i29 = 0;
                        while (i29 < pop.d0.size()) {
                            zzir zzirVar2 = pop.d0.get(i29);
                            if (zzirVar2.a0 == vz.r && (a = wz.a(zzirVar2, pop.c(vz.q))) != null && ((i4 = a.f16332b) == 1936684398 || i4 == 1986618469)) {
                                zzir d2 = zzirVar2.d(vz.s).d(vz.t).d(vz.u);
                                zzkm zzkmVar6 = d2.c(vz.X).b0;
                                int i30 = vz.Y;
                                zzis c2 = d2.c(i30);
                                if (c2 == null) {
                                    c2 = d2.c(vz.Z);
                                }
                                zzkm zzkmVar7 = c2.b0;
                                zzkm zzkmVar8 = d2.c(vz.W).b0;
                                zzkm zzkmVar9 = d2.c(vz.T).b0;
                                zzis c3 = d2.c(vz.U);
                                zzkm zzkmVar10 = c3 != null ? c3.b0 : null;
                                zzis c4 = d2.c(vz.V);
                                zzkm zzkmVar11 = c4 != null ? c4.b0 : null;
                                zzkmVar6.g(12);
                                int m = zzkmVar6.m();
                                int m2 = zzkmVar6.m();
                                int[] iArr = new int[m2];
                                z = z3;
                                long[] jArr = new long[m2];
                                zzirVar = pop;
                                long[] jArr2 = new long[m2];
                                ArrayList arrayList3 = arrayList2;
                                int[] iArr2 = new int[m2];
                                int i31 = i29;
                                zzkmVar7.g(12);
                                int m3 = zzkmVar7.m();
                                zzkmVar8.g(12);
                                int m4 = zzkmVar8.m() - 1;
                                int i32 = m3;
                                if (zzkmVar8.c() == 1) {
                                    int m5 = zzkmVar8.m();
                                    zzkmVar8.h(4);
                                    if (m4 > 0) {
                                        i7 = zzkmVar8.m() - 1;
                                        i5 = m5;
                                        i6 = 12;
                                    } else {
                                        i5 = m5;
                                        i6 = 12;
                                        i7 = -1;
                                    }
                                    zzkmVar9.g(i6);
                                    int m6 = zzkmVar9.m() - 1;
                                    int m7 = zzkmVar9.m();
                                    int m8 = zzkmVar9.m();
                                    if (zzkmVar11 != null) {
                                        zzkmVar11.g(i6);
                                        i8 = zzkmVar11.m() - 1;
                                        i9 = zzkmVar11.m();
                                        i10 = zzkmVar11.c();
                                    } else {
                                        i8 = 0;
                                        i9 = 0;
                                        i10 = 0;
                                    }
                                    if (zzkmVar10 != null) {
                                        zzkmVar10.g(i6);
                                        int m9 = zzkmVar10.m();
                                        i11 = zzkmVar10.m() - 1;
                                        i12 = m9;
                                    } else {
                                        i11 = -1;
                                        i12 = 0;
                                    }
                                    if (c2.a0 == i30) {
                                        n = zzkmVar7.k();
                                    } else {
                                        n = zzkmVar7.n();
                                    }
                                    int i33 = i12;
                                    long j10 = n;
                                    int i34 = 0;
                                    long j11 = 0;
                                    int i35 = i7;
                                    int i36 = i11;
                                    int i37 = 0;
                                    int i38 = i9;
                                    zzkm zzkmVar12 = zzkmVar8;
                                    int i39 = m8;
                                    int i40 = m6;
                                    int i41 = m4;
                                    int i42 = i10;
                                    int i43 = i8;
                                    int i44 = m7;
                                    int i45 = i5;
                                    while (i37 < m2) {
                                        jArr2[i37] = j10;
                                        iArr[i37] = m == 0 ? zzkmVar6.m() : m;
                                        zzkm zzkmVar13 = zzkmVar6;
                                        int i46 = i34;
                                        jArr[i37] = j11 + i42;
                                        iArr2[i37] = zzkmVar10 == null ? 1 : 0;
                                        if (i37 == i36) {
                                            iArr2[i37] = 1;
                                            i33--;
                                            if (i33 > 0) {
                                                i36 = zzkmVar10.m() - 1;
                                            }
                                        }
                                        j11 += i39;
                                        i44--;
                                        if (i44 == 0 && i40 > 0) {
                                            i40--;
                                            i44 = zzkmVar9.m();
                                            i39 = zzkmVar9.m();
                                        }
                                        if (zzkmVar11 != null && i38 - 1 == 0 && i43 > 0) {
                                            i43--;
                                            i38 = zzkmVar11.m();
                                            i42 = zzkmVar11.c();
                                        }
                                        i5--;
                                        if (i5 == 0) {
                                            i34 = i46 + 1;
                                            i13 = i32;
                                            i14 = i33;
                                            if (i34 < i13) {
                                                zzkmVar = zzkmVar11;
                                                if (c2.a0 == vz.Y) {
                                                    j10 = zzkmVar7.k();
                                                } else {
                                                    j10 = zzkmVar7.n();
                                                }
                                            } else {
                                                zzkmVar = zzkmVar11;
                                            }
                                            i15 = i35;
                                            if (i34 == i15) {
                                                i45 = zzkmVar12.m();
                                                zzkmVar2 = zzkmVar10;
                                                zzkmVar3 = zzkmVar12;
                                                zzkmVar3.h(4);
                                                i41--;
                                                if (i41 > 0) {
                                                    i15 = zzkmVar3.m() - 1;
                                                }
                                            } else {
                                                zzkmVar2 = zzkmVar10;
                                                zzkmVar3 = zzkmVar12;
                                            }
                                            i16 = m2;
                                            if (i34 < i13) {
                                                i5 = i45;
                                            }
                                        } else {
                                            zzkmVar = zzkmVar11;
                                            zzkmVar2 = zzkmVar10;
                                            i13 = i32;
                                            zzkmVar3 = zzkmVar12;
                                            i14 = i33;
                                            i15 = i35;
                                            i16 = m2;
                                            j10 += iArr[i37];
                                            i34 = i46;
                                        }
                                        i37++;
                                        i35 = i15;
                                        zzkmVar10 = zzkmVar2;
                                        i33 = i14;
                                        m2 = i16;
                                        zzkmVar12 = zzkmVar3;
                                        i32 = i13;
                                        zzkmVar6 = zzkmVar13;
                                        zzkmVar11 = zzkmVar;
                                    }
                                    zzkq.c(jArr, 1000000L, a.f16333c);
                                    zzkh.a(i33 == 0);
                                    zzkh.a(i44 == 0);
                                    zzkh.a(i5 == 0);
                                    zzkh.a(i40 == 0);
                                    zzkh.a(i43 == 0);
                                    zz zzVar3 = new zz(jArr2, iArr, jArr, iArr2);
                                    if (zzVar3.a != 0) {
                                        zzivVar = this;
                                        i3 = i31;
                                        yz yzVar3 = new yz(a, zzVar3, zzivVar.n.f(i3));
                                        yzVar3.f13665c.b(a.f16335e);
                                        arrayList = arrayList3;
                                        arrayList.add(yzVar3);
                                    } else {
                                        zzivVar = this;
                                        arrayList = arrayList3;
                                        i3 = i31;
                                    }
                                } else {
                                    throw new IllegalStateException("stsc first chunk must be 1");
                                }
                            } else {
                                zzirVar = pop;
                                z = z3;
                                zzivVar = zzivVar2;
                                arrayList = arrayList2;
                                i3 = i29;
                            }
                            i29 = i3 + 1;
                            arrayList2 = arrayList;
                            zzivVar2 = zzivVar;
                            z3 = z;
                            pop = zzirVar;
                        }
                        zziv zzivVar4 = zzivVar2;
                        zzivVar4.o = (yz[]) arrayList2.toArray(new yz[0]);
                        zzivVar4.n.d();
                        zzivVar4.n.g(zzivVar4);
                        zzivVar4.f16325e = 2;
                        zzivVar2 = zzivVar4;
                    } else {
                        boolean z4 = z3;
                        zziv zzivVar5 = zzivVar2;
                        if (!zzivVar5.f16324d.isEmpty()) {
                            zzivVar5.f16324d.peek().d0.add(pop);
                        }
                        zzivVar2 = zzivVar5;
                        z3 = z4;
                    }
                }
                zziv zzivVar6 = zzivVar2;
                if (z3) {
                    return 1;
                }
                zzieVar2 = zzieVar;
                zzijVar2 = zzijVar;
                zzivVar2 = zzivVar6;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzid
    public final void d(zzif zzifVar) {
        this.n = zzifVar;
    }

    @Override // com.google.android.gms.internal.ads.zzid
    public final void e() {
        this.f16326f = 0L;
        this.l = 0;
        this.m = 0;
    }
}
