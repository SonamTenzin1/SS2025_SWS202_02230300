package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.c0;
import androidx.datastore.preferences.protobuf.r1;
import androidx.datastore.preferences.protobuf.u;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

/* compiled from: MessageSetSchema.java */
/* loaded from: classes.dex */
final class u0<T> implements f1<T> {
    private final q0 a;

    /* renamed from: b, reason: collision with root package name */
    private final l1<?, ?> f1427b;

    /* renamed from: c, reason: collision with root package name */
    private final boolean f1428c;

    /* renamed from: d, reason: collision with root package name */
    private final q<?> f1429d;

    private u0(l1<?, ?> l1Var, q<?> qVar, q0 q0Var) {
        this.f1427b = l1Var;
        this.f1428c = qVar.e(q0Var);
        this.f1429d = qVar;
        this.a = q0Var;
    }

    private <UT, UB> int j(l1<UT, UB> l1Var, T t) {
        return l1Var.i(l1Var.g(t));
    }

    private <UT, UB, ET extends u.b<ET>> void k(l1<UT, UB> l1Var, q<ET> qVar, T t, e1 e1Var, p pVar) throws IOException {
        UB f2 = l1Var.f(t);
        u<ET> d2 = qVar.d(t);
        do {
            try {
                if (e1Var.A() == Integer.MAX_VALUE) {
                    return;
                }
            } finally {
                l1Var.o(t, f2);
            }
        } while (m(e1Var, pVar, qVar, d2, l1Var, f2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> u0<T> l(l1<?, ?> l1Var, q<?> qVar, q0 q0Var) {
        return new u0<>(l1Var, qVar, q0Var);
    }

    private <UT, UB, ET extends u.b<ET>> boolean m(e1 e1Var, p pVar, q<ET> qVar, u<ET> uVar, l1<UT, UB> l1Var, UB ub) throws IOException {
        int tag = e1Var.getTag();
        if (tag != r1.a) {
            if (r1.b(tag) == 2) {
                Object b2 = qVar.b(pVar, this.a, r1.a(tag));
                if (b2 != null) {
                    qVar.h(e1Var, b2, pVar, uVar);
                    return true;
                }
                return l1Var.m(ub, e1Var);
            }
            return e1Var.G();
        }
        int i2 = 0;
        Object obj = null;
        h hVar = null;
        while (e1Var.A() != Integer.MAX_VALUE) {
            int tag2 = e1Var.getTag();
            if (tag2 == r1.f1395c) {
                i2 = e1Var.p();
                obj = qVar.b(pVar, this.a, i2);
            } else if (tag2 == r1.f1396d) {
                if (obj != null) {
                    qVar.h(e1Var, obj, pVar, uVar);
                } else {
                    hVar = e1Var.C();
                }
            } else if (!e1Var.G()) {
                break;
            }
        }
        if (e1Var.getTag() != r1.f1394b) {
            throw InvalidProtocolBufferException.a();
        }
        if (hVar != null) {
            if (obj != null) {
                qVar.i(hVar, obj, pVar, uVar);
            } else {
                l1Var.d(ub, i2, hVar);
            }
        }
        return true;
    }

    private <UT, UB> void n(l1<UT, UB> l1Var, T t, s1 s1Var) throws IOException {
        l1Var.s(l1Var.g(t), s1Var);
    }

    @Override // androidx.datastore.preferences.protobuf.f1
    public void a(T t, T t2) {
        h1.G(this.f1427b, t, t2);
        if (this.f1428c) {
            h1.E(this.f1429d, t, t2);
        }
    }

    @Override // androidx.datastore.preferences.protobuf.f1
    public boolean b(T t, T t2) {
        if (!this.f1427b.g(t).equals(this.f1427b.g(t2))) {
            return false;
        }
        if (this.f1428c) {
            return this.f1429d.c(t).equals(this.f1429d.c(t2));
        }
        return true;
    }

    @Override // androidx.datastore.preferences.protobuf.f1
    public T c() {
        return (T) this.a.f().J0();
    }

    @Override // androidx.datastore.preferences.protobuf.f1
    public int d(T t) {
        int hashCode = this.f1427b.g(t).hashCode();
        return this.f1428c ? (hashCode * 53) + this.f1429d.c(t).hashCode() : hashCode;
    }

    @Override // androidx.datastore.preferences.protobuf.f1
    public void e(T t, e1 e1Var, p pVar) throws IOException {
        k(this.f1427b, this.f1429d, t, e1Var, pVar);
    }

    @Override // androidx.datastore.preferences.protobuf.f1
    public void f(T t) {
        this.f1427b.j(t);
        this.f1429d.f(t);
    }

    @Override // androidx.datastore.preferences.protobuf.f1
    public final boolean g(T t) {
        return this.f1429d.c(t).p();
    }

    @Override // androidx.datastore.preferences.protobuf.f1
    public void h(T t, s1 s1Var) throws IOException {
        Iterator<Map.Entry<?, Object>> s = this.f1429d.c(t).s();
        while (s.hasNext()) {
            Map.Entry<?, Object> next = s.next();
            u.b bVar = (u.b) next.getKey();
            if (bVar.l() == r1.c.MESSAGE && !bVar.h() && !bVar.m()) {
                if (next instanceof c0.b) {
                    s1Var.c(bVar.f(), ((c0.b) next).a().e());
                } else {
                    s1Var.c(bVar.f(), next.getValue());
                }
            } else {
                throw new IllegalStateException("Found invalid MessageSet item.");
            }
        }
        n(this.f1427b, t, s1Var);
    }

    @Override // androidx.datastore.preferences.protobuf.f1
    public int i(T t) {
        int j2 = j(this.f1427b, t) + 0;
        return this.f1428c ? j2 + this.f1429d.c(t).j() : j2;
    }
}
