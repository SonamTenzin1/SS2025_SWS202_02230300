package kotlin.reflect.y.internal.j0.e;

import androidx.recyclerview.widget.RecyclerView;
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
import kotlin.reflect.jvm.internal.impl.protobuf.p;
import kotlin.reflect.jvm.internal.impl.protobuf.q;
import kotlin.reflect.y.internal.j0.e.q;
import kotlin.reflect.y.internal.j0.e.u;

/* compiled from: ProtoBuf.java */
/* loaded from: classes3.dex */
public final class n extends h.d<n> implements p {

    /* renamed from: h, reason: collision with root package name */
    private static final n f24036h;

    /* renamed from: i, reason: collision with root package name */
    public static q<n> f24037i = new a();
    private byte A;
    private int B;

    /* renamed from: j, reason: collision with root package name */
    private final d f24038j;

    /* renamed from: k, reason: collision with root package name */
    private int f24039k;
    private int l;
    private int m;
    private int n;
    private q o;
    private int p;
    private List<s> q;
    private q r;
    private int s;
    private List<q> t;
    private List<Integer> u;
    private int v;
    private u w;
    private int x;
    private int y;
    private List<Integer> z;

    /* compiled from: ProtoBuf.java */
    /* loaded from: classes3.dex */
    static class a extends kotlin.reflect.jvm.internal.impl.protobuf.b<n> {
        a() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.q
        /* renamed from: m, reason: merged with bridge method [inline-methods] */
        public n b(e eVar, f fVar) throws InvalidProtocolBufferException {
            return new n(eVar, fVar);
        }
    }

    /* compiled from: ProtoBuf.java */
    /* loaded from: classes3.dex */
    public static final class b extends h.c<n, b> implements p {

        /* renamed from: i, reason: collision with root package name */
        private int f24040i;
        private int l;
        private int n;
        private int q;
        private int u;
        private int v;

        /* renamed from: j, reason: collision with root package name */
        private int f24041j = 518;

        /* renamed from: k, reason: collision with root package name */
        private int f24042k = 2054;
        private q m = q.Y();
        private List<s> o = Collections.emptyList();
        private q p = q.Y();
        private List<q> r = Collections.emptyList();
        private List<Integer> s = Collections.emptyList();
        private u t = u.I();
        private List<Integer> w = Collections.emptyList();

        private b() {
            E();
        }

        private void A() {
            if ((this.f24040i & AdRequest.MAX_CONTENT_URL_LENGTH) != 512) {
                this.s = new ArrayList(this.s);
                this.f24040i |= AdRequest.MAX_CONTENT_URL_LENGTH;
            }
        }

        private void B() {
            if ((this.f24040i & 256) != 256) {
                this.r = new ArrayList(this.r);
                this.f24040i |= 256;
            }
        }

        private void C() {
            if ((this.f24040i & 32) != 32) {
                this.o = new ArrayList(this.o);
                this.f24040i |= 32;
            }
        }

        private void D() {
            if ((this.f24040i & 8192) != 8192) {
                this.w = new ArrayList(this.w);
                this.f24040i |= 8192;
            }
        }

        private void E() {
        }

        static /* synthetic */ b s() {
            return w();
        }

