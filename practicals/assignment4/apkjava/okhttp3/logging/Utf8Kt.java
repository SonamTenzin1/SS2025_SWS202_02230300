package okhttp3.logging;

import j.f;
import java.io.EOFException;
import kotlin.Metadata;
import kotlin.jvm.internal.m;
import kotlin.ranges.l;
import okhttp3.HttpUrl;

/* compiled from: utf8.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a\u0013\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0000¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lj/f;", HttpUrl.FRAGMENT_ENCODE_SET, "isProbablyUtf8", "(Lj/f;)Z", "okhttp-logging-interceptor"}, k = 2, mv = {1, 4, 0})
/* loaded from: classes3.dex */
public final class Utf8Kt {
    public static final boolean isProbablyUtf8(f fVar) {
        long e2;
        m.f(fVar, "$this$isProbablyUtf8");
        try {
            f fVar2 = new f();
            e2 = l.e(fVar.size(), 64L);
            fVar.j(fVar2, 0L, e2);
            for (int i2 = 0; i2 < 16; i2++) {
                if (fVar2.R()) {
                    return true;
                }
                int a0 = fVar2.a0();
                if (Character.isISOControl(a0) && !Character.isWhitespace(a0)) {
                    return false;
                }
            }
            return true;
        } catch (EOFException unused) {
            return false;
        }
    }
}
