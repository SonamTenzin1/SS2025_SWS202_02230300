package com.facebook.o0.l0;

import com.facebook.g0;
import com.facebook.internal.j0;
import com.facebook.internal.p0;
import com.facebook.o0.l0.d;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.q0;
import kotlin.collections.t;
import kotlin.s;
import kotlin.u;
import okhttp3.HttpUrl;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: AppEventsConversionsAPITransformer.kt */
/* loaded from: classes.dex */
public final class g {
    public static final g a = new g();

    /* renamed from: b, reason: collision with root package name */
    private static final Map<com.facebook.o0.l0.e, c> f10179b;

    /* renamed from: c, reason: collision with root package name */
    public static final Map<m, b> f10180c;

    /* renamed from: d, reason: collision with root package name */
    public static final Map<String, j> f10181d;

    /* compiled from: AppEventsConversionsAPITransformer.kt */
    /* loaded from: classes.dex */
    public enum a {
        OPTIONS("data_processing_options"),
        COUNTRY("data_processing_options_country"),
        STATE("data_processing_options_state");


        /* renamed from: f, reason: collision with root package name */
        public static final C0147a f10182f = new C0147a(null);

        /* renamed from: k, reason: collision with root package name */
        private final String f10187k;

        /* compiled from: AppEventsConversionsAPITransformer.kt */
        /* renamed from: com.facebook.o0.l0.g$a$a, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C0147a {
            private C0147a() {
            }

            public /* synthetic */ C0147a(kotlin.jvm.internal.g gVar) {
                this();
            }

            public final a a(String str) {
                kotlin.jvm.internal.m.f(str, "rawValue");
                for (a aVar : a.valuesCustom()) {
                    if (kotlin.jvm.internal.m.a(aVar.k(), str)) {
                        return aVar;
                    }
                }
                return null;
            }
        }

        a(String str) {
            this.f10187k = str;
        }

        /* renamed from: values, reason: to resolve conflict with enum method */
        public static a[] valuesCustom() {
            a[] valuesCustom = values();
            return (a[]) Arrays.copyOf(valuesCustom, valuesCustom.length);
        }

