package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.j.internal.CoroutineStackFrame;
import kotlin.jvm.functions.Function1;
import okhttp3.HttpUrl;

/* compiled from: CompletionState.kt */
@Metadata(d1 = {"\u00008\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a4\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0006H\u0000ø\u0001\u0000¢\u0006\u0002\u0010\u0007\u001aI\u0010\b\u001a\u0004\u0018\u00010\u0004\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012%\b\u0002\u0010\t\u001a\u001f\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000f\u0018\u00010\nH\u0000ø\u0001\u0000¢\u0006\u0002\u0010\u0010\u001a.\u0010\b\u001a\u0004\u0018\u00010\u0004\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\n\u0010\u0011\u001a\u0006\u0012\u0002\b\u00030\u0012H\u0000ø\u0001\u0000¢\u0006\u0002\u0010\u0013\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0014"}, d2 = {"recoverResult", "Lkotlin/Result;", "T", "state", HttpUrl.FRAGMENT_ENCODE_SET, "uCont", "Lkotlin/coroutines/Continuation;", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toState", "onCancellation", "Lkotlin/Function1;", HttpUrl.FRAGMENT_ENCODE_SET, "Lkotlin/ParameterName;", "name", "cause", HttpUrl.FRAGMENT_ENCODE_SET, "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "caller", "Lkotlinx/coroutines/CancellableContinuation;", "(Ljava/lang/Object;Lkotlinx/coroutines/CancellableContinuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class e0 {
    public static final <T> Object a(Object obj, Continuation<? super T> continuation) {
        if (obj instanceof CompletedExceptionally) {
            Result.a aVar = Result.f25108f;
            Throwable th = ((CompletedExceptionally) obj).f25646b;
            if (s0.d() && (continuation instanceof CoroutineStackFrame)) {
                th = kotlinx.coroutines.internal.d0.j(th, (CoroutineStackFrame) continuation);
            }
            return Result.a(kotlin.o.a(th));
        }
        Result.a aVar2 = Result.f25108f;
        return Result.a(obj);
    }

    public static final <T> Object b(Object obj, Function1<? super Throwable, kotlin.u> function1) {
        Throwable b2 = Result.b(obj);
        if (b2 == null) {
            return function1 != null ? new CompletedWithCancellation(obj, function1) : obj;
        }
        return new CompletedExceptionally(b2, false, 2, null);
    }

    public static final <T> Object c(Object obj, CancellableContinuation<?> cancellableContinuation) {
        Throwable b2 = Result.b(obj);
        if (b2 != null) {
            if (s0.d() && (cancellableContinuation instanceof CoroutineStackFrame)) {
                b2 = kotlinx.coroutines.internal.d0.j(b2, (CoroutineStackFrame) cancellableContinuation);
            }
            obj = new CompletedExceptionally(b2, false, 2, null);
        }
        return obj;
    }

    public static /* synthetic */ Object d(Object obj, Function1 function1, int i2, Object obj2) {
        if ((i2 & 1) != 0) {
            function1 = null;
        }
        return b(obj, function1);
    }
}
