package kotlin.reflect.jvm.internal.impl.descriptors.p1;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.b;
import kotlin.reflect.jvm.internal.impl.descriptors.i1;
import kotlin.reflect.jvm.internal.impl.descriptors.s0;
import kotlin.reflect.jvm.internal.impl.descriptors.t0;
import kotlin.reflect.jvm.internal.impl.descriptors.u0;
import kotlin.reflect.jvm.internal.impl.descriptors.z0;

/* compiled from: PropertyGetterDescriptorImpl.java */
/* loaded from: classes2.dex */
public class d0 extends b0 implements u0 {
    private kotlin.reflect.y.internal.j0.l.e0 r;
    private final u0 s;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public d0(t0 t0Var, kotlin.reflect.jvm.internal.impl.descriptors.n1.g gVar, kotlin.reflect.jvm.internal.impl.descriptors.d0 d0Var, kotlin.reflect.jvm.internal.impl.descriptors.u uVar, boolean z, boolean z2, boolean z3, b.a aVar, u0 u0Var, z0 z0Var) {
        super(d0Var, uVar, t0Var, gVar, kotlin.reflect.y.internal.j0.f.f.D("<get-" + t0Var.getName() + ">"), z, z2, z3, aVar, z0Var);
        d0 d0Var2;
        d0 d0Var3;
        if (t0Var == null) {
            v(0);
        }
        if (gVar == null) {
            v(1);
        }
        if (d0Var == null) {
            v(2);
        }
        if (uVar == null) {
            v(3);
        }
        if (aVar == null) {
            v(4);
        }
        if (z0Var == null) {
            v(5);
        }
        if (u0Var != 0) {
            d0Var3 = this;
            d0Var2 = u0Var;
        } else {
            d0Var2 = this;
            d0Var3 = d0Var2;
        }
        d0Var3.s = d0Var2;
    }

    private static /* synthetic */ void v(int i2) {
        String str = (i2 == 6 || i2 == 7 || i2 == 8) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i2 == 6 || i2 == 7 || i2 == 8) ? 2 : 3];
        switch (i2) {
            case 1:
                objArr[0] = "annotations";
                break;
            case 2:
                objArr[0] = "modality";
                break;
            case 3:
                objArr[0] = "visibility";
                break;
            case 4:
                objArr[0] = "kind";
                break;
            case 5:
                objArr[0] = "source";
                break;
            case 6:
            case 7:
            case 8:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyGetterDescriptorImpl";
                break;
            default:
                objArr[0] = "correspondingProperty";
                break;
        }
        if (i2 == 6) {
            objArr[1] = "getOverriddenDescriptors";
        } else if (i2 == 7) {
            objArr[1] = "getValueParameters";
        } else if (i2 != 8) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertyGetterDescriptorImpl";
        } else {
            objArr[1] = "getOriginal";
        }
        if (i2 != 6 && i2 != 7 && i2 != 8) {
            objArr[2] = "<init>";
        }
        String format = String.format(str, objArr);
        if (i2 != 6 && i2 != 7 && i2 != 8) {
            throw new IllegalArgumentException(format);
        }
        throw new IllegalStateException(format);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.m
    public <R, D> R L(kotlin.reflect.jvm.internal.impl.descriptors.o<R, D> oVar, D d2) {
        return oVar.b(this, d2);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.p1.b0, kotlin.reflect.jvm.internal.impl.descriptors.p1.k, kotlin.reflect.jvm.internal.impl.descriptors.p1.j, kotlin.reflect.jvm.internal.impl.descriptors.m
    /* renamed from: Q0, reason: merged with bridge method [inline-methods] */
    public u0 a() {
        u0 u0Var = this.s;
        if (u0Var == null) {
            v(8);
        }
        return u0Var;
    }

    public void R0(kotlin.reflect.y.internal.j0.l.e0 e0Var) {
        if (e0Var == null) {
            e0Var = B0().getType();
        }
        this.r = e0Var;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.y, kotlin.reflect.jvm.internal.impl.descriptors.b, kotlin.reflect.jvm.internal.impl.descriptors.a
    public Collection<? extends u0> e() {
        Collection<s0> M0 = super.M0(true);
        if (M0 == null) {
            v(6);
        }
        return M0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.a
    public List<i1> f() {
        List<i1> emptyList = Collections.emptyList();
        if (emptyList == null) {
            v(7);
        }
        return emptyList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.a
    public kotlin.reflect.y.internal.j0.l.e0 getReturnType() {
        return this.r;
    }
}
