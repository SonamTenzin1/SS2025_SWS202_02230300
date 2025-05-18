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

/* compiled from: ProtoBuf.java */
/* loaded from: classes3.dex */
public final class g extends h.d<g> implements p {

    /* renamed from: h, reason: collision with root package name */
    private static final g f23981h;

    /* renamed from: i, reason: collision with root package name */
    public static q<g> f23982i = new a();

    /* renamed from: j, reason: collision with root package name */
    private final d f23983j;

    /* renamed from: k, reason: collision with root package name */
    private int f23984k;
    private int l;
    private byte m;
    private int n;

    /* compiled from: ProtoBuf.java */
    /* loaded from: classes3.dex */
    static class a extends kotlin.reflect.jvm.internal.impl.protobuf.b<g> {
        a() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.q
        /* renamed from: m, reason: merged with bridge method [inline-methods] */
        public g b(e eVar, f fVar) throws InvalidProtocolBufferException {
            return new g(eVar, fVar);
        }
    }

    /* compiled from: ProtoBuf.java */
    /* loaded from: classes3.dex */
    public static final class b extends h.c<g, b> implements p {

        /* renamed from: i, reason: collision with root package name */
        private int f23985i;

        /* renamed from: j, reason: collision with root package name */
        private int f23986j;

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
        public b m(g gVar) {
            if (gVar == g.D()) {
                return this;
            }
            if (gVar.G()) {
                D(gVar.F());
            }
            r(gVar);
            n(l().f(gVar.f23983j));
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:17:0x001d  */
        @Override // kotlin.reflect.jvm.internal.impl.protobuf.a.AbstractC0413a
        /* renamed from: C, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public b i(e eVar, f fVar) throws IOException {
            g gVar = null;
            try {
                try {
                    g b2 = g.f23982i.b(eVar, fVar);
                    if (b2 != null) {
                        m(b2);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e2) {
                    g gVar2 = (g) e2.a();
                    try {
                        throw e2;
                    } catch (Throwable th) {
                        th = th;
                        gVar = gVar2;
                        if (gVar != null) {
                            m(gVar);
                        }
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                if (gVar != null) {
                }
                throw th;
            }
        }

        public b D(int i2) {
            this.f23985i |= 1;
            this.f23986j = i2;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.o.a
        /* renamed from: t, reason: merged with bridge method [inline-methods] */
        public g c() {
            g u = u();
            if (u.isInitialized()) {
                return u;
            }
            throw a.AbstractC0413a.j(u);
        }

        public g u() {
            g gVar = new g(this);
            int i2 = (this.f23985i & 1) != 1 ? 0 : 1;
            gVar.l = this.f23986j;
            gVar.f23984k = i2;
            return gVar;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h.b
        /* renamed from: v, reason: merged with bridge method [inline-methods] */
        public b k() {
            return w().m(u());
        }
    }

    static {
        g gVar = new g(true);
        f23981h = gVar;
        gVar.H();
    }

    public static g D() {
        return f23981h;
    }

    private void H() {
        this.l = 0;
    }

    public static b I() {
        return b.s();
    }

    public static b J(g gVar) {
        return I().m(gVar);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.p
    /* renamed from: E, reason: merged with bridge method [inline-methods] */
    public g b() {
        return f23981h;
    }

    public int F() {
        return this.l;
    }

    public boolean G() {
        return (this.f23984k & 1) == 1;
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
        int i2 = this.n;
        if (i2 != -1) {
            return i2;
        }
        int o = ((this.f23984k & 1) == 1 ? 0 + CodedOutputStream.o(1, this.l) : 0) + t() + this.f23983j.size();
        this.n = o;
        return o;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h, kotlin.reflect.jvm.internal.impl.protobuf.o
    public q<g> g() {
        return f23982i;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.o
    public void h(CodedOutputStream codedOutputStream) throws IOException {
        e();
        h.d<MessageType>.a y = y();
        if ((this.f23984k & 1) == 1) {
            codedOutputStream.a0(1, this.l);
        }
        y.a(200, codedOutputStream);
        codedOutputStream.i0(this.f23983j);
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
        if (!s()) {
            this.m = (byte) 0;
            return false;
        }
        this.m = (byte) 1;
        return true;
    }

    private g(h.c<g, ?> cVar) {
        super(cVar);
        this.m = (byte) -1;
        this.n = -1;
        this.f23983j = cVar.l();
    }

    private g(boolean z) {
        this.m = (byte) -1;
        this.n = -1;
        this.f23983j = d.f25399f;
    }

    private g(e eVar, f fVar) throws InvalidProtocolBufferException {
        this.m = (byte) -1;
        this.n = -1;
        H();
        d.b w = d.w();
        CodedOutputStream J = CodedOutputStream.J(w, 1);
        boolean z = false;
        while (!z) {
            try {
                try {
                    int K = eVar.K();
                    if (K != 0) {
                        if (K != 8) {
                            if (!p(eVar, J, fVar, K)) {
                            }
                        } else {
                            this.f23984k |= 1;
                            this.l = eVar.s();
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
                    this.f23983j = w.e();
                    throw th2;
                }
                this.f23983j = w.e();
                m();
                throw th;
            }
        }
        try {
            J.I();
        } catch (IOException unused2) {
        } catch (Throwable th3) {
            this.f23983j = w.e();
            throw th3;
        }
        this.f23983j = w.e();
        m();
    }
}
