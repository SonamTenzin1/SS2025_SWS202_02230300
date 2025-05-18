package rx.n.a;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import rx.e;

/* compiled from: OperatorToObservableSortedList.java */
/* loaded from: classes3.dex */
public final class f1<T> implements e.b<List<T>, T> {

    /* renamed from: f, reason: collision with root package name */
    private static final Comparator f26207f = new c();

    /* renamed from: g, reason: collision with root package name */
    final Comparator<? super T> f26208g;

    /* renamed from: h, reason: collision with root package name */
    final int f26209h;

    /* compiled from: OperatorToObservableSortedList.java */
    /* loaded from: classes3.dex */
    class a implements Comparator<T> {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ rx.m.f f26210f;

        a(rx.m.f fVar) {
            this.f26210f = fVar;
        }

        @Override // java.util.Comparator
        public int compare(T t, T t2) {
            return ((Integer) this.f26210f.a(t, t2)).intValue();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OperatorToObservableSortedList.java */
    /* loaded from: classes3.dex */
    public class b extends rx.j<T> {

        /* renamed from: f, reason: collision with root package name */
        List<T> f26212f;

        /* renamed from: g, reason: collision with root package name */
        boolean f26213g;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ rx.n.b.b f26214h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ rx.j f26215i;

        b(rx.n.b.b bVar, rx.j jVar) {
            this.f26214h = bVar;
            this.f26215i = jVar;
            this.f26212f = new ArrayList(f1.this.f26209h);
        }

        @Override // rx.f
        public void onCompleted() {
            if (this.f26213g) {
                return;
            }
            this.f26213g = true;
            List<T> list = this.f26212f;
            this.f26212f = null;
            try {
                Collections.sort(list, f1.this.f26208g);
                this.f26214h.b(list);
            } catch (Throwable th) {
                rx.exceptions.a.f(th, this);
            }
        }

        @Override // rx.f
        public void onError(Throwable th) {
            this.f26215i.onError(th);
        }

        @Override // rx.f
        public void onNext(T t) {
            if (this.f26213g) {
                return;
            }
            this.f26212f.add(t);
        }

        @Override // rx.j
        public void onStart() {
            request(Long.MAX_VALUE);
        }
    }

    /* compiled from: OperatorToObservableSortedList.java */
    /* loaded from: classes3.dex */
    static final class c implements Comparator<Object> {
        c() {
        }

        @Override // java.util.Comparator
        public int compare(Object obj, Object obj2) {
            return ((Comparable) obj).compareTo((Comparable) obj2);
        }
    }

    public f1(rx.m.f<? super T, ? super T, Integer> fVar, int i2) {
        this.f26209h = i2;
        this.f26208g = new a(fVar);
    }

    @Override // rx.m.e
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public rx.j<? super T> call(rx.j<? super List<T>> jVar) {
        rx.n.b.b bVar = new rx.n.b.b(jVar);
        b bVar2 = new b(bVar, jVar);
        jVar.add(bVar2);
        jVar.setProducer(bVar);
        return bVar2;
    }
}
