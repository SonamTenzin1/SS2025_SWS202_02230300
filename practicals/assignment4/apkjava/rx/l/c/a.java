package rx.l.c;

import android.os.Looper;
import java.util.concurrent.atomic.AtomicReference;
import rx.h;

/* compiled from: AndroidSchedulers.java */
/* loaded from: classes.dex */
public final class a {
    private static final AtomicReference<a> a = new AtomicReference<>();

    /* renamed from: b, reason: collision with root package name */
    private final h f26098b;

    private a() {
        h b2 = rx.l.b.a.a().b().b();
        if (b2 != null) {
            this.f26098b = b2;
        } else {
            this.f26098b = new b(Looper.getMainLooper());
        }
    }

    private static a a() {
        AtomicReference<a> atomicReference;
        a aVar;
        do {
            atomicReference = a;
            a aVar2 = atomicReference.get();
            if (aVar2 != null) {
                return aVar2;
            }
            aVar = new a();
        } while (!atomicReference.compareAndSet(null, aVar));
        return aVar;
    }

    public static h b() {
        return a().f26098b;
    }
}
