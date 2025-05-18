package kotlin.reflect.jvm.internal.impl.descriptors.n1;

import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.z0;
import kotlin.reflect.y.internal.j0.l.e0;
import kotlin.reflect.y.internal.j0.l.m0;

/* compiled from: BuiltInAnnotationDescriptor.kt */
/* loaded from: classes2.dex */
public final class j implements c {
    private final kotlin.reflect.y.internal.j0.b.h a;

    /* renamed from: b, reason: collision with root package name */
    private final kotlin.reflect.y.internal.j0.f.c f25182b;

    /* renamed from: c, reason: collision with root package name */
    private final Map<kotlin.reflect.y.internal.j0.f.f, kotlin.reflect.y.internal.j0.i.r.g<?>> f25183c;

    /* renamed from: d, reason: collision with root package name */
    private final Lazy f25184d;

    /* compiled from: BuiltInAnnotationDescriptor.kt */
    /* loaded from: classes2.dex */
    static final class a extends Lambda implements Function0<m0> {
        a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final m0 invoke() {
            return j.this.a.o(j.this.d()).s();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public j(kotlin.reflect.y.internal.j0.b.h hVar, kotlin.reflect.y.internal.j0.f.c cVar, Map<kotlin.reflect.y.internal.j0.f.f, ? extends kotlin.reflect.y.internal.j0.i.r.g<?>> map) {
        Lazy a2;
        kotlin.jvm.internal.m.f(hVar, "builtIns");
        kotlin.jvm.internal.m.f(cVar, "fqName");
        kotlin.jvm.internal.m.f(map, "allValueArguments");
        this.a = hVar;
        this.f25182b = cVar;
        this.f25183c = map;
        a2 = kotlin.i.a(LazyThreadSafetyMode.PUBLICATION, new a());
        this.f25184d = a2;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.n1.c
    public Map<kotlin.reflect.y.internal.j0.f.f, kotlin.reflect.y.internal.j0.i.r.g<?>> a() {
        return this.f25183c;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.n1.c
    public kotlin.reflect.y.internal.j0.f.c d() {
        return this.f25182b;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.n1.c
    public e0 getType() {
        Object value = this.f25184d.getValue();
        kotlin.jvm.internal.m.e(value, "<get-type>(...)");
        return (e0) value;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.n1.c
    public z0 t() {
        z0 z0Var = z0.a;
        kotlin.jvm.internal.m.e(z0Var, "NO_SOURCE");
        return z0Var;
    }
}
