package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.2.0 */
/* loaded from: classes2.dex */
public final class zzid {
    public static String a(String str, String[] strArr, String[] strArr2) {
        boolean equals;
        Preconditions.k(strArr);
        Preconditions.k(strArr2);
        int min = Math.min(strArr.length, strArr2.length);
        for (int i2 = 0; i2 < min; i2++) {
            String str2 = strArr[i2];
            if (str == null && str2 == null) {
                equals = true;
            } else {
                equals = str == null ? false : str.equals(str2);
            }
            if (equals) {
                return strArr2[i2];
            }
        }
        return null;
    }
}
