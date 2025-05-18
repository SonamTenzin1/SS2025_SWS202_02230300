package com.flurry.sdk;

import android.text.TextUtils;
import okhttp3.HttpUrl;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class l4 extends q6 {

    /* renamed from: b, reason: collision with root package name */
    public final String f10895b;

    public l4(String str) {
        this.f10895b = str == null ? HttpUrl.FRAGMENT_ENCODE_SET : str;
    }

    @Override // com.flurry.sdk.q6, com.flurry.sdk.t6
    public final JSONObject a() throws JSONException {
        JSONObject a = super.a();
        if (!TextUtils.isEmpty(this.f10895b)) {
            a.put("fl.timezone.value", this.f10895b);
        }
        return a;
    }
}
