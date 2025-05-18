package kotlin.reflect.y.internal.j0.e;

import java.io.IOException;
import kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream;
import kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException;
import kotlin.reflect.jvm.internal.impl.protobuf.a;
import kotlin.reflect.jvm.internal.impl.protobuf.d;
import kotlin.reflect.jvm.internal.impl.protobuf.e;
import kotlin.reflect.jvm.internal.impl.protobuf.f;
import kotlin.reflect.jvm.internal.impl.protobuf.h;
import kotlin.reflect.jvm.internal.impl.protobuf.i;
import kotlin.reflect.jvm.internal.impl.protobuf.p;
import kotlin.reflect.jvm.internal.impl.protobuf.q;

/* compiled from: ProtoBuf.java */
/* loaded from: classes3.dex */
public final class v extends h implements p {

    /* renamed from: g, reason: collision with root package name */
    private static final v f24129g;

    /* renamed from: h, reason: collision with root package name */
    public static q<v> f24130h = new a();

    /* renamed from: i, reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.protobuf.d f24131i;

    /* renamed from: j, reason: collision with root package name */
    private int f24132j;

    /* renamed from: k, reason: collision with root package name */
    private int f24133k;
    private int l;
    private c m;
    private int n;
    private int o;
    private d p;
    private byte q;
    private int r;

    /* compiled from: ProtoBuf.java */
    /* loaded from: classes3.dex */
    static class a extends kotlin.reflect.jvm.internal.impl.protobuf.b<v> {
        a() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.q
        /* renamed from: m, reason: merged with bridge method [inline-methods] */
        public v b(e eVar, f fVar) throws InvalidProtocolBufferException {
            return new v(eVar, fVar);
        }
    }

    /* compiled from: ProtoBuf.java */
    /* loaded from: classes3.dex */
    public static final class b extends h.b<v, b> implements p {

        /* renamed from: g, reason: collision with root package name */
        private int f24134g;

        /* renamed from: h, reason: collision with root package name */
        private int f24135h;

        /* renamed from: i, reason: collision with root package name */
        private int f24136i;

        /* renamed from: k, reason: collision with root package name */
        private int f24138k;
        private int l;

        /* renamed from: j, reason: collision with root package name */
        private c f24137j = c.ERROR;
        private d m = d.LANGUAGE_VERSION;

        private b() {
            t();
        }

        static /* synthetic */ b o() {
            return s();
        }

        private static b s() {
            return new b();
        }

        private void t() {
        }

        public b A(c cVar) {
            cVar.getClass();
            this.f24134g |= 4;
            this.f24137j = cVar;
            return this;
        }

        public b B(int i2) {
            this.f24134g |= 16;
            this.l = i2;
            return this;
        }

        public b C(int i2) {
            this.f24134g |= 1;
            this.f24135h = i2;
            return this;
        }

        public b D(int i2) {
            this.f24134g |= 2;
            this.f24136i = i2;
            return this;
        }

