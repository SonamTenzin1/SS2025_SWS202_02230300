package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.view.View;

@TargetApi(18)
/* loaded from: classes2.dex */
public class zzaxs extends zzaxr {
    @Override // com.google.android.gms.internal.ads.zzaxo
    public boolean b(View view) {
        return super.b(view) || view.getWindowId() != null;
    }

    @Override // com.google.android.gms.internal.ads.zzaxo
    public final int s() {
        return 14;
    }
}
