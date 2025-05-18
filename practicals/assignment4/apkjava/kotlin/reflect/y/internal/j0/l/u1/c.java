package kotlin.reflect.y.internal.j0.l.u1;

import cm.aptoide.pt.database.room.RoomNotification;
import java.util.Collection;
import java.util.List;
import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.descriptors.a;
import kotlin.reflect.jvm.internal.impl.descriptors.b;
import kotlin.reflect.jvm.internal.impl.descriptors.d0;
import kotlin.reflect.jvm.internal.impl.descriptors.e;
import kotlin.reflect.jvm.internal.impl.descriptors.e1;
import kotlin.reflect.jvm.internal.impl.descriptors.i1;
import kotlin.reflect.jvm.internal.impl.descriptors.n1.g;
import kotlin.reflect.jvm.internal.impl.descriptors.p1.g0;
import kotlin.reflect.jvm.internal.impl.descriptors.p1.p;
import kotlin.reflect.jvm.internal.impl.descriptors.t;
import kotlin.reflect.jvm.internal.impl.descriptors.u;
import kotlin.reflect.jvm.internal.impl.descriptors.w0;
import kotlin.reflect.jvm.internal.impl.descriptors.y;
import kotlin.reflect.jvm.internal.impl.descriptors.y0;
import kotlin.reflect.jvm.internal.impl.descriptors.z0;
import kotlin.reflect.y.internal.j0.f.f;
import kotlin.reflect.y.internal.j0.l.e0;
import kotlin.reflect.y.internal.j0.l.j1;

/* compiled from: ErrorFunctionDescriptor.kt */
/* loaded from: classes3.dex */
public final class c extends g0 {

    /* compiled from: ErrorFunctionDescriptor.kt */
    /* loaded from: classes3.dex */
    public static final class a implements y.a<y0> {
        a() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.y.a
        public y.a<y0> a() {
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.y.a
        public y.a<y0> b(List<? extends i1> list) {
            m.f(list, "parameters");
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.y.a
        public y.a<y0> d(d0 d0Var) {
            m.f(d0Var, "modality");
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.y.a
        public y.a<y0> e(w0 w0Var) {
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.y.a
        public y.a<y0> f() {
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.y.a
        public y.a<y0> g(e0 e0Var) {
            m.f(e0Var, "type");
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.y.a
        public y.a<y0> h(b bVar) {
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.y.a
        public y.a<y0> i() {
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.y.a
        public y.a<y0> j(boolean z) {
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.y.a
        public y.a<y0> k(w0 w0Var) {
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.y.a
        public y.a<y0> l(j1 j1Var) {
            m.f(j1Var, "substitution");
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.y.a
        public y.a<y0> m(List<? extends e1> list) {
            m.f(list, "parameters");
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.y.a
        public <V> y.a<y0> n(a.InterfaceC0406a<V> interfaceC0406a, V v) {
            m.f(interfaceC0406a, "userDataKey");
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.y.a
        public y.a<y0> o(u uVar) {
            m.f(uVar, "visibility");
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.y.a
        public y.a<y0> p(kotlin.reflect.jvm.internal.impl.descriptors.m mVar) {
            m.f(mVar, "owner");
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.y.a
        public y.a<y0> q() {
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.y.a
        public y.a<y0> r(b.a aVar) {
            m.f(aVar, "kind");
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.y.a
        public y.a<y0> s(g gVar) {
            m.f(gVar, "additionalAnnotations");
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.y.a
        public y.a<y0> t(f fVar) {
            m.f(fVar, "name");
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.y.a
        public y.a<y0> u() {
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.descriptors.y.a
        /* renamed from: v, reason: merged with bridge method [inline-methods] */
        public y0 c() {
            return c.this;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(e eVar) {
        super(eVar, null, g.f25179c.b(), f.D(b.ERROR_FUNCTION.k()), b.a.DECLARATION, z0.a);
        List<w0> j2;
        List<? extends e1> j3;
        List<i1> j4;
        m.f(eVar, "containingDeclaration");
        j2 = kotlin.collections.u.j();
        j3 = kotlin.collections.u.j();
        j4 = kotlin.collections.u.j();
        S0(null, null, j2, j3, j4, k.d(j.n, new String[0]), d0.OPEN, t.f25368e);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.p1.g0, kotlin.reflect.jvm.internal.impl.descriptors.p1.p
    protected p M0(kotlin.reflect.jvm.internal.impl.descriptors.m mVar, y yVar, b.a aVar, f fVar, g gVar, z0 z0Var) {
        m.f(mVar, "newOwner");
        m.f(aVar, "kind");
        m.f(gVar, "annotations");
        m.f(z0Var, "source");
        return this;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.p1.p, kotlin.reflect.jvm.internal.impl.descriptors.a
    public <V> V i0(a.InterfaceC0406a<V> interfaceC0406a) {
        m.f(interfaceC0406a, RoomNotification.KEY);
        return null;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.p1.p, kotlin.reflect.jvm.internal.impl.descriptors.y
    public boolean isSuspend() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.p1.g0, kotlin.reflect.jvm.internal.impl.descriptors.p1.p, kotlin.reflect.jvm.internal.impl.descriptors.b
    /* renamed from: l1, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public y0 k0(kotlin.reflect.jvm.internal.impl.descriptors.m mVar, d0 d0Var, u uVar, b.a aVar, boolean z) {
        m.f(mVar, "newOwner");
        m.f(d0Var, "modality");
        m.f(uVar, "visibility");
        m.f(aVar, "kind");
        return this;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.p1.g0, kotlin.reflect.jvm.internal.impl.descriptors.p1.p, kotlin.reflect.jvm.internal.impl.descriptors.y, kotlin.reflect.jvm.internal.impl.descriptors.y0
    public y.a<y0> u() {
        return new a();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.p1.p, kotlin.reflect.jvm.internal.impl.descriptors.b
    public void x0(Collection<? extends b> collection) {
        m.f(collection, "overriddenDescriptors");
    }
}
