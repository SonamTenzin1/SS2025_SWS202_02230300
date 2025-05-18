package com.google.android.gms.internal.ads;

import java.util.HashMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class fa implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ String f12574f;

    /* renamed from: g, reason: collision with root package name */
    private final /* synthetic */ String f12575g;

    /* renamed from: h, reason: collision with root package name */
    private final /* synthetic */ long f12576h;

    /* renamed from: i, reason: collision with root package name */
    private final /* synthetic */ zzbft f12577i;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fa(zzbft zzbftVar, String str, String str2, long j2) {
        this.f12577i = zzbftVar;
        this.f12574f = str;
        this.f12575g = str2;
        this.f12576h = j2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        HashMap hashMap = new HashMap();
        hashMap.put("event", "precacheComplete");
        hashMap.put("src", this.f12574f);
        hashMap.put("cachedSrc", this.f12575g);
        hashMap.put("totalDuration", Long.toString(this.f12576h));
        this.f12577i.r("onPrecacheEvent", hashMap);
    }
}
