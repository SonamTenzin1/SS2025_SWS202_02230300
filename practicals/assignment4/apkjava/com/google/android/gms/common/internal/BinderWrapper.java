package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.annotation.KeepName;

/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
@KeepForSdk
@KeepName
/* loaded from: classes2.dex */
public final class BinderWrapper implements Parcelable {
    public static final Parcelable.Creator<BinderWrapper> CREATOR = new l();

    /* renamed from: f, reason: collision with root package name */
    private IBinder f11941f;

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        parcel.writeStrongBinder(this.f11941f);
    }
}
