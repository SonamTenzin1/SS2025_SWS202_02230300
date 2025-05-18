package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdgr;
import java.security.GeneralSecurityException;

/* loaded from: classes2.dex */
final class lr extends zzdbt<zzdbj, zzdhi, zzdhk> {
    public lr() {
        super(zzdbj.class, zzdhi.class, zzdhk.class, "type.googleapis.com/google.crypto.tink.KmsEnvelopeAeadKey");
    }

    @Override // com.google.android.gms.internal.ads.zzdbs
    public final int H0() {
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzdbt
    protected final zzdgr.zzb i() {
        return zzdgr.zzb.REMOTE;
    }

    @Override // com.google.android.gms.internal.ads.zzdbt
    protected final /* synthetic */ void j(zzdhi zzdhiVar) throws GeneralSecurityException {
        zzdlx.b(zzdhiVar.x(), 0);
    }

    @Override // com.google.android.gms.internal.ads.zzdbt
    protected final /* bridge */ /* synthetic */ void k(zzdhk zzdhkVar) throws GeneralSecurityException {
    }

    @Override // com.google.android.gms.internal.ads.zzdbt
    public final /* synthetic */ zzdbj l(zzdhi zzdhiVar) throws GeneralSecurityException {
        zzdhi zzdhiVar2 = zzdhiVar;
        String x = zzdhiVar2.C().x();
        return new zzdcs(zzdhiVar2.C().y(), zzdbx.a(x).b(x));
    }

    @Override // com.google.android.gms.internal.ads.zzdbt
    public final /* synthetic */ zzdhi n(zzdhk zzdhkVar) throws GeneralSecurityException {
        return (zzdhi) ((zzdob) zzdhi.D().u(zzdhkVar).v(0).p0());
    }

    @Override // com.google.android.gms.internal.ads.zzdbt
    protected final /* synthetic */ zzdhi p(zzdmr zzdmrVar) throws zzdok {
        return zzdhi.F(zzdmrVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdbt
    protected final /* synthetic */ zzdhk q(zzdmr zzdmrVar) throws zzdok {
        return zzdhk.B(zzdmrVar);
    }
}
