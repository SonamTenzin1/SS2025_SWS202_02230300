package kotlin.reflect.jvm.internal.impl.descriptors.p1;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.reflect.jvm.internal.impl.descriptors.c1;
import kotlin.reflect.jvm.internal.impl.descriptors.e1;
import kotlin.reflect.jvm.internal.impl.descriptors.z0;
import kotlin.reflect.y.internal.j0.l.a1;
import kotlin.reflect.y.internal.j0.l.r1;

/* compiled from: AbstractTypeParameterDescriptor.java */
/* loaded from: classes2.dex */
public abstract class e extends k implements e1 {

    /* renamed from: j, reason: collision with root package name */
    private final r1 f25228j;

    /* renamed from: k, reason: collision with root package name */
    private final boolean f25229k;
    private final int l;
    private final kotlin.reflect.y.internal.j0.k.i<kotlin.reflect.y.internal.j0.l.e1> m;
    private final kotlin.reflect.y.internal.j0.k.i<kotlin.reflect.y.internal.j0.l.m0> n;
    private final kotlin.reflect.y.internal.j0.k.n o;

    /* compiled from: AbstractTypeParameterDescriptor.java */
    /* loaded from: classes2.dex */
    class a implements Function0<kotlin.reflect.y.internal.j0.l.e1> {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ kotlin.reflect.y.internal.j0.k.n f25230f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ c1 f25231g;

