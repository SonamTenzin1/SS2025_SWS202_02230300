package com.airbnb.epoxy;

/* compiled from: IdUtils.java */
/* loaded from: classes.dex */
public final class y {
    public static long a(long j2) {
        long j3 = j2 ^ (j2 << 21);
        long j4 = j3 ^ (j3 >>> 35);
        return j4 ^ (j4 << 4);
    }

    public static long b(CharSequence charSequence) {
        if (charSequence == null) {
            return 0L;
        }
        long j2 = -3750763034362895579L;
        for (int i2 = 0; i2 < charSequence.length(); i2++) {
            j2 = (j2 ^ charSequence.charAt(i2)) * 1099511628211L;
        }
        return j2;
    }
}
