package com.airbnb.epoxy;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: EpoxyItemSpacingDecorator.java */
/* loaded from: classes.dex */
public class r extends RecyclerView.n {
    private int a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f8466b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f8467c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f8468d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f8469e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f8470f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f8471g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f8472h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f8473i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f8474j;

    public r() {
        this(0);
    }

    private void d(RecyclerView recyclerView, int i2, RecyclerView.o oVar) {
        int itemCount = recyclerView.getAdapter().getItemCount();
        boolean z = false;
        this.f8468d = i2 == 0;
        this.f8469e = i2 == itemCount + (-1);
        this.f8467c = oVar.canScrollHorizontally();
        this.f8466b = oVar.canScrollVertically();
        boolean z2 = oVar instanceof GridLayoutManager;
        this.f8470f = z2;
        if (z2) {
            GridLayoutManager gridLayoutManager = (GridLayoutManager) oVar;
            GridLayoutManager.c spanSizeLookup = gridLayoutManager.getSpanSizeLookup();
            int spanSize = spanSizeLookup.getSpanSize(i2);
            int spanCount = gridLayoutManager.getSpanCount();
            int spanIndex = spanSizeLookup.getSpanIndex(i2, spanCount);
            this.f8471g = spanIndex == 0;
            this.f8472h = spanIndex + spanSize == spanCount;
            boolean e2 = e(i2, spanSizeLookup, spanCount);
            this.f8473i = e2;
            if (!e2 && f(i2, itemCount, spanSizeLookup, spanCount)) {
                z = true;
            }
            this.f8474j = z;
        }
    }

    private static boolean e(int i2, GridLayoutManager.c cVar, int i3) {
        int i4 = 0;
        for (int i5 = 0; i5 <= i2; i5++) {
            i4 += cVar.getSpanSize(i5);
            if (i4 > i3) {
                return false;
            }
        }
        return true;
    }

    private static boolean f(int i2, int i3, GridLayoutManager.c cVar, int i4) {
        int i5 = 0;
        for (int i6 = i3 - 1; i6 >= i2; i6--) {
            i5 += cVar.getSpanSize(i6);
            if (i5 > i4) {
                return false;
            }
        }
        return true;
    }

    private static boolean h(RecyclerView.o oVar, boolean z) {
        boolean z2 = (oVar instanceof LinearLayoutManager) && ((LinearLayoutManager) oVar).getReverseLayout();
        return (z && (oVar.getLayoutDirection() == 1)) ? !z2 : z2;
    }

    private boolean i() {
        if (!this.f8470f) {
            return this.f8466b && !this.f8469e;
        }
        if (!this.f8467c || this.f8472h) {
            return this.f8466b && !this.f8474j;
        }
        return true;
    }

    private boolean j() {
        if (!this.f8470f) {
            return this.f8467c && !this.f8468d;
        }
        if (!this.f8467c || this.f8473i) {
            return this.f8466b && !this.f8471g;
        }
        return true;
    }

    private boolean k() {
        if (!this.f8470f) {
            return this.f8467c && !this.f8469e;
        }
        if (!this.f8467c || this.f8474j) {
            return this.f8466b && !this.f8472h;
        }
        return true;
    }

    private boolean l() {
        if (!this.f8470f) {
            return this.f8466b && !this.f8468d;
        }
        if (!this.f8467c || this.f8471g) {
            return this.f8466b && !this.f8473i;
        }
        return true;
    }

    public void g(int i2) {
        this.a = i2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.z zVar) {
        rect.setEmpty();
        int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
        if (childAdapterPosition == -1) {
            return;
        }
        RecyclerView.o layoutManager = recyclerView.getLayoutManager();
        d(recyclerView, childAdapterPosition, layoutManager);
        boolean j2 = j();
        boolean k2 = k();
        boolean l = l();
        boolean i2 = i();
        if (!h(layoutManager, this.f8467c)) {
            k2 = j2;
            j2 = k2;
        } else if (!this.f8467c) {
            k2 = j2;
            j2 = k2;
            i2 = l;
            l = i2;
        }
        int i3 = this.a / 2;
        rect.right = j2 ? i3 : 0;
        rect.left = k2 ? i3 : 0;
        rect.top = l ? i3 : 0;
        if (!i2) {
            i3 = 0;
        }
        rect.bottom = i3;
    }

    public r(int i2) {
        g(i2);
    }
}
