package com.google.android.gms.internal.ads;

import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class zzclv implements zzcjz<zzams, zzcla> {
    private final zzclc a;

    public zzclv(zzclc zzclcVar) {
        this.a = zzclcVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcjz
    public final zzcjy<zzams, zzcla> a(String str, JSONObject jSONObject) throws Throwable {
        zzams e2 = this.a.e(str, jSONObject);
        if (e2 == null) {
            return null;
        }
        return new zzcjy<>(e2, new zzcla(), str);
    }
}
