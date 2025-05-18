package androidx.datastore.core;

import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CancellationException;
import kotlin.Lazy;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.j.internal.ContinuationImpl;
import kotlin.coroutines.j.internal.DebugMetadata;
import kotlin.coroutines.j.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.c0;
import kotlin.jvm.internal.f0;
import kotlin.u;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.y;

/* compiled from: SingleProcessDataStore.kt */
/* loaded from: classes.dex */
public final class l<T> implements androidx.datastore.core.e<T> {
    public static final a a = new a(null);

    /* renamed from: b, reason: collision with root package name */
    private static final Set<String> f1154b = new LinkedHashSet();

    /* renamed from: c, reason: collision with root package name */
    private static final Object f1155c = new Object();

    /* renamed from: d, reason: collision with root package name */
    private final Function0<File> f1156d;

    /* renamed from: e, reason: collision with root package name */
    private final androidx.datastore.core.j<T> f1157e;

    /* renamed from: f, reason: collision with root package name */
    private final androidx.datastore.core.a<T> f1158f;

    /* renamed from: g, reason: collision with root package name */
    private final CoroutineScope f1159g;

    /* renamed from: h, reason: collision with root package name */
    private final Flow<T> f1160h;

    /* renamed from: i, reason: collision with root package name */
    private final String f1161i;

    /* renamed from: j, reason: collision with root package name */
    private final Lazy f1162j;

    /* renamed from: k, reason: collision with root package name */
    private final MutableStateFlow<androidx.datastore.core.m<T>> f1163k;
    private List<? extends Function2<? super androidx.datastore.core.h<T>, ? super Continuation<? super u>, ? extends Object>> l;
    private final androidx.datastore.core.k<b<T>> m;

