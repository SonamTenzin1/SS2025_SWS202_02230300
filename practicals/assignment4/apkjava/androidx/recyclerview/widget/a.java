package androidx.recyclerview.widget;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.m;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdapterHelper.java */
/* loaded from: classes.dex */
public class a implements m.a {
    private c.i.j.f<b> a;

    /* renamed from: b, reason: collision with root package name */
    final ArrayList<b> f1999b;

    /* renamed from: c, reason: collision with root package name */
    final ArrayList<b> f2000c;

    /* renamed from: d, reason: collision with root package name */
    final InterfaceC0040a f2001d;

    /* renamed from: e, reason: collision with root package name */
    Runnable f2002e;

    /* renamed from: f, reason: collision with root package name */
    final boolean f2003f;

    /* renamed from: g, reason: collision with root package name */
    final m f2004g;

    /* renamed from: h, reason: collision with root package name */
    private int f2005h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AdapterHelper.java */
    /* renamed from: androidx.recyclerview.widget.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0040a {
        void a(int i2, int i3);

        void b(b bVar);

        void c(int i2, int i3, Object obj);

        void d(b bVar);

        RecyclerView.c0 e(int i2);

        void f(int i2, int i3);

        void g(int i2, int i3);

        void h(int i2, int i3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AdapterHelper.java */
    /* loaded from: classes.dex */
    public static class b {
        int a;

        /* renamed from: b, reason: collision with root package name */
        int f2006b;

        /* renamed from: c, reason: collision with root package name */
        Object f2007c;

        /* renamed from: d, reason: collision with root package name */
        int f2008d;

        b(int i2, int i3, int i4, Object obj) {
            this.a = i2;
            this.f2006b = i3;
            this.f2008d = i4;
            this.f2007c = obj;
        }

        String a() {
            int i2 = this.a;
            return i2 != 1 ? i2 != 2 ? i2 != 4 ? i2 != 8 ? "??" : "mv" : "up" : "rm" : "add";
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || b.class != obj.getClass()) {
                return false;
            }
            b bVar = (b) obj;
            int i2 = this.a;
            if (i2 != bVar.a) {
                return false;
            }
            if (i2 == 8 && Math.abs(this.f2008d - this.f2006b) == 1 && this.f2008d == bVar.f2006b && this.f2006b == bVar.f2008d) {
                return true;
            }
            if (this.f2008d != bVar.f2008d || this.f2006b != bVar.f2006b) {
                return false;
            }
            Object obj2 = this.f2007c;
            if (obj2 != null) {
                if (!obj2.equals(bVar.f2007c)) {
                    return false;
                }
            } else if (bVar.f2007c != null) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return (((this.a * 31) + this.f2006b) * 31) + this.f2008d;
        }

