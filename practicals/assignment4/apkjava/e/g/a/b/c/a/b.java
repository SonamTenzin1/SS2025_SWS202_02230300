package e.g.a.b.c.a;

import androidx.recyclerview.widget.RecyclerView;
import rx.e;
import rx.j;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: RecyclerViewScrollEventOnSubscribe.java */
/* loaded from: classes2.dex */
public final class b implements e.a<e.g.a.b.c.a.a> {

    /* renamed from: f, reason: collision with root package name */
    final RecyclerView f21149f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: RecyclerViewScrollEventOnSubscribe.java */
    /* loaded from: classes2.dex */
    public class a extends RecyclerView.t {
        final /* synthetic */ j a;

        a(j jVar) {
            this.a = jVar;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.t
        public void onScrolled(RecyclerView recyclerView, int i2, int i3) {
            if (this.a.isUnsubscribed()) {
                return;
            }
            this.a.onNext(e.g.a.b.c.a.a.b(recyclerView, i2, i3));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: RecyclerViewScrollEventOnSubscribe.java */
    /* renamed from: e.g.a.b.c.a.b$b, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0268b extends rx.l.a {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ RecyclerView.t f21151f;

        C0268b(RecyclerView.t tVar) {
            this.f21151f = tVar;
        }

        @Override // rx.l.a
        protected void onUnsubscribe() {
            b.this.f21149f.removeOnScrollListener(this.f21151f);
        }
    }

    public b(RecyclerView recyclerView) {
        this.f21149f = recyclerView;
    }

    @Override // rx.m.b
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void call(j<? super e.g.a.b.c.a.a> jVar) {
        rx.l.a.verifyMainThread();
        a aVar = new a(jVar);
        jVar.add(new C0268b(aVar));
        this.f21149f.addOnScrollListener(aVar);
    }
}
