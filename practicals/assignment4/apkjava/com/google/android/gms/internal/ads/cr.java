package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdgr;
import com.google.android.gms.internal.ads.zzdha;
import com.google.android.gms.internal.ads.zzdhc;
import java.nio.charset.Charset;
import java.security.GeneralSecurityException;

/* loaded from: classes2.dex */
final class cr {
    private static final Charset a = Charset.forName("UTF-8");

    public static zzdhc a(zzdha zzdhaVar) {
        zzdhc.zza v = zzdhc.A().v(zzdhaVar.x());
        for (zzdha.zzb zzbVar : zzdhaVar.y()) {
            v.u((zzdhc.zzb) ((zzdob) zzdhc.zzb.D().A(zzbVar.z().B()).u(zzbVar.A()).v(zzbVar.x()).w(zzbVar.B()).p0()));
        }
        return (zzdhc) ((zzdob) v.p0());
    }

    public static void b(zzdha zzdhaVar) throws GeneralSecurityException {
        int x = zzdhaVar.x();
        int i2 = 0;
        boolean z = false;
        boolean z2 = true;
        for (zzdha.zzb zzbVar : zzdhaVar.y()) {
            if (zzbVar.A() != zzdgu.DESTROYED) {
                i2++;
                if (zzbVar.y()) {
                    if (zzbVar.x() != zzdhm.UNKNOWN_PREFIX) {
                        if (zzbVar.A() != zzdgu.UNKNOWN_STATUS) {
                            if (zzbVar.A() == zzdgu.ENABLED && zzbVar.B() == x) {
                                if (z) {
                                    throw new GeneralSecurityException("keyset contains multiple primary keys");
                                }
                                z = true;
                            }
                            if (zzbVar.z().D() != zzdgr.zzb.ASYMMETRIC_PUBLIC) {
                                z2 = false;
                            }
                        } else {
                            throw new GeneralSecurityException(String.format("key %d has unknown status", Integer.valueOf(zzbVar.B())));
                        }
                    } else {
                        throw new GeneralSecurityException(String.format("key %d has unknown prefix", Integer.valueOf(zzbVar.B())));
                    }
                } else {
                    throw new GeneralSecurityException(String.format("key %d has no key data", Integer.valueOf(zzbVar.B())));
                }
            }
        }
        if (i2 == 0) {
            throw new GeneralSecurityException("empty keyset");
        }
        if (!z && !z2) {
            throw new GeneralSecurityException("keyset doesn't contain a valid primary key");
        }
    }
}
