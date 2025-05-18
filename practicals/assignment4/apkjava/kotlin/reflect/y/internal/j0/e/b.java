package kotlin.reflect.y.internal.j0.e;

import com.google.android.gms.ads.AdRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
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
public final class b extends h implements p {

    /* renamed from: g, reason: collision with root package name */
    private static final b f23900g;

    /* renamed from: h, reason: collision with root package name */
    public static q<b> f23901h = new a();

    /* renamed from: i, reason: collision with root package name */
    private final d f23902i;

    /* renamed from: j, reason: collision with root package name */
    private int f23903j;

    /* renamed from: k, reason: collision with root package name */
    private int f23904k;
    private List<C0361b> l;
    private byte m;
    private int n;

    /* compiled from: ProtoBuf.java */
    /* loaded from: classes3.dex */
    static class a extends kotlin.reflect.jvm.internal.impl.protobuf.b<b> {
        a() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.q
        /* renamed from: m, reason: merged with bridge method [inline-methods] */
        public b b(e eVar, f fVar) throws InvalidProtocolBufferException {
            return new b(eVar, fVar);
        }
    }

    /* compiled from: ProtoBuf.java */
    /* renamed from: kotlin.f0.y.e.j0.e.b$b, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static final class C0361b extends h implements p {

        /* renamed from: g, reason: collision with root package name */
        private static final C0361b f23905g;

        /* renamed from: h, reason: collision with root package name */
        public static q<C0361b> f23906h = new a();

        /* renamed from: i, reason: collision with root package name */
        private final d f23907i;

        /* renamed from: j, reason: collision with root package name */
        private int f23908j;

        /* renamed from: k, reason: collision with root package name */
        private int f23909k;
        private c l;
        private byte m;
        private int n;

        /* compiled from: ProtoBuf.java */
        /* renamed from: kotlin.f0.y.e.j0.e.b$b$a */
        /* loaded from: classes3.dex */
        static class a extends kotlin.reflect.jvm.internal.impl.protobuf.b<C0361b> {
            a() {
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.q
            /* renamed from: m, reason: merged with bridge method [inline-methods] */
            public C0361b b(e eVar, f fVar) throws InvalidProtocolBufferException {
                return new C0361b(eVar, fVar);
            }
        }

        /* compiled from: ProtoBuf.java */
        /* renamed from: kotlin.f0.y.e.j0.e.b$b$b, reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public static final class C0362b extends h.b<C0361b, C0362b> implements p {

            /* renamed from: g, reason: collision with root package name */
            private int f23910g;

            /* renamed from: h, reason: collision with root package name */
            private int f23911h;

            /* renamed from: i, reason: collision with root package name */
            private c f23912i = c.L();

            private C0362b() {
                t();
            }

            static /* synthetic */ C0362b o() {
                return s();
            }

            private static C0362b s() {
                return new C0362b();
            }

            private void t() {
            }

