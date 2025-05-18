package com.aptoide.authenticationrx;

import com.aptoide.authentication.AptoideAuthentication;
import com.aptoide.authentication.model.CodeAuth;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.d;
import kotlin.coroutines.j.internal.DebugMetadata;
import kotlin.coroutines.j.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.o;
import kotlin.u;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AptoideAuthenticationRx.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "Lcom/aptoide/authentication/model/CodeAuth;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.aptoide.authenticationrx.AptoideAuthenticationRx$sendMagicLink$1", f = "AptoideAuthenticationRx.kt", l = {11}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class AptoideAuthenticationRx$sendMagicLink$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super CodeAuth>, Object> {
    final /* synthetic */ String $email;
    int label;
    final /* synthetic */ AptoideAuthenticationRx this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AptoideAuthenticationRx$sendMagicLink$1(AptoideAuthenticationRx aptoideAuthenticationRx, String str, Continuation<? super AptoideAuthenticationRx$sendMagicLink$1> continuation) {
        super(2, continuation);
        this.this$0 = aptoideAuthenticationRx;
        this.$email = str;
    }

    @Override // kotlin.coroutines.j.internal.BaseContinuationImpl
    public final Continuation<u> create(Object obj, Continuation<?> continuation) {
        return new AptoideAuthenticationRx$sendMagicLink$1(this.this$0, this.$email, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super CodeAuth> continuation) {
        return ((AptoideAuthenticationRx$sendMagicLink$1) create(coroutineScope, continuation)).invokeSuspend(u.a);
    }

    @Override // kotlin.coroutines.j.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object c2;
        AptoideAuthentication aptoideAuthentication;
        c2 = d.c();
        int i2 = this.label;
        if (i2 == 0) {
            o.b(obj);
            aptoideAuthentication = this.this$0.aptoideAuthentication;
            String str = this.$email;
            this.label = 1;
            obj = aptoideAuthentication.sendMagicLink(str, this);
            if (obj == c2) {
                return c2;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            o.b(obj);
        }
        return obj;
    }
}
