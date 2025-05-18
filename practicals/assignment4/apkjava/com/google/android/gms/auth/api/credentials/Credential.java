package com.google.android.gms.auth.api.credentials;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import cm.aptoide.pt.dataprovider.BuildConfig;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Collections;
import java.util.List;

@SafeParcelable.Class
@SafeParcelable.Reserved
/* loaded from: classes2.dex */
public class Credential extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<Credential> CREATOR = new zzc();

    /* renamed from: f, reason: collision with root package name */
    @SafeParcelable.Field
    private final String f11450f;

    /* renamed from: g, reason: collision with root package name */
    @SafeParcelable.Field
    private final String f11451g;

    /* renamed from: h, reason: collision with root package name */
    @SafeParcelable.Field
    private final Uri f11452h;

    /* renamed from: i, reason: collision with root package name */
    @SafeParcelable.Field
    private final List<IdToken> f11453i;

    /* renamed from: j, reason: collision with root package name */
    @SafeParcelable.Field
    private final String f11454j;

    /* renamed from: k, reason: collision with root package name */
    @SafeParcelable.Field
    private final String f11455k;

    @SafeParcelable.Field
    private final String l;

    @SafeParcelable.Field
    private final String m;

    /* loaded from: classes2.dex */
    public static class Builder {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public Credential(@SafeParcelable.Param(id = 1) String str, @SafeParcelable.Param(id = 2) String str2, @SafeParcelable.Param(id = 3) Uri uri, @SafeParcelable.Param(id = 4) List<IdToken> list, @SafeParcelable.Param(id = 5) String str3, @SafeParcelable.Param(id = 6) String str4, @SafeParcelable.Param(id = 9) String str5, @SafeParcelable.Param(id = 10) String str6) {
        List<IdToken> unmodifiableList;
        String trim = ((String) Preconditions.l(str, "credential identifier cannot be null")).trim();
        Preconditions.h(trim, "credential identifier cannot be empty");
        if (str3 != null && TextUtils.isEmpty(str3)) {
            throw new IllegalArgumentException("Password must not be empty if set");
        }
        if (str4 != null) {
            boolean z = false;
            if (!TextUtils.isEmpty(str4)) {
                Uri parse = Uri.parse(str4);
                if (parse.isAbsolute() && parse.isHierarchical() && !TextUtils.isEmpty(parse.getScheme()) && !TextUtils.isEmpty(parse.getAuthority()) && ("http".equalsIgnoreCase(parse.getScheme()) || BuildConfig.APTOIDE_WEB_SERVICES_SCHEME.equalsIgnoreCase(parse.getScheme()))) {
                    z = true;
                }
            }
            if (!Boolean.valueOf(z).booleanValue()) {
                throw new IllegalArgumentException("Account type must be a valid Http/Https URI");
            }
        }
        if (!TextUtils.isEmpty(str4) && !TextUtils.isEmpty(str3)) {
            throw new IllegalArgumentException("Password and AccountType are mutually exclusive");
        }
        if (str2 != null && TextUtils.isEmpty(str2.trim())) {
            str2 = null;
        }
        this.f11451g = str2;
        this.f11452h = uri;
        if (list == null) {
            unmodifiableList = Collections.emptyList();
        } else {
            unmodifiableList = Collections.unmodifiableList(list);
        }
        this.f11453i = unmodifiableList;
        this.f11450f = trim;
        this.f11454j = str3;
        this.f11455k = str4;
        this.l = str5;
        this.m = str6;
    }

    public Uri J0() {
        return this.f11452h;
    }

    public String W() {
        return this.l;
    }

    public String Y() {
        return this.f11450f;
    }

    public List<IdToken> e0() {
        return this.f11453i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Credential)) {
            return false;
        }
        Credential credential = (Credential) obj;
        return TextUtils.equals(this.f11450f, credential.f11450f) && TextUtils.equals(this.f11451g, credential.f11451g) && Objects.a(this.f11452h, credential.f11452h) && TextUtils.equals(this.f11454j, credential.f11454j) && TextUtils.equals(this.f11455k, credential.f11455k);
    }

    public int hashCode() {
        return Objects.b(this.f11450f, this.f11451g, this.f11452h, this.f11454j, this.f11455k);
    }

    public String i0() {
        return this.f11451g;
    }

    public String p0() {
        return this.f11454j;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        int a = SafeParcelWriter.a(parcel);
        SafeParcelWriter.u(parcel, 1, Y(), false);
        SafeParcelWriter.u(parcel, 2, i0(), false);
        SafeParcelWriter.s(parcel, 3, J0(), i2, false);
        SafeParcelWriter.y(parcel, 4, e0(), false);
        SafeParcelWriter.u(parcel, 5, p0(), false);
        SafeParcelWriter.u(parcel, 6, y(), false);
        SafeParcelWriter.u(parcel, 9, W(), false);
        SafeParcelWriter.u(parcel, 10, z(), false);
        SafeParcelWriter.b(parcel, a);
    }

    public String y() {
        return this.f11455k;
    }

    public String z() {
        return this.m;
    }
}
