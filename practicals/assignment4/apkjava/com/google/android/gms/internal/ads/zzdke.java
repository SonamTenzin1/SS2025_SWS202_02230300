package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.KeyPair;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPoint;
import java.security.spec.EllipticCurve;
import java.util.Arrays;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes2.dex */
public final class zzdke {
    private ECPublicKey a;

    public zzdke(ECPublicKey eCPublicKey) {
        this.a = eCPublicKey;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0139  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x018c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final zzdkf a(String str, byte[] bArr, byte[] bArr2, int i2, zzdkv zzdkvVar) throws GeneralSecurityException {
        byte[] bArr3;
        byte[] bArr4;
        Mac b2;
        KeyPair b3 = zzdkr.b(this.a.getParams());
        ECPublicKey eCPublicKey = (ECPublicKey) b3.getPublic();
        ECPrivateKey eCPrivateKey = (ECPrivateKey) b3.getPrivate();
        ECPublicKey eCPublicKey2 = this.a;
        try {
            ECParameterSpec params = eCPublicKey2.getParams();
            ECParameterSpec params2 = eCPrivateKey.getParams();
            if (params.getCurve().equals(params2.getCurve()) && params.getGenerator().equals(params2.getGenerator()) && params.getOrder().equals(params2.getOrder()) && params.getCofactor() == params2.getCofactor()) {
                byte[] i3 = zzdkr.i(eCPrivateKey, eCPublicKey2.getW());
                EllipticCurve curve = eCPublicKey.getParams().getCurve();
                ECPoint w = eCPublicKey.getW();
                zzdkr.h(w, curve);
                int j2 = zzdkr.j(curve);
                int i4 = ot.a[zzdkvVar.ordinal()];
                int i5 = 1;
                if (i4 == 1) {
                    int i6 = (j2 * 2) + 1;
                    bArr3 = new byte[i6];
                    byte[] byteArray = w.getAffineX().toByteArray();
                    byte[] byteArray2 = w.getAffineY().toByteArray();
                    System.arraycopy(byteArray2, 0, bArr3, i6 - byteArray2.length, byteArray2.length);
                    System.arraycopy(byteArray, 0, bArr3, (j2 + 1) - byteArray.length, byteArray.length);
                    bArr3[0] = 4;
                } else if (i4 != 2) {
                    if (i4 == 3) {
                        int i7 = j2 + 1;
                        bArr4 = new byte[i7];
                        byte[] byteArray3 = w.getAffineX().toByteArray();
                        System.arraycopy(byteArray3, 0, bArr4, i7 - byteArray3.length, byteArray3.length);
                        bArr4[0] = (byte) (w.getAffineY().testBit(0) ? 3 : 2);
                        byte[] c2 = zzdjs.c(bArr4, i3);
                        b2 = zzdkx.f15961d.b(str);
                        if (i2 > b2.getMacLength() * 255) {
                            if (bArr != null && bArr.length != 0) {
                                b2.init(new SecretKeySpec(bArr, str));
                            } else {
                                b2.init(new SecretKeySpec(new byte[b2.getMacLength()], str));
                            }
                            byte[] doFinal = b2.doFinal(c2);
                            byte[] bArr5 = new byte[i2];
                            b2.init(new SecretKeySpec(doFinal, str));
                            byte[] bArr6 = new byte[0];
                            int i8 = 0;
                            while (true) {
                                b2.update(bArr6);
                                b2.update(bArr2);
                                b2.update((byte) i5);
                                bArr6 = b2.doFinal();
                                if (bArr6.length + i8 < i2) {
                                    System.arraycopy(bArr6, 0, bArr5, i8, bArr6.length);
                                    i8 += bArr6.length;
                                    i5++;
                                } else {
                                    System.arraycopy(bArr6, 0, bArr5, i8, i2 - i8);
                                    return new zzdkf(bArr4, bArr5);
                                }
                            }
                        } else {
                            throw new GeneralSecurityException("size too large");
                        }
                    } else {
                        String valueOf = String.valueOf(zzdkvVar);
                        StringBuilder sb = new StringBuilder(valueOf.length() + 15);
                        sb.append("invalid format:");
                        sb.append(valueOf);
                        throw new GeneralSecurityException(sb.toString());
                    }
                } else {
                    int i9 = j2 * 2;
                    bArr3 = new byte[i9];
                    byte[] byteArray4 = w.getAffineX().toByteArray();
                    if (byteArray4.length > j2) {
                        byteArray4 = Arrays.copyOfRange(byteArray4, byteArray4.length - j2, byteArray4.length);
                    }
                    byte[] byteArray5 = w.getAffineY().toByteArray();
                    if (byteArray5.length > j2) {
                        byteArray5 = Arrays.copyOfRange(byteArray5, byteArray5.length - j2, byteArray5.length);
                    }
                    System.arraycopy(byteArray5, 0, bArr3, i9 - byteArray5.length, byteArray5.length);
                    System.arraycopy(byteArray4, 0, bArr3, j2 - byteArray4.length, byteArray4.length);
                }
                bArr4 = bArr3;
                byte[] c22 = zzdjs.c(bArr4, i3);
                b2 = zzdkx.f15961d.b(str);
                if (i2 > b2.getMacLength() * 255) {
                }
            } else {
                throw new GeneralSecurityException("invalid public key spec");
            }
        } catch (IllegalArgumentException | NullPointerException e2) {
            throw new GeneralSecurityException(e2.toString());
        }
    }
}
