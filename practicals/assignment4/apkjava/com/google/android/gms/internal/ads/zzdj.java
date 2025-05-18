package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes2.dex */
public final class zzdj {
    private static Cipher a;

    /* renamed from: b, reason: collision with root package name */
    private static final Object f15926b = new Object();

    /* renamed from: c, reason: collision with root package name */
    private static final Object f15927c = new Object();

    /* renamed from: d, reason: collision with root package name */
    private final SecureRandom f15928d = null;

    public zzdj(SecureRandom secureRandom) {
    }

    private static Cipher a() throws NoSuchAlgorithmException, NoSuchPaddingException {
        Cipher cipher;
        synchronized (f15927c) {
            if (a == null) {
                a = Cipher.getInstance("AES/CBC/PKCS5Padding");
            }
            cipher = a;
        }
        return cipher;
    }

    public final byte[] b(byte[] bArr, String str) throws zzdk {
        byte[] doFinal;
        if (bArr.length == 16) {
            try {
                byte[] b2 = zzcg.b(str, false);
                if (b2.length > 16) {
                    ByteBuffer allocate = ByteBuffer.allocate(b2.length);
                    allocate.put(b2);
                    allocate.flip();
                    byte[] bArr2 = new byte[16];
                    byte[] bArr3 = new byte[b2.length - 16];
                    allocate.get(bArr2);
                    allocate.get(bArr3);
                    SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
                    synchronized (f15926b) {
                        a().init(2, secretKeySpec, new IvParameterSpec(bArr2));
                        doFinal = a().doFinal(bArr3);
                    }
                    return doFinal;
                }
                throw new zzdk(this);
            } catch (IllegalArgumentException e2) {
                throw new zzdk(this, e2);
            } catch (InvalidAlgorithmParameterException e3) {
                throw new zzdk(this, e3);
            } catch (InvalidKeyException e4) {
                throw new zzdk(this, e4);
            } catch (NoSuchAlgorithmException e5) {
                throw new zzdk(this, e5);
            } catch (BadPaddingException e6) {
                throw new zzdk(this, e6);
            } catch (IllegalBlockSizeException e7) {
                throw new zzdk(this, e7);
            } catch (NoSuchPaddingException e8) {
                throw new zzdk(this, e8);
            }
        }
        throw new zzdk(this);
    }

    public final byte[] c(String str) throws zzdk {
        try {
            byte[] b2 = zzcg.b(str, false);
            if (b2.length == 32) {
                byte[] bArr = new byte[16];
                ByteBuffer.wrap(b2, 4, 16).get(bArr);
                for (int i2 = 0; i2 < 16; i2++) {
                    bArr[i2] = (byte) (bArr[i2] ^ 68);
                }
                return bArr;
            }
            throw new zzdk(this);
        } catch (IllegalArgumentException e2) {
            throw new zzdk(this, e2);
        }
    }

    public final String d(byte[] bArr, byte[] bArr2) throws zzdk {
        byte[] doFinal;
        byte[] iv;
        if (bArr.length == 16) {
            try {
                SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
                synchronized (f15926b) {
                    a().init(1, secretKeySpec, (SecureRandom) null);
                    doFinal = a().doFinal(bArr2);
                    iv = a().getIV();
                }
                int length = doFinal.length + iv.length;
                ByteBuffer allocate = ByteBuffer.allocate(length);
                allocate.put(iv).put(doFinal);
                allocate.flip();
                byte[] bArr3 = new byte[length];
                allocate.get(bArr3);
                return zzcg.a(bArr3, false);
            } catch (InvalidKeyException e2) {
                throw new zzdk(this, e2);
            } catch (NoSuchAlgorithmException e3) {
                throw new zzdk(this, e3);
            } catch (BadPaddingException e4) {
                throw new zzdk(this, e4);
            } catch (IllegalBlockSizeException e5) {
                throw new zzdk(this, e5);
            } catch (NoSuchPaddingException e6) {
                throw new zzdk(this, e6);
            }
        }
        throw new zzdk(this);
    }
}
