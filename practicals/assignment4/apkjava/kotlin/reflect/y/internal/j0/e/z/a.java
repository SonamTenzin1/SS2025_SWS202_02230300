package kotlin.reflect.y.internal.j0.e.z;

import java.util.ArrayList;
import java.util.List;
import kotlin.collections.c0;
import kotlin.collections.n;
import kotlin.collections.u;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.m;

/* compiled from: BinaryVersion.kt */
/* loaded from: classes3.dex */
public abstract class a {
    public static final C0369a a = new C0369a(null);

    /* renamed from: b, reason: collision with root package name */
    private final int[] f24177b;

    /* renamed from: c, reason: collision with root package name */
    private final int f24178c;

    /* renamed from: d, reason: collision with root package name */
    private final int f24179d;

    /* renamed from: e, reason: collision with root package name */
    private final int f24180e;

    /* renamed from: f, reason: collision with root package name */
    private final List<Integer> f24181f;

    /* compiled from: BinaryVersion.kt */
    /* renamed from: kotlin.f0.y.e.j0.e.z.a$a, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static final class C0369a {
        private C0369a() {
        }

        public /* synthetic */ C0369a(g gVar) {
            this();
        }
    }

    public a(int... iArr) {
        Integer B;
        Integer B2;
        Integer B3;
        List<Integer> j2;
        List<Integer> b2;
        m.f(iArr, "numbers");
        this.f24177b = iArr;
        B = n.B(iArr, 0);
        this.f24178c = B != null ? B.intValue() : -1;
        B2 = n.B(iArr, 1);
        this.f24179d = B2 != null ? B2.intValue() : -1;
        B3 = n.B(iArr, 2);
        this.f24180e = B3 != null ? B3.intValue() : -1;
        if (iArr.length > 3) {
            if (iArr.length <= 1024) {
                b2 = kotlin.collections.m.b(iArr);
                j2 = c0.E0(b2.subList(3, iArr.length));
            } else {
                throw new IllegalArgumentException("BinaryVersion with length more than 1024 are not supported. Provided length " + iArr.length + '.');
            }
        } else {
            j2 = u.j();
        }
        this.f24181f = j2;
    }

    public final int a() {
        return this.f24178c;
    }

    public final int b() {
        return this.f24179d;
    }

    public final boolean c(int i2, int i3, int i4) {
        int i5 = this.f24178c;
        if (i5 > i2) {
            return true;
        }
        if (i5 < i2) {
            return false;
        }
        int i6 = this.f24179d;
        if (i6 > i3) {
            return true;
        }
        return i6 >= i3 && this.f24180e >= i4;
    }

    public final boolean d(a aVar) {
        m.f(aVar, "version");
        return c(aVar.f24178c, aVar.f24179d, aVar.f24180e);
    }

    public final boolean e(int i2, int i3, int i4) {
        int i5 = this.f24178c;
        if (i5 < i2) {
            return true;
        }
        if (i5 > i2) {
            return false;
        }
        int i6 = this.f24179d;
        if (i6 < i3) {
            return true;
        }
        return i6 <= i3 && this.f24180e <= i4;
    }

    public boolean equals(Object obj) {
        if (obj != null && m.a(getClass(), obj.getClass())) {
            a aVar = (a) obj;
            if (this.f24178c == aVar.f24178c && this.f24179d == aVar.f24179d && this.f24180e == aVar.f24180e && m.a(this.f24181f, aVar.f24181f)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean f(a aVar) {
        m.f(aVar, "ourVersion");
        int i2 = this.f24178c;
        if (i2 == 0) {
            if (aVar.f24178c == 0 && this.f24179d == aVar.f24179d) {
                return true;
            }
        } else if (i2 == aVar.f24178c && this.f24179d <= aVar.f24179d) {
            return true;
        }
        return false;
    }

    public final int[] g() {
        return this.f24177b;
    }

    public int hashCode() {
        int i2 = this.f24178c;
        int i3 = i2 + (i2 * 31) + this.f24179d;
        int i4 = i3 + (i3 * 31) + this.f24180e;
        return i4 + (i4 * 31) + this.f24181f.hashCode();
    }

    public String toString() {
        String e0;
        int[] g2 = g();
        ArrayList arrayList = new ArrayList();
        int length = g2.length;
        for (int i2 = 0; i2 < length; i2++) {
            int i3 = g2[i2];
            if (!(i3 != -1)) {
                break;
            }
            arrayList.add(Integer.valueOf(i3));
        }
        if (arrayList.isEmpty()) {
            return "unknown";
        }
        e0 = c0.e0(arrayList, ".", null, null, 0, null, null, 62, null);
        return e0;
    }
}
