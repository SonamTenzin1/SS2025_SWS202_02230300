package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.media.AudioTrack;
import android.media.MediaFormat;
import android.os.ConditionVariable;
import android.util.Log;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;

@TargetApi(16)
/* loaded from: classes2.dex */
public final class zzhq {
    private boolean A;
    private int B;
    private final ConditionVariable a = new ConditionVariable(true);

    /* renamed from: b, reason: collision with root package name */
    private final long[] f16285b;

    /* renamed from: c, reason: collision with root package name */
    private final nz f16286c;

    /* renamed from: d, reason: collision with root package name */
    private AudioTrack f16287d;

    /* renamed from: e, reason: collision with root package name */
    private int f16288e;

    /* renamed from: f, reason: collision with root package name */
    private int f16289f;

    /* renamed from: g, reason: collision with root package name */
    private int f16290g;

    /* renamed from: h, reason: collision with root package name */
    private int f16291h;

    /* renamed from: i, reason: collision with root package name */
    private int f16292i;

    /* renamed from: j, reason: collision with root package name */
    private int f16293j;

    /* renamed from: k, reason: collision with root package name */
    private int f16294k;
    private int l;
    private long m;
    private long n;
    private boolean o;
    private long p;
    private Method q;
    private long r;
    private int s;
    private long t;
    private long u;
    private long v;
    private float w;
    private byte[] x;
    private int y;
    private int z;

    public zzhq() {
        mz mzVar = null;
        if (zzkq.a >= 18) {
            try {
                this.q = AudioTrack.class.getMethod("getLatency", null);
            } catch (NoSuchMethodException unused) {
            }
        }
        if (zzkq.a >= 19) {
            this.f16286c = new oz();
        } else {
            this.f16286c = new nz(mzVar);
        }
        this.f16285b = new long[10];
        this.w = 1.0f;
        this.s = 0;
    }

    private final long i(long j2) {
        if (this.A) {
            if (this.B == 0) {
                return 0L;
            }
            return ((j2 << 3) * this.f16288e) / (r0 * 1000);
        }
        return j2 / this.f16291h;
    }

    private final long j(long j2) {
        return (j2 * 1000000) / this.f16288e;
    }

    private final long k(long j2) {
        return (j2 * this.f16288e) / 1000000;
    }

    private final void o() {
        this.m = 0L;
        this.l = 0;
        this.f16294k = 0;
        this.n = 0L;
        this.o = false;
        this.p = 0L;
    }

    public final boolean a() {
        return this.f16287d != null;
    }

    public final void b() {
        if (a()) {
            o();
            this.f16287d.pause();
        }
    }

    public final void c() {
        if (a()) {
            this.u = System.nanoTime() / 1000;
            this.f16287d.play();
        }
    }

    public final void d() {
        if (a()) {
            this.r = 0L;
            this.z = 0;
            this.t = 0L;
            this.v = 0L;
            o();
            if (this.f16287d.getPlayState() == 3) {
                this.f16287d.pause();
            }
            AudioTrack audioTrack = this.f16287d;
            this.f16287d = null;
            this.f16286c.a(null, false);
            this.a.close();
            new mz(this, audioTrack).start();
        }
    }