        private static b w() {
            return new b();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h.b
        /* renamed from: F, reason: merged with bridge method [inline-methods] */
        public b m(n nVar) {
            if (nVar == n.Z()) {
                return this;
            }
            if (nVar.p0()) {
                K(nVar.b0());
            }
            if (nVar.s0()) {
                N(nVar.e0());
            }
            if (nVar.r0()) {
                M(nVar.d0());
            }
            if (nVar.v0()) {
                I(nVar.h0());
            }
            if (nVar.w0()) {
                P(nVar.i0());
            }
            if (!nVar.q.isEmpty()) {
                if (this.o.isEmpty()) {
                    this.o = nVar.q;
                    this.f24040i &= -33;
                } else {
                    C();
                    this.o.addAll(nVar.q);
                }
            }
            if (nVar.t0()) {
                H(nVar.f0());
            }
            if (nVar.u0()) {
                O(nVar.g0());
            }
            if (!nVar.t.isEmpty()) {
                if (this.r.isEmpty()) {
                    this.r = nVar.t;
                    this.f24040i &= -257;
                } else {
                    B();
                    this.r.addAll(nVar.t);
                }
            }
            if (!nVar.u.isEmpty()) {
                if (this.s.isEmpty()) {
                    this.s = nVar.u;
                    this.f24040i &= -513;
                } else {
                    A();
                    this.s.addAll(nVar.u);
                }
            }
            if (nVar.y0()) {
                J(nVar.k0());
            }
            if (nVar.q0()) {
                L(nVar.c0());
            }
            if (nVar.x0()) {
                Q(nVar.j0());
            }
            if (!nVar.z.isEmpty()) {
                if (this.w.isEmpty()) {
                    this.w = nVar.z;
                    this.f24040i &= -8193;
                } else {
                    D();
                    this.w.addAll(nVar.z);
                }
            }
            r(nVar);
            n(l().f(nVar.f24038j));
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:17:0x001d  */
        @Override // kotlin.reflect.jvm.internal.impl.protobuf.a.AbstractC0413a
        /* renamed from: G, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public b i(e eVar, f fVar) throws IOException {
            n nVar = null;
            try {
                try {
                    n b2 = n.f24037i.b(eVar, fVar);
                    if (b2 != null) {
                        m(b2);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e2) {
                    n nVar2 = (n) e2.a();
                    try {
                        throw e2;
                    } catch (Throwable th) {
                        th = th;
                        nVar = nVar2;
                        if (nVar != null) {
                            m(nVar);
                        }
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                if (nVar != null) {
                }
                throw th;
            }
        }

        public b H(q qVar) {
            if ((this.f24040i & 64) == 64 && this.p != q.Y()) {
                this.p = q.z0(this.p).m(qVar).u();
            } else {
                this.p = qVar;
            }
            this.f24040i |= 64;
            return this;
        }

        public b I(q qVar) {
            if ((this.f24040i & 8) == 8 && this.m != q.Y()) {
                this.m = q.z0(this.m).m(qVar).u();
            } else {
                this.m = qVar;
            }
            this.f24040i |= 8;
            return this;
        }

        public b J(u uVar) {
            if ((this.f24040i & 1024) == 1024 && this.t != u.I()) {
                this.t = u.Z(this.t).m(uVar).u();
            } else {
                this.t = uVar;
            }
            this.f24040i |= 1024;
            return this;
        }

        public b K(int i2) {
            this.f24040i |= 1;
            this.f24041j = i2;
            return this;
        }

        public b L(int i2) {
            this.f24040i |= RecyclerView.l.FLAG_MOVED;
            this.u = i2;
            return this;
        }

        public b M(int i2) {
            this.f24040i |= 4;
            this.l = i2;
            return this;
        }

        public b N(int i2) {
            this.f24040i |= 2;
            this.f24042k = i2;
            return this;
        }

        public b O(int i2) {
            this.f24040i |= 128;
            this.q = i2;
            return this;
        }

        public b P(int i2) {
            this.f24040i |= 16;
            this.n = i2;
            return this;
        }

        public b Q(int i2) {
            this.f24040i |= RecyclerView.l.FLAG_APPEARED_IN_PRE_LAYOUT;
            this.v = i2;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.o.a
        /* renamed from: t, reason: merged with bridge method [inline-methods] */
        public n c() {
            n u = u();
            if (u.isInitialized()) {
                return u;
            }
            throw a.AbstractC0413a.j(u);
        }

        public n u() {
            n nVar = new n(this);
            int i2 = this.f24040i;
            int i3 = (i2 & 1) != 1 ? 0 : 1;
            nVar.l = this.f24041j;
            if ((i2 & 2) == 2) {
                i3 |= 2;
            }
            nVar.m = this.f24042k;
            if ((i2 & 4) == 4) {
                i3 |= 4;
            }
            nVar.n = this.l;
            if ((i2 & 8) == 8) {
                i3 |= 8;
            }
            nVar.o = this.m;
            if ((i2 & 16) == 16) {
                i3 |= 16;
            }
            nVar.p = this.n;
            if ((this.f24040i & 32) == 32) {
                this.o = Collections.unmodifiableList(this.o);
                this.f24040i &= -33;
            }
            nVar.q = this.o;
            if ((i2 & 64) == 64) {
                i3 |= 32;
            }
            nVar.r = this.p;
            if ((i2 & 128) == 128) {
                i3 |= 64;
            }
            nVar.s = this.q;
            if ((this.f24040i & 256) == 256) {
                this.r = Collections.unmodifiableList(this.r);
                this.f24040i &= -257;
            }
            nVar.t = this.r;
            if ((this.f24040i & AdRequest.MAX_CONTENT_URL_LENGTH) == 512) {
                this.s = Collections.unmodifiableList(this.s);
                this.f24040i &= -513;
            }
            nVar.u = this.s;
            if ((i2 & 1024) == 1024) {
                i3 |= 128;
            }
            nVar.w = this.t;
            if ((i2 & RecyclerView.l.FLAG_MOVED) == 2048) {
                i3 |= 256;
            }
            nVar.x = this.u;
            if ((i2 & RecyclerView.l.FLAG_APPEARED_IN_PRE_LAYOUT) == 4096) {
                i3 |= AdRequest.MAX_CONTENT_URL_LENGTH;
            }
            nVar.y = this.v;
            if ((this.f24040i & 8192) == 8192) {
                this.w = Collections.unmodifiableList(this.w);
                this.f24040i &= -8193;
            }
            nVar.z = this.w;
            nVar.f24039k = i3;
            return nVar;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h.b
        /* renamed from: v, reason: merged with bridge method [inline-methods] */
        public b k() {
            return w().m(u());
        }
    }

    static {
        n nVar = new n(true);
        f24036h = nVar;
        nVar.z0();
    }

    public static b A0() {
        return b.s();
    }

    public static b B0(n nVar) {
        return A0().m(nVar);
    }

    public static n Z() {
        return f24036h;
    }

    private void z0() {
        this.l = 518;
        this.m = 2054;
        this.n = 0;
        this.o = q.Y();
        this.p = 0;
        this.q = Collections.emptyList();
        this.r = q.Y();
        this.s = 0;
        this.t = Collections.emptyList();
        this.u = Collections.emptyList();
        this.w = u.I();
        this.x = 0;
        this.y = 0;
        this.z = Collections.emptyList();
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.o
    /* renamed from: C0, reason: merged with bridge method [inline-methods] */
    public b f() {
        return A0();
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.o
    /* renamed from: D0, reason: merged with bridge method [inline-methods] */
    public b d() {
        return B0(this);
    }

    public q U(int i2) {
        return this.t.get(i2);
    }

    public int V() {
        return this.t.size();
    }

    public List<Integer> X() {
        return this.u;
    }

    public List<q> Y() {
        return this.t;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.p
    /* renamed from: a0, reason: merged with bridge method [inline-methods] */
    public n b() {
        return f24036h;
    }

    public int b0() {
        return this.l;
    }

    public int c0() {
        return this.x;
    }

    public int d0() {
        return this.n;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.o
    public int e() {
        int i2 = this.B;
        if (i2 != -1) {
            return i2;
        }
        int o = (this.f24039k & 2) == 2 ? CodedOutputStream.o(1, this.m) + 0 : 0;
        if ((this.f24039k & 4) == 4) {
            o += CodedOutputStream.o(2, this.n);
        }
        if ((this.f24039k & 8) == 8) {
            o += CodedOutputStream.s(3, this.o);
        }
        for (int i3 = 0; i3 < this.q.size(); i3++) {
            o += CodedOutputStream.s(4, this.q.get(i3));
        }
        if ((this.f24039k & 32) == 32) {
            o += CodedOutputStream.s(5, this.r);
        }
        if ((this.f24039k & 128) == 128) {
            o += CodedOutputStream.s(6, this.w);
        }
        if ((this.f24039k & 256) == 256) {
            o += CodedOutputStream.o(7, this.x);
        }
        if ((this.f24039k & AdRequest.MAX_CONTENT_URL_LENGTH) == 512) {
            o += CodedOutputStream.o(8, this.y);
        }
        if ((this.f24039k & 16) == 16) {
            o += CodedOutputStream.o(9, this.p);
        }
        if ((this.f24039k & 64) == 64) {
            o += CodedOutputStream.o(10, this.s);
        }
        if ((this.f24039k & 1) == 1) {
            o += CodedOutputStream.o(11, this.l);
        }
        for (int i4 = 0; i4 < this.t.size(); i4++) {
            o += CodedOutputStream.s(12, this.t.get(i4));
        }
        int i5 = 0;
        for (int i6 = 0; i6 < this.u.size(); i6++) {
            i5 += CodedOutputStream.p(this.u.get(i6).intValue());
        }
        int i7 = o + i5;
        if (!X().isEmpty()) {
            i7 = i7 + 1 + CodedOutputStream.p(i5);
        }
        this.v = i5;
        int i8 = 0;
        for (int i9 = 0; i9 < this.z.size(); i9++) {
            i8 += CodedOutputStream.p(this.z.get(i9).intValue());
        }
        int size = i7 + i8 + (o0().size() * 2) + t() + this.f24038j.size();
        this.B = size;
        return size;
    }

    public int e0() {
        return this.m;
    }

    public q f0() {
        return this.r;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h, kotlin.reflect.jvm.internal.impl.protobuf.o
    public q<n> g() {
        return f24037i;
    }

    public int g0() {
        return this.s;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.o
    public void h(CodedOutputStream codedOutputStream) throws IOException {
        e();
        h.d<MessageType>.a y = y();
        if ((this.f24039k & 2) == 2) {
            codedOutputStream.a0(1, this.m);
        }
        if ((this.f24039k & 4) == 4) {
            codedOutputStream.a0(2, this.n);
        }
        if ((this.f24039k & 8) == 8) {
            codedOutputStream.d0(3, this.o);
        }
        for (int i2 = 0; i2 < this.q.size(); i2++) {
            codedOutputStream.d0(4, this.q.get(i2));
        }
        if ((this.f24039k & 32) == 32) {
            codedOutputStream.d0(5, this.r);
        }
        if ((this.f24039k & 128) == 128) {
            codedOutputStream.d0(6, this.w);
        }
        if ((this.f24039k & 256) == 256) {
            codedOutputStream.a0(7, this.x);
        }
        if ((this.f24039k & AdRequest.MAX_CONTENT_URL_LENGTH) == 512) {
            codedOutputStream.a0(8, this.y);
        }
        if ((this.f24039k & 16) == 16) {
            codedOutputStream.a0(9, this.p);
        }
        if ((this.f24039k & 64) == 64) {
            codedOutputStream.a0(10, this.s);
        }
        if ((this.f24039k & 1) == 1) {
            codedOutputStream.a0(11, this.l);
        }
        for (int i3 = 0; i3 < this.t.size(); i3++) {
            codedOutputStream.d0(12, this.t.get(i3));
        }
        if (X().size() > 0) {
            codedOutputStream.o0(106);
            codedOutputStream.o0(this.v);
        }
        for (int i4 = 0; i4 < this.u.size(); i4++) {
            codedOutputStream.b0(this.u.get(i4).intValue());
        }
        for (int i5 = 0; i5 < this.z.size(); i5++) {
            codedOutputStream.a0(31, this.z.get(i5).intValue());
        }
        y.a(19000, codedOutputStream);
        codedOutputStream.i0(this.f24038j);
    }

    public q h0() {
        return this.o;
    }

    public int i0() {
        return this.p;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.p
    public final boolean isInitialized() {
        byte b2 = this.A;
        if (b2 == 1) {
            return true;
        }
        if (b2 == 0) {
            return false;
        }
        if (!r0()) {
            this.A = (byte) 0;
            return false;
        }
        if (v0() && !h0().isInitialized()) {
            this.A = (byte) 0;
            return false;
        }
        for (int i2 = 0; i2 < m0(); i2++) {
            if (!l0(i2).isInitialized()) {
                this.A = (byte) 0;
                return false;
            }
        }
        if (t0() && !f0().isInitialized()) {
            this.A = (byte) 0;
            return false;
        }
        for (int i3 = 0; i3 < V(); i3++) {
            if (!U(i3).isInitialized()) {
                this.A = (byte) 0;
                return false;
            }
        }
        if (y0() && !k0().isInitialized()) {
            this.A = (byte) 0;
            return false;
        }
        if (!s()) {
            this.A = (byte) 0;
            return false;
        }
        this.A = (byte) 1;
        return true;
    }

    public int j0() {
        return this.y;
    }

    public u k0() {
        return this.w;
    }

    public s l0(int i2) {
        return this.q.get(i2);
    }

    public int m0() {
        return this.q.size();
    }

    public List<s> n0() {
        return this.q;
    }

    public List<Integer> o0() {
        return this.z;
    }

    public boolean p0() {
        return (this.f24039k & 1) == 1;
    }

    public boolean q0() {
        return (this.f24039k & 256) == 256;
    }

    public boolean r0() {
        return (this.f24039k & 4) == 4;
    }

    public boolean s0() {
        return (this.f24039k & 2) == 2;
    }

    public boolean t0() {
        return (this.f24039k & 32) == 32;
    }

    public boolean u0() {
        return (this.f24039k & 64) == 64;
    }

    public boolean v0() {
        return (this.f24039k & 8) == 8;
    }

    public boolean w0() {
        return (this.f24039k & 16) == 16;
    }

    public boolean x0() {
        return (this.f24039k & AdRequest.MAX_CONTENT_URL_LENGTH) == 512;
    }

    public boolean y0() {
        return (this.f24039k & 128) == 128;
    }

    private n(h.c<n, ?> cVar) {
        super(cVar);
        this.v = -1;
        this.A = (byte) -1;
        this.B = -1;
        this.f24038j = cVar.l();
    }

    private n(boolean z) {
        this.v = -1;
        this.A = (byte) -1;
        this.B = -1;
        this.f24038j = d.f25399f;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:6:0x0027. Please report as an issue. */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v2, types: [boolean] */
    private n(e eVar, f fVar) throws InvalidProtocolBufferException {
        this.v = -1;
        this.A = (byte) -1;
        this.B = -1;
        z0();
        d.b w = d.w();
        CodedOutputStream J = CodedOutputStream.J(w, 1);
        boolean z = false;
        int i2 = 0;
        while (true) {
            ?? r5 = 256;
            if (!z) {
                try {
                    try {
                        try {
                            int K = eVar.K();
                            switch (K) {
                                case 0:
                                    z = true;
                                case 8:
                                    this.f24039k |= 2;
                                    this.m = eVar.s();
                                case 16:
                                    this.f24039k |= 4;
                                    this.n = eVar.s();
                                case 26:
                                    q.c d2 = (this.f24039k & 8) == 8 ? this.o.d() : null;
                                    q qVar = (q) eVar.u(q.f24073i, fVar);
                                    this.o = qVar;
                                    if (d2 != null) {
                                        d2.m(qVar);
                                        this.o = d2.u();
                                    }
                                    this.f24039k |= 8;
                                case 34:
                                    if ((i2 & 32) != 32) {
                                        this.q = new ArrayList();
                                        i2 |= 32;
                                    }
                                    this.q.add(eVar.u(s.f24102i, fVar));
                                case 42:
                                    q.c d3 = (this.f24039k & 32) == 32 ? this.r.d() : null;
                                    q qVar2 = (q) eVar.u(q.f24073i, fVar);
                                    this.r = qVar2;
                                    if (d3 != null) {
                                        d3.m(qVar2);
                                        this.r = d3.u();
                                    }
                                    this.f24039k |= 32;
                                case 50:
                                    u.b d4 = (this.f24039k & 128) == 128 ? this.w.d() : null;
                                    u uVar = (u) eVar.u(u.f24123i, fVar);
                                    this.w = uVar;
                                    if (d4 != null) {
                                        d4.m(uVar);
                                        this.w = d4.u();
                                    }
                                    this.f24039k |= 128;
                                case 56:
                                    this.f24039k |= 256;
                                    this.x = eVar.s();
                                case 64:
                                    this.f24039k |= AdRequest.MAX_CONTENT_URL_LENGTH;
                                    this.y = eVar.s();
                                case 72:
                                    this.f24039k |= 16;
                                    this.p = eVar.s();
                                case 80:
                                    this.f24039k |= 64;
                                    this.s = eVar.s();
                                case 88:
                                    this.f24039k |= 1;
                                    this.l = eVar.s();
                                case 98:
                                    if ((i2 & 256) != 256) {
                                        this.t = new ArrayList();
                                        i2 |= 256;
                                    }
                                    this.t.add(eVar.u(q.f24073i, fVar));
                                case 104:
                                    if ((i2 & AdRequest.MAX_CONTENT_URL_LENGTH) != 512) {
                                        this.u = new ArrayList();
                                        i2 |= AdRequest.MAX_CONTENT_URL_LENGTH;
                                    }
                                    this.u.add(Integer.valueOf(eVar.s()));
                                case 106:
                                    int j2 = eVar.j(eVar.A());
                                    if ((i2 & AdRequest.MAX_CONTENT_URL_LENGTH) != 512 && eVar.e() > 0) {
                                        this.u = new ArrayList();
                                        i2 |= AdRequest.MAX_CONTENT_URL_LENGTH;
                                    }
                                    while (eVar.e() > 0) {
                                        this.u.add(Integer.valueOf(eVar.s()));
                                    }
                                    eVar.i(j2);
                                    break;
                                case 248:
                                    if ((i2 & 8192) != 8192) {
                                        this.z = new ArrayList();
                                        i2 |= 8192;
                                    }
                                    this.z.add(Integer.valueOf(eVar.s()));
                                case 250:
                                    int j3 = eVar.j(eVar.A());
                                    if ((i2 & 8192) != 8192 && eVar.e() > 0) {
                                        this.z = new ArrayList();
                                        i2 |= 8192;
                                    }
                                    while (eVar.e() > 0) {
                                        this.z.add(Integer.valueOf(eVar.s()));
                                    }
                                    eVar.i(j3);
                                    break;
                                default:
                                    r5 = p(eVar, J, fVar, K);
                                    if (r5 == 0) {
                                        z = true;
                                    }
                            }
                        } catch (InvalidProtocolBufferException e2) {
                            throw e2.i(this);
                        }
                    } catch (IOException e3) {
                        throw new InvalidProtocolBufferException(e3.getMessage()).i(this);
                    }
                } catch (Throwable th) {
                    if ((i2 & 32) == 32) {
                        this.q = Collections.unmodifiableList(this.q);
                    }
                    if ((i2 & 256) == r5) {
                        this.t = Collections.unmodifiableList(this.t);
                    }
                    if ((i2 & AdRequest.MAX_CONTENT_URL_LENGTH) == 512) {
                        this.u = Collections.unmodifiableList(this.u);
                    }
                    if ((i2 & 8192) == 8192) {
                        this.z = Collections.unmodifiableList(this.z);
                    }
                    try {
                        J.I();
                    } catch (IOException unused) {
                    } catch (Throwable th2) {
                        this.f24038j = w.e();
                        throw th2;
                    }
                    this.f24038j = w.e();
                    m();
                    throw th;
                }
            } else {
                if ((i2 & 32) == 32) {
                    this.q = Collections.unmodifiableList(this.q);
                }
                if ((i2 & 256) == 256) {
                    this.t = Collections.unmodifiableList(this.t);
                }
                if ((i2 & AdRequest.MAX_CONTENT_URL_LENGTH) == 512) {
                    this.u = Collections.unmodifiableList(this.u);
                }
                if ((i2 & 8192) == 8192) {
                    this.z = Collections.unmodifiableList(this.z);
                }
                try {
                    J.I();
                } catch (IOException unused2) {
                } catch (Throwable th3) {
                    this.f24038j = w.e();
                    throw th3;
                }
                this.f24038j = w.e();
                m();
                return;
            }
        }
    }
}
