package kotlinx.coroutines.sync;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.j.internal.h;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.u;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.internal.AtomicOp;
import kotlinx.coroutines.internal.LockFreeLinkedListHead;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;
import kotlinx.coroutines.internal.OpDescriptor;
import kotlinx.coroutines.internal.Symbol;
import kotlinx.coroutines.p;
import kotlinx.coroutines.q;
import okhttp3.HttpUrl;

/* compiled from: Mutex.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\n\b\u0000\u0018\u00002\u00020\u00112\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0004\u0012\u00020\u00110 :\u0006$%&'()B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u001d\u0010\n\u001a\u00020\t2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0096@ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000bJ\u001d\u0010\f\u001a\u00020\t2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0082@ø\u0001\u0000¢\u0006\u0004\b\f\u0010\u000bJT\u0010\u0014\u001a\u00020\t\"\u0004\b\u0000\u0010\r2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\"\u0010\u0013\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0011\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0010H\u0016ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0019\u0010\u0019\u001a\u00020\u00012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\u0019\u0010\bJ\u0019\u0010\u001a\u001a\u00020\t2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001c\u001a\u00020\u00018VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u0014\u0010\u001f\u001a\u00020\u00018@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001dR\"\u0010#\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0004\u0012\u00020\u00110 8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\"\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006*"}, d2 = {"Lkotlinx/coroutines/sync/MutexImpl;", HttpUrl.FRAGMENT_ENCODE_SET, "locked", "<init>", "(Z)V", HttpUrl.FRAGMENT_ENCODE_SET, "owner", "holdsLock", "(Ljava/lang/Object;)Z", HttpUrl.FRAGMENT_ENCODE_SET, "lock", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "lockSuspend", "R", "Lkotlinx/coroutines/selects/SelectInstance;", "select", "Lkotlin/Function2;", "Lkotlinx/coroutines/sync/Mutex;", "Lkotlin/coroutines/Continuation;", "block", "registerSelectClause2", "(Lkotlinx/coroutines/selects/SelectInstance;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)V", HttpUrl.FRAGMENT_ENCODE_SET, "toString", "()Ljava/lang/String;", "tryLock", "unlock", "(Ljava/lang/Object;)V", "isLocked", "()Z", "isLockedEmptyQueueState$kotlinx_coroutines_core", "isLockedEmptyQueueState", "Lkotlinx/coroutines/selects/SelectClause2;", "getOnLock", "()Lkotlinx/coroutines/selects/SelectClause2;", "onLock", "LockCont", "LockSelect", "LockWaiter", "LockedQueue", "TryLockDesc", "UnlockOp", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* renamed from: kotlinx.coroutines.d3.c, reason: from Kotlin metadata */
/* loaded from: classes3.dex */
public final class MutexImpl implements Mutex {
    static final /* synthetic */ AtomicReferenceFieldUpdater a = AtomicReferenceFieldUpdater.newUpdater(MutexImpl.class, Object.class, "_state");
    volatile /* synthetic */ Object _state;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Mutex.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0082\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\u001d\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\u0010\bJ\b\u0010\t\u001a\u00020\u0007H\u0016J\b\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\rH\u0016R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lkotlinx/coroutines/sync/MutexImpl$LockCont;", "Lkotlinx/coroutines/sync/MutexImpl$LockWaiter;", "Lkotlinx/coroutines/sync/MutexImpl;", "owner", HttpUrl.FRAGMENT_ENCODE_SET, "cont", "Lkotlinx/coroutines/CancellableContinuation;", HttpUrl.FRAGMENT_ENCODE_SET, "(Lkotlinx/coroutines/sync/MutexImpl;Ljava/lang/Object;Lkotlinx/coroutines/CancellableContinuation;)V", "completeResumeLockWaiter", "toString", HttpUrl.FRAGMENT_ENCODE_SET, "tryResumeLockWaiter", HttpUrl.FRAGMENT_ENCODE_SET, "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* renamed from: kotlinx.coroutines.d3.c$a */
    /* loaded from: classes3.dex */
    public final class a extends b {
        private final CancellableContinuation<u> l;

