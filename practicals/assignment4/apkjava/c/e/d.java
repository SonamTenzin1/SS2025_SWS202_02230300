package c.e;

/* compiled from: LongSparseArray.java */
/* loaded from: classes.dex */
public class d<E> implements Cloneable {

    /* renamed from: f, reason: collision with root package name */
    private static final Object f2918f = new Object();

    /* renamed from: g, reason: collision with root package name */
    private boolean f2919g;

    /* renamed from: h, reason: collision with root package name */
    private long[] f2920h;

    /* renamed from: i, reason: collision with root package name */
    private Object[] f2921i;

    /* renamed from: j, reason: collision with root package name */
    private int f2922j;

    public d() {
        this(10);
    }

    private void f() {
        int i2 = this.f2922j;
        long[] jArr = this.f2920h;
        Object[] objArr = this.f2921i;
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            Object obj = objArr[i4];
            if (obj != f2918f) {
                if (i4 != i3) {
                    jArr[i3] = jArr[i4];
                    objArr[i3] = obj;
                    objArr[i4] = null;
                }
                i3++;
            }
        }
        this.f2919g = false;
        this.f2922j = i3;
    }

    public void b(long j2, E e2) {
        int i2 = this.f2922j;
        if (i2 != 0 && j2 <= this.f2920h[i2 - 1]) {
            k(j2, e2);
            return;
        }
        if (this.f2919g && i2 >= this.f2920h.length) {
            f();
        }
        int i3 = this.f2922j;
        if (i3 >= this.f2920h.length) {
            int f2 = c.f(i3 + 1);
            long[] jArr = new long[f2];
            Object[] objArr = new Object[f2];
            long[] jArr2 = this.f2920h;
            System.arraycopy(jArr2, 0, jArr, 0, jArr2.length);
            Object[] objArr2 = this.f2921i;
            System.arraycopy(objArr2, 0, objArr, 0, objArr2.length);
            this.f2920h = jArr;
            this.f2921i = objArr;
        }
        this.f2920h[i3] = j2;
        this.f2921i[i3] = e2;
        this.f2922j = i3 + 1;
    }

    public void d() {
        int i2 = this.f2922j;
        Object[] objArr = this.f2921i;
        for (int i3 = 0; i3 < i2; i3++) {
            objArr[i3] = null;
        }
        this.f2922j = 0;
        this.f2919g = false;
    }

    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public d<E> clone() {
        try {
            d<E> dVar = (d) super.clone();
            dVar.f2920h = (long[]) this.f2920h.clone();
            dVar.f2921i = (Object[]) this.f2921i.clone();
            return dVar;
        } catch (CloneNotSupportedException e2) {
            throw new AssertionError(e2);
        }
    }

    public E g(long j2) {
        return h(j2, null);
    }

    public E h(long j2, E e2) {
        int b2 = c.b(this.f2920h, this.f2922j, j2);
        if (b2 >= 0) {
            Object[] objArr = this.f2921i;
            if (objArr[b2] != f2918f) {
                return (E) objArr[b2];
            }
        }
        return e2;
    }

    public int i(long j2) {
        if (this.f2919g) {
            f();
        }
        return c.b(this.f2920h, this.f2922j, j2);
    }

    public long j(int i2) {
        if (this.f2919g) {
            f();
        }
        return this.f2920h[i2];
    }

    public void k(long j2, E e2) {
        int b2 = c.b(this.f2920h, this.f2922j, j2);
        if (b2 >= 0) {
            this.f2921i[b2] = e2;
            return;
        }
        int i2 = b2 ^ (-1);
        int i3 = this.f2922j;
        if (i2 < i3) {
            Object[] objArr = this.f2921i;
            if (objArr[i2] == f2918f) {
                this.f2920h[i2] = j2;
                objArr[i2] = e2;
                return;
            }
        }
        if (this.f2919g && i3 >= this.f2920h.length) {
            f();
            i2 = c.b(this.f2920h, this.f2922j, j2) ^ (-1);
        }
        int i4 = this.f2922j;
        if (i4 >= this.f2920h.length) {
            int f2 = c.f(i4 + 1);
            long[] jArr = new long[f2];
            Object[] objArr2 = new Object[f2];
            long[] jArr2 = this.f2920h;
            System.arraycopy(jArr2, 0, jArr, 0, jArr2.length);
            Object[] objArr3 = this.f2921i;
            System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
            this.f2920h = jArr;
            this.f2921i = objArr2;
        }
        int i5 = this.f2922j;
        if (i5 - i2 != 0) {
            long[] jArr3 = this.f2920h;
            int i6 = i2 + 1;
            System.arraycopy(jArr3, i2, jArr3, i6, i5 - i2);
            Object[] objArr4 = this.f2921i;
            System.arraycopy(objArr4, i2, objArr4, i6, this.f2922j - i2);
        }
        this.f2920h[i2] = j2;
        this.f2921i[i2] = e2;
        this.f2922j++;
    }

    public void l(long j2) {
        int b2 = c.b(this.f2920h, this.f2922j, j2);
        if (b2 >= 0) {
            Object[] objArr = this.f2921i;
            Object obj = objArr[b2];
            Object obj2 = f2918f;
            if (obj != obj2) {
                objArr[b2] = obj2;
                this.f2919g = true;
            }
        }
    }

    public void m(int i2) {
        Object[] objArr = this.f2921i;
        Object obj = objArr[i2];
        Object obj2 = f2918f;
        if (obj != obj2) {
            objArr[i2] = obj2;
            this.f2919g = true;
        }
    }

    public int n() {
        if (this.f2919g) {
            f();
        }
        return this.f2922j;
    }

    public E o(int i2) {
        if (this.f2919g) {
            f();
        }
        return (E) this.f2921i[i2];
    }

    public String toString() {
        if (n() <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.f2922j * 28);
        sb.append('{');
        for (int i2 = 0; i2 < this.f2922j; i2++) {
            if (i2 > 0) {
                sb.append(", ");
            }
            sb.append(j(i2));
            sb.append('=');
            E o = o(i2);
            if (o != this) {
                sb.append(o);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    public d(int i2) {
        this.f2919g = false;
        if (i2 == 0) {
            this.f2920h = c.f2916b;
            this.f2921i = c.f2917c;
        } else {
            int f2 = c.f(i2);
            this.f2920h = new long[f2];
            this.f2921i = new Object[f2];
        }
    }
}
