package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import android.util.Pair;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import okhttp3.HttpUrl;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.0 */
/* loaded from: classes2.dex */
public final class zzfk {

    @VisibleForTesting
    private final String a;

    /* renamed from: b, reason: collision with root package name */
    private final String f18130b;

    /* renamed from: c, reason: collision with root package name */
    private final String f18131c;

    /* renamed from: d, reason: collision with root package name */
    private final long f18132d;

    /* renamed from: e, reason: collision with root package name */
    private final /* synthetic */ r3 f18133e;

    private zzfk(r3 r3Var, String str, long j2) {
        this.f18133e = r3Var;
        Preconditions.g(str);
        Preconditions.a(j2 > 0);
        this.a = String.valueOf(str).concat(":start");
        this.f18130b = String.valueOf(str).concat(":count");
        this.f18131c = String.valueOf(str).concat(":value");
        this.f18132d = j2;
    }

    private final void c() {
        SharedPreferences N;
        this.f18133e.d();
        long a = this.f18133e.j().a();
        N = this.f18133e.N();
        SharedPreferences.Editor edit = N.edit();
        edit.remove(this.f18130b);
        edit.remove(this.f18131c);
        edit.putLong(this.a, a);
        edit.apply();
    }

    private final long d() {
        SharedPreferences N;
        N = this.f18133e.N();
        return N.getLong(this.a, 0L);
    }

    public final Pair<String, Long> a() {
        long abs;
        SharedPreferences N;
        SharedPreferences N2;
        this.f18133e.d();
        this.f18133e.d();
        long d2 = d();
        if (d2 == 0) {
            c();
            abs = 0;
        } else {
            abs = Math.abs(d2 - this.f18133e.j().a());
        }
        long j2 = this.f18132d;
        if (abs < j2) {
            return null;
        }
        if (abs <= (j2 << 1)) {
            N = this.f18133e.N();
            String string = N.getString(this.f18131c, null);
            N2 = this.f18133e.N();
            long j3 = N2.getLong(this.f18130b, 0L);
            c();
            if (string != null && j3 > 0) {
                return new Pair<>(string, Long.valueOf(j3));
            }
            return r3.f17919c;
        }
        c();
        return null;
    }

    public final void b(String str, long j2) {
        SharedPreferences N;
        SharedPreferences N2;
        SharedPreferences N3;
        this.f18133e.d();
        if (d() == 0) {
            c();
        }
        if (str == null) {
            str = HttpUrl.FRAGMENT_ENCODE_SET;
        }
        N = this.f18133e.N();
        long j3 = N.getLong(this.f18130b, 0L);
        if (j3 <= 0) {
            N3 = this.f18133e.N();
            SharedPreferences.Editor edit = N3.edit();
            edit.putString(this.f18131c, str);
            edit.putLong(this.f18130b, 1L);
            edit.apply();
            return;
        }
        long j4 = j3 + 1;
        boolean z = (this.f18133e.l().z0().nextLong() & Long.MAX_VALUE) < Long.MAX_VALUE / j4;
        N2 = this.f18133e.N();
        SharedPreferences.Editor edit2 = N2.edit();
        if (z) {
            edit2.putString(this.f18131c, str);
        }
        edit2.putLong(this.f18130b, j4);
        edit2.apply();
    }
}