        a(kotlin.reflect.y.internal.j0.k.n nVar, c1 c1Var) {
            this.f25230f = nVar;
            this.f25231g = c1Var;
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public kotlin.reflect.y.internal.j0.l.e1 invoke() {
            return new c(e.this, this.f25230f, this.f25231g);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AbstractTypeParameterDescriptor.java */
    /* loaded from: classes2.dex */
    public class b implements Function0<kotlin.reflect.y.internal.j0.l.m0> {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ kotlin.reflect.y.internal.j0.f.f f25233f;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: AbstractTypeParameterDescriptor.java */
        /* loaded from: classes2.dex */
        public class a implements Function0<kotlin.reflect.y.internal.j0.i.w.h> {
            a() {
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public kotlin.reflect.y.internal.j0.i.w.h invoke() {
                return kotlin.reflect.y.internal.j0.i.w.n.j("Scope for type parameter " + b.this.f25233f.k(), e.this.getUpperBounds());
            }
        }

        b(kotlin.reflect.y.internal.j0.f.f fVar) {
            this.f25233f = fVar;
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public kotlin.reflect.y.internal.j0.l.m0 invoke() {
            return kotlin.reflect.y.internal.j0.l.f0.j(a1.f24676g.h(), e.this.h(), Collections.emptyList(), false, new kotlin.reflect.y.internal.j0.i.w.g(new a()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AbstractTypeParameterDescriptor.java */
    /* loaded from: classes2.dex */
    public class c extends kotlin.reflect.y.internal.j0.l.g {

        /* renamed from: d, reason: collision with root package name */
        private final c1 f25236d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ e f25237e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(e eVar, kotlin.reflect.y.internal.j0.k.n nVar, c1 c1Var) {
            super(nVar);
            if (nVar == null) {
                v(0);
            }
            this.f25237e = eVar;
            this.f25236d = c1Var;
        }

        private static /* synthetic */ void v(int i2) {
            String str = (i2 == 1 || i2 == 2 || i2 == 3 || i2 == 4 || i2 == 5 || i2 == 8) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
            Object[] objArr = new Object[(i2 == 1 || i2 == 2 || i2 == 3 || i2 == 4 || i2 == 5 || i2 == 8) ? 2 : 3];
            switch (i2) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 8:
                    objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractTypeParameterDescriptor$TypeParameterTypeConstructor";
                    break;
                case 6:
                    objArr[0] = "type";
                    break;
                case 7:
                    objArr[0] = "supertypes";
                    break;
                case 9:
                    objArr[0] = "classifier";
                    break;
                default:
                    objArr[0] = "storageManager";
                    break;
            }
            if (i2 == 1) {
                objArr[1] = "computeSupertypes";
            } else if (i2 == 2) {
                objArr[1] = "getParameters";
            } else if (i2 == 3) {
                objArr[1] = "getDeclarationDescriptor";
            } else if (i2 == 4) {
                objArr[1] = "getBuiltIns";
            } else if (i2 == 5) {
                objArr[1] = "getSupertypeLoopChecker";
            } else if (i2 != 8) {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractTypeParameterDescriptor$TypeParameterTypeConstructor";
            } else {
                objArr[1] = "processSupertypesWithoutCycles";
            }
            switch (i2) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 8:
                    break;
                case 6:
                    objArr[2] = "reportSupertypeLoopError";
                    break;
                case 7:
                    objArr[2] = "processSupertypesWithoutCycles";
                    break;
                case 9:
                    objArr[2] = "isSameClassifier";
                    break;
                default:
                    objArr[2] = "<init>";
                    break;
            }
            String format = String.format(str, objArr);
            if (i2 != 1 && i2 != 2 && i2 != 3 && i2 != 4 && i2 != 5 && i2 != 8) {
                throw new IllegalArgumentException(format);
            }
            throw new IllegalStateException(format);
        }

        @Override // kotlin.reflect.y.internal.j0.l.m, kotlin.reflect.y.internal.j0.l.e1
        public kotlin.reflect.jvm.internal.impl.descriptors.h c() {
            e eVar = this.f25237e;
            if (eVar == null) {
                v(3);
            }
            return eVar;
        }

        @Override // kotlin.reflect.y.internal.j0.l.e1
        public boolean e() {
            return true;
        }

        @Override // kotlin.reflect.y.internal.j0.l.e1
        public List<e1> getParameters() {
            List<e1> emptyList = Collections.emptyList();
            if (emptyList == null) {
                v(2);
            }
            return emptyList;
        }

        @Override // kotlin.reflect.y.internal.j0.l.m
        protected boolean i(kotlin.reflect.jvm.internal.impl.descriptors.h hVar) {
            if (hVar == null) {
                v(9);
            }
            return (hVar instanceof e1) && kotlin.reflect.y.internal.j0.i.b.a.f(this.f25237e, (e1) hVar, true);
        }

        @Override // kotlin.reflect.y.internal.j0.l.g
        protected Collection<kotlin.reflect.y.internal.j0.l.e0> l() {
            List<kotlin.reflect.y.internal.j0.l.e0> M0 = this.f25237e.M0();
            if (M0 == null) {
                v(1);
            }
            return M0;
        }

        @Override // kotlin.reflect.y.internal.j0.l.g
        protected kotlin.reflect.y.internal.j0.l.e0 m() {
            return kotlin.reflect.y.internal.j0.l.u1.k.d(kotlin.reflect.y.internal.j0.l.u1.j.x, new String[0]);
        }

        @Override // kotlin.reflect.y.internal.j0.l.e1
        public kotlin.reflect.y.internal.j0.b.h o() {
            kotlin.reflect.y.internal.j0.b.h f2 = kotlin.reflect.y.internal.j0.i.t.a.f(this.f25237e);
            if (f2 == null) {
                v(4);
            }
            return f2;
        }

        @Override // kotlin.reflect.y.internal.j0.l.g
        protected c1 q() {
            c1 c1Var = this.f25236d;
            if (c1Var == null) {
                v(5);
            }
            return c1Var;
        }

        @Override // kotlin.reflect.y.internal.j0.l.g
        protected List<kotlin.reflect.y.internal.j0.l.e0> s(List<kotlin.reflect.y.internal.j0.l.e0> list) {
            if (list == null) {
                v(7);
            }
            List<kotlin.reflect.y.internal.j0.l.e0> A0 = this.f25237e.A0(list);
            if (A0 == null) {
                v(8);
            }
            return A0;
        }

        public String toString() {
            return this.f25237e.getName().toString();
        }

        @Override // kotlin.reflect.y.internal.j0.l.g
        protected void u(kotlin.reflect.y.internal.j0.l.e0 e0Var) {
            if (e0Var == null) {
                v(6);
            }
            this.f25237e.L0(e0Var);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(kotlin.reflect.y.internal.j0.k.n nVar, kotlin.reflect.jvm.internal.impl.descriptors.m mVar, kotlin.reflect.jvm.internal.impl.descriptors.n1.g gVar, kotlin.reflect.y.internal.j0.f.f fVar, r1 r1Var, boolean z, int i2, z0 z0Var, c1 c1Var) {
        super(mVar, gVar, fVar, z0Var);
        if (nVar == null) {
            v(0);
        }
        if (mVar == null) {
            v(1);
        }
        if (gVar == null) {
            v(2);
        }
        if (fVar == null) {
            v(3);
        }
        if (r1Var == null) {
            v(4);
        }
        if (z0Var == null) {
            v(5);
        }
        if (c1Var == null) {
            v(6);
        }
        this.f25228j = r1Var;
        this.f25229k = z;
        this.l = i2;
        this.m = nVar.d(new a(nVar, c1Var));
        this.n = nVar.d(new b(fVar));
        this.o = nVar;
    }

    private static /* synthetic */ void v(int i2) {
        String str;
        int i3;
        switch (i2) {
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 13:
            case 14:
                str = "@NotNull method %s.%s must not return null";
                break;
            case 12:
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i2) {
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 13:
            case 14:
                i3 = 2;
                break;
            case 12:
            default:
                i3 = 3;
                break;
        }
        Object[] objArr = new Object[i3];
        switch (i2) {
            case 1:
                objArr[0] = "containingDeclaration";
                break;
            case 2:
                objArr[0] = "annotations";
                break;
            case 3:
                objArr[0] = "name";
                break;
            case 4:
                objArr[0] = "variance";
                break;
            case 5:
                objArr[0] = "source";
                break;
            case 6:
                objArr[0] = "supertypeLoopChecker";
                break;
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 13:
            case 14:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractTypeParameterDescriptor";
                break;
            case 12:
                objArr[0] = "bounds";
                break;
            default:
                objArr[0] = "storageManager";
                break;
        }
        switch (i2) {
            case 7:
                objArr[1] = "getVariance";
                break;
            case 8:
                objArr[1] = "getUpperBounds";
                break;
            case 9:
                objArr[1] = "getTypeConstructor";
                break;
            case 10:
                objArr[1] = "getDefaultType";
                break;
            case 11:
                objArr[1] = "getOriginal";
                break;
            case 12:
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractTypeParameterDescriptor";
                break;
            case 13:
                objArr[1] = "processBoundsWithoutCycles";
                break;
            case 14:
                objArr[1] = "getStorageManager";
                break;
        }
        switch (i2) {
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 13:
            case 14:
                break;
            case 12:
                objArr[2] = "processBoundsWithoutCycles";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String format = String.format(str, objArr);
        switch (i2) {
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 13:
            case 14:
                throw new IllegalStateException(format);
            case 12:
            default:
                throw new IllegalArgumentException(format);
        }
    }

    protected List<kotlin.reflect.y.internal.j0.l.e0> A0(List<kotlin.reflect.y.internal.j0.l.e0> list) {
        if (list == null) {
            v(12);
        }
        if (list == null) {
            v(13);
        }
        return list;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.e1
    public boolean F() {
        return this.f25229k;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.m
    public <R, D> R L(kotlin.reflect.jvm.internal.impl.descriptors.o<R, D> oVar, D d2) {
        return oVar.m(this, d2);
    }

    protected abstract void L0(kotlin.reflect.y.internal.j0.l.e0 e0Var);

    protected abstract List<kotlin.reflect.y.internal.j0.l.e0> M0();

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.e1
    public int g() {
        return this.l;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.e1
    public List<kotlin.reflect.y.internal.j0.l.e0> getUpperBounds() {
        List<kotlin.reflect.y.internal.j0.l.e0> a2 = ((c) h()).a();
        if (a2 == null) {
            v(8);
        }
        return a2;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.e1, kotlin.reflect.jvm.internal.impl.descriptors.h
    public final kotlin.reflect.y.internal.j0.l.e1 h() {
        kotlin.reflect.y.internal.j0.l.e1 invoke = this.m.invoke();
        if (invoke == null) {
            v(9);
        }
        return invoke;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.e1
    public kotlin.reflect.y.internal.j0.k.n h0() {
        kotlin.reflect.y.internal.j0.k.n nVar = this.o;
        if (nVar == null) {
            v(14);
        }
        return nVar;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.e1
    public r1 n() {
        r1 r1Var = this.f25228j;
        if (r1Var == null) {
            v(7);
        }
        return r1Var;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.e1
    public boolean o0() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.h
    public kotlin.reflect.y.internal.j0.l.m0 s() {
        kotlin.reflect.y.internal.j0.l.m0 invoke = this.n.invoke();
        if (invoke == null) {
            v(10);
        }
        return invoke;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.p1.k, kotlin.reflect.jvm.internal.impl.descriptors.p1.j, kotlin.reflect.jvm.internal.impl.descriptors.m
    public e1 a() {
        e1 e1Var = (e1) super.a();
        if (e1Var == null) {
            v(11);
        }
        return e1Var;
    }
}
