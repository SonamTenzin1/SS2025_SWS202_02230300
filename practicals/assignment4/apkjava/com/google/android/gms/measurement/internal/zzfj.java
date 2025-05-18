package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.0 */
/* loaded from: classes2.dex */
public final class zzfj {
    private final String a;

    /* renamed from: b, reason: collision with root package name */
    private final String f18126b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f18127c;

    /* renamed from: d, reason: collision with root package name */
    private String f18128d;

    /* renamed from: e, reason: collision with root package name */
    private final /* synthetic */ r3 f18129e;

    public zzfj(r3 r3Var, String str, String str2) {
        this.f18129e = r3Var;
        Preconditions.g(str);
        this.a = str;
        this.f18126b = null;
    }

    public final String a() {
        SharedPreferences N;
        if (!this.f18127c) {
            this.f18127c = true;
            N = this.f18129e.N();
            this.f18128d = N.getString(this.a, null);
        }
        return this.f18128d;
    }

    public final void b(String str) {
        SharedPreferences N;
        if (zzkk.t0(str, this.f18128d)) {
            return;
        }
        N = this.f18129e.N();
        SharedPreferences.Editor edit = N.edit();
        edit.putString(this.a, str);
        edit.apply();
        this.f18128d = str;
    }
}
