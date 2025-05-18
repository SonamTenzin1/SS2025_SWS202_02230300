package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
final class yc extends zzbnf {

    /* renamed from: f, reason: collision with root package name */
    private final Context f13633f;

    /* renamed from: g, reason: collision with root package name */
    private final View f13634g;

    /* renamed from: h, reason: collision with root package name */
    private final zzbgz f13635h;

    /* renamed from: i, reason: collision with root package name */
    private final zzcxn f13636i;

    /* renamed from: j, reason: collision with root package name */
    private final zzbpb f13637j;

    /* renamed from: k, reason: collision with root package name */
    private final zzbzc f13638k;
    private final zzbvd l;
    private final zzdte<zzcpm> m;
    private final Executor n;

    /* JADX INFO: Access modifiers changed from: package-private */
    public yc(Context context, zzcxn zzcxnVar, View view, zzbgz zzbgzVar, zzbpb zzbpbVar, zzbzc zzbzcVar, zzbvd zzbvdVar, zzdte<zzcpm> zzdteVar, Executor executor) {
        this.f13633f = context;
        this.f13634g = view;
        this.f13635h = zzbgzVar;
        this.f13636i = zzcxnVar;
        this.f13637j = zzbpbVar;
        this.f13638k = zzbzcVar;
        this.l = zzbvdVar;
        this.m = zzdteVar;
        this.n = executor;
    }

    @Override // com.google.android.gms.internal.ads.zzbpc
    public final void c() {
        this.n.execute(new Runnable(this) { // from class: com.google.android.gms.internal.ads.zc

            /* renamed from: f, reason: collision with root package name */
            private final yc f13704f;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f13704f = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f13704f.m();
            }
        });
        super.c();
    }

    @Override // com.google.android.gms.internal.ads.zzbnf
    public final zzaar g() {
        try {
            return this.f13637j.getVideoController();
        } catch (RemoteException unused) {
            return null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbnf
    public final void h(ViewGroup viewGroup, zzyd zzydVar) {
        zzbgz zzbgzVar;
        if (viewGroup == null || (zzbgzVar = this.f13635h) == null) {
            return;
        }
        zzbgzVar.A(zzbin.i(zzydVar));
        viewGroup.setMinimumHeight(zzydVar.f16989h);
        viewGroup.setMinimumWidth(zzydVar.f16992k);
    }

    @Override // com.google.android.gms.internal.ads.zzbnf
    public final View i() {
        return this.f13634g;
    }

    @Override // com.google.android.gms.internal.ads.zzbnf
    public final zzcxn j() {
        return this.f14662b.o.get(0);
    }

    @Override // com.google.android.gms.internal.ads.zzbnf
    public final int k() {
        return this.a.f15747b.f15744b.f15737c;
    }

    @Override // com.google.android.gms.internal.ads.zzbnf
    public final void l() {
        this.l.Y();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void m() {
        if (this.f13638k.d() != null) {
            try {
                this.f13638k.d().h1(this.m.get(), ObjectWrapper.E0(this.f13633f));
            } catch (RemoteException e2) {
                zzbad.c("RemoteException when notifyAdLoad is called", e2);
            }
        }
    }
}
