package cm.aptoide.pt.util.schedulers;

import rx.h;
import rx.l.c.a;
import rx.schedulers.Schedulers;

/* loaded from: classes.dex */
public class ConcreteSchedulerProvider implements SchedulerProvider {
    private static ConcreteSchedulerProvider INSTANCE;

    private ConcreteSchedulerProvider() {
    }

    public static synchronized ConcreteSchedulerProvider getInstance() {
        ConcreteSchedulerProvider concreteSchedulerProvider;
        synchronized (ConcreteSchedulerProvider.class) {
            if (INSTANCE == null) {
                INSTANCE = new ConcreteSchedulerProvider();
            }
            concreteSchedulerProvider = INSTANCE;
        }
        return concreteSchedulerProvider;
    }

    @Override // cm.aptoide.pt.util.schedulers.SchedulerProvider
    public h computation() {
        return Schedulers.computation();
    }

    @Override // cm.aptoide.pt.util.schedulers.SchedulerProvider
    public h io() {
        return Schedulers.io();
    }

    @Override // cm.aptoide.pt.util.schedulers.SchedulerProvider
    public h ui() {
        return a.b();
    }
}
