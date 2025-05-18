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
import kotlin.reflect.jvm.internal.impl.protobuf.p;
import kotlin.reflect.jvm.internal.impl.protobuf.q;

/* compiled from: ProtoBuf.java */
/* loaded from: classes3.dex */
public final class d extends h.d<d> implements p {

    /* renamed from: h, reason: collision with root package name */
    private static final d f23945h;

    /* renamed from: i, reason: collision with root package name */
    public static q<d> f23946i = new a();

    /* renamed from: j, reason: collision with root package name */
    private final kotlin.reflect.jvm.internal.impl.protobuf.d f23947j;

    /* renamed from: k, reason: collision with root package name */
    private int f23948k;
    private int l;
    private List<u> m;
    private List<Integer> n;
    private byte o;
    private int p;

    /* compiled from: ProtoBuf.java */
    /* loaded from: classes3.dex */
    static class a extends kotlin.reflect.jvm.internal.impl.protobuf.b<d> {
        a() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.q
        /* renamed from: m, reason: merged with bridge method [inline-methods] */
        public d b(e eVar, f fVar) throws InvalidProtocolBufferException {
            return new d(eVar, fVar);
        }
    }

    /* compiled from: ProtoBuf.java */
    /* loaded from: classes3.dex */
    public static final class b extends h.c<d, b> implements p {

        /* renamed from: i, reason: collision with root package name */
        private int f23949i;

        /* renamed from: j, reason: collision with root package name */
        private int f23950j = 6;

        /* renamed from: k, reason: collision with root package name */
        private List<u> f23951k = Collections.emptyList();
        private List<Integer> l = Collections.emptyList();

        private b() {
            C();
        }

        private void A() {
            if ((this.f23949i & 2) != 2) {
                this.f23951k = new ArrayList(this.f23951k);
                this.f23949i |= 2;
            }
        }

