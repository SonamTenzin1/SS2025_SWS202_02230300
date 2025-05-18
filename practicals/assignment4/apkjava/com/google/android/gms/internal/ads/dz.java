package com.google.android.gms.internal.ads;

import android.media.MediaCodec;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class dz implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ MediaCodec.CryptoException f12488f;

    /* renamed from: g, reason: collision with root package name */
    private final /* synthetic */ zzgr f12489g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dz(zzgr zzgrVar, MediaCodec.CryptoException cryptoException) {
        this.f12489g = zzgrVar;
        this.f12488f = cryptoException;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzgw zzgwVar;
        zzgwVar = this.f12489g.f16260j;
        zzgwVar.a(this.f12488f);
    }
}
