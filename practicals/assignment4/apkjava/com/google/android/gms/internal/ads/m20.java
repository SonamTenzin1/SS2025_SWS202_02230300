package com.google.android.gms.internal.ads;

import java.io.IOException;

/* loaded from: classes2.dex */
final class m20 {
    private static final int[] a = {zzsy.i("isom"), zzsy.i("iso2"), zzsy.i("iso3"), zzsy.i("iso4"), zzsy.i("iso5"), zzsy.i("iso6"), zzsy.i("avc1"), zzsy.i("hvc1"), zzsy.i("hev1"), zzsy.i("mp41"), zzsy.i("mp42"), zzsy.i("3g2a"), zzsy.i("3g2b"), zzsy.i("3gr6"), zzsy.i("3gs6"), zzsy.i("3ge6"), zzsy.i("3gg6"), zzsy.i("M4V "), zzsy.i("M4A "), zzsy.i("f4v "), zzsy.i("kddi"), zzsy.i("M4VP"), zzsy.i("qt  "), zzsy.i("MSNV")};

    /* JADX WARN: Removed duplicated region for block: B:44:0x00a5 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00a7 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean a(zzno zznoVar) throws IOException, InterruptedException {
        boolean z;
        boolean z2;
        long f2 = zznoVar.f();
        if (f2 == -1 || f2 > 4096) {
            f2 = 4096;
        }
        int i2 = (int) f2;
        zzst zzstVar = new zzst(64);
        int i3 = 0;
        boolean z3 = false;
        while (i3 < i2) {
            zzstVar.j(8);
            zznoVar.d(zzstVar.a, 0, 8);
            long q = zzstVar.q();
            int d2 = zzstVar.d();
            int i4 = 16;
            if (q == 1) {
                zznoVar.d(zzstVar.a, 8, 8);
                zzstVar.o(16);
                q = zzstVar.t();
            } else {
                i4 = 8;
            }
            long j2 = i4;
            if (q < j2) {
                break;
            }
            i3 += i4;
            if (d2 != y10.B) {
                if (d2 == y10.K || d2 == y10.M) {
                    z = true;
                    break;
                }
                if ((i3 + q) - j2 >= i2) {
                    break;
                }
                int i5 = (int) (q - j2);
                i3 += i5;
                if (d2 == y10.a) {
                    if (i5 < 8) {
                        break;
                    }
                    zzstVar.j(i5);
                    zznoVar.d(zzstVar.a, 0, i5);
                    int i6 = i5 / 4;
                    int i7 = 0;
                    while (true) {
                        if (i7 >= i6) {
                            break;
                        }
                        if (i7 == 1) {
                            zzstVar.l(4);
                        } else {
                            int d3 = zzstVar.d();
                            if ((d3 >>> 8) != zzsy.i("3gp")) {
                                for (int i8 : a) {
                                    if (i8 != d3) {
                                    }
                                }
                                z2 = false;
                                if (!z2) {
                                    z3 = true;
                                    break;
                                }
                            }
                            z2 = true;
                            if (!z2) {
                            }
                        }
                        i7++;
                    }
                    if (!z3) {
                        break;
                    }
                } else if (i5 != 0) {
                    zznoVar.g(i5);
                }
            }
        }
        z = false;
        return z3 && !z;
    }
}
