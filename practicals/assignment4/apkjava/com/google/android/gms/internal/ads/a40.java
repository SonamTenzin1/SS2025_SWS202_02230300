package com.google.android.gms.internal.ads;

import android.view.Surface;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class a40 implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ Surface f12217f;

    /* renamed from: g, reason: collision with root package name */
    private final /* synthetic */ zzto f12218g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a40(zzto zztoVar, Surface surface) {
        this.f12218g = zztoVar;
        this.f12217f = surface;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zztn zztnVar;
        zztnVar = this.f12218g.f16775b;
        zztnVar.j(this.f12217f);
    }
}
