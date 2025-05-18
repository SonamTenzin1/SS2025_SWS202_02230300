package kotlin.reflect.y.internal.j0.d.a.l0.l;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.q0;
import kotlin.collections.v;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.y;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.descriptors.p1.z;
import kotlin.reflect.jvm.internal.impl.descriptors.z0;
import kotlin.reflect.y.internal.j0.d.a.l0.e;
import kotlin.reflect.y.internal.j0.d.a.l0.g;
import kotlin.reflect.y.internal.j0.d.a.n0.u;
import kotlin.reflect.y.internal.j0.d.b.c0.a;
import kotlin.reflect.y.internal.j0.d.b.p;
import kotlin.reflect.y.internal.j0.d.b.q;
import kotlin.reflect.y.internal.j0.d.b.r;
import kotlin.reflect.y.internal.j0.d.b.w;
import kotlin.reflect.y.internal.j0.i.u.d;
import kotlin.reflect.y.internal.j0.k.i;
import kotlin.reflect.y.internal.j0.k.n;
import kotlin.s;

/* compiled from: LazyJavaPackageFragment.kt */
/* loaded from: classes2.dex */
public final class h extends z {
    static final /* synthetic */ KProperty<Object>[] l = {g0.h(new y(g0.b(h.class), "binaryClasses", "getBinaryClasses$descriptors_jvm()Ljava/util/Map;")), g0.h(new y(g0.b(h.class), "partToFacade", "getPartToFacade()Ljava/util/HashMap;"))};
    private final u m;
    private final g n;
    private final i o;
    private final d p;
    private final i<List<kotlin.reflect.y.internal.j0.f.c>> q;
    private final kotlin.reflect.jvm.internal.impl.descriptors.n1.g r;
    private final i s;

    /* compiled from: LazyJavaPackageFragment.kt */
    /* loaded from: classes2.dex */
    static final class a extends Lambda implements Function0<Map<String, ? extends q>> {
        a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Map<String, q> invoke() {
            Map<String, q> q;
            w o = h.this.n.a().o();
            String b2 = h.this.d().b();
            m.e(b2, "fqName.asString()");
            List<String> a = o.a(b2);
            h hVar = h.this;
            ArrayList arrayList = new ArrayList();
            for (String str : a) {
                kotlin.reflect.y.internal.j0.f.b m = kotlin.reflect.y.internal.j0.f.b.m(d.d(str).e());
                m.e(m, "topLevel(JvmClassName.by…velClassMaybeWithDollars)");
                q b3 = p.b(hVar.n.a().j(), m);
                Pair a2 = b3 != null ? s.a(str, b3) : null;
                if (a2 != null) {
                    arrayList.add(a2);
                }
            }
            q = q0.q(arrayList);
            return q;
        }
    }

    /* compiled from: LazyJavaPackageFragment.kt */
    /* loaded from: classes2.dex */
    static final class b extends Lambda implements Function0<HashMap<d, d>> {

        /* compiled from: LazyJavaPackageFragment.kt */
        /* loaded from: classes2.dex */
        public /* synthetic */ class a {
            public static final /* synthetic */ int[] a;

            static {
                int[] iArr = new int[a.EnumC0345a.values().length];
                iArr[a.EnumC0345a.MULTIFILE_CLASS_PART.ordinal()] = 1;
                iArr[a.EnumC0345a.FILE_FACADE.ordinal()] = 2;
                a = iArr;
            }
        }

        b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final HashMap<d, d> invoke() {
            HashMap<d, d> hashMap = new HashMap<>();
            for (Map.Entry<String, q> entry : h.this.N0().entrySet()) {
                String key = entry.getKey();
                q value = entry.getValue();
                d d2 = d.d(key);
                m.e(d2, "byInternalName(partInternalName)");
                kotlin.reflect.y.internal.j0.d.b.c0.a a2 = value.a();
                int i2 = a.a[a2.c().ordinal()];
                if (i2 == 1) {
                    String e2 = a2.e();
                    if (e2 != null) {
                        d d3 = d.d(e2);
                        m.e(d3, "byInternalName(header.mu…: continue@kotlinClasses)");
                        hashMap.put(d2, d3);
                    }
                } else if (i2 == 2) {
                    hashMap.put(d2, d2);
                }
            }
            return hashMap;
        }
    }

    /* compiled from: LazyJavaPackageFragment.kt */
    /* loaded from: classes2.dex */
    static final class c extends Lambda implements Function0<List<? extends kotlin.reflect.y.internal.j0.f.c>> {
        c() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final List<? extends kotlin.reflect.y.internal.j0.f.c> invoke() {
            int u;
            Collection<u> A = h.this.m.A();
            u = v.u(A, 10);
            ArrayList arrayList = new ArrayList(u);
            Iterator<T> it = A.iterator();
            while (it.hasNext()) {
                arrayList.add(((u) it.next()).d());
            }
            return arrayList;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(g gVar, u uVar) {
        super(gVar.d(), uVar.d());
        List j2;
        m.f(gVar, "outerContext");
        m.f(uVar, "jPackage");
        this.m = uVar;
        g d2 = kotlin.reflect.y.internal.j0.d.a.l0.a.d(gVar, this, null, 0, 6, null);
        this.n = d2;
        this.o = d2.e().d(new a());
        this.p = new d(d2, uVar, this);
        n e2 = d2.e();
        c cVar = new c();
        j2 = kotlin.collections.u.j();
        this.q = e2.c(cVar, j2);
        this.r = d2.a().i().b() ? kotlin.reflect.jvm.internal.impl.descriptors.n1.g.f25179c.b() : e.a(d2, uVar);
        this.s = d2.e().d(new b());
    }

    public final kotlin.reflect.jvm.internal.impl.descriptors.e M0(kotlin.reflect.y.internal.j0.d.a.n0.g gVar) {
        m.f(gVar, "jClass");
        return this.p.j().O(gVar);
    }

    public final Map<String, q> N0() {
        return (Map) kotlin.reflect.y.internal.j0.k.m.a(this.o, this, l[0]);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.k0
    /* renamed from: O0, reason: merged with bridge method [inline-methods] */
    public d q() {
        return this.p;
    }

    public final List<kotlin.reflect.y.internal.j0.f.c> P0() {
        return this.q.invoke();
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.n1.b, kotlin.reflect.jvm.internal.impl.descriptors.n1.a
    public kotlin.reflect.jvm.internal.impl.descriptors.n1.g getAnnotations() {
        return this.r;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.p1.z, kotlin.reflect.jvm.internal.impl.descriptors.p1.k, kotlin.reflect.jvm.internal.impl.descriptors.p
    public z0 t() {
        return new r(this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.p1.z, kotlin.reflect.jvm.internal.impl.descriptors.p1.j
    public String toString() {
        return "Lazy Java package fragment: " + d() + " of module " + this.n.a().m();
    }
}
