package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* loaded from: classes2.dex */
public final class zzdbu {
    private zzdha a;

    private zzdbu(zzdha zzdhaVar) {
        this.a = zzdhaVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final zzdbu a(zzdha zzdhaVar) throws GeneralSecurityException {
        if (zzdhaVar != null && zzdhaVar.z() > 0) {
            return new zzdbu(zzdhaVar);
        }
        throw new GeneralSecurityException("empty keyset");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzdha b() {
        return this.a;
    }

    public final String toString() {
        return cr.a(this.a).toString();
    }
}
