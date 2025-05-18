package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzk;
import java.util.Set;
import java.util.concurrent.Callable;

/* loaded from: classes2.dex */
public final class zzctw implements zzcva<zzctv> {
    private final zzbbl a;

    /* renamed from: b, reason: collision with root package name */
    private final Context f15624b;

    /* renamed from: c, reason: collision with root package name */
    private final Set<String> f15625c;

    public zzctw(zzbbl zzbblVar, Context context, Set<String> set) {
        this.a = zzbblVar;
        this.f15624b = context;
        this.f15625c = set;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzctv a() throws Exception {
        boolean b2;
        if (((Boolean) zzyt.e().c(zzacu.b4)).booleanValue()) {
            b2 = zzctv.b(this.f15625c);
            if (b2) {
                return new zzctv(zzk.zzlv().a(this.f15624b));
            }
        }
        return new zzctv(null);
    }

    @Override // com.google.android.gms.internal.ads.zzcva
    public final zzbbh<zzctv> b() {
        return this.a.submit(new Callable(this) { // from class: com.google.android.gms.internal.ads.oo

            /* renamed from: f, reason: collision with root package name */
            private final zzctw f13112f;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f13112f = this;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f13112f.a();
            }
        });
    }
}
