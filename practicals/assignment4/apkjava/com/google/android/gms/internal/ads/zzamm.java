package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzk;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@zzard
/* loaded from: classes2.dex */
public final class zzamm {
    public final List<zzaml> a;

    /* renamed from: b, reason: collision with root package name */
    private final long f13978b;

    /* renamed from: c, reason: collision with root package name */
    private final List<String> f13979c;

    /* renamed from: d, reason: collision with root package name */
    private final List<String> f13980d;

    /* renamed from: e, reason: collision with root package name */
    private final List<String> f13981e;

    /* renamed from: f, reason: collision with root package name */
    private final List<String> f13982f;

    /* renamed from: g, reason: collision with root package name */
    private final List<String> f13983g;

    /* renamed from: h, reason: collision with root package name */
    private final boolean f13984h;

    /* renamed from: i, reason: collision with root package name */
    private final String f13985i;

    /* renamed from: j, reason: collision with root package name */
    private final long f13986j;

    /* renamed from: k, reason: collision with root package name */
    private final String f13987k;
    private final int l;
    private final int m;
    private final long n;
    private final boolean o;
    private final boolean p;
    private final boolean q;
    private final boolean r;
    private int s;
    private int t;
    private boolean u;

    public zzamm(JSONObject jSONObject) throws JSONException {
        if (zzbad.a(2)) {
            String valueOf = String.valueOf(jSONObject.toString(2));
            zzawz.m(valueOf.length() != 0 ? "Mediation Response JSON: ".concat(valueOf) : new String("Mediation Response JSON: "));
        }
        JSONArray jSONArray = jSONObject.getJSONArray("ad_networks");
        ArrayList arrayList = new ArrayList(jSONArray.length());
        int i2 = -1;
        for (int i3 = 0; i3 < jSONArray.length(); i3++) {
            try {
                zzaml zzamlVar = new zzaml(jSONArray.getJSONObject(i3));
                boolean z = true;
                if ("banner".equalsIgnoreCase(zzamlVar.v)) {
                    this.u = true;
                }
                arrayList.add(zzamlVar);
                if (i2 < 0) {
                    Iterator<String> it = zzamlVar.f13969c.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            if (it.next().equals("com.google.ads.mediation.admob.AdMobAdapter")) {
                                break;
                            }
                        } else {
                            z = false;
                            break;
                        }
                    }
                    if (z) {
                        i2 = i3;
                    }
                }
            } catch (JSONException unused) {
            }
        }
        this.s = i2;
        this.t = jSONArray.length();
        this.a = Collections.unmodifiableList(arrayList);
        this.f13985i = jSONObject.optString("qdata");
        this.m = jSONObject.optInt("fs_model_type", -1);
        this.n = jSONObject.optLong("timeout_ms", -1L);
        JSONObject optJSONObject = jSONObject.optJSONObject("settings");
        if (optJSONObject != null) {
            this.f13978b = optJSONObject.optLong("ad_network_timeout_millis", -1L);
            zzk.zzly();
            this.f13979c = zzamn.a(optJSONObject, "click_urls");
            zzk.zzly();
            this.f13980d = zzamn.a(optJSONObject, "imp_urls");
            zzk.zzly();
            this.f13981e = zzamn.a(optJSONObject, "downloaded_imp_urls");
            zzk.zzly();
            this.f13982f = zzamn.a(optJSONObject, "nofill_urls");
            zzk.zzly();
            this.f13983g = zzamn.a(optJSONObject, "remote_ping_urls");
            this.f13984h = optJSONObject.optBoolean("render_in_browser", false);
            long optLong = optJSONObject.optLong("refresh", -1L);
            this.f13986j = optLong > 0 ? 1000 * optLong : -1L;
            zzato y = zzato.y(optJSONObject.optJSONArray("rewards"));
            if (y == null) {
                this.f13987k = null;
                this.l = 0;
            } else {
                this.f13987k = y.f14157f;
                this.l = y.f14158g;
            }
            this.o = optJSONObject.optBoolean("use_displayed_impression", false);
            this.p = optJSONObject.optBoolean("allow_pub_rendered_attribution", false);
            this.q = optJSONObject.optBoolean("allow_pub_owned_ad_view", false);
            this.r = optJSONObject.optBoolean("allow_custom_click_gesture", false);
            return;
        }
        this.f13978b = -1L;
        this.f13979c = null;
        this.f13980d = null;
        this.f13981e = null;
        this.f13982f = null;
        this.f13983g = null;
        this.f13986j = -1L;
        this.f13987k = null;
        this.l = 0;
        this.o = false;
        this.f13984h = false;
        this.p = false;
        this.q = false;
        this.r = false;
    }
}
