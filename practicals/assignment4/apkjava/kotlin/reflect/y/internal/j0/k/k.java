package kotlin.reflect.y.internal.j0.k;

import kotlin.jvm.functions.Function1;
import kotlin.u;

/* compiled from: locks.kt */
/* loaded from: classes3.dex */
public interface k {
    public static final a a = a.a;

    /* compiled from: locks.kt */
    /* loaded from: classes3.dex */
    public static final class a {
        static final /* synthetic */ a a = new a();

        private a() {
        }

        public final d a(Runnable runnable, Function1<? super InterruptedException, u> function1) {
            if (runnable != null && function1 != null) {
                return new c(runnable, function1);
            }
            return new d(null, 1, null);
        }
    }

    void lock();

    void unlock();
}
