package e.g.a.b.b.a;

import c.v.a.c;
import rx.e;
import rx.j;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SwipeRefreshLayoutRefreshOnSubscribe.java */
/* loaded from: classes2.dex */
public final class d implements e.a<Void> {

    /* renamed from: f, reason: collision with root package name */
    final c.v.a.c f21144f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SwipeRefreshLayoutRefreshOnSubscribe.java */
    /* loaded from: classes2.dex */
    public class a implements c.j {
        final /* synthetic */ j a;

        a(j jVar) {
            this.a = jVar;
        }

        @Override // c.v.a.c.j
        public void a() {
            if (this.a.isUnsubscribed()) {
                return;
            }
            this.a.onNext(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SwipeRefreshLayoutRefreshOnSubscribe.java */
    /* loaded from: classes2.dex */
    public class b extends rx.l.a {
        b() {
        }

        @Override // rx.l.a
        protected void onUnsubscribe() {
            d.this.f21144f.setOnRefreshListener(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c.v.a.c cVar) {
        this.f21144f = cVar;
    }

    @Override // rx.m.b
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void call(j<? super Void> jVar) {
        rx.l.a.verifyMainThread();
        a aVar = new a(jVar);
        jVar.add(new b());
        this.f21144f.setOnRefreshListener(aVar);
    }
}
