package kotlin.reflect.y.internal.j0.e.a0.b;

import java.util.List;
import java.util.Set;
import kotlin.collections.c0;
import kotlin.collections.w0;
import kotlin.jvm.internal.m;
import kotlin.reflect.y.internal.j0.e.a0.a;
import okhttp3.HttpUrl;

/* compiled from: JvmNameResolver.kt */
/* loaded from: classes3.dex */
public final class f extends g {

    /* renamed from: h, reason: collision with root package name */
    private final a.e f23892h;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public f(a.e eVar, String[] strArr) {
        super(strArr, r0, h.a(r1));
        Set I0;
        m.f(eVar, "types");
        m.f(strArr, "strings");
        List<Integer> x = eVar.x();
        if (x.isEmpty()) {
            I0 = w0.d();
        } else {
            m.e(x, HttpUrl.FRAGMENT_ENCODE_SET);
            I0 = c0.I0(x);
        }
        List<a.e.c> y = eVar.y();
        m.e(y, "types.recordList");
        this.f23892h = eVar;
    }
}
