package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdob;

/* loaded from: classes2.dex */
public final class zzdfz extends zzdob<zzdfz, zza> implements zzdpm {
    private static volatile zzdpv<zzdfz> zzdv;
    private static final zzdfz zzgtc;
    private int zzgqy;
    private int zzgta;
    private zzdmr zzgtb = zzdmr.f15982f;

    /* loaded from: classes2.dex */
    public static final class zza extends zzdob.zza<zzdfz, zza> implements zzdpm {
        private zza() {
            super(zzdfz.zzgtc);
        }

        /* synthetic */ zza(qs qsVar) {
            this();
        }
    }

    static {
        zzdfz zzdfzVar = new zzdfz();
        zzgtc = zzdfzVar;
        zzdob.t(zzdfz.class, zzdfzVar);
    }

    private zzdfz() {
    }

    public static zzdfz A() {
        return zzgtc;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzdob
    public final Object q(int i2, Object obj, Object obj2) {
        qs qsVar = null;
        switch (qs.a[i2 - 1]) {
            case 1:
                return new zzdfz();
            case 2:
                return new zza(qsVar);
            case 3:
                return zzdob.r(zzgtc, "\u0000\u0003\u0000\u0000\u0001\u000b\u0003\u0000\u0000\u0000\u0001\f\u0002\f\u000b\n", new Object[]{"zzgta", "zzgqy", "zzgtb"});
            case 4:
                return zzgtc;
            case 5:
                zzdpv<zzdfz> zzdpvVar = zzdv;
                if (zzdpvVar == null) {
                    synchronized (zzdfz.class) {
                        zzdpvVar = zzdv;
                        if (zzdpvVar == null) {
                            zzdpvVar = new zzdob.zzb<>(zzgtc);
                            zzdv = zzdpvVar;
                        }
                    }
                }
                return zzdpvVar;
            case 6:
                return (byte) 1;
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }

    public final zzdgj x() {
        zzdgj g2 = zzdgj.g(this.zzgqy);
        return g2 == null ? zzdgj.UNRECOGNIZED : g2;
    }

    public final zzdgf y() {
        zzdgf g2 = zzdgf.g(this.zzgta);
        return g2 == null ? zzdgf.UNRECOGNIZED : g2;
    }

    public final zzdmr z() {
        return this.zzgtb;
    }
}
