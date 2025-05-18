package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
final class em implements zzbvo {
    private final /* synthetic */ zzcxu a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ zzcxm f12535b;

    /* renamed from: c, reason: collision with root package name */
    private final /* synthetic */ zzcjy f12536c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ zzcnw f12537d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public em(zzcnw zzcnwVar, zzcxu zzcxuVar, zzcxm zzcxmVar, zzcjy zzcjyVar) {
        this.f12537d = zzcnwVar;
        this.a = zzcxuVar;
        this.f12535b = zzcxmVar;
        this.f12536c = zzcjyVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbvo
    public final void a(int i2) {
        String valueOf = String.valueOf(this.f12536c.a);
        zzbad.i(valueOf.length() != 0 ? "Fail to initialize adapter ".concat(valueOf) : new String("Fail to initialize adapter "));
    }

    @Override // com.google.android.gms.internal.ads.zzbvo
    public final void onInitializationSucceeded() {
        Executor executor;
        executor = this.f12537d.f15452b;
        final zzcxu zzcxuVar = this.a;
        final zzcxm zzcxmVar = this.f12535b;
        final zzcjy zzcjyVar = this.f12536c;
        executor.execute(new Runnable(this, zzcxuVar, zzcxmVar, zzcjyVar) { // from class: com.google.android.gms.internal.ads.fm

            /* renamed from: f, reason: collision with root package name */
            private final em f12596f;

            /* renamed from: g, reason: collision with root package name */
            private final zzcxu f12597g;

            /* renamed from: h, reason: collision with root package name */
            private final zzcxm f12598h;

            /* renamed from: i, reason: collision with root package name */
            private final zzcjy f12599i;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f12596f = this;
                this.f12597g = zzcxuVar;
                this.f12598h = zzcxmVar;
                this.f12599i = zzcjyVar;
            }

            @Override // java.lang.Runnable
            public final void run() {
                em emVar = this.f12596f;
                zzcxu zzcxuVar2 = this.f12597g;
                zzcxm zzcxmVar2 = this.f12598h;
                zzcjy zzcjyVar2 = this.f12599i;
                zzcnw zzcnwVar = emVar.f12537d;
                zzcnw.e(zzcxuVar2, zzcxmVar2, zzcjyVar2);
            }
        });
    }
}
