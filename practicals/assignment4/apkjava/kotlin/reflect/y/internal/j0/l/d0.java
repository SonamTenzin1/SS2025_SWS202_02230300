package kotlin.reflect.y.internal.j0.l;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.collections.c0;
import kotlin.collections.u;
import kotlin.collections.v;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.descriptors.e1;
import kotlin.reflect.y.internal.j0.i.w.n;
import kotlin.reflect.y.internal.j0.l.t1.g;
import kotlin.reflect.y.internal.j0.l.w1.h;

/* compiled from: IntersectionTypeConstructor.kt */
/* loaded from: classes3.dex */
public final class d0 implements e1, h {
    private e0 a;

    /* renamed from: b, reason: collision with root package name */
    private final LinkedHashSet<e0> f24681b;

    /* renamed from: c, reason: collision with root package name */
    private final int f24682c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: IntersectionTypeConstructor.kt */
    /* loaded from: classes3.dex */
    public static final class a extends Lambda implements Function1<g, m0> {
        a() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final m0 invoke(g gVar) {
            m.f(gVar, "kotlinTypeRefiner");
            return d0.this.b(gVar).h();
        }
    }

    /* compiled from: Comparisons.kt */
    /* loaded from: classes3.dex */
    public static final class b<T> implements Comparator {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ Function1 f24684f;

        public b(Function1 function1) {
            this.f24684f = function1;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t, T t2) {
            int a;
            e0 e0Var = (e0) t;
            Function1 function1 = this.f24684f;
            m.e(e0Var, "it");
            String obj = function1.invoke(e0Var).toString();
            e0 e0Var2 = (e0) t2;
            Function1 function12 = this.f24684f;
            m.e(e0Var2, "it");
            a = kotlin.comparisons.b.a(obj, function12.invoke(e0Var2).toString());
            return a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: IntersectionTypeConstructor.kt */
    /* loaded from: classes3.dex */
    public static final class c extends Lambda implements Function1<e0, String> {

        /* renamed from: f, reason: collision with root package name */
        public static final c f24685f = new c();

        c() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final String invoke(e0 e0Var) {
            m.f(e0Var, "it");
            return e0Var.toString();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: IntersectionTypeConstructor.kt */
    /* loaded from: classes3.dex */
    public static final class d extends Lambda implements Function1<e0, CharSequence> {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ Function1<e0, Object> f24686f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        d(Function1<? super e0, ? extends Object> function1) {
            super(1);
            this.f24686f = function1;
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final CharSequence invoke(e0 e0Var) {
            Function1<e0, Object> function1 = this.f24686f;
            m.e(e0Var, "it");
            return function1.invoke(e0Var).toString();
        }
    }

    public d0(Collection<? extends e0> collection) {
        m.f(collection, "typesToIntersect");
        collection.isEmpty();
        LinkedHashSet<e0> linkedHashSet = new LinkedHashSet<>(collection);
        this.f24681b = linkedHashSet;
        this.f24682c = linkedHashSet.hashCode();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ String k(d0 d0Var, Function1 function1, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            function1 = c.f24685f;
        }
        return d0Var.j(function1);
    }

    @Override // kotlin.reflect.y.internal.j0.l.e1
    public Collection<e0> a() {
        return this.f24681b;
    }

    @Override // kotlin.reflect.y.internal.j0.l.e1
    /* renamed from: c */
    public kotlin.reflect.jvm.internal.impl.descriptors.h w() {
        return null;
    }

    @Override // kotlin.reflect.y.internal.j0.l.e1
    public boolean e() {
        return false;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof d0) {
            return m.a(this.f24681b, ((d0) obj).f24681b);
        }
        return false;
    }

    public final kotlin.reflect.y.internal.j0.i.w.h g() {
        return n.f24432b.a("member scope for intersection type", this.f24681b);
    }

    @Override // kotlin.reflect.y.internal.j0.l.e1
    public List<e1> getParameters() {
        List<e1> j2;
        j2 = u.j();
        return j2;
    }

    public final m0 h() {
        List j2;
        a1 h2 = a1.f24676g.h();
        j2 = u.j();
        return f0.k(h2, this, j2, false, g(), new a());
    }

    public int hashCode() {
        return this.f24682c;
    }

    public final e0 i() {
        return this.a;
    }

    public final String j(Function1<? super e0, ? extends Object> function1) {
        List x0;
        String e0;
        m.f(function1, "getProperTypeRelatedToStringify");
        x0 = c0.x0(this.f24681b, new b(function1));
        e0 = c0.e0(x0, " & ", "{", "}", 0, null, new d(function1), 24, null);
        return e0;
    }

    @Override // kotlin.reflect.y.internal.j0.l.e1
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public d0 b(g gVar) {
        int u;
        m.f(gVar, "kotlinTypeRefiner");
        Collection<e0> a2 = a();
        u = v.u(a2, 10);
        ArrayList arrayList = new ArrayList(u);
        Iterator<T> it = a2.iterator();
        boolean z = false;
        while (it.hasNext()) {
            arrayList.add(((e0) it.next()).Y0(gVar));
            z = true;
        }
        d0 d0Var = null;
        if (z) {
            e0 i2 = i();
            d0Var = new d0(arrayList).m(i2 != null ? i2.Y0(gVar) : null);
        }
        return d0Var == null ? this : d0Var;
    }

    public final d0 m(e0 e0Var) {
        return new d0(this.f24681b, e0Var);
    }

    @Override // kotlin.reflect.y.internal.j0.l.e1
    public kotlin.reflect.y.internal.j0.b.h o() {
        kotlin.reflect.y.internal.j0.b.h o = this.f24681b.iterator().next().O0().o();
        m.e(o, "intersectedTypes.iterato…xt().constructor.builtIns");
        return o;
    }

    public String toString() {
        return k(this, null, 1, null);
    }

    private d0(Collection<? extends e0> collection, e0 e0Var) {
        this(collection);
        this.a = e0Var;
    }
}
