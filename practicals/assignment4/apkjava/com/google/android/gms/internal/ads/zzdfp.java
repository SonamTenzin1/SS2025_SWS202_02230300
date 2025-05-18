package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdob;

/* loaded from: classes2.dex */
public final class zzdfp extends zzdob<zzdfp, zza> implements zzdpm {
    private static volatile zzdpv<zzdfp> zzdv;
    private static final zzdfp zzgsq;
    private zzdgw zzgsp;

    /* loaded from: classes2.dex */
    public static final class zza extends zzdob.zza<zzdfp, zza> implements zzdpm {
        private zza() {
            super(zzdfp.zzgsq);
        }

        /* synthetic */ zza(ls lsVar) {
            this();
        }
    }

    static {
        zzdfp zzdfpVar = new zzdfp();
        zzgsq = zzdfpVar;
        zzdob.t(zzdfp.class, zzdfpVar);
    }

    private zzdfp() {
    }

    public static zzdfp y() {
        return zzgsq;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzdob
    public final Object q(int i2, Object obj, Object obj2) {
        ls lsVar = null;
        switch (ls.a[i2 - 1]) {
            case 1:
                return new zzdfp();
            case 2:
                return new zza(lsVar);
            case 3:
                return zzdob.r(zzgsq, "\u0000\u0001\u0000\u0000\u0002\u0002\u0001\u0000\u0000\u0000\u0002\t", new Object[]{"zzgsp"});
            case 4:
                return zzgsq;
            case 5:
                zzdpv<zzdfp> zzdpvVar = zzdv;
                if (zzdpvVar == null) {
                    synchronized (zzdfp.class) {
                        zzdpvVar = zzdv;
                        if (zzdpvVar == null) {
                            zzdpvVar = new zzdob.zzb<>(zzgsq);
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

    public final zzdgw x() {
        zzdgw zzdgwVar = this.zzgsp;
        return zzdgwVar == null ? zzdgw.z() : zzdgwVar;
    }
}
