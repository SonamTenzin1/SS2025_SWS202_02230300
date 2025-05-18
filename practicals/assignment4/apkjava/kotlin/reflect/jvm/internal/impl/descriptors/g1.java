package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.y.internal.j0.l.w1.k;

/* compiled from: ValueClassRepresentation.kt */
/* loaded from: classes2.dex */
public abstract class g1<Type extends kotlin.reflect.y.internal.j0.l.w1.k> {
    private g1() {
    }

    public /* synthetic */ g1(kotlin.jvm.internal.g gVar) {
        this();
    }

    public abstract List<Pair<kotlin.reflect.y.internal.j0.f.f, Type>> a();

    public final <Other extends kotlin.reflect.y.internal.j0.l.w1.k> g1<Other> b(Function1<? super Type, ? extends Other> function1) {
        int u;
        kotlin.jvm.internal.m.f(function1, "transform");
        if (this instanceof z) {
            z zVar = (z) this;
            return new z(zVar.c(), function1.invoke(zVar.d()));
        }
        if (!(this instanceof h0)) {
            throw new NoWhenBranchMatchedException();
        }
        List<Pair<kotlin.reflect.y.internal.j0.f.f, Type>> a = a();
        u = kotlin.collections.v.u(a, 10);
        ArrayList arrayList = new ArrayList(u);
        Iterator<T> it = a.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            arrayList.add(kotlin.s.a((kotlin.reflect.y.internal.j0.f.f) pair.a(), function1.invoke((kotlin.reflect.y.internal.j0.l.w1.k) pair.b())));
        }
        return new h0(arrayList);
    }
}
