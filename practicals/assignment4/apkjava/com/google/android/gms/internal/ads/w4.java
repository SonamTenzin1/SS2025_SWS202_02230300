package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzk;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class w4 extends zzawv {
    private final /* synthetic */ zzawm a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w4(zzawm zzawmVar) {
        this.a = zzawmVar;
    }

    @Override // com.google.android.gms.internal.ads.zzawv
    public final void zzto() {
        Context context;
        zzbai zzbaiVar;
        Object obj;
        zzacy zzacyVar;
        context = this.a.f14221f;
        zzbaiVar = this.a.f14222g;
        zzacx zzacxVar = new zzacx(context, zzbaiVar.f14326f);
        obj = this.a.a;
        synchronized (obj) {
            try {
                zzk.zzlp();
                zzacyVar = this.a.f14223h;
                zzada.a(zzacyVar, zzacxVar);
            } catch (IllegalArgumentException e2) {
                zzbad.d("Cannot config CSI reporter.", e2);
            }
        }
    }
}
