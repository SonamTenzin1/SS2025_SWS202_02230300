package kotlin.reflect.y.internal.j0.m;

import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.descriptors.i1;
import kotlin.reflect.jvm.internal.impl.descriptors.y;
import kotlin.reflect.y.internal.j0.b.j;
import kotlin.reflect.y.internal.j0.i.t.a;
import kotlin.reflect.y.internal.j0.l.e0;
import kotlin.reflect.y.internal.j0.m.f;

/* compiled from: modifierChecks.kt */
/* loaded from: classes3.dex */
final class j implements f {
    public static final j a = new j();

    /* renamed from: b, reason: collision with root package name */
    private static final String f24905b = "second parameter must be of type KProperty<*> or its supertype";

    private j() {
    }

    @Override // kotlin.reflect.y.internal.j0.m.f
    public String a(y yVar) {
        return f.a.a(this, yVar);
    }

    @Override // kotlin.reflect.y.internal.j0.m.f
    public boolean b(y yVar) {
        m.f(yVar, "functionDescriptor");
        i1 i1Var = yVar.f().get(1);
        j.b bVar = kotlin.reflect.y.internal.j0.b.j.a;
        m.e(i1Var, "secondParameter");
        e0 a2 = bVar.a(a.l(i1Var));
        if (a2 == null) {
            return false;
        }
        e0 type = i1Var.getType();
        m.e(type, "secondParameter.type");
        return kotlin.reflect.y.internal.j0.l.x1.a.o(a2, kotlin.reflect.y.internal.j0.l.x1.a.s(type));
    }

    @Override // kotlin.reflect.y.internal.j0.m.f
    public String getDescription() {
        return f24905b;
    }
}
