package kotlin.reflect.jvm.internal.impl.descriptors.p1;

import kotlin.reflect.jvm.internal.impl.descriptors.z0;

/* compiled from: ClassDescriptorBase.java */
/* loaded from: classes2.dex */
public abstract class g extends a {

    /* renamed from: k, reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.descriptors.m f25240k;
    private final z0 l;
    private final boolean m;

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(kotlin.reflect.y.internal.j0.k.n nVar, kotlin.reflect.jvm.internal.impl.descriptors.m mVar, kotlin.reflect.y.internal.j0.f.f fVar, z0 z0Var, boolean z) {
        super(nVar, fVar);
        if (nVar == null) {
            K(0);
        }
        if (mVar == null) {
            K(1);
        }
        if (fVar == null) {
            K(2);
        }
        if (z0Var == null) {
            K(3);
        }
        this.f25240k = mVar;
        this.l = z0Var;
        this.m = z;
    }

    private static /* synthetic */ void K(int i2) {
        String str = (i2 == 4 || i2 == 5) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i2 == 4 || i2 == 5) ? 2 : 3];
        if (i2 == 1) {
            objArr[0] = "containingDeclaration";
        } else if (i2 == 2) {
            objArr[0] = "name";
        } else if (i2 == 3) {
            objArr[0] = "source";
        } else if (i2 == 4 || i2 == 5) {
            objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/ClassDescriptorBase";
        } else {
            objArr[0] = "storageManager";
        }
        if (i2 == 4) {
            objArr[1] = "getContainingDeclaration";
        } else if (i2 != 5) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/ClassDescriptorBase";
        } else {
            objArr[1] = "getSource";
        }
        if (i2 != 4 && i2 != 5) {
            objArr[2] = "<init>";
        }
        String format = String.format(str, objArr);
        if (i2 != 4 && i2 != 5) {
            throw new IllegalArgumentException(format);
        }
        throw new IllegalStateException(format);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.e, kotlin.reflect.jvm.internal.impl.descriptors.n, kotlin.reflect.jvm.internal.impl.descriptors.m
    public kotlin.reflect.jvm.internal.impl.descriptors.m b() {
        kotlin.reflect.jvm.internal.impl.descriptors.m mVar = this.f25240k;
        if (mVar == null) {
            K(4);
        }
        return mVar;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.p
    public z0 t() {
        z0 z0Var = this.l;
        if (z0Var == null) {
            K(5);
        }
        return z0Var;
    }

    public boolean z() {
        return this.m;
    }
}
