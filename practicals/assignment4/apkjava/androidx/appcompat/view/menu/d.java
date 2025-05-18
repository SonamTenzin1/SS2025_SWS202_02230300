package androidx.appcompat.view.menu;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.os.Parcelable;
import android.os.SystemClock;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.view.menu.m;
import androidx.appcompat.widget.e0;
import androidx.appcompat.widget.f0;
import androidx.core.view.u;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CascadingMenuPopup.java */
/* loaded from: classes.dex */
public final class d extends k implements m, View.OnKeyListener, PopupWindow.OnDismissListener {

    /* renamed from: g, reason: collision with root package name */
    private static final int f275g = c.a.g.f2735e;
    private int A;
    private boolean C;
    private m.a D;
    ViewTreeObserver E;
    private PopupWindow.OnDismissListener F;
    boolean G;

    /* renamed from: h, reason: collision with root package name */
    private final Context f276h;

    /* renamed from: i, reason: collision with root package name */
    private final int f277i;

    /* renamed from: j, reason: collision with root package name */
    private final int f278j;

    /* renamed from: k, reason: collision with root package name */
    private final int f279k;
    private final boolean l;
    final Handler m;
    private View u;
    View v;
    private boolean x;
    private boolean y;
    private int z;
    private final List<g> n = new ArrayList();
    final List<C0011d> o = new ArrayList();
    final ViewTreeObserver.OnGlobalLayoutListener p = new a();
    private final View.OnAttachStateChangeListener q = new b();
    private final e0 r = new c();
    private int s = 0;
    private int t = 0;
    private boolean B = false;
    private int w = E();

