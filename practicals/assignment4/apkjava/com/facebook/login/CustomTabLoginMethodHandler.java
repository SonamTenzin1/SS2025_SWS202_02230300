package com.facebook.login;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.fragment.app.Fragment;
import com.facebook.CustomTabMainActivity;
import com.facebook.FacebookException;
import com.facebook.FacebookOperationCanceledException;
import com.facebook.FacebookRequestError;
import com.facebook.FacebookServiceException;
import com.facebook.internal.f0;
import com.facebook.internal.p0;
import com.facebook.login.LoginClient;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: CustomTabLoginMethodHandler.kt */
/* loaded from: classes2.dex */
public final class CustomTabLoginMethodHandler extends WebLoginMethodHandler {
    public static boolean l;
    private String m;
    private String n;
    private String o;
    private final String p;
    private final com.facebook.w q;

    /* renamed from: k, reason: collision with root package name */
    public static final b f9932k = new b(null);
    public static final Parcelable.Creator<CustomTabLoginMethodHandler> CREATOR = new a();

    /* compiled from: CustomTabLoginMethodHandler.kt */
    /* loaded from: classes2.dex */
    public static final class a implements Parcelable.Creator<CustomTabLoginMethodHandler> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public CustomTabLoginMethodHandler createFromParcel(Parcel parcel) {
            kotlin.jvm.internal.m.f(parcel, "source");
            return new CustomTabLoginMethodHandler(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public CustomTabLoginMethodHandler[] newArray(int i2) {
            return new CustomTabLoginMethodHandler[i2];
        }
    }

