package com.google.android.gms.internal.measurement;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-base@@17.2.0 */
/* loaded from: classes2.dex */
public final class t1 {
    private final zzen a;

    /* renamed from: b, reason: collision with root package name */
    private final byte[] f17258b;

    private t1(int i2) {
        byte[] bArr = new byte[i2];
        this.f17258b = bArr;
        this.a = zzen.f(bArr);
    }

    public final zzdu a() {
        this.a.N();
        return new u1(this.f17258b);
    }

    public final zzen b() {
        return this.a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ t1(int i2, o1 o1Var) {
        this(i2);
    }
}
