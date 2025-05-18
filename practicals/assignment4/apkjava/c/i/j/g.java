package c.i.j;

/* compiled from: Pools.java */
/* loaded from: classes.dex */
public class g<T> implements f<T> {
    private final Object[] a;

    /* renamed from: b, reason: collision with root package name */
    private int f3282b;

    public g(int i2) {
        if (i2 > 0) {
            this.a = new Object[i2];
            return;
        }
        throw new IllegalArgumentException("The max pool size must be > 0");
    }

    private boolean c(T t) {
        for (int i2 = 0; i2 < this.f3282b; i2++) {
            if (this.a[i2] == t) {
                return true;
            }
        }
        return false;
    }

    @Override // c.i.j.f
    public boolean a(T t) {
        if (!c(t)) {
            int i2 = this.f3282b;
            Object[] objArr = this.a;
            if (i2 >= objArr.length) {
                return false;
            }
            objArr[i2] = t;
            this.f3282b = i2 + 1;
            return true;
        }
        throw new IllegalStateException("Already in the pool!");
    }

    @Override // c.i.j.f
    public T b() {
        int i2 = this.f3282b;
        if (i2 <= 0) {
            return null;
        }
        int i3 = i2 - 1;
        Object[] objArr = this.a;
        T t = (T) objArr[i3];
        objArr[i3] = null;
        this.f3282b = i2 - 1;
        return t;
    }
}
