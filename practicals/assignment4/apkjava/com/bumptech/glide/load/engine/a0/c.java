package com.bumptech.glide.load.engine.a0;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* compiled from: DiskCacheWriteLocker.java */
/* loaded from: classes.dex */
final class c {
    private final Map<String, a> a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    private final b f9056b = new b();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: DiskCacheWriteLocker.java */
    /* loaded from: classes.dex */
    public static class a {
        final Lock a = new ReentrantLock();

        /* renamed from: b, reason: collision with root package name */
        int f9057b;

        a() {
        }
    }

    /* compiled from: DiskCacheWriteLocker.java */
    /* loaded from: classes.dex */
    private static class b {
        private final Queue<a> a = new ArrayDeque();

        b() {
        }

        a a() {
            a poll;
            synchronized (this.a) {
                poll = this.a.poll();
            }
            return poll == null ? new a() : poll;
        }

        void b(a aVar) {
            synchronized (this.a) {
                if (this.a.size() < 10) {
                    this.a.offer(aVar);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str) {
        a aVar;
        synchronized (this) {
            aVar = this.a.get(str);
            if (aVar == null) {
                aVar = this.f9056b.a();
                this.a.put(str, aVar);
            }
            aVar.f9057b++;
        }
        aVar.a.lock();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(String str) {
        a aVar;
        synchronized (this) {
            aVar = (a) com.bumptech.glide.r.j.d(this.a.get(str));
            int i2 = aVar.f9057b;
            if (i2 >= 1) {
                int i3 = i2 - 1;
                aVar.f9057b = i3;
                if (i3 == 0) {
                    a remove = this.a.remove(str);
                    if (remove.equals(aVar)) {
                        this.f9056b.b(remove);
                    } else {
                        throw new IllegalStateException("Removed the wrong lock, expected to remove: " + aVar + ", but actually removed: " + remove + ", safeKey: " + str);
                    }
                }
            } else {
                throw new IllegalStateException("Cannot release a lock that is not held, safeKey: " + str + ", interestedThreads: " + aVar.f9057b);
            }
        }
        aVar.a.unlock();
    }
}
