package com.facebook.login;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.text.TextUtils;
import android.webkit.CookieSyncManager;
import cm.aptoide.pt.account.view.LoginActivity;
import cm.aptoide.pt.reviews.RateAndReviewsFragment;
import com.facebook.AccessToken;
import com.facebook.FacebookException;
import com.facebook.FacebookOperationCanceledException;
import com.facebook.FacebookRequestError;
import com.facebook.FacebookServiceException;
import com.facebook.internal.p0;
import com.facebook.login.LoginClient;
import com.facebook.login.LoginMethodHandler;
import okhttp3.HttpUrl;

/* compiled from: WebLoginMethodHandler.kt */
/* loaded from: classes2.dex */
public abstract class WebLoginMethodHandler extends LoginMethodHandler {

    /* renamed from: i, reason: collision with root package name */
    public static final a f9987i = new a(null);

    /* renamed from: j, reason: collision with root package name */
    private String f9988j;

    /* compiled from: WebLoginMethodHandler.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WebLoginMethodHandler(LoginClient loginClient) {
        super(loginClient);
        kotlin.jvm.internal.m.f(loginClient, "loginClient");
    }

    private final String t() {
        Context i2 = d().i();
        if (i2 == null) {
            com.facebook.a0 a0Var = com.facebook.a0.a;
            i2 = com.facebook.a0.c();
        }
        return i2.getSharedPreferences("com.facebook.login.AuthorizationClient.WebViewAuthHandler.TOKEN_STORE_KEY", 0).getString("TOKEN", HttpUrl.FRAGMENT_ENCODE_SET);
    }

    private final void v(String str) {
        Context i2 = d().i();
        if (i2 == null) {
            com.facebook.a0 a0Var = com.facebook.a0.a;
            i2 = com.facebook.a0.c();
        }
        i2.getSharedPreferences("com.facebook.login.AuthorizationClient.WebViewAuthHandler.TOKEN_STORE_KEY", 0).edit().putString("TOKEN", str).apply();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Bundle p(Bundle bundle, LoginClient.Request request) {
        kotlin.jvm.internal.m.f(bundle, "parameters");
        kotlin.jvm.internal.m.f(request, "request");
        bundle.putString("redirect_uri", g());
        if (request.r()) {
            bundle.putString(RateAndReviewsFragment.BundleCons.APP_ID, request.a());
        } else {
            bundle.putString("client_id", request.a());
        }
        bundle.putString("e2e", LoginClient.f9960f.a());
        if (request.r()) {
            bundle.putString("response_type", "token,signed_request,graph_domain,granted_scopes");
        } else {
            if (request.n().contains("openid")) {
                bundle.putString("nonce", request.m());
            }
            bundle.putString("response_type", "id_token,token,signed_request,graph_domain");
        }
        bundle.putString("code_challenge", request.d());
        p e2 = request.e();
        bundle.putString("code_challenge_method", e2 == null ? null : e2.name());
        bundle.putString("return_scopes", "true");
        bundle.putString(LoginActivity.AUTH_TYPE, request.c());
        bundle.putString("login_behavior", request.j().name());
        com.facebook.a0 a0Var = com.facebook.a0.a;
        bundle.putString("sdk", kotlin.jvm.internal.m.n("android-", com.facebook.a0.s()));
        if (r() != null) {
            bundle.putString("sso", r());
        }
        bundle.putString("cct_prefetching", com.facebook.a0.q ? "1" : "0");
        if (request.q()) {
            bundle.putString("fx_app", request.k().toString());
        }
        if (request.z()) {
            bundle.putString("skip_dedupe", "true");
        }
        if (request.l() != null) {
            bundle.putString("messenger_page_id", request.l());
            bundle.putString("reset_messenger_state", request.o() ? "1" : "0");
        }
        return bundle;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Bundle q(LoginClient.Request request) {
        kotlin.jvm.internal.m.f(request, "request");
        Bundle bundle = new Bundle();
        p0 p0Var = p0.a;
        if (!p0.b0(request.n())) {
            String join = TextUtils.join(",", request.n());
            bundle.putString("scope", join);
            a("scope", join);
        }
        r g2 = request.g();
        if (g2 == null) {
            g2 = r.NONE;
        }
        bundle.putString("default_audience", g2.k());
        bundle.putString("state", c(request.b()));
        AccessToken e2 = AccessToken.f9559f.e();
        String l = e2 == null ? null : e2.l();
        if (l != null && kotlin.jvm.internal.m.a(l, t())) {
            bundle.putString("access_token", l);
            a("access_token", "1");
        } else {
            androidx.fragment.app.d i2 = d().i();
            if (i2 != null) {
                p0.g(i2);
            }
            a("access_token", "0");
        }
        bundle.putString("cbt", String.valueOf(System.currentTimeMillis()));
        com.facebook.a0 a0Var = com.facebook.a0.a;
        bundle.putString("ies", com.facebook.a0.g() ? "1" : "0");
        return bundle;
    }

    protected String r() {
        return null;
    }

    public abstract com.facebook.w s();

    public void u(LoginClient.Request request, Bundle bundle, FacebookException facebookException) {
        String str;
        LoginClient.Result c2;
        kotlin.jvm.internal.m.f(request, "request");
        LoginClient d2 = d();
        this.f9988j = null;
        if (bundle != null) {
            if (bundle.containsKey("e2e")) {
                this.f9988j = bundle.getString("e2e");
            }
            try {
                LoginMethodHandler.a aVar = LoginMethodHandler.f9983f;
                AccessToken b2 = aVar.b(request.n(), bundle, s(), request.a());
                c2 = LoginClient.Result.f9972f.b(d2.o(), b2, aVar.d(bundle, request.m()));
                if (d2.i() != null) {
                    try {
                        CookieSyncManager.createInstance(d2.i()).sync();
                    } catch (Exception unused) {
                    }
                    if (b2 != null) {
                        v(b2.l());
                    }
                }
            } catch (FacebookException e2) {
                c2 = LoginClient.Result.c.d(LoginClient.Result.f9972f, d2.o(), null, e2.getMessage(), null, 8, null);
            }
        } else if (facebookException instanceof FacebookOperationCanceledException) {
            c2 = LoginClient.Result.f9972f.a(d2.o(), "User canceled log in.");
        } else {
            this.f9988j = null;
            String message = facebookException == null ? null : facebookException.getMessage();
            if (facebookException instanceof FacebookServiceException) {
                FacebookRequestError requestError = ((FacebookServiceException) facebookException).getRequestError();
                str = String.valueOf(requestError.b());
                message = requestError.toString();
            } else {
                str = null;
            }
            c2 = LoginClient.Result.f9972f.c(d2.o(), null, message, str);
        }
        p0 p0Var = p0.a;
        if (!p0.a0(this.f9988j)) {
            h(this.f9988j);
        }
        d2.g(c2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WebLoginMethodHandler(Parcel parcel) {
        super(parcel);
        kotlin.jvm.internal.m.f(parcel, "source");
    }
}
