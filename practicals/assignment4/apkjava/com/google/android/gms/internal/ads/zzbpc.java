package com.google.android.gms.internal.ads;

import org.json.JSONException;

/* loaded from: classes2.dex */
public class zzbpc {
    protected zzcxu a;

    /* renamed from: b, reason: collision with root package name */
    protected zzcxm f14662b;

    /* renamed from: c, reason: collision with root package name */
    protected zzbry f14663c;

    /* renamed from: d, reason: collision with root package name */
    protected zzbso f14664d;

    /* renamed from: e, reason: collision with root package name */
    protected String f14665e;

    private static String e(zzcxm zzcxmVar) {
        try {
            return zzcxmVar.s.getString("class_name");
        } catch (JSONException unused) {
            return null;
        }
    }

    public void a() {
        this.f14663c.i0(null);
    }

    public final String b() {
        return this.f14665e;
    }

    public void c() {
        this.f14664d.onAdLoaded();
    }

    public final zzbry d() {
        return this.f14663c;
    }

    public final String f() {
        String e2 = "com.google.android.gms.ads.mediation.customevent.CustomEventAdapter".equals(this.f14665e) || "com.google.ads.mediation.customevent.CustomEventAdapter".equals(this.f14665e) ? e(this.f14662b) : null;
        return e2 == null ? this.f14665e : e2;
    }
}
