package com.google.android.gms.internal.ads;

import android.net.Uri;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.common.util.Clock;
import java.io.IOException;
import java.nio.ByteBuffer;

@zzard
/* loaded from: classes2.dex */
public final class zzbgg extends zzbft {

    /* renamed from: i, reason: collision with root package name */
    private String f14436i;

    /* renamed from: j, reason: collision with root package name */
    private final zzbde f14437j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f14438k;
    private final zzbfl l;
    private ByteBuffer m;
    private boolean n;
    private final Object o;
    private boolean p;

    public zzbgg(zzbdf zzbdfVar, zzbde zzbdeVar) {
        super(zzbdfVar);
        this.f14437j = zzbdeVar;
        this.l = new zzbfl();
        this.o = new Object();
    }

    private final void D() {
        int position = this.m.position();
        boolean z = position > 0;
        int g2 = zzbdk.g();
        int h2 = zzbdk.h();
        String str = this.f14436i;
        l(str, z(str), position, 0, z, g2, h2);
    }

    public final ByteBuffer B() {
        synchronized (this.o) {
            ByteBuffer byteBuffer = this.m;
            if (byteBuffer != null && !this.n) {
                byteBuffer.flip();
                this.n = true;
            }
            this.f14438k = true;
        }
        return this.m;
    }

    public final String C() {
        return this.f14436i;
    }

    public final boolean E() {
        return this.p;
    }

    @Override // com.google.android.gms.internal.ads.zzbft
    public final void b() {
        this.f14438k = true;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:53:? -> B:50:0x0136). Please report as a decompilation issue!!! */
    @Override // com.google.android.gms.internal.ads.zzbft
    public final boolean y(String str) {
        String str2;
        this.f14436i = str;
        String z = z(str);
        String str3 = "error";
        int i2 = 0;
        try {
            String str4 = this.f14431g;
            zzbde zzbdeVar = this.f14437j;
            zzjp zzjsVar = new zzjs(str4, null, null, zzbdeVar.f14366d, zzbdeVar.f14368f, true);
            if (this.f14437j.f14372j) {
                try {
                    zzjsVar = new zzbeh(this.f14430f, zzjsVar, null);
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
            zzjsVar.a(new zzjq(Uri.parse(str)));
            zzbdf zzbdfVar = this.f14432h.get();
            if (zzbdfVar != null) {
                zzbdfVar.g(z, this);
            }
            Clock zzln = zzk.zzln();
            long a = zzln.a();
            long longValue = ((Long) zzyt.e().c(zzacu.F)).longValue();
            long longValue2 = ((Long) zzyt.e().c(zzacu.E)).longValue();
            this.m = ByteBuffer.allocate(this.f14437j.f14365c);
            int i3 = 8192;
            byte[] bArr = new byte[8192];
            long j2 = a;
            while (true) {
                int read = zzjsVar.read(bArr, i2, Math.min(this.m.remaining(), i3));
                if (read == -1) {
                    this.p = true;
                    s(str, z, (int) this.l.a(this.m));
                    return true;
                }
                synchronized (this.o) {
                    try {
                        if (this.f14438k) {
                            str2 = str3;
                        } else {
                            str2 = str3;
                            try {
                                this.m.put(bArr, 0, read);
                            } catch (Throwable th) {
                                th = th;
                                throw th;
                            }
                        }
                        try {
                            if (this.m.remaining() <= 0) {
                                D();
                                return true;
                            }
                            if (!this.f14438k) {
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
                                i2 = 0;
                                i3 = 8192;
                            } else {
                                int limit = this.m.limit();
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
