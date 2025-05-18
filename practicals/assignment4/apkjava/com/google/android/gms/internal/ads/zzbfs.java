package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzk;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@zzard
/* loaded from: classes2.dex */
public final class zzbfs implements Iterable<zzbfq> {

    /* renamed from: f, reason: collision with root package name */
    private final List<zzbfq> f14429f = new ArrayList();

    public static boolean g(zzbdf zzbdfVar) {
        zzbfq h2 = h(zzbdfVar);
        if (h2 == null) {
            return false;
        }
        h2.f14426b.b();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzbfq h(zzbdf zzbdfVar) {
        Iterator<zzbfq> it = zzk.zzmc().iterator();
        while (it.hasNext()) {
            zzbfq next = it.next();
            if (next.a == zzbdfVar) {
                return next;
            }
        }
        return null;
    }

    public final void c(zzbfq zzbfqVar) {
        this.f14429f.add(zzbfqVar);
    }

    public final void f(zzbfq zzbfqVar) {
        this.f14429f.remove(zzbfqVar);
    }

    @Override // java.lang.Iterable
    public final Iterator<zzbfq> iterator() {
        return this.f14429f.iterator();
    }
}
