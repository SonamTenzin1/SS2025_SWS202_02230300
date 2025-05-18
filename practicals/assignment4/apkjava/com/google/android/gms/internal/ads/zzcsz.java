package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import java.util.concurrent.Callable;

/* loaded from: classes2.dex */
public final class zzcsz implements zzcva<zzcsy> {
    private final zzbbl a;

    /* renamed from: b, reason: collision with root package name */
    private final zzcxv f15614b;

    public zzcsz(zzbbl zzbblVar, zzcxv zzcxvVar) {
        this.a = zzbblVar;
        this.f15614b = zzcxvVar;
    }

    private static int c(zzzy zzzyVar) {
        long value;
        if (zzzyVar != null) {
            try {
                value = zzzyVar.getValue();
            } catch (RemoteException unused) {
                zzbad.i("Cannot get correlation id, default to 0.");
            }
            return (int) value;
        }
        value = 0;
        return (int) value;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzcsy a() throws Exception {
        return new zzcsy(c(this.f15614b.a), this.f15614b.f15750d);
    }

    @Override // com.google.android.gms.internal.ads.zzcva
    public final zzbbh<zzcsy> b() {
        return this.a.submit(new Callable(this) { // from class: com.google.android.gms.internal.ads.go

            /* renamed from: f, reason: collision with root package name */
            private final zzcsz f12656f;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f12656f = this;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f12656f.a();
            }
        });
    }
}
