package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class z20 implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ x20 f13671f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z20(x20 x20Var) {
        this.f13671f = x20Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean z;
        zzqk zzqkVar;
        z = this.f13671f.M;
        if (z) {
            return;
        }
        zzqkVar = this.f13671f.v;
        zzqkVar.g(this.f13671f);
    }
}
