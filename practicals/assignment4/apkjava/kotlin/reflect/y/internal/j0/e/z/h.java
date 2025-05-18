package kotlin.reflect.y.internal.j0.e.z;

import java.util.List;
import kotlin.collections.u;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.m;
import kotlin.reflect.y.internal.j0.e.v;
import kotlin.reflect.y.internal.j0.e.w;

/* compiled from: VersionRequirement.kt */
/* loaded from: classes3.dex */
public final class h {
    public static final a a = new a(null);

    /* renamed from: b, reason: collision with root package name */
    private static final h f24195b;

    /* renamed from: c, reason: collision with root package name */
    private final List<v> f24196c;

    /* compiled from: VersionRequirement.kt */
    /* loaded from: classes3.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }

        public final h a(w wVar) {
            m.f(wVar, "table");
            if (wVar.v() == 0) {
                return b();
            }
            List<v> w = wVar.w();
            m.e(w, "table.requirementList");
            return new h(w, null);
        }

        public final h b() {
            return h.f24195b;
        }
    }

    static {
        List j2;
        j2 = u.j();
        f24195b = new h(j2);
    }

    private h(List<v> list) {
        this.f24196c = list;
    }

    public /* synthetic */ h(List list, g gVar) {
        this(list);
    }
}
