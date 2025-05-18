package com.google.android.gms.measurement.internal;

import java.util.List;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement@@17.2.0 */
/* loaded from: classes2.dex */
public final class j7 implements j3 {
    private final /* synthetic */ zzkc a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j7(zzkc zzkcVar) {
        this.a = zzkcVar;
    }

    @Override // com.google.android.gms.measurement.internal.j3
    public final void a(String str, int i2, Throwable th, byte[] bArr, Map<String, List<String>> map) {
        this.a.A(str, i2, th, bArr, map);
    }
}
