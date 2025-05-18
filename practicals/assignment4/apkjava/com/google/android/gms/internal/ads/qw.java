package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: Add missing generic type declarations: [V, K] */
/* loaded from: classes2.dex */
final class qw<K, V> implements Iterator<Map.Entry<K, V>> {

    /* renamed from: f, reason: collision with root package name */
    private int f13242f;

    /* renamed from: g, reason: collision with root package name */
    private Iterator<Map.Entry<K, V>> f13243g;

    /* renamed from: h, reason: collision with root package name */
    private final /* synthetic */ ow f13244h;

    private qw(ow owVar) {
        List list;
        this.f13244h = owVar;
        list = owVar.f13121g;
        this.f13242f = list.size();
    }

    private final Iterator<Map.Entry<K, V>> b() {
        Map map;
        if (this.f13243g == null) {
            map = this.f13244h.f13125k;
            this.f13243g = map.entrySet().iterator();
        }
        return this.f13243g;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        List list;
        int i2 = this.f13242f;
        if (i2 > 0) {
            list = this.f13244h.f13121g;
            if (i2 <= list.size()) {
                return true;
            }
        }
        return b().hasNext();
    }

    @Override // java.util.Iterator
    public final /* synthetic */ Object next() {
        List list;
        if (!b().hasNext()) {
            list = this.f13244h.f13121g;
            int i2 = this.f13242f - 1;
            this.f13242f = i2;
            return (Map.Entry) list.get(i2);
        }
        return b().next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ qw(ow owVar, pw pwVar) {
        this(owVar);
    }
}
