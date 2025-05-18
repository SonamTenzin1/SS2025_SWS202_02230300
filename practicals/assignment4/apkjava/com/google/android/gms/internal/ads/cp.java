package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import com.google.android.gms.common.util.DeviceProperties;
import com.google.android.gms.common.wrappers.Wrappers;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.Callable;

/* loaded from: classes2.dex */
final class cp implements zzcva<zzcvf> {
    private final zzbbl a;

    /* renamed from: b, reason: collision with root package name */
    private final Context f12434b;

    public cp(zzbbl zzbblVar, Context context) {
        this.a = zzbblVar;
        this.f12434b = context;
    }

    private static ResolveInfo a(PackageManager packageManager, String str) {
        return packageManager.resolveActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)), 65536);
    }

    private static String c(Context context, PackageManager packageManager) {
        ActivityInfo activityInfo;
        ResolveInfo a = a(packageManager, "market://details?id=com.google.android.gms.ads");
        if (a == null || (activityInfo = a.activityInfo) == null) {
            return null;
        }
        try {
            PackageInfo e2 = Wrappers.a(context).e(activityInfo.packageName, 0);
            if (e2 != null) {
                int i2 = e2.versionCode;
                String str = activityInfo.packageName;
                StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 12);
                sb.append(i2);
                sb.append(".");
                sb.append(str);
                return sb.toString();
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return null;
    }

    private static String e(Context context) {
        try {
            PackageInfo e2 = Wrappers.a(context).e("com.android.vending", 128);
            if (e2 != null) {
                int i2 = e2.versionCode;
                String str = e2.packageName;
                StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 12);
                sb.append(i2);
                sb.append(".");
                sb.append(str);
                return sb.toString();
            }
        } catch (Exception unused) {
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzcva
    public final zzbbh<zzcvf> b() {
        return this.a.submit(new Callable(this) { // from class: com.google.android.gms.internal.ads.dp

            /* renamed from: f, reason: collision with root package name */
            private final cp f12483f;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f12483f = this;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f12483f.d();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzcvf d() throws Exception {
        boolean z;
        PackageManager packageManager = this.f12434b.getPackageManager();
        Locale locale = Locale.getDefault();
        boolean z2 = a(packageManager, "geo:0,0?q=donuts") != null;
        boolean z3 = a(packageManager, "http://www.google.com") != null;
        String country = locale.getCountry();
        boolean startsWith = Build.DEVICE.startsWith("generic");
        boolean a = DeviceProperties.a(this.f12434b);
        boolean b2 = DeviceProperties.b(this.f12434b);
        String language = locale.getLanguage();
        String c2 = c(this.f12434b, packageManager);
        String e2 = e(this.f12434b);
        String str = Build.FINGERPRINT;
        Context context = this.f12434b;
        if (packageManager != null) {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("http://www.example.com"));
            ResolveInfo resolveActivity = packageManager.resolveActivity(intent, 0);
            List<ResolveInfo> queryIntentActivities = packageManager.queryIntentActivities(intent, 65536);
            if (queryIntentActivities != null && resolveActivity != null) {
                for (int i2 = 0; i2 < queryIntentActivities.size(); i2++) {
                    if (resolveActivity.activityInfo.name.equals(queryIntentActivities.get(i2).activityInfo.name)) {
                        z = resolveActivity.activityInfo.packageName.equals(zzdtv.a(context));
                        break;
                    }
                }
            }
        }
        z = false;
        return new zzcvf(z2, z3, country, startsWith, a, b2, language, c2, e2, str, z, Build.MODEL);
    }
}
