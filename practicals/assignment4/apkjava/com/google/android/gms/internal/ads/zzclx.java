package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class zzclx implements zzclw<zzbyn> {
    private final zzbxo a;

    /* renamed from: b, reason: collision with root package name */
    private final zzbbl f15377b;

    /* renamed from: c, reason: collision with root package name */
    private final zzcaq f15378c;

    public zzclx(zzbxo zzbxoVar, zzbbl zzbblVar, zzcaq zzcaqVar) {
        this.a = zzbxoVar;
        this.f15377b = zzbblVar;
        this.f15378c = zzcaqVar;
    }

    private final zzbbh<zzbyn> f(final zzcxu zzcxuVar, final zzcxm zzcxmVar, final JSONObject jSONObject) {
        final zzbbh<zzccj> b2 = this.a.f().b();
        final zzbbh<zzbyt> a = this.f15378c.a(zzcxuVar, zzcxmVar, jSONObject);
        return zzbar.a(b2, a).a(new Callable(this, a, b2, zzcxuVar, zzcxmVar, jSONObject) { // from class: com.google.android.gms.internal.ads.kl

            /* renamed from: f, reason: collision with root package name */
            private final zzclx f12886f;

            /* renamed from: g, reason: collision with root package name */
            private final zzbbh f12887g;

            /* renamed from: h, reason: collision with root package name */
            private final zzbbh f12888h;

            /* renamed from: i, reason: collision with root package name */
            private final zzcxu f12889i;

            /* renamed from: j, reason: collision with root package name */
            private final zzcxm f12890j;

            /* renamed from: k, reason: collision with root package name */
            private final JSONObject f12891k;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f12886f = this;
                this.f12887g = a;
                this.f12888h = b2;
                this.f12889i = zzcxuVar;
                this.f12890j = zzcxmVar;
                this.f12891k = jSONObject;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f12886f.e(this.f12887g, this.f12888h, this.f12889i, this.f12890j, this.f12891k);
            }
        }, this.f15377b);
    }

    @Override // com.google.android.gms.internal.ads.zzcjv
    public final zzbbh<List<zzbbh<zzbyn>>> a(final zzcxu zzcxuVar, final zzcxm zzcxmVar) {
        zzbbh<zzccj> b2 = this.a.f().b();
        this.a.f().a(b2);
        return zzbar.c(zzbar.c(b2, new zzbal(this, zzcxmVar) { // from class: com.google.android.gms.internal.ads.fl
            private final zzclx a;

            /* renamed from: b, reason: collision with root package name */
            private final zzcxm f12595b;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.a = this;
                this.f12595b = zzcxmVar;
            }

            @Override // com.google.android.gms.internal.ads.zzbal
            public final zzbbh zzf(Object obj) {
                return this.a.c(this.f12595b, (zzccj) obj);
            }
        }, this.f15377b), new zzbal(this, zzcxuVar, zzcxmVar) { // from class: com.google.android.gms.internal.ads.gl
            private final zzclx a;

            /* renamed from: b, reason: collision with root package name */
            private final zzcxu f12653b;

            /* renamed from: c, reason: collision with root package name */
            private final zzcxm f12654c;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.a = this;
                this.f12653b = zzcxuVar;
                this.f12654c = zzcxmVar;
            }

            @Override // com.google.android.gms.internal.ads.zzbal
            public final zzbbh zzf(Object obj) {
                return this.a.d(this.f12653b, this.f12654c, (JSONArray) obj);
            }
        }, this.f15377b);
    }

    @Override // com.google.android.gms.internal.ads.zzcjv
    public final boolean b(zzcxu zzcxuVar, zzcxm zzcxmVar) {
        zzcxq zzcxqVar = zzcxmVar.p;
        return (zzcxqVar == null || zzcxqVar.f15742c == null) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzbbh c(zzcxm zzcxmVar, zzccj zzccjVar) throws Exception {
        JSONObject d2 = zzazc.d("isNonagon", Boolean.TRUE);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("response", zzcxmVar.p.f15742c);
        jSONObject.put("sdk_params", d2);
        return zzbar.c(zzccjVar.i("google.afma.nativeAds.preProcessJson", jSONObject), il.a, this.f15377b);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzbbh d(zzcxu zzcxuVar, zzcxm zzcxmVar, JSONArray jSONArray) throws Exception {
        if (jSONArray.length() == 0) {
            return zzbar.l(new zzcgm(3));
        }
        if (zzcxuVar.a.a.l > 1) {
            int length = jSONArray.length();
            this.a.f().c(Math.min(length, zzcxuVar.a.a.l));
            ArrayList arrayList = new ArrayList(zzcxuVar.a.a.l);
            for (int i2 = 0; i2 < zzcxuVar.a.a.l; i2++) {
                if (i2 < length) {
                    arrayList.add(f(zzcxuVar, zzcxmVar, jSONArray.getJSONObject(i2)));
                } else {
                    arrayList.add(zzbar.l(new zzcgm(3)));
                }
            }
            return zzbar.o(arrayList);
        }
        return zzbar.d(f(zzcxuVar, zzcxmVar, jSONArray.getJSONObject(0)), jl.a, this.f15377b);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public final /* synthetic */ zzbyn e(zzbbh zzbbhVar, zzbbh zzbbhVar2, zzcxu zzcxuVar, zzcxm zzcxmVar, JSONObject jSONObject) throws Exception {
        zzbyt zzbytVar = (zzbyt) zzbbhVar.get();
        zzccj zzccjVar = (zzccj) zzbbhVar2.get();
        zzbyv a = this.a.a(new zzbpr(zzcxuVar, zzcxmVar, null), new zzbzf(zzbytVar), new zzbyc(jSONObject, zzccjVar));
        a.h().b();
        a.i().a(zzccjVar);
        a.j().c(zzbytVar.A());
        return a.g();
    }
}
