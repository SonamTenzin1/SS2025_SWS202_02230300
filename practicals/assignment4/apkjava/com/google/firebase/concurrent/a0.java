package com.google.firebase.concurrent;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;

/* compiled from: UiExecutor.java */
/* loaded from: classes2.dex */
public enum a0 implements Executor {
    INSTANCE;


    /* renamed from: g, reason: collision with root package name */
    @SuppressLint({"ThreadPoolCreation"})
    private static final Handler f18929g = new Handler(Looper.getMainLooper());

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        f18929g.post(runnable);
    }
}
