package kotlin.reflect.jvm.internal.impl.descriptors.n1;

import java.util.Map;
import kotlin.reflect.jvm.internal.impl.descriptors.n1.c;
import kotlin.reflect.jvm.internal.impl.descriptors.z0;
import kotlin.reflect.y.internal.j0.l.e0;

/* compiled from: AnnotationDescriptorImpl.java */
/* loaded from: classes2.dex */
public class d implements c {
    private final e0 a;

    /* renamed from: b, reason: collision with root package name */
    private final Map<kotlin.reflect.y.internal.j0.f.f, kotlin.reflect.y.internal.j0.i.r.g<?>> f25166b;

    /* renamed from: c, reason: collision with root package name */
    private final z0 f25167c;

    public d(e0 e0Var, Map<kotlin.reflect.y.internal.j0.f.f, kotlin.reflect.y.internal.j0.i.r.g<?>> map, z0 z0Var) {
        if (e0Var == null) {
            b(0);
        }
        if (map == null) {
            b(1);
        }
        if (z0Var == null) {
            b(2);
        }
        this.a = e0Var;
        this.f25166b = map;
        this.f25167c = z0Var;
    }

    private static /* synthetic */ void b(int i2) {
        String str = (i2 == 3 || i2 == 4 || i2 == 5) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i2 == 3 || i2 == 4 || i2 == 5) ? 2 : 3];
        if (i2 == 1) {
            objArr[0] = "valueArguments";
        } else if (i2 == 2) {
            objArr[0] = "source";
        } else if (i2 == 3 || i2 == 4 || i2 == 5) {
            objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/annotations/AnnotationDescriptorImpl";
        } else {
            objArr[0] = "annotationType";
        }
        if (i2 == 3) {
            objArr[1] = "getType";
        } else if (i2 == 4) {
            objArr[1] = "getAllValueArguments";
        } else if (i2 != 5) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/annotations/AnnotationDescriptorImpl";
        } else {
            objArr[1] = "getSource";
        }
        if (i2 != 3 && i2 != 4 && i2 != 5) {
            objArr[2] = "<init>";
        }
        String format = String.format(str, objArr);
        if (i2 != 3 && i2 != 4 && i2 != 5) {
            throw new IllegalArgumentException(format);
        }
        throw new IllegalStateException(format);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.n1.c
    public Map<kotlin.reflect.y.internal.j0.f.f, kotlin.reflect.y.internal.j0.i.r.g<?>> a() {
        Map<kotlin.reflect.y.internal.j0.f.f, kotlin.reflect.y.internal.j0.i.r.g<?>> map = this.f25166b;
        if (map == null) {
            b(4);
        }
        return map;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.n1.c
    public kotlin.reflect.y.internal.j0.f.c d() {
        return c.a.a(this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.n1.c
    public e0 getType() {
        e0 e0Var = this.a;
        if (e0Var == null) {
            b(3);
        }
        return e0Var;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.n1.c
    public z0 t() {
        z0 z0Var = this.f25167c;
        if (z0Var == null) {
            b(5);
        }
        return z0Var;
    }

    public String toString() {
        return kotlin.reflect.y.internal.j0.h.c.f24252g.r(this, null);
    }
}
