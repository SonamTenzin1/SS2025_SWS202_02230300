package com.google.android.gms.internal.ads;

import android.os.Build;
import java.util.Arrays;
import java.util.List;

@zzard
/* loaded from: classes2.dex */
public final class zzbfm implements zzbgd {
    @Override // com.google.android.gms.internal.ads.zzbgd
    public final zzbft a(zzbdf zzbdfVar, int i2, String str, zzbde zzbdeVar) {
        if (Build.VERSION.SDK_INT >= 16 && i2 > 0) {
            List asList = Arrays.asList(zzbdeVar.f14367e.split(","));
            if (asList.contains("3")) {
                int H = zzbfa.H();
                if (H < zzbdeVar.f14370h) {
                    return new zzbgp(zzbdfVar, zzbdeVar);
                }
                if (H < zzbdeVar.f14364b) {
                    return new zzbgo(zzbdfVar, zzbdeVar);
                }
                return new zzbgf(zzbdfVar);
            }
            if (asList.contains("1")) {
                int h2 = zzbdk.h();
                if (h2 < zzbdeVar.f14370h) {
                    if (i2 == 1) {
                        return new zzbgk(zzbdfVar);
                    }
                    if (i2 == 2) {
                        return new zzbgh(zzbdfVar, null);
                    }
                }
                if (h2 < zzbdeVar.f14364b) {
                    return new zzbgg(zzbdfVar, zzbdeVar);
                }
                return new zzbgf(zzbdfVar);
            }
        }
        return new zzbge(zzbdfVar);
    }
}
