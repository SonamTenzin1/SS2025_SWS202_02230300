package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzey;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement-base@@17.2.0 */
/* loaded from: classes2.dex */
public final class h2<T extends zzey<T>> {
    private static final h2 a = new h2(true);

    /* renamed from: b, reason: collision with root package name */
    final u3<T, Object> f17168b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f17169c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f17170d;

    private h2() {
        this.f17168b = u3.b(16);
    }

    public static int a(zzey<?> zzeyVar, Object obj) {
        zzim b2 = zzeyVar.b();
        int a2 = zzeyVar.a();
        if (zzeyVar.d()) {
            int i2 = 0;
            if (zzeyVar.e()) {
                Iterator it = ((List) obj).iterator();
                while (it.hasNext()) {
                    i2 += i(b2, it.next());
                }
                return zzen.g0(a2) + i2 + zzen.D0(i2);
            }
            Iterator it2 = ((List) obj).iterator();
            while (it2.hasNext()) {
                i2 += b(b2, a2, it2.next());
            }
            return i2;
        }
        return b(b2, a2, obj);
    }

    static int b(zzim zzimVar, int i2, Object obj) {
        int g0 = zzen.g0(i2);
        if (zzimVar == zzim.o) {
            zzff.g((zzgo) obj);
            g0 <<= 1;
        }
        return g0 + i(zzimVar, obj);
    }

    public static <T extends zzey<T>> h2<T> c() {
        return a;
    }

    private final Object d(T t) {
        Object obj = this.f17168b.get(t);
        if (!(obj instanceof zzfp)) {
            return obj;
        }
        return zzfp.e();
    }

