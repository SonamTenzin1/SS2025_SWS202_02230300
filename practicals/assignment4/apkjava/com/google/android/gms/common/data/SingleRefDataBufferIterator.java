package com.google.android.gms.common.data;

import com.google.android.gms.common.annotation.KeepForSdk;
import java.util.NoSuchElementException;

@KeepForSdk
/* loaded from: classes2.dex */
public class SingleRefDataBufferIterator<T> extends DataBufferIterator<T> {

    /* renamed from: h, reason: collision with root package name */
    private T f11922h;

    @Override // com.google.android.gms.common.data.DataBufferIterator, java.util.Iterator
    public T next() {
        if (hasNext()) {
            int i2 = this.f11904g + 1;
            this.f11904g = i2;
            if (i2 == 0) {
                T t = this.f11903f.get(0);
                this.f11922h = t;
                if (!(t instanceof DataBufferRef)) {
                    String valueOf = String.valueOf(this.f11922h.getClass());
                    StringBuilder sb = new StringBuilder(valueOf.length() + 44);
                    sb.append("DataBuffer reference of type ");
                    sb.append(valueOf);
                    sb.append(" is not movable");
                    throw new IllegalStateException(sb.toString());
                }
            } else {
                ((DataBufferRef) this.f11922h).a(i2);
            }
            return this.f11922h;
        }
        int i3 = this.f11904g;
        StringBuilder sb2 = new StringBuilder(46);
        sb2.append("Cannot advance the iterator beyond ");
        sb2.append(i3);
        throw new NoSuchElementException(sb2.toString());
    }
}
