package com.facebook;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import cm.aptoide.pt.DeepLinkIntentReceiver;
import com.facebook.AccessToken;
import com.facebook.internal.p0;
import com.facebook.internal.q0;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Profile.kt */
/* loaded from: classes.dex */
public final class Profile implements Parcelable {

    /* renamed from: h, reason: collision with root package name */
    private final String f9638h;

    /* renamed from: i, reason: collision with root package name */
    private final String f9639i;

    /* renamed from: j, reason: collision with root package name */
    private final String f9640j;

    /* renamed from: k, reason: collision with root package name */
    private final String f9641k;
    private final String l;
    private final Uri m;
    private final Uri n;

    /* renamed from: f, reason: collision with root package name */
    public static final b f9636f = new b(null);

    /* renamed from: g, reason: collision with root package name */
    private static final String f9637g = Profile.class.getSimpleName();
    public static final Parcelable.Creator<Profile> CREATOR = new a();

    /* compiled from: Profile.kt */
    /* loaded from: classes.dex */
    public static final class a implements Parcelable.Creator<Profile> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Profile createFromParcel(Parcel parcel) {
            kotlin.jvm.internal.m.f(parcel, "source");
            return new Profile(parcel, null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Profile[] newArray(int i2) {
            return new Profile[i2];
        }
    }

    /* compiled from: Profile.kt */
    /* loaded from: classes.dex */
    public static final class b {

        /* compiled from: Profile.kt */
        /* loaded from: classes.dex */
        public static final class a implements p0.a {
            a() {
            }

            @Override // com.facebook.internal.p0.a
            public void a(JSONObject jSONObject) {
                String optString = jSONObject == null ? null : jSONObject.optString(DeepLinkIntentReceiver.DeepLinksKeys.ID);
                if (optString == null) {
                    Log.w(Profile.f9637g, "No user ID returned on Me request");
                    return;
                }
                String optString2 = jSONObject.optString("link");
                String optString3 = jSONObject.optString("profile_picture", null);
                Profile.f9636f.c(new Profile(optString, jSONObject.optString("first_name"), jSONObject.optString("middle_name"), jSONObject.optString("last_name"), jSONObject.optString("name"), optString2 != null ? Uri.parse(optString2) : null, optString3 != null ? Uri.parse(optString3) : null));
            }

            @Override // com.facebook.internal.p0.a
            public void b(FacebookException facebookException) {
                Log.e(Profile.f9637g, kotlin.jvm.internal.m.n("Got unexpected exception: ", facebookException));
            }
        }

        private b() {
        }

        public /* synthetic */ b(kotlin.jvm.internal.g gVar) {
            this();
        }

        public final void a() {
            AccessToken.c cVar = AccessToken.f9559f;
            AccessToken e2 = cVar.e();
            if (e2 == null) {
                return;
            }
            if (!cVar.g()) {
                c(null);
            } else {
                p0 p0Var = p0.a;
                p0.E(e2.l(), new a());
            }
        }

        public final Profile b() {
            return i0.a.a().c();
        }

        public final void c(Profile profile) {
            i0.a.a().f(profile);
        }
    }

    public /* synthetic */ Profile(Parcel parcel, kotlin.jvm.internal.g gVar) {
        this(parcel);
    }

    public Profile(String str, String str2, String str3, String str4, String str5, Uri uri, Uri uri2) {
        q0 q0Var = q0.a;
        q0.k(str, DeepLinkIntentReceiver.DeepLinksKeys.ID);
        this.f9638h = str;
        this.f9639i = str2;
        this.f9640j = str3;
        this.f9641k = str4;
        this.l = str5;
        this.m = uri;
        this.n = uri2;
    }

