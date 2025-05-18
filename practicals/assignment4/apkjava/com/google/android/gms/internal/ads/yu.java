package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdnu;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
final class yu<FieldDescriptorType extends zzdnu<FieldDescriptorType>> {
    private static final yu a = new yu(true);

    /* renamed from: c, reason: collision with root package name */
    private boolean f13656c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f13657d = false;

    /* renamed from: b, reason: collision with root package name */
    private final ow<FieldDescriptorType, Object> f13655b = ow.p(16);

    private yu() {
    }

    static int f(zzdri zzdriVar, int i2, Object obj) {
        int h0 = zzdni.h0(i2);
        if (zzdriVar == zzdri.o) {
            zzdod.j((zzdpk) obj);
            h0 <<= 1;
        }
        return h0 + q(zzdriVar, obj);
    }

    private final Object g(FieldDescriptorType fielddescriptortype) {
        Object obj = this.f13655b.get(fielddescriptortype);
        return obj instanceof zzdon ? zzdon.e() : obj;
    }

    private final void i(FieldDescriptorType fielddescriptortype, Object obj) {
        if (fielddescriptortype.t()) {
            if (obj instanceof List) {
                ArrayList arrayList = new ArrayList();
                arrayList.addAll((List) obj);
                int size = arrayList.size();
                int i2 = 0;
                while (i2 < size) {
                    Object obj2 = arrayList.get(i2);
                    i2++;
                    j(fielddescriptortype.p(), obj2);
                }
                obj = arrayList;
            } else {
                throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
            }
        } else {
            j(fielddescriptortype.p(), obj);
        }
        if (obj instanceof zzdon) {
            this.f13657d = true;
        }
        this.f13655b.put(fielddescriptortype, obj);
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0026, code lost:
    
        if ((r3 instanceof com.google.android.gms.internal.ads.zzdoe) == false) goto L10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x002f, code lost:
    
        if ((r3 instanceof byte[]) == false) goto L10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x001b, code lost:
    
        if ((r3 instanceof com.google.android.gms.internal.ads.zzdon) == false) goto L10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x001e, code lost:
    
        r0 = false;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0011. Please report as an issue. */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void j(zzdri zzdriVar, Object obj) {
        zzdod.a(obj);
        boolean z = true;
        boolean z2 = false;
        switch (zu.a[zzdriVar.g().ordinal()]) {
            case 1:
                z = obj instanceof Integer;
                z2 = z;
                break;
            case 2:
                z = obj instanceof Long;
                z2 = z;
                break;
            case 3:
                z = obj instanceof Float;
                z2 = z;
                break;
            case 4:
                z = obj instanceof Double;
                z2 = z;
                break;
            case 5:
                z = obj instanceof Boolean;
                z2 = z;
                break;
            case 6:
                z = obj instanceof String;
                z2 = z;
                break;
            case 7:
                if (!(obj instanceof zzdmr)) {
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
                if (!(obj instanceof zzdpk)) {
                    break;
                }
                z2 = z;
                break;
        }
        if (!z2) {
            throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        }
    }

    private static Object k(Object obj) {
        if (obj instanceof zzdpr) {
            return ((zzdpr) obj).e0();
        }
        if (!(obj instanceof byte[])) {
            return obj;
        }
        byte[] bArr = (byte[]) obj;
        byte[] bArr2 = new byte[bArr.length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        return bArr2;
    }

    public static <T extends zzdnu<T>> yu<T> m() {
        return a;
    }

    private static int p(zzdnu<?> zzdnuVar, Object obj) {
        zzdri p = zzdnuVar.p();
        int i2 = zzdnuVar.i();
        if (zzdnuVar.t()) {
            int i3 = 0;
            if (zzdnuVar.w()) {
                Iterator it = ((List) obj).iterator();
                while (it.hasNext()) {
                    i3 += q(p, it.next());
                }
                return zzdni.h0(i2) + i3 + zzdni.p0(i3);
            }
            Iterator it2 = ((List) obj).iterator();
            while (it2.hasNext()) {
                i3 += f(p, i2, it2.next());
            }
            return i3;
        }
        return f(p, i2, obj);
    }

    private static int q(zzdri zzdriVar, Object obj) {
        switch (zu.f13722b[zzdriVar.ordinal()]) {
            case 1:
                return zzdni.H(((Double) obj).doubleValue());
            case 2:
                return zzdni.s0(((Float) obj).floatValue());
            case 3:
                return zzdni.V(((Long) obj).longValue());
            case 4:
                return zzdni.W(((Long) obj).longValue());
            case 5:
                return zzdni.i0(((Integer) obj).intValue());
            case 6:
                return zzdni.Y(((Long) obj).longValue());
            case 7:
                return zzdni.l0(((Integer) obj).intValue());
            case 8:
                return zzdni.G(((Boolean) obj).booleanValue());
            case 9:
                return zzdni.C0((zzdpk) obj);
            case 10:
                if (obj instanceof zzdon) {
                    return zzdni.e((zzdon) obj);
                }
                return zzdni.A0((zzdpk) obj);
            case 11:
                if (obj instanceof zzdmr) {
                    return zzdni.Q((zzdmr) obj);
                }
                return zzdni.r0((String) obj);
            case 12:
                if (obj instanceof zzdmr) {
                    return zzdni.Q((zzdmr) obj);
                }
                return zzdni.p((byte[]) obj);
            case 13:
                return zzdni.j0(((Integer) obj).intValue());
            case 14:
                return zzdni.m0(((Integer) obj).intValue());
            case 15:
                return zzdni.Z(((Long) obj).longValue());
            case 16:
                return zzdni.k0(((Integer) obj).intValue());
            case 17:
                return zzdni.X(((Long) obj).longValue());
            case 18:
                if (obj instanceof zzdoe) {
                    return zzdni.n0(((zzdoe) obj).i());
                }
                return zzdni.n0(((Integer) obj).intValue());
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    private static boolean r(Map.Entry<FieldDescriptorType, Object> entry) {
        FieldDescriptorType key = entry.getKey();
        if (key.s() == zzdrn.MESSAGE) {
            if (key.t()) {
                Iterator it = ((List) entry.getValue()).iterator();
                while (it.hasNext()) {
                    if (!((zzdpk) it.next()).isInitialized()) {
                        return false;
                    }
                }
            } else {
                Object value = entry.getValue();
                if (value instanceof zzdpk) {
                    if (!((zzdpk) value).isInitialized()) {
                        return false;
                    }
                } else {
                    if (value instanceof zzdon) {
                        return true;
                    }
                    throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
                }
            }
        }
        return true;
    }

    private final void s(Map.Entry<FieldDescriptorType, Object> entry) {
        zzdpk p0;
        FieldDescriptorType key = entry.getKey();
        Object value = entry.getValue();
        if (value instanceof zzdon) {
            value = zzdon.e();
        }
        if (key.t()) {
            Object g2 = g(key);
            if (g2 == null) {
                g2 = new ArrayList();
            }
            Iterator it = ((List) value).iterator();
            while (it.hasNext()) {
                ((List) g2).add(k(it.next()));
            }
            this.f13655b.put(key, g2);
            return;
        }
        if (key.s() == zzdrn.MESSAGE) {
            Object g3 = g(key);
            if (g3 == null) {
                this.f13655b.put(key, k(value));
                return;
            }
            if (g3 instanceof zzdpr) {
                p0 = key.C((zzdpr) g3, (zzdpr) value);
            } else {
                p0 = key.r(((zzdpk) g3).b(), (zzdpk) value).p0();
            }
            this.f13655b.put(key, p0);
            return;
        }
        this.f13655b.put(key, k(value));
    }

    private static int t(Map.Entry<FieldDescriptorType, Object> entry) {
        FieldDescriptorType key = entry.getKey();
        Object value = entry.getValue();
        if (key.s() == zzdrn.MESSAGE && !key.t() && !key.w()) {
            if (value instanceof zzdon) {
                return zzdni.y(entry.getKey().i(), (zzdon) value);
            }
            return zzdni.O(entry.getKey().i(), (zzdpk) value);
        }
        return p(key, value);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Iterator<Map.Entry<FieldDescriptorType, Object>> a() {
        if (this.f13657d) {
            return new jv(this.f13655b.j().iterator());
        }
        return this.f13655b.j().iterator();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean b() {
        return this.f13655b.isEmpty();
    }

    public final boolean c() {
        return this.f13656c;
    }

    public final /* synthetic */ Object clone() throws CloneNotSupportedException {
        yu yuVar = new yu();
        for (int i2 = 0; i2 < this.f13655b.h(); i2++) {
            Map.Entry<FieldDescriptorType, Object> q = this.f13655b.q(i2);
            yuVar.i(q.getKey(), q.getValue());
        }
        for (Map.Entry<FieldDescriptorType, Object> entry : this.f13655b.i()) {
            yuVar.i(entry.getKey(), entry.getValue());
        }
        yuVar.f13657d = this.f13657d;
        return yuVar;
    }

    public final boolean d() {
        for (int i2 = 0; i2 < this.f13655b.h(); i2++) {
            if (!r(this.f13655b.q(i2))) {
                return false;
            }
        }
        Iterator<Map.Entry<FieldDescriptorType, Object>> it = this.f13655b.i().iterator();
        while (it.hasNext()) {
            if (!r(it.next())) {
                return false;
            }
        }
        return true;
    }

    public final Iterator<Map.Entry<FieldDescriptorType, Object>> e() {
        if (this.f13657d) {
            return new jv(this.f13655b.entrySet().iterator());
        }
        return this.f13655b.entrySet().iterator();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof yu) {
            return this.f13655b.equals(((yu) obj).f13655b);
        }
        return false;
    }

    public final void h(yu<FieldDescriptorType> yuVar) {
        for (int i2 = 0; i2 < yuVar.f13655b.h(); i2++) {
            s(yuVar.f13655b.q(i2));
        }
        Iterator<Map.Entry<FieldDescriptorType, Object>> it = yuVar.f13655b.i().iterator();
        while (it.hasNext()) {
            s(it.next());
        }
    }

    public final int hashCode() {
        return this.f13655b.hashCode();
    }

    public final void l() {
        if (this.f13656c) {
            return;
        }
        this.f13655b.f();
        this.f13656c = true;
    }

    public final int n() {
        int i2 = 0;
        for (int i3 = 0; i3 < this.f13655b.h(); i3++) {
            Map.Entry<FieldDescriptorType, Object> q = this.f13655b.q(i3);
            i2 += p(q.getKey(), q.getValue());
        }
        for (Map.Entry<FieldDescriptorType, Object> entry : this.f13655b.i()) {
            i2 += p(entry.getKey(), entry.getValue());
        }
        return i2;
    }

    public final int o() {
        int i2 = 0;
        for (int i3 = 0; i3 < this.f13655b.h(); i3++) {
            i2 += t(this.f13655b.q(i3));
        }
        Iterator<Map.Entry<FieldDescriptorType, Object>> it = this.f13655b.i().iterator();
        while (it.hasNext()) {
            i2 += t(it.next());
        }
        return i2;
    }

    private yu(boolean z) {
        l();
    }
}
