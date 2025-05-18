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
public final class w extends h implements p {

    /* renamed from: g, reason: collision with root package name */
    private static final w f24151g;

    /* renamed from: h, reason: collision with root package name */
    public static q<w> f24152h = new a();

    /* renamed from: i, reason: collision with root package name */
    private final d f24153i;

    /* renamed from: j, reason: collision with root package name */
    private List<v> f24154j;

    /* renamed from: k, reason: collision with root package name */
    private byte f24155k;
    private int l;

    /* compiled from: ProtoBuf.java */
    /* loaded from: classes3.dex */
    static class a extends kotlin.reflect.jvm.internal.impl.protobuf.b<w> {
        a() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.q
        /* renamed from: m, reason: merged with bridge method [inline-methods] */
        public w b(e eVar, f fVar) throws InvalidProtocolBufferException {
            return new w(eVar, fVar);
        }
    }

    /* compiled from: ProtoBuf.java */
    /* loaded from: classes3.dex */
    public static final class b extends h.b<w, b> implements p {

        /* renamed from: g, reason: collision with root package name */
        private int f24156g;

        /* renamed from: h, reason: collision with root package name */
        private List<v> f24157h = Collections.emptyList();

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
            if ((this.f24156g & 1) != 1) {
                this.f24157h = new ArrayList(this.f24157h);
                this.f24156g |= 1;
            }
        }

        private void u() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.o.a
        /* renamed from: p, reason: merged with bridge method [inline-methods] */
        public w c() {
            w q = q();
            if (q.isInitialized()) {
                return q;
            }
            throw a.AbstractC0413a.j(q);
        }

        public w q() {
            w wVar = new w(this);
            if ((this.f24156g & 1) == 1) {
                this.f24157h = Collections.unmodifiableList(this.f24157h);
                this.f24156g &= -2;
            }
            wVar.f24154j = this.f24157h;
            return wVar;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h.b
        /* renamed from: r, reason: merged with bridge method [inline-methods] */
        public b k() {
            return s().m(q());
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h.b
        /* renamed from: v, reason: merged with bridge method [inline-methods] */
        public b m(w wVar) {
            if (wVar == w.u()) {
                return this;
            }
            if (!wVar.f24154j.isEmpty()) {
                if (this.f24157h.isEmpty()) {
                    this.f24157h = wVar.f24154j;
                    this.f24156g &= -2;
                } else {
                    t();
                    this.f24157h.addAll(wVar.f24154j);
                }
            }
            n(l().f(wVar.f24153i));
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:17:0x001d  */
        @Override // kotlin.reflect.jvm.internal.impl.protobuf.a.AbstractC0413a
        /* renamed from: w, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public b i(e eVar, f fVar) throws IOException {
            w wVar = null;
            try {
                try {
                    w b2 = w.f24152h.b(eVar, fVar);
                    if (b2 != null) {
                        m(b2);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e2) {
                    w wVar2 = (w) e2.a();
                    try {
                        throw e2;
                    } catch (Throwable th) {
                        th = th;
                        wVar = wVar2;
                        if (wVar != null) {
                            m(wVar);
                        }
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                if (wVar != null) {
                }
                throw th;
            }
        }
    }

    static {
        w wVar = new w(true);
        f24151g = wVar;
        wVar.x();
    }

    public static w u() {
        return f24151g;
    }

    private void x() {
        this.f24154j = Collections.emptyList();
    }

    public static b y() {
        return b.o();
    }

    public static b z(w wVar) {
        return y().m(wVar);
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
        for (int i4 = 0; i4 < this.f24154j.size(); i4++) {
            i3 += CodedOutputStream.s(1, this.f24154j.get(i4));
        }
        int size = i3 + this.f24153i.size();
        this.l = size;
        return size;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h, kotlin.reflect.jvm.internal.impl.protobuf.o
    public q<w> g() {
        return f24152h;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.o
    public void h(CodedOutputStream codedOutputStream) throws IOException {
        e();
        for (int i2 = 0; i2 < this.f24154j.size(); i2++) {
            codedOutputStream.d0(1, this.f24154j.get(i2));
        }
        codedOutputStream.i0(this.f24153i);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.p
    public final boolean isInitialized() {
        byte b2 = this.f24155k;
        if (b2 == 1) {
            return true;
        }
        if (b2 == 0) {
            return false;
        }
        this.f24155k = (byte) 1;
        return true;
    }

    public int v() {
        return this.f24154j.size();
    }

    public List<v> w() {
        return this.f24154j;
    }

    private w(h.b bVar) {
        super(bVar);
        this.f24155k = (byte) -1;
        this.l = -1;
        this.f24153i = bVar.l();
    }

    private w(boolean z) {
        this.f24155k = (byte) -1;
        this.l = -1;
        this.f24153i = d.f25399f;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private w(e eVar, f fVar) throws InvalidProtocolBufferException {
        this.f24155k = (byte) -1;
        this.l = -1;
        x();
        d.b w = d.w();
        CodedOutputStream J = CodedOutputStream.J(w, 1);
        boolean z = false;
        boolean z2 = false;
        while (!z) {
            try {
                try {
                    int K = eVar.K();
                    if (K != 0) {
                        if (K != 10) {
                            if (!p(eVar, J, fVar, K)) {
                            }
                        } else {
                            if (!(z2 & true)) {
                                this.f24154j = new ArrayList();
                                z2 |= true;
                            }
                            this.f24154j.add(eVar.u(v.f24130h, fVar));
                        }
                    }
                    z = true;
                } catch (Throwable th) {
                    if (z2 & true) {
                        this.f24154j = Collections.unmodifiableList(this.f24154j);
                    }
                    try {
                        J.I();
                    } catch (IOException unused) {
                    } catch (Throwable th2) {
                        this.f24153i = w.e();
                        throw th2;
                    }
                    this.f24153i = w.e();
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
            this.f24154j = Collections.unmodifiableList(this.f24154j);
        }
        try {
            J.I();
        } catch (IOException unused2) {
        } catch (Throwable th3) {
            this.f24153i = w.e();
            throw th3;
        }
        this.f24153i = w.e();
        m();
    }
}