    public final JSONObject b() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(DeepLinkIntentReceiver.DeepLinksKeys.ID, this.f9638h);
            jSONObject.put("first_name", this.f9639i);
            jSONObject.put("middle_name", this.f9640j);
            jSONObject.put("last_name", this.f9641k);
            jSONObject.put("name", this.l);
            Uri uri = this.m;
            if (uri != null) {
                jSONObject.put("link_uri", uri.toString());
            }
            Uri uri2 = this.n;
            if (uri2 != null) {
                jSONObject.put("picture_uri", uri2.toString());
            }
            return jSONObject;
        } catch (JSONException unused) {
            return null;
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        String str;
        String str2;
        String str3;
        String str4;
        Uri uri;
        Uri uri2;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Profile)) {
            return false;
        }
        String str5 = this.f9638h;
        return ((str5 == null && ((Profile) obj).f9638h == null) || kotlin.jvm.internal.m.a(str5, ((Profile) obj).f9638h)) && (((str = this.f9639i) == null && ((Profile) obj).f9639i == null) || kotlin.jvm.internal.m.a(str, ((Profile) obj).f9639i)) && ((((str2 = this.f9640j) == null && ((Profile) obj).f9640j == null) || kotlin.jvm.internal.m.a(str2, ((Profile) obj).f9640j)) && ((((str3 = this.f9641k) == null && ((Profile) obj).f9641k == null) || kotlin.jvm.internal.m.a(str3, ((Profile) obj).f9641k)) && ((((str4 = this.l) == null && ((Profile) obj).l == null) || kotlin.jvm.internal.m.a(str4, ((Profile) obj).l)) && ((((uri = this.m) == null && ((Profile) obj).m == null) || kotlin.jvm.internal.m.a(uri, ((Profile) obj).m)) && (((uri2 = this.n) == null && ((Profile) obj).n == null) || kotlin.jvm.internal.m.a(uri2, ((Profile) obj).n))))));
    }

    public int hashCode() {
        String str = this.f9638h;
        int hashCode = 527 + (str != null ? str.hashCode() : 0);
        String str2 = this.f9639i;
        if (str2 != null) {
            hashCode = (hashCode * 31) + str2.hashCode();
        }
        String str3 = this.f9640j;
        if (str3 != null) {
            hashCode = (hashCode * 31) + str3.hashCode();
        }
        String str4 = this.f9641k;
        if (str4 != null) {
            hashCode = (hashCode * 31) + str4.hashCode();
        }
        String str5 = this.l;
        if (str5 != null) {
            hashCode = (hashCode * 31) + str5.hashCode();
        }
        Uri uri = this.m;
        if (uri != null) {
            hashCode = (hashCode * 31) + uri.hashCode();
        }
        Uri uri2 = this.n;
        return uri2 != null ? (hashCode * 31) + uri2.hashCode() : hashCode;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        kotlin.jvm.internal.m.f(parcel, "dest");
        parcel.writeString(this.f9638h);
        parcel.writeString(this.f9639i);
        parcel.writeString(this.f9640j);
        parcel.writeString(this.f9641k);
        parcel.writeString(this.l);
        Uri uri = this.m;
        parcel.writeString(uri == null ? null : uri.toString());
        Uri uri2 = this.n;
        parcel.writeString(uri2 != null ? uri2.toString() : null);
    }

    public Profile(JSONObject jSONObject) {
        kotlin.jvm.internal.m.f(jSONObject, "jsonObject");
        this.f9638h = jSONObject.optString(DeepLinkIntentReceiver.DeepLinksKeys.ID, null);
        this.f9639i = jSONObject.optString("first_name", null);
        this.f9640j = jSONObject.optString("middle_name", null);
        this.f9641k = jSONObject.optString("last_name", null);
        this.l = jSONObject.optString("name", null);
        String optString = jSONObject.optString("link_uri", null);
        this.m = optString == null ? null : Uri.parse(optString);
        String optString2 = jSONObject.optString("picture_uri", null);
        this.n = optString2 != null ? Uri.parse(optString2) : null;
    }

    private Profile(Parcel parcel) {
        this.f9638h = parcel.readString();
        this.f9639i = parcel.readString();
        this.f9640j = parcel.readString();
        this.f9641k = parcel.readString();
        this.l = parcel.readString();
        String readString = parcel.readString();
        this.m = readString == null ? null : Uri.parse(readString);
        String readString2 = parcel.readString();
        this.n = readString2 != null ? Uri.parse(readString2) : null;
    }
}
