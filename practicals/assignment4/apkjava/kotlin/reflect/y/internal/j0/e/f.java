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
import kotlin.reflect.jvm.internal.impl.protobuf.h;
import kotlin.reflect.jvm.internal.impl.protobuf.i;
import kotlin.reflect.jvm.internal.impl.protobuf.p;
import kotlin.reflect.jvm.internal.impl.protobuf.q;
import kotlin.reflect.y.internal.j0.e.h;

/* compiled from: ProtoBuf.java */
/* loaded from: classes3.dex */
public final class f extends h implements p {

    /* renamed from: g, reason: collision with root package name */
    private static final f f23959g;

    /* renamed from: h, reason: collision with root package name */
    public static q<f> f23960h = new a();

    /* renamed from: i, reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.protobuf.d f23961i;

    /* renamed from: j, reason: collision with root package name */
    private int f23962j;

    /* renamed from: k, reason: collision with root package name */
    private c f23963k;
    private List<h> l;
    private h m;
    private d n;
    private byte o;
    private int p;

    /* compiled from: ProtoBuf.java */
    /* loaded from: classes3.dex */
    static class a extends kotlin.reflect.jvm.internal.impl.protobuf.b<f> {
        a() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.q
        /* renamed from: m, reason: merged with bridge method [inline-methods] */
        public f b(e eVar, kotlin.reflect.jvm.internal.impl.protobuf.f fVar) throws InvalidProtocolBufferException {
            return new f(eVar, fVar);
        }
    }

    /* compiled from: ProtoBuf.java */
    /* loaded from: classes3.dex */
    public static final class b extends h.b<f, b> implements p {

        /* renamed from: g, reason: collision with root package name */
        private int f23964g;

        /* renamed from: h, reason: collision with root package name */
        private c f23965h = c.RETURNS_CONSTANT;

        /* renamed from: i, reason: collision with root package name */
        private List<h> f23966i = Collections.emptyList();

        /* renamed from: j, reason: collision with root package name */
        private h f23967j = h.F();

