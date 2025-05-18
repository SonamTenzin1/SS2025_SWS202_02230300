package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.PointF;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

/* loaded from: classes.dex */
public class LinearLayoutManager extends RecyclerView.o implements RecyclerView.y.b {
    static final boolean DEBUG = false;
    public static final int HORIZONTAL = 0;
    public static final int INVALID_OFFSET = Integer.MIN_VALUE;
    private static final float MAX_SCROLL_FACTOR = 0.33333334f;
    private static final String TAG = "LinearLayoutManager";
    public static final int VERTICAL = 1;
    final a mAnchorInfo;
    private int mInitialPrefetchItemCount;
    private boolean mLastStackFromEnd;
    private final b mLayoutChunkResult;
    private c mLayoutState;
    int mOrientation;
    n mOrientationHelper;
    SavedState mPendingSavedState;
    int mPendingScrollPosition;
    int mPendingScrollPositionOffset;
    private boolean mRecycleChildrenOnDetach;
    private int[] mReusableIntPair;
    private boolean mReverseLayout;
    boolean mShouldReverseLayout;
    private boolean mSmoothScrollbarEnabled;
    private boolean mStackFromEnd;

    @SuppressLint({"BanParcelableUsage"})
    /* loaded from: classes.dex */
    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* renamed from: f, reason: collision with root package name */
        int f1898f;

        /* renamed from: g, reason: collision with root package name */
        int f1899g;

        /* renamed from: h, reason: collision with root package name */
        boolean f1900h;

        /* loaded from: classes.dex */
        static class a implements Parcelable.Creator<SavedState> {
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

        public SavedState() {
        }

        boolean a() {
            return this.f1898f >= 0;
        }

        void b() {
            this.f1898f = -1;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeInt(this.f1898f);
            parcel.writeInt(this.f1899g);
            parcel.writeInt(this.f1900h ? 1 : 0);
        }

        SavedState(Parcel parcel) {
            this.f1898f = parcel.readInt();
            this.f1899g = parcel.readInt();
            this.f1900h = parcel.readInt() == 1;
        }

