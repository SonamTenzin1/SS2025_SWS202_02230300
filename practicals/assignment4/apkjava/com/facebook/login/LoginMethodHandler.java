package com.facebook.login;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Base64;
import android.util.Log;
import cm.aptoide.pt.reviews.RateAndReviewsFragment;
import cm.aptoide.pt.timeline.view.follow.TimeLineFollowFragment;
import com.facebook.AccessToken;
import com.facebook.AuthenticationToken;
import com.facebook.FacebookException;
import com.facebook.FacebookRequestError;
import com.facebook.FacebookServiceException;
import com.facebook.GraphRequest;
import com.facebook.d0;
import com.facebook.internal.p0;
import com.facebook.login.LoginClient;
import com.facebook.o0.g0;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.q0;
import kotlin.text.Charsets;
import okhttp3.HttpUrl;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: LoginMethodHandler.kt */
/* loaded from: classes2.dex */
public abstract class LoginMethodHandler implements Parcelable {

    /* renamed from: f, reason: collision with root package name */
    public static final a f9983f = new a(null);

    /* renamed from: g, reason: collision with root package name */
    private Map<String, String> f9984g;

    /* renamed from: h, reason: collision with root package name */
    public LoginClient f9985h;

    /* compiled from: LoginMethodHandler.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
            this();
        }

        public final AccessToken a(Bundle bundle, com.facebook.w wVar, String str) {
            String string;
            kotlin.jvm.internal.m.f(bundle, "bundle");
            kotlin.jvm.internal.m.f(str, "applicationId");
            p0 p0Var = p0.a;
            Date v = p0.v(bundle, "com.facebook.platform.extra.EXPIRES_SECONDS_SINCE_EPOCH", new Date(0L));
            ArrayList<String> stringArrayList = bundle.getStringArrayList("com.facebook.platform.extra.PERMISSIONS");
            String string2 = bundle.getString("com.facebook.platform.extra.ACCESS_TOKEN");
            Date v2 = p0.v(bundle, "com.facebook.platform.extra.EXTRA_DATA_ACCESS_EXPIRATION_TIME", new Date(0L));
            if (string2 != null) {
                if (!(string2.length() == 0) && (string = bundle.getString("com.facebook.platform.extra.USER_ID")) != null) {
                    if (!(string.length() == 0)) {
                        return new AccessToken(string2, str, string, stringArrayList, null, null, wVar, v, new Date(), v2, bundle.getString("graph_domain"));
                    }
                }
            }
            return null;
        }

        /* JADX WARN: Removed duplicated region for block: B:16:0x007e  */
        /* JADX WARN: Removed duplicated region for block: B:25:0x00bb  */
        /* JADX WARN: Removed duplicated region for block: B:34:0x00f7 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:35:0x00f8  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final AccessToken b(Collection<String> collection, Bundle bundle, com.facebook.w wVar, String str) throws FacebookException {
            Collection<String> collection2;
            String string;
            ArrayList arrayList;
            String string2;
            ArrayList arrayList2;
            List v0;
            ArrayList f2;
            List v02;
            List v03;
            kotlin.jvm.internal.m.f(bundle, "bundle");
            kotlin.jvm.internal.m.f(str, "applicationId");
            p0 p0Var = p0.a;
            Date v = p0.v(bundle, "expires_in", new Date());
            String string3 = bundle.getString("access_token");
            if (string3 == null) {
                return null;
            }
            Date v2 = p0.v(bundle, "data_access_expiration_time", new Date(0L));
            String string4 = bundle.getString("granted_scopes");
            if (string4 != null) {
                if (string4.length() > 0) {
                    v03 = kotlin.text.v.v0(string4, new String[]{","}, false, 0, 6, null);
                    Object[] array = v03.toArray(new String[0]);
                    if (array != null) {
                        String[] strArr = (String[]) array;
                        collection2 = kotlin.collections.u.f(Arrays.copyOf(strArr, strArr.length));
                        string = bundle.getString("denied_scopes");
                        if (string != null) {
                            if (string.length() > 0) {
                                v02 = kotlin.text.v.v0(string, new String[]{","}, false, 0, 6, null);
                                Object[] array2 = v02.toArray(new String[0]);
                                if (array2 != null) {
                                    String[] strArr2 = (String[]) array2;
                                    arrayList = kotlin.collections.u.f(Arrays.copyOf(strArr2, strArr2.length));
                                    string2 = bundle.getString("expired_scopes");
                                    if (string2 != null) {
                                        if (string2.length() > 0) {
                                            v0 = kotlin.text.v.v0(string2, new String[]{","}, false, 0, 6, null);
                                            Object[] array3 = v0.toArray(new String[0]);
                                            if (array3 != null) {
                                                String[] strArr3 = (String[]) array3;
                                                f2 = kotlin.collections.u.f(Arrays.copyOf(strArr3, strArr3.length));
                                                arrayList2 = f2;
                                                if (p0.a0(string3)) {
                                                    return new AccessToken(string3, str, e(bundle.getString("signed_request")), collection2, arrayList, arrayList2, wVar, v, new Date(), v2, bundle.getString("graph_domain"));
                                                }
                                                return null;
                                            }
                                            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                                        }
                                    }
                                    arrayList2 = null;
                                    if (p0.a0(string3)) {
                                    }
                                } else {
                                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                                }
                            }
                        }
                        arrayList = null;
                        string2 = bundle.getString("expired_scopes");
                        if (string2 != null) {
                        }
                        arrayList2 = null;
                        if (p0.a0(string3)) {
                        }
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                    }
                }
            }
            collection2 = collection;
            string = bundle.getString("denied_scopes");
            if (string != null) {
            }
            arrayList = null;
            string2 = bundle.getString("expired_scopes");
            if (string2 != null) {
            }
            arrayList2 = null;
            if (p0.a0(string3)) {
            }
        }

        public final AuthenticationToken c(Bundle bundle, String str) throws FacebookException {
            kotlin.jvm.internal.m.f(bundle, "bundle");
            String string = bundle.getString("com.facebook.platform.extra.ID_TOKEN");
            if (string != null) {
                if (!(string.length() == 0) && str != null) {
                    if (!(str.length() == 0)) {
                        try {
                            return new AuthenticationToken(string, str);
                        } catch (Exception e2) {
                            throw new FacebookException(e2.getMessage());
                        }
                    }
                }
            }
            return null;
        }

        public final AuthenticationToken d(Bundle bundle, String str) throws FacebookException {
            kotlin.jvm.internal.m.f(bundle, "bundle");
            String string = bundle.getString("id_token");
            if (string != null) {
                if (!(string.length() == 0) && str != null) {
                    if (!(str.length() == 0)) {
                        try {
                            return new AuthenticationToken(string, str);
                        } catch (Exception e2) {
                            throw new FacebookException(e2.getMessage(), e2);
                        }
                    }
                }
            }
            return null;
        }

        public final String e(String str) throws FacebookException {
            List v0;
            Object[] array;
            if (str != null) {
                if (!(str.length() == 0)) {
                    try {
                        v0 = kotlin.text.v.v0(str, new String[]{"."}, false, 0, 6, null);
                        array = v0.toArray(new String[0]);
                    } catch (UnsupportedEncodingException | JSONException unused) {
                    }
                    if (array != null) {
                        String[] strArr = (String[]) array;
                        if (strArr.length == 2) {
                            byte[] decode = Base64.decode(strArr[1], 0);
                            kotlin.jvm.internal.m.e(decode, "data");
                            String string = new JSONObject(new String(decode, Charsets.f25054b)).getString(TimeLineFollowFragment.BundleKeys.USER_ID);
                            kotlin.jvm.internal.m.e(string, "jsonObject.getString(\"user_id\")");
                            return string;
                        }
                        throw new FacebookException("Failed to retrieve user_id from signed_request");
                    }
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                }
            }
            throw new FacebookException("Authorization response does not contain the signed_request");
        }
    }

    public LoginMethodHandler(LoginClient loginClient) {
        kotlin.jvm.internal.m.f(loginClient, "loginClient");
        m(loginClient);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(String str, Object obj) {
        if (this.f9984g == null) {
            this.f9984g = new HashMap();
        }
        Map<String, String> map = this.f9984g;
        if (map == null) {
            return;
        }
        map.put(str, obj == null ? null : obj.toString());
    }

    public void b() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String c(String str) {
        kotlin.jvm.internal.m.f(str, "authId");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("0_auth_logger_id", str);
            jSONObject.put("3_method", f());
            l(jSONObject);
        } catch (JSONException e2) {
            Log.w("LoginMethodHandler", kotlin.jvm.internal.m.n("Error creating client state json: ", e2.getMessage()));
        }
        String jSONObject2 = jSONObject.toString();
        kotlin.jvm.internal.m.e(jSONObject2, "param.toString()");
        return jSONObject2;
    }

    public final LoginClient d() {
        LoginClient loginClient = this.f9985h;
        if (loginClient != null) {
            return loginClient;
        }
        kotlin.jvm.internal.m.w("loginClient");
        throw null;
    }

    public final Map<String, String> e() {
        return this.f9984g;
    }

    public abstract String f();

    /* JADX INFO: Access modifiers changed from: protected */
    public String g() {
        StringBuilder sb = new StringBuilder();
        sb.append("fb");
        com.facebook.a0 a0Var = com.facebook.a0.a;
        sb.append(com.facebook.a0.d());
        sb.append("://authorize/");
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void h(String str) {
        LoginClient.Request o = d().o();
        String a2 = o == null ? null : o.a();
        if (a2 == null) {
            com.facebook.a0 a0Var = com.facebook.a0.a;
            a2 = com.facebook.a0.d();
        }
        g0 g0Var = new g0(d().i(), a2);
        Bundle bundle = new Bundle();
        bundle.putString("fb_web_login_e2e", str);
        bundle.putLong("fb_web_login_switchback_time", System.currentTimeMillis());
        bundle.putString(RateAndReviewsFragment.BundleCons.APP_ID, a2);
        g0Var.h("fb_dialogs_web_login_dialog_complete", null, bundle);
    }

    public boolean i() {
        return false;
    }

    public boolean j(int i2, int i3, Intent intent) {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Bundle k(LoginClient.Request request, Bundle bundle) throws FacebookException {
        GraphRequest a2;
        kotlin.jvm.internal.m.f(request, "request");
        kotlin.jvm.internal.m.f(bundle, "values");
        String string = bundle.getString("code");
        p0 p0Var = p0.a;
        if (p0.a0(string)) {
            throw new FacebookException("No code param found from the request");
        }
        if (string == null) {
            a2 = null;
        } else {
            b0 b0Var = b0.a;
            String g2 = g();
            String f2 = request.f();
            if (f2 == null) {
                f2 = HttpUrl.FRAGMENT_ENCODE_SET;
            }
            a2 = b0.a(string, g2, f2);
        }
        if (a2 != null) {
            d0 j2 = a2.j();
            FacebookRequestError b2 = j2.b();
            if (b2 == null) {
                try {
                    JSONObject c2 = j2.c();
                    String string2 = c2 != null ? c2.getString("access_token") : null;
                    if (c2 != null && !p0.a0(string2)) {
                        bundle.putString("access_token", string2);
                        if (c2.has("id_token")) {
                            bundle.putString("id_token", c2.getString("id_token"));
                        }
                        return bundle;
                    }
                    throw new FacebookException("No access token found from result");
                } catch (JSONException e2) {
                    throw new FacebookException(kotlin.jvm.internal.m.n("Fail to process code exchange response: ", e2.getMessage()));
                }
            }
            throw new FacebookServiceException(b2, b2.c());
        }
        throw new FacebookException("Failed to create code exchange request");
    }

    public void l(JSONObject jSONObject) throws JSONException {
        kotlin.jvm.internal.m.f(jSONObject, "param");
    }

    public final void m(LoginClient loginClient) {
        kotlin.jvm.internal.m.f(loginClient, "<set-?>");
        this.f9985h = loginClient;
    }

    public boolean n() {
        return false;
    }

    public abstract int o(LoginClient.Request request);

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        kotlin.jvm.internal.m.f(parcel, "dest");
        p0 p0Var = p0.a;
        p0.H0(parcel, this.f9984g);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public LoginMethodHandler(Parcel parcel) {
        kotlin.jvm.internal.m.f(parcel, "source");
        p0 p0Var = p0.a;
        Map<String, String> t0 = p0.t0(parcel);
        this.f9984g = t0 == null ? null : q0.u(t0);
    }
}
