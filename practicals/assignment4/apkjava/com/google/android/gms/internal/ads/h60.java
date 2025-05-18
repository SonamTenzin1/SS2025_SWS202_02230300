package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public abstract class h60<T> {
    private static final zzzv a = e();

    private static zzzv e() {
        try {
            Object newInstance = zzyh.class.getClassLoader().loadClass("com.google.android.gms.ads.internal.ClientApi2").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
            if (!(newInstance instanceof IBinder)) {
                zzbad.i("ClientApi class is not an instance of IBinder.");
                return null;
            }
            IBinder iBinder = (IBinder) newInstance;
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IClientApi");
            if (queryLocalInterface instanceof zzzv) {
                return (zzzv) queryLocalInterface;
            }
            return new zzzx(iBinder);
        } catch (Exception unused) {
            zzbad.i("Failed to instantiate ClientApi class.");
            return null;
        }
    }

    private final T f() {
        zzzv zzzvVar = a;
        if (zzzvVar == null) {
            zzbad.i("ClientApi class cannot be loaded.");
            return null;
        }
        try {
            return a(zzzvVar);
        } catch (RemoteException e2) {
            zzbad.d("Cannot invoke local loader using ClientApi class.", e2);
            return null;
        }
    }

    private final T g() {
        try {
            return d();
        } catch (RemoteException e2) {
            zzbad.d("Cannot invoke remote loader.", e2);
            return null;
        }
    }

    protected abstract T a(zzzv zzzvVar) throws RemoteException;

    public final T b(Context context, boolean z) {
        T f2;
        if (!z) {
            zzyt.a();
            if (!zzazt.s(context, GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE)) {
                zzbad.e("Google Play Services is not available.");
                z = true;
            }
        }
        if (DynamiteModule.a(context, ModuleDescriptor.MODULE_ID) > DynamiteModule.c(context, ModuleDescriptor.MODULE_ID)) {
            z = true;
        }
        zzacu.a(context);
        if (((Boolean) zzyt.e().c(zzacu.Y3)).booleanValue()) {
            z = false;
        }
        if (z) {
            f2 = f();
            if (f2 == null) {
                f2 = g();
            }
        } else {
            T g2 = g();
            int i2 = g2 == null ? 1 : 0;
            if (i2 != 0) {
                if (zzyt.h().nextInt(((Integer) zzyt.e().c(zzacu.Y4)).intValue()) == 0) {
                    Bundle bundle = new Bundle();
                    bundle.putString("action", "dynamite_load");
                    bundle.putInt("is_missing", i2);
                    zzyt.a().d(context, zzyt.g().f14326f, "gmob-apps", bundle, true);
                }
            }
            f2 = g2 == null ? f() : g2;
        }
        return f2 == null ? c() : f2;
    }

    protected abstract T c();

    protected abstract T d() throws RemoteException;
}
