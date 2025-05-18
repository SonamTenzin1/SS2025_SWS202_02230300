package com.google.android.gms.internal.ads;

import java.util.Map;

/* loaded from: classes2.dex */
public final class zzbpf<AdT> implements zzbpe<AdT> {
    private final Map<String, zzcjv<AdT>> a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbpf(Map<String, zzcjv<AdT>> map) {
        this.a = map;
    }

    @Override // com.google.android.gms.internal.ads.zzbpe
    public final zzcjv<AdT> a(int i2, String str) {
        return this.a.get(str);
    }
}
