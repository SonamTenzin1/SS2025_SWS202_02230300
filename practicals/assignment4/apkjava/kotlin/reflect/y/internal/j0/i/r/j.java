package kotlin.reflect.y.internal.j0.i.r;

import kotlin.Pair;
import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.descriptors.e;
import kotlin.reflect.jvm.internal.impl.descriptors.g0;
import kotlin.reflect.jvm.internal.impl.descriptors.x;
import kotlin.reflect.y.internal.j0.f.b;
import kotlin.reflect.y.internal.j0.f.f;
import kotlin.reflect.y.internal.j0.i.d;
import kotlin.reflect.y.internal.j0.l.e0;
import kotlin.reflect.y.internal.j0.l.m0;
import kotlin.reflect.y.internal.j0.l.u1.k;
import kotlin.s;

/* compiled from: constantValues.kt */
/* loaded from: classes3.dex */
public final class j extends g<Pair<? extends b, ? extends f>> {

    /* renamed from: b, reason: collision with root package name */
    private final b f24362b;

    /* renamed from: c, reason: collision with root package name */
    private final f f24363c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(b bVar, f fVar) {
        super(s.a(bVar, fVar));
        m.f(bVar, "enumClassId");
        m.f(fVar, "enumEntryName");
        this.f24362b = bVar;
        this.f24363c = fVar;
    }

    @Override // kotlin.reflect.y.internal.j0.i.r.g
    public e0 a(g0 g0Var) {
        m.f(g0Var, "module");
        e a = x.a(g0Var, this.f24362b);
        m0 m0Var = null;
        if (a != null) {
            if (!d.A(a)) {
                a = null;
            }
            if (a != null) {
                m0Var = a.s();
            }
        }
        if (m0Var != null) {
            return m0Var;
        }
        kotlin.reflect.y.internal.j0.l.u1.j jVar = kotlin.reflect.y.internal.j0.l.u1.j.B0;
        String bVar = this.f24362b.toString();
        m.e(bVar, "enumClassId.toString()");
        String fVar = this.f24363c.toString();
        m.e(fVar, "enumEntryName.toString()");
        return k.d(jVar, bVar, fVar);
    }

    public final f c() {
        return this.f24363c;
    }

    @Override // kotlin.reflect.y.internal.j0.i.r.g
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f24362b.j());
        sb.append('.');
        sb.append(this.f24363c);
        return sb.toString();
    }
}
