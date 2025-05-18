package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.dynamic.ObjectWrapper;

/* loaded from: classes2.dex */
public final class zzckj implements zzcka<zzbnf, zzams, zzcla> {
    private final Context a;

    /* renamed from: b, reason: collision with root package name */
    private final zzbai f15325b;

    /* renamed from: c, reason: collision with root package name */
    private final zzboc f15326c;

    public zzckj(Context context, zzbai zzbaiVar, zzboc zzbocVar) {
        this.a = context;
        this.f15325b = zzbaiVar;
        this.f15326c = zzbocVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcka
    public final /* synthetic */ zzbnf a(zzcxu zzcxuVar, zzcxm zzcxmVar, zzcjy<zzams, zzcla> zzcjyVar) throws RemoteException, zzcmw {
        zzboc zzbocVar = this.f15326c;
        zzbpr zzbprVar = new zzbpr(zzcxuVar, zzcxmVar, zzcjyVar.a);
        View view = (View) ObjectWrapper.k0(zzcjyVar.f15313b.x1());
        zzams zzamsVar = zzcjyVar.f15313b;
        zzamsVar.getClass();
        zzbng a = zzbocVar.a(zzbprVar, new zzbnk(view, null, lk.a(zzamsVar), zzcxmVar.r.get(0)));
        a.i().Y((View) ObjectWrapper.k0(zzcjyVar.f15313b.x1()));
        zzcjyVar.f15314c.i7(a.f());
        return a.g();
    }

    @Override // com.google.android.gms.internal.ads.zzcka
    public final void b(zzcxu zzcxuVar, zzcxm zzcxmVar, zzcjy<zzams, zzcla> zzcjyVar) throws RemoteException {
        zzyd a = zzcxy.a(this.a, zzcxmVar.r);
        if (this.f15325b.f14328h < 4100000) {
            zzcjyVar.f15313b.y2(ObjectWrapper.E0(this.a), a, zzcxuVar.a.a.f15750d, zzcxmVar.s.toString(), zzcjyVar.f15314c);
        } else {
            zzcjyVar.f15313b.s4(ObjectWrapper.E0(this.a), a, zzcxuVar.a.a.f15750d, zzcxmVar.s.toString(), zzazc.a(zzcxmVar.p), zzcjyVar.f15314c);
        }
    }
}
