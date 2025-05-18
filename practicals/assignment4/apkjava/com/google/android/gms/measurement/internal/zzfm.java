package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.wrappers.PackageManagerWrapper;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.measurement.zzd;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.0 */
/* loaded from: classes2.dex */
public final class zzfm {
    final zzfx a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzfm(zzfx zzfxVar) {
        this.a = zzfxVar;
    }

    @VisibleForTesting
    private final boolean c() {
        try {
            PackageManagerWrapper a = Wrappers.a(this.a.f());
            if (a != null) {
                return a.e("com.android.vending", 128).versionCode >= 80837300;
            }
            this.a.h().N().a("Failed to retrieve Package Manager to check Play Store compatibility");
            return false;
        } catch (Exception e2) {
            this.a.h().N().b("Failed to retrieve Play Store version", e2);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    public final Bundle a(String str, zzd zzdVar) {
        this.a.g().d();
        if (zzdVar == null) {
            this.a.h().K().a("Attempting to use Install Referrer Service while it is not initialized");
            return null;
        }
        Bundle bundle = new Bundle();
        bundle.putString("package_name", str);
        try {
            Bundle J = zzdVar.J(bundle);
            if (J != null) {
                return J;
            }
            this.a.h().H().a("Install Referrer Service returned a null response");
            return null;
        } catch (Exception e2) {
            this.a.h().H().b("Exception occurred while retrieving the Install Referrer", e2.getMessage());
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void b(String str) {
        if (str != null && !str.isEmpty()) {
            this.a.g().d();
            if (!c()) {
                this.a.h().N().a("Install Referrer Reporter is not available");
                return;
            }
            this.a.h().N().a("Install Referrer Reporter is initializing");
            zzfl zzflVar = new zzfl(this, str);
            this.a.g().d();
            Intent intent = new Intent("com.google.android.finsky.BIND_GET_INSTALL_REFERRER_SERVICE");
            intent.setComponent(new ComponentName("com.android.vending", "com.google.android.finsky.externalreferrer.GetInstallReferrerService"));
            PackageManager packageManager = this.a.f().getPackageManager();
            if (packageManager == null) {
                this.a.h().K().a("Failed to obtain Package Manager to verify binding conditions");
                return;
            }
            List<ResolveInfo> queryIntentServices = packageManager.queryIntentServices(intent, 0);
            if (queryIntentServices != null && !queryIntentServices.isEmpty()) {
                ServiceInfo serviceInfo = queryIntentServices.get(0).serviceInfo;
                if (serviceInfo != null) {
                    String str2 = serviceInfo.packageName;
                    if (serviceInfo.name != null && "com.android.vending".equals(str2) && c()) {
                        try {
                            this.a.h().N().b("Install Referrer Service is", ConnectionTracker.b().a(this.a.f(), new Intent(intent), zzflVar, 1) ? "available" : "not available");
                            return;
                        } catch (Exception e2) {
                            this.a.h().H().b("Exception occurred while binding to Install Referrer Service", e2.getMessage());
                            return;
                        }
                    }
                    this.a.h().N().a("Play Store missing or incompatible. Version 8.3.73 or later required");
                    return;
                }
                return;
            }
            this.a.h().N().a("Play Service for fetching Install Referrer is unavailable on device");
            return;
        }
        this.a.h().N().a("Install Referrer Reporter was called with invalid app package name");
    }
}
