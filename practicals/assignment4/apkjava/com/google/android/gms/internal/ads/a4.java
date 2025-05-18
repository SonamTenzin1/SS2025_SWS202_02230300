package com.google.android.gms.internal.ads;

import java.util.List;

/* loaded from: classes2.dex */
final class a4 implements zzban<Void> {
    private final /* synthetic */ zzbbh a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a4(zzauq zzauqVar, zzbbh zzbbhVar) {
        this.a = zzbbhVar;
    }

    @Override // com.google.android.gms.internal.ads.zzban
    public final void a(Throwable th) {
        List list;
        list = zzauq.a;
        list.remove(this.a);
    }

    @Override // com.google.android.gms.internal.ads.zzban
    public final /* synthetic */ void b(Void r2) {
        List list;
        list = zzauq.a;
        list.remove(this.a);
    }
}
