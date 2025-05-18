package com.flurry.sdk;

import android.os.Build;
import android.text.TextUtils;
import com.flurry.sdk.b7;
import com.flurry.sdk.i;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes2.dex */
public final class j {
    private k a = null;

    /* renamed from: b, reason: collision with root package name */
    byte[] f10836b = null;

    /* renamed from: d, reason: collision with root package name */
    private c7<i> f10838d = null;

    /* renamed from: c, reason: collision with root package name */
    private final b7<byte[]> f10837c = new b7<>(new r1());

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public final class a implements y1<i> {
        a() {
        }

        @Override // com.flurry.sdk.y1
        public final v1<i> a(int i2) {
            return new i.a();
        }
    }

    private static File e() {
        return new File(b2.d().getPath() + File.separator + "installationNum");
    }

    private static SecretKey f() {
        k0 a2 = k0.a();
        d1.c(3, "APIKeyProvider", "Getting legacy apikey: " + a2.f10860c);
        String str = a2.f10860c;
        if (str == null) {
            return null;
        }
        String a3 = a2.a(b0.a());
        try {
            return new SecretKeySpec(SecretKeyFactory.getInstance("PBEWithSHA256And256BitAES-CBC-BC").generateSecret(new PBEKeySpec(str.toCharArray(), ByteBuffer.allocate(8).putLong(TextUtils.isEmpty(a3) ? Long.MIN_VALUE : c2.j(a3)).array(), 1000, 256)).getEncoded(), "AES");
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e2) {
            d1.d(4, "InstallationIdProvider", "Error in generate secret key", e2);
            return null;
        }
    }

    public final void a() {
        if (this.f10838d == null) {
            this.f10838d = new c7<>(e(), "installationNum", 1, new a());
            byte[] c2 = c(d());
            if (c2 == null || Build.VERSION.SDK_INT < 23) {
                return;
            }
            b2.e(e());
            b(c2, b7.a.CRYPTO_ALGO_PADDING_7);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean b(byte[] bArr, b7.a aVar) {
        i iVar;
        try {
            b2.e(e());
            byte[] bArr2 = new byte[16];
            new SecureRandom().nextBytes(bArr2);
            byte[] b2 = this.f10837c.b(bArr, d(), new IvParameterSpec(bArr2), aVar);
            if (b2 != null) {
                iVar = new i(b2, bArr2, true, aVar.ordinal());
            } else {
                iVar = new i(bArr, new byte[0], false, aVar.ordinal());
            }
            this.f10838d.b(iVar);
            return true;
        } catch (IOException e2) {
            d1.d(5, "InstallationIdProvider", "Error while generating UUID" + e2.getMessage(), e2);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final byte[] c(Key key) {
        byte[] bArr = null;
        try {
            i a2 = this.f10838d.a();
            if (a2 != null) {
                if (a2.a) {
                    byte[] bArr2 = a2.f10816b;
                    byte[] bArr3 = a2.f10817c;
                    b7.a g2 = b7.a.g(a2.f10818d);
                    if (bArr2 != null && bArr3 != null) {
                        bArr = this.f10837c.a(bArr3, key, new IvParameterSpec(bArr2), g2);
                    }
                } else {
                    bArr = a2.f10817c;
                }
            }
        } catch (IOException unused) {
            d1.c(5, "InstallationIdProvider", "Error while reading Android Install Id. Deleting file.");
        }
        return bArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Key d() {
        if (Build.VERSION.SDK_INT < 23) {
            return f();
        }
        if (this.a == null) {
            this.a = new k();
        }
        return this.a.a();
    }
}
