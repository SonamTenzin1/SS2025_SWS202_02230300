package com.flurry.sdk;

import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class w5 extends q6 {

    /* renamed from: b, reason: collision with root package name */
    public final String f11131b;

    /* renamed from: c, reason: collision with root package name */
    public final List<String> f11132c;

    public w5(String str, List<String> list) {
        this.f11131b = str;
        this.f11132c = list;
    }

    @Override // com.flurry.sdk.q6, com.flurry.sdk.t6
    public final JSONObject a() throws JSONException {
        JSONObject a = super.a();
        JSONArray jSONArray = new JSONArray();
        Iterator<String> it = this.f11132c.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next());
        }
        a.put("fl.launch.options.key", this.f11131b);
        a.put("fl.launch.options.values", jSONArray);
        return a;
    }
}
