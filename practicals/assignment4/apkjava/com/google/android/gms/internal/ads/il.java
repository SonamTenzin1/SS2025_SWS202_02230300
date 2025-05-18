package com.google.android.gms.internal.ads;

import cm.aptoide.pt.install.installer.RootCommandOnSubscribe;
import cm.aptoide.pt.networking.BodyInterceptorV3;
import org.json.JSONObject;

/* loaded from: classes2.dex */
final /* synthetic */ class il implements zzbal {
    static final zzbal a = new il();

    private il() {
    }

    @Override // com.google.android.gms.internal.ads.zzbal
    public final zzbbh zzf(Object obj) {
        JSONObject jSONObject = (JSONObject) obj;
        if (jSONObject.optBoolean(RootCommandOnSubscribe.SUCCESS_OUTPUT_CONFIRMATION)) {
            return zzbar.o(jSONObject.getJSONObject(BodyInterceptorV3.RESPONSE_MODE_JSON).getJSONArray("ads"));
        }
        throw new zzali("process json failed");
    }
}
