package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdgr;
import java.security.GeneralSecurityException;
import java.security.KeyPair;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECPoint;

/* loaded from: classes2.dex */
final class nr extends zzdbt<zzdbp, zzdfv, zzdfr> implements zzdbs<zzdbp> {
    public nr() {
        super(zzdbp.class, zzdfv.class, zzdfr.class, "type.googleapis.com/google.crypto.tink.EciesAeadHkdfPrivateKey");
    }

    @Override // com.google.android.gms.internal.ads.zzdbs
    public final int H0() {
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzdbt
    protected final zzdgr.zzb i() {
        return zzdgr.zzb.ASYMMETRIC_PRIVATE;
    }

    @Override // com.google.android.gms.internal.ads.zzdbt
    protected final /* synthetic */ void j(zzdfv zzdfvVar) throws GeneralSecurityException {
        zzdfv zzdfvVar2 = zzdfvVar;
        zzdlx.b(zzdfvVar2.x(), 0);
        sr.d(zzdfvVar2.E().E());
    }

    @Override // com.google.android.gms.internal.ads.zzdbt
    protected final /* synthetic */ void k(zzdfr zzdfrVar) throws GeneralSecurityException {
        sr.d(zzdfrVar.x());
    }

    @Override // com.google.android.gms.internal.ads.zzdbt
    public final /* synthetic */ zzdbp l(zzdfv zzdfvVar) throws GeneralSecurityException {
        zzdfv zzdfvVar2 = zzdfvVar;
        zzdft E = zzdfvVar2.E().E();
        zzdfz x = E.x();
        return new zzdkb(zzdkr.c(sr.a(x.y()), zzdfvVar2.D().c()), x.z().c(), sr.c(x.x()), sr.b(E.z()), new ur(E.y().x()));
    }

    @Override // com.google.android.gms.internal.ads.zzdbt
    public final /* synthetic */ zzdfv n(zzdfr zzdfrVar) throws GeneralSecurityException {
        zzdfr zzdfrVar2 = zzdfrVar;
        KeyPair b2 = zzdkr.b(zzdkr.e(sr.a(zzdfrVar2.x().x().y())));
        ECPublicKey eCPublicKey = (ECPublicKey) b2.getPublic();
        ECPrivateKey eCPrivateKey = (ECPrivateKey) b2.getPrivate();
        ECPoint w = eCPublicKey.getW();
        return (zzdfv) ((zzdob) zzdfv.F().w(0).u((zzdfx) ((zzdob) zzdfx.F().A(0).w(zzdfrVar2.x()).u(zzdmr.D(w.getAffineX().toByteArray())).v(zzdmr.D(w.getAffineY().toByteArray())).p0())).v(zzdmr.D(eCPrivateKey.getS().toByteArray())).p0());
    }

    @Override // com.google.android.gms.internal.ads.zzdbt
    protected final /* synthetic */ zzdfv p(zzdmr zzdmrVar) throws zzdok {
        return zzdfv.H(zzdmrVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdbt
    protected final /* synthetic */ zzdfr q(zzdmr zzdmrVar) throws zzdok {
        return zzdfr.z(zzdmrVar);
    }
}
