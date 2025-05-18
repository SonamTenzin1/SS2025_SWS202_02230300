package com.google.android.gms.internal.ads;

import android.text.TextUtils;

/* loaded from: classes2.dex */
final class w extends zzadc {
    private static String b(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        int i2 = 0;
        int length = str.length();
        while (i2 < str.length() && str.charAt(i2) == ',') {
            i2++;
        }
        while (length > 0 && str.charAt(length - 1) == ',') {
            length--;
        }
        if (length < i2) {
            return null;
        }
        return (i2 == 0 && length == str.length()) ? str : str.substring(i2, length);
    }

    @Override // com.google.android.gms.internal.ads.zzadc
    public final String a(String str, String str2) {
        String b2 = b(str);
        String b3 = b(str2);
        if (TextUtils.isEmpty(b2)) {
            return b3;
        }
        if (TextUtils.isEmpty(b3)) {
            return b2;
        }
        StringBuilder sb = new StringBuilder(String.valueOf(b2).length() + 1 + String.valueOf(b3).length());
        sb.append(b2);
        sb.append(",");
        sb.append(b3);
        return sb.toString();
    }
}
