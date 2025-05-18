package com.google.android.gms.internal.ads;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import cm.aptoide.pt.dataprovider.BuildConfig;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@VisibleForTesting
/* loaded from: classes2.dex */
public final class zzaht {
    private final Context a;

    /* renamed from: b, reason: collision with root package name */
    private final zzdh f13902b;

    /* renamed from: c, reason: collision with root package name */
    private final View f13903c;

    public zzaht(Context context, zzdh zzdhVar, View view) {
        this.a = context;
        this.f13902b = zzdhVar;
        this.f13903c = view;
    }

    private static Intent a(Intent intent, ResolveInfo resolveInfo) {
        Intent intent2 = new Intent(intent);
        ActivityInfo activityInfo = resolveInfo.activityInfo;
        intent2.setClassName(activityInfo.packageName, activityInfo.name);
        return intent2;
    }

    @VisibleForTesting
    private final ResolveInfo b(Intent intent, ArrayList<ResolveInfo> arrayList) {
        PackageManager packageManager;
        ResolveInfo resolveInfo = null;
        try {
            packageManager = this.a.getPackageManager();
        } catch (Throwable th) {
            zzk.zzlk().e(th, "OpenSystemBrowserHandler.getDefaultBrowserResolverForIntent");
        }
        if (packageManager == null) {
            return null;
        }
        List<ResolveInfo> queryIntentActivities = packageManager.queryIntentActivities(intent, 65536);
        ResolveInfo resolveActivity = packageManager.resolveActivity(intent, 65536);
        if (queryIntentActivities != null && resolveActivity != null) {
            int i2 = 0;
            while (true) {
                if (i2 >= queryIntentActivities.size()) {
                    break;
                }
                if (resolveActivity.activityInfo.name.equals(queryIntentActivities.get(i2).activityInfo.name)) {
                    resolveInfo = resolveActivity;
                    break;
                }
                i2++;
            }
        }
        arrayList.addAll(queryIntentActivities);
        return resolveInfo;
    }

    @VisibleForTesting
    private final ResolveInfo c(Intent intent) {
        return b(intent, new ArrayList<>());
    }

    private static Intent e(Uri uri) {
        if (uri == null) {
            return null;
        }
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addFlags(268435456);
        intent.setData(uri);
        intent.setAction("android.intent.action.VIEW");
        return intent;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0080  */
    @VisibleForTesting
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Intent d(Map<String, String> map) {
        boolean z;
        ResolveInfo b2;
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        ResolveInfo c2;
        ActivityManager activityManager = (ActivityManager) this.a.getSystemService("activity");
        String str = map.get("u");
        Uri uri = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Uri parse = Uri.parse(zzahs.b(this.a, this.f13902b, str, this.f13903c, null));
        boolean parseBoolean = Boolean.parseBoolean(map.get("use_first_package"));
        boolean parseBoolean2 = Boolean.parseBoolean(map.get("use_running_process"));
        if (!Boolean.parseBoolean(map.get("use_custom_tabs"))) {
            if (!((Boolean) zzyt.e().c(zzacu.F3)).booleanValue()) {
                z = false;
                if (!"http".equalsIgnoreCase(parse.getScheme())) {
                    uri = parse.buildUpon().scheme(BuildConfig.APTOIDE_WEB_SERVICES_SCHEME).build();
                } else if (BuildConfig.APTOIDE_WEB_SERVICES_SCHEME.equalsIgnoreCase(parse.getScheme())) {
                    uri = parse.buildUpon().scheme("http").build();
                }
                ArrayList<ResolveInfo> arrayList = new ArrayList<>();
                Intent e2 = e(parse);
                Intent e3 = e(uri);
                if (z) {
                    zzk.zzlg();
                    zzaxi.I(this.a, e2);
                    zzk.zzlg();
                    zzaxi.I(this.a, e3);
                }
                b2 = b(e2, arrayList);
                if (b2 == null) {
                    return a(e2, b2);
                }
                if (e3 != null && (c2 = c(e3)) != null) {
                    Intent a = a(e2, c2);
                    if (c(a) != null) {
                        return a;
                    }
                }
                if (arrayList.size() == 0) {
                    return e2;
                }
                if (parseBoolean2 && activityManager != null && (runningAppProcesses = activityManager.getRunningAppProcesses()) != null) {
                    int size = arrayList.size();
                    int i2 = 0;
                    while (i2 < size) {
                        ResolveInfo resolveInfo = arrayList.get(i2);
                        i2++;
                        ResolveInfo resolveInfo2 = resolveInfo;
                        Iterator<ActivityManager.RunningAppProcessInfo> it = runningAppProcesses.iterator();
                        while (it.hasNext()) {
                            if (it.next().processName.equals(resolveInfo2.activityInfo.packageName)) {
                                return a(e2, resolveInfo2);
                            }
                        }
                    }
                }
                return parseBoolean ? a(e2, arrayList.get(0)) : e2;
            }
        }
        z = true;
        if (!"http".equalsIgnoreCase(parse.getScheme())) {
        }
        ArrayList<ResolveInfo> arrayList2 = new ArrayList<>();
        Intent e22 = e(parse);
        Intent e32 = e(uri);
        if (z) {
        }
        b2 = b(e22, arrayList2);
        if (b2 == null) {
        }
    }
}
