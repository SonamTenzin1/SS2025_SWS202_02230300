package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.d;
import kotlin.coroutines.j.internal.ContinuationImpl;
import kotlin.coroutines.j.internal.DebugMetadata;
import kotlin.jvm.functions.Function2;
import kotlin.o;
import kotlin.u;
import kotlinx.coroutines.flow.internal.SafeCollector;
import okhttp3.HttpUrl;

/* compiled from: Share.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002BE\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012-\u0010\u0004\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0005¢\u0006\u0002\b\tø\u0001\u0000¢\u0006\u0002\u0010\nJ\u0019\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00028\u0000H\u0096Aø\u0001\u0000¢\u0006\u0002\u0010\u000eJ\u0011\u0010\u000f\u001a\u00020\u0007H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0010R:\u0010\u0004\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0005¢\u0006\u0002\b\tX\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u000bR\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0011"}, d2 = {"Lkotlinx/coroutines/flow/SubscribedFlowCollector;", "T", "Lkotlinx/coroutines/flow/FlowCollector;", "collector", "action", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", HttpUrl.FRAGMENT_ENCODE_SET, HttpUrl.FRAGMENT_ENCODE_SET, "Lkotlin/ExtensionFunctionType;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/jvm/functions/Function2;)V", "Lkotlin/jvm/functions/Function2;", "emit", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onSubscription", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* renamed from: kotlinx.coroutines.z2.q, reason: from Kotlin metadata */
/* loaded from: classes3.dex */
public final class SubscribedFlowCollector<T> implements FlowCollector<T> {

    /* renamed from: f, reason: collision with root package name */
    private final FlowCollector<T> f25939f;

    /* renamed from: g, reason: collision with root package name */
    private final Function2<FlowCollector<? super T>, Continuation<? super u>, Object> f25940g;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Share.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "kotlinx.coroutines.flow.SubscribedFlowCollector", f = "Share.kt", l = {419, 423}, m = "onSubscription")
    /* renamed from: kotlinx.coroutines.z2.q$a */
    /* loaded from: classes3.dex */
    public static final class a extends ContinuationImpl {

        /* renamed from: f, reason: collision with root package name */
        Object f25941f;

        /* renamed from: g, reason: collision with root package name */
        Object f25942g;

        /* renamed from: h, reason: collision with root package name */
        /* synthetic */ Object f25943h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ SubscribedFlowCollector<T> f25944i;

        /* renamed from: j, reason: collision with root package name */
        int f25945j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(SubscribedFlowCollector<T> subscribedFlowCollector, Continuation<? super a> continuation) {
            super(continuation);
            this.f25944i = subscribedFlowCollector;
        }

        @Override // kotlin.coroutines.j.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f25943h = obj;
            this.f25945j |= Integer.MIN_VALUE;
            return this.f25944i.a(this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0024  */
    /* JADX WARN: Type inference failed for: r2v0, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1, types: [kotlinx.coroutines.flow.internal.h] */
    /* JADX WARN: Type inference failed for: r2v4, types: [boolean] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object a(Continuation<? super u> continuation) {
        a aVar;
        Object c2;
        ?? r2;
        SafeCollector safeCollector;
        SubscribedFlowCollector<T> subscribedFlowCollector;
        try {
            if (continuation instanceof a) {
                aVar = (a) continuation;
                int i2 = aVar.f25945j;
                if ((i2 & Integer.MIN_VALUE) != 0) {
                    aVar.f25945j = i2 - Integer.MIN_VALUE;
                    Object obj = aVar.f25943h;
                    c2 = d.c();
                    r2 = aVar.f25945j;
                    if (r2 != 0) {
                        o.b(obj);
                        safeCollector = new SafeCollector(this.f25939f, aVar.getL());
                        Function2<FlowCollector<? super T>, Continuation<? super u>, Object> function2 = this.f25940g;
                        aVar.f25941f = this;
                        aVar.f25942g = safeCollector;
                        aVar.f25945j = 1;
                        if (function2.invoke(safeCollector, aVar) == c2) {
                            return c2;
                        }
                        subscribedFlowCollector = this;
                    } else {
                        if (r2 != 1) {
                            if (r2 != 2) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            o.b(obj);
                            return u.a;
                        }
                        safeCollector = (SafeCollector) aVar.f25942g;
                        subscribedFlowCollector = (SubscribedFlowCollector) aVar.f25941f;
                        o.b(obj);
                    }
                    safeCollector.releaseIntercepted();
                    FlowCollector<T> flowCollector = subscribedFlowCollector.f25939f;
                    r2 = flowCollector instanceof SubscribedFlowCollector;
                    if (r2 != 0) {
                        return u.a;
                    }
                    aVar.f25941f = null;
                    aVar.f25942g = null;
                    aVar.f25945j = 2;
                    if (((SubscribedFlowCollector) flowCollector).a(aVar) == c2) {
                        return c2;
                    }
                    return u.a;
                }
            }
            if (r2 != 0) {
            }
            safeCollector.releaseIntercepted();
            FlowCollector<T> flowCollector2 = subscribedFlowCollector.f25939f;
            r2 = flowCollector2 instanceof SubscribedFlowCollector;
            if (r2 != 0) {
            }
        } catch (Throwable th) {
            r2.releaseIntercepted();
            throw th;
        }
        aVar = new a(this, continuation);
        Object obj2 = aVar.f25943h;
        c2 = d.c();
        r2 = aVar.f25945j;
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    public Object c(T t, Continuation<? super u> continuation) {
        return this.f25939f.c(t, continuation);
    }
}
