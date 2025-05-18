package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.common.util.Clock;
import java.io.IOException;

@zzard
@TargetApi(16)
/* loaded from: classes2.dex */
public abstract class zzbgl extends zzbft {

    /* renamed from: i, reason: collision with root package name */
    private final zzbdk f14439i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f14440j;

    /* renamed from: k, reason: collision with root package name */
    private String f14441k;
    private boolean l;

    public zzbgl(zzbdf zzbdfVar) {
        super(zzbdfVar);
        this.f14441k = null;
        zzbdk zzbdkVar = new zzbdk();
        this.f14439i = zzbdkVar;
        zzbdkVar.c(new ja(this));
    }

    protected abstract zzhn C(String str);

    protected abstract int D();

    public final void E() {
        synchronized (this) {
            this.l = true;
            this.f14439i.a();
        }
    }

    public final zzbdk F() {
        return this.f14439i;
    }

    @Override // com.google.android.gms.internal.ads.zzbft
    public final void b() {
        synchronized (this) {
            this.f14440j = true;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbft, com.google.android.gms.common.api.Releasable
    public void c() {
        this.f14439i.i();
        super.c();
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x00e0, code lost:
    
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00e4, code lost:
    
        java.lang.Thread.sleep(r18);
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00f5, code lost:
    
        throw new java.io.IOException("Interrupted sleep.");
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x00f8, code lost:
    
        r0 = java.lang.Long.toString(r20);
        r3 = new java.lang.StringBuilder(java.lang.String.valueOf(r0).length() + 27);
        r3.append("Timeout reached. Limit: ");
        r3.append(r0);
        r3.append(" ms");
        r2 = r3.toString();
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0123, code lost:
    
        throw new java.io.IOException("Timed out while buffering.");
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x0124, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x012d, code lost:
    
        throw r0;
     */
    /* JADX WARN: Type inference failed for: r1v23 */
    /* JADX WARN: Type inference failed for: r1v24, types: [long] */
    /* JADX WARN: Type inference failed for: r1v34 */
    @Override // com.google.android.gms.internal.ads.zzbft
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean y(String str) {
        long j2;
        long j3;
        long j4;
        long j5;
        zzhn C = C(str);
        String z = z(str);
        try {
            if (this.f14439i.e(C)) {
                zzge j6 = this.f14439i.j();
                if (j6 != null) {
                    zzbdf zzbdfVar = this.f14432h.get();
                    if (zzbdfVar != null) {
                        zzbdfVar.g(z, this);
                    }
                    Clock zzln = zzk.zzln();
                    long a = zzln.a();
                    long longValue = ((Long) zzyt.e().c(zzacu.F)).longValue();
                    long longValue2 = ((Long) zzyt.e().c(zzacu.E)).longValue() * 1000;
                    long intValue = ((Integer) zzyt.e().c(zzacu.D)).intValue();
                    ?? r1 = -1;
                    while (true) {
                        synchronized (this) {
                            try {
                                try {
                                    if (zzln.a() - a > longValue2) {
                                        break;
                                    }
                                    if (this.f14440j) {
                                        if (!TextUtils.isEmpty(this.f14441k)) {
                                            String str2 = this.f14441k;
                                        }
                                        throw new IOException("Abort requested before buffering finished. ");
                                    }
                                    if (!this.l) {
                                        long g2 = j6.g();
                                        if (g2 > 0) {
                                            long d2 = j6.d();
                                            if (d2 != r1) {
                                                j2 = intValue;
                                                m(str, z, d2, g2, d2 > 0);
                                                j5 = d2;
                                                j4 = g2;
                                            } else {
                                                j2 = intValue;
                                                j4 = g2;
                                                j5 = r1;
                                            }
                                            if (d2 >= j4) {
                                                s(str, z, j4);
                                            } else {
                                                D();
                                                j3 = j5;
                                                if (0 >= j2) {
                                                    j3 = j5;
                                                    if (d2 > 0) {
                                                    }
                                                }
                                            }
                                        } else {
                                            j2 = intValue;
                                            j3 = r1;
                                        }
                                    }
                                } catch (Throwable th) {
                                    th = th;
                                }
                            } catch (Throwable th2) {
                                th = th2;
                            }
                        }
                        intValue = j2;
                        r1 = j3;
                    }
                } else {
                    c();
                    throw new IOException("Failed to get ExoPlayer");
                }
            } else {
                c();
                throw new IOException("Failed to prepare AdExoPlayerHelper");
            }
        } catch (IOException e2) {
            String message = e2.getMessage();
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 34 + String.valueOf(message).length());
            sb.append("Failed to preload url ");
            sb.append(str);
            sb.append(" Exception: ");
            sb.append(message);
            zzbad.i(sb.toString());
            q(str, z, "error", null);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzbft
    public final String z(String str) {
        String valueOf = String.valueOf(super.z(str));
        return valueOf.length() != 0 ? "cache:".concat(valueOf) : new String("cache:");
    }
}
