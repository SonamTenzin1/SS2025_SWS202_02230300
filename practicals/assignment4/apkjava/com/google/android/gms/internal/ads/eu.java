package com.google.android.gms.internal.ads;

import java.util.Comparator;

/* loaded from: classes2.dex */
final class eu implements Comparator<zzdmr> {
    @Override // java.util.Comparator
    public final /* synthetic */ int compare(zzdmr zzdmrVar, zzdmr zzdmrVar2) {
        int s;
        int s2;
        zzdmr zzdmrVar3 = zzdmrVar;
        zzdmr zzdmrVar4 = zzdmrVar2;
        zzdmy zzdmyVar = (zzdmy) zzdmrVar3.iterator();
        zzdmy zzdmyVar2 = (zzdmy) zzdmrVar4.iterator();
        while (zzdmyVar.hasNext() && zzdmyVar2.hasNext()) {
            s = zzdmr.s(zzdmyVar.f());
            s2 = zzdmr.s(zzdmyVar2.f());
            int a = androidx.datastore.preferences.protobuf.i.a(s, s2);
            if (a != 0) {
                return a;
            }
        }
        return androidx.datastore.preferences.protobuf.i.a(zzdmrVar3.size(), zzdmrVar4.size());
    }
}
