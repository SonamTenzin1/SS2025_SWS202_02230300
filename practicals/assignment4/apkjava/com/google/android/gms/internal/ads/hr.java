package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdgr;
import java.security.GeneralSecurityException;

/* loaded from: classes2.dex */
final class hr extends zzdbt<zzdbj, zzdeh, zzdej> {
    public hr() {
        super(zzdbj.class, zzdeh.class, zzdej.class, "type.googleapis.com/google.crypto.tink.AesEaxKey");
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
    protected final /* synthetic */ void j(zzdeh zzdehVar) throws GeneralSecurityException {
        zzdeh zzdehVar2 = zzdehVar;
        zzdlx.b(zzdehVar2.x(), 0);
        zzdlx.a(zzdehVar2.E().size());
        if (zzdehVar2.F().x() != 12 && zzdehVar2.F().x() != 16) {
            throw new GeneralSecurityException("invalid IV size; acceptable values have 12 or 16 bytes");
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdbt
    protected final /* synthetic */ void k(zzdej zzdejVar) throws GeneralSecurityException {
        zzdej zzdejVar2 = zzdejVar;
        zzdlx.a(zzdejVar2.x());
        if (zzdejVar2.z().x() != 12 && zzdejVar2.z().x() != 16) {
            throw new GeneralSecurityException("invalid IV size; acceptable values have 12 or 16 bytes");
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdbt
    public final /* synthetic */ zzdbj l(zzdeh zzdehVar) throws GeneralSecurityException {
        zzdeh zzdehVar2 = zzdehVar;
        return new zzdjk(zzdehVar2.E().c(), zzdehVar2.F().x());
    }

    @Override // com.google.android.gms.internal.ads.zzdbt
    public final /* synthetic */ zzdeh n(zzdej zzdejVar) throws GeneralSecurityException {
        zzdej zzdejVar2 = zzdejVar;
        return (zzdeh) ((zzdob) zzdeh.G().u(zzdmr.D(zzdlo.c(zzdejVar2.x()))).v(zzdejVar2.z()).w(0).p0());
    }

    @Override // com.google.android.gms.internal.ads.zzdbt
    protected final /* synthetic */ zzdeh p(zzdmr zzdmrVar) throws zzdok {
        return zzdeh.D(zzdmrVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdbt
    protected final /* synthetic */ zzdej q(zzdmr zzdmrVar) throws zzdok {
        return zzdej.y(zzdmrVar);
    }
}
