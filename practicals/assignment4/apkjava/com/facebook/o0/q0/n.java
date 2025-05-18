package com.facebook.o0.q0;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import cm.aptoide.pt.BuildConfig;
import cm.aptoide.pt.notification.PullingContentService;
import cm.aptoide.pt.notification.sync.LocalNotificationSyncManager;
import com.facebook.internal.j0;
import com.facebook.o0.a0;
import com.facebook.o0.g0;
import java.util.Arrays;
import java.util.Locale;
import kotlin.jvm.internal.StringCompanionObject;

/* compiled from: SessionLogger.kt */
/* loaded from: classes2.dex */
public final class n {
    public static final n a = new n();

    /* renamed from: b, reason: collision with root package name */
    private static final String f10436b = n.class.getCanonicalName();

    /* renamed from: c, reason: collision with root package name */
    private static final long[] f10437c = {LocalNotificationSyncManager.FIVE_MINUTES, 900000, BuildConfig.ANALYTICS_SESSION_INTERVAL_IN_MILLIS, 3600000, 21600000, 43200000, PullingContentService.UPDATES_INTERVAL, 172800000, 259200000, 604800000, 1209600000, 1814400000, 2419200000L, 5184000000L, 7776000000L, 10368000000L, 12960000000L, 15552000000L, 31536000000L};

    private n() {
    }

    private final String a(Context context) {
        try {
            PackageManager packageManager = context.getPackageManager();
            String n = kotlin.jvm.internal.m.n("PCKGCHKSUM;", packageManager.getPackageInfo(context.getPackageName(), 0).versionName);
            SharedPreferences sharedPreferences = context.getSharedPreferences("com.facebook.sdk.appEventPreferences", 0);
            String string = sharedPreferences.getString(n, null);
            if (string != null && string.length() == 32) {
                return string;
            }
            l lVar = l.a;
            String c2 = l.c(context, null);
            if (c2 == null) {
                ApplicationInfo applicationInfo = packageManager.getApplicationInfo(context.getPackageName(), 0);
                kotlin.jvm.internal.m.e(applicationInfo, "pm.getApplicationInfo(context.packageName, 0)");
                c2 = l.b(applicationInfo.sourceDir);
            }
            sharedPreferences.edit().putString(n, c2).apply();
            return c2;
        } catch (Exception unused) {
            return null;
        }
    }

    public static final int b(long j2) {
        int i2 = 0;
        while (true) {
            long[] jArr = f10437c;
            if (i2 >= jArr.length || jArr[i2] >= j2) {
                break;
            }
            i2++;
        }
        return i2;
    }

    public static final void c(String str, o oVar, String str2, Context context) {
        String oVar2;
        kotlin.jvm.internal.m.f(str, "activityName");
        kotlin.jvm.internal.m.f(context, "context");
        String str3 = "Unclassified";
        if (oVar != null && (oVar2 = oVar.toString()) != null) {
            str3 = oVar2;
        }
        Bundle bundle = new Bundle();
        bundle.putString("fb_mobile_launch_source", str3);
        bundle.putString("fb_mobile_pckg_fp", a.a(context));
        com.facebook.internal.v0.b bVar = com.facebook.internal.v0.b.a;
        bundle.putString("fb_mobile_app_cert_hash", com.facebook.internal.v0.b.a(context));
        g0.a aVar = g0.a;
        g0 a2 = aVar.a(str, str2, null);
        a2.d("fb_mobile_activate_app", bundle);
        if (aVar.c() != a0.b.EXPLICIT_ONLY) {
            a2.a();
        }
    }

    private final void d() {
        j0.a aVar = j0.a;
        com.facebook.g0 g0Var = com.facebook.g0.APP_EVENTS;
        String str = f10436b;
        kotlin.jvm.internal.m.c(str);
        aVar.b(g0Var, str, "Clock skew detected");
    }

    public static final void e(String str, m mVar, String str2) {
        long longValue;
        String oVar;
        kotlin.jvm.internal.m.f(str, "activityName");
        if (mVar == null) {
            return;
        }
        Long b2 = mVar.b();
        if (b2 == null) {
            Long e2 = mVar.e();
            longValue = 0 - (e2 == null ? 0L : e2.longValue());
        } else {
            longValue = b2.longValue();
        }
        if (longValue < 0) {
            a.d();
            longValue = 0;
        }
        long f2 = mVar.f();
        if (f2 < 0) {
            a.d();
            f2 = 0;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("fb_mobile_app_interruptions", mVar.c());
        StringCompanionObject stringCompanionObject = StringCompanionObject.a;
        String format = String.format(Locale.ROOT, "session_quanta_%d", Arrays.copyOf(new Object[]{Integer.valueOf(b(longValue))}, 1));
        kotlin.jvm.internal.m.e(format, "java.lang.String.format(locale, format, *args)");
        bundle.putString("fb_mobile_time_between_sessions", format);
        o g2 = mVar.g();
        String str3 = "Unclassified";
        if (g2 != null && (oVar = g2.toString()) != null) {
            str3 = oVar;
        }
        bundle.putString("fb_mobile_launch_source", str3);
        Long e3 = mVar.e();
        bundle.putLong("_logTime", (e3 != null ? e3.longValue() : 0L) / 1000);
        g0 a2 = g0.a.a(str, str2, null);
        double d2 = f2;
        double d3 = 1000L;
        Double.isNaN(d2);
        Double.isNaN(d3);
        a2.c("fb_mobile_deactivate_app", d2 / d3, bundle);
    }
}
