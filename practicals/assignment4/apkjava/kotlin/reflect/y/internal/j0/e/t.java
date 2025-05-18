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
public final class t extends h implements p {

    /* renamed from: g, reason: collision with root package name */
    private static final t f24114g;

    /* renamed from: h, reason: collision with root package name */
    public static q<t> f24115h = new a();

    /* renamed from: i, reason: collision with root package name */
    private final d f24116i;

    /* renamed from: j, reason: collision with root package name */
    private int f24117j;

    /* renamed from: k, reason: collision with root package name */
    private List<q> f24118k;
    private int l;
    private byte m;
    private int n;

    /* compiled from: ProtoBuf.java */
    /* loaded from: classes3.dex */
    static class a extends kotlin.reflect.jvm.internal.impl.protobuf.b<t> {
        a() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.q
        /* renamed from: m, reason: merged with bridge method [inline-methods] */
        public t b(e eVar, f fVar) throws InvalidProtocolBufferException {
            return new t(eVar, fVar);
        }
    }

    /* compiled from: ProtoBuf.java */
    /* loaded from: classes3.dex */
    public static final class b extends h.b<t, b> implements p {

        /* renamed from: g, reason: collision with root package name */
        private int f24119g;

        /* renamed from: h, reason: collision with root package name */
        private List<q> f24120h = Collections.emptyList();

        /* renamed from: i, reason: collision with root package name */
        private int f24121i = -1;

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
            if ((this.f24119g & 1) != 1) {
                this.f24120h = new ArrayList(this.f24120h);
                this.f24119g |= 1;
            }
        }

        private void u() {
        }

        public b A(int i2) {
            this.f24119g |= 2;
            this.f24121i = i2;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.o.a
        /* renamed from: p, reason: merged with bridge method [inline-methods] */
        public t c() {
            t q = q();
            if (q.isInitialized()) {
                return q;
            }
            throw a.AbstractC0413a.j(q);
        }

        public t q() {
            t tVar = new t(this);
            int i2 = this.f24119g;
            if ((i2 & 1) == 1) {
                this.f24120h = Collections.unmodifiableList(this.f24120h);
                this.f24119g &= -2;
            }
            tVar.f24118k = this.f24120h;
            int i3 = (i2 & 2) != 2 ? 0 : 1;
            tVar.l = this.f24121i;
            tVar.f24117j = i3;
            return tVar;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h.b
        /* renamed from: r, reason: merged with bridge method [inline-methods] */
        public b k() {
            return s().m(q());
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h.b
        /* renamed from: v, reason: merged with bridge method [inline-methods] */
        public b m(t tVar) {
            if (tVar == t.w()) {
                return this;
            }
            if (!tVar.f24118k.isEmpty()) {
                if (this.f24120h.isEmpty()) {
                    this.f24120h = tVar.f24118k;
                    this.f24119g &= -2;
                } else {
                    t();
                    this.f24120h.addAll(tVar.f24118k);
                }
            }
            if (tVar.B()) {
                A(tVar.x());
            }
            n(l().f(tVar.f24116i));
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:17:0x001d  */
        @Override // kotlin.reflect.jvm.internal.impl.protobuf.a.AbstractC0413a
        /* renamed from: w, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public b i(e eVar, f fVar) throws IOException {
            t tVar = null;
            try {
                try {
                    t b2 = t.f24115h.b(eVar, fVar);
                    if (b2 != null) {
                        m(b2);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e2) {
                    t tVar2 = (t) e2.a();
                    try {
                        throw e2;
                    } catch (Throwable th) {
                        th = th;
                        tVar = tVar2;
                        if (tVar != null) {
                            m(tVar);
                        }
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                if (tVar != null) {
                }
                throw th;
            }
        }
    }

    static {
        t tVar = new t(true);
        f24114g = tVar;
        tVar.C();
    }

    private void C() {
        this.f24118k = Collections.emptyList();
        this.l = -1;
    }

    public static b D() {
        return b.o();
    }

    public static b E(t tVar) {
        return D().m(tVar);
    }

    public static t w() {
        return f24114g;
    }

    public List<q> A() {
        return this.f24118k;
    }

    public boolean B() {
        return (this.f24117j & 1) == 1;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.o
    /* renamed from: F, reason: merged with bridge method [inline-methods] */
    public b f() {
        return D();
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.o
    /* renamed from: G, reason: merged with bridge method [inline-methods] */
    public b d() {
        return E(this);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.o
    public int e() {
        int i2 = this.n;
        if (i2 != -1) {
            return i2;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < this.f24118k.size(); i4++) {
            i3 += CodedOutputStream.s(1, this.f24118k.get(i4));
        }
        if ((this.f24117j & 1) == 1) {
            i3 += CodedOutputStream.o(2, this.l);
        }
        int size = i3 + this.f24116i.size();
        this.n = size;
        return size;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h, kotlin.reflect.jvm.internal.impl.protobuf.o
    public q<t> g() {
        return f24115h;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.o
    public void h(CodedOutputStream codedOutputStream) throws IOException {
        e();
        for (int i2 = 0; i2 < this.f24118k.size(); i2++) {
            codedOutputStream.d0(1, this.f24118k.get(i2));
        }
        if ((this.f24117j & 1) == 1) {
            codedOutputStream.a0(2, this.l);
        }
        codedOutputStream.i0(this.f24116i);
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
        for (int i2 = 0; i2 < z(); i2++) {
            if (!y(i2).isInitialized()) {
                this.m = (byte) 0;
                return false;
            }
        }
        this.m = (byte) 1;
        return true;
    }

    public int x() {
        return this.l;
    }

    public q y(int i2) {
        return this.f24118k.get(i2);
    }

    public int z() {
        return this.f24118k.size();
    }

    private t(h.b bVar) {
        super(bVar);
        this.m = (byte) -1;
        this.n = -1;
        this.f24116i = bVar.l();
    }

    private t(boolean z) {
        this.m = (byte) -1;
        this.n = -1;
        this.f24116i = d.f25399f;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private t(e eVar, f fVar) throws InvalidProtocolBufferException {
        this.m = (byte) -1;
        this.n = -1;
        C();
        d.b w = d.w();
        CodedOutputStream J = CodedOutputStream.J(w, 1);
        boolean z = false;
        boolean z2 = false;
        while (!z) {
            try {
                try {
                    int K = eVar.K();
                    if (K != 0) {
                        if (K == 10) {
                            if (!(z2 & true)) {
                                this.f24118k = new ArrayList();
                                z2 |= true;
                            }
                            this.f24118k.add(eVar.u(q.f24073i, fVar));
                        } else if (K != 16) {
                            if (!p(eVar, J, fVar, K)) {
                            }
                        } else {
                            this.f24117j |= 1;
                            this.l = eVar.s();
                        }
                    }
                    z = true;
                } catch (Throwable th) {
                    if (z2 & true) {
                        this.f24118k = Collections.unmodifiableList(this.f24118k);
                    }
                    try {
                        J.I();
                    } catch (IOException unused) {
                    } catch (Throwable th2) {
                        this.f24116i = w.e();
                        throw th2;
                    }
                    this.f24116i = w.e();
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
            this.f24118k = Collections.unmodifiableList(this.f24118k);
        }
        try {
            J.I();
        } catch (IOException unused2) {
        } catch (Throwable th3) {
            this.f24116i = w.e();
            throw th3;
        }
        this.f24116i = w.e();
        m();
    }
}
