package com.google.android.gms.tasks;

import java.util.concurrent.ExecutionException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-tasks@@18.0.2 */
/* loaded from: classes2.dex */
public final class c<T> implements b<T> {
    private final Object a = new Object();

    /* renamed from: b, reason: collision with root package name */
    private final int f18311b;

    /* renamed from: c, reason: collision with root package name */
    private final x f18312c;

    /* renamed from: d, reason: collision with root package name */
    private int f18313d;

    /* renamed from: e, reason: collision with root package name */
    private int f18314e;

    /* renamed from: f, reason: collision with root package name */
    private int f18315f;

    /* renamed from: g, reason: collision with root package name */
    private Exception f18316g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f18317h;

    public c(int i2, x xVar) {
        this.f18311b = i2;
        this.f18312c = xVar;
    }

    private final void a() {
        if (this.f18313d + this.f18314e + this.f18315f == this.f18311b) {
            if (this.f18316g == null) {
                if (this.f18317h) {
                    this.f18312c.s();
                    return;
                } else {
                    this.f18312c.r(null);
                    return;
                }
            }
            this.f18312c.q(new ExecutionException(this.f18314e + " out of " + this.f18311b + " underlying tasks failed", this.f18316g));
        }
    }

    @Override // com.google.android.gms.tasks.OnCanceledListener
    public final void b() {
        synchronized (this.a) {
            this.f18315f++;
            this.f18317h = true;
            a();
        }
    }

    @Override // com.google.android.gms.tasks.OnFailureListener
    public final void c(Exception exc) {
        synchronized (this.a) {
            this.f18314e++;
            this.f18316g = exc;
            a();
        }
    }

    @Override // com.google.android.gms.tasks.OnSuccessListener
    public final void onSuccess(T t) {
        synchronized (this.a) {
            this.f18313d++;
            a();
        }
    }
}
