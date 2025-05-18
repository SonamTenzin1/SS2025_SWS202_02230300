package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseBooleanArray;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.view.menu.m;
import androidx.appcompat.view.menu.n;
import androidx.appcompat.widget.ActionMenuView;
import androidx.core.view.b;
import java.util.ArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ActionMenuPresenter extends androidx.appcompat.view.menu.b implements b.a {
    private boolean A;
    private int B;
    private final SparseBooleanArray C;
    e D;
    a E;
    c F;
    private b G;
    final f H;
    int I;
    d p;
    private Drawable q;
    private boolean r;
    private boolean s;
    private boolean t;
    private int u;
    private int v;
    private int w;
    private boolean x;
    private boolean y;
    private boolean z;

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"BanParcelableUsage"})
    /* loaded from: classes.dex */
    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* renamed from: f, reason: collision with root package name */
        public int f374f;

        /* loaded from: classes.dex */
        class a implements Parcelable.Creator<SavedState> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i2) {
                return new SavedState[i2];
            }
        }

        SavedState() {
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeInt(this.f374f);
        }

        SavedState(Parcel parcel) {
            this.f374f = parcel.readInt();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a extends androidx.appcompat.view.menu.l {
        public a(Context context, androidx.appcompat.view.menu.r rVar, View view) {
            super(context, rVar, view, false, c.a.a.l);
            if (!((androidx.appcompat.view.menu.i) rVar.getItem()).l()) {
                View view2 = ActionMenuPresenter.this.p;
                f(view2 == null ? (View) ((androidx.appcompat.view.menu.b) ActionMenuPresenter.this).n : view2);
            }
            j(ActionMenuPresenter.this.H);
        }

        @Override // androidx.appcompat.view.menu.l
        protected void e() {
            ActionMenuPresenter actionMenuPresenter = ActionMenuPresenter.this;
            actionMenuPresenter.E = null;
            actionMenuPresenter.I = 0;
            super.e();
        }
    }

    /* loaded from: classes.dex */
    private class b extends ActionMenuItemView.b {
        b() {
        }

        @Override // androidx.appcompat.view.menu.ActionMenuItemView.b
        public androidx.appcompat.view.menu.p a() {
            a aVar = ActionMenuPresenter.this.E;
            if (aVar != null) {
                return aVar.c();
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class c implements Runnable {

        /* renamed from: f, reason: collision with root package name */
        private e f375f;

        public c(e eVar) {
            this.f375f = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (((androidx.appcompat.view.menu.b) ActionMenuPresenter.this).f269h != null) {
                ((androidx.appcompat.view.menu.b) ActionMenuPresenter.this).f269h.d();
            }
            View view = (View) ((androidx.appcompat.view.menu.b) ActionMenuPresenter.this).n;
            if (view != null && view.getWindowToken() != null && this.f375f.m()) {
                ActionMenuPresenter.this.D = this.f375f;
            }
            ActionMenuPresenter.this.F = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class d extends AppCompatImageView implements ActionMenuView.a {

        /* loaded from: classes.dex */
        class a extends b0 {
            final /* synthetic */ ActionMenuPresenter o;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(View view, ActionMenuPresenter actionMenuPresenter) {
                super(view);
                this.o = actionMenuPresenter;
            }

            @Override // androidx.appcompat.widget.b0
            public androidx.appcompat.view.menu.p b() {
                e eVar = ActionMenuPresenter.this.D;
                if (eVar == null) {
                    return null;
                }
                return eVar.c();
            }

            @Override // androidx.appcompat.widget.b0
            public boolean c() {
                ActionMenuPresenter.this.M();
                return true;
            }

            @Override // androidx.appcompat.widget.b0
            public boolean d() {
                ActionMenuPresenter actionMenuPresenter = ActionMenuPresenter.this;
                if (actionMenuPresenter.F != null) {
                    return false;
                }
                actionMenuPresenter.D();
                return true;
            }
        }

        public d(Context context) {
            super(context, null, c.a.a.f2694k);
            setClickable(true);
            setFocusable(true);
            setVisibility(0);
            setEnabled(true);
            s0.a(this, getContentDescription());
            setOnTouchListener(new a(this, ActionMenuPresenter.this));
        }

        @Override // androidx.appcompat.widget.ActionMenuView.a
        public boolean a() {
            return false;
        }

        @Override // androidx.appcompat.widget.ActionMenuView.a
        public boolean b() {
            return false;
        }

        @Override // android.view.View
        public boolean performClick() {
            if (super.performClick()) {
                return true;
            }
            playSoundEffect(0);
            ActionMenuPresenter.this.M();
            return true;
        }

        @Override // android.widget.ImageView
        protected boolean setFrame(int i2, int i3, int i4, int i5) {
            boolean frame = super.setFrame(i2, i3, i4, i5);
            Drawable drawable = getDrawable();
            Drawable background = getBackground();
            if (drawable != null && background != null) {
                int width = getWidth();
                int height = getHeight();
                int max = Math.max(width, height) / 2;
                int paddingLeft = (width + (getPaddingLeft() - getPaddingRight())) / 2;
                int paddingTop = (height + (getPaddingTop() - getPaddingBottom())) / 2;
                androidx.core.graphics.drawable.a.l(background, paddingLeft - max, paddingTop - max, paddingLeft + max, paddingTop + max);
            }
            return frame;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class e extends androidx.appcompat.view.menu.l {
        public e(Context context, androidx.appcompat.view.menu.g gVar, View view, boolean z) {
            super(context, gVar, view, z, c.a.a.l);
            h(8388613);
            j(ActionMenuPresenter.this.H);
        }

        @Override // androidx.appcompat.view.menu.l
        protected void e() {
            if (((androidx.appcompat.view.menu.b) ActionMenuPresenter.this).f269h != null) {
                ((androidx.appcompat.view.menu.b) ActionMenuPresenter.this).f269h.close();
            }
            ActionMenuPresenter.this.D = null;
            super.e();
        }
    }

    /* loaded from: classes.dex */
    private class f implements m.a {
        f() {
        }

        @Override // androidx.appcompat.view.menu.m.a
        public void b(androidx.appcompat.view.menu.g gVar, boolean z) {
            if (gVar instanceof androidx.appcompat.view.menu.r) {
                gVar.F().e(false);
            }
            m.a o = ActionMenuPresenter.this.o();
            if (o != null) {
                o.b(gVar, z);
            }
        }

        @Override // androidx.appcompat.view.menu.m.a
        public boolean c(androidx.appcompat.view.menu.g gVar) {
            if (gVar == ((androidx.appcompat.view.menu.b) ActionMenuPresenter.this).f269h) {
                return false;
            }
            ActionMenuPresenter.this.I = ((androidx.appcompat.view.menu.r) gVar).getItem().getItemId();
            m.a o = ActionMenuPresenter.this.o();
            if (o != null) {
                return o.c(gVar);
            }
            return false;
        }
    }

    public ActionMenuPresenter(Context context) {
        super(context, c.a.g.f2733c, c.a.g.f2732b);
        this.C = new SparseBooleanArray();
        this.H = new f();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private View B(MenuItem menuItem) {
        ViewGroup viewGroup = (ViewGroup) this.n;
        if (viewGroup == null) {
            return null;
        }
        int childCount = viewGroup.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = viewGroup.getChildAt(i2);
            if ((childAt instanceof n.a) && ((n.a) childAt).getItemData() == menuItem) {
                return childAt;
            }
        }
        return null;
    }

    public boolean A() {
        return D() | E();
    }

    public Drawable C() {
        d dVar = this.p;
        if (dVar != null) {
            return dVar.getDrawable();
        }
        if (this.r) {
            return this.q;
        }
        return null;
    }

    public boolean D() {
        Object obj;
        c cVar = this.F;
        if (cVar != null && (obj = this.n) != null) {
            ((View) obj).removeCallbacks(cVar);
            this.F = null;
            return true;
        }
        e eVar = this.D;
        if (eVar == null) {
            return false;
        }
        eVar.b();
        return true;
    }

    public boolean E() {
        a aVar = this.E;
        if (aVar == null) {
            return false;
        }
        aVar.b();
        return true;
    }

    public boolean F() {
        return this.F != null || G();
    }

    public boolean G() {
        e eVar = this.D;
        return eVar != null && eVar.d();
    }

    public void H(Configuration configuration) {
        if (!this.x) {
            this.w = c.a.o.a.b(this.f268g).d();
        }
        androidx.appcompat.view.menu.g gVar = this.f269h;
        if (gVar != null) {
            gVar.M(true);
        }
    }

    public void I(boolean z) {
        this.A = z;
    }

    public void J(ActionMenuView actionMenuView) {
        this.n = actionMenuView;
        actionMenuView.b(this.f269h);
    }

    public void K(Drawable drawable) {
        d dVar = this.p;
        if (dVar != null) {
            dVar.setImageDrawable(drawable);
        } else {
            this.r = true;
            this.q = drawable;
        }
    }

    public void L(boolean z) {
        this.s = z;
        this.t = true;
    }

    public boolean M() {
        androidx.appcompat.view.menu.g gVar;
        if (!this.s || G() || (gVar = this.f269h) == null || this.n == null || this.F != null || gVar.B().isEmpty()) {
            return false;
        }
        c cVar = new c(new e(this.f268g, this.f269h, this.p, true));
        this.F = cVar;
        ((View) this.n).post(cVar);
        return true;
    }

    @Override // androidx.appcompat.view.menu.b, androidx.appcompat.view.menu.m
    public void b(androidx.appcompat.view.menu.g gVar, boolean z) {
        A();
        super.b(gVar, z);
    }

    @Override // androidx.appcompat.view.menu.b, androidx.appcompat.view.menu.m
    public void c(boolean z) {
        super.c(z);
        ((View) this.n).requestLayout();
        androidx.appcompat.view.menu.g gVar = this.f269h;
        boolean z2 = false;
        if (gVar != null) {
            ArrayList<androidx.appcompat.view.menu.i> u = gVar.u();
            int size = u.size();
            for (int i2 = 0; i2 < size; i2++) {
                androidx.core.view.b b2 = u.get(i2).b();
                if (b2 != null) {
                    b2.i(this);
                }
            }
        }
        androidx.appcompat.view.menu.g gVar2 = this.f269h;
        ArrayList<androidx.appcompat.view.menu.i> B = gVar2 != null ? gVar2.B() : null;
        if (this.s && B != null) {
            int size2 = B.size();
            if (size2 == 1) {
                z2 = !B.get(0).isActionViewExpanded();
            } else if (size2 > 0) {
                z2 = true;
            }
        }
        if (z2) {
            if (this.p == null) {
                this.p = new d(this.f267f);
            }
            ViewGroup viewGroup = (ViewGroup) this.p.getParent();
            if (viewGroup != this.n) {
                if (viewGroup != null) {
                    viewGroup.removeView(this.p);
                }
                ActionMenuView actionMenuView = (ActionMenuView) this.n;
                actionMenuView.addView(this.p, actionMenuView.F());
            }
        } else {
            d dVar = this.p;
            if (dVar != null) {
                Object parent = dVar.getParent();
                Object obj = this.n;
                if (parent == obj) {
                    ((ViewGroup) obj).removeView(this.p);
                }
            }
        }
        ((ActionMenuView) this.n).setOverflowReserved(this.s);
    }

    @Override // androidx.appcompat.view.menu.m
    public boolean d() {
        ArrayList<androidx.appcompat.view.menu.i> arrayList;
        int i2;
        int i3;
        int i4;
        int i5;
        ActionMenuPresenter actionMenuPresenter = this;
        androidx.appcompat.view.menu.g gVar = actionMenuPresenter.f269h;
        View view = null;
        int i6 = 0;
        if (gVar != null) {
            arrayList = gVar.G();
            i2 = arrayList.size();
        } else {
            arrayList = null;
            i2 = 0;
        }
        int i7 = actionMenuPresenter.w;
        int i8 = actionMenuPresenter.v;
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        ViewGroup viewGroup = (ViewGroup) actionMenuPresenter.n;
        boolean z = false;
        int i9 = 0;
        int i10 = 0;
        for (int i11 = 0; i11 < i2; i11++) {
            androidx.appcompat.view.menu.i iVar = arrayList.get(i11);
            if (iVar.o()) {
                i9++;
            } else if (iVar.n()) {
                i10++;
            } else {
                z = true;
            }
            if (actionMenuPresenter.A && iVar.isActionViewExpanded()) {
                i7 = 0;
            }
        }
        if (actionMenuPresenter.s && (z || i10 + i9 > i7)) {
            i7--;
        }
        int i12 = i7 - i9;
        SparseBooleanArray sparseBooleanArray = actionMenuPresenter.C;
        sparseBooleanArray.clear();
        if (actionMenuPresenter.y) {
            int i13 = actionMenuPresenter.B;
            i4 = i8 / i13;
            i3 = i13 + ((i8 % i13) / i4);
        } else {
            i3 = 0;
            i4 = 0;
        }
        int i14 = 0;
        int i15 = 0;
        while (i14 < i2) {
            androidx.appcompat.view.menu.i iVar2 = arrayList.get(i14);
            if (iVar2.o()) {
                View p = actionMenuPresenter.p(iVar2, view, viewGroup);
                if (actionMenuPresenter.y) {
                    i4 -= ActionMenuView.L(p, i3, i4, makeMeasureSpec, i6);
                } else {
                    p.measure(makeMeasureSpec, makeMeasureSpec);
                }
                int measuredWidth = p.getMeasuredWidth();
                i8 -= measuredWidth;
                if (i15 == 0) {
                    i15 = measuredWidth;
                }
                int groupId = iVar2.getGroupId();
                if (groupId != 0) {
                    sparseBooleanArray.put(groupId, true);
                }
                iVar2.u(true);
                i5 = i2;
            } else if (iVar2.n()) {
                int groupId2 = iVar2.getGroupId();
                boolean z2 = sparseBooleanArray.get(groupId2);
                boolean z3 = (i12 > 0 || z2) && i8 > 0 && (!actionMenuPresenter.y || i4 > 0);
                boolean z4 = z3;
                i5 = i2;
                if (z3) {
                    View p2 = actionMenuPresenter.p(iVar2, null, viewGroup);
                    if (actionMenuPresenter.y) {
                        int L = ActionMenuView.L(p2, i3, i4, makeMeasureSpec, 0);
                        i4 -= L;
                        if (L == 0) {
                            z4 = false;
                        }
                    } else {
                        p2.measure(makeMeasureSpec, makeMeasureSpec);
                    }
                    boolean z5 = z4;
                    int measuredWidth2 = p2.getMeasuredWidth();
                    i8 -= measuredWidth2;
                    if (i15 == 0) {
                        i15 = measuredWidth2;
                    }
                    z3 = z5 & (!actionMenuPresenter.y ? i8 + i15 <= 0 : i8 < 0);
                }
                if (z3 && groupId2 != 0) {
                    sparseBooleanArray.put(groupId2, true);
                } else if (z2) {
                    sparseBooleanArray.put(groupId2, false);
                    for (int i16 = 0; i16 < i14; i16++) {
                        androidx.appcompat.view.menu.i iVar3 = arrayList.get(i16);
                        if (iVar3.getGroupId() == groupId2) {
                            if (iVar3.l()) {
                                i12++;
                            }
                            iVar3.u(false);
                        }
                    }
                }
                if (z3) {
                    i12--;
                }
                iVar2.u(z3);
            } else {
                i5 = i2;
                iVar2.u(false);
                i14++;
                view = null;
                actionMenuPresenter = this;
                i2 = i5;
                i6 = 0;
            }
            i14++;
            view = null;
            actionMenuPresenter = this;
            i2 = i5;
            i6 = 0;
        }
        return true;
    }

    @Override // androidx.appcompat.view.menu.b, androidx.appcompat.view.menu.m
    public void h(Context context, androidx.appcompat.view.menu.g gVar) {
        super.h(context, gVar);
        Resources resources = context.getResources();
        c.a.o.a b2 = c.a.o.a.b(context);
        if (!this.t) {
            this.s = b2.h();
        }
        if (!this.z) {
            this.u = b2.c();
        }
        if (!this.x) {
            this.w = b2.d();
        }
        int i2 = this.u;
        if (this.s) {
            if (this.p == null) {
                d dVar = new d(this.f267f);
                this.p = dVar;
                if (this.r) {
                    dVar.setImageDrawable(this.q);
                    this.q = null;
                    this.r = false;
                }
                int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                this.p.measure(makeMeasureSpec, makeMeasureSpec);
            }
            i2 -= this.p.getMeasuredWidth();
        } else {
            this.p = null;
        }
        this.v = i2;
        this.B = (int) (resources.getDisplayMetrics().density * 56.0f);
    }

    @Override // androidx.appcompat.view.menu.m
    public void i(Parcelable parcelable) {
        int i2;
        MenuItem findItem;
        if ((parcelable instanceof SavedState) && (i2 = ((SavedState) parcelable).f374f) > 0 && (findItem = this.f269h.findItem(i2)) != null) {
            k((androidx.appcompat.view.menu.r) findItem.getSubMenu());
        }
    }

    @Override // androidx.appcompat.view.menu.b
    public void j(androidx.appcompat.view.menu.i iVar, n.a aVar) {
        aVar.e(iVar, 0);
        ActionMenuItemView actionMenuItemView = (ActionMenuItemView) aVar;
        actionMenuItemView.setItemInvoker((ActionMenuView) this.n);
        if (this.G == null) {
            this.G = new b();
        }
        actionMenuItemView.setPopupCallback(this.G);
    }

    @Override // androidx.appcompat.view.menu.b, androidx.appcompat.view.menu.m
    public boolean k(androidx.appcompat.view.menu.r rVar) {
        boolean z = false;
        if (!rVar.hasVisibleItems()) {
            return false;
        }
        androidx.appcompat.view.menu.r rVar2 = rVar;
        while (rVar2.i0() != this.f269h) {
            rVar2 = (androidx.appcompat.view.menu.r) rVar2.i0();
        }
        View B = B(rVar2.getItem());
        if (B == null) {
            return false;
        }
        this.I = rVar.getItem().getItemId();
        int size = rVar.size();
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                break;
            }
            MenuItem item = rVar.getItem(i2);
            if (item.isVisible() && item.getIcon() != null) {
                z = true;
                break;
            }
            i2++;
        }
        a aVar = new a(this.f268g, rVar, B);
        this.E = aVar;
        aVar.g(z);
        this.E.k();
        super.k(rVar);
        return true;
    }

    @Override // androidx.appcompat.view.menu.m
    public Parcelable l() {
        SavedState savedState = new SavedState();
        savedState.f374f = this.I;
        return savedState;
    }

    @Override // androidx.appcompat.view.menu.b
    public boolean n(ViewGroup viewGroup, int i2) {
        if (viewGroup.getChildAt(i2) == this.p) {
            return false;
        }
        return super.n(viewGroup, i2);
    }

    @Override // androidx.appcompat.view.menu.b
    public View p(androidx.appcompat.view.menu.i iVar, View view, ViewGroup viewGroup) {
        View actionView = iVar.getActionView();
        if (actionView == null || iVar.j()) {
            actionView = super.p(iVar, view, viewGroup);
        }
        actionView.setVisibility(iVar.isActionViewExpanded() ? 8 : 0);
        ActionMenuView actionMenuView = (ActionMenuView) viewGroup;
        ViewGroup.LayoutParams layoutParams = actionView.getLayoutParams();
        if (!actionMenuView.checkLayoutParams(layoutParams)) {
            actionView.setLayoutParams(actionMenuView.generateLayoutParams(layoutParams));
        }
        return actionView;
    }

    @Override // androidx.appcompat.view.menu.b
    public androidx.appcompat.view.menu.n q(ViewGroup viewGroup) {
        androidx.appcompat.view.menu.n nVar = this.n;
        androidx.appcompat.view.menu.n q = super.q(viewGroup);
        if (nVar != q) {
            ((ActionMenuView) q).setPresenter(this);
        }
        return q;
    }

    @Override // androidx.appcompat.view.menu.b
    public boolean s(int i2, androidx.appcompat.view.menu.i iVar) {
        return iVar.l();
    }
}
