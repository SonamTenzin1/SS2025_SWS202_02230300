package com.google.android.gms.internal.ads;

import android.view.View;

/* loaded from: classes2.dex */
final class lb implements View.OnAttachStateChangeListener {

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ zzavb f12921f;

    /* renamed from: g, reason: collision with root package name */
    private final /* synthetic */ zzbio f12922g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public lb(zzbio zzbioVar, zzavb zzavbVar) {
        this.f12922g = zzbioVar;
        this.f12921f = zzavbVar;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
        this.f12922g.v(view, this.f12921f, 10);
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
    }
}
