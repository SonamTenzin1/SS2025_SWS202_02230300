package com.google.android.material.bottomnavigation;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.view.menu.g;
import androidx.appcompat.widget.q0;
import androidx.core.view.c0;
import androidx.core.view.u;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.internal.j;
import com.google.android.material.internal.k;
import e.e.b.c.a0.h;
import e.e.b.c.k;
import e.e.b.c.l;

/* loaded from: classes2.dex */
public class BottomNavigationView extends FrameLayout {

    /* renamed from: f, reason: collision with root package name */
    private static final int f18458f = k.f21036h;

    /* renamed from: g, reason: collision with root package name */
    private final g f18459g;

    /* renamed from: h, reason: collision with root package name */
    final com.google.android.material.bottomnavigation.c f18460h;

    /* renamed from: i, reason: collision with root package name */
    private final BottomNavigationPresenter f18461i;

    /* renamed from: j, reason: collision with root package name */
    private ColorStateList f18462j;

    /* renamed from: k, reason: collision with root package name */
    private MenuInflater f18463k;
    private d l;
    private c m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* renamed from: h, reason: collision with root package name */
        Bundle f18464h;

        /* loaded from: classes2.dex */
        static class a implements Parcelable.ClassLoaderCreator<SavedState> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: c, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i2) {
                return new SavedState[i2];
            }
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private void b(Parcel parcel, ClassLoader classLoader) {
            this.f18464h = parcel.readBundle(classLoader);
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeBundle(this.f18464h);
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            b(parcel, classLoader == null ? SavedState.class.getClassLoader() : classLoader);
        }
    }

    /* loaded from: classes2.dex */
    class a implements g.a {
        a() {
        }

        @Override // androidx.appcompat.view.menu.g.a
        public boolean a(g gVar, MenuItem menuItem) {
            if (BottomNavigationView.this.m == null || menuItem.getItemId() != BottomNavigationView.this.getSelectedItemId()) {
                return (BottomNavigationView.this.l == null || BottomNavigationView.this.l.a(menuItem)) ? false : true;
            }
            BottomNavigationView.this.m.a(menuItem);
            return true;
        }

        @Override // androidx.appcompat.view.menu.g.a
        public void b(g gVar) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class b implements k.c {
        b() {
        }

        @Override // com.google.android.material.internal.k.c
        public c0 a(View view, c0 c0Var, k.d dVar) {
            dVar.f18724d += c0Var.h();
            dVar.a(view);
            return c0Var;
        }
    }

    /* loaded from: classes2.dex */
    public interface c {
        void a(MenuItem menuItem);
    }

    /* loaded from: classes2.dex */
    public interface d {
        boolean a(MenuItem menuItem);
    }

    public BottomNavigationView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, e.e.b.c.b.f20965d);
    }

    private void c(Context context) {
        View view = new View(context);
        view.setBackgroundColor(androidx.core.content.a.d(context, e.e.b.c.c.a));
        view.setLayoutParams(new FrameLayout.LayoutParams(-1, getResources().getDimensionPixelSize(e.e.b.c.d.f20989i)));
        addView(view);
    }

    private void d() {
        com.google.android.material.internal.k.a(this, new b());
    }

    private e.e.b.c.a0.g e(Context context) {
        e.e.b.c.a0.g gVar = new e.e.b.c.a0.g();
        Drawable background = getBackground();
        if (background instanceof ColorDrawable) {
            gVar.X(ColorStateList.valueOf(((ColorDrawable) background).getColor()));
        }
        gVar.N(context);
        return gVar;
    }

    private MenuInflater getMenuInflater() {
        if (this.f18463k == null) {
            this.f18463k = new c.a.o.g(getContext());
        }
        return this.f18463k;
    }

    public void f(int i2) {
        this.f18461i.m(true);
        getMenuInflater().inflate(i2, this.f18459g);
        this.f18461i.m(false);
        this.f18461i.c(true);
    }

    public Drawable getItemBackground() {
        return this.f18460h.getItemBackground();
    }

    @Deprecated
    public int getItemBackgroundResource() {
        return this.f18460h.getItemBackgroundRes();
    }

    public int getItemIconSize() {
        return this.f18460h.getItemIconSize();
    }

    public ColorStateList getItemIconTintList() {
        return this.f18460h.getIconTintList();
    }

    public ColorStateList getItemRippleColor() {
        return this.f18462j;
    }

    public int getItemTextAppearanceActive() {
        return this.f18460h.getItemTextAppearanceActive();
    }

    public int getItemTextAppearanceInactive() {
        return this.f18460h.getItemTextAppearanceInactive();
    }

    public ColorStateList getItemTextColor() {
        return this.f18460h.getItemTextColor();
    }

    public int getLabelVisibilityMode() {
        return this.f18460h.getLabelVisibilityMode();
    }

    public int getMaxItemCount() {
        return 5;
    }

    public Menu getMenu() {
        return this.f18459g;
    }

    public int getSelectedItemId() {
        return this.f18460h.getSelectedItemId();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        h.e(this);
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.a());
        this.f18459g.S(savedState.f18464h);
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        Bundle bundle = new Bundle();
        savedState.f18464h = bundle;
        this.f18459g.U(bundle);
        return savedState;
    }

    @Override // android.view.View
    public void setElevation(float f2) {
        super.setElevation(f2);
        h.d(this, f2);
    }

    public void setItemBackground(Drawable drawable) {
        this.f18460h.setItemBackground(drawable);
        this.f18462j = null;
    }

    public void setItemBackgroundResource(int i2) {
        this.f18460h.setItemBackgroundRes(i2);
        this.f18462j = null;
    }

    public void setItemHorizontalTranslationEnabled(boolean z) {
        if (this.f18460h.f() != z) {
            this.f18460h.setItemHorizontalTranslationEnabled(z);
            this.f18461i.c(false);
        }
    }

    public void setItemIconSize(int i2) {
        this.f18460h.setItemIconSize(i2);
    }

    public void setItemIconSizeRes(int i2) {
        setItemIconSize(getResources().getDimensionPixelSize(i2));
    }

    public void setItemIconTintList(ColorStateList colorStateList) {
        this.f18460h.setIconTintList(colorStateList);
    }

    public void setItemRippleColor(ColorStateList colorStateList) {
        if (this.f18462j == colorStateList) {
            if (colorStateList != null || this.f18460h.getItemBackground() == null) {
                return;
            }
            this.f18460h.setItemBackground(null);
            return;
        }
        this.f18462j = colorStateList;
        if (colorStateList == null) {
            this.f18460h.setItemBackground(null);
            return;
        }
        ColorStateList a2 = e.e.b.c.y.b.a(colorStateList);
        if (Build.VERSION.SDK_INT >= 21) {
            this.f18460h.setItemBackground(new RippleDrawable(a2, null, null));
            return;
        }
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(1.0E-5f);
        Drawable r = androidx.core.graphics.drawable.a.r(gradientDrawable);
        androidx.core.graphics.drawable.a.o(r, a2);
        this.f18460h.setItemBackground(r);
    }

    public void setItemTextAppearanceActive(int i2) {
        this.f18460h.setItemTextAppearanceActive(i2);
    }

    public void setItemTextAppearanceInactive(int i2) {
        this.f18460h.setItemTextAppearanceInactive(i2);
    }

    public void setItemTextColor(ColorStateList colorStateList) {
        this.f18460h.setItemTextColor(colorStateList);
    }

    public void setLabelVisibilityMode(int i2) {
        if (this.f18460h.getLabelVisibilityMode() != i2) {
            this.f18460h.setLabelVisibilityMode(i2);
            this.f18461i.c(false);
        }
    }

    public void setOnNavigationItemReselectedListener(c cVar) {
        this.m = cVar;
    }

    public void setOnNavigationItemSelectedListener(d dVar) {
        this.l = dVar;
    }

    public void setSelectedItemId(int i2) {
        MenuItem findItem = this.f18459g.findItem(i2);
        if (findItem == null || this.f18459g.O(findItem, this.f18461i, 0)) {
            return;
        }
        findItem.setChecked(true);
    }

    public BottomNavigationView(Context context, AttributeSet attributeSet, int i2) {
        super(com.google.android.material.theme.a.a.c(context, attributeSet, i2, f18458f), attributeSet, i2);
        BottomNavigationPresenter bottomNavigationPresenter = new BottomNavigationPresenter();
        this.f18461i = bottomNavigationPresenter;
        Context context2 = getContext();
        g bVar = new com.google.android.material.bottomnavigation.b(context2);
        this.f18459g = bVar;
        com.google.android.material.bottomnavigation.c cVar = new com.google.android.material.bottomnavigation.c(context2);
        this.f18460h = cVar;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        cVar.setLayoutParams(layoutParams);
        bottomNavigationPresenter.a(cVar);
        bottomNavigationPresenter.j(1);
        cVar.setPresenter(bottomNavigationPresenter);
        bVar.b(bottomNavigationPresenter);
        bottomNavigationPresenter.h(getContext(), bVar);
        int[] iArr = l.E;
        int i3 = e.e.b.c.k.f21036h;
        int i4 = l.N;
        int i5 = l.M;
        q0 i6 = j.i(context2, attributeSet, iArr, i2, i3, i4, i5);
        int i7 = l.K;
        if (i6.s(i7)) {
            cVar.setIconTintList(i6.c(i7));
        } else {
            cVar.setIconTintList(cVar.e(R.attr.textColorSecondary));
        }
        setItemIconSize(i6.f(l.J, getResources().getDimensionPixelSize(e.e.b.c.d.f20985e)));
        if (i6.s(i4)) {
            setItemTextAppearanceInactive(i6.n(i4, 0));
        }
        if (i6.s(i5)) {
            setItemTextAppearanceActive(i6.n(i5, 0));
        }
        int i8 = l.O;
        if (i6.s(i8)) {
            setItemTextColor(i6.c(i8));
        }
        if (getBackground() == null || (getBackground() instanceof ColorDrawable)) {
            u.m0(this, e(context2));
        }
        if (i6.s(l.G)) {
            u.q0(this, i6.f(r2, 0));
        }
        androidx.core.graphics.drawable.a.o(getBackground().mutate(), e.e.b.c.x.c.b(context2, i6, l.F));
        setLabelVisibilityMode(i6.l(l.P, -1));
        setItemHorizontalTranslationEnabled(i6.a(l.I, true));
        int n = i6.n(l.H, 0);
        if (n != 0) {
            cVar.setItemBackgroundRes(n);
        } else {
            setItemRippleColor(e.e.b.c.x.c.b(context2, i6, l.L));
        }
        int i9 = l.Q;
        if (i6.s(i9)) {
            f(i6.n(i9, 0));
        }
        i6.w();
        addView(cVar, layoutParams);
        if (Build.VERSION.SDK_INT < 21) {
            c(context2);
        }
        bVar.V(new a());
        d();
    }
}
