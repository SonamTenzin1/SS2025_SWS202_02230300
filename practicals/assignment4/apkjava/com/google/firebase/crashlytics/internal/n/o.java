package com.google.firebase.crashlytics.internal.n;

import android.os.Process;

/* compiled from: BackgroundPriorityRunnable.java */
/* loaded from: classes2.dex */
public abstract class o implements Runnable {
    protected abstract void a();

    @Override // java.lang.Runnable
    public final void run() {
        Process.setThreadPriority(10);
        a();
    }
}
