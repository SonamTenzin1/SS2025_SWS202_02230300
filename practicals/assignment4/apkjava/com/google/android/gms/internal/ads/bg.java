package com.google.android.gms.internal.ads;

import android.view.MotionEvent;
import android.view.ViewGroup;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class bg implements zzadx {
    private final /* synthetic */ zzcab a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ ViewGroup f12351b;

    /* renamed from: c, reason: collision with root package name */
    private final /* synthetic */ zzbzl f12352c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bg(zzbzl zzbzlVar, zzcab zzcabVar, ViewGroup viewGroup) {
        this.f12352c = zzbzlVar;
        this.a = zzcabVar;
        this.f12351b = viewGroup;
    }

    @Override // com.google.android.gms.internal.ads.zzadx
    public final void a() {
        boolean d2;
        zzbzl zzbzlVar = this.f12352c;
        d2 = zzbzl.d(this.a, zzbzj.f14914f);
        if (d2) {
            this.a.onClick(this.f12351b);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzadx
    public final void b(MotionEvent motionEvent) {
        this.a.onTouch(null, motionEvent);
    }
}
