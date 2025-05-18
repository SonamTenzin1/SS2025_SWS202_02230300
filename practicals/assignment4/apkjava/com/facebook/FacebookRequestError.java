package com.facebook;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.internal.p0;
import java.net.HttpURLConnection;
import java.util.Arrays;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: FacebookRequestError.kt */
/* loaded from: classes.dex */
public final class FacebookRequestError implements Parcelable {

    /* renamed from: h, reason: collision with root package name */
    private final int f9607h;

    /* renamed from: i, reason: collision with root package name */
    private final int f9608i;

    /* renamed from: j, reason: collision with root package name */
    private final int f9609j;

    /* renamed from: k, reason: collision with root package name */
    private final String f9610k;
    private final String l;
    private final String m;
    private final JSONObject n;
    private final JSONObject o;
    private final Object p;
    private final HttpURLConnection q;
    private final String r;
    private FacebookException s;
    private final a t;
    private final String u;

    /* renamed from: f, reason: collision with root package name */
    public static final c f9605f = new c(null);

    /* renamed from: g, reason: collision with root package name */
    private static final d f9606g = new d(200, 299);
    public static final Parcelable.Creator<FacebookRequestError> CREATOR = new b();

    /* compiled from: FacebookRequestError.kt */
    /* loaded from: classes.dex */
    public enum a {
        LOGIN_RECOVERABLE,
        OTHER,
        TRANSIENT;

        /* renamed from: values, reason: to resolve conflict with enum method */
        public static a[] valuesCustom() {
            a[] valuesCustom = values();
            return (a[]) Arrays.copyOf(valuesCustom, valuesCustom.length);
        }
    }

