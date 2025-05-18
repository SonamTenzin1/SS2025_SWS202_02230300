package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdob;
import okhttp3.HttpUrl;

/* loaded from: classes2.dex */
public final class zzdhg extends zzdob<zzdhg, zza> implements zzdpm {
    private static volatile zzdpv<zzdhg> zzdv;
    private static final zzdhg zzgvk;
    private String zzgvj = HttpUrl.FRAGMENT_ENCODE_SET;

    /* loaded from: classes2.dex */
    public static final class zza extends zzdob.zza<zzdhg, zza> implements zzdpm {
        private zza() {
            super(zzdhg.zzgvk);
        }

        /* synthetic */ zza(ft ftVar) {
            this();
        }
    }

    static {
        zzdhg zzdhgVar = new zzdhg();
        zzgvk = zzdhgVar;
        zzdob.t(zzdhg.class, zzdhgVar);
    }

    private zzdhg() {
    }

    public static zzdhg A(zzdmr zzdmrVar) throws zzdok {
        return (zzdhg) zzdob.k(zzgvk, zzdmrVar);
    }

    public static zzdhg y() {
        return zzgvk;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzdob
    public final Object q(int i2, Object obj, Object obj2) {
        ft ftVar = null;
        switch (ft.a[i2 - 1]) {
            case 1:
                return new zzdhg();
            case 2:
                return new zza(ftVar);
            case 3:
                return zzdob.r(zzgvk, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001Ȉ", new Object[]{"zzgvj"});
            case 4:
                return zzgvk;
            case 5:
                zzdpv<zzdhg> zzdpvVar = zzdv;
                if (zzdpvVar == null) {
                    synchronized (zzdhg.class) {
                        zzdpvVar = zzdv;
                        if (zzdpvVar == null) {
                            zzdpvVar = new zzdob.zzb<>(zzgvk);
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

    public final String x() {
        return this.zzgvj;
    }
}
