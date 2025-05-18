package com.bumptech.glide.load.o.c;

import android.graphics.Bitmap;
import android.util.Log;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* compiled from: BitmapEncoder.java */
/* loaded from: classes.dex */
public class c implements com.bumptech.glide.load.k<Bitmap> {
    public static final com.bumptech.glide.load.h<Integer> a = com.bumptech.glide.load.h.f("com.bumptech.glide.load.resource.bitmap.BitmapEncoder.CompressionQuality", 90);

    /* renamed from: b, reason: collision with root package name */
    public static final com.bumptech.glide.load.h<Bitmap.CompressFormat> f9352b = com.bumptech.glide.load.h.e("com.bumptech.glide.load.resource.bitmap.BitmapEncoder.CompressionFormat");

    /* renamed from: c, reason: collision with root package name */
    private final com.bumptech.glide.load.engine.z.b f9353c;

    public c(com.bumptech.glide.load.engine.z.b bVar) {
        this.f9353c = bVar;
    }

    private Bitmap.CompressFormat d(Bitmap bitmap, com.bumptech.glide.load.i iVar) {
        Bitmap.CompressFormat compressFormat = (Bitmap.CompressFormat) iVar.a(f9352b);
        if (compressFormat != null) {
            return compressFormat;
        }
        if (bitmap.hasAlpha()) {
            return Bitmap.CompressFormat.PNG;
        }
        return Bitmap.CompressFormat.JPEG;
    }

    @Override // com.bumptech.glide.load.k
    public com.bumptech.glide.load.c b(com.bumptech.glide.load.i iVar) {
        return com.bumptech.glide.load.c.TRANSFORMED;
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x0066, code lost:
    
        if (r6 != null) goto L43;
     */
    @Override // com.bumptech.glide.load.d
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean a(com.bumptech.glide.load.engine.u<Bitmap> uVar, File file, com.bumptech.glide.load.i iVar) {
        FileOutputStream fileOutputStream;
        Bitmap bitmap = uVar.get();
        Bitmap.CompressFormat d2 = d(bitmap, iVar);
        com.bumptech.glide.r.l.b.c("encode: [%dx%d] %s", Integer.valueOf(bitmap.getWidth()), Integer.valueOf(bitmap.getHeight()), d2);
        try {
            long b2 = com.bumptech.glide.r.f.b();
            int intValue = ((Integer) iVar.a(a)).intValue();
            boolean z = false;
            OutputStream outputStream = null;
            try {
                try {
                    fileOutputStream = new FileOutputStream(file);
                } catch (IOException e2) {
                    e = e2;
                }
            } catch (Throwable th) {
                th = th;
            }
            try {
                outputStream = this.f9353c != null ? new com.bumptech.glide.load.m.c(fileOutputStream, this.f9353c) : fileOutputStream;
                bitmap.compress(d2, intValue, outputStream);
                outputStream.close();
                z = true;
            } catch (IOException e3) {
                e = e3;
                outputStream = fileOutputStream;
                if (Log.isLoggable("BitmapEncoder", 3)) {
                    Log.d("BitmapEncoder", "Failed to encode Bitmap", e);
                }
            } catch (Throwable th2) {
                th = th2;
                outputStream = fileOutputStream;
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (IOException unused) {
                    }
                }
                throw th;
            }
            try {
                outputStream.close();
            } catch (IOException unused2) {
                if (Log.isLoggable("BitmapEncoder", 2)) {
                    Log.v("BitmapEncoder", "Compressed with type: " + d2 + " of size " + com.bumptech.glide.r.k.h(bitmap) + " in " + com.bumptech.glide.r.f.a(b2) + ", options format: " + iVar.a(f9352b) + ", hasAlpha: " + bitmap.hasAlpha());
                }
                return z;
            }
        } finally {
            com.bumptech.glide.r.l.b.d();
        }
    }
}
