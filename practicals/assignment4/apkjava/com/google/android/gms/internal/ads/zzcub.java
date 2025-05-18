package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;

/* loaded from: classes2.dex */
public final class zzcub implements zzcuz<Bundle>, zzcva<zzcuz<Bundle>> {
    private final ApplicationInfo a;

    /* renamed from: b, reason: collision with root package name */
    private final PackageInfo f15630b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzcub(ApplicationInfo applicationInfo, PackageInfo packageInfo) {
        this.a = applicationInfo;
        this.f15630b = packageInfo;
    }

    @Override // com.google.android.gms.internal.ads.zzcuz
    public final /* synthetic */ void a(Bundle bundle) {
        Bundle bundle2 = bundle;
        String str = this.a.packageName;
        PackageInfo packageInfo = this.f15630b;
        Integer valueOf = packageInfo == null ? null : Integer.valueOf(packageInfo.versionCode);
        bundle2.putString("pn", str);
        if (valueOf != null) {
            bundle2.putInt("vc", valueOf.intValue());
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcva
    public final zzbbh<zzcuz<Bundle>> b() {
        return zzbar.o(this);
    }
}
