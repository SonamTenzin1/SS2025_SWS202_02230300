package com.facebook.o0.o0;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.IBinder;
import com.facebook.a0;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.text.v;
import okhttp3.HttpUrl;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: InAppPurchaseEventManager.kt */
/* loaded from: classes2.dex */
public final class i {
    public static final i a = new i();

    /* renamed from: b, reason: collision with root package name */
    private static final HashMap<String, Method> f10371b = new HashMap<>();

    /* renamed from: c, reason: collision with root package name */
    private static final HashMap<String, Class<?>> f10372c = new HashMap<>();

    /* renamed from: d, reason: collision with root package name */
    private static final String f10373d;

    /* renamed from: e, reason: collision with root package name */
    private static final SharedPreferences f10374e;

    /* renamed from: f, reason: collision with root package name */
    private static final SharedPreferences f10375f;

    static {
        a0 a0Var = a0.a;
        f10373d = a0.c().getPackageName();
        f10374e = a0.c().getSharedPreferences("com.facebook.internal.SKU_DETAILS", 0);
        f10375f = a0.c().getSharedPreferences("com.facebook.internal.PURCHASE", 0);
    }

    private i() {
    }

    public static final Object a(Context context, IBinder iBinder) {
        kotlin.jvm.internal.m.f(context, "context");
        return a.n(context, "com.android.vending.billing.IInAppBillingService$Stub", "asInterface", null, new Object[]{iBinder});
    }

    public static final void b() {
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        SharedPreferences sharedPreferences = f10374e;
        long j2 = sharedPreferences.getLong("LAST_CLEARED_TIME", 0L);
        if (j2 == 0) {
            sharedPreferences.edit().putLong("LAST_CLEARED_TIME", currentTimeMillis).apply();
        } else if (currentTimeMillis - j2 > 604800) {
            sharedPreferences.edit().clear().putLong("LAST_CLEARED_TIME", currentTimeMillis).apply();
        }
    }

