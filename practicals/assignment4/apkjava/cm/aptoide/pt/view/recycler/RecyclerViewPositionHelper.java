package cm.aptoide.pt.view.recycler;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.n;

/* loaded from: classes.dex */
public class RecyclerViewPositionHelper {
    final RecyclerView.o layoutManager;
    final RecyclerView recyclerView;

    RecyclerViewPositionHelper(RecyclerView recyclerView) {
        this.recyclerView = recyclerView;
        this.layoutManager = recyclerView.getLayoutManager();
    }

    public static RecyclerViewPositionHelper createHelper(RecyclerView recyclerView) {
        if (recyclerView != null) {
            return new RecyclerViewPositionHelper(recyclerView);
        }
        throw new NullPointerException("Recycler View is null");
    }

    public int findFirstCompletelyVisibleItemPosition() {
        View findOneVisibleChild = findOneVisibleChild(0, this.layoutManager.getChildCount(), true, false);
        if (findOneVisibleChild == null) {
            return -1;
        }
        return this.recyclerView.getChildAdapterPosition(findOneVisibleChild);
    }

    public int findFirstVisibleItemPosition() {
        View findOneVisibleChild = findOneVisibleChild(0, this.layoutManager.getChildCount(), false, true);
        if (findOneVisibleChild == null) {
            return -1;
        }
        return this.recyclerView.getChildAdapterPosition(findOneVisibleChild);
    }

    public int findLastCompletelyVisibleItemPosition() {
        View findOneVisibleChild = findOneVisibleChild(this.layoutManager.getChildCount() - 1, -1, true, false);
        if (findOneVisibleChild == null) {
            return -1;
        }
        return this.recyclerView.getChildAdapterPosition(findOneVisibleChild);
    }

    public int findLastVisibleItemPosition() {
        View findOneVisibleChild = findOneVisibleChild(this.layoutManager.getChildCount() - 1, -1, false, true);
        if (findOneVisibleChild == null) {
            return -1;
        }
        return this.recyclerView.getChildAdapterPosition(findOneVisibleChild);
    }

    View findOneVisibleChild(int i2, int i3, boolean z, boolean z2) {
        n a;
        if (this.layoutManager.canScrollVertically()) {
            a = n.c(this.layoutManager);
        } else {
            a = n.a(this.layoutManager);
        }
        int m = a.m();
        int i4 = a.i();
        int i5 = i3 > i2 ? 1 : -1;
        View view = null;
        while (i2 != i3) {
            View childAt = this.layoutManager.getChildAt(i2);
            int g2 = a.g(childAt);
            int d2 = a.d(childAt);
            if (g2 < i4 && d2 > m) {
                if (!z) {
                    return childAt;
                }
                if (g2 >= m && d2 <= i4) {
                    return childAt;
                }
                if (z2 && view == null) {
                    view = childAt;
                }
            }
            i2 += i5;
        }
        return view;
    }

    public int getChildCount() {
        RecyclerView.o oVar = this.layoutManager;
        if (oVar == null) {
            return 0;
        }
        return oVar.getChildCount();
    }

    public int getItemCount() {
        RecyclerView.o oVar = this.layoutManager;
        if (oVar == null) {
            return 0;
        }
        return oVar.getItemCount();
    }
}
