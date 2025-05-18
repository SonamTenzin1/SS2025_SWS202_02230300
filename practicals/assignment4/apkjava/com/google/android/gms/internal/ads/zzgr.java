package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.SystemClock;
import android.view.Surface;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

@TargetApi(16)
/* loaded from: classes2.dex */
public abstract class zzgr extends zzhp {
    private int A;
    private boolean B;
    private boolean C;
    private boolean D;
    private boolean E;
    private long F;

    /* renamed from: b, reason: collision with root package name */
    public final zzga f16252b;

    /* renamed from: c, reason: collision with root package name */
    private final zzhz f16253c;

    /* renamed from: d, reason: collision with root package name */
    private final boolean f16254d;

    /* renamed from: e, reason: collision with root package name */
    private final zzhn f16255e;

    /* renamed from: f, reason: collision with root package name */
    private final zzhm f16256f;

    /* renamed from: g, reason: collision with root package name */
    private final zzhk f16257g;

    /* renamed from: h, reason: collision with root package name */
    private final List<Long> f16258h;

    /* renamed from: i, reason: collision with root package name */
    private final MediaCodec.BufferInfo f16259i;

    /* renamed from: j, reason: collision with root package name */
    private final zzgw f16260j;

    /* renamed from: k, reason: collision with root package name */
    protected final Handler f16261k;
    private zzhj l;
    private zzhw m;
    private MediaCodec n;
    private boolean o;
    private ByteBuffer[] p;
    private ByteBuffer[] q;
    private long r;
    private int s;
    private int t;
    private boolean u;
    private boolean v;
    private int w;
    private int x;
    private boolean y;
    private int z;

