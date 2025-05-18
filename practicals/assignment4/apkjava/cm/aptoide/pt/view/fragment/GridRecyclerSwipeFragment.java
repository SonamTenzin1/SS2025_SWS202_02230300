package cm.aptoide.pt.view.fragment;

import cm.aptoide.pt.R;
import cm.aptoide.pt.view.ReloadInterface;
import cm.aptoide.pt.view.recycler.BaseAdapter;
import cm.aptoide.pt.view.swipe.LoaderLayoutHandler;
import cm.aptoide.pt.view.swipe.SwipeLoaderLayoutHandler;

/* loaded from: classes.dex */
public abstract class GridRecyclerSwipeFragment<T extends BaseAdapter> extends GridRecyclerFragmentWithDecorator<T> implements ReloadInterface {
    protected String storeTheme;

    /* loaded from: classes.dex */
    protected static class BundleCons {
        public static final String STORE_THEME = "storeTheme";

        protected BundleCons() {
        }
    }

    @Override // cm.aptoide.pt.view.fragment.BaseLoaderFragment
    protected LoaderLayoutHandler createLoaderLayoutHandler() {
        if (getViewsToShowAfterLoadingId().length > 0) {
            return new SwipeLoaderLayoutHandler(getViewsToShowAfterLoadingId(), this);
        }
        return new SwipeLoaderLayoutHandler(getViewToShowAfterLoadingId(), this);
    }

    @Override // cm.aptoide.pt.view.fragment.BaseRecyclerViewFragment, cm.aptoide.pt.view.fragment.UiComponent
    public int getContentViewId() {
        return R.layout.recycler_swipe_fragment;
    }

    @Override // cm.aptoide.pt.view.ReloadInterface
    public void reload() {
        load(false, true, null);
    }
}
