package com.google.firebase.messaging;

import android.content.Intent;
import android.os.Binder;
import android.os.Process;
import android.util.Log;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.b1;

/* compiled from: com.google.firebase:firebase-messaging@@21.1.0 */
/* loaded from: classes2.dex */
class y0 extends Binder {

    /* renamed from: f, reason: collision with root package name */
    private final a f19884f;

    /* compiled from: com.google.firebase:firebase-messaging@@21.1.0 */
    /* loaded from: classes2.dex */
    interface a {
        Task<Void> a(Intent intent);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public y0(a aVar) {
        this.f19884f = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(final b1.a aVar) {
        if (Binder.getCallingUid() == Process.myUid()) {
            if (Log.isLoggable("FirebaseMessaging", 3)) {
                Log.d("FirebaseMessaging", "service received new intent via bind strategy");
            }
            this.f19884f.a(aVar.a).c(w0.f19882f, new OnCompleteListener(aVar) { // from class: com.google.firebase.messaging.x0
                private final b1.a a;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.a = aVar;
                }

                @Override // com.google.android.gms.tasks.OnCompleteListener
                public void a(Task task) {
                    this.a.b();
                }
            });
            return;
        }
        throw new SecurityException("Binding only allowed within app");
    }
}
