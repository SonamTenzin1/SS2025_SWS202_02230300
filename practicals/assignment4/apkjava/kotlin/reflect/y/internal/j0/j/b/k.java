package kotlin.reflect.y.internal.j0.j.b;

import java.util.List;
import kotlin.collections.t;
import kotlin.collections.u;
import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.descriptors.g0;
import kotlin.reflect.jvm.internal.impl.descriptors.j0;
import kotlin.reflect.jvm.internal.impl.descriptors.k0;
import kotlin.reflect.jvm.internal.impl.descriptors.l0;
import kotlin.reflect.jvm.internal.impl.descriptors.n1.c;
import kotlin.reflect.jvm.internal.impl.descriptors.o1.a;
import kotlin.reflect.jvm.internal.impl.descriptors.o1.b;
import kotlin.reflect.jvm.internal.impl.descriptors.o1.c;
import kotlin.reflect.jvm.internal.impl.descriptors.o1.e;
import kotlin.reflect.jvm.internal.impl.protobuf.f;
import kotlin.reflect.y.internal.j0.e.z.h;
import kotlin.reflect.y.internal.j0.i.r.g;
import kotlin.reflect.y.internal.j0.k.n;
import kotlin.reflect.y.internal.j0.l.o;
import kotlin.reflect.y.internal.j0.l.t1.l;
import kotlin.reflect.y.internal.j0.l.z0;
import okhttp3.internal.http2.Http2;

/* compiled from: context.kt */
/* loaded from: classes3.dex */
public final class k {
    private final n a;

    /* renamed from: b, reason: collision with root package name */
    private final g0 f24582b;

    /* renamed from: c, reason: collision with root package name */
    private final l f24583c;

    /* renamed from: d, reason: collision with root package name */
    private final h f24584d;

    /* renamed from: e, reason: collision with root package name */
    private final c<c, g<?>> f24585e;

    /* renamed from: f, reason: collision with root package name */
    private final l0 f24586f;

    /* renamed from: g, reason: collision with root package name */
    private final v f24587g;

    /* renamed from: h, reason: collision with root package name */
    private final r f24588h;

    /* renamed from: i, reason: collision with root package name */
    private final kotlin.reflect.y.internal.j0.c.b.c f24589i;

    /* renamed from: j, reason: collision with root package name */
    private final s f24590j;

    /* renamed from: k, reason: collision with root package name */
    private final Iterable<b> f24591k;
    private final j0 l;
    private final j m;
    private final a n;
    private final kotlin.reflect.jvm.internal.impl.descriptors.o1.c o;
    private final f p;
    private final l q;
    private final kotlin.reflect.y.internal.j0.i.v.a r;
    private final e s;
    private final List<z0> t;
    private final i u;

    /* JADX WARN: Multi-variable type inference failed */
    public k(n nVar, g0 g0Var, l lVar, h hVar, c<? extends c, ? extends g<?>> cVar, l0 l0Var, v vVar, r rVar, kotlin.reflect.y.internal.j0.c.b.c cVar2, s sVar, Iterable<? extends b> iterable, j0 j0Var, j jVar, a aVar, kotlin.reflect.jvm.internal.impl.descriptors.o1.c cVar3, f fVar, l lVar2, kotlin.reflect.y.internal.j0.i.v.a aVar2, e eVar, List<? extends z0> list) {
        m.f(nVar, "storageManager");
        m.f(g0Var, "moduleDescriptor");
        m.f(lVar, "configuration");
        m.f(hVar, "classDataFinder");
        m.f(cVar, "annotationAndConstantLoader");
        m.f(l0Var, "packageFragmentProvider");
        m.f(vVar, "localClassifierTypeSettings");
        m.f(rVar, "errorReporter");
        m.f(cVar2, "lookupTracker");
        m.f(sVar, "flexibleTypeDeserializer");
        m.f(iterable, "fictitiousClassDescriptorFactories");
        m.f(j0Var, "notFoundClasses");
        m.f(jVar, "contractDeserializer");
        m.f(aVar, "additionalClassPartsProvider");
        m.f(cVar3, "platformDependentDeclarationFilter");
        m.f(fVar, "extensionRegistryLite");
        m.f(lVar2, "kotlinTypeChecker");
        m.f(aVar2, "samConversionResolver");
        m.f(eVar, "platformDependentTypeTransformer");
        m.f(list, "typeAttributeTranslators");
        this.a = nVar;
        this.f24582b = g0Var;
        this.f24583c = lVar;
        this.f24584d = hVar;
        this.f24585e = cVar;
        this.f24586f = l0Var;
        this.f24587g = vVar;
        this.f24588h = rVar;
        this.f24589i = cVar2;
        this.f24590j = sVar;
        this.f24591k = iterable;
        this.l = j0Var;
        this.m = jVar;
        this.n = aVar;
        this.o = cVar3;
        this.p = fVar;
        this.q = lVar2;
        this.r = aVar2;
        this.s = eVar;
        this.t = list;
        this.u = new i(this);
    }

