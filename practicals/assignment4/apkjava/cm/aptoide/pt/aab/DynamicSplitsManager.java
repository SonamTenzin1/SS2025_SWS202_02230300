package cm.aptoide.pt.aab;

import h.a.s;
import kotlin.Metadata;
import kotlin.jvm.internal.m;
import kotlinx.coroutines.rx2.h;
import okhttp3.HttpUrl;

/* compiled from: DynamicSplitsManager.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\tH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcm/aptoide/pt/aab/DynamicSplitsManager;", HttpUrl.FRAGMENT_ENCODE_SET, "dynamicSplitsService", "Lcm/aptoide/pt/aab/DynamicSplitsService;", "(Lcm/aptoide/pt/aab/DynamicSplitsService;)V", "getAppSplitsByMd5", "Lio/reactivex/Single;", "Lcm/aptoide/pt/aab/DynamicSplitsModel;", "apkMd5Sum", HttpUrl.FRAGMENT_ENCODE_SET, "app_vanillaProdRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public class DynamicSplitsManager {
    private final DynamicSplitsService dynamicSplitsService;

    public DynamicSplitsManager(DynamicSplitsService dynamicSplitsService) {
        m.f(dynamicSplitsService, "dynamicSplitsService");
        this.dynamicSplitsService = dynamicSplitsService;
    }

    public s<DynamicSplitsModel> getAppSplitsByMd5(String str) {
        m.f(str, "apkMd5Sum");
        return h.c(null, new DynamicSplitsManager$getAppSplitsByMd5$1(this, str, null), 1, null);
    }
}
