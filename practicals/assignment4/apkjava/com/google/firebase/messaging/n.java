package com.google.firebase.messaging;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-messaging@@21.1.0 */
/* loaded from: classes2.dex */
public final /* synthetic */ class n implements Continuation {
    static final Continuation a = new n();

    private n() {
    }

    @Override // com.google.android.gms.tasks.Continuation
    public Object a(Task task) {
        return o.e(task);
    }
}
