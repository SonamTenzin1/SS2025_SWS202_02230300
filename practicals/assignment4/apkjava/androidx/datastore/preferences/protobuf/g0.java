package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.a0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: ListFieldSchema.java */
/* loaded from: classes.dex */
abstract class g0 {
    private static final g0 a;

    /* renamed from: b, reason: collision with root package name */
    private static final g0 f1296b;

    /* compiled from: ListFieldSchema.java */
    /* loaded from: classes.dex */
    private static final class b extends g0 {

        /* renamed from: c, reason: collision with root package name */
        private static final Class<?> f1297c = Collections.unmodifiableList(Collections.emptyList()).getClass();

        private b() {
            super();
        }

        static <E> List<E> f(Object obj, long j2) {
            return (List) p1.A(obj, j2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        private static <L> List<L> g(Object obj, long j2, int i2) {
            e0 e0Var;
            List<L> arrayList;
            List<L> f2 = f(obj, j2);
            if (f2.isEmpty()) {
                if (f2 instanceof f0) {
                    arrayList = new e0(i2);
                } else if ((f2 instanceof z0) && (f2 instanceof a0.i)) {
                    arrayList = ((a0.i) f2).J(i2);
                } else {
                    arrayList = new ArrayList<>(i2);
                }
                p1.O(obj, j2, arrayList);
                return arrayList;
            }
            if (f1297c.isAssignableFrom(f2.getClass())) {
                ArrayList arrayList2 = new ArrayList(f2.size() + i2);
                arrayList2.addAll(f2);
                p1.O(obj, j2, arrayList2);
                e0Var = arrayList2;
            } else if (f2 instanceof o1) {
                e0 e0Var2 = new e0(f2.size() + i2);
                e0Var2.addAll((o1) f2);
                p1.O(obj, j2, e0Var2);
                e0Var = e0Var2;
            } else {
                if (!(f2 instanceof z0) || !(f2 instanceof a0.i)) {
                    return f2;
                }
                a0.i iVar = (a0.i) f2;
                if (iVar.l1()) {
                    return f2;
                }
                a0.i J = iVar.J(f2.size() + i2);
                p1.O(obj, j2, J);
                return J;
            }
            return e0Var;
        }

        @Override // androidx.datastore.preferences.protobuf.g0
        void c(Object obj, long j2) {
            Object unmodifiableList;
            List list = (List) p1.A(obj, j2);
            if (list instanceof f0) {
                unmodifiableList = ((f0) list).k();
            } else {
                if (f1297c.isAssignableFrom(list.getClass())) {
                    return;
                }
                if ((list instanceof z0) && (list instanceof a0.i)) {
                    a0.i iVar = (a0.i) list;
                    if (iVar.l1()) {
                        iVar.B();
                        return;
                    }
                    return;
                }
                unmodifiableList = Collections.unmodifiableList(list);
            }
            p1.O(obj, j2, unmodifiableList);
        }

        @Override // androidx.datastore.preferences.protobuf.g0
        <E> void d(Object obj, Object obj2, long j2) {
            List f2 = f(obj2, j2);
            List g2 = g(obj, j2, f2.size());
            int size = g2.size();
            int size2 = f2.size();
            if (size > 0 && size2 > 0) {
                g2.addAll(f2);
            }
            if (size > 0) {
                f2 = g2;
            }
            p1.O(obj, j2, f2);
        }

        @Override // androidx.datastore.preferences.protobuf.g0
        <L> List<L> e(Object obj, long j2) {
            return g(obj, j2, 10);
        }
    }

    /* compiled from: ListFieldSchema.java */
    /* loaded from: classes.dex */
    private static final class c extends g0 {
        private c() {
            super();
        }

        static <E> a0.i<E> f(Object obj, long j2) {
            return (a0.i) p1.A(obj, j2);
        }

        @Override // androidx.datastore.preferences.protobuf.g0
        void c(Object obj, long j2) {
            f(obj, j2).B();
        }

        @Override // androidx.datastore.preferences.protobuf.g0
        <E> void d(Object obj, Object obj2, long j2) {
            a0.i f2 = f(obj, j2);
            a0.i f3 = f(obj2, j2);
            int size = f2.size();
            int size2 = f3.size();
            if (size > 0 && size2 > 0) {
                if (!f2.l1()) {
                    f2 = f2.J(size2 + size);
                }
                f2.addAll(f3);
            }
            if (size > 0) {
                f3 = f2;
            }
            p1.O(obj, j2, f3);
        }

        @Override // androidx.datastore.preferences.protobuf.g0
        <L> List<L> e(Object obj, long j2) {
            a0.i f2 = f(obj, j2);
            if (f2.l1()) {
                return f2;
            }
            int size = f2.size();
            a0.i J = f2.J(size == 0 ? 10 : size * 2);
            p1.O(obj, j2, J);
            return J;
        }
    }

    static {
        a = new b();
        f1296b = new c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static g0 a() {
        return a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static g0 b() {
        return f1296b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void c(Object obj, long j2);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract <L> void d(Object obj, Object obj2, long j2);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract <L> List<L> e(Object obj, long j2);

    private g0() {
    }
}
