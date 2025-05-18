package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes2.dex */
public final class zzir extends vz {
    public final long b0;
    public final List<zzis> c0;
    public final List<zzir> d0;

    public zzir(int i2, long j2) {
        super(i2);
        this.c0 = new ArrayList();
        this.d0 = new ArrayList();
        this.b0 = j2;
    }

    public final zzis c(int i2) {
        int size = this.c0.size();
        for (int i3 = 0; i3 < size; i3++) {
            zzis zzisVar = this.c0.get(i3);
            if (zzisVar.a0 == i2) {
                return zzisVar;
            }
        }
        return null;
    }

    public final zzir d(int i2) {
        int size = this.d0.size();
        for (int i3 = 0; i3 < size; i3++) {
            zzir zzirVar = this.d0.get(i3);
            if (zzirVar.a0 == i2) {
                return zzirVar;
            }
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.vz
    public final String toString() {
        String b2 = vz.b(this.a0);
        String valueOf = String.valueOf(Arrays.toString(this.c0.toArray(new zzis[0])));
        String valueOf2 = String.valueOf(Arrays.toString(this.d0.toArray(new zzir[0])));
        StringBuilder sb = new StringBuilder(String.valueOf(b2).length() + 22 + valueOf.length() + valueOf2.length());
        sb.append(b2);
        sb.append(" leaves: ");
        sb.append(valueOf);
        sb.append(" containers: ");
        sb.append(valueOf2);
        return sb.toString();
    }
}
