package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.r1;
import androidx.datastore.preferences.protobuf.y;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: ExtensionSchemaLite.java */
/* loaded from: classes.dex */
final class r extends q<y.d> {

    /* compiled from: ExtensionSchemaLite.java */
    /* loaded from: classes.dex */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[r1.b.values().length];
            a = iArr;
            try {
                iArr[r1.b.f1397f.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[r1.b.f1398g.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[r1.b.f1399h.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[r1.b.f1400i.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[r1.b.f1401j.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[r1.b.f1402k.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[r1.b.l.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                a[r1.b.m.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                a[r1.b.r.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                a[r1.b.t.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                a[r1.b.u.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                a[r1.b.v.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                a[r1.b.w.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                a[r1.b.s.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                a[r1.b.q.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                a[r1.b.n.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                a[r1.b.o.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                a[r1.b.p.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.datastore.preferences.protobuf.q
    public int a(Map.Entry<?, ?> entry) {
        return ((y.d) entry.getKey()).f();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.datastore.preferences.protobuf.q
    public Object b(p pVar, q0 q0Var, int i2) {
        return pVar.a(q0Var, i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.datastore.preferences.protobuf.q
    public u<y.d> c(Object obj) {
        return ((y.c) obj).extensions;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.datastore.preferences.protobuf.q
    public u<y.d> d(Object obj) {
        return ((y.c) obj).J();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.datastore.preferences.protobuf.q
    public boolean e(q0 q0Var) {
        return q0Var instanceof y.c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.datastore.preferences.protobuf.q
    public void f(Object obj) {
        c(obj).t();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:45:0x0102. Please report as an issue. */
    @Override // androidx.datastore.preferences.protobuf.q
    public <UT, UB> UB g(e1 e1Var, Object obj, p pVar, u<y.d> uVar, UB ub, l1<UT, UB> l1Var) throws IOException {
        Object i2;
        ArrayList arrayList;
        y.e eVar = (y.e) obj;
        int c2 = eVar.c();
        if (eVar.f1456b.h() && eVar.f1456b.m()) {
            switch (a.a[eVar.a().ordinal()]) {
                case 1:
                    arrayList = new ArrayList();
                    e1Var.J(arrayList);
                    break;
                case 2:
                    arrayList = new ArrayList();
                    e1Var.D(arrayList);
                    break;
                case 3:
                    arrayList = new ArrayList();
                    e1Var.q(arrayList);
                    break;
                case 4:
                    arrayList = new ArrayList();
                    e1Var.n(arrayList);
                    break;
                case 5:
                    arrayList = new ArrayList();
                    e1Var.s(arrayList);
                    break;
                case 6:
                    arrayList = new ArrayList();
                    e1Var.N(arrayList);
                    break;
                case 7:
                    arrayList = new ArrayList();
                    e1Var.w(arrayList);
                    break;
                case 8:
                    arrayList = new ArrayList();
                    e1Var.z(arrayList);
                    break;
                case 9:
                    arrayList = new ArrayList();
                    e1Var.j(arrayList);
                    break;
                case 10:
                    arrayList = new ArrayList();
                    e1Var.h(arrayList);
                    break;
                case 11:
                    arrayList = new ArrayList();
                    e1Var.r(arrayList);
                    break;
                case 12:
                    arrayList = new ArrayList();
                    e1Var.d(arrayList);
                    break;
                case 13:
                    arrayList = new ArrayList();
                    e1Var.i(arrayList);
                    break;
                case 14:
                    arrayList = new ArrayList();
                    e1Var.t(arrayList);
                    ub = (UB) h1.z(c2, arrayList, eVar.f1456b.k(), ub, l1Var);
                    break;
                default:
                    throw new IllegalStateException("Type cannot be packed: " + eVar.f1456b.j());
            }
            uVar.x(eVar.f1456b, arrayList);
        } else {
            Object obj2 = null;
            if (eVar.a() == r1.b.s) {
                int E = e1Var.E();
                if (eVar.f1456b.k().a(E) == null) {
                    return (UB) h1.L(c2, E, ub, l1Var);
                }
                obj2 = Integer.valueOf(E);
            } else {
                switch (a.a[eVar.a().ordinal()]) {
                    case 1:
                        obj2 = Double.valueOf(e1Var.readDouble());
                        break;
                    case 2:
                        obj2 = Float.valueOf(e1Var.readFloat());
                        break;
                    case 3:
                        obj2 = Long.valueOf(e1Var.L());
                        break;
                    case 4:
                        obj2 = Long.valueOf(e1Var.e());
                        break;
                    case 5:
                        obj2 = Integer.valueOf(e1Var.E());
                        break;
                    case 6:
                        obj2 = Long.valueOf(e1Var.f());
                        break;
                    case 7:
                        obj2 = Integer.valueOf(e1Var.k());
                        break;
                    case 8:
                        obj2 = Boolean.valueOf(e1Var.l());
                        break;
                    case 9:
                        obj2 = Integer.valueOf(e1Var.p());
                        break;
                    case 10:
                        obj2 = Integer.valueOf(e1Var.H());
                        break;
                    case 11:
                        obj2 = Long.valueOf(e1Var.m());
                        break;
                    case 12:
                        obj2 = Integer.valueOf(e1Var.x());
                        break;
                    case 13:
                        obj2 = Long.valueOf(e1Var.y());
                        break;
                    case 14:
                        throw new IllegalStateException("Shouldn't reach here.");
                    case 15:
                        obj2 = e1Var.C();
                        break;
                    case 16:
                        obj2 = e1Var.a();
                        break;
                    case 17:
                        obj2 = e1Var.o(eVar.b().getClass(), pVar);
                        break;
                    case 18:
                        obj2 = e1Var.g(eVar.b().getClass(), pVar);
                        break;
                }
            }
            if (eVar.d()) {
                uVar.a(eVar.f1456b, obj2);
            } else {
                int i3 = a.a[eVar.a().ordinal()];
                if ((i3 == 17 || i3 == 18) && (i2 = uVar.i(eVar.f1456b)) != null) {
                    obj2 = a0.h(i2, obj2);
                }
                uVar.x(eVar.f1456b, obj2);
            }
        }
        return ub;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.datastore.preferences.protobuf.q
    public void h(e1 e1Var, Object obj, p pVar, u<y.d> uVar) throws IOException {
        y.e eVar = (y.e) obj;
        uVar.x(eVar.f1456b, e1Var.g(eVar.b().getClass(), pVar));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.datastore.preferences.protobuf.q
    public void i(h hVar, Object obj, p pVar, u<y.d> uVar) throws IOException {
        y.e eVar = (y.e) obj;
        q0 J0 = eVar.b().f().J0();
        e P = e.P(ByteBuffer.wrap(hVar.z()), true);
        b1.a().b(J0, P, pVar);
        uVar.x(eVar.f1456b, J0);
        if (P.A() != Integer.MAX_VALUE) {
            throw InvalidProtocolBufferException.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.datastore.preferences.protobuf.q
    public void j(s1 s1Var, Map.Entry<?, ?> entry) throws IOException {
        y.d dVar = (y.d) entry.getKey();
        if (dVar.h()) {
            switch (a.a[dVar.j().ordinal()]) {
                case 1:
                    h1.P(dVar.f(), (List) entry.getValue(), s1Var, dVar.m());
                    return;
                case 2:
                    h1.T(dVar.f(), (List) entry.getValue(), s1Var, dVar.m());
                    return;
                case 3:
                    h1.W(dVar.f(), (List) entry.getValue(), s1Var, dVar.m());
                    return;
                case 4:
                    h1.e0(dVar.f(), (List) entry.getValue(), s1Var, dVar.m());
                    return;
                case 5:
                    h1.V(dVar.f(), (List) entry.getValue(), s1Var, dVar.m());
                    return;
                case 6:
                    h1.S(dVar.f(), (List) entry.getValue(), s1Var, dVar.m());
                    return;
                case 7:
                    h1.R(dVar.f(), (List) entry.getValue(), s1Var, dVar.m());
                    return;
                case 8:
                    h1.N(dVar.f(), (List) entry.getValue(), s1Var, dVar.m());
                    return;
                case 9:
                    h1.d0(dVar.f(), (List) entry.getValue(), s1Var, dVar.m());
                    return;
                case 10:
                    h1.Y(dVar.f(), (List) entry.getValue(), s1Var, dVar.m());
                    return;
                case 11:
                    h1.Z(dVar.f(), (List) entry.getValue(), s1Var, dVar.m());
                    return;
                case 12:
                    h1.a0(dVar.f(), (List) entry.getValue(), s1Var, dVar.m());
                    return;
                case 13:
                    h1.b0(dVar.f(), (List) entry.getValue(), s1Var, dVar.m());
                    return;
                case 14:
                    h1.V(dVar.f(), (List) entry.getValue(), s1Var, dVar.m());
                    return;
                case 15:
                    h1.O(dVar.f(), (List) entry.getValue(), s1Var);
                    return;
                case 16:
                    h1.c0(dVar.f(), (List) entry.getValue(), s1Var);
                    return;
                case 17:
                    List list = (List) entry.getValue();
                    if (list == null || list.isEmpty()) {
                        return;
                    }
                    h1.U(dVar.f(), (List) entry.getValue(), s1Var, b1.a().d(list.get(0).getClass()));
                    return;
                case 18:
                    List list2 = (List) entry.getValue();
                    if (list2 == null || list2.isEmpty()) {
                        return;
                    }
                    h1.X(dVar.f(), (List) entry.getValue(), s1Var, b1.a().d(list2.get(0).getClass()));
                    return;
                default:
                    return;
            }
        }
        switch (a.a[dVar.j().ordinal()]) {
            case 1:
                s1Var.e(dVar.f(), ((Double) entry.getValue()).doubleValue());
                return;
            case 2:
                s1Var.E(dVar.f(), ((Float) entry.getValue()).floatValue());
                return;
            case 3:
                s1Var.p(dVar.f(), ((Long) entry.getValue()).longValue());
                return;
            case 4:
                s1Var.n(dVar.f(), ((Long) entry.getValue()).longValue());
                return;
            case 5:
                s1Var.t(dVar.f(), ((Integer) entry.getValue()).intValue());
                return;
            case 6:
                s1Var.h(dVar.f(), ((Long) entry.getValue()).longValue());
                return;
            case 7:
                s1Var.d(dVar.f(), ((Integer) entry.getValue()).intValue());
                return;
            case 8:
                s1Var.q(dVar.f(), ((Boolean) entry.getValue()).booleanValue());
                return;
            case 9:
                s1Var.b(dVar.f(), ((Integer) entry.getValue()).intValue());
                return;
            case 10:
                s1Var.r(dVar.f(), ((Integer) entry.getValue()).intValue());
                return;
            case 11:
                s1Var.x(dVar.f(), ((Long) entry.getValue()).longValue());
                return;
            case 12:
                s1Var.M(dVar.f(), ((Integer) entry.getValue()).intValue());
                return;
            case 13:
                s1Var.D(dVar.f(), ((Long) entry.getValue()).longValue());
                return;
            case 14:
                s1Var.t(dVar.f(), ((Integer) entry.getValue()).intValue());
                return;
            case 15:
                s1Var.w(dVar.f(), (h) entry.getValue());
                return;
            case 16:
                s1Var.m(dVar.f(), (String) entry.getValue());
                return;
            case 17:
                s1Var.O(dVar.f(), entry.getValue(), b1.a().d(entry.getValue().getClass()));
                return;
            case 18:
                s1Var.z(dVar.f(), entry.getValue(), b1.a().d(entry.getValue().getClass()));
                return;
            default:
                return;
        }
    }
}
