package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.dynamic.ObjectWrapper;

/* loaded from: classes2.dex */
public final class zzckm implements zzcka<zzbnf, zzaov, zzcla> {
    private final Context a;

    /* renamed from: b */
    private final zzboc f15329b;

    /* renamed from: c */
    private View f15330c;

    public zzckm(Context context, zzboc zzbocVar) {
        this.a = context;
        this.f15329b = zzbocVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcka
    public final /* synthetic */ zzbnf a(zzcxu zzcxuVar, zzcxm zzcxmVar, zzcjy<zzaov, zzcla> zzcjyVar) throws RemoteException, zzcmw {
        zzboc zzbocVar = this.f15329b;
        zzbpr zzbprVar = new zzbpr(zzcxuVar, zzcxmVar, zzcjyVar.a);
        View view = this.f15330c;
        zzaov zzaovVar = zzcjyVar.f15313b;
        zzaovVar.getClass();
        zzbng a = zzbocVar.a(zzbprVar, new zzbnk(view, null, mk.a(zzaovVar), zzcxmVar.r.get(0)));
        a.i().Y(this.f15330c);
        zzcjyVar.f15314c.i7(a.f());
        return a.g();
    }

    @Override // com.google.android.gms.internal.ads.zzcka
    public final void b(zzcxu zzcxuVar, zzcxm zzcxmVar, zzcjy<zzaov, zzcla> zzcjyVar) throws RemoteException {
        zzcjyVar.f15313b.K4(zzcxmVar.K, zzcxmVar.s.toString(), zzcxuVar.a.a.f15750d, ObjectWrapper.E0(this.a), new ok(this, zzcjyVar), zzcjyVar.f15314c, zzcxuVar.a.a.f15751e);
    }
}
