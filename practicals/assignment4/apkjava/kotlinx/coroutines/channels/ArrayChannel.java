package kotlinx.coroutines.channels;

import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function1;
import kotlin.u;
import kotlinx.coroutines.internal.Symbol;
import kotlinx.coroutines.s0;
import okhttp3.HttpUrl;

/* compiled from: ArrayChannel.kt */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\b\u0010\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000BB9\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012 \u0010\t\u001a\u001c\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`\b¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\u000e\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u001d\u0010\u0013\u001a\u00020\u00122\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u0010H\u0014¢\u0006\u0004\b\u0013\u0010\u0014J\u0019\u0010\u0018\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0016\u001a\u00020\u0015H\u0014¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001a\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001c\u001a\u00020\u00172\u0006\u0010\r\u001a\u00028\u0000H\u0014¢\u0006\u0004\b\u001c\u0010\u001dJ#\u0010 \u001a\u00020\u00172\u0006\u0010\r\u001a\u00028\u00002\n\u0010\u001f\u001a\u0006\u0012\u0002\b\u00030\u001eH\u0014¢\u0006\u0004\b \u0010!J\u0017\u0010#\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020\u0012H\u0014¢\u0006\u0004\b#\u0010$J\u0011\u0010%\u001a\u0004\u0018\u00010\u0017H\u0014¢\u0006\u0004\b%\u0010&J\u001d\u0010'\u001a\u0004\u0018\u00010\u00172\n\u0010\u001f\u001a\u0006\u0012\u0002\b\u00030\u001eH\u0014¢\u0006\u0004\b'\u0010(J\u0019\u0010*\u001a\u0004\u0018\u00010)2\u0006\u0010\f\u001a\u00020\u0002H\u0002¢\u0006\u0004\b*\u0010+R\u001e\u0010-\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00170,8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010.R\u0014\u00102\u001a\u00020/8TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b0\u00101R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u00103R\u0016\u00104\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b4\u00103R\u0014\u00105\u001a\u00020\u00128DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b5\u00106R\u0014\u00107\u001a\u00020\u00128DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b7\u00106R\u0014\u00108\u001a\u00020\u00128DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b8\u00106R\u0014\u00109\u001a\u00020\u00128DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b9\u00106R\u0014\u0010:\u001a\u00020\u00128VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b:\u00106R\u0014\u0010;\u001a\u00020\u00128VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b;\u00106R\u0018\u0010>\u001a\u00060<j\u0002`=8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b>\u0010?R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010@¨\u0006A"}, d2 = {"Lkotlinx/coroutines/channels/ArrayChannel;", "E", HttpUrl.FRAGMENT_ENCODE_SET, "capacity", "Lkotlinx/coroutines/channels/BufferOverflow;", "onBufferOverflow", "Lkotlin/Function1;", HttpUrl.FRAGMENT_ENCODE_SET, "Lkotlinx/coroutines/internal/OnUndeliveredElement;", "onUndeliveredElement", "<init>", "(ILkotlinx/coroutines/channels/BufferOverflow;Lkotlin/jvm/functions/Function1;)V", "currentSize", "element", "enqueueElement", "(ILjava/lang/Object;)V", "Lkotlinx/coroutines/channels/Receive;", "receive", HttpUrl.FRAGMENT_ENCODE_SET, "enqueueReceiveInternal", "(Lkotlinx/coroutines/channels/Receive;)Z", "Lkotlinx/coroutines/channels/Send;", "send", HttpUrl.FRAGMENT_ENCODE_SET, "enqueueSend", "(Lkotlinx/coroutines/channels/Send;)Ljava/lang/Object;", "ensureCapacity", "(I)V", "offerInternal", "(Ljava/lang/Object;)Ljava/lang/Object;", "Lkotlinx/coroutines/selects/SelectInstance;", "select", "offerSelectInternal", "(Ljava/lang/Object;Lkotlinx/coroutines/selects/SelectInstance;)Ljava/lang/Object;", "wasClosed", "onCancelIdempotent", "(Z)V", "pollInternal", "()Ljava/lang/Object;", "pollSelectInternal", "(Lkotlinx/coroutines/selects/SelectInstance;)Ljava/lang/Object;", "Lkotlinx/coroutines/internal/Symbol;", "updateBufferSize", "(I)Lkotlinx/coroutines/internal/Symbol;", HttpUrl.FRAGMENT_ENCODE_SET, "buffer", "[Ljava/lang/Object;", HttpUrl.FRAGMENT_ENCODE_SET, "getBufferDebugString", "()Ljava/lang/String;", "bufferDebugString", "I", "head", "isBufferAlwaysEmpty", "()Z", "isBufferAlwaysFull", "isBufferEmpty", "isBufferFull", "isClosedForReceive", "isEmpty", "Ljava/util/concurrent/locks/ReentrantLock;", "Lkotlinx/coroutines/internal/ReentrantLock;", "lock", "Ljava/util/concurrent/locks/ReentrantLock;", "Lkotlinx/coroutines/channels/BufferOverflow;", "kotlinx-coroutines-core", "Lkotlinx/coroutines/channels/AbstractChannel;"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* renamed from: kotlinx.coroutines.channels.d, reason: from Kotlin metadata */
/* loaded from: classes3.dex */
public class ArrayChannel<E> extends AbstractChannel<E> {

    /* renamed from: e, reason: collision with root package name */
    private final int f25708e;

    /* renamed from: f, reason: collision with root package name */
    private final BufferOverflow f25709f;

    /* renamed from: g, reason: collision with root package name */
    private final ReentrantLock f25710g;

    /* renamed from: h, reason: collision with root package name */
    private Object[] f25711h;

    /* renamed from: i, reason: collision with root package name */
    private int f25712i;
    private volatile /* synthetic */ int size;

    /* compiled from: ArrayChannel.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* renamed from: kotlinx.coroutines.channels.d$a */
    /* loaded from: classes3.dex */
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[BufferOverflow.values().length];
            iArr[BufferOverflow.SUSPEND.ordinal()] = 1;
            iArr[BufferOverflow.DROP_LATEST.ordinal()] = 2;
            iArr[BufferOverflow.DROP_OLDEST.ordinal()] = 3;
            a = iArr;
        }
    }

    public ArrayChannel(int i2, BufferOverflow bufferOverflow, Function1<? super E, u> function1) {
        super(function1);
        this.f25708e = i2;
        this.f25709f = bufferOverflow;
        if (i2 >= 1) {
            this.f25710g = new ReentrantLock();
            Object[] objArr = new Object[Math.min(i2, 8)];
            kotlin.collections.m.m(objArr, b.a, 0, 0, 6, null);
            this.f25711h = objArr;
            this.size = 0;
            return;
        }
        throw new IllegalArgumentException(("ArrayChannel capacity must be at least 1, but " + i2 + " was specified").toString());
    }

    private final void C(int i2, E e2) {
        if (i2 < this.f25708e) {
            D(i2);
            Object[] objArr = this.f25711h;
            objArr[(this.f25712i + i2) % objArr.length] = e2;
            return;
        }
        if (s0.a()) {
            if (!(this.f25709f == BufferOverflow.DROP_OLDEST)) {
                throw new AssertionError();
            }
        }
        Object[] objArr2 = this.f25711h;
        int i3 = this.f25712i;
        objArr2[i3 % objArr2.length] = null;
        objArr2[(i2 + i3) % objArr2.length] = e2;
        this.f25712i = (i3 + 1) % objArr2.length;
    }

    private final void D(int i2) {
        Object[] objArr = this.f25711h;
        if (i2 >= objArr.length) {
            int min = Math.min(objArr.length * 2, this.f25708e);
            Object[] objArr2 = new Object[min];
            for (int i3 = 0; i3 < i2; i3++) {
                Object[] objArr3 = this.f25711h;
                objArr2[i3] = objArr3[(this.f25712i + i3) % objArr3.length];
            }
            kotlin.collections.m.k(objArr2, b.a, i2, min);
            this.f25711h = objArr2;
            this.f25712i = 0;
        }
    }

    private final Symbol E(int i2) {
        if (i2 < this.f25708e) {
            this.size = i2 + 1;
            return null;
        }
        int i3 = a.a[this.f25709f.ordinal()];
        if (i3 == 1) {
            return b.f25700c;
        }
        if (i3 == 2) {
            return b.f25699b;
        }
        if (i3 == 3) {
            return null;
        }
        throw new NoWhenBranchMatchedException();
    }

    @Override // kotlinx.coroutines.channels.AbstractSendChannel
    protected String f() {
        return "(buffer:capacity=" + this.f25708e + ",size=" + this.size + ')';
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x001b, code lost:
    
        if (r1 == 0) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x001d, code lost:
    
        r2 = p();
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0021, code lost:
    
        if (r2 != null) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0026, code lost:
    
        if ((r2 instanceof kotlinx.coroutines.channels.Closed) == false) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x002e, code lost:
    
        kotlin.jvm.internal.m.c(r2);
        r3 = r2.h(r6, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0036, code lost:
    
        if (r3 == null) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x003c, code lost:
    
        if (kotlinx.coroutines.s0.a() == false) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0040, code lost:
    
        if (r3 != kotlinx.coroutines.p.a) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0042, code lost:
    
        r3 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0045, code lost:
    
        if (r3 == false) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x004d, code lost:
    
        throw new java.lang.AssertionError();
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0044, code lost:
    
        r3 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x004e, code lost:
    
        r5.size = r1;
        r1 = kotlin.u.a;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0052, code lost:
    
        r0.unlock();
        r2.g(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x005c, code lost:
    
        return r2.c();
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0028, code lost:
    
        r5.size = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x002d, code lost:
    
        return r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x005d, code lost:
    
        C(r1, r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0065, code lost:
    
        return kotlinx.coroutines.channels.b.f25699b;
     */
    @Override // kotlinx.coroutines.channels.AbstractSendChannel
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object m(E e2) {
        ReentrantLock reentrantLock = this.f25710g;
        reentrantLock.lock();
        try {
            int i2 = this.size;
            Closed<?> g2 = g();
            if (g2 != null) {
                return g2;
            }
            Symbol E = E(i2);
            if (E != null) {
                return E;
            }
        } finally {
            reentrantLock.unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.coroutines.channels.AbstractChannel
    public boolean u(Receive<? super E> receive) {
        ReentrantLock reentrantLock = this.f25710g;
        reentrantLock.lock();
        try {
            return super.u(receive);
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // kotlinx.coroutines.channels.AbstractChannel
    protected final boolean v() {
        return false;
    }

    @Override // kotlinx.coroutines.channels.AbstractChannel
    protected final boolean w() {
        return this.size == 0;
    }

    @Override // kotlinx.coroutines.channels.AbstractChannel
    protected Object z() {
        ReentrantLock reentrantLock = this.f25710g;
        reentrantLock.lock();
        try {
            int i2 = this.size;
            if (i2 == 0) {
                Object g2 = g();
                if (g2 == null) {
                    g2 = b.f25701d;
                }
                return g2;
            }
            Object[] objArr = this.f25711h;
            int i3 = this.f25712i;
            Object obj = objArr[i3];
            Send send = null;
            objArr[i3] = null;
            this.size = i2 - 1;
            Object obj2 = b.f25701d;
            if (i2 == this.f25708e) {
                Send send2 = null;
                while (true) {
                    Send q = q();
                    if (q == null) {
                        send = send2;
                        break;
                    }
                    kotlin.jvm.internal.m.c(q);
                    Symbol G = q.G(null);
                    if (G != null) {
                        if (s0.a()) {
                            if (!(G == kotlinx.coroutines.p.a)) {
                                throw new AssertionError();
                            }
                        }
                        obj2 = q.getF25707i();
                        send = q;
                        r6 = true;
                    } else {
                        q.H();
                        send2 = q;
                    }
                }
            }
            if (obj2 != b.f25701d && !(obj2 instanceof Closed)) {
                this.size = i2;
                Object[] objArr2 = this.f25711h;
                objArr2[(this.f25712i + i2) % objArr2.length] = obj2;
            }
            this.f25712i = (this.f25712i + 1) % this.f25711h.length;
            u uVar = u.a;
            if (r6) {
                kotlin.jvm.internal.m.c(send);
                send.E();
            }
            return obj;
        } finally {
            reentrantLock.unlock();
        }
    }
}
