package com.flurry.sdk;

import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class q5 extends q6 {

    /* renamed from: b, reason: collision with root package name */
    public final boolean f11023b = true;

    /* renamed from: c, reason: collision with root package name */
    public final String f11024c;

    public q5(String str) {
        this.f11024c = str;
    }

    @Override // com.flurry.sdk.q6, com.flurry.sdk.t6
    public final JSONObject a() throws JSONException {
        JSONObject a = super.a();
        a.put("fl.background.enabled", this.f11023b);
        a.put("fl.sdk.version.code", this.f11024c);
        return a;
    }
}
