package kotlin.reflect.y.internal.j0.j.b.g0;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.c0;
import kotlin.collections.t;
import kotlin.collections.v;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.c1;
import kotlin.reflect.jvm.internal.impl.descriptors.n1.c;
import kotlin.reflect.jvm.internal.impl.descriptors.n1.g;
import kotlin.reflect.jvm.internal.impl.descriptors.p1.b;
import kotlin.reflect.jvm.internal.impl.descriptors.z0;
import kotlin.reflect.y.internal.j0.e.q;
import kotlin.reflect.y.internal.j0.e.s;
import kotlin.reflect.y.internal.j0.f.f;
import kotlin.reflect.y.internal.j0.j.b.a0;
import kotlin.reflect.y.internal.j0.j.b.d0;
import kotlin.reflect.y.internal.j0.j.b.x;
import kotlin.reflect.y.internal.j0.k.n;
import kotlin.reflect.y.internal.j0.l.e0;

/* compiled from: DeserializedTypeParameterDescriptor.kt */
/* loaded from: classes3.dex */
public final class m extends b {
    private final kotlin.reflect.y.internal.j0.j.b.m p;
    private final s q;
    private final kotlin.reflect.y.internal.j0.j.b.g0.a r;

    /* compiled from: DeserializedTypeParameterDescriptor.kt */
    /* loaded from: classes3.dex */
    static final class a extends Lambda implements Function0<List<? extends c>> {
        a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final List<? extends c> invoke() {
            List<? extends c> E0;
            E0 = c0.E0(m.this.p.c().d().a(m.this.P0(), m.this.p.g()));
            return E0;
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public m(kotlin.reflect.y.internal.j0.j.b.m mVar, s sVar, int i2) {
        super(r2, r3, r4, r5, r0.d(r1), sVar.O(), i2, z0.a, c1.a.a);
        kotlin.jvm.internal.m.f(mVar, "c");
        kotlin.jvm.internal.m.f(sVar, "proto");
        n h2 = mVar.h();
        kotlin.reflect.jvm.internal.impl.descriptors.m e2 = mVar.e();
        g b2 = g.f25179c.b();
        f b3 = x.b(mVar.g(), sVar.N());
        a0 a0Var = a0.a;
        s.c T = sVar.T();
        kotlin.jvm.internal.m.e(T, "proto.variance");
        this.p = mVar;
        this.q = sVar;
        this.r = new kotlin.reflect.y.internal.j0.j.b.g0.a(mVar.h(), new a());
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.p1.e
    protected List<e0> M0() {
        int u;
        List<e0> e2;
        List<q> p = kotlin.reflect.y.internal.j0.e.z.f.p(this.q, this.p.j());
        if (p.isEmpty()) {
            e2 = t.e(kotlin.reflect.y.internal.j0.i.t.a.f(this).y());
            return e2;
        }
        d0 i2 = this.p.i();
        u = v.u(p, 10);
        ArrayList arrayList = new ArrayList(u);
        Iterator<T> it = p.iterator();
        while (it.hasNext()) {
            arrayList.add(i2.q((q) it.next()));
        }
        return arrayList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.n1.b, kotlin.reflect.jvm.internal.impl.descriptors.n1.a
    /* renamed from: O0, reason: merged with bridge method [inline-methods] */
    public kotlin.reflect.y.internal.j0.j.b.g0.a getAnnotations() {
        return this.r;
    }

    public final s P0() {
        return this.q;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.descriptors.p1.e
    /* renamed from: Q0, reason: merged with bridge method [inline-methods] */
    public Void L0(e0 e0Var) {
        kotlin.jvm.internal.m.f(e0Var, "type");
        throw new IllegalStateException("There should be no cycles for deserialized type parameters, but found for: " + this);
    }
}
