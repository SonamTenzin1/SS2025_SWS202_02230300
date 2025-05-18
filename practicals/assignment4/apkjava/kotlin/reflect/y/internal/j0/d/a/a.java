package kotlin.reflect.y.internal.j0.d.a;

import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Pair;
import kotlin.collections.c0;
import kotlin.collections.n;
import kotlin.collections.s;
import kotlin.collections.x0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.m;
import kotlin.reflect.y.internal.j0.b.k;
import kotlin.reflect.y.internal.j0.d.a.o0.f;
import kotlin.reflect.y.internal.j0.d.a.o0.h;
import kotlin.reflect.y.internal.j0.d.a.o0.i;
import kotlin.reflect.y.internal.j0.f.c;

/* compiled from: AbstractAnnotationTypeQualifierResolver.kt */
/* loaded from: classes2.dex */
public abstract class a<TAnnotation> {
    private static final C0326a a = new C0326a(null);

    /* renamed from: b, reason: collision with root package name */
    @Deprecated
    private static final Map<String, kotlin.reflect.y.internal.j0.d.a.b> f23320b;

    /* renamed from: c, reason: collision with root package name */
    private final w f23321c;

    /* renamed from: d, reason: collision with root package name */
    private final ConcurrentHashMap<Object, TAnnotation> f23322d;

