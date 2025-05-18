package com.google.zxing.j.b;

/* compiled from: BarcodeRow.java */
/* loaded from: classes2.dex */
final class b {
    private final byte[] a;

    /* renamed from: b, reason: collision with root package name */
    private int f20402b = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(int i2) {
        this.a = new byte[i2];
    }

    private void c(int i2, boolean z) {
        this.a[i2] = z ? (byte) 1 : (byte) 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(boolean z, int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            int i4 = this.f20402b;
            this.f20402b = i4 + 1;
            c(i4, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public byte[] b(int i2) {
        int length = this.a.length * i2;
        byte[] bArr = new byte[length];
        for (int i3 = 0; i3 < length; i3++) {
            bArr[i3] = this.a[i3 / i2];
        }
        return bArr;
    }
}
