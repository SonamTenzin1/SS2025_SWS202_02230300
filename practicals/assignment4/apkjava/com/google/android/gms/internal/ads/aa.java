package com.google.android.gms.internal.ads;

import java.util.HashMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class aa implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ String f12232f;

    /* renamed from: g, reason: collision with root package name */
    private final /* synthetic */ String f12233g;

    /* renamed from: h, reason: collision with root package name */
    private final /* synthetic */ int f12234h;

    /* renamed from: i, reason: collision with root package name */
    private final /* synthetic */ int f12235i = 0;

    /* renamed from: j, reason: collision with root package name */
    private final /* synthetic */ boolean f12236j;

    /* renamed from: k, reason: collision with root package name */
    private final /* synthetic */ int f12237k;
    private final /* synthetic */ int l;
    private final /* synthetic */ zzbft m;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(zzbft zzbftVar, String str, String str2, int i2, int i3, boolean z, int i4, int i5) {
        this.m = zzbftVar;
        this.f12232f = str;
        this.f12233g = str2;
        this.f12234h = i2;
        this.f12236j = z;
        this.f12237k = i4;
        this.l = i5;
    }

    @Override // java.lang.Runnable
    public final void run() {
        HashMap hashMap = new HashMap();
        hashMap.put("event", "precacheProgress");
        hashMap.put("src", this.f12232f);
        hashMap.put("cachedSrc", this.f12233g);
        hashMap.put("bytesLoaded", Integer.toString(this.f12234h));
        hashMap.put("totalBytes", Integer.toString(this.f12235i));
        hashMap.put("cacheReady", this.f12236j ? "1" : "0");
        hashMap.put("playerCount", Integer.toString(this.f12237k));
        hashMap.put("playerPreparedCount", Integer.toString(this.l));
        this.m.r("onPrecacheEvent", hashMap);
    }
}
