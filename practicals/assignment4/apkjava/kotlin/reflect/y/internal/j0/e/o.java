package kotlin.reflect.y.internal.j0.e;

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
public final class o extends h implements p {

    /* renamed from: g, reason: collision with root package name */
    private static final o f24043g;

    /* renamed from: h, reason: collision with root package name */
    public static q<o> f24044h = new a();

    /* renamed from: i, reason: collision with root package name */
    private final d f24045i;

    /* renamed from: j, reason: collision with root package name */
    private List<c> f24046j;

    /* renamed from: k, reason: collision with root package name */
    private byte f24047k;
    private int l;

    /* compiled from: ProtoBuf.java */
    /* loaded from: classes3.dex */
    static class a extends kotlin.reflect.jvm.internal.impl.protobuf.b<o> {
        a() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.q
        /* renamed from: m, reason: merged with bridge method [inline-methods] */
        public o b(e eVar, f fVar) throws InvalidProtocolBufferException {
            return new o(eVar, fVar);
        }
    }

    /* compiled from: ProtoBuf.java */
    /* loaded from: classes3.dex */
    public static final class b extends h.b<o, b> implements p {

        /* renamed from: g, reason: collision with root package name */
        private int f24048g;

        /* renamed from: h, reason: collision with root package name */
        private List<c> f24049h = Collections.emptyList();

        private b() {
            u();
        }

        static /* synthetic */ b o() {
            return s();
        }

        private static b s() {
            return new b();
        }

        private void t() {
            if ((this.f24048g & 1) != 1) {
                this.f24049h = new ArrayList(this.f24049h);
                this.f24048g |= 1;
            }
        }

        private void u() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.o.a
        /* renamed from: p, reason: merged with bridge method [inline-methods] */
        public o c() {
            o q = q();
            if (q.isInitialized()) {
                return q;
            }
            throw a.AbstractC0413a.j(q);
        }

