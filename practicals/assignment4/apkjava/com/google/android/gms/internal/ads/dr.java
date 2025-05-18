package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* loaded from: classes2.dex */
final class dr implements zzdbk<zzdbj> {
    @Override // com.google.android.gms.internal.ads.zzdbk
    public final zzdcc<zzdbj> a() {
        return new zzdck();
    }

    @Override // com.google.android.gms.internal.ads.zzdbk
    public final zzdbs<zzdbj> b(String str, String str2, int i2) throws GeneralSecurityException {
        zzdbs<zzdbj> mrVar;
        String lowerCase = str2.toLowerCase();
        lowerCase.hashCode();
        if (!lowerCase.equals("aead")) {
            throw new GeneralSecurityException(String.format("No support for primitive '%s'.", str2));
        }
        str.hashCode();
        char c2 = 65535;
        switch (str.hashCode()) {
            case 245054116:
                if (str.equals("type.googleapis.com/google.crypto.tink.XChaCha20Poly1305Key")) {
                    c2 = 0;
                    break;
                }
                break;
            case 360753376:
                if (str.equals("type.googleapis.com/google.crypto.tink.ChaCha20Poly1305Key")) {
                    c2 = 1;
                    break;
                }
                break;
            case 1215885937:
                if (str.equals("type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey")) {
                    c2 = 2;
                    break;
                }
                break;
            case 1469984853:
                if (str.equals("type.googleapis.com/google.crypto.tink.KmsAeadKey")) {
                    c2 = 3;
                    break;
                }
                break;
            case 1797113348:
                if (str.equals("type.googleapis.com/google.crypto.tink.AesEaxKey")) {
                    c2 = 4;
                    break;
                }
                break;
            case 1855890991:
                if (str.equals("type.googleapis.com/google.crypto.tink.AesGcmKey")) {
                    c2 = 5;
                    break;
                }
                break;
            case 2079211877:
                if (str.equals("type.googleapis.com/google.crypto.tink.KmsEnvelopeAeadKey")) {
                    c2 = 6;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                mrVar = new mr();
                break;
            case 1:
                mrVar = new jr();
                break;
            case 2:
                mrVar = new fr();
                break;
            case 3:
                mrVar = new kr();
                break;
            case 4:
                mrVar = new hr();
                break;
            case 5:
                mrVar = new ir();
                break;
            case 6:
                mrVar = new lr();
                break;
            default:
                throw new GeneralSecurityException(String.format("No support for primitive 'Aead' with key type '%s'.", str));
        }
        if (mrVar.H0() >= i2) {
            return mrVar;
        }
        throw new GeneralSecurityException(String.format("No key manager for key type '%s' with version at least %d.", str, Integer.valueOf(i2)));
    }
}
