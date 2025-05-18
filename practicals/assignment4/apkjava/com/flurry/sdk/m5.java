package com.flurry.sdk;

import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class m5 extends q6 {

    /* renamed from: b, reason: collision with root package name */
    public boolean f10921b;

    /* renamed from: c, reason: collision with root package name */
    public Map<String, String> f10922c;

    public m5(boolean z, Map<String, String> map) {
        this.f10921b = z;
        this.f10922c = map;
    }

    @Override // com.flurry.sdk.q6, com.flurry.sdk.t6
    public final JSONObject a() throws JSONException {
        JSONObject a = super.a();
        a.put("fl.consent.isGdprScope", this.f10921b);
        JSONObject jSONObject = new JSONObject();
        Map<String, String> map = this.f10922c;
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                jSONObject.put(entry.getKey(), entry.getValue());
            }
        }
        a.put("fl.consent.strings", jSONObject);
        return a;
    }
}
