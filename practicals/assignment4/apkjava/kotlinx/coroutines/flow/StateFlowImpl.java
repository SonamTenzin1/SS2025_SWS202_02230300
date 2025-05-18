package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.d;
import kotlin.coroutines.j.internal.ContinuationImpl;
import kotlin.coroutines.j.internal.DebugMetadata;
import kotlin.jvm.internal.m;
import kotlin.o;
import kotlin.u;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.b2;
import kotlinx.coroutines.flow.internal.AbstractSharedFlow;
import kotlinx.coroutines.flow.internal.g;
import kotlinx.coroutines.internal.Symbol;
import okhttp3.HttpUrl;

/* compiled from: StateFlow.kt */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0001\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010 \n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00020\u0010062\b\u0012\u0004\u0012\u00028\u0000072\b\u0012\u0004\u0012\u00028\u0000082\b\u0012\u0004\u0012\u00028\u000009B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J!\u0010\t\u001a\u00020\b2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0096@ø\u0001\u0000¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00028\u00002\u0006\u0010\f\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0014¢\u0006\u0004\b\u0011\u0010\u0012J\u001f\u0010\u0016\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u00152\u0006\u0010\u0014\u001a\u00020\u0013H\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\u001b\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0018\u001a\u00028\u0000H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001bJ-\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000!2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u00132\u0006\u0010 \u001a\u00020\u001fH\u0016¢\u0006\u0004\b\"\u0010#J\u000f\u0010$\u001a\u00020\u0019H\u0016¢\u0006\u0004\b$\u0010%J\u0017\u0010&\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00028\u0000H\u0016¢\u0006\u0004\b&\u0010'J!\u0010*\u001a\u00020\r2\b\u0010(\u001a\u0004\u0018\u00010\u00022\u0006\u0010)\u001a\u00020\u0002H\u0002¢\u0006\u0004\b*\u0010\u000fR\u001a\u0010.\u001a\b\u0012\u0004\u0012\u00028\u00000+8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b,\u0010-R\u0016\u0010/\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u00100R*\u0010\u0018\u001a\u00028\u00002\u0006\u0010\u0018\u001a\u00028\u00008V@VX\u0096\u000e¢\u0006\u0012\u0012\u0004\b4\u0010%\u001a\u0004\b1\u00102\"\u0004\b3\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019¨\u00065"}, d2 = {"Lkotlinx/coroutines/flow/StateFlowImpl;", "T", HttpUrl.FRAGMENT_ENCODE_SET, "initialState", "<init>", "(Ljava/lang/Object;)V", "Lkotlinx/coroutines/flow/FlowCollector;", "collector", HttpUrl.FRAGMENT_ENCODE_SET, "collect", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "expect", "update", HttpUrl.FRAGMENT_ENCODE_SET, "compareAndSet", "(Ljava/lang/Object;Ljava/lang/Object;)Z", "Lkotlinx/coroutines/flow/StateFlowSlot;", "createSlot", "()Lkotlinx/coroutines/flow/StateFlowSlot;", HttpUrl.FRAGMENT_ENCODE_SET, "size", HttpUrl.FRAGMENT_ENCODE_SET, "createSlotArray", "(I)[Lkotlinx/coroutines/flow/StateFlowSlot;", "value", HttpUrl.FRAGMENT_ENCODE_SET, "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlin/coroutines/CoroutineContext;", "context", "capacity", "Lkotlinx/coroutines/channels/BufferOverflow;", "onBufferOverflow", "Lkotlinx/coroutines/flow/Flow;", "fuse", "(Lkotlin/coroutines/CoroutineContext;ILkotlinx/coroutines/channels/BufferOverflow;)Lkotlinx/coroutines/flow/Flow;", "resetReplayCache", "()V", "tryEmit", "(Ljava/lang/Object;)Z", "expectedState", "newState", "updateState", HttpUrl.FRAGMENT_ENCODE_SET, "getReplayCache", "()Ljava/util/List;", "replayCache", "sequence", "I", "getValue", "()Ljava/lang/Object;", "setValue", "getValue$annotations", "kotlinx-coroutines-core", "Lkotlinx/coroutines/flow/internal/AbstractSharedFlow;", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lkotlinx/coroutines/flow/CancellableFlow;", "Lkotlinx/coroutines/flow/internal/FusibleFlow;"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* renamed from: kotlinx.coroutines.z2.n, reason: from Kotlin metadata */
/* loaded from: classes3.dex */
final class StateFlowImpl<T> extends AbstractSharedFlow<StateFlowSlot> implements MutableStateFlow<T>, Flow {
    private volatile /* synthetic */ Object _state;

    /* renamed from: j, reason: collision with root package name */
    private int f25931j;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: StateFlow.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "kotlinx.coroutines.flow.StateFlowImpl", f = "StateFlow.kt", l = {386, 398, 403}, m = "collect")
    /* renamed from: kotlinx.coroutines.z2.n$a */
    /* loaded from: classes3.dex */
    public static final class a extends ContinuationImpl {

        /* renamed from: f, reason: collision with root package name */
        Object f25932f;

        /* renamed from: g, reason: collision with root package name */
        Object f25933g;

        /* renamed from: h, reason: collision with root package name */
        Object f25934h;

        /* renamed from: i, reason: collision with root package name */
        Object f25935i;

        /* renamed from: j, reason: collision with root package name */
        Object f25936j;

        /* renamed from: k, reason: collision with root package name */
        /* synthetic */ Object f25937k;
        final /* synthetic */ StateFlowImpl<T> l;
        int m;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(StateFlowImpl<T> stateFlowImpl, Continuation<? super a> continuation) {
            super(continuation);
            this.l = stateFlowImpl;
        }

        @Override // kotlin.coroutines.j.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f25937k = obj;
            this.m |= Integer.MIN_VALUE;
            return this.l.a(null, this);
        }
    }

    public StateFlowImpl(Object obj) {
        this._state = obj;
    }

    private final boolean j(Object obj, Object obj2) {
        int i2;
        StateFlowSlot[] g2;
        g();
        synchronized (this) {
            Object obj3 = this._state;
            if (obj != null && !m.a(obj3, obj)) {
                return false;
            }
            if (m.a(obj3, obj2)) {
                return true;
            }
            this._state = obj2;
            int i3 = this.f25931j;
            if ((i3 & 1) == 0) {
                int i4 = i3 + 1;
                this.f25931j = i4;
                StateFlowSlot[] g3 = g();
                u uVar = u.a;
                while (true) {
                    StateFlowSlot[] stateFlowSlotArr = g3;
                    if (stateFlowSlotArr != null) {
                        for (StateFlowSlot stateFlowSlot : stateFlowSlotArr) {
                            if (stateFlowSlot != null) {
                                stateFlowSlot.f();
                            }
                        }
                    }
                    synchronized (this) {
                        i2 = this.f25931j;
                        if (i2 == i4) {
                            this.f25931j = i4 + 1;
                            return true;
                        }
                        g2 = g();
                        u uVar2 = u.a;
                    }
                    g3 = g2;
                    i4 = i2;
                }
            } else {
                this.f25931j = i3 + 2;
                return true;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x00b3, code lost:
    
        if (kotlin.jvm.internal.m.a(r11, r12) == false) goto L40;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:16:0x00aa A[Catch: all -> 0x0073, TryCatch #0 {all -> 0x0073, blocks: (B:13:0x003e, B:14:0x00a6, B:16:0x00aa, B:18:0x00af, B:20:0x00d0, B:22:0x00d6, B:26:0x00b5, B:29:0x00bc, B:38:0x005c, B:40:0x006f, B:41:0x0097), top: B:7:0x0024 }] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00af A[Catch: all -> 0x0073, TryCatch #0 {all -> 0x0073, blocks: (B:13:0x003e, B:14:0x00a6, B:16:0x00aa, B:18:0x00af, B:20:0x00d0, B:22:0x00d6, B:26:0x00b5, B:29:0x00bc, B:38:0x005c, B:40:0x006f, B:41:0x0097), top: B:7:0x0024 }] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00d6 A[Catch: all -> 0x0073, TRY_LEAVE, TryCatch #0 {all -> 0x0073, blocks: (B:13:0x003e, B:14:0x00a6, B:16:0x00aa, B:18:0x00af, B:20:0x00d0, B:22:0x00d6, B:26:0x00b5, B:29:0x00bc, B:38:0x005c, B:40:0x006f, B:41:0x0097), top: B:7:0x0024 }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00ce A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0026  */
    /* JADX WARN: Type inference failed for: r12v9, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v0 */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v14 */
    /* JADX WARN: Type inference failed for: r6v15 */
    /* JADX WARN: Type inference failed for: r6v16 */
    /* JADX WARN: Type inference failed for: r6v17 */
    /* JADX WARN: Type inference failed for: r6v2, types: [kotlinx.coroutines.flow.internal.c] */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v7, types: [java.lang.Object] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x00d4 -> B:14:0x00a6). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x00e6 -> B:14:0x00a6). Please report as a decompilation issue!!! */
    @Override // kotlinx.coroutines.flow.Flow
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object a(FlowCollector<? super T> flowCollector, Continuation<?> continuation) {
        a aVar;
        Object c2;
        int i2;
        StateFlowImpl<T> stateFlowImpl;
        StateFlowSlot stateFlowSlot;
        FlowCollector flowCollector2;
        Job job;
        Object obj;
        StateFlowSlot stateFlowSlot2;
        boolean g2;
        T t;
        try {
            if (continuation instanceof a) {
                aVar = (a) continuation;
                int i3 = aVar.m;
                if ((i3 & Integer.MIN_VALUE) != 0) {
                    aVar.m = i3 - Integer.MIN_VALUE;
                    Object obj2 = aVar.f25937k;
                    c2 = d.c();
                    i2 = aVar.m;
                    ?? r6 = 1;
                    if (i2 != 0) {
                        o.b(obj2);
                        StateFlowSlot b2 = b();
                        try {
                            if (flowCollector instanceof SubscribedFlowCollector) {
                                aVar.f25932f = this;
                                aVar.f25933g = flowCollector;
                                aVar.f25934h = b2;
                                aVar.m = 1;
                                if (((SubscribedFlowCollector) flowCollector).a(aVar) == c2) {
                                    return c2;
                                }
                            }
                            stateFlowImpl = this;
                            stateFlowSlot = b2;
                        } catch (Throwable th) {
                            th = th;
                            stateFlowImpl = this;
                            r6 = b2;
                            stateFlowImpl.f(r6);
                            throw th;
                        }
                    } else if (i2 == 1) {
                        StateFlowSlot stateFlowSlot3 = (StateFlowSlot) aVar.f25934h;
                        flowCollector = (FlowCollector) aVar.f25933g;
                        stateFlowImpl = (StateFlowImpl) aVar.f25932f;
                        o.b(obj2);
                        stateFlowSlot = stateFlowSlot3;
                    } else if (i2 == 2) {
                        obj = aVar.f25936j;
                        job = (Job) aVar.f25935i;
                        StateFlowSlot stateFlowSlot4 = (StateFlowSlot) aVar.f25934h;
                        flowCollector2 = (FlowCollector) aVar.f25933g;
                        stateFlowImpl = (StateFlowImpl) aVar.f25932f;
                        o.b(obj2);
                        stateFlowSlot2 = stateFlowSlot4;
                        g2 = stateFlowSlot2.g();
                        r6 = stateFlowSlot2;
                        if (!g2) {
                        }
                        ?? r12 = stateFlowImpl._state;
                        if (job != null) {
                        }
                        if (obj != null) {
                        }
                        if (r12 == g.a) {
                        }
                        aVar.f25932f = stateFlowImpl;
                        aVar.f25933g = flowCollector2;
                        aVar.f25934h = r6;
                        aVar.f25935i = job;
                        aVar.f25936j = r12;
                        aVar.m = 2;
                        if (flowCollector2.c(t, aVar) == c2) {
                        }
                    } else {
                        if (i2 != 3) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        obj = aVar.f25936j;
                        job = (Job) aVar.f25935i;
                        StateFlowSlot stateFlowSlot5 = (StateFlowSlot) aVar.f25934h;
                        flowCollector2 = (FlowCollector) aVar.f25933g;
                        stateFlowImpl = (StateFlowImpl) aVar.f25932f;
                        o.b(obj2);
                        r6 = stateFlowSlot5;
                        ?? r122 = stateFlowImpl._state;
                        if (job != null) {
                            b2.f(job);
                        }
                        if (obj != null) {
                            stateFlowSlot2 = r6;
                        }
                        t = r122 == g.a ? null : r122;
                        aVar.f25932f = stateFlowImpl;
                        aVar.f25933g = flowCollector2;
                        aVar.f25934h = r6;
                        aVar.f25935i = job;
                        aVar.f25936j = r122;
                        aVar.m = 2;
                        if (flowCollector2.c(t, aVar) == c2) {
                            return c2;
                        }
                        obj = r122;
                        stateFlowSlot2 = r6;
                        g2 = stateFlowSlot2.g();
                        r6 = stateFlowSlot2;
                        if (!g2) {
                            aVar.f25932f = stateFlowImpl;
                            aVar.f25933g = flowCollector2;
                            aVar.f25934h = stateFlowSlot2;
                            aVar.f25935i = job;
                            aVar.f25936j = obj;
                            aVar.m = 3;
                            Object d2 = stateFlowSlot2.d(aVar);
                            r6 = stateFlowSlot2;
                            if (d2 == c2) {
                                return c2;
                            }
                        }
                        ?? r1222 = stateFlowImpl._state;
                        if (job != null) {
                        }
                        if (obj != null) {
                        }
                        if (r1222 == g.a) {
                        }
                        aVar.f25932f = stateFlowImpl;
                        aVar.f25933g = flowCollector2;
                        aVar.f25934h = r6;
                        aVar.f25935i = job;
                        aVar.f25936j = r1222;
                        aVar.m = 2;
                        if (flowCollector2.c(t, aVar) == c2) {
                        }
                    }
                    flowCollector2 = flowCollector;
                    job = (Job) aVar.getContext().get(Job.f25890e);
                    obj = null;
                    r6 = stateFlowSlot;
                    ?? r12222 = stateFlowImpl._state;
                    if (job != null) {
                    }
                    if (obj != null) {
                    }
                    if (r12222 == g.a) {
                    }
                    aVar.f25932f = stateFlowImpl;
                    aVar.f25933g = flowCollector2;
                    aVar.f25934h = r6;
                    aVar.f25935i = job;
                    aVar.f25936j = r12222;
                    aVar.m = 2;
                    if (flowCollector2.c(t, aVar) == c2) {
                    }
                }
            }
            if (i2 != 0) {
            }
            flowCollector2 = flowCollector;
            job = (Job) aVar.getContext().get(Job.f25890e);
            obj = null;
            r6 = stateFlowSlot;
            ?? r122222 = stateFlowImpl._state;
            if (job != null) {
            }
            if (obj != null) {
            }
            if (r122222 == g.a) {
            }
            aVar.f25932f = stateFlowImpl;
            aVar.f25933g = flowCollector2;
            aVar.f25934h = r6;
            aVar.f25935i = job;
            aVar.f25936j = r122222;
            aVar.m = 2;
            if (flowCollector2.c(t, aVar) == c2) {
            }
        } catch (Throwable th2) {
            th = th2;
        }
        aVar = new a(this, continuation);
        Object obj22 = aVar.f25937k;
        c2 = d.c();
        i2 = aVar.m;
        ?? r62 = 1;
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    public Object c(T t, Continuation<? super u> continuation) {
        setValue(t);
        return u.a;
    }

    @Override // kotlinx.coroutines.flow.MutableStateFlow
    public T getValue() {
        Symbol symbol = g.a;
        T t = (T) this._state;
        if (t == symbol) {
            return null;
        }
        return t;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.coroutines.flow.internal.AbstractSharedFlow
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public StateFlowSlot d() {
        return new StateFlowSlot();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.coroutines.flow.internal.AbstractSharedFlow
    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public StateFlowSlot[] e(int i2) {
        return new StateFlowSlot[i2];
    }

    @Override // kotlinx.coroutines.flow.MutableStateFlow
    public void setValue(T t) {
        if (t == null) {
            t = (T) g.a;
        }
        j(null, t);
    }
}
