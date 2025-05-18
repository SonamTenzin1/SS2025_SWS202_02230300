package com.bumptech.glide.load.o.g;

import android.graphics.Bitmap;
import com.bumptech.glide.l.a;

/* compiled from: GifBitmapProvider.java */
/* loaded from: classes.dex */
public final class b implements a.InterfaceC0122a {
    private final com.bumptech.glide.load.engine.z.e a;

    /* renamed from: b, reason: collision with root package name */
    private final com.bumptech.glide.load.engine.z.b f9417b;

    public b(com.bumptech.glide.load.engine.z.e eVar, com.bumptech.glide.load.engine.z.b bVar) {
        this.a = eVar;
        this.f9417b = bVar;
    }

    @Override // com.bumptech.glide.l.a.InterfaceC0122a
    public Bitmap a(int i2, int i3, Bitmap.Config config) {
        return this.a.e(i2, i3, config);
    }

    @Override // com.bumptech.glide.l.a.InterfaceC0122a
    public int[] b(int i2) {
        com.bumptech.glide.load.engine.z.b bVar = this.f9417b;
        if (bVar == null) {
            return new int[i2];
        }
        return (int[]) bVar.e(i2, int[].class);
    }

    @Override // com.bumptech.glide.l.a.InterfaceC0122a
    public void c(Bitmap bitmap) {
        this.a.c(bitmap);
    }

    @Override // com.bumptech.glide.l.a.InterfaceC0122a
    public void d(byte[] bArr) {
        com.bumptech.glide.load.engine.z.b bVar = this.f9417b;
        if (bVar == null) {
            return;
        }
        bVar.d(bArr);
    }

    @Override // com.bumptech.glide.l.a.InterfaceC0122a
    public byte[] e(int i2) {
        com.bumptech.glide.load.engine.z.b bVar = this.f9417b;
        if (bVar == null) {
            return new byte[i2];
        }
        return (byte[]) bVar.e(i2, byte[].class);
    }

    @Override // com.bumptech.glide.l.a.InterfaceC0122a
    public void f(int[] iArr) {
        com.bumptech.glide.load.engine.z.b bVar = this.f9417b;
        if (bVar == null) {
            return;
        }
        bVar.d(iArr);
    }
}
