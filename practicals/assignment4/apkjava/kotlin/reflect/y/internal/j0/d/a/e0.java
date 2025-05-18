package kotlin.reflect.y.internal.j0.d.a;

import java.util.List;
import kotlin.collections.u;
import kotlin.jvm.internal.m;
import kotlin.reflect.y.internal.j0.f.f;
import kotlin.reflect.y.internal.j0.m.u.a;
import kotlin.text.v;

/* compiled from: propertiesConventionUtil.kt */
/* loaded from: classes2.dex */
public final class e0 {
    public static final List<f> a(f fVar) {
        List<f> n;
        m.f(fVar, "name");
        String k2 = fVar.k();
        m.e(k2, "name.asString()");
        if (z.c(k2)) {
            n = u.n(b(fVar));
            return n;
        }
        if (z.d(k2)) {
            return f(fVar);
        }
        return g.a.b(fVar);
    }

    public static final f b(f fVar) {
        m.f(fVar, "methodName");
        f e2 = e(fVar, "get", false, null, 12, null);
        return e2 == null ? e(fVar, "is", false, null, 8, null) : e2;
    }

    public static final f c(f fVar, boolean z) {
        m.f(fVar, "methodName");
        return e(fVar, "set", false, z ? "is" : null, 4, null);
    }

    private static final f d(f fVar, String str, boolean z, String str2) {
        boolean E;
        String m0;
        String m02;
        if (fVar.y()) {
            return null;
        }
        String u = fVar.u();
        m.e(u, "methodName.identifier");
        boolean z2 = false;
        E = kotlin.text.u.E(u, str, false, 2, null);
        if (!E || u.length() == str.length()) {
            return null;
        }
        char charAt = u.charAt(str.length());
        if ('a' <= charAt && charAt < '{') {
            z2 = true;
        }
        if (z2) {
            return null;
        }
        if (str2 != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(str2);
            m02 = v.m0(u, str);
            sb.append(m02);
            return f.x(sb.toString());
        }
        if (!z) {
            return fVar;
        }
        m0 = v.m0(u, str);
        String c2 = a.c(m0, true);
        if (f.A(c2)) {
            return f.x(c2);
        }
        return null;
    }

    static /* synthetic */ f e(f fVar, String str, boolean z, String str2, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            z = true;
        }
        if ((i2 & 8) != 0) {
            str2 = null;
        }
        return d(fVar, str, z, str2);
    }

    public static final List<f> f(f fVar) {
        List<f> o;
        m.f(fVar, "methodName");
        o = u.o(c(fVar, false), c(fVar, true));
        return o;
    }
}
