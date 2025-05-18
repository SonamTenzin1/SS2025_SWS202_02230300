package kotlin.reflect.y.internal.j0.d.a.o0;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.c0;
import kotlin.collections.s;
import kotlin.collections.v;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.descriptors.a;
import kotlin.reflect.jvm.internal.impl.descriptors.b;
import kotlin.reflect.jvm.internal.impl.descriptors.e1;
import kotlin.reflect.jvm.internal.impl.descriptors.h;
import kotlin.reflect.jvm.internal.impl.descriptors.i1;
import kotlin.reflect.jvm.internal.impl.descriptors.n1.g;
import kotlin.reflect.jvm.internal.impl.descriptors.p1.d0;
import kotlin.reflect.jvm.internal.impl.descriptors.t0;
import kotlin.reflect.jvm.internal.impl.descriptors.w0;
import kotlin.reflect.jvm.internal.impl.descriptors.y;
import kotlin.reflect.y.internal.j0.d.a.i0;
import kotlin.reflect.y.internal.j0.d.a.j;
import kotlin.reflect.y.internal.j0.d.a.l0.g;
import kotlin.reflect.y.internal.j0.d.b.u;
import kotlin.reflect.y.internal.j0.d.b.x;
import kotlin.reflect.y.internal.j0.f.f;
import kotlin.reflect.y.internal.j0.l.e0;
import kotlin.reflect.y.internal.j0.l.l0;
import kotlin.reflect.y.internal.j0.l.n1;
import kotlin.reflect.y.internal.j0.l.q1;

/* compiled from: signatureEnhancement.kt */
/* loaded from: classes3.dex */
public final class l {
    private final kotlin.reflect.y.internal.j0.d.a.o0.d a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: signatureEnhancement.kt */
    /* loaded from: classes3.dex */
    public static final class a extends Lambda implements Function1<q1, Boolean> {

        /* renamed from: f, reason: collision with root package name */
        public static final a f23665f = new a();

