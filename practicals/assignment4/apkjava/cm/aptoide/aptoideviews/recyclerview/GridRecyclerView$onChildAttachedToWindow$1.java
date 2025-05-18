package cm.aptoide.aptoideviews.recyclerview;

import android.view.View;
import android.view.ViewGroup;
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
final class GridRecyclerView$onChildAttachedToWindow$1 extends Lambda implements Function2<GridRecyclerView.Size, GridRecyclerView.AdaptStrategy, u> {
    final /* synthetic */ View $child;
    final /* synthetic */ GridRecyclerView this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GridRecyclerView$onChildAttachedToWindow$1(View view, GridRecyclerView gridRecyclerView) {
        super(2);
        this.$child = view;
        this.this$0 = gridRecyclerView;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ u invoke(GridRecyclerView.Size size, GridRecyclerView.AdaptStrategy adaptStrategy) {
        invoke2(size, adaptStrategy);
        return u.a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(GridRecyclerView.Size size, GridRecyclerView.AdaptStrategy adaptStrategy) {
        int itemMeasuredWidth;
        m.f(size, "itemSize");
        m.f(adaptStrategy, "adaptStrategy");
        ViewGroup.LayoutParams layoutParams = this.$child.getLayoutParams();
        if (adaptStrategy == GridRecyclerView.AdaptStrategy.SCALE_WIDTH_ONLY || adaptStrategy == GridRecyclerView.AdaptStrategy.SCALE_KEEP_ASPECT_RATIO || adaptStrategy == GridRecyclerView.AdaptStrategy.ADJUST_PADDING) {
            layoutParams.width = -1;
        }
        if (adaptStrategy == GridRecyclerView.AdaptStrategy.SCALE_KEEP_ASPECT_RATIO) {
            itemMeasuredWidth = this.this$0.getItemMeasuredWidth();
            double d2 = itemMeasuredWidth;
            double ratio = 1.0d / size.getRatio();
            Double.isNaN(d2);
            layoutParams.height = (int) (d2 * ratio);
        }
    }
}
