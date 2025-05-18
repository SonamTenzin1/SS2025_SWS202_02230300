package kotlin.reflect.jvm.internal.impl.descriptors.p1;

import java.util.Collections;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.descriptors.d1;
import kotlin.reflect.jvm.internal.impl.descriptors.w0;
import kotlin.reflect.y.internal.j0.l.j1;
import kotlin.reflect.y.internal.j0.l.l1;
import kotlin.reflect.y.internal.j0.l.n1;

/* compiled from: AbstractClassDescriptor.java */
/* loaded from: classes2.dex */
public abstract class a extends t {

    /* renamed from: g, reason: collision with root package name */
    private final kotlin.reflect.y.internal.j0.f.f f25202g;

    /* renamed from: h, reason: collision with root package name */
    protected final kotlin.reflect.y.internal.j0.k.i<kotlin.reflect.y.internal.j0.l.m0> f25203h;

    /* renamed from: i, reason: collision with root package name */
    private final kotlin.reflect.y.internal.j0.k.i<kotlin.reflect.y.internal.j0.i.w.h> f25204i;

    /* renamed from: j, reason: collision with root package name */
    private final kotlin.reflect.y.internal.j0.k.i<w0> f25205j;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AbstractClassDescriptor.java */
    /* renamed from: kotlin.reflect.jvm.internal.impl.descriptors.p1.a$a, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0409a implements Function0<kotlin.reflect.y.internal.j0.l.m0> {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: AbstractClassDescriptor.java */
        /* renamed from: kotlin.reflect.jvm.internal.impl.descriptors.p1.a$a$a, reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class C0410a implements Function1<kotlin.reflect.y.internal.j0.l.t1.g, kotlin.reflect.y.internal.j0.l.m0> {
            C0410a() {
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public kotlin.reflect.y.internal.j0.l.m0 invoke(kotlin.reflect.y.internal.j0.l.t1.g gVar) {
                kotlin.reflect.jvm.internal.impl.descriptors.h f2 = gVar.f(a.this);
                if (f2 == null) {
                    return a.this.f25203h.invoke();
                }
                if (f2 instanceof d1) {
                    return kotlin.reflect.y.internal.j0.l.f0.b((d1) f2, n1.g(f2.h().getParameters()));
                }
                if (f2 instanceof t) {
                    return n1.u(f2.h().b(gVar), ((t) f2).H(gVar), this);
                }
                return f2.s();
            }
        }

        C0409a() {
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public kotlin.reflect.y.internal.j0.l.m0 invoke() {
            a aVar = a.this;
            return n1.t(aVar, aVar.D0(), new C0410a());
        }
    }

    /* compiled from: AbstractClassDescriptor.java */
    /* loaded from: classes2.dex */
    class b implements Function0<kotlin.reflect.y.internal.j0.i.w.h> {
        b() {
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public kotlin.reflect.y.internal.j0.i.w.h invoke() {
            return new kotlin.reflect.y.internal.j0.i.w.f(a.this.D0());
        }
    }

    /* compiled from: AbstractClassDescriptor.java */
    /* loaded from: classes2.dex */
    class c implements Function0<w0> {
        c() {
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public w0 invoke() {
            return new q(a.this);
        }
    }

    public a(kotlin.reflect.y.internal.j0.k.n nVar, kotlin.reflect.y.internal.j0.f.f fVar) {
        if (nVar == null) {
            K(0);
        }
        if (fVar == null) {
            K(1);
        }
        this.f25202g = fVar;
        this.f25203h = nVar.d(new C0409a());
        this.f25204i = nVar.d(new b());
        this.f25205j = nVar.d(new c());
    }

