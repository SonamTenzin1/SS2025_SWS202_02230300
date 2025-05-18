package com.bumptech.glide.load.engine.a0;

import android.content.Context;
import com.bumptech.glide.load.engine.a0.d;
import java.io.File;

/* compiled from: InternalCacheDiskCacheFactory.java */
/* loaded from: classes.dex */
public final class f extends d {

    /* compiled from: InternalCacheDiskCacheFactory.java */
    /* loaded from: classes.dex */
    class a implements d.a {
        final /* synthetic */ Context a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f9063b;

        a(Context context, String str) {
            this.a = context;
            this.f9063b = str;
        }

        @Override // com.bumptech.glide.load.engine.a0.d.a
        public File a() {
            File cacheDir = this.a.getCacheDir();
            if (cacheDir == null) {
                return null;
            }
            return this.f9063b != null ? new File(cacheDir, this.f9063b) : cacheDir;
        }
    }

    public f(Context context) {
        this(context, "image_manager_disk_cache", 262144000L);
    }

    public f(Context context, String str, long j2) {
        super(new a(context, str), j2);
    }
}
