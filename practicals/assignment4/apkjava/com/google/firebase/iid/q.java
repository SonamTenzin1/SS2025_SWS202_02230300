package com.google.firebase.iid;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;

/* compiled from: com.google.firebase:firebase-iid@@21.1.0 */
/* loaded from: classes2.dex */
final /* synthetic */ class q implements Continuation {
    static final Continuation a = new q();

    private q() {
    }

    @Override // com.google.android.gms.tasks.Continuation
    public Object a(Task task) {
        String a2;
        a2 = ((l) task.j()).a();
        return a2;
    }
}
