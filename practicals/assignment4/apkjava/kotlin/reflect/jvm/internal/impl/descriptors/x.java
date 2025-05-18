package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.KDeclarationContainer;
import kotlin.sequences.Sequence;

/* compiled from: findClassInModule.kt */
/* loaded from: classes2.dex */
public final class x {

    /* compiled from: findClassInModule.kt */
    /* loaded from: classes2.dex */
    /* synthetic */ class a extends kotlin.jvm.internal.i implements Function1<kotlin.reflect.y.internal.j0.f.b, kotlin.reflect.y.internal.j0.f.b> {

        /* renamed from: h, reason: collision with root package name */
        public static final a f25375h = new a();

        a() {
            super(1);
        }

        @Override // kotlin.jvm.internal.c, kotlin.reflect.KCallable
        /* renamed from: getName */
        public final String getM() {
            return "getOuterClassId";
        }

        @Override // kotlin.jvm.internal.c
        public final KDeclarationContainer getOwner() {
            return kotlin.jvm.internal.g0.b(kotlin.reflect.y.internal.j0.f.b.class);
        }

        @Override // kotlin.jvm.internal.c
        public final String getSignature() {
            return "getOuterClassId()Lorg/jetbrains/kotlin/name/ClassId;";
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: u, reason: merged with bridge method [inline-methods] */
        public final kotlin.reflect.y.internal.j0.f.b invoke(kotlin.reflect.y.internal.j0.f.b bVar) {
            kotlin.jvm.internal.m.f(bVar, "p0");
            return bVar.g();
        }
    }

    /* compiled from: findClassInModule.kt */
    /* loaded from: classes2.dex */
    static final class b extends Lambda implements Function1<kotlin.reflect.y.internal.j0.f.b, Integer> {

        /* renamed from: f, reason: collision with root package name */
        public static final b f25376f = new b();

        b() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Integer invoke(kotlin.reflect.y.internal.j0.f.b bVar) {
            kotlin.jvm.internal.m.f(bVar, "it");
            return 0;
        }
    }

    public static final e a(g0 g0Var, kotlin.reflect.y.internal.j0.f.b bVar) {
        kotlin.jvm.internal.m.f(g0Var, "<this>");
        kotlin.jvm.internal.m.f(bVar, "classId");
        h b2 = b(g0Var, bVar);
        if (b2 instanceof e) {
            return (e) b2;
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x014b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final h b(g0 g0Var, kotlin.reflect.y.internal.j0.f.b bVar) {
        h f2;
        kotlin.jvm.internal.m.f(g0Var, "<this>");
        kotlin.jvm.internal.m.f(bVar, "classId");
        g0 a2 = kotlin.reflect.y.internal.j0.i.n.a(g0Var);
        if (a2 == null) {
            kotlin.reflect.y.internal.j0.f.c h2 = bVar.h();
            kotlin.jvm.internal.m.e(h2, "classId.packageFqName");
            p0 N = g0Var.N(h2);
            List<kotlin.reflect.y.internal.j0.f.f> f3 = bVar.i().f();
            kotlin.jvm.internal.m.e(f3, "classId.relativeClassName.pathSegments()");
            kotlin.reflect.y.internal.j0.i.w.h q = N.q();
            Object U = kotlin.collections.s.U(f3);
            kotlin.jvm.internal.m.e(U, "segments.first()");
            f2 = q.f((kotlin.reflect.y.internal.j0.f.f) U, kotlin.reflect.y.internal.j0.c.b.d.FROM_DESERIALIZATION);
            if (f2 == null) {
                return null;
            }
            for (kotlin.reflect.y.internal.j0.f.f fVar : f3.subList(1, f3.size())) {
                if (!(f2 instanceof e)) {
                    return null;
                }
                kotlin.reflect.y.internal.j0.i.w.h y0 = ((e) f2).y0();
                kotlin.jvm.internal.m.e(fVar, "name");
                h f4 = y0.f(fVar, kotlin.reflect.y.internal.j0.c.b.d.FROM_DESERIALIZATION);
                f2 = f4 instanceof e ? (e) f4 : null;
                if (f2 == null) {
                    return null;
                }
            }
        } else {
            kotlin.reflect.y.internal.j0.f.c h3 = bVar.h();
            kotlin.jvm.internal.m.e(h3, "classId.packageFqName");
            p0 N2 = a2.N(h3);
            List<kotlin.reflect.y.internal.j0.f.f> f5 = bVar.i().f();
            kotlin.jvm.internal.m.e(f5, "classId.relativeClassName.pathSegments()");
            kotlin.reflect.y.internal.j0.i.w.h q2 = N2.q();
            Object U2 = kotlin.collections.s.U(f5);
            kotlin.jvm.internal.m.e(U2, "segments.first()");
            h f6 = q2.f((kotlin.reflect.y.internal.j0.f.f) U2, kotlin.reflect.y.internal.j0.c.b.d.FROM_DESERIALIZATION);
            if (f6 != null) {
                for (kotlin.reflect.y.internal.j0.f.f fVar2 : f5.subList(1, f5.size())) {
                    if (f6 instanceof e) {
                        kotlin.reflect.y.internal.j0.i.w.h y02 = ((e) f6).y0();
                        kotlin.jvm.internal.m.e(fVar2, "name");
                        h f7 = y02.f(fVar2, kotlin.reflect.y.internal.j0.c.b.d.FROM_DESERIALIZATION);
                        f6 = f7 instanceof e ? (e) f7 : null;
                        if (f6 != null) {
                        }
                    }
                }
                if (f6 == null) {
                    return f6;
                }
                kotlin.reflect.y.internal.j0.f.c h4 = bVar.h();
                kotlin.jvm.internal.m.e(h4, "classId.packageFqName");
                p0 N3 = g0Var.N(h4);
                List<kotlin.reflect.y.internal.j0.f.f> f8 = bVar.i().f();
                kotlin.jvm.internal.m.e(f8, "classId.relativeClassName.pathSegments()");
                kotlin.reflect.y.internal.j0.i.w.h q3 = N3.q();
                Object U3 = kotlin.collections.s.U(f8);
                kotlin.jvm.internal.m.e(U3, "segments.first()");
                f2 = q3.f((kotlin.reflect.y.internal.j0.f.f) U3, kotlin.reflect.y.internal.j0.c.b.d.FROM_DESERIALIZATION);
                if (f2 == null) {
                    return null;
                }
                for (kotlin.reflect.y.internal.j0.f.f fVar3 : f8.subList(1, f8.size())) {
                    if (!(f2 instanceof e)) {
                        return null;
                    }
                    kotlin.reflect.y.internal.j0.i.w.h y03 = ((e) f2).y0();
                    kotlin.jvm.internal.m.e(fVar3, "name");
                    h f9 = y03.f(fVar3, kotlin.reflect.y.internal.j0.c.b.d.FROM_DESERIALIZATION);
                    f2 = f9 instanceof e ? (e) f9 : null;
                    if (f2 == null) {
                        return null;
                    }
                }
            }
            f6 = null;
            if (f6 == null) {
            }
        }
        return f2;
    }

    public static final e c(g0 g0Var, kotlin.reflect.y.internal.j0.f.b bVar, j0 j0Var) {
        Sequence f2;
        Sequence u;
        List<Integer> A;
        kotlin.jvm.internal.m.f(g0Var, "<this>");
        kotlin.jvm.internal.m.f(bVar, "classId");
        kotlin.jvm.internal.m.f(j0Var, "notFoundClasses");
        e a2 = a(g0Var, bVar);
        if (a2 != null) {
            return a2;
        }
        f2 = kotlin.sequences.l.f(bVar, a.f25375h);
        u = kotlin.sequences.n.u(f2, b.f25376f);
        A = kotlin.sequences.n.A(u);
        return j0Var.d(bVar, A);
    }

    public static final d1 d(g0 g0Var, kotlin.reflect.y.internal.j0.f.b bVar) {
        kotlin.jvm.internal.m.f(g0Var, "<this>");
        kotlin.jvm.internal.m.f(bVar, "classId");
        h b2 = b(g0Var, bVar);
        if (b2 instanceof d1) {
            return (d1) b2;
        }
        return null;
    }
}
