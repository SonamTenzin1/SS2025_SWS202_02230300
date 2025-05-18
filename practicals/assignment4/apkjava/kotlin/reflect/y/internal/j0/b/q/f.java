package kotlin.reflect.y.internal.j0.b.q;

import java.util.List;
import kotlin.collections.c0;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.y;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.descriptors.p1.x;
import kotlin.reflect.y.internal.j0.b.h;
import kotlin.reflect.y.internal.j0.k.i;
import kotlin.reflect.y.internal.j0.k.n;

/* compiled from: JvmBuiltIns.kt */
/* loaded from: classes2.dex */
public final class f extends h {

    /* renamed from: h, reason: collision with root package name */
    static final /* synthetic */ KProperty<Object>[] f23265h = {g0.h(new y(g0.b(f.class), "customizer", "getCustomizer()Lorg/jetbrains/kotlin/builtins/jvm/JvmBuiltInsCustomizer;"))};

    /* renamed from: i, reason: collision with root package name */
    private final a f23266i;

    /* renamed from: j, reason: collision with root package name */
    private Function0<b> f23267j;

    /* renamed from: k, reason: collision with root package name */
    private final i f23268k;

    /* compiled from: JvmBuiltIns.kt */
    /* loaded from: classes2.dex */
    public enum a {
        FROM_DEPENDENCIES,
        FROM_CLASS_LOADER,
        FALLBACK
    }

    /* compiled from: JvmBuiltIns.kt */
    /* loaded from: classes2.dex */
    public static final class b {
        private final kotlin.reflect.jvm.internal.impl.descriptors.g0 a;

        /* renamed from: b, reason: collision with root package name */
        private final boolean f23273b;

        public b(kotlin.reflect.jvm.internal.impl.descriptors.g0 g0Var, boolean z) {
            m.f(g0Var, "ownerModuleDescriptor");
            this.a = g0Var;
            this.f23273b = z;
        }

        public final kotlin.reflect.jvm.internal.impl.descriptors.g0 a() {
            return this.a;
        }

        public final boolean b() {
            return this.f23273b;
        }
    }

    /* compiled from: JvmBuiltIns.kt */
    /* loaded from: classes2.dex */
    public /* synthetic */ class c {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[a.values().length];
            iArr[a.FROM_DEPENDENCIES.ordinal()] = 1;
            iArr[a.FROM_CLASS_LOADER.ordinal()] = 2;
            iArr[a.FALLBACK.ordinal()] = 3;
            a = iArr;
        }
    }

    /* compiled from: JvmBuiltIns.kt */
    /* loaded from: classes2.dex */
    static final class d extends Lambda implements Function0<g> {

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ n f23275g;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: JvmBuiltIns.kt */
        /* loaded from: classes2.dex */
        public static final class a extends Lambda implements Function0<b> {

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ f f23276f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(f fVar) {
                super(0);
                this.f23276f = fVar;
            }

            @Override // kotlin.jvm.functions.Function0
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final b invoke() {
                Function0 function0 = this.f23276f.f23267j;
                if (function0 != null) {
                    b bVar = (b) function0.invoke();
                    this.f23276f.f23267j = null;
                    return bVar;
                }
                throw new AssertionError("JvmBuiltins instance has not been initialized properly");
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(n nVar) {
            super(0);
            this.f23275g = nVar;
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final g invoke() {
            x r = f.this.r();
            m.e(r, "builtInsModule");
            return new g(r, this.f23275g, new a(f.this));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: JvmBuiltIns.kt */
    /* loaded from: classes2.dex */
    public static final class e extends Lambda implements Function0<b> {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ kotlin.reflect.jvm.internal.impl.descriptors.g0 f23277f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ boolean f23278g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(kotlin.reflect.jvm.internal.impl.descriptors.g0 g0Var, boolean z) {
            super(0);
            this.f23277f = g0Var;
            this.f23278g = z;
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final b invoke() {
            return new b(this.f23277f, this.f23278g);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(n nVar, a aVar) {
        super(nVar);
        m.f(nVar, "storageManager");
        m.f(aVar, "kind");
        this.f23266i = aVar;
        this.f23268k = nVar.d(new d(nVar));
        int i2 = c.a[aVar.ordinal()];
        if (i2 == 2) {
            f(false);
        } else {
            if (i2 != 3) {
                return;
            }
            f(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.reflect.y.internal.j0.b.h
    /* renamed from: G0, reason: merged with bridge method [inline-methods] */
    public List<kotlin.reflect.jvm.internal.impl.descriptors.o1.b> v() {
        List<kotlin.reflect.jvm.internal.impl.descriptors.o1.b> n0;
        Iterable<kotlin.reflect.jvm.internal.impl.descriptors.o1.b> v = super.v();
        m.e(v, "super.getClassDescriptorFactories()");
        n U = U();
        m.e(U, "storageManager");
        x r = r();
        m.e(r, "builtInsModule");
        n0 = c0.n0(v, new kotlin.reflect.y.internal.j0.b.q.e(U, r, null, 4, null));
        return n0;
    }

    public final g H0() {
        return (g) kotlin.reflect.y.internal.j0.k.m.a(this.f23268k, this, f23265h[0]);
    }

    public final void I0(kotlin.reflect.jvm.internal.impl.descriptors.g0 g0Var, boolean z) {
        m.f(g0Var, "moduleDescriptor");
        J0(new e(g0Var, z));
    }

    public final void J0(Function0<b> function0) {
        m.f(function0, "computation");
        Function0<b> function02 = this.f23267j;
        this.f23267j = function0;
    }

    @Override // kotlin.reflect.y.internal.j0.b.h
    protected kotlin.reflect.jvm.internal.impl.descriptors.o1.c M() {
        return H0();
    }

    @Override // kotlin.reflect.y.internal.j0.b.h
    protected kotlin.reflect.jvm.internal.impl.descriptors.o1.a g() {
        return H0();
    }
}
