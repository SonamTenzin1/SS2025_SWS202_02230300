package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdgr;
import java.security.GeneralSecurityException;

/* loaded from: classes2.dex */
final class gr extends zzdbt<zzdlk, zzdeb, zzded> {
    public gr() {
        super(zzdlk.class, zzdeb.class, zzded.class, "type.googleapis.com/google.crypto.tink.AesCtrKey");
    }

    private static void r(zzdef zzdefVar) throws GeneralSecurityException {
        if (zzdefVar.x() < 12 || zzdefVar.x() > 16) {
            throw new GeneralSecurityException("invalid IV size");
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdbs
    public final int H0() {
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzdbt
    protected final zzdgr.zzb i() {
        return zzdgr.zzb.SYMMETRIC;
    }

    @Override // com.google.android.gms.internal.ads.zzdbt
    protected final /* synthetic */ void j(zzdeb zzdebVar) throws GeneralSecurityException {
        zzdeb zzdebVar2 = zzdebVar;
        zzdlx.b(zzdebVar2.x(), 0);
        zzdlx.a(zzdebVar2.D().size());
        r(zzdebVar2.E());
    }

    @Override // com.google.android.gms.internal.ads.zzdbt
    protected final /* synthetic */ void k(zzded zzdedVar) throws GeneralSecurityException {
        zzded zzdedVar2 = zzdedVar;
        zzdlx.a(zzdedVar2.x());
        r(zzdedVar2.z());
    }

    @Override // com.google.android.gms.internal.ads.zzdbt
    public final /* synthetic */ zzdlk l(zzdeb zzdebVar) throws GeneralSecurityException {
        zzdeb zzdebVar2 = zzdebVar;
        return new zzdjj(zzdebVar2.D().c(), zzdebVar2.E().x());
    }

    @Override // com.google.android.gms.internal.ads.zzdbt
    public final /* synthetic */ zzdeb n(zzded zzdedVar) throws GeneralSecurityException {
        zzded zzdedVar2 = zzdedVar;
        return (zzdeb) ((zzdob) zzdeb.F().v(zzdedVar2.z()).u(zzdmr.D(zzdlo.c(zzdedVar2.x()))).w(0).p0());
    }

    @Override // com.google.android.gms.internal.ads.zzdbt
    protected final /* synthetic */ zzdeb p(zzdmr zzdmrVar) throws zzdok {
        return zzdeb.C(zzdmrVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdbt
    protected final /* synthetic */ zzded q(zzdmr zzdmrVar) throws zzdok {
        return zzded.y(zzdmrVar);
    }
}
