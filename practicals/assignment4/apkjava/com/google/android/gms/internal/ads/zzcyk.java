package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.pm.PackageManager;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public final class zzcyk {
    private final Map<String, zzcym> a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    private final Context f15775b;

    /* renamed from: c, reason: collision with root package name */
    private final zzawm f15776c;

    /* renamed from: d, reason: collision with root package name */
    private final zzbai f15777d;

    /* renamed from: e, reason: collision with root package name */
    private final zzdh f15778e;

    public zzcyk(Context context, zzbai zzbaiVar, zzawm zzawmVar) {
        this.f15775b = context;
        this.f15777d = zzbaiVar;
        this.f15776c = zzawmVar;
        this.f15778e = new zzdh(new com.google.android.gms.ads.internal.zzg(context, zzbaiVar));
    }

    private final zzcym a() {
        return new zzcym(this.f15775b, this.f15776c.r(), this.f15776c.t(), this.f15778e);
    }

    private final zzcym c(String str) {
        zzasq e2 = zzasq.e(this.f15775b);
        try {
            e2.a(str);
            zzaxc zzaxcVar = new zzaxc();
            zzaxcVar.B(this.f15775b, str, false);
            zzaxf zzaxfVar = new zzaxf(this.f15776c.r(), zzaxcVar);
            return new zzcym(e2, zzaxfVar, new zzawu(zzazt.x(), zzaxfVar), new zzdh(new com.google.android.gms.ads.internal.zzg(this.f15775b, this.f15777d)));
        } catch (PackageManager.NameNotFoundException unused) {
            return a();
        }
    }

    public final zzcym b(String str) {
        if (str == null) {
            return a();
        }
        if (this.a.containsKey(str)) {
            return this.a.get(str);
        }
        zzcym c2 = c(str);
        this.a.put(str, c2);
        return c2;
    }
}
