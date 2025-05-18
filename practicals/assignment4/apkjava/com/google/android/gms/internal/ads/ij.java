package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbp;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Vector;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class ij {
    private static boolean a = false;

    /* renamed from: b */
    private static MessageDigest f12770b;

    /* renamed from: c */
    private static final Object f12771c = new Object();

    /* renamed from: d */
    private static final Object f12772d = new Object();

    /* renamed from: e */
    static CountDownLatch f12773e = new CountDownLatch(1);

    private static zzbp.zza a(zzbp.zza.zzd zzdVar) {
        zzbp.zza.C0176zza k0 = zzbp.zza.k0();
        k0.N(zzdVar.i());
        return (zzbp.zza) ((zzdob) k0.p0());
    }

    private static Vector<byte[]> c(byte[] bArr, int i2) {
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        int length = ((bArr.length + 255) - 1) / 255;
        Vector<byte[]> vector = new Vector<>();
        for (int i3 = 0; i3 < length; i3++) {
            int i4 = i3 * 255;
            try {
                vector.add(Arrays.copyOfRange(bArr, i4, bArr.length - i4 > 255 ? i4 + 255 : bArr.length));
            } catch (IndexOutOfBoundsException unused) {
                return null;
            }
        }
        return vector;
    }

    private static byte[] d(byte[] bArr, String str, boolean z) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        byte[] array;
        int i2 = z ? 239 : 255;
        if (bArr.length > i2) {
            bArr = a(zzbp.zza.zzd.PSN_ENCODE_SIZE_FAIL).g();
        }
        if (bArr.length < i2) {
            byte[] bArr2 = new byte[i2 - bArr.length];
            new SecureRandom().nextBytes(bArr2);
            array = ByteBuffer.allocate(i2 + 1).put((byte) bArr.length).put(bArr).put(bArr2).array();
        } else {
            array = ByteBuffer.allocate(i2 + 1).put((byte) bArr.length).put(bArr).array();
        }
        if (z) {
            array = ByteBuffer.allocate(256).put(e(array)).put(array).array();
        }
        byte[] bArr3 = new byte[256];
        for (pl plVar : new zzcl().N2) {
            plVar.a(array, bArr3);
        }
        if (str != null && str.length() > 0) {
            if (str.length() > 32) {
                str = str.substring(0, 32);
            }
            new zzdmh(str.getBytes("UTF-8")).a(bArr3);
        }
        return bArr3;
    }

    public static byte[] e(byte[] bArr) throws NoSuchAlgorithmException {
        byte[] digest;
        synchronized (f12771c) {
            MessageDigest g2 = g();
            if (g2 != null) {
                g2.reset();
                g2.update(bArr);
                digest = f12770b.digest();
            } else {
                throw new NoSuchAlgorithmException("Cannot compute hash");
            }
        }
        return digest;
    }

    public static void f() {
        synchronized (f12772d) {
            if (!a) {
                a = true;
                new Thread(new ek()).start();
            }
        }
    }

    private static MessageDigest g() {
        boolean z;
        MessageDigest messageDigest;
        f();
        try {
            z = f12773e.await(2L, TimeUnit.SECONDS);
        } catch (InterruptedException unused) {
            z = false;
        }
        if (z && (messageDigest = f12770b) != null) {
            return messageDigest;
        }
        return null;
    }

    public static String h(zzbp.zza zzaVar, String str) throws GeneralSecurityException, UnsupportedEncodingException {
        byte[] d2;
        byte[] g2 = zzaVar.g();
        if (!((Boolean) zzyt.e().c(zzacu.t2)).booleanValue()) {
            if (qy.a != null) {
                d2 = ((zzbp.zzg) ((zzdob) zzbp.zzg.B().v(zzdmr.D(qy.a.a(g2, str != null ? str.getBytes() : new byte[0]))).u(zzbw.TINK_HYBRID).p0())).g();
            } else {
                throw new GeneralSecurityException();
            }
        } else {
            Vector<byte[]> c2 = c(g2, 255);
            if (c2 != null && c2.size() != 0) {
                zzbp.zzg.zza B = zzbp.zzg.B();
                Iterator<byte[]> it = c2.iterator();
                while (it.hasNext()) {
                    B.v(zzdmr.D(d(it.next(), str, false)));
                }
                B.w(zzdmr.D(e(g2)));
                d2 = ((zzbp.zzg) ((zzdob) B.p0())).g();
            } else {
                d2 = d(a(zzbp.zza.zzd.PSN_ENCODE_SIZE_FAIL).g(), str, true);
            }
        }
        return zzcg.a(d2, true);
    }
}
