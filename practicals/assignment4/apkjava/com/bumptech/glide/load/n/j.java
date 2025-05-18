package com.bumptech.glide.load.n;

import android.text.TextUtils;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: LazyHeaders.java */
/* loaded from: classes.dex */
public final class j implements h {

    /* renamed from: c, reason: collision with root package name */
    private final Map<String, List<i>> f9312c;

    /* renamed from: d, reason: collision with root package name */
    private volatile Map<String, String> f9313d;

    /* compiled from: LazyHeaders.java */
    /* loaded from: classes.dex */
    public static final class a {
        private static final String a;

        /* renamed from: b, reason: collision with root package name */
        private static final Map<String, List<i>> f9314b;

        /* renamed from: c, reason: collision with root package name */
        private boolean f9315c = true;

        /* renamed from: d, reason: collision with root package name */
        private Map<String, List<i>> f9316d = f9314b;

        /* renamed from: e, reason: collision with root package name */
        private boolean f9317e = true;

        static {
            String b2 = b();
            a = b2;
            HashMap hashMap = new HashMap(2);
            if (!TextUtils.isEmpty(b2)) {
                hashMap.put("User-Agent", Collections.singletonList(new b(b2)));
            }
            f9314b = Collections.unmodifiableMap(hashMap);
        }

        static String b() {
            String property = System.getProperty("http.agent");
            if (TextUtils.isEmpty(property)) {
                return property;
            }
            int length = property.length();
            StringBuilder sb = new StringBuilder(property.length());
            for (int i2 = 0; i2 < length; i2++) {
                char charAt = property.charAt(i2);
                if ((charAt > 31 || charAt == '\t') && charAt < 127) {
                    sb.append(charAt);
                } else {
                    sb.append('?');
                }
            }
            return sb.toString();
        }

        public j a() {
            this.f9315c = true;
            return new j(this.f9316d);
        }
    }

    /* compiled from: LazyHeaders.java */
    /* loaded from: classes.dex */
    static final class b implements i {
        private final String a;

        b(String str) {
            this.a = str;
        }

        @Override // com.bumptech.glide.load.n.i
        public String a() {
            return this.a;
        }

        public boolean equals(Object obj) {
            if (obj instanceof b) {
                return this.a.equals(((b) obj).a);
            }
            return false;
        }

        public int hashCode() {
            return this.a.hashCode();
        }

        public String toString() {
            return "StringHeaderFactory{value='" + this.a + "'}";
        }
    }

    j(Map<String, List<i>> map) {
        this.f9312c = Collections.unmodifiableMap(map);
    }

    private String b(List<i> list) {
        StringBuilder sb = new StringBuilder();
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            String a2 = list.get(i2).a();
            if (!TextUtils.isEmpty(a2)) {
                sb.append(a2);
                if (i2 != list.size() - 1) {
                    sb.append(',');
                }
            }
        }
        return sb.toString();
    }

    private Map<String, String> c() {
        HashMap hashMap = new HashMap();
        for (Map.Entry<String, List<i>> entry : this.f9312c.entrySet()) {
            String b2 = b(entry.getValue());
            if (!TextUtils.isEmpty(b2)) {
                hashMap.put(entry.getKey(), b2);
            }
        }
        return hashMap;
    }

    @Override // com.bumptech.glide.load.n.h
    public Map<String, String> a() {
        if (this.f9313d == null) {
            synchronized (this) {
                if (this.f9313d == null) {
                    this.f9313d = Collections.unmodifiableMap(c());
                }
            }
        }
        return this.f9313d;
    }

    public boolean equals(Object obj) {
        if (obj instanceof j) {
            return this.f9312c.equals(((j) obj).f9312c);
        }
        return false;
    }

    public int hashCode() {
        return this.f9312c.hashCode();
    }

    public String toString() {
        return "LazyHeaders{headers=" + this.f9312c + '}';
    }
}