            public C0362b A(int i2) {
                this.f23910g |= 1;
                this.f23911h = i2;
                return this;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.o.a
            /* renamed from: p, reason: merged with bridge method [inline-methods] */
            public C0361b c() {
                C0361b q = q();
                if (q.isInitialized()) {
                    return q;
                }
                throw a.AbstractC0413a.j(q);
            }

            public C0361b q() {
                C0361b c0361b = new C0361b(this);
                int i2 = this.f23910g;
                int i3 = (i2 & 1) != 1 ? 0 : 1;
                c0361b.f23909k = this.f23911h;
                if ((i2 & 2) == 2) {
                    i3 |= 2;
                }
                c0361b.l = this.f23912i;
                c0361b.f23908j = i3;
                return c0361b;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.h.b
            /* renamed from: r, reason: merged with bridge method [inline-methods] */
            public C0362b k() {
                return s().m(q());
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.h.b
            /* renamed from: u, reason: merged with bridge method [inline-methods] */
            public C0362b m(C0361b c0361b) {
                if (c0361b == C0361b.v()) {
                    return this;
                }
                if (c0361b.y()) {
                    A(c0361b.w());
                }
                if (c0361b.z()) {
                    w(c0361b.x());
                }
                n(l().f(c0361b.f23907i));
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:17:0x001d  */
            @Override // kotlin.reflect.jvm.internal.impl.protobuf.a.AbstractC0413a
            /* renamed from: v, reason: merged with bridge method [inline-methods] */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public C0362b i(e eVar, f fVar) throws IOException {
                C0361b c0361b = null;
                try {
                    try {
                        C0361b b2 = C0361b.f23906h.b(eVar, fVar);
                        if (b2 != null) {
                            m(b2);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e2) {
                        C0361b c0361b2 = (C0361b) e2.a();
                        try {
                            throw e2;
                        } catch (Throwable th) {
                            th = th;
                            c0361b = c0361b2;
                            if (c0361b != null) {
                                m(c0361b);
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (c0361b != null) {
                    }
                    throw th;
                }
            }

            public C0362b w(c cVar) {
                if ((this.f23910g & 2) == 2 && this.f23912i != c.L()) {
                    this.f23912i = c.g0(this.f23912i).m(cVar).q();
                } else {
                    this.f23912i = cVar;
                }
                this.f23910g |= 2;
                return this;
            }
        }

        static {
            C0361b c0361b = new C0361b(true);
            f23905g = c0361b;
            c0361b.A();
        }

        private void A() {
            this.f23909k = 0;
            this.l = c.L();
        }

        public static C0362b B() {
            return C0362b.o();
        }

        public static C0362b C(C0361b c0361b) {
            return B().m(c0361b);
        }

        public static C0361b v() {
            return f23905g;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.o
        /* renamed from: D, reason: merged with bridge method [inline-methods] */
        public C0362b f() {
            return B();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.o
        /* renamed from: E, reason: merged with bridge method [inline-methods] */
        public C0362b d() {
            return C(this);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.o
        public int e() {
            int i2 = this.n;
            if (i2 != -1) {
                return i2;
            }
            int o = (this.f23908j & 1) == 1 ? 0 + CodedOutputStream.o(1, this.f23909k) : 0;
            if ((this.f23908j & 2) == 2) {
                o += CodedOutputStream.s(2, this.l);
            }
            int size = o + this.f23907i.size();
            this.n = size;
            return size;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h, kotlin.reflect.jvm.internal.impl.protobuf.o
        public q<C0361b> g() {
            return f23906h;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.o
        public void h(CodedOutputStream codedOutputStream) throws IOException {
            e();
            if ((this.f23908j & 1) == 1) {
                codedOutputStream.a0(1, this.f23909k);
            }
            if ((this.f23908j & 2) == 2) {
                codedOutputStream.d0(2, this.l);
            }
            codedOutputStream.i0(this.f23907i);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.p
        public final boolean isInitialized() {
            byte b2 = this.m;
            if (b2 == 1) {
                return true;
            }
            if (b2 == 0) {
                return false;
            }
            if (!y()) {
                this.m = (byte) 0;
                return false;
            }
            if (!z()) {
                this.m = (byte) 0;
                return false;
            }
            if (!x().isInitialized()) {
                this.m = (byte) 0;
                return false;
            }
            this.m = (byte) 1;
            return true;
        }

        public int w() {
            return this.f23909k;
        }

        public c x() {
            return this.l;
        }

        public boolean y() {
            return (this.f23908j & 1) == 1;
        }

        public boolean z() {
            return (this.f23908j & 2) == 2;
        }

        /* compiled from: ProtoBuf.java */
        /* renamed from: kotlin.f0.y.e.j0.e.b$b$c */
        /* loaded from: classes3.dex */
        public static final class c extends h implements p {

            /* renamed from: g, reason: collision with root package name */
            private static final c f23913g;

            /* renamed from: h, reason: collision with root package name */
            public static q<c> f23914h = new a();

            /* renamed from: i, reason: collision with root package name */
            private final d f23915i;

            /* renamed from: j, reason: collision with root package name */
            private int f23916j;

            /* renamed from: k, reason: collision with root package name */
            private EnumC0364c f23917k;
            private long l;
            private float m;
            private double n;
            private int o;
            private int p;
            private int q;
            private b r;
            private List<c> s;
            private int t;
            private int u;
            private byte v;
            private int w;

            /* compiled from: ProtoBuf.java */
            /* renamed from: kotlin.f0.y.e.j0.e.b$b$c$a */
            /* loaded from: classes3.dex */
            static class a extends kotlin.reflect.jvm.internal.impl.protobuf.b<c> {
                a() {
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.q
                /* renamed from: m, reason: merged with bridge method [inline-methods] */
                public c b(e eVar, f fVar) throws InvalidProtocolBufferException {
                    return new c(eVar, fVar);
                }
            }

            /* compiled from: ProtoBuf.java */
            /* renamed from: kotlin.f0.y.e.j0.e.b$b$c$b, reason: collision with other inner class name */
            /* loaded from: classes3.dex */
            public static final class C0363b extends h.b<c, C0363b> implements p {

                /* renamed from: g, reason: collision with root package name */
                private int f23918g;

                /* renamed from: i, reason: collision with root package name */
                private long f23920i;

                /* renamed from: j, reason: collision with root package name */
                private float f23921j;

                /* renamed from: k, reason: collision with root package name */
                private double f23922k;
                private int l;
                private int m;
                private int n;
                private int q;
                private int r;

                /* renamed from: h, reason: collision with root package name */
                private EnumC0364c f23919h = EnumC0364c.BYTE;
                private b o = b.z();
                private List<c> p = Collections.emptyList();

                private C0363b() {
                    u();
                }

                static /* synthetic */ C0363b o() {
                    return s();
                }

                private static C0363b s() {
                    return new C0363b();
                }

                private void t() {
                    if ((this.f23918g & 256) != 256) {
                        this.p = new ArrayList(this.p);
                        this.f23918g |= 256;
                    }
                }

                private void u() {
                }

                /* JADX WARN: Removed duplicated region for block: B:17:0x001d  */
                @Override // kotlin.reflect.jvm.internal.impl.protobuf.a.AbstractC0413a
                /* renamed from: A, reason: merged with bridge method [inline-methods] */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public C0363b i(e eVar, f fVar) throws IOException {
                    c cVar = null;
                    try {
                        try {
                            c b2 = c.f23914h.b(eVar, fVar);
                            if (b2 != null) {
                                m(b2);
                            }
                            return this;
                        } catch (InvalidProtocolBufferException e2) {
                            c cVar2 = (c) e2.a();
                            try {
                                throw e2;
                            } catch (Throwable th) {
                                th = th;
                                cVar = cVar2;
                                if (cVar != null) {
                                    m(cVar);
                                }
                                throw th;
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        if (cVar != null) {
                        }
                        throw th;
                    }
                }

                public C0363b B(int i2) {
                    this.f23918g |= AdRequest.MAX_CONTENT_URL_LENGTH;
                    this.q = i2;
                    return this;
                }

                public C0363b C(int i2) {
                    this.f23918g |= 32;
                    this.m = i2;
                    return this;
                }

                public C0363b D(double d2) {
                    this.f23918g |= 8;
                    this.f23922k = d2;
                    return this;
                }

                public C0363b E(int i2) {
                    this.f23918g |= 64;
                    this.n = i2;
                    return this;
                }

                public C0363b F(int i2) {
                    this.f23918g |= 1024;
                    this.r = i2;
                    return this;
                }

                public C0363b G(float f2) {
                    this.f23918g |= 4;
                    this.f23921j = f2;
                    return this;
                }

                public C0363b H(long j2) {
                    this.f23918g |= 2;
                    this.f23920i = j2;
                    return this;
                }

                public C0363b I(int i2) {
                    this.f23918g |= 16;
                    this.l = i2;
                    return this;
                }

                public C0363b J(EnumC0364c enumC0364c) {
                    enumC0364c.getClass();
                    this.f23918g |= 1;
                    this.f23919h = enumC0364c;
                    return this;
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.o.a
                /* renamed from: p, reason: merged with bridge method [inline-methods] */
                public c c() {
                    c q = q();
                    if (q.isInitialized()) {
                        return q;
                    }
                    throw a.AbstractC0413a.j(q);
                }

                public c q() {
                    c cVar = new c(this);
                    int i2 = this.f23918g;
                    int i3 = (i2 & 1) != 1 ? 0 : 1;
                    cVar.f23917k = this.f23919h;
                    if ((i2 & 2) == 2) {
                        i3 |= 2;
                    }
                    cVar.l = this.f23920i;
                    if ((i2 & 4) == 4) {
                        i3 |= 4;
                    }
                    cVar.m = this.f23921j;
                    if ((i2 & 8) == 8) {
                        i3 |= 8;
                    }
                    cVar.n = this.f23922k;
                    if ((i2 & 16) == 16) {
                        i3 |= 16;
                    }
                    cVar.o = this.l;
                    if ((i2 & 32) == 32) {
                        i3 |= 32;
                    }
                    cVar.p = this.m;
                    if ((i2 & 64) == 64) {
                        i3 |= 64;
                    }
                    cVar.q = this.n;
                    if ((i2 & 128) == 128) {
                        i3 |= 128;
                    }
                    cVar.r = this.o;
                    if ((this.f23918g & 256) == 256) {
                        this.p = Collections.unmodifiableList(this.p);
                        this.f23918g &= -257;
                    }
                    cVar.s = this.p;
                    if ((i2 & AdRequest.MAX_CONTENT_URL_LENGTH) == 512) {
                        i3 |= 256;
                    }
                    cVar.t = this.q;
                    if ((i2 & 1024) == 1024) {
                        i3 |= AdRequest.MAX_CONTENT_URL_LENGTH;
                    }
                    cVar.u = this.r;
                    cVar.f23916j = i3;
                    return cVar;
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.h.b
                /* renamed from: r, reason: merged with bridge method [inline-methods] */
                public C0363b k() {
                    return s().m(q());
                }

                public C0363b v(b bVar) {
                    if ((this.f23918g & 128) == 128 && this.o != b.z()) {
                        this.o = b.E(this.o).m(bVar).q();
                    } else {
                        this.o = bVar;
                    }
                    this.f23918g |= 128;
                    return this;
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.h.b
                /* renamed from: w, reason: merged with bridge method [inline-methods] */
                public C0363b m(c cVar) {
                    if (cVar == c.L()) {
                        return this;
                    }
                    if (cVar.d0()) {
                        J(cVar.S());
                    }
                    if (cVar.b0()) {
                        H(cVar.Q());
                    }
                    if (cVar.a0()) {
                        G(cVar.P());
                    }
                    if (cVar.X()) {
                        D(cVar.M());
                    }
                    if (cVar.c0()) {
                        I(cVar.R());
                    }
                    if (cVar.V()) {
                        C(cVar.K());
                    }
                    if (cVar.Y()) {
                        E(cVar.N());
                    }
                    if (cVar.T()) {
                        v(cVar.F());
                    }
                    if (!cVar.s.isEmpty()) {
                        if (this.p.isEmpty()) {
                            this.p = cVar.s;
                            this.f23918g &= -257;
                        } else {
                            t();
                            this.p.addAll(cVar.s);
                        }
                    }
                    if (cVar.U()) {
                        B(cVar.G());
                    }
                    if (cVar.Z()) {
                        F(cVar.O());
                    }
                    n(l().f(cVar.f23915i));
                    return this;
                }
            }

            /* compiled from: ProtoBuf.java */
            /* renamed from: kotlin.f0.y.e.j0.e.b$b$c$c, reason: collision with other inner class name */
            /* loaded from: classes3.dex */
            public enum EnumC0364c implements i.a {
                BYTE(0, 0),
                CHAR(1, 1),
                SHORT(2, 2),
                INT(3, 3),
                LONG(4, 4),
                FLOAT(5, 5),
                DOUBLE(6, 6),
                BOOLEAN(7, 7),
                STRING(8, 8),
                CLASS(9, 9),
                ENUM(10, 10),
                ANNOTATION(11, 11),
                ARRAY(12, 12);

                private static i.b<EnumC0364c> s = new a();
                private final int u;

                /* compiled from: ProtoBuf.java */
                /* renamed from: kotlin.f0.y.e.j0.e.b$b$c$c$a */
                /* loaded from: classes3.dex */
                static class a implements i.b<EnumC0364c> {
                    a() {
                    }

                    @Override // kotlin.reflect.jvm.internal.impl.protobuf.i.b
                    /* renamed from: b, reason: merged with bridge method [inline-methods] */
                    public EnumC0364c a(int i2) {
                        return EnumC0364c.g(i2);
                    }
                }

                EnumC0364c(int i2, int i3) {
                    this.u = i3;
                }

                public static EnumC0364c g(int i2) {
                    switch (i2) {
                        case 0:
                            return BYTE;
                        case 1:
                            return CHAR;
                        case 2:
                            return SHORT;
                        case 3:
                            return INT;
                        case 4:
                            return LONG;
                        case 5:
                            return FLOAT;
                        case 6:
                            return DOUBLE;
                        case 7:
                            return BOOLEAN;
                        case 8:
                            return STRING;
                        case 9:
                            return CLASS;
                        case 10:
                            return ENUM;
                        case 11:
                            return ANNOTATION;
                        case 12:
                            return ARRAY;
                        default:
                            return null;
                    }
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.i.a
                public final int f() {
                    return this.u;
                }
            }

            static {
                c cVar = new c(true);
                f23913g = cVar;
                cVar.e0();
            }

            public static c L() {
                return f23913g;
            }

            private void e0() {
                this.f23917k = EnumC0364c.BYTE;
                this.l = 0L;
                this.m = 0.0f;
                this.n = 0.0d;
                this.o = 0;
                this.p = 0;
                this.q = 0;
                this.r = b.z();
                this.s = Collections.emptyList();
                this.t = 0;
                this.u = 0;
            }

            public static C0363b f0() {
                return C0363b.o();
            }

            public static C0363b g0(c cVar) {
                return f0().m(cVar);
            }

            public b F() {
                return this.r;
            }

            public int G() {
                return this.t;
            }

            public c H(int i2) {
                return this.s.get(i2);
            }

            public int I() {
                return this.s.size();
            }

            public List<c> J() {
                return this.s;
            }

            public int K() {
                return this.p;
            }

            public double M() {
                return this.n;
            }

            public int N() {
                return this.q;
            }

            public int O() {
                return this.u;
            }

            public float P() {
                return this.m;
            }

            public long Q() {
                return this.l;
            }

            public int R() {
                return this.o;
            }

            public EnumC0364c S() {
                return this.f23917k;
            }

            public boolean T() {
                return (this.f23916j & 128) == 128;
            }

            public boolean U() {
                return (this.f23916j & 256) == 256;
            }

            public boolean V() {
                return (this.f23916j & 32) == 32;
            }

            public boolean X() {
                return (this.f23916j & 8) == 8;
            }

            public boolean Y() {
                return (this.f23916j & 64) == 64;
            }

            public boolean Z() {
                return (this.f23916j & AdRequest.MAX_CONTENT_URL_LENGTH) == 512;
            }

            public boolean a0() {
                return (this.f23916j & 4) == 4;
            }

            public boolean b0() {
                return (this.f23916j & 2) == 2;
            }

            public boolean c0() {
                return (this.f23916j & 16) == 16;
            }

            public boolean d0() {
                return (this.f23916j & 1) == 1;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.o
            public int e() {
                int i2 = this.w;
                if (i2 != -1) {
                    return i2;
                }
                int h2 = (this.f23916j & 1) == 1 ? CodedOutputStream.h(1, this.f23917k.f()) + 0 : 0;
                if ((this.f23916j & 2) == 2) {
                    h2 += CodedOutputStream.A(2, this.l);
                }
                if ((this.f23916j & 4) == 4) {
                    h2 += CodedOutputStream.l(3, this.m);
                }
                if ((this.f23916j & 8) == 8) {
                    h2 += CodedOutputStream.f(4, this.n);
                }
                if ((this.f23916j & 16) == 16) {
                    h2 += CodedOutputStream.o(5, this.o);
                }
                if ((this.f23916j & 32) == 32) {
                    h2 += CodedOutputStream.o(6, this.p);
                }
                if ((this.f23916j & 64) == 64) {
                    h2 += CodedOutputStream.o(7, this.q);
                }
                if ((this.f23916j & 128) == 128) {
                    h2 += CodedOutputStream.s(8, this.r);
                }
                for (int i3 = 0; i3 < this.s.size(); i3++) {
                    h2 += CodedOutputStream.s(9, this.s.get(i3));
                }
                if ((this.f23916j & AdRequest.MAX_CONTENT_URL_LENGTH) == 512) {
                    h2 += CodedOutputStream.o(10, this.u);
                }
                if ((this.f23916j & 256) == 256) {
                    h2 += CodedOutputStream.o(11, this.t);
                }
                int size = h2 + this.f23915i.size();
                this.w = size;
                return size;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.h, kotlin.reflect.jvm.internal.impl.protobuf.o
            public q<c> g() {
                return f23914h;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.o
            public void h(CodedOutputStream codedOutputStream) throws IOException {
                e();
                if ((this.f23916j & 1) == 1) {
                    codedOutputStream.S(1, this.f23917k.f());
                }
                if ((this.f23916j & 2) == 2) {
                    codedOutputStream.t0(2, this.l);
                }
                if ((this.f23916j & 4) == 4) {
                    codedOutputStream.W(3, this.m);
                }
                if ((this.f23916j & 8) == 8) {
                    codedOutputStream.Q(4, this.n);
                }
                if ((this.f23916j & 16) == 16) {
                    codedOutputStream.a0(5, this.o);
                }
                if ((this.f23916j & 32) == 32) {
                    codedOutputStream.a0(6, this.p);
                }
                if ((this.f23916j & 64) == 64) {
                    codedOutputStream.a0(7, this.q);
                }
                if ((this.f23916j & 128) == 128) {
                    codedOutputStream.d0(8, this.r);
                }
                for (int i2 = 0; i2 < this.s.size(); i2++) {
                    codedOutputStream.d0(9, this.s.get(i2));
                }
                if ((this.f23916j & AdRequest.MAX_CONTENT_URL_LENGTH) == 512) {
                    codedOutputStream.a0(10, this.u);
                }
                if ((this.f23916j & 256) == 256) {
                    codedOutputStream.a0(11, this.t);
                }
                codedOutputStream.i0(this.f23915i);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.o
            /* renamed from: h0, reason: merged with bridge method [inline-methods] */
            public C0363b f() {
                return f0();
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.o
            /* renamed from: i0, reason: merged with bridge method [inline-methods] */
            public C0363b d() {
                return g0(this);
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.p
            public final boolean isInitialized() {
                byte b2 = this.v;
                if (b2 == 1) {
                    return true;
                }
                if (b2 == 0) {
                    return false;
                }
                if (T() && !F().isInitialized()) {
                    this.v = (byte) 0;
                    return false;
                }
                for (int i2 = 0; i2 < I(); i2++) {
                    if (!H(i2).isInitialized()) {
                        this.v = (byte) 0;
                        return false;
                    }
                }
                this.v = (byte) 1;
                return true;
            }

            private c(h.b bVar) {
                super(bVar);
                this.v = (byte) -1;
                this.w = -1;
                this.f23915i = bVar.l();
            }

            private c(boolean z) {
                this.v = (byte) -1;
                this.w = -1;
                this.f23915i = d.f25399f;
            }

            /* JADX WARN: Failed to find 'out' block for switch in B:6:0x001e. Please report as an issue. */
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r5v0 */
            /* JADX WARN: Type inference failed for: r5v1 */
            /* JADX WARN: Type inference failed for: r5v2, types: [boolean] */
            private c(e eVar, f fVar) throws InvalidProtocolBufferException {
                this.v = (byte) -1;
                this.w = -1;
                e0();
                d.b w = d.w();
                CodedOutputStream J = CodedOutputStream.J(w, 1);
                boolean z = false;
                int i2 = 0;
                while (true) {
                    ?? r5 = 256;
                    if (!z) {
                        try {
                            try {
                                int K = eVar.K();
                                switch (K) {
                                    case 0:
                                        z = true;
                                    case 8:
                                        int n = eVar.n();
                                        EnumC0364c g2 = EnumC0364c.g(n);
                                        if (g2 == null) {
                                            J.o0(K);
                                            J.o0(n);
                                        } else {
                                            this.f23916j |= 1;
                                            this.f23917k = g2;
                                        }
                                    case 16:
                                        this.f23916j |= 2;
                                        this.l = eVar.H();
                                    case 29:
                                        this.f23916j |= 4;
                                        this.m = eVar.q();
                                    case 33:
                                        this.f23916j |= 8;
                                        this.n = eVar.m();
                                    case 40:
                                        this.f23916j |= 16;
                                        this.o = eVar.s();
                                    case 48:
                                        this.f23916j |= 32;
                                        this.p = eVar.s();
                                    case 56:
                                        this.f23916j |= 64;
                                        this.q = eVar.s();
                                    case 66:
                                        c d2 = (this.f23916j & 128) == 128 ? this.r.d() : null;
                                        b bVar = (b) eVar.u(b.f23901h, fVar);
                                        this.r = bVar;
                                        if (d2 != null) {
                                            d2.m(bVar);
                                            this.r = d2.q();
                                        }
                                        this.f23916j |= 128;
                                    case 74:
                                        if ((i2 & 256) != 256) {
                                            this.s = new ArrayList();
                                            i2 |= 256;
                                        }
                                        this.s.add(eVar.u(f23914h, fVar));
                                    case 80:
                                        this.f23916j |= AdRequest.MAX_CONTENT_URL_LENGTH;
                                        this.u = eVar.s();
                                    case 88:
                                        this.f23916j |= 256;
                                        this.t = eVar.s();
                                    default:
                                        r5 = p(eVar, J, fVar, K);
                                        if (r5 == 0) {
                                            z = true;
                                        }
                                }
                            } catch (InvalidProtocolBufferException e2) {
                                throw e2.i(this);
                            } catch (IOException e3) {
                                throw new InvalidProtocolBufferException(e3.getMessage()).i(this);
                            }
                        } catch (Throwable th) {
                            if ((i2 & 256) == r5) {
                                this.s = Collections.unmodifiableList(this.s);
                            }
                            try {
                                J.I();
                            } catch (IOException unused) {
                            } catch (Throwable th2) {
                                this.f23915i = w.e();
                                throw th2;
                            }
                            this.f23915i = w.e();
                            m();
                            throw th;
                        }
                    } else {
                        if ((i2 & 256) == 256) {
                            this.s = Collections.unmodifiableList(this.s);
                        }
                        try {
                            J.I();
                        } catch (IOException unused2) {
                        } catch (Throwable th3) {
                            this.f23915i = w.e();
                            throw th3;
                        }
                        this.f23915i = w.e();
                        m();
                        return;
                    }
                }
            }
        }

        private C0361b(h.b bVar) {
            super(bVar);
            this.m = (byte) -1;
            this.n = -1;
            this.f23907i = bVar.l();
        }

        private C0361b(boolean z) {
            this.m = (byte) -1;
            this.n = -1;
            this.f23907i = d.f25399f;
        }

        private C0361b(e eVar, f fVar) throws InvalidProtocolBufferException {
            this.m = (byte) -1;
            this.n = -1;
            A();
            d.b w = d.w();
            CodedOutputStream J = CodedOutputStream.J(w, 1);
            boolean z = false;
            while (!z) {
                try {
                    try {
                        try {
                            int K = eVar.K();
                            if (K != 0) {
                                if (K == 8) {
                                    this.f23908j |= 1;
                                    this.f23909k = eVar.s();
                                } else if (K != 18) {
                                    if (!p(eVar, J, fVar, K)) {
                                    }
                                } else {
                                    c.C0363b d2 = (this.f23908j & 2) == 2 ? this.l.d() : null;
                                    c cVar = (c) eVar.u(c.f23914h, fVar);
                                    this.l = cVar;
                                    if (d2 != null) {
                                        d2.m(cVar);
                                        this.l = d2.q();
                                    }
                                    this.f23908j |= 2;
                                }
                            }
                            z = true;
                        } catch (InvalidProtocolBufferException e2) {
                            throw e2.i(this);
                        }
                    } catch (IOException e3) {
                        throw new InvalidProtocolBufferException(e3.getMessage()).i(this);
                    }
                } catch (Throwable th) {
                    try {
                        J.I();
                    } catch (IOException unused) {
                    } catch (Throwable th2) {
                        this.f23907i = w.e();
                        throw th2;
                    }
                    this.f23907i = w.e();
                    m();
                    throw th;
                }
            }
            try {
                J.I();
            } catch (IOException unused2) {
            } catch (Throwable th3) {
                this.f23907i = w.e();
                throw th3;
            }
            this.f23907i = w.e();
            m();
        }
    }

    /* compiled from: ProtoBuf.java */
    /* loaded from: classes3.dex */
    public static final class c extends h.b<b, c> implements p {

        /* renamed from: g, reason: collision with root package name */
        private int f23929g;

        /* renamed from: h, reason: collision with root package name */
        private int f23930h;

        /* renamed from: i, reason: collision with root package name */
        private List<C0361b> f23931i = Collections.emptyList();

        private c() {
            u();
        }

        static /* synthetic */ c o() {
            return s();
        }

        private static c s() {
            return new c();
        }

        private void t() {
            if ((this.f23929g & 2) != 2) {
                this.f23931i = new ArrayList(this.f23931i);
                this.f23929g |= 2;
            }
        }

        private void u() {
        }

        public c A(int i2) {
            this.f23929g |= 1;
            this.f23930h = i2;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.o.a
        /* renamed from: p, reason: merged with bridge method [inline-methods] */
        public b c() {
            b q = q();
            if (q.isInitialized()) {
                return q;
            }
            throw a.AbstractC0413a.j(q);
        }

        public b q() {
            b bVar = new b(this);
            int i2 = (this.f23929g & 1) != 1 ? 0 : 1;
            bVar.f23904k = this.f23930h;
            if ((this.f23929g & 2) == 2) {
                this.f23931i = Collections.unmodifiableList(this.f23931i);
                this.f23929g &= -3;
            }
            bVar.l = this.f23931i;
            bVar.f23903j = i2;
            return bVar;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h.b
        /* renamed from: r, reason: merged with bridge method [inline-methods] */
        public c k() {
            return s().m(q());
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h.b
        /* renamed from: v, reason: merged with bridge method [inline-methods] */
        public c m(b bVar) {
            if (bVar == b.z()) {
                return this;
            }
            if (bVar.B()) {
                A(bVar.A());
            }
            if (!bVar.l.isEmpty()) {
                if (this.f23931i.isEmpty()) {
                    this.f23931i = bVar.l;
                    this.f23929g &= -3;
                } else {
                    t();
                    this.f23931i.addAll(bVar.l);
                }
            }
            n(l().f(bVar.f23902i));
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:17:0x001d  */
        @Override // kotlin.reflect.jvm.internal.impl.protobuf.a.AbstractC0413a
        /* renamed from: w, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public c i(e eVar, f fVar) throws IOException {
            b bVar = null;
            try {
                try {
                    b b2 = b.f23901h.b(eVar, fVar);
                    if (b2 != null) {
                        m(b2);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e2) {
                    b bVar2 = (b) e2.a();
                    try {
                        throw e2;
                    } catch (Throwable th) {
                        th = th;
                        bVar = bVar2;
                        if (bVar != null) {
                            m(bVar);
                        }
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                if (bVar != null) {
                }
                throw th;
            }
        }
    }

    static {
        b bVar = new b(true);
        f23900g = bVar;
        bVar.C();
    }

    private void C() {
        this.f23904k = 0;
        this.l = Collections.emptyList();
    }

    public static c D() {
        return c.o();
    }

    public static c E(b bVar) {
        return D().m(bVar);
    }

    public static b z() {
        return f23900g;
    }

    public int A() {
        return this.f23904k;
    }

    public boolean B() {
        return (this.f23903j & 1) == 1;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.o
    /* renamed from: F, reason: merged with bridge method [inline-methods] */
    public c f() {
        return D();
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.o
    /* renamed from: G, reason: merged with bridge method [inline-methods] */
    public c d() {
        return E(this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.o
    public int e() {
        int i2 = this.n;
        if (i2 != -1) {
            return i2;
        }
        int o = (this.f23903j & 1) == 1 ? CodedOutputStream.o(1, this.f23904k) + 0 : 0;
        for (int i3 = 0; i3 < this.l.size(); i3++) {
            o += CodedOutputStream.s(2, this.l.get(i3));
        }
        int size = o + this.f23902i.size();
        this.n = size;
        return size;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h, kotlin.reflect.jvm.internal.impl.protobuf.o
    public q<b> g() {
        return f23901h;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.o
    public void h(CodedOutputStream codedOutputStream) throws IOException {
        e();
        if ((this.f23903j & 1) == 1) {
            codedOutputStream.a0(1, this.f23904k);
        }
        for (int i2 = 0; i2 < this.l.size(); i2++) {
            codedOutputStream.d0(2, this.l.get(i2));
        }
        codedOutputStream.i0(this.f23902i);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.p
    public final boolean isInitialized() {
        byte b2 = this.m;
        if (b2 == 1) {
            return true;
        }
        if (b2 == 0) {
            return false;
        }
        if (!B()) {
            this.m = (byte) 0;
            return false;
        }
        for (int i2 = 0; i2 < x(); i2++) {
            if (!w(i2).isInitialized()) {
                this.m = (byte) 0;
                return false;
            }
        }
        this.m = (byte) 1;
        return true;
    }

    public C0361b w(int i2) {
        return this.l.get(i2);
    }

    public int x() {
        return this.l.size();
    }

    public List<C0361b> y() {
        return this.l;
    }

    private b(h.b bVar) {
        super(bVar);
        this.m = (byte) -1;
        this.n = -1;
        this.f23902i = bVar.l();
    }

    private b(boolean z) {
        this.m = (byte) -1;
        this.n = -1;
        this.f23902i = d.f25399f;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private b(e eVar, f fVar) throws InvalidProtocolBufferException {
        this.m = (byte) -1;
        this.n = -1;
        C();
        d.b w = d.w();
        CodedOutputStream J = CodedOutputStream.J(w, 1);
        boolean z = false;
        int i2 = 0;
        while (!z) {
            try {
                try {
                    int K = eVar.K();
                    if (K != 0) {
                        if (K == 8) {
                            this.f23903j |= 1;
                            this.f23904k = eVar.s();
                        } else if (K != 18) {
                            if (!p(eVar, J, fVar, K)) {
                            }
                        } else {
                            if ((i2 & 2) != 2) {
                                this.l = new ArrayList();
                                i2 |= 2;
                            }
                            this.l.add(eVar.u(C0361b.f23906h, fVar));
                        }
                    }
                    z = true;
                } catch (Throwable th) {
                    if ((i2 & 2) == 2) {
                        this.l = Collections.unmodifiableList(this.l);
                    }
                    try {
                        J.I();
                    } catch (IOException unused) {
                    } catch (Throwable th2) {
                        this.f23902i = w.e();
                        throw th2;
                    }
                    this.f23902i = w.e();
                    m();
                    throw th;
                }
            } catch (InvalidProtocolBufferException e2) {
                throw e2.i(this);
            } catch (IOException e3) {
                throw new InvalidProtocolBufferException(e3.getMessage()).i(this);
            }
        }
        if ((i2 & 2) == 2) {
            this.l = Collections.unmodifiableList(this.l);
        }
        try {
            J.I();
        } catch (IOException unused2) {
        } catch (Throwable th3) {
            this.f23902i = w.e();
            throw th3;
        }
        this.f23902i = w.e();
        m();
    }
}
