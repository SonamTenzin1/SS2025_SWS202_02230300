package com.facebook.login;

import android.content.Context;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import cm.aptoide.pt.install.installer.RootCommandOnSubscribe;
import com.facebook.AccessToken;
import com.facebook.AuthenticationToken;
import com.facebook.CustomTabMainActivity;
import com.facebook.FacebookException;
import com.facebook.internal.p0;
import com.facebook.internal.t;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import kotlin.collections.q0;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: LoginClient.kt */
/* loaded from: classes2.dex */
public class LoginClient implements Parcelable {

    /* renamed from: g, reason: collision with root package name */
    private LoginMethodHandler[] f9961g;

    /* renamed from: h, reason: collision with root package name */
    private int f9962h;

    /* renamed from: i, reason: collision with root package name */
    private Fragment f9963i;

    /* renamed from: j, reason: collision with root package name */
    private d f9964j;

    /* renamed from: k, reason: collision with root package name */
    private a f9965k;
    private boolean l;
    private Request m;
    private Map<String, String> n;
    private Map<String, String> o;
    private w p;
    private int q;
    private int r;

    /* renamed from: f, reason: collision with root package name */
    public static final c f9960f = new c(null);
    public static final Parcelable.Creator<LoginClient> CREATOR = new b();

    /* compiled from: LoginClient.kt */
    /* loaded from: classes2.dex */
    public static final class Result implements Parcelable {

        /* renamed from: g, reason: collision with root package name */
        public final a f9973g;

        /* renamed from: h, reason: collision with root package name */
        public final AccessToken f9974h;

        /* renamed from: i, reason: collision with root package name */
        public final AuthenticationToken f9975i;

        /* renamed from: j, reason: collision with root package name */
        public final String f9976j;

        /* renamed from: k, reason: collision with root package name */
        public final String f9977k;
        public final Request l;
        public Map<String, String> m;
        public Map<String, String> n;

        /* renamed from: f, reason: collision with root package name */
        public static final c f9972f = new c(null);
        public static final Parcelable.Creator<Result> CREATOR = new b();

        /* compiled from: LoginClient.kt */
        /* loaded from: classes2.dex */
        public enum a {
            SUCCESS(RootCommandOnSubscribe.SUCCESS_OUTPUT_CONFIRMATION),
            CANCEL("cancel"),
            ERROR("error");


            /* renamed from: j, reason: collision with root package name */
            private final String f9982j;

            a(String str) {
                this.f9982j = str;
            }

            /* renamed from: values, reason: to resolve conflict with enum method */
            public static a[] valuesCustom() {
                a[] valuesCustom = values();
                return (a[]) Arrays.copyOf(valuesCustom, valuesCustom.length);
            }

            public final String k() {
                return this.f9982j;
            }
        }

        /* compiled from: LoginClient.kt */
        /* loaded from: classes2.dex */
        public static final class b implements Parcelable.Creator<Result> {
            b() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Result createFromParcel(Parcel parcel) {
                kotlin.jvm.internal.m.f(parcel, "source");
                return new Result(parcel, null);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public Result[] newArray(int i2) {
                return new Result[i2];
            }
        }

        /* compiled from: LoginClient.kt */
        /* loaded from: classes2.dex */
        public static final class c {
            private c() {
            }

            public /* synthetic */ c(kotlin.jvm.internal.g gVar) {
                this();
            }

            public static /* synthetic */ Result d(c cVar, Request request, String str, String str2, String str3, int i2, Object obj) {
                if ((i2 & 8) != 0) {
                    str3 = null;
                }
                return cVar.c(request, str, str2, str3);
            }

            public final Result a(Request request, String str) {
                return new Result(request, a.CANCEL, null, str, null);
            }

            public final Result b(Request request, AccessToken accessToken, AuthenticationToken authenticationToken) {
                return new Result(request, a.SUCCESS, accessToken, authenticationToken, null, null);
            }

            public final Result c(Request request, String str, String str2, String str3) {
                ArrayList arrayList = new ArrayList();
                if (str != null) {
                    arrayList.add(str);
                }
                if (str2 != null) {
                    arrayList.add(str2);
                }
                return new Result(request, a.ERROR, null, TextUtils.join(": ", arrayList), str3);
            }

