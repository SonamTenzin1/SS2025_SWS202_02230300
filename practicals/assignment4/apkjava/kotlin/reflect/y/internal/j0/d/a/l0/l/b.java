package kotlin.reflect.y.internal.j0.d.a.l0.l;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import kotlin.collections.u;
import kotlin.collections.w0;
import kotlin.jvm.internal.m;
import kotlin.reflect.y.internal.j0.d.a.n0.n;
import kotlin.reflect.y.internal.j0.d.a.n0.r;
import kotlin.reflect.y.internal.j0.d.a.n0.w;
import kotlin.reflect.y.internal.j0.f.f;

/* compiled from: DeclaredMemberIndex.kt */
/* loaded from: classes2.dex */
public interface b {

    /* compiled from: DeclaredMemberIndex.kt */
    /* loaded from: classes2.dex */
    public static final class a implements b {
        public static final a a = new a();

        private a() {
        }

        @Override // kotlin.reflect.y.internal.j0.d.a.l0.l.b
        public Set<f> a() {
            Set<f> d2;
            d2 = w0.d();
            return d2;
        }

        @Override // kotlin.reflect.y.internal.j0.d.a.l0.l.b
        public w b(f fVar) {
            m.f(fVar, "name");
            return null;
        }

        @Override // kotlin.reflect.y.internal.j0.d.a.l0.l.b
        public n c(f fVar) {
            m.f(fVar, "name");
            return null;
        }

        @Override // kotlin.reflect.y.internal.j0.d.a.l0.l.b
        public Set<f> d() {
            Set<f> d2;
            d2 = w0.d();
            return d2;
        }

        @Override // kotlin.reflect.y.internal.j0.d.a.l0.l.b
        public Set<f> e() {
            Set<f> d2;
            d2 = w0.d();
            return d2;
        }

        @Override // kotlin.reflect.y.internal.j0.d.a.l0.l.b
        /* renamed from: g, reason: merged with bridge method [inline-methods] */
        public List<r> f(f fVar) {
            List<r> j2;
            m.f(fVar, "name");
            j2 = u.j();
            return j2;
        }
    }

    Set<f> a();

    w b(f fVar);

    n c(f fVar);

    Set<f> d();

    Set<f> e();

    Collection<r> f(f fVar);
}
