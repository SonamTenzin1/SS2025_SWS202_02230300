package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.j.internal.ContinuationImpl;
import kotlin.coroutines.j.internal.CoroutineStackFrame;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.m;
import kotlin.text.n;
import kotlin.u;
import kotlinx.coroutines.b2;
import kotlinx.coroutines.flow.FlowCollector;
import okhttp3.HttpUrl;

/* compiled from: SafeCollector.kt */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\u00020\u00032\u00020\u0004B\u001b\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ'\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u00072\b\u0010\u0017\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0018\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\u0019J\u0019\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00028\u0000H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u001bJ%\u0010\u001a\u001a\u0004\u0018\u00010\u001c2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0006\u0010\u0018\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\u001eJ\u001a\u0010\u001f\u001a\u00020\u00102\u0006\u0010 \u001a\u00020!2\b\u0010\u0018\u001a\u0004\u0018\u00010\u001cH\u0002J\n\u0010\"\u001a\u0004\u0018\u00010#H\u0016J \u0010$\u001a\u00020\u001c2\u000e\u0010%\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001c0&H\u0016ø\u0001\u0000¢\u0006\u0002\u0010'J\b\u0010(\u001a\u00020\u0010H\u0016R\u0016\u0010\t\u001a\u0004\u0018\u00010\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0010\u0010\u0006\u001a\u00020\u00078\u0000X\u0081\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u00020\r8\u0000X\u0081\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u00028\u0000X\u0081\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006)"}, d2 = {"Lkotlinx/coroutines/flow/internal/SafeCollector;", "T", "Lkotlinx/coroutines/flow/FlowCollector;", "Lkotlin/coroutines/jvm/internal/ContinuationImpl;", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "collector", "collectContext", "Lkotlin/coroutines/CoroutineContext;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/CoroutineContext;)V", "callerFrame", "getCallerFrame", "()Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "collectContextSize", HttpUrl.FRAGMENT_ENCODE_SET, "completion", "Lkotlin/coroutines/Continuation;", HttpUrl.FRAGMENT_ENCODE_SET, "context", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "lastEmissionContext", "checkContext", "currentContext", "previousContext", "value", "(Lkotlin/coroutines/CoroutineContext;Lkotlin/coroutines/CoroutineContext;Ljava/lang/Object;)V", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", HttpUrl.FRAGMENT_ENCODE_SET, "uCont", "(Lkotlin/coroutines/Continuation;Ljava/lang/Object;)Ljava/lang/Object;", "exceptionTransparencyViolated", "exception", "Lkotlinx/coroutines/flow/internal/DownstreamExceptionContext;", "getStackTraceElement", "Ljava/lang/StackTraceElement;", "invokeSuspend", "result", "Lkotlin/Result;", "(Ljava/lang/Object;)Ljava/lang/Object;", "releaseIntercepted", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* renamed from: kotlinx.coroutines.flow.internal.h, reason: from Kotlin metadata */
/* loaded from: classes3.dex */
public final class SafeCollector<T> extends ContinuationImpl implements FlowCollector<T>, CoroutineStackFrame {

    /* renamed from: f, reason: collision with root package name */
    public final FlowCollector<T> f25763f;

    /* renamed from: g, reason: collision with root package name */
    public final CoroutineContext f25764g;

    /* renamed from: h, reason: collision with root package name */
    public final int f25765h;

    /* renamed from: i, reason: collision with root package name */
    private CoroutineContext f25766i;

    /* renamed from: j, reason: collision with root package name */
    private Continuation<? super u> f25767j;

    /* compiled from: SafeCollector.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"<anonymous>", HttpUrl.FRAGMENT_ENCODE_SET, "T", "count", "<anonymous parameter 1>", "Lkotlin/coroutines/CoroutineContext$Element;", "invoke", "(ILkotlin/coroutines/CoroutineContext$Element;)Ljava/lang/Integer;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    /* renamed from: kotlinx.coroutines.flow.internal.h$a */
    /* loaded from: classes3.dex */
    static final class a extends Lambda implements Function2<Integer, CoroutineContext.b, Integer> {

        /* renamed from: f, reason: collision with root package name */
        public static final a f25768f = new a();

        a() {
            super(2);
        }

