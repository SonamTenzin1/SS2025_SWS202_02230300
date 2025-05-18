package kotlin.reflect.y.internal.j0.e;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.protobuf.CodedOutputStream;
import kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException;
import kotlin.reflect.jvm.internal.impl.protobuf.a;
import kotlin.reflect.jvm.internal.impl.protobuf.d;
import kotlin.reflect.jvm.internal.impl.protobuf.f;
import kotlin.reflect.jvm.internal.impl.protobuf.h;
import kotlin.reflect.jvm.internal.impl.protobuf.p;
import kotlin.reflect.jvm.internal.impl.protobuf.q;

/* compiled from: ProtoBuf.java */
/* loaded from: classes3.dex */
public final class e extends h implements p {

    /* renamed from: g, reason: collision with root package name */
    private static final e f23952g;

    /* renamed from: h, reason: collision with root package name */
    public static q<e> f23953h = new a();

    /* renamed from: i, reason: collision with root package name */
    private final d f23954i;

    /* renamed from: j, reason: collision with root package name */
    private List<f> f23955j;

    /* renamed from: k, reason: collision with root package name */
    private byte f23956k;
    private int l;

    /* compiled from: ProtoBuf.java */
    /* loaded from: classes3.dex */
    static class a extends kotlin.reflect.jvm.internal.impl.protobuf.b<e> {
        a() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.q
        /* renamed from: m, reason: merged with bridge method [inline-methods] */
        public e b(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, f fVar) throws InvalidProtocolBufferException {
            return new e(eVar, fVar);
        }
    }

    /* compiled from: ProtoBuf.java */
    /* loaded from: classes3.dex */
    public static final class b extends h.b<e, b> implements p {

        /* renamed from: g, reason: collision with root package name */
        private int f23957g;

        /* renamed from: h, reason: collision with root package name */
        private List<f> f23958h = Collections.emptyList();

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
            if ((this.f23957g & 1) != 1) {
                this.f23958h = new ArrayList(this.f23958h);
                this.f23957g |= 1;
            }
        }

        private void u() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.o.a
        /* renamed from: p, reason: merged with bridge method [inline-methods] */
        public e c() {
            e q = q();
            if (q.isInitialized()) {
                return q;
            }
            throw a.AbstractC0413a.j(q);
        }

        public e q() {
            e eVar = new e(this);
            if ((this.f23957g & 1) == 1) {
                this.f23958h = Collections.unmodifiableList(this.f23958h);
                this.f23957g &= -2;
            }
            eVar.f23955j = this.f23958h;
            return eVar;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h.b
        /* renamed from: r, reason: merged with bridge method [inline-methods] */
        public b k() {
            return s().m(q());
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h.b
        /* renamed from: v, reason: merged with bridge method [inline-methods] */
        public b m(e eVar) {
            if (eVar == e.u()) {
                return this;
            }
            if (!eVar.f23955j.isEmpty()) {
                if (this.f23958h.isEmpty()) {
                    this.f23958h = eVar.f23955j;
                    this.f23957g &= -2;
                } else {
                    t();
                    this.f23958h.addAll(eVar.f23955j);
                }
            }
            n(l().f(eVar.f23954i));
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:17:0x001d  */
        @Override // kotlin.reflect.jvm.internal.impl.protobuf.a.AbstractC0413a
        /* renamed from: w, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public b i(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, f fVar) throws IOException {
            e eVar2 = null;
            try {
                try {
                    e b2 = e.f23953h.b(eVar, fVar);
                    if (b2 != null) {
                        m(b2);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e2) {
                    e eVar3 = (e) e2.a();
                    try {
                        throw e2;
                    } catch (Throwable th) {
                        th = th;
                        eVar2 = eVar3;
                        if (eVar2 != null) {
                            m(eVar2);
                        }
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                if (eVar2 != null) {
                }
                throw th;
            }
        }
    }

    static {
        e eVar = new e(true);
        f23952g = eVar;
        eVar.x();
    }

    public static e u() {
        return f23952g;
    }

    private void x() {
        this.f23955j = Collections.emptyList();
    }

    public static b y() {
        return b.o();
    }

    public static b z(e eVar) {
        return y().m(eVar);
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
        for (int i4 = 0; i4 < this.f23955j.size(); i4++) {
            i3 += CodedOutputStream.s(1, this.f23955j.get(i4));
        }
        int size = i3 + this.f23954i.size();
        this.l = size;
        return size;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.h, kotlin.reflect.jvm.internal.impl.protobuf.o
    public q<e> g() {
        return f23953h;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.o
    public void h(CodedOutputStream codedOutputStream) throws IOException {
        e();
        for (int i2 = 0; i2 < this.f23955j.size(); i2++) {
            codedOutputStream.d0(1, this.f23955j.get(i2));
        }
        codedOutputStream.i0(this.f23954i);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.p
    public final boolean isInitialized() {
        byte b2 = this.f23956k;
        if (b2 == 1) {
            return true;
        }
        if (b2 == 0) {
            return false;
        }
        for (int i2 = 0; i2 < w(); i2++) {
            if (!v(i2).isInitialized()) {
                this.f23956k = (byte) 0;
                return false;
            }
        }
        this.f23956k = (byte) 1;
        return true;
    }

    public f v(int i2) {
        return this.f23955j.get(i2);
    }

    public int w() {
        return this.f23955j.size();
    }

    private e(h.b bVar) {
        super(bVar);
        this.f23956k = (byte) -1;
        this.l = -1;
        this.f23954i = bVar.l();
    }

    private e(boolean z) {
        this.f23956k = (byte) -1;
        this.l = -1;
        this.f23954i = d.f25399f;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private e(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, f fVar) throws InvalidProtocolBufferException {
        this.f23956k = (byte) -1;
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
                                this.f23955j = new ArrayList();
                                z2 |= true;
                            }
                            this.f23955j.add(eVar.u(f.f23960h, fVar));
                        }
                    }
                    z = true;
                } catch (Throwable th) {
                    if (z2 & true) {
                        this.f23955j = Collections.unmodifiableList(this.f23955j);
                    }
                    try {
                        J.I();
                    } catch (IOException unused) {
                    } catch (Throwable th2) {
                        this.f23954i = w.e();
                        throw th2;
                    }
                    this.f23954i = w.e();
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
            this.f23955j = Collections.unmodifiableList(this.f23955j);
        }
        try {
            J.I();
        } catch (IOException unused2) {
        } catch (Throwable th3) {
            this.f23954i = w.e();
            throw th3;
        }
        this.f23954i = w.e();
        m();
    }
}