            public final Result e(Request request, AccessToken accessToken) {
                kotlin.jvm.internal.m.f(accessToken, "token");
                return new Result(request, a.SUCCESS, accessToken, null, null);
            }
        }

        public /* synthetic */ Result(Parcel parcel, kotlin.jvm.internal.g gVar) {
            this(parcel);
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Result(Request request, a aVar, AccessToken accessToken, String str, String str2) {
            this(request, aVar, accessToken, null, str, str2);
            kotlin.jvm.internal.m.f(aVar, "code");
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            kotlin.jvm.internal.m.f(parcel, "dest");
            parcel.writeString(this.f9973g.name());
            parcel.writeParcelable(this.f9974h, i2);
            parcel.writeParcelable(this.f9975i, i2);
            parcel.writeString(this.f9976j);
            parcel.writeString(this.f9977k);
            parcel.writeParcelable(this.l, i2);
            p0 p0Var = p0.a;
            p0.G0(parcel, this.m);
            p0.G0(parcel, this.n);
        }

        public Result(Request request, a aVar, AccessToken accessToken, AuthenticationToken authenticationToken, String str, String str2) {
            kotlin.jvm.internal.m.f(aVar, "code");
            this.l = request;
            this.f9974h = accessToken;
            this.f9975i = authenticationToken;
            this.f9976j = str;
            this.f9973g = aVar;
            this.f9977k = str2;
        }

        private Result(Parcel parcel) {
            String readString = parcel.readString();
            this.f9973g = a.valueOf(readString == null ? "error" : readString);
            this.f9974h = (AccessToken) parcel.readParcelable(AccessToken.class.getClassLoader());
            this.f9975i = (AuthenticationToken) parcel.readParcelable(AuthenticationToken.class.getClassLoader());
            this.f9976j = parcel.readString();
            this.f9977k = parcel.readString();
            this.l = (Request) parcel.readParcelable(Request.class.getClassLoader());
            p0 p0Var = p0.a;
            this.m = p0.r0(parcel);
            this.n = p0.r0(parcel);
        }
    }

    /* compiled from: LoginClient.kt */
    /* loaded from: classes2.dex */
    public interface a {
        void a();

        void b();
    }

    /* compiled from: LoginClient.kt */
    /* loaded from: classes2.dex */
    public static final class b implements Parcelable.Creator<LoginClient> {
        b() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public LoginClient createFromParcel(Parcel parcel) {
            kotlin.jvm.internal.m.f(parcel, "source");
            return new LoginClient(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public LoginClient[] newArray(int i2) {
            return new LoginClient[i2];
        }
    }

    /* compiled from: LoginClient.kt */
    /* loaded from: classes2.dex */
    public static final class c {
        private c() {
        }

        public /* synthetic */ c(kotlin.jvm.internal.g gVar) {
            this();
        }

        public final String a() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("init", System.currentTimeMillis());
            } catch (JSONException unused) {
            }
            String jSONObject2 = jSONObject.toString();
            kotlin.jvm.internal.m.e(jSONObject2, "e2e.toString()");
            return jSONObject2;
        }

        public final int b() {
            return t.c.Login.k();
        }
    }

    /* compiled from: LoginClient.kt */
    /* loaded from: classes2.dex */
    public interface d {
        void a(Result result);
    }

    public LoginClient(Fragment fragment) {
        kotlin.jvm.internal.m.f(fragment, "fragment");
        this.f9962h = -1;
        w(fragment);
    }

    private final void a(String str, String str2, boolean z) {
        Map<String, String> map = this.n;
        if (map == null) {
            map = new HashMap<>();
        }
        if (this.n == null) {
            this.n = map;
        }
        if (map.containsKey(str) && z) {
            str2 = ((Object) map.get(str)) + ',' + str2;
        }
        map.put(str, str2);
    }

