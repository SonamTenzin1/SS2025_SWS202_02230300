package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.logging.Logger;

/* loaded from: classes2.dex */
public final class zzdde implements zzdcc<zzdbp> {
    private static final Logger a = Logger.getLogger(zzdde.class.getName());

    /* loaded from: classes2.dex */
    static class a implements zzdbp {
        private final zzdca<zzdbp> a;

        public a(zzdca<zzdbp> zzdcaVar) {
            this.a = zzdcaVar;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdcc
    public final Class<zzdbp> a() {
        return zzdbp.class;
    }

    @Override // com.google.android.gms.internal.ads.zzdcc
    public final /* synthetic */ zzdbp b(zzdca<zzdbp> zzdcaVar) throws GeneralSecurityException {
        return new a(zzdcaVar);
    }
}
