package kotlin.reflect.y.internal.j0.i.w;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.m;
import kotlin.reflect.y.internal.j0.k.f;
import kotlin.reflect.y.internal.j0.k.i;
import kotlin.reflect.y.internal.j0.k.n;

/* compiled from: LazyScopeAdapter.kt */
/* loaded from: classes3.dex */
public final class g extends kotlin.reflect.y.internal.j0.i.w.a {

    /* renamed from: b, reason: collision with root package name */
    private final i<h> f24418b;

    /* compiled from: LazyScopeAdapter.kt */
    /* loaded from: classes3.dex */
    static final class a extends Lambda implements Function0<h> {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ Function0<h> f24419f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        a(Function0<? extends h> function0) {
            super(0);
            this.f24419f = function0;
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final h invoke() {
            h invoke = this.f24419f.invoke();
            return invoke instanceof kotlin.reflect.y.internal.j0.i.w.a ? ((kotlin.reflect.y.internal.j0.i.w.a) invoke).h() : invoke;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public g(Function0<? extends h> function0) {
        this(null, function0, 1, 0 == true ? 1 : 0);
        m.f(function0, "getScope");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ g(n nVar, Function0 function0, int i2, kotlin.jvm.internal.g gVar) {
        this(nVar, function0);
        if ((i2 & 1) != 0) {
            nVar = f.f24650b;
            m.e(nVar, "NO_LOCKS");
        }
    }

    @Override // kotlin.reflect.y.internal.j0.i.w.a
    protected h i() {
        return this.f24418b.invoke();
    }

    public g(n nVar, Function0<? extends h> function0) {
        m.f(nVar, "storageManager");
        m.f(function0, "getScope");
        this.f24418b = nVar.d(new a(function0));
    }
}
