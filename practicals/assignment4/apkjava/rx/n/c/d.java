package rx.n.c;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: GenericScheduledExecutorService.java */
/* loaded from: classes3.dex */
public final class d implements k {

    /* renamed from: f, reason: collision with root package name */
    private static final ScheduledExecutorService[] f26662f = new ScheduledExecutorService[0];

    /* renamed from: g, reason: collision with root package name */
    private static final ScheduledExecutorService f26663g;

    /* renamed from: h, reason: collision with root package name */
    public static final d f26664h;

    /* renamed from: i, reason: collision with root package name */
    private static int f26665i;

    /* renamed from: j, reason: collision with root package name */
    private final AtomicReference<ScheduledExecutorService[]> f26666j = new AtomicReference<>(f26662f);

    static {
        ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(0);
        f26663g = newScheduledThreadPool;
        newScheduledThreadPool.shutdown();
        f26664h = new d();
    }

    private d() {
        start();
    }

    public static ScheduledExecutorService a() {
        ScheduledExecutorService[] scheduledExecutorServiceArr = f26664h.f26666j.get();
        if (scheduledExecutorServiceArr == f26662f) {
            return f26663g;
        }
        int i2 = f26665i + 1;
        if (i2 >= scheduledExecutorServiceArr.length) {
            i2 = 0;
        }
        f26665i = i2;
        return scheduledExecutorServiceArr[i2];
    }

    @Override // rx.n.c.k
    public void shutdown() {
        ScheduledExecutorService[] scheduledExecutorServiceArr;
        ScheduledExecutorService[] scheduledExecutorServiceArr2;
        do {
            scheduledExecutorServiceArr = this.f26666j.get();
            scheduledExecutorServiceArr2 = f26662f;
            if (scheduledExecutorServiceArr == scheduledExecutorServiceArr2) {
                return;
            }
        } while (!this.f26666j.compareAndSet(scheduledExecutorServiceArr, scheduledExecutorServiceArr2));
        for (ScheduledExecutorService scheduledExecutorService : scheduledExecutorServiceArr) {
            h.f(scheduledExecutorService);
            scheduledExecutorService.shutdownNow();
        }
    }

    @Override // rx.n.c.k
    public void start() {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        if (availableProcessors > 4) {
            availableProcessors /= 2;
        }
        if (availableProcessors > 8) {
            availableProcessors = 8;
        }
        ScheduledExecutorService[] scheduledExecutorServiceArr = new ScheduledExecutorService[availableProcessors];
        int i2 = 0;
        for (int i3 = 0; i3 < availableProcessors; i3++) {
            scheduledExecutorServiceArr[i3] = e.g();
        }
        if (!this.f26666j.compareAndSet(f26662f, scheduledExecutorServiceArr)) {
            while (i2 < availableProcessors) {
                scheduledExecutorServiceArr[i2].shutdownNow();
                i2++;
            }
        } else {
            while (i2 < availableProcessors) {
                ScheduledExecutorService scheduledExecutorService = scheduledExecutorServiceArr[i2];
                if (!h.m(scheduledExecutorService) && (scheduledExecutorService instanceof ScheduledThreadPoolExecutor)) {
                    h.i((ScheduledThreadPoolExecutor) scheduledExecutorService);
                }
                i2++;
            }
        }
    }
}
