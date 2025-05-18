package com.facebook.o0.o0;

import java.lang.reflect.Method;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: InAppPurchaseSkuDetailsWrapper.kt */
/* loaded from: classes2.dex */
public final class l {

    /* renamed from: b, reason: collision with root package name */
    private static l f10380b;

    /* renamed from: d, reason: collision with root package name */
    private final Class<?> f10382d;

    /* renamed from: e, reason: collision with root package name */
    private final Class<?> f10383e;

    /* renamed from: f, reason: collision with root package name */
    private final Method f10384f;

    /* renamed from: g, reason: collision with root package name */
    private final Method f10385g;

    /* renamed from: h, reason: collision with root package name */
    private final Method f10386h;

    /* renamed from: i, reason: collision with root package name */
    private final Method f10387i;
    public static final a a = new a(null);

    /* renamed from: c, reason: collision with root package name */
    private static final AtomicBoolean f10381c = new AtomicBoolean(false);

    /* compiled from: InAppPurchaseSkuDetailsWrapper.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
            this();
        }

        private final void a() {
            m mVar = m.a;
            Class<?> a = m.a("com.android.billingclient.api.SkuDetailsParams");
            Class<?> a2 = m.a("com.android.billingclient.api.SkuDetailsParams$Builder");
            if (a == null || a2 == null) {
                return;
            }
            Method d2 = m.d(a, "newBuilder", new Class[0]);
            Method d3 = m.d(a2, "setType", String.class);
            Method d4 = m.d(a2, "setSkusList", List.class);
            Method d5 = m.d(a2, "build", new Class[0]);
            if (d2 == null || d3 == null || d4 == null || d5 == null) {
                return;
            }
            l.f10380b = new l(a, a2, d2, d3, d4, d5);
        }

        public final l b() {
            if (l.f10381c.get()) {
                return l.f10380b;
            }
            a();
            l.f10381c.set(true);
            return l.f10380b;
        }
    }

    public l(Class<?> cls, Class<?> cls2, Method method, Method method2, Method method3, Method method4) {
        kotlin.jvm.internal.m.f(cls, "skuDetailsParamsClazz");
        kotlin.jvm.internal.m.f(cls2, "builderClazz");
        kotlin.jvm.internal.m.f(method, "newBuilderMethod");
        kotlin.jvm.internal.m.f(method2, "setTypeMethod");
        kotlin.jvm.internal.m.f(method3, "setSkusListMethod");
        kotlin.jvm.internal.m.f(method4, "buildMethod");
        this.f10382d = cls;
        this.f10383e = cls2;
        this.f10384f = method;
        this.f10385g = method2;
        this.f10386h = method3;
        this.f10387i = method4;
    }

    public final Object d(String str, List<String> list) {
        Object e2;
        Object e3;
        m mVar = m.a;
        Object e4 = m.e(this.f10382d, this.f10384f, null, new Object[0]);
        if (e4 == null || (e2 = m.e(this.f10383e, this.f10385g, e4, str)) == null || (e3 = m.e(this.f10383e, this.f10386h, e2, list)) == null) {
            return null;
        }
        return m.e(this.f10383e, this.f10387i, e3, new Object[0]);
    }

    public final Class<?> e() {
        return this.f10382d;
    }
}
