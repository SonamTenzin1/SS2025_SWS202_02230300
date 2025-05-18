package com.google.android.gms.measurement.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.0 */
/* loaded from: classes2.dex */
public final class g implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ s4 f17766f;

    /* renamed from: g, reason: collision with root package name */
    private final /* synthetic */ f f17767g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(f fVar, s4 s4Var) {
        this.f17767g = fVar;
        this.f17766f = s4Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f17766f.G();
        if (zzw.a()) {
            this.f17766f.g().z(this);
            return;
        }
        boolean d2 = this.f17767g.d();
        f.a(this.f17767g, 0L);
        if (d2) {
            this.f17767g.b();
        }
    }
}
