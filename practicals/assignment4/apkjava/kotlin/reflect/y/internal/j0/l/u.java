package kotlin.reflect.y.internal.j0.l;

import cm.aptoide.pt.database.room.RoomNotification;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.m;

/* compiled from: DisjointKeysUnionTypeSubstitution.kt */
/* loaded from: classes3.dex */
public final class u extends j1 {

    /* renamed from: c, reason: collision with root package name */
    public static final a f24815c = new a(null);

    /* renamed from: d, reason: collision with root package name */
    private final j1 f24816d;

    /* renamed from: e, reason: collision with root package name */
    private final j1 f24817e;

    /* compiled from: DisjointKeysUnionTypeSubstitution.kt */
    /* loaded from: classes3.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }

        public final j1 a(j1 j1Var, j1 j1Var2) {
            m.f(j1Var, "first");
            m.f(j1Var2, "second");
            return j1Var.f() ? j1Var2 : j1Var2.f() ? j1Var : new u(j1Var, j1Var2, null);
        }
    }

    private u(j1 j1Var, j1 j1Var2) {
        this.f24816d = j1Var;
        this.f24817e = j1Var2;
    }

    public /* synthetic */ u(j1 j1Var, j1 j1Var2, g gVar) {
        this(j1Var, j1Var2);
    }

    public static final j1 i(j1 j1Var, j1 j1Var2) {
        return f24815c.a(j1Var, j1Var2);
    }

    @Override // kotlin.reflect.y.internal.j0.l.j1
    public boolean a() {
        return this.f24816d.a() || this.f24817e.a();
    }

    @Override // kotlin.reflect.y.internal.j0.l.j1
    public boolean b() {
        return this.f24816d.b() || this.f24817e.b();
    }

    @Override // kotlin.reflect.y.internal.j0.l.j1
    public kotlin.reflect.jvm.internal.impl.descriptors.n1.g d(kotlin.reflect.jvm.internal.impl.descriptors.n1.g gVar) {
        m.f(gVar, "annotations");
        return this.f24817e.d(this.f24816d.d(gVar));
    }

    @Override // kotlin.reflect.y.internal.j0.l.j1
    public g1 e(e0 e0Var) {
        m.f(e0Var, RoomNotification.KEY);
        g1 e2 = this.f24816d.e(e0Var);
        return e2 == null ? this.f24817e.e(e0Var) : e2;
    }

    @Override // kotlin.reflect.y.internal.j0.l.j1
    public boolean f() {
        return false;
    }

    @Override // kotlin.reflect.y.internal.j0.l.j1
    public e0 g(e0 e0Var, r1 r1Var) {
        m.f(e0Var, "topLevelType");
        m.f(r1Var, "position");
        return this.f24817e.g(this.f24816d.g(e0Var, r1Var), r1Var);
    }
}
