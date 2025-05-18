package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;

/* loaded from: classes2.dex */
final class sr {
    public static zzdkt a(zzdgf zzdgfVar) throws GeneralSecurityException {
        int i2 = tr.f13358b[zzdgfVar.ordinal()];
        if (i2 == 1) {
            return zzdkt.NIST_P256;
        }
        if (i2 == 2) {
            return zzdkt.NIST_P384;
        }
        if (i2 == 3) {
            return zzdkt.NIST_P521;
        }
        String valueOf = String.valueOf(zzdgfVar);
        StringBuilder sb = new StringBuilder(valueOf.length() + 20);
        sb.append("unknown curve type: ");
        sb.append(valueOf);
        throw new GeneralSecurityException(sb.toString());
    }

    public static zzdkv b(zzdfd zzdfdVar) throws GeneralSecurityException {
        int i2 = tr.f13359c[zzdfdVar.ordinal()];
        if (i2 == 1) {
            return zzdkv.UNCOMPRESSED;
        }
        if (i2 == 2) {
            return zzdkv.DO_NOT_USE_CRUNCHY_UNCOMPRESSED;
        }
        if (i2 == 3) {
            return zzdkv.COMPRESSED;
        }
        String valueOf = String.valueOf(zzdfdVar);
        StringBuilder sb = new StringBuilder(valueOf.length() + 22);
        sb.append("unknown point format: ");
        sb.append(valueOf);
        throw new GeneralSecurityException(sb.toString());
    }

    public static String c(zzdgj zzdgjVar) throws NoSuchAlgorithmException {
        int i2 = tr.a[zzdgjVar.ordinal()];
        if (i2 == 1) {
            return "HmacSha1";
        }
        if (i2 == 2) {
            return "HmacSha256";
        }
        if (i2 == 3) {
            return "HmacSha512";
        }
        String valueOf = String.valueOf(zzdgjVar);
        StringBuilder sb = new StringBuilder(valueOf.length() + 27);
        sb.append("hash unsupported for HMAC: ");
        sb.append(valueOf);
        throw new NoSuchAlgorithmException(sb.toString());
    }

    public static void d(zzdft zzdftVar) throws GeneralSecurityException {
        zzdkr.e(a(zzdftVar.x().y()));
        c(zzdftVar.x().x());
        if (zzdftVar.z() != zzdfd.UNKNOWN_FORMAT) {
            zzdcf.d(zzdftVar.y().x());
            return;
        }
        throw new GeneralSecurityException("unknown EC point format");
    }
}
