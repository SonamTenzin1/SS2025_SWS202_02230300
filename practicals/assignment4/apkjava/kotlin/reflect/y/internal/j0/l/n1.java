package kotlin.reflect.y.internal.j0.l;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.c0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.descriptors.e;
import kotlin.reflect.jvm.internal.impl.descriptors.e1;
import kotlin.reflect.jvm.internal.impl.descriptors.h;
import kotlin.reflect.jvm.internal.impl.utils.f;
import kotlin.reflect.y.internal.j0.l.t1.g;
import kotlin.reflect.y.internal.j0.l.t1.n;
import kotlin.reflect.y.internal.j0.l.u1.j;
import kotlin.reflect.y.internal.j0.l.u1.k;

/* compiled from: TypeUtils.java */
/* loaded from: classes3.dex */
public class n1 {
    public static final m0 a = k.d(j.H, new String[0]);

    /* renamed from: b, reason: collision with root package name */
    public static final m0 f24766b = k.d(j.A, new String[0]);

    /* renamed from: c, reason: collision with root package name */
    public static final m0 f24767c = new a("NO_EXPECTED_TYPE");

    /* renamed from: d, reason: collision with root package name */
    public static final m0 f24768d = new a("UNIT_EXPECTED_TYPE");

    /* compiled from: TypeUtils.java */
    /* loaded from: classes3.dex */
    public static class a extends r {

        /* renamed from: g, reason: collision with root package name */
        private final String f24769g;

        public a(String str) {
            this.f24769g = str;
        }

        /* JADX WARN: Removed duplicated region for block: B:17:0x0036  */
        /* JADX WARN: Removed duplicated region for block: B:20:0x0044  */
        /* JADX WARN: Removed duplicated region for block: B:35:0x003e  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private static /* synthetic */ void a1(int i2) {
            String format;
            String str = (i2 == 1 || i2 == 4) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
            Object[] objArr = new Object[(i2 == 1 || i2 == 4) ? 2 : 3];
            if (i2 != 1) {
                if (i2 == 2) {
                    objArr[0] = "delegate";
                } else if (i2 == 3) {
                    objArr[0] = "kotlinTypeRefiner";
                } else if (i2 != 4) {
                    objArr[0] = "newAttributes";
                }
                if (i2 != 1) {
                    objArr[1] = "toString";
                } else if (i2 != 4) {
                    objArr[1] = "kotlin/reflect/jvm/internal/impl/types/TypeUtils$SpecialType";
                } else {
                    objArr[1] = "refine";
                }
                if (i2 != 1) {
                    if (i2 == 2) {
                        objArr[2] = "replaceDelegate";
                    } else if (i2 == 3) {
                        objArr[2] = "refine";
                    } else if (i2 != 4) {
                        objArr[2] = "replaceAttributes";
                    }
                }
                format = String.format(str, objArr);
                if (i2 == 1 && i2 != 4) {
                    throw new IllegalArgumentException(format);
                }
                throw new IllegalStateException(format);
            }
            objArr[0] = "kotlin/reflect/jvm/internal/impl/types/TypeUtils$SpecialType";
            if (i2 != 1) {
            }
            if (i2 != 1) {
            }
            format = String.format(str, objArr);
            if (i2 == 1) {
            }
            throw new IllegalStateException(format);
        }

        @Override // kotlin.reflect.y.internal.j0.l.q1
        /* renamed from: V0, reason: merged with bridge method [inline-methods] */
        public m0 S0(boolean z) {
            throw new IllegalStateException(this.f24769g);
        }

        @Override // kotlin.reflect.y.internal.j0.l.q1
        /* renamed from: W0, reason: merged with bridge method [inline-methods] */
        public m0 U0(a1 a1Var) {
            if (a1Var == null) {
                a1(0);
            }
            throw new IllegalStateException(this.f24769g);
        }

        @Override // kotlin.reflect.y.internal.j0.l.r
        protected m0 X0() {
            throw new IllegalStateException(this.f24769g);
        }

        @Override // kotlin.reflect.y.internal.j0.l.r
        public r Z0(m0 m0Var) {
            if (m0Var == null) {
                a1(2);
            }
            throw new IllegalStateException(this.f24769g);
        }

