package kotlin.reflect.jvm.internal.impl.descriptors.r1.a;

import kotlin.text.u;

/* compiled from: ReflectKotlinClassFinder.kt */
/* loaded from: classes2.dex */
public final class h {
    /* JADX INFO: Access modifiers changed from: private */
    public static final String b(kotlin.reflect.y.internal.j0.f.b bVar) {
        String z;
        String b2 = bVar.i().b();
        kotlin.jvm.internal.m.e(b2, "relativeClassName.asString()");
        z = u.z(b2, '.', '$', false, 4, null);
        if (bVar.h().d()) {
            return z;
        }
        return bVar.h() + '.' + z;
    }
}
