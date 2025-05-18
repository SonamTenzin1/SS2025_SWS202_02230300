package com.google.android.gms.safetynet;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@SafeParcelable.Class
@SafeParcelable.Reserved
/* loaded from: classes2.dex */
public class SafeBrowsingData extends AbstractSafeParcelable {

    /* renamed from: g, reason: collision with root package name */
    @SafeParcelable.Field
    private String f18254g;

    /* renamed from: h, reason: collision with root package name */
    @SafeParcelable.Field
    private DataHolder f18255h;

    /* renamed from: i, reason: collision with root package name */
    @SafeParcelable.Field
    private ParcelFileDescriptor f18256i;

    /* renamed from: j, reason: collision with root package name */
    @SafeParcelable.Field
    private long f18257j;

    /* renamed from: k, reason: collision with root package name */
    @SafeParcelable.Field
    private byte[] f18258k;
    private byte[] l;
    private File m;

    /* renamed from: f, reason: collision with root package name */
    private static final String f18253f = SafeBrowsingData.class.getSimpleName();
    public static final Parcelable.Creator<SafeBrowsingData> CREATOR = new zzj();

    public SafeBrowsingData() {
        this(null, null, null, 0L, null);
    }

    @SafeParcelable.Constructor
    public SafeBrowsingData(@SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 3) DataHolder dataHolder, @SafeParcelable.Param(id = 4) ParcelFileDescriptor parcelFileDescriptor, @SafeParcelable.Param(id = 5) long j2, @SafeParcelable.Param(id = 6) byte[] bArr) {
        this.f18254g = str;
        this.f18255h = dataHolder;
        this.f18256i = parcelFileDescriptor;
        this.f18257j = j2;
        this.f18258k = bArr;
    }

    private final FileOutputStream i0() {
        Throwable th;
        File file;
        File file2 = this.m;
        if (file2 == null) {
            return null;
        }
        try {
            file = File.createTempFile("xlb", ".tmp", file2);
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                this.f18256i = ParcelFileDescriptor.open(file, 268435456);
                if (file != null) {
                    file.delete();
                }
                return fileOutputStream;
            } catch (IOException unused) {
                if (file != null) {
                    file.delete();
                }
                return null;
            } catch (Throwable th2) {
                th = th2;
                if (file != null) {
                    file.delete();
                }
                throw th;
            }
        } catch (IOException unused2) {
            file = null;
        } catch (Throwable th3) {
            th = th3;
            file = null;
        }
    }

    private static void p0(Closeable closeable) {
        try {
            closeable.close();
        } catch (IOException unused) {
        }
    }

    public long W() {
        return this.f18257j;
    }

    public String Y() {
        return this.f18254g;
    }

    public byte[] e0() {
        return this.f18258k;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0035  */
    @Override // android.os.Parcelable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void writeToParcel(Parcel parcel, int i2) {
        boolean z;
        FileOutputStream i0;
        if (this.f18256i == null && this.l != null && (i0 = i0()) != null) {
            DataOutputStream dataOutputStream = new DataOutputStream(new BufferedOutputStream(i0));
            try {
                dataOutputStream.writeInt(this.l.length);
                dataOutputStream.write(this.l);
                p0(dataOutputStream);
                z = true;
            } catch (IOException unused) {
                p0(dataOutputStream);
            } catch (Throwable th) {
                p0(dataOutputStream);
                throw th;
            }
            if (z) {
                i2 |= 1;
            }
            zzj.a(this, parcel, i2);
            this.f18256i = null;
        }
        z = false;
        if (z) {
        }
        zzj.a(this, parcel, i2);
        this.f18256i = null;
    }

    public DataHolder y() {
        return this.f18255h;
    }

    public ParcelFileDescriptor z() {
        return this.f18256i;
    }
}
