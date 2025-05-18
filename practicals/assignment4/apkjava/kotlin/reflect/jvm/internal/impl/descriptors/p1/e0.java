package kotlin.reflect.jvm.internal.impl.descriptors.p1;

import com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdAdapter;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.b;
import kotlin.reflect.jvm.internal.impl.descriptors.i1;
import kotlin.reflect.jvm.internal.impl.descriptors.s0;
import kotlin.reflect.jvm.internal.impl.descriptors.t0;
import kotlin.reflect.jvm.internal.impl.descriptors.v0;
import kotlin.reflect.jvm.internal.impl.descriptors.z0;

/* compiled from: PropertySetterDescriptorImpl.java */
/* loaded from: classes2.dex */
public class e0 extends b0 implements v0 {
    private i1 r;
    private final v0 s;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public e0(t0 t0Var, kotlin.reflect.jvm.internal.impl.descriptors.n1.g gVar, kotlin.reflect.jvm.internal.impl.descriptors.d0 d0Var, kotlin.reflect.jvm.internal.impl.descriptors.u uVar, boolean z, boolean z2, boolean z3, b.a aVar, v0 v0Var, z0 z0Var) {
        super(d0Var, uVar, t0Var, gVar, kotlin.reflect.y.internal.j0.f.f.D("<set-" + t0Var.getName() + ">"), z, z2, z3, aVar, z0Var);
        e0 e0Var;
        e0 e0Var2;
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
        if (v0Var != 0) {
            e0Var2 = this;
            e0Var = v0Var;
        } else {
            e0Var = this;
            e0Var2 = e0Var;
        }
        e0Var2.s = e0Var;
    }

    public static l0 Q0(v0 v0Var, kotlin.reflect.y.internal.j0.l.e0 e0Var, kotlin.reflect.jvm.internal.impl.descriptors.n1.g gVar) {
        if (v0Var == null) {
            v(7);
        }
        if (e0Var == null) {
            v(8);
        }
        if (gVar == null) {
            v(9);
        }
        return new l0(v0Var, null, 0, gVar, kotlin.reflect.y.internal.j0.f.h.n, e0Var, false, false, false, null, z0.a);
    }

    private static /* synthetic */ void v(int i2) {
        String str;
        int i3;
        switch (i2) {
            case 10:
            case 11:
            case 12:
            case 13:
                str = "@NotNull method %s.%s must not return null";
                break;
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i2) {
            case 10:
            case 11:
            case 12:
            case 13:
                i3 = 2;
                break;
            default:
                i3 = 3;
                break;
        }
        Object[] objArr = new Object[i3];
        switch (i2) {
            case 1:
            case 9:
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
                objArr[0] = MediationRewardedVideoAdAdapter.CUSTOM_EVENT_SERVER_PARAMETER_FIELD;
                break;
            case 7:
                objArr[0] = "setterDescriptor";
                break;
            case 8:
                objArr[0] = "type";
                break;
            case 10:
            case 11:
            case 12:
            case 13:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertySetterDescriptorImpl";
                break;
            default:
                objArr[0] = "correspondingProperty";
                break;
        }
        switch (i2) {
            case 10:
                objArr[1] = "getOverriddenDescriptors";
                break;
            case 11:
                objArr[1] = "getValueParameters";
                break;
            case 12:
                objArr[1] = "getReturnType";
                break;
            case 13:
                objArr[1] = "getOriginal";
                break;
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/PropertySetterDescriptorImpl";
                break;
        }
        switch (i2) {
            case 6:
                objArr[2] = "initialize";
                break;
            case 7:
            case 8:
            case 9:
                objArr[2] = "createSetterParameter";
                break;
            case 10:
            case 11:
            case 12:
            case 13:
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String format = String.format(str, objArr);
        switch (i2) {
            case 10:
            case 11:
            case 12:
            case 13:
                throw new IllegalStateException(format);
            default:
                throw new IllegalArgumentException(format);
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.m
    public <R, D> R L(kotlin.reflect.jvm.internal.impl.descriptors.o<R, D> oVar, D d2) {
        return oVar.i(this, d2);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.p1.b0, kotlin.reflect.jvm.internal.impl.descriptors.p1.k, kotlin.reflect.jvm.internal.impl.descriptors.p1.j, kotlin.reflect.jvm.internal.impl.descriptors.m
    /* renamed from: R0, reason: merged with bridge method [inline-methods] */
    public v0 a() {
        v0 v0Var = this.s;
        if (v0Var == null) {
            v(13);
        }
        return v0Var;
    }

    public void S0(i1 i1Var) {
        if (i1Var == null) {
            v(6);
        }
        this.r = i1Var;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.y, kotlin.reflect.jvm.internal.impl.descriptors.b, kotlin.reflect.jvm.internal.impl.descriptors.a
    public Collection<? extends v0> e() {
        Collection<s0> M0 = super.M0(false);
        if (M0 == null) {
            v(10);
        }
        return M0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.a
    public List<i1> f() {
        i1 i1Var = this.r;
        if (i1Var != null) {
            List<i1> singletonList = Collections.singletonList(i1Var);
            if (singletonList == null) {
                v(11);
            }
            return singletonList;
        }
        throw new IllegalStateException();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.a
    public kotlin.reflect.y.internal.j0.l.e0 getReturnType() {
        kotlin.reflect.y.internal.j0.l.m0 Z = kotlin.reflect.y.internal.j0.i.t.a.f(this).Z();
        if (Z == null) {
            v(12);
        }
        return Z;
    }
}
