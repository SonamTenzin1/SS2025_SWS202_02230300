package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Looper;
import android.os.SystemClock;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

@TargetApi(16)
/* loaded from: classes2.dex */
public abstract class zzpe extends zzks {

    /* renamed from: i, reason: collision with root package name */
    private static final byte[] f16574i = zzsy.n("0000016742C00BDA259000000168CE0F13200000016588840DCE7118A0002FBF1C31C3275D78");
    private boolean A;
    private boolean B;
    private boolean C;
    private boolean D;
    private boolean E;
    private ByteBuffer[] F;
    private ByteBuffer[] G;
    private long H;
    private int I;
    private int J;
    private boolean K;
    private boolean L;
    private int M;
    private int N;
    private boolean O;
    private boolean P;
    private boolean Q;
    private boolean R;
    private boolean S;
    private boolean T;
    protected zznc U;

    /* renamed from: j, reason: collision with root package name */
    private final zzpg f16575j;

    /* renamed from: k, reason: collision with root package name */
    private final zznj<Object> f16576k;
    private final boolean l;
    private final zznd m;
    private final zznd n;
    private final zzlj o;
    private final List<Long> p;
    private final MediaCodec.BufferInfo q;
    private zzlh r;
    private zznh<Object> s;
    private zznh<Object> t;
    private MediaCodec u;
    private zzpd v;
    private boolean w;
    private boolean x;
    private boolean y;
    private boolean z;

    public zzpe(int i2, zzpg zzpgVar, zznj<Object> zznjVar, boolean z) {
        super(i2);
        zzsk.e(zzsy.a >= 16);
        this.f16575j = (zzpg) zzsk.d(zzpgVar);
        this.f16576k = zznjVar;
        this.l = z;
        this.m = new zznd(0);
        this.n = new zznd(0);
        this.o = new zzlj();
        this.p = new ArrayList();
        this.q = new MediaCodec.BufferInfo();
        this.M = 0;
        this.N = 0;
    }

