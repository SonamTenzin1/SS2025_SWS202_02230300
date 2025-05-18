package j;

import java.util.concurrent.atomic.AtomicReference;

/* compiled from: SegmentPool.kt */
/* loaded from: classes3.dex */
public final class z {

    /* renamed from: c, reason: collision with root package name */
    private static final int f22886c;

    /* renamed from: d, reason: collision with root package name */
    private static final AtomicReference<y>[] f22887d;

    /* renamed from: e, reason: collision with root package name */
    public static final z f22888e = new z();
    private static final int a = 65536;

    /* renamed from: b, reason: collision with root package name */
    private static final y f22885b = new y(new byte[0], 0, 0, false, false);

    static {
        int highestOneBit = Integer.highestOneBit((Runtime.getRuntime().availableProcessors() * 2) - 1);
        f22886c = highestOneBit;
        AtomicReference<y>[] atomicReferenceArr = new AtomicReference[highestOneBit];
        for (int i2 = 0; i2 < highestOneBit; i2++) {
            atomicReferenceArr[i2] = new AtomicReference<>();
        }
        f22887d = atomicReferenceArr;
    }

    private z() {
    }

    private final AtomicReference<y> a() {
        Thread currentThread = Thread.currentThread();
        kotlin.jvm.internal.m.e(currentThread, "Thread.currentThread()");
        return f22887d[(int) (currentThread.getId() & (f22886c - 1))];
    }

    public static final void b(y yVar) {
        AtomicReference<y> a2;
        y yVar2;
        kotlin.jvm.internal.m.f(yVar, "segment");
        if (yVar.f22883g == null && yVar.f22884h == null) {
            if (yVar.f22881e || (yVar2 = (a2 = f22888e.a()).get()) == f22885b) {
                return;
            }
            int i2 = yVar2 != null ? yVar2.f22880d : 0;
            if (i2 >= a) {
                return;
            }
            yVar.f22883g = yVar2;
            yVar.f22879c = 0;
            yVar.f22880d = i2 + 8192;
            if (a2.compareAndSet(yVar2, yVar)) {
                return;
            }
            yVar.f22883g = null;
            return;
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    public static final y c() {
        AtomicReference<y> a2 = f22888e.a();
        y yVar = f22885b;
        y andSet = a2.getAndSet(yVar);
        if (andSet == yVar) {
            return new y();
        }
        if (andSet == null) {
            a2.set(null);
            return new y();
        }
        a2.set(andSet.f22883g);
        andSet.f22883g = null;
        andSet.f22880d = 0;
        return andSet;
    }
}
