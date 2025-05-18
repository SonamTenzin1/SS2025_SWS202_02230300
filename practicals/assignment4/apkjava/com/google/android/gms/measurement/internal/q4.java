package com.google.android.gms.measurement.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.0 */
/* loaded from: classes2.dex */
public abstract class q4 extends r4 {

    /* renamed from: b, reason: collision with root package name */
    private boolean f17912b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q4(zzfx zzfxVar) {
        super(zzfxVar);
        this.a.i(this);
    }

    protected void o() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void p() {
        if (!t()) {
            throw new IllegalStateException("Not initialized");
        }
    }

    public final void q() {
        if (!this.f17912b) {
            if (s()) {
                return;
            }
            this.a.t();
            this.f17912b = true;
            return;
        }
        throw new IllegalStateException("Can't initialize twice");
    }

    public final void r() {
        if (!this.f17912b) {
            o();
            this.a.t();
            this.f17912b = true;
            return;
        }
        throw new IllegalStateException("Can't initialize twice");
    }

    protected abstract boolean s();

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean t() {
        return this.f17912b;
    }
}
