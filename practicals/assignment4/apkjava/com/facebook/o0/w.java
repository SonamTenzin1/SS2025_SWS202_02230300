package com.facebook.o0;

import android.content.Context;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: AppEventCollection.kt */
/* loaded from: classes.dex */
public final class w {
    private final HashMap<t, i0> a = new HashMap<>();

    private final synchronized i0 e(t tVar) {
        i0 i0Var = this.a.get(tVar);
        if (i0Var == null) {
            com.facebook.a0 a0Var = com.facebook.a0.a;
            Context c2 = com.facebook.a0.c();
            com.facebook.internal.q e2 = com.facebook.internal.q.a.e(c2);
            if (e2 != null) {
                i0Var = new i0(e2, a0.a.c(c2));
            }
        }
        if (i0Var == null) {
            return null;
        }
        this.a.put(tVar, i0Var);
        return i0Var;
    }

    public final synchronized void a(t tVar, v vVar) {
        kotlin.jvm.internal.m.f(tVar, "accessTokenAppIdPair");
        kotlin.jvm.internal.m.f(vVar, "appEvent");
        i0 e2 = e(tVar);
        if (e2 != null) {
            e2.a(vVar);
        }
    }

    public final synchronized void b(h0 h0Var) {
        if (h0Var == null) {
            return;
        }
        for (Map.Entry<t, List<v>> entry : h0Var.b()) {
            i0 e2 = e(entry.getKey());
            if (e2 != null) {
                Iterator<v> it = entry.getValue().iterator();
                while (it.hasNext()) {
                    e2.a(it.next());
                }
            }
        }
    }

    public final synchronized i0 c(t tVar) {
        kotlin.jvm.internal.m.f(tVar, "accessTokenAppIdPair");
        return this.a.get(tVar);
    }

    public final synchronized int d() {
        int i2;
        i2 = 0;
        Iterator<i0> it = this.a.values().iterator();
        while (it.hasNext()) {
            i2 += it.next().c();
        }
        return i2;
    }

    public final synchronized Set<t> f() {
        Set<t> keySet;
        keySet = this.a.keySet();
        kotlin.jvm.internal.m.e(keySet, "stateMap.keys");
        return keySet;
    }
}
