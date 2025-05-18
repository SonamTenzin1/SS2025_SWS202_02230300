package kotlin.reflect.y.internal.j0.i.q.a;

import cm.aptoide.pt.database.room.RoomNotification;
import java.util.ArrayList;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.v;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.descriptors.e1;
import kotlin.reflect.jvm.internal.impl.descriptors.h;
import kotlin.reflect.y.internal.j0.k.f;
import kotlin.reflect.y.internal.j0.k.n;
import kotlin.reflect.y.internal.j0.l.c0;
import kotlin.reflect.y.internal.j0.l.e0;
import kotlin.reflect.y.internal.j0.l.g1;
import kotlin.reflect.y.internal.j0.l.h0;
import kotlin.reflect.y.internal.j0.l.i1;
import kotlin.reflect.y.internal.j0.l.j1;
import kotlin.reflect.y.internal.j0.l.q;
import kotlin.reflect.y.internal.j0.l.r1;

/* compiled from: CapturedTypeConstructor.kt */
/* loaded from: classes3.dex */
public final class d {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CapturedTypeConstructor.kt */
    /* loaded from: classes3.dex */
    public static final class a extends Lambda implements Function0<e0> {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ g1 f24356f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(g1 g1Var) {
            super(0);
            this.f24356f = g1Var;
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final e0 invoke() {
            e0 type = this.f24356f.getType();
            m.e(type, "this@createCapturedIfNeeded.type");
            return type;
        }
    }

    /* compiled from: CapturedTypeConstructor.kt */
    /* loaded from: classes3.dex */
    public static final class b extends q {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f24357d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(j1 j1Var, boolean z) {
            super(j1Var);
            this.f24357d = z;
        }

        @Override // kotlin.reflect.y.internal.j0.l.j1
        public boolean b() {
            return this.f24357d;
        }

        @Override // kotlin.reflect.y.internal.j0.l.q, kotlin.reflect.y.internal.j0.l.j1
        public g1 e(e0 e0Var) {
            m.f(e0Var, RoomNotification.KEY);
            g1 e2 = super.e(e0Var);
            if (e2 == null) {
                return null;
            }
            h w = e0Var.O0().w();
            return d.b(e2, w instanceof e1 ? (e1) w : null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final g1 b(g1 g1Var, e1 e1Var) {
        if (e1Var == null || g1Var.a() == r1.INVARIANT) {
            return g1Var;
        }
        if (e1Var.n() == g1Var.a()) {
            if (g1Var.c()) {
                n nVar = f.f24650b;
                m.e(nVar, "NO_LOCKS");
                return new i1(new h0(nVar, new a(g1Var)));
            }
            return new i1(g1Var.getType());
        }
        return new i1(c(g1Var));
    }

    public static final e0 c(g1 g1Var) {
        m.f(g1Var, "typeProjection");
        return new kotlin.reflect.y.internal.j0.i.q.a.a(g1Var, null, false, null, 14, null);
    }

    public static final boolean d(e0 e0Var) {
        m.f(e0Var, "<this>");
        return e0Var.O0() instanceof kotlin.reflect.y.internal.j0.i.q.a.b;
    }

    public static final j1 e(j1 j1Var, boolean z) {
        List<Pair> n0;
        int u;
        m.f(j1Var, "<this>");
        if (j1Var instanceof c0) {
            c0 c0Var = (c0) j1Var;
            e1[] j2 = c0Var.j();
            n0 = kotlin.collections.n.n0(c0Var.i(), c0Var.j());
            u = v.u(n0, 10);
            ArrayList arrayList = new ArrayList(u);
            for (Pair pair : n0) {
                arrayList.add(b((g1) pair.c(), (e1) pair.d()));
            }
            Object[] array = arrayList.toArray(new g1[0]);
            m.d(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            return new c0(j2, (g1[]) array, z);
        }
        return new b(j1Var, z);
    }

    public static /* synthetic */ j1 f(j1 j1Var, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = true;
        }
        return e(j1Var, z);
    }
}
