package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.internal.ads.zzbsm;
import java.util.Iterator;

/* loaded from: classes2.dex */
public final class zzcoe<AdT, AdapterT, ListenerT extends zzbsm> implements zzcjv<AdT> {
    private final zzcjz<AdapterT, ListenerT> a;

    /* renamed from: b, reason: collision with root package name */
    private final zzcka<AdT, AdapterT, ListenerT> f15456b;

    /* renamed from: c, reason: collision with root package name */
    private final zzczt f15457c;

    /* renamed from: d, reason: collision with root package name */
    private final zzbbl f15458d;

    public zzcoe(zzczt zzcztVar, zzbbl zzbblVar, zzcjz<AdapterT, ListenerT> zzcjzVar, zzcka<AdT, AdapterT, ListenerT> zzckaVar) {
        this.f15457c = zzcztVar;
        this.f15458d = zzbblVar;
        this.f15456b = zzckaVar;
        this.a = zzcjzVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcjv
    public final zzbbh<AdT> a(final zzcxu zzcxuVar, final zzcxm zzcxmVar) {
        final zzcjy<AdapterT, ListenerT> zzcjyVar;
        Iterator<String> it = zzcxmVar.q.iterator();
        while (true) {
            if (!it.hasNext()) {
                zzcjyVar = null;
                break;
            }
            try {
                zzcjyVar = this.a.a(it.next(), zzcxmVar.s);
                break;
            } catch (Throwable unused) {
            }
        }
        if (zzcjyVar == null) {
            return zzbar.l(new zzcmk("unable to instantiate mediation adapter class"));
        }
        zzbbr zzbbrVar = new zzbbr();
        zzcjyVar.f15314c.n6(new km(this, zzbbrVar, zzcjyVar));
        if (zzcxmVar.E) {
            Bundle bundle = zzcxuVar.a.a.f15750d.r;
            Bundle bundle2 = bundle.getBundle(AdMobAdapter.class.getName());
            if (bundle2 == null) {
                bundle2 = new Bundle();
                bundle.putBundle(AdMobAdapter.class.getName(), bundle2);
            }
            bundle2.putBoolean("render_test_ad_label", true);
        }
        return this.f15457c.g(zzczs.ADAPTER_LOAD_AD_SYN).a(new zzczd(this, zzcxuVar, zzcxmVar, zzcjyVar) { // from class: com.google.android.gms.internal.ads.im
            private final zzcoe a;

            /* renamed from: b, reason: collision with root package name */
            private final zzcxu f12775b;

            /* renamed from: c, reason: collision with root package name */
            private final zzcxm f12776c;

            /* renamed from: d, reason: collision with root package name */
            private final zzcjy f12777d;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.a = this;
                this.f12775b = zzcxuVar;
                this.f12776c = zzcxmVar;
                this.f12777d = zzcjyVar;
            }

            @Override // com.google.android.gms.internal.ads.zzczd
            public final void run() {
                this.a.d(this.f12775b, this.f12776c, this.f12777d);
            }
        }, this.f15458d).j(zzczs.ADAPTER_LOAD_AD_ACK).g(zzbbrVar).j(zzczs.ADAPTER_WRAP_ADAPTER).h(new zzczc(this, zzcxuVar, zzcxmVar, zzcjyVar) { // from class: com.google.android.gms.internal.ads.jm
            private final zzcoe a;

            /* renamed from: b, reason: collision with root package name */
            private final zzcxu f12831b;

            /* renamed from: c, reason: collision with root package name */
            private final zzcxm f12832c;

            /* renamed from: d, reason: collision with root package name */
            private final zzcjy f12833d;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.a = this;
                this.f12831b = zzcxuVar;
                this.f12832c = zzcxmVar;
                this.f12833d = zzcjyVar;
            }

            @Override // com.google.android.gms.internal.ads.zzczc
            public final Object a(Object obj) {
                return this.a.c(this.f12831b, this.f12832c, this.f12833d, (Void) obj);
            }
        }).f();
    }

    @Override // com.google.android.gms.internal.ads.zzcjv
    public final boolean b(zzcxu zzcxuVar, zzcxm zzcxmVar) {
        return !zzcxmVar.q.isEmpty();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ Object c(zzcxu zzcxuVar, zzcxm zzcxmVar, zzcjy zzcjyVar, Void r4) throws Exception {
        return this.f15456b.a(zzcxuVar, zzcxmVar, zzcjyVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void d(zzcxu zzcxuVar, zzcxm zzcxmVar, zzcjy zzcjyVar) throws Exception {
        this.f15456b.b(zzcxuVar, zzcxmVar, zzcjyVar);
    }
}