    /* compiled from: FacebookRequestError.kt */
    /* loaded from: classes.dex */
    public static final class b implements Parcelable.Creator<FacebookRequestError> {
        b() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public FacebookRequestError createFromParcel(Parcel parcel) {
            kotlin.jvm.internal.m.f(parcel, "parcel");
            return new FacebookRequestError(parcel, (kotlin.jvm.internal.g) null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public FacebookRequestError[] newArray(int i2) {
            return new FacebookRequestError[i2];
        }
    }

    /* compiled from: FacebookRequestError.kt */
    /* loaded from: classes.dex */
    public static final class c {
        private c() {
        }

        public /* synthetic */ c(kotlin.jvm.internal.g gVar) {
            this();
        }

        /* JADX WARN: Removed duplicated region for block: B:30:0x00d1 A[Catch: JSONException -> 0x012f, TryCatch #0 {JSONException -> 0x012f, blocks: (B:3:0x0012, B:5:0x0018, B:7:0x0024, B:9:0x0028, B:12:0x0036, B:30:0x00d1, B:33:0x0079, B:34:0x0070, B:35:0x0066, B:36:0x005e, B:37:0x0057, B:38:0x004d, B:39:0x0043, B:40:0x0085, B:43:0x0092, B:45:0x009b, B:49:0x00ac, B:50:0x00f2, B:52:0x00fc, B:54:0x010a, B:55:0x0113), top: B:2:0x0012 }] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final FacebookRequestError a(JSONObject jSONObject, Object obj, HttpURLConnection httpURLConnection) {
            String optString;
            int optInt;
            String str;
            String str2;
            String str3;
            boolean z;
            String str4;
            kotlin.jvm.internal.m.f(jSONObject, "singleResult");
            try {
                if (jSONObject.has("code")) {
                    int i2 = jSONObject.getInt("code");
                    p0 p0Var = p0.a;
                    Object M = p0.M(jSONObject, "body", "FACEBOOK_NON_JSON_RESULT");
                    if (M != null && (M instanceof JSONObject)) {
                        boolean z2 = false;
                        int i3 = -1;
                        if (((JSONObject) M).has("error")) {
                            JSONObject jSONObject2 = (JSONObject) p0.M((JSONObject) M, "error", null);
                            optString = jSONObject2 == null ? null : jSONObject2.optString("type", null);
                            String optString2 = jSONObject2 == null ? null : jSONObject2.optString("message", null);
                            int optInt2 = jSONObject2 == null ? -1 : jSONObject2.optInt("code", -1);
                            if (jSONObject2 != null) {
                                i3 = jSONObject2.optInt("error_subcode", -1);
                            }
                            str2 = jSONObject2 == null ? null : jSONObject2.optString("error_user_msg", null);
                            str3 = jSONObject2 == null ? null : jSONObject2.optString("error_user_title", null);
                            if (jSONObject2 != null) {
                                z2 = jSONObject2.optBoolean("is_transient", false);
                            }
                            str = optString2;
                            z = z2;
                            optInt = i3;
                            z2 = true;
                            i3 = optInt2;
                        } else {
                            if (!((JSONObject) M).has("error_code") && !((JSONObject) M).has("error_msg") && !((JSONObject) M).has("error_reason")) {
                                str4 = null;
                                str = null;
                                str2 = null;
                                str3 = null;
                                optInt = -1;
                                z = false;
                                if (z2) {
                                    return new FacebookRequestError(i2, i3, optInt, str4, str, str3, str2, (JSONObject) M, jSONObject, obj, httpURLConnection, null, z, null);
                                }
                            }
                            optString = ((JSONObject) M).optString("error_reason", null);
                            String optString3 = ((JSONObject) M).optString("error_msg", null);
                            int optInt3 = ((JSONObject) M).optInt("error_code", -1);
                            optInt = ((JSONObject) M).optInt("error_subcode", -1);
                            i3 = optInt3;
                            str = optString3;
                            str2 = null;
                            str3 = null;
                            z2 = true;
                            z = false;
                        }
                        str4 = optString;
                        if (z2) {
                        }
                    }
                    if (!c().a(i2)) {
                        return new FacebookRequestError(i2, -1, -1, null, null, null, null, jSONObject.has("body") ? (JSONObject) p0.M(jSONObject, "body", "FACEBOOK_NON_JSON_RESULT") : null, jSONObject, obj, httpURLConnection, null, false, null);
                    }
                }
            } catch (JSONException unused) {
            }
            return null;
        }

        public final synchronized com.facebook.internal.x b() {
            com.facebook.internal.d0 d0Var = com.facebook.internal.d0.a;
            a0 a0Var = a0.a;
            com.facebook.internal.c0 c2 = com.facebook.internal.d0.c(a0.d());
            if (c2 == null) {
                return com.facebook.internal.x.a.b();
            }
            return c2.c();
        }

        public final d c() {
            return FacebookRequestError.f9606g;
        }
    }

    /* compiled from: FacebookRequestError.kt */
    /* loaded from: classes.dex */
    public static final class d {
        private final int a;

        /* renamed from: b, reason: collision with root package name */
        private final int f9615b;

        public d(int i2, int i3) {
            this.a = i2;
            this.f9615b = i3;
        }

        public final boolean a(int i2) {
            return i2 <= this.f9615b && this.a <= i2;
        }
    }

    private FacebookRequestError(int i2, int i3, int i4, String str, String str2, String str3, String str4, JSONObject jSONObject, JSONObject jSONObject2, Object obj, HttpURLConnection httpURLConnection, FacebookException facebookException, boolean z) {
        boolean z2;
        a c2;
        this.f9607h = i2;
        this.f9608i = i3;
        this.f9609j = i4;
        this.f9610k = str;
        this.l = str3;
        this.m = str4;
        this.n = jSONObject;
        this.o = jSONObject2;
        this.p = obj;
        this.q = httpURLConnection;
        this.r = str2;
        if (facebookException != null) {
            this.s = facebookException;
            z2 = true;
        } else {
            this.s = new FacebookServiceException(this, c());
            z2 = false;
        }
        if (z2) {
            c2 = a.OTHER;
        } else {
            c2 = f9605f.b().c(i3, i4, z);
        }
        this.t = c2;
        this.u = f9605f.b().d(c2);
    }

    public /* synthetic */ FacebookRequestError(int i2, int i3, int i4, String str, String str2, String str3, String str4, JSONObject jSONObject, JSONObject jSONObject2, Object obj, HttpURLConnection httpURLConnection, FacebookException facebookException, boolean z, kotlin.jvm.internal.g gVar) {
        this(i2, i3, i4, str, str2, str3, str4, jSONObject, jSONObject2, obj, httpURLConnection, facebookException, z);
    }

    public /* synthetic */ FacebookRequestError(Parcel parcel, kotlin.jvm.internal.g gVar) {
        this(parcel);
    }

    public final int b() {
        return this.f9608i;
    }

    public final String c() {
        String str = this.r;
        if (str != null) {
            return str;
        }
        FacebookException facebookException = this.s;
        if (facebookException == null) {
            return null;
        }
        return facebookException.getLocalizedMessage();
    }

    public final String d() {
        return this.f9610k;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final FacebookException e() {
        return this.s;
    }

    public final int f() {
        return this.f9607h;
    }

    public final int g() {
        return this.f9609j;
    }

    public String toString() {
        String str = "{HttpStatus: " + this.f9607h + ", errorCode: " + this.f9608i + ", subErrorCode: " + this.f9609j + ", errorType: " + this.f9610k + ", errorMessage: " + c() + "}";
        kotlin.jvm.internal.m.e(str, "StringBuilder(\"{HttpStatus: \")\n        .append(requestStatusCode)\n        .append(\", errorCode: \")\n        .append(errorCode)\n        .append(\", subErrorCode: \")\n        .append(subErrorCode)\n        .append(\", errorType: \")\n        .append(errorType)\n        .append(\", errorMessage: \")\n        .append(errorMessage)\n        .append(\"}\")\n        .toString()");
        return str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        kotlin.jvm.internal.m.f(parcel, "out");
        parcel.writeInt(this.f9607h);
        parcel.writeInt(this.f9608i);
        parcel.writeInt(this.f9609j);
        parcel.writeString(this.f9610k);
        parcel.writeString(c());
        parcel.writeString(this.l);
        parcel.writeString(this.m);
    }

    public FacebookRequestError(HttpURLConnection httpURLConnection, Exception exc) {
        this(-1, -1, -1, null, null, null, null, null, null, null, httpURLConnection, exc instanceof FacebookException ? (FacebookException) exc : new FacebookException(exc), false);
    }

    public FacebookRequestError(int i2, String str, String str2) {
        this(-1, i2, -1, str, str2, null, null, null, null, null, null, null, false);
    }

    private FacebookRequestError(Parcel parcel) {
        this(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), null, null, null, null, null, false);
    }
}
