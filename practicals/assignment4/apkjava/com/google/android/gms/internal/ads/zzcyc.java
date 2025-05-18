package com.google.android.gms.internal.ads;

import android.os.ParcelFileDescriptor;
import com.google.android.gms.common.util.IOUtils;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes2.dex */
public final class zzcyc {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static final /* synthetic */ void a(InputStream inputStream, ParcelFileDescriptor parcelFileDescriptor) {
        try {
            try {
                ParcelFileDescriptor.AutoCloseOutputStream autoCloseOutputStream = new ParcelFileDescriptor.AutoCloseOutputStream(parcelFileDescriptor);
                try {
                    IOUtils.b(inputStream, autoCloseOutputStream);
                    autoCloseOutputStream.close();
                    if (inputStream != null) {
                        b(null, inputStream);
                    }
                } finally {
                }
            } catch (IOException unused) {
            }
        } finally {
        }
    }

    private static /* synthetic */ void b(Throwable th, InputStream inputStream) {
        if (th == null) {
            inputStream.close();
            return;
        }
        try {
            inputStream.close();
        } catch (Throwable th2) {
            zzdmb.b(th, th2);
        }
    }

    public static ParcelFileDescriptor c(final InputStream inputStream) throws IOException {
        ParcelFileDescriptor[] createPipe = ParcelFileDescriptor.createPipe();
        ParcelFileDescriptor parcelFileDescriptor = createPipe[0];
        final ParcelFileDescriptor parcelFileDescriptor2 = createPipe[1];
        zzaxg.a.execute(new Runnable(inputStream, parcelFileDescriptor2) { // from class: com.google.android.gms.internal.ads.zp

            /* renamed from: f, reason: collision with root package name */
            private final InputStream f13719f;

            /* renamed from: g, reason: collision with root package name */
            private final ParcelFileDescriptor f13720g;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f13719f = inputStream;
                this.f13720g = parcelFileDescriptor2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                zzcyc.a(this.f13719f, this.f13720g);
            }
        });
        return parcelFileDescriptor;
    }
}
