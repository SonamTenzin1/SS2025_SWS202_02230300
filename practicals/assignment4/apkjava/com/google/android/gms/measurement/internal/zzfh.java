package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.0 */
/* loaded from: classes2.dex */
public final class zzfh {
    private final String a;

    /* renamed from: b, reason: collision with root package name */
    private final long f18118b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f18119c;

    /* renamed from: d, reason: collision with root package name */
    private long f18120d;

    /* renamed from: e, reason: collision with root package name */
    private final /* synthetic */ r3 f18121e;

    public zzfh(r3 r3Var, String str, long j2) {
        this.f18121e = r3Var;
        Preconditions.g(str);
        this.a = str;
        this.f18118b = j2;
    }

    public final long a() {
        SharedPreferences N;
        if (!this.f18119c) {
            this.f18119c = true;
            N = this.f18121e.N();
            this.f18120d = N.getLong(this.a, this.f18118b);
        }
        return this.f18120d;
    }

    public final void b(long j2) {
        SharedPreferences N;
        N = this.f18121e.N();
        SharedPreferences.Editor edit = N.edit();
        edit.putLong(this.a, j2);
        edit.apply();
        this.f18120d = j2;
    }
}
