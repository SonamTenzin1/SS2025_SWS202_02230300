package kotlin.reflect.jvm.internal.impl.protobuf;

import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.reflect.jvm.internal.impl.protobuf.a;
import kotlin.reflect.jvm.internal.impl.protobuf.g;
import kotlin.reflect.jvm.internal.impl.protobuf.i;
import kotlin.reflect.jvm.internal.impl.protobuf.o;
import kotlin.reflect.jvm.internal.impl.protobuf.w;

/* compiled from: GeneratedMessageLite.java */
/* loaded from: classes3.dex */
public abstract class h extends kotlin.reflect.jvm.internal.impl.protobuf.a implements Serializable {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: GeneratedMessageLite.java */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[w.c.values().length];
            a = iArr;
            try {
                iArr[w.c.MESSAGE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[w.c.ENUM.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* compiled from: GeneratedMessageLite.java */
    /* loaded from: classes3.dex */
    public static abstract class b<MessageType extends h, BuilderType extends b> extends a.AbstractC0413a<BuilderType> {

        /* renamed from: f, reason: collision with root package name */
        private kotlin.reflect.jvm.internal.impl.protobuf.d f25422f = kotlin.reflect.jvm.internal.impl.protobuf.d.f25399f;

        @Override // 
        public BuilderType k() {
            throw new UnsupportedOperationException("This is supposed to be overridden by subclasses.");
        }

        public final kotlin.reflect.jvm.internal.impl.protobuf.d l() {
            return this.f25422f;
        }

        public abstract BuilderType m(MessageType messagetype);

        public final BuilderType n(kotlin.reflect.jvm.internal.impl.protobuf.d dVar) {
            this.f25422f = dVar;
            return this;
        }
    }

    /* compiled from: GeneratedMessageLite.java */
    /* loaded from: classes3.dex */
    public static abstract class c<MessageType extends d<MessageType>, BuilderType extends c<MessageType, BuilderType>> extends b<MessageType, BuilderType> implements p {

        /* renamed from: g, reason: collision with root package name */
        private g<e> f25423g = g.g();

        /* renamed from: h, reason: collision with root package name */
        private boolean f25424h;

        /* JADX INFO: Access modifiers changed from: private */
        public g<e> p() {
            this.f25423g.q();
            this.f25424h = false;
            return this.f25423g;
        }

        private void q() {
            if (this.f25424h) {
                return;
            }
            this.f25423g = this.f25423g.clone();
            this.f25424h = true;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public final void r(MessageType messagetype) {
            q();
            this.f25423g.r(((d) messagetype).f25425g);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: GeneratedMessageLite.java */
    /* loaded from: classes3.dex */
    public static final class e implements g.b<e> {

        /* renamed from: f, reason: collision with root package name */
        final i.b<?> f25429f;

        /* renamed from: g, reason: collision with root package name */
        final int f25430g;

        /* renamed from: h, reason: collision with root package name */
        final w.b f25431h;

        /* renamed from: i, reason: collision with root package name */
        final boolean f25432i;

        /* renamed from: j, reason: collision with root package name */
        final boolean f25433j;

        e(i.b<?> bVar, int i2, w.b bVar2, boolean z, boolean z2) {
            this.f25429f = bVar;
            this.f25430g = i2;
            this.f25431h = bVar2;
            this.f25432i = z;
            this.f25433j = z2;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.g.b
        public int f() {
            return this.f25430g;
        }

        @Override // java.lang.Comparable
        /* renamed from: g, reason: merged with bridge method [inline-methods] */
        public int compareTo(e eVar) {
            return this.f25430g - eVar.f25430g;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.g.b
        public boolean h() {
            return this.f25432i;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.g.b
        public w.b j() {
            return this.f25431h;
        }

        public i.b<?> k() {
            return this.f25429f;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.g.b
        public w.c l() {
            return this.f25431h.g();
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.g.b
        public boolean m() {
            return this.f25433j;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.g.b
        public o.a n(o.a aVar, o oVar) {
            return ((b) aVar).m((h) oVar);
        }
    }

    /* compiled from: GeneratedMessageLite.java */
    /* loaded from: classes3.dex */
    public static class f<ContainingType extends o, Type> {
        final ContainingType a;

        /* renamed from: b, reason: collision with root package name */
        final Type f25434b;

        /* renamed from: c, reason: collision with root package name */
        final o f25435c;

        /* renamed from: d, reason: collision with root package name */
        final e f25436d;

        /* renamed from: e, reason: collision with root package name */
        final Class f25437e;

        /* renamed from: f, reason: collision with root package name */
        final Method f25438f;

        f(ContainingType containingtype, Type type, o oVar, e eVar, Class cls) {
            if (containingtype != null) {
                if (eVar.j() == w.b.p && oVar == null) {
                    throw new IllegalArgumentException("Null messageDefaultInstance");
                }
                this.a = containingtype;
                this.f25434b = type;
                this.f25435c = oVar;
                this.f25436d = eVar;
                this.f25437e = cls;
                if (i.a.class.isAssignableFrom(cls)) {
                    this.f25438f = h.k(cls, "valueOf", Integer.TYPE);
                    return;
                } else {
                    this.f25438f = null;
                    return;
                }
            }
            throw new IllegalArgumentException("Null containingTypeDefaultInstance");
        }

        Object a(Object obj) {
            if (this.f25436d.h()) {
                if (this.f25436d.l() != w.c.ENUM) {
                    return obj;
                }
                ArrayList arrayList = new ArrayList();
                Iterator it = ((List) obj).iterator();
                while (it.hasNext()) {
                    arrayList.add(e(it.next()));
                }
                return arrayList;
            }
            return e(obj);
        }

        public ContainingType b() {
            return this.a;
        }

        public o c() {
            return this.f25435c;
        }

        public int d() {
            return this.f25436d.f();
        }

        Object e(Object obj) {
            return this.f25436d.l() == w.c.ENUM ? h.l(this.f25438f, null, (Integer) obj) : obj;
        }

        Object f(Object obj) {
            return this.f25436d.l() == w.c.ENUM ? Integer.valueOf(((i.a) obj).f()) : obj;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public h() {
    }

    static Method k(Class cls, String str, Class... clsArr) {
        try {
            return cls.getMethod(str, clsArr);
        } catch (NoSuchMethodException e2) {
            String name = cls.getName();
            String valueOf = String.valueOf(str);
            StringBuilder sb = new StringBuilder(name.length() + 45 + valueOf.length());
            sb.append("Generated message class \"");
            sb.append(name);
            sb.append("\" missing method \"");
            sb.append(valueOf);
            sb.append("\".");
            throw new RuntimeException(sb.toString(), e2);
        }
    }

    static Object l(Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e2) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e2);
        } catch (InvocationTargetException e3) {
            Throwable cause = e3.getCause();
            if (!(cause instanceof RuntimeException)) {
                if (cause instanceof Error) {
                    throw ((Error) cause);
                }
                throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
            }
            throw ((RuntimeException) cause);
        }
    }

    public static <ContainingType extends o, Type> f<ContainingType, Type> n(ContainingType containingtype, o oVar, i.b<?> bVar, int i2, w.b bVar2, boolean z, Class cls) {
        return new f<>(containingtype, Collections.emptyList(), oVar, new e(bVar, i2, bVar2, true, z), cls);
    }

    public static <ContainingType extends o, Type> f<ContainingType, Type> o(ContainingType containingtype, Type type, o oVar, i.b<?> bVar, int i2, w.b bVar2, Class cls) {
        return new f<>(containingtype, type, oVar, new e(bVar, i2, bVar2, false, false), cls);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:6:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0044  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static <MessageType extends o> boolean q(g<e> gVar, MessageType messagetype, kotlin.reflect.jvm.internal.impl.protobuf.e eVar, CodedOutputStream codedOutputStream, kotlin.reflect.jvm.internal.impl.protobuf.f fVar, int i2) throws IOException {
        boolean z;
        boolean z2;
        Object c2;
        o oVar;
        int b2 = w.b(i2);
        f b3 = fVar.b(messagetype, w.a(i2));
        if (b3 != null) {
            if (b2 == g.l(b3.f25436d.j(), false)) {
                z = false;
                z2 = false;
                if (z) {
                    return eVar.P(i2, codedOutputStream);
                }
                if (z2) {
                    int j2 = eVar.j(eVar.A());
                    if (b3.f25436d.j() == w.b.s) {
                        while (eVar.e() > 0) {
                            Object a2 = b3.f25436d.k().a(eVar.n());
                            if (a2 == null) {
                                return true;
                            }
                            gVar.a(b3.f25436d, b3.f(a2));
                        }
                    } else {
                        while (eVar.e() > 0) {
                            gVar.a(b3.f25436d, g.u(eVar, b3.f25436d.j(), false));
                        }
                    }
                    eVar.i(j2);
                } else {
                    int i3 = a.a[b3.f25436d.l().ordinal()];
                    if (i3 == 1) {
                        o.a aVar = null;
                        if (!b3.f25436d.h() && (oVar = (o) gVar.h(b3.f25436d)) != null) {
                            aVar = oVar.d();
                        }
                        if (aVar == null) {
                            aVar = b3.c().f();
                        }
                        if (b3.f25436d.j() == w.b.o) {
                            eVar.r(b3.d(), aVar, fVar);
                        } else {
                            eVar.v(aVar, fVar);
                        }
                        c2 = aVar.c();
                    } else if (i3 != 2) {
                        c2 = g.u(eVar, b3.f25436d.j(), false);
                    } else {
                        int n = eVar.n();
                        Object a3 = b3.f25436d.k().a(n);
                        if (a3 == null) {
                            codedOutputStream.o0(i2);
                            codedOutputStream.y0(n);
                            return true;
                        }
                        c2 = a3;
                    }
                    if (b3.f25436d.h()) {
                        gVar.a(b3.f25436d, b3.f(c2));
                    } else {
                        gVar.v(b3.f25436d, b3.f(c2));
                    }
                }
                return true;
            }
            e eVar2 = b3.f25436d;
            if (eVar2.f25432i && eVar2.f25431h.q() && b2 == g.l(b3.f25436d.j(), true)) {
                z = false;
                z2 = true;
                if (z) {
                }
            }
        }
        z = true;
        z2 = false;
        if (z) {
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.o
    public q<? extends o> g() {
        throw new UnsupportedOperationException("This is supposed to be overridden by subclasses.");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void m() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean p(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, CodedOutputStream codedOutputStream, kotlin.reflect.jvm.internal.impl.protobuf.f fVar, int i2) throws IOException {
        return eVar.P(i2, codedOutputStream);
    }

    /* compiled from: GeneratedMessageLite.java */
    /* loaded from: classes3.dex */
    public static abstract class d<MessageType extends d<MessageType>> extends h implements p {

        /* renamed from: g, reason: collision with root package name */
        private final g<e> f25425g;

        /* JADX INFO: Access modifiers changed from: protected */
        /* compiled from: GeneratedMessageLite.java */
        /* loaded from: classes3.dex */
        public class a {
            private final Iterator<Map.Entry<e, Object>> a;

            /* renamed from: b, reason: collision with root package name */
            private Map.Entry<e, Object> f25426b;

            /* renamed from: c, reason: collision with root package name */
            private final boolean f25427c;

            /* synthetic */ a(d dVar, boolean z, a aVar) {
                this(z);
            }

            public void a(int i2, CodedOutputStream codedOutputStream) throws IOException {
                while (true) {
                    Map.Entry<e, Object> entry = this.f25426b;
                    if (entry == null || entry.getKey().f() >= i2) {
                        return;
                    }
                    e key = this.f25426b.getKey();
                    if (this.f25427c && key.l() == w.c.MESSAGE && !key.h()) {
                        codedOutputStream.f0(key.f(), (o) this.f25426b.getValue());
                    } else {
                        g.z(key, this.f25426b.getValue(), codedOutputStream);
                    }
                    if (this.a.hasNext()) {
                        this.f25426b = this.a.next();
                    } else {
                        this.f25426b = null;
                    }
                }
            }

            private a(boolean z) {
                Iterator<Map.Entry<e, Object>> p = d.this.f25425g.p();
                this.a = p;
                if (p.hasNext()) {
                    this.f25426b = p.next();
                }
                this.f25427c = z;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public d() {
            this.f25425g = g.t();
        }

        private void z(f<MessageType, ?> fVar) {
            if (fVar.b() != b()) {
                throw new IllegalArgumentException("This extension is for a different message type.  Please make sure that you are not suppressing any generics type warnings.");
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
        public void m() {
            this.f25425g.q();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // kotlin.reflect.jvm.internal.impl.protobuf.h
        public boolean p(kotlin.reflect.jvm.internal.impl.protobuf.e eVar, CodedOutputStream codedOutputStream, kotlin.reflect.jvm.internal.impl.protobuf.f fVar, int i2) throws IOException {
            return h.q(this.f25425g, b(), eVar, codedOutputStream, fVar, i2);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public boolean s() {
            return this.f25425g.n();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public int t() {
            return this.f25425g.k();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final <Type> Type u(f<MessageType, Type> fVar) {
            z(fVar);
            Object h2 = this.f25425g.h(fVar.f25436d);
            if (h2 == null) {
                return fVar.f25434b;
            }
            return (Type) fVar.a(h2);
        }

        public final <Type> Type v(f<MessageType, List<Type>> fVar, int i2) {
            z(fVar);
            return (Type) fVar.e(this.f25425g.i(fVar.f25436d, i2));
        }

        public final <Type> int w(f<MessageType, List<Type>> fVar) {
            z(fVar);
            return this.f25425g.j(fVar.f25436d);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final <Type> boolean x(f<MessageType, Type> fVar) {
            z(fVar);
            return this.f25425g.m(fVar.f25436d);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public d<MessageType>.a y() {
            return new a(this, false, null);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public d(c<MessageType, ?> cVar) {
            this.f25425g = cVar.p();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public h(b bVar) {
    }
}
