package kotlin.reflect.y.internal.j0.i.w;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.c0;
import kotlin.collections.u;
import kotlin.collections.z;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.y;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.descriptors.m;
import kotlin.reflect.jvm.internal.impl.descriptors.t0;
import kotlin.reflect.jvm.internal.impl.descriptors.y0;
import kotlin.reflect.y.internal.j0.f.f;
import kotlin.reflect.y.internal.j0.i.h;
import kotlin.reflect.y.internal.j0.i.j;
import kotlin.reflect.y.internal.j0.i.w.k;
import kotlin.reflect.y.internal.j0.k.i;
import kotlin.reflect.y.internal.j0.k.n;
import kotlin.reflect.y.internal.j0.l.e0;

/* compiled from: GivenFunctionsMemberScope.kt */
/* loaded from: classes3.dex */
public abstract class e extends i {

    /* renamed from: b, reason: collision with root package name */
    static final /* synthetic */ KProperty<Object>[] f24412b = {g0.h(new y(g0.b(e.class), "allDescriptors", "getAllDescriptors()Ljava/util/List;"))};

    /* renamed from: c, reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.descriptors.e f24413c;

    /* renamed from: d, reason: collision with root package name */
    private final i f24414d;

    /* compiled from: GivenFunctionsMemberScope.kt */
    /* loaded from: classes3.dex */
    static final class a extends Lambda implements Function0<List<? extends m>> {
        a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final List<? extends m> invoke() {
            List<? extends m> o0;
            List<kotlin.reflect.jvm.internal.impl.descriptors.y> i2 = e.this.i();
            o0 = c0.o0(i2, e.this.j(i2));
            return o0;
        }
    }

    /* compiled from: GivenFunctionsMemberScope.kt */
    /* loaded from: classes3.dex */
    public static final class b extends h {
        final /* synthetic */ ArrayList<m> a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ e f24416b;

        b(ArrayList<m> arrayList, e eVar) {
            this.a = arrayList;
            this.f24416b = eVar;
        }

        @Override // kotlin.reflect.y.internal.j0.i.i
        public void a(kotlin.reflect.jvm.internal.impl.descriptors.b bVar) {
            kotlin.jvm.internal.m.f(bVar, "fakeOverride");
            j.K(bVar, null);
            this.a.add(bVar);
        }

        @Override // kotlin.reflect.y.internal.j0.i.h
        protected void e(kotlin.reflect.jvm.internal.impl.descriptors.b bVar, kotlin.reflect.jvm.internal.impl.descriptors.b bVar2) {
            kotlin.jvm.internal.m.f(bVar, "fromSuper");
            kotlin.jvm.internal.m.f(bVar2, "fromCurrent");
            throw new IllegalStateException(("Conflict in scope of " + this.f24416b.l() + ": " + bVar + " vs " + bVar2).toString());
        }
    }

