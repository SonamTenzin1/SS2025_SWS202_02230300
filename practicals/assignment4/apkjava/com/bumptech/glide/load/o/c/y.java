package com.bumptech.glide.load.o.c;

import android.annotation.TargetApi;
import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import com.bumptech.glide.load.h;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* compiled from: VideoDecoder.java */
/* loaded from: classes.dex */
public class y<T> implements com.bumptech.glide.load.j<T, Bitmap> {
    public static final com.bumptech.glide.load.h<Long> a = com.bumptech.glide.load.h.a("com.bumptech.glide.load.resource.bitmap.VideoBitmapDecode.TargetFrame", -1L, new a());

    /* renamed from: b, reason: collision with root package name */
    public static final com.bumptech.glide.load.h<Integer> f9404b = com.bumptech.glide.load.h.a("com.bumptech.glide.load.resource.bitmap.VideoBitmapDecode.FrameOption", 2, new b());

    /* renamed from: c, reason: collision with root package name */
    private static final d f9405c = new d();

    /* renamed from: d, reason: collision with root package name */
    private final e<T> f9406d;

    /* renamed from: e, reason: collision with root package name */
    private final com.bumptech.glide.load.engine.z.e f9407e;

    /* renamed from: f, reason: collision with root package name */
    private final d f9408f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: VideoDecoder.java */
    /* loaded from: classes.dex */
    public class a implements h.b<Long> {
        private final ByteBuffer a = ByteBuffer.allocate(8);

        a() {
        }

        @Override // com.bumptech.glide.load.h.b
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(byte[] bArr, Long l, MessageDigest messageDigest) {
            messageDigest.update(bArr);
            synchronized (this.a) {
                this.a.position(0);
                messageDigest.update(this.a.putLong(l.longValue()).array());
            }
        }
    }

    /* compiled from: VideoDecoder.java */
    /* loaded from: classes.dex */
    class b implements h.b<Integer> {
        private final ByteBuffer a = ByteBuffer.allocate(4);

        b() {
        }

        @Override // com.bumptech.glide.load.h.b
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(byte[] bArr, Integer num, MessageDigest messageDigest) {
            if (num == null) {
                return;
            }
            messageDigest.update(bArr);
            synchronized (this.a) {
                this.a.position(0);
                messageDigest.update(this.a.putInt(num.intValue()).array());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: VideoDecoder.java */
    /* loaded from: classes.dex */
    public static final class c implements e<AssetFileDescriptor> {
        private c() {
        }

        @Override // com.bumptech.glide.load.o.c.y.e
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(MediaMetadataRetriever mediaMetadataRetriever, AssetFileDescriptor assetFileDescriptor) {
            mediaMetadataRetriever.setDataSource(assetFileDescriptor.getFileDescriptor(), assetFileDescriptor.getStartOffset(), assetFileDescriptor.getLength());
        }

        /* synthetic */ c(a aVar) {
            this();
        }
    }

    /* compiled from: VideoDecoder.java */
    /* loaded from: classes.dex */
    static class d {
        d() {
        }

        public MediaMetadataRetriever a() {
            return new MediaMetadataRetriever();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: VideoDecoder.java */
    /* loaded from: classes.dex */
    public interface e<T> {
        void a(MediaMetadataRetriever mediaMetadataRetriever, T t);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: VideoDecoder.java */
    /* loaded from: classes.dex */
    public static final class f implements e<ParcelFileDescriptor> {
        f() {
        }

        @Override // com.bumptech.glide.load.o.c.y.e
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(MediaMetadataRetriever mediaMetadataRetriever, ParcelFileDescriptor parcelFileDescriptor) {
            mediaMetadataRetriever.setDataSource(parcelFileDescriptor.getFileDescriptor());
        }
    }

    y(com.bumptech.glide.load.engine.z.e eVar, e<T> eVar2) {
        this(eVar, eVar2, f9405c);
    }

    public static com.bumptech.glide.load.j<AssetFileDescriptor, Bitmap> c(com.bumptech.glide.load.engine.z.e eVar) {
        return new y(eVar, new c(null));
    }

    private static Bitmap d(MediaMetadataRetriever mediaMetadataRetriever, long j2, int i2, int i3, int i4, k kVar) {
        Bitmap f2 = (Build.VERSION.SDK_INT < 27 || i3 == Integer.MIN_VALUE || i4 == Integer.MIN_VALUE || kVar == k.f9364f) ? null : f(mediaMetadataRetriever, j2, i2, i3, i4, kVar);
        return f2 == null ? e(mediaMetadataRetriever, j2, i2) : f2;
    }

    private static Bitmap e(MediaMetadataRetriever mediaMetadataRetriever, long j2, int i2) {
        return mediaMetadataRetriever.getFrameAtTime(j2, i2);
    }

    @TargetApi(27)
    private static Bitmap f(MediaMetadataRetriever mediaMetadataRetriever, long j2, int i2, int i3, int i4, k kVar) {
        try {
            int parseInt = Integer.parseInt(mediaMetadataRetriever.extractMetadata(18));
            int parseInt2 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(19));
            int parseInt3 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(24));
            if (parseInt3 == 90 || parseInt3 == 270) {
                parseInt2 = parseInt;
                parseInt = parseInt2;
            }
            float b2 = kVar.b(parseInt, parseInt2, i3, i4);
            return mediaMetadataRetriever.getScaledFrameAtTime(j2, i2, Math.round(parseInt * b2), Math.round(b2 * parseInt2));
        } catch (Throwable th) {
            if (!Log.isLoggable("VideoDecoder", 3)) {
                return null;
            }
            Log.d("VideoDecoder", "Exception trying to decode frame on oreo+", th);
            return null;
        }
    }

    public static com.bumptech.glide.load.j<ParcelFileDescriptor, Bitmap> g(com.bumptech.glide.load.engine.z.e eVar) {
        return new y(eVar, new f());
    }

    @Override // com.bumptech.glide.load.j
    public boolean a(T t, com.bumptech.glide.load.i iVar) {
        return true;
    }

    @Override // com.bumptech.glide.load.j
    public com.bumptech.glide.load.engine.u<Bitmap> b(T t, int i2, int i3, com.bumptech.glide.load.i iVar) throws IOException {
        long longValue = ((Long) iVar.a(a)).longValue();
        if (longValue < 0 && longValue != -1) {
            throw new IllegalArgumentException("Requested frame must be non-negative, or DEFAULT_FRAME, given: " + longValue);
        }
        Integer num = (Integer) iVar.a(f9404b);
        if (num == null) {
            num = 2;
        }
        k kVar = (k) iVar.a(k.f9366h);
        if (kVar == null) {
            kVar = k.f9365g;
        }
        k kVar2 = kVar;
        MediaMetadataRetriever a2 = this.f9408f.a();
        try {
            try {
                this.f9406d.a(a2, t);
                Bitmap d2 = d(a2, longValue, num.intValue(), i2, i3, kVar2);
                a2.release();
                return com.bumptech.glide.load.o.c.d.f(d2, this.f9407e);
            } catch (RuntimeException e2) {
                throw new IOException(e2);
            }
        } catch (Throwable th) {
            a2.release();
            throw th;
        }
    }

    y(com.bumptech.glide.load.engine.z.e eVar, e<T> eVar2, d dVar) {
        this.f9407e = eVar;
        this.f9406d = eVar2;
        this.f9408f = dVar;
    }
}
