package com.google.zxing.k.b;

/* compiled from: ErrorCorrectionLevel.java */
/* loaded from: classes2.dex */
public enum a {
    L(1),
    M(0),
    Q(3),
    H(2);


    /* renamed from: j, reason: collision with root package name */
    private static final a[] f20427j;
    private final int l;

    static {
        a aVar = L;
        a aVar2 = M;
        a aVar3 = Q;
        f20427j = new a[]{aVar2, aVar, H, aVar3};
    }

    a(int i2) {
        this.l = i2;
    }

    public int g() {
        return this.l;
    }
}
