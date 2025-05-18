package kotlin.reflect.y.internal.j0.i.r;

import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.descriptors.g0;
import kotlin.reflect.y.internal.j0.l.m0;

/* compiled from: constantValues.kt */
/* loaded from: classes3.dex */
public final class d extends o<Byte> {
    public d(byte b2) {
        super(Byte.valueOf(b2));
    }

    @Override // kotlin.reflect.y.internal.j0.i.r.g
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public m0 a(g0 g0Var) {
        m.f(g0Var, "module");
        m0 t = g0Var.o().t();
        m.e(t, "module.builtIns.byteType");
        return t;
    }

    @Override // kotlin.reflect.y.internal.j0.i.r.g
    public String toString() {
        return b().intValue() + ".toByte()";
    }
}
