package kotlin.reflect.y.internal.j0.e.y;

import java.io.InputStream;
import kotlin.Pair;
import kotlin.io.a;
import kotlin.reflect.jvm.internal.impl.protobuf.f;
import kotlin.reflect.y.internal.j0.e.m;
import kotlin.s;

/* compiled from: readPackageFragment.kt */
/* loaded from: classes3.dex */
public final class c {
    public static final Pair<m, a> a(InputStream inputStream) {
        m mVar;
        kotlin.jvm.internal.m.f(inputStream, "<this>");
        try {
            a a = a.f24164g.a(inputStream);
            if (a.h()) {
                f d2 = f.d();
                b.a(d2);
                mVar = m.X(inputStream, d2);
            } else {
                mVar = null;
            }
            Pair<m, a> a2 = s.a(mVar, a);
            a.a(inputStream, null);
            return a2;
        } finally {
        }
    }
}
