package cm.aptoide.pt.view.swipe;

import android.view.View;
import c.v.a.c;
import cm.aptoide.pt.R;
import cm.aptoide.pt.view.ReloadInterface;
import cm.aptoide.pt.view.fragment.GridRecyclerSwipeFragment;

/* loaded from: classes.dex */
public class SwipeLoaderLayoutHandler extends LoaderLayoutHandler {
    private c.v.a.c swipeContainer;

    public SwipeLoaderLayoutHandler(int i2, ReloadInterface reloadInterface) {
        super(reloadInterface, i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: lambda$bindViews$0, reason: merged with bridge method [inline-methods] */
    public /* synthetic */ void d() {
        ((ReloadInterface) this.loadInterface).reload();
    }

    @Override // cm.aptoide.pt.view.swipe.LoaderLayoutHandler
    public void bindViews(View view) {
        super.bindViews(view);
        c.v.a.c cVar = (c.v.a.c) view.findViewById(R.id.swipe_container);
        this.swipeContainer = cVar;
        cVar.setOnRefreshListener(new c.j() { // from class: cm.aptoide.pt.view.swipe.f
            @Override // c.v.a.c.j
            public final void a() {
                SwipeLoaderLayoutHandler.this.d();
            }
        });
    }

    @Override // cm.aptoide.pt.view.swipe.LoaderLayoutHandler
    /* renamed from: onFinishLoading */
    public void a(Throwable th) {
        super.a(th);
        this.swipeContainer.setRefreshing(false);
        this.swipeContainer.setEnabled(false);
    }

    @Override // cm.aptoide.pt.view.swipe.LoaderLayoutHandler
    public void restoreState() {
        super.restoreState();
        this.swipeContainer.setEnabled(true);
    }

    @Override // cm.aptoide.pt.view.swipe.LoaderLayoutHandler
    public void unbindViews() {
        this.swipeContainer.setOnRefreshListener(null);
        super.unbindViews();
    }

    public SwipeLoaderLayoutHandler(int[] iArr, GridRecyclerSwipeFragment gridRecyclerSwipeFragment) {
        super(gridRecyclerSwipeFragment, iArr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cm.aptoide.pt.view.swipe.LoaderLayoutHandler
    public void onFinishLoading() {
        super.onFinishLoading();
        this.swipeContainer.setRefreshing(false);
        this.swipeContainer.setEnabled(true);
    }
}