        public o q() {
            o oVar = new o(this);
            if ((this.f24048g & 1) == 1) {
                this.f24049h = Collections.unmodifiableList(this.f24049h);
                this.f24048g &= -2;
            }
            oVar.f24046j = this.f24049h;
            return oVar;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h.b
        /* renamed from: r, reason: merged with bridge method [inline-methods] */
        public b k() {
            return s().m(q());
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h.b
        /* renamed from: v, reason: merged with bridge method [inline-methods] */
        public b m(o oVar) {
            if (oVar == o.u()) {
                return this;
            }
            if (!oVar.f24046j.isEmpty()) {
                if (this.f24049h.isEmpty()) {
                    this.f24049h = oVar.f24046j;
                    this.f24048g &= -2;
                } else {
                    t();
                    this.f24049h.addAll(oVar.f24046j);
                }
            }
            n(l().f(oVar.f24045i));
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:17:0x001d  */
        @Override // kotlin.reflect.jvm.internal.impl.protobuf.a.AbstractC0413a
        /* renamed from: w, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public b i(e eVar, f fVar) throws IOException {
            o oVar = null;
            try {
                try {
                    o b2 = o.f24044h.b(eVar, fVar);
                    if (b2 != null) {
                        m(b2);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e2) {
                    o oVar2 = (o) e2.a();
                    try {
                        throw e2;
                    } catch (Throwable th) {
                        th = th;
                        oVar = oVar2;
                        if (oVar != null) {
                            m(oVar);
                        }
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                if (oVar != null) {
                }
                throw th;
            }
        }
    }

    static {
        o oVar = new o(true);
        f24043g = oVar;
        oVar.x();
    }

    public static o u() {
        return f24043g;
    }

    private void x() {
        this.f24046j = Collections.emptyList();
    }

    public static b y() {
        return b.o();
    }

    public static b z(o oVar) {
        return y().m(oVar);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.o
    /* renamed from: A, reason: merged with bridge method [inline-methods] */
    public b f() {
        return y();
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.o
    /* renamed from: B, reason: merged with bridge method [inline-methods] */
    public b d() {
        return z(this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.o
    public int e() {
        int i2 = this.l;
        if (i2 != -1) {
            return i2;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < this.f24046j.size(); i4++) {
            i3 += CodedOutputStream.s(1, this.f24046j.get(i4));
        }
        int size = i3 + this.f24045i.size();
        this.l = size;
        return size;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h, kotlin.reflect.jvm.internal.impl.protobuf.o
    public q<o> g() {
        return f24044h;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.o
    public void h(CodedOutputStream codedOutputStream) throws IOException {
        e();
        for (int i2 = 0; i2 < this.f24046j.size(); i2++) {
            codedOutputStream.d0(1, this.f24046j.get(i2));
        }
        codedOutputStream.i0(this.f24045i);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.p
    public final boolean isInitialized() {
        byte b2 = this.f24047k;
        if (b2 == 1) {
            return true;
        }
        if (b2 == 0) {
            return false;
        }
        for (int i2 = 0; i2 < w(); i2++) {
            if (!v(i2).isInitialized()) {
                this.f24047k = (byte) 0;
                return false;
            }
        }
        this.f24047k = (byte) 1;
        return true;
    }

    public c v(int i2) {
        return this.f24046j.get(i2);
    }

    public int w() {
        return this.f24046j.size();
    }

    /* compiled from: ProtoBuf.java */
    /* loaded from: classes3.dex */
    public static final class c extends h implements p {

        /* renamed from: g, reason: collision with root package name */
        private static final c f24050g;

        /* renamed from: h, reason: collision with root package name */
        public static q<c> f24051h = new a();

        /* renamed from: i, reason: collision with root package name */
        private final d f24052i;

        /* renamed from: j, reason: collision with root package name */
        private int f24053j;

        /* renamed from: k, reason: collision with root package name */
        private int f24054k;
        private int l;
        private EnumC0366c m;
        private byte n;
        private int o;

        /* compiled from: ProtoBuf.java */
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
        /* loaded from: classes3.dex */
        public static final class b extends h.b<c, b> implements p {

            /* renamed from: g, reason: collision with root package name */
            private int f24055g;

            /* renamed from: i, reason: collision with root package name */
            private int f24057i;

            /* renamed from: h, reason: collision with root package name */
            private int f24056h = -1;

            /* renamed from: j, reason: collision with root package name */
            private EnumC0366c f24058j = EnumC0366c.PACKAGE;

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

            public b A(int i2) {
                this.f24055g |= 1;
                this.f24056h = i2;
                return this;
            }

            public b B(int i2) {
                this.f24055g |= 2;
                this.f24057i = i2;
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
                int i2 = this.f24055g;
                int i3 = (i2 & 1) != 1 ? 0 : 1;
                cVar.f24054k = this.f24056h;
                if ((i2 & 2) == 2) {
                    i3 |= 2;
                }
                cVar.l = this.f24057i;
                if ((i2 & 4) == 4) {
                    i3 |= 4;
                }
                cVar.m = this.f24058j;
                cVar.f24053j = i3;
                return cVar;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.h.b
            /* renamed from: r, reason: merged with bridge method [inline-methods] */
            public b k() {
                return s().m(q());
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.h.b
            /* renamed from: u, reason: merged with bridge method [inline-methods] */
            public b m(c cVar) {
                if (cVar == c.w()) {
                    return this;
                }
                if (cVar.B()) {
                    A(cVar.y());
                }
                if (cVar.C()) {
                    B(cVar.z());
                }
                if (cVar.A()) {
                    w(cVar.x());
                }
                n(l().f(cVar.f24052i));
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:17:0x001d  */
            @Override // kotlin.reflect.jvm.internal.impl.protobuf.a.AbstractC0413a
            /* renamed from: v, reason: merged with bridge method [inline-methods] */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public b i(e eVar, f fVar) throws IOException {
                c cVar = null;
                try {
                    try {
                        c b2 = c.f24051h.b(eVar, fVar);
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

            public b w(EnumC0366c enumC0366c) {
                enumC0366c.getClass();
                this.f24055g |= 4;
                this.f24058j = enumC0366c;
                return this;
            }
        }

        /* compiled from: ProtoBuf.java */
        /* renamed from: kotlin.f0.y.e.j0.e.o$c$c, reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public enum EnumC0366c implements i.a {
            CLASS(0, 0),
            PACKAGE(1, 1),
            LOCAL(2, 2);


            /* renamed from: i, reason: collision with root package name */
            private static i.b<EnumC0366c> f24062i = new a();

            /* renamed from: k, reason: collision with root package name */
            private final int f24064k;

            /* compiled from: ProtoBuf.java */
            /* renamed from: kotlin.f0.y.e.j0.e.o$c$c$a */
            /* loaded from: classes3.dex */
            static class a implements i.b<EnumC0366c> {
                a() {
                }

                @Override // kotlin.reflect.jvm.internal.impl.protobuf.i.b
                /* renamed from: b, reason: merged with bridge method [inline-methods] */
                public EnumC0366c a(int i2) {
                    return EnumC0366c.g(i2);
                }
            }

            EnumC0366c(int i2, int i3) {
                this.f24064k = i3;
            }

            public static EnumC0366c g(int i2) {
                if (i2 == 0) {
                    return CLASS;
                }
                if (i2 == 1) {
                    return PACKAGE;
                }
                if (i2 != 2) {
                    return null;
                }
                return LOCAL;
            }

            @Override // kotlin.reflect.jvm.internal.impl.protobuf.i.a
            public final int f() {
                return this.f24064k;
            }
        }

        static {
            c cVar = new c(true);
            f24050g = cVar;
            cVar.D();
        }

        private void D() {
            this.f24054k = -1;
            this.l = 0;
            this.m = EnumC0366c.PACKAGE;
        }

        public static b E() {
            return b.o();
        }

        public static b F(c cVar) {
            return E().m(cVar);
        }

        public static c w() {
            return f24050g;
        }

        public boolean A() {
            return (this.f24053j & 4) == 4;
        }

        public boolean B() {
            return (this.f24053j & 1) == 1;
        }

        public boolean C() {
            return (this.f24053j & 2) == 2;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.o
        /* renamed from: G, reason: merged with bridge method [inline-methods] */
        public b f() {
            return E();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.o
        /* renamed from: H, reason: merged with bridge method [inline-methods] */
        public b d() {
            return F(this);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.o
        public int e() {
            int i2 = this.o;
            if (i2 != -1) {
                return i2;
            }
            int o = (this.f24053j & 1) == 1 ? 0 + CodedOutputStream.o(1, this.f24054k) : 0;
            if ((this.f24053j & 2) == 2) {
                o += CodedOutputStream.o(2, this.l);
            }
            if ((this.f24053j & 4) == 4) {
                o += CodedOutputStream.h(3, this.m.f());
            }
            int size = o + this.f24052i.size();
            this.o = size;
            return size;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h, kotlin.reflect.jvm.internal.impl.protobuf.o
        public q<c> g() {
            return f24051h;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.o
        public void h(CodedOutputStream codedOutputStream) throws IOException {
            e();
            if ((this.f24053j & 1) == 1) {
                codedOutputStream.a0(1, this.f24054k);
            }
            if ((this.f24053j & 2) == 2) {
                codedOutputStream.a0(2, this.l);
            }
            if ((this.f24053j & 4) == 4) {
                codedOutputStream.S(3, this.m.f());
            }
            codedOutputStream.i0(this.f24052i);
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.p
        public final boolean isInitialized() {
            byte b2 = this.n;
            if (b2 == 1) {
                return true;
            }
            if (b2 == 0) {
                return false;
            }
            if (!C()) {
                this.n = (byte) 0;
                return false;
            }
            this.n = (byte) 1;
            return true;
        }

        public EnumC0366c x() {
            return this.m;
        }

        public int y() {
            return this.f24054k;
        }

        public int z() {
            return this.l;
        }

        private c(h.b bVar) {
            super(bVar);
            this.n = (byte) -1;
            this.o = -1;
            this.f24052i = bVar.l();
        }

        private c(boolean z) {
            this.n = (byte) -1;
            this.o = -1;
            this.f24052i = d.f25399f;
        }

        private c(e eVar, f fVar) throws InvalidProtocolBufferException {
            this.n = (byte) -1;
            this.o = -1;
            D();
            d.b w = d.w();
            CodedOutputStream J = CodedOutputStream.J(w, 1);
            boolean z = false;
            while (!z) {
                try {
                    try {
                        int K = eVar.K();
                        if (K != 0) {
                            if (K == 8) {
                                this.f24053j |= 1;
                                this.f24054k = eVar.s();
                            } else if (K == 16) {
                                this.f24053j |= 2;
                                this.l = eVar.s();
                            } else if (K != 24) {
                                if (!p(eVar, J, fVar, K)) {
                                }
                            } else {
                                int n = eVar.n();
                                EnumC0366c g2 = EnumC0366c.g(n);
                                if (g2 == null) {
                                    J.o0(K);
                                    J.o0(n);
                                } else {
                                    this.f24053j |= 4;
                                    this.m = g2;
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
                        this.f24052i = w.e();
                        throw th2;
                    }
                    this.f24052i = w.e();
                    m();
                    throw th;
                }
            }
            try {
                J.I();
            } catch (IOException unused2) {
            } catch (Throwable th3) {
                this.f24052i = w.e();
                throw th3;
            }
            this.f24052i = w.e();
            m();
        }
    }

    private o(h.b bVar) {
        super(bVar);
        this.f24047k = (byte) -1;
        this.l = -1;
        this.f24045i = bVar.l();
    }

    private o(boolean z) {
        this.f24047k = (byte) -1;
        this.l = -1;
        this.f24045i = d.f25399f;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private o(e eVar, f fVar) throws InvalidProtocolBufferException {
        this.f24047k = (byte) -1;
        this.l = -1;
        x();
        d.b w = d.w();
        CodedOutputStream J = CodedOutputStream.J(w, 1);
        boolean z = false;
        boolean z2 = false;
        while (!z) {
            try {
                try {
                    int K = eVar.K();
                    if (K != 0) {
                        if (K != 10) {
                            if (!p(eVar, J, fVar, K)) {
                            }
                        } else {
                            if (!(z2 & true)) {
                                this.f24046j = new ArrayList();
                                z2 |= true;
                            }
                            this.f24046j.add(eVar.u(c.f24051h, fVar));
                        }
                    }
                    z = true;
                } catch (Throwable th) {
                    if (z2 & true) {
                        this.f24046j = Collections.unmodifiableList(this.f24046j);
                    }
                    try {
                        J.I();
                    } catch (IOException unused) {
                    } catch (Throwable th2) {
                        this.f24045i = w.e();
                        throw th2;
                    }
                    this.f24045i = w.e();
                    m();
                    throw th;
                }
            } catch (InvalidProtocolBufferException e2) {
                throw e2.i(this);
            } catch (IOException e3) {
                throw new InvalidProtocolBufferException(e3.getMessage()).i(this);
            }
        }
        if (z2 & true) {
            this.f24046j = Collections.unmodifiableList(this.f24046j);
        }
        try {
            J.I();
        } catch (IOException unused2) {
        } catch (Throwable th3) {
            this.f24045i = w.e();
            throw th3;
        }
        this.f24045i = w.e();
        m();
    }
}
