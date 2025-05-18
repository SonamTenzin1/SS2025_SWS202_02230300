package com.google.android.gms.internal.ads;

import java.util.HashMap;

/* loaded from: classes2.dex */
final class z9 implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ String f13688f;

    /* renamed from: g, reason: collision with root package name */
    private final /* synthetic */ String f13689g;

    /* renamed from: h, reason: collision with root package name */
    private final /* synthetic */ int f13690h;

    /* renamed from: i, reason: collision with root package name */
    private final /* synthetic */ int f13691i;

    /* renamed from: j, reason: collision with root package name */
    private final /* synthetic */ boolean f13692j = false;

    /* renamed from: k, reason: collision with root package name */
    private final /* synthetic */ zzbft f13693k;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z9(zzbft zzbftVar, String str, String str2, int i2, int i3, boolean z) {
        this.f13693k = zzbftVar;
        this.f13688f = str;
        this.f13689g = str2;
        this.f13690h = i2;
        this.f13691i = i3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        HashMap hashMap = new HashMap();
        hashMap.put("event", "precacheProgress");
        hashMap.put("src", this.f13688f);
        hashMap.put("cachedSrc", this.f13689g);
        hashMap.put("bytesLoaded", Integer.toString(this.f13690h));
        hashMap.put("totalBytes", Integer.toString(this.f13691i));
        hashMap.put("cacheReady", this.f13692j ? "1" : "0");
        this.f13693k.r("onPrecacheEvent", hashMap);
    }
}
