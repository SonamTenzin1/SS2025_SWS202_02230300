package cm.aptoide.pt.app.mmpcampaigns;

import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.d;
import kotlin.jvm.internal.m;
import kotlin.u;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.h;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;

/* compiled from: CampaignApiRepository.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0019\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\n"}, d2 = {"Lcm/aptoide/pt/app/mmpcampaigns/CampaignApiRepository;", "Lcm/aptoide/pt/app/mmpcampaigns/CampaignRepository;", "client", "Lokhttp3/OkHttpClient;", "(Lokhttp3/OkHttpClient;)V", "knock", HttpUrl.FRAGMENT_ENCODE_SET, "url", HttpUrl.FRAGMENT_ENCODE_SET, "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_vanillaProdRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class CampaignApiRepository implements CampaignRepository {
    private final OkHttpClient client;

    @Inject
    public CampaignApiRepository(OkHttpClient okHttpClient) {
        m.f(okHttpClient, "client");
        this.client = okHttpClient;
    }

    @Override // cm.aptoide.pt.app.mmpcampaigns.CampaignRepository
    public Object knock(String str, Continuation<? super u> continuation) {
        Object c2;
        Object e2 = h.e(Dispatchers.b(), new CampaignApiRepository$knock$2(this, str, null), continuation);
        c2 = d.c();
        return e2 == c2 ? e2 : u.a;
    }
}
