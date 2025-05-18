package cm.aptoide.pt.dataprovider.interfaces;

import java.util.List;
import rx.e;

/* loaded from: classes.dex */
public interface EndlessControllerWithCache<U> extends EndlessController<U> {
    e<List<U>> loadMore(boolean z);
}
