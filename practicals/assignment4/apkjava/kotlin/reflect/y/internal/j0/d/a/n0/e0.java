package kotlin.reflect.y.internal.j0.d.a.n0;

import java.util.Iterator;
import kotlin.jvm.internal.m;
import kotlin.reflect.y.internal.j0.f.b;
import kotlin.reflect.y.internal.j0.f.c;

/* compiled from: javaElements.kt */
/* loaded from: classes2.dex */
public interface e0 extends d {

    /* compiled from: javaElements.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        public static kotlin.reflect.y.internal.j0.d.a.n0.a a(e0 e0Var, c cVar) {
            Object obj;
            m.f(cVar, "fqName");
            Iterator<T> it = e0Var.getAnnotations().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                b e2 = ((kotlin.reflect.y.internal.j0.d.a.n0.a) next).e();
                if (m.a(e2 != null ? e2.b() : null, cVar)) {
                    obj = next;
                    break;
                }
            }
            return (kotlin.reflect.y.internal.j0.d.a.n0.a) obj;
        }
    }
}
