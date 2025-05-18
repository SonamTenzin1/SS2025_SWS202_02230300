package com.google.android.gms.internal.ads;

import android.view.View;
import com.google.android.gms.ads.internal.zzf;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

@zzard
/* loaded from: classes2.dex */
public final class zzadj extends zzadm {

    /* renamed from: f, reason: collision with root package name */
    private final zzf f13828f;

    /* renamed from: g, reason: collision with root package name */
    private final String f13829g;

    /* renamed from: h, reason: collision with root package name */
    private final String f13830h;

    public zzadj(zzf zzfVar, String str, String str2) {
        this.f13828f = zzfVar;
        this.f13829g = str;
        this.f13830h = str2;
    }

    @Override // com.google.android.gms.internal.ads.zzadl
    public final String M5() {
        return this.f13829g;
    }

    @Override // com.google.android.gms.internal.ads.zzadl
    public final String getContent() {
        return this.f13830h;
    }

    @Override // com.google.android.gms.internal.ads.zzadl
    public final void recordClick() {
        this.f13828f.zzky();
    }

    @Override // com.google.android.gms.internal.ads.zzadl
    public final void recordImpression() {
        this.f13828f.zzkz();
    }

    @Override // com.google.android.gms.internal.ads.zzadl
    public final void z1(IObjectWrapper iObjectWrapper) {
        if (iObjectWrapper == null) {
            return;
        }
        this.f13828f.zzg((View) ObjectWrapper.k0(iObjectWrapper));
    }
}
