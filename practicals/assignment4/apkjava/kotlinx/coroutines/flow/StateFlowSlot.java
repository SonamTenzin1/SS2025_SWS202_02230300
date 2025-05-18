package kotlinx.coroutines.flow;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.c;
import kotlin.coroutines.intrinsics.d;
import kotlin.coroutines.j.internal.h;
import kotlin.jvm.internal.m;
import kotlin.u;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot;
import kotlinx.coroutines.flow.internal.b;
import kotlinx.coroutines.s0;
import okhttp3.HttpUrl;

/* compiled from: StateFlow.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\b\u0002\u0018\u00002\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00030\u0013B\u0007¢\u0006\u0004\b\u0001\u0010\u0002J\u001b\u0010\u0006\u001a\u00020\u00052\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0013\u0010\t\u001a\u00020\bH\u0086@ø\u0001\u0000¢\u0006\u0004\b\t\u0010\nJ)\u0010\r\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\b\u0018\u00010\f0\u000b2\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0003H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\r\u0010\u000f\u001a\u00020\b¢\u0006\u0004\b\u000f\u0010\u0002J\r\u0010\u0010\u001a\u00020\u0005¢\u0006\u0004\b\u0010\u0010\u0011\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0012"}, d2 = {"Lkotlinx/coroutines/flow/StateFlowSlot;", "<init>", "()V", "Lkotlinx/coroutines/flow/StateFlowImpl;", "flow", HttpUrl.FRAGMENT_ENCODE_SET, "allocateLocked", "(Lkotlinx/coroutines/flow/StateFlowImpl;)Z", HttpUrl.FRAGMENT_ENCODE_SET, "awaitPending", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", HttpUrl.FRAGMENT_ENCODE_SET, "Lkotlin/coroutines/Continuation;", "freeLocked", "(Lkotlinx/coroutines/flow/StateFlowImpl;)[Lkotlin/coroutines/Continuation;", "makePending", "takePending", "()Z", "kotlinx-coroutines-core", "Lkotlinx/coroutines/flow/internal/AbstractSharedFlowSlot;"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* renamed from: kotlinx.coroutines.z2.p, reason: from Kotlin metadata */
/* loaded from: classes3.dex */
final class StateFlowSlot extends AbstractSharedFlowSlot<StateFlowImpl<?>> {
    static final /* synthetic */ AtomicReferenceFieldUpdater a = AtomicReferenceFieldUpdater.newUpdater(StateFlowSlot.class, Object.class, "_state");
    volatile /* synthetic */ Object _state = null;

    @Override // kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public boolean a(StateFlowImpl<?> stateFlowImpl) {
        if (this._state != null) {
            return false;
        }
        this._state = o.b();
        return true;
    }

    public final Object d(Continuation<? super u> continuation) {
        Continuation b2;
        Object c2;
        Object c3;
        b2 = c.b(continuation);
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(b2, 1);
        cancellableContinuationImpl.z();
        if (s0.a() && !(!(this._state instanceof CancellableContinuationImpl))) {
            throw new AssertionError();
        }
        if (!a.compareAndSet(this, o.b(), cancellableContinuationImpl)) {
            if (s0.a()) {
                if (!(this._state == o.c())) {
                    throw new AssertionError();
                }
            }
            Result.a aVar = Result.f25108f;
            cancellableContinuationImpl.resumeWith(Result.a(u.a));
        }
        Object w = cancellableContinuationImpl.w();
        c2 = d.c();
        if (w == c2) {
            h.c(continuation);
        }
        c3 = d.c();
        return w == c3 ? w : u.a;
    }

    @Override // kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public Continuation<u>[] b(StateFlowImpl<?> stateFlowImpl) {
        this._state = null;
        return b.a;
    }

    public final void f() {
        while (true) {
            Object obj = this._state;
            if (obj == null || obj == o.c()) {
                return;
            }
            if (obj == o.b()) {
                if (a.compareAndSet(this, obj, o.c())) {
                    return;
                }
            } else if (a.compareAndSet(this, obj, o.b())) {
                Result.a aVar = Result.f25108f;
                ((CancellableContinuationImpl) obj).resumeWith(Result.a(u.a));
                return;
            }
        }
    }

    public final boolean g() {
        Object andSet = a.getAndSet(this, o.b());
        m.c(andSet);
        if (!s0.a() || (!(andSet instanceof CancellableContinuationImpl))) {
            return andSet == o.c();
        }
        throw new AssertionError();
    }
}
