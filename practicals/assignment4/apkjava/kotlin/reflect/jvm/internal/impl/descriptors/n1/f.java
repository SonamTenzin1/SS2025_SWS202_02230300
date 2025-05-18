package kotlin.reflect.jvm.internal.impl.descriptors.n1;

import java.util.List;
import java.util.Map;
import kotlin.collections.q0;
import kotlin.collections.u;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.g0;
import kotlin.reflect.y.internal.j0.b.k;
import kotlin.reflect.y.internal.j0.i.r.v;
import kotlin.reflect.y.internal.j0.l.e0;
import kotlin.reflect.y.internal.j0.l.m0;
import kotlin.reflect.y.internal.j0.l.r1;
import kotlin.s;
import okhttp3.HttpUrl;

/* compiled from: annotationUtil.kt */
/* loaded from: classes2.dex */
public final class f {
    private static final kotlin.reflect.y.internal.j0.f.f a;

    /* renamed from: b, reason: collision with root package name */
    private static final kotlin.reflect.y.internal.j0.f.f f25174b;

    /* renamed from: c, reason: collision with root package name */
    private static final kotlin.reflect.y.internal.j0.f.f f25175c;

    /* renamed from: d, reason: collision with root package name */
    private static final kotlin.reflect.y.internal.j0.f.f f25176d;

    /* renamed from: e, reason: collision with root package name */
    private static final kotlin.reflect.y.internal.j0.f.f f25177e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: annotationUtil.kt */
    /* loaded from: classes2.dex */
    public static final class a extends Lambda implements Function1<g0, e0> {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ kotlin.reflect.y.internal.j0.b.h f25178f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(kotlin.reflect.y.internal.j0.b.h hVar) {
            super(1);
            this.f25178f = hVar;
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final e0 invoke(g0 g0Var) {
            kotlin.jvm.internal.m.f(g0Var, "module");
            m0 l = g0Var.o().l(r1.INVARIANT, this.f25178f.W());
            kotlin.jvm.internal.m.e(l, "module.builtIns.getArray…ce.INVARIANT, stringType)");
            return l;
        }
    }

    static {
        kotlin.reflect.y.internal.j0.f.f x = kotlin.reflect.y.internal.j0.f.f.x("message");
        kotlin.jvm.internal.m.e(x, "identifier(\"message\")");
        a = x;
        kotlin.reflect.y.internal.j0.f.f x2 = kotlin.reflect.y.internal.j0.f.f.x("replaceWith");
        kotlin.jvm.internal.m.e(x2, "identifier(\"replaceWith\")");
        f25174b = x2;
        kotlin.reflect.y.internal.j0.f.f x3 = kotlin.reflect.y.internal.j0.f.f.x("level");
        kotlin.jvm.internal.m.e(x3, "identifier(\"level\")");
        f25175c = x3;
        kotlin.reflect.y.internal.j0.f.f x4 = kotlin.reflect.y.internal.j0.f.f.x("expression");
        kotlin.jvm.internal.m.e(x4, "identifier(\"expression\")");
        f25176d = x4;
        kotlin.reflect.y.internal.j0.f.f x5 = kotlin.reflect.y.internal.j0.f.f.x("imports");
        kotlin.jvm.internal.m.e(x5, "identifier(\"imports\")");
        f25177e = x5;
    }

    public static final c a(kotlin.reflect.y.internal.j0.b.h hVar, String str, String str2, String str3) {
        List j2;
        Map l;
        Map l2;
        kotlin.jvm.internal.m.f(hVar, "<this>");
        kotlin.jvm.internal.m.f(str, "message");
        kotlin.jvm.internal.m.f(str2, "replaceWith");
        kotlin.jvm.internal.m.f(str3, "level");
        kotlin.reflect.y.internal.j0.f.c cVar = k.a.B;
        kotlin.reflect.y.internal.j0.f.f fVar = f25177e;
        j2 = u.j();
        l = q0.l(s.a(f25176d, new v(str2)), s.a(fVar, new kotlin.reflect.y.internal.j0.i.r.b(j2, new a(hVar))));
        j jVar = new j(hVar, cVar, l);
        kotlin.reflect.y.internal.j0.f.c cVar2 = k.a.y;
        kotlin.reflect.y.internal.j0.f.f fVar2 = f25175c;
        kotlin.reflect.y.internal.j0.f.b m = kotlin.reflect.y.internal.j0.f.b.m(k.a.A);
        kotlin.jvm.internal.m.e(m, "topLevel(StandardNames.FqNames.deprecationLevel)");
        kotlin.reflect.y.internal.j0.f.f x = kotlin.reflect.y.internal.j0.f.f.x(str3);
        kotlin.jvm.internal.m.e(x, "identifier(level)");
        l2 = q0.l(s.a(a, new v(str)), s.a(f25174b, new kotlin.reflect.y.internal.j0.i.r.a(jVar)), s.a(fVar2, new kotlin.reflect.y.internal.j0.i.r.j(m, x)));
        return new j(hVar, cVar2, l2);
    }

    public static /* synthetic */ c b(kotlin.reflect.y.internal.j0.b.h hVar, String str, String str2, String str3, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str2 = HttpUrl.FRAGMENT_ENCODE_SET;
        }
        if ((i2 & 4) != 0) {
            str3 = "WARNING";
        }
        return a(hVar, str, str2, str3);
    }
}
