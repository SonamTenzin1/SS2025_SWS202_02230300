package com.google.android.gms.internal.ads;

import java.util.HashMap;

/* loaded from: classes2.dex */
public final class zzch extends zzcf<Integer, Object> {

    /* renamed from: b, reason: collision with root package name */
    public String f15228b;

    /* renamed from: c, reason: collision with root package name */
    public long f15229c;

    /* renamed from: d, reason: collision with root package name */
    public String f15230d;

    /* renamed from: e, reason: collision with root package name */
    public String f15231e;

    /* renamed from: f, reason: collision with root package name */
    public String f15232f;

    public zzch(String str) {
        this();
        a(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.ads.zzcf
    public final void a(String str) {
        HashMap b2 = zzcf.b(str);
        if (b2 != null) {
            this.f15228b = b2.get(0) == null ? "E" : (String) b2.get(0);
            this.f15229c = b2.get(1) == null ? -1L : ((Long) b2.get(1)).longValue();
            this.f15230d = b2.get(2) == null ? "E" : (String) b2.get(2);
            this.f15231e = b2.get(3) == null ? "E" : (String) b2.get(3);
            this.f15232f = b2.get(4) != null ? (String) b2.get(4) : "E";
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcf
    protected final HashMap<Integer, Object> c() {
        HashMap<Integer, Object> hashMap = new HashMap<>();
        hashMap.put(0, this.f15228b);
        hashMap.put(4, this.f15232f);
        hashMap.put(3, this.f15231e);
        hashMap.put(2, this.f15230d);
        hashMap.put(1, Long.valueOf(this.f15229c));
        return hashMap;
    }

    public zzch() {
        this.f15228b = "E";
        this.f15229c = -1L;
        this.f15230d = "E";
        this.f15231e = "E";
        this.f15232f = "E";
    }
}
