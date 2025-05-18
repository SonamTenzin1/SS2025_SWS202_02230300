package com.facebook.internal;

import com.facebook.FacebookRequestError;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: FacebookRequestErrorClassification.kt */
/* loaded from: classes2.dex */
public final class x {
    public static final a a = new a(null);

    /* renamed from: b, reason: collision with root package name */
    private static x f9911b;

    /* renamed from: c, reason: collision with root package name */
    private final Map<Integer, Set<Integer>> f9912c;

    /* renamed from: d, reason: collision with root package name */
    private final Map<Integer, Set<Integer>> f9913d;

    /* renamed from: e, reason: collision with root package name */
    private final Map<Integer, Set<Integer>> f9914e;

    /* renamed from: f, reason: collision with root package name */
    private final String f9915f;

    /* renamed from: g, reason: collision with root package name */
    private final String f9916g;

    /* renamed from: h, reason: collision with root package name */
    private final String f9917h;

    /* compiled from: FacebookRequestErrorClassification.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
            this();
        }

        private final x c() {
            HashMap k2;
            HashMap k3;
            k2 = kotlin.collections.q0.k(kotlin.s.a(2, null), kotlin.s.a(4, null), kotlin.s.a(9, null), kotlin.s.a(17, null), kotlin.s.a(341, null));
            k3 = kotlin.collections.q0.k(kotlin.s.a(102, null), kotlin.s.a(190, null), kotlin.s.a(412, null));
            return new x(null, k2, k3, null, null, null);
        }

        private final Map<Integer, Set<Integer>> d(JSONObject jSONObject) {
            int optInt;
            HashSet hashSet;
            JSONArray optJSONArray = jSONObject.optJSONArray("items");
            if (optJSONArray == null || optJSONArray.length() == 0) {
                return null;
            }
            HashMap hashMap = new HashMap();
            int length = optJSONArray.length();
            if (length > 0) {
                int i2 = 0;
                while (true) {
                    int i3 = i2 + 1;
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
                    if (optJSONObject != null && (optInt = optJSONObject.optInt("code")) != 0) {
                        JSONArray optJSONArray2 = optJSONObject.optJSONArray("subcodes");
                        if (optJSONArray2 == null || optJSONArray2.length() <= 0) {
                            hashSet = null;
                        } else {
                            hashSet = new HashSet();
                            int length2 = optJSONArray2.length();
                            if (length2 > 0) {
                                int i4 = 0;
                                while (true) {
                                    int i5 = i4 + 1;
                                    int optInt2 = optJSONArray2.optInt(i4);
                                    if (optInt2 != 0) {
                                        hashSet.add(Integer.valueOf(optInt2));
                                    }
                                    if (i5 >= length2) {
                                        break;
                                    }
                                    i4 = i5;
                                }
                            }
                        }
                        hashMap.put(Integer.valueOf(optInt), hashSet);
                    }
                    if (i3 >= length) {
                        break;
                    }
                    i2 = i3;
                }
            }
            return hashMap;
        }

        public final x a(JSONArray jSONArray) {
            Map<Integer, Set<Integer>> map;
            Map<Integer, Set<Integer>> map2;
            Map<Integer, Set<Integer>> map3;
            String str;
            String str2;
            String str3;
            String optString;
            boolean q;
            boolean q2;
            boolean q3;
            if (jSONArray == null) {
                return null;
            }
            int i2 = 0;
            int length = jSONArray.length();
            if (length > 0) {
                Map<Integer, Set<Integer>> map4 = null;
                Map<Integer, Set<Integer>> map5 = null;
                Map<Integer, Set<Integer>> map6 = null;
                String str4 = null;
                String str5 = null;
                String str6 = null;
                while (true) {
                    int i3 = i2 + 1;
                    JSONObject optJSONObject = jSONArray.optJSONObject(i2);
                    if (optJSONObject != null && (optString = optJSONObject.optString("name")) != null) {
                        q = kotlin.text.u.q(optString, "other", true);
                        if (q) {
                            str4 = optJSONObject.optString("recovery_message", null);
                            map4 = d(optJSONObject);
                        } else {
                            q2 = kotlin.text.u.q(optString, "transient", true);
                            if (q2) {
                                str5 = optJSONObject.optString("recovery_message", null);
                                map5 = d(optJSONObject);
                            } else {
                                q3 = kotlin.text.u.q(optString, "login_recoverable", true);
                                if (q3) {
                                    str6 = optJSONObject.optString("recovery_message", null);
                                    map6 = d(optJSONObject);
                                }
                            }
                        }
                    }
                    if (i3 >= length) {
                        break;
                    }
                    i2 = i3;
                }
                map = map4;
                map2 = map5;
                map3 = map6;
                str = str4;
                str2 = str5;
                str3 = str6;
            } else {
                map = null;
                map2 = null;
                map3 = null;
                str = null;
                str2 = null;
                str3 = null;
            }
            return new x(map, map2, map3, str, str2, str3);
        }

        public final synchronized x b() {
            x xVar;
            if (x.f9911b == null) {
                x.f9911b = c();
            }
            xVar = x.f9911b;
            if (xVar == null) {
                throw new NullPointerException("null cannot be cast to non-null type com.facebook.internal.FacebookRequestErrorClassification");
            }
            return xVar;
        }
    }

    /* compiled from: FacebookRequestErrorClassification.kt */
    /* loaded from: classes2.dex */
    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[FacebookRequestError.a.valuesCustom().length];
            iArr[FacebookRequestError.a.OTHER.ordinal()] = 1;
            iArr[FacebookRequestError.a.LOGIN_RECOVERABLE.ordinal()] = 2;
            iArr[FacebookRequestError.a.TRANSIENT.ordinal()] = 3;
            a = iArr;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public x(Map<Integer, ? extends Set<Integer>> map, Map<Integer, ? extends Set<Integer>> map2, Map<Integer, ? extends Set<Integer>> map3, String str, String str2, String str3) {
        this.f9912c = map;
        this.f9913d = map2;
        this.f9914e = map3;
        this.f9915f = str;
        this.f9916g = str2;
        this.f9917h = str3;
    }

