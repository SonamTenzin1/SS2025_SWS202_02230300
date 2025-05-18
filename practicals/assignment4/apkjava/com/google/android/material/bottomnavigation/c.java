package com.google.android.material.bottomnavigation;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.appcompat.view.menu.g;
import androidx.appcompat.view.menu.i;
import androidx.appcompat.view.menu.n;
import androidx.core.view.d0.c;
import androidx.core.view.u;
import c.i.j.f;
import c.i.j.h;
import c.x.o;
import c.x.q;
import com.google.android.material.badge.BadgeDrawable;
import e.e.b.c.d;
import java.util.HashSet;

/* compiled from: BottomNavigationMenuView.java */
/* loaded from: classes2.dex */
public class c extends ViewGroup implements n {

    /* renamed from: f, reason: collision with root package name */
    private static final int[] f18472f = {R.attr.state_checked};

    /* renamed from: g, reason: collision with root package name */
    private static final int[] f18473g = {-16842910};
    private Drawable A;
    private int B;
    private int[] C;
    private SparseArray<BadgeDrawable> D;
    private BottomNavigationPresenter E;
    private g F;

    /* renamed from: h, reason: collision with root package name */
    private final q f18474h;

    /* renamed from: i, reason: collision with root package name */
    private final int f18475i;

    /* renamed from: j, reason: collision with root package name */
    private final int f18476j;

    /* renamed from: k, reason: collision with root package name */
    private final int f18477k;
    private final int l;
    private final int m;
    private final View.OnClickListener n;
    private final f<com.google.android.material.bottomnavigation.a> o;
    private boolean p;
    private int q;
    private com.google.android.material.bottomnavigation.a[] r;
    private int s;
    private int t;
    private ColorStateList u;
    private int v;
    private ColorStateList w;
    private final ColorStateList x;
    private int y;
    private int z;

