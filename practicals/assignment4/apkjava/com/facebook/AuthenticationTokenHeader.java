package com.facebook;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Base64;
import com.facebook.internal.q0;
import kotlin.text.Charsets;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: AuthenticationTokenHeader.kt */
/* loaded from: classes.dex */
public final class AuthenticationTokenHeader implements Parcelable {

    /* renamed from: g, reason: collision with root package name */
    private final String f9578g;

    /* renamed from: h, reason: collision with root package name */
    private final String f9579h;

    /* renamed from: i, reason: collision with root package name */
    private final String f9580i;

    /* renamed from: f, reason: collision with root package name */
    public static final b f9577f = new b(null);
    public static final Parcelable.Creator<AuthenticationTokenHeader> CREATOR = new a();

    /* compiled from: AuthenticationTokenHeader.kt */
    /* loaded from: classes.dex */
    public static final class a implements Parcelable.Creator<AuthenticationTokenHeader> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public AuthenticationTokenHeader createFromParcel(Parcel parcel) {
            kotlin.jvm.internal.m.f(parcel, "source");
            return new AuthenticationTokenHeader(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public AuthenticationTokenHeader[] newArray(int i2) {
            return new AuthenticationTokenHeader[i2];
        }
    }

    /* compiled from: AuthenticationTokenHeader.kt */
    /* loaded from: classes.dex */
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(kotlin.jvm.internal.g gVar) {
            this();
        }
    }

    public AuthenticationTokenHeader(String str) {
        kotlin.jvm.internal.m.f(str, "encodedHeaderString");
        if (b(str)) {
            byte[] decode = Base64.decode(str, 0);
            kotlin.jvm.internal.m.e(decode, "decodedBytes");
            JSONObject jSONObject = new JSONObject(new String(decode, Charsets.f25054b));
            String string = jSONObject.getString("alg");
            kotlin.jvm.internal.m.e(string, "jsonObj.getString(\"alg\")");
            this.f9578g = string;
            String string2 = jSONObject.getString("typ");
            kotlin.jvm.internal.m.e(string2, "jsonObj.getString(\"typ\")");
            this.f9579h = string2;
            String string3 = jSONObject.getString("kid");
            kotlin.jvm.internal.m.e(string3, "jsonObj.getString(\"kid\")");
            this.f9580i = string3;
            return;
        }
        throw new IllegalArgumentException("Invalid Header".toString());
    }

    private final boolean b(String str) {
        q0 q0Var = q0.a;
        q0.g(str, "encodedHeaderString");
        byte[] decode = Base64.decode(str, 0);
        kotlin.jvm.internal.m.e(decode, "decodedBytes");
        try {
            JSONObject jSONObject = new JSONObject(new String(decode, Charsets.f25054b));
            String optString = jSONObject.optString("alg");
            kotlin.jvm.internal.m.e(optString, "alg");
            boolean z = (optString.length() > 0) && kotlin.jvm.internal.m.a(optString, "RS256");
            String optString2 = jSONObject.optString("kid");
            kotlin.jvm.internal.m.e(optString2, "jsonObj.optString(\"kid\")");
            boolean z2 = optString2.length() > 0;
            String optString3 = jSONObject.optString("typ");
            kotlin.jvm.internal.m.e(optString3, "jsonObj.optString(\"typ\")");
            return z && z2 && (optString3.length() > 0);
        } catch (JSONException unused) {
            return false;
        }
    }

    public final String a() {
        return this.f9580i;
    }

    public final JSONObject c() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("alg", this.f9578g);
        jSONObject.put("typ", this.f9579h);
        jSONObject.put("kid", this.f9580i);
        return jSONObject;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AuthenticationTokenHeader)) {
            return false;
        }
        AuthenticationTokenHeader authenticationTokenHeader = (AuthenticationTokenHeader) obj;
        return kotlin.jvm.internal.m.a(this.f9578g, authenticationTokenHeader.f9578g) && kotlin.jvm.internal.m.a(this.f9579h, authenticationTokenHeader.f9579h) && kotlin.jvm.internal.m.a(this.f9580i, authenticationTokenHeader.f9580i);
    }

    public int hashCode() {
        return ((((527 + this.f9578g.hashCode()) * 31) + this.f9579h.hashCode()) * 31) + this.f9580i.hashCode();
    }

    public String toString() {
        String jSONObject = c().toString();
        kotlin.jvm.internal.m.e(jSONObject, "headerJsonObject.toString()");
        return jSONObject;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        kotlin.jvm.internal.m.f(parcel, "dest");
        parcel.writeString(this.f9578g);
        parcel.writeString(this.f9579h);
        parcel.writeString(this.f9580i);
    }

    public AuthenticationTokenHeader(Parcel parcel) {
        kotlin.jvm.internal.m.f(parcel, "parcel");
        String readString = parcel.readString();
        q0 q0Var = q0.a;
        this.f9578g = q0.k(readString, "alg");
        this.f9579h = q0.k(parcel.readString(), "typ");
        this.f9580i = q0.k(parcel.readString(), "kid");
    }
}
