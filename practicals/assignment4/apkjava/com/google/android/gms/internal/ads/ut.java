package com.google.android.gms.internal.ads;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes2.dex */
final class ut {
    private final ConcurrentHashMap<vt, List<Throwable>> a = new ConcurrentHashMap<>(16, 0.75f, 10);

    /* renamed from: b, reason: collision with root package name */
    private final ReferenceQueue<Throwable> f13410b = new ReferenceQueue<>();

    public final List<Throwable> a(Throwable th, boolean z) {
        Reference<? extends Throwable> poll = this.f13410b.poll();
        while (poll != null) {
            this.a.remove(poll);
            poll = this.f13410b.poll();
        }
        List<Throwable> list = this.a.get(new vt(th, null));
        if (!z || list != null) {
            return list;
        }
        Vector vector = new Vector(2);
        List<Throwable> putIfAbsent = this.a.putIfAbsent(new vt(th, this.f13410b), vector);
        return putIfAbsent == null ? vector : putIfAbsent;
    }
}
