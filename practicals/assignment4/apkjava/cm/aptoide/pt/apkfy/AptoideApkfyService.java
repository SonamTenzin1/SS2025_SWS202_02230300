package cm.aptoide.pt.apkfy;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.m;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.h;
import okhttp3.HttpUrl;
import retrofit2.Response;
import retrofit2.http.GET;

/* compiled from: AptoideApkfyService.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\tB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0011\u0010\u0005\u001a\u00020\u0006H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0007J\b\u0010\b\u001a\u00020\u0006H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\n"}, d2 = {"Lcm/aptoide/pt/apkfy/AptoideApkfyService;", "Lcm/aptoide/pt/apkfy/ApkfyService;", "serviceApi", "Lcm/aptoide/pt/apkfy/AptoideApkfyService$ServiceApi;", "(Lcm/aptoide/pt/apkfy/AptoideApkfyService$ServiceApi;)V", "getApkfy", "Lcm/aptoide/pt/apkfy/ApkfyModel;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "mapErrorResponse", "ServiceApi", "app_vanillaProdRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class AptoideApkfyService implements ApkfyService {
    private final ServiceApi serviceApi;

    /* compiled from: AptoideApkfyService.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H§@ø\u0001\u0000¢\u0006\u0002\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0006"}, d2 = {"Lcm/aptoide/pt/apkfy/AptoideApkfyService$ServiceApi;", HttpUrl.FRAGMENT_ENCODE_SET, "getApkfyModel", "Lretrofit2/Response;", "Lcm/aptoide/pt/apkfy/ApkfyResponse;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_vanillaProdRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes.dex */
    public interface ServiceApi {
        @GET("apkfy")
        Object getApkfyModel(Continuation<? super Response<ApkfyResponse>> continuation);
    }

    public AptoideApkfyService(ServiceApi serviceApi) {
        m.f(serviceApi, "serviceApi");
        this.serviceApi = serviceApi;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ApkfyModel mapErrorResponse() {
        return new ApkfyModel(HttpUrl.FRAGMENT_ENCODE_SET, null, HttpUrl.FRAGMENT_ENCODE_SET, HttpUrl.FRAGMENT_ENCODE_SET, HttpUrl.FRAGMENT_ENCODE_SET, HttpUrl.FRAGMENT_ENCODE_SET, HttpUrl.FRAGMENT_ENCODE_SET, HttpUrl.FRAGMENT_ENCODE_SET, HttpUrl.FRAGMENT_ENCODE_SET);
    }

    @Override // cm.aptoide.pt.apkfy.ApkfyService
    public Object getApkfy(Continuation<? super ApkfyModel> continuation) {
        return h.e(Dispatchers.b(), new AptoideApkfyService$getApkfy$2(this, null), continuation);
    }
}
