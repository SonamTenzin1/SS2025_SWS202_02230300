package kotlin.reflect.y.internal.j0.e;

import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.ads.AdRequest;
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
import kotlin.reflect.y.internal.j0.e.e;
import kotlin.reflect.y.internal.j0.e.q;
import kotlin.reflect.y.internal.j0.e.t;

/* compiled from: ProtoBuf.java */
/* loaded from: classes3.dex */
public final class i extends h.d<i> implements p {

    /* renamed from: h, reason: collision with root package name */
    private static final i f24003h;

    /* renamed from: i, reason: collision with root package name */
    public static q<i> f24004i = new a();
    private byte A;
    private int B;

    /* renamed from: j, reason: collision with root package name */
    private final d f24005j;

    /* renamed from: k, reason: collision with root package name */
    private int f24006k;
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
    private List<u> w;
    private t x;
    private List<Integer> y;
    private e z;

    /* compiled from: ProtoBuf.java */
    /* loaded from: classes3.dex */
    static class a extends kotlin.reflect.jvm.internal.impl.protobuf.b<i> {
        a() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.q
        /* renamed from: m, reason: merged with bridge method [inline-methods] */
        public i b(e eVar, f fVar) throws InvalidProtocolBufferException {
            return new i(eVar, fVar);
        }
    }

    /* compiled from: ProtoBuf.java */
    /* loaded from: classes3.dex */
    public static final class b extends h.c<i, b> implements p {

        /* renamed from: i, reason: collision with root package name */
        private int f24007i;
        private int l;
        private int n;
        private int q;

        /* renamed from: j, reason: collision with root package name */
        private int f24008j = 6;

        /* renamed from: k, reason: collision with root package name */
        private int f24009k = 6;
        private q m = q.Y();
        private List<s> o = Collections.emptyList();
        private q p = q.Y();
        private List<q> r = Collections.emptyList();
        private List<Integer> s = Collections.emptyList();
        private List<u> t = Collections.emptyList();
        private t u = t.w();
        private List<Integer> v = Collections.emptyList();
        private e w = e.u();

        private b() {
            F();
        }

        private void A() {
            if ((this.f24007i & AdRequest.MAX_CONTENT_URL_LENGTH) != 512) {
                this.s = new ArrayList(this.s);
                this.f24007i |= AdRequest.MAX_CONTENT_URL_LENGTH;
            }
        }

        private void B() {
            if ((this.f24007i & 256) != 256) {
                this.r = new ArrayList(this.r);
                this.f24007i |= 256;
            }
        }

        private void C() {
            if ((this.f24007i & 32) != 32) {
                this.o = new ArrayList(this.o);
                this.f24007i |= 32;
            }
        }

        private void D() {
            if ((this.f24007i & 1024) != 1024) {
                this.t = new ArrayList(this.t);
                this.f24007i |= 1024;
            }
        }

        private void E() {
            if ((this.f24007i & RecyclerView.l.FLAG_APPEARED_IN_PRE_LAYOUT) != 4096) {
                this.v = new ArrayList(this.v);
                this.f24007i |= RecyclerView.l.FLAG_APPEARED_IN_PRE_LAYOUT;
            }
        }

        private void F() {
        }

        static /* synthetic */ b s() {
            return w();
        }

        private static b w() {
            return new b();
        }

