package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.MuteThisAdReason;
import okhttp3.HttpUrl;

@zzard
/* loaded from: classes2.dex */
public final class zzaan implements MuteThisAdReason {
    private final String a;

    /* renamed from: b, reason: collision with root package name */
    private zzaak f13730b;

    public zzaan(zzaak zzaakVar) {
        String str;
        this.f13730b = zzaakVar;
        try {
            str = zzaakVar.getDescription();
        } catch (RemoteException e2) {
            zzbad.c(HttpUrl.FRAGMENT_ENCODE_SET, e2);
            str = null;
        }
        this.a = str;
    }

    public final zzaak a() {
        return this.f13730b;
    }

    @Override // com.google.android.gms.ads.MuteThisAdReason
    public final String getDescription() {
        return this.a;
    }
}
