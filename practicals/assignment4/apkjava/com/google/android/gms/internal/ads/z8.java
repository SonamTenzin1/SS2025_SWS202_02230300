package com.google.android.gms.internal.ads;

import android.media.MediaCodec;
import android.view.Surface;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class z8 implements zzhh {
    private final /* synthetic */ zzbdq a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z8(zzbdq zzbdqVar) {
        this.a = zzbdqVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgw
    public final void a(MediaCodec.CryptoException cryptoException) {
        this.a.L("CryptoError", cryptoException.getMessage());
    }

    @Override // com.google.android.gms.internal.ads.zzhh
    public final void b(int i2, long j2) {
        StringBuilder sb = new StringBuilder(64);
        sb.append("Dropped frames. Count: ");
        sb.append(i2);
        sb.append(" Elapsed: ");
        sb.append(j2);
        zzbad.e(sb.toString());
    }

    @Override // com.google.android.gms.internal.ads.zzgw
    public final void c(String str, long j2, long j3) {
    }

    @Override // com.google.android.gms.internal.ads.zzgw
    public final void d(zzgv zzgvVar) {
        this.a.L("DecoderInitializationError", zzgvVar.getMessage());
    }

    @Override // com.google.android.gms.internal.ads.zzhh
    public final void e(int i2, int i3, float f2) {
        int i4;
        int i5;
        float f3;
        this.a.B = i2;
        this.a.C = i3;
        this.a.D = f2;
        zzbdq zzbdqVar = this.a;
        i4 = zzbdqVar.B;
        i5 = this.a.C;
        f3 = this.a.D;
        zzbdqVar.A(i4, i5, f3);
    }

    @Override // com.google.android.gms.internal.ads.zzhh
    public final void g(Surface surface) {
    }
}