    /* compiled from: CustomTabLoginMethodHandler.kt */
    /* loaded from: classes2.dex */
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(kotlin.jvm.internal.g gVar) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CustomTabLoginMethodHandler(LoginClient loginClient) {
        super(loginClient);
        kotlin.jvm.internal.m.f(loginClient, "loginClient");
        this.p = "custom_tab";
        this.q = com.facebook.w.CHROME_CUSTOM_TAB;
        p0 p0Var = p0.a;
        this.n = p0.q(20);
        l = false;
        com.facebook.internal.v vVar = com.facebook.internal.v.a;
        this.o = com.facebook.internal.v.c(x());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B(CustomTabLoginMethodHandler customTabLoginMethodHandler, LoginClient.Request request, Bundle bundle) {
        kotlin.jvm.internal.m.f(customTabLoginMethodHandler, "this$0");
        kotlin.jvm.internal.m.f(request, "$request");
        kotlin.jvm.internal.m.f(bundle, "$values");
        try {
            customTabLoginMethodHandler.u(request, customTabLoginMethodHandler.k(request, bundle), null);
        } catch (FacebookException e2) {
            customTabLoginMethodHandler.u(request, null, e2);
        }
    }

    private final boolean C(Bundle bundle) {
        try {
            String string = bundle.getString("state");
            if (string == null) {
                return false;
            }
            return kotlin.jvm.internal.m.a(new JSONObject(string).getString("7_challenge"), this.n);
        } catch (JSONException unused) {
            return false;
        }
    }

    private final String w() {
        String str = this.m;
        if (str != null) {
            return str;
        }
        com.facebook.internal.v vVar = com.facebook.internal.v.a;
        String a2 = com.facebook.internal.v.a();
        this.m = a2;
        return a2;
    }

    private final String x() {
        return super.g();
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00c8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void z(String str, final LoginClient.Request request) {
        boolean E;
        int i2;
        boolean E2;
        if (str == null) {
            return;
        }
        E = kotlin.text.u.E(str, "fbconnect://cct.", false, 2, null);
        if (!E) {
            E2 = kotlin.text.u.E(str, super.g(), false, 2, null);
            if (!E2) {
                return;
            }
        }
        Uri parse = Uri.parse(str);
        p0 p0Var = p0.a;
        final Bundle o0 = p0.o0(parse.getQuery());
        o0.putAll(p0.o0(parse.getFragment()));
        if (!C(o0)) {
            super.u(request, null, new FacebookException("Invalid state parameter"));
            return;
        }
        String string = o0.getString("error");
        if (string == null) {
            string = o0.getString("error_type");
        }
        String string2 = o0.getString("error_msg");
        if (string2 == null) {
            string2 = o0.getString("error_message");
        }
        if (string2 == null) {
            string2 = o0.getString("error_description");
        }
        String string3 = o0.getString("error_code");
        if (string3 != null) {
            try {
                i2 = Integer.parseInt(string3);
            } catch (NumberFormatException unused) {
                i2 = -1;
            }
            p0 p0Var2 = p0.a;
            if (!p0.a0(string) && p0.a0(string2) && i2 == -1) {
                if (o0.containsKey("access_token")) {
                    super.u(request, o0, null);
                    return;
                } else {
                    com.facebook.a0 a0Var = com.facebook.a0.a;
                    com.facebook.a0.k().execute(new Runnable() { // from class: com.facebook.login.a
                        @Override // java.lang.Runnable
                        public final void run() {
                            CustomTabLoginMethodHandler.B(CustomTabLoginMethodHandler.this, request, o0);
                        }
                    });
                    return;
                }
            }
            if (string == null && (kotlin.jvm.internal.m.a(string, "access_denied") || kotlin.jvm.internal.m.a(string, "OAuthAccessDeniedException"))) {
                super.u(request, null, new FacebookOperationCanceledException());
                return;
            } else if (i2 != 4201) {
                super.u(request, null, new FacebookOperationCanceledException());
                return;
            } else {
                super.u(request, null, new FacebookServiceException(new FacebookRequestError(i2, string, string2), string2));
                return;
            }
        }
        i2 = -1;
        p0 p0Var22 = p0.a;
        if (!p0.a0(string)) {
        }
        if (string == null) {
        }
        if (i2 != 4201) {
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.facebook.login.LoginMethodHandler
    public String f() {
        return this.p;
    }

    @Override // com.facebook.login.LoginMethodHandler
    protected String g() {
        return this.o;
    }

    @Override // com.facebook.login.LoginMethodHandler
    public boolean j(int i2, int i3, Intent intent) {
        if (intent != null && intent.getBooleanExtra(CustomTabMainActivity.m, false)) {
            return super.j(i2, i3, intent);
        }
        if (i2 != 1) {
            return super.j(i2, i3, intent);
        }
        LoginClient.Request o = d().o();
        if (o == null) {
            return false;
        }
        if (i3 == -1) {
            z(intent != null ? intent.getStringExtra(CustomTabMainActivity.f9593j) : null, o);
            return true;
        }
        super.u(o, null, new FacebookOperationCanceledException());
        return false;
    }

    @Override // com.facebook.login.LoginMethodHandler
    public void l(JSONObject jSONObject) throws JSONException {
        kotlin.jvm.internal.m.f(jSONObject, "param");
        jSONObject.put("7_challenge", this.n);
    }

    @Override // com.facebook.login.LoginMethodHandler
    public int o(LoginClient.Request request) {
        kotlin.jvm.internal.m.f(request, "request");
        LoginClient d2 = d();
        if (g().length() == 0) {
            return 0;
        }
        Bundle p = p(q(request), request);
        if (l) {
            p.putString("cct_over_app_switch", "1");
        }
        if (com.facebook.a0.q) {
            if (request.r()) {
                q.f10020f.c(f0.f9773c.a("oauth", p));
            } else {
                q.f10020f.c(com.facebook.internal.u.a.a("oauth", p));
            }
        }
        androidx.fragment.app.d i2 = d2.i();
        if (i2 == null) {
            return 0;
        }
        Intent intent = new Intent(i2, (Class<?>) CustomTabMainActivity.class);
        intent.putExtra(CustomTabMainActivity.f9590g, "oauth");
        intent.putExtra(CustomTabMainActivity.f9591h, p);
        intent.putExtra(CustomTabMainActivity.f9592i, w());
        intent.putExtra(CustomTabMainActivity.f9594k, request.k().toString());
        Fragment k2 = d2.k();
        if (k2 != null) {
            k2.startActivityForResult(intent, 1);
        }
        return 1;
    }

    @Override // com.facebook.login.WebLoginMethodHandler
    protected String r() {
        return "chrome_custom_tab";
    }

    @Override // com.facebook.login.WebLoginMethodHandler
    public com.facebook.w s() {
        return this.q;
    }

    @Override // com.facebook.login.LoginMethodHandler, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        kotlin.jvm.internal.m.f(parcel, "dest");
        super.writeToParcel(parcel, i2);
        parcel.writeString(this.n);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CustomTabLoginMethodHandler(Parcel parcel) {
        super(parcel);
        kotlin.jvm.internal.m.f(parcel, "source");
        this.p = "custom_tab";
        this.q = com.facebook.w.CHROME_CUSTOM_TAB;
        this.n = parcel.readString();
        com.facebook.internal.v vVar = com.facebook.internal.v.a;
        this.o = com.facebook.internal.v.c(x());
    }
}
