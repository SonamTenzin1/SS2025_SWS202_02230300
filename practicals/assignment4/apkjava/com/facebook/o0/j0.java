package com.facebook.o0;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;
import android.util.Patterns;
import com.facebook.internal.p0;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.collections.w0;
import kotlin.text.Regex;
import okhttp3.HttpUrl;

/* compiled from: UserDataStore.kt */
/* loaded from: classes.dex */
public final class j0 {

    /* renamed from: c, reason: collision with root package name */
    private static SharedPreferences f10144c;
    public static final j0 a = new j0();

    /* renamed from: b, reason: collision with root package name */
    private static final String f10143b = j0.class.getSimpleName();

    /* renamed from: d, reason: collision with root package name */
    private static final AtomicBoolean f10145d = new AtomicBoolean(false);

    /* renamed from: e, reason: collision with root package name */
    private static final ConcurrentHashMap<String, String> f10146e = new ConcurrentHashMap<>();

    /* renamed from: f, reason: collision with root package name */
    private static final ConcurrentHashMap<String, String> f10147f = new ConcurrentHashMap<>();

    private j0() {
    }

    public static final String a() {
        if (!f10145d.get()) {
            a.c();
        }
        HashMap hashMap = new HashMap();
        hashMap.putAll(f10146e);
        hashMap.putAll(a.b());
        p0 p0Var = p0.a;
        return p0.l0(hashMap);
    }

    private final Map<String, String> b() {
        HashMap hashMap = new HashMap();
        Set<String> b2 = com.facebook.o0.k0.e.a.b();
        for (String str : f10147f.keySet()) {
            if (b2.contains(str)) {
                hashMap.put(str, f10147f.get(str));
            }
        }
        return hashMap;
    }

    private final synchronized void c() {
        AtomicBoolean atomicBoolean = f10145d;
        if (atomicBoolean.get()) {
            return;
        }
        com.facebook.a0 a0Var = com.facebook.a0.a;
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(com.facebook.a0.c());
        kotlin.jvm.internal.m.e(defaultSharedPreferences, "getDefaultSharedPreferences(FacebookSdk.getApplicationContext())");
        f10144c = defaultSharedPreferences;
        if (defaultSharedPreferences != null) {
            String string = defaultSharedPreferences.getString("com.facebook.appevents.UserDataStore.userData", HttpUrl.FRAGMENT_ENCODE_SET);
            if (string == null) {
                string = HttpUrl.FRAGMENT_ENCODE_SET;
            }
            SharedPreferences sharedPreferences = f10144c;
            if (sharedPreferences != null) {
                String string2 = sharedPreferences.getString("com.facebook.appevents.UserDataStore.internalUserData", HttpUrl.FRAGMENT_ENCODE_SET);
                if (string2 == null) {
                    string2 = HttpUrl.FRAGMENT_ENCODE_SET;
                }
                ConcurrentHashMap<String, String> concurrentHashMap = f10146e;
                p0 p0Var = p0.a;
                concurrentHashMap.putAll(p0.f0(string));
                f10147f.putAll(p0.f0(string2));
                atomicBoolean.set(true);
                return;
            }
            kotlin.jvm.internal.m.w("sharedPreferences");
            throw null;
        }
        kotlin.jvm.internal.m.w("sharedPreferences");
        throw null;
    }

    public static final void d() {
        if (f10145d.get()) {
            return;
        }
        a.c();
    }

