package com.google.android.gms.measurement.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement@@17.2.0 */
/* loaded from: classes2.dex */
public abstract class f7 extends h7 {

    /* renamed from: c, reason: collision with root package name */
    private boolean f17765c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f7(zzkc zzkcVar) {
        super(zzkcVar);
        this.f17811b.s(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean s() {
        return this.f17765c;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void t() {
        if (!s()) {
            throw new IllegalStateException("Not initialized");
        }
    }

    public final void u() {
        if (!this.f17765c) {
            v();
            this.f17811b.f0();
            this.f17765c = true;
            return;
        }
        throw new IllegalStateException("Can't initialize twice");
    }

    protected abstract boolean v();
}
