package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class zzcoc implements zzcjz<zzaov, zzcla> {
    private final zzclc a;

    public zzcoc(zzclc zzclcVar) {
        this.a = zzclcVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcjz
    public final zzcjy<zzaov, zzcla> a(String str, JSONObject jSONObject) throws RemoteException {
        zzaov d2 = this.a.d(str);
        if (d2 == null) {
            return null;
        }
        return new zzcjy<>(d2, new zzcla(), str);
    }
}
