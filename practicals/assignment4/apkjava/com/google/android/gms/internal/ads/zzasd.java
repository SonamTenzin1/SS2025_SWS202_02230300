package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.List;
import org.json.JSONObject;

@zzard
/* loaded from: classes2.dex */
public final class zzasd {
    private final List<String> a;

    /* renamed from: b, reason: collision with root package name */
    private final String f14111b;

    /* renamed from: c, reason: collision with root package name */
    private final String f14112c;

    /* renamed from: d, reason: collision with root package name */
    private final String f14113d;

    /* renamed from: e, reason: collision with root package name */
    private final boolean f14114e;

    /* renamed from: f, reason: collision with root package name */
    private final String f14115f;

    /* renamed from: g, reason: collision with root package name */
    private final String f14116g;

    /* renamed from: h, reason: collision with root package name */
    private String f14117h;

    /* renamed from: i, reason: collision with root package name */
    private final int f14118i;

    /* renamed from: j, reason: collision with root package name */
    private final boolean f14119j;

    /* renamed from: k, reason: collision with root package name */
    private final JSONObject f14120k;
    private final String l;
    private final boolean m;

    public zzasd(JSONObject jSONObject) {
        this.f14117h = jSONObject.optString("url");
        this.f14111b = jSONObject.optString("base_uri");
        this.f14112c = jSONObject.optString("post_parameters");
        String optString = jSONObject.optString("drt_include");
        this.f14114e = optString != null && (optString.equals("1") || optString.equals("true"));
        this.f14115f = jSONObject.optString("request_id");
        this.f14113d = jSONObject.optString("type");
        String optString2 = jSONObject.optString("errors");
        this.a = optString2 == null ? null : Arrays.asList(optString2.split(","));
        this.f14118i = jSONObject.optInt("valid", 0) == 1 ? -2 : 1;
        this.f14116g = jSONObject.optString("fetched_ad");
        this.f14119j = jSONObject.optBoolean("render_test_ad_label");
        JSONObject optJSONObject = jSONObject.optJSONObject("preprocessor_flags");
        this.f14120k = optJSONObject == null ? new JSONObject() : optJSONObject;
        this.l = jSONObject.optString("analytics_query_ad_event_id");
        this.m = jSONObject.optBoolean("is_analytics_logging_enabled");
    }

    public final String a() {
        return this.f14117h;
    }

    public final String b() {
        return this.f14111b;
    }

    public final String c() {
        return this.f14112c;
    }

    public final boolean d() {
        return this.f14114e;
    }

    public final JSONObject e() {
        return this.f14120k;
    }
}
