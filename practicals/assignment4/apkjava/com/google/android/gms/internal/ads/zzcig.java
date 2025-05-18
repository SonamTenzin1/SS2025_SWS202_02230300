package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.zzk;
import java.io.InputStream;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class zzcig extends zzarn {

    /* renamed from: f, reason: collision with root package name */
    private final Context f15264f;

    /* renamed from: g, reason: collision with root package name */
    private final Executor f15265g;

    /* renamed from: h, reason: collision with root package name */
    private final zzasm f15266h;

    /* renamed from: i, reason: collision with root package name */
    private final zzasl f15267i;

    /* renamed from: j, reason: collision with root package name */
    private final zzblp f15268j;

    public zzcig(Context context, Executor executor, zzasm zzasmVar, zzblp zzblpVar, zzasl zzaslVar) {
        zzacu.a(context);
        this.f15264f = context;
        this.f15265g = executor;
        this.f15266h = zzasmVar;
        this.f15267i = zzaslVar;
        this.f15268j = zzblpVar;
    }

    private final void h7(zzbbh<InputStream> zzbbhVar, zzarr zzarrVar) {
        zzbar.f(zzbar.c(zzbbhVar, new zzbal(this) { // from class: com.google.android.gms.internal.ads.tj
            private final zzcig a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.a = this;
            }

            @Override // com.google.android.gms.internal.ads.zzbal
            public final zzbbh zzf(Object obj) {
                return zzbar.o(zzcyc.c((InputStream) obj));
            }
        }, zzaxg.a), new uj(this, zzarrVar), zzbbm.f14331b);
    }

    @Override // com.google.android.gms.internal.ads.zzarm
    public final void I5(zzarx zzarxVar, zzarr zzarrVar) {
        zzbbh<InputStream> j7 = j7(zzarxVar);
        h7(j7, zzarrVar);
        j7.k(new Runnable(this) { // from class: com.google.android.gms.internal.ads.rj

            /* renamed from: f, reason: collision with root package name */
            private final zzcig f13277f;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f13277f = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f13277f.i7();
            }
        }, this.f15265g);
    }

    @Override // com.google.android.gms.internal.ads.zzarm
    public final void W5(zzarg zzargVar, zzarp zzarpVar) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzarm
    public final void X6(zzarx zzarxVar, zzarr zzarrVar) {
        zzbbh<InputStream> f2;
        zzalr a = zzk.zzlt().a(this.f15264f, zzbai.y());
        if (!((Boolean) zzyt.e().c(zzacu.K4)).booleanValue()) {
            f2 = zzbar.l(new Exception("Signal collection disabled."));
        } else {
            zzcvs a2 = this.f15268j.a(zzarxVar);
            final zzcvb<JSONObject> b2 = this.f15268j.a(zzarxVar).b();
            f2 = a2.c().c(zzczs.GET_SIGNALS, zzbar.o(zzarxVar.f14104f)).b(new zzbal(b2) { // from class: com.google.android.gms.internal.ads.sj
                private final zzcvb a;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.a = b2;
                }

                @Override // com.google.android.gms.internal.ads.zzbal
                public final zzbbh zzf(Object obj) {
                    return this.a.b(zzk.zzlg().N((Bundle) obj));
                }
            }).j(zzczs.JS_SIGNALS).b(a.a("google.afma.request.getSignals", zzalo.f13955b, zzalo.f13956c)).f();
        }
        h7(f2, zzarrVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void i7() {
        zzbao.a(this.f15267i.a(), "persistFlags");
    }

    public final zzbbh<InputStream> j7(zzarx zzarxVar) {
        zzalr a = zzk.zzlt().a(this.f15264f, zzbai.y());
        final zzcvs a2 = this.f15268j.a(zzarxVar);
        zzbal zzbalVar = new zzbal(a2) { // from class: com.google.android.gms.internal.ads.lj
            private final zzcvs a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.a = a2;
            }

            @Override // com.google.android.gms.internal.ads.zzbal
            public final zzbbh zzf(Object obj) {
                return this.a.a().b(zzk.zzlg().N((Bundle) obj));
            }
        };
        zzczc zzczcVar = mj.a;
        zzaln<JSONObject> zzalnVar = zzalo.f13955b;
        zzalj a3 = a.a("AFMA_getAdDictionary", zzalnVar, nj.a);
        zzalj a4 = a.a("google.afma.response.normalize", zzcir.a, zzalo.f13956c);
        zzciu zzciuVar = new zzciu(this.f15264f, zzarxVar.f14105g.f14326f, this.f15266h, zzarxVar.l);
        zzczt c2 = a2.c();
        final zzcze f2 = c2.c(zzczs.GMS_SIGNALS, zzbar.o(zzarxVar.f14104f)).b(zzbalVar).h(zzczcVar).f();
        if (((Boolean) zzyt.e().c(zzacu.w4)).booleanValue()) {
            return c2.c(zzczs.AD_REQUEST, f2).b(a.a("google.afma.request.getAdResponse", zzalnVar, zzalnVar)).h(oj.a).f();
        }
        final zzcze f3 = c2.c(zzczs.BUILD_URL, f2).b(a3).f();
        final zzcze f4 = c2.b(zzczs.HTTP, f3, f2).a(new Callable(f2, f3) { // from class: com.google.android.gms.internal.ads.pj

            /* renamed from: f, reason: collision with root package name */
            private final zzbbh f13173f;

            /* renamed from: g, reason: collision with root package name */
            private final zzbbh f13174g;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f13173f = f2;
                this.f13174g = f3;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return new zzciv((JSONObject) this.f13173f.get(), (zzasd) this.f13174g.get());
            }
        }).h(zzciuVar).f();
        return c2.b(zzczs.PRE_PROCESS, f2, f3, f4).a(new Callable(f4, f2, f3) { // from class: com.google.android.gms.internal.ads.qj

            /* renamed from: f, reason: collision with root package name */
            private final zzbbh f13234f;

            /* renamed from: g, reason: collision with root package name */
            private final zzbbh f13235g;

            /* renamed from: h, reason: collision with root package name */
            private final zzbbh f13236h;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f13234f = f4;
                this.f13235g = f2;
                this.f13236h = f3;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return new zzcir((zzciw) this.f13234f.get(), (JSONObject) this.f13235g.get(), (zzasd) this.f13236h.get());
            }
        }).b(a4).f();
    }

    @Override // com.google.android.gms.internal.ads.zzarm
    public final zzari r6(zzarg zzargVar) throws RemoteException {
        return null;
    }
}
