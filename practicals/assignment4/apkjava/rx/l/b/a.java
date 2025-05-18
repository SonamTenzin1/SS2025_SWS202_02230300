package rx.l.b;

import java.util.concurrent.atomic.AtomicReference;

/* compiled from: RxAndroidPlugins.java */
/* loaded from: classes3.dex */
public final class a {
    private static final a a = new a();

    /* renamed from: b, reason: collision with root package name */
    private final AtomicReference<b> f26097b = new AtomicReference<>();

    a() {
    }

    public static a a() {
        return a;
    }

    public b b() {
        if (this.f26097b.get() == null) {
            this.f26097b.compareAndSet(null, b.a());
        }
        return this.f26097b.get();
    }
}
