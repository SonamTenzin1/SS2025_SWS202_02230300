package kotlin.reflect.y.internal.j0.d.a;

import java.util.Collection;
import kotlin.collections.c0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.descriptors.b;
import kotlin.reflect.y.internal.j0.b.h;
import kotlin.reflect.y.internal.j0.f.f;

/* compiled from: ClassicBuiltinSpecialProperties.kt */
/* loaded from: classes2.dex */
public final class i {
    public static final i a = new i();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ClassicBuiltinSpecialProperties.kt */
    /* loaded from: classes2.dex */
    public static final class a extends Lambda implements Function1<b, Boolean> {

        /* renamed from: f, reason: collision with root package name */
        public static final a f23401f = new a();

        a() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(b bVar) {
            m.f(bVar, "it");
            return Boolean.valueOf(i.a.b(bVar));
        }
    }

    private i() {
    }

    private final boolean c(b bVar) {
        boolean K;
        K = c0.K(g.a.c(), kotlin.reflect.y.internal.j0.i.t.a.d(bVar));
        if (K && bVar.f().isEmpty()) {
            return true;
        }
        if (!h.f0(bVar)) {
            return false;
        }
        Collection<? extends b> e2 = bVar.e();
        m.e(e2, "overriddenDescriptors");
        if (!e2.isEmpty()) {
            for (b bVar2 : e2) {
                i iVar = a;
                m.e(bVar2, "it");
                if (iVar.b(bVar2)) {
                    return true;
                }
            }
        }
        return false;
    }

    public final String a(b bVar) {
        f fVar;
        m.f(bVar, "<this>");
        h.f0(bVar);
        b c2 = kotlin.reflect.y.internal.j0.i.t.a.c(kotlin.reflect.y.internal.j0.i.t.a.o(bVar), false, a.f23401f, 1, null);
        if (c2 == null || (fVar = g.a.a().get(kotlin.reflect.y.internal.j0.i.t.a.h(c2))) == null) {
            return null;
        }
        return fVar.k();
    }

    public final boolean b(b bVar) {
        m.f(bVar, "callableMemberDescriptor");
        if (g.a.d().contains(bVar.getName())) {
            return c(bVar);
        }
        return false;
    }
}
