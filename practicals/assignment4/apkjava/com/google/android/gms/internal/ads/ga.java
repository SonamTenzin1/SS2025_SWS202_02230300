package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.HashMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class ga implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ String f12635f;

    /* renamed from: g, reason: collision with root package name */
    private final /* synthetic */ String f12636g;

    /* renamed from: h, reason: collision with root package name */
    private final /* synthetic */ String f12637h;

    /* renamed from: i, reason: collision with root package name */
    private final /* synthetic */ String f12638i;

    /* renamed from: j, reason: collision with root package name */
    private final /* synthetic */ zzbft f12639j;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ga(zzbft zzbftVar, String str, String str2, String str3, String str4) {
        this.f12639j = zzbftVar;
        this.f12635f = str;
        this.f12636g = str2;
        this.f12637h = str3;
        this.f12638i = str4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String A;
        HashMap hashMap = new HashMap();
        hashMap.put("event", "precacheCanceled");
        hashMap.put("src", this.f12635f);
        if (!TextUtils.isEmpty(this.f12636g)) {
            hashMap.put("cachedSrc", this.f12636g);
        }
        zzbft zzbftVar = this.f12639j;
        A = zzbft.A(this.f12637h);
        hashMap.put("type", A);
        hashMap.put("reason", this.f12637h);
        if (!TextUtils.isEmpty(this.f12638i)) {
            hashMap.put("message", this.f12638i);
        }
        this.f12639j.r("onPrecacheEvent", hashMap);
    }
}
