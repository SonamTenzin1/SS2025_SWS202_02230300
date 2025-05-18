package com.google.android.gms.internal.ads;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class e6 extends BroadcastReceiver {
    private final /* synthetic */ zzazp a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e6(zzazp zzazpVar) {
        this.a = zzazpVar;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        this.a.e(context, intent);
    }
}
