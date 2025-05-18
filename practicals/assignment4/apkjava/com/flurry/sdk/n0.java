package com.flurry.sdk;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import java.util.Locale;
import okhttp3.HttpUrl;

/* loaded from: classes2.dex */
public final class n0 {
    private static n0 a;

    /* renamed from: b, reason: collision with root package name */
    public String f10926b;

    /* renamed from: c, reason: collision with root package name */
    private String f10927c;

    /* renamed from: d, reason: collision with root package name */
    public String f10928d = String.format(Locale.getDefault(), "Flurry_Android_%d_%d.%d.%d%s%s", 328, 13, 0, 1, HttpUrl.FRAGMENT_ENCODE_SET, HttpUrl.FRAGMENT_ENCODE_SET);

    private n0() {
    }

    public static synchronized n0 a() {
        n0 n0Var;
        synchronized (n0.class) {
            if (a == null) {
                a = new n0();
            }
            n0Var = a;
        }
        return n0Var;
    }

    private static String c() {
        try {
            Context a2 = b0.a();
            PackageInfo packageInfo = a2.getPackageManager().getPackageInfo(a2.getPackageName(), 0);
            String str = packageInfo.versionName;
            if (str != null) {
                return str;
            }
            int i2 = packageInfo.versionCode;
            return i2 != 0 ? Integer.toString(i2) : "Unknown";
        } catch (Throwable th) {
            d1.d(6, "VersionProvider", HttpUrl.FRAGMENT_ENCODE_SET, th);
            return "Unknown";
        }
    }

    public final synchronized String b() {
        if (!TextUtils.isEmpty(this.f10926b)) {
            return this.f10926b;
        }
        if (!TextUtils.isEmpty(this.f10927c)) {
            return this.f10927c;
        }
        String c2 = c();
        this.f10927c = c2;
        return c2;
    }
}
