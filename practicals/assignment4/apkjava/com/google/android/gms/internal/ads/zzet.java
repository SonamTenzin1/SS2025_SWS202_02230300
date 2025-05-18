package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbp;
import java.util.concurrent.Callable;

/* loaded from: classes2.dex */
public final class zzet implements Callable {

    /* renamed from: f, reason: collision with root package name */
    private final zzdy f16212f;

    /* renamed from: g, reason: collision with root package name */
    private final zzbp.zza.C0176zza f16213g;

    public zzet(zzdy zzdyVar, zzbp.zza.C0176zza c0176zza) {
        this.f16212f = zzdyVar;
        this.f16213g = c0176zza;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // java.util.concurrent.Callable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final Void call() throws Exception {
        if (this.f16212f.A() != null) {
            this.f16212f.A().get();
        }
        zzbp.zza z = this.f16212f.z();
        if (z == null) {
            return null;
        }
        try {
            synchronized (this.f16213g) {
                zzbp.zza.C0176zza c0176zza = this.f16213g;
                byte[] g2 = z.g();
                c0176zza.l(g2, 0, g2.length, zzdno.e());
            }
            return null;
        } catch (zzdok unused) {
            return null;
        }
    }
}
