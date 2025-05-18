package kotlin.reflect.y.internal.j0.i.r;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.collections.u;
import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.descriptors.g0;
import kotlin.reflect.jvm.internal.impl.descriptors.h;
import kotlin.reflect.y.internal.j0.l.e0;
import kotlin.reflect.y.internal.j0.l.e1;
import kotlin.reflect.y.internal.j0.l.t1.g;

/* compiled from: IntegerValueTypeConstructor.kt */
/* loaded from: classes3.dex */
public final class p implements e1 {
    private final long a;

    /* renamed from: b, reason: collision with root package name */
    private final g0 f24376b;

    /* renamed from: c, reason: collision with root package name */
    private final ArrayList<e0> f24377c;

    @Override // kotlin.reflect.y.internal.j0.l.e1
    public Collection<e0> a() {
        return this.f24377c;
    }

    @Override // kotlin.reflect.y.internal.j0.l.e1
    public e1 b(g gVar) {
        m.f(gVar, "kotlinTypeRefiner");
        return this;
    }

    @Override // kotlin.reflect.y.internal.j0.l.e1
    /* renamed from: c */
    public /* bridge */ /* synthetic */ h w() {
        return (h) g();
    }

    @Override // kotlin.reflect.y.internal.j0.l.e1
    public boolean e() {
        return false;
    }

    public Void g() {
        return null;
    }

    @Override // kotlin.reflect.y.internal.j0.l.e1
    public List<kotlin.reflect.jvm.internal.impl.descriptors.e1> getParameters() {
        List<kotlin.reflect.jvm.internal.impl.descriptors.e1> j2;
        j2 = u.j();
        return j2;
    }

    @Override // kotlin.reflect.y.internal.j0.l.e1
    public kotlin.reflect.y.internal.j0.b.h o() {
        return this.f24376b.o();
    }

    public String toString() {
        return "IntegerValueType(" + this.a + ')';
    }
}
