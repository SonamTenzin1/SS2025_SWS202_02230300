package com.google.android.gms.internal.ads;

/* loaded from: classes2.dex */
final /* synthetic */ class w7 implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    private final zzbco f13499f;

    private w7(zzbco zzbcoVar) {
        this.f13499f = zzbcoVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Runnable a(zzbco zzbcoVar) {
        return new w7(zzbcoVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f13499f.i();
    }
}
