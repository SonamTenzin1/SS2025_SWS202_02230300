package kotlin.reflect.y.internal.j0.e;

import java.io.IOException;
import kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream;
import kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException;
import kotlin.reflect.jvm.internal.impl.protobuf.a;
import kotlin.reflect.jvm.internal.impl.protobuf.d;
import kotlin.reflect.jvm.internal.impl.protobuf.e;
import kotlin.reflect.jvm.internal.impl.protobuf.f;
import kotlin.reflect.jvm.internal.impl.protobuf.h;
import kotlin.reflect.jvm.internal.impl.protobuf.p;
import kotlin.reflect.jvm.internal.impl.protobuf.q;
import kotlin.reflect.y.internal.j0.e.q;

/* compiled from: ProtoBuf.java */
/* loaded from: classes3.dex */
public final class u extends h.d<u> implements p {

    /* renamed from: h, reason: collision with root package name */
    private static final u f24122h;

    /* renamed from: i, reason: collision with root package name */
    public static q<u> f24123i = new a();

    /* renamed from: j, reason: collision with root package name */
    private final d f24124j;

    /* renamed from: k, reason: collision with root package name */
    private int f24125k;
    private int l;
    private int m;
    private q n;
    private int o;
    private q p;
    private int q;
    private byte r;
    private int s;

    /* compiled from: ProtoBuf.java */
    /* loaded from: classes3.dex */
    static class a extends kotlin.reflect.jvm.internal.impl.protobuf.b<u> {
        a() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.q
        /* renamed from: m, reason: merged with bridge method [inline-methods] */
        public u b(e eVar, f fVar) throws InvalidProtocolBufferException {
            return new u(eVar, fVar);
        }
    }

    /* compiled from: ProtoBuf.java */
    /* loaded from: classes3.dex */
    public static final class b extends h.c<u, b> implements p {

        /* renamed from: i, reason: collision with root package name */
        private int f24126i;

        /* renamed from: j, reason: collision with root package name */
        private int f24127j;

        /* renamed from: k, reason: collision with root package name */
        private int f24128k;
        private int m;
        private int o;
        private q l = q.Y();
        private q n = q.Y();

        private b() {
            A();
        }

        private void A() {
        }

        static /* synthetic */ b s() {
            return w();
        }

