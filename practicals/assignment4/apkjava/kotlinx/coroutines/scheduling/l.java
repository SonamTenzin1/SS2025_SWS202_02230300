package kotlinx.coroutines.scheduling;

import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlinx.coroutines.internal.f0;
import kotlinx.coroutines.internal.h0;
import okhttp3.HttpUrl;

/* compiled from: Tasks.kt */
@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\"\u0010\u0010\u0000\u001a\u00020\u00018\u0000X\u0081\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010\u0002\u001a\u00020\u00038\u0000X\u0081\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000\"\u0010\u0010\u0006\u001a\u00020\u00078\u0000X\u0081\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010\b\u001a\u00020\u00038\u0000X\u0081\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010\t\u001a\u00020\u00018\u0000X\u0081\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u0003X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\u0003X\u0080T¢\u0006\u0002\n\u0000\"\u0010\u0010\f\u001a\u00020\u00078\u0000X\u0081\u0004¢\u0006\u0002\n\u0000\"\u0012\u0010\r\u001a\u00020\u000e8\u0000@\u0000X\u0081\u000e¢\u0006\u0002\n\u0000\"\u0019\u0010\u000f\u001a\u00020\u0010*\u00020\u00118À\u0002X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0012¨\u0006\u0013"}, d2 = {"BlockingContext", "Lkotlinx/coroutines/scheduling/TaskContext;", "CORE_POOL_SIZE", HttpUrl.FRAGMENT_ENCODE_SET, "DEFAULT_SCHEDULER_NAME", HttpUrl.FRAGMENT_ENCODE_SET, "IDLE_WORKER_KEEP_ALIVE_NS", HttpUrl.FRAGMENT_ENCODE_SET, "MAX_POOL_SIZE", "NonBlockingContext", "TASK_NON_BLOCKING", "TASK_PROBABLY_BLOCKING", "WORK_STEALING_TIME_RESOLUTION_NS", "schedulerTimeSource", "Lkotlinx/coroutines/scheduling/SchedulerTimeSource;", "isBlocking", HttpUrl.FRAGMENT_ENCODE_SET, "Lkotlinx/coroutines/scheduling/Task;", "(Lkotlinx/coroutines/scheduling/Task;)Z", "kotlinx-coroutines-core"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class l {
    public static final long a;

    /* renamed from: b, reason: collision with root package name */
    public static final int f25682b;

    /* renamed from: c, reason: collision with root package name */
    public static final int f25683c;

    /* renamed from: d, reason: collision with root package name */
    public static final long f25684d;

    /* renamed from: e, reason: collision with root package name */
    public static SchedulerTimeSource f25685e;

    /* renamed from: f, reason: collision with root package name */
    public static final TaskContext f25686f;

    /* renamed from: g, reason: collision with root package name */
    public static final TaskContext f25687g;

    static {
        long e2;
        int b2;
        int d2;
        int d3;
        long e3;
        e2 = h0.e("kotlinx.coroutines.scheduler.resolution.ns", 100000L, 0L, 0L, 12, null);
        a = e2;
        b2 = kotlin.ranges.l.b(f0.a(), 2);
        d2 = h0.d("kotlinx.coroutines.scheduler.core.pool.size", b2, 1, 0, 8, null);
        f25682b = d2;
        d3 = h0.d("kotlinx.coroutines.scheduler.max.pool.size", 2097150, 0, 2097150, 4, null);
        f25683c = d3;
        TimeUnit timeUnit = TimeUnit.SECONDS;
        e3 = h0.e("kotlinx.coroutines.scheduler.keep.alive.sec", 60L, 0L, 0L, 12, null);
        f25684d = timeUnit.toNanos(e3);
        f25685e = NanoTimeSource.a;
        f25686f = new TaskContextImpl(0);
        f25687g = new TaskContextImpl(1);
    }
}
