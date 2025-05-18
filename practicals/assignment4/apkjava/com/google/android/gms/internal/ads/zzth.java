package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Point;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.SystemClock;
import android.util.Log;
import android.view.Surface;
import java.nio.ByteBuffer;

@TargetApi(16)
/* loaded from: classes2.dex */
public final class zzth extends zzpe {
    private static final int[] V = {1920, 1600, 1440, 1280, 960, 854, 640, 540, 480};
    private long A0;
    private int B0;
    private final Context W;
    private final zztl X;
    private final zzto Y;
    private final long Z;
    private final int a0;
    private final boolean b0;
    private final long[] c0;
    private zzlh[] d0;
    private zztj e0;
    private Surface f0;
    private Surface g0;
    private int h0;
    private boolean i0;
    private long j0;
    private long k0;
    private int l0;
    private int m0;
    private int n0;
    private float o0;
    private int p0;
    private int q0;
    private int r0;
    private float s0;
    private int t0;
    private int u0;
    private int v0;
    private float w0;
    private boolean x0;
    private int y0;
    t30 z0;

    public zzth(Context context, zzpg zzpgVar, long j2, Handler handler, zztn zztnVar, int i2) {
        this(context, zzpgVar, 0L, null, false, handler, zztnVar, -1);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:7:0x0057. Please report as an issue. */
    private static int a0(String str, int i2, int i3) {
        char c2;
        int i4;
        if (i2 == -1 || i3 == -1) {
            return -1;
        }
        str.hashCode();
        int i5 = 4;
        switch (str.hashCode()) {
            case -1664118616:
                if (str.equals("video/3gpp")) {
                    c2 = 0;
                    break;
                }
                c2 = 65535;
                break;
            case -1662541442:
                if (str.equals("video/hevc")) {
                    c2 = 1;
                    break;
                }
                c2 = 65535;
                break;
            case 1187890754:
                if (str.equals("video/mp4v-es")) {
                    c2 = 2;
                    break;
                }
                c2 = 65535;
                break;
            case 1331836730:
                if (str.equals("video/avc")) {
                    c2 = 3;
                    break;
                }
                c2 = 65535;
                break;
            case 1599127256:
                if (str.equals("video/x-vnd.on2.vp8")) {
                    c2 = 4;
                    break;
                }
                c2 = 65535;
                break;
            case 1599127257:
                if (str.equals("video/x-vnd.on2.vp9")) {
                    c2 = 5;
                    break;
                }
                c2 = 65535;
                break;
            default:
                c2 = 65535;
                break;
        }
        switch (c2) {
            case 0:
            case 2:
            case 4:
                i4 = i2 * i3;
                i5 = 2;
                return (i4 * 3) / (i5 * 2);
            case 1:
            case 5:
                i4 = i2 * i3;
                return (i4 * 3) / (i5 * 2);
            case 3:
                if ("BRAVIA 4K 2015".equals(zzsy.f16742d)) {
                    return -1;
                }
                i4 = ((zzsy.j(i2, 16) * zzsy.j(i3, 16)) << 4) << 4;
                i5 = 2;
                return (i4 * 3) / (i5 * 2);
            default:
                return -1;
        }
    }

    private final void b0(MediaCodec mediaCodec, int i2, long j2) {
        zzsx.a("skipVideoBuffer");
        mediaCodec.releaseOutputBuffer(i2, false);
        zzsx.b();
        this.U.f16498e++;
    }

    @TargetApi(21)
    private final void c0(MediaCodec mediaCodec, int i2, long j2, long j3) {
        f0();
        zzsx.a("releaseOutputBuffer");
        mediaCodec.releaseOutputBuffer(i2, j3);
        zzsx.b();
        this.U.f16497d++;
        this.m0 = 0;
        l0();
    }

    private static boolean d0(boolean z, zzlh zzlhVar, zzlh zzlhVar2) {
        if (!zzlhVar.f16427k.equals(zzlhVar2.f16427k) || i0(zzlhVar) != i0(zzlhVar2)) {
            return false;
        }
        if (z) {
            return true;
        }
        return zzlhVar.o == zzlhVar2.o && zzlhVar.p == zzlhVar2.p;
    }

    private final void e0(MediaCodec mediaCodec, int i2, long j2) {
        f0();
        zzsx.a("releaseOutputBuffer");
        mediaCodec.releaseOutputBuffer(i2, true);
        zzsx.b();
        this.U.f16497d++;
        this.m0 = 0;
        l0();
    }

    private final void f0() {
        int i2 = this.t0;
        int i3 = this.p0;
        if (i2 == i3 && this.u0 == this.q0 && this.v0 == this.r0 && this.w0 == this.s0) {
            return;
        }
        this.Y.b(i3, this.q0, this.r0, this.s0);
        this.t0 = this.p0;
        this.u0 = this.q0;
        this.v0 = this.r0;
        this.w0 = this.s0;
    }

    private static boolean g0(long j2) {
        return j2 < -30000;
    }

    private static int h0(zzlh zzlhVar) {
        int i2 = zzlhVar.l;
        return i2 != -1 ? i2 : a0(zzlhVar.f16427k, zzlhVar.o, zzlhVar.p);
    }

    private static int i0(zzlh zzlhVar) {
        int i2 = zzlhVar.r;
        if (i2 == -1) {
            return 0;
        }
        return i2;
    }

    private final void j0() {
        this.j0 = this.Z > 0 ? SystemClock.elapsedRealtime() + this.Z : -9223372036854775807L;
    }

    private final void k0() {
        MediaCodec W;
        this.i0 = false;
        if (zzsy.a < 23 || !this.x0 || (W = W()) == null) {
            return;
        }
        this.z0 = new t30(this, W);
    }

    private final void m0() {
        this.t0 = -1;
        this.u0 = -1;
        this.w0 = -1.0f;
        this.v0 = -1;
    }

    private final void n0() {
        if (this.t0 == -1 && this.u0 == -1) {
            return;
        }
        this.Y.b(this.p0, this.q0, this.r0, this.s0);
    }

    private final void o0() {
        if (this.l0 > 0) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            this.Y.h(this.l0, elapsedRealtime - this.k0);
            this.l0 = 0;
            this.k0 = elapsedRealtime;
        }
    }

