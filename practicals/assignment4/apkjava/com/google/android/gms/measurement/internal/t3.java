package com.google.android.gms.measurement.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.0 */
/* loaded from: classes2.dex */
final class t3 implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ zzfx f17955f;

    /* renamed from: g, reason: collision with root package name */
    private final /* synthetic */ long f17956g;

    /* renamed from: h, reason: collision with root package name */
    private final /* synthetic */ Bundle f17957h;

    /* renamed from: i, reason: collision with root package name */
    private final /* synthetic */ Context f17958i;

    /* renamed from: j, reason: collision with root package name */
    private final /* synthetic */ zzet f17959j;

    /* renamed from: k, reason: collision with root package name */
    private final /* synthetic */ BroadcastReceiver.PendingResult f17960k;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t3(zzfn zzfnVar, zzfx zzfxVar, long j2, Bundle bundle, Context context, zzet zzetVar, BroadcastReceiver.PendingResult pendingResult) {
        this.f17955f = zzfxVar;
        this.f17956g = j2;
        this.f17957h = bundle;
        this.f17958i = context;
        this.f17959j = zzetVar;
        this.f17960k = pendingResult;
    }

    @Override // java.lang.Runnable
    public final void run() {
        long a = this.f17955f.B().f17927k.a();
        long j2 = this.f17956g;
        if (a > 0 && (j2 >= a || j2 <= 0)) {
            j2 = a - 1;
        }
        if (j2 > 0) {
            this.f17957h.putLong("click_timestamp", j2);
        }
        this.f17957h.putString("_cis", "referrer broadcast");
        zzfx.a(this.f17958i, null).H().S("auto", "_cmp", this.f17957h);
        this.f17959j.P().a("Install campaign recorded");
        BroadcastReceiver.PendingResult pendingResult = this.f17960k;
        if (pendingResult != null) {
            pendingResult.finish();
        }
    }
}
