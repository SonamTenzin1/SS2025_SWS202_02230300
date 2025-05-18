package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import okhttp3.HttpUrl;

/* compiled from: Delay.kt */
@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u0011\u0010\u0005\u001a\u00020\u0006H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0007\u001a\u0019\u0010\u0000\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u000b\u001a!\u0010\u0000\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\rH\u0086@ø\u0001\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000e\u0010\u000b\u001a\u0019\u0010\u000f\u001a\u00020\n*\u00020\rH\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0010\u0010\u0011\"\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006\u0012"}, d2 = {"delay", "Lkotlinx/coroutines/Delay;", "Lkotlin/coroutines/CoroutineContext;", "getDelay", "(Lkotlin/coroutines/CoroutineContext;)Lkotlinx/coroutines/Delay;", "awaitCancellation", HttpUrl.FRAGMENT_ENCODE_SET, "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", HttpUrl.FRAGMENT_ENCODE_SET, "timeMillis", HttpUrl.FRAGMENT_ENCODE_SET, "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "duration", "Lkotlin/time/Duration;", "delay-VtjQ1oo", "toDelayMillis", "toDelayMillis-LRDsOJo", "(J)J", "kotlinx-coroutines-core"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class y0 {
    public static final Object a(long j2, Continuation<? super kotlin.u> continuation) {
        Continuation b2;
        Object c2;
        Object c3;
        if (j2 <= 0) {
            return kotlin.u.a;
        }
        b2 = kotlin.coroutines.intrinsics.c.b(continuation);
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(b2, 1);
        cancellableContinuationImpl.z();
        if (j2 < Long.MAX_VALUE) {
            b(cancellableContinuationImpl.getL()).e(j2, cancellableContinuationImpl);
        }
        Object w = cancellableContinuationImpl.w();
        c2 = kotlin.coroutines.intrinsics.d.c();
        if (w == c2) {
            kotlin.coroutines.j.internal.h.c(continuation);
        }
        c3 = kotlin.coroutines.intrinsics.d.c();
        return w == c3 ? w : kotlin.u.a;
    }

    public static final Delay b(CoroutineContext coroutineContext) {
        CoroutineContext.b bVar = coroutineContext.get(ContinuationInterceptor.f25606b);
        Delay delay = bVar instanceof Delay ? (Delay) bVar : null;
        return delay == null ? v0.a() : delay;
    }
}
