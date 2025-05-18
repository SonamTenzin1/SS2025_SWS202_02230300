package com.google.android.gms.tasks;

/* compiled from: com.google.android.gms:play-services-tasks@@18.0.2 */
/* loaded from: classes2.dex */
final class i implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ j f18326f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(j jVar) {
        this.f18326f = jVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Object obj;
        OnCanceledListener onCanceledListener;
        OnCanceledListener onCanceledListener2;
        obj = this.f18326f.f18327b;
        synchronized (obj) {
            j jVar = this.f18326f;
            onCanceledListener = jVar.f18328c;
            if (onCanceledListener != null) {
                onCanceledListener2 = jVar.f18328c;
                onCanceledListener2.b();
            }
        }
    }
}
