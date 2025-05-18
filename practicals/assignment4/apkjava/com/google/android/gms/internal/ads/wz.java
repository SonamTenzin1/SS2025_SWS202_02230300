package com.google.android.gms.internal.ads;

import android.util.Pair;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
final class wz {
    public static zzix a(zzir zzirVar, zzis zzisVar) {
        boolean z;
        boolean z2;
        long k2;
        int i2;
        int i3;
        int i4;
        int i5;
        String str;
        zzir d2 = zzirVar.d(vz.s);
        zzkm zzkmVar = d2.c(vz.B).b0;
        zzkmVar.g(16);
        int c2 = zzkmVar.c();
        if (c2 != 1936684398 && c2 != 1986618469 && c2 != 1952807028 && c2 != 1953325924) {
            return null;
        }
        zzkm zzkmVar2 = zzirVar.c(vz.z).b0;
        zzkmVar2.g(8);
        int a = vz.a(zzkmVar2.c());
        zzkmVar2.h(a == 0 ? 8 : 16);
        int c3 = zzkmVar2.c();
        zzkmVar2.h(4);
        int a2 = zzkmVar2.a();
        int i6 = a == 0 ? 4 : 8;
        int i7 = 0;
        while (true) {
            z = true;
            if (i7 >= i6) {
                z2 = true;
                break;
            }
            if (zzkmVar2.a[a2 + i7] != -1) {
                z2 = false;
                break;
            }
            i7++;
        }
        if (z2) {
            zzkmVar2.h(i6);
            k2 = -1;
        } else {
            k2 = a == 0 ? zzkmVar2.k() : zzkmVar2.n();
        }
        Pair create = Pair.create(Integer.valueOf(c3), Long.valueOf(k2));
        int intValue = ((Integer) create.first).intValue();
        long longValue = ((Long) create.second).longValue();
        zzkm zzkmVar3 = zzisVar.b0;
        zzkmVar3.g(8);
        zzkmVar3.h(vz.a(zzkmVar3.c()) == 0 ? 8 : 16);
        long b2 = longValue == -1 ? -1L : zzkq.b(longValue, 1000000L, zzkmVar3.k());
        zzir d3 = d2.d(vz.t).d(vz.u);
        zzkm zzkmVar4 = d2.c(vz.A).b0;
        zzkmVar4.g(8);
        zzkmVar4.h(vz.a(zzkmVar4.c()) != 0 ? 16 : 8);
        long k3 = zzkmVar4.k();
        zzkm zzkmVar5 = d3.c(vz.C).b0;
        zzkmVar5.g(12);
        int c4 = zzkmVar5.c();
        xz xzVar = new xz(c4);
        int i8 = 0;
        while (i8 < c4) {
            int a3 = zzkmVar5.a();
            int c5 = zzkmVar5.c();
            zzkh.b(c5 > 0, "childAtomSize should be positive");
            int c6 = zzkmVar5.c();
            if (c6 != vz.f13474b && c6 != vz.f13475c && c6 != vz.I) {
                if (c6 != vz.f13478f && c6 != vz.J && c6 != vz.f13479g) {
                    if (c6 == vz.P) {
                        xzVar.f13587b = zzhj.h();
                        i2 = c4;
                        i3 = intValue;
                        i4 = c2;
                        i5 = c5;
                    } else if (c6 == vz.S) {
                        zzkmVar5.g(a3 + 8);
                        zzkmVar5.h(24);
                        int f2 = zzkmVar5.f();
                        int f3 = zzkmVar5.f();
                        zzkmVar5.h(50);
                        ArrayList arrayList = new ArrayList(z ? 1 : 0);
                        int a4 = zzkmVar5.a();
                        while (a4 - a3 < c5) {
                            zzkmVar5.g(a4);
                            int a5 = zzkmVar5.a();
                            int c7 = zzkmVar5.c();
                            if (c7 <= 0) {
                                z = false;
                            }
                            zzkh.b(z, "childAtomSize should be positive");
                            int i9 = c4;
                            if (zzkmVar5.c() == vz.f13476d) {
                                arrayList.add(c(zzkmVar5, a5));
                            }
                            a4 += c7;
                            c4 = i9;
                            z = true;
                        }
                        i2 = c4;
                        i5 = c5;
                        xzVar.f13587b = zzhj.e("video/mp4v-es", -1, b2, f2, f3, arrayList);
                        i3 = intValue;
                        i4 = c2;
                    } else {
                        i2 = c4;
                        i5 = c5;
                        i3 = intValue;
                        i4 = c2;
                    }
                } else {
                    i2 = c4;
                    i5 = c5;
                    zzkmVar5.g(a3 + 8);
                    zzkmVar5.h(16);
                    int f4 = zzkmVar5.f();
                    int f5 = zzkmVar5.f();
                    zzkmVar5.h(4);
                    int l = zzkmVar5.l();
                    int a6 = zzkmVar5.a();
                    int i10 = f4;
                    int i11 = l;
                    byte[] bArr = null;
                    while (true) {
                        if (a6 - a3 < i5) {
                            zzkmVar5.g(a6);
                            int a7 = zzkmVar5.a();
                            int c8 = zzkmVar5.c();
                            i4 = c2;
                            zzkh.b(c8 > 0, "childAtomSize should be positive");
                            int c9 = zzkmVar5.c();
                            i3 = intValue;
                            if (c6 != vz.f13478f && c6 != vz.J) {
                                if (c6 == vz.f13479g && c9 == vz.f13480h) {
                                    zzkmVar5.g(a7 + 8);
                                    xzVar.f13587b = zzkg.b(zzkmVar5);
                                    break;
                                }
                                if (c6 == vz.f13481i && c9 == vz.f13482j) {
                                    zzkmVar5.g(a7 + 8);
                                    xzVar.f13587b = zzkg.c(zzkmVar5);
                                    break;
                                }
                            } else if (c9 == vz.f13476d) {
                                bArr = c(zzkmVar5, a7);
                                Pair<Integer, Integer> b3 = zzki.b(bArr);
                                i11 = ((Integer) b3.first).intValue();
                                i10 = ((Integer) b3.second).intValue();
                            } else if (c9 == vz.E) {
                                xzVar.a[i8] = b(zzkmVar5, a7, c8);
                            }
                            a6 += c8;
                            c2 = i4;
                            intValue = i3;
                        } else {
                            i3 = intValue;
                            i4 = c2;
                            if (c6 == vz.f13479g) {
                                str = "audio/ac3";
                            } else {
                                str = c6 == vz.f13481i ? "audio/eac3" : "audio/mp4a-latm";
                            }
                            xzVar.f13587b = zzhj.g(str, f5, b2, i10, i11, bArr == null ? null : Collections.singletonList(bArr));
                        }
                    }
                }
                z = true;
            } else {
                i2 = c4;
                i3 = intValue;
                i4 = c2;
                i5 = c5;
                zzkmVar5.g(a3 + 8);
                zzkmVar5.h(24);
                int f6 = zzkmVar5.f();
                int f7 = zzkmVar5.f();
                zzkmVar5.h(50);
                int a8 = zzkmVar5.a();
                float f8 = 1.0f;
                List list = null;
                while (a8 - a3 < i5) {
                    zzkmVar5.g(a8);
                    int a9 = zzkmVar5.a();
                    int c10 = zzkmVar5.c();
                    if (c10 == 0 && zzkmVar5.a() - a3 == i5) {
                        break;
                    }
                    zzkh.b(c10 > 0, "childAtomSize should be positive");
                    int c11 = zzkmVar5.c();
                    if (c11 == vz.v) {
                        zzkmVar5.g(a9 + 8 + 4);
                        int e2 = (zzkmVar5.e() & 3) + 1;
                        if (e2 != 3) {
                            ArrayList arrayList2 = new ArrayList();
                            int e3 = zzkmVar5.e() & 31;
                            for (int i12 = 0; i12 < e3; i12++) {
                                arrayList2.add(zzkj.a(zzkmVar5));
                            }
                            int e4 = zzkmVar5.e();
                            for (int i13 = 0; i13 < e4; i13++) {
                                arrayList2.add(zzkj.a(zzkmVar5));
                            }
                            Pair create2 = Pair.create(arrayList2, Integer.valueOf(e2));
                            list = (List) create2.first;
                            xzVar.f13588c = ((Integer) create2.second).intValue();
                        } else {
                            throw new IllegalStateException();
                        }
                    } else if (c11 == vz.E) {
                        xzVar.a[i8] = b(zzkmVar5, a9, c10);
                    } else if (c11 == vz.O) {
                        zzkmVar5.g(a9 + 8);
                        f8 = zzkmVar5.m() / zzkmVar5.m();
                    }
                    a8 += c10;
                }
                z = true;
                xzVar.f13587b = zzhj.d("video/avc", -1, b2, f6, f7, f8, list);
            }
            zzkmVar5.g(a3 + i5);
            i8++;
            c4 = i2;
            c2 = i4;
            intValue = i3;
        }
        return new zzix(intValue, c2, k3, b2, xzVar.f13587b, xzVar.a, xzVar.f13588c);
    }

