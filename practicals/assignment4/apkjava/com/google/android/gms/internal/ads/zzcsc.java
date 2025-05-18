package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* loaded from: classes2.dex */
public final class zzcsc implements zzcuz<Bundle> {
    private final int a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f15592b;

    /* renamed from: c, reason: collision with root package name */
    private final boolean f15593c;

    /* renamed from: d, reason: collision with root package name */
    private final int f15594d;

    /* renamed from: e, reason: collision with root package name */
    private final int f15595e;

    /* renamed from: f, reason: collision with root package name */
    private final int f15596f;

    /* renamed from: g, reason: collision with root package name */
    private final float f15597g;

    /* renamed from: h, reason: collision with root package name */
    private final boolean f15598h;

    public zzcsc(int i2, boolean z, boolean z2, int i3, int i4, int i5, float f2, boolean z3) {
        this.a = i2;
        this.f15592b = z;
        this.f15593c = z2;
        this.f15594d = i3;
        this.f15595e = i4;
        this.f15596f = i5;
        this.f15597g = f2;
        this.f15598h = z3;
    }

    @Override // com.google.android.gms.internal.ads.zzcuz
    public final /* synthetic */ void a(Bundle bundle) {
        Bundle bundle2 = bundle;
        bundle2.putInt("am", this.a);
        bundle2.putBoolean("ma", this.f15592b);
        bundle2.putBoolean("sp", this.f15593c);
        bundle2.putInt("muv", this.f15594d);
        bundle2.putInt("rm", this.f15595e);
        bundle2.putInt("riv", this.f15596f);
        bundle2.putFloat("android_app_volume", this.f15597g);
        bundle2.putBoolean("android_app_muted", this.f15598h);
    }
}
