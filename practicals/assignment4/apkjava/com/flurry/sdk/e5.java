package com.flurry.sdk;

import okhttp3.HttpUrl;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class e5 extends q6 {

    /* renamed from: b, reason: collision with root package name */
    public final String f10718b;

    /* renamed from: c, reason: collision with root package name */
    public final String f10719c;

    /* renamed from: d, reason: collision with root package name */
    public final String f10720d;

    /* renamed from: e, reason: collision with root package name */
    public final String f10721e;

    /* renamed from: f, reason: collision with root package name */
    public final int f10722f;

    public e5(String str, String str2, String str3, String str4) {
        this.f10718b = str;
        this.f10719c = str2 == null ? HttpUrl.FRAGMENT_ENCODE_SET : str2;
        this.f10720d = str3;
        this.f10721e = str4;
        this.f10722f = 3;
    }

    private static void b(JSONObject jSONObject, String str, String str2) throws JSONException {
        if (str2 != null) {
            jSONObject.put(str, str2);
        }
    }

    @Override // com.flurry.sdk.q6, com.flurry.sdk.t6
    public final JSONObject a() throws JSONException {
        JSONObject a = super.a();
        b(a, "fl.app.version", this.f10718b);
        b(a, "fl.app.version.override", this.f10719c);
        b(a, "fl.app.version.code", this.f10720d);
        b(a, "fl.bundle.id", this.f10721e);
        a.put("fl.build.environment", this.f10722f);
        return a;
    }
}
