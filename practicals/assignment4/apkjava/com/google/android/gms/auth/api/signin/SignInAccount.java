package com.google.android.gms.auth.api.signin;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class
@SafeParcelable.Reserved
/* loaded from: classes2.dex */
public class SignInAccount extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<SignInAccount> CREATOR = new zzd();

    /* renamed from: f, reason: collision with root package name */
    @SafeParcelable.Field
    @Deprecated
    private String f11519f;

    /* renamed from: g, reason: collision with root package name */
    @SafeParcelable.Field
    private GoogleSignInAccount f11520g;

    /* renamed from: h, reason: collision with root package name */
    @SafeParcelable.Field
    @Deprecated
    private String f11521h;

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public SignInAccount(@SafeParcelable.Param(id = 4) String str, @SafeParcelable.Param(id = 7) GoogleSignInAccount googleSignInAccount, @SafeParcelable.Param(id = 8) String str2) {
        this.f11520g = googleSignInAccount;
        this.f11519f = Preconditions.h(str, "8.3 and 8.4 SDKs require non-null email");
        this.f11521h = Preconditions.h(str2, "8.3 and 8.4 SDKs require non-null userId");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        int a = SafeParcelWriter.a(parcel);
        SafeParcelWriter.u(parcel, 4, this.f11519f, false);
        SafeParcelWriter.s(parcel, 7, this.f11520g, i2, false);
        SafeParcelWriter.u(parcel, 8, this.f11521h, false);
        SafeParcelWriter.b(parcel, a);
    }

    public final GoogleSignInAccount x() {
        return this.f11520g;
    }
}
