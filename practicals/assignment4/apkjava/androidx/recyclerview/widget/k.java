package androidx.recyclerview.widget;

import android.graphics.PointF;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: LinearSnapHelper.java */
/* loaded from: classes.dex */
public class k extends r {
    private static final float INVALID_DISTANCE = 1.0f;
    private n mHorizontalHelper;
    private n mVerticalHelper;

    private float computeDistancePerChild(RecyclerView.o oVar, n nVar) {
        int childCount = oVar.getChildCount();
        if (childCount == 0) {
            return INVALID_DISTANCE;
        }
        View view = null;
        View view2 = null;
        int i2 = Integer.MAX_VALUE;
        int i3 = Integer.MIN_VALUE;
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt = oVar.getChildAt(i4);
            int position = oVar.getPosition(childAt);
            if (position != -1) {
                if (position < i2) {
                    view = childAt;
                    i2 = position;
                }
                if (position > i3) {
                    view2 = childAt;
                    i3 = position;
                }
            }
        }
        if (view == null || view2 == null) {
            return INVALID_DISTANCE;
        }
        int max = Math.max(nVar.d(view), nVar.d(view2)) - Math.min(nVar.g(view), nVar.g(view2));
        return max == 0 ? INVALID_DISTANCE : (max * INVALID_DISTANCE) / ((i3 - i2) + 1);
    }

    private int distanceToCenter(RecyclerView.o oVar, View view, n nVar) {
        return (nVar.g(view) + (nVar.e(view) / 2)) - (nVar.m() + (nVar.n() / 2));
    }

    private int estimateNextPositionDiffForFling(RecyclerView.o oVar, n nVar, int i2, int i3) {
        int[] calculateScrollDistance = calculateScrollDistance(i2, i3);
        float computeDistancePerChild = computeDistancePerChild(oVar, nVar);
        if (computeDistancePerChild <= 0.0f) {
            return 0;
        }
        return Math.round((Math.abs(calculateScrollDistance[0]) > Math.abs(calculateScrollDistance[1]) ? calculateScrollDistance[0] : calculateScrollDistance[1]) / computeDistancePerChild);
    }

    private View findCenterView(RecyclerView.o oVar, n nVar) {
        int childCount = oVar.getChildCount();
        View view = null;
        if (childCount == 0) {
            return null;
        }
        int m = nVar.m() + (nVar.n() / 2);
        int i2 = Integer.MAX_VALUE;
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = oVar.getChildAt(i3);
            int abs = Math.abs((nVar.g(childAt) + (nVar.e(childAt) / 2)) - m);
            if (abs < i2) {
                view = childAt;
                i2 = abs;
            }
        }
        return view;
    }

    private n getHorizontalHelper(RecyclerView.o oVar) {
        n nVar = this.mHorizontalHelper;
        if (nVar == null || nVar.a != oVar) {
            this.mHorizontalHelper = n.a(oVar);
        }
        return this.mHorizontalHelper;
    }

    private n getVerticalHelper(RecyclerView.o oVar) {
        n nVar = this.mVerticalHelper;
        if (nVar == null || nVar.a != oVar) {
            this.mVerticalHelper = n.c(oVar);
        }
        return this.mVerticalHelper;
    }

    @Override // androidx.recyclerview.widget.r
    public int[] calculateDistanceToFinalSnap(RecyclerView.o oVar, View view) {
        int[] iArr = new int[2];
        if (oVar.canScrollHorizontally()) {
            iArr[0] = distanceToCenter(oVar, view, getHorizontalHelper(oVar));
        } else {
            iArr[0] = 0;
        }
        if (oVar.canScrollVertically()) {
            iArr[1] = distanceToCenter(oVar, view, getVerticalHelper(oVar));
        } else {
            iArr[1] = 0;
        }
        return iArr;
    }

    @Override // androidx.recyclerview.widget.r
    public View findSnapView(RecyclerView.o oVar) {
        if (oVar.canScrollVertically()) {
            return findCenterView(oVar, getVerticalHelper(oVar));
        }
        if (oVar.canScrollHorizontally()) {
            return findCenterView(oVar, getHorizontalHelper(oVar));
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.recyclerview.widget.r
    public int findTargetSnapPosition(RecyclerView.o oVar, int i2, int i3) {
        int itemCount;
        View findSnapView;
        int position;
        int i4;
        PointF computeScrollVectorForPosition;
        int i5;
        int i6;
        if (!(oVar instanceof RecyclerView.y.b) || (itemCount = oVar.getItemCount()) == 0 || (findSnapView = findSnapView(oVar)) == null || (position = oVar.getPosition(findSnapView)) == -1 || (computeScrollVectorForPosition = ((RecyclerView.y.b) oVar).computeScrollVectorForPosition(itemCount - 1)) == null) {
            return -1;
        }
        if (oVar.canScrollHorizontally()) {
            i5 = estimateNextPositionDiffForFling(oVar, getHorizontalHelper(oVar), i2, 0);
            if (computeScrollVectorForPosition.x < 0.0f) {
                i5 = -i5;
            }
        } else {
            i5 = 0;
        }
        if (oVar.canScrollVertically()) {
            i6 = estimateNextPositionDiffForFling(oVar, getVerticalHelper(oVar), 0, i3);
            if (computeScrollVectorForPosition.y < 0.0f) {
                i6 = -i6;
            }
        } else {
            i6 = 0;
        }
        if (oVar.canScrollVertically()) {
            i5 = i6;
        }
        if (i5 == 0) {
            return -1;
        }
        int i7 = position + i5;
        int i8 = i7 >= 0 ? i7 : 0;
        return i8 >= itemCount ? i4 : i8;
    }
}
