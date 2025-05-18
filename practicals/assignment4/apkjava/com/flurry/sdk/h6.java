package com.flurry.sdk;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class h6 extends q6 {

    /* renamed from: b, reason: collision with root package name */
    public final Map<String, List<String>> f10812b;

    public h6(Map<String, List<String>> map) {
        this.f10812b = map == null ? new HashMap<>() : map;
    }

    @Override // com.flurry.sdk.q6, com.flurry.sdk.t6
    public final JSONObject a() throws JSONException {
        JSONObject a = super.a();
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry<String, List<String>> entry : this.f10812b.entrySet()) {
            JSONArray jSONArray = new JSONArray();
            for (String str : entry.getValue()) {
                if (!TextUtils.isEmpty(str)) {
                    jSONArray.put(str);
                }
            }
            if (jSONArray.length() > 0) {
                jSONObject.put(entry.getKey(), jSONArray);
            }
        }
        if (jSONObject.length() > 0) {
            a.put("fl.referrer.map", jSONObject);
        }
        return a;
    }
}
