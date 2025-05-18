package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.d0.c;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Arrays;

/* loaded from: classes.dex */
public class GridLayoutManager extends LinearLayoutManager {
    private static final boolean DEBUG = false;
    public static final int DEFAULT_SPAN_COUNT = -1;
    private static final String TAG = "GridLayoutManager";
    int[] mCachedBorders;
    final Rect mDecorInsets;
    boolean mPendingSpanCountChange;
    final SparseIntArray mPreLayoutSpanIndexCache;
    final SparseIntArray mPreLayoutSpanSizeCache;
    View[] mSet;
    int mSpanCount;
    c mSpanSizeLookup;
    private boolean mUsingSpansToEstimateScrollBarDimensions;

    /* loaded from: classes.dex */
    public static final class a extends c {
        @Override // androidx.recyclerview.widget.GridLayoutManager.c
        public int getSpanIndex(int i2, int i3) {
            return i2 % i3;
        }

        @Override // androidx.recyclerview.widget.GridLayoutManager.c
        public int getSpanSize(int i2) {
            return 1;
        }
    }

    /* loaded from: classes.dex */
    public static abstract class c {
        final SparseIntArray mSpanIndexCache = new SparseIntArray();
        final SparseIntArray mSpanGroupIndexCache = new SparseIntArray();
        private boolean mCacheSpanIndices = false;
        private boolean mCacheSpanGroupIndices = false;

        static int findFirstKeyLessThan(SparseIntArray sparseIntArray, int i2) {
            int size = sparseIntArray.size() - 1;
            int i3 = 0;
            while (i3 <= size) {
                int i4 = (i3 + size) >>> 1;
                if (sparseIntArray.keyAt(i4) < i2) {
                    i3 = i4 + 1;
                } else {
                    size = i4 - 1;
                }
            }
            int i5 = i3 - 1;
            if (i5 < 0 || i5 >= sparseIntArray.size()) {
                return -1;
            }
            return sparseIntArray.keyAt(i5);
        }

        int getCachedSpanGroupIndex(int i2, int i3) {
            if (!this.mCacheSpanGroupIndices) {
                return getSpanGroupIndex(i2, i3);
            }
            int i4 = this.mSpanGroupIndexCache.get(i2, -1);
            if (i4 != -1) {
                return i4;
            }
            int spanGroupIndex = getSpanGroupIndex(i2, i3);
            this.mSpanGroupIndexCache.put(i2, spanGroupIndex);
            return spanGroupIndex;
        }

        int getCachedSpanIndex(int i2, int i3) {
            if (!this.mCacheSpanIndices) {
                return getSpanIndex(i2, i3);
            }
            int i4 = this.mSpanIndexCache.get(i2, -1);
            if (i4 != -1) {
                return i4;
            }
            int spanIndex = getSpanIndex(i2, i3);
            this.mSpanIndexCache.put(i2, spanIndex);
            return spanIndex;
        }

        /* JADX WARN: Removed duplicated region for block: B:11:0x002d  */
        /* JADX WARN: Removed duplicated region for block: B:23:0x0043  */
        /* JADX WARN: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public int getSpanGroupIndex(int i2, int i3) {
            int i4;
            int i5;
            int findFirstKeyLessThan;
            if (this.mCacheSpanGroupIndices && (findFirstKeyLessThan = findFirstKeyLessThan(this.mSpanGroupIndexCache, i2)) != -1) {
                int i6 = this.mSpanGroupIndexCache.get(findFirstKeyLessThan);
                i4 = findFirstKeyLessThan + 1;
                i5 = getCachedSpanIndex(findFirstKeyLessThan, i3) + getSpanSize(findFirstKeyLessThan);
                i6 = i5 == i3 ? i6 + 1 : 0;
                int spanSize = getSpanSize(i2);
                while (i4 < i2) {
                    int spanSize2 = getSpanSize(i4);
                    i5 += spanSize2;
                    if (i5 == i3) {
                        i6++;
                        i5 = 0;
                    } else if (i5 > i3) {
                        i6++;
                        i5 = spanSize2;
                    }
                    i4++;
                }
                return i5 + spanSize <= i3 ? i6 + 1 : i6;
            }
            i4 = 0;
            i5 = 0;
            int spanSize3 = getSpanSize(i2);
            while (i4 < i2) {
            }
            if (i5 + spanSize3 <= i3) {
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:12:0x0024  */
        /* JADX WARN: Removed duplicated region for block: B:17:0x0033  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x002b -> B:10:0x0030). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x002d -> B:10:0x0030). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x002f -> B:10:0x0030). Please report as a decompilation issue!!! */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public int getSpanIndex(int i2, int i3) {
            int i4;
            int i5;
            int spanSize = getSpanSize(i2);
            if (spanSize == i3) {
                return 0;
            }
            if (!this.mCacheSpanIndices || (i4 = findFirstKeyLessThan(this.mSpanIndexCache, i2)) < 0) {
                i4 = 0;
                i5 = 0;
                if (i4 >= i2) {
                    int spanSize2 = getSpanSize(i4);
                    i5 += spanSize2;
                    if (i5 == i3) {
                        i5 = 0;
                    } else if (i5 > i3) {
                        i5 = spanSize2;
                    }
                    i4++;
                    if (i4 >= i2) {
                        if (spanSize + i5 <= i3) {
                            return i5;
                        }
                        return 0;
                    }
                }
            } else {
                i5 = this.mSpanIndexCache.get(i4) + getSpanSize(i4);
                i4++;
                if (i4 >= i2) {
                }
            }
        }

