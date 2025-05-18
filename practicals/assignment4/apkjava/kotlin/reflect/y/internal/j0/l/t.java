package kotlin.reflect.y.internal.j0.l;

import java.util.HashMap;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.e1;
import kotlin.reflect.jvm.internal.impl.descriptors.h;
import kotlin.reflect.jvm.internal.impl.descriptors.m;
import kotlin.reflect.jvm.internal.impl.descriptors.p1.k0;
import kotlin.reflect.jvm.internal.impl.descriptors.z0;
import kotlin.reflect.y.internal.j0.l.x1.a;

/* compiled from: DescriptorSubstitutor.java */
/* loaded from: classes3.dex */
public class t {
    private static /* synthetic */ void a(int i2) {
        String str = i2 != 4 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
        Object[] objArr = new Object[i2 != 4 ? 3 : 2];
        switch (i2) {
            case 1:
            case 6:
                objArr[0] = "originalSubstitution";
                break;
            case 2:
            case 7:
                objArr[0] = "newContainingDeclaration";
                break;
            case 3:
            case 8:
                objArr[0] = "result";
                break;
            case 4:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/types/DescriptorSubstitutor";
                break;
            case 5:
            default:
                objArr[0] = "typeParameters";
                break;
        }
        if (i2 != 4) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/types/DescriptorSubstitutor";
        } else {
            objArr[1] = "substituteTypeParameters";
        }
        if (i2 != 4) {
            objArr[2] = "substituteTypeParameters";
        }
        String format = String.format(str, objArr);
        if (i2 == 4) {
            throw new IllegalStateException(format);
        }
    }

    public static l1 b(List<e1> list, j1 j1Var, m mVar, List<e1> list2) {
        if (list == null) {
            a(0);
        }
        if (j1Var == null) {
            a(1);
        }
        if (mVar == null) {
            a(2);
        }
        if (list2 == null) {
            a(3);
        }
        l1 c2 = c(list, j1Var, mVar, list2, null);
        if (c2 != null) {
            return c2;
        }
        throw new AssertionError("Substitution failed");
    }

    public static l1 c(List<e1> list, j1 j1Var, m mVar, List<e1> list2, boolean[] zArr) {
        if (list == null) {
            a(5);
        }
        if (j1Var == null) {
            a(6);
        }
        if (mVar == null) {
            a(7);
        }
        if (list2 == null) {
            a(8);
        }
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        int i2 = 0;
        for (e1 e1Var : list) {
            k0 R0 = k0.R0(mVar, e1Var.getAnnotations(), e1Var.F(), e1Var.n(), e1Var.getName(), i2, z0.a, e1Var.h0());
            hashMap.put(e1Var.h(), new i1(R0.s()));
            hashMap2.put(e1Var, R0);
            list2.add(R0);
            i2++;
        }
        f1 j2 = f1.j(hashMap);
        l1 h2 = l1.h(j1Var, j2);
        l1 h3 = l1.h(j1Var.h(), j2);
        for (e1 e1Var2 : list) {
            k0 k0Var = (k0) hashMap2.get(e1Var2);
            for (e0 e0Var : e1Var2.getUpperBounds()) {
                h w = e0Var.O0().w();
                e0 p = (((w instanceof e1) && a.j((e1) w)) ? h2 : h3).p(e0Var, r1.OUT_VARIANCE);
                if (p == null) {
                    return null;
                }
                if (p != e0Var && zArr != null) {
                    zArr[0] = true;
                }
                k0Var.N0(p);
            }
            k0Var.W0();
        }
        return h2;
    }
}
