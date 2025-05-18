package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.text.TextUtils;

/* loaded from: classes2.dex */
public final class zzcvf implements zzcuz<Bundle> {
    private final boolean a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f15665b;

    /* renamed from: c, reason: collision with root package name */
    private final String f15666c;

    /* renamed from: d, reason: collision with root package name */
    private final boolean f15667d;

    /* renamed from: e, reason: collision with root package name */
    private final boolean f15668e;

    /* renamed from: f, reason: collision with root package name */
    private final boolean f15669f;

    /* renamed from: g, reason: collision with root package name */
    private final String f15670g;

    /* renamed from: h, reason: collision with root package name */
    private final String f15671h;

    /* renamed from: i, reason: collision with root package name */
    private final String f15672i;

    /* renamed from: j, reason: collision with root package name */
    private final String f15673j;

    /* renamed from: k, reason: collision with root package name */
    private final boolean f15674k;
    private final String l;

    public zzcvf(boolean z, boolean z2, String str, boolean z3, boolean z4, boolean z5, String str2, String str3, String str4, String str5, boolean z6, String str6) {
        this.a = z;
        this.f15665b = z2;
        this.f15666c = str;
        this.f15667d = z3;
        this.f15668e = z4;
        this.f15669f = z5;
        this.f15670g = str2;
        this.f15671h = str3;
        this.f15672i = str4;
        this.f15673j = str5;
        this.f15674k = z6;
        this.l = str6;
    }

    @Override // com.google.android.gms.internal.ads.zzcuz
    public final /* synthetic */ void a(Bundle bundle) {
        Bundle bundle2 = bundle;
        bundle2.putBoolean("cog", this.a);
        bundle2.putBoolean("coh", this.f15665b);
        bundle2.putString("gl", this.f15666c);
        bundle2.putBoolean("simulator", this.f15667d);
        bundle2.putBoolean("is_latchsky", this.f15668e);
        bundle2.putBoolean("is_sidewinder", this.f15669f);
        bundle2.putString("hl", this.f15670g);
        bundle2.putString("mv", this.f15671h);
        bundle2.putString("submodel", this.l);
        Bundle a = zzcxz.a(bundle2, "device");
        bundle2.putBundle("device", a);
        a.putString("build", this.f15673j);
        Bundle a2 = zzcxz.a(a, "browser");
        a.putBundle("browser", a2);
        a2.putBoolean("is_browser_custom_tabs_capable", this.f15674k);
        if (TextUtils.isEmpty(this.f15672i)) {
            return;
        }
        Bundle a3 = zzcxz.a(a, "play_store");
        a.putBundle("play_store", a3);
        a3.putString("package_version", this.f15672i);
    }
}
