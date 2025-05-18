package com.flurry.sdk;

import com.flurry.sdk.d;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class n6 extends q6 {

    /* renamed from: b, reason: collision with root package name */
    public final int f10945b = 3;

    /* renamed from: c, reason: collision with root package name */
    public final int f10946c = 328;

    /* renamed from: d, reason: collision with root package name */
    public final String f10947d;

    /* renamed from: e, reason: collision with root package name */
    public final int f10948e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f10949f;

    /* renamed from: g, reason: collision with root package name */
    public final d.EnumC0160d f10950g;

    public n6(String str, int i2, boolean z, d.EnumC0160d enumC0160d) {
        this.f10947d = str;
        this.f10948e = i2;
        this.f10949f = z;
        this.f10950g = enumC0160d;
    }

    @Override // com.flurry.sdk.q6, com.flurry.sdk.t6
    public final JSONObject a() throws JSONException {
        JSONObject a = super.a();
        a.put("fl.agent.version", this.f10946c);
        a.put("fl.agent.platform", this.f10945b);
        a.put("fl.apikey", this.f10947d);
        a.put("fl.agent.report.key", this.f10948e);
        a.put("fl.background.session.metrics", this.f10949f);
        a.put("fl.play.service.availability", this.f10950g.o);
        return a;
    }
}