        public b G(e eVar) {
            if ((this.f24007i & 8192) == 8192 && this.w != e.u()) {
                this.w = e.z(this.w).m(eVar).q();
            } else {
                this.w = eVar;
            }
            this.f24007i |= 8192;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h.b
        /* renamed from: H, reason: merged with bridge method [inline-methods] */
        public b m(i iVar) {
            if (iVar == i.b0()) {
                return this;
            }
            if (iVar.t0()) {
                M(iVar.d0());
            }
            if (iVar.v0()) {
                O(iVar.f0());
            }
            if (iVar.u0()) {
                N(iVar.e0());
            }
            if (iVar.y0()) {
                K(iVar.i0());
            }
            if (iVar.z0()) {
                Q(iVar.j0());
            }
            if (!iVar.q.isEmpty()) {
                if (this.o.isEmpty()) {
                    this.o = iVar.q;
                    this.f24007i &= -33;
                } else {
                    C();
                    this.o.addAll(iVar.q);
                }
            }
            if (iVar.w0()) {
                J(iVar.g0());
            }
            if (iVar.x0()) {
                P(iVar.h0());
            }
            if (!iVar.t.isEmpty()) {
                if (this.r.isEmpty()) {
                    this.r = iVar.t;
                    this.f24007i &= -257;
                } else {
                    B();
                    this.r.addAll(iVar.t);
                }
            }
            if (!iVar.u.isEmpty()) {
                if (this.s.isEmpty()) {
                    this.s = iVar.u;
                    this.f24007i &= -513;
                } else {
                    A();
                    this.s.addAll(iVar.u);
                }
            }
            if (!iVar.w.isEmpty()) {
                if (this.t.isEmpty()) {
                    this.t = iVar.w;
                    this.f24007i &= -1025;
                } else {
                    D();
                    this.t.addAll(iVar.w);
                }
            }
            if (iVar.A0()) {
                L(iVar.n0());
            }
            if (!iVar.y.isEmpty()) {
                if (this.v.isEmpty()) {
                    this.v = iVar.y;
                    this.f24007i &= -4097;
                } else {
                    E();
                    this.v.addAll(iVar.y);
                }
            }
            if (iVar.s0()) {
                G(iVar.a0());
            }
            r(iVar);
            n(l().f(iVar.f24005j));
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:17:0x001d  */
        @Override // kotlin.reflect.jvm.internal.impl.protobuf.a.AbstractC0413a
        /* renamed from: I, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public b i(e eVar, f fVar) throws IOException {
            i iVar = null;
            try {
                try {
                    i b2 = i.f24004i.b(eVar, fVar);
                    if (b2 != null) {
                        m(b2);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e2) {
                    i iVar2 = (i) e2.a();
                    try {
                        throw e2;
                    } catch (Throwable th) {
                        th = th;
                        iVar = iVar2;
                        if (iVar != null) {
                            m(iVar);
                        }
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                if (iVar != null) {
                }
                throw th;
            }
        }

        public b J(q qVar) {
            if ((this.f24007i & 64) == 64 && this.p != q.Y()) {
                this.p = q.z0(this.p).m(qVar).u();
            } else {
                this.p = qVar;
            }
            this.f24007i |= 64;
            return this;
        }

        public b K(q qVar) {
            if ((this.f24007i & 8) == 8 && this.m != q.Y()) {
                this.m = q.z0(this.m).m(qVar).u();
            } else {
                this.m = qVar;
            }
            this.f24007i |= 8;
            return this;
        }

        public b L(t tVar) {
            if ((this.f24007i & RecyclerView.l.FLAG_MOVED) == 2048 && this.u != t.w()) {
                this.u = t.E(this.u).m(tVar).q();
            } else {
                this.u = tVar;
            }
            this.f24007i |= RecyclerView.l.FLAG_MOVED;
            return this;
        }

        public b M(int i2) {
            this.f24007i |= 1;
            this.f24008j = i2;
            return this;
        }

        public b N(int i2) {
            this.f24007i |= 4;
            this.l = i2;
            return this;
        }

        public b O(int i2) {
            this.f24007i |= 2;
            this.f24009k = i2;
            return this;
        }

        public b P(int i2) {
            this.f24007i |= 128;
            this.q = i2;
            return this;
        }

        public b Q(int i2) {
            this.f24007i |= 16;
            this.n = i2;
            return this;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.o.a
        /* renamed from: t, reason: merged with bridge method [inline-methods] */
        public i c() {
            i u = u();
            if (u.isInitialized()) {
                return u;
            }
            throw a.AbstractC0413a.j(u);
        }

        public i u() {
            i iVar = new i(this);
            int i2 = this.f24007i;
            int i3 = (i2 & 1) != 1 ? 0 : 1;
            iVar.l = this.f24008j;
            if ((i2 & 2) == 2) {
                i3 |= 2;
            }
            iVar.m = this.f24009k;
            if ((i2 & 4) == 4) {
                i3 |= 4;
            }
            iVar.n = this.l;
            if ((i2 & 8) == 8) {
                i3 |= 8;
            }
            iVar.o = this.m;
            if ((i2 & 16) == 16) {
                i3 |= 16;
            }
            iVar.p = this.n;
            if ((this.f24007i & 32) == 32) {
                this.o = Collections.unmodifiableList(this.o);
                this.f24007i &= -33;
            }
            iVar.q = this.o;
            if ((i2 & 64) == 64) {
                i3 |= 32;
            }
            iVar.r = this.p;
            if ((i2 & 128) == 128) {
                i3 |= 64;
            }
            iVar.s = this.q;
            if ((this.f24007i & 256) == 256) {
                this.r = Collections.unmodifiableList(this.r);
                this.f24007i &= -257;
            }
            iVar.t = this.r;
            if ((this.f24007i & AdRequest.MAX_CONTENT_URL_LENGTH) == 512) {
                this.s = Collections.unmodifiableList(this.s);
                this.f24007i &= -513;
            }
            iVar.u = this.s;
            if ((this.f24007i & 1024) == 1024) {
                this.t = Collections.unmodifiableList(this.t);
                this.f24007i &= -1025;
            }
            iVar.w = this.t;
            if ((i2 & RecyclerView.l.FLAG_MOVED) == 2048) {
                i3 |= 128;
            }
            iVar.x = this.u;
            if ((this.f24007i & RecyclerView.l.FLAG_APPEARED_IN_PRE_LAYOUT) == 4096) {
                this.v = Collections.unmodifiableList(this.v);
                this.f24007i &= -4097;
            }
            iVar.y = this.v;
            if ((i2 & 8192) == 8192) {
                i3 |= 256;
            }
            iVar.z = this.w;
            iVar.f24006k = i3;
            return iVar;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h.b
        /* renamed from: v, reason: merged with bridge method [inline-methods] */
        public b k() {
            return w().m(u());
        }
    }

    static {
        i iVar = new i(true);
        f24003h = iVar;
        iVar.B0();
    }

    private void B0() {
        this.l = 6;
        this.m = 6;
        this.n = 0;
        this.o = q.Y();
        this.p = 0;
        this.q = Collections.emptyList();
        this.r = q.Y();
        this.s = 0;
        this.t = Collections.emptyList();
        this.u = Collections.emptyList();
        this.w = Collections.emptyList();
        this.x = t.w();
        this.y = Collections.emptyList();
        this.z = e.u();
    }

    public static b C0() {
        return b.s();
    }

    public static b D0(i iVar) {
        return C0().m(iVar);
    }

    public static i F0(InputStream inputStream, f fVar) throws IOException {
        return f24004i.a(inputStream, fVar);
    }

    public static i b0() {
        return f24003h;
    }

    public boolean A0() {
        return (this.f24006k & 128) == 128;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.o
    /* renamed from: E0, reason: merged with bridge method [inline-methods] */
    public b f() {
        return C0();
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.o
    /* renamed from: G0, reason: merged with bridge method [inline-methods] */
    public b d() {
        return D0(this);
    }

    public q V(int i2) {
        return this.t.get(i2);
    }

    public int X() {
        return this.t.size();
    }

    public List<Integer> Y() {
        return this.u;
    }

    public List<q> Z() {
        return this.t;
    }

    public e a0() {
        return this.z;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.p
    /* renamed from: c0, reason: merged with bridge method [inline-methods] */
    public i b() {
        return f24003h;
    }

    public int d0() {
        return this.l;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.o
    public int e() {
        int i2 = this.B;
        if (i2 != -1) {
            return i2;
        }
        int o = (this.f24006k & 2) == 2 ? CodedOutputStream.o(1, this.m) + 0 : 0;
        if ((this.f24006k & 4) == 4) {
            o += CodedOutputStream.o(2, this.n);
        }
        if ((this.f24006k & 8) == 8) {
            o += CodedOutputStream.s(3, this.o);
        }
        for (int i3 = 0; i3 < this.q.size(); i3++) {
            o += CodedOutputStream.s(4, this.q.get(i3));
        }
        if ((this.f24006k & 32) == 32) {
            o += CodedOutputStream.s(5, this.r);
        }
        for (int i4 = 0; i4 < this.w.size(); i4++) {
            o += CodedOutputStream.s(6, this.w.get(i4));
        }
        if ((this.f24006k & 16) == 16) {
            o += CodedOutputStream.o(7, this.p);
        }
        if ((this.f24006k & 64) == 64) {
            o += CodedOutputStream.o(8, this.s);
        }
        if ((this.f24006k & 1) == 1) {
            o += CodedOutputStream.o(9, this.l);
        }
        for (int i5 = 0; i5 < this.t.size(); i5++) {
            o += CodedOutputStream.s(10, this.t.get(i5));
        }
        int i6 = 0;
        for (int i7 = 0; i7 < this.u.size(); i7++) {
            i6 += CodedOutputStream.p(this.u.get(i7).intValue());
        }
        int i8 = o + i6;
        if (!Y().isEmpty()) {
            i8 = i8 + 1 + CodedOutputStream.p(i6);
        }
        this.v = i6;
        if ((this.f24006k & 128) == 128) {
            i8 += CodedOutputStream.s(30, this.x);
        }
        int i9 = 0;
        for (int i10 = 0; i10 < this.y.size(); i10++) {
            i9 += CodedOutputStream.p(this.y.get(i10).intValue());
        }
        int size = i8 + i9 + (r0().size() * 2);
        if ((this.f24006k & 256) == 256) {
            size += CodedOutputStream.s(32, this.z);
        }
        int t = size + t() + this.f24005j.size();
        this.B = t;
        return t;
    }

    public int e0() {
        return this.n;
    }

    public int f0() {
        return this.m;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h, kotlin.reflect.jvm.internal.impl.protobuf.o
    public q<i> g() {
        return f24004i;
    }

    public q g0() {
        return this.r;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.o
    public void h(CodedOutputStream codedOutputStream) throws IOException {
        e();
        h.d<MessageType>.a y = y();
        if ((this.f24006k & 2) == 2) {
            codedOutputStream.a0(1, this.m);
        }
        if ((this.f24006k & 4) == 4) {
            codedOutputStream.a0(2, this.n);
        }
        if ((this.f24006k & 8) == 8) {
            codedOutputStream.d0(3, this.o);
        }
        for (int i2 = 0; i2 < this.q.size(); i2++) {
            codedOutputStream.d0(4, this.q.get(i2));
        }
        if ((this.f24006k & 32) == 32) {
            codedOutputStream.d0(5, this.r);
        }
        for (int i3 = 0; i3 < this.w.size(); i3++) {
            codedOutputStream.d0(6, this.w.get(i3));
        }
        if ((this.f24006k & 16) == 16) {
            codedOutputStream.a0(7, this.p);
        }
        if ((this.f24006k & 64) == 64) {
            codedOutputStream.a0(8, this.s);
        }
        if ((this.f24006k & 1) == 1) {
            codedOutputStream.a0(9, this.l);
        }
        for (int i4 = 0; i4 < this.t.size(); i4++) {
            codedOutputStream.d0(10, this.t.get(i4));
        }
        if (Y().size() > 0) {
            codedOutputStream.o0(90);
            codedOutputStream.o0(this.v);
        }
        for (int i5 = 0; i5 < this.u.size(); i5++) {
            codedOutputStream.b0(this.u.get(i5).intValue());
        }
        if ((this.f24006k & 128) == 128) {
            codedOutputStream.d0(30, this.x);
        }
        for (int i6 = 0; i6 < this.y.size(); i6++) {
            codedOutputStream.a0(31, this.y.get(i6).intValue());
        }
        if ((this.f24006k & 256) == 256) {
            codedOutputStream.d0(32, this.z);
        }
        y.a(19000, codedOutputStream);
        codedOutputStream.i0(this.f24005j);
    }

    public int h0() {
        return this.s;
    }

    public q i0() {
        return this.o;
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
        if (!u0()) {
            this.A = (byte) 0;
            return false;
        }
        if (y0() && !i0().isInitialized()) {
            this.A = (byte) 0;
            return false;
        }
        for (int i2 = 0; i2 < l0(); i2++) {
            if (!k0(i2).isInitialized()) {
                this.A = (byte) 0;
                return false;
            }
        }
        if (w0() && !g0().isInitialized()) {
            this.A = (byte) 0;
            return false;
        }
        for (int i3 = 0; i3 < X(); i3++) {
            if (!V(i3).isInitialized()) {
                this.A = (byte) 0;
                return false;
            }
        }
        for (int i4 = 0; i4 < p0(); i4++) {
            if (!o0(i4).isInitialized()) {
                this.A = (byte) 0;
                return false;
            }
        }
        if (A0() && !n0().isInitialized()) {
            this.A = (byte) 0;
            return false;
        }
        if (s0() && !a0().isInitialized()) {
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
        return this.p;
    }

    public s k0(int i2) {
        return this.q.get(i2);
    }

    public int l0() {
        return this.q.size();
    }

    public List<s> m0() {
        return this.q;
    }

    public t n0() {
        return this.x;
    }

    public u o0(int i2) {
        return this.w.get(i2);
    }

    public int p0() {
        return this.w.size();
    }

    public List<u> q0() {
        return this.w;
    }

    public List<Integer> r0() {
        return this.y;
    }

    public boolean s0() {
        return (this.f24006k & 256) == 256;
    }

    public boolean t0() {
        return (this.f24006k & 1) == 1;
    }

    public boolean u0() {
        return (this.f24006k & 4) == 4;
    }

    public boolean v0() {
        return (this.f24006k & 2) == 2;
    }

    public boolean w0() {
        return (this.f24006k & 32) == 32;
    }

    public boolean x0() {
        return (this.f24006k & 64) == 64;
    }

    public boolean y0() {
        return (this.f24006k & 8) == 8;
    }

    public boolean z0() {
        return (this.f24006k & 16) == 16;
    }

    private i(h.c<i, ?> cVar) {
        super(cVar);
        this.v = -1;
        this.A = (byte) -1;
        this.B = -1;
        this.f24005j = cVar.l();
    }

    private i(boolean z) {
        this.v = -1;
        this.A = (byte) -1;
        this.B = -1;
        this.f24005j = d.f25399f;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:6:0x0029. Please report as an issue. */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v2, types: [boolean] */
    private i(e eVar, f fVar) throws InvalidProtocolBufferException {
        this.v = -1;
        this.A = (byte) -1;
        this.B = -1;
        B0();
        d.b w = d.w();
        CodedOutputStream J = CodedOutputStream.J(w, 1);
        boolean z = false;
        int i2 = 0;
        while (true) {
            ?? r5 = 1024;
            if (!z) {
                try {
                    try {
                        try {
                            int K = eVar.K();
                            switch (K) {
                                case 0:
                                    z = true;
                                case 8:
                                    this.f24006k |= 2;
                                    this.m = eVar.s();
                                case 16:
                                    this.f24006k |= 4;
                                    this.n = eVar.s();
                                case 26:
                                    q.c d2 = (this.f24006k & 8) == 8 ? this.o.d() : null;
                                    q qVar = (q) eVar.u(q.f24073i, fVar);
                                    this.o = qVar;
                                    if (d2 != null) {
                                        d2.m(qVar);
                                        this.o = d2.u();
                                    }
                                    this.f24006k |= 8;
                                case 34:
                                    if ((i2 & 32) != 32) {
                                        this.q = new ArrayList();
                                        i2 |= 32;
                                    }
                                    this.q.add(eVar.u(s.f24102i, fVar));
                                case 42:
                                    q.c d3 = (this.f24006k & 32) == 32 ? this.r.d() : null;
                                    q qVar2 = (q) eVar.u(q.f24073i, fVar);
                                    this.r = qVar2;
                                    if (d3 != null) {
                                        d3.m(qVar2);
                                        this.r = d3.u();
                                    }
                                    this.f24006k |= 32;
                                case 50:
                                    if ((i2 & 1024) != 1024) {
                                        this.w = new ArrayList();
                                        i2 |= 1024;
                                    }
                                    this.w.add(eVar.u(u.f24123i, fVar));
                                case 56:
                                    this.f24006k |= 16;
                                    this.p = eVar.s();
                                case 64:
                                    this.f24006k |= 64;
                                    this.s = eVar.s();
                                case 72:
                                    this.f24006k |= 1;
                                    this.l = eVar.s();
                                case 82:
                                    if ((i2 & 256) != 256) {
                                        this.t = new ArrayList();
                                        i2 |= 256;
                                    }
                                    this.t.add(eVar.u(q.f24073i, fVar));
                                case 88:
                                    if ((i2 & AdRequest.MAX_CONTENT_URL_LENGTH) != 512) {
                                        this.u = new ArrayList();
                                        i2 |= AdRequest.MAX_CONTENT_URL_LENGTH;
                                    }
                                    this.u.add(Integer.valueOf(eVar.s()));
                                case 90:
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
                                case 242:
                                    t.b d4 = (this.f24006k & 128) == 128 ? this.x.d() : null;
                                    t tVar = (t) eVar.u(t.f24115h, fVar);
                                    this.x = tVar;
                                    if (d4 != null) {
                                        d4.m(tVar);
                                        this.x = d4.q();
                                    }
                                    this.f24006k |= 128;
                                case 248:
                                    if ((i2 & RecyclerView.l.FLAG_APPEARED_IN_PRE_LAYOUT) != 4096) {
                                        this.y = new ArrayList();
                                        i2 |= RecyclerView.l.FLAG_APPEARED_IN_PRE_LAYOUT;
                                    }
                                    this.y.add(Integer.valueOf(eVar.s()));
                                case 250:
                                    int j3 = eVar.j(eVar.A());
                                    if ((i2 & RecyclerView.l.FLAG_APPEARED_IN_PRE_LAYOUT) != 4096 && eVar.e() > 0) {
                                        this.y = new ArrayList();
                                        i2 |= RecyclerView.l.FLAG_APPEARED_IN_PRE_LAYOUT;
                                    }
                                    while (eVar.e() > 0) {
                                        this.y.add(Integer.valueOf(eVar.s()));
                                    }
                                    eVar.i(j3);
                                    break;
                                case 258:
                                    e.b d5 = (this.f24006k & 256) == 256 ? this.z.d() : null;
                                    e eVar2 = (e) eVar.u(e.f23953h, fVar);
                                    this.z = eVar2;
                                    if (d5 != null) {
                                        d5.m(eVar2);
                                        this.z = d5.q();
                                    }
                                    this.f24006k |= 256;
                                default:
                                    r5 = p(eVar, J, fVar, K);
                                    if (r5 == 0) {
                                        z = true;
                                    }
                            }
                        } catch (IOException e2) {
                            throw new InvalidProtocolBufferException(e2.getMessage()).i(this);
                        }
                    } catch (InvalidProtocolBufferException e3) {
                        throw e3.i(this);
                    }
                } catch (Throwable th) {
                    if ((i2 & 32) == 32) {
                        this.q = Collections.unmodifiableList(this.q);
                    }
                    if ((i2 & 1024) == r5) {
                        this.w = Collections.unmodifiableList(this.w);
                    }
                    if ((i2 & 256) == 256) {
                        this.t = Collections.unmodifiableList(this.t);
                    }
                    if ((i2 & AdRequest.MAX_CONTENT_URL_LENGTH) == 512) {
                        this.u = Collections.unmodifiableList(this.u);
                    }
                    if ((i2 & RecyclerView.l.FLAG_APPEARED_IN_PRE_LAYOUT) == 4096) {
                        this.y = Collections.unmodifiableList(this.y);
                    }
                    try {
                        J.I();
                    } catch (IOException unused) {
                    } catch (Throwable th2) {
                        this.f24005j = w.e();
                        throw th2;
                    }
                    this.f24005j = w.e();
                    m();
                    throw th;
                }
            } else {
                if ((i2 & 32) == 32) {
                    this.q = Collections.unmodifiableList(this.q);
                }
                if ((i2 & 1024) == 1024) {
                    this.w = Collections.unmodifiableList(this.w);
                }
                if ((i2 & 256) == 256) {
                    this.t = Collections.unmodifiableList(this.t);
                }
                if ((i2 & AdRequest.MAX_CONTENT_URL_LENGTH) == 512) {
                    this.u = Collections.unmodifiableList(this.u);
                }
                if ((i2 & RecyclerView.l.FLAG_APPEARED_IN_PRE_LAYOUT) == 4096) {
                    this.y = Collections.unmodifiableList(this.y);
                }
                try {
                    J.I();
                } catch (IOException unused2) {
                } catch (Throwable th3) {
                    this.f24005j = w.e();
                    throw th3;
                }
                this.f24005j = w.e();
                m();
                return;
            }
        }
    }
}
