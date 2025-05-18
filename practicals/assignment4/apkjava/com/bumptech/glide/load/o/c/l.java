package com.bumptech.glide.load.o.c;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.Log;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.o.c.k;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import okhttp3.HttpUrl;

/* compiled from: Downsampler.java */
/* loaded from: classes.dex */
public final class l {
    public static final com.bumptech.glide.load.h<com.bumptech.glide.load.b> a = com.bumptech.glide.load.h.f("com.bumptech.glide.load.resource.bitmap.Downsampler.DecodeFormat", com.bumptech.glide.load.b.f9031h);

    /* renamed from: b, reason: collision with root package name */
    @Deprecated
    public static final com.bumptech.glide.load.h<k> f9370b = k.f9366h;

    /* renamed from: c, reason: collision with root package name */
    public static final com.bumptech.glide.load.h<Boolean> f9371c;

    /* renamed from: d, reason: collision with root package name */
    public static final com.bumptech.glide.load.h<Boolean> f9372d;

    /* renamed from: e, reason: collision with root package name */
    private static final Set<String> f9373e;

    /* renamed from: f, reason: collision with root package name */
    private static final b f9374f;

    /* renamed from: g, reason: collision with root package name */
    private static final Set<ImageHeaderParser.ImageType> f9375g;

    /* renamed from: h, reason: collision with root package name */
    private static final Queue<BitmapFactory.Options> f9376h;

    /* renamed from: i, reason: collision with root package name */
    private final com.bumptech.glide.load.engine.z.e f9377i;

    /* renamed from: j, reason: collision with root package name */
    private final DisplayMetrics f9378j;

    /* renamed from: k, reason: collision with root package name */
    private final com.bumptech.glide.load.engine.z.b f9379k;
    private final List<ImageHeaderParser> l;
    private final q m = q.a();

    /* compiled from: Downsampler.java */
    /* loaded from: classes.dex */
    class a implements b {
        a() {
        }

        @Override // com.bumptech.glide.load.o.c.l.b
        public void a(com.bumptech.glide.load.engine.z.e eVar, Bitmap bitmap) {
        }

        @Override // com.bumptech.glide.load.o.c.l.b
        public void b() {
        }
    }

    /* compiled from: Downsampler.java */
    /* loaded from: classes.dex */
    public interface b {
        void a(com.bumptech.glide.load.engine.z.e eVar, Bitmap bitmap) throws IOException;

        void b();
    }

    static {
        Boolean bool = Boolean.FALSE;
        f9371c = com.bumptech.glide.load.h.f("com.bumptech.glide.load.resource.bitmap.Downsampler.FixBitmapSize", bool);
        f9372d = com.bumptech.glide.load.h.f("com.bumptech.glide.load.resource.bitmap.Downsampler.AllowHardwareDecode", bool);
        f9373e = Collections.unmodifiableSet(new HashSet(Arrays.asList("image/vnd.wap.wbmp", "image/x-ico")));
        f9374f = new a();
        f9375g = Collections.unmodifiableSet(EnumSet.of(ImageHeaderParser.ImageType.JPEG, ImageHeaderParser.ImageType.PNG_A, ImageHeaderParser.ImageType.PNG));
        f9376h = com.bumptech.glide.r.k.f(0);
    }

    public l(List<ImageHeaderParser> list, DisplayMetrics displayMetrics, com.bumptech.glide.load.engine.z.e eVar, com.bumptech.glide.load.engine.z.b bVar) {
        this.l = list;
        this.f9378j = (DisplayMetrics) com.bumptech.glide.r.j.d(displayMetrics);
        this.f9377i = (com.bumptech.glide.load.engine.z.e) com.bumptech.glide.r.j.d(eVar);
        this.f9379k = (com.bumptech.glide.load.engine.z.b) com.bumptech.glide.r.j.d(bVar);
    }

