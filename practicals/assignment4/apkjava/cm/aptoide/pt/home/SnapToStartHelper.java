package cm.aptoide.pt.home;

import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
public class SnapToStartHelper extends androidx.recyclerview.widget.k {
    private androidx.recyclerview.widget.n horizontalHelper;
    private androidx.recyclerview.widget.n verticalHelper;

    private int distanceToStart(View view, androidx.recyclerview.widget.n nVar) {
        return nVar.g(view) - nVar.m();
    }

    private androidx.recyclerview.widget.n getHorizontalHelper(RecyclerView.o oVar) {
        if (this.horizontalHelper == null) {
            this.horizontalHelper = androidx.recyclerview.widget.n.a(oVar);
        }
        return this.horizontalHelper;
    }

    private View getStartView(RecyclerView.o oVar, androidx.recyclerview.widget.n nVar) {
        if (oVar instanceof LinearLayoutManager) {
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) oVar;
            int findFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
            boolean z = linearLayoutManager.findLastCompletelyVisibleItemPosition() == oVar.getItemCount() - 1;
            if (findFirstVisibleItemPosition == -1 || z) {
                return null;
            }
            View findViewByPosition = oVar.findViewByPosition(findFirstVisibleItemPosition);
            if (nVar.d(findViewByPosition) >= nVar.e(findViewByPosition) / 2 && nVar.d(findViewByPosition) > 0) {
                return findViewByPosition;
            }
            if (((LinearLayoutManager) oVar).findLastCompletelyVisibleItemPosition() == oVar.getItemCount() - 1) {
                return null;
            }
            return oVar.findViewByPosition(findFirstVisibleItemPosition + 1);
        }
        return super.findSnapView(oVar);
    }

    private androidx.recyclerview.widget.n getVerticalHelper(RecyclerView.o oVar) {
        if (this.verticalHelper == null) {
            this.verticalHelper = androidx.recyclerview.widget.n.c(oVar);
        }
        return this.verticalHelper;
    }

    @Override // androidx.recyclerview.widget.r
    public void attachToRecyclerView(RecyclerView recyclerView) throws IllegalStateException {
        super.attachToRecyclerView(recyclerView);
    }

    @Override // androidx.recyclerview.widget.k, androidx.recyclerview.widget.r
    public int[] calculateDistanceToFinalSnap(RecyclerView.o oVar, View view) {
        int[] iArr = new int[2];
        if (oVar.canScrollHorizontally()) {
            iArr[0] = distanceToStart(view, getHorizontalHelper(oVar));
        } else {
            iArr[0] = 0;
        }
        if (oVar.canScrollVertically()) {
            iArr[1] = distanceToStart(view, getVerticalHelper(oVar));
        } else {
            iArr[1] = 0;
        }
        return iArr;
    }

    @Override // androidx.recyclerview.widget.k, androidx.recyclerview.widget.r
    public View findSnapView(RecyclerView.o oVar) {
        if (oVar instanceof LinearLayoutManager) {
            if (oVar.canScrollHorizontally()) {
                return getStartView(oVar, getHorizontalHelper(oVar));
            }
            return getStartView(oVar, getVerticalHelper(oVar));
        }
        return super.findSnapView(oVar);
    }
}
