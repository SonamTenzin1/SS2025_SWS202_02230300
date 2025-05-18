package cm.aptoide.pt.apkfy;

import cm.aptoide.pt.apkfy.AptoideApkfyService;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.d;
import kotlin.coroutines.j.internal.DebugMetadata;
import kotlin.coroutines.j.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.o;
import kotlin.u;
import kotlinx.coroutines.CoroutineScope;
import retrofit2.Response;

/* compiled from: AptoideApkfyService.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "Lcm/aptoide/pt/apkfy/ApkfyModel;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "cm.aptoide.pt.apkfy.AptoideApkfyService$getApkfy$2", f = "AptoideApkfyService.kt", l = {12}, m = "invokeSuspend")
/* loaded from: classes.dex */
final class AptoideApkfyService$getApkfy$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ApkfyModel>, Object> {
    int label;
    final /* synthetic */ AptoideApkfyService this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AptoideApkfyService$getApkfy$2(AptoideApkfyService aptoideApkfyService, Continuation<? super AptoideApkfyService$getApkfy$2> continuation) {
        super(2, continuation);
        this.this$0 = aptoideApkfyService;
    }

    @Override // kotlin.coroutines.j.internal.BaseContinuationImpl
    public final Continuation<u> create(Object obj, Continuation<?> continuation) {
        return new AptoideApkfyService$getApkfy$2(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super ApkfyModel> continuation) {
        return ((AptoideApkfyService$getApkfy$2) create(coroutineScope, continuation)).invokeSuspend(u.a);
    }

    @Override // kotlin.coroutines.j.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object c2;
        AptoideApkfyService.ServiceApi serviceApi;
        ApkfyModel mapErrorResponse;
        c2 = d.c();
        int i2 = this.label;
        if (i2 == 0) {
            o.b(obj);
            serviceApi = this.this$0.serviceApi;
            this.label = 1;
            obj = serviceApi.getApkfyModel(this);
            if (obj == c2) {
                return c2;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            o.b(obj);
        }
        Response response = (Response) obj;
        ApkfyResponse apkfyResponse = (ApkfyResponse) response.body();
        if (!response.isSuccessful() || apkfyResponse == null) {
            mapErrorResponse = this.this$0.mapErrorResponse();
            return mapErrorResponse;
        }
        return ApkfyResponseKt.mapToApkfyModel(apkfyResponse);
    }
}
