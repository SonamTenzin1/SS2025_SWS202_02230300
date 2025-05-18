package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.util.IOUtils;
import java.io.DataInputStream;
import java.io.IOException;

@zzard
@SafeParcelable.Class
@SafeParcelable.Reserved
/* loaded from: classes2.dex */
public final class zzaru extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzaru> CREATOR = new zzarw();

    /* renamed from: f, reason: collision with root package name */
    @SafeParcelable.Field
    private ParcelFileDescriptor f14101f;

    /* renamed from: g, reason: collision with root package name */
    private Parcelable f14102g = null;

    /* renamed from: h, reason: collision with root package name */
    private boolean f14103h = true;

    @SafeParcelable.Constructor
    public zzaru(@SafeParcelable.Param(id = 2) ParcelFileDescriptor parcelFileDescriptor) {
        this.f14101f = parcelFileDescriptor;
    }

    private final ParcelFileDescriptor W() {
        if (this.f14101f == null) {
            Parcel obtain = Parcel.obtain();
            try {
                this.f14102g.writeToParcel(obtain, 0);
                byte[] marshall = obtain.marshall();
                obtain.recycle();
                this.f14101f = z(marshall);
            } catch (Throwable th) {
                obtain.recycle();
                throw th;
            }
        }
        return this.f14101f;
    }

    private final <T> ParcelFileDescriptor z(byte[] bArr) {
        ParcelFileDescriptor.AutoCloseOutputStream autoCloseOutputStream;
        ParcelFileDescriptor[] createPipe;
        try {
            createPipe = ParcelFileDescriptor.createPipe();
            autoCloseOutputStream = new ParcelFileDescriptor.AutoCloseOutputStream(createPipe[1]);
        } catch (IOException e2) {
            e = e2;
            autoCloseOutputStream = null;
        }
        try {
            new Thread(new r3(this, autoCloseOutputStream, bArr)).start();
            return createPipe[0];
        } catch (IOException e3) {
            e = e3;
            zzbad.c("Error transporting the ad response", e);
            zzk.zzlk().e(e, "LargeParcelTeleporter.pipeData.2");
            IOUtils.a(autoCloseOutputStream);
            return null;
        }
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        W();
        int a = SafeParcelWriter.a(parcel);
        SafeParcelWriter.s(parcel, 2, this.f14101f, i2, false);
        SafeParcelWriter.b(parcel, a);
    }

    public final <T extends SafeParcelable> T y(Parcelable.Creator<T> creator) {
        if (this.f14103h) {
            if (this.f14101f == null) {
                zzbad.g("File descriptor is empty, returning null.");
                return null;
            }
            DataInputStream dataInputStream = new DataInputStream(new ParcelFileDescriptor.AutoCloseInputStream(this.f14101f));
            try {
                try {
                    int readInt = dataInputStream.readInt();
                    byte[] bArr = new byte[readInt];
                    dataInputStream.readFully(bArr, 0, readInt);
                    IOUtils.a(dataInputStream);
                    Parcel obtain = Parcel.obtain();
                    try {
                        obtain.unmarshall(bArr, 0, readInt);
                        obtain.setDataPosition(0);
                        this.f14102g = creator.createFromParcel(obtain);
                        obtain.recycle();
                        this.f14103h = false;
                    } catch (Throwable th) {
                        obtain.recycle();
                        throw th;
                    }
                } catch (IOException e2) {
                    zzbad.c("Could not read from parcel file descriptor", e2);
                    IOUtils.a(dataInputStream);
                    return null;
                }
            } catch (Throwable th2) {
                IOUtils.a(dataInputStream);
                throw th2;
            }
        }
        return (T) this.f14102g;
    }
}
