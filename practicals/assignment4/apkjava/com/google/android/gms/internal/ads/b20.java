package com.google.android.gms.internal.ads;

import android.util.Log;
import android.util.Pair;
import cm.aptoide.pt.root.execution.Command;
import com.google.android.gms.internal.ads.zzpo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
final class b20 {
    private static final int a = zzsy.i("vide");

    /* renamed from: b, reason: collision with root package name */
    private static final int f12300b = zzsy.i("soun");

    /* renamed from: c, reason: collision with root package name */
    private static final int f12301c = zzsy.i(Command.CommandHandler.TEXT);

    /* renamed from: d, reason: collision with root package name */
    private static final int f12302d = zzsy.i("sbtl");

    /* renamed from: e, reason: collision with root package name */
    private static final int f12303e = zzsy.i("subt");

    /* renamed from: f, reason: collision with root package name */
    private static final int f12304f = zzsy.i("clcp");

    /* renamed from: g, reason: collision with root package name */
    private static final int f12305g = zzsy.i("cenc");

    /* renamed from: h, reason: collision with root package name */
    private static final int f12306h = zzsy.i("meta");

    private static int a(zzst zzstVar, int i2, int i3, e20 e20Var, int i4) {
        int b2 = zzstVar.b();
        while (true) {
            if (b2 - i2 >= i3) {
                return 0;
            }
            zzstVar.k(b2);
            int d2 = zzstVar.d();
            zzsk.b(d2 > 0, "childAtomSize should be positive");
            if (zzstVar.d() == y10.V) {
                int i5 = b2 + 8;
                Pair pair = null;
                Integer num = null;
                zzpb zzpbVar = null;
                boolean z = false;
                while (i5 - b2 < d2) {
                    zzstVar.k(i5);
                    int d3 = zzstVar.d();
                    int d4 = zzstVar.d();
                    if (d4 == y10.b0) {
                        num = Integer.valueOf(zzstVar.d());
                    } else if (d4 == y10.W) {
                        zzstVar.l(4);
                        z = zzstVar.d() == f12305g;
                    } else if (d4 == y10.X) {
                        int i6 = i5 + 8;
                        while (true) {
                            if (i6 - i5 >= d3) {
                                zzpbVar = null;
                                break;
                            }
                            zzstVar.k(i6);
                            int d5 = zzstVar.d();
                            if (zzstVar.d() == y10.Y) {
                                zzstVar.l(6);
                                boolean z2 = zzstVar.g() == 1;
                                int g2 = zzstVar.g();
                                byte[] bArr = new byte[16];
                                zzstVar.n(bArr, 0, 16);
                                zzpbVar = new zzpb(z2, g2, bArr);
                            } else {
                                i6 += d5;
                            }
                        }
                    }
                    i5 += d3;
                }
                if (z) {
                    zzsk.b(num != null, "frma atom is mandatory");
                    zzsk.b(zzpbVar != null, "schi->tenc atom is mandatory");
                    pair = Pair.create(num, zzpbVar);
                }
                if (pair != null) {
                    e20Var.a[i4] = (zzpb) pair.second;
                    return ((Integer) pair.first).intValue();
                }
            }
            b2 += d2;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:399:0x00a3, code lost:
    
        if (r14 == 0) goto L43;
     */
    /* JADX WARN: Removed duplicated region for block: B:181:0x044d  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x047f A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static zzpa b(z10 z10Var, a20 a20Var, long j2, zzne zzneVar, boolean z) throws zzlm {
        int i2;
        boolean z2;
        long q;
        long j3;
        int i3;
        int i4;
        zzpa zzpaVar;
        Pair create;
        int i5;
        a20 d2;
        Pair pair;
        h20 h20Var;
        int i6;
        int i7;
        int i8;
        String str;
        byte[] bArr;
        List<byte[]> list;
        int i9;
        int i10;
        int i11;
        int i12;
        String str2;
        String str3;
        int b2;
        int i13;
        int i14;
        String str4;
        String str5;
        long j4;
        List singletonList;
        z10 e2 = z10Var.e(y10.E);
        zzst zzstVar = e2.d(y10.S).Q0;
        zzstVar.k(16);
        int d3 = zzstVar.d();
        if (d3 == f12300b) {
            i2 = 1;
        } else if (d3 == a) {
            i2 = 2;
        } else if (d3 == f12301c || d3 == f12302d || d3 == f12303e || d3 == f12304f) {
            i2 = 3;
        } else {
            i2 = d3 == f12306h ? 4 : -1;
        }
        if (i2 == -1) {
            return null;
        }
        zzst zzstVar2 = z10Var.d(y10.O).Q0;
        zzstVar2.k(8);
        int b3 = y10.b(zzstVar2.d());
        zzstVar2.l(b3 == 0 ? 8 : 16);
        int d4 = zzstVar2.d();
        zzstVar2.l(4);
        int b4 = zzstVar2.b();
        int i15 = b3 == 0 ? 4 : 8;
        int i16 = 0;
        while (true) {
            if (i16 >= i15) {
                z2 = true;
                break;
            }
            if (zzstVar2.a[b4 + i16] != -1) {
                z2 = false;
                break;
            }
            i16++;
        }
        if (z2) {
            zzstVar2.l(i15);
        } else {
            q = b3 == 0 ? zzstVar2.q() : zzstVar2.t();
        }
        q = -9223372036854775807L;
        zzstVar2.l(16);
        int d5 = zzstVar2.d();
        int d6 = zzstVar2.d();
        zzstVar2.l(4);
        int d7 = zzstVar2.d();
        int d8 = zzstVar2.d();
        h20 h20Var2 = new h20(d4, q, (d5 == 0 && d6 == 65536 && d7 == -65536 && d8 == 0) ? 90 : (d5 == 0 && d6 == -65536 && d7 == 65536 && d8 == 0) ? 270 : (d5 == -65536 && d6 == 0 && d7 == 0 && d8 == -65536) ? 180 : 0);
        j3 = h20Var2.f12682b;
        zzst zzstVar3 = a20Var.Q0;
        zzstVar3.k(8);
        zzstVar3.l(y10.b(zzstVar3.d()) == 0 ? 8 : 16);
        long q2 = zzstVar3.q();
        long c2 = j3 != -9223372036854775807L ? zzsy.c(j3, 1000000L, q2) : -9223372036854775807L;
        z10 e3 = e2.e(y10.F).e(y10.G);
        zzst zzstVar4 = e2.d(y10.R).Q0;
        zzstVar4.k(8);
        int b5 = y10.b(zzstVar4.d());
        zzstVar4.l(b5 == 0 ? 8 : 16);
        long q3 = zzstVar4.q();
        zzstVar4.l(b5 == 0 ? 4 : 8);
        int h2 = zzstVar4.h();
        StringBuilder sb = new StringBuilder(3);
        sb.append((char) (((h2 >> 10) & 31) + 96));
        sb.append((char) (((h2 >> 5) & 31) + 96));
        sb.append((char) ((h2 & 31) + 96));
        Pair create2 = Pair.create(Long.valueOf(q3), sb.toString());
        zzst zzstVar5 = e3.d(y10.T).Q0;
        i3 = h20Var2.a;
        i4 = h20Var2.f12683c;
        String str6 = (String) create2.second;
        zzstVar5.k(12);
        int d9 = zzstVar5.d();
        e20 e20Var = new e20(d9);
        int i17 = 0;
        while (i17 < d9) {
            int b6 = zzstVar5.b();
            int d10 = zzstVar5.d();
            String str7 = "childAtomSize should be positive";
            zzsk.b(d10 > 0, "childAtomSize should be positive");
            int d11 = zzstVar5.d();
            if (d11 != y10.f13593b && d11 != y10.f13594c && d11 != y10.Z && d11 != y10.l0 && d11 != y10.f13595d && d11 != y10.f13596e && d11 != y10.f13597f && d11 != y10.K0 && d11 != y10.L0) {
                if (d11 != y10.f13600i && d11 != y10.a0 && d11 != y10.n && d11 != y10.p && d11 != y10.r && d11 != y10.u && d11 != y10.s && d11 != y10.t && d11 != y10.y0 && d11 != y10.z0 && d11 != y10.l && d11 != y10.m && d11 != y10.f13601j && d11 != y10.O0) {
                    int i18 = y10.j0;
                    if (d11 != i18 && d11 != y10.u0 && d11 != y10.v0 && d11 != y10.w0 && d11 != y10.x0) {
                        if (d11 == y10.N0) {
                            i7 = d9;
                            e20Var.f12501b = zzlh.g(Integer.toString(i3), "application/x-camera-motion", null, -1, null);
                        } else {
                            i7 = d9;
                        }
                    } else {
                        i7 = d9;
                        zzstVar5.k(b6 + 8 + 8);
                        if (d11 == i18) {
                            str5 = "application/ttml+xml";
                        } else if (d11 == y10.u0) {
                            int i19 = (d10 - 8) - 8;
                            byte[] bArr2 = new byte[i19];
                            zzstVar5.n(bArr2, 0, i19);
                            singletonList = Collections.singletonList(bArr2);
                            str5 = "application/x-quicktime-tx3g";
                            j4 = Long.MAX_VALUE;
                            e20Var.f12501b = zzlh.e(Integer.toString(i3), str5, null, -1, 0, str6, -1, null, j4, singletonList);
                        } else {
                            if (d11 == y10.v0) {
                                str4 = "application/x-mp4-vtt";
                            } else if (d11 != y10.w0) {
                                if (d11 == y10.x0) {
                                    e20Var.f12503d = 1;
                                    str4 = "application/x-mp4-cea-608";
                                } else {
                                    throw new IllegalStateException();
                                }
                            } else {
                                str5 = "application/ttml+xml";
                                j4 = 0;
                                singletonList = null;
                                e20Var.f12501b = zzlh.e(Integer.toString(i3), str5, null, -1, 0, str6, -1, null, j4, singletonList);
                            }
                            str5 = str4;
                        }
                        j4 = Long.MAX_VALUE;
                        singletonList = null;
                        e20Var.f12501b = zzlh.e(Integer.toString(i3), str5, null, -1, 0, str6, -1, null, j4, singletonList);
                    }
                } else {
                    i7 = d9;
                    zzstVar5.k(b6 + 8 + 8);
                    if (z) {
                        int h3 = zzstVar5.h();
                        zzstVar5.l(6);
                        i9 = h3;
                    } else {
                        zzstVar5.l(8);
                        i9 = 0;
                    }
                    if (i9 == 0 || i9 == 1) {
                        i10 = i2;
                        int h4 = zzstVar5.h();
                        zzstVar5.l(6);
                        int r = zzstVar5.r();
                        if (i9 == 1) {
                            zzstVar5.l(16);
                        }
                        i11 = r;
                        i12 = h4;
                    } else if (i9 == 2) {
                        zzstVar5.l(16);
                        i10 = i2;
                        i11 = (int) Math.round(Double.longBitsToDouble(zzstVar5.e()));
                        i12 = zzstVar5.s();
                        zzstVar5.l(20);
                    }
                    int b7 = zzstVar5.b();
                    int i20 = i11;
                    if (d11 == y10.a0) {
                        d11 = a(zzstVar5, b6, d10, e20Var, i17);
                        zzstVar5.k(b7);
                    }
                    if (d11 == y10.n) {
                        str2 = "audio/ac3";
                    } else if (d11 == y10.p) {
                        str2 = "audio/eac3";
                    } else if (d11 == y10.r) {
                        str2 = "audio/vnd.dts";
                    } else if (d11 == y10.s || d11 == y10.t) {
                        str2 = "audio/vnd.dts.hd";
                    } else if (d11 == y10.u) {
                        str2 = "audio/vnd.dts.hd;profile=lbr";
                    } else if (d11 == y10.y0) {
                        str2 = "audio/3gpp";
                    } else if (d11 == y10.z0) {
                        str2 = "audio/amr-wb";
                    } else if (d11 == y10.l || d11 == y10.m) {
                        str2 = "audio/raw";
                    } else if (d11 == y10.f13601j) {
                        str2 = "audio/mpeg";
                    } else {
                        str2 = d11 == y10.O0 ? "audio/alac" : null;
                    }
                    i8 = i10;
                    byte[] bArr3 = null;
                    int i21 = i12;
                    String str8 = str2;
                    int i22 = b7;
                    int i23 = i20;
                    int i24 = i21;
                    while (i22 - b6 < d10) {
                        zzstVar5.k(i22);
                        int d12 = zzstVar5.d();
                        Pair pair2 = create2;
                        zzsk.b(d12 > 0, "childAtomSize should be positive");
                        int d13 = zzstVar5.d();
                        h20 h20Var3 = h20Var2;
                        int i25 = y10.J;
                        if (d13 == i25 || (z && d13 == y10.f13602k)) {
                            boolean z3 = false;
                            if (d13 == i25) {
                                i13 = i4;
                                b2 = i22;
                            } else {
                                b2 = zzstVar5.b();
                                while (b2 - i22 < d12) {
                                    zzstVar5.k(b2);
                                    int d14 = zzstVar5.d();
                                    if (d14 > 0) {
                                        z3 = true;
                                    }
                                    zzsk.b(z3, "childAtomSize should be positive");
                                    i13 = i4;
                                    if (zzstVar5.d() != y10.J) {
                                        b2 += d14;
                                        i4 = i13;
                                        z3 = false;
                                    }
                                }
                                i13 = i4;
                                i14 = -1;
                                b2 = -1;
                                if (b2 == i14) {
                                    Pair<String, byte[]> e4 = e(zzstVar5, b2);
                                    String str9 = (String) e4.first;
                                    bArr3 = (byte[]) e4.second;
                                    if ("audio/mp4a-latm".equals(str9)) {
                                        Pair<Integer, Integer> d15 = zzsl.d(bArr3);
                                        int intValue = ((Integer) d15.first).intValue();
                                        i24 = ((Integer) d15.second).intValue();
                                        str8 = str9;
                                        i23 = intValue;
                                    } else {
                                        str8 = str9;
                                    }
                                }
                            }
                            i14 = -1;
                            if (b2 == i14) {
                            }
                        } else {
                            if (d13 == y10.o) {
                                zzstVar5.k(i22 + 8);
                                e20Var.f12501b = zzlv.a(zzstVar5, Integer.toString(i3), str6, null);
                            } else if (d13 == y10.q) {
                                zzstVar5.k(i22 + 8);
                                e20Var.f12501b = zzlv.b(zzstVar5, Integer.toString(i3), str6, null);
                            } else if (d13 == y10.v) {
                                e20Var.f12501b = zzlh.d(Integer.toString(i3), str8, null, -1, -1, i24, i23, null, null, 0, str6);
                            } else if (d13 == y10.O0) {
                                byte[] bArr4 = new byte[d12];
                                zzstVar5.k(i22);
                                zzstVar5.n(bArr4, 0, d12);
                                bArr3 = bArr4;
                                i13 = i4;
                            }
                            i13 = i4;
                        }
                        i22 += d12;
                        create2 = pair2;
                        h20Var2 = h20Var3;
                        i4 = i13;
                    }
                    pair = create2;
                    h20Var = h20Var2;
                    i6 = i4;
                    if (e20Var.f12501b == null && (str3 = str8) != null) {
                        e20Var.f12501b = zzlh.c(Integer.toString(i3), str3, null, -1, -1, i24, i23, "audio/raw".equals(str3) ? 2 : -1, bArr3 == null ? null : Collections.singletonList(bArr3), null, 0, str6);
                    }
                }
                pair = create2;
                h20Var = h20Var2;
                i6 = i4;
                i8 = i2;
            } else {
                pair = create2;
                h20Var = h20Var2;
                i6 = i4;
                i7 = d9;
                i8 = i2;
                zzstVar5.k(b6 + 8 + 8);
                zzstVar5.l(16);
                int h5 = zzstVar5.h();
                int h6 = zzstVar5.h();
                zzstVar5.l(50);
                int b8 = zzstVar5.b();
                if (d11 == y10.Z) {
                    d11 = a(zzstVar5, b6, d10, e20Var, i17);
                    zzstVar5.k(b8);
                }
                boolean z4 = false;
                String str10 = null;
                List<byte[]> list2 = null;
                float f2 = 1.0f;
                byte[] bArr5 = null;
                int i26 = -1;
                while (b8 - b6 < d10) {
                    zzstVar5.k(b8);
                    int b9 = zzstVar5.b();
                    int d16 = zzstVar5.d();
                    if (d16 == 0 && zzstVar5.b() - b6 == d10) {
                        break;
                    }
                    zzsk.b(d16 > 0, str7);
                    int d17 = zzstVar5.d();
                    if (d17 == y10.H) {
                        zzsk.e(str10 == null);
                        zzstVar5.k(b9 + 8);
                        zzta a2 = zzta.a(zzstVar5);
                        list = a2.a;
                        e20Var.f12502c = a2.f16748b;
                        if (!z4) {
                            f2 = a2.f16751e;
                        }
                        str10 = "video/avc";
                    } else if (d17 == y10.I) {
                        zzsk.e(str10 == null);
                        zzstVar5.k(b9 + 8);
                        zztg a3 = zztg.a(zzstVar5);
                        list = a3.a;
                        e20Var.f12502c = a3.f16762b;
                        str10 = "video/hevc";
                    } else {
                        if (d17 == y10.M0) {
                            zzsk.e(str10 == null);
                            str10 = d11 == y10.K0 ? "video/x-vnd.on2.vp8" : "video/x-vnd.on2.vp9";
                        } else if (d17 == y10.f13598g) {
                            zzsk.e(str10 == null);
                            str10 = "video/3gpp";
                        } else if (d17 == y10.J) {
                            zzsk.e(str10 == null);
                            Pair<String, byte[]> e5 = e(zzstVar5, b9);
                            str10 = (String) e5.first;
                            list2 = Collections.singletonList((byte[]) e5.second);
                        } else {
                            if (d17 == y10.i0) {
                                zzstVar5.k(b9 + 8);
                                f2 = zzstVar5.s() / zzstVar5.s();
                                str = str7;
                                z4 = true;
                            } else if (d17 == y10.I0) {
                                int i27 = b9 + 8;
                                while (true) {
                                    if (i27 - b9 >= d16) {
                                        str = str7;
                                        bArr = null;
                                        break;
                                    }
                                    zzstVar5.k(i27);
                                    int d18 = zzstVar5.d();
                                    str = str7;
                                    if (zzstVar5.d() == y10.J0) {
                                        bArr = Arrays.copyOfRange(zzstVar5.a, i27, d18 + i27);
                                        break;
                                    }
                                    i27 += d18;
                                    str7 = str;
                                }
                                bArr5 = bArr;
                            } else {
                                str = str7;
                                if (d17 == y10.H0) {
                                    int g2 = zzstVar5.g();
                                    zzstVar5.l(3);
                                    if (g2 == 0) {
                                        int g3 = zzstVar5.g();
                                        if (g3 == 0) {
                                            i26 = 0;
                                        } else if (g3 == 1) {
                                            i26 = 1;
                                        } else if (g3 == 2) {
                                            i26 = 2;
                                        } else if (g3 == 3) {
                                            i26 = 3;
                                        }
                                    }
                                }
                            }
                            b8 += d16;
                            str7 = str;
                        }
                        str = str7;
                        b8 += d16;
                        str7 = str;
                    }
                    str = str7;
                    list2 = list;
                    b8 += d16;
                    str7 = str;
                }
                if (str10 != null) {
                    e20Var.f12501b = zzlh.b(Integer.toString(i3), str10, null, -1, -1, h5, h6, -1.0f, list2, i6, f2, bArr5, i26, null, null);
                }
            }
            zzstVar5.k(b6 + d10);
            i17++;
            d9 = i7;
            i2 = i8;
            create2 = pair;
            h20Var2 = h20Var;
            i4 = i6;
        }
        Pair pair3 = create2;
        h20 h20Var4 = h20Var2;
        int i28 = i2;
        z10 e6 = z10Var.e(y10.P);
        if (e6 != null && (d2 = e6.d(y10.Q)) != null) {
            zzst zzstVar6 = d2.Q0;
            zzstVar6.k(8);
            int b10 = y10.b(zzstVar6.d());
            int s = zzstVar6.s();
            long[] jArr = new long[s];
            long[] jArr2 = new long[s];
            for (int i29 = 0; i29 < s; i29++) {
                jArr[i29] = b10 == 1 ? zzstVar6.t() : zzstVar6.q();
                jArr2[i29] = b10 == 1 ? zzstVar6.e() : zzstVar6.d();
                if (zzstVar6.f() == 1) {
                    zzstVar6.l(2);
                } else {
                    throw new IllegalArgumentException("Unsupported media rate.");
                }
            }
            create = Pair.create(jArr, jArr2);
            zzpaVar = null;
        } else {
            zzpaVar = null;
            create = Pair.create(null, null);
        }
        if (e20Var.f12501b == null) {
            return zzpaVar;
        }
        i5 = h20Var4.a;
        return new zzpa(i5, i28, ((Long) pair3.first).longValue(), q2, c2, e20Var.f12501b, e20Var.f12503d, e20Var.a, e20Var.f12502c, (long[]) create.first, (long[]) create.second);
    }

    public static n20 c(zzpa zzpaVar, z10 z10Var, zznr zznrVar) throws zzlm {
        d20 g20Var;
        boolean z;
        int i2;
        int i3;
        zzpa zzpaVar2;
        int i4;
        long[] jArr;
        int[] iArr;
        int i5;
        long[] jArr2;
        int[] iArr2;
        long j2;
        long j3;
        long[] jArr3;
        long[] jArr4;
        boolean z2;
        int[] iArr3;
        int[] iArr4;
        int[] iArr5;
        int i6;
        int i7;
        int i8;
        int i9;
        a20 d2 = z10Var.d(y10.q0);
        if (d2 != null) {
            g20Var = new f20(d2);
        } else {
            a20 d3 = z10Var.d(y10.r0);
            if (d3 != null) {
                g20Var = new g20(d3);
            } else {
                throw new zzlm("Track has no sample table size information");
            }
        }
        int b2 = g20Var.b();
        if (b2 == 0) {
            return new n20(new long[0], new int[0], 0, new long[0], new int[0]);
        }
        a20 d4 = z10Var.d(y10.s0);
        if (d4 == null) {
            d4 = z10Var.d(y10.t0);
            z = true;
        } else {
            z = false;
        }
        zzst zzstVar = d4.Q0;
        zzst zzstVar2 = z10Var.d(y10.p0).Q0;
        zzst zzstVar3 = z10Var.d(y10.m0).Q0;
        a20 d5 = z10Var.d(y10.n0);
        zzst zzstVar4 = null;
        zzst zzstVar5 = d5 != null ? d5.Q0 : null;
        a20 d6 = z10Var.d(y10.o0);
        zzst zzstVar6 = d6 != null ? d6.Q0 : null;
        c20 c20Var = new c20(zzstVar2, zzstVar, z);
        zzstVar3.k(12);
        int s = zzstVar3.s() - 1;
        int s2 = zzstVar3.s();
        int s3 = zzstVar3.s();
        if (zzstVar6 != null) {
            zzstVar6.k(12);
            i2 = zzstVar6.s();
        } else {
            i2 = 0;
        }
        int i10 = -1;
        if (zzstVar5 != null) {
            zzstVar5.k(12);
            i3 = zzstVar5.s();
            if (i3 > 0) {
                i10 = zzstVar5.s() - 1;
                zzstVar4 = zzstVar5;
            }
        } else {
            zzstVar4 = zzstVar5;
            i3 = 0;
        }
        long j4 = 0;
        if (!(g20Var.a() && "audio/raw".equals(zzpaVar.f16561f.f16427k) && s == 0 && i2 == 0 && i3 == 0)) {
            long[] jArr5 = new long[b2];
            iArr = new int[b2];
            jArr2 = new long[b2];
            int i11 = i3;
            iArr2 = new int[b2];
            int i12 = i10;
            long j5 = 0;
            j2 = 0;
            int i13 = 0;
            i5 = 0;
            int i14 = 0;
            int i15 = 0;
            int i16 = 0;
            int i17 = i2;
            int i18 = s3;
            int i19 = s2;
            int i20 = s;
            int i21 = i11;
            while (i13 < b2) {
                while (i15 == 0) {
                    zzsk.e(c20Var.a());
                    j5 = c20Var.f12378d;
                    i15 = c20Var.f12377c;
                    i18 = i18;
                    i19 = i19;
                }
                int i22 = i19;
                int i23 = i18;
                if (zzstVar6 != null) {
                    while (i14 == 0 && i17 > 0) {
                        i14 = zzstVar6.s();
                        i16 = zzstVar6.d();
                        i17--;
                    }
                    i14--;
                }
                int i24 = i16;
                jArr5[i13] = j5;
                iArr[i13] = g20Var.c();
                if (iArr[i13] > i5) {
                    i5 = iArr[i13];
                }
                int i25 = b2;
                d20 d20Var = g20Var;
                jArr2[i13] = j2 + i24;
                iArr2[i13] = zzstVar4 == null ? 1 : 0;
                if (i13 == i12) {
                    iArr2[i13] = 1;
                    i21--;
                    if (i21 > 0) {
                        i12 = zzstVar4.s() - 1;
                    }
                }
                long[] jArr6 = jArr5;
                j2 += i23;
                int i26 = i22 - 1;
                if (i26 != 0 || i20 <= 0) {
                    i8 = i23;
                    i9 = i26;
                } else {
                    i9 = zzstVar3.s();
                    i8 = zzstVar3.s();
                    i20--;
                }
                int i27 = i9;
                j5 += iArr[i13];
                i15--;
                i13++;
                b2 = i25;
                jArr5 = jArr6;
                i12 = i12;
                i16 = i24;
                i19 = i27;
                i18 = i8;
                g20Var = d20Var;
            }
            i4 = b2;
            long[] jArr7 = jArr5;
            int i28 = i19;
            zzsk.a(i14 == 0);
            while (i17 > 0) {
                zzsk.a(zzstVar6.s() == 0);
                zzstVar6.d();
                i17--;
            }
            if (i21 == 0 && i28 == 0) {
                i7 = i15;
                if (i7 == 0 && i20 == 0) {
                    zzpaVar2 = zzpaVar;
                    jArr = jArr7;
                }
            } else {
                i7 = i15;
            }
            zzpaVar2 = zzpaVar;
            int i29 = zzpaVar2.a;
            StringBuilder sb = new StringBuilder(215);
            sb.append("Inconsistent stbl box for track ");
            sb.append(i29);
            sb.append(": remainingSynchronizationSamples ");
            sb.append(i21);
            sb.append(", remainingSamplesAtTimestampDelta ");
            sb.append(i28);
            sb.append(", remainingSamplesInChunk ");
            sb.append(i7);
            sb.append(", remainingTimestampDeltaChanges ");
            sb.append(i20);
            Log.w("AtomParsers", sb.toString());
            jArr = jArr7;
        } else {
            zzpaVar2 = zzpaVar;
            i4 = b2;
            d20 d20Var2 = g20Var;
            int i30 = c20Var.a;
            long[] jArr8 = new long[i30];
            int[] iArr6 = new int[i30];
            while (c20Var.a()) {
                int i31 = c20Var.f12376b;
                jArr8[i31] = c20Var.f12378d;
                iArr6[i31] = c20Var.f12377c;
            }
            int c2 = d20Var2.c();
            long j6 = s3;
            int i32 = 8192 / c2;
            int i33 = 0;
            for (int i34 = 0; i34 < i30; i34++) {
                i33 += zzsy.j(iArr6[i34], i32);
            }
            long[] jArr9 = new long[i33];
            int[] iArr7 = new int[i33];
            long[] jArr10 = new long[i33];
            int[] iArr8 = new int[i33];
            int i35 = 0;
            int i36 = 0;
            int i37 = 0;
            int i38 = 0;
            while (i35 < i30) {
                int i39 = iArr6[i35];
                long j7 = jArr8[i35];
                int i40 = i30;
                int i41 = i39;
                while (i41 > 0) {
                    int min = Math.min(i32, i41);
                    jArr9[i37] = j7;
                    iArr7[i37] = c2 * min;
                    i38 = Math.max(i38, iArr7[i37]);
                    jArr10[i37] = i36 * j6;
                    iArr8[i37] = 1;
                    j7 += iArr7[i37];
                    i36 += min;
                    i41 -= min;
                    i37++;
                    jArr8 = jArr8;
                    iArr6 = iArr6;
                }
                i35++;
                i30 = i40;
            }
            zzou zzouVar = new zzou(jArr9, iArr7, i38, jArr10, iArr8);
            jArr = zzouVar.a;
            iArr = zzouVar.f16538b;
            i5 = zzouVar.f16539c;
            jArr2 = zzouVar.f16540d;
            iArr2 = zzouVar.f16541e;
            j2 = 0;
        }
        if (zzpaVar2.f16564i != null && !zznrVar.c()) {
            long[] jArr11 = zzpaVar2.f16564i;
            if (jArr11.length == 1 && zzpaVar2.f16557b == 1 && jArr2.length >= 2) {
                long j8 = zzpaVar2.f16565j[0];
                long c3 = zzsy.c(jArr11[0], zzpaVar2.f16558c, zzpaVar2.f16559d) + j8;
                if (jArr2[0] <= j8 && j8 < jArr2[1] && jArr2[jArr2.length - 1] < c3 && c3 <= j2) {
                    long j9 = j2 - c3;
                    long c4 = zzsy.c(j8 - jArr2[0], zzpaVar2.f16561f.x, zzpaVar2.f16558c);
                    long c5 = zzsy.c(j9, zzpaVar2.f16561f.x, zzpaVar2.f16558c);
                    if ((c4 != 0 || c5 != 0) && c4 <= 2147483647L && c5 <= 2147483647L) {
                        zznrVar.f16525c = (int) c4;
                        zznrVar.f16526d = (int) c5;
                        zzsy.f(jArr2, 1000000L, zzpaVar2.f16558c);
                        return new n20(jArr, iArr, i5, jArr2, iArr2);
                    }
                }
            }
            long[] jArr12 = zzpaVar2.f16564i;
            if (jArr12.length == 1) {
                char c6 = 0;
                if (jArr12[0] == 0) {
                    int i42 = 0;
                    while (i42 < jArr2.length) {
                        jArr2[i42] = zzsy.c(jArr2[i42] - zzpaVar2.f16565j[c6], 1000000L, zzpaVar2.f16558c);
                        i42++;
                        c6 = 0;
                    }
                    return new n20(jArr, iArr, i5, jArr2, iArr2);
                }
            }
            boolean z3 = zzpaVar2.f16557b == 1;
            boolean z4 = false;
            int i43 = 0;
            int i44 = 0;
            int i45 = 0;
            while (true) {
                long[] jArr13 = zzpaVar2.f16564i;
                j3 = -1;
                if (i45 >= jArr13.length) {
                    break;
                }
                int i46 = i5;
                int[] iArr9 = iArr;
                long j10 = zzpaVar2.f16565j[i45];
                if (j10 != -1) {
                    i6 = i46;
                    long c7 = zzsy.c(jArr13[i45], zzpaVar2.f16558c, zzpaVar2.f16559d);
                    int k2 = zzsy.k(jArr2, j10, true, true);
                    int k3 = zzsy.k(jArr2, j10 + c7, z3, false);
                    i43 += k3 - k2;
                    z4 |= i44 != k2;
                    i44 = k3;
                } else {
                    i6 = i46;
                }
                i45++;
                iArr = iArr9;
                i5 = i6;
            }
            int i47 = i5;
            int[] iArr10 = iArr;
            boolean z5 = z4 | (i43 != i4);
            long[] jArr14 = z5 ? new long[i43] : jArr;
            int[] iArr11 = z5 ? new int[i43] : iArr10;
            int i48 = z5 ? 0 : i47;
            int[] iArr12 = z5 ? new int[i43] : iArr2;
            long[] jArr15 = new long[i43];
            int i49 = i48;
            int i50 = 0;
            int i51 = 0;
            while (true) {
                long[] jArr16 = zzpaVar2.f16564i;
                if (i50 >= jArr16.length) {
                    break;
                }
                int[] iArr13 = iArr11;
                int[] iArr14 = iArr12;
                long j11 = zzpaVar2.f16565j[i50];
                long j12 = jArr16[i50];
                if (j11 != j3) {
                    jArr3 = jArr14;
                    long[] jArr17 = jArr;
                    long c8 = zzsy.c(j12, zzpaVar2.f16558c, zzpaVar2.f16559d) + j11;
                    int k4 = zzsy.k(jArr2, j11, true, true);
                    int k5 = zzsy.k(jArr2, c8, z3, false);
                    if (z5) {
                        int i52 = k5 - k4;
                        System.arraycopy(jArr17, k4, jArr3, i51, i52);
                        iArr4 = iArr10;
                        z2 = z3;
                        iArr3 = iArr13;
                        System.arraycopy(iArr4, k4, iArr3, i51, i52);
                        jArr4 = jArr17;
                        iArr5 = iArr14;
                        System.arraycopy(iArr2, k4, iArr5, i51, i52);
                    } else {
                        iArr4 = iArr10;
                        jArr4 = jArr17;
                        iArr5 = iArr14;
                        z2 = z3;
                        iArr3 = iArr13;
                    }
                    int i53 = i49;
                    while (k4 < k5) {
                        int[] iArr15 = iArr5;
                        int[] iArr16 = iArr4;
                        long j13 = j11;
                        jArr15[i51] = zzsy.c(j4, 1000000L, zzpaVar2.f16559d) + zzsy.c(jArr2[k4] - j11, 1000000L, zzpaVar2.f16558c);
                        if (z5 && iArr3[i51] > i53) {
                            i53 = iArr16[k4];
                        }
                        i51++;
                        k4++;
                        iArr4 = iArr16;
                        j11 = j13;
                        iArr5 = iArr15;
                    }
                    iArr14 = iArr5;
                    iArr10 = iArr4;
                    i49 = i53;
                } else {
                    jArr3 = jArr14;
                    jArr4 = jArr;
                    z2 = z3;
                    iArr3 = iArr13;
                }
                j4 += j12;
                i50++;
                iArr11 = iArr3;
                jArr14 = jArr3;
                z3 = z2;
                iArr12 = iArr14;
                jArr = jArr4;
                j3 = -1;
            }
            long[] jArr18 = jArr14;
            int[] iArr17 = iArr11;
            int[] iArr18 = iArr12;
            boolean z6 = false;
            for (int i54 = 0; i54 < iArr18.length && !z6; i54++) {
                z6 |= (iArr18[i54] & 1) != 0;
            }
            if (z6) {
                return new n20(jArr18, iArr17, i49, jArr15, iArr18);
            }
            throw new zzlm("The edited sample sequence does not contain a sync sample.");
        }
        int[] iArr19 = iArr;
        zzsy.f(jArr2, 1000000L, zzpaVar2.f16558c);
        return new n20(jArr, iArr19, i5, jArr2, iArr2);
    }

    public static zzpo d(a20 a20Var, boolean z) {
        if (z) {
            return null;
        }
        zzst zzstVar = a20Var.Q0;
        zzstVar.k(8);
        while (zzstVar.u() >= 8) {
            int b2 = zzstVar.b();
            int d2 = zzstVar.d();
            if (zzstVar.d() == y10.B0) {
                zzstVar.k(b2);
                int i2 = b2 + d2;
                zzstVar.l(12);
                while (true) {
                    if (zzstVar.b() >= i2) {
                        break;
                    }
                    int b3 = zzstVar.b();
                    int d3 = zzstVar.d();
                    if (zzstVar.d() == y10.C0) {
                        zzstVar.k(b3);
                        int i3 = b3 + d3;
                        zzstVar.l(8);
                        ArrayList arrayList = new ArrayList();
                        while (zzstVar.b() < i3) {
                            zzpo.zza d4 = j20.d(zzstVar);
                            if (d4 != null) {
                                arrayList.add(d4);
                            }
                        }
                        if (!arrayList.isEmpty()) {
                            return new zzpo(arrayList);
                        }
                    } else {
                        zzstVar.l(d3 - 8);
                    }
                }
                return null;
            }
            zzstVar.l(d2 - 8);
        }
        return null;
    }

    private static Pair<String, byte[]> e(zzst zzstVar, int i2) {
        zzstVar.k(i2 + 8 + 4);
        zzstVar.l(1);
        f(zzstVar);
        zzstVar.l(2);
        int g2 = zzstVar.g();
        if ((g2 & 128) != 0) {
            zzstVar.l(2);
        }
        if ((g2 & 64) != 0) {
            zzstVar.l(zzstVar.h());
        }
        if ((g2 & 32) != 0) {
            zzstVar.l(2);
        }
        zzstVar.l(1);
        f(zzstVar);
        int g3 = zzstVar.g();
        String str = null;
        if (g3 == 32) {
            str = "video/mp4v-es";
        } else if (g3 == 33) {
            str = "video/avc";
        } else if (g3 != 35) {
            if (g3 != 64) {
                if (g3 == 107) {
                    return Pair.create("audio/mpeg", null);
                }
                if (g3 == 165) {
                    str = "audio/ac3";
                } else if (g3 != 166) {
                    switch (g3) {
                        case 102:
                        case 103:
                        case 104:
                            break;
                        default:
                            switch (g3) {
                                case 169:
                                case 172:
                                    return Pair.create("audio/vnd.dts", null);
                                case 170:
                                case 171:
                                    return Pair.create("audio/vnd.dts.hd", null);
                            }
                    }
                } else {
                    str = "audio/eac3";
                }
            }
            str = "audio/mp4a-latm";
        } else {
            str = "video/hevc";
        }
        zzstVar.l(12);
        zzstVar.l(1);
        int f2 = f(zzstVar);
        byte[] bArr = new byte[f2];
        zzstVar.n(bArr, 0, f2);
        return Pair.create(str, bArr);
    }

    private static int f(zzst zzstVar) {
        int g2 = zzstVar.g();
        int i2 = g2 & 127;
        while ((g2 & 128) == 128) {
            g2 = zzstVar.g();
            i2 = (i2 << 7) | (g2 & 127);
        }
        return i2;
    }
}
