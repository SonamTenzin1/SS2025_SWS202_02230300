package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdob;
import okhttp3.HttpUrl;

/* loaded from: classes2.dex */
public final class zzdhc extends zzdob<zzdhc, zza> implements zzdpm {
    private static volatile zzdpv<zzdhc> zzdv;
    private static final zzdhc zzgvf;
    private int zzdj;
    private int zzgux;
    private zzdoj<zzb> zzgve = zzdob.v();

    /* loaded from: classes2.dex */
    public static final class zza extends zzdob.zza<zzdhc, zza> implements zzdpm {
        private zza() {
            super(zzdhc.zzgvf);
        }

        public final zza u(zzb zzbVar) {
            p();
            ((zzdhc) this.f16019g).x(zzbVar);
            return this;
        }

        public final zza v(int i2) {
            p();
            ((zzdhc) this.f16019g).C(i2);
            return this;
        }

        /* synthetic */ zza(dt dtVar) {
            this();
        }
    }

    /* loaded from: classes2.dex */
    public static final class zzb extends zzdob<zzb, zza> implements zzdpm {
        private static volatile zzdpv<zzb> zzdv;
        private static final zzb zzgvg;
        private String zzgtz = HttpUrl.FRAGMENT_ENCODE_SET;
        private int zzguq;
        private int zzgvb;
        private int zzgvc;

        /* loaded from: classes2.dex */
        public static final class zza extends zzdob.zza<zzb, zza> implements zzdpm {
            private zza() {
                super(zzb.zzgvg);
            }

            public final zza A(String str) {
                p();
                ((zzb) this.f16019g).G(str);
                return this;
            }

            public final zza u(zzdgu zzdguVar) {
                p();
                ((zzb) this.f16019g).x(zzdguVar);
                return this;
            }

            public final zza v(zzdhm zzdhmVar) {
                p();
                ((zzb) this.f16019g).C(zzdhmVar);
                return this;
            }

            public final zza w(int i2) {
                p();
                ((zzb) this.f16019g).F(i2);
                return this;
            }

            /* synthetic */ zza(dt dtVar) {
                this();
            }
        }

        static {
            zzb zzbVar = new zzb();
            zzgvg = zzbVar;
            zzdob.t(zzb.class, zzbVar);
        }

        private zzb() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void C(zzdhm zzdhmVar) {
            zzdhmVar.getClass();
            this.zzguq = zzdhmVar.i();
        }

        public static zza D() {
            return (zza) ((zzdob.zza) zzgvg.q(zzdob.zze.f16025e, null, null));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void F(int i2) {
            this.zzgvc = i2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void G(String str) {
            str.getClass();
            this.zzgtz = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void x(zzdgu zzdguVar) {
            zzdguVar.getClass();
            this.zzgvb = zzdguVar.i();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.ads.zzdob
        public final Object q(int i2, Object obj, Object obj2) {
            dt dtVar = null;
            switch (dt.a[i2 - 1]) {
                case 1:
                    return new zzb();
                case 2:
                    return new zza(dtVar);
                case 3:
                    return zzdob.r(zzgvg, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001Ȉ\u0002\f\u0003\u000b\u0004\f", new Object[]{"zzgtz", "zzgvb", "zzgvc", "zzguq"});
                case 4:
                    return zzgvg;
                case 5:
                    zzdpv<zzb> zzdpvVar = zzdv;
                    if (zzdpvVar == null) {
                        synchronized (zzb.class) {
                            zzdpvVar = zzdv;
                            if (zzdpvVar == null) {
                                zzdpvVar = new zzdob.zzb<>(zzgvg);
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
    }

    static {
        zzdhc zzdhcVar = new zzdhc();
        zzgvf = zzdhcVar;
        zzdob.t(zzdhc.class, zzdhcVar);
    }

    private zzdhc() {
    }

    public static zza A() {
        return (zza) ((zzdob.zza) zzgvf.q(zzdob.zze.f16025e, null, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void C(int i2) {
        this.zzgux = i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void x(zzb zzbVar) {
        zzbVar.getClass();
        if (!this.zzgve.m0()) {
            zzdoj<zzb> zzdojVar = this.zzgve;
            int size = zzdojVar.size();
            this.zzgve = zzdojVar.N(size == 0 ? 10 : size << 1);
        }
        this.zzgve.add(zzbVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzdob
    public final Object q(int i2, Object obj, Object obj2) {
        dt dtVar = null;
        switch (dt.a[i2 - 1]) {
            case 1:
                return new zzdhc();
            case 2:
                return new zza(dtVar);
            case 3:
                return zzdob.r(zzgvf, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u000b\u0002\u001b", new Object[]{"zzdj", "zzgux", "zzgve", zzb.class});
            case 4:
                return zzgvf;
            case 5:
                zzdpv<zzdhc> zzdpvVar = zzdv;
                if (zzdpvVar == null) {
                    synchronized (zzdhc.class) {
                        zzdpvVar = zzdv;
                        if (zzdpvVar == null) {
                            zzdpvVar = new zzdob.zzb<>(zzgvf);
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
}
