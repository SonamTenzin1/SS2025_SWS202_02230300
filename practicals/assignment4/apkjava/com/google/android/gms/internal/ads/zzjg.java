package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public final class zzjg implements zzid {
    private int A;
    private int B;
    private long C;
    private boolean D;
    private boolean E;
    private zzif F;
    private final e00 a;

    /* renamed from: b, reason: collision with root package name */
    private final g00 f16340b;

    /* renamed from: c, reason: collision with root package name */
    private final zzkm f16341c;

    /* renamed from: d, reason: collision with root package name */
    private final zzkm f16342d;

    /* renamed from: e, reason: collision with root package name */
    private final zzkm f16343e;

    /* renamed from: f, reason: collision with root package name */
    private long f16344f;

    /* renamed from: g, reason: collision with root package name */
    private long f16345g;

    /* renamed from: h, reason: collision with root package name */
    private long f16346h;

    /* renamed from: i, reason: collision with root package name */
    private long f16347i;

    /* renamed from: j, reason: collision with root package name */
    private j00 f16348j;

    /* renamed from: k, reason: collision with root package name */
    private j00 f16349k;
    private j00 l;
    private boolean m;
    private int n;
    private long o;
    private boolean p;
    private long q;
    private long r;
    private int s;
    private long t;
    private zzkk u;
    private zzkk v;
    private boolean w;
    private int x;
    private int y;
    private int z;

    public zzjg() {
        this(new b00());
    }

    private final void g(zzip zzipVar) {
        zzipVar.d(this.C, this.B, this.z, 0, null);
        this.y = 0;
        this.D = true;
    }

    private static boolean h(String str) {
        return "V_VP8".equals(str) || "V_VP9".equals(str) || "A_OPUS".equals(str) || "A_VORBIS".equals(str);
    }

    private final long k(long j2) {
        return TimeUnit.NANOSECONDS.toMicros(j2 * this.f16346h);
    }

    private final ArrayList<byte[]> l() throws zzhl {
        try {
            byte[] bArr = this.f16349k.f12797j;
            if (bArr[0] == 2) {
                int i2 = 1;
                int i3 = 0;
                while (bArr[i2] == -1) {
                    i3 += 255;
                    i2++;
                }
                int i4 = i2 + 1;
                int i5 = i3 + bArr[i2];
                int i6 = 0;
                while (bArr[i4] == -1) {
                    i6 += 255;
                    i4++;
                }
                int i7 = i4 + 1;
                int i8 = i6 + bArr[i4];
                if (bArr[i7] == 1) {
                    byte[] bArr2 = new byte[i5];
                    System.arraycopy(bArr, i7, bArr2, 0, i5);
                    int i9 = i7 + i5;
                    if (bArr[i9] == 3) {
                        int i10 = i9 + i8;
                        if (bArr[i10] == 5) {
                            byte[] bArr3 = new byte[bArr.length - i10];
                            System.arraycopy(bArr, i10, bArr3, 0, bArr.length - i10);
                            ArrayList<byte[]> arrayList = new ArrayList<>(2);
                            arrayList.add(bArr2);
                            arrayList.add(bArr3);
                            return arrayList;
                        }
                        throw new zzhl("Error parsing vorbis codec private");
                    }
                    throw new zzhl("Error parsing vorbis codec private");
                }
                throw new zzhl("Error parsing vorbis codec private");
            }
            throw new zzhl("Error parsing vorbis codec private");
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new zzhl("Error parsing vorbis codec private");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(int i2, double d2) {
        if (i2 == 181) {
            this.f16348j.f12796i = (int) d2;
        } else {
            if (i2 != 17545) {
                return;
            }
            this.f16347i = k((long) d2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0091, code lost:
    
        if (r8.f12789b != r10) goto L40;
     */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0129  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void b(int i2, int i3, zzie zzieVar) throws IOException, InterruptedException {
        boolean z;
        j00 j00Var;
        if (i2 != 161 && i2 != 163) {
            if (i2 == 18402) {
                byte[] bArr = new byte[i3];
                this.f16348j.f12792e = bArr;
                zzieVar.readFully(bArr, 0, i3);
                return;
            } else {
                if (i2 == 21419) {
                    Arrays.fill(this.f16343e.a, (byte) 0);
                    zzieVar.readFully(this.f16343e.a, 4 - i3, i3);
                    this.f16343e.g(0);
                    this.n = (int) this.f16343e.k();
                    return;
                }
                if (i2 == 25506) {
                    byte[] bArr2 = new byte[i3];
                    this.f16348j.f12797j = bArr2;
                    zzieVar.readFully(bArr2, 0, i3);
                    return;
                } else {
                    StringBuilder sb = new StringBuilder(26);
                    sb.append("Unexpected id: ");
                    sb.append(i2);
                    throw new IllegalStateException(sb.toString());
                }
            }
        }
        if (this.y == 0) {
            this.A = (int) this.f16340b.b(zzieVar, false, true);
            this.x = this.f16340b.c();
            this.y = 1;
        }
        j00 j00Var2 = this.f16349k;
        if (j00Var2 != null && (r8 = this.l) != null) {
            int i4 = j00Var2.f12789b;
            int i5 = this.A;
            if (i4 != i5) {
            }
        }
        if ((j00Var2 == null || this.l != null || j00Var2.f12789b == this.A) && (j00Var2 != null || (j00Var = this.l) == null || j00Var.f12789b == this.A)) {
            if (j00Var2 == null || this.A != j00Var2.f12789b) {
                j00Var2 = this.l;
            }
            zzip zzipVar = j00Var2.m;
            if (this.y == 1) {
                byte[] bArr3 = this.f16341c.a;
                int i6 = j00Var2.f12791d ? 4 : 3;
                zzieVar.readFully(bArr3, 0, i6);
                this.x += i6;
                this.C = this.t + k((bArr3[0] << 8) | (bArr3[1] & 255));
                int i7 = (bArr3[2] & 6) >> 1;
                if (i7 == 0) {
                    boolean z2 = (bArr3[2] & 8) == 8;
                    int i8 = (i2 == 163 && (bArr3[2] & 128) == 128) ? 1 : 0;
                    if (j00Var2.f12791d) {
                        if ((bArr3[3] & 128) != 128) {
                            if ((bArr3[3] & 1) == 1) {
                                z = true;
                                this.B = (!z2 ? 134217728 : 0) | i8 | (!z ? 2 : 0);
                                this.z = i3 - this.x;
                                if (z) {
                                    zzkm zzkmVar = this.f16341c;
                                    zzkmVar.a[0] = 8;
                                    zzkmVar.g(0);
                                    zzipVar.c(this.f16341c, 1);
                                    this.z++;
                                }
                                this.y = 2;
                            }
                        } else {
                            throw new zzhl("Extension bit is set in signal byte");
                        }
                    }
                    z = false;
                    this.B = (!z2 ? 134217728 : 0) | i8 | (!z ? 2 : 0);
                    this.z = i3 - this.x;
                    if (z) {
                    }
                    this.y = 2;
                } else {
                    StringBuilder sb2 = new StringBuilder(38);
                    sb2.append("Lacing mode not supported: ");
                    sb2.append(i7);
                    throw new zzhl(sb2.toString());
                }
            }
            while (true) {
                int i9 = this.x;
                if (i9 >= i3) {
                    break;
                } else {
                    this.x = i9 + zzipVar.a(zzieVar, i3 - i9);
                }
            }
            if ("A_VORBIS".equals(j00Var2.a)) {
                this.f16342d.g(0);
                zzipVar.c(this.f16342d, 4);
                this.z += 4;
            }
            if (i2 == 163) {
                g(zzipVar);
                return;
            }
            return;
        }
        zzieVar.a(i3 - this.x);
        this.y = 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x003c A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0005 A[SYNTHETIC] */
    @Override // com.google.android.gms.internal.ads.zzid
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int c(zzie zzieVar, zzij zzijVar) throws IOException, InterruptedException {
        boolean z;
        this.D = false;
        boolean z2 = true;
        while (z2 && !this.D) {
            z2 = this.a.c(zzieVar);
            if (z2) {
                long position = zzieVar.getPosition();
                if (this.p) {
                    this.r = position;
                    zzijVar.a = this.q;
                    this.s = 1;
                    this.p = false;
                } else {
                    if (this.s == 2) {
                        long j2 = this.r;
                        if (j2 != -1) {
                            zzijVar.a = j2;
                            this.r = -1L;
                        }
                    }
                    z = false;
                    if (!z) {
                        return 1;
                    }
                }
                z = true;
                if (!z) {
                }
            }
        }
        return z2 ? 0 : -1;
    }

    @Override // com.google.android.gms.internal.ads.zzid
    public final void d(zzif zzifVar) {
        this.F = zzifVar;
    }

    @Override // com.google.android.gms.internal.ads.zzid
    public final void e() {
        this.t = -1L;
        this.y = 0;
        this.a.a();
        this.f16340b.a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void f(int i2, String str) throws zzhl {
        if (i2 != 134) {
            if (i2 == 17026 && !"webm".equals(str)) {
                StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 22);
                sb.append("DocType ");
                sb.append(str);
                sb.append(" not supported");
                throw new zzhl(sb.toString());
            }
            return;
        }
        this.f16348j.a = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void i(int i2, long j2, long j3) throws zzhl {
        if (i2 == 160) {
            this.E = false;
            return;
        }
        if (i2 == 174) {
            this.f16348j = new j00();
            return;
        }
        if (i2 == 187) {
            this.w = false;
            return;
        }
        if (i2 == 19899) {
            this.n = -1;
            this.o = -1L;
            return;
        }
        if (i2 == 20533) {
            this.f16348j.f12791d = true;
            return;
        }
        if (i2 == 408125543) {
            if (this.f16344f == -1) {
                this.f16344f = j2;
                this.f16345g = j3;
                return;
            }
            throw new zzhl("Multiple Segment elements not supported");
        }
        if (i2 != 475249515) {
            if (i2 == 524531317 && this.s == 0 && this.q != -1) {
                this.p = true;
                return;
            }
            return;
        }
        this.u = new zzkk();
        this.v = new zzkk();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void j(int i2, long j2) throws zzhl {
        switch (i2) {
            case 131:
                this.f16348j.f12790c = (int) j2;
                return;
            case 159:
                this.f16348j.f12795h = (int) j2;
                return;
            case 176:
                this.f16348j.f12793f = (int) j2;
                return;
            case 179:
                this.u.a(k(j2));
                return;
            case 186:
                this.f16348j.f12794g = (int) j2;
                return;
            case 215:
                this.f16348j.f12789b = (int) j2;
                return;
            case 231:
                this.t = k(j2);
                return;
            case 241:
                if (this.w) {
                    return;
                }
                this.v.a(j2);
                this.w = true;
                return;
            case 251:
                this.E = true;
                return;
            case 17029:
                if (j2 < 1 || j2 > 2) {
                    StringBuilder sb = new StringBuilder(53);
                    sb.append("DocTypeReadVersion ");
                    sb.append(j2);
                    sb.append(" not supported");
                    throw new zzhl(sb.toString());
                }
                return;
            case 17143:
                if (j2 == 1) {
                    return;
                }
                StringBuilder sb2 = new StringBuilder(50);
                sb2.append("EBMLReadVersion ");
                sb2.append(j2);
                sb2.append(" not supported");
                throw new zzhl(sb2.toString());
            case 18401:
                if (j2 == 5) {
                    return;
                }
                StringBuilder sb3 = new StringBuilder(49);
                sb3.append("ContentEncAlgo ");
                sb3.append(j2);
                sb3.append(" not supported");
                throw new zzhl(sb3.toString());
            case 18408:
                if (j2 == 1) {
                    return;
                }
                StringBuilder sb4 = new StringBuilder(56);
                sb4.append("AESSettingsCipherMode ");
                sb4.append(j2);
                sb4.append(" not supported");
                throw new zzhl(sb4.toString());
            case 20529:
                if (j2 == 0) {
                    return;
                }
                StringBuilder sb5 = new StringBuilder(55);
                sb5.append("ContentEncodingOrder ");
                sb5.append(j2);
                sb5.append(" not supported");
                throw new zzhl(sb5.toString());
            case 20530:
                if (j2 == 1) {
                    return;
                }
                StringBuilder sb6 = new StringBuilder(55);
                sb6.append("ContentEncodingScope ");
                sb6.append(j2);
                sb6.append(" not supported");
                throw new zzhl(sb6.toString());
            case 20531:
                if (j2 == 1) {
                    return;
                }
                StringBuilder sb7 = new StringBuilder(54);
                sb7.append("ContentEncodingType ");
                sb7.append(j2);
                sb7.append(" not supported");
                throw new zzhl(sb7.toString());
            case 21420:
                this.o = j2 + this.f16344f;
                return;
            case 22186:
                this.f16348j.f12798k = j2;
                return;
            case 22203:
                this.f16348j.l = j2;
                return;
            case 2807729:
                this.f16346h = j2;
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void m(int i2) throws zzhl {
        int i3;
        zzhj e2;
        zzhj g2;
        if (i2 == 160) {
            if (this.y != 2) {
                return;
            }
            if (!this.E) {
                this.B |= 1;
            }
            j00 j00Var = this.f16349k;
            if (j00Var == null || this.A != j00Var.f12789b) {
                j00Var = this.l;
            }
            g(j00Var.m);
            return;
        }
        if (i2 == 174) {
            j00 j00Var2 = this.f16348j;
            if (j00Var2.f12789b != -1 && (i3 = j00Var2.f12790c) != -1) {
                if ((i3 == 2 && this.f16349k != null) || (i3 == 1 && this.l != null)) {
                    this.f16348j = null;
                    return;
                }
                if (i3 == 2 && h(j00Var2.a)) {
                    j00 j00Var3 = this.f16348j;
                    this.f16349k = j00Var3;
                    j00Var3.m = this.F.f(j00Var3.f12789b);
                    j00 j00Var4 = this.f16349k;
                    zzip zzipVar = j00Var4.m;
                    if (j00Var4 != null && "A_VORBIS".equals(j00Var4.a)) {
                        long j2 = this.f16347i;
                        j00 j00Var5 = this.f16349k;
                        g2 = zzhj.g("audio/vorbis", 8192, j2, j00Var5.f12795h, j00Var5.f12796i, l());
                    } else {
                        j00 j00Var6 = this.f16349k;
                        if (j00Var6 != null && "A_OPUS".equals(j00Var6.a)) {
                            ArrayList arrayList = new ArrayList(3);
                            arrayList.add(this.f16349k.f12797j);
                            arrayList.add(ByteBuffer.allocate(64).putLong(this.f16349k.f12798k).array());
                            arrayList.add(ByteBuffer.allocate(64).putLong(this.f16349k.l).array());
                            long j3 = this.f16347i;
                            j00 j00Var7 = this.f16349k;
                            g2 = zzhj.g("audio/opus", 5760, j3, j00Var7.f12795h, j00Var7.f12796i, arrayList);
                        } else {
                            throw new zzhl("Unable to build format");
                        }
                    }
                    zzipVar.b(g2);
                } else {
                    j00 j00Var8 = this.f16348j;
                    if (j00Var8.f12790c == 1 && h(j00Var8.a)) {
                        j00 j00Var9 = this.f16348j;
                        this.l = j00Var9;
                        j00Var9.m = this.F.f(j00Var9.f12789b);
                        j00 j00Var10 = this.l;
                        zzip zzipVar2 = j00Var10.m;
                        if (j00Var10 != null && "V_VP8".equals(j00Var10.a)) {
                            long j4 = this.f16347i;
                            j00 j00Var11 = this.l;
                            e2 = zzhj.e("video/x-vnd.on2.vp8", -1, j4, j00Var11.f12793f, j00Var11.f12794g, null);
                        } else {
                            j00 j00Var12 = this.l;
                            if (j00Var12 != null && "V_VP9".equals(j00Var12.a)) {
                                long j5 = this.f16347i;
                                j00 j00Var13 = this.l;
                                e2 = zzhj.e("video/x-vnd.on2.vp9", -1, j5, j00Var13.f12793f, j00Var13.f12794g, null);
                            } else {
                                throw new zzhl("Unable to build format");
                            }
                        }
                        zzipVar2.b(e2);
                    }
                }
                this.f16348j = null;
                return;
            }
            throw new zzhl("Mandatory element TrackNumber or TrackType not found");
        }
        if (i2 == 19899) {
            int i4 = this.n;
            if (i4 != -1) {
                long j6 = this.o;
                if (j6 != -1) {
                    if (i4 == 475249515) {
                        this.q = j6;
                        return;
                    }
                    return;
                }
            }
            throw new zzhl("Mandatory element SeekID or SeekPosition not found");
        }
        if (i2 == 25152) {
            j00 j00Var14 = this.f16348j;
            if (j00Var14.f12791d) {
                byte[] bArr = j00Var14.f12792e;
                if (bArr != null) {
                    if (this.m) {
                        return;
                    }
                    this.F.e(new zzhy("video/webm", bArr));
                    this.m = true;
                    return;
                }
                throw new zzhl("Encrypted Track found but ContentEncKeyID was not found");
            }
            throw new zzhl("Found an unsupported ContentEncoding");
        }
        if (i2 != 374648427) {
            if (i2 != 475249515 || this.s == 2) {
                return;
            }
            zzif zzifVar = this.F;
            if (this.f16344f == -1) {
                throw new zzhl("Segment start/end offsets unknown");
            }
            if (this.f16347i != -1) {
                zzkk zzkkVar = this.u;
                if (zzkkVar != null && this.v != null && zzkkVar.c() != 0 && this.u.c() == this.v.c()) {
                    int c2 = this.u.c();
                    int[] iArr = new int[c2];
                    long[] jArr = new long[c2];
                    long[] jArr2 = new long[c2];
                    long[] jArr3 = new long[c2];
                    int i5 = 0;
                    for (int i6 = 0; i6 < c2; i6++) {
                        jArr3[i6] = this.u.b(i6);
                        jArr[i6] = this.f16344f + this.v.b(i6);
                    }
                    while (true) {
                        int i7 = c2 - 1;
                        if (i5 < i7) {
                            int i8 = i5 + 1;
                            iArr[i5] = (int) (jArr[i8] - jArr[i5]);
                            jArr2[i5] = jArr3[i8] - jArr3[i5];
                            i5 = i8;
                        } else {
                            iArr[i7] = (int) ((this.f16344f + this.f16345g) - jArr[i7]);
                            jArr2[i7] = this.f16347i - jArr3[i7];
                            this.u = null;
                            this.v = null;
                            zzifVar.g(new zzia(iArr, jArr, jArr2, jArr3));
                            this.s = 2;
                            return;
                        }
                    }
                } else {
                    throw new zzhl("Invalid/missing cue points");
                }
            } else {
                throw new zzhl("Duration unknown");
            }
        } else {
            if (this.l == null && this.f16349k == null) {
                throw new zzhl("No valid tracks were found");
            }
            this.F.d();
        }
    }

    private zzjg(e00 e00Var) {
        this.f16344f = -1L;
        this.f16345g = -1L;
        this.f16346h = 1000000L;
        this.f16347i = -1L;
        this.q = -1L;
        this.r = -1L;
        this.s = 0;
        this.t = -1L;
        this.a = e00Var;
        e00Var.b(new i00(this));
        this.f16340b = new g00();
        this.f16341c = new zzkm(4);
        this.f16342d = new zzkm(ByteBuffer.allocate(4).putInt(-1).array());
        this.f16343e = new zzkm(4);
    }
}
