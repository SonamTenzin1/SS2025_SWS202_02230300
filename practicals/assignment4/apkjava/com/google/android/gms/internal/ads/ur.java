package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Arrays;

/* loaded from: classes2.dex */
final class ur implements zzdka {
    private final String a;

    /* renamed from: b, reason: collision with root package name */
    private final int f13406b;

    /* renamed from: c, reason: collision with root package name */
    private zzdet f13407c;

    /* renamed from: d, reason: collision with root package name */
    private zzddr f13408d;

    /* renamed from: e, reason: collision with root package name */
    private int f13409e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ur(zzdgw zzdgwVar) throws GeneralSecurityException {
        String x = zzdgwVar.x();
        this.a = x;
        if (x.equals("type.googleapis.com/google.crypto.tink.AesGcmKey")) {
            try {
                zzdev y = zzdev.y(zzdgwVar.y());
                this.f13407c = (zzdet) zzdcf.n(zzdgwVar);
                this.f13406b = y.x();
                return;
            } catch (zzdok e2) {
                throw new GeneralSecurityException("invalid KeyFormat protobuf, expected AesGcmKeyFormat", e2);
            }
        }
        if (x.equals("type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey")) {
            try {
                zzddt A = zzddt.A(zzdgwVar.y());
                this.f13408d = (zzddr) zzdcf.n(zzdgwVar);
                this.f13409e = A.x().x();
                this.f13406b = this.f13409e + A.y().x();
                return;
            } catch (zzdok e3) {
                throw new GeneralSecurityException("invalid KeyFormat protobuf, expected AesCtrHmacAeadKeyFormat", e3);
            }
        }
        String valueOf = String.valueOf(x);
        throw new GeneralSecurityException(valueOf.length() != 0 ? "unsupported AEAD DEM key type: ".concat(valueOf) : new String("unsupported AEAD DEM key type: "));
    }

    @Override // com.google.android.gms.internal.ads.zzdka
    public final zzdbj a(byte[] bArr) throws GeneralSecurityException {
        if (bArr.length == this.f13406b) {
            if (this.a.equals("type.googleapis.com/google.crypto.tink.AesGcmKey")) {
                return (zzdbj) zzdcf.h(this.a, (zzdet) ((zzdob) zzdet.D().j(this.f13407c).u(zzdmr.A(bArr, 0, this.f13406b)).p0()), zzdbj.class);
            }
            if (this.a.equals("type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey")) {
                byte[] copyOfRange = Arrays.copyOfRange(bArr, 0, this.f13409e);
                byte[] copyOfRange2 = Arrays.copyOfRange(bArr, this.f13409e, this.f13406b);
                zzdeb zzdebVar = (zzdeb) ((zzdob) zzdeb.F().j(this.f13408d.E()).u(zzdmr.D(copyOfRange)).p0());
                return (zzdbj) zzdcf.h(this.a, (zzddr) ((zzdob) zzddr.G().w(this.f13408d.x()).u(zzdebVar).v((zzdgl) ((zzdob) zzdgl.E().j(this.f13408d.F()).u(zzdmr.D(copyOfRange2)).p0())).p0()), zzdbj.class);
            }
            throw new GeneralSecurityException("unknown DEM key type");
        }
        throw new GeneralSecurityException("Symmetric key has incorrect length");
    }

    @Override // com.google.android.gms.internal.ads.zzdka
    public final int b() {
        return this.f13406b;
    }
}
