package kotlin.reflect.y.internal.j0.l.u1;

import java.util.List;
import java.util.Set;
import kotlin.collections.u;
import kotlin.collections.v0;
import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.descriptors.d;
import kotlin.reflect.jvm.internal.impl.descriptors.d0;
import kotlin.reflect.jvm.internal.impl.descriptors.e;
import kotlin.reflect.jvm.internal.impl.descriptors.g0;
import kotlin.reflect.jvm.internal.impl.descriptors.i1;
import kotlin.reflect.jvm.internal.impl.descriptors.n1.g;
import kotlin.reflect.jvm.internal.impl.descriptors.p1.h;
import kotlin.reflect.jvm.internal.impl.descriptors.t;
import kotlin.reflect.jvm.internal.impl.descriptors.z0;
import kotlin.reflect.y.internal.j0.f.f;
import kotlin.reflect.y.internal.j0.l.j1;
import kotlin.reflect.y.internal.j0.l.l1;
import okhttp3.HttpUrl;

/* compiled from: ErrorClassDescriptor.kt */
/* loaded from: classes3.dex */
public final class a extends h {
    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public a(f fVar) {
        super(r1, fVar, r3, r4, r5, r11, false, kotlin.reflect.y.internal.j0.k.f.f24650b);
        List j2;
        List<i1> j3;
        Set<d> c2;
        m.f(fVar, "name");
        k kVar = k.a;
        g0 i2 = kVar.i();
        d0 d0Var = d0.OPEN;
        kotlin.reflect.jvm.internal.impl.descriptors.f fVar2 = kotlin.reflect.jvm.internal.impl.descriptors.f.CLASS;
        j2 = u.j();
        z0 z0Var = z0.a;
        kotlin.reflect.jvm.internal.impl.descriptors.p1.f o1 = kotlin.reflect.jvm.internal.impl.descriptors.p1.f.o1(this, g.f25179c.b(), true, z0Var);
        j3 = u.j();
        o1.r1(j3, t.f25367d);
        m.e(o1, "create(this, Annotations…          )\n            }");
        g gVar = g.SCOPE_FOR_ERROR_CLASS;
        String fVar3 = o1.getName().toString();
        m.e(fVar3, "errorConstructor.name.toString()");
        kotlin.reflect.y.internal.j0.i.w.h b2 = k.b(gVar, fVar3, HttpUrl.FRAGMENT_ENCODE_SET);
        j jVar = j.w0;
        o1.h1(new h(kVar.e(jVar, new String[0]), b2, jVar, null, false, new String[0], 24, null));
        c2 = v0.c(o1);
        L0(b2, c2, o1);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.p1.a, kotlin.reflect.jvm.internal.impl.descriptors.b1
    /* renamed from: A0 */
    public e c(l1 l1Var) {
        m.f(l1Var, "substitutor");
        return this;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.p1.h
    public String toString() {
        String k2 = getName().k();
        m.e(k2, "name.asString()");
        return k2;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.p1.a, kotlin.reflect.jvm.internal.impl.descriptors.p1.t
    public kotlin.reflect.y.internal.j0.i.w.h v(j1 j1Var, kotlin.reflect.y.internal.j0.l.t1.g gVar) {
        m.f(j1Var, "typeSubstitution");
        m.f(gVar, "kotlinTypeRefiner");
        g gVar2 = g.SCOPE_FOR_ERROR_CLASS;
        String fVar = getName().toString();
        m.e(fVar, "name.toString()");
        return k.b(gVar2, fVar, j1Var.toString());
    }
}
