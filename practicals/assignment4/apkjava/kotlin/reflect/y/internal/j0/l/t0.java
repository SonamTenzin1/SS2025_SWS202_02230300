package kotlin.reflect.y.internal.j0.l;

import cm.aptoide.pt.database.room.RoomNotification;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.s;
import kotlin.collections.v;
import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.descriptors.e1;
import kotlin.reflect.jvm.internal.impl.descriptors.h;
import kotlin.reflect.jvm.internal.impl.descriptors.i;
import kotlin.reflect.jvm.internal.impl.descriptors.y;

/* compiled from: StarProjectionImpl.kt */
/* loaded from: classes3.dex */
public final class t0 {

    /* compiled from: StarProjectionImpl.kt */
    /* loaded from: classes3.dex */
    public static final class a extends f1 {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ List<e1> f24786d;

        /* JADX WARN: Multi-variable type inference failed */
        a(List<? extends e1> list) {
            this.f24786d = list;
        }

        @Override // kotlin.reflect.y.internal.j0.l.f1
        public g1 k(e1 e1Var) {
            m.f(e1Var, RoomNotification.KEY);
            if (!this.f24786d.contains(e1Var)) {
                return null;
            }
            h c2 = e1Var.c();
            m.d(c2, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.TypeParameterDescriptor");
            return n1.s((e1) c2);
        }
    }

    private static final e0 a(List<? extends e1> list, List<? extends e0> list2, kotlin.reflect.y.internal.j0.b.h hVar) {
        e0 p = l1.g(new a(list)).p((e0) s.U(list2), r1.OUT_VARIANCE);
        if (p == null) {
            p = hVar.y();
        }
        m.e(p, "typeParameters: List<Typ… ?: builtIns.defaultBound");
        return p;
    }

    public static final e0 b(e1 e1Var) {
        int u;
        int u2;
        m.f(e1Var, "<this>");
        kotlin.reflect.jvm.internal.impl.descriptors.m b2 = e1Var.b();
        m.e(b2, "this.containingDeclaration");
        if (b2 instanceof i) {
            List<e1> parameters = ((i) b2).h().getParameters();
            m.e(parameters, "descriptor.typeConstructor.parameters");
            u2 = v.u(parameters, 10);
            ArrayList arrayList = new ArrayList(u2);
            Iterator<T> it = parameters.iterator();
            while (it.hasNext()) {
                e1 h2 = ((e1) it.next()).h();
                m.e(h2, "it.typeConstructor");
                arrayList.add(h2);
            }
            List<e0> upperBounds = e1Var.getUpperBounds();
            m.e(upperBounds, "upperBounds");
            return a(arrayList, upperBounds, kotlin.reflect.y.internal.j0.i.t.a.f(e1Var));
        }
        if (b2 instanceof y) {
            List<e1> typeParameters = ((y) b2).getTypeParameters();
            m.e(typeParameters, "descriptor.typeParameters");
            u = v.u(typeParameters, 10);
            ArrayList arrayList2 = new ArrayList(u);
            Iterator<T> it2 = typeParameters.iterator();
            while (it2.hasNext()) {
                e1 h3 = ((e1) it2.next()).h();
                m.e(h3, "it.typeConstructor");
                arrayList2.add(h3);
            }
            List<e0> upperBounds2 = e1Var.getUpperBounds();
            m.e(upperBounds2, "upperBounds");
            return a(arrayList2, upperBounds2, kotlin.reflect.y.internal.j0.i.t.a.f(e1Var));
        }
        throw new IllegalArgumentException("Unsupported descriptor type to build star projection type based on type parameters of it");
    }
}