    private static int a(double d2) {
        int j2 = j(d2);
        double d3 = j2;
        Double.isNaN(d3);
        int t = t(d3 * d2);
        double d4 = t / j2;
        Double.isNaN(d4);
        double d5 = t;
        Double.isNaN(d5);
        return t((d2 / d4) * d5);
    }

    private void b(InputStream inputStream, com.bumptech.glide.load.b bVar, boolean z, boolean z2, BitmapFactory.Options options, int i2, int i3) {
        if (this.m.c(i2, i3, options, bVar, z, z2)) {
            return;
        }
        if (bVar != com.bumptech.glide.load.b.PREFER_ARGB_8888 && Build.VERSION.SDK_INT != 16) {
            boolean z3 = false;
            try {
                z3 = com.bumptech.glide.load.e.b(this.l, inputStream, this.f9379k).hasAlpha();
            } catch (IOException e2) {
                if (Log.isLoggable("Downsampler", 3)) {
                    Log.d("Downsampler", "Cannot determine whether the image has alpha or not from header, format " + bVar, e2);
                }
            }
            Bitmap.Config config = z3 ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565;
            options.inPreferredConfig = config;
            if (config == Bitmap.Config.RGB_565) {
                options.inDither = true;
                return;
            }
            return;
        }
        options.inPreferredConfig = Bitmap.Config.ARGB_8888;
    }

    private static void c(ImageHeaderParser.ImageType imageType, InputStream inputStream, b bVar, com.bumptech.glide.load.engine.z.e eVar, k kVar, int i2, int i3, int i4, int i5, int i6, BitmapFactory.Options options) throws IOException {
        float b2;
        int min;
        int i7;
        int i8;
        int floor;
        double floor2;
        int i9;
        if (i3 <= 0 || i4 <= 0) {
            if (Log.isLoggable("Downsampler", 3)) {
                Log.d("Downsampler", "Unable to determine dimensions for: " + imageType + " with target [" + i5 + "x" + i6 + "]");
                return;
            }
            return;
        }
        if (i2 != 90 && i2 != 270) {
            b2 = kVar.b(i3, i4, i5, i6);
        } else {
            b2 = kVar.b(i4, i3, i5, i6);
        }
        if (b2 > 0.0f) {
            k.g a2 = kVar.a(i3, i4, i5, i6);
            if (a2 != null) {
                float f2 = i3;
                float f3 = i4;
                int t = i3 / t(b2 * f2);
                int t2 = i4 / t(b2 * f3);
                k.g gVar = k.g.MEMORY;
                if (a2 == gVar) {
                    min = Math.max(t, t2);
                } else {
                    min = Math.min(t, t2);
                }
                int i10 = Build.VERSION.SDK_INT;
                if (i10 > 23 || !f9373e.contains(options.outMimeType)) {
                    int max = Math.max(1, Integer.highestOneBit(min));
                    i7 = (a2 != gVar || ((float) max) >= 1.0f / b2) ? max : max << 1;
                } else {
                    i7 = 1;
                }
                options.inSampleSize = i7;
                if (imageType == ImageHeaderParser.ImageType.JPEG) {
                    float min2 = Math.min(i7, 8);
                    i8 = i10;
                    floor = (int) Math.ceil(f2 / min2);
                    i9 = (int) Math.ceil(f3 / min2);
                    int i11 = i7 / 8;
                    if (i11 > 0) {
                        floor /= i11;
                        i9 /= i11;
                    }
                } else {
                    i8 = i10;
                    if (imageType != ImageHeaderParser.ImageType.PNG && imageType != ImageHeaderParser.ImageType.PNG_A) {
                        if (imageType == ImageHeaderParser.ImageType.WEBP || imageType == ImageHeaderParser.ImageType.WEBP_A) {
                            if (i8 >= 24) {
                                float f4 = i7;
                                floor = Math.round(f2 / f4);
                                i9 = Math.round(f3 / f4);
                            } else {
                                float f5 = i7;
                                floor = (int) Math.floor(f2 / f5);
                                floor2 = Math.floor(f3 / f5);
                            }
                        } else if (i3 % i7 == 0 && i4 % i7 == 0) {
                            floor = i3 / i7;
                            i9 = i4 / i7;
                        } else {
                            int[] k2 = k(inputStream, options, bVar, eVar);
                            int i12 = k2[0];
                            i9 = k2[1];
                            floor = i12;
                        }
                    } else {
                        float f6 = i7;
                        floor = (int) Math.floor(f2 / f6);
                        floor2 = Math.floor(f3 / f6);
                    }
                    i9 = (int) floor2;
                }
                double b3 = kVar.b(floor, i9, i5, i6);
                if (i8 >= 19) {
                    options.inTargetDensity = a(b3);
                    options.inDensity = j(b3);
                }
                if (o(options)) {
                    options.inScaled = true;
                } else {
                    options.inTargetDensity = 0;
                    options.inDensity = 0;
                }
                if (Log.isLoggable("Downsampler", 2)) {
                    Log.v("Downsampler", "Calculate scaling, source: [" + i3 + "x" + i4 + "], target: [" + i5 + "x" + i6 + "], power of two scaled: [" + floor + "x" + i9 + "], exact scale factor: " + b2 + ", power of 2 sample size: " + i7 + ", adjusted scale factor: " + b3 + ", target density: " + options.inTargetDensity + ", density: " + options.inDensity);
                    return;
                }
                return;
            }
            throw new IllegalArgumentException("Cannot round with null rounding");
        }
        throw new IllegalArgumentException("Cannot scale with factor: " + b2 + " from: " + kVar + ", source: [" + i3 + "x" + i4 + "], target: [" + i5 + "x" + i6 + "]");
    }

