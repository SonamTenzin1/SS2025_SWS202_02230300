package com.google.android.gms.internal.ads;

import android.view.MotionEvent;
import com.google.android.gms.ads.formats.NativeCustomTemplateAd;

/* loaded from: classes2.dex */
final class ih implements zzadx {
    private final /* synthetic */ zzccd a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ih(zzccd zzccdVar) {
        this.a = zzccdVar;
    }

    @Override // com.google.android.gms.internal.ads.zzadx
    public final void a() {
        zzbyn zzbynVar;
        zzbynVar = this.a.f15049i;
        zzbynVar.x(NativeCustomTemplateAd.ASSET_NAME_VIDEO);
    }

    @Override // com.google.android.gms.internal.ads.zzadx
    public final void b(MotionEvent motionEvent) {
    }
}
