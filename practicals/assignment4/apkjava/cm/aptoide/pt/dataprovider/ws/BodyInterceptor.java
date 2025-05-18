package cm.aptoide.pt.dataprovider.ws;

import rx.Single;

/* loaded from: classes.dex */
public interface BodyInterceptor<T> {
    Single<T> intercept(T t);
}
