package kotlinx.coroutines.internal;

import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.sequences.Sequence;
import kotlinx.coroutines.MainCoroutineDispatcher;
import okhttp3.HttpUrl;

/* compiled from: MainDispatchers.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lkotlinx/coroutines/internal/MainDispatcherLoader;", HttpUrl.FRAGMENT_ENCODE_SET, "()V", "FAST_SERVICE_LOADER_ENABLED", HttpUrl.FRAGMENT_ENCODE_SET, "dispatcher", "Lkotlinx/coroutines/MainCoroutineDispatcher;", "loadMainDispatcher", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* renamed from: kotlinx.coroutines.internal.v, reason: from Kotlin metadata */
/* loaded from: classes3.dex */
public final class MainDispatcherLoader {
    public static final MainDispatcherLoader a;

    /* renamed from: b, reason: collision with root package name */
    private static final boolean f25835b;

    /* renamed from: c, reason: collision with root package name */
    public static final MainCoroutineDispatcher f25836c;

    static {
        MainDispatcherLoader mainDispatcherLoader = new MainDispatcherLoader();
        a = mainDispatcherLoader;
        f25835b = f0.e("kotlinx.coroutines.fast.service.loader", true);
        f25836c = mainDispatcherLoader.a();
    }

    private MainDispatcherLoader() {
    }

    private final MainCoroutineDispatcher a() {
        Sequence a2;
        List<MainDispatcherFactory> A;
        Object next;
        MainCoroutineDispatcher e2;
        try {
            if (f25835b) {
                A = FastServiceLoader.a.c();
            } else {
                a2 = kotlin.sequences.l.a(defpackage.a.b());
                A = kotlin.sequences.n.A(a2);
            }
            Iterator<T> it = A.iterator();
            if (it.hasNext()) {
                next = it.next();
                if (it.hasNext()) {
                    int loadPriority = ((MainDispatcherFactory) next).getLoadPriority();
                    do {
                        Object next2 = it.next();
                        int loadPriority2 = ((MainDispatcherFactory) next2).getLoadPriority();
                        if (loadPriority < loadPriority2) {
                            next = next2;
                            loadPriority = loadPriority2;
                        }
                    } while (it.hasNext());
                }
            } else {
                next = null;
            }
            MainDispatcherFactory mainDispatcherFactory = (MainDispatcherFactory) next;
            return (mainDispatcherFactory == null || (e2 = w.e(mainDispatcherFactory, A)) == null) ? w.b(null, null, 3, null) : e2;
        } catch (Throwable th) {
            return w.b(th, null, 2, null);
        }
    }
}
