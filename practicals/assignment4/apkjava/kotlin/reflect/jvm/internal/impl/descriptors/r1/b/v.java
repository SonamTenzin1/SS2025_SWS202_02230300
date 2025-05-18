package kotlin.reflect.jvm.internal.impl.descriptors.r1.b;

import java.lang.reflect.Modifier;
import kotlin.reflect.jvm.internal.impl.descriptors.l1;
import kotlin.reflect.jvm.internal.impl.descriptors.m1;

/* compiled from: ReflectJavaModifierListOwner.kt */
/* loaded from: classes2.dex */
public interface v extends kotlin.reflect.y.internal.j0.d.a.n0.s {

    /* compiled from: ReflectJavaModifierListOwner.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        public static m1 a(v vVar) {
            int E = vVar.E();
            if (Modifier.isPublic(E)) {
                return l1.h.f25160c;
            }
            if (Modifier.isPrivate(E)) {
                return l1.e.f25157c;
            }
            if (Modifier.isProtected(E)) {
                return Modifier.isStatic(E) ? kotlin.reflect.jvm.internal.impl.descriptors.q1.c.f25310c : kotlin.reflect.jvm.internal.impl.descriptors.q1.b.f25309c;
            }
            return kotlin.reflect.jvm.internal.impl.descriptors.q1.a.f25308c;
        }

        public static boolean b(v vVar) {
            return Modifier.isAbstract(vVar.E());
        }

        public static boolean c(v vVar) {
            return Modifier.isFinal(vVar.E());
        }

        public static boolean d(v vVar) {
            return Modifier.isStatic(vVar.E());
        }
    }

    int E();
}