    public e(n nVar, kotlin.reflect.jvm.internal.impl.descriptors.e eVar) {
        kotlin.jvm.internal.m.f(nVar, "storageManager");
        kotlin.jvm.internal.m.f(eVar, "containingClass");
        this.f24413c = eVar;
        this.f24414d = nVar.d(new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final List<m> j(List<? extends kotlin.reflect.jvm.internal.impl.descriptors.y> list) {
        Collection<? extends kotlin.reflect.jvm.internal.impl.descriptors.b> j2;
        ArrayList arrayList = new ArrayList(3);
        Collection<e0> a2 = this.f24413c.h().a();
        kotlin.jvm.internal.m.e(a2, "containingClass.typeConstructor.supertypes");
        ArrayList arrayList2 = new ArrayList();
        Iterator<T> it = a2.iterator();
        while (it.hasNext()) {
            z.z(arrayList2, k.a.a(((e0) it.next()).q(), null, null, 3, null));
        }
        ArrayList arrayList3 = new ArrayList();
        for (Object obj : arrayList2) {
            if (obj instanceof kotlin.reflect.jvm.internal.impl.descriptors.b) {
                arrayList3.add(obj);
            }
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj2 : arrayList3) {
            f name = ((kotlin.reflect.jvm.internal.impl.descriptors.b) obj2).getName();
            Object obj3 = linkedHashMap.get(name);
            if (obj3 == null) {
                obj3 = new ArrayList();
                linkedHashMap.put(name, obj3);
            }
            ((List) obj3).add(obj2);
        }
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            f fVar = (f) entry.getKey();
            List list2 = (List) entry.getValue();
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            for (Object obj4 : list2) {
                Boolean valueOf = Boolean.valueOf(((kotlin.reflect.jvm.internal.impl.descriptors.b) obj4) instanceof kotlin.reflect.jvm.internal.impl.descriptors.y);
                Object obj5 = linkedHashMap2.get(valueOf);
                if (obj5 == null) {
                    obj5 = new ArrayList();
                    linkedHashMap2.put(valueOf, obj5);
                }
                ((List) obj5).add(obj4);
            }
            for (Map.Entry entry2 : linkedHashMap2.entrySet()) {
                boolean booleanValue = ((Boolean) entry2.getKey()).booleanValue();
                List list3 = (List) entry2.getValue();
                j jVar = j.f24327b;
                if (booleanValue) {
                    j2 = new ArrayList<>();
                    for (Object obj6 : list) {
                        if (kotlin.jvm.internal.m.a(((kotlin.reflect.jvm.internal.impl.descriptors.y) obj6).getName(), fVar)) {
                            j2.add(obj6);
                        }
                    }
                } else {
                    j2 = u.j();
                }
                jVar.v(fVar, list3, j2, this.f24413c, new b(arrayList, this));
            }
        }
        return kotlin.reflect.jvm.internal.impl.utils.a.c(arrayList);
    }

    private final List<m> k() {
        return (List) kotlin.reflect.y.internal.j0.k.m.a(this.f24414d, this, f24412b[0]);
    }

    @Override // kotlin.reflect.y.internal.j0.i.w.i, kotlin.reflect.y.internal.j0.i.w.h
    public Collection<y0> a(f fVar, kotlin.reflect.y.internal.j0.c.b.b bVar) {
        kotlin.jvm.internal.m.f(fVar, "name");
        kotlin.jvm.internal.m.f(bVar, "location");
        List<m> k2 = k();
        kotlin.reflect.jvm.internal.impl.utils.e eVar = new kotlin.reflect.jvm.internal.impl.utils.e();
        for (Object obj : k2) {
            if ((obj instanceof y0) && kotlin.jvm.internal.m.a(((y0) obj).getName(), fVar)) {
                eVar.add(obj);
            }
        }
        return eVar;
    }

    @Override // kotlin.reflect.y.internal.j0.i.w.i, kotlin.reflect.y.internal.j0.i.w.h
    public Collection<t0> c(f fVar, kotlin.reflect.y.internal.j0.c.b.b bVar) {
        kotlin.jvm.internal.m.f(fVar, "name");
        kotlin.jvm.internal.m.f(bVar, "location");
        List<m> k2 = k();
        kotlin.reflect.jvm.internal.impl.utils.e eVar = new kotlin.reflect.jvm.internal.impl.utils.e();
        for (Object obj : k2) {
            if ((obj instanceof t0) && kotlin.jvm.internal.m.a(((t0) obj).getName(), fVar)) {
                eVar.add(obj);
            }
        }
        return eVar;
    }

    @Override // kotlin.reflect.y.internal.j0.i.w.i, kotlin.reflect.y.internal.j0.i.w.k
    public Collection<m> g(d dVar, Function1<? super f, Boolean> function1) {
        List j2;
        kotlin.jvm.internal.m.f(dVar, "kindFilter");
        kotlin.jvm.internal.m.f(function1, "nameFilter");
        if (dVar.a(d.n.m())) {
            return k();
        }
        j2 = u.j();
        return j2;
    }

    protected abstract List<kotlin.reflect.jvm.internal.impl.descriptors.y> i();

    /* JADX INFO: Access modifiers changed from: protected */
    public final kotlin.reflect.jvm.internal.impl.descriptors.e l() {
        return this.f24413c;
    }
}
