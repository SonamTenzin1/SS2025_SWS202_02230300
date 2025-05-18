package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.a0;
import androidx.datastore.preferences.protobuf.c0;
import androidx.datastore.preferences.protobuf.q0;
import androidx.datastore.preferences.protobuf.r1;
import androidx.datastore.preferences.protobuf.u.b;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: FieldSet.java */
/* loaded from: classes.dex */
final class u<T extends b<T>> {
    private static final u a = new u(true);

    /* renamed from: b, reason: collision with root package name */
    private final i1<T, Object> f1423b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f1424c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f1425d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FieldSet.java */
    /* loaded from: classes.dex */
    public static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        /* renamed from: b, reason: collision with root package name */
        static final /* synthetic */ int[] f1426b;

        static {
            int[] iArr = new int[r1.b.values().length];
            f1426b = iArr;
            try {
                iArr[r1.b.f1397f.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f1426b[r1.b.f1398g.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f1426b[r1.b.f1399h.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f1426b[r1.b.f1400i.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f1426b[r1.b.f1401j.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f1426b[r1.b.f1402k.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f1426b[r1.b.l.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f1426b[r1.b.m.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f1426b[r1.b.o.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f1426b[r1.b.p.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f1426b[r1.b.n.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f1426b[r1.b.q.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f1426b[r1.b.r.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f1426b[r1.b.t.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f1426b[r1.b.u.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f1426b[r1.b.v.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                f1426b[r1.b.w.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                f1426b[r1.b.s.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            int[] iArr2 = new int[r1.c.values().length];
            a = iArr2;
            try {
                iArr2[r1.c.INT.ordinal()] = 1;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                a[r1.c.LONG.ordinal()] = 2;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                a[r1.c.FLOAT.ordinal()] = 3;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                a[r1.c.DOUBLE.ordinal()] = 4;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                a[r1.c.BOOLEAN.ordinal()] = 5;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                a[r1.c.STRING.ordinal()] = 6;
            } catch (NoSuchFieldError unused24) {
            }
            try {
                a[r1.c.BYTE_STRING.ordinal()] = 7;
            } catch (NoSuchFieldError unused25) {
            }
            try {
                a[r1.c.ENUM.ordinal()] = 8;
            } catch (NoSuchFieldError unused26) {
            }
            try {
                a[r1.c.MESSAGE.ordinal()] = 9;
            } catch (NoSuchFieldError unused27) {
            }
        }
    }

    /* compiled from: FieldSet.java */
    /* loaded from: classes.dex */
    public interface b<T extends b<T>> extends Comparable<T> {
        q0.a B(q0.a aVar, q0 q0Var);

        int f();

        boolean h();

        r1.b j();

        r1.c l();

        boolean m();
    }

    private u() {
        this.f1423b = i1.r(16);
    }

    static void A(CodedOutputStream codedOutputStream, r1.b bVar, Object obj) throws IOException {
        switch (a.f1426b[bVar.ordinal()]) {
            case 1:
                codedOutputStream.r0(((Double) obj).doubleValue());
                return;
            case 2:
                codedOutputStream.z0(((Float) obj).floatValue());
                return;
            case 3:
                codedOutputStream.H0(((Long) obj).longValue());
                return;
            case 4:
                codedOutputStream.a1(((Long) obj).longValue());
                return;
            case 5:
                codedOutputStream.F0(((Integer) obj).intValue());
                return;
            case 6:
                codedOutputStream.x0(((Long) obj).longValue());
                return;
            case 7:
                codedOutputStream.v0(((Integer) obj).intValue());
                return;
            case 8:
                codedOutputStream.l0(((Boolean) obj).booleanValue());
                return;
            case 9:
                codedOutputStream.C0((q0) obj);
                return;
            case 10:
                codedOutputStream.J0((q0) obj);
                return;
            case 11:
                if (obj instanceof h) {
                    codedOutputStream.p0((h) obj);
                    return;
                } else {
                    codedOutputStream.V0((String) obj);
                    return;
                }
            case 12:
                if (obj instanceof h) {
                    codedOutputStream.p0((h) obj);
                    return;
                } else {
                    codedOutputStream.m0((byte[]) obj);
                    return;
                }
            case 13:
                codedOutputStream.Y0(((Integer) obj).intValue());
                return;
            case 14:
                codedOutputStream.N0(((Integer) obj).intValue());
                return;
            case 15:
                codedOutputStream.P0(((Long) obj).longValue());
                return;
            case 16:
                codedOutputStream.R0(((Integer) obj).intValue());
                return;
            case 17:
                codedOutputStream.T0(((Long) obj).longValue());
                return;
            case 18:
                if (obj instanceof a0.c) {
                    codedOutputStream.t0(((a0.c) obj).f());
                    return;
                } else {
                    codedOutputStream.t0(((Integer) obj).intValue());
                    return;
                }
            default:
                return;
        }
    }

    private static Object c(Object obj) {
        if (!(obj instanceof byte[])) {
            return obj;
        }
        byte[] bArr = (byte[]) obj;
        byte[] bArr2 = new byte[bArr.length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        return bArr2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int d(r1.b bVar, int i2, Object obj) {
        int V = CodedOutputStream.V(i2);
        if (bVar == r1.b.o) {
            V *= 2;
        }
        return V + e(bVar, obj);
    }

    static int e(r1.b bVar, Object obj) {
        switch (a.f1426b[bVar.ordinal()]) {
            case 1:
                return CodedOutputStream.j(((Double) obj).doubleValue());
            case 2:
                return CodedOutputStream.r(((Float) obj).floatValue());
            case 3:
                return CodedOutputStream.y(((Long) obj).longValue());
            case 4:
                return CodedOutputStream.Z(((Long) obj).longValue());
            case 5:
                return CodedOutputStream.w(((Integer) obj).intValue());
            case 6:
                return CodedOutputStream.p(((Long) obj).longValue());
            case 7:
                return CodedOutputStream.n(((Integer) obj).intValue());
            case 8:
                return CodedOutputStream.e(((Boolean) obj).booleanValue());
            case 9:
                return CodedOutputStream.t((q0) obj);
            case 10:
                if (obj instanceof c0) {
                    return CodedOutputStream.B((c0) obj);
                }
                return CodedOutputStream.G((q0) obj);
            case 11:
                if (obj instanceof h) {
                    return CodedOutputStream.h((h) obj);
                }
                return CodedOutputStream.U((String) obj);
            case 12:
                if (obj instanceof h) {
                    return CodedOutputStream.h((h) obj);
                }
                return CodedOutputStream.f((byte[]) obj);
            case 13:
                return CodedOutputStream.X(((Integer) obj).intValue());
            case 14:
                return CodedOutputStream.M(((Integer) obj).intValue());
            case 15:
                return CodedOutputStream.O(((Long) obj).longValue());
            case 16:
                return CodedOutputStream.Q(((Integer) obj).intValue());
            case 17:
                return CodedOutputStream.S(((Long) obj).longValue());
            case 18:
                if (obj instanceof a0.c) {
                    return CodedOutputStream.l(((a0.c) obj).f());
                }
                return CodedOutputStream.l(((Integer) obj).intValue());
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    public static int f(b<?> bVar, Object obj) {
        r1.b j2 = bVar.j();
        int f2 = bVar.f();
        if (bVar.h()) {
            int i2 = 0;
            if (bVar.m()) {
                Iterator it = ((List) obj).iterator();
                while (it.hasNext()) {
                    i2 += e(j2, it.next());
                }
                return CodedOutputStream.V(f2) + i2 + CodedOutputStream.K(i2);
            }
            Iterator it2 = ((List) obj).iterator();
            while (it2.hasNext()) {
                i2 += d(j2, f2, it2.next());
            }
            return i2;
        }
        return d(j2, f2, obj);
    }

    public static <T extends b<T>> u<T> h() {
        return a;
    }

    private int k(Map.Entry<T, Object> entry) {
        T key = entry.getKey();
        Object value = entry.getValue();
        if (key.l() == r1.c.MESSAGE && !key.h() && !key.m()) {
            if (value instanceof c0) {
                return CodedOutputStream.z(entry.getKey().f(), (c0) value);
            }
            return CodedOutputStream.D(entry.getKey().f(), (q0) value);
        }
        return f(key, value);
    }

    static int m(r1.b bVar, boolean z) {
        if (z) {
            return 2;
        }
        return bVar.k();
    }

    private static <T extends b<T>> boolean q(Map.Entry<T, Object> entry) {
        T key = entry.getKey();
        if (key.l() == r1.c.MESSAGE) {
            if (key.h()) {
                Iterator it = ((List) entry.getValue()).iterator();
                while (it.hasNext()) {
                    if (!((q0) it.next()).isInitialized()) {
                        return false;
                    }
                }
            } else {
                Object value = entry.getValue();
                if (value instanceof q0) {
                    if (!((q0) value).isInitialized()) {
                        return false;
                    }
                } else {
                    if (value instanceof c0) {
                        return true;
                    }
                    throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
                }
            }
        }
        return true;
    }

    private static boolean r(r1.b bVar, Object obj) {
        a0.a(obj);
        switch (a.a[bVar.g().ordinal()]) {
            case 1:
                return obj instanceof Integer;
            case 2:
                return obj instanceof Long;
            case 3:
                return obj instanceof Float;
            case 4:
                return obj instanceof Double;
            case 5:
                return obj instanceof Boolean;
            case 6:
                return obj instanceof String;
            case 7:
                return (obj instanceof h) || (obj instanceof byte[]);
            case 8:
                return (obj instanceof Integer) || (obj instanceof a0.c);
            case 9:
                return (obj instanceof q0) || (obj instanceof c0);
            default:
                return false;
        }
    }

    private void v(Map.Entry<T, Object> entry) {
        T key = entry.getKey();
        Object value = entry.getValue();
        if (value instanceof c0) {
            value = ((c0) value).f();
        }
        if (key.h()) {
            Object i2 = i(key);
            if (i2 == null) {
                i2 = new ArrayList();
            }
            Iterator it = ((List) value).iterator();
            while (it.hasNext()) {
                ((List) i2).add(c(it.next()));
            }
            this.f1423b.put(key, i2);
            return;
        }
        if (key.l() == r1.c.MESSAGE) {
            Object i3 = i(key);
            if (i3 == null) {
                this.f1423b.put(key, c(value));
                return;
            } else {
                this.f1423b.put(key, key.B(((q0) i3).d(), (q0) value).c());
                return;
            }
        }
        this.f1423b.put(key, c(value));
    }

    public static <T extends b<T>> u<T> w() {
        return new u<>();
    }

    private void y(r1.b bVar, Object obj) {
        if (!r(bVar, obj)) {
            throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void z(CodedOutputStream codedOutputStream, r1.b bVar, int i2, Object obj) throws IOException {
        if (bVar == r1.b.o) {
            codedOutputStream.A0(i2, (q0) obj);
        } else {
            codedOutputStream.W0(i2, m(bVar, false));
            A(codedOutputStream, bVar, obj);
        }
    }

    public void a(T t, Object obj) {
        List list;
        if (t.h()) {
            y(t.j(), obj);
            Object i2 = i(t);
            if (i2 == null) {
                list = new ArrayList();
                this.f1423b.put(t, list);
            } else {
                list = (List) i2;
            }
            list.add(obj);
            return;
        }
        throw new IllegalArgumentException("addRepeatedField() can only be called on repeated fields.");
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public u<T> clone() {
        u<T> w = w();
        for (int i2 = 0; i2 < this.f1423b.l(); i2++) {
            Map.Entry<T, Object> k2 = this.f1423b.k(i2);
            w.x(k2.getKey(), k2.getValue());
        }
        for (Map.Entry<T, Object> entry : this.f1423b.n()) {
            w.x(entry.getKey(), entry.getValue());
        }
        w.f1425d = this.f1425d;
        return w;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof u) {
            return this.f1423b.equals(((u) obj).f1423b);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Iterator<Map.Entry<T, Object>> g() {
        if (this.f1425d) {
            return new c0.c(this.f1423b.i().iterator());
        }
        return this.f1423b.i().iterator();
    }

    public int hashCode() {
        return this.f1423b.hashCode();
    }

    public Object i(T t) {
        Object obj = this.f1423b.get(t);
        return obj instanceof c0 ? ((c0) obj).f() : obj;
    }

    public int j() {
        int i2 = 0;
        for (int i3 = 0; i3 < this.f1423b.l(); i3++) {
            i2 += k(this.f1423b.k(i3));
        }
        Iterator<Map.Entry<T, Object>> it = this.f1423b.n().iterator();
        while (it.hasNext()) {
            i2 += k(it.next());
        }
        return i2;
    }

    public int l() {
        int i2 = 0;
        for (int i3 = 0; i3 < this.f1423b.l(); i3++) {
            Map.Entry<T, Object> k2 = this.f1423b.k(i3);
            i2 += f(k2.getKey(), k2.getValue());
        }
        for (Map.Entry<T, Object> entry : this.f1423b.n()) {
            i2 += f(entry.getKey(), entry.getValue());
        }
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean n() {
        return this.f1423b.isEmpty();
    }

    public boolean o() {
        return this.f1424c;
    }

    public boolean p() {
        for (int i2 = 0; i2 < this.f1423b.l(); i2++) {
            if (!q(this.f1423b.k(i2))) {
                return false;
            }
        }
        Iterator<Map.Entry<T, Object>> it = this.f1423b.n().iterator();
        while (it.hasNext()) {
            if (!q(it.next())) {
                return false;
            }
        }
        return true;
    }

    public Iterator<Map.Entry<T, Object>> s() {
        if (this.f1425d) {
            return new c0.c(this.f1423b.entrySet().iterator());
        }
        return this.f1423b.entrySet().iterator();
    }

    public void t() {
        if (this.f1424c) {
            return;
        }
        this.f1423b.q();
        this.f1424c = true;
    }

    public void u(u<T> uVar) {
        for (int i2 = 0; i2 < uVar.f1423b.l(); i2++) {
            v(uVar.f1423b.k(i2));
        }
        Iterator<Map.Entry<T, Object>> it = uVar.f1423b.n().iterator();
        while (it.hasNext()) {
            v(it.next());
        }
    }

    public void x(T t, Object obj) {
        if (t.h()) {
            if (obj instanceof List) {
                ArrayList arrayList = new ArrayList();
                arrayList.addAll((List) obj);
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    y(t.j(), it.next());
                }
                obj = arrayList;
            } else {
                throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
            }
        } else {
            y(t.j(), obj);
        }
        if (obj instanceof c0) {
            this.f1425d = true;
        }
        this.f1423b.put(t, obj);
    }

    private u(boolean z) {
        this(i1.r(0));
        t();
    }

    private u(i1<T, Object> i1Var) {
        this.f1423b = i1Var;
        t();
    }
}
