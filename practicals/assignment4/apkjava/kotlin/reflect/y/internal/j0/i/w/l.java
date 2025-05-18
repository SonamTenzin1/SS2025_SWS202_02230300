package kotlin.reflect.y.internal.j0.i.w;

import java.util.List;
import kotlin.collections.u;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.y;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.descriptors.e;
import kotlin.reflect.jvm.internal.impl.descriptors.f;
import kotlin.reflect.jvm.internal.impl.descriptors.h;
import kotlin.reflect.jvm.internal.impl.descriptors.y0;
import kotlin.reflect.y.internal.j0.c.b.b;
import kotlin.reflect.y.internal.j0.i.c;
import kotlin.reflect.y.internal.j0.k.i;
import kotlin.reflect.y.internal.j0.k.n;

/* compiled from: StaticScopeForKotlinEnum.kt */
/* loaded from: classes3.dex */
public final class l extends i {

    /* renamed from: b, reason: collision with root package name */
    static final /* synthetic */ KProperty<Object>[] f24423b = {g0.h(new y(g0.b(l.class), "functions", "getFunctions()Ljava/util/List;"))};

    /* renamed from: c, reason: collision with root package name */
    private final e f24424c;

    /* renamed from: d, reason: collision with root package name */
    private final i f24425d;

    /* compiled from: StaticScopeForKotlinEnum.kt */
    /* loaded from: classes3.dex */
    static final class a extends Lambda implements Function0<List<? extends y0>> {
        a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final List<? extends y0> invoke() {
            List<? extends y0> m;
            m = u.m(c.f(l.this.f24424c), c.g(l.this.f24424c));
            return m;
        }
    }

    public l(n nVar, e eVar) {
        m.f(nVar, "storageManager");
        m.f(eVar, "containingClass");
        this.f24424c = eVar;
        eVar.i();
        f fVar = f.ENUM_CLASS;
        this.f24425d = nVar.d(new a());
    }

    private final List<y0> l() {
        return (List) kotlin.reflect.y.internal.j0.k.m.a(this.f24425d, this, f24423b[0]);
    }

    @Override // kotlin.reflect.y.internal.j0.i.w.i, kotlin.reflect.y.internal.j0.i.w.k
    public /* bridge */ /* synthetic */ h f(kotlin.reflect.y.internal.j0.f.f fVar, b bVar) {
        return (h) i(fVar, bVar);
    }

    public Void i(kotlin.reflect.y.internal.j0.f.f fVar, b bVar) {
        m.f(fVar, "name");
        m.f(bVar, "location");
        return null;
    }

    @Override // kotlin.reflect.y.internal.j0.i.w.i, kotlin.reflect.y.internal.j0.i.w.k
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public List<y0> g(d dVar, Function1<? super kotlin.reflect.y.internal.j0.f.f, Boolean> function1) {
        m.f(dVar, "kindFilter");
        m.f(function1, "nameFilter");
        return l();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.reflect.y.internal.j0.i.w.i, kotlin.reflect.y.internal.j0.i.w.h
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public kotlin.reflect.jvm.internal.impl.utils.e<y0> a(kotlin.reflect.y.internal.j0.f.f fVar, b bVar) {
        m.f(fVar, "name");
        m.f(bVar, "location");
        List<y0> l = l();
        kotlin.reflect.jvm.internal.impl.utils.e<y0> eVar = new kotlin.reflect.jvm.internal.impl.utils.e<>();
        for (Object obj : l) {
            if (m.a(((y0) obj).getName(), fVar)) {
                eVar.add(obj);
            }
        }
        return eVar;
    }
}
