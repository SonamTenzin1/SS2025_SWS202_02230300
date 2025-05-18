package cm.aptoide.aptoideviews.recyclerview;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import cm.aptoide.aptoideviews.recyclerview.GridRecyclerView;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.m;
import kotlin.u;
import okhttp3.HttpUrl;

/* compiled from: GridRecyclerView.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", HttpUrl.FRAGMENT_ENCODE_SET, "itemSize", "Lcm/aptoide/aptoideviews/recyclerview/GridRecyclerView$Size;", "adaptStrategy", "Lcm/aptoide/aptoideviews/recyclerview/GridRecyclerView$AdaptStrategy;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
final class GridRecyclerView$onMeasure$1 extends Lambda implements Function2<GridRecyclerView.Size, GridRecyclerView.AdaptStrategy, u> {
    final /* synthetic */ GridRecyclerView this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GridRecyclerView$onMeasure$1(GridRecyclerView gridRecyclerView) {
        super(2);
        this.this$0 = gridRecyclerView;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ u invoke(GridRecyclerView.Size size, GridRecyclerView.AdaptStrategy adaptStrategy) {
        invoke2(size, adaptStrategy);
        return u.a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(GridRecyclerView.Size size, GridRecyclerView.AdaptStrategy adaptStrategy) {
        GridItemSpacingDecorator gridItemSpacingDecorator;
        int totalWidth;
        int totalHorizontalPadding;
        int adaptiveMeasuredPadding;
        m.f(size, "itemSize");
        m.f(adaptStrategy, "adaptStrategy");
        RecyclerView.o layoutManager = this.this$0.getLayoutManager();
        if (layoutManager != null) {
            gridItemSpacingDecorator = this.this$0.spacingItemDecorator;
            int spacingPx = gridItemSpacingDecorator.getSpacingPx();
            totalWidth = this.this$0.getTotalWidth();
            totalHorizontalPadding = this.this$0.getTotalHorizontalPadding();
            double d2 = (totalWidth - totalHorizontalPadding) + spacingPx;
            double width = size.getWidth();
            double d3 = spacingPx;
            Double.isNaN(width);
            Double.isNaN(d3);
            Double.isNaN(d2);
            ((GridLayoutManager) layoutManager).setSpanCount((int) (d2 / (width + d3)));
            if (adaptStrategy == GridRecyclerView.AdaptStrategy.ADJUST_PADDING) {
                adaptiveMeasuredPadding = this.this$0.getAdaptiveMeasuredPadding(size.getWidth());
                int i2 = adaptiveMeasuredPadding / 2;
                GridRecyclerView gridRecyclerView = this.this$0;
                gridRecyclerView.setPadding(i2, gridRecyclerView.getPaddingTop(), i2, this.this$0.getPaddingBottom());
                return;
            }
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.GridLayoutManager");
    }
}
