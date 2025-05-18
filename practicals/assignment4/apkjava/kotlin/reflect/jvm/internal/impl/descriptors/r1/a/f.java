package kotlin.reflect.jvm.internal.impl.descriptors.r1.a;

import kotlin.reflect.y.internal.j0.d.b.q;
import kotlin.text.u;

/* compiled from: ReflectKotlinClass.kt */
/* loaded from: classes2.dex */
public final class f implements q {
    public static final a a = new a(null);

    /* renamed from: b, reason: collision with root package name */
    private final Class<?> f25316b;

    /* renamed from: c, reason: collision with root package name */
    private final kotlin.reflect.y.internal.j0.d.b.c0.a f25317c;

    /* compiled from: ReflectKotlinClass.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
            this();
        }

        public final f a(Class<?> cls) {
            kotlin.jvm.internal.m.f(cls, "klass");
            kotlin.reflect.y.internal.j0.d.b.c0.b bVar = new kotlin.reflect.y.internal.j0.d.b.c0.b();
            c.a.b(cls, bVar);
            kotlin.reflect.y.internal.j0.d.b.c0.a m = bVar.m();
            kotlin.jvm.internal.g gVar = null;
            if (m == null) {
                return null;
            }
            return new f(cls, m, gVar);
        }
    }

    private f(Class<?> cls, kotlin.reflect.y.internal.j0.d.b.c0.a aVar) {
        this.f25316b = cls;
        this.f25317c = aVar;
    }

    public /* synthetic */ f(Class cls, kotlin.reflect.y.internal.j0.d.b.c0.a aVar, kotlin.jvm.internal.g gVar) {
        this(cls, aVar);
    }

    @Override // kotlin.reflect.y.internal.j0.d.b.q
    public kotlin.reflect.y.internal.j0.d.b.c0.a a() {
        return this.f25317c;
    }

    @Override // kotlin.reflect.y.internal.j0.d.b.q
    public void b(q.c cVar, byte[] bArr) {
        kotlin.jvm.internal.m.f(cVar, "visitor");
        c.a.b(this.f25316b, cVar);
    }

    @Override // kotlin.reflect.y.internal.j0.d.b.q
    public void c(q.d dVar, byte[] bArr) {
        kotlin.jvm.internal.m.f(dVar, "visitor");
        c.a.i(this.f25316b, dVar);
    }

    public final Class<?> d() {
        return this.f25316b;
    }

    @Override // kotlin.reflect.y.internal.j0.d.b.q
    public kotlin.reflect.y.internal.j0.f.b e() {
        return kotlin.reflect.jvm.internal.impl.descriptors.r1.b.d.a(this.f25316b);
    }

    public boolean equals(Object obj) {
        return (obj instanceof f) && kotlin.jvm.internal.m.a(this.f25316b, ((f) obj).f25316b);
    }

    @Override // kotlin.reflect.y.internal.j0.d.b.q
    public String getLocation() {
        String z;
        StringBuilder sb = new StringBuilder();
        String name = this.f25316b.getName();
        kotlin.jvm.internal.m.e(name, "klass.name");
        z = u.z(name, '.', '/', false, 4, null);
        sb.append(z);
        sb.append(".class");
        return sb.toString();
    }

    public int hashCode() {
        return this.f25316b.hashCode();
    }

    public String toString() {
        return f.class.getName() + ": " + this.f25316b;
    }
}
