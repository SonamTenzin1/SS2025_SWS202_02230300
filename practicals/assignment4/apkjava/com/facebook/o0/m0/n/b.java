package com.facebook.o0.m0.n;

import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.m;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: ParameterComponent.kt */
/* loaded from: classes.dex */
public final class b {
    public static final a a = new a(null);

    /* renamed from: b, reason: collision with root package name */
    private final String f10318b;

    /* renamed from: c, reason: collision with root package name */
    private final String f10319c;

    /* renamed from: d, reason: collision with root package name */
    private final List<c> f10320d;

    /* renamed from: e, reason: collision with root package name */
    private final String f10321e;

    /* compiled from: ParameterComponent.kt */
    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }
    }

    public b(JSONObject jSONObject) {
        m.f(jSONObject, "component");
        String string = jSONObject.getString("name");
        m.e(string, "component.getString(PARAMETER_NAME_KEY)");
        this.f10318b = string;
        String optString = jSONObject.optString("value");
        m.e(optString, "component.optString(PARAMETER_VALUE_KEY)");
        this.f10319c = optString;
        String optString2 = jSONObject.optString("path_type", "absolute");
        m.e(optString2, "component.optString(Constants.EVENT_MAPPING_PATH_TYPE_KEY, Constants.PATH_TYPE_ABSOLUTE)");
        this.f10321e = optString2;
        ArrayList arrayList = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("path");
        if (optJSONArray != null) {
            int i2 = 0;
            int length = optJSONArray.length();
            if (length > 0) {
                while (true) {
                    int i3 = i2 + 1;
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i2);
                    m.e(jSONObject2, "jsonPathArray.getJSONObject(i)");
                    arrayList.add(new c(jSONObject2));
                    if (i3 >= length) {
                        break;
                    } else {
                        i2 = i3;
                    }
                }
            }
        }
        this.f10320d = arrayList;
    }

    public final String a() {
        return this.f10318b;
    }

    public final List<c> b() {
        return this.f10320d;
    }

    public final String c() {
        return this.f10321e;
    }

    public final String d() {
        return this.f10319c;
    }
}
