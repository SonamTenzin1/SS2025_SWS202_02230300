package rx.n.a;

import java.util.ArrayList;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicLong;
import rx.e;
import rx.exceptions.CompositeException;
import rx.exceptions.MissingBackpressureException;
import rx.exceptions.OnErrorThrowable;

/* compiled from: OperatorMerge.java */
/* loaded from: classes3.dex */
public final class q0<T> implements e.b<T, rx.e<? extends T>> {

    /* renamed from: f, reason: collision with root package name */
    final boolean f26417f;

    /* renamed from: g, reason: collision with root package name */
    final int f26418g;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OperatorMerge.java */
    /* loaded from: classes3.dex */
    public static final class a {
        static final q0<Object> a = new q0<>(true, Integer.MAX_VALUE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OperatorMerge.java */
    /* loaded from: classes3.dex */
    public static final class b {
        static final q0<Object> a = new q0<>(false, Integer.MAX_VALUE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OperatorMerge.java */
    /* loaded from: classes3.dex */
    public static final class c<T> extends rx.j<T> {

        /* renamed from: f, reason: collision with root package name */
        static final int f26419f = rx.n.e.h.f26744f / 4;

        /* renamed from: g, reason: collision with root package name */
        final e<T> f26420g;

        /* renamed from: h, reason: collision with root package name */
        final long f26421h;

        /* renamed from: i, reason: collision with root package name */
        volatile boolean f26422i;

        /* renamed from: j, reason: collision with root package name */
        volatile rx.n.e.h f26423j;

        /* renamed from: k, reason: collision with root package name */
        int f26424k;

        public c(e<T> eVar, long j2) {
            this.f26420g = eVar;
            this.f26421h = j2;
        }

        public void c(long j2) {
            int i2 = this.f26424k - ((int) j2);
            if (i2 > f26419f) {
                this.f26424k = i2;
                return;
            }
            int i3 = rx.n.e.h.f26744f;
            this.f26424k = i3;
            int i4 = i3 - i2;
            if (i4 > 0) {
                request(i4);
            }
        }

        @Override // rx.f
        public void onCompleted() {
            this.f26422i = true;
            this.f26420g.e();
        }

        @Override // rx.f
        public void onError(Throwable th) {
            this.f26420g.k().offer(th);
            this.f26422i = true;
            this.f26420g.e();
        }

        @Override // rx.f
        public void onNext(T t) {
            this.f26420g.s(this, t);
        }

        @Override // rx.j
        public void onStart() {
            int i2 = rx.n.e.h.f26744f;
            this.f26424k = i2;
            request(i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OperatorMerge.java */
    /* loaded from: classes3.dex */
    public static final class d<T> extends AtomicLong implements rx.g {

        /* renamed from: f, reason: collision with root package name */
        final e<T> f26425f;

        public d(e<T> eVar) {
            this.f26425f = eVar;
        }

        public long a(int i2) {
            return addAndGet(-i2);
        }

        @Override // rx.g
        public void request(long j2) {
            if (j2 <= 0) {
                if (j2 < 0) {
                    throw new IllegalArgumentException("n >= 0 required");
                }
            } else {
                if (get() == Long.MAX_VALUE) {
                    return;
                }
                rx.n.a.a.b(this, j2);
                this.f26425f.e();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OperatorMerge.java */
    /* loaded from: classes3.dex */
    public static final class e<T> extends rx.j<rx.e<? extends T>> {

        /* renamed from: f, reason: collision with root package name */
        static final c<?>[] f26426f = new c[0];

        /* renamed from: g, reason: collision with root package name */
        final rx.j<? super T> f26427g;

        /* renamed from: h, reason: collision with root package name */
        final boolean f26428h;

        /* renamed from: i, reason: collision with root package name */
        final int f26429i;

        /* renamed from: j, reason: collision with root package name */
        d<T> f26430j;

        /* renamed from: k, reason: collision with root package name */
        volatile Queue<Object> f26431k;
        volatile rx.t.b l;
        volatile ConcurrentLinkedQueue<Throwable> m;
        volatile boolean n;
        boolean o;
        boolean p;
        final Object q = new Object();
        volatile c<?>[] r = f26426f;
        long s;
        long t;
        int u;
        final int v;
        int w;

        public e(rx.j<? super T> jVar, boolean z, int i2) {
            this.f26427g = jVar;
            this.f26428h = z;
            this.f26429i = i2;
            if (i2 == Integer.MAX_VALUE) {
                this.v = Integer.MAX_VALUE;
                request(Long.MAX_VALUE);
            } else {
                this.v = Math.max(1, i2 >> 1);
                request(i2);
            }
        }

        private void p() {
            ArrayList arrayList = new ArrayList(this.m);
            if (arrayList.size() == 1) {
                this.f26427g.onError((Throwable) arrayList.get(0));
            } else {
                this.f26427g.onError(new CompositeException(arrayList));
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        void c(c<T> cVar) {
            j().a(cVar);
            synchronized (this.q) {
                c<?>[] cVarArr = this.r;
                int length = cVarArr.length;
                c<?>[] cVarArr2 = new c[length + 1];
                System.arraycopy(cVarArr, 0, cVarArr2, 0, length);
                cVarArr2[length] = cVar;
                this.r = cVarArr2;
            }
        }

        boolean d() {
            if (this.f26427g.isUnsubscribed()) {
                return true;
            }
            ConcurrentLinkedQueue<Throwable> concurrentLinkedQueue = this.m;
            if (this.f26428h || concurrentLinkedQueue == null || concurrentLinkedQueue.isEmpty()) {
                return false;
            }
            try {
                p();
                return true;
            } finally {
                unsubscribe();
            }
        }

        void e() {
            synchronized (this) {
                if (this.o) {
                    this.p = true;
                } else {
                    this.o = true;
                    g();
                }
            }
        }

        void f() {
            int i2 = this.w + 1;
            if (i2 == this.v) {
                this.w = 0;
                q(i2);
            } else {
                this.w = i2;
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:102:0x019d  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        void g() {
            boolean z;
            long j2;
            int i2;
            boolean z2;
            try {
                rx.j<? super T> jVar = this.f26427g;
                while (!d()) {
                    Queue<Object> queue = this.f26431k;
                    long j3 = this.f26430j.get();
                    boolean z3 = j3 == Long.MAX_VALUE;
                    if (queue != null) {
                        int i3 = 0;
                        while (true) {
                            j2 = j3;
                            int i4 = 0;
                            i2 = i3;
                            Object obj = null;
                            while (true) {
                                if (j2 <= 0) {
                                    break;
                                }
                                Object poll = queue.poll();
                                if (d()) {
                                    return;
                                }
                                if (poll == null) {
                                    obj = poll;
                                    break;
                                }
                                try {
                                    jVar.onNext((Object) h.e(poll));
                                } catch (Throwable th) {
                                    if (!this.f26428h) {
                                        rx.exceptions.a.e(th);
                                        unsubscribe();
                                        jVar.onError(th);
                                        return;
                                    }
                                    k().offer(th);
                                }
                                i2++;
                                i4++;
                                j2--;
                                obj = poll;
                            }
                            if (i4 > 0) {
                                j2 = z3 ? Long.MAX_VALUE : this.f26430j.a(i4);
                            }
                            if (j2 == 0 || obj == null) {
                                break;
                            }
                            i3 = i2;
                            j3 = j2;
                        }
                    } else {
                        j2 = j3;
                        i2 = 0;
                    }
                    boolean z4 = this.n;
                    Queue<Object> queue2 = this.f26431k;
                    c<?>[] cVarArr = this.r;
                    int length = cVarArr.length;
                    if (z4 && ((queue2 == null || queue2.isEmpty()) && length == 0)) {
                        ConcurrentLinkedQueue<Throwable> concurrentLinkedQueue = this.m;
                        if (concurrentLinkedQueue != null && !concurrentLinkedQueue.isEmpty()) {
                            p();
                            return;
                        }
                        jVar.onCompleted();
                        return;
                    }
                    if (length > 0) {
                        long j4 = this.t;
                        int i5 = this.u;
                        if (length <= i5 || cVarArr[i5].f26421h != j4) {
                            if (length <= i5) {
                                i5 = 0;
                            }
                            for (int i6 = 0; i6 < length && cVarArr[i5].f26421h != j4; i6++) {
                                i5++;
                                if (i5 == length) {
                                    i5 = 0;
                                }
                            }
                            this.u = i5;
                            this.t = cVarArr[i5].f26421h;
                        }
                        z2 = false;
                        for (int i7 = 0; i7 < length; i7++) {
                            if (d()) {
                                return;
                            }
                            c<?> cVar = cVarArr[i5];
                            Object obj2 = null;
                            do {
                                int i8 = 0;
                                while (j2 > 0) {
                                    if (d()) {
                                        return;
                                    }
                                    rx.n.e.h hVar = cVar.f26423j;
                                    if (hVar == null || (obj2 = hVar.i()) == null) {
                                        break;
                                    }
                                    try {
                                        try {
                                            jVar.onNext((Object) h.e(obj2));
                                            j2--;
                                            i8++;
                                        } catch (Throwable th2) {
                                            rx.exceptions.a.e(th2);
                                            try {
                                                jVar.onError(th2);
                                                return;
                                            } finally {
                                                unsubscribe();
                                            }
                                        }
                                    } catch (Throwable th3) {
                                        th = th3;
                                        z = true;
                                        if (!z) {
                                        }
                                        throw th;
                                    }
                                }
                                if (i8 > 0) {
                                    j2 = !z3 ? this.f26430j.a(i8) : Long.MAX_VALUE;
                                    cVar.c(i8);
                                }
                                if (j2 == 0) {
                                    break;
                                }
                            } while (obj2 != null);
                            boolean z5 = cVar.f26422i;
                            rx.n.e.h hVar2 = cVar.f26423j;
                            if (z5 && (hVar2 == null || hVar2.e())) {
                                o(cVar);
                                if (d()) {
                                    return;
                                }
                                i2++;
                                z2 = true;
                            }
                            if (j2 == 0) {
                                break;
                            }
                            i5++;
                            if (i5 == length) {
                                i5 = 0;
                            }
                        }
                        this.u = i5;
                        this.t = cVarArr[i5].f26421h;
                    } else {
                        z2 = false;
                    }
                    if (i2 > 0) {
                        request(i2);
                    }
                    if (!z2) {
                        synchronized (this) {
                            try {
                                if (!this.p) {
                                    try {
                                        this.o = false;
                                        return;
                                    } catch (Throwable th4) {
                                        th = th4;
                                        z = true;
                                        while (true) {
                                            try {
                                                break;
                                            } catch (Throwable th5) {
                                                th = th5;
                                            }
                                        }
                                        throw th;
                                    }
                                }
                                this.p = false;
                            } catch (Throwable th6) {
                                th = th6;
                                z = false;
                            }
                        }
                        try {
                            break;
                            throw th;
                        } catch (Throwable th7) {
                            th = th7;
                            if (!z) {
                                synchronized (this) {
                                    this.o = false;
                                }
                            }
                            throw th;
                        }
                    }
                }
            } catch (Throwable th8) {
                th = th8;
                z = false;
                if (!z) {
                }
                throw th;
            }
        }

        protected void h(T t, long j2) {
            boolean z = true;
            try {
                try {
                    try {
                        this.f26427g.onNext(t);
                    } catch (Throwable th) {
                        th = th;
                        z = false;
                        if (!z) {
                            synchronized (this) {
                                this.o = false;
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    if (!this.f26428h) {
                        rx.exceptions.a.e(th2);
                        unsubscribe();
                        onError(th2);
                        return;
                    }
                    k().offer(th2);
                }
                if (j2 != Long.MAX_VALUE) {
                    this.f26430j.a(1);
                }
                int i2 = this.w + 1;
                if (i2 == this.v) {
                    this.w = 0;
                    q(i2);
                } else {
                    this.w = i2;
                }
                synchronized (this) {
                    if (!this.p) {
                        this.o = false;
                    } else {
                        this.p = false;
                        g();
                    }
                }
            } catch (Throwable th3) {
                th = th3;
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:28:0x004a  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        protected void i(c<T> cVar, T t, long j2) {
            boolean z = true;
            try {
                try {
                    try {
                        this.f26427g.onNext(t);
                    } catch (Throwable th) {
                        th = th;
                        z = false;
                        if (!z) {
                            synchronized (this) {
                                this.o = false;
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    if (!this.f26428h) {
                        rx.exceptions.a.e(th2);
                        cVar.unsubscribe();
                        cVar.onError(th2);
                        return;
                    }
                    k().offer(th2);
                }
                if (j2 != Long.MAX_VALUE) {
                    this.f26430j.a(1);
                }
                cVar.c(1L);
                synchronized (this) {
                    if (!this.p) {
                        this.o = false;
                    } else {
                        this.p = false;
                        g();
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                if (!z) {
                }
                throw th;
            }
        }

        rx.t.b j() {
            rx.t.b bVar;
            rx.t.b bVar2 = this.l;
            if (bVar2 != null) {
                return bVar2;
            }
            boolean z = false;
            synchronized (this) {
                bVar = this.l;
                if (bVar == null) {
                    rx.t.b bVar3 = new rx.t.b();
                    this.l = bVar3;
                    bVar = bVar3;
                    z = true;
                }
            }
            if (z) {
                add(bVar);
            }
            return bVar;
        }

        Queue<Throwable> k() {
            ConcurrentLinkedQueue<Throwable> concurrentLinkedQueue = this.m;
            if (concurrentLinkedQueue == null) {
                synchronized (this) {
                    concurrentLinkedQueue = this.m;
                    if (concurrentLinkedQueue == null) {
                        concurrentLinkedQueue = new ConcurrentLinkedQueue<>();
                        this.m = concurrentLinkedQueue;
                    }
                }
            }
            return concurrentLinkedQueue;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // rx.f
        /* renamed from: l, reason: merged with bridge method [inline-methods] */
        public void onNext(rx.e<? extends T> eVar) {
            if (eVar == null) {
                return;
            }
            if (eVar == rx.e.B()) {
                f();
                return;
            }
            if (eVar instanceof rx.n.e.j) {
                r(((rx.n.e.j) eVar).h1());
                return;
            }
            long j2 = this.s;
            this.s = 1 + j2;
            c cVar = new c(this, j2);
            c(cVar);
            eVar.c1(cVar);
            e();
        }

        protected void m(T t) {
            Queue<Object> fVar;
            Queue<Object> queue = this.f26431k;
            if (queue == null) {
                int i2 = this.f26429i;
                if (i2 == Integer.MAX_VALUE) {
                    queue = new rx.n.e.n.h<>(rx.n.e.h.f26744f);
                } else {
                    if (rx.n.e.o.j.a(i2)) {
                        if (rx.n.e.o.z.b()) {
                            fVar = new rx.n.e.o.s<>(i2);
                        } else {
                            fVar = new rx.n.e.n.e<>(i2);
                        }
                    } else {
                        fVar = new rx.n.e.n.f<>(i2);
                    }
                    queue = fVar;
                }
                this.f26431k = queue;
            }
            if (queue.offer(h.g(t))) {
                return;
            }
            unsubscribe();
            onError(OnErrorThrowable.a(new MissingBackpressureException(), t));
        }

        protected void n(c<T> cVar, T t) {
            rx.n.e.h hVar = cVar.f26423j;
            if (hVar == null) {
                hVar = rx.n.e.h.b();
                cVar.add(hVar);
                cVar.f26423j = hVar;
            }
            try {
                hVar.g(h.g(t));
            } catch (IllegalStateException e2) {
                if (cVar.isUnsubscribed()) {
                    return;
                }
                cVar.unsubscribe();
                cVar.onError(e2);
            } catch (MissingBackpressureException e3) {
                cVar.unsubscribe();
                cVar.onError(e3);
            }
        }

        void o(c<T> cVar) {
            rx.n.e.h hVar = cVar.f26423j;
            if (hVar != null) {
                hVar.j();
            }
            this.l.d(cVar);
            synchronized (this.q) {
                c<?>[] cVarArr = this.r;
                int length = cVarArr.length;
                int i2 = -1;
                int i3 = 0;
                while (true) {
                    if (i3 >= length) {
                        break;
                    }
                    if (cVar.equals(cVarArr[i3])) {
                        i2 = i3;
                        break;
                    }
                    i3++;
                }
                if (i2 < 0) {
                    return;
                }
                if (length == 1) {
                    this.r = f26426f;
                    return;
                }
                c<?>[] cVarArr2 = new c[length - 1];
                System.arraycopy(cVarArr, 0, cVarArr2, 0, i2);
                System.arraycopy(cVarArr, i2 + 1, cVarArr2, i2, (length - i2) - 1);
                this.r = cVarArr2;
            }
        }

        @Override // rx.f
        public void onCompleted() {
            this.n = true;
            e();
        }

        @Override // rx.f
        public void onError(Throwable th) {
            k().offer(th);
            this.n = true;
            e();
        }

        public void q(long j2) {
            request(j2);
        }

        void r(T t) {
            long j2 = this.f26430j.get();
            boolean z = false;
            if (j2 != 0) {
                synchronized (this) {
                    j2 = this.f26430j.get();
                    if (!this.o && j2 != 0) {
                        this.o = true;
                        z = true;
                    }
                }
            }
            if (z) {
                Queue<Object> queue = this.f26431k;
                if (queue != null && !queue.isEmpty()) {
                    m(t);
                    g();
                    return;
                } else {
                    h(t, j2);
                    return;
                }
            }
            m(t);
            e();
        }

        void s(c<T> cVar, T t) {
            long j2 = this.f26430j.get();
            boolean z = false;
            if (j2 != 0) {
                synchronized (this) {
                    j2 = this.f26430j.get();
                    if (!this.o && j2 != 0) {
                        this.o = true;
                        z = true;
                    }
                }
            }
            if (z) {
                rx.n.e.h hVar = cVar.f26423j;
                if (hVar != null && !hVar.e()) {
                    n(cVar, t);
                    g();
                    return;
                } else {
                    i(cVar, t, j2);
                    return;
                }
            }
            n(cVar, t);
            e();
        }
    }

    q0(boolean z, int i2) {
        this.f26417f = z;
        this.f26418g = i2;
    }

    public static <T> q0<T> b(boolean z) {
        if (z) {
            return (q0<T>) a.a;
        }
        return (q0<T>) b.a;
    }

    @Override // rx.m.e
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public rx.j<rx.e<? extends T>> call(rx.j<? super T> jVar) {
        e eVar = new e(jVar, this.f26417f, this.f26418g);
        d<T> dVar = new d<>(eVar);
        eVar.f26430j = dVar;
        jVar.add(eVar);
        jVar.setProducer(dVar);
        return eVar;
    }
}
