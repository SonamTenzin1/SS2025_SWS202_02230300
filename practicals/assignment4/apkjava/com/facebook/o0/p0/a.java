package com.facebook.o0.p0;

import com.facebook.a0;
import com.facebook.internal.b0;
import com.facebook.o0.r0.h;
import java.util.List;
import java.util.Map;
import kotlin.collections.c0;
import kotlin.jvm.internal.m;
import okhttp3.HttpUrl;
import org.json.JSONObject;

/* compiled from: IntegrityManager.kt */
/* loaded from: classes2.dex */
public final class a {
    public static final a a = new a();

    /* renamed from: b, reason: collision with root package name */
    private static boolean f10388b;

    /* renamed from: c, reason: collision with root package name */
    private static boolean f10389c;

    private a() {
    }

    public static final void a() {
        f10388b = true;
        b0 b0Var = b0.a;
        a0 a0Var = a0.a;
        f10389c = b0.b("FBSDKFeatureIntegritySample", a0.d(), false);
    }

    private final String b(String str) {
        String str2;
        float[] fArr = new float[30];
        for (int i2 = 0; i2 < 30; i2++) {
            fArr[i2] = 0.0f;
        }
        h hVar = h.a;
        String[] q = h.q(h.a.MTML_INTEGRITY_DETECT, new float[][]{fArr}, new String[]{str});
        return (q == null || (str2 = q[0]) == null) ? "none" : str2;
    }

    public static final void c(Map<String, String> map) {
        List<String> E0;
        m.f(map, "parameters");
        if (f10388b && !map.isEmpty()) {
            try {
                E0 = c0.E0(map.keySet());
                JSONObject jSONObject = new JSONObject();
                for (String str : E0) {
                    String str2 = map.get(str);
                    if (str2 != null) {
                        String str3 = str2;
                        a aVar = a;
                        if (aVar.d(str) || aVar.d(str3)) {
                            map.remove(str);
                            if (!f10389c) {
                                str3 = HttpUrl.FRAGMENT_ENCODE_SET;
                            }
                            jSONObject.put(str, str3);
                        }
                    } else {
                        throw new IllegalStateException("Required value was null.".toString());
                    }
                }
                if (jSONObject.length() == 0) {
                    return;
                }
                String jSONObject2 = jSONObject.toString();
                m.e(jSONObject2, "restrictiveParamJson.toString()");
                map.put("_onDeviceParams", jSONObject2);
            } catch (Exception unused) {
            }
        }
    }

    private final boolean d(String str) {
        return !m.a("none", b(str));
    }
}
