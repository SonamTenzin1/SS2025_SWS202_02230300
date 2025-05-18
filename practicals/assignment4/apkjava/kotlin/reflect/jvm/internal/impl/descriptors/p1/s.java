package kotlin.reflect.jvm.internal.impl.descriptors.p1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.descriptors.e1;
import kotlin.reflect.jvm.internal.impl.descriptors.g1;
import kotlin.reflect.jvm.internal.impl.descriptors.w0;
import kotlin.reflect.jvm.internal.impl.descriptors.z0;
import kotlin.reflect.y.internal.j0.l.j1;
import kotlin.reflect.y.internal.j0.l.l1;
import kotlin.reflect.y.internal.j0.l.n1;
import kotlin.reflect.y.internal.j0.l.r1;

/* compiled from: LazySubstitutingClassDescriptor.java */
/* loaded from: classes2.dex */
public class s extends t {

    /* renamed from: g, reason: collision with root package name */
    private final t f25289g;

    /* renamed from: h, reason: collision with root package name */
    private final l1 f25290h;

    /* renamed from: i, reason: collision with root package name */
    private l1 f25291i;

    /* renamed from: j, reason: collision with root package name */
    private List<e1> f25292j;

    /* renamed from: k, reason: collision with root package name */
    private List<e1> f25293k;
    private kotlin.reflect.y.internal.j0.l.e1 l;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: LazySubstitutingClassDescriptor.java */
    /* loaded from: classes2.dex */
    public class a implements Function1<e1, Boolean> {
        a() {
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Boolean invoke(e1 e1Var) {
            return Boolean.valueOf(!e1Var.o0());
        }
    }

    /* compiled from: LazySubstitutingClassDescriptor.java */
    /* loaded from: classes2.dex */
    class b implements Function1<kotlin.reflect.y.internal.j0.l.m0, kotlin.reflect.y.internal.j0.l.m0> {
        b() {
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public kotlin.reflect.y.internal.j0.l.m0 invoke(kotlin.reflect.y.internal.j0.l.m0 m0Var) {
            return s.this.N0(m0Var);
        }
    }

