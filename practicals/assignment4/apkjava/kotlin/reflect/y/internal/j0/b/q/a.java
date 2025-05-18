package kotlin.reflect.y.internal.j0.b.q;

import java.util.List;
import kotlin.collections.u;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.descriptors.b;
import kotlin.reflect.jvm.internal.impl.descriptors.d0;
import kotlin.reflect.jvm.internal.impl.descriptors.e1;
import kotlin.reflect.jvm.internal.impl.descriptors.i1;
import kotlin.reflect.jvm.internal.impl.descriptors.p1.g0;
import kotlin.reflect.jvm.internal.impl.descriptors.t;
import kotlin.reflect.jvm.internal.impl.descriptors.w0;
import kotlin.reflect.jvm.internal.impl.descriptors.y;
import kotlin.reflect.jvm.internal.impl.descriptors.z0;
import kotlin.reflect.y.internal.j0.f.f;
import kotlin.reflect.y.internal.j0.i.w.e;
import kotlin.reflect.y.internal.j0.k.n;

/* compiled from: CloneableClassScope.kt */
/* loaded from: classes2.dex */
public final class a extends e {

    /* renamed from: e, reason: collision with root package name */
    public static final C0324a f23239e = new C0324a(null);

    /* renamed from: f, reason: collision with root package name */
    private static final f f23240f;

    /* compiled from: CloneableClassScope.kt */
    /* renamed from: kotlin.f0.y.e.j0.b.q.a$a, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class C0324a {
        private C0324a() {
        }

        public /* synthetic */ C0324a(g gVar) {
            this();
        }

        public final f a() {
            return a.f23240f;
        }
    }

    static {
        f x = f.x("clone");
        m.e(x, "identifier(\"clone\")");
        f23240f = x;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(n nVar, kotlin.reflect.jvm.internal.impl.descriptors.e eVar) {
        super(nVar, eVar);
        m.f(nVar, "storageManager");
        m.f(eVar, "containingClass");
    }

    @Override // kotlin.reflect.y.internal.j0.i.w.e
    protected List<y> i() {
        List<w0> j2;
        List<? extends e1> j3;
        List<i1> j4;
        List<y> e2;
        g0 m1 = g0.m1(l(), kotlin.reflect.jvm.internal.impl.descriptors.n1.g.f25179c.b(), f23240f, b.a.DECLARATION, z0.a);
        w0 K0 = l().K0();
        j2 = u.j();
        j3 = u.j();
        j4 = u.j();
        m1.S0(null, K0, j2, j3, j4, kotlin.reflect.y.internal.j0.i.t.a.f(l()).i(), d0.OPEN, t.f25366c);
        e2 = kotlin.collections.t.e(m1);
        return e2;
    }
}
