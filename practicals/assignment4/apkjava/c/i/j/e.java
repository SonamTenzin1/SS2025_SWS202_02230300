package c.i.j;

/* compiled from: Pair.java */
/* loaded from: classes.dex */
public class e<F, S> {
    public final F a;

    /* renamed from: b, reason: collision with root package name */
    public final S f3281b;

    public e(F f2, S s) {
        this.a = f2;
        this.f3281b = s;
    }

    public static <A, B> e<A, B> a(A a, B b2) {
        return new e<>(a, b2);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        return d.a(eVar.a, this.a) && d.a(eVar.f3281b, this.f3281b);
    }

    public int hashCode() {
        F f2 = this.a;
        int hashCode = f2 == null ? 0 : f2.hashCode();
        S s = this.f3281b;
        return hashCode ^ (s != null ? s.hashCode() : 0);
    }

    public String toString() {
        return "Pair{" + this.a + " " + this.f3281b + "}";
    }
}
