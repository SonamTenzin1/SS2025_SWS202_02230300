package com.facebook.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import cm.aptoide.pt.database.room.RoomNotification;
import com.facebook.GraphRequest;
import com.facebook.internal.b0;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.StringCompanionObject;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: FetchedAppGateKeepersManager.kt */
/* loaded from: classes2.dex */
public final class b0 {
    public static final b0 a = new b0();

    /* renamed from: b, reason: collision with root package name */
    private static final String f9729b = kotlin.jvm.internal.g0.b(b0.class).q();

    /* renamed from: c, reason: collision with root package name */
    private static final AtomicBoolean f9730c = new AtomicBoolean(false);

    /* renamed from: d, reason: collision with root package name */
    private static final ConcurrentLinkedQueue<a> f9731d = new ConcurrentLinkedQueue<>();

    /* renamed from: e, reason: collision with root package name */
    private static final Map<String, JSONObject> f9732e = new ConcurrentHashMap();

    /* renamed from: f, reason: collision with root package name */
    private static Long f9733f;

    /* renamed from: g, reason: collision with root package name */
    private static com.facebook.internal.s0.b f9734g;

    /* compiled from: FetchedAppGateKeepersManager.kt */
    /* loaded from: classes2.dex */
    public interface a {
        void onCompleted();
    }

    private b0() {
    }

    private final JSONObject a(String str) {
        Bundle bundle = new Bundle();
        bundle.putString("platform", "android");
        com.facebook.a0 a0Var = com.facebook.a0.a;
        bundle.putString("sdk_version", com.facebook.a0.s());
        bundle.putString("fields", "gatekeepers");
        GraphRequest.c cVar = GraphRequest.a;
        StringCompanionObject stringCompanionObject = StringCompanionObject.a;
        String format = String.format("app/%s", Arrays.copyOf(new Object[]{"mobile_sdk_gk"}, 1));
        kotlin.jvm.internal.m.e(format, "java.lang.String.format(format, *args)");
        GraphRequest x = cVar.x(null, format, null);
        x.H(bundle);
        JSONObject d2 = x.j().d();
        return d2 == null ? new JSONObject() : d2;
    }

    public static final boolean b(String str, String str2, boolean z) {
        Boolean bool;
        kotlin.jvm.internal.m.f(str, "name");
        Map<String, Boolean> c2 = a.c(str2);
        return (c2.containsKey(str) && (bool = c2.get(str)) != null) ? bool.booleanValue() : z;
    }

    private final boolean d(Long l) {
        return l != null && System.currentTimeMillis() - l.longValue() < 3600000;
    }

