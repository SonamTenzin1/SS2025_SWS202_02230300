package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzk;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
public class zzbts<ListenerT> {

    /* renamed from: f, reason: collision with root package name */
    private final Map<ListenerT, Executor> f14724f = new HashMap();

    /* JADX INFO: Access modifiers changed from: protected */
    public zzbts(Set<zzbuz<ListenerT>> set) {
        X(set);
    }

    private final synchronized void X(Set<zzbuz<ListenerT>> set) {
        Iterator<zzbuz<ListenerT>> it = set.iterator();
        while (it.hasNext()) {
            U(it.next());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final synchronized void T(final zzbtu<ListenerT> zzbtuVar) {
        for (Map.Entry<ListenerT, Executor> entry : this.f14724f.entrySet()) {
            final ListenerT key = entry.getKey();
            entry.getValue().execute(new Runnable(zzbtuVar, key) { // from class: com.google.android.gms.internal.ads.te

                /* renamed from: f, reason: collision with root package name */
                private final zzbtu f13352f;

                /* renamed from: g, reason: collision with root package name */
                private final Object f13353g;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.f13352f = zzbtuVar;
                    this.f13353g = key;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        this.f13352f.a(this.f13353g);
                    } catch (Throwable th) {
                        zzk.zzlk().h(th, "EventEmitter.notify");
                        zzawz.l("Event emitter exception.", th);
                    }
                }
            });
        }
    }

    public final synchronized void U(zzbuz<ListenerT> zzbuzVar) {
        V(zzbuzVar.a, zzbuzVar.f14744b);
    }

    public final synchronized void V(ListenerT listenert, Executor executor) {
        this.f14724f.put(listenert, executor);
    }
}