        public SavedState(SavedState savedState) {
            this.f1898f = savedState.f1898f;
            this.f1899g = savedState.f1899g;
            this.f1900h = savedState.f1900h;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a {
        n a;

        /* renamed from: b, reason: collision with root package name */
        int f1901b;

        /* renamed from: c, reason: collision with root package name */
        int f1902c;

        /* renamed from: d, reason: collision with root package name */
        boolean f1903d;

        /* renamed from: e, reason: collision with root package name */
        boolean f1904e;

        a() {
            e();
        }

        void a() {
            int m;
            if (this.f1903d) {
                m = this.a.i();
            } else {
                m = this.a.m();
            }
            this.f1902c = m;
        }

        public void b(View view, int i2) {
            if (this.f1903d) {
                this.f1902c = this.a.d(view) + this.a.o();
            } else {
                this.f1902c = this.a.g(view);
            }
            this.f1901b = i2;
        }

        public void c(View view, int i2) {
            int o = this.a.o();
            if (o >= 0) {
                b(view, i2);
                return;
            }
            this.f1901b = i2;
            if (this.f1903d) {
                int i3 = (this.a.i() - o) - this.a.d(view);
                this.f1902c = this.a.i() - i3;
                if (i3 > 0) {
                    int e2 = this.f1902c - this.a.e(view);
                    int m = this.a.m();
                    int min = e2 - (m + Math.min(this.a.g(view) - m, 0));
                    if (min < 0) {
                        this.f1902c += Math.min(i3, -min);
                        return;
                    }
                    return;
                }
                return;
            }
            int g2 = this.a.g(view);
            int m2 = g2 - this.a.m();
            this.f1902c = g2;
            if (m2 > 0) {
                int i4 = (this.a.i() - Math.min(0, (this.a.i() - o) - this.a.d(view))) - (g2 + this.a.e(view));
                if (i4 < 0) {
                    this.f1902c -= Math.min(m2, -i4);
                }
            }
        }

        boolean d(View view, RecyclerView.z zVar) {
            RecyclerView.p pVar = (RecyclerView.p) view.getLayoutParams();
            return !pVar.c() && pVar.a() >= 0 && pVar.a() < zVar.b();
        }

        void e() {
            this.f1901b = -1;
            this.f1902c = Integer.MIN_VALUE;
            this.f1903d = false;
            this.f1904e = false;
        }

        public String toString() {
            return "AnchorInfo{mPosition=" + this.f1901b + ", mCoordinate=" + this.f1902c + ", mLayoutFromEnd=" + this.f1903d + ", mValid=" + this.f1904e + '}';
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public static class b {
        public int a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f1905b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f1906c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f1907d;

        protected b() {
        }

        void a() {
            this.a = 0;
            this.f1905b = false;
            this.f1906c = false;
            this.f1907d = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class c {

        /* renamed from: b, reason: collision with root package name */
        int f1908b;

        /* renamed from: c, reason: collision with root package name */
        int f1909c;

        /* renamed from: d, reason: collision with root package name */
        int f1910d;

        /* renamed from: e, reason: collision with root package name */
        int f1911e;

        /* renamed from: f, reason: collision with root package name */
        int f1912f;

        /* renamed from: g, reason: collision with root package name */
        int f1913g;

        /* renamed from: k, reason: collision with root package name */
        int f1917k;
        boolean m;
        boolean a = true;

        /* renamed from: h, reason: collision with root package name */
        int f1914h = 0;

        /* renamed from: i, reason: collision with root package name */
        int f1915i = 0;

        /* renamed from: j, reason: collision with root package name */
        boolean f1916j = false;
        List<RecyclerView.c0> l = null;

        c() {
        }

        private View e() {
            int size = this.l.size();
            for (int i2 = 0; i2 < size; i2++) {
                View view = this.l.get(i2).itemView;
                RecyclerView.p pVar = (RecyclerView.p) view.getLayoutParams();
                if (!pVar.c() && this.f1910d == pVar.a()) {
                    b(view);
                    return view;
                }
            }
            return null;
        }

        public void a() {
            b(null);
        }

        public void b(View view) {
            View f2 = f(view);
            if (f2 == null) {
                this.f1910d = -1;
            } else {
                this.f1910d = ((RecyclerView.p) f2.getLayoutParams()).a();
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean c(RecyclerView.z zVar) {
            int i2 = this.f1910d;
            return i2 >= 0 && i2 < zVar.b();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public View d(RecyclerView.v vVar) {
            if (this.l != null) {
                return e();
            }
            View o = vVar.o(this.f1910d);
            this.f1910d += this.f1911e;
            return o;
        }

        public View f(View view) {
            int a;
            int size = this.l.size();
            View view2 = null;
            int i2 = Integer.MAX_VALUE;
            for (int i3 = 0; i3 < size; i3++) {
                View view3 = this.l.get(i3).itemView;
                RecyclerView.p pVar = (RecyclerView.p) view3.getLayoutParams();
                if (view3 != view && !pVar.c() && (a = (pVar.a() - this.f1910d) * this.f1911e) >= 0 && a < i2) {
                    view2 = view3;
                    if (a == 0) {
                        break;
                    }
                    i2 = a;
                }
            }
            return view2;
        }
    }

    public LinearLayoutManager(Context context) {
        this(context, 1, false);
    }

    private int computeScrollExtent(RecyclerView.z zVar) {
        if (getChildCount() == 0) {
            return 0;
        }
        ensureLayoutState();
        return p.a(zVar, this.mOrientationHelper, findFirstVisibleChildClosestToStart(!this.mSmoothScrollbarEnabled, true), findFirstVisibleChildClosestToEnd(!this.mSmoothScrollbarEnabled, true), this, this.mSmoothScrollbarEnabled);
    }

    private int computeScrollOffset(RecyclerView.z zVar) {
        if (getChildCount() == 0) {
            return 0;
        }
        ensureLayoutState();
        return p.b(zVar, this.mOrientationHelper, findFirstVisibleChildClosestToStart(!this.mSmoothScrollbarEnabled, true), findFirstVisibleChildClosestToEnd(!this.mSmoothScrollbarEnabled, true), this, this.mSmoothScrollbarEnabled, this.mShouldReverseLayout);
    }

    private int computeScrollRange(RecyclerView.z zVar) {
        if (getChildCount() == 0) {
            return 0;
        }
        ensureLayoutState();
        return p.c(zVar, this.mOrientationHelper, findFirstVisibleChildClosestToStart(!this.mSmoothScrollbarEnabled, true), findFirstVisibleChildClosestToEnd(!this.mSmoothScrollbarEnabled, true), this, this.mSmoothScrollbarEnabled);
    }

    private View findFirstPartiallyOrCompletelyInvisibleChild() {
        return findOnePartiallyOrCompletelyInvisibleChild(0, getChildCount());
    }

    private View findFirstReferenceChild(RecyclerView.v vVar, RecyclerView.z zVar) {
        return findReferenceChild(vVar, zVar, 0, getChildCount(), zVar.b());
    }

    private View findLastPartiallyOrCompletelyInvisibleChild() {
        return findOnePartiallyOrCompletelyInvisibleChild(getChildCount() - 1, -1);
    }

    private View findLastReferenceChild(RecyclerView.v vVar, RecyclerView.z zVar) {
        return findReferenceChild(vVar, zVar, getChildCount() - 1, -1, zVar.b());
    }

    private View findPartiallyOrCompletelyInvisibleChildClosestToEnd() {
        return this.mShouldReverseLayout ? findFirstPartiallyOrCompletelyInvisibleChild() : findLastPartiallyOrCompletelyInvisibleChild();
    }

    private View findPartiallyOrCompletelyInvisibleChildClosestToStart() {
        return this.mShouldReverseLayout ? findLastPartiallyOrCompletelyInvisibleChild() : findFirstPartiallyOrCompletelyInvisibleChild();
    }

    private View findReferenceChildClosestToEnd(RecyclerView.v vVar, RecyclerView.z zVar) {
        return this.mShouldReverseLayout ? findFirstReferenceChild(vVar, zVar) : findLastReferenceChild(vVar, zVar);
    }

    private View findReferenceChildClosestToStart(RecyclerView.v vVar, RecyclerView.z zVar) {
        return this.mShouldReverseLayout ? findLastReferenceChild(vVar, zVar) : findFirstReferenceChild(vVar, zVar);
    }

    private int fixLayoutEndGap(int i2, RecyclerView.v vVar, RecyclerView.z zVar, boolean z) {
        int i3;
        int i4 = this.mOrientationHelper.i() - i2;
        if (i4 <= 0) {
            return 0;
        }
        int i5 = -scrollBy(-i4, vVar, zVar);
        int i6 = i2 + i5;
        if (!z || (i3 = this.mOrientationHelper.i() - i6) <= 0) {
            return i5;
        }
        this.mOrientationHelper.r(i3);
        return i3 + i5;
    }

    private int fixLayoutStartGap(int i2, RecyclerView.v vVar, RecyclerView.z zVar, boolean z) {
        int m;
        int m2 = i2 - this.mOrientationHelper.m();
        if (m2 <= 0) {
            return 0;
        }
        int i3 = -scrollBy(m2, vVar, zVar);
        int i4 = i2 + i3;
        if (!z || (m = i4 - this.mOrientationHelper.m()) <= 0) {
            return i3;
        }
        this.mOrientationHelper.r(-m);
        return i3 - m;
    }

    private View getChildClosestToEnd() {
        return getChildAt(this.mShouldReverseLayout ? 0 : getChildCount() - 1);
    }

    private View getChildClosestToStart() {
        return getChildAt(this.mShouldReverseLayout ? getChildCount() - 1 : 0);
    }

    private void layoutForPredictiveAnimations(RecyclerView.v vVar, RecyclerView.z zVar, int i2, int i3) {
        if (!zVar.g() || getChildCount() == 0 || zVar.e() || !supportsPredictiveItemAnimations()) {
            return;
        }
        List<RecyclerView.c0> k2 = vVar.k();
        int size = k2.size();
        int position = getPosition(getChildAt(0));
        int i4 = 0;
        int i5 = 0;
        for (int i6 = 0; i6 < size; i6++) {
            RecyclerView.c0 c0Var = k2.get(i6);
            if (!c0Var.isRemoved()) {
                if (((c0Var.getLayoutPosition() < position) != this.mShouldReverseLayout ? (char) 65535 : (char) 1) == 65535) {
                    i4 += this.mOrientationHelper.e(c0Var.itemView);
                } else {
                    i5 += this.mOrientationHelper.e(c0Var.itemView);
                }
            }
        }
        this.mLayoutState.l = k2;
        if (i4 > 0) {
            updateLayoutStateToFillStart(getPosition(getChildClosestToStart()), i2);
            c cVar = this.mLayoutState;
            cVar.f1914h = i4;
            cVar.f1909c = 0;
            cVar.a();
            fill(vVar, this.mLayoutState, zVar, false);
        }
        if (i5 > 0) {
            updateLayoutStateToFillEnd(getPosition(getChildClosestToEnd()), i3);
            c cVar2 = this.mLayoutState;
            cVar2.f1914h = i5;
            cVar2.f1909c = 0;
            cVar2.a();
            fill(vVar, this.mLayoutState, zVar, false);
        }
        this.mLayoutState.l = null;
    }

    private void logChildren() {
        Log.d(TAG, "internal representation of views on the screen");
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            View childAt = getChildAt(i2);
            Log.d(TAG, "item " + getPosition(childAt) + ", coord:" + this.mOrientationHelper.g(childAt));
        }
        Log.d(TAG, "==============");
    }

    private void recycleByLayoutState(RecyclerView.v vVar, c cVar) {
        if (!cVar.a || cVar.m) {
            return;
        }
        int i2 = cVar.f1913g;
        int i3 = cVar.f1915i;
        if (cVar.f1912f == -1) {
            recycleViewsFromEnd(vVar, i2, i3);
        } else {
            recycleViewsFromStart(vVar, i2, i3);
        }
    }

    private void recycleChildren(RecyclerView.v vVar, int i2, int i3) {
        if (i2 == i3) {
            return;
        }
        if (i3 <= i2) {
            while (i2 > i3) {
                removeAndRecycleViewAt(i2, vVar);
                i2--;
            }
        } else {
            for (int i4 = i3 - 1; i4 >= i2; i4--) {
                removeAndRecycleViewAt(i4, vVar);
            }
        }
    }

    private void recycleViewsFromEnd(RecyclerView.v vVar, int i2, int i3) {
        int childCount = getChildCount();
        if (i2 < 0) {
            return;
        }
        int h2 = (this.mOrientationHelper.h() - i2) + i3;
        if (this.mShouldReverseLayout) {
            for (int i4 = 0; i4 < childCount; i4++) {
                View childAt = getChildAt(i4);
                if (this.mOrientationHelper.g(childAt) < h2 || this.mOrientationHelper.q(childAt) < h2) {
                    recycleChildren(vVar, 0, i4);
                    return;
                }
            }
            return;
        }
        int i5 = childCount - 1;
        for (int i6 = i5; i6 >= 0; i6--) {
            View childAt2 = getChildAt(i6);
            if (this.mOrientationHelper.g(childAt2) < h2 || this.mOrientationHelper.q(childAt2) < h2) {
                recycleChildren(vVar, i5, i6);
                return;
            }
        }
    }

    private void recycleViewsFromStart(RecyclerView.v vVar, int i2, int i3) {
        if (i2 < 0) {
            return;
        }
        int i4 = i2 - i3;
        int childCount = getChildCount();
        if (!this.mShouldReverseLayout) {
            for (int i5 = 0; i5 < childCount; i5++) {
                View childAt = getChildAt(i5);
                if (this.mOrientationHelper.d(childAt) > i4 || this.mOrientationHelper.p(childAt) > i4) {
                    recycleChildren(vVar, 0, i5);
                    return;
                }
            }
            return;
        }
        int i6 = childCount - 1;
        for (int i7 = i6; i7 >= 0; i7--) {
            View childAt2 = getChildAt(i7);
            if (this.mOrientationHelper.d(childAt2) > i4 || this.mOrientationHelper.p(childAt2) > i4) {
                recycleChildren(vVar, i6, i7);
                return;
            }
        }
    }

    private void resolveShouldLayoutReverse() {
        if (this.mOrientation != 1 && isLayoutRTL()) {
            this.mShouldReverseLayout = !this.mReverseLayout;
        } else {
            this.mShouldReverseLayout = this.mReverseLayout;
        }
    }

    private boolean updateAnchorFromChildren(RecyclerView.v vVar, RecyclerView.z zVar, a aVar) {
        View findReferenceChildClosestToStart;
        int m;
        if (getChildCount() == 0) {
            return false;
        }
        View focusedChild = getFocusedChild();
        if (focusedChild != null && aVar.d(focusedChild, zVar)) {
            aVar.c(focusedChild, getPosition(focusedChild));
            return true;
        }
        if (this.mLastStackFromEnd != this.mStackFromEnd) {
            return false;
        }
        if (aVar.f1903d) {
            findReferenceChildClosestToStart = findReferenceChildClosestToEnd(vVar, zVar);
        } else {
            findReferenceChildClosestToStart = findReferenceChildClosestToStart(vVar, zVar);
        }
        if (findReferenceChildClosestToStart == null) {
            return false;
        }
        aVar.b(findReferenceChildClosestToStart, getPosition(findReferenceChildClosestToStart));
        if (!zVar.e() && supportsPredictiveItemAnimations()) {
            if (this.mOrientationHelper.g(findReferenceChildClosestToStart) >= this.mOrientationHelper.i() || this.mOrientationHelper.d(findReferenceChildClosestToStart) < this.mOrientationHelper.m()) {
                if (aVar.f1903d) {
                    m = this.mOrientationHelper.i();
                } else {
                    m = this.mOrientationHelper.m();
                }
                aVar.f1902c = m;
            }
        }
        return true;
    }

    private boolean updateAnchorFromPendingData(RecyclerView.z zVar, a aVar) {
        int i2;
        int g2;
        if (!zVar.e() && (i2 = this.mPendingScrollPosition) != -1) {
            if (i2 >= 0 && i2 < zVar.b()) {
                aVar.f1901b = this.mPendingScrollPosition;
                SavedState savedState = this.mPendingSavedState;
                if (savedState != null && savedState.a()) {
                    boolean z = this.mPendingSavedState.f1900h;
                    aVar.f1903d = z;
                    if (z) {
                        aVar.f1902c = this.mOrientationHelper.i() - this.mPendingSavedState.f1899g;
                    } else {
                        aVar.f1902c = this.mOrientationHelper.m() + this.mPendingSavedState.f1899g;
                    }
                    return true;
                }
                if (this.mPendingScrollPositionOffset == Integer.MIN_VALUE) {
                    View findViewByPosition = findViewByPosition(this.mPendingScrollPosition);
                    if (findViewByPosition != null) {
                        if (this.mOrientationHelper.e(findViewByPosition) > this.mOrientationHelper.n()) {
                            aVar.a();
                            return true;
                        }
                        if (this.mOrientationHelper.g(findViewByPosition) - this.mOrientationHelper.m() < 0) {
                            aVar.f1902c = this.mOrientationHelper.m();
                            aVar.f1903d = false;
                            return true;
                        }
                        if (this.mOrientationHelper.i() - this.mOrientationHelper.d(findViewByPosition) < 0) {
                            aVar.f1902c = this.mOrientationHelper.i();
                            aVar.f1903d = true;
                            return true;
                        }
                        if (aVar.f1903d) {
                            g2 = this.mOrientationHelper.d(findViewByPosition) + this.mOrientationHelper.o();
                        } else {
                            g2 = this.mOrientationHelper.g(findViewByPosition);
                        }
                        aVar.f1902c = g2;
                    } else {
                        if (getChildCount() > 0) {
                            aVar.f1903d = (this.mPendingScrollPosition < getPosition(getChildAt(0))) == this.mShouldReverseLayout;
                        }
                        aVar.a();
                    }
                    return true;
                }
                boolean z2 = this.mShouldReverseLayout;
                aVar.f1903d = z2;
                if (z2) {
                    aVar.f1902c = this.mOrientationHelper.i() - this.mPendingScrollPositionOffset;
                } else {
                    aVar.f1902c = this.mOrientationHelper.m() + this.mPendingScrollPositionOffset;
                }
                return true;
            }
            this.mPendingScrollPosition = -1;
            this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        }
        return false;
    }

    private void updateAnchorInfoForLayout(RecyclerView.v vVar, RecyclerView.z zVar, a aVar) {
        if (updateAnchorFromPendingData(zVar, aVar) || updateAnchorFromChildren(vVar, zVar, aVar)) {
            return;
        }
        aVar.a();
        aVar.f1901b = this.mStackFromEnd ? zVar.b() - 1 : 0;
    }

    private void updateLayoutState(int i2, int i3, boolean z, RecyclerView.z zVar) {
        int m;
        this.mLayoutState.m = resolveIsInfinite();
        this.mLayoutState.f1912f = i2;
        int[] iArr = this.mReusableIntPair;
        iArr[0] = 0;
        iArr[1] = 0;
        calculateExtraLayoutSpace(zVar, iArr);
        int max = Math.max(0, this.mReusableIntPair[0]);
        int max2 = Math.max(0, this.mReusableIntPair[1]);
        boolean z2 = i2 == 1;
        c cVar = this.mLayoutState;
        int i4 = z2 ? max2 : max;
        cVar.f1914h = i4;
        if (!z2) {
            max = max2;
        }
        cVar.f1915i = max;
        if (z2) {
            cVar.f1914h = i4 + this.mOrientationHelper.j();
            View childClosestToEnd = getChildClosestToEnd();
            c cVar2 = this.mLayoutState;
            cVar2.f1911e = this.mShouldReverseLayout ? -1 : 1;
            int position = getPosition(childClosestToEnd);
            c cVar3 = this.mLayoutState;
            cVar2.f1910d = position + cVar3.f1911e;
            cVar3.f1908b = this.mOrientationHelper.d(childClosestToEnd);
            m = this.mOrientationHelper.d(childClosestToEnd) - this.mOrientationHelper.i();
        } else {
            View childClosestToStart = getChildClosestToStart();
            this.mLayoutState.f1914h += this.mOrientationHelper.m();
            c cVar4 = this.mLayoutState;
            cVar4.f1911e = this.mShouldReverseLayout ? 1 : -1;
            int position2 = getPosition(childClosestToStart);
            c cVar5 = this.mLayoutState;
            cVar4.f1910d = position2 + cVar5.f1911e;
            cVar5.f1908b = this.mOrientationHelper.g(childClosestToStart);
            m = (-this.mOrientationHelper.g(childClosestToStart)) + this.mOrientationHelper.m();
        }
        c cVar6 = this.mLayoutState;
        cVar6.f1909c = i3;
        if (z) {
            cVar6.f1909c = i3 - m;
        }
        cVar6.f1913g = m;
    }

    private void updateLayoutStateToFillEnd(a aVar) {
        updateLayoutStateToFillEnd(aVar.f1901b, aVar.f1902c);
    }

    private void updateLayoutStateToFillStart(a aVar) {
        updateLayoutStateToFillStart(aVar.f1901b, aVar.f1902c);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void assertNotInLayoutOrScroll(String str) {
        if (this.mPendingSavedState == null) {
            super.assertNotInLayoutOrScroll(str);
        }
    }

    protected void calculateExtraLayoutSpace(RecyclerView.z zVar, int[] iArr) {
        int i2;
        int extraLayoutSpace = getExtraLayoutSpace(zVar);
        if (this.mLayoutState.f1912f == -1) {
            i2 = 0;
        } else {
            i2 = extraLayoutSpace;
            extraLayoutSpace = 0;
        }
        iArr[0] = extraLayoutSpace;
        iArr[1] = i2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean canScrollHorizontally() {
        return this.mOrientation == 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean canScrollVertically() {
        return this.mOrientation == 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void collectAdjacentPrefetchPositions(int i2, int i3, RecyclerView.z zVar, RecyclerView.o.c cVar) {
        if (this.mOrientation != 0) {
            i2 = i3;
        }
        if (getChildCount() == 0 || i2 == 0) {
            return;
        }
        ensureLayoutState();
        updateLayoutState(i2 > 0 ? 1 : -1, Math.abs(i2), true, zVar);
        collectPrefetchPositionsForLayoutState(zVar, this.mLayoutState, cVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void collectInitialPrefetchPositions(int i2, RecyclerView.o.c cVar) {
        boolean z;
        int i3;
        SavedState savedState = this.mPendingSavedState;
        if (savedState != null && savedState.a()) {
            SavedState savedState2 = this.mPendingSavedState;
            z = savedState2.f1900h;
            i3 = savedState2.f1898f;
        } else {
            resolveShouldLayoutReverse();
            z = this.mShouldReverseLayout;
            i3 = this.mPendingScrollPosition;
            if (i3 == -1) {
                i3 = z ? i2 - 1 : 0;
            }
        }
        int i4 = z ? -1 : 1;
        for (int i5 = 0; i5 < this.mInitialPrefetchItemCount && i3 >= 0 && i3 < i2; i5++) {
            cVar.a(i3, 0);
            i3 += i4;
        }
    }

    void collectPrefetchPositionsForLayoutState(RecyclerView.z zVar, c cVar, RecyclerView.o.c cVar2) {
        int i2 = cVar.f1910d;
        if (i2 < 0 || i2 >= zVar.b()) {
            return;
        }
        cVar2.a(i2, Math.max(0, cVar.f1913g));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int computeHorizontalScrollExtent(RecyclerView.z zVar) {
        return computeScrollExtent(zVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int computeHorizontalScrollOffset(RecyclerView.z zVar) {
        return computeScrollOffset(zVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int computeHorizontalScrollRange(RecyclerView.z zVar) {
        return computeScrollRange(zVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.y.b
    public PointF computeScrollVectorForPosition(int i2) {
        if (getChildCount() == 0) {
            return null;
        }
        int i3 = (i2 < getPosition(getChildAt(0))) != this.mShouldReverseLayout ? -1 : 1;
        if (this.mOrientation == 0) {
            return new PointF(i3, 0.0f);
        }
        return new PointF(0.0f, i3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int computeVerticalScrollExtent(RecyclerView.z zVar) {
        return computeScrollExtent(zVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int computeVerticalScrollOffset(RecyclerView.z zVar) {
        return computeScrollOffset(zVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int computeVerticalScrollRange(RecyclerView.z zVar) {
        return computeScrollRange(zVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int convertFocusDirectionToLayoutDirection(int i2) {
        return i2 != 1 ? i2 != 2 ? i2 != 17 ? i2 != 33 ? i2 != 66 ? (i2 == 130 && this.mOrientation == 1) ? 1 : Integer.MIN_VALUE : this.mOrientation == 0 ? 1 : Integer.MIN_VALUE : this.mOrientation == 1 ? -1 : Integer.MIN_VALUE : this.mOrientation == 0 ? -1 : Integer.MIN_VALUE : (this.mOrientation != 1 && isLayoutRTL()) ? -1 : 1 : (this.mOrientation != 1 && isLayoutRTL()) ? 1 : -1;
    }

    c createLayoutState() {
        return new c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ensureLayoutState() {
        if (this.mLayoutState == null) {
            this.mLayoutState = createLayoutState();
        }
    }

    int fill(RecyclerView.v vVar, c cVar, RecyclerView.z zVar, boolean z) {
        int i2 = cVar.f1909c;
        int i3 = cVar.f1913g;
        if (i3 != Integer.MIN_VALUE) {
            if (i2 < 0) {
                cVar.f1913g = i3 + i2;
            }
            recycleByLayoutState(vVar, cVar);
        }
        int i4 = cVar.f1909c + cVar.f1914h;
        b bVar = this.mLayoutChunkResult;
        while (true) {
            if ((!cVar.m && i4 <= 0) || !cVar.c(zVar)) {
                break;
            }
            bVar.a();
            layoutChunk(vVar, zVar, cVar, bVar);
            if (!bVar.f1905b) {
                cVar.f1908b += bVar.a * cVar.f1912f;
                if (!bVar.f1906c || cVar.l != null || !zVar.e()) {
                    int i5 = cVar.f1909c;
                    int i6 = bVar.a;
                    cVar.f1909c = i5 - i6;
                    i4 -= i6;
                }
                int i7 = cVar.f1913g;
                if (i7 != Integer.MIN_VALUE) {
                    int i8 = i7 + bVar.a;
                    cVar.f1913g = i8;
                    int i9 = cVar.f1909c;
                    if (i9 < 0) {
                        cVar.f1913g = i8 + i9;
                    }
                    recycleByLayoutState(vVar, cVar);
                }
                if (z && bVar.f1907d) {
                    break;
                }
            } else {
                break;
            }
        }
        return i2 - cVar.f1909c;
    }

    public int findFirstCompletelyVisibleItemPosition() {
        View findOneVisibleChild = findOneVisibleChild(0, getChildCount(), true, false);
        if (findOneVisibleChild == null) {
            return -1;
        }
        return getPosition(findOneVisibleChild);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View findFirstVisibleChildClosestToEnd(boolean z, boolean z2) {
        if (this.mShouldReverseLayout) {
            return findOneVisibleChild(0, getChildCount(), z, z2);
        }
        return findOneVisibleChild(getChildCount() - 1, -1, z, z2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View findFirstVisibleChildClosestToStart(boolean z, boolean z2) {
        if (this.mShouldReverseLayout) {
            return findOneVisibleChild(getChildCount() - 1, -1, z, z2);
        }
        return findOneVisibleChild(0, getChildCount(), z, z2);
    }

    public int findFirstVisibleItemPosition() {
        View findOneVisibleChild = findOneVisibleChild(0, getChildCount(), false, true);
        if (findOneVisibleChild == null) {
            return -1;
        }
        return getPosition(findOneVisibleChild);
    }

    public int findLastCompletelyVisibleItemPosition() {
        View findOneVisibleChild = findOneVisibleChild(getChildCount() - 1, -1, true, false);
        if (findOneVisibleChild == null) {
            return -1;
        }
        return getPosition(findOneVisibleChild);
    }

    public int findLastVisibleItemPosition() {
        View findOneVisibleChild = findOneVisibleChild(getChildCount() - 1, -1, false, true);
        if (findOneVisibleChild == null) {
            return -1;
        }
        return getPosition(findOneVisibleChild);
    }

    View findOnePartiallyOrCompletelyInvisibleChild(int i2, int i3) {
        int i4;
        int i5;
        ensureLayoutState();
        if ((i3 > i2 ? (char) 1 : i3 < i2 ? (char) 65535 : (char) 0) == 0) {
            return getChildAt(i2);
        }
        if (this.mOrientationHelper.g(getChildAt(i2)) < this.mOrientationHelper.m()) {
            i4 = 16644;
            i5 = 16388;
        } else {
            i4 = 4161;
            i5 = 4097;
        }
        if (this.mOrientation == 0) {
            return this.mHorizontalBoundCheck.a(i2, i3, i4, i5);
        }
        return this.mVerticalBoundCheck.a(i2, i3, i4, i5);
    }

    View findOneVisibleChild(int i2, int i3, boolean z, boolean z2) {
        ensureLayoutState();
        int i4 = z ? 24579 : 320;
        int i5 = z2 ? 320 : 0;
        if (this.mOrientation == 0) {
            return this.mHorizontalBoundCheck.a(i2, i3, i4, i5);
        }
        return this.mVerticalBoundCheck.a(i2, i3, i4, i5);
    }

    View findReferenceChild(RecyclerView.v vVar, RecyclerView.z zVar, int i2, int i3, int i4) {
        ensureLayoutState();
        int m = this.mOrientationHelper.m();
        int i5 = this.mOrientationHelper.i();
        int i6 = i3 > i2 ? 1 : -1;
        View view = null;
        View view2 = null;
        while (i2 != i3) {
            View childAt = getChildAt(i2);
            int position = getPosition(childAt);
            if (position >= 0 && position < i4) {
                if (((RecyclerView.p) childAt.getLayoutParams()).c()) {
                    if (view2 == null) {
                        view2 = childAt;
                    }
                } else {
                    if (this.mOrientationHelper.g(childAt) < i5 && this.mOrientationHelper.d(childAt) >= m) {
                        return childAt;
                    }
                    if (view == null) {
                        view = childAt;
                    }
                }
            }
            i2 += i6;
        }
        return view != null ? view : view2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public View findViewByPosition(int i2) {
        int childCount = getChildCount();
        if (childCount == 0) {
            return null;
        }
        int position = i2 - getPosition(getChildAt(0));
        if (position >= 0 && position < childCount) {
            View childAt = getChildAt(position);
            if (getPosition(childAt) == i2) {
                return childAt;
            }
        }
        return super.findViewByPosition(i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public RecyclerView.p generateDefaultLayoutParams() {
        return new RecyclerView.p(-2, -2);
    }

    @Deprecated
    protected int getExtraLayoutSpace(RecyclerView.z zVar) {
        if (zVar.d()) {
            return this.mOrientationHelper.n();
        }
        return 0;
    }

    public int getInitialPrefetchItemCount() {
        return this.mInitialPrefetchItemCount;
    }

    public int getOrientation() {
        return this.mOrientation;
    }

    public boolean getRecycleChildrenOnDetach() {
        return this.mRecycleChildrenOnDetach;
    }

    public boolean getReverseLayout() {
        return this.mReverseLayout;
    }

    public boolean getStackFromEnd() {
        return this.mStackFromEnd;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean isAutoMeasureEnabled() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isLayoutRTL() {
        return getLayoutDirection() == 1;
    }

    public boolean isSmoothScrollbarEnabled() {
        return this.mSmoothScrollbarEnabled;
    }

    void layoutChunk(RecyclerView.v vVar, RecyclerView.z zVar, c cVar, b bVar) {
        int i2;
        int i3;
        int i4;
        int i5;
        int f2;
        View d2 = cVar.d(vVar);
        if (d2 == null) {
            bVar.f1905b = true;
            return;
        }
        RecyclerView.p pVar = (RecyclerView.p) d2.getLayoutParams();
        if (cVar.l == null) {
            if (this.mShouldReverseLayout == (cVar.f1912f == -1)) {
                addView(d2);
            } else {
                addView(d2, 0);
            }
        } else {
            if (this.mShouldReverseLayout == (cVar.f1912f == -1)) {
                addDisappearingView(d2);
            } else {
                addDisappearingView(d2, 0);
            }
        }
        measureChildWithMargins(d2, 0, 0);
        bVar.a = this.mOrientationHelper.e(d2);
        if (this.mOrientation == 1) {
            if (isLayoutRTL()) {
                f2 = getWidth() - getPaddingRight();
                i5 = f2 - this.mOrientationHelper.f(d2);
            } else {
                i5 = getPaddingLeft();
                f2 = this.mOrientationHelper.f(d2) + i5;
            }
            if (cVar.f1912f == -1) {
                int i6 = cVar.f1908b;
                i4 = i6;
                i3 = f2;
                i2 = i6 - bVar.a;
            } else {
                int i7 = cVar.f1908b;
                i2 = i7;
                i3 = f2;
                i4 = bVar.a + i7;
            }
        } else {
            int paddingTop = getPaddingTop();
            int f3 = this.mOrientationHelper.f(d2) + paddingTop;
            if (cVar.f1912f == -1) {
                int i8 = cVar.f1908b;
                i3 = i8;
                i2 = paddingTop;
                i4 = f3;
                i5 = i8 - bVar.a;
            } else {
                int i9 = cVar.f1908b;
                i2 = paddingTop;
                i3 = bVar.a + i9;
                i4 = f3;
                i5 = i9;
            }
        }
        layoutDecoratedWithMargins(d2, i5, i2, i3, i4);
        if (pVar.c() || pVar.b()) {
            bVar.f1906c = true;
        }
        bVar.f1907d = d2.hasFocusable();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onAnchorReady(RecyclerView.v vVar, RecyclerView.z zVar, a aVar, int i2) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void onDetachedFromWindow(RecyclerView recyclerView, RecyclerView.v vVar) {
        super.onDetachedFromWindow(recyclerView, vVar);
        if (this.mRecycleChildrenOnDetach) {
            removeAndRecycleAllViews(vVar);
            vVar.c();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public View onFocusSearchFailed(View view, int i2, RecyclerView.v vVar, RecyclerView.z zVar) {
        int convertFocusDirectionToLayoutDirection;
        View findPartiallyOrCompletelyInvisibleChildClosestToEnd;
        View childClosestToEnd;
        resolveShouldLayoutReverse();
        if (getChildCount() == 0 || (convertFocusDirectionToLayoutDirection = convertFocusDirectionToLayoutDirection(i2)) == Integer.MIN_VALUE) {
            return null;
        }
        ensureLayoutState();
        updateLayoutState(convertFocusDirectionToLayoutDirection, (int) (this.mOrientationHelper.n() * MAX_SCROLL_FACTOR), false, zVar);
        c cVar = this.mLayoutState;
        cVar.f1913g = Integer.MIN_VALUE;
        cVar.a = false;
        fill(vVar, cVar, zVar, true);
        if (convertFocusDirectionToLayoutDirection == -1) {
            findPartiallyOrCompletelyInvisibleChildClosestToEnd = findPartiallyOrCompletelyInvisibleChildClosestToStart();
        } else {
            findPartiallyOrCompletelyInvisibleChildClosestToEnd = findPartiallyOrCompletelyInvisibleChildClosestToEnd();
        }
        if (convertFocusDirectionToLayoutDirection == -1) {
            childClosestToEnd = getChildClosestToStart();
        } else {
            childClosestToEnd = getChildClosestToEnd();
        }
        if (!childClosestToEnd.hasFocusable()) {
            return findPartiallyOrCompletelyInvisibleChildClosestToEnd;
        }
        if (findPartiallyOrCompletelyInvisibleChildClosestToEnd == null) {
            return null;
        }
        return childClosestToEnd;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        if (getChildCount() > 0) {
            accessibilityEvent.setFromIndex(findFirstVisibleItemPosition());
            accessibilityEvent.setToIndex(findLastVisibleItemPosition());
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void onLayoutChildren(RecyclerView.v vVar, RecyclerView.z zVar) {
        int i2;
        int i3;
        int i4;
        int i5;
        int fixLayoutEndGap;
        int i6;
        View findViewByPosition;
        int g2;
        int i7;
        int i8 = -1;
        if ((this.mPendingSavedState != null || this.mPendingScrollPosition != -1) && zVar.b() == 0) {
            removeAndRecycleAllViews(vVar);
            return;
        }
        SavedState savedState = this.mPendingSavedState;
        if (savedState != null && savedState.a()) {
            this.mPendingScrollPosition = this.mPendingSavedState.f1898f;
        }
        ensureLayoutState();
        this.mLayoutState.a = false;
        resolveShouldLayoutReverse();
        View focusedChild = getFocusedChild();
        a aVar = this.mAnchorInfo;
        if (aVar.f1904e && this.mPendingScrollPosition == -1 && this.mPendingSavedState == null) {
            if (focusedChild != null && (this.mOrientationHelper.g(focusedChild) >= this.mOrientationHelper.i() || this.mOrientationHelper.d(focusedChild) <= this.mOrientationHelper.m())) {
                this.mAnchorInfo.c(focusedChild, getPosition(focusedChild));
            }
        } else {
            aVar.e();
            a aVar2 = this.mAnchorInfo;
            aVar2.f1903d = this.mShouldReverseLayout ^ this.mStackFromEnd;
            updateAnchorInfoForLayout(vVar, zVar, aVar2);
            this.mAnchorInfo.f1904e = true;
        }
        c cVar = this.mLayoutState;
        cVar.f1912f = cVar.f1917k >= 0 ? 1 : -1;
        int[] iArr = this.mReusableIntPair;
        iArr[0] = 0;
        iArr[1] = 0;
        calculateExtraLayoutSpace(zVar, iArr);
        int max = Math.max(0, this.mReusableIntPair[0]) + this.mOrientationHelper.m();
        int max2 = Math.max(0, this.mReusableIntPair[1]) + this.mOrientationHelper.j();
        if (zVar.e() && (i6 = this.mPendingScrollPosition) != -1 && this.mPendingScrollPositionOffset != Integer.MIN_VALUE && (findViewByPosition = findViewByPosition(i6)) != null) {
            if (this.mShouldReverseLayout) {
                i7 = this.mOrientationHelper.i() - this.mOrientationHelper.d(findViewByPosition);
                g2 = this.mPendingScrollPositionOffset;
            } else {
                g2 = this.mOrientationHelper.g(findViewByPosition) - this.mOrientationHelper.m();
                i7 = this.mPendingScrollPositionOffset;
            }
            int i9 = i7 - g2;
            if (i9 > 0) {
                max += i9;
            } else {
                max2 -= i9;
            }
        }
        a aVar3 = this.mAnchorInfo;
        if (!aVar3.f1903d ? !this.mShouldReverseLayout : this.mShouldReverseLayout) {
            i8 = 1;
        }
        onAnchorReady(vVar, zVar, aVar3, i8);
        detachAndScrapAttachedViews(vVar);
        this.mLayoutState.m = resolveIsInfinite();
        this.mLayoutState.f1916j = zVar.e();
        this.mLayoutState.f1915i = 0;
        a aVar4 = this.mAnchorInfo;
        if (aVar4.f1903d) {
            updateLayoutStateToFillStart(aVar4);
            c cVar2 = this.mLayoutState;
            cVar2.f1914h = max;
            fill(vVar, cVar2, zVar, false);
            c cVar3 = this.mLayoutState;
            i3 = cVar3.f1908b;
            int i10 = cVar3.f1910d;
            int i11 = cVar3.f1909c;
            if (i11 > 0) {
                max2 += i11;
            }
            updateLayoutStateToFillEnd(this.mAnchorInfo);
            c cVar4 = this.mLayoutState;
            cVar4.f1914h = max2;
            cVar4.f1910d += cVar4.f1911e;
            fill(vVar, cVar4, zVar, false);
            c cVar5 = this.mLayoutState;
            i2 = cVar5.f1908b;
            int i12 = cVar5.f1909c;
            if (i12 > 0) {
                updateLayoutStateToFillStart(i10, i3);
                c cVar6 = this.mLayoutState;
                cVar6.f1914h = i12;
                fill(vVar, cVar6, zVar, false);
                i3 = this.mLayoutState.f1908b;
            }
        } else {
            updateLayoutStateToFillEnd(aVar4);
            c cVar7 = this.mLayoutState;
            cVar7.f1914h = max2;
            fill(vVar, cVar7, zVar, false);
            c cVar8 = this.mLayoutState;
            i2 = cVar8.f1908b;
            int i13 = cVar8.f1910d;
            int i14 = cVar8.f1909c;
            if (i14 > 0) {
                max += i14;
            }
            updateLayoutStateToFillStart(this.mAnchorInfo);
            c cVar9 = this.mLayoutState;
            cVar9.f1914h = max;
            cVar9.f1910d += cVar9.f1911e;
            fill(vVar, cVar9, zVar, false);
            c cVar10 = this.mLayoutState;
            i3 = cVar10.f1908b;
            int i15 = cVar10.f1909c;
            if (i15 > 0) {
                updateLayoutStateToFillEnd(i13, i2);
                c cVar11 = this.mLayoutState;
                cVar11.f1914h = i15;
                fill(vVar, cVar11, zVar, false);
                i2 = this.mLayoutState.f1908b;
            }
        }
        if (getChildCount() > 0) {
            if (this.mShouldReverseLayout ^ this.mStackFromEnd) {
                int fixLayoutEndGap2 = fixLayoutEndGap(i2, vVar, zVar, true);
                i4 = i3 + fixLayoutEndGap2;
                i5 = i2 + fixLayoutEndGap2;
                fixLayoutEndGap = fixLayoutStartGap(i4, vVar, zVar, false);
            } else {
                int fixLayoutStartGap = fixLayoutStartGap(i3, vVar, zVar, true);
                i4 = i3 + fixLayoutStartGap;
                i5 = i2 + fixLayoutStartGap;
                fixLayoutEndGap = fixLayoutEndGap(i5, vVar, zVar, false);
            }
            i3 = i4 + fixLayoutEndGap;
            i2 = i5 + fixLayoutEndGap;
        }
        layoutForPredictiveAnimations(vVar, zVar, i3, i2);
        if (!zVar.e()) {
            this.mOrientationHelper.s();
        } else {
            this.mAnchorInfo.e();
        }
        this.mLastStackFromEnd = this.mStackFromEnd;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void onLayoutCompleted(RecyclerView.z zVar) {
        super.onLayoutCompleted(zVar);
        this.mPendingSavedState = null;
        this.mPendingScrollPosition = -1;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        this.mAnchorInfo.e();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            this.mPendingSavedState = (SavedState) parcelable;
            requestLayout();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public Parcelable onSaveInstanceState() {
        if (this.mPendingSavedState != null) {
            return new SavedState(this.mPendingSavedState);
        }
        SavedState savedState = new SavedState();
        if (getChildCount() > 0) {
            ensureLayoutState();
            boolean z = this.mLastStackFromEnd ^ this.mShouldReverseLayout;
            savedState.f1900h = z;
            if (z) {
                View childClosestToEnd = getChildClosestToEnd();
                savedState.f1899g = this.mOrientationHelper.i() - this.mOrientationHelper.d(childClosestToEnd);
                savedState.f1898f = getPosition(childClosestToEnd);
            } else {
                View childClosestToStart = getChildClosestToStart();
                savedState.f1898f = getPosition(childClosestToStart);
                savedState.f1899g = this.mOrientationHelper.g(childClosestToStart) - this.mOrientationHelper.m();
            }
        } else {
            savedState.b();
        }
        return savedState;
    }

    public void prepareForDrop(View view, View view2, int i2, int i3) {
        assertNotInLayoutOrScroll("Cannot drop a view during a scroll or layout calculation");
        ensureLayoutState();
        resolveShouldLayoutReverse();
        int position = getPosition(view);
        int position2 = getPosition(view2);
        char c2 = position < position2 ? (char) 1 : (char) 65535;
        if (this.mShouldReverseLayout) {
            if (c2 == 1) {
                scrollToPositionWithOffset(position2, this.mOrientationHelper.i() - (this.mOrientationHelper.g(view2) + this.mOrientationHelper.e(view)));
                return;
            } else {
                scrollToPositionWithOffset(position2, this.mOrientationHelper.i() - this.mOrientationHelper.d(view2));
                return;
            }
        }
        if (c2 == 65535) {
            scrollToPositionWithOffset(position2, this.mOrientationHelper.g(view2));
        } else {
            scrollToPositionWithOffset(position2, this.mOrientationHelper.d(view2) - this.mOrientationHelper.e(view));
        }
    }

    boolean resolveIsInfinite() {
        return this.mOrientationHelper.k() == 0 && this.mOrientationHelper.h() == 0;
    }

    int scrollBy(int i2, RecyclerView.v vVar, RecyclerView.z zVar) {
        if (getChildCount() == 0 || i2 == 0) {
            return 0;
        }
        ensureLayoutState();
        this.mLayoutState.a = true;
        int i3 = i2 > 0 ? 1 : -1;
        int abs = Math.abs(i2);
        updateLayoutState(i3, abs, true, zVar);
        c cVar = this.mLayoutState;
        int fill = cVar.f1913g + fill(vVar, cVar, zVar, false);
        if (fill < 0) {
            return 0;
        }
        if (abs > fill) {
            i2 = i3 * fill;
        }
        this.mOrientationHelper.r(-i2);
        this.mLayoutState.f1917k = i2;
        return i2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int scrollHorizontallyBy(int i2, RecyclerView.v vVar, RecyclerView.z zVar) {
        if (this.mOrientation == 1) {
            return 0;
        }
        return scrollBy(i2, vVar, zVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void scrollToPosition(int i2) {
        this.mPendingScrollPosition = i2;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        SavedState savedState = this.mPendingSavedState;
        if (savedState != null) {
            savedState.b();
        }
        requestLayout();
    }

    public void scrollToPositionWithOffset(int i2, int i3) {
        this.mPendingScrollPosition = i2;
        this.mPendingScrollPositionOffset = i3;
        SavedState savedState = this.mPendingSavedState;
        if (savedState != null) {
            savedState.b();
        }
        requestLayout();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int scrollVerticallyBy(int i2, RecyclerView.v vVar, RecyclerView.z zVar) {
        if (this.mOrientation == 0) {
            return 0;
        }
        return scrollBy(i2, vVar, zVar);
    }

    public void setInitialPrefetchItemCount(int i2) {
        this.mInitialPrefetchItemCount = i2;
    }

    public void setOrientation(int i2) {
        if (i2 != 0 && i2 != 1) {
            throw new IllegalArgumentException("invalid orientation:" + i2);
        }
        assertNotInLayoutOrScroll(null);
        if (i2 != this.mOrientation || this.mOrientationHelper == null) {
            n b2 = n.b(this, i2);
            this.mOrientationHelper = b2;
            this.mAnchorInfo.a = b2;
            this.mOrientation = i2;
            requestLayout();
        }
    }

    public void setRecycleChildrenOnDetach(boolean z) {
        this.mRecycleChildrenOnDetach = z;
    }

    public void setReverseLayout(boolean z) {
        assertNotInLayoutOrScroll(null);
        if (z == this.mReverseLayout) {
            return;
        }
        this.mReverseLayout = z;
        requestLayout();
    }

    public void setSmoothScrollbarEnabled(boolean z) {
        this.mSmoothScrollbarEnabled = z;
    }

    public void setStackFromEnd(boolean z) {
        assertNotInLayoutOrScroll(null);
        if (this.mStackFromEnd == z) {
            return;
        }
        this.mStackFromEnd = z;
        requestLayout();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    boolean shouldMeasureTwice() {
        return (getHeightMode() == 1073741824 || getWidthMode() == 1073741824 || !hasFlexibleChildInBothOrientations()) ? false : true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.z zVar, int i2) {
        j jVar = new j(recyclerView.getContext());
        jVar.setTargetPosition(i2);
        startSmoothScroll(jVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean supportsPredictiveItemAnimations() {
        return this.mPendingSavedState == null && this.mLastStackFromEnd == this.mStackFromEnd;
    }

    void validateChildOrder() {
        Log.d(TAG, "validating child count " + getChildCount());
        if (getChildCount() < 1) {
            return;
        }
        int position = getPosition(getChildAt(0));
        int g2 = this.mOrientationHelper.g(getChildAt(0));
        if (this.mShouldReverseLayout) {
            for (int i2 = 1; i2 < getChildCount(); i2++) {
                View childAt = getChildAt(i2);
                int position2 = getPosition(childAt);
                int g3 = this.mOrientationHelper.g(childAt);
                if (position2 < position) {
                    logChildren();
                    StringBuilder sb = new StringBuilder();
                    sb.append("detected invalid position. loc invalid? ");
                    sb.append(g3 < g2);
                    throw new RuntimeException(sb.toString());
                }
                if (g3 > g2) {
                    logChildren();
                    throw new RuntimeException("detected invalid location");
                }
            }
            return;
        }
        for (int i3 = 1; i3 < getChildCount(); i3++) {
            View childAt2 = getChildAt(i3);
            int position3 = getPosition(childAt2);
            int g4 = this.mOrientationHelper.g(childAt2);
            if (position3 < position) {
                logChildren();
                StringBuilder sb2 = new StringBuilder();
                sb2.append("detected invalid position. loc invalid? ");
                sb2.append(g4 < g2);
                throw new RuntimeException(sb2.toString());
            }
            if (g4 < g2) {
                logChildren();
                throw new RuntimeException("detected invalid location");
            }
        }
    }

    public LinearLayoutManager(Context context, int i2, boolean z) {
        this.mOrientation = 1;
        this.mReverseLayout = false;
        this.mShouldReverseLayout = false;
        this.mStackFromEnd = false;
        this.mSmoothScrollbarEnabled = true;
        this.mPendingScrollPosition = -1;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        this.mPendingSavedState = null;
        this.mAnchorInfo = new a();
        this.mLayoutChunkResult = new b();
        this.mInitialPrefetchItemCount = 2;
        this.mReusableIntPair = new int[2];
        setOrientation(i2);
        setReverseLayout(z);
    }

    private void updateLayoutStateToFillEnd(int i2, int i3) {
        this.mLayoutState.f1909c = this.mOrientationHelper.i() - i3;
        c cVar = this.mLayoutState;
        cVar.f1911e = this.mShouldReverseLayout ? -1 : 1;
        cVar.f1910d = i2;
        cVar.f1912f = 1;
        cVar.f1908b = i3;
        cVar.f1913g = Integer.MIN_VALUE;
    }

    private void updateLayoutStateToFillStart(int i2, int i3) {
        this.mLayoutState.f1909c = i3 - this.mOrientationHelper.m();
        c cVar = this.mLayoutState;
        cVar.f1910d = i2;
        cVar.f1911e = this.mShouldReverseLayout ? 1 : -1;
        cVar.f1912f = -1;
        cVar.f1908b = i3;
        cVar.f1913g = Integer.MIN_VALUE;
    }

    public LinearLayoutManager(Context context, AttributeSet attributeSet, int i2, int i3) {
        this.mOrientation = 1;
        this.mReverseLayout = false;
        this.mShouldReverseLayout = false;
        this.mStackFromEnd = false;
        this.mSmoothScrollbarEnabled = true;
        this.mPendingScrollPosition = -1;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        this.mPendingSavedState = null;
        this.mAnchorInfo = new a();
        this.mLayoutChunkResult = new b();
        this.mInitialPrefetchItemCount = 2;
        this.mReusableIntPair = new int[2];
        RecyclerView.o.d properties = RecyclerView.o.getProperties(context, attributeSet, i2, i3);
        setOrientation(properties.a);
        setReverseLayout(properties.f1931c);
        setStackFromEnd(properties.f1932d);
    }
}
