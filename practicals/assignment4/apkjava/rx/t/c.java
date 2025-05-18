package rx.t;

import rx.k;

/* compiled from: MultipleAssignmentSubscription.java */
/* loaded from: classes3.dex */
public final class c implements k {

    /* renamed from: f, reason: collision with root package name */
    final rx.n.d.a f26910f = new rx.n.d.a();

    public void a(k kVar) {
        if (kVar != null) {
            this.f26910f.b(kVar);
            return;
        }
        throw new IllegalArgumentException("Subscription can not be null");
    }

    @Override // rx.k
    public boolean isUnsubscribed() {
        return this.f26910f.isUnsubscribed();
    }

    @Override // rx.k
    public void unsubscribe() {
        this.f26910f.unsubscribe();
    }
}
