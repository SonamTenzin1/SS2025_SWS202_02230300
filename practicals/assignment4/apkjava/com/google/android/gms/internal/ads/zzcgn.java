package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzk;
import java.io.InputStream;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public final class zzcgn {
    private final zzbbl a;

    /* renamed from: b, reason: collision with root package name */
    private final zzbbl f15209b;

    /* renamed from: c, reason: collision with root package name */
    private final zzchv f15210c;

    /* renamed from: d, reason: collision with root package name */
    private final zzdte<zzcig> f15211d;

    public zzcgn(zzbbl zzbblVar, zzbbl zzbblVar2, zzchv zzchvVar, zzdte<zzcig> zzdteVar) {
        this.a = zzbblVar;
        this.f15209b = zzbblVar2;
        this.f15210c = zzchvVar;
        this.f15211d = zzdteVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzbbh a(zzarx zzarxVar, zzcie zzcieVar) throws Exception {
        return this.f15211d.get().j7(zzarxVar);
    }

    public final zzbbh<InputStream> b(final zzarx zzarxVar) {
        final zzbbh<InputStream> b2;
        String str = zzarxVar.f14107i;
        zzk.zzlg();
        if (zzaxi.V(str)) {
            b2 = zzbar.l(new zzcie(0));
        } else {
            if (((Boolean) zzyt.e().c(zzacu.v4)).booleanValue()) {
                b2 = zzbar.e(this.a.submit(new Callable(this, zzarxVar) { // from class: com.google.android.gms.internal.ads.si

                    /* renamed from: f, reason: collision with root package name */
                    private final zzcgn f13325f;

                    /* renamed from: g, reason: collision with root package name */
                    private final zzarx f13326g;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        this.f13325f = this;
                        this.f13326g = zzarxVar;
                    }

                    @Override // java.util.concurrent.Callable
                    public final Object call() {
                        return this.f13325f.c(this.f13326g);
                    }
                }), ExecutionException.class, ti.a, this.f15209b);
            } else {
                b2 = this.f15210c.b(zzarxVar);
            }
        }
        zzbbh<InputStream> e2 = zzbar.e(b2, zzcie.class, new zzbal(this, zzarxVar) { // from class: com.google.android.gms.internal.ads.ui
            private final zzcgn a;

            /* renamed from: b, reason: collision with root package name */
            private final zzarx f13398b;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.a = this;
                this.f13398b = zzarxVar;
            }

            @Override // com.google.android.gms.internal.ads.zzbal
            public final zzbbh zzf(Object obj) {
                return this.a.a(this.f13398b, (zzcie) obj);
            }
        }, this.f15209b);
        if (!((Boolean) zzyt.e().c(zzacu.v4)).booleanValue()) {
            e2.k(new Runnable(b2) { // from class: com.google.android.gms.internal.ads.vi

                /* renamed from: f, reason: collision with root package name */
                private final zzbbh f13457f;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.f13457f = b2;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.f13457f.cancel(true);
                }
            }, zzbbm.f14331b);
        }
        return e2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ InputStream c(zzarx zzarxVar) throws Exception {
        return this.f15210c.b(zzarxVar).get(((Integer) zzyt.e().c(zzacu.u4)).intValue(), TimeUnit.SECONDS);
    }
}
