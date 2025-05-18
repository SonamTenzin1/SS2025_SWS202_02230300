package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: Add missing generic type declarations: [V, K] */
/* loaded from: classes2.dex */
final class ww<K, V> implements Iterator<Map.Entry<K, V>> {

    /* renamed from: f, reason: collision with root package name */
    private int f13523f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f13524g;

    /* renamed from: h, reason: collision with root package name */
    private Iterator<Map.Entry<K, V>> f13525h;

    /* renamed from: i, reason: collision with root package name */
    private final /* synthetic */ ow f13526i;

    private ww(ow owVar) {
        this.f13526i = owVar;
        this.f13523f = -1;
    }

    private final Iterator<Map.Entry<K, V>> b() {
        Map map;
        if (this.f13525h == null) {
            map = this.f13526i.f13122h;
            this.f13525h = map.entrySet().iterator();
        }
        return this.f13525h;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        List list;
        Map map;
        int i2 = this.f13523f + 1;
        list = this.f13526i.f13121g;
        if (i2 >= list.size()) {
            map = this.f13526i.f13122h;
            if (map.isEmpty() || !b().hasNext()) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.Iterator
    public final /* synthetic */ Object next() {
        List list;
        List list2;
        this.f13524g = true;
        int i2 = this.f13523f + 1;
        this.f13523f = i2;
        list = this.f13526i.f13121g;
        if (i2 < list.size()) {
            list2 = this.f13526i.f13121g;
            return (Map.Entry) list2.get(this.f13523f);
        }
        return b().next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        List list;
        if (this.f13524g) {
            this.f13524g = false;
            this.f13526i.k();
            int i2 = this.f13523f;
            list = this.f13526i.f13121g;
            if (i2 < list.size()) {
                ow owVar = this.f13526i;
                int i3 = this.f13523f;
                this.f13523f = i3 - 1;
                owVar.r(i3);
                return;
            }
            b().remove();
            return;
        }
        throw new IllegalStateException("remove() was called before next()");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ ww(ow owVar, pw pwVar) {
        this(owVar);
    }
}