    public s(t tVar, l1 l1Var) {
        this.f25289g = tVar;
        this.f25290h = l1Var;
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00c6 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00e3 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00c2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static /* synthetic */ void K(int i2) {
        String format;
        String str = (i2 == 2 || i2 == 3 || i2 == 5 || i2 == 6 || i2 == 8 || i2 == 10 || i2 == 13 || i2 == 23) ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
        Object[] objArr = new Object[(i2 == 2 || i2 == 3 || i2 == 5 || i2 == 6 || i2 == 8 || i2 == 10 || i2 == 13 || i2 == 23) ? 3 : 2];
        if (i2 != 2) {
            if (i2 != 3) {
                if (i2 != 5) {
                    if (i2 != 6) {
                        if (i2 != 8) {
                            if (i2 != 10) {
                                if (i2 != 13) {
                                    if (i2 != 23) {
                                        objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/LazySubstitutingClassDescriptor";
                                    } else {
                                        objArr[0] = "substitutor";
                                    }
                                    switch (i2) {
                                        case 2:
                                        case 3:
                                        case 5:
                                        case 6:
                                        case 8:
                                        case 10:
                                        case 13:
                                        case 23:
                                            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/LazySubstitutingClassDescriptor";
                                            break;
                                        case 4:
                                        case 7:
                                        case 9:
                                        case 11:
                                            objArr[1] = "getMemberScope";
                                            break;
                                        case 12:
                                        case 14:
                                            objArr[1] = "getUnsubstitutedMemberScope";
                                            break;
                                        case 15:
                                            objArr[1] = "getStaticScope";
                                            break;
                                        case 16:
                                            objArr[1] = "getDefaultType";
                                            break;
                                        case 17:
                                            objArr[1] = "getContextReceivers";
                                            break;
                                        case 18:
                                            objArr[1] = "getConstructors";
                                            break;
                                        case 19:
                                            objArr[1] = "getAnnotations";
                                            break;
                                        case 20:
                                            objArr[1] = "getName";
                                            break;
                                        case 21:
                                            objArr[1] = "getOriginal";
                                            break;
                                        case 22:
                                            objArr[1] = "getContainingDeclaration";
                                            break;
                                        case 24:
                                            objArr[1] = "substitute";
                                            break;
                                        case 25:
                                            objArr[1] = "getKind";
                                            break;
                                        case 26:
                                            objArr[1] = "getModality";
                                            break;
                                        case 27:
                                            objArr[1] = "getVisibility";
                                            break;
                                        case 28:
                                            objArr[1] = "getUnsubstitutedInnerClassesScope";
                                            break;
                                        case 29:
                                            objArr[1] = "getSource";
                                            break;
                                        case 30:
                                            objArr[1] = "getDeclaredTypeParameters";
                                            break;
                                        case 31:
                                            objArr[1] = "getSealedSubclasses";
                                            break;
                                        default:
                                            objArr[1] = "getTypeConstructor";
                                            break;
                                    }
                                    if (i2 != 2 || i2 == 3 || i2 == 5 || i2 == 6 || i2 == 8 || i2 == 10) {
                                        objArr[2] = "getMemberScope";
                                    } else if (i2 == 13) {
                                        objArr[2] = "getUnsubstitutedMemberScope";
                                    } else if (i2 == 23) {
                                        objArr[2] = "substitute";
                                    }
                                    format = String.format(str, objArr);
                                    if (i2 == 2 && i2 != 3 && i2 != 5 && i2 != 6 && i2 != 8 && i2 != 10 && i2 != 13 && i2 != 23) {
                                        throw new IllegalStateException(format);
                                    }
                                    throw new IllegalArgumentException(format);
                                }
                            }
                        }
                    }
                }
                objArr[0] = "typeSubstitution";
                switch (i2) {
                }
                if (i2 != 2) {
                }
                objArr[2] = "getMemberScope";
                format = String.format(str, objArr);
                if (i2 == 2) {
                }
                throw new IllegalArgumentException(format);
            }
            objArr[0] = "kotlinTypeRefiner";
            switch (i2) {
            }
            if (i2 != 2) {
            }
            objArr[2] = "getMemberScope";
            format = String.format(str, objArr);
            if (i2 == 2) {
            }
            throw new IllegalArgumentException(format);
        }
        objArr[0] = "typeArguments";
        switch (i2) {
        }
        if (i2 != 2) {
        }
        objArr[2] = "getMemberScope";
        format = String.format(str, objArr);
        if (i2 == 2) {
        }
        throw new IllegalArgumentException(format);
    }

    private l1 L0() {
        List<e1> Q;
        if (this.f25291i == null) {
            if (this.f25290h.k()) {
                this.f25291i = this.f25290h;
            } else {
                List<e1> parameters = this.f25289g.h().getParameters();
                this.f25292j = new ArrayList(parameters.size());
                this.f25291i = kotlin.reflect.y.internal.j0.l.t.b(parameters, this.f25290h.j(), this, this.f25292j);
                Q = kotlin.collections.c0.Q(this.f25292j, new a());
                this.f25293k = Q;
            }
        }
        return this.f25291i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public kotlin.reflect.y.internal.j0.l.m0 N0(kotlin.reflect.y.internal.j0.l.m0 m0Var) {
        return (m0Var == null || this.f25290h.k()) ? m0Var : (kotlin.reflect.y.internal.j0.l.m0) L0().p(m0Var, r1.INVARIANT);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.e
    public boolean A() {
        return this.f25289g.A();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.e
    public boolean D() {
        return this.f25289g.D();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.e
    public kotlin.reflect.y.internal.j0.i.w.h D0() {
        kotlin.reflect.y.internal.j0.i.w.h H = H(kotlin.reflect.y.internal.j0.i.t.a.k(kotlin.reflect.y.internal.j0.i.d.g(this.f25289g)));
        if (H == null) {
            K(12);
        }
        return H;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.c0
    public boolean E0() {
        return this.f25289g.E0();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.e
    public List<w0> F0() {
        List<w0> emptyList = Collections.emptyList();
        if (emptyList == null) {
            K(17);
        }
        return emptyList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.p1.t
    public kotlin.reflect.y.internal.j0.i.w.h H(kotlin.reflect.y.internal.j0.l.t1.g gVar) {
        if (gVar == null) {
            K(13);
        }
        kotlin.reflect.y.internal.j0.i.w.h H = this.f25289g.H(gVar);
        if (!this.f25290h.k()) {
            return new kotlin.reflect.y.internal.j0.i.w.m(H, L0());
        }
        if (H == null) {
            K(14);
        }
        return H;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.e
    public Collection<kotlin.reflect.jvm.internal.impl.descriptors.e> J() {
        Collection<kotlin.reflect.jvm.internal.impl.descriptors.e> J = this.f25289g.J();
        if (J == null) {
            K(31);
        }
        return J;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.e
    public boolean J0() {
        return this.f25289g.J0();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.e
    public w0 K0() {
        throw new UnsupportedOperationException();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.m
    public <R, D> R L(kotlin.reflect.jvm.internal.impl.descriptors.o<R, D> oVar, D d2) {
        return oVar.a(this, d2);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.c0
    public boolean M() {
        return this.f25289g.M();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.b1
    /* renamed from: M0, reason: merged with bridge method [inline-methods] */
    public kotlin.reflect.jvm.internal.impl.descriptors.e c(l1 l1Var) {
        if (l1Var == null) {
            K(23);
        }
        return l1Var.k() ? this : new s(this, l1.h(l1Var.j(), L0().j()));
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.e
    public kotlin.reflect.jvm.internal.impl.descriptors.d R() {
        return this.f25289g.R();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.e
    public kotlin.reflect.y.internal.j0.i.w.h S() {
        kotlin.reflect.y.internal.j0.i.w.h S = this.f25289g.S();
        if (S == null) {
            K(15);
        }
        return S;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.e
    public kotlin.reflect.jvm.internal.impl.descriptors.e U() {
        return this.f25289g.U();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.e
    public kotlin.reflect.y.internal.j0.i.w.h a0(j1 j1Var) {
        if (j1Var == null) {
            K(10);
        }
        kotlin.reflect.y.internal.j0.i.w.h v = v(j1Var, kotlin.reflect.y.internal.j0.i.t.a.k(kotlin.reflect.y.internal.j0.i.d.g(this)));
        if (v == null) {
            K(11);
        }
        return v;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.e, kotlin.reflect.jvm.internal.impl.descriptors.n, kotlin.reflect.jvm.internal.impl.descriptors.m
    public kotlin.reflect.jvm.internal.impl.descriptors.m b() {
        kotlin.reflect.jvm.internal.impl.descriptors.m b2 = this.f25289g.b();
        if (b2 == null) {
            K(22);
        }
        return b2;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.n1.a
    public kotlin.reflect.jvm.internal.impl.descriptors.n1.g getAnnotations() {
        kotlin.reflect.jvm.internal.impl.descriptors.n1.g annotations = this.f25289g.getAnnotations();
        if (annotations == null) {
            K(19);
        }
        return annotations;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.i0
    public kotlin.reflect.y.internal.j0.f.f getName() {
        kotlin.reflect.y.internal.j0.f.f name = this.f25289g.getName();
        if (name == null) {
            K(20);
        }
        return name;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.e, kotlin.reflect.jvm.internal.impl.descriptors.q, kotlin.reflect.jvm.internal.impl.descriptors.c0
    public kotlin.reflect.jvm.internal.impl.descriptors.u getVisibility() {
        kotlin.reflect.jvm.internal.impl.descriptors.u visibility = this.f25289g.getVisibility();
        if (visibility == null) {
            K(27);
        }
        return visibility;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.h
    public kotlin.reflect.y.internal.j0.l.e1 h() {
        kotlin.reflect.y.internal.j0.l.e1 h2 = this.f25289g.h();
        if (this.f25290h.k()) {
            if (h2 == null) {
                K(0);
            }
            return h2;
        }
        if (this.l == null) {
            l1 L0 = L0();
            Collection<kotlin.reflect.y.internal.j0.l.e0> a2 = h2.a();
            ArrayList arrayList = new ArrayList(a2.size());
            Iterator<kotlin.reflect.y.internal.j0.l.e0> it = a2.iterator();
            while (it.hasNext()) {
                arrayList.add(L0.p(it.next(), r1.INVARIANT));
            }
            this.l = new kotlin.reflect.y.internal.j0.l.l(this, this.f25292j, arrayList, kotlin.reflect.y.internal.j0.k.f.f24650b);
        }
        kotlin.reflect.y.internal.j0.l.e1 e1Var = this.l;
        if (e1Var == null) {
            K(1);
        }
        return e1Var;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.e
    public kotlin.reflect.jvm.internal.impl.descriptors.f i() {
        kotlin.reflect.jvm.internal.impl.descriptors.f i2 = this.f25289g.i();
        if (i2 == null) {
            K(25);
        }
        return i2;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.e
    public boolean isInline() {
        return this.f25289g.isInline();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.e, kotlin.reflect.jvm.internal.impl.descriptors.c0
    public kotlin.reflect.jvm.internal.impl.descriptors.d0 j() {
        kotlin.reflect.jvm.internal.impl.descriptors.d0 j2 = this.f25289g.j();
        if (j2 == null) {
            K(26);
        }
        return j2;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.e
    public Collection<kotlin.reflect.jvm.internal.impl.descriptors.d> k() {
        Collection<kotlin.reflect.jvm.internal.impl.descriptors.d> k2 = this.f25289g.k();
        ArrayList arrayList = new ArrayList(k2.size());
        for (kotlin.reflect.jvm.internal.impl.descriptors.d dVar : k2) {
            arrayList.add(((kotlin.reflect.jvm.internal.impl.descriptors.d) dVar.u().h(dVar.a()).d(dVar.j()).o(dVar.getVisibility()).r(dVar.i()).j(false).c()).c(L0()));
        }
        return arrayList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.e
    public boolean l() {
        return this.f25289g.l();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.i
    public boolean m() {
        return this.f25289g.m();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.e, kotlin.reflect.jvm.internal.impl.descriptors.h
    public kotlin.reflect.y.internal.j0.l.m0 s() {
        kotlin.reflect.y.internal.j0.l.m0 j2 = kotlin.reflect.y.internal.j0.l.f0.j(kotlin.reflect.y.internal.j0.l.o.a.a(getAnnotations(), null, null), h(), n1.g(h().getParameters()), false, D0());
        if (j2 == null) {
            K(16);
        }
        return j2;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.p
    public z0 t() {
        z0 z0Var = z0.a;
        if (z0Var == null) {
            K(29);
        }
        return z0Var;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.p1.t
    public kotlin.reflect.y.internal.j0.i.w.h v(j1 j1Var, kotlin.reflect.y.internal.j0.l.t1.g gVar) {
        if (j1Var == null) {
            K(5);
        }
        if (gVar == null) {
            K(6);
        }
        kotlin.reflect.y.internal.j0.i.w.h v = this.f25289g.v(j1Var, gVar);
        if (!this.f25290h.k()) {
            return new kotlin.reflect.y.internal.j0.i.w.m(v, L0());
        }
        if (v == null) {
            K(7);
        }
        return v;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.e, kotlin.reflect.jvm.internal.impl.descriptors.i
    public List<e1> w() {
        L0();
        List<e1> list = this.f25293k;
        if (list == null) {
            K(30);
        }
        return list;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.e
    public kotlin.reflect.y.internal.j0.i.w.h y0() {
        kotlin.reflect.y.internal.j0.i.w.h y0 = this.f25289g.y0();
        if (y0 == null) {
            K(28);
        }
        return y0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.c0
    public boolean z() {
        return this.f25289g.z();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.e
    public g1<kotlin.reflect.y.internal.j0.l.m0> z0() {
        g1<kotlin.reflect.y.internal.j0.l.m0> z0 = this.f25289g.z0();
        if (z0 == null) {
            return null;
        }
        return z0.b(new b());
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.m
    public kotlin.reflect.jvm.internal.impl.descriptors.e a() {
        kotlin.reflect.jvm.internal.impl.descriptors.e a2 = this.f25289g.a();
        if (a2 == null) {
            K(21);
        }
        return a2;
    }
}
