package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdgr;
import java.security.GeneralSecurityException;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes2.dex */
final class vr extends zzdbt<zzdby, zzdgl, zzdgn> {
    public vr() {
        super(zzdby.class, zzdgl.class, zzdgn.class, "type.googleapis.com/google.crypto.tink.HmacKey");
    }

    private static void r(zzdgp zzdgpVar) throws GeneralSecurityException {
        if (zzdgpVar.y() >= 10) {
            int i2 = wr.a[zzdgpVar.x().ordinal()];
            if (i2 == 1) {
                if (zzdgpVar.y() > 20) {
                    throw new GeneralSecurityException("tag size too big");
                }
                return;
            } else if (i2 == 2) {
                if (zzdgpVar.y() > 32) {
                    throw new GeneralSecurityException("tag size too big");
                }
                return;
            } else {
                if (i2 == 3) {
                    if (zzdgpVar.y() > 64) {
                        throw new GeneralSecurityException("tag size too big");
                    }
                    return;
                }
                throw new GeneralSecurityException("unknown hash type");
            }
        }
        throw new GeneralSecurityException("tag size too small");
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
    protected final /* synthetic */ void j(zzdgl zzdglVar) throws GeneralSecurityException {
        zzdgl zzdglVar2 = zzdglVar;
        zzdlx.b(zzdglVar2.x(), 0);
        if (zzdglVar2.C().size() >= 16) {
            r(zzdglVar2.D());
            return;
        }
        throw new GeneralSecurityException("key too short");
    }

    @Override // com.google.android.gms.internal.ads.zzdbt
    protected final /* synthetic */ void k(zzdgn zzdgnVar) throws GeneralSecurityException {
        zzdgn zzdgnVar2 = zzdgnVar;
        if (zzdgnVar2.x() >= 16) {
            r(zzdgnVar2.y());
            return;
        }
        throw new GeneralSecurityException("key too short");
    }

    @Override // com.google.android.gms.internal.ads.zzdbt
    public final /* synthetic */ zzdby l(zzdgl zzdglVar) throws GeneralSecurityException {
        zzdgl zzdglVar2 = zzdglVar;
        zzdgj x = zzdglVar2.D().x();
        SecretKeySpec secretKeySpec = new SecretKeySpec(zzdglVar2.C().c(), "HMAC");
        int y = zzdglVar2.D().y();
        int i2 = wr.a[x.ordinal()];
        if (i2 == 1) {
            return new zzdll("HMACSHA1", secretKeySpec, y);
        }
        if (i2 == 2) {
            return new zzdll("HMACSHA256", secretKeySpec, y);
        }
        if (i2 == 3) {
            return new zzdll("HMACSHA512", secretKeySpec, y);
        }
        throw new GeneralSecurityException("unknown hash");
    }

    @Override // com.google.android.gms.internal.ads.zzdbt
    public final /* synthetic */ zzdgl n(zzdgn zzdgnVar) throws GeneralSecurityException {
        zzdgn zzdgnVar2 = zzdgnVar;
        return (zzdgl) ((zzdob) zzdgl.E().w(0).v(zzdgnVar2.y()).u(zzdmr.D(zzdlo.c(zzdgnVar2.x()))).p0());
    }

    @Override // com.google.android.gms.internal.ads.zzdbt
    protected final /* synthetic */ zzdgl p(zzdmr zzdmrVar) throws zzdok {
        return zzdgl.I(zzdmrVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdbt
    protected final /* synthetic */ zzdgn q(zzdmr zzdmrVar) throws zzdok {
        return zzdgn.B(zzdmrVar);
    }
}
