package com.google.android.gms.internal.ads;

import android.os.ParcelFileDescriptor;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class p0 implements zzbal<zzaig, ParcelFileDescriptor> {
    private final /* synthetic */ zzaia a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p0(zzaii zzaiiVar, zzaia zzaiaVar) {
        this.a = zzaiaVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbal
    public final /* synthetic */ zzbbh<ParcelFileDescriptor> zzf(zzaig zzaigVar) throws Exception {
        zzbbr zzbbrVar = new zzbbr();
        zzaigVar.b3(this.a, new q0(this, zzbbrVar));
        return zzbbrVar;
    }
}
