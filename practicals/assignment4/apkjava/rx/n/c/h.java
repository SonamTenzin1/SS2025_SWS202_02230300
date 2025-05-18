package rx.n.c;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import rx.h;

/* compiled from: NewThreadWorker.java */
/* loaded from: classes3.dex */
public class h extends h.a implements rx.k {

    /* renamed from: f, reason: collision with root package name */
    private static final boolean f26671f;

    /* renamed from: j, reason: collision with root package name */
    private static volatile Object f26675j;
    private final ScheduledExecutorService l;
    volatile boolean m;

    /* renamed from: k, reason: collision with root package name */
    private static final Object f26676k = new Object();

    /* renamed from: h, reason: collision with root package name */
    private static final ConcurrentHashMap<ScheduledThreadPoolExecutor, ScheduledThreadPoolExecutor> f26673h = new ConcurrentHashMap<>();

    /* renamed from: i, reason: collision with root package name */
    private static final AtomicReference<ScheduledExecutorService> f26674i = new AtomicReference<>();

    /* renamed from: g, reason: collision with root package name */
    public static final int f26672g = Integer.getInteger("rx.scheduler.jdk6.purge-frequency-millis", 1000).intValue();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: NewThreadWorker.java */
    /* loaded from: classes3.dex */
    public static class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            h.h();
        }
    }

    static {
        boolean z = Boolean.getBoolean("rx.scheduler.jdk6.purge-force");
        int a2 = rx.n.e.g.a();
        f26671f = !z && (a2 == 0 || a2 >= 21);
    }

    public h(ThreadFactory threadFactory) {
        ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(1, threadFactory);
        if (!m(newScheduledThreadPool) && (newScheduledThreadPool instanceof ScheduledThreadPoolExecutor)) {
            i((ScheduledThreadPoolExecutor) newScheduledThreadPool);
        }
        this.l = newScheduledThreadPool;
    }

    public static void f(ScheduledExecutorService scheduledExecutorService) {
        f26673h.remove(scheduledExecutorService);
    }

    static Method g(ScheduledExecutorService scheduledExecutorService) {
        for (Method method : scheduledExecutorService.getClass().getMethods()) {
            if (method.getName().equals("setRemoveOnCancelPolicy")) {
                Class<?>[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length == 1 && parameterTypes[0] == Boolean.TYPE) {
                    return method;
                }
            }
        }
        return null;
    }

    static void h() {
        try {
            Iterator<ScheduledThreadPoolExecutor> it = f26673h.keySet().iterator();
            while (it.hasNext()) {
                ScheduledThreadPoolExecutor next = it.next();
                if (!next.isShutdown()) {
                    next.purge();
                } else {
                    it.remove();
                }
            }
        } catch (Throwable th) {
            rx.exceptions.a.e(th);
            rx.q.c.j(th);
        }
    }

    public static void i(ScheduledThreadPoolExecutor scheduledThreadPoolExecutor) {
        while (true) {
            AtomicReference<ScheduledExecutorService> atomicReference = f26674i;
            if (atomicReference.get() != null) {
                break;
            }
            ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(1, new rx.n.e.i("RxSchedulerPurge-"));
            if (atomicReference.compareAndSet(null, newScheduledThreadPool)) {
                a aVar = new a();
                int i2 = f26672g;
                newScheduledThreadPool.scheduleAtFixedRate(aVar, i2, i2, TimeUnit.MILLISECONDS);
                break;
            }
            newScheduledThreadPool.shutdownNow();
        }
        f26673h.putIfAbsent(scheduledThreadPoolExecutor, scheduledThreadPoolExecutor);
    }

    public static boolean m(ScheduledExecutorService scheduledExecutorService) {
        Method g2;
        if (f26671f) {
            if (scheduledExecutorService instanceof ScheduledThreadPoolExecutor) {
                Object obj = f26675j;
                Object obj2 = f26676k;
                if (obj == obj2) {
                    return false;
                }
                if (obj == null) {
                    g2 = g(scheduledExecutorService);
                    if (g2 != null) {
                        obj2 = g2;
                    }
                    f26675j = obj2;
                } else {
                    g2 = (Method) obj;
                }
            } else {
                g2 = g(scheduledExecutorService);
            }
            if (g2 != null) {
                try {
                    g2.invoke(scheduledExecutorService, Boolean.TRUE);
                    return true;
                } catch (IllegalAccessException e2) {
                    rx.q.c.j(e2);
                } catch (IllegalArgumentException e3) {
                    rx.q.c.j(e3);
                } catch (InvocationTargetException e4) {
                    rx.q.c.j(e4);
                }
            }
        }
        return false;
    }

    @Override // rx.h.a
    public rx.k c(rx.m.a aVar) {
        return d(aVar, 0L, null);
    }

    @Override // rx.h.a
    public rx.k d(rx.m.a aVar, long j2, TimeUnit timeUnit) {
        if (this.m) {
            return rx.t.e.c();
        }
        return j(aVar, j2, timeUnit);
    }

    @Override // rx.k
    public boolean isUnsubscribed() {
        return this.m;
    }

    public j j(rx.m.a aVar, long j2, TimeUnit timeUnit) {
        Future<?> schedule;
        j jVar = new j(rx.q.c.q(aVar));
        if (j2 <= 0) {
            schedule = this.l.submit(jVar);
        } else {
            schedule = this.l.schedule(jVar, j2, timeUnit);
        }
        jVar.a(schedule);
        return jVar;
    }

    public j k(rx.m.a aVar, long j2, TimeUnit timeUnit, rx.n.e.l lVar) {
        Future<?> schedule;
        j jVar = new j(rx.q.c.q(aVar), lVar);
        lVar.a(jVar);
        if (j2 <= 0) {
            schedule = this.l.submit(jVar);
        } else {
            schedule = this.l.schedule(jVar, j2, timeUnit);
        }
        jVar.a(schedule);
        return jVar;
    }

    public j l(rx.m.a aVar, long j2, TimeUnit timeUnit, rx.t.b bVar) {
        Future<?> schedule;
        j jVar = new j(rx.q.c.q(aVar), bVar);
        bVar.a(jVar);
        if (j2 <= 0) {
            schedule = this.l.submit(jVar);
        } else {
            schedule = this.l.schedule(jVar, j2, timeUnit);
        }
        jVar.a(schedule);
        return jVar;
    }

    @Override // rx.k
    public void unsubscribe() {
        this.m = true;
        this.l.shutdownNow();
        f(this.l);
    }
}
