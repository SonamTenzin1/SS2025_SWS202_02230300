package cm.aptoide.pt.util;

import cm.aptoide.pt.utils.BaseException;
import rx.e;
import rx.j;

/* loaded from: classes.dex */
public class RxJavaStackTracer extends rx.q.d {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class OperatorTraceOnError<T> implements e.b<T, T> {
        private final StackTraceElement[] trace = new Throwable().getStackTrace();

        /* loaded from: classes.dex */
        private static class TracedException extends RuntimeException {
            public TracedException(Throwable th, StackTraceElement[] stackTraceElementArr) {
                super(th);
                setStackTrace(stackTraceElementArr);
            }
        }

        OperatorTraceOnError() {
        }

        public static <T> OperatorTraceOnError<T> traceOnError() {
            return new OperatorTraceOnError<>();
        }

        @Override // rx.m.e
        public j<? super T> call(final j<? super T> jVar) {
            j<T> jVar2 = new j<T>() { // from class: cm.aptoide.pt.util.RxJavaStackTracer.OperatorTraceOnError.1
                @Override // rx.f
                public void onCompleted() {
                    jVar.onCompleted();
                }

                @Override // rx.f
                public void onError(Throwable th) {
                    if (!BaseException.class.isAssignableFrom(th.getClass())) {
                        jVar.onError(new TracedException(th, OperatorTraceOnError.this.trace));
                    } else {
                        jVar.onError(th);
                    }
                }

                @Override // rx.f
                public void onNext(T t) {
                    jVar.onNext(t);
                }
            };
            jVar.add(jVar2);
            return jVar2;
        }
    }

    @Override // rx.q.d
    public <T> e.a<T> onSubscribeStart(rx.e<? extends T> eVar, final e.a<T> aVar) {
        return new e.a<T>() { // from class: cm.aptoide.pt.util.RxJavaStackTracer.1
            @Override // rx.m.b
            public void call(j<? super T> jVar) {
                try {
                    j<? super T> call = RxJavaStackTracer.this.onLift(OperatorTraceOnError.traceOnError()).call(jVar);
                    try {
                        call.onStart();
                        aVar.call(call);
                    } catch (Throwable th) {
                        rx.exceptions.a.e(th);
                        call.onError(th);
                    }
                } catch (Throwable th2) {
                    rx.exceptions.a.e(th2);
                    jVar.onError(th2);
                }
            }
        };
    }
}
