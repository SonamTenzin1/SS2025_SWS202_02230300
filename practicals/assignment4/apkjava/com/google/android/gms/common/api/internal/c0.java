package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.internal.GoogleApiManager;
import com.google.android.gms.common.internal.BaseGmsClient;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class c0 implements BaseGmsClient.SignOutCallbacks {
    final /* synthetic */ GoogleApiManager.zaa a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c0(GoogleApiManager.zaa zaaVar) {
        this.a = zaaVar;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.SignOutCallbacks
    public final void a() {
        GoogleApiManager.this.v.post(new d0(this));
    }
}
