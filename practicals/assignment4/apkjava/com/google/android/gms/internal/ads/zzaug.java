package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.rewarded.OnAdMetadataChangedListener;
import com.google.android.gms.ads.rewarded.RewardItem;
import com.google.android.gms.ads.rewarded.RewardedAdCallback;
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback;
import com.google.android.gms.ads.rewarded.ServerSideVerificationOptions;
import com.google.android.gms.dynamic.ObjectWrapper;
import okhttp3.HttpUrl;

@zzard
/* loaded from: classes2.dex */
public final class zzaug {
    private final zzatt a;

    /* renamed from: b, reason: collision with root package name */
    private final Context f14159b;

    public zzaug(Context context, String str) {
        this.f14159b = context.getApplicationContext();
        this.a = zzyt.b().j(context, str, new zzamo());
    }

    public final Bundle a() {
        try {
            return this.a.getAdMetadata();
        } catch (RemoteException e2) {
            zzbad.f("#007 Could not call remote method.", e2);
            return new Bundle();
        }
    }

    public final String b() {
        try {
            return this.a.getMediationAdapterClassName();
        } catch (RemoteException e2) {
            zzbad.f("#007 Could not call remote method.", e2);
            return HttpUrl.FRAGMENT_ENCODE_SET;
        }
    }

    public final RewardItem c() {
        try {
            zzatq O6 = this.a.O6();
            if (O6 == null) {
                return null;
            }
            return new zzauh(O6);
        } catch (RemoteException e2) {
            zzbad.f("#007 Could not call remote method.", e2);
            return null;
        }
    }

    public final boolean d() {
        try {
            return this.a.isLoaded();
        } catch (RemoteException e2) {
            zzbad.f("#007 Could not call remote method.", e2);
            return false;
        }
    }

    public final void e(OnAdMetadataChangedListener onAdMetadataChangedListener) {
        try {
            this.a.G5(new zzabz(onAdMetadataChangedListener));
        } catch (RemoteException e2) {
            zzbad.f("#007 Could not call remote method.", e2);
        }
    }

    public final void f(ServerSideVerificationOptions serverSideVerificationOptions) {
        try {
            this.a.m2(new zzaum(serverSideVerificationOptions));
        } catch (RemoteException e2) {
            zzbad.f("#007 Could not call remote method.", e2);
        }
    }

    public final void g(Activity activity, RewardedAdCallback rewardedAdCallback) {
        try {
            this.a.L5(new zzaui(rewardedAdCallback));
            this.a.f5(ObjectWrapper.E0(activity));
        } catch (RemoteException e2) {
            zzbad.f("#007 Could not call remote method.", e2);
        }
    }

    public final void h(Activity activity, RewardedAdCallback rewardedAdCallback, boolean z) {
        try {
            this.a.L5(new zzaui(rewardedAdCallback));
            this.a.e7(ObjectWrapper.E0(activity), z);
        } catch (RemoteException e2) {
            zzbad.f("#007 Could not call remote method.", e2);
        }
    }

    public final void i(zzaaz zzaazVar, RewardedAdLoadCallback rewardedAdLoadCallback) {
        try {
            this.a.W1(zzyc.a(this.f14159b, zzaazVar), new zzaul(rewardedAdLoadCallback));
        } catch (RemoteException e2) {
            zzbad.f("#007 Could not call remote method.", e2);
        }
    }
}
