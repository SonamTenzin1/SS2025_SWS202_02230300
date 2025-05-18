package com.google.android.gms.internal.ads;

import java.util.HashMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class ea implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ String f12515f;

    /* renamed from: g, reason: collision with root package name */
    private final /* synthetic */ String f12516g;

    /* renamed from: h, reason: collision with root package name */
    private final /* synthetic */ int f12517h;

    /* renamed from: i, reason: collision with root package name */
    private final /* synthetic */ zzbft f12518i;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ea(zzbft zzbftVar, String str, String str2, int i2) {
        this.f12518i = zzbftVar;
        this.f12515f = str;
        this.f12516g = str2;
        this.f12517h = i2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        HashMap hashMap = new HashMap();
        hashMap.put("event", "precacheComplete");
        hashMap.put("src", this.f12515f);
        hashMap.put("cachedSrc", this.f12516g);
        hashMap.put("totalBytes", Integer.toString(this.f12517h));
        this.f12518i.r("onPrecacheEvent", hashMap);
    }
}
