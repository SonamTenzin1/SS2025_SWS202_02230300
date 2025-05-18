package org.parceler.g;

import android.os.Parcel;

/* compiled from: BooleanArrayParcelConverter.java */
/* loaded from: classes3.dex */
public class b implements org.parceler.f {
    @Override // org.parceler.f
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public boolean[] a(Parcel parcel) {
        int readInt = parcel.readInt();
        if (readInt == -1) {
            return null;
        }
        boolean[] zArr = new boolean[readInt];
        parcel.readBooleanArray(zArr);
        return zArr;
    }

    @Override // org.parceler.f
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public void b(boolean[] zArr, Parcel parcel) {
        if (zArr == null) {
            parcel.writeInt(-1);
        } else {
            parcel.writeInt(zArr.length);
            parcel.writeBooleanArray(zArr);
        }
    }
}
