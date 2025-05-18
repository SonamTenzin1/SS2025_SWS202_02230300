package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.internal.DispatchedContinuation;
import okhttp3.HttpUrl;

/* compiled from: DispatchedTask.kt */
@Metadata(d1 = {"\u0000<\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a \u0010\f\u001a\u00020\r\"\u0004\b\u0000\u0010\u000e*\b\u0012\u0004\u0012\u0002H\u000e0\u000f2\u0006\u0010\u0010\u001a\u00020\u0001H\u0000\u001a.\u0010\u0011\u001a\u00020\r\"\u0004\b\u0000\u0010\u000e*\b\u0012\u0004\u0012\u0002H\u000e0\u000f2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u000e0\u00132\u0006\u0010\u0014\u001a\u00020\tH\u0000\u001a\u0010\u0010\u0015\u001a\u00020\r*\u0006\u0012\u0002\b\u00030\u000fH\u0002\u001a\u0019\u0010\u0016\u001a\u00020\r*\u0006\u0012\u0002\b\u00030\u00132\u0006\u0010\u0017\u001a\u00020\u0018H\u0080\b\u001a'\u0010\u0019\u001a\u00020\r*\u0006\u0012\u0002\b\u00030\u000f2\u0006\u0010\u001a\u001a\u00020\u001b2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\r0\u001dH\u0080\b\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u0016\u0010\u0002\u001a\u00020\u00018\u0000X\u0081T¢\u0006\b\n\u0000\u0012\u0004\b\u0003\u0010\u0004\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u0018\u0010\b\u001a\u00020\t*\u00020\u00018@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\n\"\u0018\u0010\u000b\u001a\u00020\t*\u00020\u00018@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\n¨\u0006\u001e"}, d2 = {"MODE_ATOMIC", HttpUrl.FRAGMENT_ENCODE_SET, "MODE_CANCELLABLE", "getMODE_CANCELLABLE$annotations", "()V", "MODE_CANCELLABLE_REUSABLE", "MODE_UNDISPATCHED", "MODE_UNINITIALIZED", "isCancellableMode", HttpUrl.FRAGMENT_ENCODE_SET, "(I)Z", "isReusableMode", "dispatch", HttpUrl.FRAGMENT_ENCODE_SET, "T", "Lkotlinx/coroutines/DispatchedTask;", "mode", "resume", "delegate", "Lkotlin/coroutines/Continuation;", "undispatched", "resumeUnconfined", "resumeWithStackTrace", "exception", HttpUrl.FRAGMENT_ENCODE_SET, "runUnconfinedEventLoop", "eventLoop", "Lkotlinx/coroutines/EventLoop;", "block", "Lkotlin/Function0;", "kotlinx-coroutines-core"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class c1 {
    public static final <T> void a(DispatchedTask<? super T> dispatchedTask, int i2) {
        if (s0.a()) {
            if (!(i2 != -1)) {
                throw new AssertionError();
            }
        }
        Continuation<? super T> c2 = dispatchedTask.c();
        boolean z = i2 == 4;
        if (!z && (c2 instanceof DispatchedContinuation) && b(i2) == b(dispatchedTask.f25647h)) {
            CoroutineDispatcher coroutineDispatcher = ((DispatchedContinuation) c2).f25797j;
            CoroutineContext l = c2.getL();
            if (coroutineDispatcher.N(l)) {
                coroutineDispatcher.K(l, dispatchedTask);
                return;
            } else {
                e(dispatchedTask);
                return;
            }
        }
        d(dispatchedTask, c2, z);
    }

    public static final boolean b(int i2) {
        return i2 == 1 || i2 == 2;
    }

    public static final boolean c(int i2) {
        return i2 == 2;
    }

    public static final <T> void d(DispatchedTask<? super T> dispatchedTask, Continuation<? super T> continuation, boolean z) {
        Object f2;
        boolean H0;
        Object j2 = dispatchedTask.j();
        Throwable d2 = dispatchedTask.d(j2);
        if (d2 != null) {
            Result.a aVar = Result.f25108f;
            f2 = kotlin.o.a(d2);
        } else {
            Result.a aVar2 = Result.f25108f;
            f2 = dispatchedTask.f(j2);
        }
        Object a = Result.a(f2);
        if (z) {
            DispatchedContinuation dispatchedContinuation = (DispatchedContinuation) continuation;
            Continuation<T> continuation2 = dispatchedContinuation.f25798k;
            Object obj = dispatchedContinuation.m;
            CoroutineContext l = continuation2.getL();
            Object c2 = kotlinx.coroutines.internal.i0.c(l, obj);
            UndispatchedCoroutine<?> g2 = c2 != kotlinx.coroutines.internal.i0.a ? h0.g(continuation2, l, c2) : null;
            try {
                dispatchedContinuation.f25798k.resumeWith(a);
                kotlin.u uVar = kotlin.u.a;
                if (g2 != null) {
                    if (!H0) {
                        return;
                    }
                }
                return;
            } finally {
                if (g2 == null || g2.H0()) {
                    kotlinx.coroutines.internal.i0.a(l, c2);
                }
            }
        }
        continuation.resumeWith(a);
    }

    private static final void e(DispatchedTask<?> dispatchedTask) {
        EventLoop b2 = ThreadLocalEventLoop.a.b();
        if (b2.i0()) {
            b2.Z(dispatchedTask);
            return;
        }
        b2.e0(true);
        try {
            d(dispatchedTask, dispatchedTask.c(), true);
            do {
            } while (b2.p0());
        } finally {
            try {
            } finally {
            }
        }
    }
}
