package com.facebook.o0.m0.n;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.m;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: EventBinding.kt */
/* loaded from: classes.dex */
public final class a {
    public static final b a = new b(null);

    /* renamed from: b, reason: collision with root package name */
    private final String f10302b;

    /* renamed from: c, reason: collision with root package name */
    private final c f10303c;

    /* renamed from: d, reason: collision with root package name */
    private final EnumC0148a f10304d;

    /* renamed from: e, reason: collision with root package name */
    private final String f10305e;

    /* renamed from: f, reason: collision with root package name */
    private final List<com.facebook.o0.m0.n.c> f10306f;

    /* renamed from: g, reason: collision with root package name */
    private final List<com.facebook.o0.m0.n.b> f10307g;

    /* renamed from: h, reason: collision with root package name */
    private final String f10308h;

    /* renamed from: i, reason: collision with root package name */
    private final String f10309i;

    /* renamed from: j, reason: collision with root package name */
    private final String f10310j;

    /* compiled from: EventBinding.kt */
    /* renamed from: com.facebook.o0.m0.n.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public enum EnumC0148a {
        CLICK,
        SELECTED,
        TEXT_CHANGED;

        /* renamed from: values, reason: to resolve conflict with enum method */
        public static EnumC0148a[] valuesCustom() {
            EnumC0148a[] valuesCustom = values();
            return (EnumC0148a[]) Arrays.copyOf(valuesCustom, valuesCustom.length);
        }
    }

    /* compiled from: EventBinding.kt */
    /* loaded from: classes.dex */
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(g gVar) {
            this();
        }

        public final a a(JSONObject jSONObject) throws JSONException, IllegalArgumentException {
            int length;
            m.f(jSONObject, "mapping");
            String string = jSONObject.getString("event_name");
            String string2 = jSONObject.getString("method");
            m.e(string2, "mapping.getString(\"method\")");
            Locale locale = Locale.ENGLISH;
            m.e(locale, "ENGLISH");
            String upperCase = string2.toUpperCase(locale);
            m.e(upperCase, "(this as java.lang.String).toUpperCase(locale)");
            c valueOf = c.valueOf(upperCase);
            String string3 = jSONObject.getString("event_type");
            m.e(string3, "mapping.getString(\"event_type\")");
            m.e(locale, "ENGLISH");
            String upperCase2 = string3.toUpperCase(locale);
            m.e(upperCase2, "(this as java.lang.String).toUpperCase(locale)");
            EnumC0148a valueOf2 = EnumC0148a.valueOf(upperCase2);
            String string4 = jSONObject.getString("app_version");
            JSONArray jSONArray = jSONObject.getJSONArray("path");
            ArrayList arrayList = new ArrayList();
            int length2 = jSONArray.length();
            int i2 = 0;
            if (length2 > 0) {
                int i3 = 0;
                while (true) {
                    int i4 = i3 + 1;
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i3);
                    m.e(jSONObject2, "jsonPath");
                    arrayList.add(new com.facebook.o0.m0.n.c(jSONObject2));
                    if (i4 >= length2) {
                        break;
                    }
                    i3 = i4;
                }
            }
            String optString = jSONObject.optString("path_type", "absolute");
            JSONArray optJSONArray = jSONObject.optJSONArray("parameters");
            ArrayList arrayList2 = new ArrayList();
            if (optJSONArray != null && (length = optJSONArray.length()) > 0) {
                while (true) {
                    int i5 = i2 + 1;
                    JSONObject jSONObject3 = optJSONArray.getJSONObject(i2);
                    m.e(jSONObject3, "jsonParameter");
                    arrayList2.add(new com.facebook.o0.m0.n.b(jSONObject3));
                    if (i5 >= length) {
                        break;
                    }
                    i2 = i5;
                }
            }
            String optString2 = jSONObject.optString("component_id");
            String optString3 = jSONObject.optString("activity_name");
            m.e(string, "eventName");
            m.e(string4, "appVersion");
            m.e(optString2, "componentId");
            m.e(optString, "pathType");
            m.e(optString3, "activityName");
            return new a(string, valueOf, valueOf2, string4, arrayList, arrayList2, optString2, optString, optString3);
        }

        public final List<a> b(JSONArray jSONArray) {
            ArrayList arrayList = new ArrayList();
            if (jSONArray != null) {
                int i2 = 0;
                try {
                    int length = jSONArray.length();
                    if (length > 0) {
                        while (true) {
                            int i3 = i2 + 1;
                            JSONObject jSONObject = jSONArray.getJSONObject(i2);
                            m.e(jSONObject, "array.getJSONObject(i)");
                            arrayList.add(a(jSONObject));
                            if (i3 >= length) {
                                break;
                            }
                            i2 = i3;
                        }
                    }
                } catch (IllegalArgumentException | JSONException unused) {
                }
            }
            return arrayList;
        }
    }

    /* compiled from: EventBinding.kt */
    /* loaded from: classes.dex */
    public enum c {
        MANUAL,
        INFERENCE;

        /* renamed from: values, reason: to resolve conflict with enum method */
        public static c[] valuesCustom() {
            c[] valuesCustom = values();
            return (c[]) Arrays.copyOf(valuesCustom, valuesCustom.length);
        }
    }

    public a(String str, c cVar, EnumC0148a enumC0148a, String str2, List<com.facebook.o0.m0.n.c> list, List<com.facebook.o0.m0.n.b> list2, String str3, String str4, String str5) {
        m.f(str, "eventName");
        m.f(cVar, "method");
        m.f(enumC0148a, "type");
        m.f(str2, "appVersion");
        m.f(list, "path");
        m.f(list2, "parameters");
        m.f(str3, "componentId");
        m.f(str4, "pathType");
        m.f(str5, "activityName");
        this.f10302b = str;
        this.f10303c = cVar;
        this.f10304d = enumC0148a;
        this.f10305e = str2;
        this.f10306f = list;
        this.f10307g = list2;
        this.f10308h = str3;
        this.f10309i = str4;
        this.f10310j = str5;
    }

    public final String a() {
        return this.f10310j;
    }

    public final String b() {
        return this.f10302b;
    }

    public final List<com.facebook.o0.m0.n.b> c() {
        List<com.facebook.o0.m0.n.b> unmodifiableList = Collections.unmodifiableList(this.f10307g);
        m.e(unmodifiableList, "unmodifiableList(parameters)");
        return unmodifiableList;
    }

    public final List<com.facebook.o0.m0.n.c> d() {
        List<com.facebook.o0.m0.n.c> unmodifiableList = Collections.unmodifiableList(this.f10306f);
        m.e(unmodifiableList, "unmodifiableList(path)");
        return unmodifiableList;
    }
}
