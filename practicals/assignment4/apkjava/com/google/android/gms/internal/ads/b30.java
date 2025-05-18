package com.google.android.gms.internal.ads;

import java.io.IOException;

/* loaded from: classes2.dex */
final class b30 implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ IOException f12309f;

    /* renamed from: g, reason: collision with root package name */
    private final /* synthetic */ x20 f12310g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b30(x20 x20Var, IOException iOException) {
        this.f12310g = x20Var;
        this.f12309f = iOException;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzqi zzqiVar;
        zzqiVar = this.f12310g.f13549j;
        zzqiVar.f(this.f12309f);
    }
}
