package kotlin.reflect.jvm.internal.impl.descriptors.p1;

/* compiled from: ReceiverParameterDescriptorImpl.java */
/* loaded from: classes2.dex */
public class f0 extends c {

    /* renamed from: h, reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.descriptors.m f25238h;

    /* renamed from: i, reason: collision with root package name */
    private kotlin.reflect.y.internal.j0.i.w.o.f f25239i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f0(kotlin.reflect.jvm.internal.impl.descriptors.m mVar, kotlin.reflect.y.internal.j0.i.w.o.f fVar, kotlin.reflect.jvm.internal.impl.descriptors.n1.g gVar) {
        super(gVar);
        if (mVar == null) {
            v(0);
        }
        if (fVar == null) {
            v(1);
        }
        if (gVar == null) {
            v(2);
        }
        this.f25238h = mVar;
        this.f25239i = fVar;
    }

    private static /* synthetic */ void v(int i2) {
        String str = (i2 == 3 || i2 == 4) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i2 == 3 || i2 == 4) ? 2 : 3];
        switch (i2) {
            case 1:
                objArr[0] = "value";
                break;
            case 2:
                objArr[0] = "annotations";
                break;
            case 3:
            case 4:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/ReceiverParameterDescriptorImpl";
                break;
            case 5:
                objArr[0] = "newOwner";
                break;
            case 6:
                objArr[0] = "outType";
                break;
            default:
                objArr[0] = "containingDeclaration";
                break;
        }
        if (i2 == 3) {
            objArr[1] = "getValue";
        } else if (i2 != 4) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/ReceiverParameterDescriptorImpl";
        } else {
            objArr[1] = "getContainingDeclaration";
        }
        if (i2 != 3 && i2 != 4) {
            if (i2 == 5) {
                objArr[2] = "copy";
            } else if (i2 != 6) {
                objArr[2] = "<init>";
            } else {
                objArr[2] = "setOutType";
            }
        }
        String format = String.format(str, objArr);
        if (i2 != 3 && i2 != 4) {
            throw new IllegalArgumentException(format);
        }
        throw new IllegalStateException(format);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.m
    public kotlin.reflect.jvm.internal.impl.descriptors.m b() {
        kotlin.reflect.jvm.internal.impl.descriptors.m mVar = this.f25238h;
        if (mVar == null) {
            v(4);
        }
        return mVar;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.w0
    public kotlin.reflect.y.internal.j0.i.w.o.f getValue() {
        kotlin.reflect.y.internal.j0.i.w.o.f fVar = this.f25239i;
        if (fVar == null) {
            v(3);
        }
        return fVar;
    }
}
