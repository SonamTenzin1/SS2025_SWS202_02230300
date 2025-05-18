package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import com.google.android.gms.ads.internal.zzk;
import java.util.concurrent.Callable;

/* loaded from: classes2.dex */
public final class zzcvk implements zzcva<zzcvj> {
    private final zzbbl a;

    /* renamed from: b, reason: collision with root package name */
    private final Context f15681b;

    public zzcvk(zzbbl zzbblVar, Context context) {
        this.a = zzbblVar;
        this.f15681b = context;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzcvj a() throws Exception {
        int i2;
        boolean z;
        int i3;
        int i4;
        TelephonyManager telephonyManager = (TelephonyManager) this.f15681b.getSystemService("phone");
        String networkOperator = telephonyManager.getNetworkOperator();
        int networkType = telephonyManager.getNetworkType();
        int phoneType = telephonyManager.getPhoneType();
        zzk.zzlg();
        int i5 = -1;
        if (zzaxi.f0(this.f15681b, "android.permission.ACCESS_NETWORK_STATE")) {
            ConnectivityManager connectivityManager = (ConnectivityManager) this.f15681b.getSystemService("connectivity");
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                i5 = activeNetworkInfo.getType();
                i4 = activeNetworkInfo.getDetailedState().ordinal();
            } else {
                i4 = -1;
            }
            if (Build.VERSION.SDK_INT >= 16) {
                i2 = i5;
                i3 = i4;
                z = connectivityManager.isActiveNetworkMetered();
            } else {
                i2 = i5;
                i3 = i4;
                z = false;
            }
        } else {
            i2 = -2;
            z = false;
            i3 = -1;
        }
        return new zzcvj(networkOperator, i2, networkType, phoneType, z, i3);
    }

    @Override // com.google.android.gms.internal.ads.zzcva
    public final zzbbh<zzcvj> b() {
        return this.a.submit(new Callable(this) { // from class: com.google.android.gms.internal.ads.ep

            /* renamed from: f, reason: collision with root package name */
            private final zzcvk f12541f;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f12541f = this;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f12541f.a();
            }
        });
    }
}
