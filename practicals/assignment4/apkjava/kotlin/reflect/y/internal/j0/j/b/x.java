package kotlin.reflect.y.internal.j0.j.b;

import kotlin.jvm.internal.m;
import kotlin.reflect.y.internal.j0.e.z.c;
import kotlin.reflect.y.internal.j0.f.b;
import kotlin.reflect.y.internal.j0.f.f;

/* compiled from: NameResolverUtil.kt */
/* loaded from: classes3.dex */
public final class x {
    public static final b a(c cVar, int i2) {
        m.f(cVar, "<this>");
        b f2 = b.f(cVar.a(i2), cVar.b(i2));
        m.e(f2, "fromString(getQualifiedC… isLocalClassName(index))");
        return f2;
    }

    public static final f b(c cVar, int i2) {
        m.f(cVar, "<this>");
        f v = f.v(cVar.getString(i2));
        m.e(v, "guessByFirstCharacter(getString(index))");
        return v;
    }
}