    private final boolean S(long j2, long j3) throws zzku {
        boolean x;
        boolean z;
        if (this.J < 0) {
            if (this.B && this.P) {
                try {
                    this.J = this.u.dequeueOutputBuffer(this.q, 0L);
                } catch (IllegalStateException unused) {
                    Z();
                    if (this.R) {
                        U();
                    }
                    return false;
                }
            } else {
                this.J = this.u.dequeueOutputBuffer(this.q, 0L);
            }
            int i2 = this.J;
            if (i2 < 0) {
                if (i2 != -2) {
                    if (i2 == -3) {
                        this.G = this.u.getOutputBuffers();
                        return true;
                    }
                    if (this.z && (this.Q || this.N == 2)) {
                        Z();
                    }
                    return false;
                }
                MediaFormat outputFormat = this.u.getOutputFormat();
                if (this.y && outputFormat.getInteger("width") == 32 && outputFormat.getInteger("height") == 32) {
                    this.E = true;
                } else {
                    if (this.C) {
                        outputFormat.setInteger("channel-count", 1);
                    }
                    r(this.u, outputFormat);
                }
                return true;
            }
            if (this.E) {
                this.E = false;
                this.u.releaseOutputBuffer(i2, false);
                this.J = -1;
                return true;
            }
            MediaCodec.BufferInfo bufferInfo = this.q;
            if ((bufferInfo.flags & 4) != 0) {
                Z();
                this.J = -1;
                return false;
            }
            ByteBuffer byteBuffer = this.G[i2];
            if (byteBuffer != null) {
                byteBuffer.position(bufferInfo.offset);
                MediaCodec.BufferInfo bufferInfo2 = this.q;
                byteBuffer.limit(bufferInfo2.offset + bufferInfo2.size);
            }
            long j4 = this.q.presentationTimeUs;
            int size = this.p.size();
            int i3 = 0;
            while (true) {
                if (i3 >= size) {
                    z = false;
                    break;
                }
                if (this.p.get(i3).longValue() == j4) {
                    this.p.remove(i3);
                    z = true;
                    break;
                }
                i3++;
            }
            this.K = z;
        }
        if (this.B && this.P) {
            try {
                MediaCodec mediaCodec = this.u;
                ByteBuffer[] byteBufferArr = this.G;
                int i4 = this.J;
                ByteBuffer byteBuffer2 = byteBufferArr[i4];
                MediaCodec.BufferInfo bufferInfo3 = this.q;
                x = x(j2, j3, mediaCodec, byteBuffer2, i4, bufferInfo3.flags, bufferInfo3.presentationTimeUs, this.K);
            } catch (IllegalStateException unused2) {
                Z();
                if (this.R) {
                    U();
                }
                return false;
            }
        } else {
            MediaCodec mediaCodec2 = this.u;
            ByteBuffer[] byteBufferArr2 = this.G;
            int i5 = this.J;
            ByteBuffer byteBuffer3 = byteBufferArr2[i5];
            MediaCodec.BufferInfo bufferInfo4 = this.q;
            x = x(j2, j3, mediaCodec2, byteBuffer3, i5, bufferInfo4.flags, bufferInfo4.presentationTimeUs, this.K);
        }
        if (!x) {
            return false;
        }
        long j5 = this.q.presentationTimeUs;
        this.J = -1;
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:76:0x0145 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0146  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final boolean Y() throws zzku {
        int position;
        int j2;
        boolean z;
        MediaCodec mediaCodec = this.u;
        if (mediaCodec == null || this.N == 2 || this.Q) {
            return false;
        }
        if (this.I < 0) {
            int dequeueInputBuffer = mediaCodec.dequeueInputBuffer(0L);
            this.I = dequeueInputBuffer;
            if (dequeueInputBuffer < 0) {
                return false;
            }
            zznd zzndVar = this.m;
            zzndVar.f16502c = this.F[dequeueInputBuffer];
            zzndVar.a();
        }
        if (this.N == 1) {
            if (!this.z) {
                this.P = true;
                this.u.queueInputBuffer(this.I, 0, 0, 0L, 4);
                this.I = -1;
            }
            this.N = 2;
            return false;
        }
        if (this.D) {
            this.D = false;
            ByteBuffer byteBuffer = this.m.f16502c;
            byte[] bArr = f16574i;
            byteBuffer.put(bArr);
            this.u.queueInputBuffer(this.I, 0, bArr.length, 0L, 0);
            this.I = -1;
            this.O = true;
            return true;
        }
        if (this.S) {
            j2 = -4;
            position = 0;
        } else {
            if (this.M == 1) {
                for (int i2 = 0; i2 < this.r.m.size(); i2++) {
                    this.m.f16502c.put(this.r.m.get(i2));
                }
                this.M = 2;
            }
            position = this.m.f16502c.position();
            j2 = j(this.o, this.m, false);
        }
        if (j2 == -3) {
            return false;
        }
        if (j2 == -5) {
            if (this.M == 2) {
                this.m.a();
                this.M = 1;
            }
            A(this.o.a);
            return true;
        }
        if (this.m.f()) {
            if (this.M == 2) {
                this.m.a();
                this.M = 1;
            }
            this.Q = true;
            if (!this.O) {
                Z();
                return false;
            }
            try {
                if (!this.z) {
                    this.P = true;
                    this.u.queueInputBuffer(this.I, 0, 0, 0L, 4);
                    this.I = -1;
                }
                return false;
            } catch (MediaCodec.CryptoException e2) {
                throw zzku.b(e2, g());
            }
        }
        if (this.T && !this.m.g()) {
            this.m.a();
            if (this.M == 2) {
                this.M = 1;
            }
            return true;
        }
        this.T = false;
        boolean j3 = this.m.j();
        zznh<Object> zznhVar = this.s;
        if (zznhVar != null) {
            int state = zznhVar.getState();
            if (state != 0) {
                if (state != 4 && (j3 || !this.l)) {
                    z = true;
                    this.S = z;
                    if (!z) {
                        return false;
                    }
                    if (this.w && !j3) {
                        zzsq.b(this.m.f16502c);
                        if (this.m.f16502c.position() == 0) {
                            return true;
                        }
                        this.w = false;
                    }
                    try {
                        zznd zzndVar2 = this.m;
                        long j4 = zzndVar2.f16503d;
                        if (zzndVar2.e()) {
                            this.p.add(Long.valueOf(j4));
                        }
                        this.m.f16502c.flip();
                        u(this.m);
                        if (j3) {
                            MediaCodec.CryptoInfo b2 = this.m.f16501b.b();
                            if (position != 0) {
                                if (b2.numBytesOfClearData == null) {
                                    b2.numBytesOfClearData = new int[1];
                                }
                                int[] iArr = b2.numBytesOfClearData;
                                iArr[0] = iArr[0] + position;
                            }
                            this.u.queueSecureInputBuffer(this.I, 0, b2, j4, 0);
                        } else {
                            this.u.queueInputBuffer(this.I, 0, this.m.f16502c.limit(), j4, 0);
                        }
                        this.I = -1;
                        this.O = true;
                        this.M = 0;
                        this.U.f16496c++;
                        return true;
                    } catch (MediaCodec.CryptoException e3) {
                        throw zzku.b(e3, g());
                    }
                }
            } else {
                throw zzku.b(this.s.a(), g());
            }
        }
        z = false;
        this.S = z;
        if (!z) {
        }
    }

    private final void Z() throws zzku {
        if (this.N == 2) {
            U();
            T();
        } else {
            this.R = true;
            V();
        }
    }

    private final void w(zzpf zzpfVar) throws zzku {
        throw zzku.b(zzpfVar, g());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0073, code lost:
    
        if (r5.p == r0.p) goto L32;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void A(zzlh zzlhVar) throws zzku {
        MediaCodec mediaCodec;
        zzlh zzlhVar2 = this.r;
        this.r = zzlhVar;
        boolean z = true;
        if (!zzsy.g(zzlhVar.n, zzlhVar2 == null ? null : zzlhVar2.n)) {
            if (this.r.n != null) {
                zznj<Object> zznjVar = this.f16576k;
                if (zznjVar != null) {
                    zznh<Object> a = zznjVar.a(Looper.myLooper(), this.r.n);
                    this.t = a;
                    if (a == this.s) {
                        this.f16576k.b(a);
                    }
                } else {
                    throw zzku.b(new IllegalStateException("Media requires a DrmSessionManager"), g());
                }
            } else {
                this.t = null;
            }
        }
        if (this.t == this.s && (mediaCodec = this.u) != null && y(mediaCodec, this.v.f16569b, zzlhVar2, this.r)) {
            this.L = true;
            this.M = 1;
            if (this.y) {
                zzlh zzlhVar3 = this.r;
                if (zzlhVar3.o == zzlhVar2.o) {
                }
            }
            z = false;
            this.D = z;
            return;
        }
        if (this.O) {
            this.N = 1;
        } else {
            U();
            T();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzlo
    public boolean B() {
        if (this.r == null || this.S) {
            return false;
        }
        if (q() || this.J >= 0) {
            return true;
        }
        return this.H != -9223372036854775807L && SystemClock.elapsedRealtime() < this.H;
    }

    @Override // com.google.android.gms.internal.ads.zzlo
    public boolean C() {
        return this.R;
    }

    @Override // com.google.android.gms.internal.ads.zzlo
    public final void O(long j2, long j3) throws zzku {
        if (this.R) {
            V();
            return;
        }
        if (this.r == null) {
            this.n.a();
            int j4 = j(this.o, this.n, true);
            if (j4 != -5) {
                if (j4 == -4) {
                    zzsk.e(this.n.f());
                    this.Q = true;
                    Z();
                    return;
                }
                return;
            }
            A(this.o.a);
        }
        T();
        if (this.u != null) {
            zzsx.a("drainAndFeed");
            do {
            } while (S(j2, j3));
            do {
            } while (Y());
            zzsx.b();
        } else {
            m(j2);
            this.n.a();
            int j5 = j(this.o, this.n, false);
            if (j5 == -5) {
                A(this.o.a);
            } else if (j5 == -4) {
                zzsk.e(this.n.f());
                this.Q = true;
                Z();
            }
        }
        this.U.a();
    }

    protected void R(String str, long j2, long j3) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't wrap try/catch for region: R(28:24|(1:114)(1:30)|31|(1:113)(1:45)|46|(2:52|(18:60|61|(1:111)(1:67)|68|(1:110)(1:72)|73|(1:102)(1:77)|78|(1:101)(1:84)|85|86|87|(1:89)(1:98)|90|91|(1:93)(1:96)|94|95))|112|61|(2:63|65)|111|68|(1:70)|110|73|(1:75)|102|78|(1:80)|101|85|86|87|(0)(0)|90|91|(0)(0)|94|95) */
    /* JADX WARN: Code restructure failed: missing block: B:100:0x01d3, code lost:
    
        w(new com.google.android.gms.internal.ads.zzpf(r11.r, (java.lang.Throwable) r1, false, r0));
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x01d2, code lost:
    
        r1 = move-exception;
     */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0181 A[Catch: Exception -> 0x01d2, TryCatch #1 {Exception -> 0x01d2, blocks: (B:87:0x0171, B:89:0x0181, B:90:0x018c, B:98:0x0186), top: B:86:0x0171 }] */
    /* JADX WARN: Removed duplicated region for block: B:93:0x01e4  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x01ec  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0186 A[Catch: Exception -> 0x01d2, TryCatch #1 {Exception -> 0x01d2, blocks: (B:87:0x0171, B:89:0x0181, B:90:0x018c, B:98:0x0186), top: B:86:0x0171 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void T() throws zzku {
        zzlh zzlhVar;
        boolean z;
        if (this.u != null || (zzlhVar = this.r) == null) {
            return;
        }
        zznh<Object> zznhVar = this.t;
        this.s = zznhVar;
        String str = zzlhVar.f16427k;
        if (zznhVar != null) {
            int state = zznhVar.getState();
            if (state == 0) {
                throw zzku.b(this.s.a(), g());
            }
            if (state == 3 || state == 4) {
                this.s.b();
                throw new NoSuchMethodError();
            }
            return;
        }
        if (this.v == null) {
            try {
                this.v = t(this.f16575j, zzlhVar, false);
            } catch (zzpk e2) {
                w(new zzpf(this.r, (Throwable) e2, false, -49998));
            }
            if (this.v == null) {
                w(new zzpf(this.r, (Throwable) null, false, -49999));
            }
        }
        if (z(this.v)) {
            String str2 = this.v.a;
            zzlh zzlhVar2 = this.r;
            int i2 = zzsy.a;
            this.w = i2 < 21 && zzlhVar2.m.isEmpty() && "OMX.MTK.VIDEO.DECODER.AVC".equals(str2);
            this.x = i2 < 18 || (i2 == 18 && ("OMX.SEC.avc.dec".equals(str2) || "OMX.SEC.avc.dec.secure".equals(str2))) || (i2 == 19 && zzsy.f16742d.startsWith("SM-G800") && ("OMX.Exynos.avc.dec".equals(str2) || "OMX.Exynos.avc.dec.secure".equals(str2)));
            if (i2 < 24 && ("OMX.Nvidia.h264.decode".equals(str2) || "OMX.Nvidia.h264.decode.secure".equals(str2))) {
                String str3 = zzsy.f16740b;
                if ("flounder".equals(str3) || "flounder_lte".equals(str3) || "grouper".equals(str3) || "tilapia".equals(str3)) {
                    z = true;
                    this.y = z;
                    this.z = i2 > 17 && ("OMX.rk.video_decoder.avc".equals(str2) || "OMX.allwinner.video.decoder.avc".equals(str2));
                    this.A = (i2 > 23 && "OMX.google.vorbis.decoder".equals(str2)) || (i2 <= 19 && "hb2000".equals(zzsy.f16740b) && ("OMX.amlogic.avc.decoder.awesome".equals(str2) || "OMX.amlogic.avc.decoder.awesome.secure".equals(str2)));
                    this.B = i2 != 21 && "OMX.google.aac.decoder".equals(str2);
                    this.C = i2 > 18 && this.r.w == 1 && "OMX.MTK.AUDIO.DECODER.MP3".equals(str2);
                    long elapsedRealtime = SystemClock.elapsedRealtime();
                    String valueOf = String.valueOf(str2);
                    zzsx.a(valueOf.length() == 0 ? "createCodec:".concat(valueOf) : new String("createCodec:"));
                    this.u = MediaCodec.createByCodecName(str2);
                    zzsx.b();
                    zzsx.a("configureCodec");
                    v(this.v, this.u, this.r, null);
                    zzsx.b();
                    zzsx.a("startCodec");
                    this.u.start();
                    zzsx.b();
                    long elapsedRealtime2 = SystemClock.elapsedRealtime();
                    R(str2, elapsedRealtime2, elapsedRealtime2 - elapsedRealtime);
                    this.F = this.u.getInputBuffers();
                    this.G = this.u.getOutputBuffers();
                    this.H = getState() != 2 ? SystemClock.elapsedRealtime() + 1000 : -9223372036854775807L;
                    this.I = -1;
                    this.J = -1;
                    this.T = true;
                    this.U.a++;
                }
            }
            z = false;
            this.y = z;
            this.z = i2 > 17 && ("OMX.rk.video_decoder.avc".equals(str2) || "OMX.allwinner.video.decoder.avc".equals(str2));
            this.A = (i2 > 23 && "OMX.google.vorbis.decoder".equals(str2)) || (i2 <= 19 && "hb2000".equals(zzsy.f16740b) && ("OMX.amlogic.avc.decoder.awesome".equals(str2) || "OMX.amlogic.avc.decoder.awesome.secure".equals(str2)));
            this.B = i2 != 21 && "OMX.google.aac.decoder".equals(str2);
            this.C = i2 > 18 && this.r.w == 1 && "OMX.MTK.AUDIO.DECODER.MP3".equals(str2);
            long elapsedRealtime3 = SystemClock.elapsedRealtime();
            String valueOf2 = String.valueOf(str2);
            zzsx.a(valueOf2.length() == 0 ? "createCodec:".concat(valueOf2) : new String("createCodec:"));
            this.u = MediaCodec.createByCodecName(str2);
            zzsx.b();
            zzsx.a("configureCodec");
            v(this.v, this.u, this.r, null);
            zzsx.b();
            zzsx.a("startCodec");
            this.u.start();
            zzsx.b();
            long elapsedRealtime22 = SystemClock.elapsedRealtime();
            R(str2, elapsedRealtime22, elapsedRealtime22 - elapsedRealtime3);
            this.F = this.u.getInputBuffers();
            this.G = this.u.getOutputBuffers();
            this.H = getState() != 2 ? SystemClock.elapsedRealtime() + 1000 : -9223372036854775807L;
            this.I = -1;
            this.J = -1;
            this.T = true;
            this.U.a++;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void U() {
        this.H = -9223372036854775807L;
        this.I = -1;
        this.J = -1;
        this.S = false;
        this.K = false;
        this.p.clear();
        this.F = null;
        this.G = null;
        this.v = null;
        this.L = false;
        this.O = false;
        this.w = false;
        this.x = false;
        this.y = false;
        this.z = false;
        this.A = false;
        this.C = false;
        this.D = false;
        this.E = false;
        this.P = false;
        this.M = 0;
        this.N = 0;
        this.m.f16502c = null;
        MediaCodec mediaCodec = this.u;
        if (mediaCodec != null) {
            this.U.f16495b++;
            try {
                mediaCodec.stop();
                try {
                    this.u.release();
                    this.u = null;
                    zznh<Object> zznhVar = this.s;
                    if (zznhVar == null || this.t == zznhVar) {
                        return;
                    }
                    try {
                        this.f16576k.b(zznhVar);
                    } finally {
                    }
                } catch (Throwable th) {
                    this.u = null;
                    zznh<Object> zznhVar2 = this.s;
                    if (zznhVar2 != null && this.t != zznhVar2) {
                        try {
                            this.f16576k.b(zznhVar2);
                        } finally {
                        }
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                try {
                    this.u.release();
                    this.u = null;
                    zznh<Object> zznhVar3 = this.s;
                    if (zznhVar3 != null && this.t != zznhVar3) {
                        try {
                            this.f16576k.b(zznhVar3);
                        } finally {
                        }
                    }
                    throw th2;
                } catch (Throwable th3) {
                    this.u = null;
                    zznh<Object> zznhVar4 = this.s;
                    if (zznhVar4 != null && this.t != zznhVar4) {
                        try {
                            this.f16576k.b(zznhVar4);
                        } finally {
                        }
                    }
                    throw th3;
                }
            }
        }
    }

    protected void V() throws zzku {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final MediaCodec W() {
        return this.u;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final zzpd X() {
        return this.v;
    }

    @Override // com.google.android.gms.internal.ads.zzks, com.google.android.gms.internal.ads.zzlp
    public final int a() {
        return 4;
    }

    @Override // com.google.android.gms.internal.ads.zzlp
    public final int b(zzlh zzlhVar) throws zzku {
        try {
            return s(this.f16575j, zzlhVar);
        } catch (zzpk e2) {
            throw zzku.b(e2, g());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzks
    public void h() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzks
    public void i() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzks
    public void l(long j2, boolean z) throws zzku {
        this.Q = false;
        this.R = false;
        if (this.u != null) {
            this.H = -9223372036854775807L;
            this.I = -1;
            this.J = -1;
            this.T = true;
            this.S = false;
            this.K = false;
            this.p.clear();
            this.D = false;
            this.E = false;
            if (!this.x && (!this.A || !this.P)) {
                if (this.N != 0) {
                    U();
                    T();
                } else {
                    this.u.flush();
                    this.O = false;
                }
            } else {
                U();
                T();
            }
            if (!this.L || this.r == null) {
                return;
            }
            this.M = 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzks
    public void n() {
        this.r = null;
        try {
            U();
            try {
                zznh<Object> zznhVar = this.s;
                if (zznhVar != null) {
                    this.f16576k.b(zznhVar);
                }
                try {
                    zznh<Object> zznhVar2 = this.t;
                    if (zznhVar2 != null && zznhVar2 != this.s) {
                        this.f16576k.b(zznhVar2);
                    }
                } finally {
                }
            } catch (Throwable th) {
                try {
                    zznh<Object> zznhVar3 = this.t;
                    if (zznhVar3 != null && zznhVar3 != this.s) {
                        this.f16576k.b(zznhVar3);
                    }
                    throw th;
                } finally {
                }
            }
        } catch (Throwable th2) {
            try {
                if (this.s != null) {
                    this.f16576k.b(this.s);
                }
                try {
                    zznh<Object> zznhVar4 = this.t;
                    if (zznhVar4 != null && zznhVar4 != this.s) {
                        this.f16576k.b(zznhVar4);
                    }
                    throw th2;
                } finally {
                }
            } catch (Throwable th3) {
                try {
                    zznh<Object> zznhVar5 = this.t;
                    if (zznhVar5 != null && zznhVar5 != this.s) {
                        this.f16576k.b(zznhVar5);
                    }
                    throw th3;
                } finally {
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzks
    public void o(boolean z) throws zzku {
        this.U = new zznc();
    }

    protected void r(MediaCodec mediaCodec, MediaFormat mediaFormat) throws zzku {
    }

    protected abstract int s(zzpg zzpgVar, zzlh zzlhVar) throws zzpk;

    /* JADX INFO: Access modifiers changed from: protected */
    public zzpd t(zzpg zzpgVar, zzlh zzlhVar, boolean z) throws zzpk {
        return zzpgVar.b(zzlhVar.f16427k, z);
    }

    protected void u(zznd zzndVar) {
    }

    protected abstract void v(zzpd zzpdVar, MediaCodec mediaCodec, zzlh zzlhVar, MediaCrypto mediaCrypto) throws zzpk;

    protected abstract boolean x(long j2, long j3, MediaCodec mediaCodec, ByteBuffer byteBuffer, int i2, int i3, long j4, boolean z) throws zzku;

    protected boolean y(MediaCodec mediaCodec, boolean z, zzlh zzlhVar, zzlh zzlhVar2) {
        return false;
    }

    protected boolean z(zzpd zzpdVar) {
        return true;
    }
}
