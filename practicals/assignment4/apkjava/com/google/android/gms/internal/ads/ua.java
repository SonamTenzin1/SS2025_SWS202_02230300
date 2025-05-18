package com.google.android.gms.internal.ads;

import android.view.View;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class ua implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ View f13391f;

    /* renamed from: g, reason: collision with root package name */
    private final /* synthetic */ zzavb f13392g;

    /* renamed from: h, reason: collision with root package name */
    private final /* synthetic */ int f13393h;

    /* renamed from: i, reason: collision with root package name */
    private final /* synthetic */ zzbha f13394i;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ua(zzbha zzbhaVar, View view, zzavb zzavbVar, int i2) {
        this.f13394i = zzbhaVar;
        this.f13391f = view;
        this.f13392g = zzavbVar;
        this.f13393h = i2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f13394i.q(this.f13391f, this.f13392g, this.f13393h - 1);
    }
}
