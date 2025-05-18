package com.google.android.gms.internal.ads;

import java.util.HashMap;

/* loaded from: classes2.dex */
public final class zzeg extends zzcf<Integer, Long> {

    /* renamed from: b, reason: collision with root package name */
    public Long f16202b;

    /* renamed from: c, reason: collision with root package name */
    public Long f16203c;

    /* renamed from: d, reason: collision with root package name */
    public Long f16204d;

    /* renamed from: e, reason: collision with root package name */
    public Long f16205e;

    public zzeg() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzcf
    public final void a(String str) {
        HashMap b2 = zzcf.b(str);
        if (b2 != null) {
            this.f16202b = (Long) b2.get(0);
            this.f16203c = (Long) b2.get(1);
            this.f16204d = (Long) b2.get(2);
            this.f16205e = (Long) b2.get(3);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcf
    protected final HashMap<Integer, Long> c() {
        HashMap<Integer, Long> hashMap = new HashMap<>();
        hashMap.put(0, this.f16202b);
        hashMap.put(1, this.f16203c);
        hashMap.put(2, this.f16204d);
        hashMap.put(3, this.f16205e);
        return hashMap;
    }

    public zzeg(String str) {
        a(str);
    }
}