    private final ArrayList<String> c(ArrayList<String> arrayList) {
        ArrayList<String> arrayList2 = new ArrayList<>();
        SharedPreferences.Editor edit = f10375f.edit();
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            String next = it.next();
            try {
                JSONObject jSONObject = new JSONObject(next);
                String string = jSONObject.getString("productId");
                long j2 = jSONObject.getLong("purchaseTime");
                String string2 = jSONObject.getString("purchaseToken");
                if (currentTimeMillis - (j2 / 1000) <= 86400 && !kotlin.jvm.internal.m.a(f10375f.getString(string, HttpUrl.FRAGMENT_ENCODE_SET), string2)) {
                    edit.putString(string, string2);
                    arrayList2.add(next);
                }
            } catch (JSONException unused) {
            }
        }
        edit.apply();
        return arrayList2;
    }

    private final Class<?> d(Context context, String str) {
        HashMap<String, Class<?>> hashMap = f10372c;
        Class<?> cls = hashMap.get(str);
        if (cls != null) {
            return cls;
        }
        m mVar = m.a;
        Class<?> b2 = m.b(context, str);
        if (b2 != null) {
            hashMap.put(str, b2);
        }
        return b2;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private final Method e(Class<?> cls, String str) {
        Class[] clsArr;
        Method c2;
        HashMap<String, Method> hashMap = f10371b;
        Method method = hashMap.get(str);
        if (method != null) {
            return method;
        }
        switch (str.hashCode()) {
            case -1801122596:
                if (str.equals("getPurchases")) {
                    Class cls2 = Integer.TYPE;
                    kotlin.jvm.internal.m.e(cls2, "TYPE");
                    clsArr = new Class[]{cls2, String.class, String.class, String.class};
                    break;
                }
                clsArr = null;
                break;
            case -1450694211:
                if (str.equals("isBillingSupported")) {
                    Class cls3 = Integer.TYPE;
                    kotlin.jvm.internal.m.e(cls3, "TYPE");
                    clsArr = new Class[]{cls3, String.class, String.class};
                    break;
                }
                clsArr = null;
                break;
            case -1123215065:
                if (str.equals("asInterface")) {
                    clsArr = new Class[]{IBinder.class};
                    break;
                }
                clsArr = null;
                break;
            case -594356707:
                if (str.equals("getPurchaseHistory")) {
                    Class cls4 = Integer.TYPE;
                    kotlin.jvm.internal.m.e(cls4, "TYPE");
                    clsArr = new Class[]{cls4, String.class, String.class, String.class, Bundle.class};
                    break;
                }
                clsArr = null;
                break;
            case -573310373:
                if (str.equals("getSkuDetails")) {
                    Class cls5 = Integer.TYPE;
                    kotlin.jvm.internal.m.e(cls5, "TYPE");
                    clsArr = new Class[]{cls5, String.class, String.class, Bundle.class};
                    break;
                }
                clsArr = null;
                break;
            default:
                clsArr = null;
                break;
        }
        if (clsArr == null) {
            m mVar = m.a;
            c2 = m.c(cls, str, null);
        } else {
            m mVar2 = m.a;
            c2 = m.c(cls, str, (Class[]) Arrays.copyOf(clsArr, clsArr.length));
        }
        if (c2 != null) {
            hashMap.put(str, c2);
        }
        return c2;
    }

    private final ArrayList<String> f(Context context, Object obj, String str) {
        ArrayList<String> stringArrayList;
        ArrayList<String> arrayList = new ArrayList<>();
        if (o(context, obj, str)) {
            String str2 = null;
            int i2 = 0;
            boolean z = false;
            do {
                Object n = n(context, "com.android.vending.billing.IInAppBillingService", "getPurchaseHistory", obj, new Object[]{6, f10373d, str, str2, new Bundle()});
                if (n != null) {
                    long currentTimeMillis = System.currentTimeMillis() / 1000;
                    Bundle bundle = (Bundle) n;
                    if (bundle.getInt("RESPONSE_CODE") == 0 && (stringArrayList = bundle.getStringArrayList("INAPP_PURCHASE_DATA_LIST")) != null) {
                        Iterator<String> it = stringArrayList.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            String next = it.next();
                            if (currentTimeMillis - (new JSONObject(next).getLong("purchaseTime") / 1000) > 1200) {
                                z = true;
                                break;
                            }
                            arrayList.add(next);
                            i2++;
                        }
                        str2 = bundle.getString("INAPP_CONTINUATION_TOKEN");
                        if (i2 < 30 || str2 == null) {
                            break;
                            break;
                        }
                    }
                }
                str2 = null;
                if (i2 < 30) {
                    break;
                }
            } while (!z);
        }
        return arrayList;
    }

    public static final ArrayList<String> g(Context context, Object obj) {
        i iVar;
        Class<?> d2;
        kotlin.jvm.internal.m.f(context, "context");
        ArrayList<String> arrayList = new ArrayList<>();
        return (obj == null || (d2 = (iVar = a).d(context, "com.android.vending.billing.IInAppBillingService")) == null || iVar.e(d2, "getPurchaseHistory") == null) ? arrayList : iVar.c(iVar.f(context, obj, "inapp"));
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0059 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x005b A[EDGE_INSN: B:20:0x005b->B:23:0x005b BREAK  A[LOOP:0: B:8:0x0012->B:19:?], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final ArrayList<String> h(Context context, Object obj, String str) {
        ArrayList<String> arrayList = new ArrayList<>();
        if (obj != null && o(context, obj, str)) {
            String str2 = null;
            int i2 = 0;
            do {
                Object n = n(context, "com.android.vending.billing.IInAppBillingService", "getPurchases", obj, new Object[]{3, f10373d, str, str2});
                if (n != null) {
                    Bundle bundle = (Bundle) n;
                    if (bundle.getInt("RESPONSE_CODE") == 0) {
                        ArrayList<String> stringArrayList = bundle.getStringArrayList("INAPP_PURCHASE_DATA_LIST");
                        if (stringArrayList == null) {
                            break;
                        }
                        i2 += stringArrayList.size();
                        arrayList.addAll(stringArrayList);
                        str2 = bundle.getString("INAPP_CONTINUATION_TOKEN");
                        if (i2 < 30) {
                            break;
                        }
                    }
                }
                str2 = null;
                if (i2 < 30) {
                }
            } while (str2 != null);
        }
        return arrayList;
    }

    public static final ArrayList<String> i(Context context, Object obj) {
        kotlin.jvm.internal.m.f(context, "context");
        i iVar = a;
        return iVar.c(iVar.h(context, obj, "inapp"));
    }

    public static final ArrayList<String> j(Context context, Object obj) {
        kotlin.jvm.internal.m.f(context, "context");
        i iVar = a;
        return iVar.c(iVar.h(context, obj, "subs"));
    }

    public static final Map<String, String> k(Context context, ArrayList<String> arrayList, Object obj, boolean z) {
        kotlin.jvm.internal.m.f(context, "context");
        kotlin.jvm.internal.m.f(arrayList, "skuList");
        Map<String, String> p = a.p(arrayList);
        ArrayList<String> arrayList2 = new ArrayList<>();
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (!p.containsKey(next)) {
                arrayList2.add(next);
            }
        }
        p.putAll(a.l(context, arrayList2, obj, z));
        return p;
    }

    private final Map<String, String> l(Context context, ArrayList<String> arrayList, Object obj, boolean z) {
        int size;
        Map<String, String> linkedHashMap = new LinkedHashMap<>();
        if (obj != null && !arrayList.isEmpty()) {
            Bundle bundle = new Bundle();
            bundle.putStringArrayList("ITEM_ID_LIST", arrayList);
            Object[] objArr = new Object[4];
            int i2 = 0;
            objArr[0] = 3;
            objArr[1] = f10373d;
            objArr[2] = z ? "subs" : "inapp";
            objArr[3] = bundle;
            Object n = n(context, "com.android.vending.billing.IInAppBillingService", "getSkuDetails", obj, objArr);
            if (n != null) {
                Bundle bundle2 = (Bundle) n;
                if (bundle2.getInt("RESPONSE_CODE") == 0) {
                    ArrayList<String> stringArrayList = bundle2.getStringArrayList("DETAILS_LIST");
                    if (stringArrayList != null && arrayList.size() == stringArrayList.size() && arrayList.size() - 1 >= 0) {
                        while (true) {
                            int i3 = i2 + 1;
                            String str = arrayList.get(i2);
                            kotlin.jvm.internal.m.e(str, "skuList[i]");
                            String str2 = stringArrayList.get(i2);
                            kotlin.jvm.internal.m.e(str2, "skuDetailsList[i]");
                            linkedHashMap.put(str, str2);
                            if (i3 > size) {
                                break;
                            }
                            i2 = i3;
                        }
                    }
                    q(linkedHashMap);
                }
            }
        }
        return linkedHashMap;
    }

    private final Object n(Context context, String str, String str2, Object obj, Object[] objArr) {
        Method e2;
        Class<?> d2 = d(context, str);
        if (d2 == null || (e2 = e(d2, str2)) == null) {
            return null;
        }
        m mVar = m.a;
        return m.e(d2, e2, obj, Arrays.copyOf(objArr, objArr.length));
    }

    private final boolean o(Context context, Object obj, String str) {
        Object n;
        return (obj == null || (n = n(context, "com.android.vending.billing.IInAppBillingService", "isBillingSupported", obj, new Object[]{3, f10373d, str})) == null || ((Integer) n).intValue() != 0) ? false : true;
    }

    private final Map<String, String> p(ArrayList<String> arrayList) {
        List v0;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            String next = it.next();
            String string = f10374e.getString(next, null);
            if (string != null) {
                v0 = v.v0(string, new String[]{";"}, false, 2, 2, null);
                if (currentTimeMillis - Long.parseLong((String) v0.get(0)) < 43200) {
                    kotlin.jvm.internal.m.e(next, "sku");
                    linkedHashMap.put(next, v0.get(1));
                }
            }
        }
        return linkedHashMap;
    }

    private final void q(Map<String, String> map) {
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        SharedPreferences.Editor edit = f10374e.edit();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            edit.putString(entry.getKey(), currentTimeMillis + ';' + entry.getValue());
        }
        edit.apply();
    }

    public final boolean m(String str) {
        kotlin.jvm.internal.m.f(str, "skuDetail");
        try {
            String optString = new JSONObject(str).optString("freeTrialPeriod");
            if (optString != null) {
                return optString.length() > 0;
            }
            return false;
        } catch (JSONException unused) {
            return false;
        }
    }
}