        public abstract int getSpanSize(int i2);

        public void invalidateSpanGroupIndexCache() {
            this.mSpanGroupIndexCache.clear();
        }

        public void invalidateSpanIndexCache() {
            this.mSpanIndexCache.clear();
        }

        public boolean isSpanGroupIndexCacheEnabled() {
            return this.mCacheSpanGroupIndices;
        }

        public boolean isSpanIndexCacheEnabled() {
            return this.mCacheSpanIndices;
        }

        public void setSpanGroupIndexCacheEnabled(boolean z) {
            if (!z) {
                this.mSpanGroupIndexCache.clear();
            }
            this.mCacheSpanGroupIndices = z;
        }

        public void setSpanIndexCacheEnabled(boolean z) {
            if (!z) {
                this.mSpanGroupIndexCache.clear();
            }
            this.mCacheSpanIndices = z;
        }
    }

    public GridLayoutManager(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        this.mPendingSpanCountChange = false;
        this.mSpanCount = -1;
        this.mPreLayoutSpanSizeCache = new SparseIntArray();
        this.mPreLayoutSpanIndexCache = new SparseIntArray();
        this.mSpanSizeLookup = new a();
        this.mDecorInsets = new Rect();
        setSpanCount(RecyclerView.o.getProperties(context, attributeSet, i2, i3).f1930b);
    }

    private void assignSpans(RecyclerView.v vVar, RecyclerView.z zVar, int i2, boolean z) {
        int i3;
        int i4;
        int i5 = 0;
        int i6 = -1;
        if (z) {
            i6 = i2;
            i3 = 0;
            i4 = 1;
        } else {
            i3 = i2 - 1;
            i4 = -1;
        }
        while (i3 != i6) {
            View view = this.mSet[i3];
            b bVar = (b) view.getLayoutParams();
            int spanSize = getSpanSize(vVar, zVar, getPosition(view));
            bVar.f1897f = spanSize;
            bVar.f1896e = i5;
            i5 += spanSize;
            i3 += i4;
        }
    }

