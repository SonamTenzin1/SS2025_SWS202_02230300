package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdob;

/* loaded from: classes2.dex */
public final class zzdgn extends zzdob<zzdgn, zza> implements zzdpm {
    private static volatile zzdpv<zzdgn> zzdv;
    private static final zzdgn zzgtv;
    private int zzgqu;
    private zzdgp zzgtt;

    /* loaded from: classes2.dex */
    public static final class zza extends zzdob.zza<zzdgn, zza> implements zzdpm {
        private zza() {
            super(zzdgn.zzgtv);
        }

        /* synthetic */ zza(vs vsVar) {
            this();
        }
    }

    static {
        zzdgn zzdgnVar = new zzdgn();
        zzgtv = zzdgnVar;
        zzdob.t(zzdgn.class, zzdgnVar);
    }

    private zzdgn() {
    }

    public static zzdgn B(zzdmr zzdmrVar) throws zzdok {
        return (zzdgn) zzdob.k(zzgtv, zzdmrVar);
    }

    public static zzdgn z() {
        return zzgtv;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzdob
    public final Object q(int i2, Object obj, Object obj2) {
        vs vsVar = null;
        switch (vs.a[i2 - 1]) {
            case 1:
                return new zzdgn();
            case 2:
                return new zza(vsVar);
            case 3:
                return zzdob.r(zzgtv, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\t\u0002\u000b", new Object[]{"zzgtt", "zzgqu"});
            case 4:
                return zzgtv;
            case 5:
                zzdpv<zzdgn> zzdpvVar = zzdv;
                if (zzdpvVar == null) {
                    synchronized (zzdgn.class) {
                        zzdpvVar = zzdv;
                        if (zzdpvVar == null) {
                            zzdpvVar = new zzdob.zzb<>(zzgtv);
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
        return this.zzgqu;
    }

    public final zzdgp y() {
        zzdgp zzdgpVar = this.zzgtt;
        return zzdgpVar == null ? zzdgp.z() : zzdgpVar;
    }
}
