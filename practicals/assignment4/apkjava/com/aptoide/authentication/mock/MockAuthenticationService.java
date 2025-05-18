package com.aptoide.authentication.mock;

import com.aptoide.authentication.model.CodeAuth;
import com.aptoide.authentication.model.OAuth2;
import com.aptoide.authentication.service.AuthenticationService;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.d;
import kotlin.o;
import kotlinx.coroutines.y0;
import okhttp3.HttpUrl;

/* compiled from: MockAuthenticationService.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J)\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\tJ\u0019\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0006H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\r\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u000e"}, d2 = {"Lcom/aptoide/authentication/mock/MockAuthenticationService;", "Lcom/aptoide/authentication/service/AuthenticationService;", "()V", "authenticate", "Lcom/aptoide/authentication/model/OAuth2;", "magicToken", HttpUrl.FRAGMENT_ENCODE_SET, "state", "agent", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sendMagicLink", "Lcom/aptoide/authentication/model/CodeAuth;", "email", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "aptoide-authentication-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class MockAuthenticationService implements AuthenticationService {
    /* JADX WARN: Removed duplicated region for block: B:15:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @Override // com.aptoide.authentication.service.AuthenticationService
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object authenticate(String str, String str2, String str3, Continuation<? super OAuth2> continuation) {
        MockAuthenticationService$authenticate$1 mockAuthenticationService$authenticate$1;
        Object c2;
        int i2;
        if (continuation instanceof MockAuthenticationService$authenticate$1) {
            mockAuthenticationService$authenticate$1 = (MockAuthenticationService$authenticate$1) continuation;
            int i3 = mockAuthenticationService$authenticate$1.label;
            if ((i3 & Integer.MIN_VALUE) != 0) {
                mockAuthenticationService$authenticate$1.label = i3 - Integer.MIN_VALUE;
                Object obj = mockAuthenticationService$authenticate$1.result;
                c2 = d.c();
                i2 = mockAuthenticationService$authenticate$1.label;
                if (i2 != 0) {
                    o.b(obj);
                    mockAuthenticationService$authenticate$1.label = 1;
                    if (y0.a(200L, mockAuthenticationService$authenticate$1) == c2) {
                        return c2;
                    }
                } else {
                    if (i2 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    o.b(obj);
                }
                return new OAuth2("OAUTH2", false, new OAuth2.Data("accesst0k3nF4k3", 3000, "r3fr3shT0k3nF4k3", "Bearer", null));
            }
        }
        mockAuthenticationService$authenticate$1 = new MockAuthenticationService$authenticate$1(this, continuation);
        Object obj2 = mockAuthenticationService$authenticate$1.result;
        c2 = d.c();
        i2 = mockAuthenticationService$authenticate$1.label;
        if (i2 != 0) {
        }
        return new OAuth2("OAUTH2", false, new OAuth2.Data("accesst0k3nF4k3", 3000, "r3fr3shT0k3nF4k3", "Bearer", null));
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @Override // com.aptoide.authentication.service.AuthenticationService
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object sendMagicLink(String str, Continuation<? super CodeAuth> continuation) {
        MockAuthenticationService$sendMagicLink$1 mockAuthenticationService$sendMagicLink$1;
        Object c2;
        int i2;
        if (continuation instanceof MockAuthenticationService$sendMagicLink$1) {
            mockAuthenticationService$sendMagicLink$1 = (MockAuthenticationService$sendMagicLink$1) continuation;
            int i3 = mockAuthenticationService$sendMagicLink$1.label;
            if ((i3 & Integer.MIN_VALUE) != 0) {
                mockAuthenticationService$sendMagicLink$1.label = i3 - Integer.MIN_VALUE;
                Object obj = mockAuthenticationService$sendMagicLink$1.result;
                c2 = d.c();
                i2 = mockAuthenticationService$sendMagicLink$1.label;
                if (i2 != 0) {
                    o.b(obj);
                    mockAuthenticationService$sendMagicLink$1.label = 1;
                    if (y0.a(200L, mockAuthenticationService$sendMagicLink$1) == c2) {
                        return c2;
                    }
                } else {
                    if (i2 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    o.b(obj);
                }
                return new CodeAuth("code", "estado de arte", "agente da pejota", false, new CodeAuth.Data("TOKEN", "EMAIL"), "filipo@emailo.como");
            }
        }
        mockAuthenticationService$sendMagicLink$1 = new MockAuthenticationService$sendMagicLink$1(this, continuation);
        Object obj2 = mockAuthenticationService$sendMagicLink$1.result;
        c2 = d.c();
        i2 = mockAuthenticationService$sendMagicLink$1.label;
        if (i2 != 0) {
        }
        return new CodeAuth("code", "estado de arte", "agente da pejota", false, new CodeAuth.Data("TOKEN", "EMAIL"), "filipo@emailo.como");
    }
}