    public static final synchronized void h(a aVar) {
        synchronized (b0.class) {
            if (aVar != null) {
                f9731d.add(aVar);
            }
            com.facebook.a0 a0Var = com.facebook.a0.a;
            final String d2 = com.facebook.a0.d();
            b0 b0Var = a;
            if (b0Var.d(f9733f) && f9732e.containsKey(d2)) {
                b0Var.k();
                return;
            }
            final Context c2 = com.facebook.a0.c();
            StringCompanionObject stringCompanionObject = StringCompanionObject.a;
            final String format = String.format("com.facebook.internal.APP_GATEKEEPERS.%s", Arrays.copyOf(new Object[]{d2}, 1));
            kotlin.jvm.internal.m.e(format, "java.lang.String.format(format, *args)");
            if (c2 == null) {
                return;
            }
            JSONObject jSONObject = null;
            String string = c2.getSharedPreferences("com.facebook.internal.preferences.APP_GATEKEEPERS", 0).getString(format, null);
            p0 p0Var = p0.a;
            if (!p0.a0(string)) {
                try {
                    jSONObject = new JSONObject(string);
                } catch (JSONException e2) {
                    p0 p0Var2 = p0.a;
                    p0.i0("FacebookSDK", e2);
                }
                if (jSONObject != null) {
                    j(d2, jSONObject);
                }
            }
            com.facebook.a0 a0Var2 = com.facebook.a0.a;
            Executor k2 = com.facebook.a0.k();
            if (k2 == null) {
                return;
            }
            if (f9730c.compareAndSet(false, true)) {
                k2.execute(new Runnable() { // from class: com.facebook.internal.e
                    @Override // java.lang.Runnable
                    public final void run() {
                        b0.i(d2, c2, format);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(String str, Context context, String str2) {
        kotlin.jvm.internal.m.f(str, "$applicationId");
        kotlin.jvm.internal.m.f(context, "$context");
        kotlin.jvm.internal.m.f(str2, "$gateKeepersKey");
        b0 b0Var = a;
        JSONObject a2 = b0Var.a(str);
        if (a2.length() != 0) {
            j(str, a2);
            context.getSharedPreferences("com.facebook.internal.preferences.APP_GATEKEEPERS", 0).edit().putString(str2, a2.toString()).apply();
            f9733f = Long.valueOf(System.currentTimeMillis());
        }
        b0Var.k();
        f9730c.set(false);
    }

    public static final synchronized JSONObject j(String str, JSONObject jSONObject) {
        JSONObject jSONObject2;
        JSONArray optJSONArray;
        synchronized (b0.class) {
            kotlin.jvm.internal.m.f(str, "applicationId");
            jSONObject2 = f9732e.get(str);
            if (jSONObject2 == null) {
                jSONObject2 = new JSONObject();
            }
            int i2 = 0;
            JSONObject jSONObject3 = null;
            if (jSONObject != null && (optJSONArray = jSONObject.optJSONArray("data")) != null) {
                jSONObject3 = optJSONArray.optJSONObject(0);
            }
            if (jSONObject3 == null) {
                jSONObject3 = new JSONObject();
            }
            JSONArray optJSONArray2 = jSONObject3.optJSONArray("gatekeepers");
            if (optJSONArray2 == null) {
                optJSONArray2 = new JSONArray();
            }
            int length = optJSONArray2.length();
            if (length > 0) {
                while (true) {
                    int i3 = i2 + 1;
                    try {
                        JSONObject jSONObject4 = optJSONArray2.getJSONObject(i2);
                        jSONObject2.put(jSONObject4.getString(RoomNotification.KEY), jSONObject4.getBoolean("value"));
                    } catch (JSONException e2) {
                        p0 p0Var = p0.a;
                        p0.i0("FacebookSDK", e2);
                    }
                    if (i3 >= length) {
                        break;
                    }
                    i2 = i3;
                }
            }
            f9732e.put(str, jSONObject2);
        }
        return jSONObject2;
    }

    private final void k() {
        Handler handler = new Handler(Looper.getMainLooper());
        while (true) {
            ConcurrentLinkedQueue<a> concurrentLinkedQueue = f9731d;
            if (concurrentLinkedQueue.isEmpty()) {
                return;
            }
            final a poll = concurrentLinkedQueue.poll();
            if (poll != null) {
                handler.post(new Runnable() { // from class: com.facebook.internal.d
                    @Override // java.lang.Runnable
                    public final void run() {
                        b0.l(b0.a.this);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(a aVar) {
        aVar.onCompleted();
    }

    public static final JSONObject m(String str, boolean z) {
        kotlin.jvm.internal.m.f(str, "applicationId");
        if (!z) {
            Map<String, JSONObject> map = f9732e;
            if (map.containsKey(str)) {
                JSONObject jSONObject = map.get(str);
                return jSONObject == null ? new JSONObject() : jSONObject;
            }
        }
        JSONObject a2 = a.a(str);
        com.facebook.a0 a0Var = com.facebook.a0.a;
        Context c2 = com.facebook.a0.c();
        StringCompanionObject stringCompanionObject = StringCompanionObject.a;
        String format = String.format("com.facebook.internal.APP_GATEKEEPERS.%s", Arrays.copyOf(new Object[]{str}, 1));
        kotlin.jvm.internal.m.e(format, "java.lang.String.format(format, *args)");
        c2.getSharedPreferences("com.facebook.internal.preferences.APP_GATEKEEPERS", 0).edit().putString(format, a2.toString()).apply();
        return j(str, a2);
    }

    public final Map<String, Boolean> c(String str) {
        g();
        if (str != null) {
            Map<String, JSONObject> map = f9732e;
            if (map.containsKey(str)) {
                com.facebook.internal.s0.b bVar = f9734g;
                List<com.facebook.internal.s0.a> a2 = bVar == null ? null : bVar.a(str);
                if (a2 != null) {
                    HashMap hashMap = new HashMap();
                    for (com.facebook.internal.s0.a aVar : a2) {
                        hashMap.put(aVar.a(), Boolean.valueOf(aVar.b()));
                    }
                    return hashMap;
                }
                HashMap hashMap2 = new HashMap();
                JSONObject jSONObject = map.get(str);
                if (jSONObject == null) {
                    jSONObject = new JSONObject();
                }
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    kotlin.jvm.internal.m.e(next, RoomNotification.KEY);
                    hashMap2.put(next, Boolean.valueOf(jSONObject.optBoolean(next)));
                }
                com.facebook.internal.s0.b bVar2 = f9734g;
                if (bVar2 == null) {
                    bVar2 = new com.facebook.internal.s0.b();
                }
                ArrayList arrayList = new ArrayList(hashMap2.size());
                for (Map.Entry entry : hashMap2.entrySet()) {
                    arrayList.add(new com.facebook.internal.s0.a((String) entry.getKey(), ((Boolean) entry.getValue()).booleanValue()));
                }
                bVar2.b(str, arrayList);
                f9734g = bVar2;
                return hashMap2;
            }
        }
        return new HashMap();
    }

    public final void g() {
        h(null);
    }
}