    private Bitmap f(InputStream inputStream, BitmapFactory.Options options, k kVar, com.bumptech.glide.load.b bVar, boolean z, int i2, int i3, boolean z2, b bVar2) throws IOException {
        l lVar;
        int round;
        int round2;
        int i4;
        long b2 = com.bumptech.glide.r.f.b();
        int[] k2 = k(inputStream, options, bVar2, this.f9377i);
        int i5 = k2[0];
        int i6 = k2[1];
        String str = options.outMimeType;
        boolean z3 = (i5 == -1 || i6 == -1) ? false : z;
        int a2 = com.bumptech.glide.load.e.a(this.l, inputStream, this.f9379k);
        int j2 = w.j(a2);
        boolean m = w.m(a2);
        int i7 = i2 == Integer.MIN_VALUE ? i5 : i2;
        int i8 = i3 == Integer.MIN_VALUE ? i6 : i3;
        ImageHeaderParser.ImageType b3 = com.bumptech.glide.load.e.b(this.l, inputStream, this.f9379k);
        c(b3, inputStream, bVar2, this.f9377i, kVar, j2, i5, i6, i7, i8, options);
        b(inputStream, bVar, z3, m, options, i7, i8);
        boolean z4 = Build.VERSION.SDK_INT >= 19;
        if (options.inSampleSize == 1 || z4) {
            lVar = this;
            if (lVar.v(b3)) {
                if (i5 < 0 || i6 < 0 || !z2 || !z4) {
                    float f2 = o(options) ? options.inTargetDensity / options.inDensity : 1.0f;
                    int i9 = options.inSampleSize;
                    float f3 = i9;
                    int ceil = (int) Math.ceil(i5 / f3);
                    int ceil2 = (int) Math.ceil(i6 / f3);
                    round = Math.round(ceil * f2);
                    round2 = Math.round(ceil2 * f2);
                    if (Log.isLoggable("Downsampler", 2)) {
                        Log.v("Downsampler", "Calculated target [" + round + "x" + round2 + "] for source [" + i5 + "x" + i6 + "], sampleSize: " + i9 + ", targetDensity: " + options.inTargetDensity + ", density: " + options.inDensity + ", density multiplier: " + f2);
                    }
                } else {
                    round = i7;
                    round2 = i8;
                }
                if (round > 0 && round2 > 0) {
                    u(options, lVar.f9377i, round, round2);
                }
            }
        } else {
            lVar = this;
        }
        Bitmap g2 = g(inputStream, options, bVar2, lVar.f9377i);
        bVar2.a(lVar.f9377i, g2);
        if (Log.isLoggable("Downsampler", 2)) {
            i4 = a2;
            p(i5, i6, str, options, g2, i2, i3, b2);
        } else {
            i4 = a2;
        }
        Bitmap bitmap = null;
        if (g2 != null) {
            g2.setDensity(lVar.f9378j.densityDpi);
            bitmap = w.n(lVar.f9377i, g2, i4);
            if (!g2.equals(bitmap)) {
                lVar.f9377i.c(g2);
            }
        }
        return bitmap;
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:?, code lost:
    
        throw r1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static Bitmap g(InputStream inputStream, BitmapFactory.Options options, b bVar, com.bumptech.glide.load.engine.z.e eVar) throws IOException {
        if (options.inJustDecodeBounds) {
            inputStream.mark(10485760);
        } else {
            bVar.b();
        }
        int i2 = options.outWidth;
        int i3 = options.outHeight;
        String str = options.outMimeType;
        w.i().lock();
        try {
            try {
                Bitmap decodeStream = BitmapFactory.decodeStream(inputStream, null, options);
                w.i().unlock();
                if (options.inJustDecodeBounds) {
                    inputStream.reset();
                }
                return decodeStream;
            } catch (IllegalArgumentException e2) {
                IOException q = q(e2, i2, i3, str, options);
                if (Log.isLoggable("Downsampler", 3)) {
                    Log.d("Downsampler", "Failed to decode with inBitmap, trying again without Bitmap re-use", q);
                }
                if (options.inBitmap != null) {
                    try {
                        inputStream.reset();
                        eVar.c(options.inBitmap);
                        options.inBitmap = null;
                        Bitmap g2 = g(inputStream, options, bVar, eVar);
                        w.i().unlock();
                        return g2;
                    } catch (IOException unused) {
                        throw q;
                    }
                }
                throw q;
            }
        } catch (Throwable th) {
            w.i().unlock();
            throw th;
        }
    }

    @TargetApi(19)
    private static String h(Bitmap bitmap) {
        String str;
        if (bitmap == null) {
            return null;
        }
        if (Build.VERSION.SDK_INT >= 19) {
            str = " (" + bitmap.getAllocationByteCount() + ")";
        } else {
            str = HttpUrl.FRAGMENT_ENCODE_SET;
        }
        return "[" + bitmap.getWidth() + "x" + bitmap.getHeight() + "] " + bitmap.getConfig() + str;
    }

    private static synchronized BitmapFactory.Options i() {
        BitmapFactory.Options poll;
        synchronized (l.class) {
            Queue<BitmapFactory.Options> queue = f9376h;
            synchronized (queue) {
                poll = queue.poll();
            }
            if (poll == null) {
                poll = new BitmapFactory.Options();
                s(poll);
            }
        }
        return poll;
    }

    private static int j(double d2) {
        if (d2 > 1.0d) {
            d2 = 1.0d / d2;
        }
        return (int) Math.round(d2 * 2.147483647E9d);
    }

    private static int[] k(InputStream inputStream, BitmapFactory.Options options, b bVar, com.bumptech.glide.load.engine.z.e eVar) throws IOException {
        options.inJustDecodeBounds = true;
        g(inputStream, options, bVar, eVar);
        options.inJustDecodeBounds = false;
        return new int[]{options.outWidth, options.outHeight};
    }

    private static String l(BitmapFactory.Options options) {
        return h(options.inBitmap);
    }

    private static boolean o(BitmapFactory.Options options) {
        int i2;
        int i3 = options.inTargetDensity;
        return i3 > 0 && (i2 = options.inDensity) > 0 && i3 != i2;
    }

    private static void p(int i2, int i3, String str, BitmapFactory.Options options, Bitmap bitmap, int i4, int i5, long j2) {
        Log.v("Downsampler", "Decoded " + h(bitmap) + " from [" + i2 + "x" + i3 + "] " + str + " with inBitmap " + l(options) + " for [" + i4 + "x" + i5 + "], sample size: " + options.inSampleSize + ", density: " + options.inDensity + ", target density: " + options.inTargetDensity + ", thread: " + Thread.currentThread().getName() + ", duration: " + com.bumptech.glide.r.f.a(j2));
    }

    private static IOException q(IllegalArgumentException illegalArgumentException, int i2, int i3, String str, BitmapFactory.Options options) {
        return new IOException("Exception decoding bitmap, outWidth: " + i2 + ", outHeight: " + i3 + ", outMimeType: " + str + ", inBitmap: " + l(options), illegalArgumentException);
    }

    private static void r(BitmapFactory.Options options) {
        s(options);
        Queue<BitmapFactory.Options> queue = f9376h;
        synchronized (queue) {
            queue.offer(options);
        }
    }

    private static void s(BitmapFactory.Options options) {
        options.inTempStorage = null;
        options.inDither = false;
        options.inScaled = false;
        options.inSampleSize = 1;
        options.inPreferredConfig = null;
        options.inJustDecodeBounds = false;
        options.inDensity = 0;
        options.inTargetDensity = 0;
        options.outWidth = 0;
        options.outHeight = 0;
        options.outMimeType = null;
        options.inBitmap = null;
        options.inMutable = true;
    }

    private static int t(double d2) {
        return (int) (d2 + 0.5d);
    }

    @TargetApi(26)
    private static void u(BitmapFactory.Options options, com.bumptech.glide.load.engine.z.e eVar, int i2, int i3) {
        Bitmap.Config config;
        if (Build.VERSION.SDK_INT < 26) {
            config = null;
        } else if (options.inPreferredConfig == Bitmap.Config.HARDWARE) {
            return;
        } else {
            config = options.outConfig;
        }
        if (config == null) {
            config = options.inPreferredConfig;
        }
        options.inBitmap = eVar.e(i2, i3, config);
    }

    private boolean v(ImageHeaderParser.ImageType imageType) {
        if (Build.VERSION.SDK_INT >= 19) {
            return true;
        }
        return f9375g.contains(imageType);
    }

    public com.bumptech.glide.load.engine.u<Bitmap> d(InputStream inputStream, int i2, int i3, com.bumptech.glide.load.i iVar) throws IOException {
        return e(inputStream, i2, i3, iVar, f9374f);
    }

    public com.bumptech.glide.load.engine.u<Bitmap> e(InputStream inputStream, int i2, int i3, com.bumptech.glide.load.i iVar, b bVar) throws IOException {
        com.bumptech.glide.r.j.a(inputStream.markSupported(), "You must provide an InputStream that supports mark()");
        byte[] bArr = (byte[]) this.f9379k.e(65536, byte[].class);
        BitmapFactory.Options i4 = i();
        i4.inTempStorage = bArr;
        com.bumptech.glide.load.b bVar2 = (com.bumptech.glide.load.b) iVar.a(a);
        k kVar = (k) iVar.a(k.f9366h);
        boolean booleanValue = ((Boolean) iVar.a(f9371c)).booleanValue();
        com.bumptech.glide.load.h<Boolean> hVar = f9372d;
        try {
            return d.f(f(inputStream, i4, kVar, bVar2, iVar.a(hVar) != null && ((Boolean) iVar.a(hVar)).booleanValue(), i2, i3, booleanValue, bVar), this.f9377i);
        } finally {
            r(i4);
            this.f9379k.d(bArr);
        }
    }

    public boolean m(InputStream inputStream) {
        return true;
    }

    public boolean n(ByteBuffer byteBuffer) {
        return true;
    }
}
