package com.aptoide.aptoide_ab_testing.network;

import com.aptoide.aptoide_ab_testing.FlagrException;
import com.aptoide.aptoide_ab_testing.model.EvalContext;
import com.aptoide.aptoide_ab_testing.model.PostEvaluationResponseJson;
import com.aptoide.aptoide_ab_testing.network.FlagrApiService;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.d;
import kotlin.coroutines.j.internal.DebugMetadata;
import kotlin.coroutines.j.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.m;
import kotlin.o;
import kotlin.u;
import kotlinx.coroutines.CoroutineScope;
import retrofit2.Response;

/* compiled from: FlagrApiService.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "Lcom/aptoide/aptoide_ab_testing/model/PostEvaluationResponseJson;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.aptoide.aptoide_ab_testing.network.FlagrApiService$postEvaluation$2", f = "FlagrApiService.kt", l = {47}, m = "invokeSuspend")
/* loaded from: classes.dex */
final class FlagrApiService$postEvaluation$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super PostEvaluationResponseJson>, Object> {
    final /* synthetic */ EvalContext $body;
    int label;
    final /* synthetic */ FlagrApiService this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlagrApiService$postEvaluation$2(FlagrApiService flagrApiService, EvalContext evalContext, Continuation<? super FlagrApiService$postEvaluation$2> continuation) {
        super(2, continuation);
        this.this$0 = flagrApiService;
        this.$body = evalContext;
    }

    @Override // kotlin.coroutines.j.internal.BaseContinuationImpl
    public final Continuation<u> create(Object obj, Continuation<?> continuation) {
        return new FlagrApiService$postEvaluation$2(this.this$0, this.$body, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super PostEvaluationResponseJson> continuation) {
        return ((FlagrApiService$postEvaluation$2) create(coroutineScope, continuation)).invokeSuspend(u.a);
    }

    @Override // kotlin.coroutines.j.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object c2;
        FlagrApiService.Flagr flagr;
        c2 = d.c();
        int i2 = this.label;
        if (i2 == 0) {
            o.b(obj);
            flagr = this.this$0.flagr;
            EvalContext evalContext = this.$body;
            this.label = 1;
            obj = flagr.postEvaluation(evalContext, this);
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
        PostEvaluationResponseJson postEvaluationResponseJson = (PostEvaluationResponseJson) response.body();
        if (response.isSuccessful() && postEvaluationResponseJson != null) {
            return postEvaluationResponseJson;
        }
        String message = response.message();
        m.e(message, "postEvaluationResult.message()");
        throw new FlagrException(message, response.code());
    }
}
