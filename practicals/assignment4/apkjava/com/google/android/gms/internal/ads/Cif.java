package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.VideoController;

/* renamed from: com.google.android.gms.internal.ads.if, reason: invalid class name */
/* loaded from: classes2.dex */
final /* synthetic */ class Cif implements zzbtu {
    static final zzbtu a = new Cif();

    private Cif() {
    }

    @Override // com.google.android.gms.internal.ads.zzbtu
    public final void a(Object obj) {
        ((VideoController.VideoLifecycleCallbacks) obj).onVideoStart();
    }
}
