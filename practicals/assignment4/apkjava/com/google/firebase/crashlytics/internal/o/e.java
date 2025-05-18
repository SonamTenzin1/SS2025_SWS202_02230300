package com.google.firebase.crashlytics.internal.o;

import com.google.firebase.crashlytics.internal.h;
import com.google.firebase.crashlytics.internal.n.t;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import okhttp3.HttpUrl;

/* compiled from: KeysMap.java */
/* loaded from: classes2.dex */
class e {
    private final Map<String, String> a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    private final int f19151b;

    /* renamed from: c, reason: collision with root package name */
    private final int f19152c;

    public e(int i2, int i3) {
        this.f19151b = i2;
        this.f19152c = i3;
    }

    private String b(String str) {
        if (str != null) {
            return c(str, this.f19152c);
        }
        throw new IllegalArgumentException("Custom attribute key must not be null.");
    }

    public static String c(String str, int i2) {
        if (str == null) {
            return str;
        }
        String trim = str.trim();
        return trim.length() > i2 ? trim.substring(0, i2) : trim;
    }

    public synchronized Map<String, String> a() {
        return Collections.unmodifiableMap(new HashMap(this.a));
    }

    public synchronized boolean d(String str, String str2) {
        String b2 = b(str);
        if (this.a.size() >= this.f19151b && !this.a.containsKey(b2)) {
            h.f().k("Ignored entry \"" + str + "\" when adding custom keys. Maximum allowable: " + this.f19151b);
            return false;
        }
        String c2 = c(str2, this.f19152c);
        if (t.y(this.a.get(b2), c2)) {
            return false;
        }
        Map<String, String> map = this.a;
        if (str2 == null) {
            c2 = HttpUrl.FRAGMENT_ENCODE_SET;
        }
        map.put(b2, c2);
        return true;
    }

    public synchronized void e(Map<String, String> map) {
        int i2 = 0;
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String b2 = b(entry.getKey());
            if (this.a.size() >= this.f19151b && !this.a.containsKey(b2)) {
                i2++;
            }
            String value = entry.getValue();
            this.a.put(b2, value == null ? HttpUrl.FRAGMENT_ENCODE_SET : c(value, this.f19152c));
        }
        if (i2 > 0) {
            h.f().k("Ignored " + i2 + " entries when adding custom keys. Maximum allowable: " + this.f19151b);
        }
    }
}
