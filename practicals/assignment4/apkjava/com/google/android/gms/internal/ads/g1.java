package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
final class g1 implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ String f12612f;

    /* renamed from: g, reason: collision with root package name */
    private final /* synthetic */ zzajy f12613g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g1(zzajy zzajyVar, String str) {
        this.f12613g = zzajyVar;
        this.f12612f = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzbgz zzbgzVar;
        zzbgzVar = this.f12613g.f13927f;
        zzbgzVar.loadUrl(this.f12612f);
    }
}
