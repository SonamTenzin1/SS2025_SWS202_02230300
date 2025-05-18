package androidx.work;

import android.content.Context;
import androidx.work.ListenableWorker;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.j.internal.DebugMetadata;
import kotlin.coroutines.j.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.d2;
import kotlinx.coroutines.p0;

/* compiled from: CoroutineWorker.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010 \u001a\u00020\u001f\u0012\u0006\u0010\"\u001a\u00020!¢\u0006\u0004\b#\u0010$J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0013\u0010\u0006\u001a\u00020\u0003H¦@ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007J\u0013\u0010\t\u001a\u00020\bH\u0096@ø\u0001\u0000¢\u0006\u0004\b\t\u0010\u0007J\u0013\u0010\n\u001a\b\u0012\u0004\u0012\u00020\b0\u0002¢\u0006\u0004\b\n\u0010\u0005J\r\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rR\"\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00030\u000e8\u0000@\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\"\u0010\u0019\u001a\u00020\u00148\u0016@\u0017X\u0097\u0004¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u0012\u0004\b\u0018\u0010\r\u001a\u0004\b\u0015\u0010\u0017R\u001c\u0010\u001e\u001a\u00020\u001a8\u0000@\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006%"}, d2 = {"Landroidx/work/CoroutineWorker;", "Landroidx/work/ListenableWorker;", "Le/e/c/a/a/a;", "Landroidx/work/ListenableWorker$a;", "startWork", "()Le/e/c/a/a/a;", "a", "(Lkotlin/y/d;)Ljava/lang/Object;", "Landroidx/work/h;", "d", "getForegroundInfoAsync", "Lkotlin/u;", "onStopped", "()V", "Landroidx/work/impl/utils/o/c;", "b", "Landroidx/work/impl/utils/o/c;", "g", "()Landroidx/work/impl/utils/o/c;", "future", "Lkotlinx/coroutines/i0;", "c", "Lkotlinx/coroutines/i0;", "()Lkotlinx/coroutines/i0;", "getCoroutineContext$annotations", "coroutineContext", "Lkotlinx/coroutines/z;", "Lkotlinx/coroutines/z;", "h", "()Lkotlinx/coroutines/z;", "job", "Landroid/content/Context;", "appContext", "Landroidx/work/WorkerParameters;", "params", "<init>", "(Landroid/content/Context;Landroidx/work/WorkerParameters;)V", "work-runtime-ktx_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes.dex */
public abstract class CoroutineWorker extends ListenableWorker {

    /* renamed from: a, reason: from kotlin metadata */
    private final CompletableJob job;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final androidx.work.impl.utils.o.c<ListenableWorker.a> future;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final CoroutineDispatcher coroutineContext;

