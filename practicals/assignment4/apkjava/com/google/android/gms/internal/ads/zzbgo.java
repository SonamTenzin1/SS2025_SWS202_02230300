package com.google.android.gms.internal.ads;

import android.net.Uri;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.common.util.Clock;
import java.io.IOException;
import java.nio.ByteBuffer;

@zzard
/* loaded from: classes2.dex */
public final class zzbgo extends zzbft implements zzsj<zzrv> {

    /* renamed from: i, reason: collision with root package name */
    private String f14442i;

    /* renamed from: j, reason: collision with root package name */
    private final zzbde f14443j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f14444k;
    private final ka l;
    private final zzbfl m;
    private ByteBuffer n;
    private boolean o;
    private final Object p;
    private boolean q;

    public zzbgo(zzbdf zzbdfVar, zzbde zzbdeVar) {
        super(zzbdfVar);
        this.f14443j = zzbdeVar;
        this.l = new ka();
        this.m = new zzbfl();
        this.p = new Object();
    }

    private final void D() {
        int b2 = (int) this.l.b();
        int a = (int) this.m.a(this.n);
        int position = this.n.position();
        int round = Math.round(a * (position / b2));
        boolean z = round > 0;
        int G = zzbfa.G();
        int H = zzbfa.H();
        String str = this.f14442i;
        k(str, z(str), position, b2, round, a, z, G, H);
    }

    public final ByteBuffer B() {
        synchronized (this.p) {
            ByteBuffer byteBuffer = this.n;
            if (byteBuffer != null && !this.o) {
                byteBuffer.flip();
                this.o = true;
            }
            this.f14444k = true;
        }
        return this.n;
    }

    public final String C() {
        return this.f14442i;
    }

    public final boolean E() {
        return this.q;
    }

    @Override // com.google.android.gms.internal.ads.zzbft
    public final void b() {
        this.f14444k = true;
    }

    @Override // com.google.android.gms.internal.ads.zzsj
    public final /* bridge */ /* synthetic */ void d(zzrv zzrvVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzsj
    public final /* synthetic */ void n(zzrv zzrvVar, zzry zzryVar) {
        zzrv zzrvVar2 = zzrvVar;
        if (zzrvVar2 instanceof zzsa) {
            this.l.a((zzsa) zzrvVar2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzsj
    public final /* bridge */ /* synthetic */ void o(zzrv zzrvVar, int i2) {
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:53:? -> B:50:0x0138). Please report as a decompilation issue!!! */
    @Override // com.google.android.gms.internal.ads.zzbft
    public final boolean y(String str) {
        String str2;
        this.f14442i = str;
        String z = z(str);
        String str3 = "error";
        int i2 = 0;
        try {
            String str4 = this.f14431g;
            zzbde zzbdeVar = this.f14443j;
            zzrv zzsaVar = new zzsa(str4, null, this, zzbdeVar.f14366d, zzbdeVar.f14368f, true, null);
            if (this.f14443j.f14372j) {
                try {
                    zzsaVar = new zzbex(this.f14430f, zzsaVar, null, null);
                } catch (Exception e2) {
                    e = e2;
                    String canonicalName = e.getClass().getCanonicalName();
                    String message = e.getMessage();
                    StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 1 + String.valueOf(message).length());
                    sb.append(canonicalName);
                    sb.append(":");
                    sb.append(message);
                    String sb2 = sb.toString();
                    StringBuilder sb3 = new StringBuilder(String.valueOf(str).length() + 34 + String.valueOf(sb2).length());
                    sb3.append("Failed to preload url ");
                    sb3.append(str);
                    sb3.append(" Exception: ");
                    sb3.append(sb2);
                    zzbad.i(sb3.toString());
                    q(str, z, str3, sb2);
                    return false;
                }
            }
            zzsaVar.a(new zzry(Uri.parse(str)));
            zzbdf zzbdfVar = this.f14432h.get();
            if (zzbdfVar != null) {
                zzbdfVar.g(z, this);
            }
            Clock zzln = zzk.zzln();
            long a = zzln.a();
            long longValue = ((Long) zzyt.e().c(zzacu.F)).longValue();
            long longValue2 = ((Long) zzyt.e().c(zzacu.E)).longValue();
            this.n = ByteBuffer.allocate(this.f14443j.f14365c);
            int i3 = 8192;
            byte[] bArr = new byte[8192];
            long j2 = a;
            while (true) {
                int read = zzsaVar.read(bArr, i2, Math.min(this.n.remaining(), i3));
                if (read == -1) {
                    this.q = true;
                    s(str, z, (int) this.m.a(this.n));
                    return true;
                }
                synchronized (this.p) {
                    try {
                        if (this.f14444k) {
                            str2 = str3;
                        } else {
                            str2 = str3;
                            try {
                                this.n.put(bArr, 0, read);
                            } catch (Throwable th) {
                                th = th;
                                throw th;
                            }
                        }
                        try {
                            if (this.n.remaining() <= 0) {
                                D();
                                return true;
                            }
                            if (!this.f14444k) {
                                long a2 = zzln.a();
                                if (a2 - j2 >= longValue) {
                                    D();
                                    j2 = a2;
                                }
                                if (a2 - a > 1000 * longValue2) {
                                    StringBuilder sb4 = new StringBuilder(49);
                                    sb4.append("Timeout exceeded. Limit: ");
                                    sb4.append(longValue2);
                                    sb4.append(" sec");
                                    throw new IOException(sb4.toString());
                                }
                                str3 = str2;
                                i3 = 8192;
                                i2 = 0;
                            } else {
                                int limit = this.n.limit();
                                StringBuilder sb5 = new StringBuilder(35);
                                sb5.append("Precache abort at ");
                                sb5.append(limit);
                                sb5.append(" bytes");
                                throw new IOException(sb5.toString());
                            }
                        } catch (Exception e3) {
                            e = e3;
                            str3 = str2;
                            String canonicalName2 = e.getClass().getCanonicalName();
                            String message2 = e.getMessage();
                            StringBuilder sb6 = new StringBuilder(String.valueOf(canonicalName2).length() + 1 + String.valueOf(message2).length());
                            sb6.append(canonicalName2);
                            sb6.append(":");
                            sb6.append(message2);
                            String sb22 = sb6.toString();
                            StringBuilder sb32 = new StringBuilder(String.valueOf(str).length() + 34 + String.valueOf(sb22).length());
                            sb32.append("Failed to preload url ");
                            sb32.append(str);
                            sb32.append(" Exception: ");
                            sb32.append(sb22);
                            zzbad.i(sb32.toString());
                            q(str, z, str3, sb22);
                            return false;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        throw th;
                    }
                }
            }
        } catch (Exception e4) {
            e = e4;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzbft
    public final String z(String str) {
        String valueOf = String.valueOf(super.z(str));
        return valueOf.length() != 0 ? "cache:".concat(valueOf) : new String("cache:");
    }
}
