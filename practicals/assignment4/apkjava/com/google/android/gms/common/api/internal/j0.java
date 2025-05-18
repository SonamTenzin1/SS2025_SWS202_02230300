package com.google.android.gms.common.api.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class j0 implements l0 {
    private final /* synthetic */ zacp a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j0(zacp zacpVar) {
        this.a = zacpVar;
    }

    @Override // com.google.android.gms.common.api.internal.l0
    public final void a(BasePendingResult<?> basePendingResult) {
        this.a.f11850c.remove(basePendingResult);
    }
}
