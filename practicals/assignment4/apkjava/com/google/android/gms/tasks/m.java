package com.google.android.gms.tasks;

import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-tasks@@18.0.2 */
/* loaded from: classes2.dex */
final class m implements Runnable {

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ Task f18333f;

    /* renamed from: g, reason: collision with root package name */
    final /* synthetic */ n f18334g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(n nVar, Task task) {
        this.f18334g = nVar;
        this.f18333f = task;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Object obj;
        OnFailureListener onFailureListener;
        OnFailureListener onFailureListener2;
        obj = this.f18334g.f18335b;
        synchronized (obj) {
            n nVar = this.f18334g;
            onFailureListener = nVar.f18336c;
            if (onFailureListener != null) {
                onFailureListener2 = nVar.f18336c;
                onFailureListener2.c((Exception) Preconditions.k(this.f18333f.i()));
            }
        }
    }
}
