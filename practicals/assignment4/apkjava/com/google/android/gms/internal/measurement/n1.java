package com.google.android.gms.internal.measurement;

import java.util.Comparator;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.2.0 */
/* loaded from: classes2.dex */
final class n1 implements Comparator<zzdu> {
    @Override // java.util.Comparator
    public final /* synthetic */ int compare(zzdu zzduVar, zzdu zzduVar2) {
        int u;
        int u2;
        zzdu zzduVar3 = zzduVar;
        zzdu zzduVar4 = zzduVar2;
        zzed zzedVar = (zzed) zzduVar3.iterator();
        zzed zzedVar2 = (zzed) zzduVar4.iterator();
        while (zzedVar.hasNext() && zzedVar2.hasNext()) {
            u = zzdu.u(zzedVar.a());
            u2 = zzdu.u(zzedVar2.a());
            int a = androidx.datastore.preferences.protobuf.i.a(u, u2);
            if (a != 0) {
                return a;
            }
        }
        return androidx.datastore.preferences.protobuf.i.a(zzduVar3.f(), zzduVar4.f());
    }
}
