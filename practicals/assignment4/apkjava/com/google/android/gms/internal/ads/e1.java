package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
final class e1 implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ String f12491f;

    /* renamed from: g, reason: collision with root package name */
    private final /* synthetic */ zzajy f12492g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e1(zzajy zzajyVar, String str) {
        this.f12492g = zzajyVar;
        this.f12491f = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzbgz zzbgzVar;
        zzbgzVar = this.f12492g.f13927f;
        zzbgzVar.loadData(this.f12491f, "text/html", "UTF-8");
    }
}