    /* compiled from: CoroutineWorker.kt */
    /* loaded from: classes.dex */
    static final class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (CoroutineWorker.this.g().isCancelled()) {
                Job.a.a(CoroutineWorker.this.getJob(), null, 1, null);
            }
        }
    }

    /* compiled from: CoroutineWorker.kt */
    @DebugMetadata(c = "androidx.work.CoroutineWorker$getForegroundInfoAsync$1", f = "CoroutineWorker.kt", l = {134}, m = "invokeSuspend")
    /* loaded from: classes.dex */
    static final class b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super kotlin.u>, Object> {

        /* renamed from: f, reason: collision with root package name */
        Object f2267f;

        /* renamed from: g, reason: collision with root package name */
        int f2268g;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ m<h> f2269h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ CoroutineWorker f2270i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(m<h> mVar, CoroutineWorker coroutineWorker, Continuation<? super b> continuation) {
            super(2, continuation);
            this.f2269h = mVar;
            this.f2270i = coroutineWorker;
        }

        @Override // kotlin.coroutines.j.internal.BaseContinuationImpl
        public final Continuation<kotlin.u> create(Object obj, Continuation<?> continuation) {
            return new b(this.f2269h, this.f2270i, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super kotlin.u> continuation) {
            return ((b) create(coroutineScope, continuation)).invokeSuspend(kotlin.u.a);
        }

        @Override // kotlin.coroutines.j.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object c2;
            m mVar;
            c2 = kotlin.coroutines.intrinsics.d.c();
            int i2 = this.f2268g;
            if (i2 == 0) {
                kotlin.o.b(obj);
                m<h> mVar2 = this.f2269h;
                CoroutineWorker coroutineWorker = this.f2270i;
                this.f2267f = mVar2;
                this.f2268g = 1;
                Object d2 = coroutineWorker.d(this);
                if (d2 == c2) {
                    return c2;
                }
                mVar = mVar2;
                obj = d2;
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                mVar = (m) this.f2267f;
                kotlin.o.b(obj);
            }
            mVar.b(obj);
            return kotlin.u.a;
        }
    }

    /* compiled from: CoroutineWorker.kt */
    @DebugMetadata(c = "androidx.work.CoroutineWorker$startWork$1", f = "CoroutineWorker.kt", l = {68}, m = "invokeSuspend")
    /* loaded from: classes.dex */
    static final class c extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super kotlin.u>, Object> {

        /* renamed from: f, reason: collision with root package name */
        int f2271f;

        c(Continuation<? super c> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.j.internal.BaseContinuationImpl
        public final Continuation<kotlin.u> create(Object obj, Continuation<?> continuation) {
            return new c(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super kotlin.u> continuation) {
            return ((c) create(coroutineScope, continuation)).invokeSuspend(kotlin.u.a);
        }

        @Override // kotlin.coroutines.j.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object c2;
            c2 = kotlin.coroutines.intrinsics.d.c();
            int i2 = this.f2271f;
            try {
                if (i2 == 0) {
                    kotlin.o.b(obj);
                    CoroutineWorker coroutineWorker = CoroutineWorker.this;
                    this.f2271f = 1;
                    obj = coroutineWorker.a(this);
                    if (obj == c2) {
                        return c2;
                    }
                } else {
                    if (i2 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    kotlin.o.b(obj);
                }
                CoroutineWorker.this.g().q((ListenableWorker.a) obj);
            } catch (Throwable th) {
                CoroutineWorker.this.g().r(th);
            }
            return kotlin.u.a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CoroutineWorker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
        CompletableJob b2;
        kotlin.jvm.internal.m.f(context, "appContext");
        kotlin.jvm.internal.m.f(workerParameters, "params");
        b2 = d2.b(null, 1, null);
        this.job = b2;
        androidx.work.impl.utils.o.c<ListenableWorker.a> u = androidx.work.impl.utils.o.c.u();
        kotlin.jvm.internal.m.e(u, "create()");
        this.future = u;
        u.g(new a(), getTaskExecutor().c());
        this.coroutineContext = Dispatchers.a();
    }

    static /* synthetic */ Object f(CoroutineWorker coroutineWorker, Continuation continuation) {
        throw new IllegalStateException("Not implemented");
    }

    public abstract Object a(Continuation<? super ListenableWorker.a> continuation);

    /* renamed from: c, reason: from getter */
    public CoroutineDispatcher getCoroutineContext() {
        return this.coroutineContext;
    }

    public Object d(Continuation<? super h> continuation) {
        return f(this, continuation);
    }

    public final androidx.work.impl.utils.o.c<ListenableWorker.a> g() {
        return this.future;
    }

    @Override // androidx.work.ListenableWorker
    public final e.e.c.a.a.a<h> getForegroundInfoAsync() {
        CompletableJob b2;
        b2 = d2.b(null, 1, null);
        CoroutineScope a2 = p0.a(getCoroutineContext().plus(b2));
        m mVar = new m(b2, null, 2, null);
        kotlinx.coroutines.j.b(a2, null, null, new b(mVar, this, null), 3, null);
        return mVar;
    }

    /* renamed from: h, reason: from getter */
    public final CompletableJob getJob() {
        return this.job;
    }

    @Override // androidx.work.ListenableWorker
    public final void onStopped() {
        super.onStopped();
        this.future.cancel(false);
    }

    @Override // androidx.work.ListenableWorker
    public final e.e.c.a.a.a<ListenableWorker.a> startWork() {
        kotlinx.coroutines.j.b(p0.a(getCoroutineContext().plus(this.job)), null, null, new c(null), 3, null);
        return this.future;
    }
}
