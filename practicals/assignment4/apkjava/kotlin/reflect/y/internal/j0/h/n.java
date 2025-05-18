package kotlin.reflect.y.internal.j0.h;

import java.util.List;
import kotlin.jvm.internal.m;
import kotlin.reflect.y.internal.j0.f.d;
import kotlin.reflect.y.internal.j0.f.f;

/* compiled from: RenderingUtils.kt */
/* loaded from: classes3.dex */
public final class n {
    public static final String a(d dVar) {
        m.f(dVar, "<this>");
        List<f> h2 = dVar.h();
        m.e(h2, "pathSegments()");
        return c(h2);
    }

    public static final String b(f fVar) {
        m.f(fVar, "<this>");
        if (!d(fVar)) {
            String k2 = fVar.k();
            m.e(k2, "asString()");
            return k2;
        }
        StringBuilder sb = new StringBuilder();
        String k3 = fVar.k();
        m.e(k3, "asString()");
        sb.append('`' + k3);
        sb.append('`');
        return sb.toString();
    }

    public static final String c(List<f> list) {
        m.f(list, "pathSegments");
        StringBuilder sb = new StringBuilder();
        for (f fVar : list) {
            if (sb.length() > 0) {
                sb.append(".");
            }
            sb.append(b(fVar));
        }
        String sb2 = sb.toString();
        m.e(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    private static final boolean d(f fVar) {
        boolean z;
        String k2 = fVar.k();
        m.e(k2, "asString()");
        if (!i.a.contains(k2)) {
            int i2 = 0;
            while (true) {
                if (i2 >= k2.length()) {
                    z = false;
                    break;
                }
                char charAt = k2.charAt(i2);
                if ((Character.isLetterOrDigit(charAt) || charAt == '_') ? false : true) {
                    z = true;
                    break;
                }
                i2++;
            }
            if (!z) {
                return false;
            }
        }
        return true;
    }
}