    public zzgr(zzhn zzhnVar, zzhz zzhzVar, boolean z, Handler handler, zzgw zzgwVar) {
        zzkh.d(zzkq.a >= 16);
        this.f16255e = zzhnVar;
        this.f16253c = null;
        this.f16254d = true;
        this.f16261k = handler;
        this.f16260j = zzgwVar;
        this.f16252b = new zzga();
        this.f16256f = new zzhm(0);
        this.f16257g = new zzhk();
        this.f16258h = new ArrayList();
        this.f16259i = new MediaCodec.BufferInfo();
        this.w = 0;
        this.x = 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:65:0x011a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x011b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final boolean G(boolean z) throws IOException, zzgd {
        int w;
        boolean z2;
        if (this.B || this.x == 2) {
            return false;
        }
        if (this.s < 0) {
            int dequeueInputBuffer = this.n.dequeueInputBuffer(0L);
            this.s = dequeueInputBuffer;
            if (dequeueInputBuffer < 0) {
                return false;
            }
            zzhm zzhmVar = this.f16256f;
            ByteBuffer byteBuffer = this.p[dequeueInputBuffer];
            zzhmVar.f16279b = byteBuffer;
            byteBuffer.clear();
        }
        if (this.x == 1) {
            this.n.queueInputBuffer(this.s, 0, 0, 0L, 4);
            this.s = -1;
            this.x = 2;
            return false;
        }
        if (this.D) {
            w = -3;
        } else {
            if (this.w == 1) {
                for (int i2 = 0; i2 < this.l.f16275i.size(); i2++) {
                    this.f16256f.f16279b.put(this.l.f16275i.get(i2));
                }
                this.w = 2;
            }
            w = this.f16255e.w(this.z, this.F, this.f16257g, this.f16256f, false);
            if (z && this.A == 1 && w == -2) {
                this.A = 2;
            }
        }
        if (w == -2) {
            return false;
        }
        if (w == -5) {
            L();
            return true;
        }
        if (w == -4) {
            if (this.w == 2) {
                this.f16256f.f16279b.clear();
                this.w = 1;
            }
            B(this.f16257g);
            return true;
        }
        if (w == -1) {
            if (this.w == 2) {
                this.f16256f.f16279b.clear();
                this.w = 1;
            }
            this.B = true;
            try {
                this.n.queueInputBuffer(this.s, 0, 0, 0L, 4);
                this.s = -1;
                return false;
            } catch (MediaCodec.CryptoException e2) {
                x(e2);
                throw new zzgd(e2);
            }
        }
        if (this.E) {
            if (!this.f16256f.b()) {
                this.f16256f.f16279b.clear();
                if (this.w == 2) {
                    this.w = 1;
                }
                return true;
            }
            this.E = false;
        }
        boolean a = this.f16256f.a();
        if (this.u) {
            int state = this.f16253c.getState();
            if (state != 0) {
                if (state != 4 && (a || !this.f16254d)) {
                    z2 = true;
                    this.D = z2;
                    if (!z2) {
                        return false;
                    }
                    try {
                        int position = this.f16256f.f16279b.position();
                        zzhm zzhmVar2 = this.f16256f;
                        int i3 = position - zzhmVar2.f16280c;
                        long j2 = zzhmVar2.f16282e;
                        if ((zzhmVar2.f16281d & 134217728) != 0) {
                            this.f16258h.add(Long.valueOf(j2));
                        }
                        if (a) {
                            MediaCodec.CryptoInfo c2 = this.f16256f.a.c();
                            if (i3 != 0) {
                                if (c2.numBytesOfClearData == null) {
                                    c2.numBytesOfClearData = new int[1];
                                }
                                int[] iArr = c2.numBytesOfClearData;
                                iArr[0] = iArr[0] + i3;
                            }
                            this.n.queueSecureInputBuffer(this.s, 0, c2, j2, 0);
                        } else {
                            this.n.queueInputBuffer(this.s, 0, position, j2, 0);
                        }
                        this.s = -1;
                        this.y = true;
                        this.w = 0;
                        return true;
                    } catch (MediaCodec.CryptoException e3) {
                        x(e3);
                        throw new zzgd(e3);
                    }
                }
            } else {
                throw new zzgd(this.f16253c.b());
            }
        }
        z2 = false;
        this.D = z2;
        if (!z2) {
        }
    }

    private final void L() throws zzgd {
        this.r = -1L;
        this.s = -1;
        this.t = -1;
        this.E = true;
        this.D = false;
        this.f16258h.clear();
        if (zzkq.a >= 18 && this.x == 0) {
            this.n.flush();
            this.y = false;
        } else {
            K();
            H();
        }
        if (!this.v || this.l == null) {
            return;
        }
        this.w = 1;
    }

    private final void x(MediaCodec.CryptoException cryptoException) {
        Handler handler = this.f16261k;
        if (handler == null || this.f16260j == null) {
            return;
        }
        handler.post(new dz(this, cryptoException));
    }

    private final void z(zzgv zzgvVar) throws zzgd {
        Handler handler = this.f16261k;
        if (handler != null && this.f16260j != null) {
            handler.post(new cz(this, zzgvVar));
        }
        throw new zzgd(zzgvVar);
    }

    protected void A(zzhj zzhjVar, MediaFormat mediaFormat) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void B(zzhk zzhkVar) throws zzgd {
        zzhj zzhjVar = this.l;
        zzhj zzhjVar2 = zzhkVar.a;
        this.l = zzhjVar2;
        this.m = zzhkVar.f16278b;
        MediaCodec mediaCodec = this.n;
        if (mediaCodec != null && D(mediaCodec, this.o, zzhjVar, zzhjVar2)) {
            this.v = true;
            this.w = 1;
        } else if (this.y) {
            this.x = 1;
        } else {
            K();
            H();
        }
    }

    protected abstract boolean C(long j2, long j3, MediaCodec mediaCodec, ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo, int i2, boolean z) throws zzgd;

    protected boolean D(MediaCodec mediaCodec, boolean z, zzhj zzhjVar, zzhj zzhjVar2) {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean E(String str) {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public zzgc F(String str, boolean z) throws zzgz {
        return zzgx.b(str, z);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void H() throws zzgd {
        MediaCrypto mediaCrypto;
        zzgc zzgcVar;
        if (I()) {
            String str = this.l.a;
            boolean z = false;
            zzhw zzhwVar = this.m;
            if (zzhwVar != null) {
                zzhz zzhzVar = this.f16253c;
                if (zzhzVar != null) {
                    if (!this.u) {
                        zzhzVar.c(zzhwVar);
                        this.u = true;
                    }
                    int state = this.f16253c.getState();
                    if (state == 0) {
                        throw new zzgd(this.f16253c.b());
                    }
                    if (state != 3 && state != 4) {
                        return;
                    }
                    mediaCrypto = this.f16253c.d();
                    z = this.f16253c.a(str);
                } else {
                    throw new zzgd("Media requires a DrmSessionManager");
                }
            } else {
                mediaCrypto = null;
            }
            try {
                zzgcVar = F(str, z);
            } catch (zzgz e2) {
                z(new zzgv(this.l, e2, -49998));
                zzgcVar = null;
            }
            if (zzgcVar == null) {
                z(new zzgv(this.l, (Throwable) null, -49999));
            }
            String str2 = zzgcVar.a;
            this.o = zzgcVar.f16240b;
            try {
                long elapsedRealtime = SystemClock.elapsedRealtime();
                MediaCodec createByCodecName = MediaCodec.createByCodecName(str2);
                this.n = createByCodecName;
                y(createByCodecName, str2, this.l.i(), mediaCrypto);
                this.n.start();
                long elapsedRealtime2 = SystemClock.elapsedRealtime();
                long j2 = elapsedRealtime2 - elapsedRealtime;
                Handler handler = this.f16261k;
                if (handler != null && this.f16260j != null) {
                    handler.post(new ez(this, str2, elapsedRealtime2, j2));
                }
                this.p = this.n.getInputBuffers();
                this.q = this.n.getOutputBuffers();
            } catch (Exception e3) {
                z(new zzgv(this.l, e3, str2));
            }
            this.r = c() == 3 ? SystemClock.elapsedRealtime() : -1L;
            this.s = -1;
            this.t = -1;
            this.E = true;
            this.f16252b.a++;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean I() {
        return this.n == null && this.l != null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean J() {
        return this.n != null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void K() {
        if (this.n != null) {
            this.r = -1L;
            this.s = -1;
            this.t = -1;
            this.D = false;
            this.f16258h.clear();
            this.p = null;
            this.q = null;
            this.v = false;
            this.y = false;
            this.o = false;
            this.w = 0;
            this.x = 0;
            this.f16252b.f16228b++;
            try {
                this.n.stop();
                try {
                    this.n.release();
                } finally {
                }
            } catch (Throwable th) {
                try {
                    this.n.release();
                    throw th;
                } finally {
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int M() {
        return this.A;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzhp
    public final long b() {
        return this.f16255e.v(this.z).f16284b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzhp
    public boolean d() {
        if (this.l != null && !this.D) {
            if (this.A == 0 && this.t < 0) {
                if (SystemClock.elapsedRealtime() < this.r + 1000) {
                }
            }
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzhp
    public void e() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzhp
    public void g() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzhp
    public void i(long j2) throws zzgd {
        this.F = j2;
        this.f16255e.t(j2);
        this.A = 0;
        this.B = false;
        this.C = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0059, code lost:
    
        if (r17.n != null) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x005d, code lost:
    
        if (r17.C != false) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0061, code lost:
    
        if (r17.t >= 0) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0063, code lost:
    
        r17.t = r17.n.dequeueOutputBuffer(r17.f16259i, 0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x006f, code lost:
    
        r0 = r17.t;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0072, code lost:
    
        if (r0 != (-2)) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0074, code lost:
    
        A(r17.l, r17.n.getOutputFormat());
        r17.f16252b.f16229c++;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0086, code lost:
    
        r14 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x010a, code lost:
    
        if (r14 != false) goto L81;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0110, code lost:
    
        if (G(true) == false) goto L70;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0117, code lost:
    
        if (G(false) != false) goto L83;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x008a, code lost:
    
        if (r0 != (-3)) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x008c, code lost:
    
        r17.q = r17.n.getOutputBuffers();
        r17.f16252b.f16230d++;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x009c, code lost:
    
        if (r0 < 0) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x009e, code lost:
    
        r0 = r17.f16259i;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00a4, code lost:
    
        if ((r0.flags & 4) == 0) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00a9, code lost:
    
        if (r17.x != 2) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00ab, code lost:
    
        K();
        H();
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00b2, code lost:
    
        r17.C = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00b5, code lost:
    
        r0 = r0.presentationTimeUs;
        r2 = r17.f16258h.size();
        r3 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x00bf, code lost:
    
        if (r3 >= r2) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00cf, code lost:
    
        if (r17.f16258h.get(r3).longValue() != r0) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x00d3, code lost:
    
        r3 = r3 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00d1, code lost:
    
        r0 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x00d7, code lost:
    
        r6 = r17.n;
        r1 = r17.q;
        r9 = r17.t;
        r7 = r1[r9];
        r8 = r17.f16259i;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x00e1, code lost:
    
        if (r0 == (-1)) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x00e3, code lost:
    
        r16 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x00f5, code lost:
    
        if (C(r18, r20, r6, r7, r8, r9, r16) == false) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x00f7, code lost:
    
        if (r0 == (-1)) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x00f9, code lost:
    
        r17.f16258h.remove(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x0105, code lost:
    
        r17.t = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x00ff, code lost:
    
        r17.F = r17.f16259i.presentationTimeUs;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x00e6, code lost:
    
        r16 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x00d6, code lost:
    
        r0 = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0109, code lost:
    
        r14 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x0119, code lost:
    
        r17.f16252b.a();
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x011e, code lost:
    
        return;
     */
    @Override // com.google.android.gms.internal.ads.zzhp
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void l(long j2, long j3) throws zzgd {
        int i2;
        try {
            if (this.f16255e.x(j2)) {
                i2 = this.A;
                if (i2 == 0) {
                    i2 = 1;
                }
            } else {
                i2 = 0;
            }
            this.A = i2;
            if (this.n != null && this.f16255e.w(this.z, this.F, this.f16257g, this.f16256f, true) == -5) {
                L();
            }
            if (this.l == null && this.f16255e.w(this.z, this.F, this.f16257g, this.f16256f, false) == -4) {
                B(this.f16257g);
            }
            if (this.n == null && I()) {
                H();
            }
        } catch (IOException e2) {
            throw new zzgd(e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzhp
    public void m(long j2, boolean z) {
        this.f16255e.q(this.z, j2);
        this.A = 0;
        this.B = false;
        this.C = false;
        this.D = false;
        this.F = j2;
    }

    @Override // com.google.android.gms.internal.ads.zzhp
    protected final int o(long j2) throws zzgd {
        try {
            if (!this.f16255e.u(j2)) {
                return 0;
            }
            for (int i2 = 0; i2 < this.f16255e.s(); i2++) {
                if (E(this.f16255e.v(i2).a)) {
                    this.z = i2;
                    return 1;
                }
            }
            return -1;
        } catch (IOException e2) {
            throw new zzgd(e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzhp
    public final long q() {
        long r = this.f16255e.r();
        return (r == -1 || r == -3) ? r : Math.max(r, t());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzhp
    public boolean s() {
        return this.C;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzhp
    public long t() {
        return this.F;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzhp
    public void u() {
        this.l = null;
        this.m = null;
        try {
            K();
            try {
                if (this.u) {
                    this.f16253c.close();
                    this.u = false;
                }
            } finally {
            }
        } catch (Throwable th) {
            try {
                if (this.u) {
                    this.f16253c.close();
                    this.u = false;
                }
                throw th;
            } finally {
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhp
    protected final void v() {
        this.f16255e.c();
    }

    protected void y(MediaCodec mediaCodec, String str, MediaFormat mediaFormat, MediaCrypto mediaCrypto) {
        mediaCodec.configure(mediaFormat, (Surface) null, mediaCrypto, 0);
    }
}
