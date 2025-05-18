package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdob;
import okhttp3.HttpUrl;

/* loaded from: classes2.dex */
public final class zzbk {

    /* loaded from: classes2.dex */
    public static final class zza extends zzdob<zza, C0175zza> implements zzdpm {
        private static volatile zzdpv<zza> zzdv;
        private static final zza zzdy;
        private int zzdj;
        private zzb zzdw;
        private zzc zzdx;

        /* renamed from: com.google.android.gms.internal.ads.zzbk$zza$zza, reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public static final class C0175zza extends zzdob.zza<zza, C0175zza> implements zzdpm {
            private C0175zza() {
                super(zza.zzdy);
            }

            /* synthetic */ C0175zza(oc ocVar) {
                this();
            }
        }

        static {
            zza zzaVar = new zza();
            zzdy = zzaVar;
            zzdob.t(zza.class, zzaVar);
        }

        private zza() {
        }

        public static zza x(byte[] bArr, zzdno zzdnoVar) throws zzdok {
            return (zza) zzdob.p(zzdy, bArr, zzdnoVar);
        }

        public final boolean A() {
            return (this.zzdj & 2) == 2;
        }

        public final zzc B() {
            zzc zzcVar = this.zzdx;
            return zzcVar == null ? zzc.z() : zzcVar;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.ads.zzdob
        public final Object q(int i2, Object obj, Object obj2) {
            oc ocVar = null;
            switch (oc.a[i2 - 1]) {
                case 1:
                    return new zza();
                case 2:
                    return new C0175zza(ocVar);
                case 3:
                    return zzdob.r(zzdy, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\t\u0000\u0002\t\u0001", new Object[]{"zzdj", "zzdw", "zzdx"});
                case 4:
                    return zzdy;
                case 5:
                    zzdpv<zza> zzdpvVar = zzdv;
                    if (zzdpvVar == null) {
                        synchronized (zza.class) {
                            zzdpvVar = zzdv;
                            if (zzdpvVar == null) {
                                zzdpvVar = new zzdob.zzb<>(zzdy);
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

        public final boolean y() {
            return (this.zzdj & 1) == 1;
        }

        public final zzb z() {
            zzb zzbVar = this.zzdw;
            return zzbVar == null ? zzb.x() : zzbVar;
        }
    }

    /* loaded from: classes2.dex */
    public static final class zzb extends zzdob<zzb, zza> implements zzdpm {
        private static volatile zzdpv<zzb> zzdv;
        private static final zzb zzea;
        private int zzdj;
        private int zzdz = 2;

        /* loaded from: classes2.dex */
        public static final class zza extends zzdob.zza<zzb, zza> implements zzdpm {
            private zza() {
                super(zzb.zzea);
            }

            /* synthetic */ zza(oc ocVar) {
                this();
            }
        }

        static {
            zzb zzbVar = new zzb();
            zzea = zzbVar;
            zzdob.t(zzb.class, zzbVar);
        }

        private zzb() {
        }

        public static zzb x() {
            return zzea;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.ads.zzdob
        public final Object q(int i2, Object obj, Object obj2) {
            oc ocVar = null;
            switch (oc.a[i2 - 1]) {
                case 1:
                    return new zzb();
                case 2:
                    return new zza(ocVar);
                case 3:
                    return zzdob.r(zzea, "\u0001\u0001\u0000\u0001\u001b\u001b\u0001\u0000\u0000\u0000\u001b\f\u0000", new Object[]{"zzdj", "zzdz", zzbm.g()});
                case 4:
                    return zzea;
                case 5:
                    zzdpv<zzb> zzdpvVar = zzdv;
                    if (zzdpvVar == null) {
                        synchronized (zzb.class) {
                            zzdpvVar = zzdv;
                            if (zzdpvVar == null) {
                                zzdpvVar = new zzdob.zzb<>(zzea);
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

        public final zzbm z() {
            zzbm k2 = zzbm.k(this.zzdz);
            return k2 == null ? zzbm.ENUM_SIGNAL_SOURCE_ADSHIELD : k2;
        }
    }

    /* loaded from: classes2.dex */
    public static final class zzc extends zzdob<zzc, zza> implements zzdpm {
        private static volatile zzdpv<zzc> zzdv;
        private static final zzc zzep;
        private int zzdj;
        private String zzej = HttpUrl.FRAGMENT_ENCODE_SET;
        private String zzek = HttpUrl.FRAGMENT_ENCODE_SET;
        private String zzel = HttpUrl.FRAGMENT_ENCODE_SET;
        private String zzem = HttpUrl.FRAGMENT_ENCODE_SET;
        private String zzen = HttpUrl.FRAGMENT_ENCODE_SET;
        private String zzeo = HttpUrl.FRAGMENT_ENCODE_SET;

        /* loaded from: classes2.dex */
        public static final class zza extends zzdob.zza<zzc, zza> implements zzdpm {
            private zza() {
                super(zzc.zzep);
            }

            /* synthetic */ zza(oc ocVar) {
                this();
            }
        }

        static {
            zzc zzcVar = new zzc();
            zzep = zzcVar;
            zzdob.t(zzc.class, zzcVar);
        }

        private zzc() {
        }

        public static zzc z() {
            return zzep;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.internal.ads.zzdob
        public final Object q(int i2, Object obj, Object obj2) {
            oc ocVar = null;
            switch (oc.a[i2 - 1]) {
                case 1:
                    return new zzc();
                case 2:
                    return new zza(ocVar);
                case 3:
                    return zzdob.r(zzep, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001\b\u0000\u0002\b\u0001\u0003\b\u0002\u0004\b\u0003\u0005\b\u0004\u0006\b\u0005", new Object[]{"zzdj", "zzej", "zzek", "zzel", "zzem", "zzen", "zzeo"});
                case 4:
                    return zzep;
                case 5:
                    zzdpv<zzc> zzdpvVar = zzdv;
                    if (zzdpvVar == null) {
                        synchronized (zzc.class) {
                            zzdpvVar = zzdv;
                            if (zzdpvVar == null) {
                                zzdpvVar = new zzdob.zzb<>(zzep);
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
            return this.zzej;
        }

        public final String y() {
            return this.zzeo;
        }
    }
}