    /* compiled from: CascadingMenuPopup.java */
    /* loaded from: classes.dex */
    class a implements ViewTreeObserver.OnGlobalLayoutListener {
        a() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (!d.this.a() || d.this.o.size() <= 0 || d.this.o.get(0).a.A()) {
                return;
            }
            View view = d.this.v;
            if (view != null && view.isShown()) {
                Iterator<C0011d> it = d.this.o.iterator();
                while (it.hasNext()) {
                    it.next().a.show();
                }
                return;
            }
            d.this.dismiss();
        }
    }

    /* compiled from: CascadingMenuPopup.java */
    /* loaded from: classes.dex */
    class b implements View.OnAttachStateChangeListener {
        b() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            ViewTreeObserver viewTreeObserver = d.this.E;
            if (viewTreeObserver != null) {
                if (!viewTreeObserver.isAlive()) {
                    d.this.E = view.getViewTreeObserver();
                }
                d dVar = d.this;
                dVar.E.removeGlobalOnLayoutListener(dVar.p);
            }
            view.removeOnAttachStateChangeListener(this);
        }
    }

    /* compiled from: CascadingMenuPopup.java */
    /* loaded from: classes.dex */
    class c implements e0 {

        /* compiled from: CascadingMenuPopup.java */
        /* loaded from: classes.dex */
        class a implements Runnable {

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ C0011d f283f;

            /* renamed from: g, reason: collision with root package name */
            final /* synthetic */ MenuItem f284g;

            /* renamed from: h, reason: collision with root package name */
            final /* synthetic */ g f285h;

            a(C0011d c0011d, MenuItem menuItem, g gVar) {
                this.f283f = c0011d;
                this.f284g = menuItem;
                this.f285h = gVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                C0011d c0011d = this.f283f;
                if (c0011d != null) {
                    d.this.G = true;
                    c0011d.f287b.e(false);
                    d.this.G = false;
                }
                if (this.f284g.isEnabled() && this.f284g.hasSubMenu()) {
                    this.f285h.N(this.f284g, 4);
                }
            }
        }

        c() {
        }

        @Override // androidx.appcompat.widget.e0
        public void d(g gVar, MenuItem menuItem) {
            d.this.m.removeCallbacksAndMessages(null);
            int size = d.this.o.size();
            int i2 = 0;
            while (true) {
                if (i2 >= size) {
                    i2 = -1;
                    break;
                } else if (gVar == d.this.o.get(i2).f287b) {
                    break;
                } else {
                    i2++;
                }
            }
            if (i2 == -1) {
                return;
            }
            int i3 = i2 + 1;
            d.this.m.postAtTime(new a(i3 < d.this.o.size() ? d.this.o.get(i3) : null, menuItem, gVar), gVar, SystemClock.uptimeMillis() + 200);
        }

        @Override // androidx.appcompat.widget.e0
        public void g(g gVar, MenuItem menuItem) {
            d.this.m.removeCallbacksAndMessages(gVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: CascadingMenuPopup.java */
    /* renamed from: androidx.appcompat.view.menu.d$d, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0011d {
        public final f0 a;

        /* renamed from: b, reason: collision with root package name */
        public final g f287b;

        /* renamed from: c, reason: collision with root package name */
        public final int f288c;

        public C0011d(f0 f0Var, g gVar, int i2) {
            this.a = f0Var;
            this.f287b = gVar;
            this.f288c = i2;
        }

        public ListView a() {
            return this.a.j();
        }
    }

    public d(Context context, View view, int i2, int i3, boolean z) {
        this.f276h = context;
        this.u = view;
        this.f278j = i2;
        this.f279k = i3;
        this.l = z;
        Resources resources = context.getResources();
        this.f277i = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(c.a.d.f2704d));
        this.m = new Handler();
    }

    private f0 A() {
        f0 f0Var = new f0(this.f276h, null, this.f278j, this.f279k);
        f0Var.S(this.r);
        f0Var.K(this);
        f0Var.J(this);
        f0Var.C(this.u);
        f0Var.F(this.t);
        f0Var.I(true);
        f0Var.H(2);
        return f0Var;
    }

    private int B(g gVar) {
        int size = this.o.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (gVar == this.o.get(i2).f287b) {
                return i2;
            }
        }
        return -1;
    }

    private MenuItem C(g gVar, g gVar2) {
        int size = gVar.size();
        for (int i2 = 0; i2 < size; i2++) {
            MenuItem item = gVar.getItem(i2);
            if (item.hasSubMenu() && gVar2 == item.getSubMenu()) {
                return item;
            }
        }
        return null;
    }

    private View D(C0011d c0011d, g gVar) {
        f fVar;
        int i2;
        int firstVisiblePosition;
        MenuItem C = C(c0011d.f287b, gVar);
        if (C == null) {
            return null;
        }
        ListView a2 = c0011d.a();
        ListAdapter adapter = a2.getAdapter();
        int i3 = 0;
        if (adapter instanceof HeaderViewListAdapter) {
            HeaderViewListAdapter headerViewListAdapter = (HeaderViewListAdapter) adapter;
            i2 = headerViewListAdapter.getHeadersCount();
            fVar = (f) headerViewListAdapter.getWrappedAdapter();
        } else {
            fVar = (f) adapter;
            i2 = 0;
        }
        int count = fVar.getCount();
        while (true) {
            if (i3 >= count) {
                i3 = -1;
                break;
            }
            if (C == fVar.getItem(i3)) {
                break;
            }
            i3++;
        }
        if (i3 != -1 && (firstVisiblePosition = (i3 + i2) - a2.getFirstVisiblePosition()) >= 0 && firstVisiblePosition < a2.getChildCount()) {
            return a2.getChildAt(firstVisiblePosition);
        }
        return null;
    }

    private int E() {
        return u.y(this.u) == 1 ? 0 : 1;
    }

    private int F(int i2) {
        List<C0011d> list = this.o;
        ListView a2 = list.get(list.size() - 1).a();
        int[] iArr = new int[2];
        a2.getLocationOnScreen(iArr);
        Rect rect = new Rect();
        this.v.getWindowVisibleDisplayFrame(rect);
        return this.w == 1 ? (iArr[0] + a2.getWidth()) + i2 > rect.right ? 0 : 1 : iArr[0] - i2 < 0 ? 1 : 0;
    }

    private void G(g gVar) {
        C0011d c0011d;
        View view;
        int i2;
        int i3;
        int i4;
        LayoutInflater from = LayoutInflater.from(this.f276h);
        f fVar = new f(gVar, from, this.l, f275g);
        if (!a() && this.B) {
            fVar.d(true);
        } else if (a()) {
            fVar.d(k.y(gVar));
        }
        int p = k.p(fVar, null, this.f276h, this.f277i);
        f0 A = A();
        A.o(fVar);
        A.E(p);
        A.F(this.t);
        if (this.o.size() > 0) {
            List<C0011d> list = this.o;
            c0011d = list.get(list.size() - 1);
            view = D(c0011d, gVar);
        } else {
            c0011d = null;
            view = null;
        }
        if (view != null) {
            A.T(false);
            A.Q(null);
            int F = F(p);
            boolean z = F == 1;
            this.w = F;
            if (Build.VERSION.SDK_INT >= 26) {
                A.C(view);
                i3 = 0;
                i2 = 0;
            } else {
                int[] iArr = new int[2];
                this.u.getLocationOnScreen(iArr);
                int[] iArr2 = new int[2];
                view.getLocationOnScreen(iArr2);
                if ((this.t & 7) == 5) {
                    iArr[0] = iArr[0] + this.u.getWidth();
                    iArr2[0] = iArr2[0] + view.getWidth();
                }
                i2 = iArr2[0] - iArr[0];
                i3 = iArr2[1] - iArr[1];
            }
            if ((this.t & 5) == 5) {
                if (!z) {
                    p = view.getWidth();
                    i4 = i2 - p;
                }
                i4 = i2 + p;
            } else {
                if (z) {
                    p = view.getWidth();
                    i4 = i2 + p;
                }
                i4 = i2 - p;
            }
            A.e(i4);
            A.L(true);
            A.k(i3);
        } else {
            if (this.x) {
                A.e(this.z);
            }
            if (this.y) {
                A.k(this.A);
            }
            A.G(o());
        }
        this.o.add(new C0011d(A, gVar, this.w));
        A.show();
        ListView j2 = A.j();
        j2.setOnKeyListener(this);
        if (c0011d == null && this.C && gVar.z() != null) {
            FrameLayout frameLayout = (FrameLayout) from.inflate(c.a.g.l, (ViewGroup) j2, false);
            TextView textView = (TextView) frameLayout.findViewById(R.id.title);
            frameLayout.setEnabled(false);
            textView.setText(gVar.z());
            j2.addHeaderView(frameLayout, null, false);
            A.show();
        }
    }

    @Override // androidx.appcompat.view.menu.p
    public boolean a() {
        return this.o.size() > 0 && this.o.get(0).a.a();
    }

    @Override // androidx.appcompat.view.menu.m
    public void b(g gVar, boolean z) {
        int B = B(gVar);
        if (B < 0) {
            return;
        }
        int i2 = B + 1;
        if (i2 < this.o.size()) {
            this.o.get(i2).f287b.e(false);
        }
        C0011d remove = this.o.remove(B);
        remove.f287b.Q(this);
        if (this.G) {
            remove.a.R(null);
            remove.a.D(0);
        }
        remove.a.dismiss();
        int size = this.o.size();
        if (size > 0) {
            this.w = this.o.get(size - 1).f288c;
        } else {
            this.w = E();
        }
        if (size != 0) {
            if (z) {
                this.o.get(0).f287b.e(false);
                return;
            }
            return;
        }
        dismiss();
        m.a aVar = this.D;
        if (aVar != null) {
            aVar.b(gVar, true);
        }
        ViewTreeObserver viewTreeObserver = this.E;
        if (viewTreeObserver != null) {
            if (viewTreeObserver.isAlive()) {
                this.E.removeGlobalOnLayoutListener(this.p);
            }
            this.E = null;
        }
        this.v.removeOnAttachStateChangeListener(this.q);
        this.F.onDismiss();
    }

    @Override // androidx.appcompat.view.menu.m
    public void c(boolean z) {
        Iterator<C0011d> it = this.o.iterator();
        while (it.hasNext()) {
            k.z(it.next().a().getAdapter()).notifyDataSetChanged();
        }
    }

    @Override // androidx.appcompat.view.menu.m
    public boolean d() {
        return false;
    }

    @Override // androidx.appcompat.view.menu.p
    public void dismiss() {
        int size = this.o.size();
        if (size > 0) {
            C0011d[] c0011dArr = (C0011d[]) this.o.toArray(new C0011d[size]);
            for (int i2 = size - 1; i2 >= 0; i2--) {
                C0011d c0011d = c0011dArr[i2];
                if (c0011d.a.a()) {
                    c0011d.a.dismiss();
                }
            }
        }
    }

    @Override // androidx.appcompat.view.menu.m
    public void g(m.a aVar) {
        this.D = aVar;
    }

    @Override // androidx.appcompat.view.menu.m
    public void i(Parcelable parcelable) {
    }

    @Override // androidx.appcompat.view.menu.p
    public ListView j() {
        if (this.o.isEmpty()) {
            return null;
        }
        return this.o.get(r0.size() - 1).a();
    }

    @Override // androidx.appcompat.view.menu.m
    public boolean k(r rVar) {
        for (C0011d c0011d : this.o) {
            if (rVar == c0011d.f287b) {
                c0011d.a().requestFocus();
                return true;
            }
        }
        if (!rVar.hasVisibleItems()) {
            return false;
        }
        m(rVar);
        m.a aVar = this.D;
        if (aVar != null) {
            aVar.c(rVar);
        }
        return true;
    }

    @Override // androidx.appcompat.view.menu.m
    public Parcelable l() {
        return null;
    }

    @Override // androidx.appcompat.view.menu.k
    public void m(g gVar) {
        gVar.c(this, this.f276h);
        if (a()) {
            G(gVar);
        } else {
            this.n.add(gVar);
        }
    }

    @Override // androidx.appcompat.view.menu.k
    protected boolean n() {
        return false;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        C0011d c0011d;
        int size = this.o.size();
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                c0011d = null;
                break;
            }
            c0011d = this.o.get(i2);
            if (!c0011d.a.a()) {
                break;
            } else {
                i2++;
            }
        }
        if (c0011d != null) {
            c0011d.f287b.e(false);
        }
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i2, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 1 || i2 != 82) {
            return false;
        }
        dismiss();
        return true;
    }

    @Override // androidx.appcompat.view.menu.k
    public void q(View view) {
        if (this.u != view) {
            this.u = view;
            this.t = androidx.core.view.d.b(this.s, u.y(view));
        }
    }

    @Override // androidx.appcompat.view.menu.k
    public void s(boolean z) {
        this.B = z;
    }

    @Override // androidx.appcompat.view.menu.p
    public void show() {
        if (a()) {
            return;
        }
        Iterator<g> it = this.n.iterator();
        while (it.hasNext()) {
            G(it.next());
        }
        this.n.clear();
        View view = this.u;
        this.v = view;
        if (view != null) {
            boolean z = this.E == null;
            ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
            this.E = viewTreeObserver;
            if (z) {
                viewTreeObserver.addOnGlobalLayoutListener(this.p);
            }
            this.v.addOnAttachStateChangeListener(this.q);
        }
    }

    @Override // androidx.appcompat.view.menu.k
    public void t(int i2) {
        if (this.s != i2) {
            this.s = i2;
            this.t = androidx.core.view.d.b(i2, u.y(this.u));
        }
    }

    @Override // androidx.appcompat.view.menu.k
    public void u(int i2) {
        this.x = true;
        this.z = i2;
    }

    @Override // androidx.appcompat.view.menu.k
    public void v(PopupWindow.OnDismissListener onDismissListener) {
        this.F = onDismissListener;
    }

    @Override // androidx.appcompat.view.menu.k
    public void w(boolean z) {
        this.C = z;
    }

    @Override // androidx.appcompat.view.menu.k
    public void x(int i2) {
        this.y = true;
        this.A = i2;
    }
}
