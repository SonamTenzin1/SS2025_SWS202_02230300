package kotlin.reflect.y.internal.j0.d.a.j0;

import java.util.List;
import java.util.Map;
import kotlin.collections.p0;
import kotlin.collections.q0;
import kotlin.collections.t;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.y;
import kotlin.reflect.KProperty;
import kotlin.reflect.y.internal.j0.b.k;
import kotlin.reflect.y.internal.j0.d.a.n0.b;
import kotlin.reflect.y.internal.j0.d.a.n0.e;
import kotlin.reflect.y.internal.j0.d.a.n0.m;
import kotlin.reflect.y.internal.j0.f.f;
import kotlin.reflect.y.internal.j0.i.r.g;
import kotlin.s;

/* compiled from: JavaAnnotationMapper.kt */
/* loaded from: classes2.dex */
public final class i extends b {

    /* renamed from: g, reason: collision with root package name */
    static final /* synthetic */ KProperty<Object>[] f23426g = {g0.h(new y(g0.b(i.class), "allValueArguments", "getAllValueArguments()Ljava/util/Map;"))};

    /* renamed from: h, reason: collision with root package name */
    private final kotlin.reflect.y.internal.j0.k.i f23427h;

    /* compiled from: JavaAnnotationMapper.kt */
    /* loaded from: classes2.dex */
    static final class a extends Lambda implements Function0<Map<f, ? extends g<? extends Object>>> {
        a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Map<f, g<Object>> invoke() {
            g<?> gVar;
            List<? extends b> e2;
            Map<f, g<Object>> i2;
            b b2 = i.this.b();
            if (b2 instanceof e) {
                gVar = d.a.c(((e) i.this.b()).e());
            } else if (b2 instanceof m) {
                d dVar = d.a;
                e2 = t.e(i.this.b());
                gVar = dVar.c(e2);
            } else {
                gVar = null;
            }
            Map<f, g<Object>> f2 = gVar != null ? p0.f(s.a(c.a.d(), gVar)) : null;
            if (f2 != null) {
                return f2;
            }
            i2 = q0.i();
            return i2;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(kotlin.reflect.y.internal.j0.d.a.n0.a aVar, kotlin.reflect.y.internal.j0.d.a.l0.g gVar) {
        super(gVar, aVar, k.a.H);
        kotlin.jvm.internal.m.f(aVar, "annotation");
        kotlin.jvm.internal.m.f(gVar, "c");
        this.f23427h = gVar.e().d(new a());
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.j0.b, kotlin.reflect.jvm.internal.impl.descriptors.n1.c
    public Map<f, g<Object>> a() {
        return (Map) kotlin.reflect.y.internal.j0.k.m.a(this.f23427h, this, f23426g[0]);
    }
}
