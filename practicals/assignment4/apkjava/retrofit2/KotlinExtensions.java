package retrofit2;

import java.lang.reflect.Method;
import kotlin.KotlinNullPointerException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.d;
import kotlin.coroutines.j.internal.h;
import kotlin.jvm.internal.m;
import kotlin.o;
import kotlin.u;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.Dispatchers;
import okhttp3.HttpUrl;

/* compiled from: KotlinExtensions.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0003\u001a\u001c\u0010\u0002\u001a\u00028\u0000\"\u0006\b\u0000\u0010\u0000\u0018\u0001*\u00020\u0001H\u0086\b¢\u0006\u0004\b\u0002\u0010\u0003\u001a'\u0010\u0006\u001a\u00028\u0000\"\b\b\u0000\u0010\u0000*\u00020\u0004*\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u001a+\u0010\u0006\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\u0000*\u00020\u0004*\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0005H\u0087@ø\u0001\u0000¢\u0006\u0004\b\b\u0010\u0007\u001a)\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\t\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0086@ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u0007\u001a\u001b\u0010\u000e\u001a\u00020\r*\u00060\u000bj\u0002`\fH\u0080@ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000f\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0010"}, d2 = {"T", "Lretrofit2/Retrofit;", "create", "(Lretrofit2/Retrofit;)Ljava/lang/Object;", HttpUrl.FRAGMENT_ENCODE_SET, "Lretrofit2/Call;", "await", "(Lretrofit2/Call;Lkotlin/y/d;)Ljava/lang/Object;", "awaitNullable", "Lretrofit2/Response;", "awaitResponse", "Ljava/lang/Exception;", "Lkotlin/Exception;", HttpUrl.FRAGMENT_ENCODE_SET, "suspendAndThrow", "(Ljava/lang/Exception;Lkotlin/y/d;)Ljava/lang/Object;", "retrofit"}, k = 2, mv = {1, 4, 0})
/* loaded from: classes3.dex */
public final class KotlinExtensions {
    public static final <T> Object await(Call<T> call, Continuation<? super T> continuation) {
        Continuation b2;
        Object c2;
        b2 = kotlin.coroutines.intrinsics.c.b(continuation);
        final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(b2, 1);
        cancellableContinuationImpl.e(new KotlinExtensions$await$$inlined$suspendCancellableCoroutine$lambda$1(call));
        call.enqueue(new Callback<T>() { // from class: retrofit2.KotlinExtensions$await$2$2
            @Override // retrofit2.Callback
            public void onFailure(Call<T> call2, Throwable t) {
                m.g(call2, "call");
                m.g(t, "t");
                CancellableContinuation cancellableContinuation = CancellableContinuation.this;
                Result.a aVar = Result.f25108f;
                cancellableContinuation.resumeWith(Result.a(o.a(t)));
            }

            @Override // retrofit2.Callback
            public void onResponse(Call<T> call2, Response<T> response) {
                m.g(call2, "call");
                m.g(response, "response");
                if (response.isSuccessful()) {
                    T body = response.body();
                    if (body == null) {
                        Object tag = call2.request().tag(Invocation.class);
                        if (tag == null) {
                            m.q();
                        }
                        m.b(tag, "call.request().tag(Invocation::class.java)!!");
                        Method method = ((Invocation) tag).method();
                        StringBuilder sb = new StringBuilder();
                        sb.append("Response from ");
                        m.b(method, "method");
                        Class<?> declaringClass = method.getDeclaringClass();
                        m.b(declaringClass, "method.declaringClass");
                        sb.append(declaringClass.getName());
                        sb.append('.');
                        sb.append(method.getName());
                        sb.append(" was null but response body type was declared as non-null");
                        KotlinNullPointerException kotlinNullPointerException = new KotlinNullPointerException(sb.toString());
                        CancellableContinuation cancellableContinuation = CancellableContinuation.this;
                        Result.a aVar = Result.f25108f;
                        cancellableContinuation.resumeWith(Result.a(o.a(kotlinNullPointerException)));
                        return;
                    }
                    CancellableContinuation cancellableContinuation2 = CancellableContinuation.this;
                    Result.a aVar2 = Result.f25108f;
                    cancellableContinuation2.resumeWith(Result.a(body));
                    return;
                }
                CancellableContinuation cancellableContinuation3 = CancellableContinuation.this;
                HttpException httpException = new HttpException(response);
                Result.a aVar3 = Result.f25108f;
                cancellableContinuation3.resumeWith(Result.a(o.a(httpException)));
            }
        });
        Object w = cancellableContinuationImpl.w();
        c2 = d.c();
        if (w == c2) {
            h.c(continuation);
        }
        return w;
    }

