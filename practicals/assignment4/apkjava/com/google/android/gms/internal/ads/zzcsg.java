package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* loaded from: classes2.dex */
public final class zzcsg implements zzcuz<Bundle> {
    private final double a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f15601b;

    public zzcsg(double d2, boolean z) {
        this.a = d2;
        this.f15601b = z;
    }

    @Override // com.google.android.gms.internal.ads.zzcuz
    public final /* synthetic */ void a(Bundle bundle) {
        Bundle bundle2 = bundle;
        Bundle a = zzcxz.a(bundle2, "device");
        bundle2.putBundle("device", a);
        Bundle a2 = zzcxz.a(a, "battery");
        a.putBundle("battery", a2);
        a2.putBoolean("is_charging", this.f15601b);
        a2.putDouble("battery_level", this.a);
    }
}
