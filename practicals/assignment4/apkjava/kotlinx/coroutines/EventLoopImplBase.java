package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;
import kotlinx.coroutines.internal.Symbol;
import kotlinx.coroutines.internal.ThreadSafeHeap;
import kotlinx.coroutines.internal.ThreadSafeHeapNode;
import okhttp3.HttpUrl;

/* compiled from: EventLoop.common.kt */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\u0018\u0002\b \u0018\u00002\u0002092\u00020::\u00044567B\u0007¢\u0006\u0004\b\u0001\u0010\u0002J\u000f\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0004\u0010\u0002J\u0017\u0010\u0007\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\bJ!\u0010\f\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\t2\n\u0010\u000b\u001a\u00060\u0005j\u0002`\u0006¢\u0006\u0004\b\f\u0010\rJ\u001b\u0010\u000f\u001a\u00020\u00032\n\u0010\u000e\u001a\u00060\u0005j\u0002`\u0006H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u001b\u0010\u0012\u001a\u00020\u00112\n\u0010\u000e\u001a\u00060\u0005j\u0002`\u0006H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0017\u0010\u0002J\u000f\u0010\u0018\u001a\u00020\u0003H\u0004¢\u0006\u0004\b\u0018\u0010\u0002J\u001d\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u001a¢\u0006\u0004\b\u001c\u0010\u001dJ\u001f\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u001aH\u0002¢\u0006\u0004\b\u001f\u0010 J#\u0010#\u001a\u00020\"2\u0006\u0010!\u001a\u00020\u00142\n\u0010\u000b\u001a\u00060\u0005j\u0002`\u0006H\u0004¢\u0006\u0004\b#\u0010$J%\u0010'\u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u00142\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00030%H\u0016¢\u0006\u0004\b'\u0010(J\u0017\u0010)\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u001aH\u0002¢\u0006\u0004\b)\u0010*J\u000f\u0010+\u001a\u00020\u0003H\u0016¢\u0006\u0004\b+\u0010\u0002R$\u0010-\u001a\u00020\u00112\u0006\u0010,\u001a\u00020\u00118B@BX\u0082\u000e¢\u0006\f\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u0014\u00101\u001a\u00020\u00118TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b1\u0010.R\u0014\u00103\u001a\u00020\u00148TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b2\u0010\u0016¨\u00068"}, d2 = {"Lkotlinx/coroutines/EventLoopImplBase;", "<init>", "()V", HttpUrl.FRAGMENT_ENCODE_SET, "closeQueue", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "dequeue", "()Ljava/lang/Runnable;", "Lkotlin/coroutines/CoroutineContext;", "context", "block", "dispatch", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Runnable;)V", "task", "enqueue", "(Ljava/lang/Runnable;)V", HttpUrl.FRAGMENT_ENCODE_SET, "enqueueImpl", "(Ljava/lang/Runnable;)Z", HttpUrl.FRAGMENT_ENCODE_SET, "processNextEvent", "()J", "rescheduleAllDelayed", "resetAll", "now", "Lkotlinx/coroutines/EventLoopImplBase$DelayedTask;", "delayedTask", "schedule", "(JLkotlinx/coroutines/EventLoopImplBase$DelayedTask;)V", HttpUrl.FRAGMENT_ENCODE_SET, "scheduleImpl", "(JLkotlinx/coroutines/EventLoopImplBase$DelayedTask;)I", "timeMillis", "Lkotlinx/coroutines/DisposableHandle;", "scheduleInvokeOnTimeout", "(JLjava/lang/Runnable;)Lkotlinx/coroutines/DisposableHandle;", "Lkotlinx/coroutines/CancellableContinuation;", "continuation", "scheduleResumeAfterDelay", "(JLkotlinx/coroutines/CancellableContinuation;)V", "shouldUnpark", "(Lkotlinx/coroutines/EventLoopImplBase$DelayedTask;)Z", "shutdown", "value", "isCompleted", "()Z", "setCompleted", "(Z)V", "isEmpty", "getNextTime", "nextTime", "DelayedResumeTask", "DelayedRunnableTask", "DelayedTask", "DelayedTaskQueue", "kotlinx-coroutines-core", "Lkotlinx/coroutines/EventLoopImplPlatform;", "Lkotlinx/coroutines/Delay;"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* renamed from: kotlinx.coroutines.j1, reason: from Kotlin metadata */
/* loaded from: classes3.dex */
public abstract class EventLoopImplBase extends EventLoopImplPlatform implements Delay {