        public String toString() {
            return Integer.toHexString(System.identityHashCode(this)) + "[" + a() + ",s:" + this.f2006b + "c:" + this.f2008d + ",p:" + this.f2007c + "]";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(InterfaceC0040a interfaceC0040a) {
        this(interfaceC0040a, false);
    }

    private void c(b bVar) {
        v(bVar);
    }

    private void d(b bVar) {
        v(bVar);
    }

    private void f(b bVar) {
        boolean z;
        char c2;
        int i2 = bVar.f2006b;
        int i3 = bVar.f2008d + i2;
        char c3 = 65535;
        int i4 = i2;
        int i5 = 0;
        while (i4 < i3) {
            if (this.f2001d.e(i4) != null || h(i4)) {
                if (c3 == 0) {
                    k(b(2, i2, i5, null));
                    z = true;
                } else {
                    z = false;
                }
                c2 = 1;
            } else {
                if (c3 == 1) {
                    v(b(2, i2, i5, null));
                    z = true;
                } else {
                    z = false;
                }
                c2 = 0;
            }
            if (z) {
                i4 -= i5;
                i3 -= i5;
                i5 = 1;
            } else {
                i5++;
            }
            i4++;
            c3 = c2;
        }
        if (i5 != bVar.f2008d) {
            a(bVar);
            bVar = b(2, i2, i5, null);
        }
        if (c3 == 0) {
            k(bVar);
        } else {
            v(bVar);
        }
    }

    private void g(b bVar) {
        int i2 = bVar.f2006b;
        int i3 = bVar.f2008d + i2;
        int i4 = i2;
        char c2 = 65535;
        int i5 = 0;
        while (i2 < i3) {
            if (this.f2001d.e(i2) != null || h(i2)) {
                if (c2 == 0) {
                    k(b(4, i4, i5, bVar.f2007c));
                    i4 = i2;
                    i5 = 0;
                }
                c2 = 1;
            } else {
                if (c2 == 1) {
                    v(b(4, i4, i5, bVar.f2007c));
                    i4 = i2;
                    i5 = 0;
                }
                c2 = 0;
            }
            i5++;
            i2++;
        }
        if (i5 != bVar.f2008d) {
            Object obj = bVar.f2007c;
            a(bVar);
            bVar = b(4, i4, i5, obj);
        }
        if (c2 == 0) {
            k(bVar);
        } else {
            v(bVar);
        }
    }

    private boolean h(int i2) {
        int size = this.f2000c.size();
        for (int i3 = 0; i3 < size; i3++) {
            b bVar = this.f2000c.get(i3);
            int i4 = bVar.a;
            if (i4 == 8) {
                if (n(bVar.f2008d, i3 + 1) == i2) {
                    return true;
                }
            } else if (i4 == 1) {
                int i5 = bVar.f2006b;
                int i6 = bVar.f2008d + i5;
                while (i5 < i6) {
                    if (n(i5, i3 + 1) == i2) {
                        return true;
                    }
                    i5++;
                }
            } else {
                continue;
            }
        }
        return false;
    }

    private void k(b bVar) {
        int i2;
        int i3 = bVar.a;
        if (i3 != 1 && i3 != 8) {
            int z = z(bVar.f2006b, i3);
            int i4 = bVar.f2006b;
            int i5 = bVar.a;
            if (i5 == 2) {
                i2 = 0;
            } else {
                if (i5 != 4) {
                    throw new IllegalArgumentException("op should be remove or update." + bVar);
                }
                i2 = 1;
            }
            int i6 = 1;
            for (int i7 = 1; i7 < bVar.f2008d; i7++) {
                int z2 = z(bVar.f2006b + (i2 * i7), bVar.a);
                int i8 = bVar.a;
                if (i8 == 2 ? z2 == z : i8 == 4 && z2 == z + 1) {
                    i6++;
                } else {
                    b b2 = b(i8, z, i6, bVar.f2007c);
                    l(b2, i4);
                    a(b2);
                    if (bVar.a == 4) {
                        i4 += i6;
                    }
                    z = z2;
                    i6 = 1;
                }
            }
            Object obj = bVar.f2007c;
            a(bVar);
            if (i6 > 0) {
                b b3 = b(bVar.a, z, i6, obj);
                l(b3, i4);
                a(b3);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("should not dispatch add or move for pre layout");
    }

    private void v(b bVar) {
        this.f2000c.add(bVar);
        int i2 = bVar.a;
        if (i2 == 1) {
            this.f2001d.g(bVar.f2006b, bVar.f2008d);
            return;
        }
        if (i2 == 2) {
            this.f2001d.f(bVar.f2006b, bVar.f2008d);
            return;
        }
        if (i2 == 4) {
            this.f2001d.c(bVar.f2006b, bVar.f2008d, bVar.f2007c);
        } else {
            if (i2 == 8) {
                this.f2001d.a(bVar.f2006b, bVar.f2008d);
                return;
            }
            throw new IllegalArgumentException("Unknown update op type for " + bVar);
        }
    }

    private int z(int i2, int i3) {
        int i4;
        int i5;
        for (int size = this.f2000c.size() - 1; size >= 0; size--) {
            b bVar = this.f2000c.get(size);
            int i6 = bVar.a;
            if (i6 == 8) {
                int i7 = bVar.f2006b;
                int i8 = bVar.f2008d;
                if (i7 < i8) {
                    i5 = i7;
                    i4 = i8;
                } else {
                    i4 = i7;
                    i5 = i8;
                }
                if (i2 < i5 || i2 > i4) {
                    if (i2 < i7) {
                        if (i3 == 1) {
                            bVar.f2006b = i7 + 1;
                            bVar.f2008d = i8 + 1;
                        } else if (i3 == 2) {
                            bVar.f2006b = i7 - 1;
                            bVar.f2008d = i8 - 1;
                        }
                    }
                } else if (i5 == i7) {
                    if (i3 == 1) {
                        bVar.f2008d = i8 + 1;
                    } else if (i3 == 2) {
                        bVar.f2008d = i8 - 1;
                    }
                    i2++;
                } else {
                    if (i3 == 1) {
                        bVar.f2006b = i7 + 1;
                    } else if (i3 == 2) {
                        bVar.f2006b = i7 - 1;
                    }
                    i2--;
                }
            } else {
                int i9 = bVar.f2006b;
                if (i9 <= i2) {
                    if (i6 == 1) {
                        i2 -= bVar.f2008d;
                    } else if (i6 == 2) {
                        i2 += bVar.f2008d;
                    }
                } else if (i3 == 1) {
                    bVar.f2006b = i9 + 1;
                } else if (i3 == 2) {
                    bVar.f2006b = i9 - 1;
                }
            }
        }
        for (int size2 = this.f2000c.size() - 1; size2 >= 0; size2--) {
            b bVar2 = this.f2000c.get(size2);
            if (bVar2.a == 8) {
                int i10 = bVar2.f2008d;
                if (i10 == bVar2.f2006b || i10 < 0) {
                    this.f2000c.remove(size2);
                    a(bVar2);
                }
            } else if (bVar2.f2008d <= 0) {
                this.f2000c.remove(size2);
                a(bVar2);
            }
        }
        return i2;
    }

    @Override // androidx.recyclerview.widget.m.a
    public void a(b bVar) {
        if (this.f2003f) {
            return;
        }
        bVar.f2007c = null;
        this.a.a(bVar);
    }

    @Override // androidx.recyclerview.widget.m.a
    public b b(int i2, int i3, int i4, Object obj) {
        b b2 = this.a.b();
        if (b2 == null) {
            return new b(i2, i3, i4, obj);
        }
        b2.a = i2;
        b2.f2006b = i3;
        b2.f2008d = i4;
        b2.f2007c = obj;
        return b2;
    }

    public int e(int i2) {
        int size = this.f1999b.size();
        for (int i3 = 0; i3 < size; i3++) {
            b bVar = this.f1999b.get(i3);
            int i4 = bVar.a;
            if (i4 != 1) {
                if (i4 == 2) {
                    int i5 = bVar.f2006b;
                    if (i5 <= i2) {
                        int i6 = bVar.f2008d;
                        if (i5 + i6 > i2) {
                            return -1;
                        }
                        i2 -= i6;
                    } else {
                        continue;
                    }
                } else if (i4 == 8) {
                    int i7 = bVar.f2006b;
                    if (i7 == i2) {
                        i2 = bVar.f2008d;
                    } else {
                        if (i7 < i2) {
                            i2--;
                        }
                        if (bVar.f2008d <= i2) {
                            i2++;
                        }
                    }
                }
            } else if (bVar.f2006b <= i2) {
                i2 += bVar.f2008d;
            }
        }
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i() {
        int size = this.f2000c.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.f2001d.d(this.f2000c.get(i2));
        }
        x(this.f2000c);
        this.f2005h = 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void j() {
        i();
        int size = this.f1999b.size();
        for (int i2 = 0; i2 < size; i2++) {
            b bVar = this.f1999b.get(i2);
            int i3 = bVar.a;
            if (i3 == 1) {
                this.f2001d.d(bVar);
                this.f2001d.g(bVar.f2006b, bVar.f2008d);
            } else if (i3 == 2) {
                this.f2001d.d(bVar);
                this.f2001d.h(bVar.f2006b, bVar.f2008d);
            } else if (i3 == 4) {
                this.f2001d.d(bVar);
                this.f2001d.c(bVar.f2006b, bVar.f2008d, bVar.f2007c);
            } else if (i3 == 8) {
                this.f2001d.d(bVar);
                this.f2001d.a(bVar.f2006b, bVar.f2008d);
            }
            Runnable runnable = this.f2002e;
            if (runnable != null) {
                runnable.run();
            }
        }
        x(this.f1999b);
        this.f2005h = 0;
    }

    void l(b bVar, int i2) {
        this.f2001d.b(bVar);
        int i3 = bVar.a;
        if (i3 == 2) {
            this.f2001d.h(i2, bVar.f2008d);
        } else {
            if (i3 == 4) {
                this.f2001d.c(i2, bVar.f2008d, bVar.f2007c);
                return;
            }
            throw new IllegalArgumentException("only remove and update ops can be dispatched in first pass");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int m(int i2) {
        return n(i2, 0);
    }

    int n(int i2, int i3) {
        int size = this.f2000c.size();
        while (i3 < size) {
            b bVar = this.f2000c.get(i3);
            int i4 = bVar.a;
            if (i4 == 8) {
                int i5 = bVar.f2006b;
                if (i5 == i2) {
                    i2 = bVar.f2008d;
                } else {
                    if (i5 < i2) {
                        i2--;
                    }
                    if (bVar.f2008d <= i2) {
                        i2++;
                    }
                }
            } else {
                int i6 = bVar.f2006b;
                if (i6 > i2) {
                    continue;
                } else if (i4 == 2) {
                    int i7 = bVar.f2008d;
                    if (i2 < i6 + i7) {
                        return -1;
                    }
                    i2 -= i7;
                } else if (i4 == 1) {
                    i2 += bVar.f2008d;
                }
            }
            i3++;
        }
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean o(int i2) {
        return (i2 & this.f2005h) != 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean p() {
        return this.f1999b.size() > 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean q() {
        return (this.f2000c.isEmpty() || this.f1999b.isEmpty()) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean r(int i2, int i3, Object obj) {
        if (i3 < 1) {
            return false;
        }
        this.f1999b.add(b(4, i2, i3, obj));
        this.f2005h |= 4;
        return this.f1999b.size() == 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean s(int i2, int i3) {
        if (i3 < 1) {
            return false;
        }
        this.f1999b.add(b(1, i2, i3, null));
        this.f2005h |= 1;
        return this.f1999b.size() == 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean t(int i2, int i3, int i4) {
        if (i2 == i3) {
            return false;
        }
        if (i4 == 1) {
            this.f1999b.add(b(8, i2, i3, null));
            this.f2005h |= 8;
            return this.f1999b.size() == 1;
        }
        throw new IllegalArgumentException("Moving more than 1 item is not supported yet");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean u(int i2, int i3) {
        if (i3 < 1) {
            return false;
        }
        this.f1999b.add(b(2, i2, i3, null));
        this.f2005h |= 2;
        return this.f1999b.size() == 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void w() {
        this.f2004g.b(this.f1999b);
        int size = this.f1999b.size();
        for (int i2 = 0; i2 < size; i2++) {
            b bVar = this.f1999b.get(i2);
            int i3 = bVar.a;
            if (i3 == 1) {
                c(bVar);
            } else if (i3 == 2) {
                f(bVar);
            } else if (i3 == 4) {
                g(bVar);
            } else if (i3 == 8) {
                d(bVar);
            }
            Runnable runnable = this.f2002e;
            if (runnable != null) {
                runnable.run();
            }
        }
        this.f1999b.clear();
    }

    void x(List<b> list) {
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            a(list.get(i2));
        }
        list.clear();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void y() {
        x(this.f1999b);
        x(this.f2000c);
        this.f2005h = 0;
    }

    a(InterfaceC0040a interfaceC0040a, boolean z) {
        this.a = new c.i.j.g(30);
        this.f1999b = new ArrayList<>();
        this.f2000c = new ArrayList<>();
        this.f2005h = 0;
        this.f2001d = interfaceC0040a;
        this.f2003f = z;
        this.f2004g = new m(this);
    }
}
