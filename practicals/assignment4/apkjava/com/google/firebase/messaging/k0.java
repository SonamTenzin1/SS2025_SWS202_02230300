package com.google.firebase.messaging;

import android.util.Log;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import java.util.Map;
import java.util.concurrent.Executor;

/* compiled from: com.google.firebase:firebase-messaging@@21.1.0 */
/* loaded from: classes2.dex */
class k0 {
    private final Executor a;

    /* renamed from: b, reason: collision with root package name */
    private final Map<String, Task<String>> f19826b = new c.e.a();

    /* compiled from: com.google.firebase:firebase-messaging@@21.1.0 */
    /* loaded from: classes2.dex */
    interface a {
        Task<String> start();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public k0(Executor executor) {
        this.a = executor;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public synchronized Task<String> a(final String str, a aVar) {
        Task<String> task = this.f19826b.get(str);
        if (task != null) {
            if (Log.isLoggable("FirebaseMessaging", 3)) {
                String valueOf = String.valueOf(str);
                Log.d("FirebaseMessaging", valueOf.length() != 0 ? "Joining ongoing request for: ".concat(valueOf) : new String("Joining ongoing request for: "));
            }
            return task;
        }
        if (Log.isLoggable("FirebaseMessaging", 3)) {
            String valueOf2 = String.valueOf(str);
            Log.d("FirebaseMessaging", valueOf2.length() != 0 ? "Making new request for: ".concat(valueOf2) : new String("Making new request for: "));
        }
        Task h2 = aVar.start().h(this.a, new Continuation(this, str) { // from class: com.google.firebase.messaging.j0
            private final k0 a;

            /* renamed from: b, reason: collision with root package name */
            private final String f19824b;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.a = this;
                this.f19824b = str;
            }

            @Override // com.google.android.gms.tasks.Continuation
            public Object a(Task task2) {
                this.a.b(this.f19824b, task2);
                return task2;
            }
        });
        this.f19826b.put(str, h2);
        return h2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ Task b(String str, Task task) throws Exception {
        synchronized (this) {
            this.f19826b.remove(str);
        }
        return task;
    }
}
