package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: Add missing generic type declarations: [V, K] */
/* compiled from: com.google.android.gms:play-services-measurement-base@@17.2.0 */
/* loaded from: classes2.dex */
final class w3<K, V> implements Iterator<Map.Entry<K, V>> {

    /* renamed from: f, reason: collision with root package name */
    private int f17278f;

    /* renamed from: g, reason: collision with root package name */
    private Iterator<Map.Entry<K, V>> f17279g;

    /* renamed from: h, reason: collision with root package name */
    private final /* synthetic */ u3 f17280h;

    private w3(u3 u3Var) {
        List list;
        this.f17280h = u3Var;
        list = u3Var.f17264g;
        this.f17278f = list.size();
    }

    private final Iterator<Map.Entry<K, V>> b() {
        Map map;
        if (this.f17279g == null) {
            map = this.f17280h.f17268k;
            this.f17279g = map.entrySet().iterator();
        }
        return this.f17279g;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        List list;
        int i2 = this.f17278f;
        if (i2 > 0) {
            list = this.f17280h.f17264g;
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
            list = this.f17280h.f17264g;
            int i2 = this.f17278f - 1;
            this.f17278f = i2;
            return (Map.Entry) list.get(i2);
        }
        return b().next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ w3(u3 u3Var, t3 t3Var) {
        this(u3Var);
    }
}
