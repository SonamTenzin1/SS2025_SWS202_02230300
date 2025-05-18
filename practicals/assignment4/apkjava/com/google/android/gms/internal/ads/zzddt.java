package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdob;

/* loaded from: classes2.dex */
public final class zzddt extends zzdob<zzddt, zza> implements zzdpm {
    private static volatile zzdpv<zzddt> zzdv;
    private static final zzddt zzgqq;
    private zzded zzgqo;
    private zzdgn zzgqp;

    /* loaded from: classes2.dex */
    public static final class zza extends zzdob.zza<zzddt, zza> implements zzdpm {
        private zza() {
            super(zzddt.zzgqq);
        }

        /* synthetic */ zza(as asVar) {
            this();
        }
    }

    static {
        zzddt zzddtVar = new zzddt();
        zzgqq = zzddtVar;
        zzdob.t(zzddt.class, zzddtVar);
    }

    private zzddt() {
    }

    public static zzddt A(zzdmr zzdmrVar) throws zzdok {
        return (zzddt) zzdob.k(zzgqq, zzdmrVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzdob
    public final Object q(int i2, Object obj, Object obj2) {
        as asVar = null;
        switch (as.a[i2 - 1]) {
            case 1:
                return new zzddt();
            case 2:
                return new zza(asVar);
            case 3:
                return zzdob.r(zzgqq, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\t\u0002\t", new Object[]{"zzgqo", "zzgqp"});
            case 4:
                return zzgqq;
            case 5:
                zzdpv<zzddt> zzdpvVar = zzdv;
                if (zzdpvVar == null) {
                    synchronized (zzddt.class) {
                        zzdpvVar = zzdv;
                        if (zzdpvVar == null) {
                            zzdpvVar = new zzdob.zzb<>(zzgqq);
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

    public final zzded x() {
        zzded zzdedVar = this.zzgqo;
        return zzdedVar == null ? zzded.A() : zzdedVar;
    }

    public final zzdgn y() {
        zzdgn zzdgnVar = this.zzgqp;
        return zzdgnVar == null ? zzdgn.z() : zzdgnVar;
    }
}
