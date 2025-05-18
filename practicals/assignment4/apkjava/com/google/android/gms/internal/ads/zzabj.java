package com.google.android.gms.internal.ads;

import android.os.RemoteException;

@zzard
/* loaded from: classes2.dex */
public final class zzabj extends zzaal {

    /* renamed from: f, reason: collision with root package name */
    private final String f13776f;

    /* renamed from: g, reason: collision with root package name */
    private final String f13777g;

    public zzabj(String str, String str2) {
        this.f13776f = str;
        this.f13777g = str2;
    }

    @Override // com.google.android.gms.internal.ads.zzaak
    public final String Z1() throws RemoteException {
        return this.f13777g;
    }

    @Override // com.google.android.gms.internal.ads.zzaak
    public final String getDescription() throws RemoteException {
        return this.f13776f;
    }
}
