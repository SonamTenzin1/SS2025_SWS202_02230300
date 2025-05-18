package kotlin.reflect.jvm.internal.impl.protobuf;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.reflect.jvm.internal.impl.protobuf.g.b;
import kotlin.reflect.jvm.internal.impl.protobuf.i;
import kotlin.reflect.jvm.internal.impl.protobuf.j;
import kotlin.reflect.jvm.internal.impl.protobuf.o;
import kotlin.reflect.jvm.internal.impl.protobuf.w;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FieldSet.java */
/* loaded from: classes3.dex */
public final class g<FieldDescriptorType extends b<FieldDescriptorType>> {
    private static final g a = new g(true);

    /* renamed from: c, reason: collision with root package name */
    private boolean f25419c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f25420d = false;

    /* renamed from: b, reason: collision with root package name */
    private final t<FieldDescriptorType, Object> f25418b = t.o(16);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FieldSet.java */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        /* renamed from: b, reason: collision with root package name */
        static final /* synthetic */ int[] f25421b;

        static {
            int[] iArr = new int[w.b.values().length];
            f25421b = iArr;
            try {
                iArr[w.b.f25493f.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f25421b[w.b.f25494g.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f25421b[w.b.f25495h.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f25421b[w.b.f25496i.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f25421b[w.b.f25497j.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f25421b[w.b.f25498k.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f25421b[w.b.l.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f25421b[w.b.m.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f25421b[w.b.n.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f25421b[w.b.q.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f25421b[w.b.r.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f25421b[w.b.t.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f25421b[w.b.u.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f25421b[w.b.v.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f25421b[w.b.w.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f25421b[w.b.o.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                f25421b[w.b.p.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                f25421b[w.b.s.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            int[] iArr2 = new int[w.c.values().length];
            a = iArr2;
            try {
                iArr2[w.c.INT.ordinal()] = 1;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                a[w.c.LONG.ordinal()] = 2;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                a[w.c.FLOAT.ordinal()] = 3;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                a[w.c.DOUBLE.ordinal()] = 4;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                a[w.c.BOOLEAN.ordinal()] = 5;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                a[w.c.STRING.ordinal()] = 6;
            } catch (NoSuchFieldError unused24) {
            }
            try {
                a[w.c.BYTE_STRING.ordinal()] = 7;
            } catch (NoSuchFieldError unused25) {
            }
            try {
                a[w.c.ENUM.ordinal()] = 8;
            } catch (NoSuchFieldError unused26) {
            }
            try {
                a[w.c.MESSAGE.ordinal()] = 9;
            } catch (NoSuchFieldError unused27) {
            }
        }
    }

    /* compiled from: FieldSet.java */
    /* loaded from: classes3.dex */
    public interface b<T extends b<T>> extends Comparable<T> {
        int f();

        boolean h();

        w.b j();

        w.c l();

        boolean m();

        o.a n(o.a aVar, o oVar);
    }

    private g() {
    }

    private Object c(Object obj) {
        if (!(obj instanceof byte[])) {
            return obj;
        }
        byte[] bArr = (byte[]) obj;
        byte[] bArr2 = new byte[bArr.length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        return bArr2;
    }

    private static int d(w.b bVar, int i2, Object obj) {
        int D = CodedOutputStream.D(i2);
        if (bVar == w.b.o) {
            D *= 2;
        }
        return D + e(bVar, obj);
    }

    private static int e(w.b bVar, Object obj) {
        switch (a.f25421b[bVar.ordinal()]) {
            case 1:
                return CodedOutputStream.g(((Double) obj).doubleValue());
            case 2:
                return CodedOutputStream.m(((Float) obj).floatValue());
            case 3:
                return CodedOutputStream.q(((Long) obj).longValue());
            case 4:
                return CodedOutputStream.F(((Long) obj).longValue());
            case 5:
                return CodedOutputStream.p(((Integer) obj).intValue());
            case 6:
                return CodedOutputStream.k(((Long) obj).longValue());
            case 7:
                return CodedOutputStream.j(((Integer) obj).intValue());
            case 8:
                return CodedOutputStream.b(((Boolean) obj).booleanValue());
            case 9:
                return CodedOutputStream.C((String) obj);
            case 10:
                if (obj instanceof d) {
                    return CodedOutputStream.e((d) obj);
                }
                return CodedOutputStream.c((byte[]) obj);
            case 11:
                return CodedOutputStream.E(((Integer) obj).intValue());
            case 12:
                return CodedOutputStream.x(((Integer) obj).intValue());
            case 13:
                return CodedOutputStream.y(((Long) obj).longValue());
            case 14:
                return CodedOutputStream.z(((Integer) obj).intValue());
            case 15:
                return CodedOutputStream.B(((Long) obj).longValue());
            case 16:
                return CodedOutputStream.n((o) obj);
            case 17:
                if (obj instanceof j) {
                    return CodedOutputStream.r((j) obj);
                }
                return CodedOutputStream.t((o) obj);
            case 18:
                if (obj instanceof i.a) {
                    return CodedOutputStream.i(((i.a) obj).f());
                }
                return CodedOutputStream.i(((Integer) obj).intValue());
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    public static int f(b<?> bVar, Object obj) {
        w.b j2 = bVar.j();
        int f2 = bVar.f();
        if (bVar.h()) {
            int i2 = 0;
            if (bVar.m()) {
                Iterator it = ((List) obj).iterator();
                while (it.hasNext()) {
                    i2 += e(j2, it.next());
                }
                return CodedOutputStream.D(f2) + i2 + CodedOutputStream.v(i2);
            }
            Iterator it2 = ((List) obj).iterator();
            while (it2.hasNext()) {
                i2 += d(j2, f2, it2.next());
            }
            return i2;
        }
        return d(j2, f2, obj);
    }

    public static <T extends b<T>> g<T> g() {
        return a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int l(w.b bVar, boolean z) {
        if (z) {
            return 2;
        }
        return bVar.k();
    }

    private boolean o(Map.Entry<FieldDescriptorType, Object> entry) {
        FieldDescriptorType key = entry.getKey();
        if (key.l() == w.c.MESSAGE) {
            if (key.h()) {
                Iterator it = ((List) entry.getValue()).iterator();
                while (it.hasNext()) {
                    if (!((o) it.next()).isInitialized()) {
                        return false;
                    }
                }
            } else {
                Object value = entry.getValue();
                if (value instanceof o) {
                    if (!((o) value).isInitialized()) {
                        return false;
                    }
                } else {
                    if (value instanceof j) {
                        return true;
                    }
                    throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
                }
            }
        }
        return true;
    }

    private void s(Map.Entry<FieldDescriptorType, Object> entry) {
        FieldDescriptorType key = entry.getKey();
        Object value = entry.getValue();
        if (value instanceof j) {
            value = ((j) value).e();
        }
        if (key.h()) {
            Object h2 = h(key);
            if (h2 == null) {
                h2 = new ArrayList();
            }
            Iterator it = ((List) value).iterator();
            while (it.hasNext()) {
                ((List) h2).add(c(it.next()));
            }
            this.f25418b.p(key, h2);
            return;
        }
        if (key.l() == w.c.MESSAGE) {
            Object h3 = h(key);
            if (h3 == null) {
                this.f25418b.p(key, c(value));
                return;
            } else {
                this.f25418b.p(key, key.n(((o) h3).d(), (o) value).c());
                return;
            }
        }
        this.f25418b.p(key, c(value));
    }

    public static <T extends b<T>> g<T> t() {
        return new g<>();
    }

    public static Object u(e eVar, w.b bVar, boolean z) throws IOException {
        switch (a.f25421b[bVar.ordinal()]) {
            case 1:
                return Double.valueOf(eVar.m());
            case 2:
                return Float.valueOf(eVar.q());
            case 3:
                return Long.valueOf(eVar.t());
            case 4:
                return Long.valueOf(eVar.M());
            case 5:
                return Integer.valueOf(eVar.s());
            case 6:
                return Long.valueOf(eVar.p());
            case 7:
                return Integer.valueOf(eVar.o());
            case 8:
                return Boolean.valueOf(eVar.k());
            case 9:
                if (z) {
                    return eVar.J();
                }
                return eVar.I();
            case 10:
                return eVar.l();
            case 11:
                return Integer.valueOf(eVar.L());
            case 12:
                return Integer.valueOf(eVar.E());
            case 13:
                return Long.valueOf(eVar.F());
            case 14:
                return Integer.valueOf(eVar.G());
            case 15:
                return Long.valueOf(eVar.H());
            case 16:
                throw new IllegalArgumentException("readPrimitiveField() cannot handle nested groups.");
            case 17:
                throw new IllegalArgumentException("readPrimitiveField() cannot handle embedded messages.");
            case 18:
                throw new IllegalArgumentException("readPrimitiveField() cannot handle enums.");
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0024, code lost:
    
        if ((r3 instanceof kotlin.reflect.jvm.internal.impl.protobuf.i.a) == false) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x002d, code lost:
    
        if ((r3 instanceof byte[]) == false) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x001b, code lost:
    
        if ((r3 instanceof kotlin.reflect.jvm.internal.impl.protobuf.j) == false) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0030, code lost:
    
        r0 = false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void w(w.b bVar, Object obj) {
        obj.getClass();
        boolean z = true;
        boolean z2 = false;
        switch (a.a[bVar.g().ordinal()]) {
            case 1:
                z2 = obj instanceof Integer;
                break;
            case 2:
                z2 = obj instanceof Long;
                break;
            case 3:
                z2 = obj instanceof Float;
                break;
            case 4:
                z2 = obj instanceof Double;
                break;
            case 5:
                z2 = obj instanceof Boolean;
                break;
            case 6:
                z2 = obj instanceof String;
                break;
            case 7:
                if (!(obj instanceof d)) {
                    break;
                }
                z2 = z;
                break;
            case 8:
                if (!(obj instanceof Integer)) {
                    break;
                }
                z2 = z;
                break;
            case 9:
                if (!(obj instanceof o)) {
                    break;
                }
                z2 = z;
                break;
        }
        if (!z2) {
            throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        }
    }

    private static void x(CodedOutputStream codedOutputStream, w.b bVar, int i2, Object obj) throws IOException {
        if (bVar == w.b.o) {
            codedOutputStream.Y(i2, (o) obj);
        } else {
            codedOutputStream.w0(i2, l(bVar, false));
            y(codedOutputStream, bVar, obj);
        }
    }

    private static void y(CodedOutputStream codedOutputStream, w.b bVar, Object obj) throws IOException {
        switch (a.f25421b[bVar.ordinal()]) {
            case 1:
                codedOutputStream.R(((Double) obj).doubleValue());
                return;
            case 2:
                codedOutputStream.X(((Float) obj).floatValue());
                return;
            case 3:
                codedOutputStream.c0(((Long) obj).longValue());
                return;
            case 4:
                codedOutputStream.z0(((Long) obj).longValue());
                return;
            case 5:
                codedOutputStream.b0(((Integer) obj).intValue());
                return;
            case 6:
                codedOutputStream.V(((Long) obj).longValue());
                return;
            case 7:
                codedOutputStream.U(((Integer) obj).intValue());
                return;
            case 8:
                codedOutputStream.M(((Boolean) obj).booleanValue());
                return;
            case 9:
                codedOutputStream.v0((String) obj);
                return;
            case 10:
                if (obj instanceof d) {
                    codedOutputStream.P((d) obj);
                    return;
                } else {
                    codedOutputStream.N((byte[]) obj);
                    return;
                }
            case 11:
                codedOutputStream.y0(((Integer) obj).intValue());
                return;
            case 12:
                codedOutputStream.q0(((Integer) obj).intValue());
                return;
            case 13:
                codedOutputStream.r0(((Long) obj).longValue());
                return;
            case 14:
                codedOutputStream.s0(((Integer) obj).intValue());
                return;
            case 15:
                codedOutputStream.u0(((Long) obj).longValue());
                return;
            case 16:
                codedOutputStream.Z((o) obj);
                return;
            case 17:
                codedOutputStream.e0((o) obj);
                return;
            case 18:
                if (obj instanceof i.a) {
                    codedOutputStream.T(((i.a) obj).f());
                    return;
                } else {
                    codedOutputStream.T(((Integer) obj).intValue());
                    return;
                }
            default:
                return;
        }
    }

    public static void z(b<?> bVar, Object obj, CodedOutputStream codedOutputStream) throws IOException {
        w.b j2 = bVar.j();
        int f2 = bVar.f();
        if (bVar.h()) {
            List list = (List) obj;
            if (bVar.m()) {
                codedOutputStream.w0(f2, 2);
                int i2 = 0;
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    i2 += e(j2, it.next());
                }
                codedOutputStream.o0(i2);
                Iterator it2 = list.iterator();
                while (it2.hasNext()) {
                    y(codedOutputStream, j2, it2.next());
                }
                return;
            }
            Iterator it3 = list.iterator();
            while (it3.hasNext()) {
                x(codedOutputStream, j2, f2, it3.next());
            }
            return;
        }
        if (obj instanceof j) {
            x(codedOutputStream, j2, f2, ((j) obj).e());
        } else {
            x(codedOutputStream, j2, f2, obj);
        }
    }

    public void a(FieldDescriptorType fielddescriptortype, Object obj) {
        List list;
        if (fielddescriptortype.h()) {
            w(fielddescriptortype.j(), obj);
            Object h2 = h(fielddescriptortype);
            if (h2 == null) {
                list = new ArrayList();
                this.f25418b.p(fielddescriptortype, list);
            } else {
                list = (List) h2;
            }
            list.add(obj);
            return;
        }
        throw new IllegalArgumentException("addRepeatedField() can only be called on repeated fields.");
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public g<FieldDescriptorType> clone() {
        g<FieldDescriptorType> t = t();
        for (int i2 = 0; i2 < this.f25418b.j(); i2++) {
            Map.Entry<FieldDescriptorType, Object> i3 = this.f25418b.i(i2);
            t.v(i3.getKey(), i3.getValue());
        }
        for (Map.Entry<FieldDescriptorType, Object> entry : this.f25418b.k()) {
            t.v(entry.getKey(), entry.getValue());
        }
        t.f25420d = this.f25420d;
        return t;
    }

    public Object h(FieldDescriptorType fielddescriptortype) {
        Object obj = this.f25418b.get(fielddescriptortype);
        return obj instanceof j ? ((j) obj).e() : obj;
    }

    public Object i(FieldDescriptorType fielddescriptortype, int i2) {
        if (fielddescriptortype.h()) {
            Object h2 = h(fielddescriptortype);
            if (h2 != null) {
                return ((List) h2).get(i2);
            }
            throw new IndexOutOfBoundsException();
        }
        throw new IllegalArgumentException("getRepeatedField() can only be called on repeated fields.");
    }

    public int j(FieldDescriptorType fielddescriptortype) {
        if (fielddescriptortype.h()) {
            Object h2 = h(fielddescriptortype);
            if (h2 == null) {
                return 0;
            }
            return ((List) h2).size();
        }
        throw new IllegalArgumentException("getRepeatedField() can only be called on repeated fields.");
    }

    public int k() {
        int i2 = 0;
        for (int i3 = 0; i3 < this.f25418b.j(); i3++) {
            Map.Entry<FieldDescriptorType, Object> i4 = this.f25418b.i(i3);
            i2 += f(i4.getKey(), i4.getValue());
        }
        for (Map.Entry<FieldDescriptorType, Object> entry : this.f25418b.k()) {
            i2 += f(entry.getKey(), entry.getValue());
        }
        return i2;
    }

    public boolean m(FieldDescriptorType fielddescriptortype) {
        if (fielddescriptortype.h()) {
            throw new IllegalArgumentException("hasField() can only be called on non-repeated fields.");
        }
        return this.f25418b.get(fielddescriptortype) != null;
    }

    public boolean n() {
        for (int i2 = 0; i2 < this.f25418b.j(); i2++) {
            if (!o(this.f25418b.i(i2))) {
                return false;
            }
        }
        Iterator<Map.Entry<FieldDescriptorType, Object>> it = this.f25418b.k().iterator();
        while (it.hasNext()) {
            if (!o(it.next())) {
                return false;
            }
        }
        return true;
    }

    public Iterator<Map.Entry<FieldDescriptorType, Object>> p() {
        if (this.f25420d) {
            return new j.c(this.f25418b.entrySet().iterator());
        }
        return this.f25418b.entrySet().iterator();
    }

    public void q() {
        if (this.f25419c) {
            return;
        }
        this.f25418b.n();
        this.f25419c = true;
    }

    public void r(g<FieldDescriptorType> gVar) {
        for (int i2 = 0; i2 < gVar.f25418b.j(); i2++) {
            s(gVar.f25418b.i(i2));
        }
        Iterator<Map.Entry<FieldDescriptorType, Object>> it = gVar.f25418b.k().iterator();
        while (it.hasNext()) {
            s(it.next());
        }
    }

    public void v(FieldDescriptorType fielddescriptortype, Object obj) {
        if (fielddescriptortype.h()) {
            if (obj instanceof List) {
                ArrayList arrayList = new ArrayList();
                arrayList.addAll((List) obj);
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    w(fielddescriptortype.j(), it.next());
                }
                obj = arrayList;
            } else {
                throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
            }
        } else {
            w(fielddescriptortype.j(), obj);
        }
        if (obj instanceof j) {
            this.f25420d = true;
        }
        this.f25418b.p(fielddescriptortype, obj);
    }

    private g(boolean z) {
        q();
    }
}
