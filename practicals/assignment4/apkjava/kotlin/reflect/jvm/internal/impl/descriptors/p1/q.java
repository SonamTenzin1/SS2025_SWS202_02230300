package kotlin.reflect.jvm.internal.impl.descriptors.p1;

/* compiled from: LazyClassReceiverParameterDescriptor.java */
/* loaded from: classes2.dex */
public class q extends c {

    /* renamed from: h, reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.descriptors.e f25280h;

    /* renamed from: i, reason: collision with root package name */
    private final kotlin.reflect.y.internal.j0.i.w.o.e f25281i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(kotlin.reflect.jvm.internal.impl.descriptors.e eVar) {
        super(kotlin.reflect.jvm.internal.impl.descriptors.n1.g.f25179c.b());
        if (eVar == null) {
            v(0);
        }
        this.f25280h = eVar;
        this.f25281i = new kotlin.reflect.y.internal.j0.i.w.o.e(eVar, null);
    }

    private static /* synthetic */ void v(int i2) {
        String str = (i2 == 1 || i2 == 2) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i2 == 1 || i2 == 2) ? 2 : 3];
        if (i2 == 1 || i2 == 2) {
            objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/LazyClassReceiverParameterDescriptor";
        } else if (i2 != 3) {
            objArr[0] = "descriptor";
        } else {
            objArr[0] = "newOwner";
        }
        if (i2 == 1) {
            objArr[1] = "getValue";
        } else if (i2 != 2) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/LazyClassReceiverParameterDescriptor";
        } else {
            objArr[1] = "getContainingDeclaration";
        }
        if (i2 != 1 && i2 != 2) {
            if (i2 != 3) {
                objArr[2] = "<init>";
            } else {
                objArr[2] = "copy";
            }
        }
        String format = String.format(str, objArr);
        if (i2 != 1 && i2 != 2) {
            throw new IllegalArgumentException(format);
        }
        throw new IllegalStateException(format);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.m
    public kotlin.reflect.jvm.internal.impl.descriptors.m b() {
        kotlin.reflect.jvm.internal.impl.descriptors.e eVar = this.f25280h;
        if (eVar == null) {
            v(2);
        }
        return eVar;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.w0
    public kotlin.reflect.y.internal.j0.i.w.o.f getValue() {
        kotlin.reflect.y.internal.j0.i.w.o.e eVar = this.f25281i;
        if (eVar == null) {
            v(1);
        }
        return eVar;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.p1.j
    public String toString() {
        return "class " + this.f25280h.getName() + "::this";
    }
}
