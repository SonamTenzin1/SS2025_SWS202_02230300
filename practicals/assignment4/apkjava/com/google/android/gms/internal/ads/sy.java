package com.google.android.gms.internal.ads;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class sy extends BroadcastReceiver {
    private final /* synthetic */ zzeh a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public sy(zzeh zzehVar) {
        this.a = zzehVar;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        this.a.e();
    }
}
