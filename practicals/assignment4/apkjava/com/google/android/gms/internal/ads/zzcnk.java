package com.google.android.gms.internal.ads;

import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class zzcnk implements zzcjz<zzams, zzclb> {
    private final Map<String, zzcjy<zzams, zzclb>> a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    private final zzclc f15441b;

    public zzcnk(zzclc zzclcVar) {
        this.f15441b = zzclcVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcjz
    public final zzcjy<zzams, zzclb> a(String str, JSONObject jSONObject) throws Throwable {
        synchronized (this) {
            zzcjy<zzams, zzclb> zzcjyVar = this.a.get(str);
            if (zzcjyVar == null) {
                zzams e2 = this.f15441b.e(str, jSONObject);
                if (e2 == null) {
                    return null;
                }
                zzcjyVar = new zzcjy<>(e2, new zzclb(), str);
                this.a.put(str, zzcjyVar);
            }
            return zzcjyVar;
        }
    }
}
