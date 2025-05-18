package com.google.firebase.crashlytics.internal.n;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import com.google.firebase.crashlytics.internal.g;
import java.util.List;

/* compiled from: AppData.java */
/* loaded from: classes2.dex */
public class l {
    public final String a;

    /* renamed from: b, reason: collision with root package name */
    public final String f19056b;

    /* renamed from: c, reason: collision with root package name */
    public final List<q> f19057c;

    /* renamed from: d, reason: collision with root package name */
    public final String f19058d;

    /* renamed from: e, reason: collision with root package name */
    public final String f19059e;

    /* renamed from: f, reason: collision with root package name */
    public final String f19060f;

    /* renamed from: g, reason: collision with root package name */
    public final String f19061g;

    /* renamed from: h, reason: collision with root package name */
    public final g f19062h;

    public l(String str, String str2, List<q> list, String str3, String str4, String str5, String str6, g gVar) {
        this.a = str;
        this.f19056b = str2;
        this.f19057c = list;
        this.f19058d = str3;
        this.f19059e = str4;
        this.f19060f = str5;
        this.f19061g = str6;
        this.f19062h = gVar;
    }

    public static l a(Context context, i0 i0Var, String str, String str2, List<q> list, g gVar) throws PackageManager.NameNotFoundException {
        String packageName = context.getPackageName();
        String g2 = i0Var.g();
        PackageInfo packageInfo = context.getPackageManager().getPackageInfo(packageName, 0);
        String b2 = b(packageInfo);
        String str3 = packageInfo.versionName;
        if (str3 == null) {
            str3 = "0.0";
        }
        return new l(str, str2, list, g2, packageName, b2, str3, gVar);
    }

    private static String b(PackageInfo packageInfo) {
        if (Build.VERSION.SDK_INT >= 28) {
            return Long.toString(packageInfo.getLongVersionCode());
        }
        return Integer.toString(packageInfo.versionCode);
    }
}
