package e.e.b.a.i;

import android.annotation.SuppressLint;

/* compiled from: ForcedSender.java */
/* loaded from: classes2.dex */
public final class m {
    @SuppressLint({"DiscouragedApi"})
    public static void a(e.e.b.a.f<?> fVar, e.e.b.a.d dVar) {
        if (fVar instanceof s) {
            u.c().e().u(((s) fVar).c().f(dVar), 1);
        } else {
            e.e.b.a.i.z.a.g("ForcedSender", "Expected instance of `TransportImpl`, got `%s`.", fVar);
        }
    }
}
