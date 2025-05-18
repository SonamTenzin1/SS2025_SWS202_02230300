package rx.n.e;

import java.util.Queue;
import rx.exceptions.MissingBackpressureException;
import rx.n.e.o.s;
import rx.n.e.o.z;

/* compiled from: RxRingBuffer.java */
/* loaded from: classes3.dex */
public class h implements rx.k {

    /* renamed from: f, reason: collision with root package name */
    public static final int f26744f;

    /* renamed from: g, reason: collision with root package name */
    private Queue<Object> f26745g;

    /* renamed from: h, reason: collision with root package name */
    private final int f26746h;

    /* renamed from: i, reason: collision with root package name */
    public volatile Object f26747i;

    static {
        int i2 = g.b() ? 16 : 128;
        String property = System.getProperty("rx.ring-buffer.size");
        if (property != null) {
            try {
                i2 = Integer.parseInt(property);
            } catch (NumberFormatException e2) {
                System.err.println("Failed to set 'rx.buffer.size' with value " + property + " => " + e2.getMessage());
            }
        }
        f26744f = i2;
    }

    private h(Queue<Object> queue, int i2) {
        this.f26745g = queue;
        this.f26746h = i2;
    }

    public static h a() {
        if (z.b()) {
            return new h(true, f26744f);
        }
        return new h();
    }

    public static h b() {
        if (z.b()) {
            return new h(false, f26744f);
        }
        return new h();
    }

    public Object c(Object obj) {
        return rx.n.a.h.e(obj);
    }

    public boolean d(Object obj) {
        return rx.n.a.h.f(obj);
    }

    public boolean e() {
        Queue<Object> queue = this.f26745g;
        return queue == null || queue.isEmpty();
    }

    public void f() {
        if (this.f26747i == null) {
            this.f26747i = rx.n.a.h.b();
        }
    }

    public void g(Object obj) throws MissingBackpressureException {
        boolean z;
        boolean z2;
        synchronized (this) {
            Queue<Object> queue = this.f26745g;
            z = true;
            z2 = false;
            if (queue != null) {
                z2 = !queue.offer(rx.n.a.h.g(obj));
                z = false;
            }
        }
        if (z) {
            throw new IllegalStateException("This instance has been unsubscribed and the queue is no longer usable.");
        }
        if (z2) {
            throw new MissingBackpressureException();
        }
    }

    public Object h() {
        synchronized (this) {
            Queue<Object> queue = this.f26745g;
            if (queue == null) {
                return null;
            }
            Object peek = queue.peek();
            Object obj = this.f26747i;
            if (peek == null && obj != null && queue.peek() == null) {
                peek = obj;
            }
            return peek;
        }
    }

    public Object i() {
        synchronized (this) {
            Queue<Object> queue = this.f26745g;
            if (queue == null) {
                return null;
            }
            Object poll = queue.poll();
            Object obj = this.f26747i;
            if (poll == null && obj != null && queue.peek() == null) {
                this.f26747i = null;
                poll = obj;
            }
            return poll;
        }
    }

    @Override // rx.k
    public boolean isUnsubscribed() {
        return this.f26745g == null;
    }

    public synchronized void j() {
    }

    @Override // rx.k
    public void unsubscribe() {
        j();
    }

    private h(boolean z, int i2) {
        this.f26745g = z ? new rx.n.e.o.k<>(i2) : new s<>(i2);
        this.f26746h = i2;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    h() {
        this(new rx.n.e.n.e(r1), r1);
        int i2 = f26744f;
    }
}
