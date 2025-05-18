package com.google.android.gms.internal.ads;

import android.view.View;

/* loaded from: classes2.dex */
final class o40 implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ View f13084f;

    /* renamed from: g, reason: collision with root package name */
    private final /* synthetic */ zzuu f13085g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o40(zzuu zzuuVar, View view) {
        this.f13085g = zzuuVar;
        this.f13084f = view;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f13085g.d(this.f13084f);
    }
}
