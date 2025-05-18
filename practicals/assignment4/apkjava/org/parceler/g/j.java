package org.parceler.g;

import android.os.Parcel;
import java.util.Map;

/* compiled from: MapParcelConverter.java */
/* loaded from: classes3.dex */
public abstract class j<K, V, M extends Map<K, V>> implements org.parceler.f<Map<K, V>, M> {
    public abstract M c();

    @Override // org.parceler.f
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public M a(Parcel parcel) {
        int readInt = parcel.readInt();
        if (readInt == -1) {
            return null;
        }
        M c2 = c();
        for (int i2 = 0; i2 < readInt; i2++) {
            c2.put(e(parcel), g(parcel));
        }
        return c2;
    }

    public abstract K e(Parcel parcel);

    public abstract void f(K k2, Parcel parcel);

    public abstract V g(Parcel parcel);

    public abstract void h(V v, Parcel parcel);

    @Override // org.parceler.f
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public void b(Map<K, V> map, Parcel parcel) {
        if (map == null) {
            parcel.writeInt(-1);
            return;
        }
        parcel.writeInt(map.size());
        for (Map.Entry<K, V> entry : map.entrySet()) {
            f(entry.getKey(), parcel);
            h(entry.getValue(), parcel);
        }
    }
}