    private static zziy b(zzkm zzkmVar, int i2, int i3) {
        int i4 = i2 + 8;
        zziy zziyVar = null;
        while (i4 - i2 < i3) {
            zzkmVar.g(i4);
            int c2 = zzkmVar.c();
            int c3 = zzkmVar.c();
            if (c3 == vz.K) {
                zzkmVar.c();
            } else if (c3 == vz.F) {
                zzkmVar.h(4);
                zzkmVar.c();
                zzkmVar.c();
            } else if (c3 == vz.G) {
                int i5 = i4 + 8;
                while (true) {
                    if (i5 - i4 >= c2) {
                        zziyVar = null;
                        break;
                    }
                    zzkmVar.g(i5);
                    int c4 = zzkmVar.c();
                    if (zzkmVar.c() == vz.H) {
                        zzkmVar.h(4);
                        int c5 = zzkmVar.c();
                        boolean z = (c5 >> 8) == 1;
                        byte[] bArr = new byte[16];
                        zzkmVar.j(bArr, 0, 16);
                        zziyVar = new zziy(z, c5 & 255, bArr);
                    } else {
                        i5 += c4;
                    }
                }
            }
            i4 += c2;
        }
        return zziyVar;
    }

    private static byte[] c(zzkm zzkmVar, int i2) {
        zzkmVar.g(i2 + 8 + 4);
        zzkmVar.h(1);
        int e2 = zzkmVar.e();
        while (e2 > 127) {
            e2 = zzkmVar.e();
        }
        zzkmVar.h(2);
        int e3 = zzkmVar.e();
        if ((e3 & 128) != 0) {
            zzkmVar.h(2);
        }
        if ((e3 & 64) != 0) {
            zzkmVar.h(zzkmVar.f());
        }
        if ((e3 & 32) != 0) {
            zzkmVar.h(2);
        }
        zzkmVar.h(1);
        int e4 = zzkmVar.e();
        while (e4 > 127) {
            e4 = zzkmVar.e();
        }
        zzkmVar.h(13);
        zzkmVar.h(1);
        int e5 = zzkmVar.e();
        int i3 = e5 & 127;
        while (e5 > 127) {
            e5 = zzkmVar.e();
            i3 = (i3 << 8) | (e5 & 127);
        }
        byte[] bArr = new byte[i3];
        zzkmVar.j(bArr, 0, i3);
        return bArr;
    }
}
