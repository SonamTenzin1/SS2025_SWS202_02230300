package com.google.android.gms.internal.ads;

import java.util.Date;
import java.util.HashSet;

@zzard
/* loaded from: classes2.dex */
public final class zzaog {
    public static int a(e.e.a.a aVar) {
        int i2 = x2.f13544b[aVar.ordinal()];
        if (i2 == 2) {
            return 1;
        }
        if (i2 != 3) {
            return i2 != 4 ? 0 : 3;
        }
        return 2;
    }

    public static com.google.ads.mediation.a b(zzxz zzxzVar, boolean z) {
        e.e.a.b bVar;
        HashSet hashSet = zzxzVar.f16972j != null ? new HashSet(zzxzVar.f16972j) : null;
        Date date = new Date(zzxzVar.f16969g);
        int i2 = zzxzVar.f16971i;
        if (i2 == 1) {
            bVar = e.e.a.b.MALE;
        } else if (i2 != 2) {
            bVar = e.e.a.b.UNKNOWN;
        } else {
            bVar = e.e.a.b.FEMALE;
        }
        return new com.google.ads.mediation.a(date, bVar, hashSet, z, zzxzVar.p);
    }
}
