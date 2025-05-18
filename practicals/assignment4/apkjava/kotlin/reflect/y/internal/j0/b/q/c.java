package kotlin.reflect.y.internal.j0.b.q;

import java.lang.annotation.Annotation;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import kotlin.collections.u;
import kotlin.jvm.internal.m;
import kotlin.reflect.y.internal.j0.b.k;
import kotlin.reflect.y.internal.j0.f.b;
import kotlin.reflect.y.internal.j0.f.d;
import kotlin.reflect.y.internal.j0.f.e;
import kotlin.reflect.y.internal.j0.f.f;
import kotlin.reflect.y.internal.j0.f.h;
import kotlin.reflect.y.internal.j0.f.i;
import kotlin.text.v;
import okhttp3.HttpUrl;

/* compiled from: JavaToKotlinClassMap.kt */
/* loaded from: classes2.dex */
public final class c {
    public static final c a;

    /* renamed from: b, reason: collision with root package name */
    private static final String f23243b;

    /* renamed from: c, reason: collision with root package name */
    private static final String f23244c;

    /* renamed from: d, reason: collision with root package name */
    private static final String f23245d;

    /* renamed from: e, reason: collision with root package name */
    private static final String f23246e;

    /* renamed from: f, reason: collision with root package name */
    private static final b f23247f;

    /* renamed from: g, reason: collision with root package name */
    private static final kotlin.reflect.y.internal.j0.f.c f23248g;

    /* renamed from: h, reason: collision with root package name */
    private static final b f23249h;

    /* renamed from: i, reason: collision with root package name */
    private static final b f23250i;

    /* renamed from: j, reason: collision with root package name */
    private static final b f23251j;

    /* renamed from: k, reason: collision with root package name */
    private static final HashMap<d, b> f23252k;
    private static final HashMap<d, b> l;
    private static final HashMap<d, kotlin.reflect.y.internal.j0.f.c> m;
    private static final HashMap<d, kotlin.reflect.y.internal.j0.f.c> n;
    private static final HashMap<b, b> o;
    private static final HashMap<b, b> p;
    private static final List<a> q;

    /* compiled from: JavaToKotlinClassMap.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private final b a;

        /* renamed from: b, reason: collision with root package name */
        private final b f23253b;

        /* renamed from: c, reason: collision with root package name */
        private final b f23254c;

        public a(b bVar, b bVar2, b bVar3) {
            m.f(bVar, "javaClass");
            m.f(bVar2, "kotlinReadOnly");
            m.f(bVar3, "kotlinMutable");
            this.a = bVar;
            this.f23253b = bVar2;
            this.f23254c = bVar3;
        }

        public final b a() {
            return this.a;
        }

        public final b b() {
            return this.f23253b;
        }

        public final b c() {
            return this.f23254c;
        }

        public final b d() {
            return this.a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return m.a(this.a, aVar.a) && m.a(this.f23253b, aVar.f23253b) && m.a(this.f23254c, aVar.f23254c);
        }

        public int hashCode() {
            return (((this.a.hashCode() * 31) + this.f23253b.hashCode()) * 31) + this.f23254c.hashCode();
        }

