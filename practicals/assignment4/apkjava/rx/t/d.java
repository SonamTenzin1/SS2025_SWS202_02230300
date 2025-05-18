package rx.t;

import rx.k;

/* compiled from: SerialSubscription.java */
/* loaded from: classes3.dex */
public final class d implements k {

    /* renamed from: f, reason: collision with root package name */
    final rx.n.d.a f26911f = new rx.n.d.a();

    public k a() {
        return this.f26911f.a();
    }

    public void b(k kVar) {
        if (kVar != null) {
            this.f26911f.c(kVar);
            return;
        }
        throw new IllegalArgumentException("Subscription can not be null");
    }

    @Override // rx.k
    public boolean isUnsubscribed() {
        return this.f26911f.isUnsubscribed();
    }

    @Override // rx.k
    public void unsubscribe() {
        this.f26911f.unsubscribe();
    }
}
