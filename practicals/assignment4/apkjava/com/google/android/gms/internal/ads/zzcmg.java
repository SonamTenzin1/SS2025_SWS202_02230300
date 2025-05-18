package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;

/* loaded from: classes2.dex */
public final class zzcmg implements zzcka<zzbyn, zzaov, zzcla> {
    private final Context a;

    /* renamed from: b */
    private final zzbxo f15383b;

    /* renamed from: c */
    private zzang f15384c;

    public zzcmg(Context context, zzbxo zzbxoVar) {
        this.a = context;
        this.f15383b = zzbxoVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcka
    public final /* synthetic */ zzbyn a(zzcxu zzcxuVar, zzcxm zzcxmVar, zzcjy<zzaov, zzcla> zzcjyVar) throws RemoteException, zzcmw {
        if (zzcxuVar.a.a.f15753g.contains(Integer.toString(6))) {
            zzbyt J = zzbyt.J(this.f15384c);
            if (zzcxuVar.a.a.f15753g.contains(Integer.toString(J.w()))) {
                zzbyw b2 = this.f15383b.b(new zzbpr(zzcxuVar, zzcxmVar, zzcjyVar.a), new zzbzf(J), new zzcag(null, null, this.f15384c));
                zzcjyVar.f15314c.i7(b2.f());
                return b2.g();
            }
            throw new zzcmw("No corresponding native ad listener", 0);
        }
        throw new zzcmw("Unified must be used for RTB.", 1);
    }

    @Override // com.google.android.gms.internal.ads.zzcka
    public final void b(zzcxu zzcxuVar, zzcxm zzcxmVar, zzcjy<zzaov, zzcla> zzcjyVar) throws RemoteException {
        zzcjyVar.f15313b.g4(zzcxmVar.K, zzcxmVar.s.toString(), zzcxuVar.a.a.f15750d, ObjectWrapper.E0(this.a), new ml(this, zzcjyVar), zzcjyVar.f15314c);
    }
}
