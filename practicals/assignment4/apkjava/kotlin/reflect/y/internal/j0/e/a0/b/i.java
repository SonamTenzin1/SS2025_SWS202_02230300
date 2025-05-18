package kotlin.reflect.y.internal.j0.e.a0.b;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.c0;
import kotlin.collections.v;
import kotlin.jvm.internal.m;
import kotlin.reflect.jvm.internal.impl.protobuf.f;
import kotlin.reflect.jvm.internal.impl.protobuf.h;
import kotlin.reflect.y.internal.j0.e.a0.a;
import kotlin.reflect.y.internal.j0.e.a0.b.d;
import kotlin.reflect.y.internal.j0.e.l;
import kotlin.reflect.y.internal.j0.e.n;
import kotlin.reflect.y.internal.j0.e.q;
import kotlin.reflect.y.internal.j0.e.u;
import kotlin.reflect.y.internal.j0.e.z.b;
import kotlin.reflect.y.internal.j0.e.z.c;
import kotlin.reflect.y.internal.j0.e.z.e;
import kotlin.reflect.y.internal.j0.e.z.g;
import okhttp3.HttpUrl;

/* compiled from: JvmProtoBufUtil.kt */
/* loaded from: classes3.dex */
public final class i {
    public static final i a = new i();

    /* renamed from: b */
    private static final f f23899b;

    static {
        f d2 = f.d();
        a.a(d2);
        m.e(d2, "newInstance().apply(JvmP…f::registerAllExtensions)");
        f23899b = d2;
    }

    private i() {
    }

    public static /* synthetic */ d.a d(i iVar, n nVar, c cVar, g gVar, boolean z, int i2, Object obj) {
        if ((i2 & 8) != 0) {
            z = true;
        }
        return iVar.c(nVar, cVar, gVar, z);
    }

    public static final boolean f(n nVar) {
        m.f(nVar, "proto");
        b.C0370b a2 = c.a.a();
        Object u = nVar.u(a.f23824e);
        m.e(u, "proto.getExtension(JvmProtoBuf.flags)");
        Boolean d2 = a2.d(((Number) u).intValue());
        m.e(d2, "JvmFlags.IS_MOVED_FROM_I…nsion(JvmProtoBuf.flags))");
        return d2.booleanValue();
    }

    private final String g(q qVar, c cVar) {
        if (qVar.m0()) {
            return b.b(cVar.a(qVar.X()));
        }
        return null;
    }

    public static final Pair<f, kotlin.reflect.y.internal.j0.e.c> h(byte[] bArr, String[] strArr) {
        m.f(bArr, "bytes");
        m.f(strArr, "strings");
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        return new Pair<>(a.k(byteArrayInputStream, strArr), kotlin.reflect.y.internal.j0.e.c.x1(byteArrayInputStream, f23899b));
    }

    public static final Pair<f, kotlin.reflect.y.internal.j0.e.c> i(String[] strArr, String[] strArr2) {
        m.f(strArr, "data");
        m.f(strArr2, "strings");
        byte[] e2 = a.e(strArr);
        m.e(e2, "decodeBytes(data)");
        return h(e2, strArr2);
    }

    public static final Pair<f, kotlin.reflect.y.internal.j0.e.i> j(String[] strArr, String[] strArr2) {
        m.f(strArr, "data");
        m.f(strArr2, "strings");
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(a.e(strArr));
        return new Pair<>(a.k(byteArrayInputStream, strArr2), kotlin.reflect.y.internal.j0.e.i.F0(byteArrayInputStream, f23899b));
    }

    private final f k(InputStream inputStream, String[] strArr) {
        a.e D = a.e.D(inputStream, f23899b);
        m.e(D, "parseDelimitedFrom(this, EXTENSION_REGISTRY)");
        return new f(D, strArr);
    }

    public static final Pair<f, l> l(byte[] bArr, String[] strArr) {
        m.f(bArr, "bytes");
        m.f(strArr, "strings");
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        return new Pair<>(a.k(byteArrayInputStream, strArr), l.e0(byteArrayInputStream, f23899b));
    }

    public static final Pair<f, l> m(String[] strArr, String[] strArr2) {
        m.f(strArr, "data");
        m.f(strArr2, "strings");
        byte[] e2 = a.e(strArr);
        m.e(e2, "decodeBytes(data)");
        return l(e2, strArr2);
    }

    public final f a() {
        return f23899b;
    }

