package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.engine.a0.a;
import java.io.File;

/* compiled from: DataCacheWriter.java */
/* loaded from: classes.dex */
class e<DataType> implements a.b {
    private final com.bumptech.glide.load.d<DataType> a;

    /* renamed from: b, reason: collision with root package name */
    private final DataType f9101b;

    /* renamed from: c, reason: collision with root package name */
    private final com.bumptech.glide.load.i f9102c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(com.bumptech.glide.load.d<DataType> dVar, DataType datatype, com.bumptech.glide.load.i iVar) {
        this.a = dVar;
        this.f9101b = datatype;
        this.f9102c = iVar;
    }

    @Override // com.bumptech.glide.load.engine.a0.a.b
    public boolean a(File file) {
        return this.a.a(this.f9101b, file, this.f9102c);
    }
}
