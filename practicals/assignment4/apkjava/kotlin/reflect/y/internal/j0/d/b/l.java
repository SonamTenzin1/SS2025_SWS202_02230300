package kotlin.reflect.y.internal.j0.d.b;

import kotlin.jvm.internal.g;
import kotlin.jvm.internal.m;
import kotlin.reflect.y.internal.j0.i.u.e;

/* compiled from: methodSignatureMapping.kt */
/* loaded from: classes3.dex */
public abstract class l {
    public static final b a = new b(null);

    /* renamed from: b, reason: collision with root package name */
    private static final d f23802b = new d(e.BOOLEAN);

    /* renamed from: c, reason: collision with root package name */
    private static final d f23803c = new d(e.CHAR);

    /* renamed from: d, reason: collision with root package name */
    private static final d f23804d = new d(e.BYTE);

    /* renamed from: e, reason: collision with root package name */
    private static final d f23805e = new d(e.SHORT);

    /* renamed from: f, reason: collision with root package name */
    private static final d f23806f = new d(e.INT);

    /* renamed from: g, reason: collision with root package name */
    private static final d f23807g = new d(e.FLOAT);

    /* renamed from: h, reason: collision with root package name */
    private static final d f23808h = new d(e.LONG);

    /* renamed from: i, reason: collision with root package name */
    private static final d f23809i = new d(e.DOUBLE);

    /* compiled from: methodSignatureMapping.kt */
    /* loaded from: classes3.dex */
    public static final class a extends l {

        /* renamed from: j, reason: collision with root package name */
        private final l f23810j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(l lVar) {
            super(null);
            m.f(lVar, "elementType");
            this.f23810j = lVar;
        }

        public final l i() {
            return this.f23810j;
        }
    }

    /* compiled from: methodSignatureMapping.kt */
    /* loaded from: classes3.dex */
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(g gVar) {
            this();
        }

        public final d a() {
            return l.f23802b;
        }

        public final d b() {
            return l.f23804d;
        }

        public final d c() {
            return l.f23803c;
        }

        public final d d() {
            return l.f23809i;
        }

        public final d e() {
            return l.f23807g;
        }

        public final d f() {
            return l.f23806f;
        }

        public final d g() {
            return l.f23808h;
        }

        public final d h() {
            return l.f23805e;
        }
    }

    /* compiled from: methodSignatureMapping.kt */
    /* loaded from: classes3.dex */
    public static final class c extends l {

        /* renamed from: j, reason: collision with root package name */
        private final String f23811j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(String str) {
            super(null);
            m.f(str, "internalName");
            this.f23811j = str;
        }

        public final String i() {
            return this.f23811j;
        }
    }

    /* compiled from: methodSignatureMapping.kt */
    /* loaded from: classes3.dex */
    public static final class d extends l {

        /* renamed from: j, reason: collision with root package name */
        private final e f23812j;

        public d(e eVar) {
            super(null);
            this.f23812j = eVar;
        }

        public final e i() {
            return this.f23812j;
        }
    }

    private l() {
    }

    public /* synthetic */ l(g gVar) {
        this();
    }

    public String toString() {
        return n.a.a(this);
    }
}
