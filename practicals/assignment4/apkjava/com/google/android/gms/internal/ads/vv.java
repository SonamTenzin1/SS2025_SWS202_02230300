package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.Map;

/* loaded from: classes2.dex */
final class vv implements uv {
    @Override // com.google.android.gms.internal.ads.uv
    public final Object a(Object obj, Object obj2) {
        zzdpe zzdpeVar = (zzdpe) obj;
        zzdpe zzdpeVar2 = (zzdpe) obj2;
        if (!zzdpeVar2.isEmpty()) {
            if (!zzdpeVar.b()) {
                zzdpeVar = zzdpeVar.i();
            }
            zzdpeVar.d(zzdpeVar2);
        }
        return zzdpeVar;
    }

    @Override // com.google.android.gms.internal.ads.uv
    public final Map<?, ?> b(Object obj) {
        return (zzdpe) obj;
    }

    @Override // com.google.android.gms.internal.ads.uv
    public final boolean c(Object obj) {
        return !((zzdpe) obj).b();
    }

    @Override // com.google.android.gms.internal.ads.uv
    public final Object d(Object obj) {
        ((zzdpe) obj).f();
        return obj;
    }

    @Override // com.google.android.gms.internal.ads.uv
    public final Object e(Object obj) {
        return zzdpe.h().i();
    }

    @Override // com.google.android.gms.internal.ads.uv
    public final int f(int i2, Object obj, Object obj2) {
        zzdpe zzdpeVar = (zzdpe) obj;
        if (zzdpeVar.isEmpty()) {
            return 0;
        }
        Iterator it = zzdpeVar.entrySet().iterator();
        if (!it.hasNext()) {
            return 0;
        }
        Map.Entry entry = (Map.Entry) it.next();
        entry.getKey();
        entry.getValue();
        throw new NoSuchMethodError();
    }

    @Override // com.google.android.gms.internal.ads.uv
    public final tv<?, ?> g(Object obj) {
        throw new NoSuchMethodError();
    }

    @Override // com.google.android.gms.internal.ads.uv
    public final Map<?, ?> h(Object obj) {
        return (zzdpe) obj;
    }
}