        @Override // kotlin.reflect.y.internal.j0.l.r
        /* renamed from: b1, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
        public a Y0(g gVar) {
            if (gVar == null) {
                a1(3);
            }
            return this;
        }

        @Override // kotlin.reflect.y.internal.j0.l.m0
        public String toString() {
            String str = this.f24769g;
            if (str == null) {
                a1(1);
            }
            return str;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:107:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0140  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x014c  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0152  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x015e  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0164  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0169  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x016e  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0173  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0178  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x017d  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0182  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0187  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x018c  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0191  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0194  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0199  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x019e  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x01a1  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x01a4  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x01a7  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x01ac  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x01af  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x01b2  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x01b7  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x01c1 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:94:0x01da  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static /* synthetic */ void a(int i2) {
        String str;
        int i3;
        if (i2 != 4 && i2 != 9 && i2 != 11 && i2 != 15 && i2 != 17 && i2 != 19 && i2 != 26 && i2 != 35 && i2 != 47 && i2 != 52 && i2 != 6 && i2 != 7) {
            switch (i2) {
                case 55:
                case 56:
                case 57:
                case 58:
                    break;
                default:
                    str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                    break;
            }
            if (i2 != 4 && i2 != 9 && i2 != 11 && i2 != 15 && i2 != 17 && i2 != 19 && i2 != 26 && i2 != 35 && i2 != 47 && i2 != 52 && i2 != 6 && i2 != 7) {
                switch (i2) {
                    case 55:
                    case 56:
                    case 57:
                    case 58:
                        break;
                    default:
                        i3 = 3;
                        break;
                }
                Object[] objArr = new Object[i3];
                switch (i2) {
                    case 4:
                    case 6:
                    case 7:
                    case 9:
                    case 11:
                    case 15:
                    case 17:
                    case 19:
                    case 26:
                    case 35:
                    case 47:
                    case 52:
                    case 55:
                    case 56:
                    case 57:
                    case 58:
                        objArr[0] = "kotlin/reflect/jvm/internal/impl/types/TypeUtils";
                        break;
                    case 5:
                    case 8:
                    case 10:
                    case 18:
                    case 23:
                    case 25:
                    case 27:
                    case 28:
                    case 29:
                    case 30:
                    case 38:
                    case 40:
                    default:
                        objArr[0] = "type";
                        break;
                    case 12:
                        objArr[0] = "typeConstructor";
                        break;
                    case 13:
                        objArr[0] = "unsubstitutedMemberScope";
                        break;
                    case 14:
                        objArr[0] = "refinedTypeFactory";
                        break;
                    case 16:
                        objArr[0] = "parameters";
                        break;
                    case 20:
                        objArr[0] = "subType";
                        break;
                    case 21:
                        objArr[0] = "superType";
                        break;
                    case 22:
                        objArr[0] = "substitutor";
                        break;
                    case 24:
                        objArr[0] = "result";
                        break;
                    case 31:
                    case 33:
                        objArr[0] = "clazz";
                        break;
                    case 32:
                        objArr[0] = "typeArguments";
                        break;
                    case 34:
                        objArr[0] = "projections";
                        break;
                    case 36:
                        objArr[0] = "a";
                        break;
                    case 37:
                        objArr[0] = "b";
                        break;
                    case 39:
                        objArr[0] = "typeParameters";
                        break;
                    case 41:
                        objArr[0] = "typeParameterConstructors";
                        break;
                    case 42:
                        objArr[0] = "specialType";
                        break;
                    case 43:
                    case 44:
                        objArr[0] = "isSpecialType";
                        break;
                    case 45:
                        objArr[0] = "parameterDescriptor";
                        break;
                    case 46:
                    case 50:
                        objArr[0] = "numberValueTypeConstructor";
                        break;
                    case 48:
                    case 49:
                        objArr[0] = "supertypes";
                        break;
                    case 51:
                    case 54:
                        objArr[0] = "expectedType";
                        break;
                    case 53:
                        objArr[0] = "literalTypeConstructor";
                        break;
                }
                if (i2 == 4) {
                    if (i2 != 9) {
                        if (i2 == 11 || i2 == 15) {
                            objArr[1] = "makeUnsubstitutedType";
                        } else if (i2 == 17) {
                            objArr[1] = "getDefaultTypeProjections";
                        } else if (i2 == 19) {
                            objArr[1] = "getImmediateSupertypes";
                        } else if (i2 == 26) {
                            objArr[1] = "getAllSupertypes";
                        } else if (i2 == 35) {
                            objArr[1] = "substituteProjectionsForParameters";
                        } else if (i2 != 47) {
                            if (i2 != 52) {
                                if (i2 != 6 && i2 != 7) {
                                    switch (i2) {
                                        case 55:
                                        case 56:
                                        case 57:
                                        case 58:
                                            break;
                                        default:
                                            objArr[1] = "kotlin/reflect/jvm/internal/impl/types/TypeUtils";
                                            break;
                                    }
                                }
                            }
                            objArr[1] = "getPrimitiveNumberType";
                        } else {
                            objArr[1] = "getDefaultPrimitiveNumberType";
                        }
                    }
                    objArr[1] = "makeNullableIfNeeded";
                } else {
                    objArr[1] = "makeNullableAsSpecified";
                }
                switch (i2) {
                    case 1:
                        objArr[2] = "makeNullable";
                        break;
                    case 2:
                        objArr[2] = "makeNotNullable";
                        break;
                    case 3:
                        objArr[2] = "makeNullableAsSpecified";
                        break;
                    case 4:
                    case 6:
                    case 7:
                    case 9:
                    case 11:
                    case 15:
                    case 17:
                    case 19:
                    case 26:
                    case 35:
                    case 47:
                    case 52:
                    case 55:
                    case 56:
                    case 57:
                    case 58:
                        break;
                    case 5:
                    case 8:
                        objArr[2] = "makeNullableIfNeeded";
                        break;
                    case 10:
                        objArr[2] = "canHaveSubtypes";
                        break;
                    case 12:
                    case 13:
                    case 14:
                        objArr[2] = "makeUnsubstitutedType";
                        break;
                    case 16:
                        objArr[2] = "getDefaultTypeProjections";
                        break;
                    case 18:
                        objArr[2] = "getImmediateSupertypes";
                        break;
                    case 20:
                    case 21:
                    case 22:
                        objArr[2] = "createSubstitutedSupertype";
                        break;
                    case 23:
                    case 24:
                        objArr[2] = "collectAllSupertypes";
                        break;
                    case 25:
                        objArr[2] = "getAllSupertypes";
                        break;
                    case 27:
                        objArr[2] = "isNullableType";
                        break;
                    case 28:
                        objArr[2] = "acceptsNullable";
                        break;
                    case 29:
                        objArr[2] = "hasNullableSuperType";
                        break;
                    case 30:
                        objArr[2] = "getClassDescriptor";
                        break;
                    case 31:
                    case 32:
                        objArr[2] = "substituteParameters";
                        break;
                    case 33:
                    case 34:
                        objArr[2] = "substituteProjectionsForParameters";
                        break;
                    case 36:
                    case 37:
                        objArr[2] = "equalTypes";
                        break;
                    case 38:
                    case 39:
                        objArr[2] = "dependsOnTypeParameters";
                        break;
                    case 40:
                    case 41:
                        objArr[2] = "dependsOnTypeConstructors";
                        break;
                    case 42:
                    case 43:
                    case 44:
                        objArr[2] = "contains";
                        break;
                    case 45:
                        objArr[2] = "makeStarProjection";
                        break;
                    case 46:
                    case 48:
                        objArr[2] = "getDefaultPrimitiveNumberType";
                        break;
                    case 49:
                        objArr[2] = "findByFqName";
                        break;
                    case 50:
                    case 51:
                    case 53:
                    case 54:
                        objArr[2] = "getPrimitiveNumberType";
                        break;
                    case 59:
                        objArr[2] = "isTypeParameter";
                        break;
                    case 60:
                        objArr[2] = "isReifiedTypeParameter";
                        break;
                    case 61:
                        objArr[2] = "isNonReifiedTypeParameter";
                        break;
                    case 62:
                        objArr[2] = "getTypeParameterDescriptorOrNull";
                        break;
                    default:
                        objArr[2] = "noExpectedType";
                        break;
                }
                String format = String.format(str, objArr);
                if (i2 != 4 && i2 != 9 && i2 != 11 && i2 != 15 && i2 != 17 && i2 != 19 && i2 != 26 && i2 != 35 && i2 != 47 && i2 != 52 && i2 != 6 && i2 != 7) {
                    switch (i2) {
                        case 55:
                        case 56:
                        case 57:
                        case 58:
                            break;
                        default:
                            throw new IllegalArgumentException(format);
                    }
                }
                throw new IllegalStateException(format);
            }
            i3 = 2;
            Object[] objArr2 = new Object[i3];
            switch (i2) {
            }
            if (i2 == 4) {
            }
            switch (i2) {
            }
            String format2 = String.format(str, objArr2);
            if (i2 != 4) {
                switch (i2) {
                }
            }
            throw new IllegalStateException(format2);
        }
        str = "@NotNull method %s.%s must not return null";
        if (i2 != 4) {
            switch (i2) {
            }
            Object[] objArr22 = new Object[i3];
            switch (i2) {
            }
            if (i2 == 4) {
            }
            switch (i2) {
            }
            String format22 = String.format(str, objArr22);
            if (i2 != 4) {
            }
            throw new IllegalStateException(format22);
        }
        i3 = 2;
        Object[] objArr222 = new Object[i3];
        switch (i2) {
        }
        if (i2 == 4) {
        }
        switch (i2) {
        }
        String format222 = String.format(str, objArr222);
        if (i2 != 4) {
        }
        throw new IllegalStateException(format222);
    }

