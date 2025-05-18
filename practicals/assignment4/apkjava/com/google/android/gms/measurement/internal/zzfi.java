package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.0 */
/* loaded from: classes2.dex */
public final class zzfi {
    private final String a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f18122b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f18123c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f18124d;

    /* renamed from: e, reason: collision with root package name */
    private final /* synthetic */ r3 f18125e;

    public zzfi(r3 r3Var, String str, boolean z) {
        this.f18125e = r3Var;
        Preconditions.g(str);
        this.a = str;
        this.f18122b = z;
    }

    public final void a(boolean z) {
        SharedPreferences N;
        N = this.f18125e.N();
        SharedPreferences.Editor edit = N.edit();
        edit.putBoolean(this.a, z);
        edit.apply();
        this.f18124d = z;
    }

    public final boolean b() {
        SharedPreferences N;
        if (!this.f18123c) {
            this.f18123c = true;
            N = this.f18125e.N();
            this.f18124d = N.getBoolean(this.a, this.f18122b);
        }
        return this.f18124d;
    }
}
