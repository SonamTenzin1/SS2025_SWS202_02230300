package cm.aptoide.pt.aab;

import cm.aptoide.pt.aab.DynamicSplitsRemoteService;
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

/* compiled from: DynamicSplitsRemoteService.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "Lcm/aptoide/pt/aab/DynamicSplitsModel;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "cm.aptoide.pt.aab.DynamicSplitsRemoteService$getDynamicSplitsByMd5$2", f = "DynamicSplitsRemoteService.kt", l = {18}, m = "invokeSuspend")
/* loaded from: classes.dex */
final class DynamicSplitsRemoteService$getDynamicSplitsByMd5$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super DynamicSplitsModel>, Object> {
    final /* synthetic */ String $apkMd5Sum;
    int label;
    final /* synthetic */ DynamicSplitsRemoteService this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DynamicSplitsRemoteService$getDynamicSplitsByMd5$2(DynamicSplitsRemoteService dynamicSplitsRemoteService, String str, Continuation<? super DynamicSplitsRemoteService$getDynamicSplitsByMd5$2> continuation) {
        super(2, continuation);
        this.this$0 = dynamicSplitsRemoteService;
        this.$apkMd5Sum = str;
    }

    @Override // kotlin.coroutines.j.internal.BaseContinuationImpl
    public final Continuation<u> create(Object obj, Continuation<?> continuation) {
        return new DynamicSplitsRemoteService$getDynamicSplitsByMd5$2(this.this$0, this.$apkMd5Sum, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super DynamicSplitsModel> continuation) {
        return ((DynamicSplitsRemoteService$getDynamicSplitsByMd5$2) create(coroutineScope, continuation)).invokeSuspend(u.a);
    }

    @Override // kotlin.coroutines.j.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object c2;
        DynamicSplitsRemoteService.DynamicSplitsApi dynamicSplitsApi;
        DynamicSplitsModel mapErrorResponse;
        DynamicSplitsModel mapResponse;
        c2 = d.c();
        int i2 = this.label;
        if (i2 == 0) {
            o.b(obj);
            dynamicSplitsApi = this.this$0.dynamicSplitsApi;
            String str = this.$apkMd5Sum;
            this.label = 1;
            obj = dynamicSplitsApi.getDynamicSplitsByMd5(str, this);
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
        DynamicSplitsResponse dynamicSplitsResponse = (DynamicSplitsResponse) response.body();
        if (!response.isSuccessful() || dynamicSplitsResponse == null) {
            mapErrorResponse = this.this$0.mapErrorResponse();
            return mapErrorResponse;
        }
        mapResponse = this.this$0.mapResponse(dynamicSplitsResponse);
        return mapResponse;
    }
}
