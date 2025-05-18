package com.aptoide.aptoide_ab_testing.network;

import com.aptoide.aptoide_ab_testing.FlagrException;
import com.aptoide.aptoide_ab_testing.model.Flag;
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
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "Lcom/aptoide/aptoide_ab_testing/model/Flag;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.aptoide.aptoide_ab_testing.network.FlagrApiService$getFlag$2", f = "FlagrApiService.kt", l = {33}, m = "invokeSuspend")
/* loaded from: classes.dex */
final class FlagrApiService$getFlag$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Flag>, Object> {
    final /* synthetic */ String $flagID;
    int label;
    final /* synthetic */ FlagrApiService this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlagrApiService$getFlag$2(FlagrApiService flagrApiService, String str, Continuation<? super FlagrApiService$getFlag$2> continuation) {
        super(2, continuation);
        this.this$0 = flagrApiService;
        this.$flagID = str;
    }

    @Override // kotlin.coroutines.j.internal.BaseContinuationImpl
    public final Continuation<u> create(Object obj, Continuation<?> continuation) {
        return new FlagrApiService$getFlag$2(this.this$0, this.$flagID, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Flag> continuation) {
        return ((FlagrApiService$getFlag$2) create(coroutineScope, continuation)).invokeSuspend(u.a);
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
            String str = this.$flagID;
            this.label = 1;
            obj = flagr.getFlag(str, this);
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
        Flag flag = (Flag) response.body();
        if (response.isSuccessful() && flag != null) {
            return flag;
        }
        String message = response.message();
        m.e(message, "getFlagResponse.message()");
        throw new FlagrException(message, response.code());
    }
}
