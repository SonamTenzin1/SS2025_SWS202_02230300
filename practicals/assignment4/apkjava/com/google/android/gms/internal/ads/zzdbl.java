package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdgy;
import java.security.GeneralSecurityException;

/* loaded from: classes2.dex */
public final class zzdbl {
    public static zzdgy a(String str, String str2, String str3, int i2, boolean z) {
        zzdgy.zza w = zzdgy.F().w(str2);
        String valueOf = String.valueOf(str3);
        return (zzdgy) ((zzdob) w.A(valueOf.length() != 0 ? "type.googleapis.com/google.crypto.tink.".concat(valueOf) : new String("type.googleapis.com/google.crypto.tink.")).v(0).u(true).B(str).p0());
    }

    public static void b(zzdho zzdhoVar) throws GeneralSecurityException {
        for (zzdgy zzdgyVar : zzdhoVar.A()) {
            if (!zzdgyVar.A().isEmpty()) {
                if (!zzdgyVar.B().isEmpty()) {
                    if (!zzdgyVar.E().isEmpty()) {
                        zzdbk<?> o = zzdcf.o(zzdgyVar.E());
                        zzdcf.l(o.a());
                        zzdcf.k(o.b(zzdgyVar.A(), zzdgyVar.B(), zzdgyVar.C()), zzdgyVar.D());
                    } else {
                        throw new GeneralSecurityException("Missing catalogue_name.");
                    }
                } else {
                    throw new GeneralSecurityException("Missing primitive_name.");
                }
            } else {
                throw new GeneralSecurityException("Missing type_url.");
            }
        }
    }
}
