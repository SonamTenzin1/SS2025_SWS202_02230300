package com.airbnb.epoxy.preload;

import com.airbnb.epoxy.preload.c;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.collections.IntIterator;
import kotlin.collections.v;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.m;
import kotlin.ranges.IntRange;
import kotlin.ranges.l;

/* compiled from: PreloadTargetProvider.kt */
/* loaded from: classes.dex */
public final class d<P extends c> {
    private final ArrayDeque<P> a;

    public d(int i2, Function0<? extends P> function0) {
        IntRange k2;
        int u;
        m.g(function0, "requestHolderFactory");
        k2 = l.k(0, i2);
        u = v.u(k2, 10);
        ArrayList arrayList = new ArrayList(u);
        Iterator<Integer> it = k2.iterator();
        while (it.hasNext()) {
            ((IntIterator) it).b();
            arrayList.add(function0.invoke());
        }
        this.a = new ArrayDeque<>(arrayList);
    }

    public final void a() {
        Iterator<T> it = this.a.iterator();
        while (it.hasNext()) {
            ((c) it.next()).clear();
        }
    }

    public final P b() {
        P poll = this.a.poll();
        this.a.offer(poll);
        poll.clear();
        m.b(poll, "result");
        return poll;
    }
}