    public final m a(k0 k0Var, kotlin.reflect.y.internal.j0.e.z.c cVar, kotlin.reflect.y.internal.j0.e.z.g gVar, h hVar, kotlin.reflect.y.internal.j0.e.z.a aVar, kotlin.reflect.y.internal.j0.j.b.g0.f fVar) {
        List j2;
        m.f(k0Var, "descriptor");
        m.f(cVar, "nameResolver");
        m.f(gVar, "typeTable");
        m.f(hVar, "versionRequirementTable");
        m.f(aVar, "metadataVersion");
        j2 = u.j();
        return new m(this, cVar, k0Var, gVar, hVar, aVar, fVar, null, j2);
    }

    public final kotlin.reflect.jvm.internal.impl.descriptors.e b(kotlin.reflect.y.internal.j0.f.b bVar) {
        m.f(bVar, "classId");
        return i.e(this.u, bVar, null, 2, null);
    }

    public final a c() {
        return this.n;
    }

    public final c<c, g<?>> d() {
        return this.f24585e;
    }

    public final h e() {
        return this.f24584d;
    }

    public final i f() {
        return this.u;
    }

    public final l g() {
        return this.f24583c;
    }

    public final j h() {
        return this.m;
    }

    public final r i() {
        return this.f24588h;
    }

    public final f j() {
        return this.p;
    }

    public final Iterable<b> k() {
        return this.f24591k;
    }

    public final s l() {
        return this.f24590j;
    }

    public final l m() {
        return this.q;
    }

    public final v n() {
        return this.f24587g;
    }

    public final kotlin.reflect.y.internal.j0.c.b.c o() {
        return this.f24589i;
    }

    public final g0 p() {
        return this.f24582b;
    }

    public final j0 q() {
        return this.l;
    }

    public final l0 r() {
        return this.f24586f;
    }

    public final kotlin.reflect.jvm.internal.impl.descriptors.o1.c s() {
        return this.o;
    }

    public final e t() {
        return this.s;
    }

    public final n u() {
        return this.a;
    }

    public final List<z0> v() {
        return this.t;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ k(n nVar, g0 g0Var, l lVar, h hVar, c cVar, l0 l0Var, v vVar, r rVar, kotlin.reflect.y.internal.j0.c.b.c cVar2, s sVar, Iterable iterable, j0 j0Var, j jVar, a aVar, kotlin.reflect.jvm.internal.impl.descriptors.o1.c cVar3, f fVar, l lVar2, kotlin.reflect.y.internal.j0.i.v.a aVar2, e eVar, List list, int i2, kotlin.jvm.internal.g gVar) {
        this(nVar, g0Var, lVar, hVar, cVar, l0Var, vVar, rVar, cVar2, sVar, iterable, j0Var, jVar, r16, r17, fVar, r19, aVar2, r21, r22);
        List list2;
        List e2;
        a aVar3 = (i2 & 8192) != 0 ? a.C0408a.a : aVar;
        kotlin.reflect.jvm.internal.impl.descriptors.o1.c cVar4 = (i2 & Http2.INITIAL_MAX_FRAME_SIZE) != 0 ? c.a.a : cVar3;
        l a = (65536 & i2) != 0 ? l.f24802b.a() : lVar2;
        e eVar2 = (262144 & i2) != 0 ? e.a.a : eVar;
        if ((i2 & 524288) != 0) {
            e2 = t.e(o.a);
            list2 = e2;
        } else {
            list2 = list;
        }
    }
}
