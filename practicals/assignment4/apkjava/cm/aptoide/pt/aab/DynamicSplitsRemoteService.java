package cm.aptoide.pt.aab;

import cm.aptoide.pt.aab.DynamicSplitsResponse;
import java.util.Collections;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.m;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.h;
import okhttp3.HttpUrl;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Query;

/* compiled from: DynamicSplitsRemoteService.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0010B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0019\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u000bJ\b\u0010\f\u001a\u00020\bH\u0002J\u0010\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0011"}, d2 = {"Lcm/aptoide/pt/aab/DynamicSplitsRemoteService;", "Lcm/aptoide/pt/aab/DynamicSplitsService;", "dynamicSplitsApi", "Lcm/aptoide/pt/aab/DynamicSplitsRemoteService$DynamicSplitsApi;", "mapper", "Lcm/aptoide/pt/aab/DynamicSplitsMapper;", "(Lcm/aptoide/pt/aab/DynamicSplitsRemoteService$DynamicSplitsApi;Lcm/aptoide/pt/aab/DynamicSplitsMapper;)V", "getDynamicSplitsByMd5", "Lcm/aptoide/pt/aab/DynamicSplitsModel;", "apkMd5Sum", HttpUrl.FRAGMENT_ENCODE_SET, "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "mapErrorResponse", "mapResponse", "dynamicSplitsResponseBody", "Lcm/aptoide/pt/aab/DynamicSplitsResponse;", "DynamicSplitsApi", "app_vanillaProdRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class DynamicSplitsRemoteService implements DynamicSplitsService {
    private final DynamicSplitsApi dynamicSplitsApi;
    private final DynamicSplitsMapper mapper;

    /* compiled from: DynamicSplitsRemoteService.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J!\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H§@ø\u0001\u0000¢\u0006\u0002\u0010\u0007\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\b"}, d2 = {"Lcm/aptoide/pt/aab/DynamicSplitsRemoteService$DynamicSplitsApi;", HttpUrl.FRAGMENT_ENCODE_SET, "getDynamicSplitsByMd5", "Lretrofit2/Response;", "Lcm/aptoide/pt/aab/DynamicSplitsResponse;", "md5", HttpUrl.FRAGMENT_ENCODE_SET, "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_vanillaProdRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes.dex */
    public interface DynamicSplitsApi {
        @GET("app/getDynamicSplits")
        Object getDynamicSplitsByMd5(@Query("apk_md5sum") String str, Continuation<? super Response<DynamicSplitsResponse>> continuation);
    }

    public DynamicSplitsRemoteService(DynamicSplitsApi dynamicSplitsApi, DynamicSplitsMapper dynamicSplitsMapper) {
        m.f(dynamicSplitsApi, "dynamicSplitsApi");
        m.f(dynamicSplitsMapper, "mapper");
        this.dynamicSplitsApi = dynamicSplitsApi;
        this.mapper = dynamicSplitsMapper;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final DynamicSplitsModel mapErrorResponse() {
        List emptyList = Collections.emptyList();
        m.e(emptyList, "emptyList()");
        return new DynamicSplitsModel(emptyList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final DynamicSplitsModel mapResponse(DynamicSplitsResponse dynamicSplitsResponseBody) {
        DynamicSplitsMapper dynamicSplitsMapper = this.mapper;
        List<DynamicSplitsResponse.DynamicSplit> dynamicSplitList = dynamicSplitsResponseBody.getDynamicSplitList();
        m.e(dynamicSplitList, "dynamicSplitsResponseBody.dynamicSplitList");
        return new DynamicSplitsModel(dynamicSplitsMapper.mapDynamicSplits(dynamicSplitList));
    }

    @Override // cm.aptoide.pt.aab.DynamicSplitsService
    public Object getDynamicSplitsByMd5(String str, Continuation<? super DynamicSplitsModel> continuation) {
        return h.e(Dispatchers.b(), new DynamicSplitsRemoteService$getDynamicSplitsByMd5$2(this, str, null), continuation);
    }
}
