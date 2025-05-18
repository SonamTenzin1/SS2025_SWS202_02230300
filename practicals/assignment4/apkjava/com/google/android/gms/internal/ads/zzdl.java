package com.google.android.gms.internal.ads;

import java.util.HashMap;

/* loaded from: classes2.dex */
public final class zzdl extends zzcf<Integer, Long> {

    /* renamed from: b, reason: collision with root package name */
    public long f15969b;

    /* renamed from: c, reason: collision with root package name */
    public long f15970c;

    public zzdl() {
        this.f15969b = -1L;
        this.f15970c = -1L;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzcf
    public final void a(String str) {
        HashMap b2 = zzcf.b(str);
        if (b2 != null) {
            this.f15969b = ((Long) b2.get(0)).longValue();
            this.f15970c = ((Long) b2.get(1)).longValue();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcf
    protected final HashMap<Integer, Long> c() {
        HashMap<Integer, Long> hashMap = new HashMap<>();
        hashMap.put(0, Long.valueOf(this.f15969b));
        hashMap.put(1, Long.valueOf(this.f15970c));
        return hashMap;
    }

    public zzdl(String str) {
        this();
        a(str);
    }
}