    private final boolean p0(boolean z) {
        if (zzsy.a < 23 || this.x0) {
            return false;
        }
        return !z || zztd.b(this.W);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzpe
    public final void A(zzlh zzlhVar) throws zzku {
        super.A(zzlhVar);
        this.Y.d(zzlhVar);
        float f2 = zzlhVar.s;
        if (f2 == -1.0f) {
            f2 = 1.0f;
        }
        this.o0 = f2;
        this.n0 = i0(zzlhVar);
    }

    @Override // com.google.android.gms.internal.ads.zzpe, com.google.android.gms.internal.ads.zzlo
    public final boolean B() {
        Surface surface;
        if (super.B() && (this.i0 || (((surface = this.g0) != null && this.f0 == surface) || W() == null))) {
            this.j0 = -9223372036854775807L;
            return true;
        }
        if (this.j0 == -9223372036854775807L) {
            return false;
        }
        if (SystemClock.elapsedRealtime() < this.j0) {
            return true;
        }
        this.j0 = -9223372036854775807L;
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzpe
    protected final void R(String str, long j2, long j3) {
        this.Y.f(str, j2, j3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzpe
    public final void U() {
        try {
            super.U();
            Surface surface = this.g0;
            if (surface != null) {
                if (this.f0 == surface) {
                    this.f0 = null;
                }
                surface.release();
                this.g0 = null;
            }
        } catch (Throwable th) {
            if (this.g0 != null) {
                Surface surface2 = this.f0;
                Surface surface3 = this.g0;
                if (surface2 == surface3) {
                    this.f0 = null;
                }
                surface3.release();
                this.g0 = null;
            }
            throw th;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzks, com.google.android.gms.internal.ads.zzkx
    public final void f(int i2, Object obj) throws zzku {
        if (i2 != 1) {
            if (i2 == 4) {
                this.h0 = ((Integer) obj).intValue();
                MediaCodec W = W();
                if (W != null) {
                    W.setVideoScalingMode(this.h0);
                    return;
                }
                return;
            }
            super.f(i2, obj);
            return;
        }
        Surface surface = (Surface) obj;
        if (surface == null) {
            Surface surface2 = this.g0;
            if (surface2 != null) {
                surface = surface2;
            } else {
                zzpd X = X();
                if (X != null && p0(X.f16571d)) {
                    surface = zztd.a(this.W, X.f16571d);
                    this.g0 = surface;
                }
            }
        }
        if (this.f0 != surface) {
            this.f0 = surface;
            int state = getState();
            if (state == 1 || state == 2) {
                MediaCodec W2 = W();
                if (zzsy.a >= 23 && W2 != null && surface != null) {
                    W2.setOutputSurface(surface);
                } else {
                    U();
                    T();
                }
            }
            if (surface != null && surface != this.g0) {
                n0();
                k0();
                if (state == 2) {
                    j0();
                    return;
                }
                return;
            }
            m0();
            k0();
            return;
        }
        if (surface == null || surface == this.g0) {
            return;
        }
        n0();
        if (this.i0) {
            this.Y.c(this.f0);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzpe, com.google.android.gms.internal.ads.zzks
    public final void h() {
        super.h();
        this.l0 = 0;
        this.k0 = SystemClock.elapsedRealtime();
        this.j0 = -9223372036854775807L;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzpe, com.google.android.gms.internal.ads.zzks
    public final void i() {
        o0();
        super.i();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzks
    public final void k(zzlh[] zzlhVarArr, long j2) throws zzku {
        this.d0 = zzlhVarArr;
        if (this.A0 == -9223372036854775807L) {
            this.A0 = j2;
        } else {
            int i2 = this.B0;
            long[] jArr = this.c0;
            if (i2 == jArr.length) {
                long j3 = jArr[i2 - 1];
                StringBuilder sb = new StringBuilder(65);
                sb.append("Too many stream changes, so dropping offset: ");
                sb.append(j3);
                Log.w("MediaCodecVideoRenderer", sb.toString());
            } else {
                this.B0 = i2 + 1;
            }
            this.c0[this.B0 - 1] = j2;
        }
        super.k(zzlhVarArr, j2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzpe, com.google.android.gms.internal.ads.zzks
    public final void l(long j2, boolean z) throws zzku {
        super.l(j2, z);
        k0();
        this.m0 = 0;
        int i2 = this.B0;
        if (i2 != 0) {
            this.A0 = this.c0[i2 - 1];
            this.B0 = 0;
        }
        if (z) {
            j0();
        } else {
            this.j0 = -9223372036854775807L;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void l0() {
        if (this.i0) {
            return;
        }
        this.i0 = true;
        this.Y.c(this.f0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzpe, com.google.android.gms.internal.ads.zzks
    public final void n() {
        this.p0 = -1;
        this.q0 = -1;
        this.s0 = -1.0f;
        this.o0 = -1.0f;
        this.A0 = -9223372036854775807L;
        this.B0 = 0;
        m0();
        k0();
        this.X.a();
        this.z0 = null;
        this.x0 = false;
        try {
            super.n();
        } finally {
            this.U.a();
            this.Y.g(this.U);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzpe, com.google.android.gms.internal.ads.zzks
    public final void o(boolean z) throws zzku {
        super.o(z);
        int i2 = p().f16434b;
        this.y0 = i2;
        this.x0 = i2 != 0;
        this.Y.e(this.U);
        this.X.b();
    }

    @Override // com.google.android.gms.internal.ads.zzpe
    protected final void r(MediaCodec mediaCodec, MediaFormat mediaFormat) {
        int integer;
        int integer2;
        boolean z = mediaFormat.containsKey("crop-right") && mediaFormat.containsKey("crop-left") && mediaFormat.containsKey("crop-bottom") && mediaFormat.containsKey("crop-top");
        if (z) {
            integer = (mediaFormat.getInteger("crop-right") - mediaFormat.getInteger("crop-left")) + 1;
        } else {
            integer = mediaFormat.getInteger("width");
        }
        this.p0 = integer;
        if (z) {
            integer2 = (mediaFormat.getInteger("crop-bottom") - mediaFormat.getInteger("crop-top")) + 1;
        } else {
            integer2 = mediaFormat.getInteger("height");
        }
        this.q0 = integer2;
        float f2 = this.o0;
        this.s0 = f2;
        if (zzsy.a >= 21) {
            int i2 = this.n0;
            if (i2 == 90 || i2 == 270) {
                int i3 = this.p0;
                this.p0 = integer2;
                this.q0 = i3;
                this.s0 = 1.0f / f2;
            }
        } else {
            this.r0 = this.n0;
        }
        mediaCodec.setVideoScalingMode(this.h0);
    }

    @Override // com.google.android.gms.internal.ads.zzpe
    protected final int s(zzpg zzpgVar, zzlh zzlhVar) throws zzpk {
        boolean z;
        int i2;
        int i3;
        String str = zzlhVar.f16427k;
        if (!zzsp.c(str)) {
            return 0;
        }
        zzne zzneVar = zzlhVar.n;
        if (zzneVar != null) {
            z = false;
            for (int i4 = 0; i4 < zzneVar.f16507h; i4++) {
                z |= zzneVar.a(i4).f16512j;
            }
        } else {
            z = false;
        }
        zzpd b2 = zzpgVar.b(str, z);
        if (b2 == null) {
            return 1;
        }
        boolean d2 = b2.d(zzlhVar.f16424h);
        if (d2 && (i2 = zzlhVar.o) > 0 && (i3 = zzlhVar.p) > 0) {
            if (zzsy.a >= 21) {
                d2 = b2.b(i2, i3, zzlhVar.q);
            } else {
                boolean z2 = i2 * i3 <= zzpi.g();
                if (!z2) {
                    int i5 = zzlhVar.o;
                    int i6 = zzlhVar.p;
                    String str2 = zzsy.f16743e;
                    StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + 56);
                    sb.append("FalseCheck [legacyFrameSize, ");
                    sb.append(i5);
                    sb.append("x");
                    sb.append(i6);
                    sb.append("] [");
                    sb.append(str2);
                    sb.append("]");
                    Log.d("MediaCodecVideoRenderer", sb.toString());
                }
                d2 = z2;
            }
        }
        return (d2 ? 3 : 2) | (b2.f16569b ? 8 : 4) | (b2.f16570c ? 16 : 0);
    }

    @Override // com.google.android.gms.internal.ads.zzpe
    protected final void u(zznd zzndVar) {
        if (zzsy.a >= 23 || !this.x0) {
            return;
        }
        l0();
    }

    @Override // com.google.android.gms.internal.ads.zzpe
    protected final void v(zzpd zzpdVar, MediaCodec mediaCodec, zzlh zzlhVar, MediaCrypto mediaCrypto) throws zzpk {
        zztj zztjVar;
        String str;
        Point point;
        zzlh[] zzlhVarArr = this.d0;
        int i2 = zzlhVar.o;
        int i3 = zzlhVar.p;
        int h0 = h0(zzlhVar);
        if (zzlhVarArr.length == 1) {
            zztjVar = new zztj(i2, i3, h0);
        } else {
            boolean z = false;
            for (zzlh zzlhVar2 : zzlhVarArr) {
                if (d0(zzpdVar.f16569b, zzlhVar, zzlhVar2)) {
                    int i4 = zzlhVar2.o;
                    z |= i4 == -1 || zzlhVar2.p == -1;
                    i2 = Math.max(i2, i4);
                    i3 = Math.max(i3, zzlhVar2.p);
                    h0 = Math.max(h0, h0(zzlhVar2));
                }
            }
            if (z) {
                StringBuilder sb = new StringBuilder(66);
                sb.append("Resolutions unknown. Codec max resolution: ");
                sb.append(i2);
                sb.append("x");
                sb.append(i3);
                String str2 = "MediaCodecVideoRenderer";
                Log.w("MediaCodecVideoRenderer", sb.toString());
                int i5 = zzlhVar.p;
                int i6 = zzlhVar.o;
                boolean z2 = i5 > i6;
                int i7 = z2 ? i5 : i6;
                if (z2) {
                    i5 = i6;
                }
                float f2 = i5 / i7;
                int[] iArr = V;
                int length = iArr.length;
                int i8 = 0;
                while (i8 < length) {
                    int i9 = length;
                    int i10 = iArr[i8];
                    int[] iArr2 = iArr;
                    int i11 = (int) (i10 * f2);
                    if (i10 <= i7 || i11 <= i5) {
                        break;
                    }
                    int i12 = i5;
                    float f3 = f2;
                    if (zzsy.a >= 21) {
                        int i13 = z2 ? i11 : i10;
                        if (!z2) {
                            i10 = i11;
                        }
                        point = zzpdVar.i(i13, i10);
                        str = str2;
                        if (zzpdVar.b(point.x, point.y, zzlhVar.q)) {
                            break;
                        }
                        i8++;
                        length = i9;
                        iArr = iArr2;
                        i5 = i12;
                        f2 = f3;
                        str2 = str;
                    } else {
                        str = str2;
                        int j2 = zzsy.j(i10, 16) << 4;
                        int j3 = zzsy.j(i11, 16) << 4;
                        if (j2 * j3 <= zzpi.g()) {
                            int i14 = z2 ? j3 : j2;
                            if (!z2) {
                                j2 = j3;
                            }
                            point = new Point(i14, j2);
                        } else {
                            i8++;
                            length = i9;
                            iArr = iArr2;
                            i5 = i12;
                            f2 = f3;
                            str2 = str;
                        }
                    }
                }
                str = str2;
                point = null;
                if (point != null) {
                    i2 = Math.max(i2, point.x);
                    i3 = Math.max(i3, point.y);
                    h0 = Math.max(h0, a0(zzlhVar.f16427k, i2, i3));
                    StringBuilder sb2 = new StringBuilder(57);
                    sb2.append("Codec max resolution adjusted to: ");
                    sb2.append(i2);
                    sb2.append("x");
                    sb2.append(i3);
                    Log.w(str, sb2.toString());
                }
            }
            zztjVar = new zztj(i2, i3, h0);
        }
        this.e0 = zztjVar;
        boolean z3 = this.b0;
        int i15 = this.y0;
        MediaFormat m = zzlhVar.m();
        m.setInteger("max-width", zztjVar.a);
        m.setInteger("max-height", zztjVar.f16763b);
        int i16 = zztjVar.f16764c;
        if (i16 != -1) {
            m.setInteger("max-input-size", i16);
        }
        if (z3) {
            m.setInteger("auto-frc", 0);
        }
        if (i15 != 0) {
            m.setFeatureEnabled("tunneled-playback", true);
            m.setInteger("audio-session-id", i15);
        }
        if (this.f0 == null) {
            zzsk.e(p0(zzpdVar.f16571d));
            if (this.g0 == null) {
                this.g0 = zztd.a(this.W, zzpdVar.f16571d);
            }
            this.f0 = this.g0;
        }
        mediaCodec.configure(m, this.f0, (MediaCrypto) null, 0);
        if (zzsy.a < 23 || !this.x0) {
            return;
        }
        this.z0 = new t30(this, mediaCodec);
    }

    @Override // com.google.android.gms.internal.ads.zzpe
    protected final boolean x(long j2, long j3, MediaCodec mediaCodec, ByteBuffer byteBuffer, int i2, int i3, long j4, boolean z) {
        while (true) {
            int i4 = this.B0;
            if (i4 == 0) {
                break;
            }
            long[] jArr = this.c0;
            if (j4 < jArr[0]) {
                break;
            }
            this.A0 = jArr[0];
            int i5 = i4 - 1;
            this.B0 = i5;
            System.arraycopy(jArr, 1, jArr, 0, i5);
        }
        long j5 = j4 - this.A0;
        if (z) {
            b0(mediaCodec, i2, j5);
            return true;
        }
        long j6 = j4 - j2;
        if (this.f0 == this.g0) {
            if (!g0(j6)) {
                return false;
            }
            b0(mediaCodec, i2, j5);
            return true;
        }
        if (!this.i0) {
            if (zzsy.a >= 21) {
                c0(mediaCodec, i2, j5, System.nanoTime());
            } else {
                e0(mediaCodec, i2, j5);
            }
            return true;
        }
        if (getState() != 2) {
            return false;
        }
        long elapsedRealtime = j6 - ((SystemClock.elapsedRealtime() * 1000) - j3);
        long nanoTime = System.nanoTime();
        long c2 = this.X.c(j4, (elapsedRealtime * 1000) + nanoTime);
        long j7 = (c2 - nanoTime) / 1000;
        if (g0(j7)) {
            zzsx.a("dropVideoBuffer");
            mediaCodec.releaseOutputBuffer(i2, false);
            zzsx.b();
            zznc zzncVar = this.U;
            zzncVar.f16499f++;
            this.l0++;
            int i6 = this.m0 + 1;
            this.m0 = i6;
            zzncVar.f16500g = Math.max(i6, zzncVar.f16500g);
            if (this.l0 == this.a0) {
                o0();
            }
            return true;
        }
        if (zzsy.a >= 21) {
            if (j7 < 50000) {
                c0(mediaCodec, i2, j5, c2);
                return true;
            }
        } else if (j7 < 30000) {
            if (j7 > 11000) {
                try {
                    Thread.sleep((j7 - 10000) / 1000);
                } catch (InterruptedException unused) {
                    Thread.currentThread().interrupt();
                }
            }
            e0(mediaCodec, i2, j5);
            return true;
        }
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzpe
    protected final boolean y(MediaCodec mediaCodec, boolean z, zzlh zzlhVar, zzlh zzlhVar2) {
        if (!d0(z, zzlhVar, zzlhVar2)) {
            return false;
        }
        int i2 = zzlhVar2.o;
        zztj zztjVar = this.e0;
        return i2 <= zztjVar.a && zzlhVar2.p <= zztjVar.f16763b && zzlhVar2.l <= zztjVar.f16764c;
    }

    @Override // com.google.android.gms.internal.ads.zzpe
    protected final boolean z(zzpd zzpdVar) {
        return this.f0 != null || p0(zzpdVar.f16571d);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    private zzth(Context context, zzpg zzpgVar, long j2, zznj<Object> zznjVar, boolean z, Handler handler, zztn zztnVar, int i2) {
        super(2, zzpgVar, null, false);
        boolean z2 = false;
        this.Z = 0L;
        this.a0 = -1;
        this.W = context.getApplicationContext();
        this.X = new zztl(context);
        this.Y = new zzto(handler, zztnVar);
        if (zzsy.a <= 22 && "foster".equals(zzsy.f16740b) && "NVIDIA".equals(zzsy.f16741c)) {
            z2 = true;
        }
        this.b0 = z2;
        this.c0 = new long[10];
        this.A0 = -9223372036854775807L;
        this.j0 = -9223372036854775807L;
        this.p0 = -1;
        this.q0 = -1;
        this.s0 = -1.0f;
        this.o0 = -1.0f;
        this.h0 = 1;
        m0();
    }
}
