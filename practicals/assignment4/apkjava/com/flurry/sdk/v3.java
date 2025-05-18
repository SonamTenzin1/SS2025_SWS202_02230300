package com.flurry.sdk;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class v3 extends q6 {

    /* renamed from: b, reason: collision with root package name */
    public final String f11097b;

    /* renamed from: c, reason: collision with root package name */
    public int f11098c;

    /* renamed from: d, reason: collision with root package name */
    public final a f11099d;

    /* renamed from: e, reason: collision with root package name */
    public final Map<String, String> f11100e;

    /* renamed from: f, reason: collision with root package name */
    public final Map<String, String> f11101f;

    /* renamed from: g, reason: collision with root package name */
    public final boolean f11102g;

    /* renamed from: h, reason: collision with root package name */
    public final boolean f11103h;

    /* renamed from: i, reason: collision with root package name */
    public final long f11104i;

    /* renamed from: j, reason: collision with root package name */
    public final long f11105j;

    /* renamed from: k, reason: collision with root package name */
    public long f11106k;

    /* loaded from: classes2.dex */
    public enum a {
        UNKNOWN(0),
        CUSTOM(1),
        PURCHASE(8),
        MESSAGE(9),
        USER_STANDARD(10),
        PERFORMANCE(1),
        SDK_LOG(1);

        final int n;

        a(int i2) {
            this.n = i2;
        }
    }

    public v3(String str, int i2, a aVar, Map<String, String> map, Map<String, String> map2, boolean z, boolean z2, long j2, long j3, long j4) {
        this.a = 2;
        this.f11097b = str;
        this.f11098c = i2;
        this.f11099d = aVar;
        this.f11100e = map;
        this.f11101f = map2;
        this.f11102g = z;
        this.f11103h = z2;
        this.f11104i = j2;
        this.f11105j = j3;
        this.f11106k = j4;
    }

    private static Map<String, String> b(Map<String, String> map, List<String> list) {
        String h2;
        String value;
        HashMap hashMap = new HashMap();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (!list.contains(entry.getKey())) {
                h2 = c2.h(entry.getKey());
                value = c2.h(entry.getValue());
            } else {
                h2 = c2.h(entry.getKey());
                value = entry.getValue();
            }
            if (!TextUtils.isEmpty(h2)) {
                hashMap.put(h2, value);
            }
        }
        return hashMap;
    }

    @Override // com.flurry.sdk.q6, com.flurry.sdk.t6
    public final JSONObject a() throws JSONException {
        JSONObject a2 = super.a();
        a2.put("fl.event.name", this.f11097b);
        a2.put("fl.event.id", this.f11098c);
        a2.put("fl.event.type", this.f11099d.n);
        a2.put("fl.event.timed", this.f11102g);
        a2.put("fl.timed.event.starting", this.f11103h);
        long j2 = this.f11106k;
        if (j2 > 0) {
            a2.put("fl.timed.event.duration", j2);
        }
        a2.put("fl.event.timestamp", this.f11104i);
        a2.put("fl.event.uptime", this.f11105j);
        a2.put("fl.event.user.parameters", e2.a(this.f11100e));
        a2.put("fl.event.flurry.parameters", e2.a(this.f11101f));
        return a2;
    }

    public v3(String str, int i2, a aVar, Map<String, String> map, Map<String, String> map2, List<String> list, boolean z, boolean z2, long j2, long j3) {
        this(c2.h(c2.b(str)), i2, aVar, (Map<String, String>) (map != null ? b(map, list) : new HashMap()), (Map<String, String>) (map2 != null ? b(map2, list) : new HashMap()), z, z2, j2, j3, 0L);
    }
}
