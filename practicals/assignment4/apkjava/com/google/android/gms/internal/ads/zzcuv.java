package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* loaded from: classes2.dex */
public final class zzcuv implements zzcuz<Bundle> {
    private final boolean a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f15654b;

    /* renamed from: c, reason: collision with root package name */
    private final String f15655c;

    /* renamed from: d, reason: collision with root package name */
    private final boolean f15656d;

    /* renamed from: e, reason: collision with root package name */
    private final int f15657e;

    /* renamed from: f, reason: collision with root package name */
    private final int f15658f;

    public zzcuv(boolean z, boolean z2, String str, boolean z3, int i2, int i3) {
        this.a = z;
        this.f15654b = z2;
        this.f15655c = str;
        this.f15656d = z3;
        this.f15657e = i2;
        this.f15658f = i3;
    }

    @Override // com.google.android.gms.internal.ads.zzcuz
    public final /* synthetic */ void a(Bundle bundle) {
        Bundle bundle2 = bundle;
        bundle2.putString("js", this.f15655c);
        bundle2.putBoolean("is_nonagon", true);
        bundle2.putString("extra_caps", (String) zzyt.e().c(zzacu.C2));
        bundle2.putInt("target_api", this.f15657e);
        bundle2.putInt("dv", this.f15658f);
        Bundle a = zzcxz.a(bundle2, "sdk_env");
        a.putBoolean("mf", ((Boolean) zzyt.e().c(zzacu.E2)).booleanValue());
        a.putBoolean("instant_app", this.a);
        a.putBoolean("lite", this.f15654b);
        a.putBoolean("is_privileged_process", this.f15656d);
        bundle2.putBundle("sdk_env", a);
        Bundle a2 = zzcxz.a(a, "build_meta");
        a2.putString("cl", "248613007");
        a2.putString("rapid_rc", "dev");
        a2.putString("rapid_rollup", "HEAD");
        a.putBundle("build_meta", a2);
    }
}
