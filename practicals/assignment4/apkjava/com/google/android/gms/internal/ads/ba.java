package com.google.android.gms.internal.ads;

import java.util.HashMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class ba implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ String f12328f;

    /* renamed from: g, reason: collision with root package name */
    private final /* synthetic */ String f12329g;

    /* renamed from: h, reason: collision with root package name */
    private final /* synthetic */ long f12330h;

    /* renamed from: i, reason: collision with root package name */
    private final /* synthetic */ long f12331i;

    /* renamed from: j, reason: collision with root package name */
    private final /* synthetic */ boolean f12332j;

    /* renamed from: k, reason: collision with root package name */
    private final /* synthetic */ zzbft f12333k;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ba(zzbft zzbftVar, String str, String str2, long j2, long j3, boolean z) {
        this.f12333k = zzbftVar;
        this.f12328f = str;
        this.f12329g = str2;
        this.f12330h = j2;
        this.f12331i = j3;
        this.f12332j = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        HashMap hashMap = new HashMap();
        hashMap.put("event", "precacheProgress");
        hashMap.put("src", this.f12328f);
        hashMap.put("cachedSrc", this.f12329g);
        hashMap.put("bufferedDuration", Long.toString(this.f12330h));
        hashMap.put("totalDuration", Long.toString(this.f12331i));
        hashMap.put("cacheReady", this.f12332j ? "1" : "0");
        this.f12333k.r("onPrecacheEvent", hashMap);
    }
}
