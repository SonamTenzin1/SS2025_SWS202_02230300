package org.parceler.g;

import android.os.Parcel;

/* compiled from: CharArrayParcelConverter.java */
/* loaded from: classes3.dex */
public class c implements org.parceler.f {
    @Override // org.parceler.f
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public char[] a(Parcel parcel) {
        int readInt = parcel.readInt();
        if (readInt == -1) {
            return null;
        }
        char[] cArr = new char[readInt];
        parcel.readCharArray(cArr);
        return cArr;
    }

    @Override // org.parceler.f
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public void b(char[] cArr, Parcel parcel) {
        if (cArr == null) {
            parcel.writeInt(-1);
        } else {
            parcel.writeInt(cArr.length);
            parcel.writeCharArray(cArr);
        }
    }
}
