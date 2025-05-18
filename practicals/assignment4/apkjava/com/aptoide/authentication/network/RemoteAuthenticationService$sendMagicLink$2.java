package com.aptoide.authentication.network;

import com.aptoide.authentication.AuthenticationException;
import com.aptoide.authentication.model.CodeAuth;
import com.aptoide.authentication.network.RemoteAuthenticationService;
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

/* compiled from: RemoteAuthenticationService.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "Lcom/aptoide/authentication/model/CodeAuth;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.aptoide.authentication.network.RemoteAuthenticationService$sendMagicLink$2", f = "RemoteAuthenticationService.kt", l = {37}, m = "invokeSuspend")
/* loaded from: classes.dex */
final class RemoteAuthenticationService$sendMagicLink$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super CodeAuth>, Object> {
    final /* synthetic */ String $email;
    int label;
    final /* synthetic */ RemoteAuthenticationService this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RemoteAuthenticationService$sendMagicLink$2(RemoteAuthenticationService remoteAuthenticationService, String str, Continuation<? super RemoteAuthenticationService$sendMagicLink$2> continuation) {
        super(2, continuation);
        this.this$0 = remoteAuthenticationService;
        this.$email = str;
    }

    @Override // kotlin.coroutines.j.internal.BaseContinuationImpl
    public final Continuation<u> create(Object obj, Continuation<?> continuation) {
        return new RemoteAuthenticationService$sendMagicLink$2(this.this$0, this.$email, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super CodeAuth> continuation) {
        return ((RemoteAuthenticationService$sendMagicLink$2) create(coroutineScope, continuation)).invokeSuspend(u.a);
    }

    @Override // kotlin.coroutines.j.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object c2;
        RemoteAuthenticationService.AuthorizationV7 authorizationV7;
        c2 = d.c();
        int i2 = this.label;
        if (i2 == 0) {
            o.b(obj);
            authorizationV7 = this.this$0.authorizationV7;
            RemoteAuthenticationService.Credentials credentials = new RemoteAuthenticationService.Credentials(this.$email, new String[]{"CODE:TOKEN:EMAIL"});
            this.label = 1;
            obj = authorizationV7.sendMagicLink(Type.EMAIL, new String[]{"TOS", "PRIVACY", "DISTRIBUTION"}, credentials, this);
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
        CodeAuth codeAuth = (CodeAuth) response.body();
        if (response.isSuccessful() && codeAuth != null) {
            codeAuth.setEmail(this.$email);
            return codeAuth;
        }
        String message = response.message();
        m.e(message, "sendMagicLinkResponse.message()");
        throw new AuthenticationException(message, response.code());
    }
}
