package com.google.android.gms.internal.ads;

import android.content.Context;

@zzard
/* loaded from: classes2.dex */
public final class zzawx {
    public static void a(Context context) {
        if (zzazx.o(context) && !zzazx.u()) {
            zzbbh zzvi = new a5(context).zzvi();
            zzbad.h("Updating ad debug logging enablement.");
            zzbao.a(zzvi, "AdDebugLogUpdater.updateEnablement");
        }
    }
}
