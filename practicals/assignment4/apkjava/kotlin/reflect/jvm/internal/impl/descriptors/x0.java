package kotlin.reflect.jvm.internal.impl.descriptors;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.KProperty;
import kotlin.reflect.y.internal.j0.i.w.h;

/* compiled from: ScopesHolderForClass.kt */
/* loaded from: classes2.dex */
public final class x0<T extends kotlin.reflect.y.internal.j0.i.w.h> {

    /* renamed from: c, reason: collision with root package name */
    private final e f25378c;

    /* renamed from: d, reason: collision with root package name */
    private final Function1<kotlin.reflect.y.internal.j0.l.t1.g, T> f25379d;

    /* renamed from: e, reason: collision with root package name */
    private final kotlin.reflect.y.internal.j0.l.t1.g f25380e;

    /* renamed from: f, reason: collision with root package name */
    private final kotlin.reflect.y.internal.j0.k.i f25381f;

    /* renamed from: b, reason: collision with root package name */
    static final /* synthetic */ KProperty<Object>[] f25377b = {kotlin.jvm.internal.g0.h(new kotlin.jvm.internal.y(kotlin.jvm.internal.g0.b(x0.class), "scopeForOwnerModule", "getScopeForOwnerModule()Lorg/jetbrains/kotlin/resolve/scopes/MemberScope;"))};
    public static final a a = new a(null);

    /* compiled from: ScopesHolderForClass.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
            this();
        }

        public final <T extends kotlin.reflect.y.internal.j0.i.w.h> x0<T> a(e eVar, kotlin.reflect.y.internal.j0.k.n nVar, kotlin.reflect.y.internal.j0.l.t1.g gVar, Function1<? super kotlin.reflect.y.internal.j0.l.t1.g, ? extends T> function1) {
            kotlin.jvm.internal.m.f(eVar, "classDescriptor");
            kotlin.jvm.internal.m.f(nVar, "storageManager");
            kotlin.jvm.internal.m.f(gVar, "kotlinTypeRefinerForOwnerModule");
            kotlin.jvm.internal.m.f(function1, "scopeFactory");
            return new x0<>(eVar, nVar, function1, gVar, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ScopesHolderForClass.kt */
    /* loaded from: classes2.dex */
    public static final class b extends Lambda implements Function0<T> {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ x0<T> f25382f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ kotlin.reflect.y.internal.j0.l.t1.g f25383g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(x0<T> x0Var, kotlin.reflect.y.internal.j0.l.t1.g gVar) {
            super(0);
            this.f25382f = x0Var;
            this.f25383g = gVar;
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final T invoke() {
            return (T) ((x0) this.f25382f).f25379d.invoke(this.f25383g);
        }
    }

    /* compiled from: ScopesHolderForClass.kt */
    /* loaded from: classes2.dex */
    static final class c extends Lambda implements Function0<T> {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ x0<T> f25384f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(x0<T> x0Var) {
            super(0);
            this.f25384f = x0Var;
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final T invoke() {
            return (T) ((x0) this.f25384f).f25379d.invoke(((x0) this.f25384f).f25380e);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private x0(e eVar, kotlin.reflect.y.internal.j0.k.n nVar, Function1<? super kotlin.reflect.y.internal.j0.l.t1.g, ? extends T> function1, kotlin.reflect.y.internal.j0.l.t1.g gVar) {
        this.f25378c = eVar;
        this.f25379d = function1;
        this.f25380e = gVar;
        this.f25381f = nVar.d(new c(this));
    }

    public /* synthetic */ x0(e eVar, kotlin.reflect.y.internal.j0.k.n nVar, Function1 function1, kotlin.reflect.y.internal.j0.l.t1.g gVar, kotlin.jvm.internal.g gVar2) {
        this(eVar, nVar, function1, gVar);
    }

    private final T d() {
        return (T) kotlin.reflect.y.internal.j0.k.m.a(this.f25381f, this, f25377b[0]);
    }

    public final T c(kotlin.reflect.y.internal.j0.l.t1.g gVar) {
        kotlin.jvm.internal.m.f(gVar, "kotlinTypeRefiner");
        if (!gVar.d(kotlin.reflect.y.internal.j0.i.t.a.l(this.f25378c))) {
            return d();
        }
        kotlin.reflect.y.internal.j0.l.e1 h2 = this.f25378c.h();
        kotlin.jvm.internal.m.e(h2, "classDescriptor.typeConstructor");
        return !gVar.e(h2) ? d() : (T) gVar.c(this.f25378c, new b(this, gVar));
    }
}
