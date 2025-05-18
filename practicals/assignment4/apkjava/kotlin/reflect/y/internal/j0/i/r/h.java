package kotlin.reflect.y.internal.j0.i.r;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.c0;
import kotlin.collections.n;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.descriptors.g0;
import kotlin.reflect.y.internal.j0.b.i;
import kotlin.reflect.y.internal.j0.l.e0;
import kotlin.reflect.y.internal.j0.l.m0;

/* compiled from: ConstantValueFactory.kt */
/* loaded from: classes3.dex */
public final class h {
    public static final h a = new h();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ConstantValueFactory.kt */
    /* loaded from: classes3.dex */
    public static final class a extends Lambda implements Function1<g0, e0> {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ e0 f24360f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(e0 e0Var) {
            super(1);
            this.f24360f = e0Var;
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final e0 invoke(g0 g0Var) {
            m.f(g0Var, "it");
            return this.f24360f;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ConstantValueFactory.kt */
    /* loaded from: classes3.dex */
    public static final class b extends Lambda implements Function1<g0, e0> {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ i f24361f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(i iVar) {
            super(1);
            this.f24361f = iVar;
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final e0 invoke(g0 g0Var) {
            m.f(g0Var, "module");
            m0 O = g0Var.o().O(this.f24361f);
            m.e(O, "module.builtIns.getPrimi…KotlinType(componentType)");
            return O;
        }
    }

    private h() {
    }

    private final kotlin.reflect.y.internal.j0.i.r.b a(List<?> list, i iVar) {
        List E0;
        E0 = c0.E0(list);
        ArrayList arrayList = new ArrayList();
        Iterator it = E0.iterator();
        while (it.hasNext()) {
            g<?> c2 = c(it.next());
            if (c2 != null) {
                arrayList.add(c2);
            }
        }
        return new kotlin.reflect.y.internal.j0.i.r.b(arrayList, new b(iVar));
    }

    public final kotlin.reflect.y.internal.j0.i.r.b b(List<? extends g<?>> list, e0 e0Var) {
        m.f(list, "value");
        m.f(e0Var, "type");
        return new kotlin.reflect.y.internal.j0.i.r.b(list, new a(e0Var));
    }

    public final g<?> c(Object obj) {
        List<Boolean> b0;
        List<Double> V;
        List<Float> W;
        List<Character> U;
        List<Long> Y;
        List<Integer> X;
        List<Short> a0;
        List<Byte> T;
        if (obj instanceof Byte) {
            return new d(((Number) obj).byteValue());
        }
        if (obj instanceof Short) {
            return new u(((Number) obj).shortValue());
        }
        if (obj instanceof Integer) {
            return new m(((Number) obj).intValue());
        }
        if (obj instanceof Long) {
            return new r(((Number) obj).longValue());
        }
        if (obj instanceof Character) {
            return new e(((Character) obj).charValue());
        }
        if (obj instanceof Float) {
            return new l(((Number) obj).floatValue());
        }
        if (obj instanceof Double) {
            return new i(((Number) obj).doubleValue());
        }
        if (obj instanceof Boolean) {
            return new c(((Boolean) obj).booleanValue());
        }
        if (obj instanceof String) {
            return new v((String) obj);
        }
        if (obj instanceof byte[]) {
            T = n.T((byte[]) obj);
            return a(T, i.BYTE);
        }
        if (obj instanceof short[]) {
            a0 = n.a0((short[]) obj);
            return a(a0, i.SHORT);
        }
        if (obj instanceof int[]) {
            X = n.X((int[]) obj);
            return a(X, i.INT);
        }
        if (obj instanceof long[]) {
            Y = n.Y((long[]) obj);
            return a(Y, i.LONG);
        }
        if (obj instanceof char[]) {
            U = n.U((char[]) obj);
            return a(U, i.CHAR);
        }
        if (obj instanceof float[]) {
            W = n.W((float[]) obj);
            return a(W, i.FLOAT);
        }
        if (obj instanceof double[]) {
            V = n.V((double[]) obj);
            return a(V, i.DOUBLE);
        }
        if (obj instanceof boolean[]) {
            b0 = n.b0((boolean[]) obj);
            return a(b0, i.BOOLEAN);
        }
        if (obj == null) {
            return new s();
        }
        return null;
    }
}
