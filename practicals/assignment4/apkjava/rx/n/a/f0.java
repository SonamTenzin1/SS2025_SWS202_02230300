package rx.n.a;

import java.util.concurrent.TimeUnit;
import rx.e;
import rx.h;

/* compiled from: OnSubscribeTimerOnce.java */
/* loaded from: classes3.dex */
public final class f0 implements e.a<Long> {

    /* renamed from: f, reason: collision with root package name */
    final long f26202f;

    /* renamed from: g, reason: collision with root package name */
    final TimeUnit f26203g;

    /* renamed from: h, reason: collision with root package name */
    final rx.h f26204h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OnSubscribeTimerOnce.java */
    /* loaded from: classes3.dex */
    public class a implements rx.m.a {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ rx.j f26205f;

        a(rx.j jVar) {
            this.f26205f = jVar;
        }

        @Override // rx.m.a
        public void call() {
            try {
                this.f26205f.onNext(0L);
                this.f26205f.onCompleted();
            } catch (Throwable th) {
                rx.exceptions.a.f(th, this.f26205f);
            }
        }
    }

    public f0(long j2, TimeUnit timeUnit, rx.h hVar) {
        this.f26202f = j2;
        this.f26203g = timeUnit;
        this.f26204h = hVar;
    }

    @Override // rx.m.b
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void call(rx.j<? super Long> jVar) {
        h.a createWorker = this.f26204h.createWorker();
        jVar.add(createWorker);
        createWorker.d(new a(jVar), this.f26202f, this.f26203g);
    }
}
