package kotlinx.coroutines.internal;

import kotlin.Metadata;
import kotlin.Result;
import okhttp3.HttpUrl;

/* compiled from: FastServiceLoader.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"ANDROID_DETECTED", HttpUrl.FRAGMENT_ENCODE_SET, "getANDROID_DETECTED", "()Z", "kotlinx-coroutines-core"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class l {
    private static final boolean a;

    static {
        Object a2;
        try {
            Result.a aVar = Result.f25108f;
            a2 = Result.a(Class.forName("android.os.Build"));
        } catch (Throwable th) {
            Result.a aVar2 = Result.f25108f;
            a2 = Result.a(kotlin.o.a(th));
        }
        a = Result.d(a2);
    }

    public static final boolean a() {
        return a;
    }
}
