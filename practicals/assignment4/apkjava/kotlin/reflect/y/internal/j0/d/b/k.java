package kotlin.reflect.y.internal.j0.d.b;

import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.descriptors.a1;
import kotlin.reflect.jvm.internal.impl.protobuf.h;
import kotlin.reflect.y.internal.j0.e.a0.a;
import kotlin.reflect.y.internal.j0.e.a0.b.e;
import kotlin.reflect.y.internal.j0.e.l;
import kotlin.reflect.y.internal.j0.e.z.c;
import kotlin.reflect.y.internal.j0.f.b;
import kotlin.reflect.y.internal.j0.i.u.d;
import kotlin.reflect.y.internal.j0.j.b.g0.f;
import kotlin.reflect.y.internal.j0.j.b.t;
import kotlin.text.v;

/* compiled from: JvmPackagePartSource.kt */
/* loaded from: classes3.dex */
public final class k implements f {

    /* renamed from: b, reason: collision with root package name */
    private final d f23795b;

    /* renamed from: c, reason: collision with root package name */
    private final d f23796c;

    /* renamed from: d, reason: collision with root package name */
    private final t<e> f23797d;

    /* renamed from: e, reason: collision with root package name */
    private final boolean f23798e;

    /* renamed from: f, reason: collision with root package name */
    private final kotlin.reflect.y.internal.j0.j.b.g0.e f23799f;

    /* renamed from: g, reason: collision with root package name */
    private final q f23800g;

    /* renamed from: h, reason: collision with root package name */
    private final String f23801h;

    public k(d dVar, d dVar2, l lVar, c cVar, t<e> tVar, boolean z, kotlin.reflect.y.internal.j0.j.b.g0.e eVar, q qVar) {
        String string;
        m.f(dVar, "className");
        m.f(lVar, "packageProto");
        m.f(cVar, "nameResolver");
        m.f(eVar, "abiStability");
        this.f23795b = dVar;
        this.f23796c = dVar2;
        this.f23797d = tVar;
        this.f23798e = z;
        this.f23799f = eVar;
        this.f23800g = qVar;
        h.f<l, Integer> fVar = a.m;
        m.e(fVar, "packageModuleName");
        Integer num = (Integer) kotlin.reflect.y.internal.j0.e.z.e.a(lVar, fVar);
        this.f23801h = (num == null || (string = cVar.getString(num.intValue())) == null) ? "main" : string;
    }

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.z0
    public a1 a() {
        a1 a1Var = a1.a;
        m.e(a1Var, "NO_SOURCE_FILE");
        return a1Var;
    }

    @Override // kotlin.reflect.y.internal.j0.j.b.g0.f
    public String c() {
        return "Class '" + d().b().b() + '\'';
    }

    public final b d() {
        return new b(e().g(), h());
    }

    public d e() {
        return this.f23795b;
    }

    public d f() {
        return this.f23796c;
    }

    public final q g() {
        return this.f23800g;
    }

    public final kotlin.reflect.y.internal.j0.f.f h() {
        String I0;
        String f2 = e().f();
        m.e(f2, "className.internalName");
        I0 = v.I0(f2, '/', null, 2, null);
        kotlin.reflect.y.internal.j0.f.f x = kotlin.reflect.y.internal.j0.f.f.x(I0);
        m.e(x, "identifier(className.int….substringAfterLast('/'))");
        return x;
    }

    public String toString() {
        return k.class.getSimpleName() + ": " + e();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public k(q qVar, l lVar, c cVar, t<e> tVar, boolean z, kotlin.reflect.y.internal.j0.j.b.g0.e eVar) {
        this(r2, r1, lVar, cVar, tVar, z, eVar, qVar);
        m.f(qVar, "kotlinClass");
        m.f(lVar, "packageProto");
        m.f(cVar, "nameResolver");
        m.f(eVar, "abiStability");
        d b2 = d.b(qVar.e());
        m.e(b2, "byClassId(kotlinClass.classId)");
        String e2 = qVar.a().e();
        d dVar = null;
        if (e2 != null) {
            if (e2.length() > 0) {
                dVar = d.d(e2);
            }
        }
    }
}
