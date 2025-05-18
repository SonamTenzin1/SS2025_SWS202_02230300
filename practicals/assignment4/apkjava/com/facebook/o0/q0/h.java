package com.facebook.o0.q0;

import android.content.Context;
import com.facebook.g0;
import com.facebook.internal.j0;
import com.facebook.internal.p0;
import com.facebook.internal.q;
import com.facebook.o0.a0;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.collections.q0;
import kotlin.s;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: AppEventsLoggerUtility.kt */
/* loaded from: classes2.dex */
public final class h {
    public static final h a = new h();

    /* renamed from: b, reason: collision with root package name */
    private static final Map<a, String> f10415b;

    /* compiled from: AppEventsLoggerUtility.kt */
    /* loaded from: classes2.dex */
    public enum a {
        MOBILE_INSTALL_EVENT,
        CUSTOM_APP_EVENTS;

        /* renamed from: values, reason: to resolve conflict with enum method */
        public static a[] valuesCustom() {
            a[] valuesCustom = values();
            return (a[]) Arrays.copyOf(valuesCustom, valuesCustom.length);
        }
    }

    static {
        HashMap k2;
        k2 = q0.k(s.a(a.MOBILE_INSTALL_EVENT, "MOBILE_APP_INSTALL"), s.a(a.CUSTOM_APP_EVENTS, "CUSTOM_APP_EVENTS"));
        f10415b = k2;
    }

    private h() {
    }

    public static final JSONObject a(a aVar, q qVar, String str, boolean z, Context context) throws JSONException {
        kotlin.jvm.internal.m.f(aVar, "activityType");
        kotlin.jvm.internal.m.f(context, "context");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("event", f10415b.get(aVar));
        String e2 = a0.a.e();
        if (e2 != null) {
            jSONObject.put("app_user_id", e2);
        }
        p0 p0Var = p0.a;
        p0.C0(jSONObject, qVar, str, z, context);
        try {
            p0.D0(jSONObject, context);
        } catch (Exception e3) {
            j0.a.c(g0.APP_EVENTS, "AppEvents", "Fetching extended device info parameters failed: '%s'", e3.toString());
        }
        p0 p0Var2 = p0.a;
        JSONObject A = p0.A();
        if (A != null) {
            Iterator<String> keys = A.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                jSONObject.put(next, A.get(next));
            }
        }
        jSONObject.put("application_package_name", context.getPackageName());
        return jSONObject;
    }
}
