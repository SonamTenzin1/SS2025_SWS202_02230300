package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.ads.internal.zzk;

/* loaded from: classes2.dex */
public final class zzcdb extends zzbpc {

    /* renamed from: f, reason: collision with root package name */
    private final Context f15087f;

    /* renamed from: g, reason: collision with root package name */
    private final zzbwz f15088g;

    /* renamed from: h, reason: collision with root package name */
    private final zzbup f15089h;

    /* renamed from: i, reason: collision with root package name */
    private final zzbrp f15090i;

    /* renamed from: j, reason: collision with root package name */
    private final zzbpv f15091j;

    /* renamed from: k, reason: collision with root package name */
    private final zzatq f15092k;
    private final zzdan l;
    private boolean m = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzcdb(Context context, zzbwz zzbwzVar, zzbup zzbupVar, zzbrp zzbrpVar, zzbry zzbryVar, zzbpv zzbpvVar, zzcxm zzcxmVar, zzdan zzdanVar) {
        this.f15087f = context;
        this.f15088g = zzbwzVar;
        this.f15089h = zzbupVar;
        this.f15090i = zzbrpVar;
        this.f14663c = zzbryVar;
        this.f15091j = zzbpvVar;
        this.l = zzdanVar;
        this.f15092k = new zzaup(zzcxmVar.l);
    }

    public final boolean g() {
        return this.f15091j.a();
    }

    public final zzbry h() {
        return this.f14663c;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v2, types: [android.content.Context] */
    public final void i(boolean z, Activity activity) {
        if (((Boolean) zzyt.e().c(zzacu.L0)).booleanValue()) {
            zzk.zzlg();
            if (zzaxi.A(this.f15087f)) {
                zzbad.i("Rewarded ad can not be shown when app is not in foreground.");
                this.f15090i.R(3);
                if (((Boolean) zzyt.e().c(zzacu.M0)).booleanValue()) {
                    this.l.a(this.a.f15747b.f15744b.f15736b);
                    return;
                }
                return;
            }
        }
        if (this.m) {
            zzbad.i("The rewarded ad have been showed.");
            this.f15090i.R(1);
            return;
        }
        this.m = true;
        this.f15089h.y();
        Activity activity2 = activity;
        if (activity == null) {
            activity2 = this.f15087f;
        }
        this.f15088g.a(z, activity2);
    }

    public final zzatq j() {
        return this.f15092k;
    }
}
