package com.google.firebase.messaging;

import android.content.Context;
import android.content.SharedPreferences;
import java.lang.ref.WeakReference;
import java.util.concurrent.Executor;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-messaging@@21.1.0 */
/* loaded from: classes2.dex */
public final class r0 {
    private static WeakReference<r0> a;

    /* renamed from: b, reason: collision with root package name */
    private final SharedPreferences f19853b;

    /* renamed from: c, reason: collision with root package name */
    private n0 f19854c;

    /* renamed from: d, reason: collision with root package name */
    private final Executor f19855d;

    private r0(SharedPreferences sharedPreferences, Executor executor) {
        this.f19855d = executor;
        this.f19853b = sharedPreferences;
    }

    public static synchronized r0 a(Context context, Executor executor) {
        synchronized (r0.class) {
            WeakReference<r0> weakReference = a;
            r0 r0Var = weakReference != null ? weakReference.get() : null;
            if (r0Var != null) {
                return r0Var;
            }
            r0 r0Var2 = new r0(context.getSharedPreferences("com.google.android.gms.appid", 0), executor);
            r0Var2.c();
            a = new WeakReference<>(r0Var2);
            return r0Var2;
        }
    }

    private synchronized void c() {
        this.f19854c = n0.c(this.f19853b, "topic_operation_queue", ",", this.f19855d);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized q0 b() {
        return q0.a(this.f19854c.e());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized boolean d(q0 q0Var) {
        return this.f19854c.f(q0Var.e());
    }
}
