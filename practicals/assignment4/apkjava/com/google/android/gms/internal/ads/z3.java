package com.google.android.gms.internal.ads;

import android.graphics.Bitmap;
import java.io.ByteArrayOutputStream;

/* loaded from: classes2.dex */
final class z3 implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ Bitmap f13672f;

    /* renamed from: g, reason: collision with root package name */
    private final /* synthetic */ zzauq f13673g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z3(zzauq zzauqVar, Bitmap bitmap) {
        this.f13673g = zzauqVar;
        this.f13672f = bitmap;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Object obj;
        zzdsj zzdsjVar;
        zzdsj zzdsjVar2;
        zzdsj zzdsjVar3;
        zzdsj zzdsjVar4;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        this.f13672f.compress(Bitmap.CompressFormat.PNG, 0, byteArrayOutputStream);
        obj = this.f13673g.l;
        synchronized (obj) {
            zzdsjVar = this.f13673g.f14167c;
            zzdsjVar.f16118k = new zzdso();
            zzdsjVar2 = this.f13673g.f14167c;
            zzdsjVar2.f16118k.f16130e = byteArrayOutputStream.toByteArray();
            zzdsjVar3 = this.f13673g.f14167c;
            zzdsjVar3.f16118k.f16129d = "image/png";
            zzdsjVar4 = this.f13673g.f14167c;
            zzdsjVar4.f16118k.f16128c = 1;
        }
    }
}
