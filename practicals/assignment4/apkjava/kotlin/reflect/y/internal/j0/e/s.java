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
public final class s extends h.d<s> implements p {

    /* renamed from: h, reason: collision with root package name */
    private static final s f24101h;

    /* renamed from: i, reason: collision with root package name */
    public static q<s> f24102i = new a();

    /* renamed from: j, reason: collision with root package name */
    private final d f24103j;

    /* renamed from: k, reason: collision with root package name */
    private int f24104k;
    private int l;
    private int m;
    private boolean n;
    private c o;
    private List<q> p;
    private List<Integer> q;
    private int r;
    private byte s;
    private int t;

    /* compiled from: ProtoBuf.java */
    /* loaded from: classes3.dex */
    static class a extends kotlin.reflect.jvm.internal.impl.protobuf.b<s> {
        a() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.q
        /* renamed from: m, reason: merged with bridge method [inline-methods] */
        public s b(e eVar, f fVar) throws InvalidProtocolBufferException {
            return new s(eVar, fVar);
        }
    }

    /* compiled from: ProtoBuf.java */
    /* loaded from: classes3.dex */
    public static final class b extends h.c<s, b> implements p {

        /* renamed from: i, reason: collision with root package name */
        private int f24105i;

        /* renamed from: j, reason: collision with root package name */
        private int f24106j;

        /* renamed from: k, reason: collision with root package name */
        private int f24107k;
        private boolean l;
        private c m = c.INV;
        private List<q> n = Collections.emptyList();
        private List<Integer> o = Collections.emptyList();

        private b() {
            C();
        }

        private void A() {
            if ((this.f24105i & 32) != 32) {
                this.o = new ArrayList(this.o);
                this.f24105i |= 32;
            }
        }

        private void B() {
            if ((this.f24105i & 16) != 16) {
                this.n = new ArrayList(this.n);
                this.f24105i |= 16;
            }
        }

        private void C() {
        }

        static /* synthetic */ b s() {
            return w();
        }

