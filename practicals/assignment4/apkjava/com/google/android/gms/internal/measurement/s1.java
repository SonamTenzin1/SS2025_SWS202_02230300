package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.2.0 */
/* loaded from: classes2.dex */
final class s1 extends u1 {

    /* renamed from: k, reason: collision with root package name */
    private final int f17253k;
    private final int l;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s1(byte[] bArr, int i2, int i3) {
        super(bArr);
        zzdu.v(i2, i2 + i3, bArr.length);
        this.f17253k = i2;
        this.l = i3;
    }

    @Override // com.google.android.gms.internal.measurement.u1
    protected final int C() {
        return this.f17253k;
    }

    @Override // com.google.android.gms.internal.measurement.u1, com.google.android.gms.internal.measurement.zzdu
    public final byte c(int i2) {
        int f2 = f();
        if (((f2 - (i2 + 1)) | i2) >= 0) {
            return this.f17261j[this.f17253k + i2];
        }
        if (i2 < 0) {
            StringBuilder sb = new StringBuilder(22);
            sb.append("Index < 0: ");
            sb.append(i2);
            throw new ArrayIndexOutOfBoundsException(sb.toString());
        }
        StringBuilder sb2 = new StringBuilder(40);
        sb2.append("Index > length: ");
        sb2.append(i2);
        sb2.append(", ");
        sb2.append(f2);
        throw new ArrayIndexOutOfBoundsException(sb2.toString());
    }

    @Override // com.google.android.gms.internal.measurement.u1, com.google.android.gms.internal.measurement.zzdu
    public final int f() {
        return this.l;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.u1, com.google.android.gms.internal.measurement.zzdu
    public final byte t(int i2) {
        return this.f17261j[this.f17253k + i2];
    }
}
