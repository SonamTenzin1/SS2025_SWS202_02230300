package com.google.firebase.iid;

import android.util.Log;
import android.util.Pair;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import java.util.Map;
import java.util.concurrent.Executor;

/* compiled from: com.google.firebase:firebase-iid@@21.1.0 */
/* loaded from: classes2.dex */
class s {
    private final Executor a;

    /* renamed from: b, reason: collision with root package name */
    private final Map<Pair<String, String>, Task<l>> f19654b = new c.e.a();

    /* compiled from: com.google.firebase:firebase-iid@@21.1.0 */
    /* loaded from: classes2.dex */
    interface a {
        Task<l> start();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(Executor executor) {
        this.a = executor;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public synchronized Task<l> a(String str, String str2, a aVar) {
        final Pair pair = new Pair(str, str2);
        Task<l> task = this.f19654b.get(pair);
        if (task != null) {
            if (Log.isLoggable("FirebaseInstanceId", 3)) {
                String valueOf = String.valueOf(pair);
                StringBuilder sb = new StringBuilder(valueOf.length() + 29);
                sb.append("Joining ongoing request for: ");
                sb.append(valueOf);
                Log.d("FirebaseInstanceId", sb.toString());
            }
            return task;
        }
        if (Log.isLoggable("FirebaseInstanceId", 3)) {
            String valueOf2 = String.valueOf(pair);
            StringBuilder sb2 = new StringBuilder(valueOf2.length() + 24);
            sb2.append("Making new request for: ");
            sb2.append(valueOf2);
            Log.d("FirebaseInstanceId", sb2.toString());
        }
        Task h2 = aVar.start().h(this.a, new Continuation(this, pair) { // from class: com.google.firebase.iid.r
            private final s a;

            /* renamed from: b, reason: collision with root package name */
            private final Pair f19653b;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.a = this;
                this.f19653b = pair;
            }

            @Override // com.google.android.gms.tasks.Continuation
            public Object a(Task task2) {
                this.a.b(this.f19653b, task2);
                return task2;
            }
        });
        this.f19654b.put(pair, h2);
        return h2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ Task b(Pair pair, Task task) throws Exception {
        synchronized (this) {
            this.f19654b.remove(pair);
        }
        return task;
    }
}
