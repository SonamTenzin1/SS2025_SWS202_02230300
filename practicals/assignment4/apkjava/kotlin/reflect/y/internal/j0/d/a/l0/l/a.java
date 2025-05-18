package kotlin.reflect.y.internal.j0.d.a.l0.l;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.collections.c0;
import kotlin.collections.p0;
import kotlin.collections.u;
import kotlin.collections.v;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.m;
import kotlin.ranges.l;
import kotlin.reflect.y.internal.j0.d.a.n0.g;
import kotlin.reflect.y.internal.j0.d.a.n0.n;
import kotlin.reflect.y.internal.j0.d.a.n0.p;
import kotlin.reflect.y.internal.j0.d.a.n0.q;
import kotlin.reflect.y.internal.j0.d.a.n0.r;
import kotlin.reflect.y.internal.j0.d.a.n0.w;
import kotlin.reflect.y.internal.j0.f.f;
import kotlin.sequences.Sequence;

/* compiled from: DeclaredMemberIndex.kt */
/* loaded from: classes2.dex */
public class a implements b {
    private final g a;

    /* renamed from: b, reason: collision with root package name */
    private final Function1<q, Boolean> f23476b;

    /* renamed from: c, reason: collision with root package name */
    private final Function1<r, Boolean> f23477c;

    /* renamed from: d, reason: collision with root package name */
    private final Map<f, List<r>> f23478d;

    /* renamed from: e, reason: collision with root package name */
    private final Map<f, n> f23479e;

    /* renamed from: f, reason: collision with root package name */
    private final Map<f, w> f23480f;

    /* compiled from: DeclaredMemberIndex.kt */
    /* renamed from: kotlin.f0.y.e.j0.d.a.l0.l.a$a, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    static final class C0331a extends Lambda implements Function1<r, Boolean> {
        C0331a() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(r rVar) {
            m.f(rVar, "m");
            return Boolean.valueOf(((Boolean) a.this.f23476b.invoke(rVar)).booleanValue() && !p.c(rVar));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a(g gVar, Function1<? super q, Boolean> function1) {
        Sequence J;
        Sequence l;
        Sequence J2;
        Sequence l2;
        int u;
        int e2;
        int b2;
        m.f(gVar, "jClass");
        m.f(function1, "memberFilter");
        this.a = gVar;
        this.f23476b = function1;
        C0331a c0331a = new C0331a();
        this.f23477c = c0331a;
        J = c0.J(gVar.M());
        l = kotlin.sequences.n.l(J, c0331a);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj : l) {
            f name = ((r) obj).getName();
            Object obj2 = linkedHashMap.get(name);
            if (obj2 == null) {
                obj2 = new ArrayList();
                linkedHashMap.put(name, obj2);
            }
            ((List) obj2).add(obj);
        }
        this.f23478d = linkedHashMap;
        J2 = c0.J(this.a.D());
        l2 = kotlin.sequences.n.l(J2, this.f23476b);
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        for (Object obj3 : l2) {
            linkedHashMap2.put(((n) obj3).getName(), obj3);
        }
        this.f23479e = linkedHashMap2;
        Collection<w> j2 = this.a.j();
        Function1<q, Boolean> function12 = this.f23476b;
        ArrayList arrayList = new ArrayList();
        for (Object obj4 : j2) {
            if (((Boolean) function12.invoke(obj4)).booleanValue()) {
                arrayList.add(obj4);
            }
        }
        u = v.u(arrayList, 10);
        e2 = p0.e(u);
        b2 = l.b(e2, 16);
        LinkedHashMap linkedHashMap3 = new LinkedHashMap(b2);
        for (Object obj5 : arrayList) {
            linkedHashMap3.put(((w) obj5).getName(), obj5);
        }
        this.f23480f = linkedHashMap3;
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.l0.l.b
    public Set<f> a() {
        Sequence J;
        Sequence l;
        J = c0.J(this.a.M());
        l = kotlin.sequences.n.l(J, this.f23477c);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator it = l.iterator();
        while (it.hasNext()) {
            linkedHashSet.add(((r) it.next()).getName());
        }
        return linkedHashSet;
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.l0.l.b
    public w b(f fVar) {
        m.f(fVar, "name");
        return this.f23480f.get(fVar);
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.l0.l.b
    public n c(f fVar) {
        m.f(fVar, "name");
        return this.f23479e.get(fVar);
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.l0.l.b
    public Set<f> d() {
        return this.f23480f.keySet();
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.l0.l.b
    public Set<f> e() {
        Sequence J;
        Sequence l;
        J = c0.J(this.a.D());
        l = kotlin.sequences.n.l(J, this.f23476b);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator it = l.iterator();
        while (it.hasNext()) {
            linkedHashSet.add(((n) it.next()).getName());
        }
        return linkedHashSet;
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.l0.l.b
    public Collection<r> f(f fVar) {
        List j2;
        m.f(fVar, "name");
        List<r> list = this.f23478d.get(fVar);
        if (list != null) {
            return list;
        }
        j2 = u.j();
        return j2;
    }
}
