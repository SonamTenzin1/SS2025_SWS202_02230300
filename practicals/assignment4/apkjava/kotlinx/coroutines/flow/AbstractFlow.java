package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.d;
import kotlin.coroutines.j.internal.ContinuationImpl;
import kotlin.coroutines.j.internal.DebugMetadata;
import kotlin.o;
import kotlin.u;
import kotlinx.coroutines.flow.internal.SafeCollector;
import okhttp3.HttpUrl;

/* compiled from: Flow.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b'\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u0005¢\u0006\u0002\u0010\u0004J\u001f\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\bH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\tJ\u001f\u0010\n\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\bH¦@ø\u0001\u0000¢\u0006\u0002\u0010\t\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u000b"}, d2 = {"Lkotlinx/coroutines/flow/AbstractFlow;", "T", "Lkotlinx/coroutines/flow/Flow;", "Lkotlinx/coroutines/flow/CancellableFlow;", "()V", "collect", HttpUrl.FRAGMENT_ENCODE_SET, "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "collectSafely", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* renamed from: kotlinx.coroutines.z2.a, reason: from Kotlin metadata */
/* loaded from: classes3.dex */
public abstract class AbstractFlow<T> implements Flow<T> {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Flow.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "kotlinx.coroutines.flow.AbstractFlow", f = "Flow.kt", l = {230}, m = "collect")
    /* renamed from: kotlinx.coroutines.z2.a$a */
    /* loaded from: classes3.dex */
    public static final class a extends ContinuationImpl {

        /* renamed from: f, reason: collision with root package name */
        Object f25895f;

        /* renamed from: g, reason: collision with root package name */
        /* synthetic */ Object f25896g;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ AbstractFlow<T> f25897h;

        /* renamed from: i, reason: collision with root package name */
        int f25898i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(AbstractFlow<T> abstractFlow, Continuation<? super a> continuation) {
            super(continuation);
            this.f25897h = abstractFlow;
        }

        @Override // kotlin.coroutines.j.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f25896g = obj;
            this.f25898i |= Integer.MIN_VALUE;
            return this.f25897h.a(null, this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @Override // kotlinx.coroutines.flow.Flow
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object a(FlowCollector<? super T> flowCollector, Continuation<? super u> continuation) {
        a aVar;
        Object c2;
        int i2;
        Throwable th;
        SafeCollector safeCollector;
        if (continuation instanceof a) {
            aVar = (a) continuation;
            int i3 = aVar.f25898i;
            if ((i3 & Integer.MIN_VALUE) != 0) {
                aVar.f25898i = i3 - Integer.MIN_VALUE;
                Object obj = aVar.f25896g;
                c2 = d.c();
                i2 = aVar.f25898i;
                if (i2 != 0) {
                    o.b(obj);
                    SafeCollector safeCollector2 = new SafeCollector(flowCollector, aVar.getL());
                    try {
                        aVar.f25895f = safeCollector2;
                        aVar.f25898i = 1;
                        if (b(safeCollector2, aVar) == c2) {
                            return c2;
                        }
                        safeCollector = safeCollector2;
                    } catch (Throwable th2) {
                        th = th2;
                        safeCollector = safeCollector2;
                        safeCollector.releaseIntercepted();
                        throw th;
                    }
                } else {
                    if (i2 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    safeCollector = (SafeCollector) aVar.f25895f;
                    try {
                        o.b(obj);
                    } catch (Throwable th3) {
                        th = th3;
                        safeCollector.releaseIntercepted();
                        throw th;
                    }
                }
                safeCollector.releaseIntercepted();
                return u.a;
            }
        }
        aVar = new a(this, continuation);
        Object obj2 = aVar.f25896g;
        c2 = d.c();
        i2 = aVar.f25898i;
        if (i2 != 0) {
        }
        safeCollector.releaseIntercepted();
        return u.a;
    }

    public abstract Object b(FlowCollector<? super T> flowCollector, Continuation<? super u> continuation);
}
