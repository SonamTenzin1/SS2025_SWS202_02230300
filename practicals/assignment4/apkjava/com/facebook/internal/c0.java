package com.facebook.internal;

import android.net.Uri;
import java.util.EnumSet;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: FetchedAppSettings.kt */
/* loaded from: classes2.dex */
public final class c0 {
    public static final a a = new a(null);

    /* renamed from: b, reason: collision with root package name */
    private final boolean f9736b;

    /* renamed from: c, reason: collision with root package name */
    private final String f9737c;

    /* renamed from: d, reason: collision with root package name */
    private final boolean f9738d;

    /* renamed from: e, reason: collision with root package name */
    private final int f9739e;

    /* renamed from: f, reason: collision with root package name */
    private final EnumSet<o0> f9740f;

    /* renamed from: g, reason: collision with root package name */
    private final Map<String, Map<String, b>> f9741g;

    /* renamed from: h, reason: collision with root package name */
    private final boolean f9742h;

    /* renamed from: i, reason: collision with root package name */
    private final x f9743i;

    /* renamed from: j, reason: collision with root package name */
    private final String f9744j;

    /* renamed from: k, reason: collision with root package name */
    private final String f9745k;
    private final boolean l;
    private final boolean m;
    private final JSONArray n;
    private final String o;
    private final boolean p;
    private final boolean q;
    private final String r;
    private final String s;
    private final String t;
    private final JSONArray u;
    private final JSONArray v;

    /* compiled from: FetchedAppSettings.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
            this();
        }
    }

    /* compiled from: FetchedAppSettings.kt */
    /* loaded from: classes2.dex */
    public static final class b {
        public static final a a = new a(null);

        /* renamed from: b, reason: collision with root package name */
        private final String f9746b;

        /* renamed from: c, reason: collision with root package name */
        private final String f9747c;

        /* renamed from: d, reason: collision with root package name */
        private final Uri f9748d;

        /* renamed from: e, reason: collision with root package name */
        private final int[] f9749e;

        /* compiled from: FetchedAppSettings.kt */
        /* loaded from: classes2.dex */
        public static final class a {
            private a() {
            }

            public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
                this();
            }

            private final int[] b(JSONArray jSONArray) {
                if (jSONArray == null) {
                    return null;
                }
                int length = jSONArray.length();
                int[] iArr = new int[length];
                int i2 = 0;
                if (length <= 0) {
                    return iArr;
                }
                while (true) {
                    int i3 = i2 + 1;
                    int i4 = -1;
                    int optInt = jSONArray.optInt(i2, -1);
                    if (optInt == -1) {
                        String optString = jSONArray.optString(i2);
                        p0 p0Var = p0.a;
                        if (!p0.a0(optString)) {
                            try {
                                kotlin.jvm.internal.m.e(optString, "versionString");
                                i4 = Integer.parseInt(optString);
                            } catch (NumberFormatException e2) {
                                p0 p0Var2 = p0.a;
                                p0.i0("FacebookSDK", e2);
                            }
                            optInt = i4;
                        }
                    }
                    iArr[i2] = optInt;
                    if (i3 >= length) {
                        return iArr;
                    }
                    i2 = i3;
                }
            }

            public final b a(JSONObject jSONObject) {
                List v0;
                kotlin.jvm.internal.m.f(jSONObject, "dialogConfigJSON");
                String optString = jSONObject.optString("name");
                p0 p0Var = p0.a;
                if (p0.a0(optString)) {
                    return null;
                }
                kotlin.jvm.internal.m.e(optString, "dialogNameWithFeature");
                v0 = kotlin.text.v.v0(optString, new String[]{"|"}, false, 0, 6, null);
                if (v0.size() != 2) {
                    return null;
                }
                String str = (String) kotlin.collections.s.U(v0);
                String str2 = (String) kotlin.collections.s.g0(v0);
                if (p0.a0(str) || p0.a0(str2)) {
                    return null;
                }
                String optString2 = jSONObject.optString("url");
                return new b(str, str2, p0.a0(optString2) ? null : Uri.parse(optString2), b(jSONObject.optJSONArray("versions")), null);
            }
        }

        private b(String str, String str2, Uri uri, int[] iArr) {
            this.f9746b = str;
            this.f9747c = str2;
            this.f9748d = uri;
            this.f9749e = iArr;
        }

        public /* synthetic */ b(String str, String str2, Uri uri, int[] iArr, kotlin.jvm.internal.g gVar) {
            this(str, str2, uri, iArr);
        }

        public final String a() {
            return this.f9746b;
        }

        public final String b() {
            return this.f9747c;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public c0(boolean z, String str, boolean z2, int i2, EnumSet<o0> enumSet, Map<String, ? extends Map<String, b>> map, boolean z3, x xVar, String str2, String str3, boolean z4, boolean z5, JSONArray jSONArray, String str4, boolean z6, boolean z7, String str5, String str6, String str7, JSONArray jSONArray2, JSONArray jSONArray3) {
        kotlin.jvm.internal.m.f(str, "nuxContent");
        kotlin.jvm.internal.m.f(enumSet, "smartLoginOptions");
        kotlin.jvm.internal.m.f(map, "dialogConfigurations");
        kotlin.jvm.internal.m.f(xVar, "errorClassification");
        kotlin.jvm.internal.m.f(str2, "smartLoginBookmarkIconURL");
        kotlin.jvm.internal.m.f(str3, "smartLoginMenuIconURL");
        kotlin.jvm.internal.m.f(str4, "sdkUpdateMessage");
        this.f9736b = z;
        this.f9737c = str;
        this.f9738d = z2;
        this.f9739e = i2;
        this.f9740f = enumSet;
        this.f9741g = map;
        this.f9742h = z3;
        this.f9743i = xVar;
        this.f9744j = str2;
        this.f9745k = str3;
        this.l = z4;
        this.m = z5;
        this.n = jSONArray;
        this.o = str4;
        this.p = z6;
        this.q = z7;
        this.r = str5;
        this.s = str6;
        this.t = str7;
        this.u = jSONArray2;
        this.v = jSONArray3;
    }

    public final boolean a() {
        return this.f9742h;
    }

    public final boolean b() {
        return this.m;
    }

    public final x c() {
        return this.f9743i;
    }

    public final JSONArray d() {
        return this.n;
    }

    public final boolean e() {
        return this.l;
    }

    public final JSONArray f() {
        return this.v;
    }

    public final JSONArray g() {
        return this.u;
    }

    public final String h() {
        return this.r;
    }

    public final String i() {
        return this.t;
    }

    public final String j() {
        return this.o;
    }

    public final int k() {
        return this.f9739e;
    }

    public final EnumSet<o0> l() {
        return this.f9740f;
    }

    public final String m() {
        return this.s;
    }

    public final boolean n() {
        return this.f9736b;
    }
}
