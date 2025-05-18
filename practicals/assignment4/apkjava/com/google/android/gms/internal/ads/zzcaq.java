package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import cm.aptoide.pt.account.AccountAnalytics;
import com.google.android.gms.ads.internal.zzk;
import java.util.List;
import java.util.concurrent.Callable;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class zzcaq {
    private final zzbbl a;

    /* renamed from: b, reason: collision with root package name */
    private final zzcau f14987b;

    /* renamed from: c, reason: collision with root package name */
    private final zzcbd f14988c;

    public zzcaq(zzbbl zzbblVar, zzcau zzcauVar, zzcbd zzcbdVar) {
        this.a = zzbblVar;
        this.f14987b = zzcauVar;
        this.f14988c = zzcbdVar;
    }

    public final zzbbh<zzbyt> a(final zzcxu zzcxuVar, final zzcxm zzcxmVar, final JSONObject jSONObject) {
        zzbbh c2;
        final zzbbh submit = this.a.submit(new Callable(this, zzcxuVar, zzcxmVar, jSONObject) { // from class: com.google.android.gms.internal.ads.lg

            /* renamed from: f, reason: collision with root package name */
            private final zzcaq f12935f;

            /* renamed from: g, reason: collision with root package name */
            private final zzcxu f12936g;

            /* renamed from: h, reason: collision with root package name */
            private final zzcxm f12937h;

            /* renamed from: i, reason: collision with root package name */
            private final JSONObject f12938i;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f12935f = this;
                this.f12936g = zzcxuVar;
                this.f12937h = zzcxmVar;
                this.f12938i = jSONObject;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                zzcxu zzcxuVar2 = this.f12936g;
                zzcxm zzcxmVar2 = this.f12937h;
                JSONObject jSONObject2 = this.f12938i;
                zzbyt zzbytVar = new zzbyt();
                zzbytVar.M(jSONObject2.optInt("template_id", -1));
                zzbytVar.P(jSONObject2.optString("custom_template_id"));
                zzcxv zzcxvVar = zzcxuVar2.a.a;
                if (zzcxvVar.f15753g.contains(Integer.toString(zzbytVar.w()))) {
                    if (zzbytVar.w() == 3) {
                        if (zzbytVar.e() != null) {
                            if (!zzcxvVar.f15754h.contains(zzbytVar.e())) {
                                throw new zzcmw("Unexpected custom template id in the response.", 0);
                            }
                        } else {
                            throw new zzcmw("No custom template id for custom template ad response.", 0);
                        }
                    }
                    zzbytVar.o(jSONObject2.optDouble("rating", -1.0d));
                    String optString = jSONObject2.optString("headline", null);
                    if (zzcxmVar2.E) {
                        zzk.zzlg();
                        String m0 = zzaxi.m0();
                        StringBuilder sb = new StringBuilder(String.valueOf(m0).length() + 3 + String.valueOf(optString).length());
                        sb.append(m0);
                        sb.append(" : ");
                        sb.append(optString);
                        optString = sb.toString();
                    }
                    zzbytVar.T("headline", optString);
                    zzbytVar.T("body", jSONObject2.optString("body", null));
                    zzbytVar.T("call_to_action", jSONObject2.optString("call_to_action", null));
                    zzbytVar.T(AccountAnalytics.STORE, jSONObject2.optString(AccountAnalytics.STORE, null));
                    zzbytVar.T("price", jSONObject2.optString("price", null));
                    zzbytVar.T("advertiser", jSONObject2.optString("advertiser", null));
                    return zzbytVar;
                }
                int w = zzbytVar.w();
                StringBuilder sb2 = new StringBuilder(32);
                sb2.append("Invalid template ID: ");
                sb2.append(w);
                throw new zzcmw(sb2.toString(), 0);
            }
        });
        final zzbbh<List<zzadw>> h2 = this.f14987b.h(jSONObject, "images");
        final zzbbh<zzadw> g2 = this.f14987b.g(jSONObject, "secondary_image");
        final zzbbh<zzadw> g3 = this.f14987b.g(jSONObject, "app_icon");
        final zzbbh<zzadt> i2 = this.f14987b.i(jSONObject, "attribution");
        final zzbbh<zzbgz> n = this.f14987b.n(jSONObject);
        final zzcau zzcauVar = this.f14987b;
        if (!jSONObject.optBoolean("enable_omid")) {
            c2 = zzbar.o(null);
        } else {
            JSONObject optJSONObject = jSONObject.optJSONObject("omid_settings");
            if (optJSONObject == null) {
                c2 = zzbar.o(null);
            } else {
                final String optString = optJSONObject.optString("omid_html");
                if (TextUtils.isEmpty(optString)) {
                    c2 = zzbar.o(null);
                } else {
                    c2 = zzbar.c(zzbar.o(null), new zzbal(zzcauVar, optString) { // from class: com.google.android.gms.internal.ads.qg
                        private final zzcau a;

                        /* renamed from: b, reason: collision with root package name */
                        private final String f13231b;

                        /* JADX INFO: Access modifiers changed from: package-private */
                        {
                            this.a = zzcauVar;
                            this.f13231b = optString;
                        }

                        @Override // com.google.android.gms.internal.ads.zzbal
                        public final zzbbh zzf(Object obj) {
                            return this.a.f(this.f13231b, obj);
                        }
                    }, zzbbm.a);
                }
            }
        }
        final zzbbh zzbbhVar = c2;
        final zzbbh<List<zzcbg>> a = this.f14988c.a(jSONObject, "custom_assets");
        return zzbar.a(submit, h2, g2, g3, i2, n, zzbbhVar, a).a(new Callable(this, submit, h2, g3, g2, i2, jSONObject, n, zzbbhVar, a) { // from class: com.google.android.gms.internal.ads.mg

            /* renamed from: f, reason: collision with root package name */
            private final zzcaq f12982f;

            /* renamed from: g, reason: collision with root package name */
            private final zzbbh f12983g;

            /* renamed from: h, reason: collision with root package name */
            private final zzbbh f12984h;

            /* renamed from: i, reason: collision with root package name */
            private final zzbbh f12985i;

            /* renamed from: j, reason: collision with root package name */
            private final zzbbh f12986j;

            /* renamed from: k, reason: collision with root package name */
            private final zzbbh f12987k;
            private final JSONObject l;
            private final zzbbh m;
            private final zzbbh n;
            private final zzbbh o;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f12982f = this;
                this.f12983g = submit;
                this.f12984h = h2;
                this.f12985i = g3;
                this.f12986j = g2;
                this.f12987k = i2;
                this.l = jSONObject;
                this.m = n;
                this.n = zzbbhVar;
                this.o = a;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.concurrent.Callable
            public final Object call() {
                zzbbh zzbbhVar2 = this.f12983g;
                zzbbh zzbbhVar3 = this.f12984h;
                zzbbh zzbbhVar4 = this.f12985i;
                zzbbh zzbbhVar5 = this.f12986j;
                zzbbh zzbbhVar6 = this.f12987k;
                JSONObject jSONObject2 = this.l;
                zzbbh zzbbhVar7 = this.m;
                zzbbh zzbbhVar8 = this.n;
                zzbbh zzbbhVar9 = this.o;
                zzbyt zzbytVar = (zzbyt) zzbbhVar2.get();
                zzbytVar.n((List) zzbbhVar3.get());
                zzbytVar.u((zzaei) zzbbhVar4.get());
                zzbytVar.L((zzaei) zzbbhVar5.get());
                zzbytVar.t((zzaea) zzbbhVar6.get());
                zzbytVar.N(zzcau.k(jSONObject2));
                zzbytVar.s(zzcau.l(jSONObject2));
                zzbgz zzbgzVar = (zzbgz) zzbbhVar7.get();
                if (zzbgzVar != null) {
                    zzbytVar.R(zzbgzVar);
                    zzbytVar.Z(zzbgzVar.getView());
                    zzbytVar.K(zzbgzVar.h());
                }
                zzbgz zzbgzVar2 = (zzbgz) zzbbhVar8.get();
                if (zzbgzVar2 != null) {
                    zzbytVar.S(zzbgzVar2);
                }
                for (zzcbg zzcbgVar : (List) zzbbhVar9.get()) {
                    int i3 = zzcbgVar.a;
                    if (i3 == 1) {
                        zzbytVar.T(zzcbgVar.f15010b, zzcbgVar.f15011c);
                    } else if (i3 == 2) {
                        zzbytVar.v(zzcbgVar.f15010b, zzcbgVar.f15012d);
                    }
                }
                return zzbytVar;
            }
        }, this.a);
    }
}
