package com.google.zxing.f.b;

/* compiled from: SimpleToken.java */
/* loaded from: classes2.dex */
final class e extends g {

    /* renamed from: c, reason: collision with root package name */
    private final short f20332c;

    /* renamed from: d, reason: collision with root package name */
    private final short f20333d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(g gVar, int i2, int i3) {
        super(gVar);
        this.f20332c = (short) i2;
        this.f20333d = (short) i3;
    }

    @Override // com.google.zxing.f.b.g
    void c(com.google.zxing.g.a aVar, byte[] bArr) {
        aVar.e(this.f20332c, this.f20333d);
    }

    public String toString() {
        short s = this.f20332c;
        short s2 = this.f20333d;
        return "<" + Integer.toBinaryString((s & ((1 << s2) - 1)) | (1 << s2) | (1 << this.f20333d)).substring(1) + '>';
    }
}
