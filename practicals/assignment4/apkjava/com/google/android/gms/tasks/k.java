package com.google.android.gms.tasks;

/* compiled from: com.google.android.gms:play-services-tasks@@18.0.2 */
/* loaded from: classes2.dex */
final class k implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ Task f18329f;

    /* renamed from: g, reason: collision with root package name */
    final /* synthetic */ l f18330g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(l lVar, Task task) {
        this.f18330g = lVar;
        this.f18329f = task;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Object obj;
        OnCompleteListener onCompleteListener;
        OnCompleteListener onCompleteListener2;
        obj = this.f18330g.f18331b;
        synchronized (obj) {
            l lVar = this.f18330g;
            onCompleteListener = lVar.f18332c;
            if (onCompleteListener != null) {
                onCompleteListener2 = lVar.f18332c;
                onCompleteListener2.a(this.f18329f);
            }
        }
    }
}
