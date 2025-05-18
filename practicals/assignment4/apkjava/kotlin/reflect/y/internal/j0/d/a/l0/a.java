package kotlin.reflect.y.internal.j0.d.a.l0;

import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.i;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.g;
import kotlin.reflect.jvm.internal.impl.descriptors.m;
import kotlin.reflect.y.internal.j0.d.a.n0.z;
import kotlin.reflect.y.internal.j0.d.a.x;

/* compiled from: context.kt */
/* loaded from: classes2.dex */
public final class a {

    /* compiled from: context.kt */
    /* renamed from: kotlin.f0.y.e.j0.d.a.l0.a$a */
    /* loaded from: classes2.dex */
    public static final class C0330a extends Lambda implements Function0<x> {

        /* renamed from: f */
        final /* synthetic */ g f23444f;

        /* renamed from: g */
        final /* synthetic */ g f23445g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C0330a(g gVar, g gVar2) {
            super(0);
            this.f23444f = gVar;
            this.f23445g = gVar2;
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: b */
        public final x invoke() {
            return a.g(this.f23444f, this.f23445g.getAnnotations());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: context.kt */
    /* loaded from: classes2.dex */
    public static final class b extends Lambda implements Function0<x> {

        /* renamed from: f */
        final /* synthetic */ g f23446f;

        /* renamed from: g */
        final /* synthetic */ kotlin.reflect.jvm.internal.impl.descriptors.n1.g f23447g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(g gVar, kotlin.reflect.jvm.internal.impl.descriptors.n1.g gVar2) {
            super(0);
            this.f23446f = gVar;
            this.f23447g = gVar2;
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: b */
        public final x invoke() {
            return a.g(this.f23446f, this.f23447g);
        }
    }

    private static final g a(g gVar, m mVar, z zVar, int i2, Lazy<x> lazy) {
        k f2;
        kotlin.reflect.y.internal.j0.d.a.l0.b a = gVar.a();
        if (zVar != null) {
            f2 = new h(gVar, mVar, zVar, i2);
        } else {
            f2 = gVar.f();
        }
        return new g(a, f2, lazy);
    }

    public static final g b(g gVar, k kVar) {
        kotlin.jvm.internal.m.f(gVar, "<this>");
        kotlin.jvm.internal.m.f(kVar, "typeParameterResolver");
        return new g(gVar.a(), kVar, gVar.c());
    }

    public static final g c(g gVar, g gVar2, z zVar, int i2) {
        Lazy a;
        kotlin.jvm.internal.m.f(gVar, "<this>");
        kotlin.jvm.internal.m.f(gVar2, "containingDeclaration");
        a = i.a(LazyThreadSafetyMode.NONE, new C0330a(gVar, gVar2));
        return a(gVar, gVar2, zVar, i2, a);
    }

    public static /* synthetic */ g d(g gVar, g gVar2, z zVar, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            zVar = null;
        }
        if ((i3 & 4) != 0) {
            i2 = 0;
        }
        return c(gVar, gVar2, zVar, i2);
    }

    public static final g e(g gVar, m mVar, z zVar, int i2) {
        kotlin.jvm.internal.m.f(gVar, "<this>");
        kotlin.jvm.internal.m.f(mVar, "containingDeclaration");
        kotlin.jvm.internal.m.f(zVar, "typeParameterOwner");
        return a(gVar, mVar, zVar, i2, gVar.c());
    }

    public static /* synthetic */ g f(g gVar, m mVar, z zVar, int i2, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            i2 = 0;
        }
        return e(gVar, mVar, zVar, i2);
    }

    public static final x g(g gVar, kotlin.reflect.jvm.internal.impl.descriptors.n1.g gVar2) {
        kotlin.jvm.internal.m.f(gVar, "<this>");
        kotlin.jvm.internal.m.f(gVar2, "additionalAnnotations");
        return gVar.a().a().c(gVar.b(), gVar2);
    }

    public static final g h(g gVar, kotlin.reflect.jvm.internal.impl.descriptors.n1.g gVar2) {
        Lazy a;
        kotlin.jvm.internal.m.f(gVar, "<this>");
        kotlin.jvm.internal.m.f(gVar2, "additionalAnnotations");
        if (gVar2.isEmpty()) {
            return gVar;
        }
        kotlin.reflect.y.internal.j0.d.a.l0.b a2 = gVar.a();
        k f2 = gVar.f();
        a = i.a(LazyThreadSafetyMode.NONE, new b(gVar, gVar2));
        return new g(a2, f2, a);
    }

    public static final g i(g gVar, kotlin.reflect.y.internal.j0.d.a.l0.b bVar) {
        kotlin.jvm.internal.m.f(gVar, "<this>");
        kotlin.jvm.internal.m.f(bVar, "components");
        return new g(bVar, gVar.f(), gVar.c());
    }
}