    public final d.b b(kotlin.reflect.y.internal.j0.e.d dVar, c cVar, g gVar) {
        int u;
        String e0;
        m.f(dVar, "proto");
        m.f(cVar, "nameResolver");
        m.f(gVar, "typeTable");
        h.f<kotlin.reflect.y.internal.j0.e.d, a.c> fVar = a.a;
        m.e(fVar, "constructorSignature");
        a.c cVar2 = (a.c) e.a(dVar, fVar);
        String string = (cVar2 == null || !cVar2.z()) ? "<init>" : cVar.getString(cVar2.x());
        if (cVar2 != null && cVar2.y()) {
            e0 = cVar.getString(cVar2.w());
        } else {
            List<u> M = dVar.M();
            m.e(M, "proto.valueParameterList");
            u = v.u(M, 10);
            ArrayList arrayList = new ArrayList(u);
            for (u uVar : M) {
                i iVar = a;
                m.e(uVar, "it");
                String g2 = iVar.g(kotlin.reflect.y.internal.j0.e.z.f.n(uVar, gVar), cVar);
                if (g2 == null) {
                    return null;
                }
                arrayList.add(g2);
            }
            e0 = c0.e0(arrayList, HttpUrl.FRAGMENT_ENCODE_SET, "(", ")V", 0, null, null, 56, null);
        }
        return new d.b(string, e0);
    }

    public final d.a c(n nVar, c cVar, g gVar, boolean z) {
        String g2;
        m.f(nVar, "proto");
        m.f(cVar, "nameResolver");
        m.f(gVar, "typeTable");
        h.f<n, a.d> fVar = a.f23823d;
        m.e(fVar, "propertySignature");
        a.d dVar = (a.d) e.a(nVar, fVar);
        if (dVar == null) {
            return null;
        }
        a.b A = dVar.F() ? dVar.A() : null;
        if (A == null && z) {
            return null;
        }
        int d0 = (A == null || !A.z()) ? nVar.d0() : A.x();
        if (A == null || !A.y()) {
            g2 = g(kotlin.reflect.y.internal.j0.e.z.f.k(nVar, gVar), cVar);
            if (g2 == null) {
                return null;
            }
        } else {
            g2 = cVar.getString(A.w());
        }
        return new d.a(cVar.getString(d0), g2);
    }

    public final d.b e(kotlin.reflect.y.internal.j0.e.i iVar, c cVar, g gVar) {
        List n;
        int u;
        List o0;
        int u2;
        String e0;
        String sb;
        m.f(iVar, "proto");
        m.f(cVar, "nameResolver");
        m.f(gVar, "typeTable");
        h.f<kotlin.reflect.y.internal.j0.e.i, a.c> fVar = a.f23821b;
        m.e(fVar, "methodSignature");
        a.c cVar2 = (a.c) e.a(iVar, fVar);
        int e02 = (cVar2 == null || !cVar2.z()) ? iVar.e0() : cVar2.x();
        if (cVar2 != null && cVar2.y()) {
            sb = cVar.getString(cVar2.w());
        } else {
            n = kotlin.collections.u.n(kotlin.reflect.y.internal.j0.e.z.f.h(iVar, gVar));
            List<u> q0 = iVar.q0();
            m.e(q0, "proto.valueParameterList");
            u = v.u(q0, 10);
            ArrayList arrayList = new ArrayList(u);
            for (u uVar : q0) {
                m.e(uVar, "it");
                arrayList.add(kotlin.reflect.y.internal.j0.e.z.f.n(uVar, gVar));
            }
            o0 = c0.o0(n, arrayList);
            u2 = v.u(o0, 10);
            ArrayList arrayList2 = new ArrayList(u2);
            Iterator it = o0.iterator();
            while (it.hasNext()) {
                String g2 = a.g((q) it.next(), cVar);
                if (g2 == null) {
                    return null;
                }
                arrayList2.add(g2);
            }
            String g3 = g(kotlin.reflect.y.internal.j0.e.z.f.j(iVar, gVar), cVar);
            if (g3 == null) {
                return null;
            }
            StringBuilder sb2 = new StringBuilder();
            e0 = c0.e0(arrayList2, HttpUrl.FRAGMENT_ENCODE_SET, "(", ")", 0, null, null, 56, null);
            sb2.append(e0);
            sb2.append(g3);
            sb = sb2.toString();
        }
        return new d.b(cVar.getString(e02), sb);
    }
}
