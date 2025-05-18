package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzk;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class zzcxg implements zzcuz<JSONObject> {
    private final Map<String, Object> a;

    public zzcxg(Map<String, Object> map) {
        this.a = map;
    }

    @Override // com.google.android.gms.internal.ads.zzcuz
    public final /* synthetic */ void a(JSONObject jSONObject) {
        try {
            jSONObject.put("video_decoders", zzk.zzlg().Y(this.a));
        } catch (JSONException e2) {
            String valueOf = String.valueOf(e2.getMessage());
            zzawz.m(valueOf.length() != 0 ? "Could not encode video decoder properties: ".concat(valueOf) : new String("Could not encode video decoder properties: "));
        }
    }
}