    public static boolean b(e0 e0Var) {
        if (e0Var == null) {
            a(28);
        }
        if (e0Var.P0()) {
            return true;
        }
        return b0.b(e0Var) && b(b0.a(e0Var).X0());
    }

    public static boolean c(e0 e0Var, Function1<q1, Boolean> function1) {
        if (function1 == null) {
            a(43);
        }
        return d(e0Var, function1, null);
    }

    private static boolean d(e0 e0Var, Function1<q1, Boolean> function1, f<e0> fVar) {
        if (function1 == null) {
            a(44);
        }
        if (e0Var == null) {
            return false;
        }
        q1 R0 = e0Var.R0();
        if (v(e0Var)) {
            return function1.invoke(R0).booleanValue();
        }
        if (fVar != null && fVar.contains(e0Var)) {
            return false;
        }
        if (function1.invoke(R0).booleanValue()) {
            return true;
        }
        if (fVar == null) {
            fVar = f.c();
        }
        fVar.add(e0Var);
        y yVar = R0 instanceof y ? (y) R0 : null;
        if (yVar != null && (d(yVar.W0(), function1, fVar) || d(yVar.X0(), function1, fVar))) {
            return true;
        }
        if ((R0 instanceof p) && d(((p) R0).a1(), function1, fVar)) {
            return true;
        }
        e1 O0 = e0Var.O0();
        if (O0 instanceof d0) {
            Iterator<e0> it = ((d0) O0).a().iterator();
            while (it.hasNext()) {
                if (d(it.next(), function1, fVar)) {
                    return true;
                }
            }
            return false;
        }
        for (g1 g1Var : e0Var.M0()) {
            if (!g1Var.c()) {
                if (d(g1Var.getType(), function1, fVar)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static e0 e(e0 e0Var, e0 e0Var2, l1 l1Var) {
        if (e0Var == null) {
            a(20);
        }
        if (e0Var2 == null) {
            a(21);
        }
        if (l1Var == null) {
            a(22);
        }
        e0 p = l1Var.p(e0Var2, r1.INVARIANT);
        if (p != null) {
            return q(p, e0Var.P0());
        }
        return null;
    }

    public static e f(e0 e0Var) {
        if (e0Var == null) {
            a(30);
        }
        h w = e0Var.O0().w();
        if (w instanceof e) {
            return (e) w;
        }
        return null;
    }

    public static List<g1> g(List<e1> list) {
        List<g1> E0;
        if (list == null) {
            a(16);
        }
        ArrayList arrayList = new ArrayList(list.size());
        Iterator<e1> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(new i1(it.next().s()));
        }
        E0 = c0.E0(arrayList);
        if (E0 == null) {
            a(17);
        }
        return E0;
    }

    public static List<e0> h(e0 e0Var) {
        if (e0Var == null) {
            a(18);
        }
        l1 f2 = l1.f(e0Var);
        Collection<e0> a2 = e0Var.O0().a();
        ArrayList arrayList = new ArrayList(a2.size());
        Iterator<e0> it = a2.iterator();
        while (it.hasNext()) {
            e0 e2 = e(e0Var, it.next(), f2);
            if (e2 != null) {
                arrayList.add(e2);
            }
        }
        return arrayList;
    }

    public static e1 i(e0 e0Var) {
        if (e0Var == null) {
            a(62);
        }
        if (e0Var.O0().w() instanceof e1) {
            return (e1) e0Var.O0().w();
        }
        return null;
    }

    public static boolean j(e0 e0Var) {
        if (e0Var == null) {
            a(29);
        }
        if (e0Var.O0().w() instanceof e) {
            return false;
        }
        Iterator<e0> it = h(e0Var).iterator();
        while (it.hasNext()) {
            if (l(it.next())) {
                return true;
            }
        }
        return false;
    }

    public static boolean k(e0 e0Var) {
        return e0Var != null && e0Var.O0() == a.O0();
    }

    public static boolean l(e0 e0Var) {
        if (e0Var == null) {
            a(27);
        }
        if (e0Var.P0()) {
            return true;
        }
        if (b0.b(e0Var) && l(b0.a(e0Var).X0())) {
            return true;
        }
        if (q0.c(e0Var)) {
            return false;
        }
        if (m(e0Var)) {
            return j(e0Var);
        }
        if (e0Var instanceof e) {
            e1 d2 = ((e) e0Var).X0().d();
            return d2 == null || j(d2.s());
        }
        e1 O0 = e0Var.O0();
        if (O0 instanceof d0) {
            Iterator<e0> it = O0.a().iterator();
            while (it.hasNext()) {
                if (l(it.next())) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean m(e0 e0Var) {
        if (e0Var == null) {
            a(59);
        }
        return i(e0Var) != null || (e0Var.O0() instanceof n);
    }

    public static e0 n(e0 e0Var) {
        if (e0Var == null) {
            a(2);
        }
        return p(e0Var, false);
    }

    public static e0 o(e0 e0Var) {
        if (e0Var == null) {
            a(1);
        }
        return p(e0Var, true);
    }

    public static e0 p(e0 e0Var, boolean z) {
        if (e0Var == null) {
            a(3);
        }
        q1 S0 = e0Var.R0().S0(z);
        if (S0 == null) {
            a(4);
        }
        return S0;
    }

    public static e0 q(e0 e0Var, boolean z) {
        if (e0Var == null) {
            a(8);
        }
        if (z) {
            return o(e0Var);
        }
        if (e0Var == null) {
            a(9);
        }
        return e0Var;
    }

    public static m0 r(m0 m0Var, boolean z) {
        if (m0Var == null) {
            a(5);
        }
        if (!z) {
            if (m0Var == null) {
                a(7);
            }
            return m0Var;
        }
        m0 S0 = m0Var.S0(true);
        if (S0 == null) {
            a(6);
        }
        return S0;
    }

    public static g1 s(e1 e1Var) {
        if (e1Var == null) {
            a(45);
        }
        return new s0(e1Var);
    }

    public static m0 t(h hVar, kotlin.reflect.y.internal.j0.i.w.h hVar2, Function1<g, m0> function1) {
        if (k.m(hVar)) {
            kotlin.reflect.y.internal.j0.l.u1.h d2 = k.d(j.G, hVar.toString());
            if (d2 == null) {
                a(11);
            }
            return d2;
        }
        return u(hVar.h(), hVar2, function1);
    }

    public static m0 u(e1 e1Var, kotlin.reflect.y.internal.j0.i.w.h hVar, Function1<g, m0> function1) {
        if (e1Var == null) {
            a(12);
        }
        if (hVar == null) {
            a(13);
        }
        if (function1 == null) {
            a(14);
        }
        m0 k2 = f0.k(a1.f24676g.h(), e1Var, g(e1Var.getParameters()), false, hVar, function1);
        if (k2 == null) {
            a(15);
        }
        return k2;
    }

    public static boolean v(e0 e0Var) {
        if (e0Var == null) {
            a(0);
        }
        return e0Var == f24767c || e0Var == f24768d;
    }
}
