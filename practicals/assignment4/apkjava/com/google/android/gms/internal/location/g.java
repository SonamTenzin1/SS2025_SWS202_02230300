package com.google.android.gms.internal.location;

import android.os.DeadObjectException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class g implements zzbj<zzao> {
    private final /* synthetic */ zzk a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(zzk zzkVar) {
        this.a = zzkVar;
    }

    @Override // com.google.android.gms.internal.location.zzbj
    public final void a() {
        this.a.checkConnected();
    }

    @Override // com.google.android.gms.internal.location.zzbj
    public final /* synthetic */ zzao b() throws DeadObjectException {
        return (zzao) this.a.getService();
    }
}
