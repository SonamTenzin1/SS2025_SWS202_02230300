package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class w30 implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ String f13491f;

    /* renamed from: g, reason: collision with root package name */
    private final /* synthetic */ long f13492g;

    /* renamed from: h, reason: collision with root package name */
    private final /* synthetic */ long f13493h;

    /* renamed from: i, reason: collision with root package name */
    private final /* synthetic */ zzto f13494i;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w30(zzto zztoVar, String str, long j2, long j3) {
        this.f13494i = zztoVar;
        this.f13491f = str;
        this.f13492g = j2;
        this.f13493h = j3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zztn zztnVar;
        zztnVar = this.f13494i.f16775b;
        zztnVar.g(this.f13491f, this.f13492g, this.f13493h);
    }
}
