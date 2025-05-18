package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* loaded from: classes2.dex */
public final class zzcfk implements zzczz {

    /* renamed from: g, reason: collision with root package name */
    private final zzcfi f15168g;

    /* renamed from: h, reason: collision with root package name */
    private final Clock f15169h;

    /* renamed from: f, reason: collision with root package name */
    private final Map<zzczs, Long> f15167f = new HashMap();

    /* renamed from: i, reason: collision with root package name */
    private final Map<zzczs, ii> f15170i = new HashMap();

    public zzcfk(zzcfi zzcfiVar, Set<ii> set, Clock clock) {
        zzczs zzczsVar;
        this.f15168g = zzcfiVar;
        for (ii iiVar : set) {
            Map<zzczs, ii> map = this.f15170i;
            zzczsVar = iiVar.f12769c;
            map.put(zzczsVar, iiVar);
        }
        this.f15169h = clock;
    }

    private final void a(zzczs zzczsVar, boolean z) {
        zzczs zzczsVar2;
        String str;
        zzczsVar2 = this.f15170i.get(zzczsVar).f12768b;
        String str2 = z ? "s." : "f.";
        if (this.f15167f.containsKey(zzczsVar2)) {
            long b2 = this.f15169h.b() - this.f15167f.get(zzczsVar2).longValue();
            Map<String, String> c2 = this.f15168g.c();
            str = this.f15170i.get(zzczsVar).a;
            String valueOf = String.valueOf(str);
            String concat = valueOf.length() != 0 ? "label.".concat(valueOf) : new String("label.");
            String valueOf2 = String.valueOf(Long.toString(b2));
            c2.put(concat, valueOf2.length() != 0 ? str2.concat(valueOf2) : new String(str2));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzczz
    public final void b(zzczs zzczsVar, String str, Throwable th) {
        if (this.f15167f.containsKey(zzczsVar)) {
            long b2 = this.f15169h.b() - this.f15167f.get(zzczsVar).longValue();
            Map<String, String> c2 = this.f15168g.c();
            String valueOf = String.valueOf(str);
            String concat = valueOf.length() != 0 ? "task.".concat(valueOf) : new String("task.");
            String valueOf2 = String.valueOf(Long.toString(b2));
            c2.put(concat, valueOf2.length() != 0 ? "f.".concat(valueOf2) : new String("f."));
        }
        if (this.f15170i.containsKey(zzczsVar)) {
            a(zzczsVar, false);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzczz
    public final void c(zzczs zzczsVar, String str) {
        if (this.f15167f.containsKey(zzczsVar)) {
            long b2 = this.f15169h.b() - this.f15167f.get(zzczsVar).longValue();
            Map<String, String> c2 = this.f15168g.c();
            String valueOf = String.valueOf(str);
            String concat = valueOf.length() != 0 ? "task.".concat(valueOf) : new String("task.");
            String valueOf2 = String.valueOf(Long.toString(b2));
            c2.put(concat, valueOf2.length() != 0 ? "s.".concat(valueOf2) : new String("s."));
        }
        if (this.f15170i.containsKey(zzczsVar)) {
            a(zzczsVar, true);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzczz
    public final void d(zzczs zzczsVar, String str) {
        this.f15167f.put(zzczsVar, Long.valueOf(this.f15169h.b()));
    }

    @Override // com.google.android.gms.internal.ads.zzczz
    public final void e(zzczs zzczsVar, String str) {
    }
}