    /* compiled from: AbstractAnnotationTypeQualifierResolver.kt */
    /* renamed from: kotlin.f0.y.e.j0.d.a.a$a, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    private static final class C0326a {
        private C0326a() {
        }

        public /* synthetic */ C0326a(g gVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AbstractAnnotationTypeQualifierResolver.kt */
    /* loaded from: classes2.dex */
    public static final class b extends Lambda implements Function1<TAnnotation, Boolean> {

        /* renamed from: f, reason: collision with root package name */
        public static final b f23323f = new b();

        b() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(TAnnotation tannotation) {
            m.f(tannotation, "$this$extractNullability");
            return Boolean.FALSE;
        }
    }

    static {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (kotlin.reflect.y.internal.j0.d.a.b bVar : kotlin.reflect.y.internal.j0.d.a.b.values()) {
            String k2 = bVar.k();
            if (linkedHashMap.get(k2) == null) {
                linkedHashMap.put(k2, bVar);
            }
        }
        f23320b = linkedHashMap;
    }

    public a(w wVar) {
        m.f(wVar, "javaTypeEnhancementState");
        this.f23321c = wVar;
        this.f23322d = new ConcurrentHashMap<>();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final Set<kotlin.reflect.y.internal.j0.d.a.b> a(Set<? extends kotlin.reflect.y.internal.j0.d.a.b> set) {
        Set l0;
        Set k2;
        Set<kotlin.reflect.y.internal.j0.d.a.b> l;
        if (!set.contains(kotlin.reflect.y.internal.j0.d.a.b.TYPE_USE)) {
            return set;
        }
        l0 = n.l0(kotlin.reflect.y.internal.j0.d.a.b.values());
        k2 = x0.k(l0, kotlin.reflect.y.internal.j0.d.a.b.TYPE_PARAMETER_BOUNDS);
        l = x0.l(k2, set);
        return l;
    }

    private final q d(TAnnotation tannotation) {
        i g2;
        q r = r(tannotation);
        if (r != null) {
            return r;
        }
        Pair<TAnnotation, Set<kotlin.reflect.y.internal.j0.d.a.b>> t = t(tannotation);
        if (t == null) {
            return null;
        }
        TAnnotation a2 = t.a();
        Set<kotlin.reflect.y.internal.j0.d.a.b> b2 = t.b();
        f0 q = q(tannotation);
        if (q == null) {
            q = p(a2);
        }
        if (q.q() || (g2 = g(a2, b.f23323f)) == null) {
            return null;
        }
        return new q(i.b(g2, null, q.u(), 1, null), b2, false, 4, null);
    }

    private final i g(TAnnotation tannotation, Function1<? super TAnnotation, Boolean> function1) {
        i n;
        i n2 = n(tannotation, function1.invoke(tannotation).booleanValue());
        if (n2 != null) {
            return n2;
        }
        TAnnotation s = s(tannotation);
        if (s == null) {
            return null;
        }
        f0 p = p(tannotation);
        if (p.q() || (n = n(s, function1.invoke(s).booleanValue())) == null) {
            return null;
        }
        return i.b(n, null, p.u(), 1, null);
    }

    private final TAnnotation h(TAnnotation tannotation, c cVar) {
        for (TAnnotation tannotation2 : k(tannotation)) {
            if (m.a(i(tannotation2), cVar)) {
                return tannotation2;
            }
        }
        return null;
    }

    private final boolean l(TAnnotation tannotation, c cVar) {
        Iterable<TAnnotation> k2 = k(tannotation);
        if ((k2 instanceof Collection) && ((Collection) k2).isEmpty()) {
            return false;
        }
        Iterator<TAnnotation> it = k2.iterator();
        while (it.hasNext()) {
            if (m.a(i(it.next()), cVar)) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0078, code lost:
    
        if (r6.equals("ALWAYS") != false) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x008d, code lost:
    
        if (r6.equals("NEVER") == false) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0099, code lost:
    
        r6 = kotlin.reflect.y.internal.j0.d.a.o0.h.NULLABLE;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0096, code lost:
    
        if (r6.equals("MAYBE") == false) goto L41;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:31:0x006e. Please report as an issue. */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final i n(TAnnotation tannotation, boolean z) {
        h hVar;
        c i2 = i(tannotation);
        if (i2 == null) {
            return null;
        }
        f0 invoke = this.f23321c.c().invoke(i2);
        if (invoke.q()) {
            return null;
        }
        if (b0.l().contains(i2)) {
            hVar = h.NULLABLE;
        } else if (b0.k().contains(i2)) {
            hVar = h.NOT_NULL;
        } else if (m.a(i2, b0.g())) {
            hVar = h.NULLABLE;
        } else if (m.a(i2, b0.h())) {
            hVar = h.FORCE_FLEXIBILITY;
        } else if (m.a(i2, b0.f())) {
            String str = (String) s.V(b(tannotation, false));
            if (str != null) {
                switch (str.hashCode()) {
                    case 73135176:
                        break;
                    case 74175084:
                        break;
                    case 433141802:
                        if (str.equals("UNKNOWN")) {
                            hVar = h.FORCE_FLEXIBILITY;
                            break;
                        }
                        return null;
                    case 1933739535:
                        break;
                    default:
                        return null;
                }
            }
            hVar = h.NOT_NULL;
        } else if (m.a(i2, b0.d())) {
            hVar = h.NULLABLE;
        } else if (m.a(i2, b0.c())) {
            hVar = h.NOT_NULL;
        } else if (m.a(i2, b0.a())) {
            hVar = h.NOT_NULL;
        } else {
            if (!m.a(i2, b0.b())) {
                return null;
            }
            hVar = h.NULLABLE;
        }
        return new i(hVar, invoke.u() || z);
    }

    private final f0 o(TAnnotation tannotation) {
        c i2 = i(tannotation);
        if (i2 != null && c.c().containsKey(i2)) {
            return this.f23321c.c().invoke(i2);
        }
        return p(tannotation);
    }

    private final f0 p(TAnnotation tannotation) {
        f0 q = q(tannotation);
        return q != null ? q : this.f23321c.d().a();
    }

    private final f0 q(TAnnotation tannotation) {
        Iterable<String> b2;
        String str;
        f0 f0Var = this.f23321c.d().c().get(i(tannotation));
        if (f0Var != null) {
            return f0Var;
        }
        TAnnotation h2 = h(tannotation, c.d());
        if (h2 == null || (b2 = b(h2, false)) == null || (str = (String) s.V(b2)) == null) {
            return null;
        }
        f0 b3 = this.f23321c.d().b();
        if (b3 != null) {
            return b3;
        }
        int hashCode = str.hashCode();
        if (hashCode == -2137067054) {
            if (str.equals("IGNORE")) {
                return f0.IGNORE;
            }
            return null;
        }
        if (hashCode == -1838656823) {
            if (str.equals("STRICT")) {
                return f0.STRICT;
            }
            return null;
        }
        if (hashCode == 2656902 && str.equals("WARN")) {
            return f0.WARN;
        }
        return null;
    }

    private final q r(TAnnotation tannotation) {
        q qVar;
        if (this.f23321c.b() || (qVar = c.a().get(i(tannotation))) == null) {
            return null;
        }
        f0 o = o(tannotation);
        if (!(o != f0.IGNORE)) {
            o = null;
        }
        if (o == null) {
            return null;
        }
        return q.b(qVar, i.b(qVar.d(), null, o.u(), 1, null), null, false, 6, null);
    }

    private final Pair<TAnnotation, Set<kotlin.reflect.y.internal.j0.d.a.b>> t(TAnnotation tannotation) {
        TAnnotation h2;
        TAnnotation tannotation2;
        if (this.f23321c.d().d() || (h2 = h(tannotation, c.e())) == null) {
            return null;
        }
        Iterator<TAnnotation> it = k(tannotation).iterator();
        while (true) {
            if (!it.hasNext()) {
                tannotation2 = null;
                break;
            }
            tannotation2 = it.next();
            if (s(tannotation2) != null) {
                break;
            }
        }
        if (tannotation2 == null) {
            return null;
        }
        Iterable<String> b2 = b(h2, true);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator<String> it2 = b2.iterator();
        while (it2.hasNext()) {
            kotlin.reflect.y.internal.j0.d.a.b bVar = f23320b.get(it2.next());
            if (bVar != null) {
                linkedHashSet.add(bVar);
            }
        }
        return new Pair<>(tannotation2, a(linkedHashSet));
    }

    protected abstract Iterable<String> b(TAnnotation tannotation, boolean z);

    public final x c(x xVar, Iterable<? extends TAnnotation> iterable) {
        EnumMap<kotlin.reflect.y.internal.j0.d.a.b, q> b2;
        m.f(iterable, "annotations");
        if (this.f23321c.b()) {
            return xVar;
        }
        ArrayList<q> arrayList = new ArrayList();
        Iterator<? extends TAnnotation> it = iterable.iterator();
        while (it.hasNext()) {
            q d2 = d(it.next());
            if (d2 != null) {
                arrayList.add(d2);
            }
        }
        if (arrayList.isEmpty()) {
            return xVar;
        }
        EnumMap enumMap = (xVar == null || (b2 = xVar.b()) == null) ? new EnumMap(kotlin.reflect.y.internal.j0.d.a.b.class) : new EnumMap((EnumMap) b2);
        boolean z = false;
        for (q qVar : arrayList) {
            Iterator<kotlin.reflect.y.internal.j0.d.a.b> it2 = qVar.e().iterator();
            while (it2.hasNext()) {
                enumMap.put((EnumMap) it2.next(), (kotlin.reflect.y.internal.j0.d.a.b) qVar);
                z = true;
            }
        }
        return !z ? xVar : new x(enumMap);
    }

    public final f e(Iterable<? extends TAnnotation> iterable) {
        f fVar;
        m.f(iterable, "annotations");
        Iterator<? extends TAnnotation> it = iterable.iterator();
        f fVar2 = null;
        while (it.hasNext()) {
            c i2 = i(it.next());
            if (b0.m().contains(i2)) {
                fVar = f.READ_ONLY;
            } else if (b0.j().contains(i2)) {
                fVar = f.MUTABLE;
            } else {
                continue;
            }
            if (fVar2 != null && fVar2 != fVar) {
                return null;
            }
            fVar2 = fVar;
        }
        return fVar2;
    }

    public final i f(Iterable<? extends TAnnotation> iterable, Function1<? super TAnnotation, Boolean> function1) {
        m.f(iterable, "annotations");
        m.f(function1, "forceWarning");
        Iterator<? extends TAnnotation> it = iterable.iterator();
        i iVar = null;
        while (it.hasNext()) {
            i g2 = g(it.next(), function1);
            if (iVar != null) {
                if (g2 != null && !m.a(g2, iVar) && (!g2.d() || iVar.d())) {
                    if (g2.d() || !iVar.d()) {
                        return null;
                    }
                }
            }
            iVar = g2;
        }
        return iVar;
    }

    protected abstract c i(TAnnotation tannotation);

    protected abstract Object j(TAnnotation tannotation);

    protected abstract Iterable<TAnnotation> k(TAnnotation tannotation);

    public final boolean m(TAnnotation tannotation) {
        m.f(tannotation, "annotation");
        TAnnotation h2 = h(tannotation, k.a.H);
        if (h2 == null) {
            return false;
        }
        Iterable<String> b2 = b(h2, false);
        if ((b2 instanceof Collection) && ((Collection) b2).isEmpty()) {
            return false;
        }
        Iterator<String> it = b2.iterator();
        while (it.hasNext()) {
            if (m.a(it.next(), kotlin.reflect.jvm.internal.impl.descriptors.n1.n.H.name())) {
                return true;
            }
        }
        return false;
    }

    public final TAnnotation s(TAnnotation tannotation) {
        boolean K;
        TAnnotation tannotation2;
        m.f(tannotation, "annotation");
        if (this.f23321c.d().d()) {
            return null;
        }
        K = c0.K(c.b(), i(tannotation));
        if (K || l(tannotation, c.f())) {
            return tannotation;
        }
        if (!l(tannotation, c.g())) {
            return null;
        }
        ConcurrentHashMap<Object, TAnnotation> concurrentHashMap = this.f23322d;
        Object j2 = j(tannotation);
        TAnnotation tannotation3 = concurrentHashMap.get(j2);
        if (tannotation3 != null) {
            return tannotation3;
        }
        Iterator<TAnnotation> it = k(tannotation).iterator();
        while (true) {
            if (!it.hasNext()) {
                tannotation2 = null;
                break;
            }
            tannotation2 = s(it.next());
            if (tannotation2 != null) {
                break;
            }
        }
        if (tannotation2 == null) {
            return null;
        }
        TAnnotation putIfAbsent = concurrentHashMap.putIfAbsent(j2, tannotation2);
        return putIfAbsent == null ? tannotation2 : putIfAbsent;
    }
}
