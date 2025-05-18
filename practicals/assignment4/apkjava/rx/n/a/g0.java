package rx.n.a;

import java.util.concurrent.TimeUnit;
import rx.e;
import rx.h;

/* compiled from: OnSubscribeTimerPeriodically.java */
/* loaded from: classes3.dex */
public final class g0 implements e.a<Long> {

    /* renamed from: f, reason: collision with root package name */
    final long f26220f;

    /* renamed from: g, reason: collision with root package name */
    final long f26221g;

    /* renamed from: h, reason: collision with root package name */
    final TimeUnit f26222h;

    /* renamed from: i, reason: collision with root package name */
    final rx.h f26223i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OnSubscribeTimerPeriodically.java */
    /* loaded from: classes3.dex */
    public class a implements rx.m.a {

        /* renamed from: f, reason: collision with root package name */
        long f26224f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ rx.j f26225g;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ h.a f26226h;

        a(rx.j jVar, h.a aVar) {
            this.f26225g = jVar;
            this.f26226h = aVar;
        }

        @Override // rx.m.a
        public void call() {
            try {
                rx.j jVar = this.f26225g;
                long j2 = this.f26224f;
                this.f26224f = 1 + j2;
                jVar.onNext(Long.valueOf(j2));
            } catch (Throwable th) {
                try {
                    this.f26226h.unsubscribe();
                } finally {
                    rx.exceptions.a.f(th, this.f26225g);
                }
            }
        }
    }

    public g0(long j2, long j3, TimeUnit timeUnit, rx.h hVar) {
        this.f26220f = j2;
        this.f26221g = j3;
        this.f26222h = timeUnit;
        this.f26223i = hVar;
    }

    @Override // rx.m.b
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void call(rx.j<? super Long> jVar) {
        h.a createWorker = this.f26223i.createWorker();
        jVar.add(createWorker);
        createWorker.e(new a(jVar, createWorker), this.f26220f, this.f26221g, this.f26222h);
    }
}
