package cm.aptoide.pt;

import cm.aptoide.pt.bonus.BonusAppcModel;
import cm.aptoide.pt.bonus.BonusAppcService;
import kotlin.Metadata;
import okhttp3.HttpUrl;

/* compiled from: AppCoinsManager.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcm/aptoide/pt/AppCoinsManager;", HttpUrl.FRAGMENT_ENCODE_SET, "bonusAppcService", "Lcm/aptoide/pt/bonus/BonusAppcService;", "(Lcm/aptoide/pt/bonus/BonusAppcService;)V", "getBonusAppc", "Lio/reactivex/Single;", "Lcm/aptoide/pt/bonus/BonusAppcModel;", "appcoins"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public class AppCoinsManager {
    private final BonusAppcService bonusAppcService;

    public AppCoinsManager(BonusAppcService bonusAppcService) {
        kotlin.jvm.internal.m.f(bonusAppcService, "bonusAppcService");
        this.bonusAppcService = bonusAppcService;
    }

    public final h.a.s<BonusAppcModel> getBonusAppc() {
        return kotlinx.coroutines.rx2.h.c(null, new AppCoinsManager$getBonusAppc$1(this, null), 1, null);
    }
}
