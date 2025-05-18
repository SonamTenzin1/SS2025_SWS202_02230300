package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.j.internal.CoroutineStackFrame;
import kotlinx.coroutines.internal.DispatchedContinuation;
import kotlinx.coroutines.scheduling.Task;
import kotlinx.coroutines.scheduling.TaskContext;
import okhttp3.HttpUrl;

/* compiled from: DispatchedTask.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u000e\b \u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\u00060\u0002j\u0002`\u0003B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u001f\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0010¢\u0006\u0002\b\u0011J\u0019\u0010\u0012\u001a\u0004\u0018\u00010\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u000eH\u0010¢\u0006\u0002\b\u0014J\u001f\u0010\u0015\u001a\u0002H\u0001\"\u0004\b\u0001\u0010\u00012\b\u0010\u0013\u001a\u0004\u0018\u00010\u000eH\u0010¢\u0006\u0004\b\u0016\u0010\u0017J\u001a\u0010\u0018\u001a\u00020\f2\b\u0010\u0019\u001a\u0004\u0018\u00010\u00102\b\u0010\u001a\u001a\u0004\u0018\u00010\u0010J\u0006\u0010\u001b\u001a\u00020\fJ\u000f\u0010\u001c\u001a\u0004\u0018\u00010\u000eH ¢\u0006\u0002\b\u001dR\u0018\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\bX \u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0012\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lkotlinx/coroutines/DispatchedTask;", "T", "Lkotlinx/coroutines/scheduling/Task;", "Lkotlinx/coroutines/SchedulerTask;", "resumeMode", HttpUrl.FRAGMENT_ENCODE_SET, "(I)V", "delegate", "Lkotlin/coroutines/Continuation;", "getDelegate$kotlinx_coroutines_core", "()Lkotlin/coroutines/Continuation;", "cancelCompletedResult", HttpUrl.FRAGMENT_ENCODE_SET, "takenState", HttpUrl.FRAGMENT_ENCODE_SET, "cause", HttpUrl.FRAGMENT_ENCODE_SET, "cancelCompletedResult$kotlinx_coroutines_core", "getExceptionalResult", "state", "getExceptionalResult$kotlinx_coroutines_core", "getSuccessfulResult", "getSuccessfulResult$kotlinx_coroutines_core", "(Ljava/lang/Object;)Ljava/lang/Object;", "handleFatalException", "exception", "finallyException", "run", "takeState", "takeState$kotlinx_coroutines_core", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* renamed from: kotlinx.coroutines.b1, reason: from Kotlin metadata */
/* loaded from: classes3.dex */
public abstract class DispatchedTask<T> extends Task {

    /* renamed from: h, reason: collision with root package name */
    public int f25647h;

    public DispatchedTask(int i2) {
        this.f25647h = i2;
    }

    public void a(Object obj, Throwable th) {
    }

    public abstract Continuation<T> c();

    public Throwable d(Object obj) {
        CompletedExceptionally completedExceptionally = obj instanceof CompletedExceptionally ? (CompletedExceptionally) obj : null;
        if (completedExceptionally != null) {
            return completedExceptionally.f25646b;
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T> T f(Object obj) {
        return obj;
    }

    public final void i(Throwable th, Throwable th2) {
        if (th == null && th2 == null) {
            return;
        }
        if (th != null && th2 != null) {
            kotlin.b.a(th, th2);
        }
        if (th == null) {
            th = th2;
        }
        kotlin.jvm.internal.m.c(th);
        l0.a(c().getL(), new CoroutinesInternalError("Fatal exception in coroutines machinery for " + this + ". Please read KDoc to 'handleFatalException' method and report this incident to maintainers", th));
    }

    public abstract Object j();

    @Override // java.lang.Runnable
    public final void run() {
        Object a;
        Object a2;
        if (s0.a()) {
            if (!(this.f25647h != -1)) {
                throw new AssertionError();
            }
        }
        TaskContext taskContext = this.f25680g;
        try {
            DispatchedContinuation dispatchedContinuation = (DispatchedContinuation) c();
            Continuation<T> continuation = dispatchedContinuation.f25798k;
            Object obj = dispatchedContinuation.m;
            CoroutineContext l = continuation.getL();
            Object c2 = kotlinx.coroutines.internal.i0.c(l, obj);
            UndispatchedCoroutine<?> g2 = c2 != kotlinx.coroutines.internal.i0.a ? h0.g(continuation, l, c2) : null;
            try {
                CoroutineContext l2 = continuation.getL();
                Object j2 = j();
                Throwable d2 = d(j2);
                Job job = (d2 == null && c1.b(this.f25647h)) ? (Job) l2.get(Job.f25890e) : null;
                if (job != null && !job.b()) {
                    Throwable j3 = job.j();
                    a(j2, j3);
                    Result.a aVar = Result.f25108f;
                    if (s0.d() && (continuation instanceof CoroutineStackFrame)) {
                        j3 = kotlinx.coroutines.internal.d0.a(j3, (CoroutineStackFrame) continuation);
                    }
                    continuation.resumeWith(Result.a(kotlin.o.a(j3)));
                } else if (d2 != null) {
                    Result.a aVar2 = Result.f25108f;
                    continuation.resumeWith(Result.a(kotlin.o.a(d2)));
                } else {
                    Result.a aVar3 = Result.f25108f;
                    continuation.resumeWith(Result.a(f(j2)));
                }
                kotlin.u uVar = kotlin.u.a;
                try {
                    Result.a aVar4 = Result.f25108f;
                    taskContext.a();
                    a2 = Result.a(uVar);
                } catch (Throwable th) {
                    Result.a aVar5 = Result.f25108f;
                    a2 = Result.a(kotlin.o.a(th));
                }
                i(null, Result.b(a2));
            } finally {
                if (g2 == null || g2.H0()) {
                    kotlinx.coroutines.internal.i0.a(l, c2);
                }
            }
        } catch (Throwable th2) {
            try {
                Result.a aVar6 = Result.f25108f;
                taskContext.a();
                a = Result.a(kotlin.u.a);
            } catch (Throwable th3) {
                Result.a aVar7 = Result.f25108f;
                a = Result.a(kotlin.o.a(th3));
            }
            i(th2, Result.b(a));
        }
    }
}