    /* compiled from: SingleProcessDataStore.kt */
    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
            this();
        }

        public final Set<String> a() {
            return l.f1154b;
        }

        public final Object b() {
            return l.f1155c;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: SingleProcessDataStore.kt */
    /* loaded from: classes.dex */
    public static abstract class b<T> {

        /* compiled from: SingleProcessDataStore.kt */
        /* loaded from: classes.dex */
        public static final class a<T> extends b<T> {
            private final androidx.datastore.core.m<T> a;

            public a(androidx.datastore.core.m<T> mVar) {
                super(null);
                this.a = mVar;
            }

            public androidx.datastore.core.m<T> a() {
                return this.a;
            }
        }

        /* compiled from: SingleProcessDataStore.kt */
        /* renamed from: androidx.datastore.core.l$b$b, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C0029b<T> extends b<T> {
            private final Function2<T, Continuation<? super T>, Object> a;

            /* renamed from: b, reason: collision with root package name */
            private final CompletableDeferred<T> f1164b;

            /* renamed from: c, reason: collision with root package name */
            private final androidx.datastore.core.m<T> f1165c;

            /* renamed from: d, reason: collision with root package name */
            private final CoroutineContext f1166d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public C0029b(Function2<? super T, ? super Continuation<? super T>, ? extends Object> function2, CompletableDeferred<T> completableDeferred, androidx.datastore.core.m<T> mVar, CoroutineContext coroutineContext) {
                super(null);
                kotlin.jvm.internal.m.f(function2, "transform");
                kotlin.jvm.internal.m.f(completableDeferred, "ack");
                kotlin.jvm.internal.m.f(coroutineContext, "callerContext");
                this.a = function2;
                this.f1164b = completableDeferred;
                this.f1165c = mVar;
                this.f1166d = coroutineContext;
            }

            public final CompletableDeferred<T> a() {
                return this.f1164b;
            }

            public final CoroutineContext b() {
                return this.f1166d;
            }

            public androidx.datastore.core.m<T> c() {
                return this.f1165c;
            }

            public final Function2<T, Continuation<? super T>, Object> d() {
                return this.a;
            }
        }

        private b() {
        }

        public /* synthetic */ b(kotlin.jvm.internal.g gVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: SingleProcessDataStore.kt */
    /* loaded from: classes.dex */
    public static final class c extends OutputStream {

        /* renamed from: f, reason: collision with root package name */
        private final FileOutputStream f1167f;

        public c(FileOutputStream fileOutputStream) {
            kotlin.jvm.internal.m.f(fileOutputStream, "fileOutputStream");
            this.f1167f = fileOutputStream;
        }

        @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        @Override // java.io.OutputStream, java.io.Flushable
        public void flush() {
            this.f1167f.flush();
        }

        @Override // java.io.OutputStream
        public void write(int i2) {
            this.f1167f.write(i2);
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr) {
            kotlin.jvm.internal.m.f(bArr, "b");
            this.f1167f.write(bArr);
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr, int i2, int i3) {
            kotlin.jvm.internal.m.f(bArr, "bytes");
            this.f1167f.write(bArr, i2, i3);
        }
    }

    /* compiled from: SingleProcessDataStore.kt */
    /* loaded from: classes.dex */
    static final class d extends Lambda implements Function1<Throwable, u> {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ l<T> f1168f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(l<T> lVar) {
            super(1);
            this.f1168f = lVar;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ u invoke(Throwable th) {
            invoke2(th);
            return u.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Throwable th) {
            if (th != null) {
                ((l) this.f1168f).f1163k.setValue(new androidx.datastore.core.g(th));
            }
            a aVar = l.a;
            Object b2 = aVar.b();
            l<T> lVar = this.f1168f;
            synchronized (b2) {
                aVar.a().remove(lVar.r().getAbsolutePath());
                u uVar = u.a;
            }
        }
    }

    /* compiled from: SingleProcessDataStore.kt */
    /* loaded from: classes.dex */
    static final class e extends Lambda implements Function2<b<T>, Throwable, u> {

        /* renamed from: f, reason: collision with root package name */
        public static final e f1169f = new e();

        e() {
            super(2);
        }

        public final void b(b<T> bVar, Throwable th) {
            kotlin.jvm.internal.m.f(bVar, "msg");
            if (bVar instanceof b.C0029b) {
                CompletableDeferred<T> a = ((b.C0029b) bVar).a();
                if (th == null) {
                    th = new CancellationException("DataStore scope was cancelled before updateData could complete");
                }
                a.A(th);
            }
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ u invoke(Object obj, Throwable th) {
            b((b) obj, th);
            return u.a;
        }
    }

    /* compiled from: SingleProcessDataStore.kt */
    @DebugMetadata(c = "androidx.datastore.core.SingleProcessDataStore$actor$3", f = "SingleProcessDataStore.kt", l = {239, 242}, m = "invokeSuspend")
    /* loaded from: classes.dex */
    static final class f extends SuspendLambda implements Function2<b<T>, Continuation<? super u>, Object> {

        /* renamed from: f, reason: collision with root package name */
        int f1170f;

        /* renamed from: g, reason: collision with root package name */
        /* synthetic */ Object f1171g;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ l<T> f1172h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f(l<T> lVar, Continuation<? super f> continuation) {
            super(2, continuation);
            this.f1172h = lVar;
        }

        @Override // kotlin.coroutines.j.internal.BaseContinuationImpl
        public final Continuation<u> create(Object obj, Continuation<?> continuation) {
            f fVar = new f(this.f1172h, continuation);
            fVar.f1171g = obj;
            return fVar;
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public final Object invoke(b<T> bVar, Continuation<? super u> continuation) {
            return ((f) create(bVar, continuation)).invokeSuspend(u.a);
        }

        @Override // kotlin.coroutines.j.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object c2;
            c2 = kotlin.coroutines.intrinsics.d.c();
            int i2 = this.f1170f;
            if (i2 == 0) {
                kotlin.o.b(obj);
                b bVar = (b) this.f1171g;
                if (bVar instanceof b.a) {
                    this.f1170f = 1;
                    if (this.f1172h.s((b.a) bVar, this) == c2) {
                        return c2;
                    }
                } else if (bVar instanceof b.C0029b) {
                    this.f1170f = 2;
                    if (this.f1172h.t((b.C0029b) bVar, this) == c2) {
                        return c2;
                    }
                }
            } else {
                if (i2 != 1 && i2 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                kotlin.o.b(obj);
            }
            return u.a;
        }
    }

    /* compiled from: SingleProcessDataStore.kt */
    @DebugMetadata(c = "androidx.datastore.core.SingleProcessDataStore$data$1", f = "SingleProcessDataStore.kt", l = {117}, m = "invokeSuspend")
    /* loaded from: classes.dex */
    static final class g extends SuspendLambda implements Function2<FlowCollector<? super T>, Continuation<? super u>, Object> {

        /* renamed from: f, reason: collision with root package name */
        int f1173f;

        /* renamed from: g, reason: collision with root package name */
        private /* synthetic */ Object f1174g;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ l<T> f1175h;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: SingleProcessDataStore.kt */
        @DebugMetadata(c = "androidx.datastore.core.SingleProcessDataStore$data$1$1", f = "SingleProcessDataStore.kt", l = {}, m = "invokeSuspend")
        /* loaded from: classes.dex */
        public static final class a extends SuspendLambda implements Function2<androidx.datastore.core.m<T>, Continuation<? super Boolean>, Object> {

            /* renamed from: f, reason: collision with root package name */
            int f1176f;

            /* renamed from: g, reason: collision with root package name */
            /* synthetic */ Object f1177g;

            /* renamed from: h, reason: collision with root package name */
            final /* synthetic */ androidx.datastore.core.m<T> f1178h;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(androidx.datastore.core.m<T> mVar, Continuation<? super a> continuation) {
                super(2, continuation);
                this.f1178h = mVar;
            }

            @Override // kotlin.coroutines.j.internal.BaseContinuationImpl
            public final Continuation<u> create(Object obj, Continuation<?> continuation) {
                a aVar = new a(this.f1178h, continuation);
                aVar.f1177g = obj;
                return aVar;
            }

            @Override // kotlin.jvm.functions.Function2
            /* renamed from: i, reason: merged with bridge method [inline-methods] */
            public final Object invoke(androidx.datastore.core.m<T> mVar, Continuation<? super Boolean> continuation) {
                return ((a) create(mVar, continuation)).invokeSuspend(u.a);
            }

            @Override // kotlin.coroutines.j.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                kotlin.coroutines.intrinsics.d.c();
                if (this.f1176f == 0) {
                    kotlin.o.b(obj);
                    androidx.datastore.core.m<T> mVar = (androidx.datastore.core.m) this.f1177g;
                    androidx.datastore.core.m<T> mVar2 = this.f1178h;
                    boolean z = false;
                    if (!(mVar2 instanceof androidx.datastore.core.b) && !(mVar2 instanceof androidx.datastore.core.g) && mVar == mVar2) {
                        z = true;
                    }
                    return kotlin.coroutines.j.internal.b.a(z);
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* compiled from: SafeCollector.common.kt */
        /* loaded from: classes.dex */
        public static final class b implements Flow<T> {

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ Flow f1179f;

            /* compiled from: Collect.kt */
            /* loaded from: classes.dex */
            public static final class a implements FlowCollector<androidx.datastore.core.m<T>> {

                /* renamed from: f, reason: collision with root package name */
                final /* synthetic */ FlowCollector f1180f;

                @DebugMetadata(c = "androidx.datastore.core.SingleProcessDataStore$data$1$invokeSuspend$$inlined$map$1$2", f = "SingleProcessDataStore.kt", l = {137}, m = "emit")
                /* renamed from: androidx.datastore.core.l$g$b$a$a, reason: collision with other inner class name */
                /* loaded from: classes.dex */
                public static final class C0030a extends ContinuationImpl {

                    /* renamed from: f, reason: collision with root package name */
                    /* synthetic */ Object f1181f;

                    /* renamed from: g, reason: collision with root package name */
                    int f1182g;

                    public C0030a(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.j.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        this.f1181f = obj;
                        this.f1182g |= Integer.MIN_VALUE;
                        return a.this.c(null, this);
                    }
                }

                public a(FlowCollector flowCollector) {
                    this.f1180f = flowCollector;
                }

                /* JADX WARN: Multi-variable type inference failed */
                /* JADX WARN: Removed duplicated region for block: B:15:0x0031  */
                /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public Object c(Object obj, Continuation continuation) {
                    C0030a c0030a;
                    Object c2;
                    int i2;
                    if (continuation instanceof C0030a) {
                        c0030a = (C0030a) continuation;
                        int i3 = c0030a.f1182g;
                        if ((i3 & Integer.MIN_VALUE) != 0) {
                            c0030a.f1182g = i3 - Integer.MIN_VALUE;
                            Object obj2 = c0030a.f1181f;
                            c2 = kotlin.coroutines.intrinsics.d.c();
                            i2 = c0030a.f1182g;
                            if (i2 != 0) {
                                kotlin.o.b(obj2);
                                FlowCollector flowCollector = this.f1180f;
                                androidx.datastore.core.m mVar = (androidx.datastore.core.m) obj;
                                if (!(mVar instanceof androidx.datastore.core.i)) {
                                    if (!(mVar instanceof androidx.datastore.core.g)) {
                                        if (mVar instanceof androidx.datastore.core.b) {
                                            Object b2 = ((androidx.datastore.core.b) mVar).b();
                                            c0030a.f1182g = 1;
                                            if (flowCollector.c(b2, c0030a) == c2) {
                                                return c2;
                                            }
                                        } else {
                                            if (mVar instanceof androidx.datastore.core.n) {
                                                throw new IllegalStateException("This is a bug in DataStore. Please file a bug at: https://issuetracker.google.com/issues/new?component=907884&template=1466542".toString());
                                            }
                                            throw new NoWhenBranchMatchedException();
                                        }
                                    } else {
                                        throw ((androidx.datastore.core.g) mVar).a();
                                    }
                                } else {
                                    throw ((androidx.datastore.core.i) mVar).a();
                                }
                            } else {
                                if (i2 != 1) {
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                                kotlin.o.b(obj2);
                            }
                            return u.a;
                        }
                    }
                    c0030a = new C0030a(continuation);
                    Object obj22 = c0030a.f1181f;
                    c2 = kotlin.coroutines.intrinsics.d.c();
                    i2 = c0030a.f1182g;
                    if (i2 != 0) {
                    }
                    return u.a;
                }
            }

            public b(Flow flow) {
                this.f1179f = flow;
            }

            @Override // kotlinx.coroutines.flow.Flow
            public Object a(FlowCollector flowCollector, Continuation continuation) {
                Object c2;
                Object a2 = this.f1179f.a(new a(flowCollector), continuation);
                c2 = kotlin.coroutines.intrinsics.d.c();
                return a2 == c2 ? a2 : u.a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        g(l<T> lVar, Continuation<? super g> continuation) {
            super(2, continuation);
            this.f1175h = lVar;
        }

        @Override // kotlin.coroutines.j.internal.BaseContinuationImpl
        public final Continuation<u> create(Object obj, Continuation<?> continuation) {
            g gVar = new g(this.f1175h, continuation);
            gVar.f1174g = obj;
            return gVar;
        }

        @Override // kotlin.jvm.functions.Function2
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public final Object invoke(FlowCollector<? super T> flowCollector, Continuation<? super u> continuation) {
            return ((g) create(flowCollector, continuation)).invokeSuspend(u.a);
        }

        @Override // kotlin.coroutines.j.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object c2;
            c2 = kotlin.coroutines.intrinsics.d.c();
            int i2 = this.f1173f;
            if (i2 == 0) {
                kotlin.o.b(obj);
                FlowCollector flowCollector = (FlowCollector) this.f1174g;
                androidx.datastore.core.m mVar = (androidx.datastore.core.m) ((l) this.f1175h).f1163k.getValue();
                if (!(mVar instanceof androidx.datastore.core.b)) {
                    ((l) this.f1175h).m.e(new b.a(mVar));
                }
                b bVar = new b(kotlinx.coroutines.flow.d.c(((l) this.f1175h).f1163k, new a(mVar, null)));
                this.f1173f = 1;
                if (kotlinx.coroutines.flow.d.d(flowCollector, bVar, this) == c2) {
                    return c2;
                }
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                kotlin.o.b(obj);
            }
            return u.a;
        }
    }

    /* compiled from: SingleProcessDataStore.kt */
    /* loaded from: classes.dex */
    static final class h extends Lambda implements Function0<File> {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ l<T> f1184f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        h(l<T> lVar) {
            super(0);
            this.f1184f = lVar;
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final File invoke() {
            File file = (File) ((l) this.f1184f).f1156d.invoke();
            String absolutePath = file.getAbsolutePath();
            a aVar = l.a;
            synchronized (aVar.b()) {
                if (!aVar.a().contains(absolutePath)) {
                    Set<String> a = aVar.a();
                    kotlin.jvm.internal.m.e(absolutePath, "it");
                    a.add(absolutePath);
                } else {
                    throw new IllegalStateException(("There are multiple DataStores active for the same file: " + file + ". You should either maintain your DataStore as a singleton or confirm that there is no two DataStore's active on the same file (by confirming that the scope is cancelled).").toString());
                }
            }
            return file;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SingleProcessDataStore.kt */
    @DebugMetadata(c = "androidx.datastore.core.SingleProcessDataStore", f = "SingleProcessDataStore.kt", l = {276, 281, 284}, m = "handleUpdate")
    /* loaded from: classes.dex */
    public static final class i extends ContinuationImpl {

        /* renamed from: f, reason: collision with root package name */
        Object f1185f;

        /* renamed from: g, reason: collision with root package name */
        Object f1186g;

        /* renamed from: h, reason: collision with root package name */
        Object f1187h;

        /* renamed from: i, reason: collision with root package name */
        /* synthetic */ Object f1188i;

        /* renamed from: j, reason: collision with root package name */
        final /* synthetic */ l<T> f1189j;

        /* renamed from: k, reason: collision with root package name */
        int f1190k;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        i(l<T> lVar, Continuation<? super i> continuation) {
            super(continuation);
            this.f1189j = lVar;
        }

        @Override // kotlin.coroutines.j.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f1188i = obj;
            this.f1190k |= Integer.MIN_VALUE;
            return this.f1189j.t(null, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SingleProcessDataStore.kt */
    @DebugMetadata(c = "androidx.datastore.core.SingleProcessDataStore", f = "SingleProcessDataStore.kt", l = {322, 348, 505}, m = "readAndInit")
    /* loaded from: classes.dex */
    public static final class j extends ContinuationImpl {

        /* renamed from: f, reason: collision with root package name */
        Object f1191f;

        /* renamed from: g, reason: collision with root package name */
        Object f1192g;

        /* renamed from: h, reason: collision with root package name */
        Object f1193h;

        /* renamed from: i, reason: collision with root package name */
        Object f1194i;

        /* renamed from: j, reason: collision with root package name */
        Object f1195j;

        /* renamed from: k, reason: collision with root package name */
        Object f1196k;
        /* synthetic */ Object l;
        final /* synthetic */ l<T> m;
        int n;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        j(l<T> lVar, Continuation<? super j> continuation) {
            super(continuation);
            this.m = lVar;
        }

        @Override // kotlin.coroutines.j.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.l = obj;
            this.n |= Integer.MIN_VALUE;
            return this.m.u(this);
        }
    }

    /* compiled from: SingleProcessDataStore.kt */
    /* loaded from: classes.dex */
    public static final class k implements androidx.datastore.core.h<T> {
        final /* synthetic */ Mutex a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ c0 f1197b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ f0<T> f1198c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ l<T> f1199d;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: SingleProcessDataStore.kt */
        @DebugMetadata(c = "androidx.datastore.core.SingleProcessDataStore$readAndInit$api$1", f = "SingleProcessDataStore.kt", l = {503, 337, 339}, m = "updateData")
        /* loaded from: classes.dex */
        public static final class a extends ContinuationImpl {

            /* renamed from: f, reason: collision with root package name */
            Object f1200f;

            /* renamed from: g, reason: collision with root package name */
            Object f1201g;

            /* renamed from: h, reason: collision with root package name */
            Object f1202h;

            /* renamed from: i, reason: collision with root package name */
            Object f1203i;

            /* renamed from: j, reason: collision with root package name */
            Object f1204j;

            /* renamed from: k, reason: collision with root package name */
            /* synthetic */ Object f1205k;
            int m;

            a(Continuation<? super a> continuation) {
                super(continuation);
            }

            @Override // kotlin.coroutines.j.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                this.f1205k = obj;
                this.m |= Integer.MIN_VALUE;
                return k.this.a(null, this);
            }
        }

        k(Mutex mutex, c0 c0Var, f0<T> f0Var, l<T> lVar) {
            this.a = mutex;
            this.f1197b = c0Var;
            this.f1198c = f0Var;
            this.f1199d = lVar;
        }

        /* JADX WARN: Removed duplicated region for block: B:30:0x00ba A[Catch: all -> 0x0056, TRY_LEAVE, TryCatch #0 {all -> 0x0056, blocks: (B:27:0x0052, B:28:0x00b2, B:30:0x00ba), top: B:26:0x0052 }] */
        /* JADX WARN: Removed duplicated region for block: B:35:0x00d0  */
        /* JADX WARN: Removed duplicated region for block: B:42:0x009a A[Catch: all -> 0x00df, TRY_LEAVE, TryCatch #2 {all -> 0x00df, blocks: (B:40:0x0096, B:42:0x009a, B:46:0x00d7, B:47:0x00de), top: B:39:0x0096 }] */
        /* JADX WARN: Removed duplicated region for block: B:46:0x00d7 A[Catch: all -> 0x00df, TRY_ENTER, TryCatch #2 {all -> 0x00df, blocks: (B:40:0x0096, B:42:0x009a, B:46:0x00d7, B:47:0x00de), top: B:39:0x0096 }] */
        /* JADX WARN: Removed duplicated region for block: B:50:0x0076  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0026  */
        @Override // androidx.datastore.core.h
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public Object a(Function2<? super T, ? super Continuation<? super T>, ? extends Object> function2, Continuation<? super T> continuation) {
            a aVar;
            Object c2;
            int i2;
            Mutex mutex;
            l lVar;
            c0 c0Var;
            f0<T> f0Var;
            Mutex mutex2;
            Mutex mutex3;
            l lVar2;
            T t;
            f0<T> f0Var2;
            try {
                if (continuation instanceof a) {
                    aVar = (a) continuation;
                    int i3 = aVar.m;
                    if ((i3 & Integer.MIN_VALUE) != 0) {
                        aVar.m = i3 - Integer.MIN_VALUE;
                        Object obj = aVar.f1205k;
                        c2 = kotlin.coroutines.intrinsics.d.c();
                        i2 = aVar.m;
                        if (i2 != 0) {
                            kotlin.o.b(obj);
                            mutex = this.a;
                            c0 c0Var2 = this.f1197b;
                            f0<T> f0Var3 = this.f1198c;
                            lVar = this.f1199d;
                            aVar.f1200f = function2;
                            aVar.f1201g = mutex;
                            aVar.f1202h = c0Var2;
                            aVar.f1203i = f0Var3;
                            aVar.f1204j = lVar;
                            aVar.m = 1;
                            if (mutex.b(null, aVar) == c2) {
                                return c2;
                            }
                            c0Var = c0Var2;
                            f0Var = f0Var3;
                        } else {
                            if (i2 != 1) {
                                if (i2 != 2) {
                                    if (i2 != 3) {
                                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                    }
                                    t = (T) aVar.f1202h;
                                    f0Var2 = (f0) aVar.f1201g;
                                    mutex2 = (Mutex) aVar.f1200f;
                                    try {
                                        kotlin.o.b(obj);
                                        f0Var2.f22943f = t;
                                        f0Var = f0Var2;
                                        T t2 = f0Var.f22943f;
                                        mutex2.c(null);
                                        return t2;
                                    } catch (Throwable th) {
                                        th = th;
                                        mutex2.c(null);
                                        throw th;
                                    }
                                }
                                l lVar3 = (l) aVar.f1202h;
                                f0Var = (f0) aVar.f1201g;
                                mutex3 = (Mutex) aVar.f1200f;
                                try {
                                    kotlin.o.b(obj);
                                    lVar2 = lVar3;
                                    if (kotlin.jvm.internal.m.a(obj, f0Var.f22943f)) {
                                        aVar.f1200f = mutex3;
                                        aVar.f1201g = f0Var;
                                        aVar.f1202h = obj;
                                        aVar.m = 3;
                                        if (lVar2.A(obj, aVar) == c2) {
                                            return c2;
                                        }
                                        t = (T) obj;
                                        f0Var2 = f0Var;
                                        mutex2 = mutex3;
                                        f0Var2.f22943f = t;
                                        f0Var = f0Var2;
                                        T t22 = f0Var.f22943f;
                                        mutex2.c(null);
                                        return t22;
                                    }
                                    mutex2 = mutex3;
                                    T t222 = f0Var.f22943f;
                                    mutex2.c(null);
                                    return t222;
                                } catch (Throwable th2) {
                                    th = th2;
                                    mutex2 = mutex3;
                                    mutex2.c(null);
                                    throw th;
                                }
                            }
                            l lVar4 = (l) aVar.f1204j;
                            f0Var = (f0) aVar.f1203i;
                            c0Var = (c0) aVar.f1202h;
                            Mutex mutex4 = (Mutex) aVar.f1201g;
                            Function2<? super T, ? super Continuation<? super T>, ? extends Object> function22 = (Function2) aVar.f1200f;
                            kotlin.o.b(obj);
                            mutex = mutex4;
                            lVar = lVar4;
                            function2 = function22;
                        }
                        if (c0Var.f22934f) {
                            T t3 = f0Var.f22943f;
                            aVar.f1200f = mutex;
                            aVar.f1201g = f0Var;
                            aVar.f1202h = lVar;
                            aVar.f1203i = null;
                            aVar.f1204j = null;
                            aVar.m = 2;
                            Object invoke = function2.invoke(t3, aVar);
                            if (invoke == c2) {
                                return c2;
                            }
                            mutex3 = mutex;
                            obj = invoke;
                            lVar2 = lVar;
                            if (kotlin.jvm.internal.m.a(obj, f0Var.f22943f)) {
                            }
                        } else {
                            throw new IllegalStateException("InitializerApi.updateData should not be called after initialization is complete.");
                        }
                    }
                }
                if (c0Var.f22934f) {
                }
            } catch (Throwable th3) {
                th = th3;
                mutex2 = mutex;
                mutex2.c(null);
                throw th;
            }
            aVar = new a(continuation);
            Object obj2 = aVar.f1205k;
            c2 = kotlin.coroutines.intrinsics.d.c();
            i2 = aVar.m;
            if (i2 != 0) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SingleProcessDataStore.kt */
    @DebugMetadata(c = "androidx.datastore.core.SingleProcessDataStore", f = "SingleProcessDataStore.kt", l = {302}, m = "readAndInitOrPropagateAndThrowFailure")
    /* renamed from: androidx.datastore.core.l$l, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0031l extends ContinuationImpl {

        /* renamed from: f, reason: collision with root package name */
        Object f1206f;

        /* renamed from: g, reason: collision with root package name */
        /* synthetic */ Object f1207g;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ l<T> f1208h;

        /* renamed from: i, reason: collision with root package name */
        int f1209i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C0031l(l<T> lVar, Continuation<? super C0031l> continuation) {
            super(continuation);
            this.f1208h = lVar;
        }

        @Override // kotlin.coroutines.j.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f1207g = obj;
            this.f1209i |= Integer.MIN_VALUE;
            return this.f1208h.v(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SingleProcessDataStore.kt */
    @DebugMetadata(c = "androidx.datastore.core.SingleProcessDataStore", f = "SingleProcessDataStore.kt", l = {311}, m = "readAndInitOrPropagateFailure")
    /* loaded from: classes.dex */
    public static final class m extends ContinuationImpl {

        /* renamed from: f, reason: collision with root package name */
        Object f1210f;

        /* renamed from: g, reason: collision with root package name */
        /* synthetic */ Object f1211g;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ l<T> f1212h;

        /* renamed from: i, reason: collision with root package name */
        int f1213i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        m(l<T> lVar, Continuation<? super m> continuation) {
            super(continuation);
            this.f1212h = lVar;
        }

        @Override // kotlin.coroutines.j.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f1211g = obj;
            this.f1213i |= Integer.MIN_VALUE;
            return this.f1212h.w(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SingleProcessDataStore.kt */
    @DebugMetadata(c = "androidx.datastore.core.SingleProcessDataStore", f = "SingleProcessDataStore.kt", l = {381}, m = "readData")
    /* loaded from: classes.dex */
    public static final class n extends ContinuationImpl {

        /* renamed from: f, reason: collision with root package name */
        Object f1214f;

        /* renamed from: g, reason: collision with root package name */
        Object f1215g;

        /* renamed from: h, reason: collision with root package name */
        Object f1216h;

        /* renamed from: i, reason: collision with root package name */
        /* synthetic */ Object f1217i;

        /* renamed from: j, reason: collision with root package name */
        final /* synthetic */ l<T> f1218j;

        /* renamed from: k, reason: collision with root package name */
        int f1219k;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        n(l<T> lVar, Continuation<? super n> continuation) {
            super(continuation);
            this.f1218j = lVar;
        }

        @Override // kotlin.coroutines.j.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f1217i = obj;
            this.f1219k |= Integer.MIN_VALUE;
            return this.f1218j.x(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SingleProcessDataStore.kt */
    @DebugMetadata(c = "androidx.datastore.core.SingleProcessDataStore", f = "SingleProcessDataStore.kt", l = {359, 362, 365}, m = "readDataOrHandleCorruption")
    /* loaded from: classes.dex */
    public static final class o extends ContinuationImpl {

        /* renamed from: f, reason: collision with root package name */
        Object f1220f;

        /* renamed from: g, reason: collision with root package name */
        Object f1221g;

        /* renamed from: h, reason: collision with root package name */
        /* synthetic */ Object f1222h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ l<T> f1223i;

        /* renamed from: j, reason: collision with root package name */
        int f1224j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        o(l<T> lVar, Continuation<? super o> continuation) {
            super(continuation);
            this.f1223i = lVar;
        }

        @Override // kotlin.coroutines.j.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f1222h = obj;
            this.f1224j |= Integer.MIN_VALUE;
            return this.f1223i.y(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SingleProcessDataStore.kt */
    @DebugMetadata(c = "androidx.datastore.core.SingleProcessDataStore", f = "SingleProcessDataStore.kt", l = {402, 410}, m = "transformAndWrite")
    /* loaded from: classes.dex */
    public static final class p extends ContinuationImpl {

        /* renamed from: f, reason: collision with root package name */
        Object f1225f;

        /* renamed from: g, reason: collision with root package name */
        Object f1226g;

        /* renamed from: h, reason: collision with root package name */
        Object f1227h;

        /* renamed from: i, reason: collision with root package name */
        /* synthetic */ Object f1228i;

        /* renamed from: j, reason: collision with root package name */
        final /* synthetic */ l<T> f1229j;

        /* renamed from: k, reason: collision with root package name */
        int f1230k;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        p(l<T> lVar, Continuation<? super p> continuation) {
            super(continuation);
            this.f1229j = lVar;
        }

        @Override // kotlin.coroutines.j.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f1228i = obj;
            this.f1230k |= Integer.MIN_VALUE;
            return this.f1229j.z(null, null, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SingleProcessDataStore.kt */
    @DebugMetadata(c = "androidx.datastore.core.SingleProcessDataStore$transformAndWrite$newData$1", f = "SingleProcessDataStore.kt", l = {402}, m = "invokeSuspend")
    /* loaded from: classes.dex */
    public static final class q extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super T>, Object> {

        /* renamed from: f, reason: collision with root package name */
        int f1231f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ Function2<T, Continuation<? super T>, Object> f1232g;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ T f1233h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        q(Function2<? super T, ? super Continuation<? super T>, ? extends Object> function2, T t, Continuation<? super q> continuation) {
            super(2, continuation);
            this.f1232g = function2;
            this.f1233h = t;
        }

        @Override // kotlin.coroutines.j.internal.BaseContinuationImpl
        public final Continuation<u> create(Object obj, Continuation<?> continuation) {
            return new q(this.f1232g, this.f1233h, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super T> continuation) {
            return ((q) create(coroutineScope, continuation)).invokeSuspend(u.a);
        }

        @Override // kotlin.coroutines.j.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object c2;
            c2 = kotlin.coroutines.intrinsics.d.c();
            int i2 = this.f1231f;
            if (i2 == 0) {
                kotlin.o.b(obj);
                Function2<T, Continuation<? super T>, Object> function2 = this.f1232g;
                T t = this.f1233h;
                this.f1231f = 1;
                obj = function2.invoke(t, this);
                if (obj == c2) {
                    return c2;
                }
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                kotlin.o.b(obj);
            }
            return obj;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SingleProcessDataStore.kt */
    @DebugMetadata(c = "androidx.datastore.core.SingleProcessDataStore", f = "SingleProcessDataStore.kt", l = {426}, m = "writeData$datastore_core")
    /* loaded from: classes.dex */
    public static final class r extends ContinuationImpl {

        /* renamed from: f, reason: collision with root package name */
        Object f1234f;

        /* renamed from: g, reason: collision with root package name */
        Object f1235g;

        /* renamed from: h, reason: collision with root package name */
        Object f1236h;

        /* renamed from: i, reason: collision with root package name */
        Object f1237i;

        /* renamed from: j, reason: collision with root package name */
        Object f1238j;

        /* renamed from: k, reason: collision with root package name */
        /* synthetic */ Object f1239k;
        final /* synthetic */ l<T> l;
        int m;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        r(l<T> lVar, Continuation<? super r> continuation) {
            super(continuation);
            this.l = lVar;
        }

        @Override // kotlin.coroutines.j.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f1239k = obj;
            this.m |= Integer.MIN_VALUE;
            return this.l.A(null, this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public l(Function0<? extends File> function0, androidx.datastore.core.j<T> jVar, List<? extends Function2<? super androidx.datastore.core.h<T>, ? super Continuation<? super u>, ? extends Object>> list, androidx.datastore.core.a<T> aVar, CoroutineScope coroutineScope) {
        Lazy b2;
        List<? extends Function2<? super androidx.datastore.core.h<T>, ? super Continuation<? super u>, ? extends Object>> E0;
        kotlin.jvm.internal.m.f(function0, "produceFile");
        kotlin.jvm.internal.m.f(jVar, "serializer");
        kotlin.jvm.internal.m.f(list, "initTasksList");
        kotlin.jvm.internal.m.f(aVar, "corruptionHandler");
        kotlin.jvm.internal.m.f(coroutineScope, "scope");
        this.f1156d = function0;
        this.f1157e = jVar;
        this.f1158f = aVar;
        this.f1159g = coroutineScope;
        this.f1160h = kotlinx.coroutines.flow.d.g(new g(this, null));
        this.f1161i = ".tmp";
        b2 = kotlin.i.b(new h(this));
        this.f1162j = b2;
        this.f1163k = kotlinx.coroutines.flow.o.a(androidx.datastore.core.n.a);
        E0 = kotlin.collections.c0.E0(list);
        this.l = E0;
        this.m = new androidx.datastore.core.k<>(coroutineScope, new d(this), e.f1169f, new f(this, null));
    }

    private final void q(File file) {
        File parentFile = file.getCanonicalFile().getParentFile();
        if (parentFile == null) {
            return;
        }
        parentFile.mkdirs();
        if (!parentFile.isDirectory()) {
            throw new IOException(kotlin.jvm.internal.m.n("Unable to create parent directories of ", file));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final File r() {
        return (File) this.f1162j.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object s(b.a<T> aVar, Continuation<? super u> continuation) {
        Object c2;
        Object c3;
        androidx.datastore.core.m<T> value = this.f1163k.getValue();
        if (!(value instanceof androidx.datastore.core.b)) {
            if (value instanceof androidx.datastore.core.i) {
                if (value == aVar.a()) {
                    Object w = w(continuation);
                    c3 = kotlin.coroutines.intrinsics.d.c();
                    return w == c3 ? w : u.a;
                }
            } else {
                if (kotlin.jvm.internal.m.a(value, androidx.datastore.core.n.a)) {
                    Object w2 = w(continuation);
                    c2 = kotlin.coroutines.intrinsics.d.c();
                    return w2 == c2 ? w2 : u.a;
                }
                if (value instanceof androidx.datastore.core.g) {
                    throw new IllegalStateException("Can't read in final state.".toString());
                }
            }
        }
        return u.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't wrap try/catch for region: R(13:1|(2:3|(10:5|6|7|(5:(1:(1:(1:12)(2:19|20))(3:21|22|23))(1:28)|13|14|15|16)(4:29|30|31|(6:33|(1:35)|26|14|15|16)(3:36|(1:38)(1:54)|(2:40|(2:42|(1:44)(1:45))(2:46|47))(2:48|(2:50|51)(2:52|53))))|24|(1:27)|26|14|15|16))|59|6|7|(0)(0)|24|(0)|26|14|15|16|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0052, code lost:
    
        r10 = th;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00b7 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0025  */
    /* JADX WARN: Type inference failed for: r8v0, types: [androidx.datastore.core.l, java.lang.Object, androidx.datastore.core.l<T>] */
    /* JADX WARN: Type inference failed for: r9v20, types: [kotlinx.coroutines.w] */
    /* JADX WARN: Type inference failed for: r9v3, types: [kotlinx.coroutines.w] */
    /* JADX WARN: Type inference failed for: r9v33 */
    /* JADX WARN: Type inference failed for: r9v34 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object t(b.C0029b<T> c0029b, Continuation<? super u> continuation) {
        i iVar;
        Object c2;
        int i2;
        Object a2;
        ?? r9;
        CompletableDeferred<T> a3;
        androidx.datastore.core.m<T> value;
        l lVar;
        Object z;
        b.C0029b<T> c0029b2;
        b.C0029b<T> c0029b3;
        if (continuation instanceof i) {
            iVar = (i) continuation;
            int i3 = iVar.f1190k;
            if ((i3 & Integer.MIN_VALUE) != 0) {
                iVar.f1190k = i3 - Integer.MIN_VALUE;
                Object obj = iVar.f1188i;
                c2 = kotlin.coroutines.intrinsics.d.c();
                i2 = iVar.f1190k;
                boolean z2 = true;
                if (i2 != 0) {
                    kotlin.o.b(obj);
                    a3 = c0029b.a();
                    try {
                        Result.a aVar = Result.f25108f;
                        value = this.f1163k.getValue();
                    } catch (Throwable th) {
                        th = th;
                        c0029b = a3;
                        Result.a aVar2 = Result.f25108f;
                        a2 = Result.a(kotlin.o.a(th));
                        r9 = c0029b;
                        y.c(r9, a2);
                        return u.a;
                    }
                    if (value instanceof androidx.datastore.core.b) {
                        Function2<T, Continuation<? super T>, Object> d2 = c0029b.d();
                        CoroutineContext b2 = c0029b.b();
                        iVar.f1185f = a3;
                        iVar.f1190k = 1;
                        z = z(d2, b2, iVar);
                        if (z == c2) {
                            return c2;
                        }
                        b.C0029b<T> c0029b4 = a3;
                        obj = z;
                        c0029b = c0029b4;
                        a2 = Result.a(obj);
                        r9 = c0029b;
                        y.c(r9, a2);
                        return u.a;
                    }
                    if (!(value instanceof androidx.datastore.core.i)) {
                        z2 = value instanceof androidx.datastore.core.n;
                    }
                    if (z2) {
                        if (value == c0029b.c()) {
                            iVar.f1185f = c0029b;
                            iVar.f1186g = this;
                            iVar.f1187h = a3;
                            iVar.f1190k = 2;
                            if (v(iVar) == c2) {
                                return c2;
                            }
                            lVar = this;
                            c0029b2 = c0029b;
                        } else {
                            throw ((androidx.datastore.core.i) value).a();
                        }
                    } else {
                        if (value instanceof androidx.datastore.core.g) {
                            throw ((androidx.datastore.core.g) value).a();
                        }
                        throw new NoWhenBranchMatchedException();
                    }
                } else {
                    if (i2 == 1) {
                        c0029b3 = (CompletableDeferred) iVar.f1185f;
                    } else if (i2 == 2) {
                        CompletableDeferred<T> completableDeferred = (CompletableDeferred) iVar.f1187h;
                        lVar = (l) iVar.f1186g;
                        b.C0029b<T> c0029b5 = (b.C0029b) iVar.f1185f;
                        kotlin.o.b(obj);
                        a3 = completableDeferred;
                        c0029b2 = c0029b5;
                    } else {
                        if (i2 != 3) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        c0029b3 = (b.C0029b<T>) ((CompletableDeferred) iVar.f1185f);
                    }
                    kotlin.o.b(obj);
                    c0029b = c0029b3;
                    a2 = Result.a(obj);
                    r9 = c0029b;
                    y.c(r9, a2);
                    return u.a;
                }
                Function2<T, Continuation<? super T>, Object> d3 = c0029b2.d();
                CoroutineContext b3 = c0029b2.b();
                iVar.f1185f = a3;
                iVar.f1186g = null;
                iVar.f1187h = null;
                iVar.f1190k = 3;
                z = lVar.z(d3, b3, iVar);
                if (z == c2) {
                    return c2;
                }
                b.C0029b<T> c0029b42 = a3;
                obj = z;
                c0029b = c0029b42;
                a2 = Result.a(obj);
                r9 = c0029b;
                y.c(r9, a2);
                return u.a;
            }
        }
        iVar = new i(this, continuation);
        Object obj2 = iVar.f1188i;
        c2 = kotlin.coroutines.intrinsics.d.c();
        i2 = iVar.f1190k;
        boolean z22 = true;
        if (i2 != 0) {
        }
        Function2<T, Continuation<? super T>, Object> d32 = c0029b2.d();
        CoroutineContext b32 = c0029b2.b();
        iVar.f1185f = a3;
        iVar.f1186g = null;
        iVar.f1187h = null;
        iVar.f1190k = 3;
        z = lVar.z(d32, b32, iVar);
        if (z == c2) {
        }
        b.C0029b<T> c0029b422 = a3;
        obj2 = z;
        c0029b = c0029b422;
        a2 = Result.a(obj2);
        r9 = c0029b;
        y.c(r9, a2);
        return u.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0114 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0115  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0027  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object u(Continuation<? super u> continuation) {
        j jVar;
        Object c2;
        int i2;
        Mutex b2;
        f0 f0Var;
        l<T> lVar;
        f0 f0Var2;
        List<? extends Function2<? super androidx.datastore.core.h<T>, ? super Continuation<? super u>, ? extends Object>> list;
        l<T> lVar2;
        f0 f0Var3;
        k kVar;
        Iterator<T> it;
        Mutex mutex;
        c0 c0Var;
        Object obj;
        Mutex mutex2;
        j jVar2;
        l<T> lVar3;
        f0 f0Var4;
        c0 c0Var2;
        if (continuation instanceof j) {
            jVar = (j) continuation;
            int i3 = jVar.n;
            if ((i3 & Integer.MIN_VALUE) != 0) {
                jVar.n = i3 - Integer.MIN_VALUE;
                T t = (T) jVar.l;
                c2 = kotlin.coroutines.intrinsics.d.c();
                i2 = jVar.n;
                if (i2 != 0) {
                    kotlin.o.b(t);
                    if (kotlin.jvm.internal.m.a(this.f1163k.getValue(), androidx.datastore.core.n.a) || (this.f1163k.getValue() instanceof androidx.datastore.core.i)) {
                        b2 = kotlinx.coroutines.sync.d.b(false, 1, null);
                        f0Var = new f0();
                        jVar.f1191f = this;
                        jVar.f1192g = b2;
                        jVar.f1193h = f0Var;
                        jVar.f1194i = f0Var;
                        jVar.n = 1;
                        t = (T) y(jVar);
                        if (t == c2) {
                            return c2;
                        }
                        lVar = this;
                        f0Var2 = f0Var;
                    } else {
                        throw new IllegalStateException("Check failed.".toString());
                    }
                } else {
                    if (i2 != 1) {
                        if (i2 != 2) {
                            if (i2 != 3) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            mutex2 = (Mutex) jVar.f1194i;
                            c0Var2 = (c0) jVar.f1193h;
                            f0Var4 = (f0) jVar.f1192g;
                            lVar3 = (l) jVar.f1191f;
                            kotlin.o.b(t);
                            try {
                                c0Var2.f22934f = true;
                                u uVar = u.a;
                                mutex2.c(null);
                                MutableStateFlow<androidx.datastore.core.m<T>> mutableStateFlow = lVar3.f1163k;
                                T t2 = f0Var4.f22943f;
                                mutableStateFlow.setValue(new androidx.datastore.core.b(t2, t2 != null ? t2.hashCode() : 0));
                                return uVar;
                            } catch (Throwable th) {
                                mutex2.c(null);
                                throw th;
                            }
                        }
                        it = (Iterator) jVar.f1196k;
                        kVar = (k) jVar.f1195j;
                        c0Var = (c0) jVar.f1194i;
                        f0Var3 = (f0) jVar.f1193h;
                        mutex = (Mutex) jVar.f1192g;
                        lVar2 = (l) jVar.f1191f;
                        kotlin.o.b(t);
                        while (it.hasNext()) {
                            Function2 function2 = (Function2) it.next();
                            jVar.f1191f = lVar2;
                            jVar.f1192g = mutex;
                            jVar.f1193h = f0Var3;
                            jVar.f1194i = c0Var;
                            jVar.f1195j = kVar;
                            jVar.f1196k = it;
                            jVar.n = 2;
                            if (function2.invoke(kVar, jVar) == c2) {
                                return c2;
                            }
                        }
                        jVar2 = jVar;
                        obj = c2;
                        f0Var2 = f0Var3;
                        mutex2 = mutex;
                        lVar3 = lVar2;
                        lVar3.l = null;
                        jVar2.f1191f = lVar3;
                        jVar2.f1192g = f0Var2;
                        jVar2.f1193h = c0Var;
                        jVar2.f1194i = mutex2;
                        jVar2.f1195j = null;
                        jVar2.f1196k = null;
                        jVar2.n = 3;
                        if (mutex2.b(null, jVar2) == obj) {
                            return obj;
                        }
                        f0Var4 = f0Var2;
                        c0Var2 = c0Var;
                        c0Var2.f22934f = true;
                        u uVar2 = u.a;
                        mutex2.c(null);
                        MutableStateFlow<androidx.datastore.core.m<T>> mutableStateFlow2 = lVar3.f1163k;
                        T t22 = f0Var4.f22943f;
                        mutableStateFlow2.setValue(new androidx.datastore.core.b(t22, t22 != null ? t22.hashCode() : 0));
                        return uVar2;
                    }
                    f0Var = (f0) jVar.f1194i;
                    f0Var2 = (f0) jVar.f1193h;
                    b2 = (Mutex) jVar.f1192g;
                    lVar = (l) jVar.f1191f;
                    kotlin.o.b(t);
                }
                f0Var.f22943f = t;
                c0 c0Var3 = new c0();
                k kVar2 = new k(b2, c0Var3, f0Var2, lVar);
                list = lVar.l;
                if (list == null) {
                    lVar2 = lVar;
                    f0Var3 = f0Var2;
                    kVar = kVar2;
                    it = list.iterator();
                    mutex = b2;
                    c0Var = c0Var3;
                    while (it.hasNext()) {
                    }
                    jVar2 = jVar;
                    obj = c2;
                    f0Var2 = f0Var3;
                    mutex2 = mutex;
                    lVar3 = lVar2;
                    lVar3.l = null;
                    jVar2.f1191f = lVar3;
                    jVar2.f1192g = f0Var2;
                    jVar2.f1193h = c0Var;
                    jVar2.f1194i = mutex2;
                    jVar2.f1195j = null;
                    jVar2.f1196k = null;
                    jVar2.n = 3;
                    if (mutex2.b(null, jVar2) == obj) {
                    }
                } else {
                    obj = c2;
                    mutex2 = b2;
                    c0Var = c0Var3;
                    jVar2 = jVar;
                    lVar3 = lVar;
                    lVar3.l = null;
                    jVar2.f1191f = lVar3;
                    jVar2.f1192g = f0Var2;
                    jVar2.f1193h = c0Var;
                    jVar2.f1194i = mutex2;
                    jVar2.f1195j = null;
                    jVar2.f1196k = null;
                    jVar2.n = 3;
                    if (mutex2.b(null, jVar2) == obj) {
                    }
                }
            }
        }
        jVar = new j(this, continuation);
        T t3 = (T) jVar.l;
        c2 = kotlin.coroutines.intrinsics.d.c();
        i2 = jVar.n;
        if (i2 != 0) {
        }
        f0Var.f22943f = t3;
        c0 c0Var32 = new c0();
        k kVar22 = new k(b2, c0Var32, f0Var2, lVar);
        list = lVar.l;
        if (list == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object v(Continuation<? super u> continuation) {
        C0031l c0031l;
        Object c2;
        int i2;
        l<T> lVar;
        if (continuation instanceof C0031l) {
            c0031l = (C0031l) continuation;
            int i3 = c0031l.f1209i;
            if ((i3 & Integer.MIN_VALUE) != 0) {
                c0031l.f1209i = i3 - Integer.MIN_VALUE;
                Object obj = c0031l.f1207g;
                c2 = kotlin.coroutines.intrinsics.d.c();
                i2 = c0031l.f1209i;
                if (i2 != 0) {
                    kotlin.o.b(obj);
                    try {
                        c0031l.f1206f = this;
                        c0031l.f1209i = 1;
                        if (u(c0031l) == c2) {
                            return c2;
                        }
                    } catch (Throwable th) {
                        th = th;
                        lVar = this;
                        lVar.f1163k.setValue(new androidx.datastore.core.i(th));
                        throw th;
                    }
                } else {
                    if (i2 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    lVar = (l) c0031l.f1206f;
                    try {
                        kotlin.o.b(obj);
                    } catch (Throwable th2) {
                        th = th2;
                        lVar.f1163k.setValue(new androidx.datastore.core.i(th));
                        throw th;
                    }
                }
                return u.a;
            }
        }
        c0031l = new C0031l(this, continuation);
        Object obj2 = c0031l.f1207g;
        c2 = kotlin.coroutines.intrinsics.d.c();
        i2 = c0031l.f1209i;
        if (i2 != 0) {
        }
        return u.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object w(Continuation<? super u> continuation) {
        m mVar;
        Object c2;
        int i2;
        l<T> lVar;
        if (continuation instanceof m) {
            mVar = (m) continuation;
            int i3 = mVar.f1213i;
            if ((i3 & Integer.MIN_VALUE) != 0) {
                mVar.f1213i = i3 - Integer.MIN_VALUE;
                Object obj = mVar.f1211g;
                c2 = kotlin.coroutines.intrinsics.d.c();
                i2 = mVar.f1213i;
                if (i2 != 0) {
                    kotlin.o.b(obj);
                    try {
                        mVar.f1210f = this;
                        mVar.f1213i = 1;
                        if (u(mVar) == c2) {
                            return c2;
                        }
                    } catch (Throwable th) {
                        th = th;
                        lVar = this;
                        lVar.f1163k.setValue(new androidx.datastore.core.i(th));
                        return u.a;
                    }
                } else {
                    if (i2 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    lVar = (l) mVar.f1210f;
                    try {
                        kotlin.o.b(obj);
                    } catch (Throwable th2) {
                        th = th2;
                        lVar.f1163k.setValue(new androidx.datastore.core.i(th));
                        return u.a;
                    }
                }
                return u.a;
            }
        }
        mVar = new m(this, continuation);
        Object obj2 = mVar.f1211g;
        c2 = kotlin.coroutines.intrinsics.d.c();
        i2 = mVar.f1213i;
        if (i2 != 0) {
        }
        return u.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:26:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0023  */
    /* JADX WARN: Type inference failed for: r0v12, types: [androidx.datastore.core.l] */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v2, types: [kotlin.y.d, androidx.datastore.core.l$n] */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4, types: [androidx.datastore.core.l] */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.lang.Object, java.io.FileInputStream, java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r2v5, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r4v0, types: [androidx.datastore.core.j<T>, androidx.datastore.core.j] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object x(Continuation<? super T> continuation) {
        ?? r0;
        Object c2;
        int i2;
        ?? fileInputStream;
        Throwable th;
        Closeable closeable;
        try {
            if (continuation instanceof n) {
                n nVar = (n) continuation;
                int i3 = nVar.f1219k;
                if ((i3 & Integer.MIN_VALUE) != 0) {
                    nVar.f1219k = i3 - Integer.MIN_VALUE;
                    r0 = nVar;
                    Object obj = r0.f1217i;
                    c2 = kotlin.coroutines.intrinsics.d.c();
                    i2 = r0.f1219k;
                    if (i2 != 0) {
                        kotlin.o.b(obj);
                        try {
                            fileInputStream = new FileInputStream(r());
                            try {
                                androidx.datastore.core.j<T> jVar = this.f1157e;
                                r0.f1214f = this;
                                r0.f1215g = fileInputStream;
                                r0.f1216h = null;
                                r0.f1219k = 1;
                                Object c3 = jVar.c(fileInputStream, r0);
                                if (c3 == c2) {
                                    return c2;
                                }
                                th = null;
                                obj = c3;
                                closeable = fileInputStream;
                            } catch (Throwable th2) {
                                th = th2;
                                r0 = this;
                                throw th;
                            }
                        } catch (FileNotFoundException e2) {
                            e = e2;
                            r0 = this;
                            if (!r0.r().exists()) {
                                return r0.f1157e.a();
                            }
                            throw e;
                        }
                    } else {
                        if (i2 != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        th = (Throwable) r0.f1216h;
                        fileInputStream = (Closeable) r0.f1215g;
                        r0 = (l) r0.f1214f;
                        try {
                            kotlin.o.b(obj);
                            closeable = fileInputStream;
                        } catch (Throwable th3) {
                            th = th3;
                            try {
                                throw th;
                            } finally {
                                kotlin.io.a.a(fileInputStream, th);
                            }
                        }
                    }
                    return obj;
                }
            }
            if (i2 != 0) {
            }
            return obj;
        } catch (FileNotFoundException e3) {
            e = e3;
        }
        r0 = new n(this, continuation);
        Object obj2 = r0.f1217i;
        c2 = kotlin.coroutines.intrinsics.d.c();
        i2 = r0.f1219k;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0085 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0074 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object y(Continuation<? super T> continuation) {
        o oVar;
        Object c2;
        int i2;
        l lVar;
        Object a2;
        CorruptionException corruptionException;
        l lVar2;
        CorruptionException corruptionException2;
        if (continuation instanceof o) {
            oVar = (o) continuation;
            int i3 = oVar.f1224j;
            if ((i3 & Integer.MIN_VALUE) != 0) {
                oVar.f1224j = i3 - Integer.MIN_VALUE;
                Object obj = oVar.f1222h;
                c2 = kotlin.coroutines.intrinsics.d.c();
                i2 = oVar.f1224j;
                if (i2 != 0) {
                    kotlin.o.b(obj);
                    try {
                        oVar.f1220f = this;
                        oVar.f1224j = 1;
                        obj = x(oVar);
                        if (obj == c2) {
                            return c2;
                        }
                    } catch (CorruptionException e2) {
                        e = e2;
                        lVar = this;
                        androidx.datastore.core.a<T> aVar = lVar.f1158f;
                        oVar.f1220f = lVar;
                        oVar.f1221g = e;
                        oVar.f1224j = 2;
                        a2 = aVar.a(e, oVar);
                        if (a2 != c2) {
                        }
                    }
                } else {
                    if (i2 != 1) {
                        if (i2 != 2) {
                            if (i2 != 3) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            Object obj2 = oVar.f1221g;
                            corruptionException2 = (CorruptionException) oVar.f1220f;
                            try {
                                kotlin.o.b(obj);
                                return obj2;
                            } catch (IOException e3) {
                                e = e3;
                                kotlin.b.a(corruptionException2, e);
                                throw corruptionException2;
                            }
                        }
                        corruptionException = (CorruptionException) oVar.f1221g;
                        l lVar3 = (l) oVar.f1220f;
                        kotlin.o.b(obj);
                        lVar2 = lVar3;
                        try {
                            oVar.f1220f = corruptionException;
                            oVar.f1221g = obj;
                            oVar.f1224j = 3;
                            return lVar2.A(obj, oVar) != c2 ? c2 : obj;
                        } catch (IOException e4) {
                            e = e4;
                            corruptionException2 = corruptionException;
                            kotlin.b.a(corruptionException2, e);
                            throw corruptionException2;
                        }
                    }
                    lVar = (l) oVar.f1220f;
                    try {
                        kotlin.o.b(obj);
                    } catch (CorruptionException e5) {
                        e = e5;
                        androidx.datastore.core.a<T> aVar2 = lVar.f1158f;
                        oVar.f1220f = lVar;
                        oVar.f1221g = e;
                        oVar.f1224j = 2;
                        a2 = aVar2.a(e, oVar);
                        if (a2 != c2) {
                            return c2;
                        }
                        l lVar4 = lVar;
                        corruptionException = e;
                        obj = a2;
                        lVar2 = lVar4;
                        oVar.f1220f = corruptionException;
                        oVar.f1221g = obj;
                        oVar.f1224j = 3;
                        if (lVar2.A(obj, oVar) != c2) {
                        }
                    }
                }
                return obj;
            }
        }
        oVar = new o(this, continuation);
        Object obj3 = oVar.f1222h;
        c2 = kotlin.coroutines.intrinsics.d.c();
        i2 = oVar.f1224j;
        if (i2 != 0) {
        }
        return obj3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object z(Function2<? super T, ? super Continuation<? super T>, ? extends Object> function2, CoroutineContext coroutineContext, Continuation<? super T> continuation) {
        p pVar;
        Object obj;
        Object c2;
        int i2;
        androidx.datastore.core.b bVar;
        Object obj2;
        l lVar;
        l lVar2;
        if (continuation instanceof p) {
            pVar = (p) continuation;
            int i3 = pVar.f1230k;
            if ((i3 & Integer.MIN_VALUE) != 0) {
                pVar.f1230k = i3 - Integer.MIN_VALUE;
                obj = pVar.f1228i;
                c2 = kotlin.coroutines.intrinsics.d.c();
                i2 = pVar.f1230k;
                if (i2 != 0) {
                    kotlin.o.b(obj);
                    androidx.datastore.core.b bVar2 = (androidx.datastore.core.b) this.f1163k.getValue();
                    bVar2.a();
                    Object b2 = bVar2.b();
                    q qVar = new q(function2, b2, null);
                    pVar.f1225f = this;
                    pVar.f1226g = bVar2;
                    pVar.f1227h = b2;
                    pVar.f1230k = 1;
                    Object e2 = kotlinx.coroutines.h.e(coroutineContext, qVar, pVar);
                    if (e2 == c2) {
                        return c2;
                    }
                    bVar = bVar2;
                    obj = e2;
                    obj2 = b2;
                    lVar = this;
                } else {
                    if (i2 != 1) {
                        if (i2 != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        obj2 = pVar.f1226g;
                        lVar2 = (l) pVar.f1225f;
                        kotlin.o.b(obj);
                        lVar2.f1163k.setValue(new androidx.datastore.core.b(obj2, obj2 == null ? obj2.hashCode() : 0));
                        return obj2;
                    }
                    obj2 = pVar.f1227h;
                    bVar = (androidx.datastore.core.b) pVar.f1226g;
                    l lVar3 = (l) pVar.f1225f;
                    kotlin.o.b(obj);
                    lVar = lVar3;
                }
                bVar.a();
                if (!kotlin.jvm.internal.m.a(obj2, obj)) {
                    pVar.f1225f = lVar;
                    pVar.f1226g = obj;
                    pVar.f1227h = null;
                    pVar.f1230k = 2;
                    if (lVar.A(obj, pVar) == c2) {
                        return c2;
                    }
                    obj2 = obj;
                    lVar2 = lVar;
                    lVar2.f1163k.setValue(new androidx.datastore.core.b(obj2, obj2 == null ? obj2.hashCode() : 0));
                }
                return obj2;
            }
        }
        pVar = new p(this, continuation);
        obj = pVar.f1228i;
        c2 = kotlin.coroutines.intrinsics.d.c();
        i2 = pVar.f1230k;
        if (i2 != 0) {
        }
        bVar.a();
        if (!kotlin.jvm.internal.m.a(obj2, obj)) {
        }
        return obj2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:16:0x009f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00a0 A[Catch: IOException -> 0x00c4, TryCatch #1 {IOException -> 0x00c4, blocks: (B:14:0x0092, B:18:0x00a0, B:19:0x00bb, B:26:0x00c0, B:27:0x00c3, B:23:0x00be), top: B:7:0x0021, inners: #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0023  */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.io.FileOutputStream, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v5, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v7, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r2v9, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v10 */
    /* JADX WARN: Type inference failed for: r3v2 */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v4 */
    /* JADX WARN: Type inference failed for: r3v5 */
    /* JADX WARN: Type inference failed for: r3v6, types: [java.lang.Object, java.io.File] */
    /* JADX WARN: Type inference failed for: r3v8, types: [java.io.File] */
    /* JADX WARN: Type inference failed for: r9v9, types: [java.lang.StringBuilder] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object A(T t, Continuation<? super u> continuation) {
        r rVar;
        Object c2;
        int i2;
        ?? r3;
        File file;
        ?? fileOutputStream;
        l<T> lVar;
        FileOutputStream fileOutputStream2;
        Throwable th;
        try {
            if (continuation instanceof r) {
                rVar = (r) continuation;
                int i3 = rVar.m;
                if ((i3 & Integer.MIN_VALUE) != 0) {
                    rVar.m = i3 - Integer.MIN_VALUE;
                    Object obj = rVar.f1239k;
                    c2 = kotlin.coroutines.intrinsics.d.c();
                    i2 = rVar.m;
                    r3 = 1;
                    if (i2 != 0) {
                        kotlin.o.b(obj);
                        q(r());
                        file = new File(kotlin.jvm.internal.m.n(r().getAbsolutePath(), this.f1161i));
                        try {
                            fileOutputStream = new FileOutputStream(file);
                            try {
                                androidx.datastore.core.j<T> jVar = this.f1157e;
                                c cVar = new c(fileOutputStream);
                                rVar.f1234f = this;
                                rVar.f1235g = file;
                                rVar.f1236h = fileOutputStream;
                                rVar.f1237i = null;
                                rVar.f1238j = fileOutputStream;
                                rVar.m = 1;
                                if (jVar.b(t, cVar, rVar) == c2) {
                                    return c2;
                                }
                                lVar = this;
                                r3 = file;
                                fileOutputStream2 = fileOutputStream;
                                th = null;
                                fileOutputStream = fileOutputStream;
                            } catch (Throwable th2) {
                                th = th2;
                                r3 = file;
                                throw th;
                            }
                        } catch (IOException e2) {
                            e = e2;
                            if (file.exists()) {
                                file.delete();
                            }
                            throw e;
                        }
                    } else {
                        if (i2 != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        fileOutputStream2 = (FileOutputStream) rVar.f1238j;
                        th = (Throwable) rVar.f1237i;
                        fileOutputStream = (Closeable) rVar.f1236h;
                        r3 = (File) rVar.f1235g;
                        lVar = (l) rVar.f1234f;
                        try {
                            kotlin.o.b(obj);
                            fileOutputStream = fileOutputStream;
                            r3 = r3;
                        } catch (Throwable th3) {
                            th = th3;
                            try {
                                throw th;
                            } catch (Throwable th4) {
                                kotlin.io.a.a(fileOutputStream, th);
                                throw th4;
                            }
                        }
                    }
                    fileOutputStream2.getFD().sync();
                    u uVar = u.a;
                    kotlin.io.a.a(fileOutputStream, th);
                    if (!r3.renameTo(lVar.r())) {
                        return uVar;
                    }
                    throw new IOException("Unable to rename " + r3 + ".This likely means that there are multiple instances of DataStore for this file. Ensure that you are only creating a single instance of datastore for this file.");
                }
            }
            if (i2 != 0) {
            }
            fileOutputStream2.getFD().sync();
            u uVar2 = u.a;
            kotlin.io.a.a(fileOutputStream, th);
            if (!r3.renameTo(lVar.r())) {
            }
        } catch (IOException e3) {
            e = e3;
            file = r3;
        }
        rVar = new r(this, continuation);
        Object obj2 = rVar.f1239k;
        c2 = kotlin.coroutines.intrinsics.d.c();
        i2 = rVar.m;
        r3 = 1;
    }

    @Override // androidx.datastore.core.e
    public Object a(Function2<? super T, ? super Continuation<? super T>, ? extends Object> function2, Continuation<? super T> continuation) {
        CompletableDeferred b2 = y.b(null, 1, null);
        this.m.e(new b.C0029b(function2, b2, this.f1163k.getValue(), continuation.getL()));
        return b2.k(continuation);
    }

    @Override // androidx.datastore.core.e
    public Flow<T> b() {
        return this.f1160h;
    }
}
