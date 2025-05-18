package c.l.b.i;

import java.util.Map;
import kotlin.collections.q0;
import kotlin.jvm.internal.m;

/* compiled from: Preferences.kt */
/* loaded from: classes.dex */
public abstract class d {

    /* compiled from: Preferences.kt */
    /* loaded from: classes.dex */
    public static final class a<T> {
        private final String a;

        public a(String str) {
            m.f(str, "name");
            this.a = str;
        }

        public final String a() {
            return this.a;
        }

        public boolean equals(Object obj) {
            if (obj instanceof a) {
                return m.a(this.a, ((a) obj).a);
            }
            return false;
        }

        public int hashCode() {
            return this.a.hashCode();
        }

        public String toString() {
            return this.a;
        }
    }

    /* compiled from: Preferences.kt */
    /* loaded from: classes.dex */
    public static final class b<T> {
        private final a<T> a;

        /* renamed from: b, reason: collision with root package name */
        private final T f3332b;

        public final a<T> a() {
            return this.a;
        }

        public final T b() {
            return this.f3332b;
        }
    }

    public abstract Map<a<?>, Object> a();

    public abstract <T> T b(a<T> aVar);

    public final c.l.b.i.a c() {
        Map u;
        u = q0.u(a());
        return new c.l.b.i.a(u, false);
    }

    public final d d() {
        Map u;
        u = q0.u(a());
        return new c.l.b.i.a(u, true);
    }
}