        private void B() {
            if ((this.f23949i & 4) != 4) {
                this.l = new ArrayList(this.l);
                this.f23949i |= 4;
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
        public b m(d dVar) {
            if (dVar == d.H()) {
                return this;
            }
            if (dVar.O()) {
                F(dVar.J());
            }
            if (!dVar.m.isEmpty()) {
                if (this.f23951k.isEmpty()) {
                    this.f23951k = dVar.m;
                    this.f23949i &= -3;
                } else {
                    A();
                    this.f23951k.addAll(dVar.m);
                }
            }
            if (!dVar.n.isEmpty()) {
                if (this.l.isEmpty()) {
                    this.l = dVar.n;
                    this.f23949i &= -5;
                } else {
                    B();
                    this.l.addAll(dVar.n);
                }
            }
            r(dVar);
            n(l().f(dVar.f23947j));
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:17:0x001d  */
        @Override // kotlin.reflect.jvm.internal.impl.protobuf.a.AbstractC0413a
        /* renamed from: E, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public b i(e eVar, f fVar) throws IOException {
            d dVar = null;
            try {
                try {
                    d b2 = d.f23946i.b(eVar, fVar);
                    if (b2 != null) {
                        m(b2);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e2) {
                    d dVar2 = (d) e2.a();
                    try {
                        throw e2;
                    } catch (Throwable th) {
                        th = th;
                        dVar = dVar2;
                        if (dVar != null) {
                            m(dVar);
                        }
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                if (dVar != null) {
                }
                throw th;
            }
        }

        public b F(int i2) {
            this.f23949i |= 1;
            this.f23950j = i2;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.o.a
        /* renamed from: t, reason: merged with bridge method [inline-methods] */
        public d c() {
            d u = u();
            if (u.isInitialized()) {
                return u;
            }
            throw a.AbstractC0413a.j(u);
        }

        public d u() {
            d dVar = new d(this);
            int i2 = (this.f23949i & 1) != 1 ? 0 : 1;
            dVar.l = this.f23950j;
            if ((this.f23949i & 2) == 2) {
                this.f23951k = Collections.unmodifiableList(this.f23951k);
                this.f23949i &= -3;
            }
            dVar.m = this.f23951k;
            if ((this.f23949i & 4) == 4) {
                this.l = Collections.unmodifiableList(this.l);
                this.f23949i &= -5;
            }
            dVar.n = this.l;
            dVar.f23948k = i2;
            return dVar;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h.b
        /* renamed from: v, reason: merged with bridge method [inline-methods] */
        public b k() {
            return w().m(u());
        }
    }

    static {
        d dVar = new d(true);
        f23945h = dVar;
        dVar.P();
    }

    public static d H() {
        return f23945h;
    }

    private void P() {
        this.l = 6;
        this.m = Collections.emptyList();
        this.n = Collections.emptyList();
    }

    public static b Q() {
        return b.s();
    }

    public static b R(d dVar) {
        return Q().m(dVar);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.p
    /* renamed from: I, reason: merged with bridge method [inline-methods] */
    public d b() {
        return f23945h;
    }

    public int J() {
        return this.l;
    }

    public u K(int i2) {
        return this.m.get(i2);
    }

    public int L() {
        return this.m.size();
    }

    public List<u> M() {
        return this.m;
    }

    public List<Integer> N() {
        return this.n;
    }

    public boolean O() {
        return (this.f23948k & 1) == 1;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.o
    /* renamed from: S, reason: merged with bridge method [inline-methods] */
    public b f() {
        return Q();
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.o
    /* renamed from: T, reason: merged with bridge method [inline-methods] */
    public b d() {
        return R(this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.o
    public int e() {
        int i2 = this.p;
        if (i2 != -1) {
            return i2;
        }
        int o = (this.f23948k & 1) == 1 ? CodedOutputStream.o(1, this.l) + 0 : 0;
        for (int i3 = 0; i3 < this.m.size(); i3++) {
            o += CodedOutputStream.s(2, this.m.get(i3));
        }
        int i4 = 0;
        for (int i5 = 0; i5 < this.n.size(); i5++) {
            i4 += CodedOutputStream.p(this.n.get(i5).intValue());
        }
        int size = o + i4 + (N().size() * 2) + t() + this.f23947j.size();
        this.p = size;
        return size;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h, kotlin.reflect.jvm.internal.impl.protobuf.o
    public q<d> g() {
        return f23946i;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.o
    public void h(CodedOutputStream codedOutputStream) throws IOException {
        e();
        h.d<MessageType>.a y = y();
        if ((this.f23948k & 1) == 1) {
            codedOutputStream.a0(1, this.l);
        }
        for (int i2 = 0; i2 < this.m.size(); i2++) {
            codedOutputStream.d0(2, this.m.get(i2));
        }
        for (int i3 = 0; i3 < this.n.size(); i3++) {
            codedOutputStream.a0(31, this.n.get(i3).intValue());
        }
        y.a(19000, codedOutputStream);
        codedOutputStream.i0(this.f23947j);
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
        for (int i2 = 0; i2 < L(); i2++) {
            if (!K(i2).isInitialized()) {
                this.o = (byte) 0;
                return false;
            }
        }
        if (!s()) {
            this.o = (byte) 0;
            return false;
        }
        this.o = (byte) 1;
        return true;
    }

    private d(h.c<d, ?> cVar) {
        super(cVar);
        this.o = (byte) -1;
        this.p = -1;
        this.f23947j = cVar.l();
    }

    private d(boolean z) {
        this.o = (byte) -1;
        this.p = -1;
        this.f23947j = kotlin.reflect.jvm.internal.impl.protobuf.d.f25399f;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private d(e eVar, f fVar) throws InvalidProtocolBufferException {
        this.o = (byte) -1;
        this.p = -1;
        P();
        d.b w = kotlin.reflect.jvm.internal.impl.protobuf.d.w();
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
                                this.f23948k |= 1;
                                this.l = eVar.s();
                            } else if (K == 18) {
                                if ((i2 & 2) != 2) {
                                    this.m = new ArrayList();
                                    i2 |= 2;
                                }
                                this.m.add(eVar.u(u.f24123i, fVar));
                            } else if (K == 248) {
                                if ((i2 & 4) != 4) {
                                    this.n = new ArrayList();
                                    i2 |= 4;
                                }
                                this.n.add(Integer.valueOf(eVar.s()));
                            } else if (K != 250) {
                                if (!p(eVar, J, fVar, K)) {
                                }
                            } else {
                                int j2 = eVar.j(eVar.A());
                                if ((i2 & 4) != 4 && eVar.e() > 0) {
                                    this.n = new ArrayList();
                                    i2 |= 4;
                                }
                                while (eVar.e() > 0) {
                                    this.n.add(Integer.valueOf(eVar.s()));
                                }
                                eVar.i(j2);
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
                if ((i2 & 2) == 2) {
                    this.m = Collections.unmodifiableList(this.m);
                }
                if ((i2 & 4) == 4) {
                    this.n = Collections.unmodifiableList(this.n);
                }
                try {
                    J.I();
                } catch (IOException unused) {
                } catch (Throwable th2) {
                    this.f23947j = w.e();
                    throw th2;
                }
                this.f23947j = w.e();
                m();
                throw th;
            }
        }
        if ((i2 & 2) == 2) {
            this.m = Collections.unmodifiableList(this.m);
        }
        if ((i2 & 4) == 4) {
            this.n = Collections.unmodifiableList(this.n);
        }
        try {
            J.I();
        } catch (IOException unused2) {
        } catch (Throwable th3) {
            this.f23947j = w.e();
            throw th3;
        }
        this.f23947j = w.e();
        m();
    }
}
