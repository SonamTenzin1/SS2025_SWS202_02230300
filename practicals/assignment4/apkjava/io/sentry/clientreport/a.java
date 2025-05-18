package io.sentry.clientreport;

import io.sentry.z0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import org.jetbrains.annotations.ApiStatus;

/* compiled from: AtomicClientReportStorage.java */
@ApiStatus.Internal
/* loaded from: classes2.dex */
final class a implements h {
    private final Map<c, AtomicLong> a;

    public a() {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        for (e eVar : e.values()) {
            for (z0 z0Var : z0.values()) {
                concurrentHashMap.put(new c(eVar.getReason(), z0Var.getCategory()), new AtomicLong(0L));
            }
        }
        this.a = Collections.unmodifiableMap(concurrentHashMap);
    }

    @Override // io.sentry.clientreport.h
    public List<f> a() {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<c, AtomicLong> entry : this.a.entrySet()) {
            Long valueOf = Long.valueOf(entry.getValue().getAndSet(0L));
            if (valueOf.longValue() > 0) {
                arrayList.add(new f(entry.getKey().b(), entry.getKey().a(), valueOf));
            }
        }
        return arrayList;
    }

    @Override // io.sentry.clientreport.h
    public void b(c cVar, Long l) {
        AtomicLong atomicLong = this.a.get(cVar);
        if (atomicLong != null) {
            atomicLong.addAndGet(l.longValue());
        }
    }
}