    private static /* synthetic */ void K(int i2) {
        String str = (i2 == 2 || i2 == 3 || i2 == 4 || i2 == 5 || i2 == 6 || i2 == 9 || i2 == 12 || i2 == 14 || i2 == 16 || i2 == 17 || i2 == 19 || i2 == 20) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i2 == 2 || i2 == 3 || i2 == 4 || i2 == 5 || i2 == 6 || i2 == 9 || i2 == 12 || i2 == 14 || i2 == 16 || i2 == 17 || i2 == 19 || i2 == 20) ? 2 : 3];
        switch (i2) {
            case 1:
                objArr[0] = "name";
                break;
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 9:
            case 12:
            case 14:
            case 16:
            case 17:
            case 19:
            case 20:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractClassDescriptor";
                break;
            case 7:
            case 13:
                objArr[0] = "typeArguments";
                break;
            case 8:
            case 11:
                objArr[0] = "kotlinTypeRefiner";
                break;
            case 10:
            case 15:
                objArr[0] = "typeSubstitution";
                break;
            case 18:
                objArr[0] = "substitutor";
                break;
            default:
                objArr[0] = "storageManager";
                break;
        }
        if (i2 == 2) {
            objArr[1] = "getName";
        } else if (i2 == 3) {
            objArr[1] = "getOriginal";
        } else if (i2 == 4) {
            objArr[1] = "getUnsubstitutedInnerClassesScope";
        } else if (i2 == 5) {
            objArr[1] = "getThisAsReceiverParameter";
        } else if (i2 == 6) {
            objArr[1] = "getContextReceivers";
        } else if (i2 == 9 || i2 == 12 || i2 == 14 || i2 == 16) {
            objArr[1] = "getMemberScope";
        } else if (i2 == 17) {
            objArr[1] = "getUnsubstitutedMemberScope";
        } else if (i2 == 19) {
            objArr[1] = "substitute";
        } else if (i2 != 20) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractClassDescriptor";
        } else {
            objArr[1] = "getDefaultType";
        }
        switch (i2) {
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 9:
            case 12:
            case 14:
            case 16:
            case 17:
            case 19:
            case 20:
                break;
            case 7:
            case 8:
            case 10:
            case 11:
            case 13:
            case 15:
                objArr[2] = "getMemberScope";
                break;
            case 18:
                objArr[2] = "substitute";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String format = String.format(str, objArr);
        if (i2 != 2 && i2 != 3 && i2 != 4 && i2 != 5 && i2 != 6 && i2 != 9 && i2 != 12 && i2 != 14 && i2 != 16 && i2 != 17 && i2 != 19 && i2 != 20) {
            throw new IllegalArgumentException(format);
        }
        throw new IllegalStateException(format);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.b1
    /* renamed from: A0, reason: merged with bridge method [inline-methods] */
    public kotlin.reflect.jvm.internal.impl.descriptors.e c(l1 l1Var) {
        if (l1Var == null) {
            K(18);
        }
        return l1Var.k() ? this : new s(this, l1Var);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.e
    public kotlin.reflect.y.internal.j0.i.w.h D0() {
        kotlin.reflect.y.internal.j0.i.w.h H = H(kotlin.reflect.y.internal.j0.i.t.a.k(kotlin.reflect.y.internal.j0.i.d.g(this)));
        if (H == null) {
            K(17);
        }
        return H;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.e
    public List<w0> F0() {
        List<w0> emptyList = Collections.emptyList();
        if (emptyList == null) {
            K(6);
        }
        return emptyList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.e
    public w0 K0() {
        w0 invoke = this.f25205j.invoke();
        if (invoke == null) {
            K(5);
        }
        return invoke;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.m
    public <R, D> R L(kotlin.reflect.jvm.internal.impl.descriptors.o<R, D> oVar, D d2) {
        return oVar.a(this, d2);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.m
    public kotlin.reflect.jvm.internal.impl.descriptors.e a() {
        return this;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.e
    public kotlin.reflect.y.internal.j0.i.w.h a0(j1 j1Var) {
        if (j1Var == null) {
            K(15);
        }
        kotlin.reflect.y.internal.j0.i.w.h v = v(j1Var, kotlin.reflect.y.internal.j0.i.t.a.k(kotlin.reflect.y.internal.j0.i.d.g(this)));
        if (v == null) {
            K(16);
        }
        return v;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.i0
    public kotlin.reflect.y.internal.j0.f.f getName() {
        kotlin.reflect.y.internal.j0.f.f fVar = this.f25202g;
        if (fVar == null) {
            K(2);
        }
        return fVar;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.e, kotlin.reflect.jvm.internal.impl.descriptors.h
    public kotlin.reflect.y.internal.j0.l.m0 s() {
        kotlin.reflect.y.internal.j0.l.m0 invoke = this.f25203h.invoke();
        if (invoke == null) {
            K(20);
        }
        return invoke;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.p1.t
    public kotlin.reflect.y.internal.j0.i.w.h v(j1 j1Var, kotlin.reflect.y.internal.j0.l.t1.g gVar) {
        if (j1Var == null) {
            K(10);
        }
        if (gVar == null) {
            K(11);
        }
        if (!j1Var.f()) {
            return new kotlin.reflect.y.internal.j0.i.w.m(H(gVar), l1.g(j1Var));
        }
        kotlin.reflect.y.internal.j0.i.w.h H = H(gVar);
        if (H == null) {
            K(12);
        }
        return H;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.e
    public kotlin.reflect.y.internal.j0.i.w.h y0() {
        kotlin.reflect.y.internal.j0.i.w.h invoke = this.f25204i.invoke();
        if (invoke == null) {
            K(4);
        }
        return invoke;
    }
}