    /* compiled from: BottomNavigationMenuView.java */
    /* loaded from: classes2.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            i itemData = ((com.google.android.material.bottomnavigation.a) view).getItemData();
            if (c.this.F.O(itemData, c.this.E, 0)) {
                return;
            }
            itemData.setChecked(true);
        }
    }

    public c(Context context) {
        this(context, null);
    }

    private boolean g(int i2, int i3) {
        if (i2 == -1) {
            if (i3 > 3) {
                return true;
            }
        } else if (i2 == 0) {
            return true;
        }
        return false;
    }

    private com.google.android.material.bottomnavigation.a getNewItem() {
        com.google.android.material.bottomnavigation.a b2 = this.o.b();
        return b2 == null ? new com.google.android.material.bottomnavigation.a(getContext()) : b2;
    }

    private boolean h(int i2) {
        return i2 != -1;
    }

    private void i() {
        HashSet hashSet = new HashSet();
        for (int i2 = 0; i2 < this.F.size(); i2++) {
            hashSet.add(Integer.valueOf(this.F.getItem(i2).getItemId()));
        }
        for (int i3 = 0; i3 < this.D.size(); i3++) {
            int keyAt = this.D.keyAt(i3);
            if (!hashSet.contains(Integer.valueOf(keyAt))) {
                this.D.delete(keyAt);
            }
        }
    }

    private void setBadgeIfNeeded(com.google.android.material.bottomnavigation.a aVar) {
        BadgeDrawable badgeDrawable;
        int id = aVar.getId();
        if (h(id) && (badgeDrawable = this.D.get(id)) != null) {
            aVar.setBadge(badgeDrawable);
        }
    }

    @Override // androidx.appcompat.view.menu.n
    public void b(g gVar) {
        this.F = gVar;
    }

    public void d() {
        removeAllViews();
        com.google.android.material.bottomnavigation.a[] aVarArr = this.r;
        if (aVarArr != null) {
            for (com.google.android.material.bottomnavigation.a aVar : aVarArr) {
                if (aVar != null) {
                    this.o.a(aVar);
                    aVar.h();
                }
            }
        }
        if (this.F.size() == 0) {
            this.s = 0;
            this.t = 0;
            this.r = null;
            return;
        }
        i();
        this.r = new com.google.android.material.bottomnavigation.a[this.F.size()];
        boolean g2 = g(this.q, this.F.G().size());
        for (int i2 = 0; i2 < this.F.size(); i2++) {
            this.E.m(true);
            this.F.getItem(i2).setCheckable(true);
            this.E.m(false);
            com.google.android.material.bottomnavigation.a newItem = getNewItem();
            this.r[i2] = newItem;
            newItem.setIconTintList(this.u);
            newItem.setIconSize(this.v);
            newItem.setTextColor(this.x);
            newItem.setTextAppearanceInactive(this.y);
            newItem.setTextAppearanceActive(this.z);
            newItem.setTextColor(this.w);
            Drawable drawable = this.A;
            if (drawable != null) {
                newItem.setItemBackground(drawable);
            } else {
                newItem.setItemBackground(this.B);
            }
            newItem.setShifting(g2);
            newItem.setLabelVisibilityMode(this.q);
            newItem.e((i) this.F.getItem(i2), 0);
            newItem.setItemPosition(i2);
            newItem.setOnClickListener(this.n);
            if (this.s != 0 && this.F.getItem(i2).getItemId() == this.s) {
                this.t = i2;
            }
            setBadgeIfNeeded(newItem);
            addView(newItem);
        }
        int min = Math.min(this.F.size() - 1, this.t);
        this.t = min;
        this.F.getItem(min).setChecked(true);
    }

    public ColorStateList e(int i2) {
        TypedValue typedValue = new TypedValue();
        if (!getContext().getTheme().resolveAttribute(i2, typedValue, true)) {
            return null;
        }
        ColorStateList c2 = c.a.k.a.a.c(getContext(), typedValue.resourceId);
        if (!getContext().getTheme().resolveAttribute(c.a.a.x, typedValue, true)) {
            return null;
        }
        int i3 = typedValue.data;
        int defaultColor = c2.getDefaultColor();
        int[] iArr = f18473g;
        return new ColorStateList(new int[][]{iArr, f18472f, ViewGroup.EMPTY_STATE_SET}, new int[]{c2.getColorForState(iArr, defaultColor), i3, defaultColor});
    }

    public boolean f() {
        return this.p;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SparseArray<BadgeDrawable> getBadgeDrawables() {
        return this.D;
    }

    public ColorStateList getIconTintList() {
        return this.u;
    }

    public Drawable getItemBackground() {
        com.google.android.material.bottomnavigation.a[] aVarArr = this.r;
        if (aVarArr != null && aVarArr.length > 0) {
            return aVarArr[0].getBackground();
        }
        return this.A;
    }

    @Deprecated
    public int getItemBackgroundRes() {
        return this.B;
    }

    public int getItemIconSize() {
        return this.v;
    }

    public int getItemTextAppearanceActive() {
        return this.z;
    }

    public int getItemTextAppearanceInactive() {
        return this.y;
    }

    public ColorStateList getItemTextColor() {
        return this.w;
    }

    public int getLabelVisibilityMode() {
        return this.q;
    }

    public int getSelectedItemId() {
        return this.s;
    }

    public int getWindowAnimations() {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void j(int i2) {
        int size = this.F.size();
        for (int i3 = 0; i3 < size; i3++) {
            MenuItem item = this.F.getItem(i3);
            if (i2 == item.getItemId()) {
                this.s = i2;
                this.t = i3;
                item.setChecked(true);
                return;
            }
        }
    }

    public void k() {
        g gVar = this.F;
        if (gVar == null || this.r == null) {
            return;
        }
        int size = gVar.size();
        if (size != this.r.length) {
            d();
            return;
        }
        int i2 = this.s;
        for (int i3 = 0; i3 < size; i3++) {
            MenuItem item = this.F.getItem(i3);
            if (item.isChecked()) {
                this.s = item.getItemId();
                this.t = i3;
            }
        }
        if (i2 != this.s) {
            o.a(this, this.f18474h);
        }
        boolean g2 = g(this.q, this.F.G().size());
        for (int i4 = 0; i4 < size; i4++) {
            this.E.m(true);
            this.r[i4].setLabelVisibilityMode(this.q);
            this.r[i4].setShifting(g2);
            this.r[i4].e((i) this.F.getItem(i4), 0);
            this.E.m(false);
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        androidx.core.view.d0.c.y0(accessibilityNodeInfo).a0(c.b.a(1, this.F.G().size(), false, 1));
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int childCount = getChildCount();
        int i6 = i4 - i2;
        int i7 = i5 - i3;
        int i8 = 0;
        for (int i9 = 0; i9 < childCount; i9++) {
            View childAt = getChildAt(i9);
            if (childAt.getVisibility() != 8) {
                if (u.y(this) == 1) {
                    int i10 = i6 - i8;
                    childAt.layout(i10 - childAt.getMeasuredWidth(), 0, i10, i7);
                } else {
                    childAt.layout(i8, 0, childAt.getMeasuredWidth() + i8, i7);
                }
                i8 += childAt.getMeasuredWidth();
            }
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i2, int i3) {
        int size = View.MeasureSpec.getSize(i2);
        int size2 = this.F.G().size();
        int childCount = getChildCount();
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(this.m, 1073741824);
        if (g(this.q, size2) && this.p) {
            View childAt = getChildAt(this.t);
            int i4 = this.l;
            if (childAt.getVisibility() != 8) {
                childAt.measure(View.MeasureSpec.makeMeasureSpec(this.f18477k, Integer.MIN_VALUE), makeMeasureSpec);
                i4 = Math.max(i4, childAt.getMeasuredWidth());
            }
            int i5 = size2 - (childAt.getVisibility() != 8 ? 1 : 0);
            int min = Math.min(size - (this.f18476j * i5), Math.min(i4, this.f18477k));
            int i6 = size - min;
            int min2 = Math.min(i6 / (i5 == 0 ? 1 : i5), this.f18475i);
            int i7 = i6 - (i5 * min2);
            int i8 = 0;
            while (i8 < childCount) {
                if (getChildAt(i8).getVisibility() != 8) {
                    int[] iArr = this.C;
                    iArr[i8] = i8 == this.t ? min : min2;
                    if (i7 > 0) {
                        iArr[i8] = iArr[i8] + 1;
                        i7--;
                    }
                } else {
                    this.C[i8] = 0;
                }
                i8++;
            }
        } else {
            int min3 = Math.min(size / (size2 == 0 ? 1 : size2), this.f18477k);
            int i9 = size - (size2 * min3);
            for (int i10 = 0; i10 < childCount; i10++) {
                if (getChildAt(i10).getVisibility() != 8) {
                    int[] iArr2 = this.C;
                    iArr2[i10] = min3;
                    if (i9 > 0) {
                        iArr2[i10] = iArr2[i10] + 1;
                        i9--;
                    }
                } else {
                    this.C[i10] = 0;
                }
            }
        }
        int i11 = 0;
        for (int i12 = 0; i12 < childCount; i12++) {
            View childAt2 = getChildAt(i12);
            if (childAt2.getVisibility() != 8) {
                childAt2.measure(View.MeasureSpec.makeMeasureSpec(this.C[i12], 1073741824), makeMeasureSpec);
                childAt2.getLayoutParams().width = childAt2.getMeasuredWidth();
                i11 += childAt2.getMeasuredWidth();
            }
        }
        setMeasuredDimension(View.resolveSizeAndState(i11, View.MeasureSpec.makeMeasureSpec(i11, 1073741824), 0), View.resolveSizeAndState(this.m, makeMeasureSpec, 0));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setBadgeDrawables(SparseArray<BadgeDrawable> sparseArray) {
        this.D = sparseArray;
        com.google.android.material.bottomnavigation.a[] aVarArr = this.r;
        if (aVarArr != null) {
            for (com.google.android.material.bottomnavigation.a aVar : aVarArr) {
                aVar.setBadge(sparseArray.get(aVar.getId()));
            }
        }
    }

    public void setIconTintList(ColorStateList colorStateList) {
        this.u = colorStateList;
        com.google.android.material.bottomnavigation.a[] aVarArr = this.r;
        if (aVarArr != null) {
            for (com.google.android.material.bottomnavigation.a aVar : aVarArr) {
                aVar.setIconTintList(colorStateList);
            }
        }
    }

    public void setItemBackground(Drawable drawable) {
        this.A = drawable;
        com.google.android.material.bottomnavigation.a[] aVarArr = this.r;
        if (aVarArr != null) {
            for (com.google.android.material.bottomnavigation.a aVar : aVarArr) {
                aVar.setItemBackground(drawable);
            }
        }
    }

    public void setItemBackgroundRes(int i2) {
        this.B = i2;
        com.google.android.material.bottomnavigation.a[] aVarArr = this.r;
        if (aVarArr != null) {
            for (com.google.android.material.bottomnavigation.a aVar : aVarArr) {
                aVar.setItemBackground(i2);
            }
        }
    }

    public void setItemHorizontalTranslationEnabled(boolean z) {
        this.p = z;
    }

    public void setItemIconSize(int i2) {
        this.v = i2;
        com.google.android.material.bottomnavigation.a[] aVarArr = this.r;
        if (aVarArr != null) {
            for (com.google.android.material.bottomnavigation.a aVar : aVarArr) {
                aVar.setIconSize(i2);
            }
        }
    }

    public void setItemTextAppearanceActive(int i2) {
        this.z = i2;
        com.google.android.material.bottomnavigation.a[] aVarArr = this.r;
        if (aVarArr != null) {
            for (com.google.android.material.bottomnavigation.a aVar : aVarArr) {
                aVar.setTextAppearanceActive(i2);
                ColorStateList colorStateList = this.w;
                if (colorStateList != null) {
                    aVar.setTextColor(colorStateList);
                }
            }
        }
    }

    public void setItemTextAppearanceInactive(int i2) {
        this.y = i2;
        com.google.android.material.bottomnavigation.a[] aVarArr = this.r;
        if (aVarArr != null) {
            for (com.google.android.material.bottomnavigation.a aVar : aVarArr) {
                aVar.setTextAppearanceInactive(i2);
                ColorStateList colorStateList = this.w;
                if (colorStateList != null) {
                    aVar.setTextColor(colorStateList);
                }
            }
        }
    }

    public void setItemTextColor(ColorStateList colorStateList) {
        this.w = colorStateList;
        com.google.android.material.bottomnavigation.a[] aVarArr = this.r;
        if (aVarArr != null) {
            for (com.google.android.material.bottomnavigation.a aVar : aVarArr) {
                aVar.setTextColor(colorStateList);
            }
        }
    }

    public void setLabelVisibilityMode(int i2) {
        this.q = i2;
    }

    public void setPresenter(BottomNavigationPresenter bottomNavigationPresenter) {
        this.E = bottomNavigationPresenter;
    }

    public c(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.o = new h(5);
        this.s = 0;
        this.t = 0;
        this.D = new SparseArray<>(5);
        Resources resources = getResources();
        this.f18475i = resources.getDimensionPixelSize(d.f20986f);
        this.f18476j = resources.getDimensionPixelSize(d.f20987g);
        this.f18477k = resources.getDimensionPixelSize(d.f20982b);
        this.l = resources.getDimensionPixelSize(d.f20983c);
        this.m = resources.getDimensionPixelSize(d.f20984d);
        this.x = e(R.attr.textColorSecondary);
        c.x.b bVar = new c.x.b();
        this.f18474h = bVar;
        bVar.v0(0);
        bVar.a0(115L);
        bVar.c0(new c.n.a.a.b());
        bVar.m0(new com.google.android.material.internal.i());
        this.n = new a();
        this.C = new int[5];
        u.t0(this, 1);
    }
}
