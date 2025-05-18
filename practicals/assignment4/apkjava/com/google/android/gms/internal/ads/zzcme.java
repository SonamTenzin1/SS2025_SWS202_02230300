package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

/* loaded from: classes2.dex */
public final class zzcme implements zzcka<zzbyn, zzams, zzcla> {
    private final Context a;

    /* renamed from: b, reason: collision with root package name */
    private final zzbxo f15381b;

    public zzcme(Context context, zzbxo zzbxoVar) {
        this.a = context;
        this.f15381b = zzbxoVar;
    }

    private static boolean c(zzcxu zzcxuVar, int i2) {
        return zzcxuVar.a.a.f15753g.contains(Integer.toString(i2));
    }

    @Override // com.google.android.gms.internal.ads.zzcka
    public final /* synthetic */ zzbyn a(zzcxu zzcxuVar, zzcxm zzcxmVar, zzcjy<zzams, zzcla> zzcjyVar) throws RemoteException, zzcmw {
        zzbyt r;
        zzana b7 = zzcjyVar.f15313b.b7();
        zzand e6 = zzcjyVar.f15313b.e6();
        zzang P1 = zzcjyVar.f15313b.P1();
        if (P1 != null && c(zzcxuVar, 6)) {
            r = zzbyt.J(P1);
        } else if (b7 != null && c(zzcxuVar, 6)) {
            r = zzbyt.H(b7);
        } else if (b7 != null && c(zzcxuVar, 2)) {
            r = zzbyt.q(b7);
        } else if (e6 != null && c(zzcxuVar, 6)) {
            r = zzbyt.I(e6);
        } else if (e6 != null && c(zzcxuVar, 1)) {
            r = zzbyt.r(e6);
        } else {
            throw new zzcmw("No native ad mappers", 0);
        }
        if (zzcxuVar.a.a.f15753g.contains(Integer.toString(r.w()))) {
            zzbyw b2 = this.f15381b.b(new zzbpr(zzcxuVar, zzcxmVar, zzcjyVar.a), new zzbzf(r), new zzcag(e6, b7, P1));
            zzcjyVar.f15314c.i7(b2.f());
            return b2.g();
        }
        throw new zzcmw("No corresponding native ad listener", 0);
    }

    @Override // com.google.android.gms.internal.ads.zzcka
    public final void b(zzcxu zzcxuVar, zzcxm zzcxmVar, zzcjy<zzams, zzcla> zzcjyVar) throws RemoteException {
        zzams zzamsVar = zzcjyVar.f15313b;
        IObjectWrapper E0 = ObjectWrapper.E0(this.a);
        zzxz zzxzVar = zzcxuVar.a.a.f15750d;
        String jSONObject = zzcxmVar.s.toString();
        String a = zzazc.a(zzcxmVar.p);
        zzcla zzclaVar = zzcjyVar.f15314c;
        zzcxv zzcxvVar = zzcxuVar.a.a;
        zzamsVar.M3(E0, zzxzVar, jSONObject, a, zzclaVar, zzcxvVar.f15755i, zzcxvVar.f15753g);
    }
}
