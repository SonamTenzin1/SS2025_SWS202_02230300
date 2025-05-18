package com.google.android.gms.internal.ads;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class gw {
    private static final gw a = new gw();

    /* renamed from: c, reason: collision with root package name */
    private final ConcurrentMap<Class<?>, lw<?>> f12662c = new ConcurrentHashMap();

    /* renamed from: b, reason: collision with root package name */
    private final mw f12661b = new pv();

    private gw() {
    }

    public static gw b() {
        return a;
    }

    public final <T> lw<T> a(T t) {
        return c(t.getClass());
    }

    public final <T> lw<T> c(Class<T> cls) {
        zzdod.d(cls, "messageType");
        lw<T> lwVar = (lw) this.f12662c.get(cls);
        if (lwVar != null) {
            return lwVar;
        }
        lw<T> a2 = this.f12661b.a(cls);
        zzdod.d(cls, "messageType");
        zzdod.d(a2, "schema");
        lw<T> lwVar2 = (lw) this.f12662c.putIfAbsent(cls, a2);
        return lwVar2 != null ? lwVar2 : a2;
    }
}
