package com.bumptech.glide.load.engine.a0;

import com.bumptech.glide.load.engine.a0.a;
import java.io.File;

/* compiled from: DiskLruCacheFactory.java */
/* loaded from: classes.dex */
public class d implements a.InterfaceC0125a {
    private final long a;

    /* renamed from: b, reason: collision with root package name */
    private final a f9058b;

    /* compiled from: DiskLruCacheFactory.java */
    /* loaded from: classes.dex */
    public interface a {
        File a();
    }

    public d(a aVar, long j2) {
        this.a = j2;
        this.f9058b = aVar;
    }

    @Override // com.bumptech.glide.load.engine.a0.a.InterfaceC0125a
    public com.bumptech.glide.load.engine.a0.a c() {
        File a2 = this.f9058b.a();
        if (a2 == null) {
            return null;
        }
        if (a2.mkdirs() || (a2.exists() && a2.isDirectory())) {
            return e.c(a2, this.a);
        }
        return null;
    }
}
