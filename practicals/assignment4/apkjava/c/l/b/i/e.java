package c.l.b.i;

import c.l.b.i.d;
import java.util.Arrays;
import kotlin.jvm.internal.m;

/* compiled from: PreferencesFactory.kt */
/* loaded from: classes.dex */
public final class e {
    public static final d a() {
        return new a(null, true, 1, null);
    }

    public static final a b(d.b<?>... bVarArr) {
        m.f(bVarArr, "pairs");
        a aVar = new a(null, false, 1, null);
        aVar.g((d.b[]) Arrays.copyOf(bVarArr, bVarArr.length));
        return aVar;
    }
}
