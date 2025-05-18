package kotlin.reflect.jvm.internal.impl.descriptors.r1.b;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.r1.b.z;

/* compiled from: ReflectJavaClassifierType.kt */
/* loaded from: classes2.dex */
public final class n extends z implements kotlin.reflect.y.internal.j0.d.a.n0.j {

    /* renamed from: b, reason: collision with root package name */
    private final Type f25358b;

    /* renamed from: c, reason: collision with root package name */
    private final kotlin.reflect.y.internal.j0.d.a.n0.i f25359c;

    public n(Type type) {
        kotlin.reflect.y.internal.j0.d.a.n0.i lVar;
        kotlin.jvm.internal.m.f(type, "reflectType");
        this.f25358b = type;
        Type R = R();
        if (R instanceof Class) {
            lVar = new l((Class) R);
        } else if (R instanceof TypeVariable) {
            lVar = new a0((TypeVariable) R);
        } else {
            if (!(R instanceof ParameterizedType)) {
                throw new IllegalStateException("Not a classifier type (" + R.getClass() + "): " + R);
            }
            Type rawType = ((ParameterizedType) R).getRawType();
            kotlin.jvm.internal.m.d(rawType, "null cannot be cast to non-null type java.lang.Class<*>");
            lVar = new l((Class) rawType);
        }
        this.f25359c = lVar;
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.n0.j
    public List<kotlin.reflect.y.internal.j0.d.a.n0.x> F() {
        int u;
        List<Type> c2 = d.c(R());
        z.a aVar = z.a;
        u = kotlin.collections.v.u(c2, 10);
        ArrayList arrayList = new ArrayList(u);
        Iterator<T> it = c2.iterator();
        while (it.hasNext()) {
            arrayList.add(aVar.a((Type) it.next()));
        }
        return arrayList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.r1.b.z
    public Type R() {
        return this.f25358b;
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.n0.j
    public kotlin.reflect.y.internal.j0.d.a.n0.i c() {
        return this.f25359c;
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.n0.d
    public Collection<kotlin.reflect.y.internal.j0.d.a.n0.a> getAnnotations() {
        List j2;
        j2 = kotlin.collections.u.j();
        return j2;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.r1.b.z, kotlin.reflect.y.internal.j0.d.a.n0.d
    public kotlin.reflect.y.internal.j0.d.a.n0.a l(kotlin.reflect.y.internal.j0.f.c cVar) {
        kotlin.jvm.internal.m.f(cVar, "fqName");
        return null;
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.n0.d
    public boolean m() {
        return false;
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.n0.j
    public String p() {
        return R().toString();
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.n0.j
    public boolean x() {
        Type R = R();
        if (!(R instanceof Class)) {
            return false;
        }
        TypeVariable[] typeParameters = ((Class) R).getTypeParameters();
        kotlin.jvm.internal.m.e(typeParameters, "getTypeParameters()");
        return (typeParameters.length == 0) ^ true;
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.n0.j
    public String y() {
        throw new UnsupportedOperationException("Type not found: " + R());
    }
}
