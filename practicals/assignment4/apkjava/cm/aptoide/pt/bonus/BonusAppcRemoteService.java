package cm.aptoide.pt.bonus;

import cm.aptoide.pt.bonus.BonusAppcResponse;
import kotlin.Metadata;
import kotlin.collections.s;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.m;
import kotlin.text.u;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.h;
import okhttp3.HttpUrl;
import retrofit2.Response;
import retrofit2.http.GET;

/* compiled from: BonusAppcRemoteService.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\fB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0011\u0010\u0005\u001a\u00020\u0006H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0007J\b\u0010\b\u001a\u00020\u0006H\u0002J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\r"}, d2 = {"Lcm/aptoide/pt/bonus/BonusAppcRemoteService;", "Lcm/aptoide/pt/bonus/BonusAppcService;", "serviceApi", "Lcm/aptoide/pt/bonus/BonusAppcRemoteService$ServiceApi;", "(Lcm/aptoide/pt/bonus/BonusAppcRemoteService$ServiceApi;)V", "getBonusAppc", "Lcm/aptoide/pt/bonus/BonusAppcModel;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "mapErrorResponse", "mapResponse", "response", "Lcm/aptoide/pt/bonus/BonusAppcResponse;", "ServiceApi", "appcoins"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class BonusAppcRemoteService implements BonusAppcService {
    private final ServiceApi serviceApi;

    /* compiled from: BonusAppcRemoteService.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H§@ø\u0001\u0000¢\u0006\u0002\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0006"}, d2 = {"Lcm/aptoide/pt/bonus/BonusAppcRemoteService$ServiceApi;", HttpUrl.FRAGMENT_ENCODE_SET, "getAppcBonus", "Lretrofit2/Response;", "Lcm/aptoide/pt/bonus/BonusAppcResponse;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "appcoins"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes.dex */
    public interface ServiceApi {
        @GET("gamification/levels")
        Object getAppcBonus(Continuation<? super Response<BonusAppcResponse>> continuation);
    }

    public BonusAppcRemoteService(ServiceApi serviceApi) {
        m.f(serviceApi, "serviceApi");
        this.serviceApi = serviceApi;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final BonusAppcModel mapErrorResponse() {
        return new BonusAppcModel(false, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final BonusAppcModel mapResponse(BonusAppcResponse response) {
        boolean r;
        r = u.r(response.getStatus(), "ACTIVE", false, 2, null);
        if (r && (!response.getResult().isEmpty())) {
            return new BonusAppcModel(true, ((BonusAppcResponse.Result) s.g0(response.getResult())).getBonus());
        }
        return mapErrorResponse();
    }

    @Override // cm.aptoide.pt.bonus.BonusAppcService
    public Object getBonusAppc(Continuation<? super BonusAppcModel> continuation) {
        return h.e(Dispatchers.b(), new BonusAppcRemoteService$getBonusAppc$2(this, null), continuation);
    }
}
