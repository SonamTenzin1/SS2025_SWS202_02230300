package kotlin.reflect.y.internal.j0.k;

import kotlin.reflect.KProperty;

/* compiled from: storage.kt */
/* loaded from: classes3.dex */
public final class m {
    public static final <T> T a(i<? extends T> iVar, Object obj, KProperty<?> kProperty) {
        kotlin.jvm.internal.m.f(iVar, "<this>");
        kotlin.jvm.internal.m.f(kProperty, "p");
        return iVar.invoke();
    }

    public static final <T> T b(j<? extends T> jVar, Object obj, KProperty<?> kProperty) {
        kotlin.jvm.internal.m.f(jVar, "<this>");
        kotlin.jvm.internal.m.f(kProperty, "p");
        return jVar.invoke();
    }
}
