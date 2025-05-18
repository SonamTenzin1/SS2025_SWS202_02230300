package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import java.util.concurrent.Callable;

/* loaded from: classes2.dex */
public final class zzcsh implements zzcva<zzcsg> {
    private final zzbbl a;

    /* renamed from: b, reason: collision with root package name */
    private final Context f15602b;

    public zzcsh(zzbbl zzbblVar, Context context) {
        this.a = zzbblVar;
        this.f15602b = context;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzcsg a() throws Exception {
        double d2;
        Intent registerReceiver = this.f15602b.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        boolean z = false;
        if (registerReceiver != null) {
            int intExtra = registerReceiver.getIntExtra("status", -1);
            double intExtra2 = registerReceiver.getIntExtra("level", -1);
            double intExtra3 = registerReceiver.getIntExtra("scale", -1);
            Double.isNaN(intExtra2);
            Double.isNaN(intExtra3);
            d2 = intExtra2 / intExtra3;
            if (intExtra == 2 || intExtra == 5) {
                z = true;
            }
        } else {
            d2 = -1.0d;
        }
        return new zzcsg(d2, z);
    }

    @Override // com.google.android.gms.internal.ads.zzcva
    public final zzbbh<zzcsg> b() {
        return this.a.submit(new Callable(this) { // from class: com.google.android.gms.internal.ads.zn

            /* renamed from: f, reason: collision with root package name */
            private final zzcsh f13718f;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f13718f = this;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f13718f.a();
            }
        });
    }
}
