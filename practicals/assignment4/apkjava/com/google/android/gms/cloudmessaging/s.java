package com.google.android.gms.cloudmessaging;

import android.os.Bundle;
import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-cloud-messaging@@16.0.0 */
/* loaded from: classes2.dex */
public final /* synthetic */ class s implements SuccessContinuation {
    static final SuccessContinuation a = new s();

    private s() {
    }

    @Override // com.google.android.gms.tasks.SuccessContinuation
    public final Task a(Object obj) {
        return Rpc.c((Bundle) obj);
    }
}
