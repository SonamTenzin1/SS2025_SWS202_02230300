package com.google.android.gms.internal.ads;

import java.io.IOException;

/* loaded from: classes2.dex */
public class zzdrw {
    protected volatile int a = -1;

    public static final byte[] b(zzdrw zzdrwVar) {
        int c2 = zzdrwVar.c();
        byte[] bArr = new byte[c2];
        try {
            zzdrp v = zzdrp.v(bArr, 0, c2);
            zzdrwVar.a(v);
            v.f();
            return bArr;
        } catch (IOException e2) {
            throw new RuntimeException("Serializing to a byte array threw an IOException (should never happen).", e2);
        }
    }

    public void a(zzdrp zzdrpVar) throws IOException {
    }

    public final int c() {
        int e2 = e();
        this.a = e2;
        return e2;
    }

    @Override // 
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public zzdrw clone() throws CloneNotSupportedException {
        return (zzdrw) super.clone();
    }

    protected int e() {
        return 0;
    }

    public String toString() {
        return zzdrx.b(this);
    }
}
