package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
public final class zzly extends Exception {
    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public zzly(int i2, int i3, int i4) {
        super(r0.toString());
        StringBuilder sb = new StringBuilder(78);
        sb.append("Unhandled format: ");
        sb.append(i2);
        sb.append(" Hz, ");
        sb.append(i3);
        sb.append(" channels in encoding ");
        sb.append(i4);
    }
}
