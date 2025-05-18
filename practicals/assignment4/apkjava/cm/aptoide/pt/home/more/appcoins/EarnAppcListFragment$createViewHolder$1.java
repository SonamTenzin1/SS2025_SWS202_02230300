package cm.aptoide.pt.home.more.appcoins;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import cm.aptoide.pt.R;
import java.text.DecimalFormat;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import okhttp3.HttpUrl;

/* compiled from: EarnAppcListFragment.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "Lcm/aptoide/pt/home/more/appcoins/EarnAppcListViewHolder;", "parent", "Landroid/view/ViewGroup;", "viewType", HttpUrl.FRAGMENT_ENCODE_SET, "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
final class EarnAppcListFragment$createViewHolder$1 extends Lambda implements Function2<ViewGroup, Integer, EarnAppcListViewHolder> {
    public static final EarnAppcListFragment$createViewHolder$1 INSTANCE = new EarnAppcListFragment$createViewHolder$1();

    EarnAppcListFragment$createViewHolder$1() {
        super(2);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ EarnAppcListViewHolder invoke(ViewGroup viewGroup, Integer num) {
        return invoke(viewGroup, num.intValue());
    }

    public final EarnAppcListViewHolder invoke(ViewGroup viewGroup, int i2) {
        kotlin.jvm.internal.m.f(viewGroup, "parent");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.earn_appcoins_item_more, viewGroup, false);
        kotlin.jvm.internal.m.e(inflate, "from(parent.context).inf…ent,\n              false)");
        return new EarnAppcListViewHolder(inflate, new DecimalFormat("0.00"));
    }
}
