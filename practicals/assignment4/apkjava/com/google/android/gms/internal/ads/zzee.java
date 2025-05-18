package com.google.android.gms.internal.ads;

import java.util.HashMap;

/* loaded from: classes2.dex */
public final class zzee extends zzcf<Integer, Long> {

    /* renamed from: b, reason: collision with root package name */
    public Long f16192b;

    /* renamed from: c, reason: collision with root package name */
    public Long f16193c;

    /* renamed from: d, reason: collision with root package name */
    public Long f16194d;

    /* renamed from: e, reason: collision with root package name */
    public Long f16195e;

    /* renamed from: f, reason: collision with root package name */
    public Long f16196f;

    /* renamed from: g, reason: collision with root package name */
    public Long f16197g;

    /* renamed from: h, reason: collision with root package name */
    public Long f16198h;

    /* renamed from: i, reason: collision with root package name */
    public Long f16199i;

    /* renamed from: j, reason: collision with root package name */
    public Long f16200j;

    /* renamed from: k, reason: collision with root package name */
    public Long f16201k;
    public Long l;

    public zzee() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzcf
    public final void a(String str) {
        HashMap b2 = zzcf.b(str);
        if (b2 != null) {
            this.f16192b = (Long) b2.get(0);
            this.f16193c = (Long) b2.get(1);
            this.f16194d = (Long) b2.get(2);
            this.f16195e = (Long) b2.get(3);
            this.f16196f = (Long) b2.get(4);
            this.f16197g = (Long) b2.get(5);
            this.f16198h = (Long) b2.get(6);
            this.f16199i = (Long) b2.get(7);
            this.f16200j = (Long) b2.get(8);
            this.f16201k = (Long) b2.get(9);
            this.l = (Long) b2.get(10);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcf
    protected final HashMap<Integer, Long> c() {
        HashMap<Integer, Long> hashMap = new HashMap<>();
        hashMap.put(0, this.f16192b);
        hashMap.put(1, this.f16193c);
        hashMap.put(2, this.f16194d);
        hashMap.put(3, this.f16195e);
        hashMap.put(4, this.f16196f);
        hashMap.put(5, this.f16197g);
        hashMap.put(6, this.f16198h);
        hashMap.put(7, this.f16199i);
        hashMap.put(8, this.f16200j);
        hashMap.put(9, this.f16201k);
        hashMap.put(10, this.l);
        return hashMap;
    }

    public zzee(String str) {
        a(str);
    }
}
