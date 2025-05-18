package kotlin.reflect.y.internal.j0.e;

import java.io.IOException;
import java.io.InputStream;
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
import kotlin.reflect.jvm.internal.impl.protobuf.p;
import kotlin.reflect.jvm.internal.impl.protobuf.q;
import kotlin.reflect.y.internal.j0.e.l;
import kotlin.reflect.y.internal.j0.e.o;
import kotlin.reflect.y.internal.j0.e.p;

/* compiled from: ProtoBuf.java */
/* loaded from: classes3.dex */
public final class m extends h.d<m> implements p {

    /* renamed from: h, reason: collision with root package name */
    private static final m f24029h;

    /* renamed from: i, reason: collision with root package name */
    public static q<m> f24030i = new a();

    /* renamed from: j, reason: collision with root package name */
    private final d f24031j;

    /* renamed from: k, reason: collision with root package name */
    private int f24032k;
    private p l;
    private o m;
    private l n;
    private List<c> o;
    private byte p;
    private int q;

    /* compiled from: ProtoBuf.java */
    /* loaded from: classes3.dex */
    static class a extends kotlin.reflect.jvm.internal.impl.protobuf.b<m> {
        a() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.q
        /* renamed from: m, reason: merged with bridge method [inline-methods] */
        public m b(e eVar, f fVar) throws InvalidProtocolBufferException {
            return new m(eVar, fVar);
        }
    }

    /* compiled from: ProtoBuf.java */
    /* loaded from: classes3.dex */
    public static final class b extends h.c<m, b> implements p {

        /* renamed from: i, reason: collision with root package name */
        private int f24033i;

        /* renamed from: j, reason: collision with root package name */
        private p f24034j = p.u();

        /* renamed from: k, reason: collision with root package name */
        private o f24035k = o.u();
        private l l = l.K();
        private List<c> m = Collections.emptyList();

        private b() {
            B();
        }

        private void A() {
            if ((this.f24033i & 8) != 8) {
                this.m = new ArrayList(this.m);
                this.f24033i |= 8;
            }
        }

        private void B() {
        }

        static /* synthetic */ b s() {
            return w();
        }

