package kotlin.reflect.y.internal.j0.i;

import java.util.Collection;
import kotlin.collections.s;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.b;
import kotlin.reflect.jvm.internal.impl.descriptors.c0;
import kotlin.reflect.jvm.internal.impl.descriptors.h;
import kotlin.reflect.jvm.internal.impl.descriptors.k0;
import kotlin.reflect.jvm.internal.impl.descriptors.m;
import kotlin.reflect.jvm.internal.impl.descriptors.z0;
import kotlin.reflect.y.internal.j0.i.j;
import kotlin.reflect.y.internal.j0.l.e1;
import kotlin.reflect.y.internal.j0.l.t1.e;
import kotlin.reflect.y.internal.j0.l.t1.g;

/* compiled from: DescriptorEquivalenceForOverrides.kt */
/* loaded from: classes3.dex */
public final class b {
    public static final b a = new b();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DescriptorEquivalenceForOverrides.kt */
    /* loaded from: classes3.dex */
    public static final class a extends Lambda implements Function2<m, m, Boolean> {

        /* renamed from: f, reason: collision with root package name */
        public static final a f24310f = new a();

        a() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(m mVar, m mVar2) {
            return Boolean.FALSE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DescriptorEquivalenceForOverrides.kt */
    /* renamed from: kotlin.f0.y.e.j0.i.b$b, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static final class C0377b implements e.a {
        final /* synthetic */ boolean a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ kotlin.reflect.jvm.internal.impl.descriptors.a f24311b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ kotlin.reflect.jvm.internal.impl.descriptors.a f24312c;

        /* compiled from: DescriptorEquivalenceForOverrides.kt */
        /* renamed from: kotlin.f0.y.e.j0.i.b$b$a */
        /* loaded from: classes3.dex */
        static final class a extends Lambda implements Function2<m, m, Boolean> {

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ kotlin.reflect.jvm.internal.impl.descriptors.a f24313f;

            /* renamed from: g, reason: collision with root package name */
            final /* synthetic */ kotlin.reflect.jvm.internal.impl.descriptors.a f24314g;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(kotlin.reflect.jvm.internal.impl.descriptors.a aVar, kotlin.reflect.jvm.internal.impl.descriptors.a aVar2) {
                super(2);
                this.f24313f = aVar;
                this.f24314g = aVar2;
            }

            @Override // kotlin.jvm.functions.Function2
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Boolean invoke(m mVar, m mVar2) {
                return Boolean.valueOf(kotlin.jvm.internal.m.a(mVar, this.f24313f) && kotlin.jvm.internal.m.a(mVar2, this.f24314g));
            }
        }

        C0377b(boolean z, kotlin.reflect.jvm.internal.impl.descriptors.a aVar, kotlin.reflect.jvm.internal.impl.descriptors.a aVar2) {
            this.a = z;
            this.f24311b = aVar;
            this.f24312c = aVar2;
        }

        @Override // kotlin.f0.y.e.j0.l.t1.e.a
        public final boolean a(e1 e1Var, e1 e1Var2) {
            kotlin.jvm.internal.m.f(e1Var, "c1");
            kotlin.jvm.internal.m.f(e1Var2, "c2");
            if (kotlin.jvm.internal.m.a(e1Var, e1Var2)) {
                return true;
            }
            h w = e1Var.w();
            h w2 = e1Var2.w();
            if ((w instanceof kotlin.reflect.jvm.internal.impl.descriptors.e1) && (w2 instanceof kotlin.reflect.jvm.internal.impl.descriptors.e1)) {
                return b.a.g((kotlin.reflect.jvm.internal.impl.descriptors.e1) w, (kotlin.reflect.jvm.internal.impl.descriptors.e1) w2, this.a, new a(this.f24311b, this.f24312c));
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DescriptorEquivalenceForOverrides.kt */
    /* loaded from: classes3.dex */
    public static final class c extends Lambda implements Function2<m, m, Boolean> {

        /* renamed from: f, reason: collision with root package name */
        public static final c f24315f = new c();

        c() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(m mVar, m mVar2) {
            return Boolean.FALSE;
        }
    }

    private b() {
    }

    public static /* synthetic */ boolean b(b bVar, kotlin.reflect.jvm.internal.impl.descriptors.a aVar, kotlin.reflect.jvm.internal.impl.descriptors.a aVar2, boolean z, boolean z2, boolean z3, g gVar, int i2, Object obj) {
        return bVar.a(aVar, aVar2, z, (i2 & 8) != 0 ? true : z2, (i2 & 16) != 0 ? false : z3, gVar);
    }

    private final boolean c(kotlin.reflect.jvm.internal.impl.descriptors.e eVar, kotlin.reflect.jvm.internal.impl.descriptors.e eVar2) {
        return kotlin.jvm.internal.m.a(eVar.h(), eVar2.h());
    }

    public static /* synthetic */ boolean e(b bVar, m mVar, m mVar2, boolean z, boolean z2, int i2, Object obj) {
        if ((i2 & 8) != 0) {
            z2 = true;
        }
        return bVar.d(mVar, mVar2, z, z2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ boolean h(b bVar, kotlin.reflect.jvm.internal.impl.descriptors.e1 e1Var, kotlin.reflect.jvm.internal.impl.descriptors.e1 e1Var2, boolean z, Function2 function2, int i2, Object obj) {
        if ((i2 & 8) != 0) {
            function2 = c.f24315f;
        }
        return bVar.g(e1Var, e1Var2, z, function2);
    }

    private final boolean i(m mVar, m mVar2, Function2<? super m, ? super m, Boolean> function2, boolean z) {
        m b2 = mVar.b();
        m b3 = mVar2.b();
        if (!(b2 instanceof kotlin.reflect.jvm.internal.impl.descriptors.b) && !(b3 instanceof kotlin.reflect.jvm.internal.impl.descriptors.b)) {
            return e(this, b2, b3, z, false, 8, null);
        }
        return function2.invoke(b2, b3).booleanValue();
    }

    private final z0 j(kotlin.reflect.jvm.internal.impl.descriptors.a aVar) {
        while (aVar instanceof kotlin.reflect.jvm.internal.impl.descriptors.b) {
            kotlin.reflect.jvm.internal.impl.descriptors.b bVar = (kotlin.reflect.jvm.internal.impl.descriptors.b) aVar;
            if (bVar.i() != b.a.FAKE_OVERRIDE) {
                break;
            }
            Collection<? extends kotlin.reflect.jvm.internal.impl.descriptors.b> e2 = bVar.e();
            kotlin.jvm.internal.m.e(e2, "overriddenDescriptors");
            aVar = (kotlin.reflect.jvm.internal.impl.descriptors.b) s.t0(e2);
            if (aVar == null) {
                return null;
            }
        }
        return aVar.t();
    }

    public final boolean a(kotlin.reflect.jvm.internal.impl.descriptors.a aVar, kotlin.reflect.jvm.internal.impl.descriptors.a aVar2, boolean z, boolean z2, boolean z3, g gVar) {
        kotlin.jvm.internal.m.f(aVar, "a");
        kotlin.jvm.internal.m.f(aVar2, "b");
        kotlin.jvm.internal.m.f(gVar, "kotlinTypeRefiner");
        if (kotlin.jvm.internal.m.a(aVar, aVar2)) {
            return true;
        }
        if (!kotlin.jvm.internal.m.a(aVar.getName(), aVar2.getName())) {
            return false;
        }
        if (z2 && (aVar instanceof c0) && (aVar2 instanceof c0) && ((c0) aVar).M() != ((c0) aVar2).M()) {
            return false;
        }
        if ((kotlin.jvm.internal.m.a(aVar.b(), aVar2.b()) && (!z || !kotlin.jvm.internal.m.a(j(aVar), j(aVar2)))) || d.E(aVar) || d.E(aVar2) || !i(aVar, aVar2, a.f24310f, z)) {
            return false;
        }
        j i2 = j.i(gVar, new C0377b(z, aVar, aVar2));
        kotlin.jvm.internal.m.e(i2, "a: CallableDescriptor,\n …= a && y == b }\n        }");
        j.i.a c2 = i2.E(aVar, aVar2, null, !z3).c();
        j.i.a aVar3 = j.i.a.OVERRIDABLE;
        return c2 == aVar3 && i2.E(aVar2, aVar, null, z3 ^ true).c() == aVar3;
    }

    public final boolean d(m mVar, m mVar2, boolean z, boolean z2) {
        if ((mVar instanceof kotlin.reflect.jvm.internal.impl.descriptors.e) && (mVar2 instanceof kotlin.reflect.jvm.internal.impl.descriptors.e)) {
            return c((kotlin.reflect.jvm.internal.impl.descriptors.e) mVar, (kotlin.reflect.jvm.internal.impl.descriptors.e) mVar2);
        }
        if ((mVar instanceof kotlin.reflect.jvm.internal.impl.descriptors.e1) && (mVar2 instanceof kotlin.reflect.jvm.internal.impl.descriptors.e1)) {
            return h(this, (kotlin.reflect.jvm.internal.impl.descriptors.e1) mVar, (kotlin.reflect.jvm.internal.impl.descriptors.e1) mVar2, z, null, 8, null);
        }
        if ((mVar instanceof kotlin.reflect.jvm.internal.impl.descriptors.a) && (mVar2 instanceof kotlin.reflect.jvm.internal.impl.descriptors.a)) {
            return b(this, (kotlin.reflect.jvm.internal.impl.descriptors.a) mVar, (kotlin.reflect.jvm.internal.impl.descriptors.a) mVar2, z, z2, false, g.a.a, 16, null);
        }
        return ((mVar instanceof k0) && (mVar2 instanceof k0)) ? kotlin.jvm.internal.m.a(((k0) mVar).d(), ((k0) mVar2).d()) : kotlin.jvm.internal.m.a(mVar, mVar2);
    }

    public final boolean f(kotlin.reflect.jvm.internal.impl.descriptors.e1 e1Var, kotlin.reflect.jvm.internal.impl.descriptors.e1 e1Var2, boolean z) {
        kotlin.jvm.internal.m.f(e1Var, "a");
        kotlin.jvm.internal.m.f(e1Var2, "b");
        return h(this, e1Var, e1Var2, z, null, 8, null);
    }

    public final boolean g(kotlin.reflect.jvm.internal.impl.descriptors.e1 e1Var, kotlin.reflect.jvm.internal.impl.descriptors.e1 e1Var2, boolean z, Function2<? super m, ? super m, Boolean> function2) {
        kotlin.jvm.internal.m.f(e1Var, "a");
        kotlin.jvm.internal.m.f(e1Var2, "b");
        kotlin.jvm.internal.m.f(function2, "equivalentCallables");
        if (kotlin.jvm.internal.m.a(e1Var, e1Var2)) {
            return true;
        }
        return !kotlin.jvm.internal.m.a(e1Var.b(), e1Var2.b()) && i(e1Var, e1Var2, function2, z) && e1Var.g() == e1Var2.g();
    }
}
