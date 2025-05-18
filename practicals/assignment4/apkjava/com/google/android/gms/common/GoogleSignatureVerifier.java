package com.google.android.gms.common;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.util.Log;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.errorprone.annotations.RestrictedInheritance;

/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
@ShowFirstParty
@KeepForSdk
@RestrictedInheritance(allowedOnPath = ".*java.*/com/google/android/gms/common/testing/.*", explanation = "Sub classing of GMS Core's APIs are restricted to testing fakes.", link = "go/gmscore-restrictedinheritance")
/* loaded from: classes.dex */
public class GoogleSignatureVerifier {
    private static GoogleSignatureVerifier a;

    /* renamed from: b, reason: collision with root package name */
    private final Context f11640b;

    /* renamed from: c, reason: collision with root package name */
    private volatile String f11641c;

    public GoogleSignatureVerifier(Context context) {
        this.f11640b = context.getApplicationContext();
    }

    @KeepForSdk
    public static GoogleSignatureVerifier a(Context context) {
        Preconditions.k(context);
        synchronized (GoogleSignatureVerifier.class) {
            if (a == null) {
                k.d(context);
                a = new GoogleSignatureVerifier(context);
            }
        }
        return a;
    }

    static final g d(PackageInfo packageInfo, g... gVarArr) {
        Signature[] signatureArr = packageInfo.signatures;
        if (signatureArr == null) {
            return null;
        }
        if (signatureArr.length != 1) {
            Log.w("GoogleSignatureVerifier", "Package has more than one signature.");
            return null;
        }
        h hVar = new h(packageInfo.signatures[0].toByteArray());
        for (int i2 = 0; i2 < gVarArr.length; i2++) {
            if (gVarArr[i2].equals(hVar)) {
                return gVarArr[i2];
            }
        }
        return null;
    }

    public static final boolean e(PackageInfo packageInfo, boolean z) {
        if (z && packageInfo != null && ("com.android.vending".equals(packageInfo.packageName) || "com.google.android.gms".equals(packageInfo.packageName))) {
            ApplicationInfo applicationInfo = packageInfo.applicationInfo;
            z = (applicationInfo == null || (applicationInfo.flags & 129) == 0) ? false : true;
        }
        if (packageInfo != null && packageInfo.signatures != null) {
            if ((z ? d(packageInfo, j.a) : d(packageInfo, j.a[0])) != null) {
                return true;
            }
        }
        return false;
    }

    @SuppressLint({"PackageManagerGetSignatures"})
    private final m f(String str, boolean z, boolean z2) {
        m c2;
        ApplicationInfo applicationInfo;
        if (str == null) {
            return m.c("null pkg");
        }
        if (str.equals(this.f11641c)) {
            return m.b();
        }
        if (k.e()) {
            c2 = k.b(str, GooglePlayServicesUtilLight.honorsDebugCertificates(this.f11640b), false, false);
        } else {
            try {
                PackageInfo packageInfo = this.f11640b.getPackageManager().getPackageInfo(str, 64);
                boolean honorsDebugCertificates = GooglePlayServicesUtilLight.honorsDebugCertificates(this.f11640b);
                if (packageInfo == null) {
                    c2 = m.c("null pkg");
                } else {
                    Signature[] signatureArr = packageInfo.signatures;
                    if (signatureArr != null && signatureArr.length == 1) {
                        h hVar = new h(packageInfo.signatures[0].toByteArray());
                        String str2 = packageInfo.packageName;
                        m a2 = k.a(str2, hVar, honorsDebugCertificates, false);
                        c2 = (!a2.f12088b || (applicationInfo = packageInfo.applicationInfo) == null || (applicationInfo.flags & 2) == 0 || !k.a(str2, hVar, false, true).f12088b) ? a2 : m.c("debuggable release cert app rejected");
                    } else {
                        c2 = m.c("single cert required");
                    }
                }
            } catch (PackageManager.NameNotFoundException e2) {
                return m.d("no pkg ".concat(str), e2);
            }
        }
        if (c2.f12088b) {
            this.f11641c = str;
        }
        return c2;
    }

    @KeepForSdk
    public boolean b(PackageInfo packageInfo) {
        if (packageInfo == null) {
            return false;
        }
        if (e(packageInfo, false)) {
            return true;
        }
        if (e(packageInfo, true)) {
            if (GooglePlayServicesUtilLight.honorsDebugCertificates(this.f11640b)) {
                return true;
            }
            Log.w("GoogleSignatureVerifier", "Test-keys aren't accepted on this build.");
        }
        return false;
    }

    @ShowFirstParty
    @KeepForSdk
    public boolean c(int i2) {
        m c2;
        int length;
        String[] packagesForUid = this.f11640b.getPackageManager().getPackagesForUid(i2);
        if (packagesForUid != null && (length = packagesForUid.length) != 0) {
            c2 = null;
            int i3 = 0;
            while (true) {
                if (i3 < length) {
                    c2 = f(packagesForUid[i3], false, false);
                    if (c2.f12088b) {
                        break;
                    }
                    i3++;
                } else {
                    Preconditions.k(c2);
                    break;
                }
            }
        } else {
            c2 = m.c("no pkgs");
        }
        c2.e();
        return c2.f12088b;
    }
}
