package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzk;
import okhttp3.HttpUrl;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class ri extends zzair {

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ Object f13272f;

    /* renamed from: g, reason: collision with root package name */
    private final /* synthetic */ String f13273g;

    /* renamed from: h, reason: collision with root package name */
    private final /* synthetic */ long f13274h;

    /* renamed from: i, reason: collision with root package name */
    private final /* synthetic */ zzbbr f13275i;

    /* renamed from: j, reason: collision with root package name */
    private final /* synthetic */ zzcgb f13276j;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ri(zzcgb zzcgbVar, Object obj, String str, long j2, zzbbr zzbbrVar) {
        this.f13276j = zzcgbVar;
        this.f13272f = obj;
        this.f13273g = str;
        this.f13274h = j2;
        this.f13275i = zzbbrVar;
    }

    @Override // com.google.android.gms.internal.ads.zzaiq
    public final void onInitializationFailed(String str) {
        synchronized (this.f13272f) {
            this.f13276j.d(this.f13273g, false, str, (int) (zzk.zzln().b() - this.f13274h));
            this.f13275i.a(Boolean.FALSE);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaiq
    public final void onInitializationSucceeded() {
        synchronized (this.f13272f) {
            this.f13276j.d(this.f13273g, true, HttpUrl.FRAGMENT_ENCODE_SET, (int) (zzk.zzln().b() - this.f13274h));
            this.f13275i.a(Boolean.TRUE);
        }
    }
}
