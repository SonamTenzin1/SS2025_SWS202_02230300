package com.google.android.gms.internal.ads;

import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class zzcvx implements zzcuz<JSONObject> {
    private final JSONObject a;

    public zzcvx(JSONObject jSONObject) {
        this.a = jSONObject;
    }

    @Override // com.google.android.gms.internal.ads.zzcuz
    public final /* synthetic */ void a(JSONObject jSONObject) {
        try {
            JSONObject k2 = zzazc.k(jSONObject, "content_info");
            JSONObject jSONObject2 = this.a;
            Iterator<String> keys = jSONObject2.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                k2.put(next, jSONObject2.get(next));
            }
        } catch (JSONException unused) {
            zzawz.m("Failed putting app indexing json.");
        }
    }
}
