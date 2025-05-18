package com.aptoide.authenticationrx;

import com.aptoide.authentication.AptoideAuthentication;
import com.aptoide.authentication.model.CodeAuth;
import com.aptoide.authentication.model.OAuth2;
import h.a.s;
import kotlin.Metadata;
import kotlin.jvm.internal.m;
import kotlinx.coroutines.rx2.h;
import okhttp3.HttpUrl;

/* compiled from: AptoideAuthenticationRx.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J$\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tJ\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u00062\u0006\u0010\u000e\u001a\u00020\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/aptoide/authenticationrx/AptoideAuthenticationRx;", HttpUrl.FRAGMENT_ENCODE_SET, "aptoideAuthentication", "Lcom/aptoide/authentication/AptoideAuthentication;", "(Lcom/aptoide/authentication/AptoideAuthentication;)V", "authenticate", "Lio/reactivex/Single;", "Lcom/aptoide/authentication/model/OAuth2;", "magicCode", HttpUrl.FRAGMENT_ENCODE_SET, "state", "agent", "sendMagicLink", "Lcom/aptoide/authentication/model/CodeAuth;", "email", "aptoide-authentication-rx"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class AptoideAuthenticationRx {
    private final AptoideAuthentication aptoideAuthentication;

    public AptoideAuthenticationRx(AptoideAuthentication aptoideAuthentication) {
        m.f(aptoideAuthentication, "aptoideAuthentication");
        this.aptoideAuthentication = aptoideAuthentication;
    }

    public final s<OAuth2> authenticate(String str, String str2, String str3) {
        m.f(str, "magicCode");
        m.f(str2, "state");
        m.f(str3, "agent");
        return h.c(null, new AptoideAuthenticationRx$authenticate$1(this, str, str2, str3, null), 1, null);
    }

    public final s<CodeAuth> sendMagicLink(String str) {
        m.f(str, "email");
        return h.c(null, new AptoideAuthenticationRx$sendMagicLink$1(this, str, null), 1, null);
    }
}
