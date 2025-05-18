package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamic.RemoteCreator;

@zzard
/* loaded from: classes2.dex */
public final class zzaqf extends RemoteCreator<zzaqj> {
    public zzaqf() {
        super("com.google.android.gms.ads.AdOverlayCreatorImpl");
    }

    @Override // com.google.android.gms.dynamic.RemoteCreator
    protected final /* synthetic */ zzaqj a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.overlay.client.IAdOverlayCreator");
        if (queryLocalInterface instanceof zzaqj) {
            return (zzaqj) queryLocalInterface;
        }
        return new zzaqk(iBinder);
    }

    public final zzaqg c(Activity activity) {
        try {
            IBinder w5 = b(activity).w5(ObjectWrapper.E0(activity));
            if (w5 == null) {
                return null;
            }
            IInterface queryLocalInterface = w5.queryLocalInterface("com.google.android.gms.ads.internal.overlay.client.IAdOverlay");
            if (queryLocalInterface instanceof zzaqg) {
                return (zzaqg) queryLocalInterface;
            }
            return new zzaqi(w5);
        } catch (RemoteException e2) {
            zzbad.d("Could not create remote AdOverlay.", e2);
            return null;
        } catch (RemoteCreator.RemoteCreatorException e3) {
            zzbad.d("Could not create remote AdOverlay.", e3);
            return null;
        }
    }
}
