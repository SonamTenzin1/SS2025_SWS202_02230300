package kotlin.reflect.y.internal.j0.d.a.j0;

import java.util.Map;
import kotlin.collections.p0;
import kotlin.collections.q0;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.y;
import kotlin.reflect.KProperty;
import kotlin.reflect.y.internal.j0.b.k;
import kotlin.reflect.y.internal.j0.f.f;
import kotlin.reflect.y.internal.j0.i.r.g;
import kotlin.reflect.y.internal.j0.k.i;
import kotlin.s;

/* compiled from: JavaAnnotationMapper.kt */
/* loaded from: classes2.dex */
public final class h extends b {

    /* renamed from: g, reason: collision with root package name */
    static final /* synthetic */ KProperty<Object>[] f23423g = {g0.h(new y(g0.b(h.class), "allValueArguments", "getAllValueArguments()Ljava/util/Map;"))};

    /* renamed from: h, reason: collision with root package name */
    private final i f23424h;

    /* compiled from: JavaAnnotationMapper.kt */
    /* loaded from: classes2.dex */
    static final class a extends Lambda implements Function0<Map<f, ? extends g<?>>> {
        a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Map<f, g<?>> invoke() {
            Map<f, g<?>> i2;
            g<?> a = d.a.a(h.this.b());
            Map<f, g<?>> f2 = a != null ? p0.f(s.a(c.a.c(), a)) : null;
            if (f2 != null) {
                return f2;
            }
            i2 = q0.i();
            return i2;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(kotlin.reflect.y.internal.j0.d.a.n0.a aVar, kotlin.reflect.y.internal.j0.d.a.l0.g gVar) {
        super(gVar, aVar, k.a.L);
        m.f(aVar, "annotation");
        m.f(gVar, "c");
        this.f23424h = gVar.e().d(new a());
    }

    @Override // kotlin.reflect.y.internal.j0.d.a.j0.b, kotlin.reflect.jvm.internal.impl.descriptors.n1.c
    public Map<f, g<?>> a() {
        return (Map) kotlin.reflect.y.internal.j0.k.m.a(this.f23424h, this, f23423g[0]);
    }
}
