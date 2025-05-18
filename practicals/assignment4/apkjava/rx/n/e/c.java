package rx.n.e;

import java.util.concurrent.atomic.AtomicLong;

/* compiled from: BackpressureDrainManager.java */
/* loaded from: classes3.dex */
public final class c extends AtomicLong implements rx.g {

    /* renamed from: f, reason: collision with root package name */
    boolean f26730f;

    /* renamed from: g, reason: collision with root package name */
    volatile boolean f26731g;

    /* renamed from: h, reason: collision with root package name */
    Throwable f26732h;

    /* renamed from: i, reason: collision with root package name */
    final a f26733i;

    /* compiled from: BackpressureDrainManager.java */
    /* loaded from: classes3.dex */
    public interface a {
        boolean a(Object obj);

        void b(Throwable th);

        Object peek();

        Object poll();
    }

    public c(a aVar) {
        this.f26733i = aVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0038, code lost:
    
        monitor-enter(r13);
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0039, code lost:
    
        r1 = r13.f26731g;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x003f, code lost:
    
        if (r5.peek() == null) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0041, code lost:
    
        r2 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x004f, code lost:
    
        if (get() != Long.MAX_VALUE) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0051, code lost:
    
        if (r2 != false) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0053, code lost:
    
        if (r1 != false) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0055, code lost:
    
        r13.f26730f = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0057, code lost:
    
        monitor-exit(r13);
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0058, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0059, code lost:
    
        r2 = Long.MAX_VALUE;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x005d, code lost:
    
        r9 = addAndGet(-r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0063, code lost:
    
        if (r9 == 0) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0065, code lost:
    
        if (r2 != false) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x006c, code lost:
    
        r2 = r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0067, code lost:
    
        if (r1 == false) goto L91;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0069, code lost:
    
        if (r2 == false) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x006f, code lost:
    
        r13.f26730f = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0071, code lost:
    
        monitor-exit(r13);
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0072, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0043, code lost:
    
        r2 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0073, code lost:
    
        r1 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0075, code lost:
    
        monitor-exit(r13);
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0076, code lost:
    
        throw r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x002f, code lost:
    
        if (r2 == 0) goto L85;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a() {
        synchronized (this) {
            if (this.f26730f) {
                return;
            }
            boolean z = true;
            this.f26730f = true;
            boolean z2 = this.f26731g;
            long j2 = get();
            try {
                a aVar = this.f26733i;
                while (true) {
                    int i2 = 0;
                    while (true) {
                        try {
                            if (j2 > 0 || z2) {
                                if (z2) {
                                    if (aVar.peek() == null) {
                                        aVar.b(this.f26732h);
                                        return;
                                    }
                                }
                                Object poll = aVar.poll();
                                if (poll != null) {
                                    if (aVar.a(poll)) {
                                        return;
                                    }
                                    j2--;
                                    i2++;
                                }
                            }
                            try {
                                break;
                            } catch (Throwable th) {
                                th = th;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            if (!z) {
                                synchronized (this) {
                                    this.f26730f = false;
                                }
                            }
                            throw th;
                        }
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                z = false;
            }
        }
    }

    public void b() {
        this.f26731g = true;
        a();
    }

    public void c(Throwable th) {
        if (this.f26731g) {
            return;
        }
        this.f26732h = th;
        this.f26731g = true;
        a();
    }

    @Override // rx.g
    public void request(long j2) {
        boolean z;
        long j3;
        if (j2 == 0) {
            return;
        }
        while (true) {
            long j4 = get();
            boolean z2 = true;
            z = j4 == 0;
            if (j4 == Long.MAX_VALUE) {
                break;
            }
            if (j2 == Long.MAX_VALUE) {
                j3 = j2;
            } else {
                j3 = j4 <= Long.MAX_VALUE - j2 ? j4 + j2 : Long.MAX_VALUE;
                z2 = z;
            }
            if (compareAndSet(j4, j3)) {
                z = z2;
                break;
            }
        }
        if (z) {
            a();
        }
    }
}
