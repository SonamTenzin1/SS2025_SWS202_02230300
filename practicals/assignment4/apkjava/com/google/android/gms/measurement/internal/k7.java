package com.google.android.gms.measurement.internal;

import java.util.List;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement@@17.2.0 */
/* loaded from: classes2.dex */
public final class k7 implements j3 {
    private final /* synthetic */ String a;

    /* renamed from: b, reason: collision with root package name */
    private final /* synthetic */ zzkc f17847b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k7(zzkc zzkcVar, String str) {
        this.f17847b = zzkcVar;
        this.a = str;
    }

    @Override // com.google.android.gms.measurement.internal.j3
    public final void a(String str, int i2, Throwable th, byte[] bArr, Map<String, List<String>> map) {
        this.f17847b.k(i2, th, bArr, this.a);
    }
}
