package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingQueue;

/* loaded from: classes2.dex */
public final class uy implements o30 {
    private final Map<String, List<zzr<?>>> a = new HashMap();

    /* renamed from: b */
    private final zzd f13411b;

    public uy(zzd zzdVar) {
        this.f13411b = zzdVar;
    }

    public final synchronized boolean d(zzr<?> zzrVar) {
        String M = zzrVar.M();
        if (this.a.containsKey(M)) {
            List<zzr<?>> list = this.a.get(M);
            if (list == null) {
                list = new ArrayList<>();
            }
            zzrVar.I("waiting-for-response");
            list.add(zzrVar);
            this.a.put(M, list);
            if (zzag.f13871b) {
                zzag.a("Request for cacheKey=%s is in flight, putting on hold.", M);
            }
            return true;
        }
        this.a.put(M, null);
        zzrVar.D(this);
        if (zzag.f13871b) {
            zzag.a("new request, sending to network %s", M);
        }
        return false;
    }

    @Override // com.google.android.gms.internal.ads.o30
    public final synchronized void a(zzr<?> zzrVar) {
        BlockingQueue blockingQueue;
        String M = zzrVar.M();
        List<zzr<?>> remove = this.a.remove(M);
        if (remove != null && !remove.isEmpty()) {
            if (zzag.f13871b) {
                zzag.c("%d waiting requests for cacheKey=%s; resend to network", Integer.valueOf(remove.size()), M);
            }
            zzr<?> remove2 = remove.remove(0);
            this.a.put(M, remove);
            remove2.D(this);
            try {
                blockingQueue = this.f13411b.f15812h;
                blockingQueue.put(remove2);
            } catch (InterruptedException e2) {
                zzag.b("Couldn't add request to queue. %s", e2.toString());
                Thread.currentThread().interrupt();
                this.f13411b.b();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.o30
    public final void b(zzr<?> zzrVar, zzy<?> zzyVar) {
        List<zzr<?>> remove;
        zzab zzabVar;
        zzc zzcVar = zzyVar.f16974b;
        if (zzcVar != null && !zzcVar.a()) {
            String M = zzrVar.M();
            synchronized (this) {
                remove = this.a.remove(M);
            }
            if (remove != null) {
                if (zzag.f13871b) {
                    zzag.c("Releasing %d waiting requests for cacheKey=%s.", Integer.valueOf(remove.size()), M);
                }
                for (zzr<?> zzrVar2 : remove) {
                    zzabVar = this.f13411b.f15814j;
                    zzabVar.c(zzrVar2, zzyVar);
                }
                return;
            }
            return;
        }
        a(zzrVar);
    }
}
