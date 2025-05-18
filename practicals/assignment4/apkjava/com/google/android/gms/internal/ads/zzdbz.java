package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdgr;
import com.google.android.gms.internal.ads.zzdha;
import java.security.GeneralSecurityException;

@Deprecated
/* loaded from: classes2.dex */
public final class zzdbz {
    private static void a(zzdha zzdhaVar) throws GeneralSecurityException {
        for (zzdha.zzb zzbVar : zzdhaVar.y()) {
            if (zzbVar.z().D() == zzdgr.zzb.UNKNOWN_KEYMATERIAL || zzbVar.z().D() == zzdgr.zzb.SYMMETRIC || zzbVar.z().D() == zzdgr.zzb.ASYMMETRIC_PRIVATE) {
                throw new GeneralSecurityException("keyset contains secret key material");
            }
        }
    }

    @Deprecated
    public static final zzdbu b(byte[] bArr) throws GeneralSecurityException {
        try {
            zzdha B = zzdha.B(bArr);
            a(B);
            return zzdbu.a(B);
        } catch (zzdok unused) {
            throw new GeneralSecurityException("invalid keyset");
        }
    }
}
