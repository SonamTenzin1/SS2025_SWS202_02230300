package com.facebook.o0.o0;

import android.content.Context;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.text.u;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: InAppPurchaseBillingClientWrapper.kt */
/* loaded from: classes2.dex */
public final class h {

    /* renamed from: c, reason: collision with root package name */
    private static h f10360c;

    /* renamed from: g, reason: collision with root package name */
    private final Context f10364g;

    /* renamed from: h, reason: collision with root package name */
    private final Object f10365h;

    /* renamed from: i, reason: collision with root package name */
    private final Class<?> f10366i;

    /* renamed from: j, reason: collision with root package name */
    private final Class<?> f10367j;

    /* renamed from: k, reason: collision with root package name */
    private final Class<?> f10368k;
    private final Class<?> l;
    private final Class<?> m;
    private final Class<?> n;
    private final Class<?> o;
    private final Method p;
    private final Method q;
    private final Method r;
    private final Method s;
    private final Method t;
    private final Method u;
    private final Method v;
    private final l w;
    private final Set<String> x;
    public static final b a = new b(null);

    /* renamed from: b, reason: collision with root package name */
    private static final AtomicBoolean f10359b = new AtomicBoolean(false);

    /* renamed from: d, reason: collision with root package name */
    private static final AtomicBoolean f10361d = new AtomicBoolean(false);

    /* renamed from: e, reason: collision with root package name */
    private static final Map<String, JSONObject> f10362e = new ConcurrentHashMap();

    /* renamed from: f, reason: collision with root package name */
    private static final Map<String, JSONObject> f10363f = new ConcurrentHashMap();

