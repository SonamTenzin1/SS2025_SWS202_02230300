package com.facebook.o0.m0.n;

import android.util.Log;
import java.lang.reflect.Method;
import kotlin.jvm.internal.m;
import okhttp3.HttpUrl;

/* compiled from: UnityReflection.kt */
/* loaded from: classes.dex */
public final class e {
    public static final e a = new e();

    /* renamed from: b, reason: collision with root package name */
    private static final String f10336b = e.class.getCanonicalName();

    /* renamed from: c, reason: collision with root package name */
    private static Class<?> f10337c;

    private e() {
    }

    public static final void a() {
        d("UnityFacebookSDKPlugin", "CaptureViewHierarchy", HttpUrl.FRAGMENT_ENCODE_SET);
    }

    private final Class<?> b() {
        Class<?> cls = Class.forName("com.unity3d.player.UnityPlayer");
        m.e(cls, "forName(UNITY_PLAYER_CLASS)");
        return cls;
    }

    public static final void c(String str) {
        d("UnityFacebookSDKPlugin", "OnReceiveMapping", str);
    }

    public static final void d(String str, String str2, String str3) {
        try {
            if (f10337c == null) {
                f10337c = a.b();
            }
            Class<?> cls = f10337c;
            if (cls != null) {
                Method method = cls.getMethod("UnitySendMessage", String.class, String.class, String.class);
                Class<?> cls2 = f10337c;
                if (cls2 != null) {
                    method.invoke(cls2, str, str2, str3);
                    return;
                } else {
                    m.w("unityPlayer");
                    throw null;
                }
            }
            m.w("unityPlayer");
            throw null;
        } catch (Exception e2) {
            Log.e(f10336b, "Failed to send message to Unity", e2);
        }
    }
}