    /* renamed from: j, reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f25844j = AtomicReferenceFieldUpdater.newUpdater(EventLoopImplBase.class, Object.class, "_queue");

    /* renamed from: k, reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f25845k = AtomicReferenceFieldUpdater.newUpdater(EventLoopImplBase.class, Object.class, "_delayed");
    private volatile /* synthetic */ Object _queue = null;
    private volatile /* synthetic */ Object _delayed = null;
    private volatile /* synthetic */ int _isCompleted = 0;

    /* compiled from: EventLoop.common.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\b\u0010\b\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\nH\u0016R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lkotlinx/coroutines/EventLoopImplBase$DelayedResumeTask;", "Lkotlinx/coroutines/EventLoopImplBase$DelayedTask;", "nanoTime", HttpUrl.FRAGMENT_ENCODE_SET, "cont", "Lkotlinx/coroutines/CancellableContinuation;", HttpUrl.FRAGMENT_ENCODE_SET, "(Lkotlinx/coroutines/EventLoopImplBase;JLkotlinx/coroutines/CancellableContinuation;)V", "run", "toString", HttpUrl.FRAGMENT_ENCODE_SET, "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* renamed from: kotlinx.coroutines.j1$a */
    /* loaded from: classes3.dex */
    private final class a extends b {

        /* renamed from: h, reason: collision with root package name */
        private final CancellableContinuation<kotlin.u> f25846h;

        /* JADX WARN: Multi-variable type inference failed */
        public a(long j2, CancellableContinuation<? super kotlin.u> cancellableContinuation) {
            super(j2);
            this.f25846h = cancellableContinuation;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f25846h.h(EventLoopImplBase.this, kotlin.u.a);
        }

        @Override // kotlinx.coroutines.EventLoopImplBase.b
        public String toString() {
            return super.toString() + this.f25846h;
        }
    }