    /* compiled from: InAppPurchaseBillingClientWrapper.kt */
    /* loaded from: classes2.dex */
    public static final class a implements InvocationHandler {
        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) {
            boolean p;
            kotlin.jvm.internal.m.f(obj, "proxy");
            kotlin.jvm.internal.m.f(method, "m");
            if (kotlin.jvm.internal.m.a(method.getName(), "onBillingSetupFinished")) {
                h.a.f().set(true);
            } else {
                String name = method.getName();
                kotlin.jvm.internal.m.e(name, "m.name");
                p = u.p(name, "onBillingServiceDisconnected", false, 2, null);
                if (p) {
                    h.a.f().set(false);
                }
            }
            return null;
        }
    }

    /* compiled from: InAppPurchaseBillingClientWrapper.kt */
    /* loaded from: classes2.dex */
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(kotlin.jvm.internal.g gVar) {
            this();
        }

        private final Object a(Context context, Class<?> cls) {
            Object e2;
            Object e3;
            Object e4;
            m mVar = m.a;
            Class<?> a = m.a("com.android.billingclient.api.BillingClient$Builder");
            Class<?> a2 = m.a("com.android.billingclient.api.PurchasesUpdatedListener");
            if (a == null || a2 == null) {
                return null;
            }
            Method d2 = m.d(cls, "newBuilder", Context.class);
            Method d3 = m.d(a, "enablePendingPurchases", new Class[0]);
            Method d4 = m.d(a, "setListener", a2);
            Method d5 = m.d(a, "build", new Class[0]);
            if (d2 == null || d3 == null || d4 == null || d5 == null || (e2 = m.e(cls, d2, null, context)) == null || (e3 = m.e(a, d4, e2, Proxy.newProxyInstance(a2.getClassLoader(), new Class[]{a2}, new d()))) == null || (e4 = m.e(a, d3, e3, new Object[0])) == null) {
                return null;
            }
            return m.e(a, d5, e4, new Object[0]);
        }

        private final void b(Context context) {
            l b2 = l.a.b();
            if (b2 == null) {
                return;
            }
            m mVar = m.a;
            Class<?> a = m.a("com.android.billingclient.api.BillingClient");
            Class<?> a2 = m.a("com.android.billingclient.api.Purchase");
            Class<?> a3 = m.a("com.android.billingclient.api.Purchase$PurchasesResult");
            Class<?> a4 = m.a("com.android.billingclient.api.SkuDetails");
            Class<?> a5 = m.a("com.android.billingclient.api.PurchaseHistoryRecord");
            Class<?> a6 = m.a("com.android.billingclient.api.SkuDetailsResponseListener");
            Class<?> a7 = m.a("com.android.billingclient.api.PurchaseHistoryResponseListener");
            if (a == null || a3 == null || a2 == null || a4 == null || a6 == null || a5 == null || a7 == null) {
                return;
            }
            Method d2 = m.d(a, "queryPurchases", String.class);
            Method d3 = m.d(a3, "getPurchasesList", new Class[0]);
            Method d4 = m.d(a2, "getOriginalJson", new Class[0]);
            Method d5 = m.d(a4, "getOriginalJson", new Class[0]);
            Method d6 = m.d(a5, "getOriginalJson", new Class[0]);
            Method d7 = m.d(a, "querySkuDetailsAsync", b2.e(), a6);
            Method d8 = m.d(a, "queryPurchaseHistoryAsync", String.class, a7);
            if (d2 == null || d3 == null || d4 == null || d5 == null || d6 == null || d7 == null || d8 == null) {
                return;
            }
            Object a8 = a(context, a);
            if (a8 == null) {
                return;
            }
            h.f10360c = new h(context, a8, a, a3, a2, a4, a5, a6, a7, d2, d3, d4, d5, d6, d7, d8, b2, null);
            h hVar = h.f10360c;
            if (hVar == null) {
                throw new NullPointerException("null cannot be cast to non-null type com.facebook.appevents.iap.InAppPurchaseBillingClientWrapper");
            }
            hVar.t();
        }

        public final synchronized h c(Context context) {
            kotlin.jvm.internal.m.f(context, "context");
            if (h.f10359b.get()) {
                return h.f10360c;
            }
            b(context);
            h.f10359b.set(true);
            return h.f10360c;
        }

        public final Map<String, JSONObject> d() {
            return h.f10362e;
        }

        public final Map<String, JSONObject> e() {
            return h.f10363f;
        }

        public final AtomicBoolean f() {
            return h.f10361d;
        }
    }

    /* compiled from: InAppPurchaseBillingClientWrapper.kt */
    /* loaded from: classes2.dex */
    public final class c implements InvocationHandler {
        private Runnable a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ h f10369b;

        public c(h hVar, Runnable runnable) {
            kotlin.jvm.internal.m.f(hVar, "this$0");
            kotlin.jvm.internal.m.f(runnable, "runnable");
            this.f10369b = hVar;
            this.a = runnable;
        }

        private final void a(List<?> list) {
            for (Object obj : list) {
                try {
                    m mVar = m.a;
                    Object e2 = m.e(this.f10369b.m, this.f10369b.t, obj, new Object[0]);
                    String str = e2 instanceof String ? (String) e2 : null;
                    if (str != null) {
                        JSONObject jSONObject = new JSONObject(str);
                        jSONObject.put("packageName", this.f10369b.f10364g.getPackageName());
                        if (jSONObject.has("productId")) {
                            String string = jSONObject.getString("productId");
                            this.f10369b.x.add(string);
                            Map<String, JSONObject> d2 = h.a.d();
                            kotlin.jvm.internal.m.e(string, "skuID");
                            d2.put(string, jSONObject);
                        }
                    }
                } catch (Exception unused) {
                }
            }
            this.a.run();
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) {
            kotlin.jvm.internal.m.f(obj, "proxy");
            kotlin.jvm.internal.m.f(method, "method");
            if (kotlin.jvm.internal.m.a(method.getName(), "onPurchaseHistoryResponse")) {
                Object obj2 = objArr == null ? null : objArr[1];
                if (obj2 != null && (obj2 instanceof List)) {
                    a((List) obj2);
                }
            }
            return null;
        }
    }

    /* compiled from: InAppPurchaseBillingClientWrapper.kt */
    /* loaded from: classes2.dex */
    public static final class d implements InvocationHandler {
        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) {
            kotlin.jvm.internal.m.f(obj, "proxy");
            kotlin.jvm.internal.m.f(method, "m");
            return null;
        }
    }

    /* compiled from: InAppPurchaseBillingClientWrapper.kt */
    /* loaded from: classes2.dex */
    public final class e implements InvocationHandler {
        private Runnable a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ h f10370b;

        public e(h hVar, Runnable runnable) {
            kotlin.jvm.internal.m.f(hVar, "this$0");
            kotlin.jvm.internal.m.f(runnable, "runnable");
            this.f10370b = hVar;
            this.a = runnable;
        }

        public final void a(List<?> list) {
            kotlin.jvm.internal.m.f(list, "skuDetailsObjectList");
            for (Object obj : list) {
                try {
                    m mVar = m.a;
                    Object e2 = m.e(this.f10370b.l, this.f10370b.s, obj, new Object[0]);
                    String str = e2 instanceof String ? (String) e2 : null;
                    if (str != null) {
                        JSONObject jSONObject = new JSONObject(str);
                        if (jSONObject.has("productId")) {
                            String string = jSONObject.getString("productId");
                            Map<String, JSONObject> e3 = h.a.e();
                            kotlin.jvm.internal.m.e(string, "skuID");
                            e3.put(string, jSONObject);
                        }
                    }
                } catch (Exception unused) {
                }
            }
            this.a.run();
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) {
            kotlin.jvm.internal.m.f(obj, "proxy");
            kotlin.jvm.internal.m.f(method, "m");
            if (kotlin.jvm.internal.m.a(method.getName(), "onSkuDetailsResponse")) {
                Object obj2 = objArr == null ? null : objArr[1];
                if (obj2 != null && (obj2 instanceof List)) {
                    a((List) obj2);
                }
            }
            return null;
        }
    }

    private h(Context context, Object obj, Class<?> cls, Class<?> cls2, Class<?> cls3, Class<?> cls4, Class<?> cls5, Class<?> cls6, Class<?> cls7, Method method, Method method2, Method method3, Method method4, Method method5, Method method6, Method method7, l lVar) {
        this.f10364g = context;
        this.f10365h = obj;
        this.f10366i = cls;
        this.f10367j = cls2;
        this.f10368k = cls3;
        this.l = cls4;
        this.m = cls5;
        this.n = cls6;
        this.o = cls7;
        this.p = method;
        this.q = method2;
        this.r = method3;
        this.s = method4;
        this.t = method5;
        this.u = method6;
        this.v = method7;
        this.w = lVar;
        this.x = new CopyOnWriteArraySet();
    }

    public /* synthetic */ h(Context context, Object obj, Class cls, Class cls2, Class cls3, Class cls4, Class cls5, Class cls6, Class cls7, Method method, Method method2, Method method3, Method method4, Method method5, Method method6, Method method7, l lVar, kotlin.jvm.internal.g gVar) {
        this(context, obj, cls, cls2, cls3, cls4, cls5, cls6, cls7, method, method2, method3, method4, method5, method6, method7, lVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(h hVar, Runnable runnable) {
        kotlin.jvm.internal.m.f(hVar, "this$0");
        kotlin.jvm.internal.m.f(runnable, "$queryPurchaseHistoryRunnable");
        hVar.s("inapp", new ArrayList(hVar.x), runnable);
    }

    private final void r(String str, Runnable runnable) {
        Object newProxyInstance = Proxy.newProxyInstance(this.o.getClassLoader(), new Class[]{this.o}, new c(this, runnable));
        m mVar = m.a;
        m.e(this.f10366i, this.v, this.f10365h, str, newProxyInstance);
    }

    private final void s(String str, List<String> list, Runnable runnable) {
        Object newProxyInstance = Proxy.newProxyInstance(this.n.getClassLoader(), new Class[]{this.n}, new e(this, runnable));
        Object d2 = this.w.d(str, list);
        m mVar = m.a;
        m.e(this.f10366i, this.u, this.f10365h, d2, newProxyInstance);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void t() {
        Method d2;
        m mVar = m.a;
        Class<?> a2 = m.a("com.android.billingclient.api.BillingClientStateListener");
        if (a2 == null || (d2 = m.d(this.f10366i, "startConnection", a2)) == null) {
            return;
        }
        m.e(this.f10366i, d2, this.f10365h, Proxy.newProxyInstance(a2.getClassLoader(), new Class[]{a2}, new a()));
    }

    public final void o(String str, Runnable runnable) {
        kotlin.jvm.internal.m.f(str, "skuType");
        kotlin.jvm.internal.m.f(runnable, "querySkuRunnable");
        m mVar = m.a;
        Object e2 = m.e(this.f10367j, this.q, m.e(this.f10366i, this.p, this.f10365h, "inapp"), new Object[0]);
        List list = e2 instanceof List ? (List) e2 : null;
        if (list == null) {
            return;
        }
        try {
            ArrayList arrayList = new ArrayList();
            for (Object obj : list) {
                m mVar2 = m.a;
                Object e3 = m.e(this.f10368k, this.r, obj, new Object[0]);
                String str2 = e3 instanceof String ? (String) e3 : null;
                if (str2 != null) {
                    JSONObject jSONObject = new JSONObject(str2);
                    if (jSONObject.has("productId")) {
                        String string = jSONObject.getString("productId");
                        arrayList.add(string);
                        Map<String, JSONObject> map = f10362e;
                        kotlin.jvm.internal.m.e(string, "skuID");
                        map.put(string, jSONObject);
                    }
                }
            }
            s(str, arrayList, runnable);
        } catch (JSONException unused) {
        }
    }

    public final void p(String str, final Runnable runnable) {
        kotlin.jvm.internal.m.f(str, "skuType");
        kotlin.jvm.internal.m.f(runnable, "queryPurchaseHistoryRunnable");
        r(str, new Runnable() { // from class: com.facebook.o0.o0.e
            @Override // java.lang.Runnable
            public final void run() {
                h.q(h.this, runnable);
            }
        });
    }
}
