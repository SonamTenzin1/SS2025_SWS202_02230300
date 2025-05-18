package com.google.android.gms.internal.ads;

import android.os.Looper;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class d8 implements Runnable {
    /* JADX INFO: Access modifiers changed from: package-private */
    public d8(c8 c8Var) {
    }

    @Override // java.lang.Runnable
    public final void run() {
        Looper.myLooper().quit();
    }
}
