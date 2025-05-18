package kotlin.reflect.y.internal.j0.d.b;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import kotlin.Pair;
import kotlin.collections.u;
import kotlin.collections.v0;
import kotlin.collections.w0;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.descriptors.k0;
import kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException;
import kotlin.reflect.y.internal.j0.d.b.c0.a;
import kotlin.reflect.y.internal.j0.e.a0.b.e;
import kotlin.reflect.y.internal.j0.e.a0.b.i;
import kotlin.reflect.y.internal.j0.e.c;
import kotlin.reflect.y.internal.j0.e.l;
import kotlin.reflect.y.internal.j0.f.f;
import kotlin.reflect.y.internal.j0.i.w.h;
import kotlin.reflect.y.internal.j0.j.b.k;
import kotlin.reflect.y.internal.j0.j.b.t;

/* compiled from: DeserializedDescriptorResolver.kt */
/* loaded from: classes3.dex */
public final class g {
    public static final a a = new a(null);

    /* renamed from: b, reason: collision with root package name */
    private static final Set<a.EnumC0345a> f23787b;

    /* renamed from: c, reason: collision with root package name */
    private static final Set<a.EnumC0345a> f23788c;

    /* renamed from: d, reason: collision with root package name */
    private static final e f23789d;

    /* renamed from: e, reason: collision with root package name */
    private static final e f23790e;

    /* renamed from: f, reason: collision with root package name */
    private static final e f23791f;

    /* renamed from: g, reason: collision with root package name */
    public k f23792g;

    /* compiled from: DeserializedDescriptorResolver.kt */
    /* loaded from: classes3.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
            this();
        }

        public final e a() {
            return g.f23791f;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: DeserializedDescriptorResolver.kt */
    /* loaded from: classes3.dex */
    public static final class b extends Lambda implements Function0<Collection<? extends f>> {

        /* renamed from: f, reason: collision with root package name */
        public static final b f23793f = new b();

        b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Collection<f> invoke() {
            List j2;
            j2 = u.j();
            return j2;
        }
    }

    static {
        Set<a.EnumC0345a> c2;
        Set<a.EnumC0345a> i2;
        c2 = v0.c(a.EnumC0345a.CLASS);
        f23787b = c2;
        i2 = w0.i(a.EnumC0345a.FILE_FACADE, a.EnumC0345a.MULTIFILE_CLASS_PART);
        f23788c = i2;
        f23789d = new e(1, 1, 2);
        f23790e = new e(1, 1, 11);
        f23791f = new e(1, 1, 13);
    }

    private final kotlin.reflect.y.internal.j0.j.b.g0.e c(q qVar) {
        return d().g().b() ? kotlin.reflect.y.internal.j0.j.b.g0.e.STABLE : qVar.a().j() ? kotlin.reflect.y.internal.j0.j.b.g0.e.FIR_UNSTABLE : qVar.a().k() ? kotlin.reflect.y.internal.j0.j.b.g0.e.IR_UNSTABLE : kotlin.reflect.y.internal.j0.j.b.g0.e.STABLE;
    }

    private final t<e> e(q qVar) {
        if (f() || qVar.a().d().h()) {
            return null;
        }
        return new t<>(qVar.a().d(), e.f23889h, qVar.getLocation(), qVar.e());
    }

    private final boolean f() {
        return d().g().d();
    }

    private final boolean g(q qVar) {
        return !d().g().c() && qVar.a().i() && m.a(qVar.a().d(), f23790e);
    }

    private final boolean h(q qVar) {
        return (d().g().e() && (qVar.a().i() || m.a(qVar.a().d(), f23789d))) || g(qVar);
    }

    private final String[] j(q qVar, Set<? extends a.EnumC0345a> set) {
        kotlin.reflect.y.internal.j0.d.b.c0.a a2 = qVar.a();
        String[] a3 = a2.a();
        if (a3 == null) {
            a3 = a2.b();
        }
        if (a3 == null || !set.contains(a2.c())) {
            return null;
        }
        return a3;
    }

    public final h b(k0 k0Var, q qVar) {
        String[] g2;
        Pair<kotlin.reflect.y.internal.j0.e.a0.b.f, l> pair;
        m.f(k0Var, "descriptor");
        m.f(qVar, "kotlinClass");
        String[] j2 = j(qVar, f23788c);
        if (j2 == null || (g2 = qVar.a().g()) == null) {
            return null;
        }
        try {
            try {
                pair = i.m(j2, g2);
            } catch (InvalidProtocolBufferException e2) {
                throw new IllegalStateException("Could not read data from " + qVar.getLocation(), e2);
            }
        } catch (Throwable th) {
            if (f() || qVar.a().d().h()) {
                throw th;
            }
            pair = null;
        }
        if (pair == null) {
            return null;
        }
        kotlin.reflect.y.internal.j0.e.a0.b.f a2 = pair.a();
        l b2 = pair.b();
        k kVar = new k(qVar, b2, a2, e(qVar), h(qVar), c(qVar));
        return new kotlin.reflect.y.internal.j0.j.b.g0.i(k0Var, b2, a2, qVar.a().d(), kVar, d(), "scope for " + kVar + " in " + k0Var, b.f23793f);
    }

    public final k d() {
        k kVar = this.f23792g;
        if (kVar != null) {
            return kVar;
        }
        m.w("components");
        return null;
    }

    public final kotlin.reflect.y.internal.j0.j.b.g i(q qVar) {
        String[] g2;
        Pair<kotlin.reflect.y.internal.j0.e.a0.b.f, c> pair;
        m.f(qVar, "kotlinClass");
        String[] j2 = j(qVar, f23787b);
        if (j2 == null || (g2 = qVar.a().g()) == null) {
            return null;
        }
        try {
            try {
                pair = i.i(j2, g2);
            } catch (InvalidProtocolBufferException e2) {
                throw new IllegalStateException("Could not read data from " + qVar.getLocation(), e2);
            }
        } catch (Throwable th) {
            if (f() || qVar.a().d().h()) {
                throw th;
            }
            pair = null;
        }
        if (pair == null) {
            return null;
        }
        return new kotlin.reflect.y.internal.j0.j.b.g(pair.a(), pair.b(), qVar.a().d(), new s(qVar, e(qVar), h(qVar), c(qVar)));
    }

    public final kotlin.reflect.jvm.internal.impl.descriptors.e k(q qVar) {
        m.f(qVar, "kotlinClass");
        kotlin.reflect.y.internal.j0.j.b.g i2 = i(qVar);
        if (i2 == null) {
            return null;
        }
        return d().f().d(qVar.e(), i2);
    }

    public final void l(e eVar) {
        m.f(eVar, "components");
        m(eVar.a());
    }

    public final void m(k kVar) {
        m.f(kVar, "<set-?>");
        this.f23792g = kVar;
    }
}
