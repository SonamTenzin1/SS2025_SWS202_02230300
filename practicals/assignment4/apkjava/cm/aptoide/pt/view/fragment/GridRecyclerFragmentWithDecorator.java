package cm.aptoide.pt.view.fragment;

import android.graphics.Rect;
import android.util.TypedValue;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import cm.aptoide.pt.R;
import cm.aptoide.pt.view.recycler.BaseAdapter;

/* loaded from: classes.dex */
public abstract class GridRecyclerFragmentWithDecorator<T extends BaseAdapter> extends AptoideBaseFragment<T> {
    protected RecyclerView.n getItemDecoration() {
        return new RecyclerView.n() { // from class: cm.aptoide.pt.view.fragment.GridRecyclerFragmentWithDecorator.1
            @Override // androidx.recyclerview.widget.RecyclerView.n
            public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.z zVar) {
                int i2;
                int i3;
                int i4;
                int i5;
                int i6;
                androidx.fragment.app.d activity = GridRecyclerFragmentWithDecorator.this.getActivity();
                int i7 = 0;
                if (activity != null) {
                    i2 = (int) TypedValue.applyDimension(1, 5.0f, activity.getResources().getDisplayMetrics());
                    i3 = i2;
                    i4 = i3;
                    i5 = i4;
                    i6 = i5;
                } else {
                    i2 = 0;
                    i3 = 0;
                    i4 = 0;
                    i5 = 0;
                    i6 = 0;
                }
                if (view.getId() == R.id.brick_app_item) {
                    i3 = i2 / 2;
                    i4 = i3;
                    i5 = i4;
                    i6 = i5;
                }
                if (view.getId() == R.id.message_white_bg) {
                    i4 = i2;
                    i6 = i4;
                } else {
                    i7 = i3;
                    i2 = i5;
                }
                rect.set(i2, i7, i6, i4);
            }
        };
    }

    @Override // cm.aptoide.pt.view.fragment.BaseRecyclerViewFragment, cm.aptoide.pt.view.fragment.BaseLoaderToolbarFragment, cm.aptoide.pt.view.fragment.UIComponentFragment, cm.aptoide.pt.view.fragment.UiComponent
    public void setupViews() {
        super.setupViews();
        RecyclerView.n itemDecoration = getItemDecoration();
        if (itemDecoration != null) {
            getRecyclerView().addItemDecoration(itemDecoration);
        }
    }
}
