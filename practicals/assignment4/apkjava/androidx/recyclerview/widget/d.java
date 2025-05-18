package androidx.recyclerview.widget;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ChildHelper.java */
/* loaded from: classes.dex */
public class d {
    final b a;

    /* renamed from: b, reason: collision with root package name */
    final a f2013b = new a();

    /* renamed from: c, reason: collision with root package name */
    final List<View> f2014c = new ArrayList();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ChildHelper.java */
    /* loaded from: classes.dex */
    public static class a {
        long a = 0;

        /* renamed from: b, reason: collision with root package name */
        a f2015b;

        a() {
        }

        private void c() {
            if (this.f2015b == null) {
                this.f2015b = new a();
            }
        }

        void a(int i2) {
            if (i2 >= 64) {
                a aVar = this.f2015b;
                if (aVar != null) {
                    aVar.a(i2 - 64);
                    return;
                }
                return;
            }
            this.a &= (1 << i2) ^ (-1);
        }

        int b(int i2) {
            a aVar = this.f2015b;
            if (aVar == null) {
                if (i2 >= 64) {
                    return Long.bitCount(this.a);
                }
                return Long.bitCount(this.a & ((1 << i2) - 1));
            }
            if (i2 < 64) {
                return Long.bitCount(this.a & ((1 << i2) - 1));
            }
            return aVar.b(i2 - 64) + Long.bitCount(this.a);
        }

        boolean d(int i2) {
            if (i2 < 64) {
                return (this.a & (1 << i2)) != 0;
            }
            c();
            return this.f2015b.d(i2 - 64);
        }

        void e(int i2, boolean z) {
            if (i2 >= 64) {
                c();
                this.f2015b.e(i2 - 64, z);
                return;
            }
            long j2 = this.a;
            boolean z2 = (Long.MIN_VALUE & j2) != 0;
            long j3 = (1 << i2) - 1;
            this.a = ((j2 & (j3 ^ (-1))) << 1) | (j2 & j3);
            if (z) {
                h(i2);
            } else {
                a(i2);
            }
            if (z2 || this.f2015b != null) {
                c();
                this.f2015b.e(0, z2);
            }
        }

        boolean f(int i2) {
            if (i2 >= 64) {
                c();
                return this.f2015b.f(i2 - 64);
            }
            long j2 = 1 << i2;
            long j3 = this.a;
            boolean z = (j3 & j2) != 0;
            long j4 = j3 & (j2 ^ (-1));
            this.a = j4;
            long j5 = j2 - 1;
            this.a = (j4 & j5) | Long.rotateRight((j5 ^ (-1)) & j4, 1);
            a aVar = this.f2015b;
            if (aVar != null) {
                if (aVar.d(0)) {
                    h(63);
                }
                this.f2015b.f(0);
            }
            return z;
        }

        void g() {
            this.a = 0L;
            a aVar = this.f2015b;
            if (aVar != null) {
                aVar.g();
            }
        }

        void h(int i2) {
            if (i2 >= 64) {
                c();
                this.f2015b.h(i2 - 64);
            } else {
                this.a |= 1 << i2;
            }
        }

        public String toString() {
            if (this.f2015b == null) {
                return Long.toBinaryString(this.a);
            }
            return this.f2015b.toString() + "xx" + Long.toBinaryString(this.a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ChildHelper.java */
    /* loaded from: classes.dex */
    public interface b {
        View a(int i2);

        void b(View view);

        int c();

        void d();

        int e(View view);

        RecyclerView.c0 f(View view);

        void g(int i2);

        void h(View view);

        void i(View view, int i2);

        void j(int i2);

        void k(View view, int i2, ViewGroup.LayoutParams layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(b bVar) {
        this.a = bVar;
    }

    private int h(int i2) {
        if (i2 < 0) {
            return -1;
        }
        int c2 = this.a.c();
        int i3 = i2;
        while (i3 < c2) {
            int b2 = i2 - (i3 - this.f2013b.b(i3));
            if (b2 == 0) {
                while (this.f2013b.d(i3)) {
                    i3++;
                }
                return i3;
            }
            i3 += b2;
        }
        return -1;
    }

    private void l(View view) {
        this.f2014c.add(view);
        this.a.b(view);
    }

    private boolean t(View view) {
        if (!this.f2014c.remove(view)) {
            return false;
        }
        this.a.h(view);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(View view, int i2, boolean z) {
        int h2;
        if (i2 < 0) {
            h2 = this.a.c();
        } else {
            h2 = h(i2);
        }
        this.f2013b.e(h2, z);
        if (z) {
            l(view);
        }
        this.a.i(view, h2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(View view, boolean z) {
        a(view, -1, z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(View view, int i2, ViewGroup.LayoutParams layoutParams, boolean z) {
        int h2;
        if (i2 < 0) {
            h2 = this.a.c();
        } else {
            h2 = h(i2);
        }
        this.f2013b.e(h2, z);
        if (z) {
            l(view);
        }
        this.a.k(view, h2, layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(int i2) {
        int h2 = h(i2);
        this.f2013b.f(h2);
        this.a.g(h2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View e(int i2) {
        int size = this.f2014c.size();
        for (int i3 = 0; i3 < size; i3++) {
            View view = this.f2014c.get(i3);
            RecyclerView.c0 f2 = this.a.f(view);
            if (f2.getLayoutPosition() == i2 && !f2.isInvalid() && !f2.isRemoved()) {
                return view;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View f(int i2) {
        return this.a.a(h(i2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int g() {
        return this.a.c() - this.f2014c.size();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View i(int i2) {
        return this.a.a(i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int j() {
        return this.a.c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k(View view) {
        int e2 = this.a.e(view);
        if (e2 >= 0) {
            this.f2013b.h(e2);
            l(view);
        } else {
            throw new IllegalArgumentException("view is not a child, cannot hide " + view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int m(View view) {
        int e2 = this.a.e(view);
        if (e2 == -1 || this.f2013b.d(e2)) {
            return -1;
        }
        return e2 - this.f2013b.b(e2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean n(View view) {
        return this.f2014c.contains(view);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void o() {
        this.f2013b.g();
        for (int size = this.f2014c.size() - 1; size >= 0; size--) {
            this.a.h(this.f2014c.get(size));
            this.f2014c.remove(size);
        }
        this.a.d();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void p(View view) {
        int e2 = this.a.e(view);
        if (e2 < 0) {
            return;
        }
        if (this.f2013b.f(e2)) {
            t(view);
        }
        this.a.j(e2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void q(int i2) {
        int h2 = h(i2);
        View a2 = this.a.a(h2);
        if (a2 == null) {
            return;
        }
        if (this.f2013b.f(h2)) {
            t(a2);
        }
        this.a.j(h2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean r(View view) {
        int e2 = this.a.e(view);
        if (e2 == -1) {
            t(view);
            return true;
        }
        if (!this.f2013b.d(e2)) {
            return false;
        }
        this.f2013b.f(e2);
        t(view);
        this.a.j(e2);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void s(View view) {
        int e2 = this.a.e(view);
        if (e2 >= 0) {
            if (this.f2013b.d(e2)) {
                this.f2013b.a(e2);
                t(view);
                return;
            } else {
                throw new RuntimeException("trying to unhide a view that was not hidden" + view);
            }
        }
        throw new IllegalArgumentException("view is not a child, cannot hide " + view);
    }

    public String toString() {
        return this.f2013b.toString() + ", hidden list:" + this.f2014c.size();
    }
}
