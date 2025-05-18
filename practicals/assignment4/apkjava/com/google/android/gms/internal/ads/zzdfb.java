package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdob;

/* loaded from: classes2.dex */
public final class zzdfb extends zzdob<zzdfb, zza> implements zzdpm {
    private static volatile zzdpv<zzdfb> zzdv;
    private static final zzdfb zzgrs;
    private int zzgqk;
    private zzdmr zzgqs = zzdmr.f15982f;

    /* loaded from: classes2.dex */
    public static final class zza extends zzdob.zza<zzdfb, zza> implements zzdpm {
        private zza() {
            super(zzdfb.zzgrs);
        }

        public final zza u(zzdmr zzdmrVar) {
            p();
            ((zzdfb) this.f16019g).F(zzdmrVar);
            return this;
        }

        public final zza v(int i2) {
            p();
            ((zzdfb) this.f16019g).y(0);
            return this;
        }

        /* synthetic */ zza(js jsVar) {
            this();
        }
    }

    static {
        zzdfb zzdfbVar = new zzdfb();
        zzgrs = zzdfbVar;
        zzdob.t(zzdfb.class, zzdfbVar);
    }

    private zzdfb() {
    }

    public static zzdfb C(zzdmr zzdmrVar) throws zzdok {
        return (zzdfb) zzdob.k(zzgrs, zzdmrVar);
    }

    public static zza D() {
        return (zza) ((zzdob.zza) zzgrs.q(zzdob.zze.f16025e, null, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void F(zzdmr zzdmrVar) {
        zzdmrVar.getClass();
        this.zzgqs = zzdmrVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void y(int i2) {
        this.zzgqk = i2;
    }

    public final zzdmr B() {
        return this.zzgqs;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzdob
    public final Object q(int i2, Object obj, Object obj2) {
        js jsVar = null;
        switch (js.a[i2 - 1]) {
            case 1:
                return new zzdfb();
            case 2:
                return new zza(jsVar);
            case 3:
                return zzdob.r(zzgrs, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002\n", new Object[]{"zzgqk", "zzgqs"});
            case 4:
                return zzgrs;
            case 5:
                zzdpv<zzdfb> zzdpvVar = zzdv;
                if (zzdpvVar == null) {
                    synchronized (zzdfb.class) {
                        zzdpvVar = zzdv;
                        if (zzdpvVar == null) {
                            zzdpvVar = new zzdob.zzb<>(zzgrs);
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
        return this.zzgqk;
    }
}