        /* renamed from: k, reason: collision with root package name */
        private d f23968k = d.AT_MOST_ONCE;

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
            if ((this.f23964g & 2) != 2) {
                this.f23966i = new ArrayList(this.f23966i);
                this.f23964g |= 2;
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
        public b i(e eVar, kotlin.reflect.jvm.internal.impl.protobuf.f fVar) throws IOException {
            f fVar2 = null;
            try {
                try {
                    f b2 = f.f23960h.b(eVar, fVar);
                    if (b2 != null) {
                        m(b2);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e2) {
                    f fVar3 = (f) e2.a();
                    try {
                        throw e2;
                    } catch (Throwable th) {
                        th = th;
                        fVar2 = fVar3;
                        if (fVar2 != null) {
                            m(fVar2);
                        }
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                if (fVar2 != null) {
                }
                throw th;
            }
        }

        public b B(c cVar) {
            cVar.getClass();
            this.f23964g |= 1;
            this.f23965h = cVar;
            return this;
        }

        public b C(d dVar) {
            dVar.getClass();
            this.f23964g |= 8;
            this.f23968k = dVar;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.o.a
        /* renamed from: p, reason: merged with bridge method [inline-methods] */
        public f c() {
            f q = q();
            if (q.isInitialized()) {
                return q;
            }
            throw a.AbstractC0413a.j(q);
        }

        public f q() {
            f fVar = new f(this);
            int i2 = this.f23964g;
            int i3 = (i2 & 1) != 1 ? 0 : 1;
            fVar.f23963k = this.f23965h;
            if ((this.f23964g & 2) == 2) {
                this.f23966i = Collections.unmodifiableList(this.f23966i);
                this.f23964g &= -3;
            }
            fVar.l = this.f23966i;
            if ((i2 & 4) == 4) {
                i3 |= 2;
            }
            fVar.m = this.f23967j;
            if ((i2 & 8) == 8) {
                i3 |= 4;
            }
            fVar.n = this.f23968k;
            fVar.f23962j = i3;
            return fVar;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h.b
        /* renamed from: r, reason: merged with bridge method [inline-methods] */
        public b k() {
            return s().m(q());
        }

        public b v(h hVar) {
            if ((this.f23964g & 4) == 4 && this.f23967j != h.F()) {
                this.f23967j = h.T(this.f23967j).m(hVar).q();
            } else {
                this.f23967j = hVar;
            }
            this.f23964g |= 4;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h.b
        /* renamed from: w, reason: merged with bridge method [inline-methods] */
        public b m(f fVar) {
            if (fVar == f.z()) {
                return this;
            }
            if (fVar.F()) {
                B(fVar.C());
            }
            if (!fVar.l.isEmpty()) {
                if (this.f23966i.isEmpty()) {
                    this.f23966i = fVar.l;
                    this.f23964g &= -3;
                } else {
                    t();
                    this.f23966i.addAll(fVar.l);
                }
            }
            if (fVar.E()) {
                v(fVar.y());
            }
            if (fVar.G()) {
                C(fVar.D());
            }
            n(l().f(fVar.f23961i));
            return this;
        }
    }

    /* compiled from: ProtoBuf.java */
    /* loaded from: classes3.dex */
    public enum c implements i.a {
        RETURNS_CONSTANT(0, 0),
        CALLS(1, 1),
        RETURNS_NOT_NULL(2, 2);


        /* renamed from: i, reason: collision with root package name */
        private static i.b<c> f23972i = new a();

        /* renamed from: k, reason: collision with root package name */
        private final int f23974k;

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
            this.f23974k = i3;
        }

        public static c g(int i2) {
            if (i2 == 0) {
                return RETURNS_CONSTANT;
            }
            if (i2 == 1) {
                return CALLS;
            }
            if (i2 != 2) {
                return null;
            }
            return RETURNS_NOT_NULL;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.i.a
        public final int f() {
            return this.f23974k;
        }
    }

    /* compiled from: ProtoBuf.java */
    /* loaded from: classes3.dex */
    public enum d implements i.a {
        AT_MOST_ONCE(0, 0),
        EXACTLY_ONCE(1, 1),
        AT_LEAST_ONCE(2, 2);


        /* renamed from: i, reason: collision with root package name */
        private static i.b<d> f23978i = new a();

        /* renamed from: k, reason: collision with root package name */
        private final int f23980k;

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
            this.f23980k = i3;
        }

        public static d g(int i2) {
            if (i2 == 0) {
                return AT_MOST_ONCE;
            }
            if (i2 == 1) {
                return EXACTLY_ONCE;
            }
            if (i2 != 2) {
                return null;
            }
            return AT_LEAST_ONCE;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.i.a
        public final int f() {
            return this.f23980k;
        }
    }

    static {
        f fVar = new f(true);
        f23959g = fVar;
        fVar.H();
    }

    private void H() {
        this.f23963k = c.RETURNS_CONSTANT;
        this.l = Collections.emptyList();
        this.m = h.F();
        this.n = d.AT_MOST_ONCE;
    }

    public static b I() {
        return b.o();
    }

    public static b J(f fVar) {
        return I().m(fVar);
    }

    public static f z() {
        return f23959g;
    }

    public h A(int i2) {
        return this.l.get(i2);
    }

    public int B() {
        return this.l.size();
    }

    public c C() {
        return this.f23963k;
    }

    public d D() {
        return this.n;
    }

    public boolean E() {
        return (this.f23962j & 2) == 2;
    }

    public boolean F() {
        return (this.f23962j & 1) == 1;
    }

    public boolean G() {
        return (this.f23962j & 4) == 4;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.o
    /* renamed from: K, reason: merged with bridge method [inline-methods] */
    public b f() {
        return I();
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.o
    /* renamed from: L, reason: merged with bridge method [inline-methods] */
    public b d() {
        return J(this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.o
    public int e() {
        int i2 = this.p;
        if (i2 != -1) {
            return i2;
        }
        int h2 = (this.f23962j & 1) == 1 ? CodedOutputStream.h(1, this.f23963k.f()) + 0 : 0;
        for (int i3 = 0; i3 < this.l.size(); i3++) {
            h2 += CodedOutputStream.s(2, this.l.get(i3));
        }
        if ((this.f23962j & 2) == 2) {
            h2 += CodedOutputStream.s(3, this.m);
        }
        if ((this.f23962j & 4) == 4) {
            h2 += CodedOutputStream.h(4, this.n.f());
        }
        int size = h2 + this.f23961i.size();
        this.p = size;
        return size;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h, kotlin.reflect.jvm.internal.impl.protobuf.o
    public q<f> g() {
        return f23960h;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.o
    public void h(CodedOutputStream codedOutputStream) throws IOException {
        e();
        if ((this.f23962j & 1) == 1) {
            codedOutputStream.S(1, this.f23963k.f());
        }
        for (int i2 = 0; i2 < this.l.size(); i2++) {
            codedOutputStream.d0(2, this.l.get(i2));
        }
        if ((this.f23962j & 2) == 2) {
            codedOutputStream.d0(3, this.m);
        }
        if ((this.f23962j & 4) == 4) {
            codedOutputStream.S(4, this.n.f());
        }
        codedOutputStream.i0(this.f23961i);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.p
    public final boolean isInitialized() {
        byte b2 = this.o;
        if (b2 == 1) {
            return true;
        }
        if (b2 == 0) {
            return false;
        }
        for (int i2 = 0; i2 < B(); i2++) {
            if (!A(i2).isInitialized()) {
                this.o = (byte) 0;
                return false;
            }
        }
        if (E() && !y().isInitialized()) {
            this.o = (byte) 0;
            return false;
        }
        this.o = (byte) 1;
        return true;
    }

    public h y() {
        return this.m;
    }

    private f(h.b bVar) {
        super(bVar);
        this.o = (byte) -1;
        this.p = -1;
        this.f23961i = bVar.l();
    }

    private f(boolean z) {
        this.o = (byte) -1;
        this.p = -1;
        this.f23961i = kotlin.reflect.jvm.internal.impl.protobuf.d.f25399f;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private f(e eVar, kotlin.reflect.jvm.internal.impl.protobuf.f fVar) throws InvalidProtocolBufferException {
        this.o = (byte) -1;
        this.p = -1;
        H();
        d.b w = kotlin.reflect.jvm.internal.impl.protobuf.d.w();
        CodedOutputStream J = CodedOutputStream.J(w, 1);
        boolean z = false;
        int i2 = 0;
        while (!z) {
            try {
                try {
                    int K = eVar.K();
                    if (K != 0) {
                        if (K == 8) {
                            int n = eVar.n();
                            c g2 = c.g(n);
                            if (g2 == null) {
                                J.o0(K);
                                J.o0(n);
                            } else {
                                this.f23962j |= 1;
                                this.f23963k = g2;
                            }
                        } else if (K == 18) {
                            if ((i2 & 2) != 2) {
                                this.l = new ArrayList();
                                i2 |= 2;
                            }
                            this.l.add(eVar.u(h.f23988h, fVar));
                        } else if (K == 26) {
                            h.b d2 = (this.f23962j & 2) == 2 ? this.m.d() : null;
                            h hVar = (h) eVar.u(h.f23988h, fVar);
                            this.m = hVar;
                            if (d2 != null) {
                                d2.m(hVar);
                                this.m = d2.q();
                            }
                            this.f23962j |= 2;
                        } else if (K != 32) {
                            if (!p(eVar, J, fVar, K)) {
                            }
                        } else {
                            int n2 = eVar.n();
                            d g3 = d.g(n2);
                            if (g3 == null) {
                                J.o0(K);
                                J.o0(n2);
                            } else {
                                this.f23962j |= 4;
                                this.n = g3;
                            }
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
                        this.f23961i = w.e();
                        throw th2;
                    }
                    this.f23961i = w.e();
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
            this.f23961i = w.e();
            throw th3;
        }
        this.f23961i = w.e();
        m();
    }
}
