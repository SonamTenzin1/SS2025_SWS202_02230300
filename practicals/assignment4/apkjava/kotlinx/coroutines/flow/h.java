package kotlinx.coroutines.flow;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.d;
import kotlin.coroutines.j.internal.ContinuationImpl;
import kotlin.coroutines.j.internal.DebugMetadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.m;
import kotlin.o;
import kotlin.u;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.internal.d0;
import kotlinx.coroutines.s0;
import okhttp3.HttpUrl;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Errors.kt */
@Metadata(d1 = {"\u0000V\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001ah\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012B\u0010\u0003\u001a>\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0005\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u0004¢\u0006\u0002\b\rø\u0001\u0000¢\u0006\u0002\u0010\u000e\u001a1\u0010\u000f\u001a\u0004\u0018\u00010\u0006\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0005H\u0080@ø\u0001\u0000¢\u0006\u0002\u0010\u0011\u001a\u0019\u0010\u0012\u001a\u00020\u0013*\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0015H\u0002¢\u0006\u0002\b\u0016\u001a\u001b\u0010\u0017\u001a\u00020\u0013*\u00020\u00062\b\u0010\u0018\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0002\b\u0019\u001ac\u0010\u001a\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\b\b\u0002\u0010\u001b\u001a\u00020\u001c23\b\u0002\u0010\u001d\u001a-\b\u0001\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u001eø\u0001\u0000¢\u0006\u0002\u0010\u001f\u001a}\u0010 \u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012W\u0010\u001d\u001aS\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0005\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\u001c¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\"\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\n\u0012\u0006\u0012\u0004\u0018\u00010\f0!¢\u0006\u0002\b\rø\u0001\u0000¢\u0006\u0002\u0010#\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006$"}, d2 = {"catch", "Lkotlinx/coroutines/flow/Flow;", "T", "action", "Lkotlin/Function3;", "Lkotlinx/coroutines/flow/FlowCollector;", HttpUrl.FRAGMENT_ENCODE_SET, "Lkotlin/ParameterName;", "name", "cause", "Lkotlin/coroutines/Continuation;", HttpUrl.FRAGMENT_ENCODE_SET, HttpUrl.FRAGMENT_ENCODE_SET, "Lkotlin/ExtensionFunctionType;", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function3;)Lkotlinx/coroutines/flow/Flow;", "catchImpl", "collector", "(Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isCancellationCause", HttpUrl.FRAGMENT_ENCODE_SET, "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "isCancellationCause$FlowKt__ErrorsKt", "isSameExceptionAs", "other", "isSameExceptionAs$FlowKt__ErrorsKt", "retry", "retries", HttpUrl.FRAGMENT_ENCODE_SET, "predicate", "Lkotlin/Function2;", "(Lkotlinx/coroutines/flow/Flow;JLkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/flow/Flow;", "retryWhen", "Lkotlin/Function4;", "attempt", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function4;)Lkotlinx/coroutines/flow/Flow;", "kotlinx-coroutines-core"}, k = 5, mv = {1, 6, 0}, xi = 48, xs = "kotlinx/coroutines/flow/FlowKt")
/* loaded from: classes3.dex */
public final /* synthetic */ class h {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: SafeCollector.common.kt */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001f\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007¸\u0006\u0000"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", HttpUrl.FRAGMENT_ENCODE_SET, "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class a<T> implements Flow<T> {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ Flow f25899f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ Function3 f25900g;

        /* compiled from: SafeCollector.common.kt */
        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ErrorsKt$catch$$inlined$unsafeFlow$1", f = "Errors.kt", l = {113, 114}, m = "collect")
        /* renamed from: kotlinx.coroutines.z2.h$a$a, reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public static final class C0425a extends ContinuationImpl {

            /* renamed from: f, reason: collision with root package name */
            /* synthetic */ Object f25901f;

            /* renamed from: g, reason: collision with root package name */
            int f25902g;

            /* renamed from: i, reason: collision with root package name */
            Object f25904i;

            /* renamed from: j, reason: collision with root package name */
            Object f25905j;

            public C0425a(Continuation continuation) {
                super(continuation);
            }

            @Override // kotlin.coroutines.j.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                this.f25901f = obj;
                this.f25902g |= Integer.MIN_VALUE;
                return a.this.a(null, this);
            }
        }

        public a(Flow flow, Function3 function3) {
            this.f25899f = flow;
            this.f25900g = function3;
        }

        /* JADX WARN: Removed duplicated region for block: B:19:0x0057  */
        /* JADX WARN: Removed duplicated region for block: B:22:0x0040  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
        @Override // kotlinx.coroutines.flow.Flow
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public Object a(FlowCollector<? super T> flowCollector, Continuation<? super u> continuation) {
            C0425a c0425a;
            Object c2;
            int i2;
            a<T> aVar;
            Throwable th;
            if (continuation instanceof C0425a) {
                c0425a = (C0425a) continuation;
                int i3 = c0425a.f25902g;
                if ((i3 & Integer.MIN_VALUE) != 0) {
                    c0425a.f25902g = i3 - Integer.MIN_VALUE;
                    Object obj = c0425a.f25901f;
                    c2 = d.c();
                    i2 = c0425a.f25902g;
                    if (i2 != 0) {
                        o.b(obj);
                        Flow flow = this.f25899f;
                        c0425a.f25904i = this;
                        c0425a.f25905j = flowCollector;
                        c0425a.f25902g = 1;
                        obj = d.b(flow, flowCollector, c0425a);
                        if (obj == c2) {
                            return c2;
                        }
                        aVar = this;
                    } else {
                        if (i2 != 1) {
                            if (i2 != 2) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            o.b(obj);
                            return u.a;
                        }
                        flowCollector = (FlowCollector) c0425a.f25905j;
                        aVar = (a) c0425a.f25904i;
                        o.b(obj);
                    }
                    th = (Throwable) obj;
                    if (th != null) {
                        Function3 function3 = aVar.f25900g;
                        c0425a.f25904i = null;
                        c0425a.f25905j = null;
                        c0425a.f25902g = 2;
                        k.c(6);
                        Object d2 = function3.d(flowCollector, th, c0425a);
                        k.c(7);
                        if (d2 == c2) {
                            return c2;
                        }
                    }
                    return u.a;
                }
            }
            c0425a = new C0425a(continuation);
            Object obj2 = c0425a.f25901f;
            c2 = d.c();
            i2 = c0425a.f25902g;
            if (i2 != 0) {
            }
            th = (Throwable) obj2;
            if (th != null) {
            }
            return u.a;
        }
    }

    /* compiled from: Errors.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ErrorsKt", f = "Errors.kt", l = {156}, m = "catchImpl")
    /* loaded from: classes3.dex */
    static final class b<T> extends ContinuationImpl {

        /* renamed from: f, reason: collision with root package name */
        Object f25906f;

        /* renamed from: g, reason: collision with root package name */
        /* synthetic */ Object f25907g;

        /* renamed from: h, reason: collision with root package name */
        int f25908h;

        b(Continuation<? super b> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.j.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f25907g = obj;
            this.f25908h |= Integer.MIN_VALUE;
            return d.b(null, null, this);
        }
    }

    /* compiled from: Errors.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", HttpUrl.FRAGMENT_ENCODE_SET, "T", "it", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes3.dex */
    static final class c<T> implements FlowCollector {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ FlowCollector<T> f25909f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ f0<Throwable> f25910g;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: Errors.kt */
        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ErrorsKt$catchImpl$2", f = "Errors.kt", l = {158}, m = "emit")
        /* loaded from: classes3.dex */
        public static final class a extends ContinuationImpl {

            /* renamed from: f, reason: collision with root package name */
            Object f25911f;

            /* renamed from: g, reason: collision with root package name */
            /* synthetic */ Object f25912g;

            /* renamed from: h, reason: collision with root package name */
            final /* synthetic */ c<T> f25913h;

            /* renamed from: i, reason: collision with root package name */
            int f25914i;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            a(c<? super T> cVar, Continuation<? super a> continuation) {
                super(continuation);
                this.f25913h = cVar;
            }

            @Override // kotlin.coroutines.j.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                this.f25912g = obj;
                this.f25914i |= Integer.MIN_VALUE;
                return this.f25913h.c(null, this);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        c(FlowCollector<? super T> flowCollector, f0<Throwable> f0Var) {
            this.f25909f = flowCollector;
            this.f25910g = f0Var;
        }

        /* JADX WARN: Removed duplicated region for block: B:21:0x0037  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
        @Override // kotlinx.coroutines.flow.FlowCollector
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object c(T t, Continuation<? super u> continuation) {
            a aVar;
            Object c2;
            int i2;
            c<T> cVar;
            if (continuation instanceof a) {
                aVar = (a) continuation;
                int i3 = aVar.f25914i;
                if ((i3 & Integer.MIN_VALUE) != 0) {
                    aVar.f25914i = i3 - Integer.MIN_VALUE;
                    Object obj = aVar.f25912g;
                    c2 = d.c();
                    i2 = aVar.f25914i;
                    if (i2 != 0) {
                        o.b(obj);
                        try {
                            FlowCollector<T> flowCollector = this.f25909f;
                            aVar.f25911f = this;
                            aVar.f25914i = 1;
                            if (flowCollector.c(t, aVar) == c2) {
                                return c2;
                            }
                        } catch (Throwable 
                        /*  JADX ERROR: Method code generation error
                            java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.SSAVar.getCodeVar()" because "ssaVar" is null
                            	at jadx.core.codegen.RegionGen.makeCatchBlock(RegionGen.java:367)
                            	at jadx.core.codegen.RegionGen.makeTryCatch(RegionGen.java:330)
                            	at jadx.core.dex.regions.TryCatchRegion.generate(TryCatchRegion.java:85)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                            	at jadx.core.dex.regions.Region.generate(Region.java:35)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:126)
                            	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                            	at jadx.core.dex.regions.Region.generate(Region.java:35)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:126)
                            	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                            	at jadx.core.dex.regions.Region.generate(Region.java:35)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:126)
                            	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                            	at jadx.core.dex.regions.Region.generate(Region.java:35)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                            	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:297)
                            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:276)
                            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:406)
                            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
                            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
                            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:184)
                            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1597)
                            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
                            */
                        /*
                            this = this;
                            boolean r0 = r6 instanceof kotlinx.coroutines.z2.h.c.a
                            if (r0 == 0) goto L13
                            r0 = r6
                            kotlinx.coroutines.z2.h$c$a r0 = (kotlinx.coroutines.z2.h.c.a) r0
                            int r1 = r0.f25914i
                            r2 = -2147483648(0xffffffff80000000, float:-0.0)
                            r3 = r1 & r2
                            if (r3 == 0) goto L13
                            int r1 = r1 - r2
                            r0.f25914i = r1
                            goto L18
                        L13:
                            kotlinx.coroutines.z2.h$c$a r0 = new kotlinx.coroutines.z2.h$c$a
                            r0.<init>(r4, r6)
                        L18:
                            java.lang.Object r6 = r0.f25912g
                            java.lang.Object r1 = kotlin.coroutines.intrinsics.b.c()
                            int r2 = r0.f25914i
                            r3 = 1
                            if (r2 == 0) goto L37
                            if (r2 != r3) goto L2f
                            java.lang.Object r5 = r0.f25911f
                            kotlinx.coroutines.z2.h$c r5 = (kotlinx.coroutines.z2.h.c) r5
                            kotlin.o.b(r6)     // Catch: java.lang.Throwable -> L2d
                            goto L47
                        L2d:
                            r6 = move-exception
                            goto L4c
                        L2f:
                            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                            r5.<init>(r6)
                            throw r5
                        L37:
                            kotlin.o.b(r6)
                            kotlinx.coroutines.z2.c<T> r6 = r4.f25909f     // Catch: java.lang.Throwable -> L4a
                            r0.f25911f = r4     // Catch: java.lang.Throwable -> L4a
                            r0.f25914i = r3     // Catch: java.lang.Throwable -> L4a
                            java.lang.Object r5 = r6.c(r5, r0)     // Catch: java.lang.Throwable -> L4a
                            if (r5 != r1) goto L47
                            return r1
                        L47:
                            kotlin.u r5 = kotlin.u.a
                            return r5
                        L4a:
                            r6 = move-exception
                            r5 = r4
                        L4c:
                            kotlin.a0.d.f0<java.lang.Throwable> r5 = r5.f25910g
                            r5.f22943f = r6
                            throw r6
                        */
                        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.z2.h.c.c(java.lang.Object, kotlin.y.d):java.lang.Object");
                    }
                }

                public static final <T> Flow<T> a(Flow<? extends T> flow, Function3<? super FlowCollector<? super T>, ? super Throwable, ? super Continuation<? super u>, ? extends Object> function3) {
                    return new a(flow, function3);
                }

                /* JADX WARN: Removed duplicated region for block: B:31:0x0037  */
                /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public static final <T> Object b(Flow<? extends T> flow, FlowCollector<? super T> flowCollector, Continuation<? super Throwable> continuation) {
                    b bVar;
                    Object c2;
                    int i2;
                    f0 f0Var;
                    Throwable th;
                    if (continuation instanceof b) {
                        bVar = (b) continuation;
                        int i3 = bVar.f25908h;
                        if ((i3 & Integer.MIN_VALUE) != 0) {
                            bVar.f25908h = i3 - Integer.MIN_VALUE;
                            Object obj = bVar.f25907g;
                            c2 = d.c();
                            i2 = bVar.f25908h;
                            if (i2 != 0) {
                                o.b(obj);
                                f0 f0Var2 = new f0();
                                try {
                                    FlowCollector<? super Object> cVar = new c<>(flowCollector, f0Var2);
                                    bVar.f25906f = f0Var2;
                                    bVar.f25908h = 1;
                                    if (flow.a(cVar, bVar) == c2) {
                                        return c2;
                                    }
                                    return null;
                                } catch (Throwable th2) {
                                    th = th2;
                                    f0Var = f0Var2;
                                }
                            } else {
                                if (i2 != 1) {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                                f0Var = (f0) bVar.f25906f;
                                try {
                                    o.b(obj);
                                    return null;
                                } catch (Throwable th3) {
                                    th = th3;
                                }
                            }
                            th = (Throwable) f0Var.f22943f;
                            if (!d(th, th) || c(th, bVar.getL())) {
                                throw th;
                            }
                            if (th == null) {
                                return th;
                            }
                            if (th instanceof CancellationException) {
                                kotlin.b.a(th, th);
                                throw th;
                            }
                            kotlin.b.a(th, th);
                            throw th;
                        }
                    }
                    bVar = new b(continuation);
                    Object obj2 = bVar.f25907g;
                    c2 = d.c();
                    i2 = bVar.f25908h;
                    if (i2 != 0) {
                    }
                    th = (Throwable) f0Var.f22943f;
                    if (d(th, th)) {
                    }
                    throw th;
                }

                private static final boolean c(Throwable th, CoroutineContext coroutineContext) {
                    Job job = (Job) coroutineContext.get(Job.f25890e);
                    if (job == null || !job.isCancelled()) {
                        return false;
                    }
                    return d(th, job.j());
                }

                private static final boolean d(Throwable th, Throwable th2) {
                    if (th2 != null) {
                        if (s0.d()) {
                            th2 = d0.l(th2);
                        }
                        if (s0.d()) {
                            th = d0.l(th);
                        }
                        if (m.a(th2, th)) {
                            return true;
                        }
                    }
                    return false;
                }
            }
