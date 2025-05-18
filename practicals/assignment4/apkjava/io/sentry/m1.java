package io.sentry;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.jetbrains.annotations.ApiStatus;

/* compiled from: FullyDisplayedReporter.java */
@ApiStatus.Internal
/* loaded from: classes2.dex */
public final class m1 {
    private static final m1 a = new m1();

    /* renamed from: b, reason: collision with root package name */
    private final List<a> f22493b = new CopyOnWriteArrayList();

    /* compiled from: FullyDisplayedReporter.java */
    @ApiStatus.Internal
    /* loaded from: classes2.dex */
    public interface a {
    }

    private m1() {
    }

    public static m1 a() {
        return a;
    }

    public void b(a aVar) {
        this.f22493b.add(aVar);
    }
}
