package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.ads.formats.PublisherAdViewOptions;
import java.util.ArrayList;
import java.util.Set;

/* loaded from: classes2.dex */
public final class zzcxv {
    public final zzzy a;

    /* renamed from: b, reason: collision with root package name */
    public final zzacd f15748b;

    /* renamed from: c, reason: collision with root package name */
    public final zzaiy f15749c;

    /* renamed from: d, reason: collision with root package name */
    public final zzxz f15750d;

    /* renamed from: e, reason: collision with root package name */
    public final zzyd f15751e;

    /* renamed from: f, reason: collision with root package name */
    public final String f15752f;

    /* renamed from: g, reason: collision with root package name */
    public final ArrayList<String> f15753g;

    /* renamed from: h, reason: collision with root package name */
    public final ArrayList<String> f15754h;

    /* renamed from: i, reason: collision with root package name */
    public final zzady f15755i;

    /* renamed from: j, reason: collision with root package name */
    public final String f15756j;

    /* renamed from: k, reason: collision with root package name */
    public final String f15757k;
    public final int l;
    public final PublisherAdViewOptions m;
    public final zzzs n;
    public final Set<String> o;

    private zzcxv(zzcxx zzcxxVar) {
        zzacd zzacdVar;
        this.f15751e = zzcxx.a(zzcxxVar);
        this.f15752f = zzcxx.i(zzcxxVar);
        this.a = zzcxx.m(zzcxxVar);
        this.f15750d = new zzxz(zzcxx.C(zzcxxVar).f16968f, zzcxx.C(zzcxxVar).f16969g, zzcxx.C(zzcxxVar).f16970h, zzcxx.C(zzcxxVar).f16971i, zzcxx.C(zzcxxVar).f16972j, zzcxx.C(zzcxxVar).f16973k, zzcxx.C(zzcxxVar).l, zzcxx.C(zzcxxVar).m || zzcxx.D(zzcxxVar), zzcxx.C(zzcxxVar).n, zzcxx.C(zzcxxVar).o, zzcxx.C(zzcxxVar).p, zzcxx.C(zzcxxVar).q, zzcxx.C(zzcxxVar).r, zzcxx.C(zzcxxVar).s, zzcxx.C(zzcxxVar).t, zzcxx.C(zzcxxVar).u, zzcxx.C(zzcxxVar).v, zzcxx.C(zzcxxVar).w, zzcxx.C(zzcxxVar).x, zzcxx.C(zzcxxVar).y, zzcxx.C(zzcxxVar).z);
        zzady zzadyVar = null;
        if (zzcxx.E(zzcxxVar) != null) {
            zzacdVar = zzcxx.E(zzcxxVar);
        } else {
            zzacdVar = zzcxx.F(zzcxxVar) != null ? zzcxx.F(zzcxxVar).f13850k : null;
        }
        this.f15748b = zzacdVar;
        this.f15753g = zzcxx.p(zzcxxVar);
        this.f15754h = zzcxx.r(zzcxxVar);
        if (zzcxx.p(zzcxxVar) != null) {
            if (zzcxx.F(zzcxxVar) == null) {
                zzadyVar = new zzady(new NativeAdOptions.Builder().build());
            } else {
                zzadyVar = zzcxx.F(zzcxxVar);
            }
        }
        this.f15755i = zzadyVar;
        this.f15756j = zzcxx.s(zzcxxVar);
        this.f15757k = zzcxx.x(zzcxxVar);
        this.l = zzcxx.y(zzcxxVar);
        this.m = zzcxx.z(zzcxxVar);
        this.n = zzcxx.A(zzcxxVar);
        this.f15749c = zzcxx.B(zzcxxVar);
        this.o = zzcxxVar.p;
    }

    public final zzaga a() {
        PublisherAdViewOptions publisherAdViewOptions = this.m;
        if (publisherAdViewOptions == null) {
            return null;
        }
        return publisherAdViewOptions.zzku();
    }
}
