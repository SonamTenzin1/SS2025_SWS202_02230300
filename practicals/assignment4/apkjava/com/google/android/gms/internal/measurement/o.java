package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.internal.measurement.zzx;
import com.google.android.gms.measurement.internal.zzha;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-sdk-api@@17.2.0 */
/* loaded from: classes2.dex */
public final class o extends zzx.a {

    /* renamed from: j, reason: collision with root package name */
    private final /* synthetic */ zzha f17230j;

    /* renamed from: k, reason: collision with root package name */
    private final /* synthetic */ zzx f17231k;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(zzx zzxVar, zzha zzhaVar) {
        super(zzxVar);
        this.f17231k = zzxVar;
        this.f17230j = zzhaVar;
    }

    /* JADX WARN: Incorrect condition in loop: B:3:0x000b */
    @Override // com.google.android.gms.internal.measurement.zzx.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    final void a() throws RemoteException {
        List list;
        List list2;
        zzm zzmVar;
        List list3;
        String str;
        for (int i2 = 0; i2 < list.size(); i2++) {
            zzha zzhaVar = this.f17230j;
            list3 = this.f17231k.l;
            if (zzhaVar.equals(((Pair) list3.get(i2)).first)) {
                str = this.f17231k.f17577h;
                Log.w(str, "OnEventListener already registered.");
                return;
            }
        }
        zzx.b bVar = new zzx.b(this.f17230j);
        list2 = this.f17231k.l;
        list2.add(new Pair(this.f17230j, bVar));
        zzmVar = this.f17231k.p;
        zzmVar.registerOnMeasurementEventListener(bVar);
    }
}
