package com.google.android.gms.common.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@KeepForSdk
/* loaded from: classes2.dex */
public class DataBufferSafeParcelable<T extends SafeParcelable> extends AbstractDataBuffer<T> {

    /* renamed from: g, reason: collision with root package name */
    private static final String[] f11907g = {"data"};

    /* renamed from: h, reason: collision with root package name */
    private final Parcelable.Creator<T> f11908h;

    @Override // com.google.android.gms.common.data.AbstractDataBuffer, com.google.android.gms.common.data.DataBuffer
    @KeepForSdk
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public T get(int i2) {
        DataHolder dataHolder = this.f11896f;
        byte[] y = dataHolder.y("data", i2, dataHolder.e0(i2));
        Parcel obtain = Parcel.obtain();
        obtain.unmarshall(y, 0, y.length);
        obtain.setDataPosition(0);
        T createFromParcel = this.f11908h.createFromParcel(obtain);
        obtain.recycle();
        return createFromParcel;
    }
}
