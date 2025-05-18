package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdob;

/* loaded from: classes2.dex */
public final class zzdft extends zzdob<zzdft, zza> implements zzdpm {
    private static volatile zzdpv<zzdft> zzdv;
    private static final zzdft zzgsw;
    private zzdfz zzgst;
    private zzdfp zzgsu;
    private int zzgsv;

    /* loaded from: classes2.dex */
    public static final class zza extends zzdob.zza<zzdft, zza> implements zzdpm {
        private zza() {
            super(zzdft.zzgsw);
        }

        /* synthetic */ zza(ns nsVar) {
            this();
        }
    }

    static {
        zzdft zzdftVar = new zzdft();
        zzgsw = zzdftVar;
        zzdob.t(zzdft.class, zzdftVar);
    }

    private zzdft() {
    }

    public static zzdft A() {
        return zzgsw;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzdob
    public final Object q(int i2, Object obj, Object obj2) {
        ns nsVar = null;
        switch (ns.a[i2 - 1]) {
            case 1:
                return new zzdft();
            case 2:
                return new zza(nsVar);
            case 3:
                return zzdob.r(zzgsw, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\t\u0002\t\u0003\f", new Object[]{"zzgst", "zzgsu", "zzgsv"});
            case 4:
                return zzgsw;
            case 5:
                zzdpv<zzdft> zzdpvVar = zzdv;
                if (zzdpvVar == null) {
                    synchronized (zzdft.class) {
                        zzdpvVar = zzdv;
                        if (zzdpvVar == null) {
                            zzdpvVar = new zzdob.zzb<>(zzgsw);
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

    public final zzdfz x() {
        zzdfz zzdfzVar = this.zzgst;
        return zzdfzVar == null ? zzdfz.A() : zzdfzVar;
    }

    public final zzdfp y() {
        zzdfp zzdfpVar = this.zzgsu;
        return zzdfpVar == null ? zzdfp.y() : zzdfpVar;
    }

    public final zzdfd z() {
        zzdfd g2 = zzdfd.g(this.zzgsv);
        return g2 == null ? zzdfd.UNRECOGNIZED : g2;
    }
}
