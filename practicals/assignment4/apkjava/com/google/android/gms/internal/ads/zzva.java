package com.google.android.gms.internal.ads;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@zzard
/* loaded from: classes2.dex */
public abstract class zzva {
    private static MessageDigest a;

    /* renamed from: b, reason: collision with root package name */
    protected Object f16841b = new Object();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract byte[] a(String str);

    /* JADX INFO: Access modifiers changed from: protected */
    public final MessageDigest b() {
        synchronized (this.f16841b) {
            MessageDigest messageDigest = a;
            if (messageDigest != null) {
                return messageDigest;
            }
            for (int i2 = 0; i2 < 2; i2++) {
                try {
                    a = MessageDigest.getInstance("MD5");
                } catch (NoSuchAlgorithmException unused) {
                }
            }
            return a;
        }
    }
}
