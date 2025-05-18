package com.bumptech.glide.load.engine.z;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.os.Build;
import android.util.Log;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* compiled from: LruBitmapPool.java */
/* loaded from: classes.dex */
public class k implements e {
    private static final Bitmap.Config a = Bitmap.Config.ARGB_8888;

    /* renamed from: b, reason: collision with root package name */
    private final l f9235b;

    /* renamed from: c, reason: collision with root package name */
    private final Set<Bitmap.Config> f9236c;

    /* renamed from: d, reason: collision with root package name */
    private final long f9237d;

    /* renamed from: e, reason: collision with root package name */
    private final a f9238e;

    /* renamed from: f, reason: collision with root package name */
    private long f9239f;

    /* renamed from: g, reason: collision with root package name */
    private long f9240g;

    /* renamed from: h, reason: collision with root package name */
    private int f9241h;

    /* renamed from: i, reason: collision with root package name */
    private int f9242i;

    /* renamed from: j, reason: collision with root package name */
    private int f9243j;

    /* renamed from: k, reason: collision with root package name */
    private int f9244k;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: LruBitmapPool.java */
    /* loaded from: classes.dex */
    public interface a {
        void a(Bitmap bitmap);

        void b(Bitmap bitmap);
    }

    /* compiled from: LruBitmapPool.java */
    /* loaded from: classes.dex */
    private static final class b implements a {
        b() {
        }

        @Override // com.bumptech.glide.load.engine.z.k.a
        public void a(Bitmap bitmap) {
        }

        @Override // com.bumptech.glide.load.engine.z.k.a
        public void b(Bitmap bitmap) {
        }
    }

    k(long j2, l lVar, Set<Bitmap.Config> set) {
        this.f9237d = j2;
        this.f9239f = j2;
        this.f9235b = lVar;
        this.f9236c = set;
        this.f9238e = new b();
    }

    @TargetApi(26)
    private static void f(Bitmap.Config config) {
        if (Build.VERSION.SDK_INT >= 26 && config == Bitmap.Config.HARDWARE) {
            throw new IllegalArgumentException("Cannot create a mutable Bitmap with config: " + config + ". Consider setting Downsampler#ALLOW_HARDWARE_CONFIG to false in your RequestOptions and/or in GlideBuilder.setDefaultRequestOptions");
        }
    }

    private static Bitmap g(int i2, int i3, Bitmap.Config config) {
        if (config == null) {
            config = a;
        }
        return Bitmap.createBitmap(i2, i3, config);
    }

    private void h() {
        if (Log.isLoggable("LruBitmapPool", 2)) {
            i();
        }
    }

    private void i() {
        Log.v("LruBitmapPool", "Hits=" + this.f9241h + ", misses=" + this.f9242i + ", puts=" + this.f9243j + ", evictions=" + this.f9244k + ", currentSize=" + this.f9240g + ", maxSize=" + this.f9239f + "\nStrategy=" + this.f9235b);
    }

    private void j() {
        q(this.f9239f);
    }

