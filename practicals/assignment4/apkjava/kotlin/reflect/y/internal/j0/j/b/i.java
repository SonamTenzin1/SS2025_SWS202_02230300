package kotlin.reflect.y.internal.j0.j.b;

import cm.aptoide.pt.database.room.RoomNotification;
import java.util.Iterator;
import java.util.Set;
import kotlin.collections.v0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.descriptors.e;
import kotlin.reflect.jvm.internal.impl.descriptors.k0;
import kotlin.reflect.jvm.internal.impl.descriptors.l0;
import kotlin.reflect.jvm.internal.impl.descriptors.n0;
import kotlin.reflect.jvm.internal.impl.descriptors.z0;
import kotlin.reflect.y.internal.j0.b.k;
import kotlin.reflect.y.internal.j0.e.t;
import kotlin.reflect.y.internal.j0.e.w;
import kotlin.reflect.y.internal.j0.e.z.h;
import kotlin.reflect.y.internal.j0.f.f;
import kotlin.reflect.y.internal.j0.j.b.g0.d;

/* compiled from: ClassDeserializer.kt */
/* loaded from: classes3.dex */
public final class i {
    public static final b a = new b(null);

    /* renamed from: b */
    private static final Set<kotlin.reflect.y.internal.j0.f.b> f24576b;

    /* renamed from: c */
    private final k f24577c;

    /* renamed from: d */
    private final Function1<a, e> f24578d;

    /* compiled from: ClassDeserializer.kt */
    /* loaded from: classes3.dex */
    public static final class a {
        private final kotlin.reflect.y.internal.j0.f.b a;

        /* renamed from: b */
        private final g f24579b;

        public a(kotlin.reflect.y.internal.j0.f.b bVar, g gVar) {
            m.f(bVar, "classId");
            this.a = bVar;
            this.f24579b = gVar;
        }

        public final g a() {
            return this.f24579b;
        }

        public final kotlin.reflect.y.internal.j0.f.b b() {
            return this.a;
        }

        public boolean equals(Object obj) {
            return (obj instanceof a) && m.a(this.a, ((a) obj).a);
        }

        public int hashCode() {
            return this.a.hashCode();
        }
    }

    /* compiled from: ClassDeserializer.kt */
    /* loaded from: classes3.dex */
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(g gVar) {
            this();
        }

        public final Set<kotlin.reflect.y.internal.j0.f.b> a() {
            return i.f24576b;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ClassDeserializer.kt */
    /* loaded from: classes3.dex */
    public static final class c extends Lambda implements Function1<a, e> {
        c() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: b */
        public final e invoke(a aVar) {
            m.f(aVar, RoomNotification.KEY);
            return i.this.c(aVar);
        }
    }

    static {
        Set<kotlin.reflect.y.internal.j0.f.b> c2;
        c2 = v0.c(kotlin.reflect.y.internal.j0.f.b.m(k.a.f23203d.l()));
        f24576b = c2;
    }

    public i(k kVar) {
        m.f(kVar, "components");
        this.f24577c = kVar;
        this.f24578d = kVar.u().i(new c());
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x00b8 A[EDGE_INSN: B:43:0x00b8->B:44:0x00b8 BREAK  A[LOOP:1: B:34:0x0090->B:48:?], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:48:? A[LOOP:1: B:34:0x0090->B:48:?, LOOP_END, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final e c(a aVar) {
        Object obj;
        m a2;
        boolean z;
        kotlin.reflect.y.internal.j0.f.b b2 = aVar.b();
        Iterator<kotlin.reflect.jvm.internal.impl.descriptors.o1.b> it = this.f24577c.k().iterator();
        while (it.hasNext()) {
            e c2 = it.next().c(b2);
            if (c2 != null) {
                return c2;
            }
        }
        if (f24576b.contains(b2)) {
            return null;
        }
        g a3 = aVar.a();
        if (a3 == null && (a3 = this.f24577c.e().a(b2)) == null) {
            return null;
        }
        kotlin.reflect.y.internal.j0.e.z.c a4 = a3.a();
        kotlin.reflect.y.internal.j0.e.c b3 = a3.b();
        kotlin.reflect.y.internal.j0.e.z.a c3 = a3.c();
        z0 d2 = a3.d();
        kotlin.reflect.y.internal.j0.f.b g2 = b2.g();
        if (g2 != null) {
            e e2 = e(this, g2, null, 2, null);
            d dVar = e2 instanceof d ? (d) e2 : null;
            if (dVar == null) {
                return null;
            }
            f j2 = b2.j();
            m.e(j2, "classId.shortClassName");
            if (!dVar.h1(j2)) {
                return null;
            }
            a2 = dVar.b1();
        } else {
            l0 r = this.f24577c.r();
            kotlin.reflect.y.internal.j0.f.c h2 = b2.h();
            m.e(h2, "classId.packageFqName");
            Iterator<T> it2 = n0.c(r, h2).iterator();
            while (true) {
                if (!it2.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it2.next();
                k0 k0Var = (k0) obj;
                if (k0Var instanceof p) {
                    f j3 = b2.j();
                    m.e(j3, "classId.shortClassName");
                    if (!((p) k0Var).L0(j3)) {
                        z = false;
                        if (!z) {
                            break;
                        }
                    }
                }
                z = true;
                if (!z) {
                }
            }
            k0 k0Var2 = (k0) obj;
            if (k0Var2 == null) {
                return null;
            }
            k kVar = this.f24577c;
            t i1 = b3.i1();
            m.e(i1, "classProto.typeTable");
            kotlin.reflect.y.internal.j0.e.z.g gVar = new kotlin.reflect.y.internal.j0.e.z.g(i1);
            h.a aVar2 = h.a;
            w k1 = b3.k1();
            m.e(k1, "classProto.versionRequirementTable");
            a2 = kVar.a(k0Var2, a4, gVar, aVar2.a(k1), c3, null);
        }
        return new d(a2, b3, a4, c3, d2);
    }

    public static /* synthetic */ e e(i iVar, kotlin.reflect.y.internal.j0.f.b bVar, g gVar, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            gVar = null;
        }
        return iVar.d(bVar, gVar);
    }

    public final e d(kotlin.reflect.y.internal.j0.f.b bVar, g gVar) {
        m.f(bVar, "classId");
        return this.f24578d.invoke(new a(bVar, gVar));
    }
}
