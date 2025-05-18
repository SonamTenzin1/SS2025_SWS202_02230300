package rx.n.a;

import java.util.Queue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import rx.e;
import rx.exceptions.MissingBackpressureException;

/* compiled from: OperatorPublish.java */
/* loaded from: classes3.dex */
public final class u0<T> extends rx.o.b<T> {

    /* renamed from: g, reason: collision with root package name */
    final rx.e<? extends T> f26503g;

    /* renamed from: h, reason: collision with root package name */
    final AtomicReference<c<T>> f26504h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OperatorPublish.java */
    /* loaded from: classes3.dex */
    public static class a implements e.a<T> {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ AtomicReference f26505f;

        a(AtomicReference atomicReference) {
            this.f26505f = atomicReference;
        }

        @Override // rx.m.b
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void call(rx.j<? super T> jVar) {
            while (true) {
                c cVar = (c) this.f26505f.get();
                if (cVar == null || cVar.isUnsubscribed()) {
                    c cVar2 = new c(this.f26505f);
                    cVar2.f();
                    if (this.f26505f.compareAndSet(cVar, cVar2)) {
                        cVar = cVar2;
                    } else {
                        continue;
                    }
                }
                b<T> bVar = new b<>(cVar, jVar);
                if (cVar.c(bVar)) {
                    jVar.add(bVar);
                    jVar.setProducer(bVar);
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OperatorPublish.java */
    /* loaded from: classes3.dex */
    public static final class b<T> extends AtomicLong implements rx.g, rx.k {

        /* renamed from: f, reason: collision with root package name */
        final c<T> f26506f;

        /* renamed from: g, reason: collision with root package name */
        final rx.j<? super T> f26507g;

        public b(c<T> cVar, rx.j<? super T> jVar) {
            this.f26506f = cVar;
            this.f26507g = jVar;
            lazySet(-4611686018427387904L);
        }

        public long a(long j2) {
            long j3;
            long j4;
            if (j2 <= 0) {
                throw new IllegalArgumentException("Cant produce zero or less");
            }
            do {
                j3 = get();
                if (j3 == -4611686018427387904L) {
                    throw new IllegalStateException("Produced without request");
                }
                if (j3 == Long.MIN_VALUE) {
                    return Long.MIN_VALUE;
                }
                j4 = j3 - j2;
                if (j4 < 0) {
                    throw new IllegalStateException("More produced (" + j2 + ") than requested (" + j3 + ")");
                }
            } while (!compareAndSet(j3, j4));
            return j4;
        }

        @Override // rx.k
        public boolean isUnsubscribed() {
            return get() == Long.MIN_VALUE;
        }

        @Override // rx.g
        public void request(long j2) {
            long j3;
            long j4;
            if (j2 < 0) {
                return;
            }
            do {
                j3 = get();
                if (j3 == Long.MIN_VALUE) {
                    return;
                }
                if (j3 >= 0 && j2 == 0) {
                    return;
                }
                if (j3 == -4611686018427387904L) {
                    j4 = j2;
                } else {
                    j4 = j3 + j2;
                    if (j4 < 0) {
                        j4 = Long.MAX_VALUE;
                    }
                }
            } while (!compareAndSet(j3, j4));
            this.f26506f.e();
        }

        @Override // rx.k
        public void unsubscribe() {
            if (get() == Long.MIN_VALUE || getAndSet(Long.MIN_VALUE) == Long.MIN_VALUE) {
                return;
            }
            this.f26506f.g(this);
            this.f26506f.e();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OperatorPublish.java */
    /* loaded from: classes3.dex */
    public static final class c<T> extends rx.j<T> implements rx.k {

        /* renamed from: f, reason: collision with root package name */
        static final b[] f26508f = new b[0];

        /* renamed from: g, reason: collision with root package name */
        static final b[] f26509g = new b[0];

        /* renamed from: h, reason: collision with root package name */
        final Queue<Object> f26510h;

        /* renamed from: i, reason: collision with root package name */
        final AtomicReference<c<T>> f26511i;

        /* renamed from: j, reason: collision with root package name */
        volatile Object f26512j;

        /* renamed from: k, reason: collision with root package name */
        final AtomicReference<b[]> f26513k;
        final AtomicBoolean l;
        boolean m;
        boolean n;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: OperatorPublish.java */
        /* loaded from: classes3.dex */
        public class a implements rx.m.a {
            a() {
            }

            @Override // rx.m.a
            public void call() {
                c.this.f26513k.getAndSet(c.f26509g);
                c<T> cVar = c.this;
                cVar.f26511i.compareAndSet(cVar, null);
            }
        }

        public c(AtomicReference<c<T>> atomicReference) {
            this.f26510h = rx.n.e.o.z.b() ? new rx.n.e.o.s<>(rx.n.e.h.f26744f) : new rx.n.e.n.e<>(rx.n.e.h.f26744f);
            this.f26513k = new AtomicReference<>(f26508f);
            this.f26511i = atomicReference;
            this.l = new AtomicBoolean();
        }

        boolean c(b<T> bVar) {
            b[] bVarArr;
            b[] bVarArr2;
            bVar.getClass();
            do {
                bVarArr = this.f26513k.get();
                if (bVarArr == f26509g) {
                    return false;
                }
                int length = bVarArr.length;
                bVarArr2 = new b[length + 1];
                System.arraycopy(bVarArr, 0, bVarArr2, 0, length);
                bVarArr2[length] = bVar;
            } while (!this.f26513k.compareAndSet(bVarArr, bVarArr2));
            return true;
        }

        boolean d(Object obj, boolean z) {
            int i2 = 0;
            if (obj != null) {
                if (!h.f(obj)) {
                    Throwable d2 = h.d(obj);
                    this.f26511i.compareAndSet(this, null);
                    try {
                        b[] andSet = this.f26513k.getAndSet(f26509g);
                        int length = andSet.length;
                        while (i2 < length) {
                            andSet[i2].f26507g.onError(d2);
                            i2++;
                        }
                        return true;
                    } finally {
                    }
                }
                if (z) {
                    this.f26511i.compareAndSet(this, null);
                    try {
                        b[] andSet2 = this.f26513k.getAndSet(f26509g);
                        int length2 = andSet2.length;
                        while (i2 < length2) {
                            andSet2[i2].f26507g.onCompleted();
                            i2++;
                        }
                        return true;
                    } finally {
                    }
                }
            }
            return false;
        }

        void e() {
            boolean z;
            long j2;
            synchronized (this) {
                if (this.m) {
                    this.n = true;
                    return;
                }
                this.m = true;
                this.n = false;
                while (true) {
                    try {
                        Object obj = this.f26512j;
                        boolean isEmpty = this.f26510h.isEmpty();
                        if (d(obj, isEmpty)) {
                            return;
                        }
                        if (!isEmpty) {
                            b[] bVarArr = this.f26513k.get();
                            int length = bVarArr.length;
                            long j3 = Long.MAX_VALUE;
                            int i2 = 0;
                            for (b bVar : bVarArr) {
                                long j4 = bVar.get();
                                if (j4 >= 0) {
                                    j3 = Math.min(j3, j4);
                                } else if (j4 == Long.MIN_VALUE) {
                                    i2++;
                                }
                            }
                            if (length != i2) {
                                int i3 = 0;
                                while (true) {
                                    j2 = i3;
                                    if (j2 >= j3) {
                                        break;
                                    }
                                    Object obj2 = this.f26512j;
                                    Object poll = this.f26510h.poll();
                                    boolean z2 = poll == null;
                                    if (d(obj2, z2)) {
                                        return;
                                    }
                                    if (z2) {
                                        isEmpty = z2;
                                        break;
                                    }
                                    Object e2 = h.e(poll);
                                    for (b bVar2 : bVarArr) {
                                        if (bVar2.get() > 0) {
                                            try {
                                                bVar2.f26507g.onNext(e2);
                                                bVar2.a(1L);
                                            } catch (Throwable th) {
                                                bVar2.unsubscribe();
                                                rx.exceptions.a.g(th, bVar2.f26507g, e2);
                                            }
                                        }
                                    }
                                    i3++;
                                    isEmpty = z2;
                                }
                                if (i3 > 0) {
                                    request(j2);
                                }
                                if (j3 != 0 && !isEmpty) {
                                }
                            } else if (d(this.f26512j, this.f26510h.poll() == null)) {
                                return;
                            } else {
                                request(1L);
                            }
                        }
                        synchronized (this) {
                            try {
                                if (!this.n) {
                                    this.m = false;
                                    try {
                                        return;
                                    } catch (Throwable th2) {
                                        th = th2;
                                        z = true;
                                        while (true) {
                                            try {
                                                break;
                                            } catch (Throwable th3) {
                                                th = th3;
                                            }
                                        }
                                        throw th;
                                    }
                                }
                                this.n = false;
                            } catch (Throwable th4) {
                                th = th4;
                                z = false;
                            }
                        }
                        try {
                            break;
                            throw th;
                        } catch (Throwable th5) {
                            th = th5;
                            if (!z) {
                                synchronized (this) {
                                    this.m = false;
                                }
                            }
                            throw th;
                        }
                    } catch (Throwable th6) {
                        th = th6;
                        z = false;
                    }
                }
            }
        }

        void f() {
            add(rx.t.e.a(new a()));
        }

        void g(b<T> bVar) {
            b[] bVarArr;
            b[] bVarArr2;
            do {
                bVarArr = this.f26513k.get();
                if (bVarArr == f26508f || bVarArr == f26509g) {
                    return;
                }
                int i2 = -1;
                int length = bVarArr.length;
                int i3 = 0;
                while (true) {
                    if (i3 >= length) {
                        break;
                    }
                    if (bVarArr[i3].equals(bVar)) {
                        i2 = i3;
                        break;
                    }
                    i3++;
                }
                if (i2 < 0) {
                    return;
                }
                if (length == 1) {
                    bVarArr2 = f26508f;
                } else {
                    b[] bVarArr3 = new b[length - 1];
                    System.arraycopy(bVarArr, 0, bVarArr3, 0, i2);
                    System.arraycopy(bVarArr, i2 + 1, bVarArr3, i2, (length - i2) - 1);
                    bVarArr2 = bVarArr3;
                }
            } while (!this.f26513k.compareAndSet(bVarArr, bVarArr2));
        }

        @Override // rx.f
        public void onCompleted() {
            if (this.f26512j == null) {
                this.f26512j = h.b();
                e();
            }
        }

        @Override // rx.f
        public void onError(Throwable th) {
            if (this.f26512j == null) {
                this.f26512j = h.c(th);
                e();
            }
        }

        @Override // rx.f
        public void onNext(T t) {
            if (!this.f26510h.offer(h.g(t))) {
                onError(new MissingBackpressureException());
            } else {
                e();
            }
        }

        @Override // rx.j
        public void onStart() {
            request(rx.n.e.h.f26744f);
        }
    }

    private u0(e.a<T> aVar, rx.e<? extends T> eVar, AtomicReference<c<T>> atomicReference) {
        super(aVar);
        this.f26503g = eVar;
        this.f26504h = atomicReference;
    }

    public static <T> rx.o.b<T> k1(rx.e<? extends T> eVar) {
        AtomicReference atomicReference = new AtomicReference();
        return new u0(new a(atomicReference), eVar, atomicReference);
    }

    @Override // rx.o.b
    public void i1(rx.m.b<? super rx.k> bVar) {
        c<T> cVar;
        while (true) {
            cVar = this.f26504h.get();
            if (cVar != null && !cVar.isUnsubscribed()) {
                break;
            }
            c<T> cVar2 = new c<>(this.f26504h);
            cVar2.f();
            if (this.f26504h.compareAndSet(cVar, cVar2)) {
                cVar = cVar2;
                break;
            }
        }
        boolean z = !cVar.l.get() && cVar.l.compareAndSet(false, true);
        bVar.call(cVar);
        if (z) {
            this.f26503g.c1(cVar);
        }
    }
}
