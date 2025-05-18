package kotlin.reflect.y.internal.j0.i.r;

import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.descriptors.e;
import kotlin.reflect.jvm.internal.impl.descriptors.g0;
import kotlin.reflect.jvm.internal.impl.descriptors.x;
import kotlin.reflect.y.internal.j0.b.k;
import kotlin.reflect.y.internal.j0.l.e0;
import kotlin.reflect.y.internal.j0.l.m0;
import kotlin.reflect.y.internal.j0.l.u1.j;

/* compiled from: constantValues.kt */
/* loaded from: classes3.dex */
public final class w extends a0<Byte> {
    public w(byte b2) {
        super(Byte.valueOf(b2));
    }

    @Override // kotlin.reflect.y.internal.j0.i.r.g
    public e0 a(g0 g0Var) {
        m.f(g0Var, "module");
        e a = x.a(g0Var, k.a.y0);
        m0 s = a != null ? a.s() : null;
        return s == null ? kotlin.reflect.y.internal.j0.l.u1.k.d(j.A0, "UByte") : s;
    }

    @Override // kotlin.reflect.y.internal.j0.i.r.g
    public String toString() {
        return b().intValue() + ".toUByte()";
    }
}
