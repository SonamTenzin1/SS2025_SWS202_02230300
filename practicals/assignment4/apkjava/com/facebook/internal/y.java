package com.facebook.internal;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Build;
import java.util.HashSet;
import kotlin.collections.w0;

/* compiled from: FacebookSignatureValidator.kt */
/* loaded from: classes2.dex */
public final class y {
    public static final y a = new y();

    /* renamed from: b, reason: collision with root package name */
    private static final HashSet<String> f9918b;

    static {
        HashSet<String> e2;
        e2 = w0.e("8a3c4b262d721acd49a4bf97d5213199c86fa2b9", "cc2751449a350f668590264ed76692694a80308a", "a4b7452e2ed8f5f191058ca7bbfd26b0d3214bfc", "df6b721c8b4d3b6eb44c861d4415007e5a35fc95", "9b8f518b086098de3d77736f9458a3d2f6f95a37", "2438bce1ddb7bd026d5ff89f598b3b5e5bb824b3", "c56fb7d591ba6704df047fd98f535372fea00211");
        f9918b = e2;
    }

    private y() {
    }

    public static final boolean a(Context context, String str) {
        boolean E;
        boolean K;
        kotlin.jvm.internal.m.f(context, "context");
        kotlin.jvm.internal.m.f(str, "packageName");
        String str2 = Build.BRAND;
        int i2 = context.getApplicationInfo().flags;
        kotlin.jvm.internal.m.e(str2, "brand");
        E = kotlin.text.u.E(str2, "generic", false, 2, null);
        if (E && (i2 & 2) != 0) {
            return true;
        }
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 64);
            Signature[] signatureArr = packageInfo.signatures;
            if (signatureArr == null) {
                return false;
            }
            kotlin.jvm.internal.m.e(signatureArr, "packageInfo.signatures");
            if (signatureArr.length == 0) {
                return false;
            }
            Signature[] signatureArr2 = packageInfo.signatures;
            kotlin.jvm.internal.m.e(signatureArr2, "packageInfo.signatures");
            for (Signature signature : signatureArr2) {
                HashSet<String> hashSet = f9918b;
                p0 p0Var = p0.a;
                byte[] byteArray = signature.toByteArray();
                kotlin.jvm.internal.m.e(byteArray, "it.toByteArray()");
                K = kotlin.collections.c0.K(hashSet, p0.E0(byteArray));
                if (!K) {
                    return false;
                }
            }
            return true;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }
}
