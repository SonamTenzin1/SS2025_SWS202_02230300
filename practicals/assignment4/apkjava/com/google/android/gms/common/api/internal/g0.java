package com.google.android.gms.common.api.internal;

/* loaded from: classes2.dex */
final class g0 implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ com.google.android.gms.signin.internal.zaj f11755f;

    /* renamed from: g, reason: collision with root package name */
    private final /* synthetic */ zace f11756g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g0(zace zaceVar, com.google.android.gms.signin.internal.zaj zajVar) {
        this.f11756g = zaceVar;
        this.f11755f = zajVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f11756g.A5(this.f11755f);
    }
}
