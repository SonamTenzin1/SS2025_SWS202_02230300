package com.flurry.sdk;

import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class b4 extends q6 {

    /* renamed from: b, reason: collision with root package name */
    public final int f10639b;

    /* renamed from: c, reason: collision with root package name */
    public final String f10640c;

    /* renamed from: d, reason: collision with root package name */
    public final String f10641d;

    /* renamed from: e, reason: collision with root package name */
    public final String f10642e;

    /* renamed from: f, reason: collision with root package name */
    public final String f10643f;

    /* renamed from: g, reason: collision with root package name */
    public final String f10644g;

    /* renamed from: h, reason: collision with root package name */
    public final String f10645h;

    /* renamed from: i, reason: collision with root package name */
    public final int f10646i;

    public b4(int i2, String str, String str2, String str3, String str4, String str5, String str6, int i3) {
        this.a = 2;
        this.f10639b = i2 < 0 ? -1 : i2;
        this.f10640c = str;
        this.f10641d = str2;
        this.f10642e = str3;
        this.f10643f = str4;
        this.f10644g = str5;
        this.f10645h = str6;
        this.f10646i = i3;
    }

    @Override // com.flurry.sdk.q6, com.flurry.sdk.t6
    public final JSONObject a() throws JSONException {
        JSONObject a = super.a();
        a.put("fl.network.status", this.f10639b);
        String str = this.f10640c;
        if (str != null) {
            a.put("fl.cellular.name", str);
            a.put("fl.cellular.operator", this.f10641d);
            a.put("fl.cellular.sim.operator", this.f10642e);
            a.put("fl.cellular.sim.id", this.f10643f);
            a.put("fl.cellular.sim.name", this.f10644g);
            a.put("fl.cellular.band", this.f10645h);
            a.put("fl.cellular.signal.strength", this.f10646i);
        }
        return a;
    }
}
