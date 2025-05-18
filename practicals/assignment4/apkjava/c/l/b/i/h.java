package c.l.b.i;

import androidx.datastore.core.CorruptionException;
import androidx.datastore.core.j;
import c.l.b.f;
import c.l.b.h;
import c.l.b.i.d;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.c0;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.m;
import kotlin.u;

/* compiled from: PreferencesSerializer.kt */
/* loaded from: classes.dex */
public final class h implements j<d> {
    public static final h a = new h();

    /* renamed from: b, reason: collision with root package name */
    private static final String f3336b = "preferences_pb";

    /* compiled from: PreferencesSerializer.kt */
    /* loaded from: classes.dex */
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[h.b.values().length];
            iArr[h.b.BOOLEAN.ordinal()] = 1;
            iArr[h.b.FLOAT.ordinal()] = 2;
            iArr[h.b.DOUBLE.ordinal()] = 3;
            iArr[h.b.INTEGER.ordinal()] = 4;
            iArr[h.b.LONG.ordinal()] = 5;
            iArr[h.b.STRING.ordinal()] = 6;
            iArr[h.b.STRING_SET.ordinal()] = 7;
            iArr[h.b.VALUE_NOT_SET.ordinal()] = 8;
            a = iArr;
        }
    }

    private h() {
    }

    private final void d(String str, c.l.b.h hVar, c.l.b.i.a aVar) {
        Set I0;
        h.b Z = hVar.Z();
        switch (Z == null ? -1 : a.a[Z.ordinal()]) {
            case -1:
                throw new CorruptionException("Value case is null.", null, 2, null);
            case 0:
            default:
                throw new NoWhenBranchMatchedException();
            case 1:
                aVar.i(f.a(str), Boolean.valueOf(hVar.R()));
                return;
            case 2:
                aVar.i(f.c(str), Float.valueOf(hVar.U()));
                return;
            case 3:
                aVar.i(f.b(str), Double.valueOf(hVar.T()));
                return;
            case 4:
                aVar.i(f.d(str), Integer.valueOf(hVar.V()));
                return;
            case 5:
                aVar.i(f.e(str), Long.valueOf(hVar.W()));
                return;
            case 6:
                d.a<String> f2 = f.f(str);
                String X = hVar.X();
                m.e(X, "value.string");
                aVar.i(f2, X);
                return;
            case 7:
                d.a<Set<String>> g2 = f.g(str);
                List<String> O = hVar.Y().O();
                m.e(O, "value.stringSet.stringsList");
                I0 = c0.I0(O);
                aVar.i(g2, I0);
                return;
            case 8:
                throw new CorruptionException("Value not set.", null, 2, null);
        }
    }

    private final c.l.b.h g(Object obj) {
        if (obj instanceof Boolean) {
            c.l.b.h c2 = c.l.b.h.a0().w(((Boolean) obj).booleanValue()).c();
            m.e(c2, "newBuilder().setBoolean(value).build()");
            return c2;
        }
        if (obj instanceof Float) {
            c.l.b.h c3 = c.l.b.h.a0().B(((Number) obj).floatValue()).c();
            m.e(c3, "newBuilder().setFloat(value).build()");
            return c3;
        }
        if (obj instanceof Double) {
            c.l.b.h c4 = c.l.b.h.a0().A(((Number) obj).doubleValue()).c();
            m.e(c4, "newBuilder().setDouble(value).build()");
            return c4;
        }
        if (obj instanceof Integer) {
            c.l.b.h c5 = c.l.b.h.a0().C(((Number) obj).intValue()).c();
            m.e(c5, "newBuilder().setInteger(value).build()");
            return c5;
        }
        if (obj instanceof Long) {
            c.l.b.h c6 = c.l.b.h.a0().D(((Number) obj).longValue()).c();
            m.e(c6, "newBuilder().setLong(value).build()");
            return c6;
        }
        if (obj instanceof String) {
            c.l.b.h c7 = c.l.b.h.a0().E((String) obj).c();
            m.e(c7, "newBuilder().setString(value).build()");
            return c7;
        }
        if (obj instanceof Set) {
            c.l.b.h c8 = c.l.b.h.a0().F(c.l.b.g.P().w((Set) obj)).c();
            m.e(c8, "newBuilder().setStringSet(\n                    StringSet.newBuilder().addAllStrings(value as Set<String>)\n                ).build()");
            return c8;
        }
        throw new IllegalStateException(m.n("PreferencesSerializer does not support type: ", obj.getClass().getName()));
    }

    @Override // androidx.datastore.core.j
    public Object c(InputStream inputStream, Continuation<? super d> continuation) throws IOException, CorruptionException {
        c.l.b.f a2 = c.l.b.d.a.a(inputStream);
        c.l.b.i.a b2 = e.b(new d.b[0]);
        Map<String, c.l.b.h> M = a2.M();
        m.e(M, "preferencesProto.preferencesMap");
        for (Map.Entry<String, c.l.b.h> entry : M.entrySet()) {
            String key = entry.getKey();
            c.l.b.h value = entry.getValue();
            h hVar = a;
            m.e(key, "name");
            m.e(value, "value");
            hVar.d(key, value, b2);
        }
        return b2.d();
    }

    @Override // androidx.datastore.core.j
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public d a() {
        return e.a();
    }

    public final String f() {
        return f3336b;
    }

    @Override // androidx.datastore.core.j
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public Object b(d dVar, OutputStream outputStream, Continuation<? super u> continuation) throws IOException, CorruptionException {
        Map<d.a<?>, Object> a2 = dVar.a();
        f.a P = c.l.b.f.P();
        for (Map.Entry<d.a<?>, Object> entry : a2.entrySet()) {
            P.w(entry.getKey().a(), g(entry.getValue()));
        }
        P.c().o(outputStream);
        return u.a;
    }
}
