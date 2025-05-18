package com.flurry.sdk;

import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class i5 extends q6 {

    /* renamed from: b, reason: collision with root package name */
    public final int f10833b;

    /* renamed from: c, reason: collision with root package name */
    public final int f10834c;

    public i5(int i2, int i3) {
        this.f10834c = i2 < 0 ? g7.UNKNOWN.f10800j : i2;
        this.f10833b = i3 < 0 ? g7.UNKNOWN.f10800j : i3;
    }

    @Override // com.flurry.sdk.q6, com.flurry.sdk.t6
    public final JSONObject a() throws JSONException {
        JSONObject a = super.a();
        a.put("fl.app.current.state", this.f10833b);
        a.put("fl.app.previous.state", this.f10834c);
        return a;
    }
}
