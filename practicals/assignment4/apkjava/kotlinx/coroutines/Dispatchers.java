package kotlinx.coroutines;

import kotlin.Metadata;
import kotlinx.coroutines.internal.MainDispatcherLoader;
import kotlinx.coroutines.scheduling.DefaultIoScheduler;
import kotlinx.coroutines.scheduling.DefaultScheduler;
import okhttp3.HttpUrl;

/* compiled from: Dispatchers.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0013\u001a\u00020\u0014H\u0007R\u001c\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\b\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\t\u0010\u0002\u001a\u0004\b\n\u0010\u0007R\u001a\u0010\u000b\u001a\u00020\f8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\r\u0010\u0002\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0011\u0010\u0002\u001a\u0004\b\u0012\u0010\u0007¨\u0006\u0015"}, d2 = {"Lkotlinx/coroutines/Dispatchers;", HttpUrl.FRAGMENT_ENCODE_SET, "()V", "Default", "Lkotlinx/coroutines/CoroutineDispatcher;", "getDefault$annotations", "getDefault", "()Lkotlinx/coroutines/CoroutineDispatcher;", "IO", "getIO$annotations", "getIO", "Main", "Lkotlinx/coroutines/MainCoroutineDispatcher;", "getMain$annotations", "getMain", "()Lkotlinx/coroutines/MainCoroutineDispatcher;", "Unconfined", "getUnconfined$annotations", "getUnconfined", "shutdown", HttpUrl.FRAGMENT_ENCODE_SET, "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* renamed from: kotlinx.coroutines.e1, reason: from Kotlin metadata */
/* loaded from: classes3.dex */
public final class Dispatchers {
    public static final Dispatchers a = new Dispatchers();

    /* renamed from: b, reason: collision with root package name */
    private static final CoroutineDispatcher f25738b = DefaultScheduler.m;

    /* renamed from: c, reason: collision with root package name */
    private static final CoroutineDispatcher f25739c = Unconfined.f25884g;

    /* renamed from: d, reason: collision with root package name */
    private static final CoroutineDispatcher f25740d = DefaultIoScheduler.f25673h;

    private Dispatchers() {
    }

    public static final CoroutineDispatcher a() {
        return f25738b;
    }

    public static final CoroutineDispatcher b() {
        return f25740d;
    }

    public static final MainCoroutineDispatcher c() {
        return MainDispatcherLoader.f25836c;
    }
}
