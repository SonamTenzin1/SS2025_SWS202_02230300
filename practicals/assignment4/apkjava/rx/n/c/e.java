package rx.n.c;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: GenericScheduledExecutorServiceFactory.java */
/* loaded from: classes3.dex */
public enum e {
    ;


    /* renamed from: f, reason: collision with root package name */
    static final rx.n.e.i f26667f = new rx.n.e.i("RxScheduledExecutorPool-");

    public static ScheduledExecutorService g() {
        rx.m.d<? extends ScheduledExecutorService> a = rx.q.c.a();
        if (a == null) {
            return k();
        }
        return a.call();
    }

    static ScheduledExecutorService k() {
        return Executors.newScheduledThreadPool(1, q());
    }

    static ThreadFactory q() {
        return f26667f;
    }
}
