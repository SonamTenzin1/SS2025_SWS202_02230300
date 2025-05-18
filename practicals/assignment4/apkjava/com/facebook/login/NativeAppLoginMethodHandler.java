package com.facebook.login;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import androidx.fragment.app.Fragment;
import com.facebook.FacebookException;
import com.facebook.FacebookRequestError;
import com.facebook.FacebookServiceException;
import com.facebook.internal.n0;
import com.facebook.internal.p0;
import com.facebook.login.CustomTabLoginMethodHandler;
import com.facebook.login.LoginClient;
import com.facebook.login.LoginMethodHandler;

/* compiled from: NativeAppLoginMethodHandler.kt */
/* loaded from: classes2.dex */
public abstract class NativeAppLoginMethodHandler extends LoginMethodHandler {

    /* renamed from: i, reason: collision with root package name */
    private final com.facebook.w f9986i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NativeAppLoginMethodHandler(LoginClient loginClient) {
        super(loginClient);
        kotlin.jvm.internal.m.f(loginClient, "loginClient");
        this.f9986i = com.facebook.w.FACEBOOK_APPLICATION_WEB;
    }

    private final void p(LoginClient.Result result) {
        if (result != null) {
            d().g(result);
        } else {
            d().B();
        }
    }

    private final boolean w(Intent intent) {
        com.facebook.a0 a0Var = com.facebook.a0.a;
        kotlin.jvm.internal.m.e(com.facebook.a0.c().getPackageManager().queryIntentActivities(intent, 65536), "FacebookSdk.getApplicationContext()\n            .packageManager\n            .queryIntentActivities(intent, PackageManager.MATCH_DEFAULT_ONLY)");
        return !r3.isEmpty();
    }

    private final void y(final LoginClient.Request request, final Bundle bundle) {
        if (bundle.containsKey("code")) {
            p0 p0Var = p0.a;
            if (!p0.a0(bundle.getString("code"))) {
                com.facebook.a0 a0Var = com.facebook.a0.a;
                com.facebook.a0.k().execute(new Runnable() { // from class: com.facebook.login.o
                    @Override // java.lang.Runnable
                    public final void run() {
                        NativeAppLoginMethodHandler.z(NativeAppLoginMethodHandler.this, request, bundle);
                    }
                });
                return;
            }
        }
        v(request, bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z(NativeAppLoginMethodHandler nativeAppLoginMethodHandler, LoginClient.Request request, Bundle bundle) {
        kotlin.jvm.internal.m.f(nativeAppLoginMethodHandler, "this$0");
        kotlin.jvm.internal.m.f(request, "$request");
        kotlin.jvm.internal.m.f(bundle, "$extras");
        try {
            nativeAppLoginMethodHandler.v(request, nativeAppLoginMethodHandler.k(request, bundle));
        } catch (FacebookServiceException e2) {
            FacebookRequestError requestError = e2.getRequestError();
            nativeAppLoginMethodHandler.u(request, requestError.d(), requestError.c(), String.valueOf(requestError.b()));
        } catch (FacebookException e3) {
            nativeAppLoginMethodHandler.u(request, null, e3.getMessage(), null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean B(Intent intent, int i2) {
        androidx.activity.result.b<Intent> g2;
        if (intent == null || !w(intent)) {
            return false;
        }
        Fragment k2 = d().k();
        kotlin.u uVar = null;
        v vVar = k2 instanceof v ? (v) k2 : null;
        if (vVar != null && (g2 = vVar.g()) != null) {
            g2.a(intent);
            uVar = kotlin.u.a;
        }
        return uVar != null;
    }

    @Override // com.facebook.login.LoginMethodHandler
    public boolean j(int i2, int i3, Intent intent) {
        LoginClient.Request o = d().o();
        if (intent == null) {
            p(LoginClient.Result.f9972f.a(o, "Operation canceled"));
        } else if (i3 == 0) {
            t(o, intent);
        } else if (i3 != -1) {
            p(LoginClient.Result.c.d(LoginClient.Result.f9972f, o, "Unexpected resultCode from authorization.", null, null, 8, null));
        } else {
            Bundle extras = intent.getExtras();
            if (extras == null) {
                p(LoginClient.Result.c.d(LoginClient.Result.f9972f, o, "Unexpected null from returned authorization data.", null, null, 8, null));
                return true;
            }
            String q = q(extras);
            Object obj = extras.get("error_code");
            String obj2 = obj == null ? null : obj.toString();
            String r = r(extras);
            String string = extras.getString("e2e");
            p0 p0Var = p0.a;
            if (!p0.a0(string)) {
                h(string);
            }
            if (q == null && obj2 == null && r == null && o != null) {
                y(o, extras);
            } else {
                u(o, q, r, obj2);
            }
        }
        return true;
    }

    protected String q(Bundle bundle) {
        String string = bundle == null ? null : bundle.getString("error");
        if (string != null) {
            return string;
        }
        if (bundle == null) {
            return null;
        }
        return bundle.getString("error_type");
    }

    protected String r(Bundle bundle) {
        String string = bundle == null ? null : bundle.getString("error_message");
        if (string != null) {
            return string;
        }
        if (bundle == null) {
            return null;
        }
        return bundle.getString("error_description");
    }

    public com.facebook.w s() {
        return this.f9986i;
    }

    protected void t(LoginClient.Request request, Intent intent) {
        Object obj;
        kotlin.jvm.internal.m.f(intent, "data");
        Bundle extras = intent.getExtras();
        String q = q(extras);
        String str = null;
        if (extras != null && (obj = extras.get("error_code")) != null) {
            str = obj.toString();
        }
        n0 n0Var = n0.a;
        if (kotlin.jvm.internal.m.a(n0.c(), str)) {
            p(LoginClient.Result.f9972f.c(request, q, r(extras), str));
        } else {
            p(LoginClient.Result.f9972f.a(request, q));
        }
    }

    protected void u(LoginClient.Request request, String str, String str2, String str3) {
        boolean K;
        boolean K2;
        if (str != null && kotlin.jvm.internal.m.a(str, "logged_out")) {
            CustomTabLoginMethodHandler.b bVar = CustomTabLoginMethodHandler.f9932k;
            CustomTabLoginMethodHandler.l = true;
            p(null);
            return;
        }
        n0 n0Var = n0.a;
        K = kotlin.collections.c0.K(n0.d(), str);
        if (K) {
            p(null);
            return;
        }
        K2 = kotlin.collections.c0.K(n0.e(), str);
        if (K2) {
            p(LoginClient.Result.f9972f.a(request, null));
        } else {
            p(LoginClient.Result.f9972f.c(request, str, str2, str3));
        }
    }

    protected void v(LoginClient.Request request, Bundle bundle) {
        kotlin.jvm.internal.m.f(request, "request");
        kotlin.jvm.internal.m.f(bundle, "extras");
        try {
            LoginMethodHandler.a aVar = LoginMethodHandler.f9983f;
            p(LoginClient.Result.f9972f.b(request, aVar.b(request.n(), bundle, s(), request.a()), aVar.d(bundle, request.m())));
        } catch (FacebookException e2) {
            p(LoginClient.Result.c.d(LoginClient.Result.f9972f, request, null, e2.getMessage(), null, 8, null));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NativeAppLoginMethodHandler(Parcel parcel) {
        super(parcel);
        kotlin.jvm.internal.m.f(parcel, "source");
        this.f9986i = com.facebook.w.FACEBOOK_APPLICATION_WEB;
    }
}
