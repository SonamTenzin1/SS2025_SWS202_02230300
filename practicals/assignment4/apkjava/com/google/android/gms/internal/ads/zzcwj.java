package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;

/* loaded from: classes2.dex */
public final class zzcwj implements zzcva<zzcwi> {
    private zzawe a;

    /* renamed from: b, reason: collision with root package name */
    private zzbbl f15705b;

    /* renamed from: c, reason: collision with root package name */
    private String f15706c;

    public zzcwj(zzawe zzaweVar, zzbbl zzbblVar, String str) {
        this.a = zzaweVar;
        this.f15705b = zzbblVar;
        this.f15706c = str;
    }

    @Override // com.google.android.gms.internal.ads.zzcva
    public final zzbbh<zzcwi> b() {
        new zzbbr();
        final zzbbh<String> o = zzbar.o(null);
        if (((Boolean) zzyt.e().c(zzacu.E4)).booleanValue()) {
            o = this.a.a(this.f15706c);
        }
        final zzbbh<String> b2 = this.a.b(this.f15706c);
        return zzbar.a(o, b2).a(new Callable(o, b2) { // from class: com.google.android.gms.internal.ads.op

            /* renamed from: f, reason: collision with root package name */
            private final zzbbh f13113f;

            /* renamed from: g, reason: collision with root package name */
            private final zzbbh f13114g;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f13113f = o;
                this.f13114g = b2;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return new zzcwi((String) this.f13113f.get(), (String) this.f13114g.get());
            }
        }, zzaxg.a);
    }
}
