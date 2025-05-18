package com.google.android.gms.measurement.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.0 */
/* loaded from: classes2.dex */
public abstract class u2 extends k3 {

    /* renamed from: b, reason: collision with root package name */
    private boolean f17972b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u2(zzfx zzfxVar) {
        super(zzfxVar);
        this.a.d(this);
    }

    protected abstract boolean A();

    protected void v() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean w() {
        return this.f17972b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void x() {
        if (!w()) {
            throw new IllegalStateException("Not initialized");
        }
    }

    public final void y() {
        if (!this.f17972b) {
            if (A()) {
                return;
            }
            this.a.t();
            this.f17972b = true;
            return;
        }
        throw new IllegalStateException("Can't initialize twice");
    }

    public final void z() {
        if (!this.f17972b) {
            v();
            this.a.t();
            this.f17972b = true;
            return;
        }
        throw new IllegalStateException("Can't initialize twice");
    }
}
