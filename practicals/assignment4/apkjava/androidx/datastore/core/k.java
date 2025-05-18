package androidx.datastore.core;

import java.util.concurrent.atomic.AtomicInteger;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.j.internal.DebugMetadata;
import kotlin.coroutines.j.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlin.o;
import kotlin.u;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelResult;
import kotlinx.coroutines.channels.ClosedSendChannelException;
import kotlinx.coroutines.p0;

/* compiled from: SimpleActor.kt */
/* loaded from: classes.dex */
public final class k<T> {
    private final CoroutineScope a;

    /* renamed from: b, reason: collision with root package name */
    private final Function2<T, Continuation<? super u>, Object> f1145b;

    /* renamed from: c, reason: collision with root package name */
    private final Channel<T> f1146c;

    /* renamed from: d, reason: collision with root package name */
    private final AtomicInteger f1147d;

    /* compiled from: SimpleActor.kt */
    /* loaded from: classes.dex */
    static final class a extends Lambda implements Function1<Throwable, u> {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ Function1<Throwable, u> f1148f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ k<T> f1149g;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ Function2<T, Throwable, u> f1150h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        a(Function1<? super Throwable, u> function1, k<T> kVar, Function2<? super T, ? super Throwable, u> function2) {
            super(1);
            this.f1148f = function1;
            this.f1149g = kVar;
            this.f1150h = function2;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ u invoke(Throwable th) {
            invoke2(th);
            return u.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Throwable th) {
            u uVar;
            this.f1148f.invoke(th);
            ((k) this.f1149g).f1146c.c(th);
            do {
                Object f2 = ChannelResult.f(((k) this.f1149g).f1146c.a());
                if (f2 == null) {
                    uVar = null;
                } else {
                    this.f1150h.invoke(f2, th);
                    uVar = u.a;
                }
            } while (uVar != null);
        }
    }

    /* compiled from: SimpleActor.kt */
    @DebugMetadata(c = "androidx.datastore.core.SimpleActor$offer$2", f = "SimpleActor.kt", l = {122, 122}, m = "invokeSuspend")
    /* loaded from: classes.dex */
    static final class b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super u>, Object> {

        /* renamed from: f, reason: collision with root package name */
        Object f1151f;

        /* renamed from: g, reason: collision with root package name */
        int f1152g;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ k<T> f1153h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(k<T> kVar, Continuation<? super b> continuation) {
            super(2, continuation);
            this.f1153h = kVar;
        }

        @Override // kotlin.coroutines.j.internal.BaseContinuationImpl
        public final Continuation<u> create(Object obj, Continuation<?> continuation) {
            return new b(this.f1153h, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super u> continuation) {
            return ((b) create(coroutineScope, continuation)).invokeSuspend(u.a);
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x005a A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:12:0x005b  */
        /* JADX WARN: Removed duplicated region for block: B:15:0x006b A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:16:0x006c  */
        /* JADX WARN: Removed duplicated region for block: B:17:0x007a  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x006c -> B:6:0x006e). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.j.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            Object c2;
            b bVar;
            Function2 function2;
            Object obj2;
            b bVar2;
            Object b2;
            c2 = kotlin.coroutines.intrinsics.d.c();
            int i2 = this.f1152g;
            if (i2 == 0) {
                o.b(obj);
                if (((k) this.f1153h).f1147d.get() > 0) {
                    bVar = this;
                    p0.b(((k) bVar.f1153h).a);
                    Function2 function22 = ((k) bVar.f1153h).f1145b;
                    Channel channel = ((k) bVar.f1153h).f1146c;
                    bVar.f1151f = function22;
                    bVar.f1152g = 1;
                    b2 = channel.b(bVar);
                    if (b2 == c2) {
                    }
                } else {
                    throw new IllegalStateException("Check failed.".toString());
                }
            } else if (i2 == 1) {
                Function2 function23 = (Function2) this.f1151f;
                o.b(obj);
                function2 = function23;
                obj2 = c2;
                bVar2 = this;
                bVar2.f1151f = null;
                bVar2.f1152g = 2;
                if (function2.invoke(obj, bVar2) != obj2) {
                }
            } else if (i2 == 2) {
                o.b(obj);
                bVar = this;
                if (((k) bVar.f1153h).f1147d.decrementAndGet() == 0) {
                    return u.a;
                }
                p0.b(((k) bVar.f1153h).a);
                Function2 function222 = ((k) bVar.f1153h).f1145b;
                Channel channel2 = ((k) bVar.f1153h).f1146c;
                bVar.f1151f = function222;
                bVar.f1152g = 1;
                b2 = channel2.b(bVar);
                if (b2 == c2) {
                    return c2;
                }
                Object obj3 = c2;
                bVar2 = bVar;
                obj = b2;
                function2 = function222;
                obj2 = obj3;
                bVar2.f1151f = null;
                bVar2.f1152g = 2;
                if (function2.invoke(obj, bVar2) != obj2) {
                    return obj2;
                }
                bVar = bVar2;
                c2 = obj2;
                if (((k) bVar.f1153h).f1147d.decrementAndGet() == 0) {
                }
                p0.b(((k) bVar.f1153h).a);
                Function2 function2222 = ((k) bVar.f1153h).f1145b;
                Channel channel22 = ((k) bVar.f1153h).f1146c;
                bVar.f1151f = function2222;
                bVar.f1152g = 1;
                b2 = channel22.b(bVar);
                if (b2 == c2) {
                }
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public k(CoroutineScope coroutineScope, Function1<? super Throwable, u> function1, Function2<? super T, ? super Throwable, u> function2, Function2<? super T, ? super Continuation<? super u>, ? extends Object> function22) {
        kotlin.jvm.internal.m.f(coroutineScope, "scope");
        kotlin.jvm.internal.m.f(function1, "onComplete");
        kotlin.jvm.internal.m.f(function2, "onUndeliveredElement");
        kotlin.jvm.internal.m.f(function22, "consumeMessage");
        this.a = coroutineScope;
        this.f1145b = function22;
        this.f1146c = kotlinx.coroutines.channels.g.b(Integer.MAX_VALUE, null, null, 6, null);
        this.f1147d = new AtomicInteger(0);
        Job job = (Job) coroutineScope.getF25795f().get(Job.f25890e);
        if (job == null) {
            return;
        }
        job.m(new a(function1, this, function2));
    }

    public final void e(T t) {
        Object d2 = this.f1146c.d(t);
        if (d2 instanceof ChannelResult.Closed) {
            Throwable e2 = ChannelResult.e(d2);
            if (e2 != null) {
                throw e2;
            }
            throw new ClosedSendChannelException("Channel was closed normally");
        }
        if (ChannelResult.h(d2)) {
            if (this.f1147d.getAndIncrement() == 0) {
                kotlinx.coroutines.j.b(this.a, null, null, new b(this, null), 3, null);
                return;
            }
            return;
        }
        throw new IllegalStateException("Check failed.".toString());
    }
}
