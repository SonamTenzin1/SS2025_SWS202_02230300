package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
public final class zzcna implements zzcka<zzcdb, zzams, zzcla> {
    private final Context a;

    /* renamed from: b, reason: collision with root package name */
    private final Executor f15427b;

    /* renamed from: c, reason: collision with root package name */
    private final zzcdf f15428c;

    public zzcna(Context context, Executor executor, zzcdf zzcdfVar) {
        this.a = context;
        this.f15427b = executor;
        this.f15428c = zzcdfVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcka
    public final /* synthetic */ zzcdb a(zzcxu zzcxuVar, zzcxm zzcxmVar, final zzcjy<zzams, zzcla> zzcjyVar) throws RemoteException, zzcmw {
        zzcdc a = this.f15428c.a(new zzbpr(zzcxuVar, zzcxmVar, zzcjyVar.a), new zzcdd(new zzbwz(zzcjyVar) { // from class: com.google.android.gms.internal.ads.ql
            private final zzcjy a;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.a = zzcjyVar;
            }

            @Override // com.google.android.gms.internal.ads.zzbwz
            public final void a(boolean z, Context context) {
                zzcjy zzcjyVar2 = this.a;
                try {
                    ((zzams) zzcjyVar2.f15313b).setImmersiveMode(z);
                    ((zzams) zzcjyVar2.f15313b).a4(ObjectWrapper.E0(context));
                } catch (RemoteException e2) {
                    zzbad.d("Cannot show rewarded .", e2);
                }
            }
        }));
        a.a().V(new zzccy(zzcjyVar.f15313b), this.f15427b);
        zzcjyVar.f15314c.i7(a.l());
        return a.j();
    }

    @Override // com.google.android.gms.internal.ads.zzcka
    public final void b(zzcxu zzcxuVar, zzcxm zzcxmVar, zzcjy<zzams, zzcla> zzcjyVar) throws RemoteException {
        try {
            zzcjyVar.f15313b.f2(ObjectWrapper.E0(this.a), zzcxuVar.a.a.f15750d, zzcxmVar.s.toString(), zzcjyVar.f15314c);
        } catch (Exception e2) {
            String valueOf = String.valueOf(zzcjyVar.a);
            zzbad.d(valueOf.length() != 0 ? "Fail to load ad from adapter ".concat(valueOf) : new String("Fail to load ad from adapter "), e2);
        }
    }
}
