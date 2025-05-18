package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.d;
import kotlin.coroutines.j.internal.ContinuationImpl;
import kotlin.coroutines.j.internal.DebugMetadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.c0;
import kotlin.o;
import kotlin.u;
import okhttp3.HttpUrl;

/* compiled from: Limit.kt */
@Metadata(d1 = {"\u0000F\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aV\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u000323\b\u0004\u0010\u0004\u001a-\b\u0001\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0005H\u0080Hø\u0001\u0000¢\u0006\u0002\u0010\f\u001a$\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0003\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000f\u001aH\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0003\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\"\u0010\u0004\u001a\u001e\b\u0001\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0005ø\u0001\u0000¢\u0006\u0002\u0010\u0011\u001a+\u0010\u0012\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00132\u0006\u0010\b\u001a\u0002H\u0002H\u0082@ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015\u001a$\u0010\u0016\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0003\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000f\u001aH\u0010\u0017\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0003\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\"\u0010\u0004\u001a\u001e\b\u0001\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0005ø\u0001\u0000¢\u0006\u0002\u0010\u0011\u001ap\u0010\u0018\u001a\b\u0012\u0004\u0012\u0002H\u00190\u0003\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0019*\b\u0012\u0004\u0012\u0002H\u00020\u00032D\b\u0001\u0010\u001a\u001a>\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00190\u0013\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u001b¢\u0006\u0002\b\u001cø\u0001\u0000¢\u0006\u0002\u0010\u001d\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001e"}, d2 = {"collectWhile", HttpUrl.FRAGMENT_ENCODE_SET, "T", "Lkotlinx/coroutines/flow/Flow;", "predicate", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "value", "Lkotlin/coroutines/Continuation;", HttpUrl.FRAGMENT_ENCODE_SET, HttpUrl.FRAGMENT_ENCODE_SET, "(Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "drop", "count", HttpUrl.FRAGMENT_ENCODE_SET, "dropWhile", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/flow/Flow;", "emitAbort", "Lkotlinx/coroutines/flow/FlowCollector;", "emitAbort$FlowKt__LimitKt", "(Lkotlinx/coroutines/flow/FlowCollector;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "take", "takeWhile", "transformWhile", "R", "transform", "Lkotlin/Function3;", "Lkotlin/ExtensionFunctionType;", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function3;)Lkotlinx/coroutines/flow/Flow;", "kotlinx-coroutines-core"}, k = 5, mv = {1, 6, 0}, xi = 48, xs = "kotlinx/coroutines/flow/FlowKt")
/* loaded from: classes3.dex */
final /* synthetic */ class i {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: SafeCollector.common.kt */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001f\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007¸\u0006\u0000"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", HttpUrl.FRAGMENT_ENCODE_SET, "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class a<T> implements Flow<T> {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ Flow f25915f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ Function2 f25916g;

        public a(Flow flow, Function2 function2) {
            this.f25915f = flow;
            this.f25916g = function2;
        }

        @Override // kotlinx.coroutines.flow.Flow
        public Object a(FlowCollector<? super T> flowCollector, Continuation<? super u> continuation) {
            Object c2;
            Object a = this.f25915f.a(new b(new c0(), flowCollector, this.f25916g), continuation);
            c2 = d.c();
            return a == c2 ? a : u.a;
        }
    }

    /* compiled from: Limit.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", HttpUrl.FRAGMENT_ENCODE_SET, "T", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes3.dex */
    static final class b<T> implements FlowCollector {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ c0 f25917f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ FlowCollector<T> f25918g;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ Function2<T, Continuation<? super Boolean>, Object> f25919h;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: Limit.kt */
        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__LimitKt$dropWhile$1$1", f = "Limit.kt", l = {37, 38, 40}, m = "emit")
        /* loaded from: classes3.dex */
        public static final class a extends ContinuationImpl {

            /* renamed from: f, reason: collision with root package name */
            Object f25920f;

            /* renamed from: g, reason: collision with root package name */
            Object f25921g;

            /* renamed from: h, reason: collision with root package name */
            /* synthetic */ Object f25922h;

            /* renamed from: i, reason: collision with root package name */
            final /* synthetic */ b<T> f25923i;

            /* renamed from: j, reason: collision with root package name */
            int f25924j;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            a(b<? super T> bVar, Continuation<? super a> continuation) {
                super(continuation);
                this.f25923i = bVar;
            }

            @Override // kotlin.coroutines.j.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                this.f25922h = obj;
                this.f25924j |= Integer.MIN_VALUE;
                return this.f25923i.c(null, this);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        b(c0 c0Var, FlowCollector<? super T> flowCollector, Function2<? super T, ? super Continuation<? super Boolean>, ? extends Object> function2) {
            this.f25917f = c0Var;
            this.f25918g = flowCollector;
            this.f25919h = function2;
        }

        /* JADX WARN: Removed duplicated region for block: B:20:0x0074  */
        /* JADX WARN: Removed duplicated region for block: B:23:0x008b  */
        /* JADX WARN: Removed duplicated region for block: B:28:0x0045  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
        @Override // kotlinx.coroutines.flow.FlowCollector
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object c(T t, Continuation<? super u> continuation) {
            a aVar;
            Object c2;
            int i2;
            b<T> bVar;
            if (continuation instanceof a) {
                aVar = (a) continuation;
                int i3 = aVar.f25924j;
                if ((i3 & Integer.MIN_VALUE) != 0) {
                    aVar.f25924j = i3 - Integer.MIN_VALUE;
                    Object obj = aVar.f25922h;
                    c2 = d.c();
                    i2 = aVar.f25924j;
                    if (i2 != 0) {
                        o.b(obj);
                        if (this.f25917f.f22934f) {
                            FlowCollector<T> flowCollector = this.f25918g;
                            aVar.f25924j = 1;
                            if (flowCollector.c(t, aVar) == c2) {
                                return c2;
                            }
                            return u.a;
                        }
                        Function2<T, Continuation<? super Boolean>, Object> function2 = this.f25919h;
                        aVar.f25920f = this;
                        aVar.f25921g = t;
                        aVar.f25924j = 2;
                        obj = function2.invoke(t, aVar);
                        if (obj == c2) {
                            return c2;
                        }
                        bVar = this;
                        if (!((Boolean) obj).booleanValue()) {
                        }
                    } else {
                        if (i2 == 1) {
                            o.b(obj);
                            return u.a;
                        }
                        if (i2 == 2) {
                            t = (T) aVar.f25921g;
                            bVar = (b) aVar.f25920f;
                            o.b(obj);
                            if (!((Boolean) obj).booleanValue()) {
                                return u.a;
                            }
                            bVar.f25917f.f22934f = true;
                            FlowCollector<T> flowCollector2 = bVar.f25918g;
                            aVar.f25920f = null;
                            aVar.f25921g = null;
                            aVar.f25924j = 3;
                            if (flowCollector2.c(t, aVar) == c2) {
                                return c2;
                            }
                        } else {
                            if (i2 != 3) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            o.b(obj);
                        }
                    }
                    return u.a;
                }
            }
            aVar = new a(this, continuation);
            Object obj2 = aVar.f25922h;
            c2 = d.c();
            i2 = aVar.f25924j;
            if (i2 != 0) {
            }
            return u.a;
        }
    }

    public static final <T> Flow<T> a(Flow<? extends T> flow, Function2<? super T, ? super Continuation<? super Boolean>, ? extends Object> function2) {
        return new a(flow, function2);
    }
}
