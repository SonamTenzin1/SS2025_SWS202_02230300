package com.flurry.sdk;

import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class c6 extends q6 {

    /* renamed from: b, reason: collision with root package name */
    public final String f10676b;

    /* renamed from: c, reason: collision with root package name */
    public final Map<String, String> f10677c;

    public c6(String str, Map<String, String> map) {
        this.f10676b = str;
        this.f10677c = map == null ? new HashMap<>() : map;
    }

    @Override // com.flurry.sdk.q6, com.flurry.sdk.t6
    public final JSONObject a() throws JSONException {
        JSONObject a = super.a();
        JSONObject a2 = e2.a(this.f10677c);
        a.put("fl.origin.attribute.name", this.f10676b);
        a.put("fl.origin.attribute.parameters", a2);
        return a;
    }
}