    private final void h() {
        f(Result.c.d(Result.f9972f, this.m, "Login attempt failed.", null, null, 8, null));
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0016, code lost:
    
        if (kotlin.jvm.internal.m.a(r1, r2 == null ? null : r2.a()) == false) goto L10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final w n() {
        String a2;
        w wVar = this.p;
        if (wVar != null) {
            String a3 = wVar.a();
            Request request = this.m;
        }
        Context i2 = i();
        if (i2 == null) {
            com.facebook.a0 a0Var = com.facebook.a0.a;
            i2 = com.facebook.a0.c();
        }
        Request request2 = this.m;
        if (request2 == null) {
            com.facebook.a0 a0Var2 = com.facebook.a0.a;
            a2 = com.facebook.a0.d();
        } else {
            a2 = request2.a();
        }
        wVar = new w(i2, a2);
        this.p = wVar;
        return wVar;
    }

    private final void p(String str, Result result, Map<String, String> map) {
        q(str, result.f9973g.k(), result.f9976j, result.f9977k, map);
    }

    private final void q(String str, String str2, String str3, String str4, Map<String, String> map) {
        Request request = this.m;
        if (request == null) {
            n().j("fb_mobile_login_method_complete", "Unexpected call to logCompleteLogin with null pendingAuthorizationRequest.", str);
        } else {
            n().c(request.b(), str, str2, str3, str4, map, request.q() ? "foa_mobile_login_method_complete" : "fb_mobile_login_method_complete");
        }
    }

    private final void t(Result result) {
        d dVar = this.f9964j;
        if (dVar == null) {
            return;
        }
        dVar.a(result);
    }

    public final void B() {
        LoginMethodHandler j2 = j();
        if (j2 != null) {
            q(j2.f(), "skipped", null, null, j2.e());
        }
        LoginMethodHandler[] loginMethodHandlerArr = this.f9961g;
        while (loginMethodHandlerArr != null) {
            int i2 = this.f9962h;
            if (i2 >= loginMethodHandlerArr.length - 1) {
                break;
            }
            this.f9962h = i2 + 1;
            if (z()) {
                return;
            }
        }
        if (this.m != null) {
            h();
        }
    }

    public final void C(Result result) {
        Result b2;
        kotlin.jvm.internal.m.f(result, "pendingResult");
        if (result.f9974h != null) {
            AccessToken e2 = AccessToken.f9559f.e();
            AccessToken accessToken = result.f9974h;
            if (e2 != null) {
                try {
                    if (kotlin.jvm.internal.m.a(e2.m(), accessToken.m())) {
                        b2 = Result.f9972f.b(this.m, result.f9974h, result.f9975i);
                        f(b2);
                        return;
                    }
                } catch (Exception e3) {
                    f(Result.c.d(Result.f9972f, this.m, "Caught exception", e3.getMessage(), null, 8, null));
                    return;
                }
            }
            b2 = Result.c.d(Result.f9972f, this.m, "User logged in as different Facebook user.", null, null, 8, null);
            f(b2);
            return;
        }
        throw new FacebookException("Can't validate without a token");
    }

    public final void b(Request request) {
        if (request == null) {
            return;
        }
        if (this.m == null) {
            if (!AccessToken.f9559f.g() || d()) {
                this.m = request;
                this.f9961g = l(request);
                B();
                return;
            }
            return;
        }
        throw new FacebookException("Attempted to authorize while a request is pending.");
    }

    public final void c() {
        LoginMethodHandler j2 = j();
        if (j2 == null) {
            return;
        }
        j2.b();
    }

    public final boolean d() {
        if (this.l) {
            return true;
        }
        if (e("android.permission.INTERNET") != 0) {
            androidx.fragment.app.d i2 = i();
            f(Result.c.d(Result.f9972f, this.m, i2 == null ? null : i2.getString(com.facebook.common.d.f9682c), i2 != null ? i2.getString(com.facebook.common.d.f9681b) : null, null, 8, null));
            return false;
        }
        this.l = true;
        return true;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final int e(String str) {
        kotlin.jvm.internal.m.f(str, "permission");
        androidx.fragment.app.d i2 = i();
        if (i2 == null) {
            return -1;
        }
        return i2.checkCallingOrSelfPermission(str);
    }

    public final void f(Result result) {
        kotlin.jvm.internal.m.f(result, "outcome");
        LoginMethodHandler j2 = j();
        if (j2 != null) {
            p(j2.f(), result, j2.e());
        }
        Map<String, String> map = this.n;
        if (map != null) {
            result.m = map;
        }
        Map<String, String> map2 = this.o;
        if (map2 != null) {
            result.n = map2;
        }
        this.f9961g = null;
        this.f9962h = -1;
        this.m = null;
        this.n = null;
        this.q = 0;
        this.r = 0;
        t(result);
    }

    public final void g(Result result) {
        kotlin.jvm.internal.m.f(result, "outcome");
        if (result.f9974h != null && AccessToken.f9559f.g()) {
            C(result);
        } else {
            f(result);
        }
    }

    public final androidx.fragment.app.d i() {
        Fragment fragment = this.f9963i;
        if (fragment == null) {
            return null;
        }
        return fragment.getActivity();
    }

    public final LoginMethodHandler j() {
        LoginMethodHandler[] loginMethodHandlerArr;
        int i2 = this.f9962h;
        if (i2 < 0 || (loginMethodHandlerArr = this.f9961g) == null) {
            return null;
        }
        return loginMethodHandlerArr[i2];
    }

    public final Fragment k() {
        return this.f9963i;
    }

    public LoginMethodHandler[] l(Request request) {
        kotlin.jvm.internal.m.f(request, "request");
        ArrayList arrayList = new ArrayList();
        t j2 = request.j();
        if (request.r()) {
            if (!com.facebook.a0.s && j2.v()) {
                arrayList.add(new InstagramAppLoginMethodHandler(this));
            }
        } else {
            if (j2.u()) {
                arrayList.add(new GetTokenLoginMethodHandler(this));
            }
            if (!com.facebook.a0.s && j2.x()) {
                arrayList.add(new KatanaProxyLoginMethodHandler(this));
            }
        }
        if (j2.k()) {
            arrayList.add(new CustomTabLoginMethodHandler(this));
        }
        if (j2.y()) {
            arrayList.add(new WebViewLoginMethodHandler(this));
        }
        if (!request.r() && j2.q()) {
            arrayList.add(new DeviceAuthMethodHandler(this));
        }
        Object[] array = arrayList.toArray(new LoginMethodHandler[0]);
        if (array != null) {
            return (LoginMethodHandler[]) array;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    }

    public final boolean m() {
        return this.m != null && this.f9962h >= 0;
    }

    public final Request o() {
        return this.m;
    }

    public final void r() {
        a aVar = this.f9965k;
        if (aVar == null) {
            return;
        }
        aVar.a();
    }

    public final void s() {
        a aVar = this.f9965k;
        if (aVar == null) {
            return;
        }
        aVar.b();
    }

    public final boolean u(int i2, int i3, Intent intent) {
        this.q++;
        if (this.m != null) {
            if (intent != null && intent.getBooleanExtra(CustomTabMainActivity.m, false)) {
                B();
                return false;
            }
            LoginMethodHandler j2 = j();
            if (j2 != null && (!j2.n() || intent != null || this.q >= this.r)) {
                return j2.j(i2, i3, intent);
            }
        }
        return false;
    }

    public final void v(a aVar) {
        this.f9965k = aVar;
    }

    public final void w(Fragment fragment) {
        if (this.f9963i == null) {
            this.f9963i = fragment;
            return;
        }
        throw new FacebookException("Can't set fragment once it is already set.");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        kotlin.jvm.internal.m.f(parcel, "dest");
        parcel.writeParcelableArray(this.f9961g, i2);
        parcel.writeInt(this.f9962h);
        parcel.writeParcelable(this.m, i2);
        p0 p0Var = p0.a;
        p0.G0(parcel, this.n);
        p0.G0(parcel, this.o);
    }

    public final void x(d dVar) {
        this.f9964j = dVar;
    }

    public final void y(Request request) {
        if (m()) {
            return;
        }
        b(request);
    }

    public final boolean z() {
        LoginMethodHandler j2 = j();
        if (j2 == null) {
            return false;
        }
        if (j2.i() && !d()) {
            a("no_internet_permission", "1", false);
            return false;
        }
        Request request = this.m;
        if (request == null) {
            return false;
        }
        int o = j2.o(request);
        this.q = 0;
        if (o > 0) {
            n().e(request.b(), j2.f(), request.q() ? "foa_mobile_login_method_start" : "fb_mobile_login_method_start");
            this.r = o;
        } else {
            n().d(request.b(), j2.f(), request.q() ? "foa_mobile_login_method_not_tried" : "fb_mobile_login_method_not_tried");
            a("not_tried", j2.f(), true);
        }
        return o > 0;
    }

    public LoginClient(Parcel parcel) {
        kotlin.jvm.internal.m.f(parcel, "source");
        this.f9962h = -1;
        Parcelable[] readParcelableArray = parcel.readParcelableArray(LoginMethodHandler.class.getClassLoader());
        readParcelableArray = readParcelableArray == null ? new Parcelable[0] : readParcelableArray;
        ArrayList arrayList = new ArrayList();
        int length = readParcelableArray.length;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                break;
            }
            Parcelable parcelable = readParcelableArray[i2];
            LoginMethodHandler loginMethodHandler = parcelable instanceof LoginMethodHandler ? (LoginMethodHandler) parcelable : null;
            if (loginMethodHandler != null) {
                loginMethodHandler.m(this);
            }
            if (loginMethodHandler != null) {
                arrayList.add(loginMethodHandler);
            }
            i2++;
        }
        Object[] array = arrayList.toArray(new LoginMethodHandler[0]);
        if (array != null) {
            this.f9961g = (LoginMethodHandler[]) array;
            this.f9962h = parcel.readInt();
            this.m = (Request) parcel.readParcelable(Request.class.getClassLoader());
            p0 p0Var = p0.a;
            Map<String, String> r0 = p0.r0(parcel);
            this.n = r0 == null ? null : q0.u(r0);
            Map<String, String> r02 = p0.r0(parcel);
            this.o = r02 != null ? q0.u(r02) : null;
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    }

    /* compiled from: LoginClient.kt */
    /* loaded from: classes2.dex */
    public static final class Request implements Parcelable {

        /* renamed from: g, reason: collision with root package name */
        private final t f9967g;

        /* renamed from: h, reason: collision with root package name */
        private Set<String> f9968h;

        /* renamed from: i, reason: collision with root package name */
        private final r f9969i;

        /* renamed from: j, reason: collision with root package name */
        private final String f9970j;

        /* renamed from: k, reason: collision with root package name */
        private String f9971k;
        private boolean l;
        private String m;
        private String n;
        private String o;
        private String p;
        private boolean q;
        private final z r;
        private boolean s;
        private boolean t;
        private final String u;
        private final String v;
        private final String w;
        private final p x;

        /* renamed from: f, reason: collision with root package name */
        public static final b f9966f = new b(null);
        public static final Parcelable.Creator<Request> CREATOR = new a();

        /* compiled from: LoginClient.kt */
        /* loaded from: classes2.dex */
        public static final class a implements Parcelable.Creator<Request> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Request createFromParcel(Parcel parcel) {
                kotlin.jvm.internal.m.f(parcel, "source");
                return new Request(parcel, null);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public Request[] newArray(int i2) {
                return new Request[i2];
            }
        }

        /* compiled from: LoginClient.kt */
        /* loaded from: classes2.dex */
        public static final class b {
            private b() {
            }

            public /* synthetic */ b(kotlin.jvm.internal.g gVar) {
                this();
            }
        }

        public /* synthetic */ Request(Parcel parcel, kotlin.jvm.internal.g gVar) {
            this(parcel);
        }

        public Request(t tVar, Set<String> set, r rVar, String str, String str2, String str3, z zVar, String str4, String str5, String str6, p pVar) {
            kotlin.jvm.internal.m.f(tVar, "loginBehavior");
            kotlin.jvm.internal.m.f(rVar, "defaultAudience");
            kotlin.jvm.internal.m.f(str, "authType");
            kotlin.jvm.internal.m.f(str2, "applicationId");
            kotlin.jvm.internal.m.f(str3, "authId");
            this.f9967g = tVar;
            this.f9968h = set == null ? new HashSet<>() : set;
            this.f9969i = rVar;
            this.n = str;
            this.f9970j = str2;
            this.f9971k = str3;
            this.r = zVar == null ? z.FACEBOOK : zVar;
            if (str4 != null) {
                if (!(str4.length() == 0)) {
                    this.u = str4;
                    this.v = str5;
                    this.w = str6;
                    this.x = pVar;
                }
            }
            String uuid = UUID.randomUUID().toString();
            kotlin.jvm.internal.m.e(uuid, "randomUUID().toString()");
            this.u = uuid;
            this.v = str5;
            this.w = str6;
            this.x = pVar;
        }

        public final String a() {
            return this.f9970j;
        }

        public final String b() {
            return this.f9971k;
        }

        public final String c() {
            return this.n;
        }

        public final String d() {
            return this.w;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public final p e() {
            return this.x;
        }

        public final String f() {
            return this.v;
        }

        public final r g() {
            return this.f9969i;
        }

        public final String h() {
            return this.o;
        }

        public final String i() {
            return this.m;
        }

        public final t j() {
            return this.f9967g;
        }

        public final z k() {
            return this.r;
        }

        public final String l() {
            return this.p;
        }

        public final String m() {
            return this.u;
        }

        public final Set<String> n() {
            return this.f9968h;
        }

        public final boolean o() {
            return this.q;
        }

        public final boolean p() {
            Iterator<String> it = this.f9968h.iterator();
            while (it.hasNext()) {
                if (x.a.e(it.next())) {
                    return true;
                }
            }
            return false;
        }

        public final boolean q() {
            return this.s;
        }

        public final boolean r() {
            return this.r == z.INSTAGRAM;
        }

        public final boolean s() {
            return this.l;
        }

        public final void t(boolean z) {
            this.s = z;
        }

        public final void u(String str) {
            this.p = str;
        }

        public final void v(Set<String> set) {
            kotlin.jvm.internal.m.f(set, "<set-?>");
            this.f9968h = set;
        }

        public final void w(boolean z) {
            this.l = z;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            kotlin.jvm.internal.m.f(parcel, "dest");
            parcel.writeString(this.f9967g.name());
            parcel.writeStringList(new ArrayList(this.f9968h));
            parcel.writeString(this.f9969i.name());
            parcel.writeString(this.f9970j);
            parcel.writeString(this.f9971k);
            parcel.writeByte(this.l ? (byte) 1 : (byte) 0);
            parcel.writeString(this.m);
            parcel.writeString(this.n);
            parcel.writeString(this.o);
            parcel.writeString(this.p);
            parcel.writeByte(this.q ? (byte) 1 : (byte) 0);
            parcel.writeString(this.r.name());
            parcel.writeByte(this.s ? (byte) 1 : (byte) 0);
            parcel.writeByte(this.t ? (byte) 1 : (byte) 0);
            parcel.writeString(this.u);
            parcel.writeString(this.v);
            parcel.writeString(this.w);
            p pVar = this.x;
            parcel.writeString(pVar == null ? null : pVar.name());
        }

        public final void x(boolean z) {
            this.q = z;
        }

        public final void y(boolean z) {
            this.t = z;
        }

        public final boolean z() {
            return this.t;
        }

        private Request(Parcel parcel) {
            r rVar;
            z zVar;
            com.facebook.internal.q0 q0Var = com.facebook.internal.q0.a;
            this.f9967g = t.valueOf(com.facebook.internal.q0.k(parcel.readString(), "loginBehavior"));
            ArrayList arrayList = new ArrayList();
            parcel.readStringList(arrayList);
            this.f9968h = new HashSet(arrayList);
            String readString = parcel.readString();
            if (readString != null) {
                rVar = r.valueOf(readString);
            } else {
                rVar = r.NONE;
            }
            this.f9969i = rVar;
            this.f9970j = com.facebook.internal.q0.k(parcel.readString(), "applicationId");
            this.f9971k = com.facebook.internal.q0.k(parcel.readString(), "authId");
            this.l = parcel.readByte() != 0;
            this.m = parcel.readString();
            this.n = com.facebook.internal.q0.k(parcel.readString(), "authType");
            this.o = parcel.readString();
            this.p = parcel.readString();
            this.q = parcel.readByte() != 0;
            String readString2 = parcel.readString();
            if (readString2 != null) {
                zVar = z.valueOf(readString2);
            } else {
                zVar = z.FACEBOOK;
            }
            this.r = zVar;
            this.s = parcel.readByte() != 0;
            this.t = parcel.readByte() != 0;
            this.u = com.facebook.internal.q0.k(parcel.readString(), "nonce");
            this.v = parcel.readString();
            this.w = parcel.readString();
            String readString3 = parcel.readString();
            this.x = readString3 == null ? null : p.valueOf(readString3);
        }
    }
}