    private final String f(String str, String str2) {
        String str3;
        int length = str2.length() - 1;
        int i2 = 0;
        boolean z = false;
        while (i2 <= length) {
            boolean z2 = kotlin.jvm.internal.m.h(str2.charAt(!z ? i2 : length), 32) <= 0;
            if (z) {
                if (!z2) {
                    break;
                }
                length--;
            } else if (z2) {
                i2++;
            } else {
                z = true;
            }
        }
        String obj = str2.subSequence(i2, length + 1).toString();
        if (obj != null) {
            String lowerCase = obj.toLowerCase();
            kotlin.jvm.internal.m.e(lowerCase, "(this as java.lang.String).toLowerCase()");
            if (kotlin.jvm.internal.m.a("em", str)) {
                if (Patterns.EMAIL_ADDRESS.matcher(lowerCase).matches()) {
                    return lowerCase;
                }
                Log.e(f10143b, "Setting email failure: this is not a valid email address");
                return HttpUrl.FRAGMENT_ENCODE_SET;
            }
            if (kotlin.jvm.internal.m.a("ph", str)) {
                return new Regex("[^0-9]").c(lowerCase, HttpUrl.FRAGMENT_ENCODE_SET);
            }
            if (!kotlin.jvm.internal.m.a("ge", str)) {
                return lowerCase;
            }
            if (!(lowerCase.length() > 0)) {
                str3 = HttpUrl.FRAGMENT_ENCODE_SET;
            } else {
                if (lowerCase == null) {
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                }
                str3 = lowerCase.substring(0, 1);
                kotlin.jvm.internal.m.e(str3, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            }
            if (kotlin.jvm.internal.m.a("f", str3) || kotlin.jvm.internal.m.a("m", str3)) {
                return str3;
            }
            Log.e(f10143b, "Setting gender failure: the supported value for gender is f or m");
            return HttpUrl.FRAGMENT_ENCODE_SET;
        }
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    }

    public static final void g(Map<String, String> map) {
        Set g2;
        List<String> d2;
        kotlin.jvm.internal.m.f(map, "ud");
        if (!f10145d.get()) {
            a.c();
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            p0 p0Var = p0.a;
            j0 j0Var = a;
            int i2 = 1;
            int length = value.length() - 1;
            int i3 = 0;
            boolean z = false;
            while (i3 <= length) {
                boolean z2 = kotlin.jvm.internal.m.h(value.charAt(!z ? i3 : length), 32) <= 0;
                if (z) {
                    if (!z2) {
                        break;
                    } else {
                        length--;
                    }
                } else if (z2) {
                    i3++;
                } else {
                    z = true;
                }
            }
            String F0 = p0.F0(j0Var.f(key, value.subSequence(i3, length + 1).toString()));
            ConcurrentHashMap<String, String> concurrentHashMap = f10147f;
            if (concurrentHashMap.containsKey(key)) {
                String str = concurrentHashMap.get(key);
                String[] strArr = null;
                if (str != null && (d2 = new Regex(",").d(str, 0)) != null) {
                    Object[] array = d2.toArray(new String[0]);
                    if (array == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                    }
                    strArr = (String[]) array;
                }
                if (strArr == null) {
                    strArr = new String[0];
                }
                g2 = w0.g(Arrays.copyOf(strArr, strArr.length));
                if (g2.contains(F0)) {
                    return;
                }
                StringBuilder sb = new StringBuilder();
                if (strArr.length == 0) {
                    sb.append(F0);
                } else if (strArr.length < 5) {
                    sb.append(str);
                    sb.append(",");
                    sb.append(F0);
                } else {
                    while (true) {
                        int i4 = i2 + 1;
                        sb.append(strArr[i2]);
                        sb.append(",");
                        if (i4 >= 5) {
                            break;
                        } else {
                            i2 = i4;
                        }
                    }
                    sb.append(F0);
                    g2.remove(strArr[0]);
                }
                f10147f.put(key, sb.toString());
            } else {
                concurrentHashMap.put(key, F0);
            }
        }
        j0 j0Var2 = a;
        p0 p0Var2 = p0.a;
        j0Var2.h("com.facebook.appevents.UserDataStore.internalUserData", p0.l0(f10147f));
    }

    private final void h(final String str, final String str2) {
        com.facebook.a0 a0Var = com.facebook.a0.a;
        com.facebook.a0.k().execute(new Runnable() { // from class: com.facebook.o0.s
            @Override // java.lang.Runnable
            public final void run() {
                j0.i(str, str2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(String str, String str2) {
        kotlin.jvm.internal.m.f(str, "$key");
        kotlin.jvm.internal.m.f(str2, "$value");
        if (!f10145d.get()) {
            a.c();
        }
        SharedPreferences sharedPreferences = f10144c;
        if (sharedPreferences != null) {
            sharedPreferences.edit().putString(str, str2).apply();
        } else {
            kotlin.jvm.internal.m.w("sharedPreferences");
            throw null;
        }
    }
}
