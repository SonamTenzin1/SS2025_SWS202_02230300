package org.parceler.g;

import android.os.Parcel;
import java.util.Collection;
import java.util.Iterator;

/* compiled from: CollectionParcelConverter.java */
/* loaded from: classes3.dex */
public abstract class d<T, C extends Collection<T>> implements org.parceler.f<Collection<T>, C> {
    public abstract C c();

    @Override // org.parceler.f
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public C a(Parcel parcel) {
        int readInt = parcel.readInt();
        if (readInt == -1) {
            return null;
        }
        C c2 = c();
        for (int i2 = 0; i2 < readInt; i2++) {
            c2.add(e(parcel));
        }
        return c2;
    }

    public abstract T e(Parcel parcel);

    public abstract void f(T t, Parcel parcel);

    @Override // org.parceler.f
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public void b(Collection<T> collection, Parcel parcel) {
        if (collection == null) {
            parcel.writeInt(-1);
            return;
        }
        parcel.writeInt(collection.size());
        Iterator<T> it = collection.iterator();
        while (it.hasNext()) {
            f(it.next(), parcel);
        }
    }
}
