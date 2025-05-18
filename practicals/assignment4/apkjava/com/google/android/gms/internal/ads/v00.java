package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class v00 implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ String f13415f;

    /* renamed from: g, reason: collision with root package name */
    private final /* synthetic */ long f13416g;

    /* renamed from: h, reason: collision with root package name */
    private final /* synthetic */ long f13417h;

    /* renamed from: i, reason: collision with root package name */
    private final /* synthetic */ zzma f13418i;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v00(zzma zzmaVar, String str, long j2, long j3) {
        this.f13418i = zzmaVar;
        this.f13415f = str;
        this.f13416g = j2;
        this.f13417h = j3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzlz zzlzVar;
        zzlzVar = this.f13418i.f16456b;
        zzlzVar.d(this.f13415f, this.f13416g, this.f13417h);
    }
}
