package kotlin.reflect.y.internal.j0.k;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.m;

/* compiled from: locks.kt */
/* loaded from: classes3.dex */
public class d implements k {

    /* renamed from: b, reason: collision with root package name */
    private final Lock f24648b;

    public d(Lock lock) {
        m.f(lock, "lock");
        this.f24648b = lock;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Lock a() {
        return this.f24648b;
    }

    @Override // kotlin.reflect.y.internal.j0.k.k
    public void lock() {
        this.f24648b.lock();
    }

    @Override // kotlin.reflect.y.internal.j0.k.k
    public void unlock() {
        this.f24648b.unlock();
    }

    public /* synthetic */ d(Lock lock, int i2, g gVar) {
        this((i2 & 1) != 0 ? new ReentrantLock() : lock);
    }
}
