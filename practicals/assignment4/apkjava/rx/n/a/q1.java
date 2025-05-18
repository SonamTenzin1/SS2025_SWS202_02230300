package rx.n.a;

import rx.Single;

/* compiled from: SingleOperatorOnErrorResumeNext.java */
/* loaded from: classes3.dex */
public final class q1<T> implements Single.j<T> {

    /* renamed from: f, reason: collision with root package name */
    private final Single<? extends T> f26432f;

    /* renamed from: g, reason: collision with root package name */
    final rx.m.e<Throwable, ? extends Single<? extends T>> f26433g;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SingleOperatorOnErrorResumeNext.java */
    /* loaded from: classes3.dex */
    public class a extends rx.i<T> {

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ rx.i f26434g;

        a(rx.i iVar) {
            this.f26434g = iVar;
        }

        @Override // rx.i
        public void c(T t) {
            this.f26434g.c(t);
        }

        @Override // rx.i
        public void onError(Throwable th) {
            try {
                q1.this.f26433g.call(th).t(this.f26434g);
            } catch (Throwable th2) {
                rx.exceptions.a.h(th2, this.f26434g);
            }
        }
    }

    private q1(Single<? extends T> single, rx.m.e<Throwable, ? extends Single<? extends T>> eVar) {
        if (single == null) {
            throw new NullPointerException("originalSingle must not be null");
        }
        if (eVar != null) {
            this.f26432f = single;
            this.f26433g = eVar;
            return;
        }
        throw new NullPointerException("resumeFunctionInCaseOfError must not be null");
    }

    public static <T> q1<T> b(Single<? extends T> single, rx.m.e<Throwable, ? extends Single<? extends T>> eVar) {
        return new q1<>(single, eVar);
    }

    @Override // rx.m.b
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void call(rx.i<? super T> iVar) {
        a aVar = new a(iVar);
        iVar.b(aVar);
        this.f26432f.t(aVar);
    }
}
