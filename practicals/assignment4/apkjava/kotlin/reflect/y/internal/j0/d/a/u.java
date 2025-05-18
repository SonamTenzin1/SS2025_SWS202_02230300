package kotlin.reflect.y.internal.j0.d.a;

import java.util.Map;
import kotlin.KotlinVersion;
import kotlin.collections.q0;
import kotlin.jvm.internal.m;
import kotlin.reflect.y.internal.j0.d.a.v;
import kotlin.reflect.y.internal.j0.f.c;
import kotlin.s;

/* compiled from: JavaNullabilityAnnotationSettings.kt */
/* loaded from: classes2.dex */
public final class u {
    private static final c a;

    /* renamed from: b, reason: collision with root package name */
    private static final c f23688b;

    /* renamed from: c, reason: collision with root package name */
    private static final c0<v> f23689c;

    /* renamed from: d, reason: collision with root package name */
    private static final v f23690d;

    static {
        Map l;
        c cVar = new c("org.jspecify.nullness");
        a = cVar;
        c cVar2 = new c("org.checkerframework.checker.nullness.compatqual");
        f23688b = cVar2;
        c cVar3 = new c("org.jetbrains.annotations");
        v.a aVar = v.a;
        c cVar4 = new c("androidx.annotation.RecentlyNullable");
        f0 f0Var = f0.WARN;
        KotlinVersion kotlinVersion = new KotlinVersion(1, 8);
        f0 f0Var2 = f0.STRICT;
        l = q0.l(s.a(cVar3, aVar.a()), s.a(new c("androidx.annotation"), aVar.a()), s.a(new c("android.support.annotation"), aVar.a()), s.a(new c("android.annotation"), aVar.a()), s.a(new c("com.android.annotations"), aVar.a()), s.a(new c("org.eclipse.jdt.annotation"), aVar.a()), s.a(new c("org.checkerframework.checker.nullness.qual"), aVar.a()), s.a(cVar2, aVar.a()), s.a(new c("javax.annotation"), aVar.a()), s.a(new c("edu.umd.cs.findbugs.annotations"), aVar.a()), s.a(new c("io.reactivex.annotations"), aVar.a()), s.a(cVar4, new v(f0Var, null, null, 4, null)), s.a(new c("androidx.annotation.RecentlyNonNull"), new v(f0Var, null, null, 4, null)), s.a(new c("lombok"), aVar.a()), s.a(cVar, new v(f0Var, kotlinVersion, f0Var2)), s.a(new c("io.reactivex.rxjava3.annotations"), new v(f0Var, new KotlinVersion(1, 8), f0Var2)));
        f23689c = new d0(l);
        f23690d = new v(f0Var, null, null, 4, null);
    }

    public static final y a(KotlinVersion kotlinVersion) {
        f0 c2;
        m.f(kotlinVersion, "configuredKotlinVersion");
        v vVar = f23690d;
        if (vVar.d() != null && vVar.d().compareTo(kotlinVersion) <= 0) {
            c2 = vVar.b();
        } else {
            c2 = vVar.c();
        }
        f0 f0Var = c2;
        return new y(f0Var, c(f0Var), null, 4, null);
    }

    public static /* synthetic */ y b(KotlinVersion kotlinVersion, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            kotlinVersion = KotlinVersion.f22956g;
        }
        return a(kotlinVersion);
    }

    public static final f0 c(f0 f0Var) {
        m.f(f0Var, "globalReportLevel");
        if (f0Var == f0.WARN) {
            return null;
        }
        return f0Var;
    }

    public static final f0 d(c cVar) {
        m.f(cVar, "annotationFqName");
        return g(cVar, c0.a.a(), null, 4, null);
    }

    public static final c e() {
        return a;
    }

    public static final f0 f(c cVar, c0<? extends f0> c0Var, KotlinVersion kotlinVersion) {
        m.f(cVar, "annotation");
        m.f(c0Var, "configuredReportLevels");
        m.f(kotlinVersion, "configuredKotlinVersion");
        f0 a2 = c0Var.a(cVar);
        if (a2 != null) {
            return a2;
        }
        v a3 = f23689c.a(cVar);
        if (a3 == null) {
            return f0.IGNORE;
        }
        if (a3.d() != null && a3.d().compareTo(kotlinVersion) <= 0) {
            return a3.b();
        }
        return a3.c();
    }

    public static /* synthetic */ f0 g(c cVar, c0 c0Var, KotlinVersion kotlinVersion, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            kotlinVersion = new KotlinVersion(1, 7, 0);
        }
        return f(cVar, c0Var, kotlinVersion);
    }
}
