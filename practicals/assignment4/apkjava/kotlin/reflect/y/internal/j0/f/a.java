package kotlin.reflect.y.internal.j0.f;

import kotlin.jvm.internal.g;
import kotlin.jvm.internal.m;
import kotlin.text.u;

/* compiled from: CallableId.kt */
/* loaded from: classes3.dex */
public final class a {
    private static final C0371a a = new C0371a(null);

    /* renamed from: b, reason: collision with root package name */
    @Deprecated
    private static final f f24197b;

    /* renamed from: c, reason: collision with root package name */
    @Deprecated
    private static final c f24198c;

    /* renamed from: d, reason: collision with root package name */
    private final c f24199d;

    /* renamed from: e, reason: collision with root package name */
    private final c f24200e;

    /* renamed from: f, reason: collision with root package name */
    private final f f24201f;

    /* renamed from: g, reason: collision with root package name */
    private final c f24202g;

    /* compiled from: CallableId.kt */
    /* renamed from: kotlin.f0.y.e.j0.f.a$a, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    private static final class C0371a {
        private C0371a() {
        }

        public /* synthetic */ C0371a(g gVar) {
            this();
        }
    }

    static {
        f fVar = h.l;
        f24197b = fVar;
        c k2 = c.k(fVar);
        m.e(k2, "topLevel(LOCAL_NAME)");
        f24198c = k2;
    }

    public a(c cVar, c cVar2, f fVar, c cVar3) {
        m.f(cVar, "packageName");
        m.f(fVar, "callableName");
        this.f24199d = cVar;
        this.f24200e = cVar2;
        this.f24201f = fVar;
        this.f24202g = cVar3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return m.a(this.f24199d, aVar.f24199d) && m.a(this.f24200e, aVar.f24200e) && m.a(this.f24201f, aVar.f24201f) && m.a(this.f24202g, aVar.f24202g);
    }

    public int hashCode() {
        int hashCode = this.f24199d.hashCode() * 31;
        c cVar = this.f24200e;
        int hashCode2 = (((hashCode + (cVar == null ? 0 : cVar.hashCode())) * 31) + this.f24201f.hashCode()) * 31;
        c cVar2 = this.f24202g;
        return hashCode2 + (cVar2 != null ? cVar2.hashCode() : 0);
    }

    public String toString() {
        String z;
        StringBuilder sb = new StringBuilder();
        String b2 = this.f24199d.b();
        m.e(b2, "packageName.asString()");
        z = u.z(b2, '.', '/', false, 4, null);
        sb.append(z);
        sb.append("/");
        c cVar = this.f24200e;
        if (cVar != null) {
            sb.append(cVar);
            sb.append(".");
        }
        sb.append(this.f24201f);
        String sb2 = sb.toString();
        m.e(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    public /* synthetic */ a(c cVar, c cVar2, f fVar, c cVar3, int i2, g gVar) {
        this(cVar, cVar2, fVar, (i2 & 8) != 0 ? null : cVar3);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public a(c cVar, f fVar) {
        this(cVar, null, fVar, null, 8, null);
        m.f(cVar, "packageName");
        m.f(fVar, "callableName");
    }
}
