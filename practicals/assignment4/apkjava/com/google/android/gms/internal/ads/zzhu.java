package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
public final class zzhu extends Exception {

    /* renamed from: f, reason: collision with root package name */
    private final int f16295f;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public zzhu(int i2, int i3, int i4, int i5) {
        super(r0.toString());
        StringBuilder sb = new StringBuilder(82);
        sb.append("AudioTrack init failed: ");
        sb.append(i2);
        sb.append(", Config(");
        sb.append(i3);
        sb.append(", ");
        sb.append(i4);
        sb.append(", ");
        sb.append(i5);
        sb.append(")");
        this.f16295f = i2;
    }
}
