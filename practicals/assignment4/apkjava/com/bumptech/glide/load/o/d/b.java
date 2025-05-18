package com.bumptech.glide.load.o.d;

import com.bumptech.glide.load.engine.u;
import com.bumptech.glide.r.j;

/* compiled from: BytesResource.java */
/* loaded from: classes.dex */
public class b implements u<byte[]> {

    /* renamed from: f, reason: collision with root package name */
    private final byte[] f9409f;

    public b(byte[] bArr) {
        this.f9409f = (byte[]) j.d(bArr);
    }

    @Override // com.bumptech.glide.load.engine.u
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public byte[] get() {
        return this.f9409f;
    }

    @Override // com.bumptech.glide.load.engine.u
    public void c() {
    }

    @Override // com.bumptech.glide.load.engine.u
    public int d() {
        return this.f9409f.length;
    }

    @Override // com.bumptech.glide.load.engine.u
    public Class<byte[]> e() {
        return byte[].class;
    }
}
