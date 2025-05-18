package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.util.VisibleForTesting;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.0 */
@VisibleForTesting
/* loaded from: classes2.dex */
public final class zzem<V> {
    private static final Object a = new Object();

    /* renamed from: b, reason: collision with root package name */
    private final String f18084b;

    /* renamed from: c, reason: collision with root package name */
    private final e3<V> f18085c;

    /* renamed from: d, reason: collision with root package name */
    private final V f18086d;

    /* renamed from: e, reason: collision with root package name */
    private final V f18087e;

    /* renamed from: f, reason: collision with root package name */
    private final Object f18088f;

    /* renamed from: g, reason: collision with root package name */
    private volatile V f18089g;

    /* renamed from: h, reason: collision with root package name */
    private volatile V f18090h;

    private zzem(String str, V v, V v2, e3<V> e3Var) {
        this.f18088f = new Object();
        this.f18089g = null;
        this.f18090h = null;
        this.f18084b = str;
        this.f18086d = v;
        this.f18087e = v2;
        this.f18085c = e3Var;
    }

    public final V a(V v) {
        synchronized (this.f18088f) {
        }
        if (v != null) {
            return v;
        }
        if (zzap.a == null) {
            return this.f18086d;
        }
        synchronized (a) {
            if (zzw.a()) {
                return this.f18090h == null ? this.f18086d : this.f18090h;
            }
            if (!zzw.a()) {
                zzw zzwVar = zzap.a;
                try {
                    for (zzem zzemVar : zzap.A0()) {
                        synchronized (a) {
                            if (!zzw.a()) {
                                try {
                                    e3<V> e3Var = zzemVar.f18085c;
                                    zzemVar.f18090h = e3Var != null ? e3Var.a() : null;
                                } catch (IllegalStateException unused) {
                                    zzemVar.f18090h = null;
                                }
                            } else {
                                throw new IllegalStateException("Refreshing flag cache must be done on a worker thread.");
                            }
                        }
                    }
                } catch (SecurityException e2) {
                    zzap.f(e2);
                }
                e3<V> e3Var2 = this.f18085c;
                if (e3Var2 == null) {
                    zzw zzwVar2 = zzap.a;
                    return this.f18086d;
                }
                try {
                    return e3Var2.a();
                } catch (IllegalStateException unused2) {
                    zzw zzwVar3 = zzap.a;
                    return this.f18086d;
                } catch (SecurityException e3) {
                    zzap.f(e3);
                    zzw zzwVar4 = zzap.a;
                    return this.f18086d;
                }
            }
            throw new IllegalStateException("Tried to refresh flag cache on main thread or on package side.");
        }
    }

    public final String b() {
        return this.f18084b;
    }
}
