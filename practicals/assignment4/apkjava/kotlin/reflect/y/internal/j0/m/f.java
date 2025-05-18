package kotlin.reflect.y.internal.j0.m;

import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.descriptors.y;

/* compiled from: modifierChecks.kt */
/* loaded from: classes3.dex */
public interface f {

    /* compiled from: modifierChecks.kt */
    /* loaded from: classes3.dex */
    public static final class a {
        public static String a(f fVar, y yVar) {
            m.f(yVar, "functionDescriptor");
            if (fVar.b(yVar)) {
                return null;
            }
            return fVar.getDescription();
        }
    }

    String a(y yVar);

    boolean b(y yVar);

    String getDescription();
}
