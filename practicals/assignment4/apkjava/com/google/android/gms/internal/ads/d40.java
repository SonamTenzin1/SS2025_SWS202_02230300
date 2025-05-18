package com.google.android.gms.internal.ads;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class d40 extends BroadcastReceiver {
    private final /* synthetic */ zzua a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d40(zzua zzuaVar) {
        this.a = zzuaVar;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        this.a.f(3);
    }
}
