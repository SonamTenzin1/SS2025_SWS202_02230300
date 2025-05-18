package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.s1;
import java.io.IOException;
import java.util.Arrays;

/* compiled from: UnknownFieldSetLite.java */
/* loaded from: classes.dex */
public final class m1 {
    private static final m1 a = new m1(0, new int[0], new Object[0], false);

    /* renamed from: b, reason: collision with root package name */
    private int f1367b;

    /* renamed from: c, reason: collision with root package name */
    private int[] f1368c;

    /* renamed from: d, reason: collision with root package name */
    private Object[] f1369d;

    /* renamed from: e, reason: collision with root package name */
    private int f1370e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f1371f;

    private m1() {
        this(0, new int[8], new Object[8], true);
    }

    private void b() {
        int i2 = this.f1367b;
        int[] iArr = this.f1368c;
        if (i2 == iArr.length) {
            int i3 = i2 + (i2 < 4 ? 8 : i2 >> 1);
            this.f1368c = Arrays.copyOf(iArr, i3);
            this.f1369d = Arrays.copyOf(this.f1369d, i3);
        }
    }

    private static boolean c(int[] iArr, int[] iArr2, int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            if (iArr[i3] != iArr2[i3]) {
                return false;
            }
        }
        return true;
    }

    private static boolean d(Object[] objArr, Object[] objArr2, int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            if (!objArr[i3].equals(objArr2[i3])) {
                return false;
            }
        }
        return true;
    }

    public static m1 e() {
        return a;
    }

    private static int h(int[] iArr, int i2) {
        int i3 = 17;
        for (int i4 = 0; i4 < i2; i4++) {
            i3 = (i3 * 31) + iArr[i4];
        }
        return i3;
    }

    private static int i(Object[] objArr, int i2) {
        int i3 = 17;
        for (int i4 = 0; i4 < i2; i4++) {
            i3 = (i3 * 31) + objArr[i4].hashCode();
        }
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static m1 k(m1 m1Var, m1 m1Var2) {
        int i2 = m1Var.f1367b + m1Var2.f1367b;
        int[] copyOf = Arrays.copyOf(m1Var.f1368c, i2);
        System.arraycopy(m1Var2.f1368c, 0, copyOf, m1Var.f1367b, m1Var2.f1367b);
        Object[] copyOf2 = Arrays.copyOf(m1Var.f1369d, i2);
        System.arraycopy(m1Var2.f1369d, 0, copyOf2, m1Var.f1367b, m1Var2.f1367b);
        return new m1(i2, copyOf, copyOf2, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static m1 l() {
        return new m1();
    }

    private static void p(int i2, Object obj, s1 s1Var) throws IOException {
        int a2 = r1.a(i2);
        int b2 = r1.b(i2);
        if (b2 == 0) {
            s1Var.p(a2, ((Long) obj).longValue());
            return;
        }
        if (b2 == 1) {
            s1Var.h(a2, ((Long) obj).longValue());
            return;
        }
        if (b2 == 2) {
            s1Var.w(a2, (h) obj);
            return;
        }
        if (b2 != 3) {
            if (b2 == 5) {
                s1Var.d(a2, ((Integer) obj).intValue());
                return;
            }
            throw new RuntimeException(InvalidProtocolBufferException.d());
        }
        if (s1Var.i() == s1.a.ASCENDING) {
            s1Var.s(a2);
            ((m1) obj).q(s1Var);
            s1Var.F(a2);
        } else {
            s1Var.F(a2);
            ((m1) obj).q(s1Var);
            s1Var.s(a2);
        }
    }

    void a() {
        if (!this.f1371f) {
            throw new UnsupportedOperationException();
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof m1)) {
            return false;
        }
        m1 m1Var = (m1) obj;
        int i2 = this.f1367b;
        return i2 == m1Var.f1367b && c(this.f1368c, m1Var.f1368c, i2) && d(this.f1369d, m1Var.f1369d, this.f1367b);
    }

    public int f() {
        int Y;
        int i2 = this.f1370e;
        if (i2 != -1) {
            return i2;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < this.f1367b; i4++) {
            int i5 = this.f1368c[i4];
            int a2 = r1.a(i5);
            int b2 = r1.b(i5);
            if (b2 == 0) {
                Y = CodedOutputStream.Y(a2, ((Long) this.f1369d[i4]).longValue());
            } else if (b2 == 1) {
                Y = CodedOutputStream.o(a2, ((Long) this.f1369d[i4]).longValue());
            } else if (b2 == 2) {
                Y = CodedOutputStream.g(a2, (h) this.f1369d[i4]);
            } else if (b2 == 3) {
                Y = (CodedOutputStream.V(a2) * 2) + ((m1) this.f1369d[i4]).f();
            } else if (b2 == 5) {
                Y = CodedOutputStream.m(a2, ((Integer) this.f1369d[i4]).intValue());
            } else {
                throw new IllegalStateException(InvalidProtocolBufferException.d());
            }
            i3 += Y;
        }
        this.f1370e = i3;
        return i3;
    }

    public int g() {
        int i2 = this.f1370e;
        if (i2 != -1) {
            return i2;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < this.f1367b; i4++) {
            i3 += CodedOutputStream.J(r1.a(this.f1368c[i4]), (h) this.f1369d[i4]);
        }
        this.f1370e = i3;
        return i3;
    }

    public int hashCode() {
        int i2 = this.f1367b;
        return ((((527 + i2) * 31) + h(this.f1368c, i2)) * 31) + i(this.f1369d, this.f1367b);
    }

    public void j() {
        this.f1371f = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void m(StringBuilder sb, int i2) {
        for (int i3 = 0; i3 < this.f1367b; i3++) {
            s0.c(sb, i2, String.valueOf(r1.a(this.f1368c[i3])), this.f1369d[i3]);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void n(int i2, Object obj) {
        a();
        b();
        int[] iArr = this.f1368c;
        int i3 = this.f1367b;
        iArr[i3] = i2;
        this.f1369d[i3] = obj;
        this.f1367b = i3 + 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void o(s1 s1Var) throws IOException {
        if (s1Var.i() == s1.a.DESCENDING) {
            for (int i2 = this.f1367b - 1; i2 >= 0; i2--) {
                s1Var.c(r1.a(this.f1368c[i2]), this.f1369d[i2]);
            }
            return;
        }
        for (int i3 = 0; i3 < this.f1367b; i3++) {
            s1Var.c(r1.a(this.f1368c[i3]), this.f1369d[i3]);
        }
    }

    public void q(s1 s1Var) throws IOException {
        if (this.f1367b == 0) {
            return;
        }
        if (s1Var.i() == s1.a.ASCENDING) {
            for (int i2 = 0; i2 < this.f1367b; i2++) {
                p(this.f1368c[i2], this.f1369d[i2], s1Var);
            }
            return;
        }
        for (int i3 = this.f1367b - 1; i3 >= 0; i3--) {
            p(this.f1368c[i3], this.f1369d[i3], s1Var);
        }
    }

    private m1(int i2, int[] iArr, Object[] objArr, boolean z) {
        this.f1370e = -1;
        this.f1367b = i2;
        this.f1368c = iArr;
        this.f1369d = objArr;
        this.f1371f = z;
    }
}
