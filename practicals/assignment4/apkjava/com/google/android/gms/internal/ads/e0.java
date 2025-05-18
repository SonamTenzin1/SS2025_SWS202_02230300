package com.google.android.gms.internal.ads;

import java.util.Map;

/* loaded from: classes2.dex */
final class e0 implements zzaho<zzbgz> {
    @Override // com.google.android.gms.internal.ads.zzaho
    public final /* synthetic */ void a(zzbgz zzbgzVar, Map map) {
        zzbgz zzbgzVar2 = zzbgzVar;
        com.google.android.gms.ads.internal.overlay.zzd k0 = zzbgzVar2.k0();
        if (k0 != null) {
            k0.close();
            return;
        }
        com.google.android.gms.ads.internal.overlay.zzd s0 = zzbgzVar2.s0();
        if (s0 != null) {
            s0.close();
        } else {
            zzbad.i("A GMSG tried to close something that wasn't an overlay.");
        }
    }
}