        private static b w() {
            return new b();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h.b
        /* renamed from: C, reason: merged with bridge method [inline-methods] */
        public b m(m mVar) {
            if (mVar == m.K()) {
                return this;
            }
            if (mVar.R()) {
                G(mVar.O());
            }
            if (mVar.Q()) {
                F(mVar.N());
            }
            if (mVar.P()) {
                E(mVar.M());
            }
            if (!mVar.o.isEmpty()) {
                if (this.m.isEmpty()) {
                    this.m = mVar.o;
                    this.f24033i &= -9;
                } else {
                    A();
                    this.m.addAll(mVar.o);
                }
            }
            r(mVar);
            n(l().f(mVar.f24031j));
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:17:0x001d  */
        @Override // kotlin.reflect.jvm.internal.impl.protobuf.a.AbstractC0413a
        /* renamed from: D, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public b i(e eVar, f fVar) throws IOException {
            m mVar = null;
            try {
                try {
                    m b2 = m.f24030i.b(eVar, fVar);
                    if (b2 != null) {
                        m(b2);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e2) {
                    m mVar2 = (m) e2.a();
                    try {
                        throw e2;
                    } catch (Throwable th) {
                        th = th;
                        mVar = mVar2;
                        if (mVar != null) {
                            m(mVar);
                        }
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                if (mVar != null) {
                }
                throw th;
            }
        }

        public b E(l lVar) {
            if ((this.f24033i & 4) == 4 && this.l != l.K()) {
                this.l = l.c0(this.l).m(lVar).u();
            } else {
                this.l = lVar;
            }
            this.f24033i |= 4;
            return this;
        }

        public b F(o oVar) {
            if ((this.f24033i & 2) == 2 && this.f24035k != o.u()) {
                this.f24035k = o.z(this.f24035k).m(oVar).q();
            } else {
                this.f24035k = oVar;
            }
            this.f24033i |= 2;
            return this;
        }

        public b G(p pVar) {
            if ((this.f24033i & 1) == 1 && this.f24034j != p.u()) {
                this.f24034j = p.z(this.f24034j).m(pVar).q();
            } else {
                this.f24034j = pVar;
            }
            this.f24033i |= 1;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.o.a
        /* renamed from: t, reason: merged with bridge method [inline-methods] */
        public m c() {
            m u = u();
            if (u.isInitialized()) {
                return u;
            }
            throw a.AbstractC0413a.j(u);
        }

        public m u() {
            m mVar = new m(this);
            int i2 = this.f24033i;
            int i3 = (i2 & 1) != 1 ? 0 : 1;
            mVar.l = this.f24034j;
            if ((i2 & 2) == 2) {
                i3 |= 2;
            }
            mVar.m = this.f24035k;
            if ((i2 & 4) == 4) {
                i3 |= 4;
            }
            mVar.n = this.l;
            if ((this.f24033i & 8) == 8) {
                this.m = Collections.unmodifiableList(this.m);
                this.f24033i &= -9;
            }
            mVar.o = this.m;
            mVar.f24032k = i3;
            return mVar;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h.b
        /* renamed from: v, reason: merged with bridge method [inline-methods] */
        public b k() {
            return w().m(u());
        }
    }

    static {
        m mVar = new m(true);
        f24029h = mVar;
        mVar.S();
    }

    public static m K() {
        return f24029h;
    }

    private void S() {
        this.l = p.u();
        this.m = o.u();
        this.n = l.K();
        this.o = Collections.emptyList();
    }

    public static b T() {
        return b.s();
    }

    public static b U(m mVar) {
        return T().m(mVar);
    }

    public static m X(InputStream inputStream, f fVar) throws IOException {
        return f24030i.a(inputStream, fVar);
    }

    public c H(int i2) {
        return this.o.get(i2);
    }

    public int I() {
        return this.o.size();
    }

    public List<c> J() {
        return this.o;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.p
    /* renamed from: L, reason: merged with bridge method [inline-methods] */
    public m b() {
        return f24029h;
    }

    public l M() {
        return this.n;
    }

    public o N() {
        return this.m;
    }

    public p O() {
        return this.l;
    }

    public boolean P() {
        return (this.f24032k & 4) == 4;
    }

    public boolean Q() {
        return (this.f24032k & 2) == 2;
    }

    public boolean R() {
        return (this.f24032k & 1) == 1;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.o
    /* renamed from: V, reason: merged with bridge method [inline-methods] */
    public b f() {
        return T();
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.o
    /* renamed from: Y, reason: merged with bridge method [inline-methods] */
    public b d() {
        return U(this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.o
    public int e() {
        int i2 = this.q;
        if (i2 != -1) {
            return i2;
        }
        int s = (this.f24032k & 1) == 1 ? CodedOutputStream.s(1, this.l) + 0 : 0;
        if ((this.f24032k & 2) == 2) {
            s += CodedOutputStream.s(2, this.m);
        }
        if ((this.f24032k & 4) == 4) {
            s += CodedOutputStream.s(3, this.n);
        }
        for (int i3 = 0; i3 < this.o.size(); i3++) {
            s += CodedOutputStream.s(4, this.o.get(i3));
        }
        int t = s + t() + this.f24031j.size();
        this.q = t;
        return t;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h, kotlin.reflect.jvm.internal.impl.protobuf.o
    public q<m> g() {
        return f24030i;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.o
    public void h(CodedOutputStream codedOutputStream) throws IOException {
        e();
        h.d<MessageType>.a y = y();
        if ((this.f24032k & 1) == 1) {
            codedOutputStream.d0(1, this.l);
        }
        if ((this.f24032k & 2) == 2) {
            codedOutputStream.d0(2, this.m);
        }
        if ((this.f24032k & 4) == 4) {
            codedOutputStream.d0(3, this.n);
        }
        for (int i2 = 0; i2 < this.o.size(); i2++) {
            codedOutputStream.d0(4, this.o.get(i2));
        }
        y.a(200, codedOutputStream);
        codedOutputStream.i0(this.f24031j);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.p
    public final boolean isInitialized() {
        byte b2 = this.p;
        if (b2 == 1) {
            return true;
        }
        if (b2 == 0) {
            return false;
        }
        if (Q() && !N().isInitialized()) {
            this.p = (byte) 0;
            return false;
        }
        if (P() && !M().isInitialized()) {
            this.p = (byte) 0;
            return false;
        }
        for (int i2 = 0; i2 < I(); i2++) {
            if (!H(i2).isInitialized()) {
                this.p = (byte) 0;
                return false;
            }
        }
        if (!s()) {
            this.p = (byte) 0;
            return false;
        }
        this.p = (byte) 1;
        return true;
    }

    private m(h.c<m, ?> cVar) {
        super(cVar);
        this.p = (byte) -1;
        this.q = -1;
        this.f24031j = cVar.l();
    }

    private m(boolean z) {
        this.p = (byte) -1;
        this.q = -1;
        this.f24031j = d.f25399f;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private m(e eVar, f fVar) throws InvalidProtocolBufferException {
        this.p = (byte) -1;
        this.q = -1;
        S();
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
                            if (K == 10) {
                                p.b d2 = (this.f24032k & 1) == 1 ? this.l.d() : null;
                                p pVar = (p) eVar.u(p.f24066h, fVar);
                                this.l = pVar;
                                if (d2 != null) {
                                    d2.m(pVar);
                                    this.l = d2.q();
                                }
                                this.f24032k |= 1;
                            } else if (K == 18) {
                                o.b d3 = (this.f24032k & 2) == 2 ? this.m.d() : null;
                                o oVar = (o) eVar.u(o.f24044h, fVar);
                                this.m = oVar;
                                if (d3 != null) {
                                    d3.m(oVar);
                                    this.m = d3.q();
                                }
                                this.f24032k |= 2;
                            } else if (K == 26) {
                                l.b d4 = (this.f24032k & 4) == 4 ? this.n.d() : null;
                                l lVar = (l) eVar.u(l.f24023i, fVar);
                                this.n = lVar;
                                if (d4 != null) {
                                    d4.m(lVar);
                                    this.n = d4.u();
                                }
                                this.f24032k |= 4;
                            } else if (K != 34) {
                                if (!p(eVar, J, fVar, K)) {
                                }
                            } else {
                                if ((i2 & 8) != 8) {
                                    this.o = new ArrayList();
                                    i2 |= 8;
                                }
                                this.o.add(eVar.u(c.f23933i, fVar));
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
                if ((i2 & 8) == 8) {
                    this.o = Collections.unmodifiableList(this.o);
                }
                try {
                    J.I();
                } catch (IOException unused) {
                } catch (Throwable th2) {
                    this.f24031j = w.e();
                    throw th2;
                }
                this.f24031j = w.e();
                m();
                throw th;
            }
        }
        if ((i2 & 8) == 8) {
            this.o = Collections.unmodifiableList(this.o);
        }
        try {
            J.I();
        } catch (IOException unused2) {
        } catch (Throwable th3) {
            this.f24031j = w.e();
            throw th3;
        }
        this.f24031j = w.e();
        m();
    }
}
