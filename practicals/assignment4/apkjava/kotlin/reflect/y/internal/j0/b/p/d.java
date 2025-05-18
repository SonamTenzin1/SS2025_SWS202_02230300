package kotlin.reflect.y.internal.j0.b.p;

import java.util.List;
import kotlin.collections.t;
import kotlin.collections.u;
import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.descriptors.y;
import kotlin.reflect.y.internal.j0.i.w.e;
import kotlin.reflect.y.internal.j0.k.n;

/* compiled from: FunctionClassScope.kt */
/* loaded from: classes2.dex */
public final class d extends e {

    /* compiled from: FunctionClassScope.kt */
    /* loaded from: classes2.dex */
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[c.values().length];
            iArr[c.f23233g.ordinal()] = 1;
            iArr[c.f23234h.ordinal()] = 2;
            a = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(n nVar, b bVar) {
        super(nVar, bVar);
        m.f(nVar, "storageManager");
        m.f(bVar, "containingClass");
    }

    @Override // kotlin.reflect.y.internal.j0.i.w.e
    protected List<y> i() {
        List<y> e2;
        List<y> e3;
        List<y> j2;
        kotlin.reflect.jvm.internal.impl.descriptors.e l = l();
        m.d(l, "null cannot be cast to non-null type org.jetbrains.kotlin.builtins.functions.FunctionClassDescriptor");
        int i2 = a.a[((b) l).V0().ordinal()];
        if (i2 == 1) {
            e2 = t.e(e.J.a((b) l(), false));
            return e2;
        }
        if (i2 != 2) {
            j2 = u.j();
            return j2;
        }
        e3 = t.e(e.J.a((b) l(), true));
        return e3;
    }
}
