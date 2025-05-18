package com.facebook.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import com.facebook.GraphRequest;
import com.facebook.internal.c0;
import com.facebook.internal.d0;
import com.facebook.internal.x;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.internal.StringCompanionObject;
import okhttp3.HttpUrl;
import okhttp3.internal.http2.Http2;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: FetchedAppSettingsManager.kt */
/* loaded from: classes2.dex */
public final class d0 {
    public static final d0 a = new d0();

    /* renamed from: b, reason: collision with root package name */
    private static final String f9751b = d0.class.getSimpleName();

    /* renamed from: c, reason: collision with root package name */
    private static final List<String> f9752c;

    /* renamed from: d, reason: collision with root package name */
    private static final Map<String, c0> f9753d;

    /* renamed from: e, reason: collision with root package name */
    private static final AtomicReference<a> f9754e;

    /* renamed from: f, reason: collision with root package name */
    private static final ConcurrentLinkedQueue<b> f9755f;

    /* renamed from: g, reason: collision with root package name */
    private static boolean f9756g;

    /* renamed from: h, reason: collision with root package name */
    private static JSONArray f9757h;

    /* compiled from: FetchedAppSettingsManager.kt */
    /* loaded from: classes2.dex */
    public enum a {
        NOT_LOADED,
        LOADING,
        SUCCESS,
        ERROR;

        /* renamed from: values, reason: to resolve conflict with enum method */
        public static a[] valuesCustom() {
            a[] valuesCustom = values();
            return (a[]) Arrays.copyOf(valuesCustom, valuesCustom.length);
        }
    }

    /* compiled from: FetchedAppSettingsManager.kt */
    /* loaded from: classes2.dex */
    public interface b {
        void a(c0 c0Var);

        void onError();
    }

    static {
        List<String> m;
        m = kotlin.collections.u.m("supports_implicit_sdk_logging", "gdpv4_nux_content", "gdpv4_nux_enabled", "android_dialog_configs", "android_sdk_error_categories", "app_events_session_timeout", "app_events_feature_bitmask", "auto_event_mapping_android", "seamless_login", "smart_login_bookmark_icon_url", "smart_login_menu_icon_url", "restrictive_data_filter_params", "aam_rules", "suggested_events_setting", "protected_mode_rules");
        f9752c = m;
        f9753d = new ConcurrentHashMap();
        f9754e = new AtomicReference<>(a.NOT_LOADED);
        f9755f = new ConcurrentLinkedQueue<>();
    }

    private d0() {
    }

    public static final void a(b bVar) {
        kotlin.jvm.internal.m.f(bVar, "callback");
        f9755f.add(bVar);
        g();
    }

    private final JSONObject b(String str) {
        Bundle bundle = new Bundle();
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(f9752c);
        bundle.putString("fields", TextUtils.join(",", arrayList));
        GraphRequest x = GraphRequest.a.x(null, "app", null);
        x.E(true);
        x.H(bundle);
        JSONObject d2 = x.j().d();
        return d2 == null ? new JSONObject() : d2;
    }

    public static final c0 c(String str) {
        if (str != null) {
            return f9753d.get(str);
        }
        return null;
    }

