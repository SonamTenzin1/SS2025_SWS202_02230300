package com.flurry.sdk;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import okhttp3.HttpUrl;

/* loaded from: classes2.dex */
public final class a2 {
    public static String a(Context context) {
        String str;
        PackageInfo b2 = b(context);
        return (b2 == null || (str = b2.packageName) == null) ? HttpUrl.FRAGMENT_ENCODE_SET : str;
    }

    private static PackageInfo b(Context context) {
        if (context != null) {
            try {
                return context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            } catch (PackageManager.NameNotFoundException unused) {
                d1.e("ContextUtil", "Cannot find package info for package: " + context.getPackageName());
            }
        }
        return null;
    }
}
