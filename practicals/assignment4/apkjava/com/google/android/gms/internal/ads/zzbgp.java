package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.net.Uri;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.common.util.Clock;
import java.io.IOException;

@zzard
@TargetApi(16)
/* loaded from: classes2.dex */
public final class zzbgp extends zzbft implements zzbfi {

    /* renamed from: i, reason: collision with root package name */
    private zzbfa f14445i;

    /* renamed from: j, reason: collision with root package name */
    private String f14446j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f14447k;
    private Exception l;
    private boolean m;

    public zzbgp(zzbdf zzbdfVar, zzbde zzbdeVar) {
        super(zzbdfVar);
        zzbfa zzbfaVar = new zzbfa(zzbdfVar.getContext(), zzbdeVar);
        this.f14445i = zzbfaVar;
        zzbfaVar.x(this);
    }

    private static String C(String str, Exception exc) {
        String canonicalName = exc.getClass().getCanonicalName();
        String message = exc.getMessage();
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 2 + String.valueOf(canonicalName).length() + String.valueOf(message).length());
        sb.append(str);
        sb.append("/");
        sb.append(canonicalName);
        sb.append(":");
        sb.append(message);
        return sb.toString();
    }

    private final void D(String str) {
        synchronized (this) {
            this.f14447k = true;
            notify();
            c();
        }
        String str2 = this.f14446j;
        if (str2 != null) {
            String z = z(str2);
            Exception exc = this.l;
            if (exc != null) {
                q(this.f14446j, z, "badUrl", C(str, exc));
            } else {
                q(this.f14446j, z, "externalAbort", "Programmatic precache abort.");
            }
        }
    }

    public final zzbfa B() {
        synchronized (this) {
            this.m = true;
            notify();
        }
        this.f14445i.x(null);
        zzbfa zzbfaVar = this.f14445i;
        this.f14445i = null;
        return zzbfaVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbfi
    public final void a(final boolean z, final long j2) {
        final zzbdf zzbdfVar = this.f14432h.get();
        if (zzbdfVar != null) {
            zzbbm.a.execute(new Runnable(zzbdfVar, z, j2) { // from class: com.google.android.gms.internal.ads.la

                /* renamed from: f, reason: collision with root package name */
                private final zzbdf f12918f;

                /* renamed from: g, reason: collision with root package name */
                private final boolean f12919g;

                /* renamed from: h, reason: collision with root package name */
                private final long f12920h;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.f12918f = zzbdfVar;
                    this.f12919g = z;
                    this.f12920h = j2;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.f12918f.R(this.f12919g, this.f12920h);
                }
            });
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbft
    public final void b() {
        D(null);
    }

    @Override // com.google.android.gms.internal.ads.zzbft, com.google.android.gms.common.api.Releasable
    public final void c() {
        zzbfa zzbfaVar = this.f14445i;
        if (zzbfaVar != null) {
            zzbfaVar.x(null);
            this.f14445i.t();
        }
        super.c();
    }

    @Override // com.google.android.gms.internal.ads.zzbfi
    public final void e(int i2) {
    }

    @Override // com.google.android.gms.internal.ads.zzbfi
    public final void f(String str, Exception exc) {
        this.l = exc;
        zzbad.d("Precache error", exc);
        D(str);
    }

    @Override // com.google.android.gms.internal.ads.zzbfi
    public final void g(int i2, int i3) {
    }

    @Override // com.google.android.gms.internal.ads.zzbft
    public final void t(int i2) {
        this.f14445i.J().j(i2);
    }

    @Override // com.google.android.gms.internal.ads.zzbft
    public final void u(int i2) {
        this.f14445i.J().k(i2);
    }

    @Override // com.google.android.gms.internal.ads.zzbft
    public final void v(int i2) {
        this.f14445i.J().h(i2);
    }

    @Override // com.google.android.gms.internal.ads.zzbft
    public final void w(int i2) {
        this.f14445i.J().i(i2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:49:0x0100, code lost:
    
        return true;
     */
    @Override // com.google.android.gms.internal.ads.zzbft
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean x(String str, String[] strArr) {
        String str2;
        long j2;
        long j3;
        long j4;
        String str3;
        long j5;
        long j6;
        this.f14446j = str;
        String z = z(str);
        String str4 = "error";
        try {
            Uri[] uriArr = new Uri[strArr.length];
            for (int i2 = 0; i2 < strArr.length; i2++) {
                try {
                    uriArr[i2] = Uri.parse(strArr[i2]);
                } catch (Exception e2) {
                    e = e2;
                    String message = e.getMessage();
                    StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 34 + String.valueOf(message).length());
                    sb.append("Failed to preload url ");
                    sb.append(str);
                    sb.append(" Exception: ");
                    sb.append(message);
                    zzbad.i(sb.toString());
                    c();
                    q(str, z, str4, C(str4, e));
                    return false;
                }
            }
            this.f14445i.y(uriArr, this.f14431g);
            zzbdf zzbdfVar = this.f14432h.get();
            if (zzbdfVar != null) {
                zzbdfVar.g(z, this);
            }
            Clock zzln = zzk.zzln();
            long a = zzln.a();
            long longValue = ((Long) zzyt.e().c(zzacu.F)).longValue();
            long longValue2 = ((Long) zzyt.e().c(zzacu.E)).longValue() * 1000;
            long intValue = ((Integer) zzyt.e().c(zzacu.D)).intValue();
            long j7 = -1;
            while (true) {
                try {
                    synchronized (this) {
                        try {
                            if (zzln.a() - a <= longValue2) {
                                if (this.f14447k) {
                                    Exception exc = this.l;
                                    if (exc != null) {
                                        throw exc;
                                    }
                                    throw new IOException("Abort requested before buffering finished. ");
                                }
                                if (!this.m) {
                                    zzkv I = this.f14445i.I();
                                    if (I != null) {
                                        str2 = str4;
                                        try {
                                            long g2 = I.g();
                                            if (g2 > 0) {
                                                long d2 = I.d();
                                                if (d2 != j7) {
                                                    j2 = intValue;
                                                    j3 = longValue2;
                                                    j5 = longValue;
                                                    p(str, z, d2, g2, d2 > 0, zzbfa.G(), zzbfa.H());
                                                    j6 = d2;
                                                } else {
                                                    j2 = intValue;
                                                    j3 = longValue2;
                                                    j5 = longValue;
                                                    j6 = j7;
                                                }
                                                if (d2 >= g2) {
                                                    s(str, z, g2);
                                                } else if (this.f14445i.s() < j2 || d2 <= 0) {
                                                    j4 = j5;
                                                    str3 = j6;
                                                }
                                            } else {
                                                j2 = intValue;
                                                j3 = longValue2;
                                                j4 = longValue;
                                                str3 = j7;
                                            }
                                            try {
                                                try {
                                                    wait(j4);
                                                } catch (InterruptedException unused) {
                                                    throw new IOException("Wait interrupted.");
                                                }
                                            } catch (Throwable th) {
                                                th = th;
                                                str4 = str3;
                                                throw th;
                                            }
                                        } catch (Throwable th2) {
                                            th = th2;
                                            str4 = str2;
                                        }
                                    } else {
                                        throw new IOException("ExoPlayer was released during preloading.");
                                    }
                                }
                            } else {
                                long j8 = longValue2;
                                StringBuilder sb2 = new StringBuilder(47);
                                sb2.append("Timeout reached. Limit: ");
                                sb2.append(j8);
                                sb2.append(" ms");
                                throw new IOException(sb2.toString());
                            }
                        } catch (Throwable th3) {
                            th = th3;
                        }
                    }
                    longValue = j4;
                    str4 = str2;
                    intValue = j2;
                    longValue2 = j3;
                    j7 = str3;
                } catch (Throwable th4) {
                    th = th4;
                }
            }
        } catch (Exception e3) {
            e = e3;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbft
    public final boolean y(String str) {
        return x(str, new String[]{str});
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzbft
    public final String z(String str) {
        String valueOf = String.valueOf(super.z(str));
        return valueOf.length() != 0 ? "cache:".concat(valueOf) : new String("cache:");
    }
}