    private static Object e(Object obj) {
        if (obj instanceof zzgt) {
            return ((zzgt) obj).clone();
        }
        if (!(obj instanceof byte[])) {
            return obj;
        }
        byte[] bArr = (byte[]) obj;
        byte[] bArr2 = new byte[bArr.length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        return bArr2;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x001c, code lost:
    
        if ((r3 instanceof com.google.android.gms.internal.measurement.zzfp) == false) goto L4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0025, code lost:
    
        if ((r3 instanceof com.google.android.gms.internal.measurement.zzfi) == false) goto L4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x002e, code lost:
    
        if ((r3 instanceof byte[]) == false) goto L4;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void g(zzim zzimVar, Object obj) {
        zzff.d(obj);
        boolean z = true;
        switch (g2.a[zzimVar.g().ordinal()]) {
            case 1:
                z = obj instanceof Integer;
                break;
            case 2:
                z = obj instanceof Long;
                break;
            case 3:
                z = obj instanceof Float;
                break;
            case 4:
                z = obj instanceof Double;
                break;
            case 5:
                z = obj instanceof Boolean;
                break;
            case 6:
                z = obj instanceof String;
                break;
            case 7:
                if (!(obj instanceof zzdu)) {
                    break;
                }
                break;
            case 8:
                if (!(obj instanceof Integer)) {
                    break;
                }
                break;
            case 9:
                if (!(obj instanceof zzgo)) {
                    break;
                }
                break;
            default:
                z = false;
                break;
        }
        if (!z) {
            throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        }
    }

    private static <T extends zzey<T>> boolean h(Map.Entry<T, Object> entry) {
        T key = entry.getKey();
        if (key.c() == zzip.MESSAGE) {
            if (key.d()) {
                Iterator it = ((List) entry.getValue()).iterator();
                while (it.hasNext()) {
                    if (!((zzgo) it.next()).b()) {
                        return false;
                    }
                }
            } else {
                Object value = entry.getValue();
                if (value instanceof zzgo) {
                    if (!((zzgo) value).b()) {
                        return false;
                    }
                } else {
                    if (value instanceof zzfp) {
                        return true;
                    }
                    throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
                }
            }
        }
        return true;
    }

    private static int i(zzim zzimVar, Object obj) {
        switch (g2.f17155b[zzimVar.ordinal()]) {
            case 1:
                return zzen.z(((Double) obj).doubleValue());
            case 2:
                return zzen.A(((Float) obj).floatValue());
            case 3:
                return zzen.d0(((Long) obj).longValue());
            case 4:
                return zzen.i0(((Long) obj).longValue());
            case 5:
                return zzen.k0(((Integer) obj).intValue());
            case 6:
                return zzen.r0(((Long) obj).longValue());
            case 7:
                return zzen.w0(((Integer) obj).intValue());
            case 8:
                return zzen.L(((Boolean) obj).booleanValue());
            case 9:
                return zzen.V((zzgo) obj);
            case 10:
                if (obj instanceof zzfp) {
                    return zzen.d((zzfp) obj);
                }
                return zzen.J((zzgo) obj);
            case 11:
                if (obj instanceof zzdu) {
                    return zzen.I((zzdu) obj);
                }
                return zzen.K((String) obj);
            case 12:
                if (obj instanceof zzdu) {
                    return zzen.I((zzdu) obj);
                }
                return zzen.M((byte[]) obj);
            case 13:
                return zzen.o0(((Integer) obj).intValue());
            case 14:
                return zzen.z0(((Integer) obj).intValue());
            case 15:
                return zzen.v0(((Long) obj).longValue());
            case 16:
                return zzen.s0(((Integer) obj).intValue());
            case 17:
                return zzen.n0(((Long) obj).longValue());
            case 18:
                if (obj instanceof zzfi) {
                    return zzen.B0(((zzfi) obj).a());
                }
                return zzen.B0(((Integer) obj).intValue());
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    private final void k(T t, Object obj) {
        if (t.d()) {
            if (obj instanceof List) {
                ArrayList arrayList = new ArrayList();
                arrayList.addAll((List) obj);
                int size = arrayList.size();
                int i2 = 0;
                while (i2 < size) {
                    Object obj2 = arrayList.get(i2);
                    i2++;
                    g(t.b(), obj2);
                }
                obj = arrayList;
            } else {
                throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
            }
        } else {
            g(t.b(), obj);
        }
        if (obj instanceof zzfp) {
            this.f17170d = true;
        }
        this.f17168b.put(t, obj);
    }

    private final void l(Map.Entry<T, Object> entry) {
        zzgo y;
        T key = entry.getKey();
        Object value = entry.getValue();
        if (value instanceof zzfp) {
            value = zzfp.e();
        }
        if (key.d()) {
            Object d2 = d(key);
            if (d2 == null) {
                d2 = new ArrayList();
            }
            Iterator it = ((List) value).iterator();
            while (it.hasNext()) {
                ((List) d2).add(e(it.next()));
            }
            this.f17168b.put(key, d2);
            return;
        }
        if (key.c() == zzip.MESSAGE) {
            Object d3 = d(key);
            if (d3 == null) {
                this.f17168b.put(key, e(value));
                return;
            }
            if (d3 instanceof zzgt) {
                y = key.z((zzgt) d3, (zzgt) value);
            } else {
                y = key.o(((zzgo) d3).e(), (zzgo) value).y();
            }
            this.f17168b.put(key, y);
            return;
        }
        this.f17168b.put(key, e(value));
    }

    private static int m(Map.Entry<T, Object> entry) {
        T key = entry.getKey();
        Object value = entry.getValue();
        if (key.c() == zzip.MESSAGE && !key.d() && !key.e()) {
            if (value instanceof zzfp) {
                return zzen.D(entry.getKey().a(), (zzfp) value);
            }
            return zzen.E(entry.getKey().a(), (zzgo) value);
        }
        return a(key, value);
    }

    public final /* synthetic */ Object clone() throws CloneNotSupportedException {
        h2 h2Var = new h2();
        for (int i2 = 0; i2 < this.f17168b.k(); i2++) {
            Map.Entry<T, Object> i3 = this.f17168b.i(i2);
            h2Var.k(i3.getKey(), i3.getValue());
        }
        for (Map.Entry<T, Object> entry : this.f17168b.n()) {
            h2Var.k(entry.getKey(), entry.getValue());
        }
        h2Var.f17170d = this.f17170d;
        return h2Var;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof h2) {
            return this.f17168b.equals(((h2) obj).f17168b);
        }
        return false;
    }

    public final void f(h2<T> h2Var) {
        for (int i2 = 0; i2 < h2Var.f17168b.k(); i2++) {
            l(h2Var.f17168b.i(i2));
        }
        Iterator<Map.Entry<T, Object>> it = h2Var.f17168b.n().iterator();
        while (it.hasNext()) {
            l(it.next());
        }
    }

    public final int hashCode() {
        return this.f17168b.hashCode();
    }

    public final void j() {
        if (this.f17169c) {
            return;
        }
        this.f17168b.e();
        this.f17169c = true;
    }

    public final boolean n() {
        return this.f17169c;
    }

    public final Iterator<Map.Entry<T, Object>> o() {
        if (this.f17170d) {
            return new q2(this.f17168b.entrySet().iterator());
        }
        return this.f17168b.entrySet().iterator();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Iterator<Map.Entry<T, Object>> p() {
        if (this.f17170d) {
            return new q2(this.f17168b.p().iterator());
        }
        return this.f17168b.p().iterator();
    }

    public final boolean q() {
        for (int i2 = 0; i2 < this.f17168b.k(); i2++) {
            if (!h(this.f17168b.i(i2))) {
                return false;
            }
        }
        Iterator<Map.Entry<T, Object>> it = this.f17168b.n().iterator();
        while (it.hasNext()) {
            if (!h(it.next())) {
                return false;
            }
        }
        return true;
    }

    public final int r() {
        int i2 = 0;
        for (int i3 = 0; i3 < this.f17168b.k(); i3++) {
            i2 += m(this.f17168b.i(i3));
        }
        Iterator<Map.Entry<T, Object>> it = this.f17168b.n().iterator();
        while (it.hasNext()) {
            i2 += m(it.next());
        }
        return i2;
    }

    private h2(boolean z) {
        this(u3.b(0));
        j();
    }

    private h2(u3<T, Object> u3Var) {
        this.f17168b = u3Var;
        j();
    }
}
