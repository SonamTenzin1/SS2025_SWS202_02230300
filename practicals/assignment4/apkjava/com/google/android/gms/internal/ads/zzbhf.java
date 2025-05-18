package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzj;
import com.google.android.gms.ads.internal.zzk;
import java.util.concurrent.Callable;
import okhttp3.HttpUrl;

@zzard
/* loaded from: classes2.dex */
public final class zzbhf {
    public static zzbbh<zzbgz> a(final Context context, final zzbai zzbaiVar, final String str, final zzdh zzdhVar, final com.google.android.gms.ads.internal.zza zzaVar) {
        return zzbar.c(zzbar.o(null), new zzbal(context, zzdhVar, zzbaiVar, zzaVar, str) { // from class: com.google.android.gms.internal.ads.xa
            private final Context a;

            /* renamed from: b, reason: collision with root package name */
            private final zzdh f13567b;

            /* renamed from: c, reason: collision with root package name */
            private final zzbai f13568c;

            /* renamed from: d, reason: collision with root package name */
            private final com.google.android.gms.ads.internal.zza f13569d;

            /* renamed from: e, reason: collision with root package name */
            private final String f13570e;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.a = context;
                this.f13567b = zzdhVar;
                this.f13568c = zzbaiVar;
                this.f13569d = zzaVar;
                this.f13570e = str;
            }

            @Override // com.google.android.gms.internal.ads.zzbal
            public final zzbbh zzf(Object obj) {
                Context context2 = this.a;
                zzdh zzdhVar2 = this.f13567b;
                zzbai zzbaiVar2 = this.f13568c;
                com.google.android.gms.ads.internal.zza zzaVar2 = this.f13569d;
                String str2 = this.f13570e;
                zzk.zzlh();
                zzbgz b2 = zzbhf.b(context2, zzbin.b(), HttpUrl.FRAGMENT_ENCODE_SET, false, false, zzdhVar2, zzbaiVar2, null, null, zzaVar2, zzwj.f());
                final zzbbq e2 = zzbbq.e(b2);
                b2.p().i(new zzbij(e2) { // from class: com.google.android.gms.internal.ads.za
                    private final zzbbq a;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        this.a = e2;
                    }

                    @Override // com.google.android.gms.internal.ads.zzbij
                    public final void zzae(boolean z) {
                        this.a.f();
                    }
                });
                b2.loadUrl(str2);
                return e2;
            }
        }, zzbbm.a);
    }

    public static zzbgz b(final Context context, final zzbin zzbinVar, final String str, final boolean z, final boolean z2, final zzdh zzdhVar, final zzbai zzbaiVar, zzadi zzadiVar, final zzj zzjVar, final com.google.android.gms.ads.internal.zza zzaVar, final zzwj zzwjVar) throws zzbhj {
        zzacu.a(context);
        if (((Boolean) zzyt.e().c(zzacu.P0)).booleanValue()) {
            return zzbit.a(context, zzbinVar, str, z, z2, zzdhVar, zzbaiVar, null, zzjVar, zzaVar, zzwjVar);
        }
        try {
            final zzadi zzadiVar2 = null;
            return (zzbgz) zzazl.b(new Callable(context, zzbinVar, str, z, z2, zzdhVar, zzbaiVar, zzadiVar2, zzjVar, zzaVar, zzwjVar) { // from class: com.google.android.gms.internal.ads.ya

                /* renamed from: f, reason: collision with root package name */
                private final Context f13617f;

                /* renamed from: g, reason: collision with root package name */
                private final zzbin f13618g;

                /* renamed from: h, reason: collision with root package name */
                private final String f13619h;

                /* renamed from: i, reason: collision with root package name */
                private final boolean f13620i;

                /* renamed from: j, reason: collision with root package name */
                private final boolean f13621j;

                /* renamed from: k, reason: collision with root package name */
                private final zzdh f13622k;
                private final zzbai l;
                private final zzadi m = null;
                private final zzj n;
                private final com.google.android.gms.ads.internal.zza o;
                private final zzwj p;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.f13617f = context;
                    this.f13618g = zzbinVar;
                    this.f13619h = str;
                    this.f13620i = z;
                    this.f13621j = z2;
                    this.f13622k = zzdhVar;
                    this.l = zzbaiVar;
                    this.n = zzjVar;
                    this.o = zzaVar;
                    this.p = zzwjVar;
                }

                @Override // java.util.concurrent.Callable
                public final Object call() {
                    Context context2 = this.f13617f;
                    zzbin zzbinVar2 = this.f13618g;
                    String str2 = this.f13619h;
                    boolean z3 = this.f13620i;
                    boolean z4 = this.f13621j;
                    zzdh zzdhVar2 = this.f13622k;
                    zzbai zzbaiVar2 = this.l;
                    zzadi zzadiVar3 = this.m;
                    zzj zzjVar2 = this.n;
                    com.google.android.gms.ads.internal.zza zzaVar2 = this.o;
                    zzwj zzwjVar2 = this.p;
                    zzbhk zzbhkVar = new zzbhk(bb.L0(context2, zzbinVar2, str2, z3, z4, zzdhVar2, zzbaiVar2, zzadiVar3, zzjVar2, zzaVar2, zzwjVar2));
                    zzbhkVar.setWebViewClient(zzk.zzli().g(zzbhkVar, zzwjVar2, z4));
                    zzbhkVar.setWebChromeClient(new zzbgr(zzbhkVar));
                    return zzbhkVar;
                }
            });
        } catch (Throwable th) {
            throw new zzbhj("Webview initialization failed.", th);
        }
    }
}