    public final void e(float f2) {
        this.w = f2;
        if (a()) {
            if (zzkq.a >= 21) {
                this.f16287d.setVolume(f2);
            } else {
                this.f16287d.setStereoVolume(f2, f2);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0101  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int f(ByteBuffer byteBuffer, int i2, int i3, long j2) throws zzhv {
        int i4;
        if (i3 == 0) {
            return 2;
        }
        int i5 = zzkq.a;
        int i6 = 0;
        if (i5 <= 22 && this.A) {
            if (this.f16287d.getPlayState() == 2) {
                return 0;
            }
            if (this.f16287d.getPlayState() == 1 && this.f16286c.c() != 0) {
                return 0;
            }
        }
        if (this.z == 0) {
            if (this.A && this.B == 0) {
                this.B = zzkg.a(i3, this.f16288e);
            }
            long j3 = j2 - j(i(i3));
            long j4 = this.t;
            if (j4 == 0) {
                this.t = Math.max(0L, j3);
                this.s = 1;
            } else {
                long j5 = j4 + j(i(this.r));
                if (this.s == 1 && Math.abs(j5 - j3) > 200000) {
                    StringBuilder sb = new StringBuilder(80);
                    sb.append("Discontinuity detected [expected ");
                    sb.append(j5);
                    sb.append(", got ");
                    sb.append(j3);
                    sb.append("]");
                    Log.e("AudioTrack", sb.toString());
                    this.s = 2;
                }
                if (this.s == 2) {
                    this.t += j3 - j5;
                    this.s = 1;
                    i4 = 1;
                    if (this.z == 0) {
                        this.z = i3;
                        byteBuffer.position(i2);
                        if (i5 < 21) {
                            byte[] bArr = this.x;
                            if (bArr == null || bArr.length < i3) {
                                this.x = new byte[i3];
                            }
                            byteBuffer.get(this.x, 0, i3);
                            this.y = 0;
                        }
                    }
                    if (i5 >= 21) {
                        int c2 = this.f16293j - ((int) (this.r - (this.f16286c.c() * this.f16291h)));
                        if (c2 > 0) {
                            i6 = this.f16287d.write(this.x, this.y, Math.min(this.z, c2));
                            if (i6 >= 0) {
                                this.y += i6;
                            }
                        }
                    } else {
                        i6 = this.f16287d.write(byteBuffer, this.z, 1);
                    }
                    if (i6 < 0) {
                        int i7 = this.z - i6;
                        this.z = i7;
                        this.r += i6;
                        return i7 == 0 ? i4 | 2 : i4;
                    }
                    throw new zzhv(i6);
                }
            }
        }
        i4 = 0;
        if (this.z == 0) {
        }
        if (i5 >= 21) {
        }
        if (i6 < 0) {
        }
    }

    public final void h(MediaFormat mediaFormat, int i2) {
        int i3;
        int i4;
        int integer = mediaFormat.getInteger("channel-count");
        if (integer == 1) {
            i3 = 4;
        } else if (integer == 2) {
            i3 = 12;
        } else if (integer == 6) {
            i3 = 252;
        } else {
            if (integer != 8) {
                StringBuilder sb = new StringBuilder(38);
                sb.append("Unsupported channel count: ");
                sb.append(integer);
                throw new IllegalArgumentException(sb.toString());
            }
            i3 = 1020;
        }
        int integer2 = mediaFormat.getInteger("sample-rate");
        String string = mediaFormat.getString("mime");
        if ("audio/ac3".equals(string)) {
            i4 = 5;
        } else if ("audio/eac3".equals(string)) {
            i4 = 6;
        } else {
            i4 = zzkl.b(string) ? 2 : 0;
        }
        boolean z = i4 == 5 || i4 == 6;
        if (a() && this.f16288e == integer2 && this.f16289f == i3 && !this.A && !z) {
            return;
        }
        d();
        this.f16290g = i4;
        this.f16288e = integer2;
        this.f16289f = i3;
        this.A = z;
        this.B = 0;
        this.f16291h = integer * 2;
        int minBufferSize = AudioTrack.getMinBufferSize(integer2, i3, i4);
        this.f16292i = minBufferSize;
        zzkh.d(minBufferSize != -2);
        int i5 = this.f16292i << 2;
        int k2 = ((int) k(250000L)) * this.f16291h;
        int max = (int) Math.max(this.f16292i, k(750000L) * this.f16291h);
        if (i5 < k2) {
            i5 = k2;
        } else if (i5 > max) {
            i5 = max;
        }
        this.f16293j = i5;
    }

    public final void l() {
        if (this.s == 1) {
            this.s = 2;
        }
    }

    public final boolean m() {
        if (a()) {
            return i(this.r) > this.f16286c.c() || this.f16286c.b();
        }
        return false;
    }

    public final boolean n() {
        return this.r > ((long) ((this.f16292i * 3) / 2));
    }

    public final long p(boolean z) {
        long j2;
        long j3;
        if (!(a() && this.t != 0)) {
            return Long.MIN_VALUE;
        }
        if (this.f16287d.getPlayState() == 3) {
            long d2 = this.f16286c.d();
            if (d2 != 0) {
                long nanoTime = System.nanoTime() / 1000;
                if (nanoTime - this.n >= 30000) {
                    long[] jArr = this.f16285b;
                    int i2 = this.f16294k;
                    jArr[i2] = d2 - nanoTime;
                    this.f16294k = (i2 + 1) % 10;
                    int i3 = this.l;
                    if (i3 < 10) {
                        this.l = i3 + 1;
                    }
                    this.n = nanoTime;
                    this.m = 0L;
                    int i4 = 0;
                    while (true) {
                        int i5 = this.l;
                        if (i4 >= i5) {
                            break;
                        }
                        this.m += this.f16285b[i4] / i5;
                        i4++;
                    }
                }
                if (!this.A && nanoTime - this.p >= 500000) {
                    boolean e2 = this.f16286c.e();
                    this.o = e2;
                    if (e2) {
                        long f2 = this.f16286c.f() / 1000;
                        long g2 = this.f16286c.g();
                        if (f2 < this.u) {
                            this.o = false;
                        } else if (Math.abs(f2 - nanoTime) > 5000000) {
                            this.o = false;
                            StringBuilder sb = new StringBuilder(136);
                            sb.append("Spurious audio timestamp (system clock mismatch): ");
                            sb.append(g2);
                            sb.append(", ");
                            sb.append(f2);
                            sb.append(", ");
                            sb.append(nanoTime);
                            sb.append(", ");
                            sb.append(d2);
                            Log.w("AudioTrack", sb.toString());
                        } else if (Math.abs(j(g2) - d2) > 5000000) {
                            this.o = false;
                            StringBuilder sb2 = new StringBuilder(138);
                            sb2.append("Spurious audio timestamp (frame position mismatch): ");
                            sb2.append(g2);
                            sb2.append(", ");
                            sb2.append(f2);
                            sb2.append(", ");
                            sb2.append(nanoTime);
                            sb2.append(", ");
                            sb2.append(d2);
                            Log.w("AudioTrack", sb2.toString());
                        }
                    }
                    if (this.q != null) {
                        try {
                            long intValue = (((Integer) r1.invoke(this.f16287d, null)).intValue() * 1000) - j(i(this.f16293j));
                            this.v = intValue;
                            long max = Math.max(intValue, 0L);
                            this.v = max;
                            if (max > 5000000) {
                                StringBuilder sb3 = new StringBuilder(61);
                                sb3.append("Ignoring impossibly large audio latency: ");
                                sb3.append(max);
                                Log.w("AudioTrack", sb3.toString());
                                this.v = 0L;
                            }
                        } catch (Exception unused) {
                            this.q = null;
                        }
                    }
                    this.p = nanoTime;
                }
            }
        }
        long nanoTime2 = System.nanoTime() / 1000;
        if (this.o) {
            return j(this.f16286c.g() + k(nanoTime2 - (this.f16286c.f() / 1000))) + this.t;
        }
        if (this.l == 0) {
            j2 = this.f16286c.d();
            j3 = this.t;
        } else {
            j2 = nanoTime2 + this.m;
            j3 = this.t;
        }
        long j4 = j2 + j3;
        return !z ? j4 - this.v : j4;
    }

    public final int q(int i2) throws zzhu {
        this.a.block();
        if (i2 == 0) {
            this.f16287d = new AudioTrack(3, this.f16288e, this.f16289f, this.f16290g, this.f16293j, 1);
        } else {
            this.f16287d = new AudioTrack(3, this.f16288e, this.f16289f, this.f16290g, this.f16293j, 1, i2);
        }
        int state = this.f16287d.getState();
        if (state == 1) {
            int audioSessionId = this.f16287d.getAudioSessionId();
            this.f16286c.a(this.f16287d, this.A);
            e(this.w);
            return audioSessionId;
        }
        try {
            this.f16287d.release();
        } catch (Exception unused) {
        } finally {
            this.f16287d = null;
        }
        throw new zzhu(state, this.f16288e, this.f16289f, this.f16293j);
    }
}
