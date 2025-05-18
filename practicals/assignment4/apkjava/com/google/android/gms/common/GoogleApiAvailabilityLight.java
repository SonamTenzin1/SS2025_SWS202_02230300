package com.google.android.gms.common;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.HideFirstParty;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.util.DeviceProperties;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.common.zzd;

/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
@ShowFirstParty
@KeepForSdk
/* loaded from: classes2.dex */
public class GoogleApiAvailabilityLight {

    @KeepForSdk
    public static final int a = GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE;

    /* renamed from: b, reason: collision with root package name */
    private static final GoogleApiAvailabilityLight f11636b = new GoogleApiAvailabilityLight();

    /* JADX INFO: Access modifiers changed from: package-private */
    @KeepForSdk
    public GoogleApiAvailabilityLight() {
    }

    @KeepForSdk
    public static GoogleApiAvailabilityLight h() {
        return f11636b;
    }

    @KeepForSdk
    public void a(Context context) {
        GooglePlayServicesUtilLight.cancelAvailabilityErrorNotifications(context);
    }

    @ShowFirstParty
    @KeepForSdk
    public int b(Context context) {
        return GooglePlayServicesUtilLight.getApkVersion(context);
    }

    @ShowFirstParty
    @KeepForSdk
    @Deprecated
    public Intent c(int i2) {
        return d(null, i2, null);
    }

    @ShowFirstParty
    @KeepForSdk
    public Intent d(Context context, int i2, String str) {
        if (i2 != 1 && i2 != 2) {
            if (i2 != 3) {
                return null;
            }
            return com.google.android.gms.common.internal.zzt.c("com.google.android.gms");
        }
        if (context != null && DeviceProperties.e(context)) {
            return com.google.android.gms.common.internal.zzt.a();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("gcore_");
        sb.append(a);
        sb.append("-");
        if (!TextUtils.isEmpty(str)) {
            sb.append(str);
        }
        sb.append("-");
        if (context != null) {
            sb.append(context.getPackageName());
        }
        sb.append("-");
        if (context != null) {
            try {
                sb.append(Wrappers.a(context).e(context.getPackageName(), 0).versionCode);
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
        return com.google.android.gms.common.internal.zzt.b("com.google.android.gms", sb.toString());
    }

    @KeepForSdk
    public PendingIntent e(Context context, int i2, int i3) {
        return f(context, i2, i3, null);
    }

    @ShowFirstParty
    @KeepForSdk
    public PendingIntent f(Context context, int i2, int i3, String str) {
        Intent d2 = d(context, i2, str);
        if (d2 == null) {
            return null;
        }
        return PendingIntent.getActivity(context, i3, d2, zzd.a | 134217728);
    }

    @KeepForSdk
    public String g(int i2) {
        return GooglePlayServicesUtilLight.getErrorString(i2);
    }

    @HideFirstParty
    @KeepForSdk
    public int i(Context context) {
        return j(context, a);
    }

    @KeepForSdk
    public int j(Context context, int i2) {
        int isGooglePlayServicesAvailable = GooglePlayServicesUtilLight.isGooglePlayServicesAvailable(context, i2);
        if (GooglePlayServicesUtilLight.isPlayServicesPossiblyUpdating(context, isGooglePlayServicesAvailable)) {
            return 18;
        }
        return isGooglePlayServicesAvailable;
    }

    @ShowFirstParty
    @KeepForSdk
    public boolean k(Context context, int i2) {
        return GooglePlayServicesUtilLight.isPlayServicesPossiblyUpdating(context, i2);
    }

    @KeepForSdk
    public boolean l(Context context, String str) {
        return GooglePlayServicesUtilLight.zza(context, str);
    }

    @KeepForSdk
    public boolean m(int i2) {
        return GooglePlayServicesUtilLight.isUserRecoverableError(i2);
    }
}