    public static final void g() {
        com.facebook.a0 a0Var = com.facebook.a0.a;
        final Context c2 = com.facebook.a0.c();
        final String d2 = com.facebook.a0.d();
        p0 p0Var = p0.a;
        if (p0.a0(d2)) {
            f9754e.set(a.ERROR);
            a.l();
            return;
        }
        if (f9753d.containsKey(d2)) {
            f9754e.set(a.SUCCESS);
            a.l();
            return;
        }
        AtomicReference<a> atomicReference = f9754e;
        a aVar = a.NOT_LOADED;
        a aVar2 = a.LOADING;
        if (!(atomicReference.compareAndSet(aVar, aVar2) || atomicReference.compareAndSet(a.ERROR, aVar2))) {
            a.l();
            return;
        }
        StringCompanionObject stringCompanionObject = StringCompanionObject.a;
        final String format = String.format("com.facebook.internal.APP_SETTINGS.%s", Arrays.copyOf(new Object[]{d2}, 1));
        kotlin.jvm.internal.m.e(format, "java.lang.String.format(format, *args)");
        com.facebook.a0.k().execute(new Runnable() { // from class: com.facebook.internal.f
            @Override // java.lang.Runnable
            public final void run() {
                d0.h(c2, format, d2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(Context context, String str, String str2) {
        JSONObject jSONObject;
        kotlin.jvm.internal.m.f(context, "$context");
        kotlin.jvm.internal.m.f(str, "$settingsKey");
        kotlin.jvm.internal.m.f(str2, "$applicationId");
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.facebook.internal.preferences.APP_SETTINGS", 0);
        c0 c0Var = null;
        String string = sharedPreferences.getString(str, null);
        p0 p0Var = p0.a;
        if (!p0.a0(string)) {
            if (string != null) {
                try {
                    jSONObject = new JSONObject(string);
                } catch (JSONException e2) {
                    p0 p0Var2 = p0.a;
                    p0.i0("FacebookSDK", e2);
                    jSONObject = null;
                }
                if (jSONObject != null) {
                    c0Var = a.i(str2, jSONObject);
                }
            } else {
                throw new IllegalStateException("Required value was null.".toString());
            }
        }
        d0 d0Var = a;
        JSONObject b2 = d0Var.b(str2);
        if (b2 != null) {
            d0Var.i(str2, b2);
            sharedPreferences.edit().putString(str, b2.toString()).apply();
        }
        if (c0Var != null) {
            String j2 = c0Var.j();
            if (!f9756g && j2 != null && j2.length() > 0) {
                f9756g = true;
                Log.w(f9751b, j2);
            }
        }
        b0 b0Var = b0.a;
        b0.m(str2, true);
        com.facebook.o0.q0.i iVar = com.facebook.o0.q0.i.a;
        com.facebook.o0.q0.i.d();
        f9754e.set(f9753d.containsKey(str2) ? a.SUCCESS : a.ERROR);
        d0Var.l();
    }

    private final Map<String, Map<String, c0.b>> j(JSONObject jSONObject) {
        JSONArray optJSONArray;
        HashMap hashMap = new HashMap();
        if (jSONObject != null && (optJSONArray = jSONObject.optJSONArray("data")) != null) {
            int i2 = 0;
            int length = optJSONArray.length();
            if (length > 0) {
                while (true) {
                    int i3 = i2 + 1;
                    c0.b.a aVar = c0.b.a;
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
                    kotlin.jvm.internal.m.e(optJSONObject, "dialogConfigData.optJSONObject(i)");
                    c0.b a2 = aVar.a(optJSONObject);
                    if (a2 != null) {
                        String a3 = a2.a();
                        Map map = (Map) hashMap.get(a3);
                        if (map == null) {
                            map = new HashMap();
                            hashMap.put(a3, map);
                        }
                        map.put(a2.b(), a2);
                    }
                    if (i3 >= length) {
                        break;
                    }
                    i2 = i3;
                }
            }
        }
        return hashMap;
    }

    private final JSONArray k(JSONObject jSONObject, String str) {
        if (jSONObject != null) {
            return jSONObject.optJSONArray(str);
        }
        return null;
    }

    private final synchronized void l() {
        a aVar = f9754e.get();
        if (a.NOT_LOADED != aVar && a.LOADING != aVar) {
            com.facebook.a0 a0Var = com.facebook.a0.a;
            final c0 c0Var = f9753d.get(com.facebook.a0.d());
            Handler handler = new Handler(Looper.getMainLooper());
            if (a.ERROR == aVar) {
                while (true) {
                    ConcurrentLinkedQueue<b> concurrentLinkedQueue = f9755f;
                    if (concurrentLinkedQueue.isEmpty()) {
                        return;
                    }
                    final b poll = concurrentLinkedQueue.poll();
                    handler.post(new Runnable() { // from class: com.facebook.internal.g
                        @Override // java.lang.Runnable
                        public final void run() {
                            d0.m(d0.b.this);
                        }
                    });
                }
            } else {
                while (true) {
                    ConcurrentLinkedQueue<b> concurrentLinkedQueue2 = f9755f;
                    if (concurrentLinkedQueue2.isEmpty()) {
                        return;
                    }
                    final b poll2 = concurrentLinkedQueue2.poll();
                    handler.post(new Runnable() { // from class: com.facebook.internal.h
                        @Override // java.lang.Runnable
                        public final void run() {
                            d0.n(d0.b.this, c0Var);
                        }
                    });
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(b bVar) {
        bVar.onError();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(b bVar, c0 c0Var) {
        bVar.a(c0Var);
    }

    public static final c0 o(String str, boolean z) {
        kotlin.jvm.internal.m.f(str, "applicationId");
        if (!z) {
            Map<String, c0> map = f9753d;
            if (map.containsKey(str)) {
                return map.get(str);
            }
        }
        d0 d0Var = a;
        JSONObject b2 = d0Var.b(str);
        if (b2 == null) {
            return null;
        }
        c0 i2 = d0Var.i(str, b2);
        com.facebook.a0 a0Var = com.facebook.a0.a;
        if (kotlin.jvm.internal.m.a(str, com.facebook.a0.d())) {
            f9754e.set(a.SUCCESS);
            d0Var.l();
        }
        return i2;
    }

    public final c0 i(String str, JSONObject jSONObject) {
        kotlin.jvm.internal.m.f(str, "applicationId");
        kotlin.jvm.internal.m.f(jSONObject, "settingsJSON");
        JSONArray optJSONArray = jSONObject.optJSONArray("android_sdk_error_categories");
        x.a aVar = x.a;
        x a2 = aVar.a(optJSONArray);
        if (a2 == null) {
            a2 = aVar.b();
        }
        x xVar = a2;
        int optInt = jSONObject.optInt("app_events_feature_bitmask", 0);
        boolean z = (optInt & 8) != 0;
        boolean z2 = (optInt & 16) != 0;
        boolean z3 = (optInt & 32) != 0;
        boolean z4 = (optInt & 256) != 0;
        boolean z5 = (optInt & Http2.INITIAL_MAX_FRAME_SIZE) != 0;
        JSONArray optJSONArray2 = jSONObject.optJSONArray("auto_event_mapping_android");
        f9757h = optJSONArray2;
        if (optJSONArray2 != null) {
            h0 h0Var = h0.a;
            if (h0.b()) {
                com.facebook.o0.m0.n.e eVar = com.facebook.o0.m0.n.e.a;
                com.facebook.o0.m0.n.e.c(optJSONArray2 == null ? null : optJSONArray2.toString());
            }
        }
        boolean optBoolean = jSONObject.optBoolean("supports_implicit_sdk_logging", false);
        String optString = jSONObject.optString("gdpv4_nux_content", HttpUrl.FRAGMENT_ENCODE_SET);
        kotlin.jvm.internal.m.e(optString, "settingsJSON.optString(APP_SETTING_NUX_CONTENT, \"\")");
        boolean optBoolean2 = jSONObject.optBoolean("gdpv4_nux_enabled", false);
        com.facebook.o0.q0.j jVar = com.facebook.o0.q0.j.a;
        int optInt2 = jSONObject.optInt("app_events_session_timeout", com.facebook.o0.q0.j.a());
        EnumSet<o0> a3 = o0.f9810f.a(jSONObject.optLong("seamless_login"));
        Map<String, Map<String, c0.b>> j2 = j(jSONObject.optJSONObject("android_dialog_configs"));
        String optString2 = jSONObject.optString("smart_login_bookmark_icon_url");
        kotlin.jvm.internal.m.e(optString2, "settingsJSON.optString(SMART_LOGIN_BOOKMARK_ICON_URL)");
        String optString3 = jSONObject.optString("smart_login_menu_icon_url");
        kotlin.jvm.internal.m.e(optString3, "settingsJSON.optString(SMART_LOGIN_MENU_ICON_URL)");
        String optString4 = jSONObject.optString("sdk_update_message");
        kotlin.jvm.internal.m.e(optString4, "settingsJSON.optString(SDK_UPDATE_MESSAGE)");
        c0 c0Var = new c0(optBoolean, optString, optBoolean2, optInt2, a3, j2, z, xVar, optString2, optString3, z2, z3, optJSONArray2, optString4, z4, z5, jSONObject.optString("aam_rules"), jSONObject.optString("suggested_events_setting"), jSONObject.optString("restrictive_data_filter_params"), k(jSONObject.optJSONObject("protected_mode_rules"), "standard_params"), k(jSONObject.optJSONObject("protected_mode_rules"), "maca_rules"));
        f9753d.put(str, c0Var);
        return c0Var;
    }
}
