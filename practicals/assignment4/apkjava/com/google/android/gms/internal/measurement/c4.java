package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: Add missing generic type declarations: [V, K] */
/* compiled from: com.google.android.gms:play-services-measurement-base@@17.2.0 */
/* loaded from: classes2.dex */
final class c4<K, V> implements Iterator<Map.Entry<K, V>> {

    /* renamed from: f, reason: collision with root package name */
    private int f17140f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f17141g;

    /* renamed from: h, reason: collision with root package name */
    private Iterator<Map.Entry<K, V>> f17142h;

    /* renamed from: i, reason: collision with root package name */
    private final /* synthetic */ u3 f17143i;

    private c4(u3 u3Var) {
        this.f17143i = u3Var;
        this.f17140f = -1;
    }

    private final Iterator<Map.Entry<K, V>> b() {
        Map map;
        if (this.f17142h == null) {
            map = this.f17143i.f17265h;
            this.f17142h = map.entrySet().iterator();
        }
        return this.f17142h;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        List list;
        Map map;
        int i2 = this.f17140f + 1;
        list = this.f17143i.f17264g;
        if (i2 >= list.size()) {
            map = this.f17143i.f17265h;
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
        this.f17141g = true;
        int i2 = this.f17140f + 1;
        this.f17140f = i2;
        list = this.f17143i.f17264g;
        if (i2 < list.size()) {
            list2 = this.f17143i.f17264g;
            return (Map.Entry) list2.get(this.f17140f);
        }
        return b().next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        List list;
        if (this.f17141g) {
            this.f17141g = false;
            this.f17143i.q();
            int i2 = this.f17140f;
            list = this.f17143i.f17264g;
            if (i2 < list.size()) {
                u3 u3Var = this.f17143i;
                int i3 = this.f17140f;
                this.f17140f = i3 - 1;
                u3Var.l(i3);
                return;
            }
            b().remove();
            return;
        }
        throw new IllegalStateException("remove() was called before next()");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ c4(u3 u3Var, t3 t3Var) {
        this(u3Var);
    }
}
