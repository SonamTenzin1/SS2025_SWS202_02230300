package com.google.android.gms.internal.ads;

import android.os.Handler;
import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
final class a00 implements Executor {

    /* renamed from: f, reason: collision with root package name */
    private final /* synthetic */ Handler f12207f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a00(zzi zziVar, Handler handler) {
        this.f12207f = handler;
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        this.f12207f.post(runnable);
    }
}
