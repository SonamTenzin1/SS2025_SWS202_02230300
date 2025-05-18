package com.google.android.gms.tasks;

/* compiled from: com.google.android.gms:play-services-tasks@@18.0.2 */
/* loaded from: classes2.dex */
final class o implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ Task f18337f;

    /* renamed from: g, reason: collision with root package name */
    final /* synthetic */ p f18338g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(p pVar, Task task) {
        this.f18338g = pVar;
        this.f18337f = task;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Object obj;
        OnSuccessListener onSuccessListener;
        OnSuccessListener onSuccessListener2;
        obj = this.f18338g.f18339b;
        synchronized (obj) {
            p pVar = this.f18338g;
            onSuccessListener = pVar.f18340c;
            if (onSuccessListener != null) {
                onSuccessListener2 = pVar.f18340c;
                onSuccessListener2.onSuccess(this.f18337f.j());
            }
        }
    }
}
