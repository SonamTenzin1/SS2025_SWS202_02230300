package com.google.firebase.crashlytics.internal.n;

import android.content.Context;
import okhttp3.HttpUrl;

/* compiled from: InstallerPackageNameProvider.java */
/* loaded from: classes2.dex */
class k0 {
    private String a;

    private static String b(Context context) {
        String installerPackageName = context.getPackageManager().getInstallerPackageName(context.getPackageName());
        return installerPackageName == null ? HttpUrl.FRAGMENT_ENCODE_SET : installerPackageName;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized String a(Context context) {
        if (this.a == null) {
            this.a = b(context);
        }
        return HttpUrl.FRAGMENT_ENCODE_SET.equals(this.a) ? null : this.a;
    }
}
