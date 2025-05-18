package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@zzard
/* loaded from: classes2.dex */
final class ka {
    private final ArrayList<zzsa> a = new ArrayList<>();

    /* renamed from: b, reason: collision with root package name */
    private long f12858b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(zzsa zzsaVar) {
        this.a.add(zzsaVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final long b() {
        Iterator<zzsa> it = this.a.iterator();
        while (it.hasNext()) {
            Map<String, List<String>> b2 = it.next().b();
            if (b2 != null) {
                for (Map.Entry<String, List<String>> entry : b2.entrySet()) {
                    try {
                        if ("content-length".equalsIgnoreCase(entry.getKey())) {
                            this.f12858b = Math.max(this.f12858b, Long.parseLong(entry.getValue().get(0)));
                        }
                    } catch (RuntimeException unused) {
                    }
                }
                it.remove();
            }
        }
        return this.f12858b;
    }
}
