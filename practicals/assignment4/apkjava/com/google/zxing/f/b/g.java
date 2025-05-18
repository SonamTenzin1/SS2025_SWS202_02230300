package com.google.zxing.f.b;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Token.java */
/* loaded from: classes2.dex */
public abstract class g {
    static final g a = new e(null, 0, 0);

    /* renamed from: b, reason: collision with root package name */
    private final g f20338b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(g gVar) {
        this.f20338b = gVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final g a(int i2, int i3) {
        return new e(this, i2, i3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final g b(int i2, int i3) {
        return new b(this, i2, i3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void c(com.google.zxing.g.a aVar, byte[] bArr);

    /* JADX INFO: Access modifiers changed from: package-private */
    public final g d() {
        return this.f20338b;
    }
}