    public final FacebookRequestError.a c(int i2, int i3, boolean z) {
        Set<Integer> set;
        Set<Integer> set2;
        Set<Integer> set3;
        if (z) {
            return FacebookRequestError.a.TRANSIENT;
        }
        Map<Integer, Set<Integer>> map = this.f9912c;
        if (map != null && map.containsKey(Integer.valueOf(i2)) && ((set3 = this.f9912c.get(Integer.valueOf(i2))) == null || set3.contains(Integer.valueOf(i3)))) {
            return FacebookRequestError.a.OTHER;
        }
        Map<Integer, Set<Integer>> map2 = this.f9914e;
        if (map2 != null && map2.containsKey(Integer.valueOf(i2)) && ((set2 = this.f9914e.get(Integer.valueOf(i2))) == null || set2.contains(Integer.valueOf(i3)))) {
            return FacebookRequestError.a.LOGIN_RECOVERABLE;
        }
        Map<Integer, Set<Integer>> map3 = this.f9913d;
        if (map3 != null && map3.containsKey(Integer.valueOf(i2)) && ((set = this.f9913d.get(Integer.valueOf(i2))) == null || set.contains(Integer.valueOf(i3)))) {
            return FacebookRequestError.a.TRANSIENT;
        }
        return FacebookRequestError.a.OTHER;
    }

    public final String d(FacebookRequestError.a aVar) {
        int i2 = aVar == null ? -1 : b.a[aVar.ordinal()];
        if (i2 == 1) {
            return this.f9915f;
        }
        if (i2 == 2) {
            return this.f9917h;
        }
        if (i2 != 3) {
            return null;
        }
        return this.f9916g;
    }
}
