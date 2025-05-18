package kotlin.reflect.y.internal.j0.d.a;

import kotlin.jvm.internal.m;
import kotlin.reflect.y.internal.j0.f.c;
import kotlin.reflect.y.internal.j0.f.d;
import kotlin.reflect.y.internal.j0.f.f;

/* compiled from: BuiltinSpecialProperties.kt */
/* loaded from: classes2.dex */
public final class h {
    /* JADX INFO: Access modifiers changed from: private */
    public static final c c(c cVar, String str) {
        c c2 = cVar.c(f.x(str));
        m.e(c2, "child(Name.identifier(name))");
        return c2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final c d(d dVar, String str) {
        c l = dVar.c(f.x(str)).l();
        m.e(l, "child(Name.identifier(name)).toSafe()");
        return l;
    }
}
