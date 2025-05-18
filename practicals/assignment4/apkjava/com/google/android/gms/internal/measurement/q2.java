package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.2.0 */
/* loaded from: classes2.dex */
final class q2<K> implements Iterator<Map.Entry<K, Object>> {

    /* renamed from: f, reason: collision with root package name */
    private Iterator<Map.Entry<K, Object>> f17245f;

    public q2(Iterator<Map.Entry<K, Object>> it) {
        this.f17245f = it;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f17245f.hasNext();
    }

    @Override // java.util.Iterator
    public final /* synthetic */ Object next() {
        Map.Entry<K, Object> next = this.f17245f.next();
        return next.getValue() instanceof zzfp ? new o2(next) : next;
    }

    @Override // java.util.Iterator
    public final void remove() {
        this.f17245f.remove();
    }
}
