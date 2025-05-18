package cm.aptoide.pt.app.mmpcampaigns;

import android.content.SharedPreferences;
import h.a.b;
import kotlin.Metadata;
import kotlin.jvm.internal.m;
import kotlinx.coroutines.rx2.f;
import okhttp3.HttpUrl;

/* compiled from: CampaignManager.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcm/aptoide/pt/app/mmpcampaigns/CampaignManager;", HttpUrl.FRAGMENT_ENCODE_SET, "campaignRepository", "Lcm/aptoide/pt/app/mmpcampaigns/CampaignRepository;", "securePreferences", "Landroid/content/SharedPreferences;", "(Lcm/aptoide/pt/app/mmpcampaigns/CampaignRepository;Landroid/content/SharedPreferences;)V", "convertCampaign", "Lio/reactivex/Completable;", "campaign", "Lcm/aptoide/pt/app/mmpcampaigns/Campaign;", "medium", HttpUrl.FRAGMENT_ENCODE_SET, "app_vanillaProdRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class CampaignManager {
    private final CampaignRepository campaignRepository;
    private final SharedPreferences securePreferences;

    public CampaignManager(CampaignRepository campaignRepository, SharedPreferences sharedPreferences) {
        m.f(campaignRepository, "campaignRepository");
        m.f(sharedPreferences, "securePreferences");
        this.campaignRepository = campaignRepository;
        this.securePreferences = sharedPreferences;
    }

    public final b convertCampaign(Campaign campaign, String str) {
        m.f(campaign, "campaign");
        m.f(str, "medium");
        return f.c(null, new CampaignManager$convertCampaign$1(campaign, this, str, null), 1, null);
    }
}
