package kotlin.reflect.jvm.internal.impl.descriptors.p1;

import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.e1;
import kotlin.reflect.jvm.internal.impl.descriptors.i1;
import kotlin.reflect.jvm.internal.impl.descriptors.j1;
import kotlin.reflect.jvm.internal.impl.descriptors.w0;
import kotlin.reflect.jvm.internal.impl.descriptors.z0;

/* compiled from: VariableDescriptorImpl.java */
/* loaded from: classes2.dex */
public abstract class m0 extends k implements j1 {

    /* renamed from: j, reason: collision with root package name */
    protected kotlin.reflect.y.internal.j0.l.e0 f25251j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m0(kotlin.reflect.jvm.internal.impl.descriptors.m mVar, kotlin.reflect.jvm.internal.impl.descriptors.n1.g gVar, kotlin.reflect.y.internal.j0.f.f fVar, kotlin.reflect.y.internal.j0.l.e0 e0Var, z0 z0Var) {
        super(mVar, gVar, fVar, z0Var);
        if (mVar == null) {
            v(0);
        }
        if (gVar == null) {
            v(1);
        }
        if (fVar == null) {
            v(2);
        }
        if (z0Var == null) {
            v(3);
        }
        this.f25251j = e0Var;
    }

    private static /* synthetic */ void v(int i2) {
        String str;
        int i3;
        switch (i2) {
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
                str = "@NotNull method %s.%s must not return null";
                break;
            default:
                str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                break;
        }
        switch (i2) {
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
                i3 = 2;
                break;
            default:
                i3 = 3;
                break;
        }
        Object[] objArr = new Object[i3];
        switch (i2) {
            case 1:
                objArr[0] = "annotations";
                break;
            case 2:
                objArr[0] = "name";
                break;
            case 3:
                objArr[0] = "source";
                break;
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/VariableDescriptorImpl";
                break;
            default:
                objArr[0] = "containingDeclaration";
                break;
        }
        switch (i2) {
            case 4:
                objArr[1] = "getType";
                break;
            case 5:
                objArr[1] = "getOriginal";
                break;
            case 6:
                objArr[1] = "getValueParameters";
                break;
            case 7:
                objArr[1] = "getOverriddenDescriptors";
                break;
            case 8:
                objArr[1] = "getTypeParameters";
                break;
            case 9:
                objArr[1] = "getContextReceiverParameters";
                break;
            case 10:
                objArr[1] = "getReturnType";
                break;
            default:
                objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/VariableDescriptorImpl";
                break;
        }
        switch (i2) {
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String format = String.format(str, objArr);
        switch (i2) {
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
                throw new IllegalStateException(format);
            default:
                throw new IllegalArgumentException(format);
        }
    }

    public void A0(kotlin.reflect.y.internal.j0.l.e0 e0Var) {
        this.f25251j = e0Var;
    }

    public boolean G() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.a
    public List<i1> f() {
        List<i1> emptyList = Collections.emptyList();
        if (emptyList == null) {
            v(6);
        }
        return emptyList;
    }

    public w0 f0() {
        return null;
    }

    public kotlin.reflect.y.internal.j0.l.e0 getReturnType() {
        kotlin.reflect.y.internal.j0.l.e0 type = getType();
        if (type == null) {
            v(10);
        }
        return type;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.h1
    public kotlin.reflect.y.internal.j0.l.e0 getType() {
        kotlin.reflect.y.internal.j0.l.e0 e0Var = this.f25251j;
        if (e0Var == null) {
            v(4);
        }
        return e0Var;
    }

    public List<e1> getTypeParameters() {
        List<e1> emptyList = Collections.emptyList();
        if (emptyList == null) {
            v(8);
        }
        return emptyList;
    }

    public w0 m0() {
        return null;
    }
}