        public String toString() {
            return "PlatformMutabilityMapping(javaClass=" + this.a + ", kotlinReadOnly=" + this.f23253b + ", kotlinMutable=" + this.f23254c + ')';
        }
    }

    static {
        List<a> m2;
        c cVar = new c();
        a = cVar;
        StringBuilder sb = new StringBuilder();
        kotlin.reflect.y.internal.j0.b.p.c cVar2 = kotlin.reflect.y.internal.j0.b.p.c.f23233g;
        sb.append(cVar2.q().toString());
        sb.append('.');
        sb.append(cVar2.k());
        f23243b = sb.toString();
        StringBuilder sb2 = new StringBuilder();
        kotlin.reflect.y.internal.j0.b.p.c cVar3 = kotlin.reflect.y.internal.j0.b.p.c.f23235i;
        sb2.append(cVar3.q().toString());
        sb2.append('.');
        sb2.append(cVar3.k());
        f23244c = sb2.toString();
        StringBuilder sb3 = new StringBuilder();
        kotlin.reflect.y.internal.j0.b.p.c cVar4 = kotlin.reflect.y.internal.j0.b.p.c.f23234h;
        sb3.append(cVar4.q().toString());
        sb3.append('.');
        sb3.append(cVar4.k());
        f23245d = sb3.toString();
        StringBuilder sb4 = new StringBuilder();
        kotlin.reflect.y.internal.j0.b.p.c cVar5 = kotlin.reflect.y.internal.j0.b.p.c.f23236j;
        sb4.append(cVar5.q().toString());
        sb4.append('.');
        sb4.append(cVar5.k());
        f23246e = sb4.toString();
        b m3 = b.m(new kotlin.reflect.y.internal.j0.f.c("kotlin.jvm.functions.FunctionN"));
        m.e(m3, "topLevel(FqName(\"kotlin.jvm.functions.FunctionN\"))");
        f23247f = m3;
        kotlin.reflect.y.internal.j0.f.c b2 = m3.b();
        m.e(b2, "FUNCTION_N_CLASS_ID.asSingleFqName()");
        f23248g = b2;
        i iVar = i.a;
        f23249h = iVar.i();
        f23250i = iVar.h();
        f23251j = cVar.g(Class.class);
        f23252k = new HashMap<>();
        l = new HashMap<>();
        m = new HashMap<>();
        n = new HashMap<>();
        o = new HashMap<>();
        p = new HashMap<>();
        b m4 = b.m(k.a.T);
        m.e(m4, "topLevel(FqNames.iterable)");
        kotlin.reflect.y.internal.j0.f.c cVar6 = k.a.b0;
        kotlin.reflect.y.internal.j0.f.c h2 = m4.h();
        kotlin.reflect.y.internal.j0.f.c h3 = m4.h();
        m.e(h3, "kotlinReadOnly.packageFqName");
        kotlin.reflect.y.internal.j0.f.c g2 = e.g(cVar6, h3);
        b bVar = new b(h2, g2, false);
        b m5 = b.m(k.a.S);
        m.e(m5, "topLevel(FqNames.iterator)");
        kotlin.reflect.y.internal.j0.f.c cVar7 = k.a.a0;
        kotlin.reflect.y.internal.j0.f.c h4 = m5.h();
        kotlin.reflect.y.internal.j0.f.c h5 = m5.h();
        m.e(h5, "kotlinReadOnly.packageFqName");
        b bVar2 = new b(h4, e.g(cVar7, h5), false);
        b m6 = b.m(k.a.U);
        m.e(m6, "topLevel(FqNames.collection)");
        kotlin.reflect.y.internal.j0.f.c cVar8 = k.a.c0;
        kotlin.reflect.y.internal.j0.f.c h6 = m6.h();
        kotlin.reflect.y.internal.j0.f.c h7 = m6.h();
        m.e(h7, "kotlinReadOnly.packageFqName");
        b bVar3 = new b(h6, e.g(cVar8, h7), false);
        b m7 = b.m(k.a.V);
        m.e(m7, "topLevel(FqNames.list)");
        kotlin.reflect.y.internal.j0.f.c cVar9 = k.a.d0;
        kotlin.reflect.y.internal.j0.f.c h8 = m7.h();
        kotlin.reflect.y.internal.j0.f.c h9 = m7.h();
        m.e(h9, "kotlinReadOnly.packageFqName");
        b bVar4 = new b(h8, e.g(cVar9, h9), false);
        b m8 = b.m(k.a.X);
        m.e(m8, "topLevel(FqNames.set)");
        kotlin.reflect.y.internal.j0.f.c cVar10 = k.a.f0;
        kotlin.reflect.y.internal.j0.f.c h10 = m8.h();
        kotlin.reflect.y.internal.j0.f.c h11 = m8.h();
        m.e(h11, "kotlinReadOnly.packageFqName");
        b bVar5 = new b(h10, e.g(cVar10, h11), false);
        b m9 = b.m(k.a.W);
        m.e(m9, "topLevel(FqNames.listIterator)");
        kotlin.reflect.y.internal.j0.f.c cVar11 = k.a.e0;
        kotlin.reflect.y.internal.j0.f.c h12 = m9.h();
        kotlin.reflect.y.internal.j0.f.c h13 = m9.h();
        m.e(h13, "kotlinReadOnly.packageFqName");
        b bVar6 = new b(h12, e.g(cVar11, h13), false);
        kotlin.reflect.y.internal.j0.f.c cVar12 = k.a.Y;
        b m10 = b.m(cVar12);
        m.e(m10, "topLevel(FqNames.map)");
        kotlin.reflect.y.internal.j0.f.c cVar13 = k.a.g0;
        kotlin.reflect.y.internal.j0.f.c h14 = m10.h();
        kotlin.reflect.y.internal.j0.f.c h15 = m10.h();
        m.e(h15, "kotlinReadOnly.packageFqName");
        b bVar7 = new b(h14, e.g(cVar13, h15), false);
        b d2 = b.m(cVar12).d(k.a.Z.g());
        m.e(d2, "topLevel(FqNames.map).cr…mes.mapEntry.shortName())");
        kotlin.reflect.y.internal.j0.f.c cVar14 = k.a.h0;
        kotlin.reflect.y.internal.j0.f.c h16 = d2.h();
        kotlin.reflect.y.internal.j0.f.c h17 = d2.h();
        m.e(h17, "kotlinReadOnly.packageFqName");
        m2 = u.m(new a(cVar.g(Iterable.class), m4, bVar), new a(cVar.g(Iterator.class), m5, bVar2), new a(cVar.g(Collection.class), m6, bVar3), new a(cVar.g(List.class), m7, bVar4), new a(cVar.g(Set.class), m8, bVar5), new a(cVar.g(ListIterator.class), m9, bVar6), new a(cVar.g(Map.class), m10, bVar7), new a(cVar.g(Map.Entry.class), d2, new b(h16, e.g(cVar14, h17), false)));
        q = m2;
        cVar.f(Object.class, k.a.f23201b);
        cVar.f(String.class, k.a.f23207h);
        cVar.f(CharSequence.class, k.a.f23206g);
        cVar.e(Throwable.class, k.a.u);
        cVar.f(Cloneable.class, k.a.f23203d);
        cVar.f(Number.class, k.a.r);
        cVar.e(Comparable.class, k.a.v);
        cVar.f(Enum.class, k.a.s);
        cVar.e(Annotation.class, k.a.G);
        Iterator<a> it = m2.iterator();
        while (it.hasNext()) {
            a.d(it.next());
        }
        for (kotlin.reflect.y.internal.j0.i.u.e eVar : kotlin.reflect.y.internal.j0.i.u.e.values()) {
            c cVar15 = a;
            b m11 = b.m(eVar.y());
            m.e(m11, "topLevel(jvmType.wrapperFqName)");
            kotlin.reflect.y.internal.j0.b.i x = eVar.x();
            m.e(x, "jvmType.primitiveType");
            b m12 = b.m(k.c(x));
            m.e(m12, "topLevel(StandardNames.g…e(jvmType.primitiveType))");
            cVar15.a(m11, m12);
        }
        for (b bVar8 : kotlin.reflect.y.internal.j0.b.c.a.a()) {
            c cVar16 = a;
            b m13 = b.m(new kotlin.reflect.y.internal.j0.f.c("kotlin.jvm.internal." + bVar8.j().k() + "CompanionObject"));
            m.e(m13, "topLevel(FqName(\"kotlin.…g() + \"CompanionObject\"))");
            b d3 = bVar8.d(h.f24218d);
            m.e(d3, "classId.createNestedClas…AME_FOR_COMPANION_OBJECT)");
            cVar16.a(m13, d3);
        }
        for (int i2 = 0; i2 < 23; i2++) {
            c cVar17 = a;
            b m14 = b.m(new kotlin.reflect.y.internal.j0.f.c("kotlin.jvm.functions.Function" + i2));
            m.e(m14, "topLevel(FqName(\"kotlin.…m.functions.Function$i\"))");
            cVar17.a(m14, k.a(i2));
            cVar17.c(new kotlin.reflect.y.internal.j0.f.c(f23244c + i2), f23249h);
        }
        for (int i3 = 0; i3 < 22; i3++) {
            kotlin.reflect.y.internal.j0.b.p.c cVar18 = kotlin.reflect.y.internal.j0.b.p.c.f23236j;
            a.c(new kotlin.reflect.y.internal.j0.f.c((cVar18.q().toString() + '.' + cVar18.k()) + i3), f23249h);
        }
        c cVar19 = a;
        kotlin.reflect.y.internal.j0.f.c l2 = k.a.f23202c.l();
        m.e(l2, "nothing.toSafe()");
        cVar19.c(l2, cVar19.g(Void.class));
    }

    private c() {
    }

    private final void a(b bVar, b bVar2) {
        b(bVar, bVar2);
        kotlin.reflect.y.internal.j0.f.c b2 = bVar2.b();
        m.e(b2, "kotlinClassId.asSingleFqName()");
        c(b2, bVar);
    }

    private final void b(b bVar, b bVar2) {
        HashMap<d, b> hashMap = f23252k;
        d j2 = bVar.b().j();
        m.e(j2, "javaClassId.asSingleFqName().toUnsafe()");
        hashMap.put(j2, bVar2);
    }

    private final void c(kotlin.reflect.y.internal.j0.f.c cVar, b bVar) {
        HashMap<d, b> hashMap = l;
        d j2 = cVar.j();
        m.e(j2, "kotlinFqNameUnsafe.toUnsafe()");
        hashMap.put(j2, bVar);
    }

    private final void d(a aVar) {
        b a2 = aVar.a();
        b b2 = aVar.b();
        b c2 = aVar.c();
        a(a2, b2);
        kotlin.reflect.y.internal.j0.f.c b3 = c2.b();
        m.e(b3, "mutableClassId.asSingleFqName()");
        c(b3, a2);
        o.put(c2, b2);
        p.put(b2, c2);
        kotlin.reflect.y.internal.j0.f.c b4 = b2.b();
        m.e(b4, "readOnlyClassId.asSingleFqName()");
        kotlin.reflect.y.internal.j0.f.c b5 = c2.b();
        m.e(b5, "mutableClassId.asSingleFqName()");
        HashMap<d, kotlin.reflect.y.internal.j0.f.c> hashMap = m;
        d j2 = c2.b().j();
        m.e(j2, "mutableClassId.asSingleFqName().toUnsafe()");
        hashMap.put(j2, b4);
        HashMap<d, kotlin.reflect.y.internal.j0.f.c> hashMap2 = n;
        d j3 = b4.j();
        m.e(j3, "readOnlyFqName.toUnsafe()");
        hashMap2.put(j3, b5);
    }

    private final void e(Class<?> cls, kotlin.reflect.y.internal.j0.f.c cVar) {
        b g2 = g(cls);
        b m2 = b.m(cVar);
        m.e(m2, "topLevel(kotlinFqName)");
        a(g2, m2);
    }

    private final void f(Class<?> cls, d dVar) {
        kotlin.reflect.y.internal.j0.f.c l2 = dVar.l();
        m.e(l2, "kotlinFqName.toSafe()");
        e(cls, l2);
    }

    private final b g(Class<?> cls) {
        if (!cls.isPrimitive()) {
            cls.isArray();
        }
        Class<?> declaringClass = cls.getDeclaringClass();
        if (declaringClass == null) {
            b m2 = b.m(new kotlin.reflect.y.internal.j0.f.c(cls.getCanonicalName()));
            m.e(m2, "topLevel(FqName(clazz.canonicalName))");
            return m2;
        }
        b d2 = g(declaringClass).d(f.x(cls.getSimpleName()));
        m.e(d2, "classId(outer).createNes…tifier(clazz.simpleName))");
        return d2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0026, code lost:
    
        r5 = kotlin.text.t.j(r5);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final boolean j(d dVar, String str) {
        String E0;
        boolean A0;
        Integer j2;
        String b2 = dVar.b();
        m.e(b2, "kotlinFqName.asString()");
        E0 = v.E0(b2, str, HttpUrl.FRAGMENT_ENCODE_SET);
        if (E0.length() > 0) {
            A0 = v.A0(E0, '0', false, 2, null);
            return (A0 || j2 == null || j2.intValue() < 23) ? false : true;
        }
        return false;
    }

    public final kotlin.reflect.y.internal.j0.f.c h() {
        return f23248g;
    }

    public final List<a> i() {
        return q;
    }

    public final boolean k(d dVar) {
        return m.containsKey(dVar);
    }

    public final boolean l(d dVar) {
        return n.containsKey(dVar);
    }

    public final b m(kotlin.reflect.y.internal.j0.f.c cVar) {
        m.f(cVar, "fqName");
        return f23252k.get(cVar.j());
    }

    public final b n(d dVar) {
        m.f(dVar, "kotlinFqName");
        if (!j(dVar, f23243b) && !j(dVar, f23245d)) {
            if (!j(dVar, f23244c) && !j(dVar, f23246e)) {
                return l.get(dVar);
            }
            return f23249h;
        }
        return f23247f;
    }

    public final kotlin.reflect.y.internal.j0.f.c o(d dVar) {
        return m.get(dVar);
    }

    public final kotlin.reflect.y.internal.j0.f.c p(d dVar) {
        return n.get(dVar);
    }
}