        a() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(q1 q1Var) {
            h w = q1Var.O0().w();
            if (w == null) {
                return Boolean.FALSE;
            }
            f name = w.getName();
            kotlin.reflect.y.internal.j0.b.q.c cVar = kotlin.reflect.y.internal.j0.b.q.c.a;
            return Boolean.valueOf(m.a(name, cVar.h().g()) && m.a(kotlin.reflect.y.internal.j0.i.t.a.d(w), cVar.h()));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: signatureEnhancement.kt */
    /* loaded from: classes3.dex */
    public static final class b extends Lambda implements Function1<kotlin.reflect.jvm.internal.impl.descriptors.b, e0> {

        /* renamed from: f, reason: collision with root package name */
        public static final b f23666f = new b();

        b() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final e0 invoke(kotlin.reflect.jvm.internal.impl.descriptors.b bVar) {
            m.f(bVar, "it");
            w0 m0 = bVar.m0();
            m.c(m0);
            e0 type = m0.getType();
            m.e(type, "it.extensionReceiverParameter!!.type");
            return type;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: signatureEnhancement.kt */
    /* loaded from: classes3.dex */
    public static final class c extends Lambda implements Function1<kotlin.reflect.jvm.internal.impl.descriptors.b, e0> {

        /* renamed from: f, reason: collision with root package name */
        public static final c f23667f = new c();

        c() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final e0 invoke(kotlin.reflect.jvm.internal.impl.descriptors.b bVar) {
            m.f(bVar, "it");
            e0 returnType = bVar.getReturnType();
            m.c(returnType);
            return returnType;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: signatureEnhancement.kt */
    /* loaded from: classes3.dex */
    public static final class d extends Lambda implements Function1<kotlin.reflect.jvm.internal.impl.descriptors.b, e0> {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ i1 f23668f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(i1 i1Var) {
            super(1);
            this.f23668f = i1Var;
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final e0 invoke(kotlin.reflect.jvm.internal.impl.descriptors.b bVar) {
            m.f(bVar, "it");
            e0 type = bVar.f().get(this.f23668f.g()).getType();
            m.e(type, "it.valueParameters[p.index].type");
            return type;
        }
    }

    /* compiled from: signatureEnhancement.kt */
    /* loaded from: classes3.dex */
    static final class e extends Lambda implements Function1<q1, Boolean> {

        /* renamed from: f, reason: collision with root package name */
        public static final e f23669f = new e();

        e() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(q1 q1Var) {
            m.f(q1Var, "it");
            return Boolean.valueOf(q1Var instanceof l0);
        }
    }

    public l(kotlin.reflect.y.internal.j0.d.a.o0.d dVar) {
        m.f(dVar, "typeEnhancement");
        this.a = dVar;
    }

    private final boolean a(e0 e0Var) {
        return n1.c(e0Var, a.f23665f);
    }

    private final e0 b(kotlin.reflect.jvm.internal.impl.descriptors.b bVar, kotlin.reflect.jvm.internal.impl.descriptors.n1.a aVar, boolean z, g gVar, kotlin.reflect.y.internal.j0.d.a.b bVar2, q qVar, boolean z2, Function1<? super kotlin.reflect.jvm.internal.impl.descriptors.b, ? extends e0> function1) {
        int u;
        n nVar = new n(aVar, z, gVar, bVar2, false, 16, null);
        e0 invoke = function1.invoke(bVar);
        Collection<? extends kotlin.reflect.jvm.internal.impl.descriptors.b> e2 = bVar.e();
        m.e(e2, "overriddenDescriptors");
        u = v.u(e2, 10);
        ArrayList arrayList = new ArrayList(u);
        for (kotlin.reflect.jvm.internal.impl.descriptors.b bVar3 : e2) {
            m.e(bVar3, "it");
            arrayList.add(function1.invoke(bVar3));
        }
        return c(nVar, invoke, arrayList, qVar, z2);
    }

    private final e0 c(n nVar, e0 e0Var, List<? extends e0> list, q qVar, boolean z) {
        return this.a.a(e0Var, nVar.b(e0Var, list, qVar, z), nVar.u());
    }

    static /* synthetic */ e0 d(l lVar, kotlin.reflect.jvm.internal.impl.descriptors.b bVar, kotlin.reflect.jvm.internal.impl.descriptors.n1.a aVar, boolean z, g gVar, kotlin.reflect.y.internal.j0.d.a.b bVar2, q qVar, boolean z2, Function1 function1, int i2, Object obj) {
        return lVar.b(bVar, aVar, z, gVar, bVar2, qVar, (i2 & 32) != 0 ? false : z2, function1);
    }

    static /* synthetic */ e0 e(l lVar, n nVar, e0 e0Var, List list, q qVar, boolean z, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            qVar = null;
        }
        return lVar.c(nVar, e0Var, list, qVar, (i2 & 8) != 0 ? false : z);
    }

    /* JADX WARN: Removed duplicated region for block: B:107:0x021a  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0240  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0269  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0228  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x01ed  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x0167  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x015c  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x0149  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x014e  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0159  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0161  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x018e  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x01df  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x01f1 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:93:0x01fb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final <D extends kotlin.reflect.jvm.internal.impl.descriptors.b> D f(D d2, g gVar) {
        D d3;
        e0 e0Var;
        kotlin.reflect.y.internal.j0.d.a.k0.e eVar;
        k kVar;
        int u;
        t0 t0Var;
        kotlin.reflect.y.internal.j0.d.a.b bVar;
        e0 d4;
        e0 returnType;
        boolean z;
        e0 e0Var2;
        int u2;
        boolean z2;
        e0 type;
        List<q> a2;
        if (!(d2 instanceof kotlin.reflect.y.internal.j0.d.a.k0.a)) {
            return d2;
        }
        kotlin.reflect.y.internal.j0.d.a.k0.a aVar = (kotlin.reflect.y.internal.j0.d.a.k0.a) d2;
        boolean z3 = true;
        if (aVar.i() == b.a.FAKE_OVERRIDE && aVar.a().e().size() == 1) {
            return d2;
        }
        g h2 = kotlin.reflect.y.internal.j0.d.a.l0.a.h(gVar, k(d2, gVar));
        if (d2 instanceof kotlin.reflect.y.internal.j0.d.a.k0.f) {
            kotlin.reflect.y.internal.j0.d.a.k0.f fVar = (kotlin.reflect.y.internal.j0.d.a.k0.f) d2;
            d0 getter = fVar.getGetter();
            if ((getter == null || getter.V()) ? false : true) {
                d0 getter2 = fVar.getGetter();
                m.c(getter2);
                d3 = getter2;
                if (aVar.m0() == null) {
                    y yVar = (y) (!(d3 instanceof y) ? null : d3);
                    e0Var = j(d2, yVar != null ? (i1) yVar.i0(kotlin.reflect.y.internal.j0.d.a.k0.e.J) : null, h2, null, false, b.f23666f);
                } else {
                    e0Var = null;
                }
                eVar = !(d2 instanceof kotlin.reflect.y.internal.j0.d.a.k0.e) ? (kotlin.reflect.y.internal.j0.d.a.k0.e) d2 : null;
                if (eVar != null) {
                    x xVar = x.a;
                    kotlin.reflect.jvm.internal.impl.descriptors.m b2 = eVar.b();
                    m.d(b2, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
                    String a3 = u.a(xVar, (kotlin.reflect.jvm.internal.impl.descriptors.e) b2, kotlin.reflect.y.internal.j0.d.b.v.c(eVar, false, false, 3, null));
                    if (a3 != null) {
                        kVar = j.d().get(a3);
                        if (kVar != null) {
                            kVar.a().size();
                            aVar.f().size();
                        }
                        boolean z4 = (!i0.b(gVar.a().i()) || h2.a().q().b()) && i0.a(d2);
                        List<i1> f2 = d3.f();
                        m.e(f2, "annotationOwnerForMember.valueParameters");
                        u = v.u(f2, 10);
                        ArrayList arrayList = new ArrayList(u);
                        for (i1 i1Var : f2) {
                            ArrayList arrayList2 = arrayList;
                            arrayList2.add(j(d2, i1Var, h2, (kVar == null || (a2 = kVar.a()) == null) ? null : (q) s.X(a2, i1Var.g()), z4, new d(i1Var)));
                            arrayList = arrayList2;
                        }
                        ArrayList arrayList3 = arrayList;
                        t0Var = (t0) (!(d2 instanceof t0) ? null : d2);
                        if (t0Var == null && kotlin.reflect.y.internal.j0.d.a.l0.l.c.a(t0Var)) {
                            bVar = kotlin.reflect.y.internal.j0.d.a.b.FIELD;
                        } else {
                            bVar = kotlin.reflect.y.internal.j0.d.a.b.METHOD_RETURN_TYPE;
                        }
                        d4 = d(this, d2, d3, true, h2, bVar, kVar != null ? kVar.b() : null, false, c.f23667f, 32, null);
                        returnType = aVar.getReturnType();
                        m.c(returnType);
                        if (!a(returnType)) {
                            w0 m0 = aVar.m0();
                            if (!((m0 == null || (type = m0.getType()) == null) ? false : a(type))) {
                                List<i1> f3 = aVar.f();
                                m.e(f3, "valueParameters");
                                if (!(f3 instanceof Collection) || !f3.isEmpty()) {
                                    Iterator<T> it = f3.iterator();
                                    while (it.hasNext()) {
                                        e0 type2 = ((i1) it.next()).getType();
                                        m.e(type2, "it.type");
                                        if (a(type2)) {
                                            z2 = true;
                                            break;
                                        }
                                    }
                                }
                                z2 = false;
                                if (!z2) {
                                    z = false;
                                    Pair<a.InterfaceC0406a<?>, ?> a4 = !z ? kotlin.s.a(kotlin.reflect.y.internal.j0.i.s.d.a(), new j(d2)) : null;
                                    if (e0Var == null && d4 == null) {
                                        if (!arrayList3.isEmpty()) {
                                            Iterator it2 = arrayList3.iterator();
                                            while (it2.hasNext()) {
                                                if (((e0) it2.next()) != null) {
                                                    break;
                                                }
                                            }
                                        }
                                        z3 = false;
                                        if (!z3 && a4 == null) {
                                            return d2;
                                        }
                                    }
                                    if (e0Var != null) {
                                        w0 m02 = aVar.m0();
                                        e0Var2 = m02 != null ? m02.getType() : null;
                                    } else {
                                        e0Var2 = e0Var;
                                    }
                                    u2 = v.u(arrayList3, 10);
                                    ArrayList arrayList4 = new ArrayList(u2);
                                    int i2 = 0;
                                    for (Object obj : arrayList3) {
                                        int i3 = i2 + 1;
                                        if (i2 < 0) {
                                            kotlin.collections.u.t();
                                        }
                                        e0 e0Var3 = (e0) obj;
                                        if (e0Var3 == null) {
                                            e0Var3 = aVar.f().get(i2).getType();
                                            m.e(e0Var3, "valueParameters[index].type");
                                        }
                                        arrayList4.add(e0Var3);
                                        i2 = i3;
                                    }
                                    if (d4 == null) {
                                        d4 = aVar.getReturnType();
                                        m.c(d4);
                                    }
                                    kotlin.reflect.y.internal.j0.d.a.k0.a y = aVar.y(e0Var2, arrayList4, d4, a4);
                                    m.d(y, "null cannot be cast to non-null type D of org.jetbrains.kotlin.load.java.typeEnhancement.SignatureEnhancement.enhanceSignature");
                                    return y;
                                }
                            }
                        }
                        z = true;
                        if (!z) {
                        }
                        if (e0Var == null) {
                            if (!arrayList3.isEmpty()) {
                            }
                            z3 = false;
                            if (!z3) {
                                return d2;
                            }
                        }
                        if (e0Var != null) {
                        }
                        u2 = v.u(arrayList3, 10);
                        ArrayList arrayList42 = new ArrayList(u2);
                        int i22 = 0;
                        while (r3.hasNext()) {
                        }
                        if (d4 == null) {
                        }
                        kotlin.reflect.y.internal.j0.d.a.k0.a y2 = aVar.y(e0Var2, arrayList42, d4, a4);
                        m.d(y2, "null cannot be cast to non-null type D of org.jetbrains.kotlin.load.java.typeEnhancement.SignatureEnhancement.enhanceSignature");
                        return y2;
                    }
                }
                kVar = null;
                if (kVar != null) {
                }
                if (i0.b(gVar.a().i())) {
                }
                List<i1> f22 = d3.f();
                m.e(f22, "annotationOwnerForMember.valueParameters");
                u = v.u(f22, 10);
                ArrayList arrayList5 = new ArrayList(u);
                while (r18.hasNext()) {
                }
                ArrayList arrayList32 = arrayList5;
                t0Var = (t0) (!(d2 instanceof t0) ? null : d2);
                if (t0Var == null && kotlin.reflect.y.internal.j0.d.a.l0.l.c.a(t0Var)) {
                }
                d4 = d(this, d2, d3, true, h2, bVar, kVar != null ? kVar.b() : null, false, c.f23667f, 32, null);
                returnType = aVar.getReturnType();
                m.c(returnType);
                if (!a(returnType)) {
                }
                z = true;
                if (!z) {
                }
                if (e0Var == null) {
                }
                if (e0Var != null) {
                }
                u2 = v.u(arrayList32, 10);
                ArrayList arrayList422 = new ArrayList(u2);
                int i222 = 0;
                while (r3.hasNext()) {
                }
                if (d4 == null) {
                }
                kotlin.reflect.y.internal.j0.d.a.k0.a y22 = aVar.y(e0Var2, arrayList422, d4, a4);
                m.d(y22, "null cannot be cast to non-null type D of org.jetbrains.kotlin.load.java.typeEnhancement.SignatureEnhancement.enhanceSignature");
                return y22;
            }
        }
        d3 = d2;
        if (aVar.m0() == null) {
        }
        if (!(d2 instanceof kotlin.reflect.y.internal.j0.d.a.k0.e)) {
        }
        if (eVar != null) {
        }
        kVar = null;
        if (kVar != null) {
        }
        if (i0.b(gVar.a().i())) {
        }
        List<i1> f222 = d3.f();
        m.e(f222, "annotationOwnerForMember.valueParameters");
        u = v.u(f222, 10);
        ArrayList arrayList52 = new ArrayList(u);
        while (r18.hasNext()) {
        }
        ArrayList arrayList322 = arrayList52;
        t0Var = (t0) (!(d2 instanceof t0) ? null : d2);
        if (t0Var == null && kotlin.reflect.y.internal.j0.d.a.l0.l.c.a(t0Var)) {
        }
        d4 = d(this, d2, d3, true, h2, bVar, kVar != null ? kVar.b() : null, false, c.f23667f, 32, null);
        returnType = aVar.getReturnType();
        m.c(returnType);
        if (!a(returnType)) {
        }
        z = true;
        if (!z) {
        }
        if (e0Var == null) {
        }
        if (e0Var != null) {
        }
        u2 = v.u(arrayList322, 10);
        ArrayList arrayList4222 = new ArrayList(u2);
        int i2222 = 0;
        while (r3.hasNext()) {
        }
        if (d4 == null) {
        }
        kotlin.reflect.y.internal.j0.d.a.k0.a y222 = aVar.y(e0Var2, arrayList4222, d4, a4);
        m.d(y222, "null cannot be cast to non-null type D of org.jetbrains.kotlin.load.java.typeEnhancement.SignatureEnhancement.enhanceSignature");
        return y222;
    }

    private final e0 j(kotlin.reflect.jvm.internal.impl.descriptors.b bVar, i1 i1Var, g gVar, q qVar, boolean z, Function1<? super kotlin.reflect.jvm.internal.impl.descriptors.b, ? extends e0> function1) {
        g h2;
        return b(bVar, i1Var, false, (i1Var == null || (h2 = kotlin.reflect.y.internal.j0.d.a.l0.a.h(gVar, i1Var.getAnnotations())) == null) ? gVar : h2, kotlin.reflect.y.internal.j0.d.a.b.VALUE_PARAMETER, qVar, z, function1);
    }

    private final <D extends kotlin.reflect.jvm.internal.impl.descriptors.b> kotlin.reflect.jvm.internal.impl.descriptors.n1.g k(D d2, g gVar) {
        int u;
        List<? extends kotlin.reflect.jvm.internal.impl.descriptors.n1.c> m0;
        h a2 = kotlin.reflect.jvm.internal.impl.descriptors.s.a(d2);
        if (a2 == null) {
            return d2.getAnnotations();
        }
        kotlin.reflect.y.internal.j0.d.a.l0.l.f fVar = a2 instanceof kotlin.reflect.y.internal.j0.d.a.l0.l.f ? (kotlin.reflect.y.internal.j0.d.a.l0.l.f) a2 : null;
        List<kotlin.reflect.y.internal.j0.d.a.n0.a> R0 = fVar != null ? fVar.R0() : null;
        if (R0 == null || R0.isEmpty()) {
            return d2.getAnnotations();
        }
        u = v.u(R0, 10);
        ArrayList arrayList = new ArrayList(u);
        Iterator<T> it = R0.iterator();
        while (it.hasNext()) {
            arrayList.add(new kotlin.reflect.y.internal.j0.d.a.l0.l.e(gVar, (kotlin.reflect.y.internal.j0.d.a.n0.a) it.next(), true));
        }
        g.a aVar = kotlin.reflect.jvm.internal.impl.descriptors.n1.g.f25179c;
        m0 = c0.m0(d2.getAnnotations(), arrayList);
        return aVar.a(m0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <D extends kotlin.reflect.jvm.internal.impl.descriptors.b> Collection<D> g(kotlin.reflect.y.internal.j0.d.a.l0.g gVar, Collection<? extends D> collection) {
        int u;
        m.f(gVar, "c");
        m.f(collection, "platformSignatures");
        u = v.u(collection, 10);
        ArrayList arrayList = new ArrayList(u);
        Iterator<T> it = collection.iterator();
        while (it.hasNext()) {
            arrayList.add(f((kotlin.reflect.jvm.internal.impl.descriptors.b) it.next(), gVar));
        }
        return arrayList;
    }

    public final e0 h(e0 e0Var, kotlin.reflect.y.internal.j0.d.a.l0.g gVar) {
        List j2;
        m.f(e0Var, "type");
        m.f(gVar, "context");
        n nVar = new n(null, false, gVar, kotlin.reflect.y.internal.j0.d.a.b.TYPE_USE, true);
        j2 = kotlin.collections.u.j();
        e0 e2 = e(this, nVar, e0Var, j2, null, false, 12, null);
        return e2 == null ? e0Var : e2;
    }

    public final List<e0> i(e1 e1Var, List<? extends e0> list, kotlin.reflect.y.internal.j0.d.a.l0.g gVar) {
        int u;
        List j2;
        m.f(e1Var, "typeParameter");
        m.f(list, "bounds");
        m.f(gVar, "context");
        u = v.u(list, 10);
        ArrayList arrayList = new ArrayList(u);
        for (e0 e0Var : list) {
            if (!kotlin.reflect.y.internal.j0.l.x1.a.b(e0Var, e.f23669f)) {
                n nVar = new n(e1Var, false, gVar, kotlin.reflect.y.internal.j0.d.a.b.TYPE_PARAMETER_BOUNDS, false, 16, null);
                j2 = kotlin.collections.u.j();
                e0 e2 = e(this, nVar, e0Var, j2, null, false, 12, null);
                if (e2 != null) {
                    e0Var = e2;
                }
            }
            arrayList.add(e0Var);
        }
        return arrayList;
    }
}
