package kotlin.reflect.y.internal.j0.l;

import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.descriptors.e1;
import kotlin.reflect.jvm.internal.impl.descriptors.n1.g;
import kotlin.reflect.jvm.internal.impl.descriptors.n1.l;
import kotlin.reflect.y.internal.j0.b.h;
import kotlin.reflect.y.internal.j0.b.k;
import kotlin.reflect.y.internal.j0.l.t1.j;

/* compiled from: TypeSubstitutor.java */
/* loaded from: classes3.dex */
public class l1 {
    public static final l1 a = g(j1.f24750b);

    /* renamed from: b, reason: collision with root package name */
    private final j1 f24756b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TypeSubstitutor.java */
    /* loaded from: classes3.dex */
    public static class a implements Function1<kotlin.reflect.y.internal.j0.f.c, Boolean> {
        a() {
        }

        private static /* synthetic */ void b(int i2) {
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "name", "kotlin/reflect/jvm/internal/impl/types/TypeSubstitutor$1", "invoke"));
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public Boolean invoke(kotlin.reflect.y.internal.j0.f.c cVar) {
            if (cVar == null) {
                b(0);
            }
            return Boolean.valueOf(!cVar.equals(k.a.Q));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: TypeSubstitutor.java */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class b {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[d.values().length];
            a = iArr;
            try {
                iArr[d.OUT_IN_IN_POSITION.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[d.IN_IN_OUT_POSITION.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[d.NO_CONFLICT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: TypeSubstitutor.java */
    /* loaded from: classes3.dex */
    public static final class c extends Exception {
        public c(String str) {
            super(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: TypeSubstitutor.java */
    /* loaded from: classes3.dex */
    public enum d {
        NO_CONFLICT,
        IN_IN_OUT_POSITION,
        OUT_IN_IN_POSITION
    }

    protected l1(j1 j1Var) {
        if (j1Var == null) {
            a(7);
        }
        this.f24756b = j1Var;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:53:0x0104. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:54:0x0107. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:55:0x010a. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00fc A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0116 A[FALL_THROUGH] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x003b A[FALL_THROUGH] */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0021 A[FALL_THROUGH] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static /* synthetic */ void a(int i2) {
        String str;
        int i3;
        if (i2 != 1 && i2 != 2 && i2 != 8 && i2 != 34 && i2 != 37) {
            switch (i2) {
                default:
                    switch (i2) {
                        default:
                            switch (i2) {
                                default:
                                    switch (i2) {
                                        case 40:
                                        case 41:
                                        case 42:
                                            break;
                                        default:
                                            str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                                            break;
                                    }
                                case 29:
                                case 30:
                                case 31:
                                case 32:
                                    str = "@NotNull method %s.%s must not return null";
                                    break;
                            }
                        case 19:
                        case 20:
                        case 21:
                        case 22:
                        case 23:
                        case 24:
                        case 25:
                            break;
                    }
                case 11:
                case 12:
                case 13:
                    break;
            }
            if (i2 != 1 && i2 != 2 && i2 != 8 && i2 != 34 && i2 != 37) {
                switch (i2) {
                    default:
                        switch (i2) {
                            default:
                                switch (i2) {
                                    default:
                                        switch (i2) {
                                            case 40:
                                            case 41:
                                            case 42:
                                                break;
                                            default:
                                                i3 = 3;
                                                break;
                                        }
                                    case 29:
                                    case 30:
                                    case 31:
                                    case 32:
                                        i3 = 2;
                                        break;
                                }
                            case 19:
                            case 20:
                            case 21:
                            case 22:
                            case 23:
                            case 24:
                            case 25:
                                break;
                        }
                    case 11:
                    case 12:
                    case 13:
                        break;
                }
                Object[] objArr = new Object[i3];
                switch (i2) {
                    case 1:
                    case 2:
                    case 8:
                    case 11:
                    case 12:
                    case 13:
                    case 19:
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                    case 24:
                    case 25:
                    case 29:
                    case 30:
                    case 31:
                    case 32:
                    case 34:
                    case 37:
                    case 40:
                    case 41:
                    case 42:
                        objArr[0] = "kotlin/reflect/jvm/internal/impl/types/TypeSubstitutor";
                        break;
                    case 3:
                        objArr[0] = "first";
                        break;
                    case 4:
                        objArr[0] = "second";
                        break;
                    case 5:
                        objArr[0] = "substitutionContext";
                        break;
                    case 6:
                        objArr[0] = "context";
                        break;
                    case 7:
                    default:
                        objArr[0] = "substitution";
                        break;
                    case 9:
                    case 14:
                        objArr[0] = "type";
                        break;
                    case 10:
                    case 15:
                        objArr[0] = "howThisTypeIsUsed";
                        break;
                    case 16:
                    case 17:
                    case 36:
                        objArr[0] = "typeProjection";
                        break;
                    case 18:
                    case 28:
                        objArr[0] = "originalProjection";
                        break;
                    case 26:
                        objArr[0] = "originalType";
                        break;
                    case 27:
                        objArr[0] = "substituted";
                        break;
                    case 33:
                        objArr[0] = "annotations";
                        break;
                    case 35:
                    case 38:
                        objArr[0] = "typeParameterVariance";
                        break;
                    case 39:
                        objArr[0] = "projectionKind";
                        break;
                }
                if (i2 != 1) {
                    objArr[1] = "replaceWithNonApproximatingSubstitution";
                } else if (i2 == 2) {
                    objArr[1] = "replaceWithContravariantApproximatingSubstitution";
                } else if (i2 == 8) {
                    objArr[1] = "getSubstitution";
                } else if (i2 != 34) {
                    if (i2 != 37) {
                        switch (i2) {
                            case 11:
                            case 12:
                            case 13:
                                objArr[1] = "safeSubstitute";
                                break;
                            default:
                                switch (i2) {
                                    case 19:
                                    case 20:
                                    case 21:
                                    case 22:
                                    case 23:
                                    case 24:
                                    case 25:
                                        objArr[1] = "unsafeSubstitute";
                                        break;
                                    default:
                                        switch (i2) {
                                            case 29:
                                            case 30:
                                            case 31:
                                            case 32:
                                                objArr[1] = "projectedTypeForConflictedTypeWithUnsafeVariance";
                                                break;
                                            default:
                                                switch (i2) {
                                                    case 40:
                                                    case 41:
                                                    case 42:
                                                        break;
                                                    default:
                                                        objArr[1] = "kotlin/reflect/jvm/internal/impl/types/TypeSubstitutor";
                                                        break;
                                                }
                                        }
                                }
                        }
                    }
                    objArr[1] = "combine";
                } else {
                    objArr[1] = "filterOutUnsafeVariance";
                }
                switch (i2) {
                    case 1:
                    case 2:
                    case 8:
                    case 11:
                    case 12:
                    case 13:
                    case 19:
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                    case 24:
                    case 25:
                    case 29:
                    case 30:
                    case 31:
                    case 32:
                    case 34:
                    case 37:
                    case 40:
                    case 41:
                    case 42:
                        break;
                    case 3:
                    case 4:
                        objArr[2] = "createChainedSubstitutor";
                        break;
                    case 5:
                    case 6:
                    default:
                        objArr[2] = "create";
                        break;
                    case 7:
                        objArr[2] = "<init>";
                        break;
                    case 9:
                    case 10:
                        objArr[2] = "safeSubstitute";
                        break;
                    case 14:
                    case 15:
                    case 16:
                        objArr[2] = "substitute";
                        break;
                    case 17:
                        objArr[2] = "substituteWithoutApproximation";
                        break;
                    case 18:
                        objArr[2] = "unsafeSubstitute";
                        break;
                    case 26:
                    case 27:
                    case 28:
                        objArr[2] = "projectedTypeForConflictedTypeWithUnsafeVariance";
                        break;
                    case 33:
                        objArr[2] = "filterOutUnsafeVariance";
                        break;
                    case 35:
                    case 36:
                    case 38:
                    case 39:
                        objArr[2] = "combine";
                        break;
                }
                String format = String.format(str, objArr);
                if (i2 != 1 && i2 != 2 && i2 != 8 && i2 != 34 && i2 != 37) {
                    switch (i2) {
                        default:
                            switch (i2) {
                                default:
                                    switch (i2) {
                                        default:
                                            switch (i2) {
                                                case 40:
                                                case 41:
                                                case 42:
                                                    break;
                                                default:
                                                    throw new IllegalArgumentException(format);
                                            }
                                        case 29:
                                        case 30:
                                        case 31:
                                        case 32:
                                            throw new IllegalStateException(format);
                                    }
                                case 19:
                                case 20:
                                case 21:
                                case 22:
                                case 23:
                                case 24:
                                case 25:
                                    break;
                            }
                        case 11:
                        case 12:
                        case 13:
                            break;
                    }
                }
                throw new IllegalStateException(format);
            }
            i3 = 2;
            Object[] objArr2 = new Object[i3];
            switch (i2) {
            }
            if (i2 != 1) {
            }
            switch (i2) {
            }
            String format2 = String.format(str, objArr2);
            if (i2 != 1) {
                switch (i2) {
                }
            }
            throw new IllegalStateException(format2);
        }
        str = "@NotNull method %s.%s must not return null";
        if (i2 != 1) {
            switch (i2) {
            }
            Object[] objArr22 = new Object[i3];
            switch (i2) {
            }
            if (i2 != 1) {
            }
            switch (i2) {
            }
            String format22 = String.format(str, objArr22);
            if (i2 != 1) {
            }
            throw new IllegalStateException(format22);
        }
        i3 = 2;
        Object[] objArr222 = new Object[i3];
        switch (i2) {
        }
        if (i2 != 1) {
        }
        switch (i2) {
        }
        String format222 = String.format(str, objArr222);
        if (i2 != 1) {
        }
        throw new IllegalStateException(format222);
    }

    private static void b(int i2, g1 g1Var, j1 j1Var) {
        if (i2 <= 100) {
            return;
        }
        throw new IllegalStateException("Recursion too deep. Most likely infinite loop while substituting " + o(g1Var) + "; substitution: " + o(j1Var));
    }

    public static r1 c(r1 r1Var, g1 g1Var) {
        if (r1Var == null) {
            a(35);
        }
        if (g1Var == null) {
            a(36);
        }
        if (!g1Var.c()) {
            return d(r1Var, g1Var.a());
        }
        r1 r1Var2 = r1.OUT_VARIANCE;
        if (r1Var2 == null) {
            a(37);
        }
        return r1Var2;
    }

    public static r1 d(r1 r1Var, r1 r1Var2) {
        if (r1Var == null) {
            a(38);
        }
        if (r1Var2 == null) {
            a(39);
        }
        r1 r1Var3 = r1.INVARIANT;
        if (r1Var == r1Var3) {
            if (r1Var2 == null) {
                a(40);
            }
            return r1Var2;
        }
        if (r1Var2 == r1Var3) {
            if (r1Var == null) {
                a(41);
            }
            return r1Var;
        }
        if (r1Var == r1Var2) {
            if (r1Var2 == null) {
                a(42);
            }
            return r1Var2;
        }
        throw new AssertionError("Variance conflict: type parameter variance '" + r1Var + "' and projection kind '" + r1Var2 + "' cannot be combined");
    }

    private static d e(r1 r1Var, r1 r1Var2) {
        r1 r1Var3 = r1.IN_VARIANCE;
        if (r1Var == r1Var3 && r1Var2 == r1.OUT_VARIANCE) {
            return d.OUT_IN_IN_POSITION;
        }
        if (r1Var == r1.OUT_VARIANCE && r1Var2 == r1Var3) {
            return d.IN_IN_OUT_POSITION;
        }
        return d.NO_CONFLICT;
    }

    public static l1 f(e0 e0Var) {
        if (e0Var == null) {
            a(6);
        }
        return g(f1.i(e0Var.O0(), e0Var.M0()));
    }

    public static l1 g(j1 j1Var) {
        if (j1Var == null) {
            a(0);
        }
        return new l1(j1Var);
    }

    public static l1 h(j1 j1Var, j1 j1Var2) {
        if (j1Var == null) {
            a(3);
        }
        if (j1Var2 == null) {
            a(4);
        }
        return g(u.i(j1Var, j1Var2));
    }

    private static g i(g gVar) {
        if (gVar == null) {
            a(33);
        }
        return !gVar.R0(k.a.Q) ? gVar : new l(gVar, new a());
    }

    private static g1 l(e0 e0Var, g1 g1Var, e1 e1Var, g1 g1Var2) {
        if (e0Var == null) {
            a(26);
        }
        if (g1Var == null) {
            a(27);
        }
        if (g1Var2 == null) {
            a(28);
        }
        if (!e0Var.getAnnotations().R0(k.a.Q)) {
            if (g1Var == null) {
                a(29);
            }
            return g1Var;
        }
        e1 O0 = g1Var.getType().O0();
        if (!(O0 instanceof j)) {
            return g1Var;
        }
        g1 f2 = ((j) O0).f();
        r1 a2 = f2.a();
        d e2 = e(g1Var2.a(), a2);
        d dVar = d.OUT_IN_IN_POSITION;
        if (e2 == dVar) {
            return new i1(f2.getType());
        }
        return (e1Var != null && e(e1Var.n(), a2) == dVar) ? new i1(f2.getType()) : g1Var;
    }

    private static String o(Object obj) {
        try {
            return obj.toString();
        } catch (Throwable th) {
            if (!kotlin.reflect.jvm.internal.impl.utils.c.a(th)) {
                return "[Exception while computing toString(): " + th + "]";
            }
            throw th;
        }
    }

    private g1 r(g1 g1Var, int i2) throws c {
        e0 type = g1Var.getType();
        r1 a2 = g1Var.a();
        if (type.O0().c() instanceof e1) {
            return g1Var;
        }
        m0 b2 = q0.b(type);
        e0 p = b2 != null ? m().p(b2, r1.INVARIANT) : null;
        e0 b3 = k1.b(type, s(type.O0().getParameters(), type.M0(), i2), this.f24756b.d(type.getAnnotations()));
        if ((b3 instanceof m0) && (p instanceof m0)) {
            b3 = q0.j((m0) b3, (m0) p);
        }
        return new i1(a2, b3);
    }

    private List<g1> s(List<e1> list, List<g1> list2, int i2) throws c {
        ArrayList arrayList = new ArrayList(list.size());
        boolean z = false;
        for (int i3 = 0; i3 < list.size(); i3++) {
            e1 e1Var = list.get(i3);
            g1 g1Var = list2.get(i3);
            g1 u = u(g1Var, e1Var, i2 + 1);
            int i4 = b.a[e(e1Var.n(), u.a()).ordinal()];
            if (i4 == 1 || i4 == 2) {
                u = n1.s(e1Var);
            } else if (i4 == 3) {
                r1 n = e1Var.n();
                r1 r1Var = r1.INVARIANT;
                if (n != r1Var && !u.c()) {
                    u = new i1(r1Var, u.getType());
                }
            }
            if (u != g1Var) {
                z = true;
            }
            arrayList.add(u);
        }
        return !z ? list2 : arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private g1 u(g1 g1Var, e1 e1Var, int i2) throws c {
        e0 q;
        if (g1Var == null) {
            a(18);
        }
        b(i2, g1Var, this.f24756b);
        if (g1Var.c()) {
            return g1Var;
        }
        e0 type = g1Var.getType();
        if (type instanceof o1) {
            o1 o1Var = (o1) type;
            q1 v = o1Var.v();
            e0 H = o1Var.H();
            g1 u = u(new i1(g1Var.a(), v), e1Var, i2 + 1);
            return u.c() ? u : new i1(u.a(), p1.d(u.getType().R0(), p(H, g1Var.a())));
        }
        if (!w.a(type) && !(type.R0() instanceof l0)) {
            g1 e2 = this.f24756b.e(type);
            g1 l = e2 != null ? l(type, e2, e1Var, g1Var) : null;
            r1 a2 = g1Var.a();
            if (l == null && b0.b(type) && !c1.b(type)) {
                y a3 = b0.a(type);
                int i3 = i2 + 1;
                g1 u2 = u(new i1(a2, a3.W0()), e1Var, i3);
                g1 u3 = u(new i1(a2, a3.X0()), e1Var, i3);
                return (u2.getType() == a3.W0() && u3.getType() == a3.X0()) ? g1Var : new i1(u2.a(), f0.d(k1.a(u2.getType()), k1.a(u3.getType())));
            }
            if (!h.m0(type) && !g0.a(type)) {
                if (l != null) {
                    d e3 = e(a2, l.a());
                    if (!kotlin.reflect.y.internal.j0.i.q.a.d.d(type)) {
                        int i4 = b.a[e3.ordinal()];
                        if (i4 == 1) {
                            throw new c("Out-projection in in-position");
                        }
                        if (i4 == 2) {
                            return new i1(r1.OUT_VARIANCE, type.O0().o().I());
                        }
                    }
                    n a4 = c1.a(type);
                    if (l.c()) {
                        return l;
                    }
                    if (a4 != null) {
                        q = a4.K(l.getType());
                    } else {
                        q = n1.q(l.getType(), type.P0());
                    }
                    if (!type.getAnnotations().isEmpty()) {
                        q = kotlin.reflect.y.internal.j0.l.x1.a.u(q, new kotlin.reflect.jvm.internal.impl.descriptors.n1.k(q.getAnnotations(), i(this.f24756b.d(type.getAnnotations()))));
                    }
                    if (e3 == d.NO_CONFLICT) {
                        a2 = d(a2, l.a());
                    }
                    return new i1(a2, q);
                }
                g1Var = r(g1Var, i2);
                if (g1Var == null) {
                    a(25);
                }
            }
        }
        return g1Var;
    }

    public j1 j() {
        j1 j1Var = this.f24756b;
        if (j1Var == null) {
            a(8);
        }
        return j1Var;
    }

    public boolean k() {
        return this.f24756b.f();
    }

    public l1 m() {
        j1 j1Var = this.f24756b;
        return ((j1Var instanceof c0) && j1Var.b()) ? new l1(new c0(((c0) this.f24756b).j(), ((c0) this.f24756b).i(), false)) : this;
    }

    public e0 n(e0 e0Var, r1 r1Var) {
        if (e0Var == null) {
            a(9);
        }
        if (r1Var == null) {
            a(10);
        }
        if (k()) {
            if (e0Var == null) {
                a(11);
            }
            return e0Var;
        }
        try {
            e0 type = u(new i1(r1Var, e0Var), null, 0).getType();
            if (type == null) {
                a(12);
            }
            return type;
        } catch (c e2) {
            kotlin.reflect.y.internal.j0.l.u1.h d2 = kotlin.reflect.y.internal.j0.l.u1.k.d(kotlin.reflect.y.internal.j0.l.u1.j.G, e2.getMessage());
            if (d2 == null) {
                a(13);
            }
            return d2;
        }
    }

    public e0 p(e0 e0Var, r1 r1Var) {
        if (e0Var == null) {
            a(14);
        }
        if (r1Var == null) {
            a(15);
        }
        g1 q = q(new i1(r1Var, j().g(e0Var, r1Var)));
        if (q == null) {
            return null;
        }
        return q.getType();
    }

    public g1 q(g1 g1Var) {
        if (g1Var == null) {
            a(16);
        }
        g1 t = t(g1Var);
        return (this.f24756b.a() || this.f24756b.b()) ? kotlin.reflect.y.internal.j0.l.y1.b.c(t, this.f24756b.b()) : t;
    }

    public g1 t(g1 g1Var) {
        if (g1Var == null) {
            a(17);
        }
        if (k()) {
            return g1Var;
        }
        try {
            return u(g1Var, null, 0);
        } catch (c unused) {
            return null;
        }
    }
}
