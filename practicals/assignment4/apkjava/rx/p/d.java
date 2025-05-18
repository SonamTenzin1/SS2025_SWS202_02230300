package rx.p;

import rx.exceptions.OnErrorThrowable;
import rx.n.a.h;

/* compiled from: SerializedObserver.java */
/* loaded from: classes3.dex */
public class d<T> implements rx.f<T> {

    /* renamed from: f, reason: collision with root package name */
    private final rx.f<? super T> f26835f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f26836g;

    /* renamed from: h, reason: collision with root package name */
    private volatile boolean f26837h;

    /* renamed from: i, reason: collision with root package name */
    private a f26838i;

    /* compiled from: SerializedObserver.java */
    /* loaded from: classes3.dex */
    static final class a {
        Object[] a;

        /* renamed from: b, reason: collision with root package name */
        int f26839b;

        a() {
        }

        public void a(Object obj) {
            int i2 = this.f26839b;
            Object[] objArr = this.a;
            if (objArr == null) {
                objArr = new Object[16];
                this.a = objArr;
            } else if (i2 == objArr.length) {
                Object[] objArr2 = new Object[(i2 >> 2) + i2];
                System.arraycopy(objArr, 0, objArr2, 0, i2);
                this.a = objArr2;
                objArr = objArr2;
            }
            objArr[i2] = obj;
            this.f26839b = i2 + 1;
        }
    }

    public d(rx.f<? super T> fVar) {
        this.f26835f = fVar;
    }

    @Override // rx.f
    public void onCompleted() {
        if (this.f26837h) {
            return;
        }
        synchronized (this) {
            if (this.f26837h) {
                return;
            }
            this.f26837h = true;
            if (this.f26836g) {
                a aVar = this.f26838i;
                if (aVar == null) {
                    aVar = new a();
                    this.f26838i = aVar;
                }
                aVar.a(h.b());
                return;
            }
            this.f26836g = true;
            this.f26835f.onCompleted();
        }
    }

    @Override // rx.f
    public void onError(Throwable th) {
        rx.exceptions.a.e(th);
        if (this.f26837h) {
            return;
        }
        synchronized (this) {
            if (this.f26837h) {
                return;
            }
            this.f26837h = true;
            if (this.f26836g) {
                a aVar = this.f26838i;
                if (aVar == null) {
                    aVar = new a();
                    this.f26838i = aVar;
                }
                aVar.a(h.c(th));
                return;
            }
            this.f26836g = true;
            this.f26835f.onError(th);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:44:0x002d, code lost:
    
        continue;
     */
    @Override // rx.f
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onNext(T t) {
        if (this.f26837h) {
            return;
        }
        synchronized (this) {
            if (this.f26837h) {
                return;
            }
            if (this.f26836g) {
                a aVar = this.f26838i;
                if (aVar == null) {
                    aVar = new a();
                    this.f26838i = aVar;
                }
                aVar.a(h.g(t));
                return;
            }
            this.f26836g = true;
            try {
                this.f26835f.onNext(t);
                while (true) {
                    synchronized (this) {
                        a aVar2 = this.f26838i;
                        if (aVar2 == null) {
                            this.f26836g = false;
                            return;
                        }
                        this.f26838i = null;
                        for (Object obj : aVar2.a) {
                            if (obj == null) {
                                break;
                            }
                            try {
                                if (h.a(this.f26835f, obj)) {
                                    this.f26837h = true;
                                    return;
                                }
                            } catch (Throwable th) {
                                this.f26837h = true;
                                rx.exceptions.a.e(th);
                                this.f26835f.onError(OnErrorThrowable.a(th, t));
                                return;
                            }
                        }
                    }
                }
            } catch (Throwable th2) {
                this.f26837h = true;
                rx.exceptions.a.g(th2, this.f26835f, t);
            }
        }
    }
}
