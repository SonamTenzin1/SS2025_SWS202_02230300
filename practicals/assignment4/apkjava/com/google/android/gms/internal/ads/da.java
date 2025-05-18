package com.google.android.gms.internal.ads;

import java.util.HashMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class da implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ String f12461f;

    /* renamed from: g, reason: collision with root package name */
    private final /* synthetic */ String f12462g;

    /* renamed from: h, reason: collision with root package name */
    private final /* synthetic */ int f12463h;

    /* renamed from: i, reason: collision with root package name */
    private final /* synthetic */ int f12464i;

    /* renamed from: j, reason: collision with root package name */
    private final /* synthetic */ long f12465j;

    /* renamed from: k, reason: collision with root package name */
    private final /* synthetic */ long f12466k;
    private final /* synthetic */ boolean l;
    private final /* synthetic */ int m;
    private final /* synthetic */ int n;
    private final /* synthetic */ zzbft o;

    /* JADX INFO: Access modifiers changed from: package-private */
    public da(zzbft zzbftVar, String str, String str2, int i2, int i3, long j2, long j3, boolean z, int i4, int i5) {
        this.o = zzbftVar;
        this.f12461f = str;
        this.f12462g = str2;
        this.f12463h = i2;
        this.f12464i = i3;
        this.f12465j = j2;
        this.f12466k = j3;
        this.l = z;
        this.m = i4;
        this.n = i5;
    }

    @Override // java.lang.Runnable
    public final void run() {
        HashMap hashMap = new HashMap();
        hashMap.put("event", "precacheProgress");
        hashMap.put("src", this.f12461f);
        hashMap.put("cachedSrc", this.f12462g);
        hashMap.put("bytesLoaded", Integer.toString(this.f12463h));
        hashMap.put("totalBytes", Integer.toString(this.f12464i));
        hashMap.put("bufferedDuration", Long.toString(this.f12465j));
        hashMap.put("totalDuration", Long.toString(this.f12466k));
        hashMap.put("cacheReady", this.l ? "1" : "0");
        hashMap.put("playerCount", Integer.toString(this.m));
        hashMap.put("playerPreparedCount", Integer.toString(this.n));
        this.o.r("onPrecacheEvent", hashMap);
    }
}