        public final String k() {
            return this.f10187k;
        }
    }

    /* compiled from: AppEventsConversionsAPITransformer.kt */
    /* loaded from: classes.dex */
    public static final class b {
        private k a;

        /* renamed from: b, reason: collision with root package name */
        private i f10188b;

        public b(k kVar, i iVar) {
            kotlin.jvm.internal.m.f(iVar, "field");
            this.a = kVar;
            this.f10188b = iVar;
        }

        public final i a() {
            return this.f10188b;
        }

        public final k b() {
            return this.a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return this.a == bVar.a && this.f10188b == bVar.f10188b;
        }

        public int hashCode() {
            k kVar = this.a;
            return ((kVar == null ? 0 : kVar.hashCode()) * 31) + this.f10188b.hashCode();
        }

        public String toString() {
            return "SectionCustomEventFieldMapping(section=" + this.a + ", field=" + this.f10188b + ')';
        }
    }

    /* compiled from: AppEventsConversionsAPITransformer.kt */
    /* loaded from: classes.dex */
    public static final class c {
        private k a;

        /* renamed from: b, reason: collision with root package name */
        private l f10189b;

        public c(k kVar, l lVar) {
            kotlin.jvm.internal.m.f(kVar, "section");
            this.a = kVar;
            this.f10189b = lVar;
        }

        public final l a() {
            return this.f10189b;
        }

        public final k b() {
            return this.a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return this.a == cVar.a && this.f10189b == cVar.f10189b;
        }

        public int hashCode() {
            int hashCode = this.a.hashCode() * 31;
            l lVar = this.f10189b;
            return hashCode + (lVar == null ? 0 : lVar.hashCode());
        }

        public String toString() {
            return "SectionFieldMapping(section=" + this.a + ", field=" + this.f10189b + ')';
        }
    }

    /* compiled from: AppEventsConversionsAPITransformer.kt */
    /* loaded from: classes.dex */
    public enum d {
        ARRAY,
        BOOL,
        INT;


        /* renamed from: f, reason: collision with root package name */
        public static final a f10190f = new a(null);

        /* compiled from: AppEventsConversionsAPITransformer.kt */
        /* loaded from: classes.dex */
        public static final class a {
            private a() {
            }

            public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
                this();
            }

            public final d a(String str) {
                kotlin.jvm.internal.m.f(str, "rawValue");
                if (!kotlin.jvm.internal.m.a(str, com.facebook.o0.l0.e.EXT_INFO.k()) && !kotlin.jvm.internal.m.a(str, com.facebook.o0.l0.e.URL_SCHEMES.k()) && !kotlin.jvm.internal.m.a(str, m.CONTENT_IDS.k()) && !kotlin.jvm.internal.m.a(str, m.CONTENTS.k()) && !kotlin.jvm.internal.m.a(str, a.OPTIONS.k())) {
                    if (!kotlin.jvm.internal.m.a(str, com.facebook.o0.l0.e.ADV_TE.k()) && !kotlin.jvm.internal.m.a(str, com.facebook.o0.l0.e.APP_TE.k())) {
                        if (kotlin.jvm.internal.m.a(str, m.EVENT_TIME.k())) {
                            return d.INT;
                        }
                        return null;
                    }
                    return d.BOOL;
                }
                return d.ARRAY;
            }
        }

        /* renamed from: values, reason: to resolve conflict with enum method */
        public static d[] valuesCustom() {
            d[] valuesCustom = values();
            return (d[]) Arrays.copyOf(valuesCustom, valuesCustom.length);
        }
    }

    /* compiled from: AppEventsConversionsAPITransformer.kt */
    /* loaded from: classes.dex */
    public /* synthetic */ class e {
        public static final /* synthetic */ int[] a;

        /* renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f10195b;

        /* renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ int[] f10196c;

        static {
            int[] iArr = new int[d.valuesCustom().length];
            iArr[d.ARRAY.ordinal()] = 1;
            iArr[d.BOOL.ordinal()] = 2;
            iArr[d.INT.ordinal()] = 3;
            a = iArr;
            int[] iArr2 = new int[k.valuesCustom().length];
            iArr2[k.APP_DATA.ordinal()] = 1;
            iArr2[k.USER_DATA.ordinal()] = 2;
            f10195b = iArr2;
            int[] iArr3 = new int[com.facebook.o0.l0.d.valuesCustom().length];
            iArr3[com.facebook.o0.l0.d.MOBILE_APP_INSTALL.ordinal()] = 1;
            iArr3[com.facebook.o0.l0.d.CUSTOM.ordinal()] = 2;
            f10196c = iArr3;
        }
    }

    static {
        Map<com.facebook.o0.l0.e, c> l;
        Map<m, b> l2;
        Map<String, j> l3;
        com.facebook.o0.l0.e eVar = com.facebook.o0.l0.e.ANON_ID;
        k kVar = k.USER_DATA;
        com.facebook.o0.l0.e eVar2 = com.facebook.o0.l0.e.ADV_TE;
        k kVar2 = k.APP_DATA;
        l = q0.l(s.a(eVar, new c(kVar, l.ANON_ID)), s.a(com.facebook.o0.l0.e.APP_USER_ID, new c(kVar, l.FB_LOGIN_ID)), s.a(com.facebook.o0.l0.e.ADVERTISER_ID, new c(kVar, l.MAD_ID)), s.a(com.facebook.o0.l0.e.PAGE_ID, new c(kVar, l.PAGE_ID)), s.a(com.facebook.o0.l0.e.PAGE_SCOPED_USER_ID, new c(kVar, l.PAGE_SCOPED_USER_ID)), s.a(eVar2, new c(kVar2, l.ADV_TE)), s.a(com.facebook.o0.l0.e.APP_TE, new c(kVar2, l.APP_TE)), s.a(com.facebook.o0.l0.e.CONSIDER_VIEWS, new c(kVar2, l.CONSIDER_VIEWS)), s.a(com.facebook.o0.l0.e.DEVICE_TOKEN, new c(kVar2, l.DEVICE_TOKEN)), s.a(com.facebook.o0.l0.e.EXT_INFO, new c(kVar2, l.EXT_INFO)), s.a(com.facebook.o0.l0.e.INCLUDE_DWELL_DATA, new c(kVar2, l.INCLUDE_DWELL_DATA)), s.a(com.facebook.o0.l0.e.INCLUDE_VIDEO_DATA, new c(kVar2, l.INCLUDE_VIDEO_DATA)), s.a(com.facebook.o0.l0.e.INSTALL_REFERRER, new c(kVar2, l.INSTALL_REFERRER)), s.a(com.facebook.o0.l0.e.INSTALLER_PACKAGE, new c(kVar2, l.INSTALLER_PACKAGE)), s.a(com.facebook.o0.l0.e.RECEIPT_DATA, new c(kVar2, l.RECEIPT_DATA)), s.a(com.facebook.o0.l0.e.URL_SCHEMES, new c(kVar2, l.URL_SCHEMES)), s.a(com.facebook.o0.l0.e.USER_DATA, new c(kVar, null)));
        f10179b = l;
        m mVar = m.VALUE_TO_SUM;
        k kVar3 = k.CUSTOM_DATA;
        l2 = q0.l(s.a(m.EVENT_TIME, new b(null, i.EVENT_TIME)), s.a(m.EVENT_NAME, new b(null, i.EVENT_NAME)), s.a(mVar, new b(kVar3, i.VALUE_TO_SUM)), s.a(m.CONTENT_IDS, new b(kVar3, i.CONTENT_IDS)), s.a(m.CONTENTS, new b(kVar3, i.CONTENTS)), s.a(m.CONTENT_TYPE, new b(kVar3, i.CONTENT_TYPE)), s.a(m.CURRENCY, new b(kVar3, i.CURRENCY)), s.a(m.DESCRIPTION, new b(kVar3, i.DESCRIPTION)), s.a(m.LEVEL, new b(kVar3, i.LEVEL)), s.a(m.MAX_RATING_VALUE, new b(kVar3, i.MAX_RATING_VALUE)), s.a(m.NUM_ITEMS, new b(kVar3, i.NUM_ITEMS)), s.a(m.PAYMENT_INFO_AVAILABLE, new b(kVar3, i.PAYMENT_INFO_AVAILABLE)), s.a(m.REGISTRATION_METHOD, new b(kVar3, i.REGISTRATION_METHOD)), s.a(m.SEARCH_STRING, new b(kVar3, i.SEARCH_STRING)), s.a(m.SUCCESS, new b(kVar3, i.SUCCESS)), s.a(m.ORDER_ID, new b(kVar3, i.ORDER_ID)), s.a(m.AD_TYPE, new b(kVar3, i.AD_TYPE)));
        f10180c = l2;
        l3 = q0.l(s.a("fb_mobile_achievement_unlocked", j.UNLOCKED_ACHIEVEMENT), s.a("fb_mobile_activate_app", j.ACTIVATED_APP), s.a("fb_mobile_add_payment_info", j.ADDED_PAYMENT_INFO), s.a("fb_mobile_add_to_cart", j.ADDED_TO_CART), s.a("fb_mobile_add_to_wishlist", j.ADDED_TO_WISHLIST), s.a("fb_mobile_complete_registration", j.COMPLETED_REGISTRATION), s.a("fb_mobile_content_view", j.VIEWED_CONTENT), s.a("fb_mobile_initiated_checkout", j.INITIATED_CHECKOUT), s.a("fb_mobile_level_achieved", j.ACHIEVED_LEVEL), s.a("fb_mobile_purchase", j.PURCHASED), s.a("fb_mobile_rate", j.RATED), s.a("fb_mobile_search", j.SEARCHED), s.a("fb_mobile_spent_credits", j.SPENT_CREDITS), s.a("fb_mobile_tutorial_completion", j.COMPLETED_TUTORIAL));
        f10181d = l3;
    }

    private g() {
    }

    private final List<Map<String, Object>> b(Map<String, ? extends Object> map, List<? extends Map<String, ? extends Object>> list) {
        if (list.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            Map map2 = (Map) it.next();
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.putAll(map);
            linkedHashMap.putAll(map2);
            arrayList.add(linkedHashMap);
        }
        return arrayList;
    }

    private final List<Map<String, Object>> c(Map<String, ? extends Object> map, Object obj) {
        List<Map<String, Object>> e2;
        if (obj == null) {
            return null;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.putAll(map);
        linkedHashMap.put(i.EVENT_NAME.k(), n.MOBILE_APP_INSTALL.k());
        linkedHashMap.put(i.EVENT_TIME.k(), obj);
        e2 = t.e(linkedHashMap);
        return e2;
    }

    private final com.facebook.o0.l0.d f(Map<String, ? extends Object> map, Map<String, Object> map2, Map<String, Object> map3, ArrayList<Map<String, Object>> arrayList, Map<String, Object> map4) {
        Object obj = map.get(n.EVENT.k());
        d.a aVar = com.facebook.o0.l0.d.f10166f;
        if (obj != null) {
            com.facebook.o0.l0.d a2 = aVar.a((String) obj);
            if (a2 == com.facebook.o0.l0.d.OTHER) {
                return a2;
            }
            for (Map.Entry<String, ? extends Object> entry : map.entrySet()) {
                String key = entry.getKey();
                Object value = entry.getValue();
                com.facebook.o0.l0.e a3 = com.facebook.o0.l0.e.f10171f.a(key);
                if (a3 != null) {
                    a.g(map2, map3, a3, value);
                } else {
                    boolean a4 = kotlin.jvm.internal.m.a(key, k.CUSTOM_EVENTS.k());
                    boolean z = value instanceof String;
                    if (a2 == com.facebook.o0.l0.d.CUSTOM && a4 && z) {
                        ArrayList<Map<String, Object>> k2 = k((String) value);
                        if (k2 != null) {
                            arrayList.addAll(k2);
                        }
                    } else if (a.f10182f.a(key) != null) {
                        map4.put(key, value);
                    }
                }
            }
            return a2;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
    }

    private final void h(Map<String, Object> map, com.facebook.o0.l0.e eVar, Object obj) {
        c cVar = f10179b.get(eVar);
        l a2 = cVar == null ? null : cVar.a();
        if (a2 == null) {
            return;
        }
        map.put(a2.k(), obj);
    }

    private final void i(Map<String, Object> map, com.facebook.o0.l0.e eVar, Object obj) {
        if (eVar == com.facebook.o0.l0.e.USER_DATA) {
            try {
                p0 p0Var = p0.a;
                map.putAll(p0.l(new JSONObject((String) obj)));
                return;
            } catch (JSONException e2) {
                j0.a.c(g0.APP_EVENTS, "AppEventsConversionsAPITransformer", "\n transformEvents JSONException: \n%s\n%s", obj, e2);
                return;
            }
        }
        c cVar = f10179b.get(eVar);
        l a2 = cVar == null ? null : cVar.a();
        if (a2 == null) {
            return;
        }
        map.put(a2.k(), obj);
    }

    private final String j(String str) {
        Map<String, j> map = f10181d;
        if (!map.containsKey(str)) {
            return str;
        }
        j jVar = map.get(str);
        return jVar == null ? HttpUrl.FRAGMENT_ENCODE_SET : jVar.k();
    }

    public static final ArrayList<Map<String, Object>> k(String str) {
        String b2;
        kotlin.jvm.internal.m.f(str, "appEvents");
        ArrayList<Map> arrayList = new ArrayList();
        try {
            p0 p0Var = p0.a;
            for (String str2 : p0.k(new JSONArray(str))) {
                p0 p0Var2 = p0.a;
                arrayList.add(p0.l(new JSONObject(str2)));
            }
            if (arrayList.isEmpty()) {
                return null;
            }
            ArrayList<Map<String, Object>> arrayList2 = new ArrayList<>();
            for (Map map : arrayList) {
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                for (String str3 : map.keySet()) {
                    m a2 = m.f10229f.a(str3);
                    b bVar = f10180c.get(a2);
                    if (a2 != null && bVar != null) {
                        k b3 = bVar.b();
                        if (b3 != null) {
                            if (b3 == k.CUSTOM_DATA) {
                                String k2 = bVar.a().k();
                                Object obj = map.get(str3);
                                if (obj == null) {
                                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Any");
                                }
                                Object l = l(str3, obj);
                                if (l != null) {
                                    linkedHashMap.put(k2, l);
                                } else {
                                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Any");
                                }
                            } else {
                                continue;
                            }
                        } else {
                            try {
                                String k3 = bVar.a().k();
                                if (a2 == m.EVENT_NAME && ((String) map.get(str3)) != null) {
                                    g gVar = a;
                                    Object obj2 = map.get(str3);
                                    if (obj2 == null) {
                                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                                    }
                                    linkedHashMap2.put(k3, gVar.j((String) obj2));
                                } else if (a2 == m.EVENT_TIME && ((Integer) map.get(str3)) != null) {
                                    Object obj3 = map.get(str3);
                                    if (obj3 == null) {
                                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Any");
                                    }
                                    Object l2 = l(str3, obj3);
                                    if (l2 != null) {
                                        linkedHashMap2.put(k3, l2);
                                    } else {
                                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Any");
                                    }
                                }
                            } catch (ClassCastException e2) {
                                j0.a aVar = j0.a;
                                g0 g0Var = g0.APP_EVENTS;
                                b2 = kotlin.b.b(e2);
                                aVar.c(g0Var, "AppEventsConversionsAPITransformer", "\n transformEvents ClassCastException: \n %s ", b2);
                            }
                        }
                    }
                }
                if (!linkedHashMap.isEmpty()) {
                    linkedHashMap2.put(k.CUSTOM_DATA.k(), linkedHashMap);
                }
                arrayList2.add(linkedHashMap2);
            }
            return arrayList2;
        } catch (JSONException e3) {
            j0.a.c(g0.APP_EVENTS, "AppEventsConversionsAPITransformer", "\n transformEvents JSONException: \n%s\n%s", str, e3);
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v7, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r1v8, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v9, types: [java.util.Map] */
    public static final Object l(String str, Object obj) {
        Integer j2;
        Integer j3;
        kotlin.jvm.internal.m.f(str, "field");
        kotlin.jvm.internal.m.f(obj, "value");
        d a2 = d.f10190f.a(str);
        String str2 = obj instanceof String ? (String) obj : null;
        if (a2 == null || str2 == null) {
            return obj;
        }
        int i2 = e.a[a2.ordinal()];
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 != 3) {
                    throw new NoWhenBranchMatchedException();
                }
                j3 = kotlin.text.t.j(obj.toString());
                return j3;
            }
            j2 = kotlin.text.t.j(str2);
            if (j2 != null) {
                return Boolean.valueOf(j2.intValue() != 0);
            }
            return null;
        }
        try {
            p0 p0Var = p0.a;
            List<String> k2 = p0.k(new JSONArray(str2));
            ArrayList arrayList = new ArrayList();
            Iterator it = k2.iterator();
            while (it.hasNext()) {
                ?? r1 = (String) it.next();
                try {
                    try {
                        p0 p0Var2 = p0.a;
                        r1 = p0.l(new JSONObject((String) r1));
                    } catch (JSONException unused) {
                    }
                } catch (JSONException unused2) {
                    p0 p0Var3 = p0.a;
                    r1 = p0.k(new JSONArray((String) r1));
                }
                arrayList.add(r1);
            }
            return arrayList;
        } catch (JSONException e2) {
            j0.a.c(g0.APP_EVENTS, "AppEventsConversionsAPITransformer", "\n transformEvents JSONException: \n%s\n%s", obj, e2);
            return u.a;
        }
    }

    public final List<Map<String, Object>> a(com.facebook.o0.l0.d dVar, Map<String, Object> map, Map<String, Object> map2, Map<String, Object> map3, List<? extends Map<String, ? extends Object>> list, Object obj) {
        kotlin.jvm.internal.m.f(dVar, "eventType");
        kotlin.jvm.internal.m.f(map, "userData");
        kotlin.jvm.internal.m.f(map2, "appData");
        kotlin.jvm.internal.m.f(map3, "restOfData");
        kotlin.jvm.internal.m.f(list, "customEvents");
        Map<String, Object> d2 = d(map, map2, map3);
        int i2 = e.f10196c[dVar.ordinal()];
        if (i2 == 1) {
            return c(d2, obj);
        }
        if (i2 != 2) {
            return null;
        }
        return b(d2, list);
    }

    public final Map<String, Object> d(Map<String, ? extends Object> map, Map<String, ? extends Object> map2, Map<String, ? extends Object> map3) {
        kotlin.jvm.internal.m.f(map, "userData");
        kotlin.jvm.internal.m.f(map2, "appData");
        kotlin.jvm.internal.m.f(map3, "restOfData");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(n.ACTION_SOURCE.k(), n.APP.k());
        linkedHashMap.put(k.USER_DATA.k(), map);
        linkedHashMap.put(k.APP_DATA.k(), map2);
        linkedHashMap.putAll(map3);
        return linkedHashMap;
    }

    public final List<Map<String, Object>> e(Map<String, ? extends Object> map) {
        kotlin.jvm.internal.m.f(map, "parameters");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        ArrayList<Map<String, Object>> arrayList = new ArrayList<>();
        LinkedHashMap linkedHashMap3 = new LinkedHashMap();
        com.facebook.o0.l0.d f2 = f(map, linkedHashMap, linkedHashMap2, arrayList, linkedHashMap3);
        if (f2 == com.facebook.o0.l0.d.OTHER) {
            return null;
        }
        return a(f2, linkedHashMap, linkedHashMap2, linkedHashMap3, arrayList, map.get(n.INSTALL_EVENT_TIME.k()));
    }

    public final void g(Map<String, Object> map, Map<String, Object> map2, com.facebook.o0.l0.e eVar, Object obj) {
        kotlin.jvm.internal.m.f(map, "userData");
        kotlin.jvm.internal.m.f(map2, "appData");
        kotlin.jvm.internal.m.f(eVar, "field");
        kotlin.jvm.internal.m.f(obj, "value");
        c cVar = f10179b.get(eVar);
        if (cVar == null) {
            return;
        }
        int i2 = e.f10195b[cVar.b().ordinal()];
        if (i2 == 1) {
            h(map2, eVar, obj);
        } else {
            if (i2 != 2) {
                return;
            }
            i(map, eVar, obj);
        }
    }
}