    public static final <T> Object awaitNullable(Call<T> call, Continuation<? super T> continuation) {
        Continuation b2;
        Object c2;
        b2 = kotlin.coroutines.intrinsics.c.b(continuation);
        final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(b2, 1);
        cancellableContinuationImpl.e(new KotlinExtensions$await$$inlined$suspendCancellableCoroutine$lambda$2(call));
        call.enqueue(new Callback<T>() { // from class: retrofit2.KotlinExtensions$await$4$2
            @Override // retrofit2.Callback
            public void onFailure(Call<T> call2, Throwable t) {
                m.g(call2, "call");
                m.g(t, "t");
                CancellableContinuation cancellableContinuation = CancellableContinuation.this;
                Result.a aVar = Result.f25108f;
                cancellableContinuation.resumeWith(Result.a(o.a(t)));
            }

            @Override // retrofit2.Callback
            public void onResponse(Call<T> call2, Response<T> response) {
                m.g(call2, "call");
                m.g(response, "response");
                if (response.isSuccessful()) {
                    CancellableContinuation cancellableContinuation = CancellableContinuation.this;
                    T body = response.body();
                    Result.a aVar = Result.f25108f;
                    cancellableContinuation.resumeWith(Result.a(body));
                    return;
                }
                CancellableContinuation cancellableContinuation2 = CancellableContinuation.this;
                HttpException httpException = new HttpException(response);
                Result.a aVar2 = Result.f25108f;
                cancellableContinuation2.resumeWith(Result.a(o.a(httpException)));
            }
        });
        Object w = cancellableContinuationImpl.w();
        c2 = d.c();
        if (w == c2) {
            h.c(continuation);
        }
        return w;
    }

    public static final <T> Object awaitResponse(Call<T> call, Continuation<? super Response<T>> continuation) {
        Continuation b2;
        Object c2;
        b2 = kotlin.coroutines.intrinsics.c.b(continuation);
        final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(b2, 1);
        cancellableContinuationImpl.e(new KotlinExtensions$awaitResponse$$inlined$suspendCancellableCoroutine$lambda$1(call));
        call.enqueue(new Callback<T>() { // from class: retrofit2.KotlinExtensions$awaitResponse$2$2
            @Override // retrofit2.Callback
            public void onFailure(Call<T> call2, Throwable t) {
                m.g(call2, "call");
                m.g(t, "t");
                CancellableContinuation cancellableContinuation = CancellableContinuation.this;
                Result.a aVar = Result.f25108f;
                cancellableContinuation.resumeWith(Result.a(o.a(t)));
            }

            @Override // retrofit2.Callback
            public void onResponse(Call<T> call2, Response<T> response) {
                m.g(call2, "call");
                m.g(response, "response");
                CancellableContinuation cancellableContinuation = CancellableContinuation.this;
                Result.a aVar = Result.f25108f;
                cancellableContinuation.resumeWith(Result.a(response));
            }
        });
        Object w = cancellableContinuationImpl.w();
        c2 = d.c();
        if (w == c2) {
            h.c(continuation);
        }
        return w;
    }

    public static final /* synthetic */ <T> T create(Retrofit retrofit) {
        m.g(retrofit, "$this$create");
        m.k(4, "T");
        return (T) retrofit.create(Object.class);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object suspendAndThrow(final Exception exc, Continuation<?> continuation) {
        final KotlinExtensions$suspendAndThrow$1 kotlinExtensions$suspendAndThrow$1;
        Object c2;
        int i2;
        Object c3;
        Object c4;
        if (continuation instanceof KotlinExtensions$suspendAndThrow$1) {
            kotlinExtensions$suspendAndThrow$1 = (KotlinExtensions$suspendAndThrow$1) continuation;
            int i3 = kotlinExtensions$suspendAndThrow$1.label;
            if ((i3 & Integer.MIN_VALUE) != 0) {
                kotlinExtensions$suspendAndThrow$1.label = i3 - Integer.MIN_VALUE;
                Object obj = kotlinExtensions$suspendAndThrow$1.result;
                c2 = d.c();
                i2 = kotlinExtensions$suspendAndThrow$1.label;
                if (i2 != 0) {
                    o.b(obj);
                    kotlinExtensions$suspendAndThrow$1.L$0 = exc;
                    kotlinExtensions$suspendAndThrow$1.label = 1;
                    Dispatchers.a().K(kotlinExtensions$suspendAndThrow$1.getL(), new Runnable() { // from class: retrofit2.KotlinExtensions$suspendAndThrow$$inlined$suspendCoroutineUninterceptedOrReturn$lambda$1
                        @Override // java.lang.Runnable
                        public final void run() {
                            Continuation b2;
                            b2 = kotlin.coroutines.intrinsics.c.b(Continuation.this);
                            Exception exc2 = exc;
                            Result.a aVar = Result.f25108f;
                            b2.resumeWith(Result.a(o.a(exc2)));
                        }
                    });
                    c3 = d.c();
                    c4 = d.c();
                    if (c3 == c4) {
                        h.c(kotlinExtensions$suspendAndThrow$1);
                    }
                    if (c3 == c2) {
                        return c2;
                    }
                } else {
                    if (i2 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    o.b(obj);
                }
                return u.a;
            }
        }
        kotlinExtensions$suspendAndThrow$1 = new KotlinExtensions$suspendAndThrow$1(continuation);
        Object obj2 = kotlinExtensions$suspendAndThrow$1.result;
        c2 = d.c();
        i2 = kotlinExtensions$suspendAndThrow$1.label;
        if (i2 != 0) {
        }
        return u.a;
    }
}