    /* compiled from: EventLoop.common.kt */
    @Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\b \u0018\u00002\u00060\u0001j\u0002`\u00022\b\u0012\u0004\u0012\u00020\u00000\u00032\u00020\u00042\u00020\u0005B\r\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0011\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u0000H\u0096\u0002J\u0006\u0010\u001a\u001a\u00020\u001bJ\u001e\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!J\u000e\u0010\"\u001a\u00020#2\u0006\u0010\u001d\u001a\u00020\u0007J\b\u0010$\u001a\u00020%H\u0016R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R0\u0010\r\u001a\b\u0012\u0002\b\u0003\u0018\u00010\f2\f\u0010\u000b\u001a\b\u0012\u0002\b\u0003\u0018\u00010\f8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0012\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lkotlinx/coroutines/EventLoopImplBase$DelayedTask;", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", HttpUrl.FRAGMENT_ENCODE_SET, "Lkotlinx/coroutines/DisposableHandle;", "Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "nanoTime", HttpUrl.FRAGMENT_ENCODE_SET, "(J)V", "_heap", HttpUrl.FRAGMENT_ENCODE_SET, "value", "Lkotlinx/coroutines/internal/ThreadSafeHeap;", "heap", "getHeap", "()Lkotlinx/coroutines/internal/ThreadSafeHeap;", "setHeap", "(Lkotlinx/coroutines/internal/ThreadSafeHeap;)V", "index", HttpUrl.FRAGMENT_ENCODE_SET, "getIndex", "()I", "setIndex", "(I)V", "compareTo", "other", "dispose", HttpUrl.FRAGMENT_ENCODE_SET, "scheduleTask", "now", "delayed", "Lkotlinx/coroutines/EventLoopImplBase$DelayedTaskQueue;", "eventLoop", "Lkotlinx/coroutines/EventLoopImplBase;", "timeToExecute", HttpUrl.FRAGMENT_ENCODE_SET, "toString", HttpUrl.FRAGMENT_ENCODE_SET, "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* renamed from: kotlinx.coroutines.j1$b */
    /* loaded from: classes3.dex */
    public static abstract class b implements Runnable, Comparable<b>, DisposableHandle, ThreadSafeHeapNode {
        private volatile Object _heap;

        /* renamed from: f, reason: collision with root package name */
        public long f25848f;

        /* renamed from: g, reason: collision with root package name */
        private int f25849g = -1;

        public b(long j2) {
            this.f25848f = j2;
        }

        public final boolean A(long j2) {
            return j2 - this.f25848f >= 0;
        }

        @Override // kotlinx.coroutines.internal.ThreadSafeHeapNode
        public void D(int i2) {
            this.f25849g = i2;
        }

        @Override // kotlinx.coroutines.internal.ThreadSafeHeapNode
        /* renamed from: g, reason: from getter */
        public int getF25849g() {
            return this.f25849g;
        }

        @Override // kotlinx.coroutines.DisposableHandle
        public final synchronized void k() {
            Symbol symbol;
            Symbol symbol2;
            Object obj = this._heap;
            symbol = m1.a;
            if (obj == symbol) {
                return;
            }
            c cVar = obj instanceof c ? (c) obj : null;
            if (cVar != null) {
                cVar.g(this);
            }
            symbol2 = m1.a;
            this._heap = symbol2;
        }

        @Override // kotlinx.coroutines.internal.ThreadSafeHeapNode
        public void q(ThreadSafeHeap<?> threadSafeHeap) {
            Symbol symbol;
            Object obj = this._heap;
            symbol = m1.a;
            if (obj != symbol) {
                this._heap = threadSafeHeap;
                return;
            }
            throw new IllegalArgumentException("Failed requirement.".toString());
        }

        public String toString() {
            return "Delayed[nanos=" + this.f25848f + ']';
        }

        @Override // kotlinx.coroutines.internal.ThreadSafeHeapNode
        public ThreadSafeHeap<?> v() {
            Object obj = this._heap;
            if (obj instanceof ThreadSafeHeap) {
                return (ThreadSafeHeap) obj;
            }
            return null;
        }

        @Override // java.lang.Comparable
        /* renamed from: x, reason: merged with bridge method [inline-methods] */
        public int compareTo(b bVar) {
            long j2 = this.f25848f - bVar.f25848f;
            if (j2 > 0) {
                return 1;
            }
            return j2 < 0 ? -1 : 0;
        }

        public final synchronized int y(long j2, c cVar, EventLoopImplBase eventLoopImplBase) {
            Symbol symbol;
            Object obj = this._heap;
            symbol = m1.a;
            if (obj == symbol) {
                return 2;
            }
            synchronized (cVar) {
                b b2 = cVar.b();
                if (eventLoopImplBase.M0()) {
                    return 1;
                }
                if (b2 == null) {
                    cVar.f25850b = j2;
                } else {
                    long j3 = b2.f25848f;
                    if (j3 - j2 < 0) {
                        j2 = j3;
                    }
                    if (j2 - cVar.f25850b > 0) {
                        cVar.f25850b = j2;
                    }
                }
                long j4 = this.f25848f;
                long j5 = cVar.f25850b;
                if (j4 - j5 < 0) {
                    this.f25848f = j5;
                }
                cVar.a(this);
                return 0;
            }
        }
    }

    /* compiled from: EventLoop.common.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005R\u0012\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lkotlinx/coroutines/EventLoopImplBase$DelayedTaskQueue;", "Lkotlinx/coroutines/internal/ThreadSafeHeap;", "Lkotlinx/coroutines/EventLoopImplBase$DelayedTask;", "timeNow", HttpUrl.FRAGMENT_ENCODE_SET, "(J)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* renamed from: kotlinx.coroutines.j1$c */
    /* loaded from: classes3.dex */
    public static final class c extends ThreadSafeHeap<b> {

        /* renamed from: b, reason: collision with root package name */
        public long f25850b;

        public c(long j2) {
            this.f25850b = j2;
        }
    }

    private final void F0() {
        Symbol symbol;
        Symbol symbol2;
        if (s0.a() && !M0()) {
            throw new AssertionError();
        }
        while (true) {
            Object obj = this._queue;
            if (obj == null) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f25844j;
                symbol = m1.f25855b;
                if (atomicReferenceFieldUpdater.compareAndSet(this, null, symbol)) {
                    return;
                }
            } else if (!(obj instanceof LockFreeTaskQueueCore)) {
                symbol2 = m1.f25855b;
                if (obj == symbol2) {
                    return;
                }
                LockFreeTaskQueueCore lockFreeTaskQueueCore = new LockFreeTaskQueueCore(8, true);
                lockFreeTaskQueueCore.a((Runnable) obj);
                if (f25844j.compareAndSet(this, obj, lockFreeTaskQueueCore)) {
                    return;
                }
            } else {
                ((LockFreeTaskQueueCore) obj).d();
                return;
            }
        }
    }

    private final Runnable G0() {
        Symbol symbol;
        while (true) {
            Object obj = this._queue;
            if (obj == null) {
                return null;
            }
            if (!(obj instanceof LockFreeTaskQueueCore)) {
                symbol = m1.f25855b;
                if (obj == symbol) {
                    return null;
                }
                if (f25844j.compareAndSet(this, obj, null)) {
                    return (Runnable) obj;
                }
            } else {
                LockFreeTaskQueueCore lockFreeTaskQueueCore = (LockFreeTaskQueueCore) obj;
                Object j2 = lockFreeTaskQueueCore.j();
                if (j2 != LockFreeTaskQueueCore.f25830d) {
                    return (Runnable) j2;
                }
                f25844j.compareAndSet(this, obj, lockFreeTaskQueueCore.i());
            }
        }
    }

    private final boolean K0(Runnable runnable) {
        Symbol symbol;
        while (true) {
            Object obj = this._queue;
            if (M0()) {
                return false;
            }
            if (obj == null) {
                if (f25844j.compareAndSet(this, null, runnable)) {
                    return true;
                }
            } else if (!(obj instanceof LockFreeTaskQueueCore)) {
                symbol = m1.f25855b;
                if (obj == symbol) {
                    return false;
                }
                LockFreeTaskQueueCore lockFreeTaskQueueCore = new LockFreeTaskQueueCore(8, true);
                lockFreeTaskQueueCore.a((Runnable) obj);
                lockFreeTaskQueueCore.a(runnable);
                if (f25844j.compareAndSet(this, obj, lockFreeTaskQueueCore)) {
                    return true;
                }
            } else {
                LockFreeTaskQueueCore lockFreeTaskQueueCore2 = (LockFreeTaskQueueCore) obj;
                int a2 = lockFreeTaskQueueCore2.a(runnable);
                if (a2 == 0) {
                    return true;
                }
                if (a2 == 1) {
                    f25844j.compareAndSet(this, obj, lockFreeTaskQueueCore2.i());
                } else if (a2 == 2) {
                    return false;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v0, types: [int, boolean] */
    public final boolean M0() {
        return this._isCompleted;
    }

    private final void Q0() {
        b i2;
        if (kotlinx.coroutines.c.a() != null) {
            throw null;
        }
        long nanoTime = System.nanoTime();
        while (true) {
            c cVar = (c) this._delayed;
            if (cVar == null || (i2 = cVar.i()) == null) {
                return;
            } else {
                x0(nanoTime, i2);
            }
        }
    }

    private final int V0(long j2, b bVar) {
        if (M0()) {
            return 1;
        }
        c cVar = (c) this._delayed;
        if (cVar == null) {
            f25845k.compareAndSet(this, null, new c(j2));
            Object obj = this._delayed;
            kotlin.jvm.internal.m.c(obj);
            cVar = (c) obj;
        }
        return bVar.y(j2, cVar, this);
    }

    private final void X0(boolean z) {
        this._isCompleted = z ? 1 : 0;
    }

    private final boolean Z0(b bVar) {
        c cVar = (c) this._delayed;
        return (cVar != null ? cVar.e() : null) == bVar;
    }

    public void J0(Runnable runnable) {
        if (K0(runnable)) {
            y0();
        } else {
            DefaultExecutor.l.J0(runnable);
        }
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public final void K(CoroutineContext coroutineContext, Runnable runnable) {
        J0(runnable);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean N0() {
        Symbol symbol;
        if (!m0()) {
            return false;
        }
        c cVar = (c) this._delayed;
        if (cVar != null && !cVar.d()) {
            return false;
        }
        Object obj = this._queue;
        if (obj != null) {
            if (obj instanceof LockFreeTaskQueueCore) {
                return ((LockFreeTaskQueueCore) obj).g();
            }
            symbol = m1.f25855b;
            if (obj != symbol) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void R0() {
        this._queue = null;
        this._delayed = null;
    }

    public final void T0(long j2, b bVar) {
        int V0 = V0(j2, bVar);
        if (V0 == 0) {
            if (Z0(bVar)) {
                y0();
            }
        } else if (V0 == 1) {
            x0(j2, bVar);
        } else if (V0 != 2) {
            throw new IllegalStateException("unexpected result".toString());
        }
    }

    @Override // kotlinx.coroutines.EventLoop
    protected long a0() {
        b e2;
        long c2;
        Symbol symbol;
        if (super.a0() == 0) {
            return 0L;
        }
        Object obj = this._queue;
        if (obj != null) {
            if (!(obj instanceof LockFreeTaskQueueCore)) {
                symbol = m1.f25855b;
                return obj == symbol ? Long.MAX_VALUE : 0L;
            }
            if (!((LockFreeTaskQueueCore) obj).g()) {
                return 0L;
            }
        }
        c cVar = (c) this._delayed;
        if (cVar == null || (e2 = cVar.e()) == null) {
            return Long.MAX_VALUE;
        }
        long j2 = e2.f25848f;
        if (kotlinx.coroutines.c.a() != null) {
            throw null;
        }
        c2 = kotlin.ranges.l.c(j2 - System.nanoTime(), 0L);
        return c2;
    }

    @Override // kotlinx.coroutines.Delay
    public void e(long j2, CancellableContinuation<? super kotlin.u> cancellableContinuation) {
        long c2 = m1.c(j2);
        if (c2 < 4611686018427387903L) {
            if (kotlinx.coroutines.c.a() == null) {
                long nanoTime = System.nanoTime();
                a aVar = new a(c2 + nanoTime, cancellableContinuation);
                T0(nanoTime, aVar);
                q.a(cancellableContinuation, aVar);
                return;
            }
            throw null;
        }
    }

    @Override // kotlinx.coroutines.EventLoop
    public long n0() {
        b h2;
        if (p0()) {
            return 0L;
        }
        c cVar = (c) this._delayed;
        if (cVar != null && !cVar.d()) {
            if (kotlinx.coroutines.c.a() == null) {
                long nanoTime = System.nanoTime();
                do {
                    synchronized (cVar) {
                        b b2 = cVar.b();
                        if (b2 == null) {
                            h2 = null;
                        } else {
                            b bVar = b2;
                            h2 = bVar.A(nanoTime) ? K0(bVar) : false ? cVar.h(0) : null;
                        }
                    }
                } while (h2 != null);
            } else {
                throw null;
            }
        }
        Runnable G0 = G0();
        if (G0 != null) {
            G0.run();
            return 0L;
        }
        return a0();
    }

    @Override // kotlinx.coroutines.EventLoop
    public void shutdown() {
        ThreadLocalEventLoop.a.c();
        X0(true);
        F0();
        do {
        } while (n0() <= 0);
        Q0();
    }
}
