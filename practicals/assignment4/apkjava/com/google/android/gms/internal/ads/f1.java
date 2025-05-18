package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
final class f1 implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ String f12552f;

    /* renamed from: g, reason: collision with root package name */
    private final /* synthetic */ zzajy f12553g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f1(zzajy zzajyVar, String str) {
        this.f12553g = zzajyVar;
        this.f12552f = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzbgz zzbgzVar;
        zzbgzVar = this.f12553g.f13927f;
        zzbgzVar.loadData(this.f12552f, "text/html", "UTF-8");
    }
}
