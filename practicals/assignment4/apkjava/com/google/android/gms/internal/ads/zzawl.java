package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import cm.aptoide.pt.reviews.RateAndReviewsFragment;
import com.google.android.gms.ads.internal.zzk;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@zzard
/* loaded from: classes2.dex */
public final class zzawl {
    private final long a;

    /* renamed from: b, reason: collision with root package name */
    private final List<String> f14210b = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    private final List<String> f14211c = new ArrayList();

    /* renamed from: d, reason: collision with root package name */
    private final Map<String, zzamm> f14212d = new HashMap();

    /* renamed from: e, reason: collision with root package name */
    private String f14213e;

    /* renamed from: f, reason: collision with root package name */
    private String f14214f;

    /* renamed from: g, reason: collision with root package name */
    private JSONObject f14215g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f14216h;

    public zzawl(String str, long j2) {
        JSONObject optJSONObject;
        this.f14216h = false;
        this.f14214f = str;
        this.a = j2;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.f14215g = jSONObject;
            if (jSONObject.optInt("status", -1) != 1) {
                this.f14216h = false;
                zzbad.i("App settings could not be fetched successfully.");
                return;
            }
            this.f14216h = true;
            this.f14213e = this.f14215g.optString(RateAndReviewsFragment.BundleCons.APP_ID);
            JSONArray optJSONArray = this.f14215g.optJSONArray("ad_unit_id_settings");
            if (optJSONArray != null) {
                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i2);
                    String optString = jSONObject2.optString("format");
                    String optString2 = jSONObject2.optString("ad_unit_id");
                    if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2)) {
                        if ("interstitial".equalsIgnoreCase(optString)) {
                            this.f14211c.add(optString2);
                        } else if ("rewarded".equalsIgnoreCase(optString) && (optJSONObject = jSONObject2.optJSONObject("mediation_config")) != null) {
                            this.f14212d.put(optString2, new zzamm(optJSONObject));
                        }
                    }
                }
            }
            JSONArray optJSONArray2 = this.f14215g.optJSONArray("persistable_banner_ad_unit_ids");
            if (optJSONArray2 != null) {
                for (int i3 = 0; i3 < optJSONArray2.length(); i3++) {
                    this.f14210b.add(optJSONArray2.optString(i3));
                }
            }
        } catch (JSONException e2) {
            zzbad.d("Exception occurred while processing app setting json", e2);
            zzk.zzlk().e(e2, "AppSettings.parseAppSettingsJson");
        }
    }

    public final long a() {
        return this.a;
    }

    public final boolean b() {
        return this.f14216h;
    }

    public final String c() {
        return this.f14214f;
    }

    public final String d() {
        return this.f14213e;
    }

    public final Map<String, zzamm> e() {
        return this.f14212d;
    }

    public final JSONObject f() {
        return this.f14215g;
    }
}