        public b E(d dVar) {
            dVar.getClass();
            this.f24134g |= 32;
            this.m = dVar;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.o.a
        /* renamed from: p, reason: merged with bridge method [inline-methods] */
        public v c() {
            v q = q();
            if (q.isInitialized()) {
                return q;
            }
            throw a.AbstractC0413a.j(q);
        }

        public v q() {
            v vVar = new v(this);
            int i2 = this.f24134g;
            int i3 = (i2 & 1) != 1 ? 0 : 1;
            vVar.f24133k = this.f24135h;
            if ((i2 & 2) == 2) {
                i3 |= 2;
            }
            vVar.l = this.f24136i;
            if ((i2 & 4) == 4) {
                i3 |= 4;
            }
            vVar.m = this.f24137j;
            if ((i2 & 8) == 8) {
                i3 |= 8;
            }
            vVar.n = this.f24138k;
            if ((i2 & 16) == 16) {
                i3 |= 16;
            }
            vVar.o = this.l;
            if ((i2 & 32) == 32) {
                i3 |= 32;
            }
            vVar.p = this.m;
            vVar.f24132j = i3;
            return vVar;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h.b
        /* renamed from: r, reason: merged with bridge method [inline-methods] */
        public b k() {
            return s().m(q());
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h.b
        /* renamed from: u, reason: merged with bridge method [inline-methods] */
        public b m(v vVar) {
            if (vVar == v.z()) {
                return this;
            }
            if (vVar.J()) {
                C(vVar.D());
            }
            if (vVar.K()) {
                D(vVar.E());
            }
            if (vVar.H()) {
                A(vVar.B());
            }
            if (vVar.G()) {
                w(vVar.A());
            }
            if (vVar.I()) {
                B(vVar.C());
            }
            if (vVar.L()) {
                E(vVar.F());
            }
            n(l().f(vVar.f24131i));
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:17:0x001d  */
        @Override // kotlin.reflect.jvm.internal.impl.protobuf.a.AbstractC0413a
        /* renamed from: v, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public b i(e eVar, f fVar) throws IOException {
            v vVar = null;
            try {
                try {
                    v b2 = v.f24130h.b(eVar, fVar);
                    if (b2 != null) {
                        m(b2);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e2) {
                    v vVar2 = (v) e2.a();
                    try {
                        throw e2;
                    } catch (Throwable th) {
                        th = th;
                        vVar = vVar2;
                        if (vVar != null) {
                            m(vVar);
                        }
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                if (vVar != null) {
                }
                throw th;
            }
        }

        public b w(int i2) {
            this.f24134g |= 8;
            this.f24138k = i2;
            return this;
        }
    }

    /* compiled from: ProtoBuf.java */
    /* loaded from: classes3.dex */
    public enum c implements i.a {
        WARNING(0, 0),
        ERROR(1, 1),
        HIDDEN(2, 2);


        /* renamed from: i, reason: collision with root package name */
        private static i.b<c> f24142i = new a();

        /* renamed from: k, reason: collision with root package name */
        private final int f24144k;

        /* compiled from: ProtoBuf.java */
        /* loaded from: classes3.dex */
        static class a implements i.b<c> {
            a() {
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.i.b
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public c a(int i2) {
                return c.g(i2);
            }
        }

        c(int i2, int i3) {
            this.f24144k = i3;
        }

        public static c g(int i2) {
            if (i2 == 0) {
                return WARNING;
            }
            if (i2 == 1) {
                return ERROR;
            }
            if (i2 != 2) {
                return null;
            }
            return HIDDEN;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.i.a
        public final int f() {
            return this.f24144k;
        }
    }

    /* compiled from: ProtoBuf.java */
    /* loaded from: classes3.dex */
    public enum d implements i.a {
        LANGUAGE_VERSION(0, 0),
        COMPILER_VERSION(1, 1),
        API_VERSION(2, 2);


        /* renamed from: i, reason: collision with root package name */
        private static i.b<d> f24148i = new a();

        /* renamed from: k, reason: collision with root package name */
        private final int f24150k;

        /* compiled from: ProtoBuf.java */
        /* loaded from: classes3.dex */
        static class a implements i.b<d> {
            a() {
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.i.b
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public d a(int i2) {
                return d.g(i2);
            }
        }

        d(int i2, int i3) {
            this.f24150k = i3;
        }

        public static d g(int i2) {
            if (i2 == 0) {
                return LANGUAGE_VERSION;
            }
            if (i2 == 1) {
                return COMPILER_VERSION;
            }
            if (i2 != 2) {
                return null;
            }
            return API_VERSION;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.i.a
        public final int f() {
            return this.f24150k;
        }
    }

    static {
        v vVar = new v(true);
        f24129g = vVar;
        vVar.M();
    }

    private void M() {
        this.f24133k = 0;
        this.l = 0;
        this.m = c.ERROR;
        this.n = 0;
        this.o = 0;
        this.p = d.LANGUAGE_VERSION;
    }

    public static b N() {
        return b.o();
    }

    public static b O(v vVar) {
        return N().m(vVar);
    }

    public static v z() {
        return f24129g;
    }

    public int A() {
        return this.n;
    }

    public c B() {
        return this.m;
    }

    public int C() {
        return this.o;
    }

    public int D() {
        return this.f24133k;
    }

    public int E() {
        return this.l;
    }

    public d F() {
        return this.p;
    }

    public boolean G() {
        return (this.f24132j & 8) == 8;
    }

    public boolean H() {
        return (this.f24132j & 4) == 4;
    }

    public boolean I() {
        return (this.f24132j & 16) == 16;
    }

    public boolean J() {
        return (this.f24132j & 1) == 1;
    }

    public boolean K() {
        return (this.f24132j & 2) == 2;
    }

    public boolean L() {
        return (this.f24132j & 32) == 32;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.o
    /* renamed from: P, reason: merged with bridge method [inline-methods] */
    public b f() {
        return N();
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.o
    /* renamed from: Q, reason: merged with bridge method [inline-methods] */
    public b d() {
        return O(this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.o
    public int e() {
        int i2 = this.r;
        if (i2 != -1) {
            return i2;
        }
        int o = (this.f24132j & 1) == 1 ? 0 + CodedOutputStream.o(1, this.f24133k) : 0;
        if ((this.f24132j & 2) == 2) {
            o += CodedOutputStream.o(2, this.l);
        }
        if ((this.f24132j & 4) == 4) {
            o += CodedOutputStream.h(3, this.m.f());
        }
        if ((this.f24132j & 8) == 8) {
            o += CodedOutputStream.o(4, this.n);
        }
        if ((this.f24132j & 16) == 16) {
            o += CodedOutputStream.o(5, this.o);
        }
        if ((this.f24132j & 32) == 32) {
            o += CodedOutputStream.h(6, this.p.f());
        }
        int size = o + this.f24131i.size();
        this.r = size;
        return size;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h, kotlin.reflect.jvm.internal.impl.protobuf.o
    public q<v> g() {
        return f24130h;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.o
    public void h(CodedOutputStream codedOutputStream) throws IOException {
        e();
        if ((this.f24132j & 1) == 1) {
            codedOutputStream.a0(1, this.f24133k);
        }
        if ((this.f24132j & 2) == 2) {
            codedOutputStream.a0(2, this.l);
        }
        if ((this.f24132j & 4) == 4) {
            codedOutputStream.S(3, this.m.f());
        }
        if ((this.f24132j & 8) == 8) {
            codedOutputStream.a0(4, this.n);
        }
        if ((this.f24132j & 16) == 16) {
            codedOutputStream.a0(5, this.o);
        }
        if ((this.f24132j & 32) == 32) {
            codedOutputStream.S(6, this.p.f());
        }
        codedOutputStream.i0(this.f24131i);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.p
    public final boolean isInitialized() {
        byte b2 = this.q;
        if (b2 == 1) {
            return true;
        }
        if (b2 == 0) {
            return false;
        }
        this.q = (byte) 1;
        return true;
    }

    private v(h.b bVar) {
        super(bVar);
        this.q = (byte) -1;
        this.r = -1;
        this.f24131i = bVar.l();
    }

    private v(boolean z) {
        this.q = (byte) -1;
        this.r = -1;
        this.f24131i = kotlin.reflect.jvm.internal.impl.protobuf.d.f25399f;
    }

    private v(e eVar, f fVar) throws InvalidProtocolBufferException {
        this.q = (byte) -1;
        this.r = -1;
        M();
        d.b w = kotlin.reflect.jvm.internal.impl.protobuf.d.w();
        CodedOutputStream J = CodedOutputStream.J(w, 1);
        boolean z = false;
        while (!z) {
            try {
                try {
                    int K = eVar.K();
                    if (K != 0) {
                        if (K == 8) {
                            this.f24132j |= 1;
                            this.f24133k = eVar.s();
                        } else if (K == 16) {
                            this.f24132j |= 2;
                            this.l = eVar.s();
                        } else if (K == 24) {
                            int n = eVar.n();
                            c g2 = c.g(n);
                            if (g2 == null) {
                                J.o0(K);
                                J.o0(n);
                            } else {
                                this.f24132j |= 4;
                                this.m = g2;
                            }
                        } else if (K == 32) {
                            this.f24132j |= 8;
                            this.n = eVar.s();
                        } else if (K == 40) {
                            this.f24132j |= 16;
                            this.o = eVar.s();
                        } else if (K != 48) {
                            if (!p(eVar, J, fVar, K)) {
                            }
                        } else {
                            int n2 = eVar.n();
                            d g3 = d.g(n2);
                            if (g3 == null) {
                                J.o0(K);
                                J.o0(n2);
                            } else {
                                this.f24132j |= 32;
                                this.p = g3;
                            }
                        }
                    }
                    z = true;
                } catch (InvalidProtocolBufferException e2) {
                    throw e2.i(this);
                } catch (IOException e3) {
                    throw new InvalidProtocolBufferException(e3.getMessage()).i(this);
                }
            } catch (Throwable th) {
                try {
                    J.I();
                } catch (IOException unused) {
                } catch (Throwable th2) {
                    this.f24131i = w.e();
                    throw th2;
                }
                this.f24131i = w.e();
                m();
                throw th;
            }
        }
        try {
            J.I();
        } catch (IOException unused2) {
        } catch (Throwable th3) {
            this.f24131i = w.e();
            throw th3;
        }
        this.f24131i = w.e();
        m();
    }
}