        private static b w() {
            return new b();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h.b
        /* renamed from: D, reason: merged with bridge method [inline-methods] */
        public b m(s sVar) {
            if (sVar == s.K()) {
                return this;
            }
            if (sVar.U()) {
                F(sVar.M());
            }
            if (sVar.V()) {
                G(sVar.N());
            }
            if (sVar.X()) {
                H(sVar.O());
            }
            if (sVar.Y()) {
                I(sVar.T());
            }
            if (!sVar.p.isEmpty()) {
                if (this.n.isEmpty()) {
                    this.n = sVar.p;
                    this.f24105i &= -17;
                } else {
                    B();
                    this.n.addAll(sVar.p);
                }
            }
            if (!sVar.q.isEmpty()) {
                if (this.o.isEmpty()) {
                    this.o = sVar.q;
                    this.f24105i &= -33;
                } else {
                    A();
                    this.o.addAll(sVar.q);
                }
            }
            r(sVar);
            n(l().f(sVar.f24103j));
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:17:0x001d  */
        @Override // kotlin.reflect.jvm.internal.impl.protobuf.a.AbstractC0413a
        /* renamed from: E, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public b i(e eVar, f fVar) throws IOException {
            s sVar = null;
            try {
                try {
                    s b2 = s.f24102i.b(eVar, fVar);
                    if (b2 != null) {
                        m(b2);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e2) {
                    s sVar2 = (s) e2.a();
                    try {
                        throw e2;
                    } catch (Throwable th) {
                        th = th;
                        sVar = sVar2;
                        if (sVar != null) {
                            m(sVar);
                        }
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                if (sVar != null) {
                }
                throw th;
            }
        }

        public b F(int i2) {
            this.f24105i |= 1;
            this.f24106j = i2;
            return this;
        }

        public b G(int i2) {
            this.f24105i |= 2;
            this.f24107k = i2;
            return this;
        }

        public b H(boolean z) {
            this.f24105i |= 4;
            this.l = z;
            return this;
        }

        public b I(c cVar) {
            cVar.getClass();
            this.f24105i |= 8;
            this.m = cVar;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.o.a
        /* renamed from: t, reason: merged with bridge method [inline-methods] */
        public s c() {
            s u = u();
            if (u.isInitialized()) {
                return u;
            }
            throw a.AbstractC0413a.j(u);
        }

        public s u() {
            s sVar = new s(this);
            int i2 = this.f24105i;
            int i3 = (i2 & 1) != 1 ? 0 : 1;
            sVar.l = this.f24106j;
            if ((i2 & 2) == 2) {
                i3 |= 2;
            }
            sVar.m = this.f24107k;
            if ((i2 & 4) == 4) {
                i3 |= 4;
            }
            sVar.n = this.l;
            if ((i2 & 8) == 8) {
                i3 |= 8;
            }
            sVar.o = this.m;
            if ((this.f24105i & 16) == 16) {
                this.n = Collections.unmodifiableList(this.n);
                this.f24105i &= -17;
            }
            sVar.p = this.n;
            if ((this.f24105i & 32) == 32) {
                this.o = Collections.unmodifiableList(this.o);
                this.f24105i &= -33;
            }
            sVar.q = this.o;
            sVar.f24104k = i3;
            return sVar;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h.b
        /* renamed from: v, reason: merged with bridge method [inline-methods] */
        public b k() {
            return w().m(u());
        }
    }

    /* compiled from: ProtoBuf.java */
    /* loaded from: classes3.dex */
    public enum c implements i.a {
        IN(0, 0),
        OUT(1, 1),
        INV(2, 2);


        /* renamed from: i, reason: collision with root package name */
        private static i.b<c> f24111i = new a();

        /* renamed from: k, reason: collision with root package name */
        private final int f24113k;

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
            this.f24113k = i3;
        }

        public static c g(int i2) {
            if (i2 == 0) {
                return IN;
            }
            if (i2 == 1) {
                return OUT;
            }
            if (i2 != 2) {
                return null;
            }
            return INV;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.i.a
        public final int f() {
            return this.f24113k;
        }
    }

    static {
        s sVar = new s(true);
        f24101h = sVar;
        sVar.Z();
    }

    public static s K() {
        return f24101h;
    }

    private void Z() {
        this.l = 0;
        this.m = 0;
        this.n = false;
        this.o = c.INV;
        this.p = Collections.emptyList();
        this.q = Collections.emptyList();
    }

    public static b a0() {
        return b.s();
    }

    public static b b0(s sVar) {
        return a0().m(sVar);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.p
    /* renamed from: L, reason: merged with bridge method [inline-methods] */
    public s b() {
        return f24101h;
    }

    public int M() {
        return this.l;
    }

    public int N() {
        return this.m;
    }

    public boolean O() {
        return this.n;
    }

    public q P(int i2) {
        return this.p.get(i2);
    }

    public int Q() {
        return this.p.size();
    }

    public List<Integer> R() {
        return this.q;
    }

    public List<q> S() {
        return this.p;
    }

    public c T() {
        return this.o;
    }

    public boolean U() {
        return (this.f24104k & 1) == 1;
    }

    public boolean V() {
        return (this.f24104k & 2) == 2;
    }

    public boolean X() {
        return (this.f24104k & 4) == 4;
    }

    public boolean Y() {
        return (this.f24104k & 8) == 8;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.o
    /* renamed from: c0, reason: merged with bridge method [inline-methods] */
    public b f() {
        return a0();
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.o
    /* renamed from: d0, reason: merged with bridge method [inline-methods] */
    public b d() {
        return b0(this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.o
    public int e() {
        int i2 = this.t;
        if (i2 != -1) {
            return i2;
        }
        int o = (this.f24104k & 1) == 1 ? CodedOutputStream.o(1, this.l) + 0 : 0;
        if ((this.f24104k & 2) == 2) {
            o += CodedOutputStream.o(2, this.m);
        }
        if ((this.f24104k & 4) == 4) {
            o += CodedOutputStream.a(3, this.n);
        }
        if ((this.f24104k & 8) == 8) {
            o += CodedOutputStream.h(4, this.o.f());
        }
        for (int i3 = 0; i3 < this.p.size(); i3++) {
            o += CodedOutputStream.s(5, this.p.get(i3));
        }
        int i4 = 0;
        for (int i5 = 0; i5 < this.q.size(); i5++) {
            i4 += CodedOutputStream.p(this.q.get(i5).intValue());
        }
        int i6 = o + i4;
        if (!R().isEmpty()) {
            i6 = i6 + 1 + CodedOutputStream.p(i4);
        }
        this.r = i4;
        int t = i6 + t() + this.f24103j.size();
        this.t = t;
        return t;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h, kotlin.reflect.jvm.internal.impl.protobuf.o
    public q<s> g() {
        return f24102i;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.o
    public void h(CodedOutputStream codedOutputStream) throws IOException {
        e();
        h.d<MessageType>.a y = y();
        if ((this.f24104k & 1) == 1) {
            codedOutputStream.a0(1, this.l);
        }
        if ((this.f24104k & 2) == 2) {
            codedOutputStream.a0(2, this.m);
        }
        if ((this.f24104k & 4) == 4) {
            codedOutputStream.L(3, this.n);
        }
        if ((this.f24104k & 8) == 8) {
            codedOutputStream.S(4, this.o.f());
        }
        for (int i2 = 0; i2 < this.p.size(); i2++) {
            codedOutputStream.d0(5, this.p.get(i2));
        }
        if (R().size() > 0) {
            codedOutputStream.o0(50);
            codedOutputStream.o0(this.r);
        }
        for (int i3 = 0; i3 < this.q.size(); i3++) {
            codedOutputStream.b0(this.q.get(i3).intValue());
        }
        y.a(1000, codedOutputStream);
        codedOutputStream.i0(this.f24103j);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.p
    public final boolean isInitialized() {
        byte b2 = this.s;
        if (b2 == 1) {
            return true;
        }
        if (b2 == 0) {
            return false;
        }
        if (!U()) {
            this.s = (byte) 0;
            return false;
        }
        if (!V()) {
            this.s = (byte) 0;
            return false;
        }
        for (int i2 = 0; i2 < Q(); i2++) {
            if (!P(i2).isInitialized()) {
                this.s = (byte) 0;
                return false;
            }
        }
        if (!s()) {
            this.s = (byte) 0;
            return false;
        }
        this.s = (byte) 1;
        return true;
    }

    private s(h.c<s, ?> cVar) {
        super(cVar);
        this.r = -1;
        this.s = (byte) -1;
        this.t = -1;
        this.f24103j = cVar.l();
    }

    private s(boolean z) {
        this.r = -1;
        this.s = (byte) -1;
        this.t = -1;
        this.f24103j = d.f25399f;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private s(e eVar, f fVar) throws InvalidProtocolBufferException {
        this.r = -1;
        this.s = (byte) -1;
        this.t = -1;
        Z();
        d.b w = d.w();
        CodedOutputStream J = CodedOutputStream.J(w, 1);
        boolean z = false;
        int i2 = 0;
        while (!z) {
            try {
                try {
                    try {
                        int K = eVar.K();
                        if (K != 0) {
                            if (K == 8) {
                                this.f24104k |= 1;
                                this.l = eVar.s();
                            } else if (K == 16) {
                                this.f24104k |= 2;
                                this.m = eVar.s();
                            } else if (K == 24) {
                                this.f24104k |= 4;
                                this.n = eVar.k();
                            } else if (K == 32) {
                                int n = eVar.n();
                                c g2 = c.g(n);
                                if (g2 == null) {
                                    J.o0(K);
                                    J.o0(n);
                                } else {
                                    this.f24104k |= 8;
                                    this.o = g2;
                                }
                            } else if (K == 42) {
                                if ((i2 & 16) != 16) {
                                    this.p = new ArrayList();
                                    i2 |= 16;
                                }
                                this.p.add(eVar.u(q.f24073i, fVar));
                            } else if (K == 48) {
                                if ((i2 & 32) != 32) {
                                    this.q = new ArrayList();
                                    i2 |= 32;
                                }
                                this.q.add(Integer.valueOf(eVar.s()));
                            } else if (K != 50) {
                                if (!p(eVar, J, fVar, K)) {
                                }
                            } else {
                                int j2 = eVar.j(eVar.A());
                                if ((i2 & 32) != 32 && eVar.e() > 0) {
                                    this.q = new ArrayList();
                                    i2 |= 32;
                                }
                                while (eVar.e() > 0) {
                                    this.q.add(Integer.valueOf(eVar.s()));
                                }
                                eVar.i(j2);
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
                if ((i2 & 16) == 16) {
                    this.p = Collections.unmodifiableList(this.p);
                }
                if ((i2 & 32) == 32) {
                    this.q = Collections.unmodifiableList(this.q);
                }
                try {
                    J.I();
                } catch (IOException unused) {
                } catch (Throwable th2) {
                    this.f24103j = w.e();
                    throw th2;
                }
                this.f24103j = w.e();
                m();
                throw th;
            }
        }
        if ((i2 & 16) == 16) {
            this.p = Collections.unmodifiableList(this.p);
        }
        if ((i2 & 32) == 32) {
            this.q = Collections.unmodifiableList(this.q);
        }
        try {
            J.I();
        } catch (IOException unused2) {
        } catch (Throwable th3) {
            this.f24103j = w.e();
            throw th3;
        }
        this.f24103j = w.e();
        m();
    }
}