    @TargetApi(26)
    private static Set<Bitmap.Config> k() {
        HashSet hashSet = new HashSet(Arrays.asList(Bitmap.Config.values()));
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 19) {
            hashSet.add(null);
        }
        if (i2 >= 26) {
            hashSet.remove(Bitmap.Config.HARDWARE);
        }
        return Collections.unmodifiableSet(hashSet);
    }

    private static l l() {
        if (Build.VERSION.SDK_INT >= 19) {
            return new n();
        }
        return new c();
    }

    private synchronized Bitmap m(int i2, int i3, Bitmap.Config config) {
        Bitmap d2;
        f(config);
        d2 = this.f9235b.d(i2, i3, config != null ? config : a);
        if (d2 == null) {
            if (Log.isLoggable("LruBitmapPool", 3)) {
                Log.d("LruBitmapPool", "Missing bitmap=" + this.f9235b.b(i2, i3, config));
            }
            this.f9242i++;
        } else {
            this.f9241h++;
            this.f9240g -= this.f9235b.e(d2);
            this.f9238e.a(d2);
            p(d2);
        }
        if (Log.isLoggable("LruBitmapPool", 2)) {
            Log.v("LruBitmapPool", "Get bitmap=" + this.f9235b.b(i2, i3, config));
        }
        h();
        return d2;
    }

    @TargetApi(19)
    private static void o(Bitmap bitmap) {
        if (Build.VERSION.SDK_INT >= 19) {
            bitmap.setPremultiplied(true);
        }
    }

    private static void p(Bitmap bitmap) {
        bitmap.setHasAlpha(true);
        o(bitmap);
    }

    private synchronized void q(long j2) {
        while (this.f9240g > j2) {
            Bitmap a2 = this.f9235b.a();
            if (a2 == null) {
                if (Log.isLoggable("LruBitmapPool", 5)) {
                    Log.w("LruBitmapPool", "Size mismatch, resetting");
                    i();
                }
                this.f9240g = 0L;
                return;
            }
            this.f9238e.a(a2);
            this.f9240g -= this.f9235b.e(a2);
            this.f9244k++;
            if (Log.isLoggable("LruBitmapPool", 3)) {
                Log.d("LruBitmapPool", "Evicting bitmap=" + this.f9235b.f(a2));
            }
            h();
            a2.recycle();
        }
    }

    @Override // com.bumptech.glide.load.engine.z.e
    @SuppressLint({"InlinedApi"})
    public void a(int i2) {
        if (Log.isLoggable("LruBitmapPool", 3)) {
            Log.d("LruBitmapPool", "trimMemory, level=" + i2);
        }
        if (i2 >= 40) {
            b();
        } else if (i2 >= 20 || i2 == 15) {
            q(n() / 2);
        }
    }

    @Override // com.bumptech.glide.load.engine.z.e
    public void b() {
        if (Log.isLoggable("LruBitmapPool", 3)) {
            Log.d("LruBitmapPool", "clearMemory");
        }
        q(0L);
    }

    @Override // com.bumptech.glide.load.engine.z.e
    public synchronized void c(Bitmap bitmap) {
        try {
            if (bitmap != null) {
                if (!bitmap.isRecycled()) {
                    if (bitmap.isMutable() && this.f9235b.e(bitmap) <= this.f9239f && this.f9236c.contains(bitmap.getConfig())) {
                        int e2 = this.f9235b.e(bitmap);
                        this.f9235b.c(bitmap);
                        this.f9238e.b(bitmap);
                        this.f9243j++;
                        this.f9240g += e2;
                        if (Log.isLoggable("LruBitmapPool", 2)) {
                            Log.v("LruBitmapPool", "Put bitmap in pool=" + this.f9235b.f(bitmap));
                        }
                        h();
                        j();
                        return;
                    }
                    if (Log.isLoggable("LruBitmapPool", 2)) {
                        Log.v("LruBitmapPool", "Reject bitmap from pool, bitmap: " + this.f9235b.f(bitmap) + ", is mutable: " + bitmap.isMutable() + ", is allowed config: " + this.f9236c.contains(bitmap.getConfig()));
                    }
                    bitmap.recycle();
                    return;
                }
                throw new IllegalStateException("Cannot pool recycled bitmap");
            }
            throw new NullPointerException("Bitmap must not be null");
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // com.bumptech.glide.load.engine.z.e
    public Bitmap d(int i2, int i3, Bitmap.Config config) {
        Bitmap m = m(i2, i3, config);
        if (m != null) {
            m.eraseColor(0);
            return m;
        }
        return g(i2, i3, config);
    }

    @Override // com.bumptech.glide.load.engine.z.e
    public Bitmap e(int i2, int i3, Bitmap.Config config) {
        Bitmap m = m(i2, i3, config);
        return m == null ? g(i2, i3, config) : m;
    }

    public long n() {
        return this.f9239f;
    }

    public k(long j2) {
        this(j2, l(), k());
    }
}
