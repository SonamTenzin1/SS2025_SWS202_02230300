package com.facebook.o0.t0;

import android.util.Log;
import cm.aptoide.pt.database.room.RoomNotification;
import com.facebook.a0;
import com.facebook.internal.c0;
import com.facebook.internal.d0;
import com.facebook.internal.p0;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.jvm.internal.m;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: RestrictiveDataManager.kt */
/* loaded from: classes2.dex */
public final class a {

    /* renamed from: b, reason: collision with root package name */
    private static boolean f10498b;
    public static final a a = new a();

    /* renamed from: c, reason: collision with root package name */
    private static final String f10499c = a.class.getCanonicalName();

    /* renamed from: d, reason: collision with root package name */
    private static final List<C0151a> f10500d = new ArrayList();

    /* renamed from: e, reason: collision with root package name */
    private static final Set<String> f10501e = new CopyOnWriteArraySet();

    /* compiled from: RestrictiveDataManager.kt */
    /* renamed from: com.facebook.o0.t0.a$a, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class C0151a {
        private String a;

        /* renamed from: b, reason: collision with root package name */
        private Map<String, String> f10502b;

        public C0151a(String str, Map<String, String> map) {
            m.f(str, "eventName");
            m.f(map, "restrictiveParams");
            this.a = str;
            this.f10502b = map;
        }

        public final String a() {
            return this.a;
        }

        public final Map<String, String> b() {
            return this.f10502b;
        }

        public final void c(Map<String, String> map) {
            m.f(map, "<set-?>");
            this.f10502b = map;
        }
    }

    private a() {
    }

    public static final void a() {
        a aVar = a;
        f10498b = true;
        aVar.c();
    }

    private final String b(String str, String str2) {
        try {
            for (C0151a c0151a : new ArrayList(f10500d)) {
                if (c0151a != null && m.a(str, c0151a.a())) {
                    for (String str3 : c0151a.b().keySet()) {
                        if (m.a(str2, str3)) {
                            return c0151a.b().get(str3);
                        }
                    }
                }
            }
            return null;
        } catch (Exception e2) {
            Log.w(f10499c, "getMatchedRuleType failed", e2);
            return null;
        }
    }

    private final void c() {
        String i2;
        try {
            d0 d0Var = d0.a;
            a0 a0Var = a0.a;
            c0 o = d0.o(a0.d(), false);
            if (o == null || (i2 = o.i()) == null) {
                return;
            }
            if (i2.length() == 0) {
                return;
            }
            JSONObject jSONObject = new JSONObject(i2);
            f10500d.clear();
            f10501e.clear();
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                JSONObject jSONObject2 = jSONObject.getJSONObject(next);
                if (jSONObject2 != null) {
                    JSONObject optJSONObject = jSONObject2.optJSONObject("restrictive_param");
                    m.e(next, RoomNotification.KEY);
                    C0151a c0151a = new C0151a(next, new HashMap());
                    if (optJSONObject != null) {
                        p0 p0Var = p0.a;
                        c0151a.c(p0.m(optJSONObject));
                        f10500d.add(c0151a);
                    }
                    if (jSONObject2.has("process_event_name")) {
                        f10501e.add(c0151a.a());
                    }
                }
            }
        } catch (Exception unused) {
        }
    }

    private final boolean d(String str) {
        return f10501e.contains(str);
    }

    public static final String e(String str) {
        m.f(str, "eventName");
        return (f10498b && a.d(str)) ? "_removed_" : str;
    }

    public static final void f(Map<String, String> map, String str) {
        m.f(map, "parameters");
        m.f(str, "eventName");
        if (f10498b) {
            HashMap hashMap = new HashMap();
            for (String str2 : new ArrayList(map.keySet())) {
                String b2 = a.b(str, str2);
                if (b2 != null) {
                    hashMap.put(str2, b2);
                    map.remove(str2);
                }
            }
            if (!hashMap.isEmpty()) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    for (Map.Entry entry : hashMap.entrySet()) {
                        jSONObject.put((String) entry.getKey(), (String) entry.getValue());
                    }
                    map.put("_restrictedParams", jSONObject.toString());
                } catch (JSONException unused) {
                }
            }
        }
    }
}