        /* compiled from: Mutex.kt */
        @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", HttpUrl.FRAGMENT_ENCODE_SET, "it", HttpUrl.FRAGMENT_ENCODE_SET, "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
        /* renamed from: kotlinx.coroutines.d3.c$a$a, reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        static final class C0421a extends Lambda implements Function1<Throwable, u> {

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ MutexImpl f25725f;

            /* renamed from: g, reason: collision with root package name */
            final /* synthetic */ a f25726g;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C0421a(MutexImpl mutexImpl, a aVar) {
                super(1);
                this.f25725f = mutexImpl;
                this.f25726g = aVar;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ u invoke(Throwable th) {
                invoke2(th);
                return u.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                this.f25725f.c(this.f25726g.f25728j);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public a(Object obj, CancellableContinuation<? super u> cancellableContinuation) {
            super(obj);
            this.l = cancellableContinuation;
        }

        @Override // kotlinx.coroutines.sync.MutexImpl.b
        public void E() {
            this.l.q(p.a);
        }

        @Override // kotlinx.coroutines.sync.MutexImpl.b
        public boolean G() {
            return F() && this.l.g(u.a, null, new C0421a(MutexImpl.this, this)) != null;
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode
        public String toString() {
            return "LockCont[" + this.f25728j + ", " + this.l + "] for " + MutexImpl.this;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Mutex.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\b¢\u0004\u0018\u00002\u00020\u000f2\u00020\u0010B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\b\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\u0007J\r\u0010\n\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\tH&¢\u0006\u0004\b\f\u0010\u000bR\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u00018\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0002\u0010\r¨\u0006\u000e"}, d2 = {"Lkotlinx/coroutines/sync/MutexImpl$LockWaiter;", HttpUrl.FRAGMENT_ENCODE_SET, "owner", "<init>", "(Lkotlinx/coroutines/sync/MutexImpl;Ljava/lang/Object;)V", HttpUrl.FRAGMENT_ENCODE_SET, "completeResumeLockWaiter", "()V", "dispose", HttpUrl.FRAGMENT_ENCODE_SET, "take", "()Z", "tryResumeLockWaiter", "Ljava/lang/Object;", "kotlinx-coroutines-core", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "Lkotlinx/coroutines/DisposableHandle;"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* renamed from: kotlinx.coroutines.d3.c$b */
    /* loaded from: classes3.dex */
    public abstract class b extends LockFreeLinkedListNode implements DisposableHandle {

        /* renamed from: i, reason: collision with root package name */
        private static final /* synthetic */ AtomicIntegerFieldUpdater f25727i = AtomicIntegerFieldUpdater.newUpdater(b.class, "isTaken");
        private volatile /* synthetic */ int isTaken = 0;

        /* renamed from: j, reason: collision with root package name */
        public final Object f25728j;

        public b(Object obj) {
            this.f25728j = obj;
        }

        public abstract void E();

        public final boolean F() {
            return f25727i.compareAndSet(this, 0, 1);
        }

        public abstract boolean G();

        @Override // kotlinx.coroutines.DisposableHandle
        public final void k() {
            z();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Mutex.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016R\u0012\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lkotlinx/coroutines/sync/MutexImpl$LockedQueue;", "Lkotlinx/coroutines/internal/LockFreeLinkedListHead;", "owner", HttpUrl.FRAGMENT_ENCODE_SET, "(Ljava/lang/Object;)V", "toString", HttpUrl.FRAGMENT_ENCODE_SET, "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* renamed from: kotlinx.coroutines.d3.c$c */
    /* loaded from: classes3.dex */
    public static final class c extends LockFreeLinkedListHead {
        public volatile Object owner;

        public c(Object obj) {
            this.owner = obj;
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode
        public String toString() {
            return "LockedQueue[" + this.owner + ']';
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Mutex.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u001a\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\b\u001a\u00020\u0002H\u0016R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lkotlinx/coroutines/sync/MutexImpl$UnlockOp;", "Lkotlinx/coroutines/internal/AtomicOp;", "Lkotlinx/coroutines/sync/MutexImpl;", "queue", "Lkotlinx/coroutines/sync/MutexImpl$LockedQueue;", "(Lkotlinx/coroutines/sync/MutexImpl$LockedQueue;)V", "complete", HttpUrl.FRAGMENT_ENCODE_SET, "affected", "failure", HttpUrl.FRAGMENT_ENCODE_SET, "prepare", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* renamed from: kotlinx.coroutines.d3.c$d */
    /* loaded from: classes3.dex */
    public static final class d extends AtomicOp<MutexImpl> {

        /* renamed from: b, reason: collision with root package name */
        public final c f25730b;

        public d(c cVar) {
            this.f25730b = cVar;
        }

        @Override // kotlinx.coroutines.internal.AtomicOp
        /* renamed from: h, reason: merged with bridge method [inline-methods] */
        public void d(MutexImpl mutexImpl, Object obj) {
            MutexImpl.a.compareAndSet(mutexImpl, this, obj == null ? kotlinx.coroutines.sync.d.f25737f : this.f25730b);
        }

        @Override // kotlinx.coroutines.internal.AtomicOp
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public Object g(MutexImpl mutexImpl) {
            Symbol symbol;
            if (this.f25730b.E()) {
                return null;
            }
            symbol = kotlinx.coroutines.sync.d.f25733b;
            return symbol;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Mutex.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", HttpUrl.FRAGMENT_ENCODE_SET, "it", HttpUrl.FRAGMENT_ENCODE_SET, "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
    /* renamed from: kotlinx.coroutines.d3.c$e */
    /* loaded from: classes3.dex */
    public static final class e extends Lambda implements Function1<Throwable, u> {

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ Object f25732g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(Object obj) {
            super(1);
            this.f25732g = obj;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ u invoke(Throwable th) {
            invoke2(th);
            return u.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Throwable th) {
            MutexImpl.this.c(this.f25732g);
        }
    }

    public MutexImpl(boolean z) {
        this._state = z ? kotlinx.coroutines.sync.d.f25736e : kotlinx.coroutines.sync.d.f25737f;
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x006e, code lost:
    
        kotlinx.coroutines.q.c(r0, r1);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final Object d(Object obj, Continuation<? super u> continuation) {
        Continuation b2;
        Symbol symbol;
        Object c2;
        Object c3;
        b2 = kotlin.coroutines.intrinsics.c.b(continuation);
        CancellableContinuationImpl b3 = q.b(b2);
        a aVar = new a(obj, b3);
        while (true) {
            Object obj2 = this._state;
            if (obj2 instanceof Empty) {
                Empty empty = (Empty) obj2;
                Object obj3 = empty.a;
                symbol = kotlinx.coroutines.sync.d.f25735d;
                if (obj3 != symbol) {
                    a.compareAndSet(this, obj2, new c(empty.a));
                } else {
                    if (a.compareAndSet(this, obj2, obj == null ? kotlinx.coroutines.sync.d.f25736e : new Empty(obj))) {
                        b3.n(u.a, new e(obj));
                        break;
                    }
                }
            } else if (obj2 instanceof c) {
                c cVar = (c) obj2;
                if (cVar.owner != obj) {
                    cVar.j(aVar);
                    if (this._state == obj2 || !aVar.F()) {
                        break;
                    }
                    aVar = new a(obj, b3);
                } else {
                    throw new IllegalStateException(("Already locked by " + obj).toString());
                }
            } else {
                if (!(obj2 instanceof OpDescriptor)) {
                    throw new IllegalStateException(("Illegal state " + obj2).toString());
                }
                ((OpDescriptor) obj2).c(this);
            }
        }
        Object w = b3.w();
        c2 = kotlin.coroutines.intrinsics.d.c();
        if (w == c2) {
            h.c(continuation);
        }
        c3 = kotlin.coroutines.intrinsics.d.c();
        return w == c3 ? w : u.a;
    }

    @Override // kotlinx.coroutines.sync.Mutex
    public boolean a() {
        Symbol symbol;
        while (true) {
            Object obj = this._state;
            if (obj instanceof Empty) {
                Object obj2 = ((Empty) obj).a;
                symbol = kotlinx.coroutines.sync.d.f25735d;
                return obj2 != symbol;
            }
            if (obj instanceof c) {
                return true;
            }
            if (!(obj instanceof OpDescriptor)) {
                throw new IllegalStateException(("Illegal state " + obj).toString());
            }
            ((OpDescriptor) obj).c(this);
        }
    }

    @Override // kotlinx.coroutines.sync.Mutex
    public Object b(Object obj, Continuation<? super u> continuation) {
        Object c2;
        if (e(obj)) {
            return u.a;
        }
        Object d2 = d(obj, continuation);
        c2 = kotlin.coroutines.intrinsics.d.c();
        return d2 == c2 ? d2 : u.a;
    }

    @Override // kotlinx.coroutines.sync.Mutex
    public void c(Object obj) {
        Empty empty;
        Symbol symbol;
        while (true) {
            Object obj2 = this._state;
            if (obj2 instanceof Empty) {
                if (obj == null) {
                    Object obj3 = ((Empty) obj2).a;
                    symbol = kotlinx.coroutines.sync.d.f25735d;
                    if (!(obj3 != symbol)) {
                        throw new IllegalStateException("Mutex is not locked".toString());
                    }
                } else {
                    Empty empty2 = (Empty) obj2;
                    if (!(empty2.a == obj)) {
                        throw new IllegalStateException(("Mutex is locked by " + empty2.a + " but expected " + obj).toString());
                    }
                }
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = a;
                empty = kotlinx.coroutines.sync.d.f25737f;
                if (atomicReferenceFieldUpdater.compareAndSet(this, obj2, empty)) {
                    return;
                }
            } else if (obj2 instanceof OpDescriptor) {
                ((OpDescriptor) obj2).c(this);
            } else if (obj2 instanceof c) {
                if (obj != null) {
                    c cVar = (c) obj2;
                    if (!(cVar.owner == obj)) {
                        throw new IllegalStateException(("Mutex is locked by " + cVar.owner + " but expected " + obj).toString());
                    }
                }
                c cVar2 = (c) obj2;
                LockFreeLinkedListNode A = cVar2.A();
                if (A == null) {
                    d dVar = new d(cVar2);
                    if (a.compareAndSet(this, obj2, dVar) && dVar.c(this) == null) {
                        return;
                    }
                } else {
                    b bVar = (b) A;
                    if (bVar.G()) {
                        Object obj4 = bVar.f25728j;
                        if (obj4 == null) {
                            obj4 = kotlinx.coroutines.sync.d.f25734c;
                        }
                        cVar2.owner = obj4;
                        bVar.E();
                        return;
                    }
                }
            } else {
                throw new IllegalStateException(("Illegal state " + obj2).toString());
            }
        }
    }

    public boolean e(Object obj) {
        Symbol symbol;
        while (true) {
            Object obj2 = this._state;
            if (obj2 instanceof Empty) {
                Object obj3 = ((Empty) obj2).a;
                symbol = kotlinx.coroutines.sync.d.f25735d;
                if (obj3 != symbol) {
                    return false;
                }
                if (a.compareAndSet(this, obj2, obj == null ? kotlinx.coroutines.sync.d.f25736e : new Empty(obj))) {
                    return true;
                }
            } else {
                if (obj2 instanceof c) {
                    if (((c) obj2).owner != obj) {
                        return false;
                    }
                    throw new IllegalStateException(("Already locked by " + obj).toString());
                }
                if (!(obj2 instanceof OpDescriptor)) {
                    throw new IllegalStateException(("Illegal state " + obj2).toString());
                }
                ((OpDescriptor) obj2).c(this);
            }
        }
    }

    public String toString() {
        while (true) {
            Object obj = this._state;
            if (obj instanceof Empty) {
                return "Mutex[" + ((Empty) obj).a + ']';
            }
            if (!(obj instanceof OpDescriptor)) {
                if (!(obj instanceof c)) {
                    throw new IllegalStateException(("Illegal state " + obj).toString());
                }
                return "Mutex[" + ((c) obj).owner + ']';
            }
            ((OpDescriptor) obj).c(this);
        }
    }
}
