package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdob;

/* loaded from: classes2.dex */
public final class zzdef extends zzdob<zzdef, zza> implements zzdpm {
    private static volatile zzdpv<zzdef> zzdv;
    private static final zzdef zzgrf;
    private int zzgre;

    /* loaded from: classes2.dex */
    public static final class zza extends zzdob.zza<zzdef, zza> implements zzdpm {
        private zza() {
            super(zzdef.zzgrf);
        }

        /* synthetic */ zza(ds dsVar) {
            this();
        }
    }

    static {
        zzdef zzdefVar = new zzdef();
        zzgrf = zzdefVar;
        zzdob.t(zzdef.class, zzdefVar);
    }

    private zzdef() {
    }

    public static zzdef y() {
        return zzgrf;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzdob
    public final Object q(int i2, Object obj, Object obj2) {
        ds dsVar = null;
        switch (ds.a[i2 - 1]) {
            case 1:
                return new zzdef();
            case 2:
                return new zza(dsVar);
            case 3:
                return zzdob.r(zzgrf, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u000b", new Object[]{"zzgre"});
            case 4:
                return zzgrf;
            case 5:
                zzdpv<zzdef> zzdpvVar = zzdv;
                if (zzdpvVar == null) {
                    synchronized (zzdef.class) {
                        zzdpvVar = zzdv;
                        if (zzdpvVar == null) {
                            zzdpvVar = new zzdob.zzb<>(zzgrf);
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

    public final int x() {
        return this.zzgre;
    }
}