        public final Integer b(int i2, CoroutineContext.b bVar) {
            return Integer.valueOf(i2 + 1);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Integer invoke(Integer num, CoroutineContext.b bVar) {
            return b(num.intValue(), bVar);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SafeCollector(FlowCollector<? super T> flowCollector, CoroutineContext coroutineContext) {
        super(NoOpContinuation.f25759f, EmptyCoroutineContext.f25609f);
        this.f25763f = flowCollector;
        this.f25764g = coroutineContext;
        this.f25765h = ((Number) coroutineContext.fold(0, a.f25768f)).intValue();
    }

    private final void i(CoroutineContext coroutineContext, CoroutineContext coroutineContext2, T t) {
        if (coroutineContext2 instanceof DownstreamExceptionContext) {
            k((DownstreamExceptionContext) coroutineContext2, t);
        }
        j.a(this, coroutineContext);
    }

    private final Object j(Continuation<? super u> continuation, T t) {
        Function3 function3;
        Object c2;
        CoroutineContext l = continuation.getL();
        b2.e(l);
        CoroutineContext coroutineContext = this.f25766i;
        if (coroutineContext != l) {
            i(l, coroutineContext, t);
            this.f25766i = l;
        }
        this.f25767j = continuation;
        function3 = i.a;
        Object d2 = function3.d(this.f25763f, t, this);
        c2 = kotlin.coroutines.intrinsics.d.c();
        if (!m.a(d2, c2)) {
            this.f25767j = null;
        }
        return d2;
    }

    private final void k(DownstreamExceptionContext downstreamExceptionContext, Object obj) {
        String f2;
        f2 = n.f("\n            Flow exception transparency is violated:\n                Previous 'emit' call has thrown exception " + downstreamExceptionContext.f25757f + ", but then emission attempt of value '" + obj + "' has been detected.\n                Emissions from 'catch' blocks are prohibited in order to avoid unspecified behaviour, 'Flow.catch' operator can be used instead.\n                For a more detailed explanation, please refer to Flow documentation.\n            ");
        throw new IllegalStateException(f2.toString());
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    public Object c(T t, Continuation<? super u> continuation) {
        Object c2;
        Object c3;
        try {
            Object j2 = j(continuation, t);
            c2 = kotlin.coroutines.intrinsics.d.c();
            if (j2 == c2) {
                kotlin.coroutines.j.internal.h.c(continuation);
            }
            c3 = kotlin.coroutines.intrinsics.d.c();
            return j2 == c3 ? j2 : u.a;
        } catch (Throwable th) {
            this.f25766i = new DownstreamExceptionContext(th, continuation.getL());
            throw th;
        }
    }

    @Override // kotlin.coroutines.j.internal.BaseContinuationImpl, kotlin.coroutines.j.internal.CoroutineStackFrame
    public CoroutineStackFrame getCallerFrame() {
        Continuation<? super u> continuation = this.f25767j;
        if (continuation instanceof CoroutineStackFrame) {
            return (CoroutineStackFrame) continuation;
        }
        return null;
    }

    @Override // kotlin.coroutines.j.internal.ContinuationImpl, kotlin.coroutines.Continuation
    /* renamed from: getContext */
    public CoroutineContext getL() {
        CoroutineContext coroutineContext = this.f25766i;
        return coroutineContext == null ? EmptyCoroutineContext.f25609f : coroutineContext;
    }

    @Override // kotlin.coroutines.j.internal.BaseContinuationImpl, kotlin.coroutines.j.internal.CoroutineStackFrame
    public StackTraceElement getStackTraceElement() {
        return null;
    }

    @Override // kotlin.coroutines.j.internal.BaseContinuationImpl
    public Object invokeSuspend(Object result) {
        Object c2;
        Throwable b2 = Result.b(result);
        if (b2 != null) {
            this.f25766i = new DownstreamExceptionContext(b2, getL());
        }
        Continuation<? super u> continuation = this.f25767j;
        if (continuation != null) {
            continuation.resumeWith(result);
        }
        c2 = kotlin.coroutines.intrinsics.d.c();
        return c2;
    }

    @Override // kotlin.coroutines.j.internal.ContinuationImpl, kotlin.coroutines.j.internal.BaseContinuationImpl
    public void releaseIntercepted() {
        super.releaseIntercepted();
    }
}
