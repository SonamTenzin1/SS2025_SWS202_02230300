package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdgr;
import java.security.GeneralSecurityException;

/* loaded from: classes2.dex */
final class or extends zzdbt<zzdbq, zzdfx, zzdgh> {
    public or() {
        super(zzdbq.class, zzdfx.class, zzdgh.class, "type.googleapis.com/google.crypto.tink.EciesAeadHkdfPublicKey");
    }

    @Override // com.google.android.gms.internal.ads.zzdbs
    public final int H0() {
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzdbt
    protected final zzdgr.zzb i() {
        return zzdgr.zzb.ASYMMETRIC_PUBLIC;
    }

    @Override // com.google.android.gms.internal.ads.zzdbt
    protected final /* synthetic */ void j(zzdfx zzdfxVar) throws GeneralSecurityException {
        zzdfx zzdfxVar2 = zzdfxVar;
        zzdlx.b(zzdfxVar2.x(), 0);
        sr.d(zzdfxVar2.E());
    }

    @Override // com.google.android.gms.internal.ads.zzdbt
    protected final /* bridge */ /* synthetic */ void k(zzdgh zzdghVar) throws GeneralSecurityException {
    }

    @Override // com.google.android.gms.internal.ads.zzdbt
    protected final /* synthetic */ zzdbq l(zzdfx zzdfxVar) throws GeneralSecurityException {
        zzdfx zzdfxVar2 = zzdfxVar;
        zzdft E = zzdfxVar2.E();
        zzdfz x = E.x();
        return new zzdkc(zzdkr.d(sr.a(x.y()), zzdfxVar2.C().c(), zzdfxVar2.D().c()), x.z().c(), sr.c(x.x()), sr.b(E.z()), new ur(E.y().x()));
    }

    @Override // com.google.android.gms.internal.ads.zzdbt
    public final /* synthetic */ zzdfx n(zzdgh zzdghVar) throws GeneralSecurityException {
        throw new GeneralSecurityException("Not implemented.");
    }

    @Override // com.google.android.gms.internal.ads.zzdbt
    protected final /* synthetic */ zzdfx p(zzdmr zzdmrVar) throws zzdok {
        return zzdfx.M(zzdmrVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdbt
    protected final /* synthetic */ zzdgh q(zzdmr zzdmrVar) throws zzdok {
        return zzdgh.y(zzdmrVar);
    }
}
