package com.google.android.gms.internal.ads;

import java.util.HashMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class ca implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ String f12412f;

    /* renamed from: g, reason: collision with root package name */
    private final /* synthetic */ String f12413g;

    /* renamed from: h, reason: collision with root package name */
    private final /* synthetic */ long f12414h;

    /* renamed from: i, reason: collision with root package name */
    private final /* synthetic */ long f12415i;

    /* renamed from: j, reason: collision with root package name */
    private final /* synthetic */ boolean f12416j;

    /* renamed from: k, reason: collision with root package name */
    private final /* synthetic */ int f12417k;
    private final /* synthetic */ int l;
    private final /* synthetic */ zzbft m;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ca(zzbft zzbftVar, String str, String str2, long j2, long j3, boolean z, int i2, int i3) {
        this.m = zzbftVar;
        this.f12412f = str;
        this.f12413g = str2;
        this.f12414h = j2;
        this.f12415i = j3;
        this.f12416j = z;
        this.f12417k = i2;
        this.l = i3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        HashMap hashMap = new HashMap();
        hashMap.put("event", "precacheProgress");
        hashMap.put("src", this.f12412f);
        hashMap.put("cachedSrc", this.f12413g);
        hashMap.put("bufferedDuration", Long.toString(this.f12414h));
        hashMap.put("totalDuration", Long.toString(this.f12415i));
        hashMap.put("cacheReady", this.f12416j ? "1" : "0");
        hashMap.put("playerCount", Integer.toString(this.f12417k));
        hashMap.put("playerPreparedCount", Integer.toString(this.l));
        this.m.r("onPrecacheEvent", hashMap);
    }
}
