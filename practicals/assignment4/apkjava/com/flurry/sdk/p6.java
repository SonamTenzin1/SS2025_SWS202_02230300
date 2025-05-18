package com.flurry.sdk;

import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class p6 extends q6 {

    /* renamed from: b, reason: collision with root package name */
    public final int f10995b;

    /* renamed from: c, reason: collision with root package name */
    public final long f10996c;

    /* renamed from: d, reason: collision with root package name */
    public final String f10997d;

    /* renamed from: e, reason: collision with root package name */
    public final List<String> f10998e;

    /* renamed from: f, reason: collision with root package name */
    public final a f10999f;

    /* loaded from: classes2.dex */
    public enum a {
        Set(1),
        Add(2),
        Remove(3),
        Clear(4),
        Assign(5),
        Flag(6),
        Unknown(0);

        private final int n;

        a(int i2) {
            this.n = i2;
        }
    }

    public p6(int i2, long j2, String str, List<String> list, a aVar) {
        this.f10995b = i2;
        this.f10996c = j2;
        this.f10997d = str;
        this.f10998e = list;
        this.f10999f = aVar;
    }

    @Override // com.flurry.sdk.q6, com.flurry.sdk.t6
    public final JSONObject a() throws JSONException {
        JSONObject a2 = super.a();
        a2.put("fl.user.property.id", this.f10995b);
        a2.put("fl.user.property.uptime", this.f10996c);
        a2.put("fl.user.property.key", this.f10997d);
        List<String> list = this.f10998e;
        JSONArray jSONArray = new JSONArray();
        if (list != null && !list.isEmpty()) {
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                jSONArray.put(it.next());
            }
        }
        a2.put("fl.user.property.values", jSONArray);
        a2.put("fl.user.property.call.type", this.f10999f.n);
        return a2;
    }
}
