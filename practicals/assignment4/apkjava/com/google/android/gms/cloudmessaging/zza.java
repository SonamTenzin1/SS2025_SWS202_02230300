package com.google.android.gms.cloudmessaging;

import android.os.Build;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.cloudmessaging.IMessengerCompat;

/* compiled from: com.google.android.gms:play-services-cloud-messaging@@16.0.0 */
/* loaded from: classes2.dex */
public class zza implements Parcelable {
    public static final Parcelable.Creator<zza> CREATOR = new a();

    /* renamed from: f, reason: collision with root package name */
    private Messenger f11608f;

    /* renamed from: g, reason: collision with root package name */
    private IMessengerCompat f11609g;

    /* compiled from: com.google.android.gms:play-services-cloud-messaging@@16.0.0 */
    /* renamed from: com.google.android.gms.cloudmessaging.zza$zza, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class C0173zza extends ClassLoader {
        @Override // java.lang.ClassLoader
        protected final Class<?> loadClass(String str, boolean z) throws ClassNotFoundException {
            if ("com.google.android.gms.iid.MessengerCompat".equals(str)) {
                if (Log.isLoggable("CloudMessengerCompat", 3) || (Build.VERSION.SDK_INT == 23 && Log.isLoggable("CloudMessengerCompat", 3))) {
                    Log.d("CloudMessengerCompat", "Using renamed FirebaseIidMessengerCompat class");
                    return zza.class;
                }
                return zza.class;
            }
            return super.loadClass(str, z);
        }
    }

    public zza(IBinder iBinder) {
        if (Build.VERSION.SDK_INT >= 21) {
            this.f11608f = new Messenger(iBinder);
        } else {
            this.f11609g = new IMessengerCompat.Proxy(iBinder);
        }
    }

    private final IBinder a() {
        Messenger messenger = this.f11608f;
        return messenger != null ? messenger.getBinder() : this.f11609g.asBinder();
    }

    public final void b(Message message) throws RemoteException {
        Messenger messenger = this.f11608f;
        if (messenger != null) {
            messenger.send(message);
        } else {
            this.f11609g.E1(message);
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        try {
            return a().equals(((zza) obj).a());
        } catch (ClassCastException unused) {
            return false;
        }
    }

    public int hashCode() {
        return a().hashCode();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        Messenger messenger = this.f11608f;
        if (messenger != null) {
            parcel.writeStrongBinder(messenger.getBinder());
        } else {
            parcel.writeStrongBinder(this.f11609g.asBinder());
        }
    }
}
