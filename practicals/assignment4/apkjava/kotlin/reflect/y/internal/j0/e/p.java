package kotlin.reflect.y.internal.j0.e;

import java.io.IOException;
import kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream;
import kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException;
import kotlin.reflect.jvm.internal.impl.protobuf.a;
import kotlin.reflect.jvm.internal.impl.protobuf.d;
import kotlin.reflect.jvm.internal.impl.protobuf.e;
import kotlin.reflect.jvm.internal.impl.protobuf.f;
import kotlin.reflect.jvm.internal.impl.protobuf.h;
import kotlin.reflect.jvm.internal.impl.protobuf.l;
import kotlin.reflect.jvm.internal.impl.protobuf.m;
import kotlin.reflect.jvm.internal.impl.protobuf.q;
import kotlin.reflect.jvm.internal.impl.protobuf.r;

/* compiled from: ProtoBuf.java */
/* loaded from: classes3.dex */
public final class p extends h implements kotlin.reflect.jvm.internal.impl.protobuf.p {

    /* renamed from: g, reason: collision with root package name */
    private static final p f24065g;

    /* renamed from: h, reason: collision with root package name */
    public static q<p> f24066h = new a();

    /* renamed from: i, reason: collision with root package name */
    private final d f24067i;

    /* renamed from: j, reason: collision with root package name */
    private m f24068j;

    /* renamed from: k, reason: collision with root package name */
    private byte f24069k;
    private int l;

    /* compiled from: ProtoBuf.java */
    /* loaded from: classes3.dex */
    static class a extends kotlin.reflect.jvm.internal.impl.protobuf.b<p> {
        a() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.q
        /* renamed from: m, reason: merged with bridge method [inline-methods] */
        public p b(e eVar, f fVar) throws InvalidProtocolBufferException {
            return new p(eVar, fVar);
        }
    }

    /* compiled from: ProtoBuf.java */
    /* loaded from: classes3.dex */
    public static final class b extends h.b<p, b> implements kotlin.reflect.jvm.internal.impl.protobuf.p {

        /* renamed from: g, reason: collision with root package name */
        private int f24070g;

        /* renamed from: h, reason: collision with root package name */
        private m f24071h = l.f25446f;

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
            if ((this.f24070g & 1) != 1) {
                this.f24071h = new l(this.f24071h);
                this.f24070g |= 1;
            }
        }

        private void u() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.o.a
        /* renamed from: p, reason: merged with bridge method [inline-methods] */
        public p c() {
            p q = q();
            if (q.isInitialized()) {
                return q;
            }
            throw a.AbstractC0413a.j(q);
        }

        public p q() {
            p pVar = new p(this);
            if ((this.f24070g & 1) == 1) {
                this.f24071h = this.f24071h.k();
                this.f24070g &= -2;
            }
            pVar.f24068j = this.f24071h;
            return pVar;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h.b
        /* renamed from: r, reason: merged with bridge method [inline-methods] */
        public b k() {
            return s().m(q());
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h.b
        /* renamed from: v, reason: merged with bridge method [inline-methods] */
        public b m(p pVar) {
            if (pVar == p.u()) {
                return this;
            }
            if (!pVar.f24068j.isEmpty()) {
                if (this.f24071h.isEmpty()) {
                    this.f24071h = pVar.f24068j;
                    this.f24070g &= -2;
                } else {
                    t();
                    this.f24071h.addAll(pVar.f24068j);
                }
            }
            n(l().f(pVar.f24067i));
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:17:0x001d  */
        @Override // kotlin.reflect.jvm.internal.impl.protobuf.a.AbstractC0413a
        /* renamed from: w, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public b i(e eVar, f fVar) throws IOException {
            p pVar = null;
            try {
                try {
                    p b2 = p.f24066h.b(eVar, fVar);
                    if (b2 != null) {
                        m(b2);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e2) {
                    p pVar2 = (p) e2.a();
                    try {
                        throw e2;
                    } catch (Throwable th) {
                        th = th;
                        pVar = pVar2;
                        if (pVar != null) {
                            m(pVar);
                        }
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                if (pVar != null) {
                }
                throw th;
            }
        }
    }

    static {
        p pVar = new p(true);
        f24065g = pVar;
        pVar.x();
    }

    public static p u() {
        return f24065g;
    }

    private void x() {
        this.f24068j = l.f25446f;
    }

    public static b y() {
        return b.o();
    }

    public static b z(p pVar) {
        return y().m(pVar);
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
        for (int i4 = 0; i4 < this.f24068j.size(); i4++) {
            i3 += CodedOutputStream.e(this.f24068j.N0(i4));
        }
        int size = 0 + i3 + (w().size() * 1) + this.f24067i.size();
        this.l = size;
        return size;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h, kotlin.reflect.jvm.internal.impl.protobuf.o
    public q<p> g() {
        return f24066h;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.o
    public void h(CodedOutputStream codedOutputStream) throws IOException {
        e();
        for (int i2 = 0; i2 < this.f24068j.size(); i2++) {
            codedOutputStream.O(1, this.f24068j.N0(i2));
        }
        codedOutputStream.i0(this.f24067i);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.p
    public final boolean isInitialized() {
        byte b2 = this.f24069k;
        if (b2 == 1) {
            return true;
        }
        if (b2 == 0) {
            return false;
        }
        this.f24069k = (byte) 1;
        return true;
    }

    public String v(int i2) {
        return this.f24068j.get(i2);
    }

    public r w() {
        return this.f24068j;
    }

    private p(h.b bVar) {
        super(bVar);
        this.f24069k = (byte) -1;
        this.l = -1;
        this.f24067i = bVar.l();
    }

    private p(boolean z) {
        this.f24069k = (byte) -1;
        this.l = -1;
        this.f24067i = d.f25399f;
    }

    private p(e eVar, f fVar) throws InvalidProtocolBufferException {
        this.f24069k = (byte) -1;
        this.l = -1;
        x();
        d.b w = d.w();
        CodedOutputStream J = CodedOutputStream.J(w, 1);
        boolean z = false;
        boolean z2 = false;
        while (!z) {
            try {
                try {
                    try {
                        int K = eVar.K();
                        if (K != 0) {
                            if (K != 10) {
                                if (!p(eVar, J, fVar, K)) {
                                }
                            } else {
                                d l = eVar.l();
                                if (!(z2 & true)) {
                                    this.f24068j = new l();
                                    z2 |= true;
                                }
                                this.f24068j.h1(l);
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
                if (z2 & true) {
                    this.f24068j = this.f24068j.k();
                }
                try {
                    J.I();
                } catch (IOException unused) {
                } catch (Throwable th2) {
                    this.f24067i = w.e();
                    throw th2;
                }
                this.f24067i = w.e();
                m();
                throw th;
            }
        }
        if (z2 & true) {
            this.f24068j = this.f24068j.k();
        }
        try {
            J.I();
        } catch (IOException unused2) {
        } catch (Throwable th3) {
            this.f24067i = w.e();
            throw th3;
        }
        this.f24067i = w.e();
        m();
    }
}
