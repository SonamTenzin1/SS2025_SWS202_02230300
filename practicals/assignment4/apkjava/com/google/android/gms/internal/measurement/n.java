package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzx;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@17.2.0 */
/* loaded from: classes2.dex */
public final class n extends zzx.a {

    /* renamed from: j, reason: collision with root package name */
    private final /* synthetic */ String f17221j;

    /* renamed from: k, reason: collision with root package name */
    private final /* synthetic */ zzk f17222k;
    private final /* synthetic */ zzx l;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(zzx zzxVar, String str, zzk zzkVar) {
        super(zzxVar);
        this.l = zzxVar;
        this.f17221j = str;
        this.f17222k = zzkVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzx.a
    final void a() throws RemoteException {
        zzm zzmVar;
        zzmVar = this.l.p;
        zzmVar.getMaxUserProperties(this.f17221j, this.f17222k);
    }

    @Override // com.google.android.gms.internal.measurement.zzx.a
    protected final void b() {
        this.f17222k.J(null);
    }
}
