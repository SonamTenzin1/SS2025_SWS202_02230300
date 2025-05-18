package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzbr;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement@@17.2.0 */
/* loaded from: classes2.dex */
public final class q7 extends f7 {
    /* JADX INFO: Access modifiers changed from: package-private */
    public q7(zzkc zzkcVar) {
        super(zzkcVar);
    }

    @Override // com.google.android.gms.measurement.internal.f7
    protected final boolean v() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final List<zzbr.zza> w(String str, List<zzbr.zzc> list, List<zzbr.zzk> list2, Long l) {
        Preconditions.g(str);
        Preconditions.k(list);
        Preconditions.k(list2);
        return new u7(this, str).b(list, list2, l);
    }
}
