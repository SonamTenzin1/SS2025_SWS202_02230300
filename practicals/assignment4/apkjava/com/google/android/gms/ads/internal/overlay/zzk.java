package com.google.android.gms.ads.internal.overlay;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.google.android.gms.internal.ads.zzard;
import com.google.android.gms.internal.ads.zzawv;
import com.google.android.gms.internal.ads.zzaxi;
import com.google.android.gms.internal.ads.zzaxo;

@zzard
/* loaded from: classes2.dex */
final class zzk extends zzawv {
    final /* synthetic */ zzd zzdki;

    private zzk(zzd zzdVar) {
        this.zzdki = zzdVar;
    }

    @Override // com.google.android.gms.internal.ads.zzawv
    public final void zzto() {
        Bitmap a = com.google.android.gms.ads.internal.zzk.zzlz().a(Integer.valueOf(this.zzdki.zzdjl.zzdkt.zzbrj));
        if (a != null) {
            zzaxo zzli = com.google.android.gms.ads.internal.zzk.zzli();
            zzd zzdVar = this.zzdki;
            Activity activity = zzdVar.mActivity;
            com.google.android.gms.ads.internal.zzh zzhVar = zzdVar.zzdjl.zzdkt;
            final Drawable e2 = zzli.e(activity, a, zzhVar.zzbrh, zzhVar.zzbri);
            zzaxi.a.post(new Runnable(this, e2) { // from class: com.google.android.gms.ads.internal.overlay.zzl
                private final zzk zzdkj;
                private final Drawable zzdkk;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.zzdkj = this;
                    this.zzdkk = e2;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    zzk zzkVar = this.zzdkj;
                    zzkVar.zzdki.mActivity.getWindow().setBackgroundDrawable(this.zzdkk);
                }
            });
        }
    }
}