    private void cachePreLayoutSpanMapping() {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            b bVar = (b) getChildAt(i2).getLayoutParams();
            int a2 = bVar.a();
            this.mPreLayoutSpanSizeCache.put(a2, bVar.f());
            this.mPreLayoutSpanIndexCache.put(a2, bVar.e());
        }
    }

    private void calculateItemBorders(int i2) {
        this.mCachedBorders = calculateItemBorders(this.mCachedBorders, this.mSpanCount, i2);
    }

    private void clearPreLayoutSpanMappingCache() {
        this.mPreLayoutSpanSizeCache.clear();
        this.mPreLayoutSpanIndexCache.clear();
    }

    private int computeScrollOffsetWithSpanInfo(RecyclerView.z zVar) {
        int max;
        if (getChildCount() != 0 && zVar.b() != 0) {
            ensureLayoutState();
            boolean isSmoothScrollbarEnabled = isSmoothScrollbarEnabled();
            View findFirstVisibleChildClosestToStart = findFirstVisibleChildClosestToStart(!isSmoothScrollbarEnabled, true);
            View findFirstVisibleChildClosestToEnd = findFirstVisibleChildClosestToEnd(!isSmoothScrollbarEnabled, true);
            if (findFirstVisibleChildClosestToStart != null && findFirstVisibleChildClosestToEnd != null) {
                int cachedSpanGroupIndex = this.mSpanSizeLookup.getCachedSpanGroupIndex(getPosition(findFirstVisibleChildClosestToStart), this.mSpanCount);
                int cachedSpanGroupIndex2 = this.mSpanSizeLookup.getCachedSpanGroupIndex(getPosition(findFirstVisibleChildClosestToEnd), this.mSpanCount);
                int min = Math.min(cachedSpanGroupIndex, cachedSpanGroupIndex2);
                int max2 = Math.max(cachedSpanGroupIndex, cachedSpanGroupIndex2);
                int cachedSpanGroupIndex3 = this.mSpanSizeLookup.getCachedSpanGroupIndex(zVar.b() - 1, this.mSpanCount) + 1;
                if (this.mShouldReverseLayout) {
                    max = Math.max(0, (cachedSpanGroupIndex3 - max2) - 1);
                } else {
                    max = Math.max(0, min);
                }
                if (!isSmoothScrollbarEnabled) {
                    return max;
                }
                return Math.round((max * (Math.abs(this.mOrientationHelper.d(findFirstVisibleChildClosestToEnd) - this.mOrientationHelper.g(findFirstVisibleChildClosestToStart)) / ((this.mSpanSizeLookup.getCachedSpanGroupIndex(getPosition(findFirstVisibleChildClosestToEnd), this.mSpanCount) - this.mSpanSizeLookup.getCachedSpanGroupIndex(getPosition(findFirstVisibleChildClosestToStart), this.mSpanCount)) + 1))) + (this.mOrientationHelper.m() - this.mOrientationHelper.g(findFirstVisibleChildClosestToStart)));
            }
        }
        return 0;
    }

    private int computeScrollRangeWithSpanInfo(RecyclerView.z zVar) {
        if (getChildCount() != 0 && zVar.b() != 0) {
            ensureLayoutState();
            View findFirstVisibleChildClosestToStart = findFirstVisibleChildClosestToStart(!isSmoothScrollbarEnabled(), true);
            View findFirstVisibleChildClosestToEnd = findFirstVisibleChildClosestToEnd(!isSmoothScrollbarEnabled(), true);
            if (findFirstVisibleChildClosestToStart != null && findFirstVisibleChildClosestToEnd != null) {
                if (!isSmoothScrollbarEnabled()) {
                    return this.mSpanSizeLookup.getCachedSpanGroupIndex(zVar.b() - 1, this.mSpanCount) + 1;
                }
                int d2 = this.mOrientationHelper.d(findFirstVisibleChildClosestToEnd) - this.mOrientationHelper.g(findFirstVisibleChildClosestToStart);
                int cachedSpanGroupIndex = this.mSpanSizeLookup.getCachedSpanGroupIndex(getPosition(findFirstVisibleChildClosestToStart), this.mSpanCount);
                return (int) ((d2 / ((this.mSpanSizeLookup.getCachedSpanGroupIndex(getPosition(findFirstVisibleChildClosestToEnd), this.mSpanCount) - cachedSpanGroupIndex) + 1)) * (this.mSpanSizeLookup.getCachedSpanGroupIndex(zVar.b() - 1, this.mSpanCount) + 1));
            }
        }
        return 0;
    }

    private void ensureAnchorIsInCorrectSpan(RecyclerView.v vVar, RecyclerView.z zVar, LinearLayoutManager.a aVar, int i2) {
        boolean z = i2 == 1;
        int spanIndex = getSpanIndex(vVar, zVar, aVar.f1901b);
        if (z) {
            while (spanIndex > 0) {
                int i3 = aVar.f1901b;
                if (i3 <= 0) {
                    return;
                }
                int i4 = i3 - 1;
                aVar.f1901b = i4;
                spanIndex = getSpanIndex(vVar, zVar, i4);
            }
            return;
        }
        int b2 = zVar.b() - 1;
        int i5 = aVar.f1901b;
        while (i5 < b2) {
            int i6 = i5 + 1;
            int spanIndex2 = getSpanIndex(vVar, zVar, i6);
            if (spanIndex2 <= spanIndex) {
                break;
            }
            i5 = i6;
            spanIndex = spanIndex2;
        }
        aVar.f1901b = i5;
    }

    private void ensureViewSet() {
        View[] viewArr = this.mSet;
        if (viewArr == null || viewArr.length != this.mSpanCount) {
            this.mSet = new View[this.mSpanCount];
        }
    }

    private int getSpanGroupIndex(RecyclerView.v vVar, RecyclerView.z zVar, int i2) {
        if (!zVar.e()) {
            return this.mSpanSizeLookup.getCachedSpanGroupIndex(i2, this.mSpanCount);
        }
        int f2 = vVar.f(i2);
        if (f2 == -1) {
            Log.w(TAG, "Cannot find span size for pre layout position. " + i2);
            return 0;
        }
        return this.mSpanSizeLookup.getCachedSpanGroupIndex(f2, this.mSpanCount);
    }

    private int getSpanIndex(RecyclerView.v vVar, RecyclerView.z zVar, int i2) {
        if (!zVar.e()) {
            return this.mSpanSizeLookup.getCachedSpanIndex(i2, this.mSpanCount);
        }
        int i3 = this.mPreLayoutSpanIndexCache.get(i2, -1);
        if (i3 != -1) {
            return i3;
        }
        int f2 = vVar.f(i2);
        if (f2 == -1) {
            Log.w(TAG, "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + i2);
            return 0;
        }
        return this.mSpanSizeLookup.getCachedSpanIndex(f2, this.mSpanCount);
    }

    private int getSpanSize(RecyclerView.v vVar, RecyclerView.z zVar, int i2) {
        if (!zVar.e()) {
            return this.mSpanSizeLookup.getSpanSize(i2);
        }
        int i3 = this.mPreLayoutSpanSizeCache.get(i2, -1);
        if (i3 != -1) {
            return i3;
        }
        int f2 = vVar.f(i2);
        if (f2 == -1) {
            Log.w(TAG, "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + i2);
            return 1;
        }
        return this.mSpanSizeLookup.getSpanSize(f2);
    }

    private void guessMeasurement(float f2, int i2) {
        calculateItemBorders(Math.max(Math.round(f2 * this.mSpanCount), i2));
    }

    private void measureChild(View view, int i2, boolean z) {
        int i3;
        int i4;
        b bVar = (b) view.getLayoutParams();
        Rect rect = bVar.f1933b;
        int i5 = rect.top + rect.bottom + ((ViewGroup.MarginLayoutParams) bVar).topMargin + ((ViewGroup.MarginLayoutParams) bVar).bottomMargin;
        int i6 = rect.left + rect.right + ((ViewGroup.MarginLayoutParams) bVar).leftMargin + ((ViewGroup.MarginLayoutParams) bVar).rightMargin;
        int spaceForSpanRange = getSpaceForSpanRange(bVar.f1896e, bVar.f1897f);
        if (this.mOrientation == 1) {
            i4 = RecyclerView.o.getChildMeasureSpec(spaceForSpanRange, i2, i6, ((ViewGroup.MarginLayoutParams) bVar).width, false);
            i3 = RecyclerView.o.getChildMeasureSpec(this.mOrientationHelper.n(), getHeightMode(), i5, ((ViewGroup.MarginLayoutParams) bVar).height, true);
        } else {
            int childMeasureSpec = RecyclerView.o.getChildMeasureSpec(spaceForSpanRange, i2, i5, ((ViewGroup.MarginLayoutParams) bVar).height, false);
            int childMeasureSpec2 = RecyclerView.o.getChildMeasureSpec(this.mOrientationHelper.n(), getWidthMode(), i6, ((ViewGroup.MarginLayoutParams) bVar).width, true);
            i3 = childMeasureSpec;
            i4 = childMeasureSpec2;
        }
        measureChildWithDecorationsAndMargin(view, i4, i3, z);
    }

    private void measureChildWithDecorationsAndMargin(View view, int i2, int i3, boolean z) {
        boolean shouldMeasureChild;
        RecyclerView.p pVar = (RecyclerView.p) view.getLayoutParams();
        if (z) {
            shouldMeasureChild = shouldReMeasureChild(view, i2, i3, pVar);
        } else {
            shouldMeasureChild = shouldMeasureChild(view, i2, i3, pVar);
        }
        if (shouldMeasureChild) {
            view.measure(i2, i3);
        }
    }

    private void updateMeasurements() {
        int height;
        int paddingTop;
        if (getOrientation() == 1) {
            height = getWidth() - getPaddingRight();
            paddingTop = getPaddingLeft();
        } else {
            height = getHeight() - getPaddingBottom();
            paddingTop = getPaddingTop();
        }
        calculateItemBorders(height - paddingTop);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public boolean checkLayoutParams(RecyclerView.p pVar) {
        return pVar instanceof b;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    void collectPrefetchPositionsForLayoutState(RecyclerView.z zVar, LinearLayoutManager.c cVar, RecyclerView.o.c cVar2) {
        int i2 = this.mSpanCount;
        for (int i3 = 0; i3 < this.mSpanCount && cVar.c(zVar) && i2 > 0; i3++) {
            int i4 = cVar.f1910d;
            cVar2.a(i4, Math.max(0, cVar.f1913g));
            i2 -= this.mSpanSizeLookup.getSpanSize(i4);
            cVar.f1910d += cVar.f1911e;
        }
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public int computeHorizontalScrollOffset(RecyclerView.z zVar) {
        if (this.mUsingSpansToEstimateScrollBarDimensions) {
            return computeScrollOffsetWithSpanInfo(zVar);
        }
        return super.computeHorizontalScrollOffset(zVar);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public int computeHorizontalScrollRange(RecyclerView.z zVar) {
        if (this.mUsingSpansToEstimateScrollBarDimensions) {
            return computeScrollRangeWithSpanInfo(zVar);
        }
        return super.computeHorizontalScrollRange(zVar);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public int computeVerticalScrollOffset(RecyclerView.z zVar) {
        if (this.mUsingSpansToEstimateScrollBarDimensions) {
            return computeScrollOffsetWithSpanInfo(zVar);
        }
        return super.computeVerticalScrollOffset(zVar);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public int computeVerticalScrollRange(RecyclerView.z zVar) {
        if (this.mUsingSpansToEstimateScrollBarDimensions) {
            return computeScrollRangeWithSpanInfo(zVar);
        }
        return super.computeVerticalScrollRange(zVar);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
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
            if (position >= 0 && position < i4 && getSpanIndex(vVar, zVar, position) == 0) {
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

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public RecyclerView.p generateDefaultLayoutParams() {
        if (this.mOrientation == 0) {
            return new b(-2, -1);
        }
        return new b(-1, -2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public RecyclerView.p generateLayoutParams(Context context, AttributeSet attributeSet) {
        return new b(context, attributeSet);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int getColumnCountForAccessibility(RecyclerView.v vVar, RecyclerView.z zVar) {
        if (this.mOrientation == 1) {
            return this.mSpanCount;
        }
        if (zVar.b() < 1) {
            return 0;
        }
        return getSpanGroupIndex(vVar, zVar, zVar.b() - 1) + 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public int getRowCountForAccessibility(RecyclerView.v vVar, RecyclerView.z zVar) {
        if (this.mOrientation == 0) {
            return this.mSpanCount;
        }
        if (zVar.b() < 1) {
            return 0;
        }
        return getSpanGroupIndex(vVar, zVar, zVar.b() - 1) + 1;
    }

    int getSpaceForSpanRange(int i2, int i3) {
        if (this.mOrientation == 1 && isLayoutRTL()) {
            int[] iArr = this.mCachedBorders;
            int i4 = this.mSpanCount;
            return iArr[i4 - i2] - iArr[(i4 - i2) - i3];
        }
        int[] iArr2 = this.mCachedBorders;
        return iArr2[i3 + i2] - iArr2[i2];
    }

    public int getSpanCount() {
        return this.mSpanCount;
    }

    public c getSpanSizeLookup() {
        return this.mSpanSizeLookup;
    }

    public boolean isUsingSpansToEstimateScrollbarDimensions() {
        return this.mUsingSpansToEstimateScrollBarDimensions;
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x009f, code lost:
    
        r21.f1905b = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00a1, code lost:
    
        return;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v1, types: [int, boolean] */
    /* JADX WARN: Type inference failed for: r5v19 */
    @Override // androidx.recyclerview.widget.LinearLayoutManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    void layoutChunk(RecyclerView.v vVar, RecyclerView.z zVar, LinearLayoutManager.c cVar, LinearLayoutManager.b bVar) {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int f2;
        int i8;
        int childMeasureSpec;
        int i9;
        View d2;
        int l = this.mOrientationHelper.l();
        ?? r5 = 0;
        boolean z = l != 1073741824;
        int i10 = getChildCount() > 0 ? this.mCachedBorders[this.mSpanCount] : 0;
        if (z) {
            updateMeasurements();
        }
        boolean z2 = cVar.f1911e == 1;
        int i11 = this.mSpanCount;
        if (!z2) {
            i11 = getSpanIndex(vVar, zVar, cVar.f1910d) + getSpanSize(vVar, zVar, cVar.f1910d);
        }
        int i12 = 0;
        while (i12 < this.mSpanCount && cVar.c(zVar) && i11 > 0) {
            int i13 = cVar.f1910d;
            int spanSize = getSpanSize(vVar, zVar, i13);
            if (spanSize > this.mSpanCount) {
                throw new IllegalArgumentException("Item at position " + i13 + " requires " + spanSize + " spans but GridLayoutManager has only " + this.mSpanCount + " spans.");
            }
            i11 -= spanSize;
            if (i11 < 0 || (d2 = cVar.d(vVar)) == null) {
                break;
            }
            this.mSet[i12] = d2;
            i12++;
        }
        float f3 = 0.0f;
        assignSpans(vVar, zVar, i12, z2);
        int i14 = 0;
        int i15 = 0;
        while (i14 < i12) {
            View view = this.mSet[i14];
            if (cVar.l == null) {
                if (z2) {
                    addView(view);
                } else {
                    addView(view, r5);
                }
            } else if (z2) {
                addDisappearingView(view);
            } else {
                addDisappearingView(view, r5);
            }
            calculateItemDecorationsForChild(view, this.mDecorInsets);
            measureChild(view, l, (boolean) r5);
            int e2 = this.mOrientationHelper.e(view);
            if (e2 > i15) {
                i15 = e2;
            }
            float f4 = (this.mOrientationHelper.f(view) * 1.0f) / ((b) view.getLayoutParams()).f1897f;
            if (f4 > f3) {
                f3 = f4;
            }
            i14++;
            r5 = 0;
        }
        if (z) {
            guessMeasurement(f3, i10);
            i15 = 0;
            for (int i16 = 0; i16 < i12; i16++) {
                View view2 = this.mSet[i16];
                measureChild(view2, 1073741824, true);
                int e3 = this.mOrientationHelper.e(view2);
                if (e3 > i15) {
                    i15 = e3;
                }
            }
        }
        for (int i17 = 0; i17 < i12; i17++) {
            View view3 = this.mSet[i17];
            if (this.mOrientationHelper.e(view3) != i15) {
                b bVar2 = (b) view3.getLayoutParams();
                Rect rect = bVar2.f1933b;
                int i18 = rect.top + rect.bottom + ((ViewGroup.MarginLayoutParams) bVar2).topMargin + ((ViewGroup.MarginLayoutParams) bVar2).bottomMargin;
                int i19 = rect.left + rect.right + ((ViewGroup.MarginLayoutParams) bVar2).leftMargin + ((ViewGroup.MarginLayoutParams) bVar2).rightMargin;
                int spaceForSpanRange = getSpaceForSpanRange(bVar2.f1896e, bVar2.f1897f);
                if (this.mOrientation == 1) {
                    i9 = RecyclerView.o.getChildMeasureSpec(spaceForSpanRange, 1073741824, i19, ((ViewGroup.MarginLayoutParams) bVar2).width, false);
                    childMeasureSpec = View.MeasureSpec.makeMeasureSpec(i15 - i18, 1073741824);
                } else {
                    int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i15 - i19, 1073741824);
                    childMeasureSpec = RecyclerView.o.getChildMeasureSpec(spaceForSpanRange, 1073741824, i18, ((ViewGroup.MarginLayoutParams) bVar2).height, false);
                    i9 = makeMeasureSpec;
                }
                measureChildWithDecorationsAndMargin(view3, i9, childMeasureSpec, true);
            }
        }
        int i20 = 0;
        bVar.a = i15;
        if (this.mOrientation == 1) {
            if (cVar.f1912f == -1) {
                i4 = cVar.f1908b;
                i5 = i4 - i15;
            } else {
                int i21 = cVar.f1908b;
                i5 = i21;
                i4 = i15 + i21;
            }
            i2 = 0;
            i3 = 0;
        } else if (cVar.f1912f == -1) {
            int i22 = cVar.f1908b;
            i3 = i22 - i15;
            i5 = 0;
            i2 = i22;
            i4 = 0;
        } else {
            int i23 = cVar.f1908b;
            i2 = i15 + i23;
            i3 = i23;
            i4 = 0;
            i5 = 0;
        }
        while (i20 < i12) {
            View view4 = this.mSet[i20];
            b bVar3 = (b) view4.getLayoutParams();
            if (this.mOrientation == 1) {
                if (isLayoutRTL()) {
                    int paddingLeft = getPaddingLeft() + this.mCachedBorders[this.mSpanCount - bVar3.f1896e];
                    i3 = paddingLeft - this.mOrientationHelper.f(view4);
                    f2 = i4;
                    i7 = paddingLeft;
                    i6 = i5;
                } else {
                    int paddingLeft2 = getPaddingLeft() + this.mCachedBorders[bVar3.f1896e];
                    f2 = i4;
                    i8 = paddingLeft2;
                    i6 = i5;
                    i7 = this.mOrientationHelper.f(view4) + paddingLeft2;
                    layoutDecoratedWithMargins(view4, i8, i6, i7, f2);
                    if (!bVar3.c() || bVar3.b()) {
                        bVar.f1906c = true;
                    }
                    bVar.f1907d |= view4.hasFocusable();
                    i20++;
                    i4 = f2;
                    i2 = i7;
                    i5 = i6;
                    i3 = i8;
                }
            } else {
                int paddingTop = getPaddingTop() + this.mCachedBorders[bVar3.f1896e];
                i6 = paddingTop;
                i7 = i2;
                f2 = this.mOrientationHelper.f(view4) + paddingTop;
            }
            i8 = i3;
            layoutDecoratedWithMargins(view4, i8, i6, i7, f2);
            if (!bVar3.c()) {
            }
            bVar.f1906c = true;
            bVar.f1907d |= view4.hasFocusable();
            i20++;
            i4 = f2;
            i2 = i7;
            i5 = i6;
            i3 = i8;
        }
        Arrays.fill(this.mSet, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public void onAnchorReady(RecyclerView.v vVar, RecyclerView.z zVar, LinearLayoutManager.a aVar, int i2) {
        super.onAnchorReady(vVar, zVar, aVar, i2);
        updateMeasurements();
        if (zVar.b() > 0 && !zVar.e()) {
            ensureAnchorIsInCorrectSpan(vVar, zVar, aVar, i2);
        }
        ensureViewSet();
    }

    /* JADX WARN: Code restructure failed: missing block: B:68:0x00d6, code lost:
    
        if (r13 == (r2 > r15)) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x00f6, code lost:
    
        if (r13 == (r2 > r7)) goto L50;
     */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0107  */
    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public View onFocusSearchFailed(View view, int i2, RecyclerView.v vVar, RecyclerView.z zVar) {
        int childCount;
        int i3;
        int i4;
        View view2;
        View view3;
        int i5;
        int i6;
        boolean z;
        int i7;
        int i8;
        RecyclerView.v vVar2 = vVar;
        RecyclerView.z zVar2 = zVar;
        View findContainingItemView = findContainingItemView(view);
        View view4 = null;
        if (findContainingItemView == null) {
            return null;
        }
        b bVar = (b) findContainingItemView.getLayoutParams();
        int i9 = bVar.f1896e;
        int i10 = bVar.f1897f + i9;
        if (super.onFocusSearchFailed(view, i2, vVar, zVar) == null) {
            return null;
        }
        if ((convertFocusDirectionToLayoutDirection(i2) == 1) != this.mShouldReverseLayout) {
            i3 = getChildCount() - 1;
            childCount = -1;
            i4 = -1;
        } else {
            childCount = getChildCount();
            i3 = 0;
            i4 = 1;
        }
        boolean z2 = this.mOrientation == 1 && isLayoutRTL();
        int spanGroupIndex = getSpanGroupIndex(vVar2, zVar2, i3);
        int i11 = i3;
        int i12 = 0;
        int i13 = -1;
        int i14 = -1;
        int i15 = 0;
        View view5 = null;
        while (i11 != childCount) {
            int spanGroupIndex2 = getSpanGroupIndex(vVar2, zVar2, i11);
            View childAt = getChildAt(i11);
            if (childAt == findContainingItemView) {
                break;
            }
            if (!childAt.hasFocusable() || spanGroupIndex2 == spanGroupIndex) {
                b bVar2 = (b) childAt.getLayoutParams();
                int i16 = bVar2.f1896e;
                view2 = findContainingItemView;
                int i17 = bVar2.f1897f + i16;
                if (childAt.hasFocusable() && i16 == i9 && i17 == i10) {
                    return childAt;
                }
                if (!(childAt.hasFocusable() && view4 == null) && (childAt.hasFocusable() || view5 != null)) {
                    view3 = view5;
                    int min = Math.min(i17, i10) - Math.max(i16, i9);
                    if (childAt.hasFocusable()) {
                        if (min <= i12) {
                            if (min == i12) {
                            }
                        }
                    } else if (view4 == null) {
                        i5 = i12;
                        i6 = childCount;
                        if (isViewPartiallyVisible(childAt, false, true)) {
                            i7 = i15;
                            if (min > i7) {
                                i8 = i14;
                                if (z) {
                                    if (childAt.hasFocusable()) {
                                        i13 = bVar2.f1896e;
                                        i14 = i8;
                                        i15 = i7;
                                        view5 = view3;
                                        view4 = childAt;
                                        i12 = Math.min(i17, i10) - Math.max(i16, i9);
                                    } else {
                                        int i18 = bVar2.f1896e;
                                        i15 = Math.min(i17, i10) - Math.max(i16, i9);
                                        i14 = i18;
                                        i12 = i5;
                                        view5 = childAt;
                                    }
                                    i11 += i4;
                                    vVar2 = vVar;
                                    zVar2 = zVar;
                                    findContainingItemView = view2;
                                    childCount = i6;
                                }
                            } else {
                                if (min == i7) {
                                    i8 = i14;
                                } else {
                                    i8 = i14;
                                }
                                z = false;
                                if (z) {
                                }
                            }
                        }
                        i8 = i14;
                        i7 = i15;
                        z = false;
                        if (z) {
                        }
                    }
                    i5 = i12;
                    i6 = childCount;
                    i8 = i14;
                    i7 = i15;
                    z = false;
                    if (z) {
                    }
                } else {
                    view3 = view5;
                }
                i5 = i12;
                i6 = childCount;
                i8 = i14;
                i7 = i15;
                z = true;
                if (z) {
                }
            } else {
                if (view4 != null) {
                    break;
                }
                view2 = findContainingItemView;
                view3 = view5;
                i5 = i12;
                i6 = childCount;
                i8 = i14;
                i7 = i15;
            }
            i14 = i8;
            i15 = i7;
            i12 = i5;
            view5 = view3;
            i11 += i4;
            vVar2 = vVar;
            zVar2 = zVar;
            findContainingItemView = view2;
            childCount = i6;
        }
        return view4 != null ? view4 : view5;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void onInitializeAccessibilityNodeInfoForItem(RecyclerView.v vVar, RecyclerView.z zVar, View view, androidx.core.view.d0.c cVar) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof b)) {
            super.onInitializeAccessibilityNodeInfoForItem(view, cVar);
            return;
        }
        b bVar = (b) layoutParams;
        int spanGroupIndex = getSpanGroupIndex(vVar, zVar, bVar.a());
        if (this.mOrientation == 0) {
            cVar.b0(c.C0025c.f(bVar.e(), bVar.f(), spanGroupIndex, 1, false, false));
        } else {
            cVar.b0(c.C0025c.f(spanGroupIndex, 1, bVar.e(), bVar.f(), false, false));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void onItemsAdded(RecyclerView recyclerView, int i2, int i3) {
        this.mSpanSizeLookup.invalidateSpanIndexCache();
        this.mSpanSizeLookup.invalidateSpanGroupIndexCache();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void onItemsChanged(RecyclerView recyclerView) {
        this.mSpanSizeLookup.invalidateSpanIndexCache();
        this.mSpanSizeLookup.invalidateSpanGroupIndexCache();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void onItemsMoved(RecyclerView recyclerView, int i2, int i3, int i4) {
        this.mSpanSizeLookup.invalidateSpanIndexCache();
        this.mSpanSizeLookup.invalidateSpanGroupIndexCache();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void onItemsRemoved(RecyclerView recyclerView, int i2, int i3) {
        this.mSpanSizeLookup.invalidateSpanIndexCache();
        this.mSpanSizeLookup.invalidateSpanGroupIndexCache();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void onItemsUpdated(RecyclerView recyclerView, int i2, int i3, Object obj) {
        this.mSpanSizeLookup.invalidateSpanIndexCache();
        this.mSpanSizeLookup.invalidateSpanGroupIndexCache();
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public void onLayoutChildren(RecyclerView.v vVar, RecyclerView.z zVar) {
        if (zVar.e()) {
            cachePreLayoutSpanMapping();
        }
        super.onLayoutChildren(vVar, zVar);
        clearPreLayoutSpanMappingCache();
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public void onLayoutCompleted(RecyclerView.z zVar) {
        super.onLayoutCompleted(zVar);
        this.mPendingSpanCountChange = false;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public int scrollHorizontallyBy(int i2, RecyclerView.v vVar, RecyclerView.z zVar) {
        updateMeasurements();
        ensureViewSet();
        return super.scrollHorizontallyBy(i2, vVar, zVar);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public int scrollVerticallyBy(int i2, RecyclerView.v vVar, RecyclerView.z zVar) {
        updateMeasurements();
        ensureViewSet();
        return super.scrollVerticallyBy(i2, vVar, zVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public void setMeasuredDimension(Rect rect, int i2, int i3) {
        int chooseSize;
        int chooseSize2;
        if (this.mCachedBorders == null) {
            super.setMeasuredDimension(rect, i2, i3);
        }
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        if (this.mOrientation == 1) {
            chooseSize2 = RecyclerView.o.chooseSize(i3, rect.height() + paddingTop, getMinimumHeight());
            int[] iArr = this.mCachedBorders;
            chooseSize = RecyclerView.o.chooseSize(i2, iArr[iArr.length - 1] + paddingLeft, getMinimumWidth());
        } else {
            chooseSize = RecyclerView.o.chooseSize(i2, rect.width() + paddingLeft, getMinimumWidth());
            int[] iArr2 = this.mCachedBorders;
            chooseSize2 = RecyclerView.o.chooseSize(i3, iArr2[iArr2.length - 1] + paddingTop, getMinimumHeight());
        }
        setMeasuredDimension(chooseSize, chooseSize2);
    }

    public void setSpanCount(int i2) {
        if (i2 == this.mSpanCount) {
            return;
        }
        this.mPendingSpanCountChange = true;
        if (i2 >= 1) {
            this.mSpanCount = i2;
            this.mSpanSizeLookup.invalidateSpanIndexCache();
            requestLayout();
        } else {
            throw new IllegalArgumentException("Span count should be at least 1. Provided " + i2);
        }
    }

    public void setSpanSizeLookup(c cVar) {
        this.mSpanSizeLookup = cVar;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public void setStackFromEnd(boolean z) {
        if (!z) {
            super.setStackFromEnd(false);
            return;
        }
        throw new UnsupportedOperationException("GridLayoutManager does not support stack from end. Consider using reverse layout");
    }

    public void setUsingSpansToEstimateScrollbarDimensions(boolean z) {
        this.mUsingSpansToEstimateScrollBarDimensions = z;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.o
    public boolean supportsPredictiveItemAnimations() {
        return this.mPendingSavedState == null && !this.mPendingSpanCountChange;
    }

    static int[] calculateItemBorders(int[] iArr, int i2, int i3) {
        int i4;
        if (iArr == null || iArr.length != i2 + 1 || iArr[iArr.length - 1] != i3) {
            iArr = new int[i2 + 1];
        }
        int i5 = 0;
        iArr[0] = 0;
        int i6 = i3 / i2;
        int i7 = i3 % i2;
        int i8 = 0;
        for (int i9 = 1; i9 <= i2; i9++) {
            i5 += i7;
            if (i5 <= 0 || i2 - i5 >= i7) {
                i4 = i6;
            } else {
                i4 = i6 + 1;
                i5 -= i2;
            }
            i8 += i4;
            iArr[i9] = i8;
        }
        return iArr;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.o
    public RecyclerView.p generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new b((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new b(layoutParams);
    }

    /* loaded from: classes.dex */
    public static class b extends RecyclerView.p {

        /* renamed from: e, reason: collision with root package name */
        int f1896e;

        /* renamed from: f, reason: collision with root package name */
        int f1897f;

        public b(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f1896e = -1;
            this.f1897f = 0;
        }

        public int e() {
            return this.f1896e;
        }

        public int f() {
            return this.f1897f;
        }

        public b(int i2, int i3) {
            super(i2, i3);
            this.f1896e = -1;
            this.f1897f = 0;
        }

        public b(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f1896e = -1;
            this.f1897f = 0;
        }

        public b(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f1896e = -1;
            this.f1897f = 0;
        }
    }

    public GridLayoutManager(Context context, int i2) {
        super(context);
        this.mPendingSpanCountChange = false;
        this.mSpanCount = -1;
        this.mPreLayoutSpanSizeCache = new SparseIntArray();
        this.mPreLayoutSpanIndexCache = new SparseIntArray();
        this.mSpanSizeLookup = new a();
        this.mDecorInsets = new Rect();
        setSpanCount(i2);
    }

    public GridLayoutManager(Context context, int i2, int i3, boolean z) {
        super(context, i3, z);
        this.mPendingSpanCountChange = false;
        this.mSpanCount = -1;
        this.mPreLayoutSpanSizeCache = new SparseIntArray();
        this.mPreLayoutSpanIndexCache = new SparseIntArray();
        this.mSpanSizeLookup = new a();
        this.mDecorInsets = new Rect();
        setSpanCount(i2);
    }
}