        private static b w() {
            return new b();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h.b
        /* renamed from: B, reason: merged with bridge method [inline-methods] */
        public b m(u uVar) {
            if (uVar == u.I()) {
                return this;
            }
            if (uVar.Q()) {
                F(uVar.K());
            }
            if (uVar.R()) {
                G(uVar.L());
            }
            if (uVar.S()) {
                D(uVar.M());
            }
            if (uVar.T()) {
                H(uVar.N());
            }
            if (uVar.U()) {
                E(uVar.O());
            }
            if (uVar.V()) {
                I(uVar.P());
            }
            r(uVar);
            n(l().f(uVar.f24124j));
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:17:0x001d  */
        @Override // kotlin.reflect.jvm.internal.impl.protobuf.a.AbstractC0413a
        /* renamed from: C, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public b i(e eVar, f fVar) throws IOException {
            u uVar = null;
            try {
                try {
                    u b2 = u.f24123i.b(eVar, fVar);
                    if (b2 != null) {
                        m(b2);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e2) {
                    u uVar2 = (u) e2.a();
                    try {
                        throw e2;
                    } catch (Throwable th) {
                        th = th;
                        uVar = uVar2;
                        if (uVar != null) {
                            m(uVar);
                        }
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                if (uVar != null) {
                }
                throw th;
            }
        }

        public b D(q qVar) {
            if ((this.f24126i & 4) == 4 && this.l != q.Y()) {
                this.l = q.z0(this.l).m(qVar).u();
            } else {
                this.l = qVar;
            }
            this.f24126i |= 4;
            return this;
        }

        public b E(q qVar) {
            if ((this.f24126i & 16) == 16 && this.n != q.Y()) {
                this.n = q.z0(this.n).m(qVar).u();
            } else {
                this.n = qVar;
            }
            this.f24126i |= 16;
            return this;
        }

        public b F(int i2) {
            this.f24126i |= 1;
            this.f24127j = i2;
            return this;
        }

        public b G(int i2) {
            this.f24126i |= 2;
            this.f24128k = i2;
            return this;
        }

        public b H(int i2) {
            this.f24126i |= 8;
            this.m = i2;
            return this;
        }

        public b I(int i2) {
            this.f24126i |= 32;
            this.o = i2;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.o.a
        /* renamed from: t, reason: merged with bridge method [inline-methods] */
        public u c() {
            u u = u();
            if (u.isInitialized()) {
                return u;
            }
            throw a.AbstractC0413a.j(u);
        }

        public u u() {
            u uVar = new u(this);
            int i2 = this.f24126i;
            int i3 = (i2 & 1) != 1 ? 0 : 1;
            uVar.l = this.f24127j;
            if ((i2 & 2) == 2) {
                i3 |= 2;
            }
            uVar.m = this.f24128k;
            if ((i2 & 4) == 4) {
                i3 |= 4;
            }
            uVar.n = this.l;
            if ((i2 & 8) == 8) {
                i3 |= 8;
            }
            uVar.o = this.m;
            if ((i2 & 16) == 16) {
                i3 |= 16;
            }
            uVar.p = this.n;
            if ((i2 & 32) == 32) {
                i3 |= 32;
            }
            uVar.q = this.o;
            uVar.f24125k = i3;
            return uVar;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h.b
        /* renamed from: v, reason: merged with bridge method [inline-methods] */
        public b k() {
            return w().m(u());
        }
    }

    static {
        u uVar = new u(true);
        f24122h = uVar;
        uVar.X();
    }

    public static u I() {
        return f24122h;
    }

    private void X() {
        this.l = 0;
        this.m = 0;
        this.n = q.Y();
        this.o = 0;
        this.p = q.Y();
        this.q = 0;
    }

    public static b Y() {
        return b.s();
    }

    public static b Z(u uVar) {
        return Y().m(uVar);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.p
    /* renamed from: J, reason: merged with bridge method [inline-methods] */
    public u b() {
        return f24122h;
    }

    public int K() {
        return this.l;
    }

    public int L() {
        return this.m;
    }

    public q M() {
        return this.n;
    }

    public int N() {
        return this.o;
    }

    public q O() {
        return this.p;
    }

    public int P() {
        return this.q;
    }

    public boolean Q() {
        return (this.f24125k & 1) == 1;
    }

    public boolean R() {
        return (this.f24125k & 2) == 2;
    }

    public boolean S() {
        return (this.f24125k & 4) == 4;
    }

    public boolean T() {
        return (this.f24125k & 8) == 8;
    }

    public boolean U() {
        return (this.f24125k & 16) == 16;
    }

    public boolean V() {
        return (this.f24125k & 32) == 32;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.o
    /* renamed from: a0, reason: merged with bridge method [inline-methods] */
    public b f() {
        return Y();
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.o
    /* renamed from: b0, reason: merged with bridge method [inline-methods] */
    public b d() {
        return Z(this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.o
    public int e() {
        int i2 = this.s;
        if (i2 != -1) {
            return i2;
        }
        int o = (this.f24125k & 1) == 1 ? 0 + CodedOutputStream.o(1, this.l) : 0;
        if ((this.f24125k & 2) == 2) {
            o += CodedOutputStream.o(2, this.m);
        }
        if ((this.f24125k & 4) == 4) {
            o += CodedOutputStream.s(3, this.n);
        }
        if ((this.f24125k & 16) == 16) {
            o += CodedOutputStream.s(4, this.p);
        }
        if ((this.f24125k & 8) == 8) {
            o += CodedOutputStream.o(5, this.o);
        }
        if ((this.f24125k & 32) == 32) {
            o += CodedOutputStream.o(6, this.q);
        }
        int t = o + t() + this.f24124j.size();
        this.s = t;
        return t;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h, kotlin.reflect.jvm.internal.impl.protobuf.o
    public q<u> g() {
        return f24123i;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.o
    public void h(CodedOutputStream codedOutputStream) throws IOException {
        e();
        h.d<MessageType>.a y = y();
        if ((this.f24125k & 1) == 1) {
            codedOutputStream.a0(1, this.l);
        }
        if ((this.f24125k & 2) == 2) {
            codedOutputStream.a0(2, this.m);
        }
        if ((this.f24125k & 4) == 4) {
            codedOutputStream.d0(3, this.n);
        }
        if ((this.f24125k & 16) == 16) {
            codedOutputStream.d0(4, this.p);
        }
        if ((this.f24125k & 8) == 8) {
            codedOutputStream.a0(5, this.o);
        }
        if ((this.f24125k & 32) == 32) {
            codedOutputStream.a0(6, this.q);
        }
        y.a(200, codedOutputStream);
        codedOutputStream.i0(this.f24124j);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.p
    public final boolean isInitialized() {
        byte b2 = this.r;
        if (b2 == 1) {
            return true;
        }
        if (b2 == 0) {
            return false;
        }
        if (!R()) {
            this.r = (byte) 0;
            return false;
        }
        if (S() && !M().isInitialized()) {
            this.r = (byte) 0;
            return false;
        }
        if (U() && !O().isInitialized()) {
            this.r = (byte) 0;
            return false;
        }
        if (!s()) {
            this.r = (byte) 0;
            return false;
        }
        this.r = (byte) 1;
        return true;
    }

    private u(h.c<u, ?> cVar) {
        super(cVar);
        this.r = (byte) -1;
        this.s = -1;
        this.f24124j = cVar.l();
    }

    private u(boolean z) {
        this.r = (byte) -1;
        this.s = -1;
        this.f24124j = d.f25399f;
    }

    private u(e eVar, f fVar) throws InvalidProtocolBufferException {
        q.c d2;
        this.r = (byte) -1;
        this.s = -1;
        X();
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
                                this.f24125k |= 1;
                                this.l = eVar.s();
                            } else if (K != 16) {
                                if (K == 26) {
                                    d2 = (this.f24125k & 4) == 4 ? this.n.d() : null;
                                    q qVar = (q) eVar.u(q.f24073i, fVar);
                                    this.n = qVar;
                                    if (d2 != null) {
                                        d2.m(qVar);
                                        this.n = d2.u();
                                    }
                                    this.f24125k |= 4;
                                } else if (K == 34) {
                                    d2 = (this.f24125k & 16) == 16 ? this.p.d() : null;
                                    q qVar2 = (q) eVar.u(q.f24073i, fVar);
                                    this.p = qVar2;
                                    if (d2 != null) {
                                        d2.m(qVar2);
                                        this.p = d2.u();
                                    }
                                    this.f24125k |= 16;
                                } else if (K == 40) {
                                    this.f24125k |= 8;
                                    this.o = eVar.s();
                                } else if (K != 48) {
                                    if (!p(eVar, J, fVar, K)) {
                                    }
                                } else {
                                    this.f24125k |= 32;
                                    this.q = eVar.s();
                                }
                            } else {
                                this.f24125k |= 2;
                                this.m = eVar.s();
                            }
                        }
                        z = true;
                    } catch (IOException e2) {
                        throw new InvalidProtocolBufferException(e2.getMessage()).i(this);
                    }
                } catch (InvalidProtocolBufferException e3) {
                    throw e3.i(this);
                }
            } catch (Throwable th) {
                try {
                    J.I();
                } catch (IOException unused) {
                } catch (Throwable th2) {
                    this.f24124j = w.e();
                    throw th2;
                }
                this.f24124j = w.e();
                m();
                throw th;
            }
        }
        try {
            J.I();
        } catch (IOException unused2) {
        } catch (Throwable th3) {
            this.f24124j = w.e();
            throw th3;
        }
        this.f24124j = w.e();
        m();
    }
}
