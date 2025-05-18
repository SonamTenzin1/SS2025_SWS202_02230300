package kotlin.reflect.y.internal.j0.j.b.f0;

import java.util.List;
import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.protobuf.f;
import kotlin.reflect.jvm.internal.impl.protobuf.h;
import kotlin.reflect.y.internal.j0.e.b;
import kotlin.reflect.y.internal.j0.e.c;
import kotlin.reflect.y.internal.j0.e.d;
import kotlin.reflect.y.internal.j0.e.g;
import kotlin.reflect.y.internal.j0.e.i;
import kotlin.reflect.y.internal.j0.e.l;
import kotlin.reflect.y.internal.j0.e.n;
import kotlin.reflect.y.internal.j0.e.q;
import kotlin.reflect.y.internal.j0.e.s;
import kotlin.reflect.y.internal.j0.e.u;
import kotlin.reflect.y.internal.j0.e.y.b;

/* compiled from: BuiltInSerializerProtocol.kt */
/* loaded from: classes3.dex */
public final class a extends kotlin.reflect.y.internal.j0.j.a {
    public static final a n = new a();

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private a() {
        super(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13);
        f d2 = f.d();
        b.a(d2);
        m.e(d2, "newInstance().apply(Buil…f::registerAllExtensions)");
        h.f<l, Integer> fVar = b.a;
        m.e(fVar, "packageFqName");
        h.f<d, List<kotlin.reflect.y.internal.j0.e.b>> fVar2 = b.f24168c;
        m.e(fVar2, "constructorAnnotation");
        h.f<c, List<kotlin.reflect.y.internal.j0.e.b>> fVar3 = b.f24167b;
        m.e(fVar3, "classAnnotation");
        h.f<i, List<kotlin.reflect.y.internal.j0.e.b>> fVar4 = b.f24169d;
        m.e(fVar4, "functionAnnotation");
        h.f<n, List<kotlin.reflect.y.internal.j0.e.b>> fVar5 = b.f24170e;
        m.e(fVar5, "propertyAnnotation");
        h.f<n, List<kotlin.reflect.y.internal.j0.e.b>> fVar6 = b.f24171f;
        m.e(fVar6, "propertyGetterAnnotation");
        h.f<n, List<kotlin.reflect.y.internal.j0.e.b>> fVar7 = b.f24172g;
        m.e(fVar7, "propertySetterAnnotation");
        h.f<g, List<kotlin.reflect.y.internal.j0.e.b>> fVar8 = b.f24174i;
        m.e(fVar8, "enumEntryAnnotation");
        h.f<n, b.C0361b.c> fVar9 = kotlin.reflect.y.internal.j0.e.y.b.f24173h;
        m.e(fVar9, "compileTimeValue");
        h.f<u, List<kotlin.reflect.y.internal.j0.e.b>> fVar10 = kotlin.reflect.y.internal.j0.e.y.b.f24175j;
        m.e(fVar10, "parameterAnnotation");
        h.f<q, List<kotlin.reflect.y.internal.j0.e.b>> fVar11 = kotlin.reflect.y.internal.j0.e.y.b.f24176k;
        m.e(fVar11, "typeAnnotation");
        h.f<s, List<kotlin.reflect.y.internal.j0.e.b>> fVar12 = kotlin.reflect.y.internal.j0.e.y.b.l;
        m.e(fVar12, "typeParameterAnnotation");
    }

    private final String o(kotlin.reflect.y.internal.j0.f.c cVar) {
        if (cVar.d()) {
            return "default-package";
        }
        String k2 = cVar.g().k();
        m.e(k2, "fqName.shortName().asString()");
        return k2;
    }

    public final String m(kotlin.reflect.y.internal.j0.f.c cVar) {
        m.f(cVar, "fqName");
        return o(cVar) + ".kotlin_builtins";
    }

    public final String n(kotlin.reflect.y.internal.j0.f.c cVar) {
        String z;
        m.f(cVar, "fqName");
        StringBuilder sb = new StringBuilder();
        String b2 = cVar.b();
        m.e(b2, "fqName.asString()");
        z = kotlin.text.u.z(b2, '.', '/', false, 4, null);
        sb.append(z);
        sb.append('/');
        sb.append(m(cVar));
        return sb.toString();
    }
}
