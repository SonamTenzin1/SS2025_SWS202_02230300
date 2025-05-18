package com.google.android.gms.internal.ads;

import org.json.JSONObject;

/* loaded from: classes2.dex */
final /* synthetic */ class oj implements zzczc {
    static final zzczc a = new oj();

    private oj() {
    }

    @Override // com.google.android.gms.internal.ads.zzczc
    public final Object a(Object obj) {
        JSONObject jSONObject = (JSONObject) obj;
        if (jSONObject.optInt("error_code") == 6) {
            return zzalo.f13956c.a(jSONObject.getJSONObject("response"));
        }
        throw new zzcif(jSONObject.getString("error_reason"), jSONObject.optInt("error_code", 0));
    }
}
