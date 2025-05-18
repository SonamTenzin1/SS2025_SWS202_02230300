package cm.aptoide.pt.bonus;

import cm.aptoide.pt.bonus.BonusAppcRemoteService;
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

/* compiled from: BonusAppcRemoteService.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "Lcm/aptoide/pt/bonus/BonusAppcModel;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "cm.aptoide.pt.bonus.BonusAppcRemoteService$getBonusAppc$2", f = "BonusAppcRemoteService.kt", l = {14}, m = "invokeSuspend")
/* loaded from: classes.dex */
final class BonusAppcRemoteService$getBonusAppc$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super BonusAppcModel>, Object> {
    int label;
    final /* synthetic */ BonusAppcRemoteService this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BonusAppcRemoteService$getBonusAppc$2(BonusAppcRemoteService bonusAppcRemoteService, Continuation<? super BonusAppcRemoteService$getBonusAppc$2> continuation) {
        super(2, continuation);
        this.this$0 = bonusAppcRemoteService;
    }

    @Override // kotlin.coroutines.j.internal.BaseContinuationImpl
    public final Continuation<u> create(Object obj, Continuation<?> continuation) {
        return new BonusAppcRemoteService$getBonusAppc$2(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super BonusAppcModel> continuation) {
        return ((BonusAppcRemoteService$getBonusAppc$2) create(coroutineScope, continuation)).invokeSuspend(u.a);
    }

    @Override // kotlin.coroutines.j.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object c2;
        BonusAppcRemoteService.ServiceApi serviceApi;
        BonusAppcModel mapErrorResponse;
        BonusAppcModel mapResponse;
        c2 = d.c();
        int i2 = this.label;
        if (i2 == 0) {
            o.b(obj);
            serviceApi = this.this$0.serviceApi;
            this.label = 1;
            obj = serviceApi.getAppcBonus(this);
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
        BonusAppcResponse bonusAppcResponse = (BonusAppcResponse) response.body();
        if (!response.isSuccessful() || bonusAppcResponse == null) {
            mapErrorResponse = this.this$0.mapErrorResponse();
            return mapErrorResponse;
        }
        mapResponse = this.this$0.mapResponse(bonusAppcResponse);
        return mapResponse;
    }
}
