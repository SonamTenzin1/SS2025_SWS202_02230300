package rx.schedulers;

import rx.h;

@Deprecated
/* loaded from: classes3.dex */
public final class ImmediateScheduler extends h {
    private ImmediateScheduler() {
        throw new IllegalStateException("No instances!");
    }

    @Override // rx.h
    public h.a createWorker() {
        return null;
    }
}
