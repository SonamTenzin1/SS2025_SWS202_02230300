package com.bumptech.glide.load.engine.a0;

import android.util.Log;
import com.bumptech.glide.k.a;
import com.bumptech.glide.load.engine.a0.a;
import java.io.File;
import java.io.IOException;

/* compiled from: DiskLruCacheWrapper.java */
/* loaded from: classes.dex */
public class e implements a {

    /* renamed from: b, reason: collision with root package name */
    private final File f9059b;

    /* renamed from: c, reason: collision with root package name */
    private final long f9060c;

    /* renamed from: e, reason: collision with root package name */
    private com.bumptech.glide.k.a f9062e;

    /* renamed from: d, reason: collision with root package name */
    private final c f9061d = new c();
    private final j a = new j();

    @Deprecated
    protected e(File file, long j2) {
        this.f9059b = file;
        this.f9060c = j2;
    }

    public static a c(File file, long j2) {
        return new e(file, j2);
    }

    private synchronized com.bumptech.glide.k.a d() throws IOException {
        if (this.f9062e == null) {
            this.f9062e = com.bumptech.glide.k.a.D(this.f9059b, 1, 1, this.f9060c);
        }
        return this.f9062e;
    }

    @Override // com.bumptech.glide.load.engine.a0.a
    public void a(com.bumptech.glide.load.f fVar, a.b bVar) {
        com.bumptech.glide.k.a d2;
        String b2 = this.a.b(fVar);
        this.f9061d.a(b2);
        try {
            if (Log.isLoggable("DiskLruCacheWrapper", 2)) {
                Log.v("DiskLruCacheWrapper", "Put: Obtained: " + b2 + " for for Key: " + fVar);
            }
            try {
                d2 = d();
            } catch (IOException e2) {
                if (Log.isLoggable("DiskLruCacheWrapper", 5)) {
                    Log.w("DiskLruCacheWrapper", "Unable to put to disk cache", e2);
                }
            }
            if (d2.A(b2) != null) {
                return;
            }
            a.c y = d2.y(b2);
            if (y != null) {
                try {
                    if (bVar.a(y.f(0))) {
                        y.e();
                    }
                    y.b();
                    return;
                } catch (Throwable th) {
                    y.b();
                    throw th;
                }
            }
            throw new IllegalStateException("Had two simultaneous puts for: " + b2);
        } finally {
            this.f9061d.b(b2);
        }
    }

    @Override // com.bumptech.glide.load.engine.a0.a
    public File b(com.bumptech.glide.load.f fVar) {
        String b2 = this.a.b(fVar);
        if (Log.isLoggable("DiskLruCacheWrapper", 2)) {
            Log.v("DiskLruCacheWrapper", "Get: Obtained: " + b2 + " for for Key: " + fVar);
        }
        try {
            a.e A = d().A(b2);
            if (A != null) {
                return A.a(0);
            }
            return null;
        } catch (IOException e2) {
            if (!Log.isLoggable("DiskLruCacheWrapper", 5)) {
                return null;
            }
            Log.w("DiskLruCacheWrapper", "Unable to get from disk cache", e2);
            return null;
        }
    }
}
