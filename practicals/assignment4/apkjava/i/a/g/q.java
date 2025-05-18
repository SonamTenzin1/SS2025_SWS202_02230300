package i.a.g;

import i.a.d;
import i.a.g.h;
import i.a.g.i;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import okhttp3.HttpUrl;

/* compiled from: ServiceInfoImpl.java */
/* loaded from: classes2.dex */
public class q extends i.a.d implements d, i {

    /* renamed from: g, reason: collision with root package name */
    private static k.b.b f21847g = k.b.c.i(q.class.getName());

    /* renamed from: h, reason: collision with root package name */
    private String f21848h;

    /* renamed from: i, reason: collision with root package name */
    private String f21849i;

    /* renamed from: j, reason: collision with root package name */
    private String f21850j;

    /* renamed from: k, reason: collision with root package name */
    private String f21851k;
    private String l;
    private String m;
    private int n;
    private int o;
    private int p;
    private byte[] q;
    private Map<String, byte[]> r;
    private final Set<Inet4Address> s;
    private final Set<Inet6Address> t;
    private transient String u;
    private boolean v;
    private boolean w;
    private final b x;

    /* compiled from: ServiceInfoImpl.java */
    /* loaded from: classes2.dex */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[i.a.g.s.e.values().length];
            a = iArr;
            try {
                iArr[i.a.g.s.e.TYPE_A.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[i.a.g.s.e.TYPE_AAAA.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[i.a.g.s.e.TYPE_SRV.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[i.a.g.s.e.TYPE_TXT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[i.a.g.s.e.TYPE_PTR.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ServiceInfoImpl.java */
    /* loaded from: classes2.dex */
    public static final class b extends i.b {
        private final q l;

        public b(q qVar) {
            this.l = qVar;
        }

        @Override // i.a.g.i.b
        public void q(l lVar) {
            super.q(lVar);
        }

        @Override // i.a.g.i.b
        protected void s(i.a.g.t.a aVar) {
            super.s(aVar);
            if (this.f21787h == null && this.l.U()) {
                lock();
                try {
                    if (this.f21787h == null && this.l.U()) {
                        if (this.f21788i.k()) {
                            r(i.a.g.s.g.f21887i);
                            if (e() != null) {
                                e().l();
                            }
                        }
                        this.l.f0(false);
                    }
                } finally {
                    unlock();
                }
            }
        }
    }

    public q(String str, String str2, String str3, int i2, int i3, int i4, boolean z, byte[] bArr) {
        this(I(str, str2, str3), i2, i3, i4, z, bArr);
    }

    protected static Map<d.a, String> G(Map<d.a, String> map) {
        HashMap hashMap = new HashMap(5);
        d.a aVar = d.a.Domain;
        String str = "local";
        String str2 = map.containsKey(aVar) ? map.get(aVar) : "local";
        if (str2 != null && str2.length() != 0) {
            str = str2;
        }
        hashMap.put(aVar, a0(str));
        d.a aVar2 = d.a.Protocol;
        String str3 = "tcp";
        String str4 = map.containsKey(aVar2) ? map.get(aVar2) : "tcp";
        if (str4 != null && str4.length() != 0) {
            str3 = str4;
        }
        hashMap.put(aVar2, a0(str3));
        d.a aVar3 = d.a.Application;
        boolean containsKey = map.containsKey(aVar3);
        String str5 = HttpUrl.FRAGMENT_ENCODE_SET;
        String str6 = containsKey ? map.get(aVar3) : HttpUrl.FRAGMENT_ENCODE_SET;
        if (str6 == null || str6.length() == 0) {
            str6 = HttpUrl.FRAGMENT_ENCODE_SET;
        }
        hashMap.put(aVar3, a0(str6));
        d.a aVar4 = d.a.Instance;
        String str7 = map.containsKey(aVar4) ? map.get(aVar4) : HttpUrl.FRAGMENT_ENCODE_SET;
        if (str7 == null || str7.length() == 0) {
            str7 = HttpUrl.FRAGMENT_ENCODE_SET;
        }
        hashMap.put(aVar4, a0(str7));
        d.a aVar5 = d.a.Subtype;
        String str8 = map.containsKey(aVar5) ? map.get(aVar5) : HttpUrl.FRAGMENT_ENCODE_SET;
        if (str8 != null && str8.length() != 0) {
            str5 = str8;
        }
        hashMap.put(aVar5, a0(str5));
        return hashMap;
    }

    public static Map<d.a, String> I(String str, String str2, String str3) {
        Map<d.a, String> J = J(str);
        J.put(d.a.Instance, str2);
        J.put(d.a.Subtype, str3);
        return G(J);
    }

    public static Map<d.a, String> J(String str) {
        String a0;
        String substring;
        String str2;
        int indexOf;
        String substring2;
        String str3;
        String str4;
        String lowerCase = str.toLowerCase();
        boolean contains = lowerCase.contains("in-addr.arpa");
        String str5 = HttpUrl.FRAGMENT_ENCODE_SET;
        if (!contains && !lowerCase.contains("ip6.arpa")) {
            if (!lowerCase.contains("_") && lowerCase.contains(".")) {
                int indexOf2 = lowerCase.indexOf(46);
                a0 = a0(str.substring(0, indexOf2));
                substring = a0(str.substring(indexOf2));
            } else {
                if ((!lowerCase.startsWith("_") || lowerCase.startsWith("_services")) && (indexOf = lowerCase.indexOf("._")) > 0) {
                    substring2 = str.substring(0, indexOf);
                    int i2 = indexOf + 1;
                    if (i2 < lowerCase.length()) {
                        str3 = lowerCase.substring(i2);
                        str = str.substring(i2);
                    } else {
                        str3 = lowerCase;
                    }
                } else {
                    str3 = lowerCase;
                    substring2 = HttpUrl.FRAGMENT_ENCODE_SET;
                }
                int lastIndexOf = str3.lastIndexOf("._");
                if (lastIndexOf > 0) {
                    int i3 = lastIndexOf + 2;
                    str4 = str.substring(i3, str3.indexOf(46, i3));
                } else {
                    str4 = HttpUrl.FRAGMENT_ENCODE_SET;
                }
                if (str4.length() > 0) {
                    int indexOf3 = str3.indexOf("_" + str4.toLowerCase() + ".");
                    int length = str4.length() + indexOf3 + 2;
                    int length2 = str3.length() - (str3.endsWith(".") ? 1 : 0);
                    String substring3 = length2 > length ? str.substring(length, length2) : HttpUrl.FRAGMENT_ENCODE_SET;
                    if (indexOf3 > 0) {
                        lowerCase = str.substring(0, indexOf3 - 1);
                        substring = substring3;
                    } else {
                        substring = substring3;
                        lowerCase = HttpUrl.FRAGMENT_ENCODE_SET;
                    }
                } else {
                    substring = HttpUrl.FRAGMENT_ENCODE_SET;
                }
                int indexOf4 = lowerCase.toLowerCase().indexOf("._sub");
                if (indexOf4 > 0) {
                    str5 = a0(lowerCase.substring(0, indexOf4));
                    lowerCase = lowerCase.substring(indexOf4 + 5);
                }
                a0 = substring2;
                String str6 = str5;
                str5 = str4;
                str2 = str6;
                HashMap hashMap = new HashMap(5);
                hashMap.put(d.a.Domain, a0(substring));
                hashMap.put(d.a.Protocol, str5);
                hashMap.put(d.a.Application, a0(lowerCase));
                hashMap.put(d.a.Instance, a0);
                hashMap.put(d.a.Subtype, str2);
                return hashMap;
            }
        } else {
            int indexOf5 = lowerCase.contains("in-addr.arpa") ? lowerCase.indexOf("in-addr.arpa") : lowerCase.indexOf("ip6.arpa");
            a0 = a0(str.substring(0, indexOf5));
            substring = str.substring(indexOf5);
        }
        lowerCase = HttpUrl.FRAGMENT_ENCODE_SET;
        str2 = lowerCase;
        HashMap hashMap2 = new HashMap(5);
        hashMap2.put(d.a.Domain, a0(substring));
        hashMap2.put(d.a.Protocol, str5);
        hashMap2.put(d.a.Application, a0(lowerCase));
        hashMap2.put(d.a.Instance, a0);
        hashMap2.put(d.a.Subtype, str2);
        return hashMap2;
    }

    private final boolean P() {
        return this.s.size() > 0 || this.t.size() > 0;
    }

    private static String a0(String str) {
        if (str == null) {
            return HttpUrl.FRAGMENT_ENCODE_SET;
        }
        String trim = str.trim();
        if (trim.startsWith(".")) {
            trim = trim.substring(1);
        }
        if (trim.startsWith("_")) {
            trim = trim.substring(1);
        }
        return trim.endsWith(".") ? trim.substring(0, trim.length() - 1) : trim;
    }

    private static byte[] h0(Map<String, ?> map) {
        byte[] bArr = null;
        if (map != null) {
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(256);
                for (String str : map.keySet()) {
                    Object obj = map.get(str);
                    ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream(100);
                    l0(byteArrayOutputStream2, str);
                    if (obj != null) {
                        if (obj instanceof String) {
                            byteArrayOutputStream2.write(61);
                            l0(byteArrayOutputStream2, (String) obj);
                        } else if (obj instanceof byte[]) {
                            byte[] bArr2 = (byte[]) obj;
                            if (bArr2.length > 0) {
                                byteArrayOutputStream2.write(61);
                                byteArrayOutputStream2.write(bArr2, 0, bArr2.length);
                            } else {
                                obj = null;
                            }
                        } else {
                            throw new IllegalArgumentException("invalid property value: " + obj);
                        }
                    }
                    byte[] byteArray = byteArrayOutputStream2.toByteArray();
                    if (byteArray.length > 255) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("Cannot have individual values larger that 255 chars. Offending value: ");
                        sb.append(str);
                        sb.append(obj != null ? HttpUrl.FRAGMENT_ENCODE_SET : "=" + obj);
                        throw new IOException(sb.toString());
                    }
                    byteArrayOutputStream.write((byte) byteArray.length);
                    byteArrayOutputStream.write(byteArray, 0, byteArray.length);
                }
                bArr = byteArrayOutputStream.toByteArray();
            } catch (IOException e2) {
                throw new RuntimeException("unexpected exception: " + e2);
            }
        }
        return (bArr == null || bArr.length <= 0) ? h.f21780i : bArr;
    }

    static void l0(OutputStream outputStream, String str) throws IOException {
        int length = str.length();
        for (int i2 = 0; i2 < length; i2++) {
            char charAt = str.charAt(i2);
            if (charAt >= 1 && charAt <= 127) {
                outputStream.write(charAt);
            } else if (charAt > 2047) {
                outputStream.write(((charAt >> '\f') & 15) | 224);
                outputStream.write(((charAt >> 6) & 63) | 128);
                outputStream.write(((charAt >> 0) & 63) | 128);
            } else {
                outputStream.write(((charAt >> 6) & 31) | 192);
                outputStream.write(((charAt >> 0) & 63) | 128);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void A(byte[] bArr) {
        this.q = bArr;
        this.r = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void B(Inet4Address inet4Address) {
        this.s.add(inet4Address);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void C(Inet6Address inet6Address) {
        this.t.add(inet6Address);
    }

    public Collection<h> D(i.a.g.s.d dVar, boolean z, int i2, k kVar) {
        ArrayList arrayList = new ArrayList();
        if (dVar == i.a.g.s.d.CLASS_ANY || dVar == i.a.g.s.d.CLASS_IN) {
            if (q().length() > 0) {
                arrayList.add(new h.e(O(), i.a.g.s.d.CLASS_IN, false, i2, o()));
            }
            String s = s();
            i.a.g.s.d dVar2 = i.a.g.s.d.CLASS_IN;
            arrayList.add(new h.e(s, dVar2, false, i2, o()));
            arrayList.add(new h.f(o(), dVar2, z, i2, this.p, this.o, this.n, kVar.q()));
            arrayList.add(new h.g(o(), dVar2, z, i2, r()));
        }
        return arrayList;
    }

    public void E(i.a.g.t.a aVar, i.a.g.s.g gVar) {
        this.x.a(aVar, gVar);
    }

    public boolean F() {
        return this.x.b();
    }

    @Override // i.a.d
    /* renamed from: H, reason: merged with bridge method [inline-methods] */
    public q clone() {
        q qVar = new q(N(), this.n, this.o, this.p, this.v, this.q);
        for (Inet6Address inet6Address : i()) {
            qVar.t.add(inet6Address);
        }
        for (Inet4Address inet4Address : h()) {
            qVar.s.add(inet4Address);
        }
        return qVar;
    }

    public l K() {
        return this.x.e();
    }

    public String L() {
        if (this.u == null) {
            this.u = o().toLowerCase();
        }
        return this.u;
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x0069, code lost:
    
        r0.clear();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    synchronized Map<String, byte[]> M() {
        Map<String, byte[]> map;
        int i2;
        if (this.r == null && r() != null) {
            Hashtable hashtable = new Hashtable();
            int i3 = 0;
            while (true) {
                try {
                    if (i3 >= r().length) {
                        break;
                    }
                    int i4 = i3 + 1;
                    int i5 = r()[i3] & 255;
                    if (i5 == 0 || (i2 = i4 + i5) > r().length) {
                        break;
                    }
                    int i6 = 0;
                    while (i6 < i5 && r()[i4 + i6] != 61) {
                        i6++;
                    }
                    String V = V(r(), i4, i6);
                    if (V == null) {
                        hashtable.clear();
                        break;
                    }
                    if (i6 == i5) {
                        hashtable.put(V, i.a.d.f21745f);
                    } else {
                        int i7 = i6 + 1;
                        int i8 = i5 - i7;
                        byte[] bArr = new byte[i8];
                        System.arraycopy(r(), i4 + i7, bArr, 0, i8);
                        hashtable.put(V, bArr);
                    }
                    i3 = i2;
                } catch (Exception e2) {
                    f21847g.f("Malformed TXT Field ", e2);
                }
            }
            this.r = hashtable;
        }
        map = this.r;
        if (map == null) {
            map = Collections.emptyMap();
        }
        return map;
    }

    public Map<d.a, String> N() {
        HashMap hashMap = new HashMap(5);
        hashMap.put(d.a.Domain, g());
        hashMap.put(d.a.Protocol, n());
        hashMap.put(d.a.Application, f());
        hashMap.put(d.a.Instance, k());
        hashMap.put(d.a.Subtype, q());
        return hashMap;
    }

    public String O() {
        String str;
        String q = q();
        StringBuilder sb = new StringBuilder();
        if (q.length() > 0) {
            str = "_" + q.toLowerCase() + "._sub.";
        } else {
            str = HttpUrl.FRAGMENT_ENCODE_SET;
        }
        sb.append(str);
        sb.append(s());
        return sb.toString();
    }

    public boolean Q() {
        return this.x.f();
    }

    public boolean R() {
        return this.x.g();
    }

    public boolean S(i.a.g.t.a aVar, i.a.g.s.g gVar) {
        return this.x.h(aVar, gVar);
    }

    public boolean T() {
        return this.x.m();
    }

    public boolean U() {
        return this.w;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:4:0x0012. Please report as an issue. */
    String V(byte[] bArr, int i2, int i3) {
        int i4;
        int i5;
        int i6;
        StringBuffer stringBuffer = new StringBuffer();
        int i7 = i2 + i3;
        while (i2 < i7) {
            int i8 = i2 + 1;
            int i9 = bArr[i2] & 255;
            switch (i9 >> 4) {
                case 0:
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                    stringBuffer.append((char) i9);
                    i2 = i8;
                case 8:
                case 9:
                case 10:
                case 11:
                default:
                    i5 = i8 + 1;
                    if (i5 >= i3) {
                        return null;
                    }
                    i4 = (i9 & 63) << 4;
                    i6 = bArr[i8] & 15;
                    i9 = i4 | i6;
                    i8 = i5;
                    stringBuffer.append((char) i9);
                    i2 = i8;
                case 12:
                case 13:
                    if (i8 >= i3) {
                        return null;
                    }
                    i4 = (i9 & 31) << 6;
                    i5 = i8 + 1;
                    i6 = bArr[i8] & 63;
                    i9 = i4 | i6;
                    i8 = i5;
                    stringBuffer.append((char) i9);
                    i2 = i8;
                case 14:
                    if (i8 + 2 >= i3) {
                        return null;
                    }
                    int i10 = i8 + 1;
                    int i11 = ((i9 & 15) << 12) | ((bArr[i8] & 63) << 6);
                    i8 = i10 + 1;
                    i9 = i11 | (bArr[i10] & 63);
                    stringBuffer.append((char) i9);
                    i2 = i8;
            }
        }
        return stringBuffer.toString();
    }

    public boolean X() {
        return this.x.n();
    }

    public void Z(i.a.g.t.a aVar) {
        this.x.o(aVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0138 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // i.a.g.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void b(i.a.g.a aVar, long j2, i.a.g.b bVar) {
        l K;
        if (!(bVar instanceof h) || bVar.j(j2)) {
            return;
        }
        int i2 = a.a[bVar.f().ordinal()];
        boolean z = false;
        if (i2 == 1) {
            if (bVar.c().equalsIgnoreCase(p())) {
                this.s.add((Inet4Address) ((h.a) bVar).T());
                z = true;
            }
            if (z) {
            }
            synchronized (this) {
            }
        } else if (i2 == 2) {
            if (bVar.c().equalsIgnoreCase(p())) {
                this.t.add((Inet6Address) ((h.a) bVar).T());
                z = true;
            }
            if (z) {
            }
            synchronized (this) {
            }
        } else if (i2 == 3) {
            if (bVar.c().equalsIgnoreCase(o())) {
                h.f fVar = (h.f) bVar;
                String str = this.m;
                boolean z2 = str == null || !str.equalsIgnoreCase(fVar.V());
                this.m = fVar.V();
                this.n = fVar.T();
                this.o = fVar.W();
                this.p = fVar.U();
                if (z2) {
                    this.s.clear();
                    this.t.clear();
                    Iterator<? extends i.a.g.b> it = aVar.h(this.m, i.a.g.s.e.TYPE_A, i.a.g.s.d.CLASS_IN).iterator();
                    while (it.hasNext()) {
                        b(aVar, j2, it.next());
                    }
                    Iterator<? extends i.a.g.b> it2 = aVar.h(this.m, i.a.g.s.e.TYPE_AAAA, i.a.g.s.d.CLASS_IN).iterator();
                    while (it2.hasNext()) {
                        b(aVar, j2, it2.next());
                    }
                }
                z = true;
            }
            if (z) {
            }
            synchronized (this) {
            }
        } else {
            if (i2 != 4) {
                if (i2 == 5 && q().length() == 0 && bVar.g().length() != 0) {
                    this.l = bVar.g();
                    z = true;
                }
                if (z && u() && (K = K()) != null) {
                    K.M0(new p(K, s(), k(), this));
                }
                synchronized (this) {
                    notifyAll();
                }
                return;
            }
            if (bVar.c().equalsIgnoreCase(o())) {
                this.q = ((h.g) bVar).T();
                this.r = null;
                z = true;
            }
            if (z) {
                K.M0(new p(K, s(), k(), this));
            }
            synchronized (this) {
            }
        }
    }

    public boolean b0() {
        return this.x.p();
    }

    public void c0(l lVar) {
        this.x.q(lVar);
    }

    @Override // i.a.g.i
    public boolean d(i.a.g.t.a aVar) {
        return this.x.d(aVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d0(String str) {
        this.f21851k = str;
        this.u = null;
    }

    public boolean equals(Object obj) {
        return (obj instanceof q) && o().equals(((q) obj).o());
    }

    @Override // i.a.d
    public String f() {
        String str = this.f21850j;
        return str != null ? str : HttpUrl.FRAGMENT_ENCODE_SET;
    }

    public void f0(boolean z) {
        this.w = z;
        if (z) {
            this.x.s(null);
        }
    }

    @Override // i.a.d
    public String g() {
        String str = this.f21848h;
        return str != null ? str : "local";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g0(String str) {
        this.m = str;
    }

    @Override // i.a.d
    public Inet4Address[] h() {
        Set<Inet4Address> set = this.s;
        return (Inet4Address[]) set.toArray(new Inet4Address[set.size()]);
    }

    public int hashCode() {
        return o().hashCode();
    }

    @Override // i.a.d
    public Inet6Address[] i() {
        Set<Inet6Address> set = this.t;
        return (Inet6Address[]) set.toArray(new Inet6Address[set.size()]);
    }

    @Override // i.a.d
    public InetAddress[] j() {
        ArrayList arrayList = new ArrayList(this.s.size() + this.t.size());
        arrayList.addAll(this.s);
        arrayList.addAll(this.t);
        return (InetAddress[]) arrayList.toArray(new InetAddress[arrayList.size()]);
    }

    public boolean j0(long j2) {
        return this.x.t(j2);
    }

    @Override // i.a.d
    public String k() {
        String str = this.f21851k;
        return str != null ? str : HttpUrl.FRAGMENT_ENCODE_SET;
    }

    public boolean k0(long j2) {
        return this.x.u(j2);
    }

    @Override // i.a.d
    public int l() {
        return this.n;
    }

    @Override // i.a.d
    public int m() {
        return this.p;
    }

    @Override // i.a.d
    public String n() {
        String str = this.f21849i;
        return str != null ? str : "tcp";
    }

    @Override // i.a.d
    public String o() {
        String str;
        String str2;
        String g2 = g();
        String n = n();
        String f2 = f();
        String k2 = k();
        StringBuilder sb = new StringBuilder();
        int length = k2.length();
        String str3 = HttpUrl.FRAGMENT_ENCODE_SET;
        if (length > 0) {
            str = k2 + ".";
        } else {
            str = HttpUrl.FRAGMENT_ENCODE_SET;
        }
        sb.append(str);
        if (f2.length() > 0) {
            str2 = "_" + f2 + ".";
        } else {
            str2 = HttpUrl.FRAGMENT_ENCODE_SET;
        }
        sb.append(str2);
        if (n.length() > 0) {
            str3 = "_" + n + ".";
        }
        sb.append(str3);
        sb.append(g2);
        sb.append(".");
        return sb.toString();
    }

    @Override // i.a.d
    public String p() {
        String str = this.m;
        return str != null ? str : HttpUrl.FRAGMENT_ENCODE_SET;
    }

    @Override // i.a.d
    public String q() {
        String str = this.l;
        return str != null ? str : HttpUrl.FRAGMENT_ENCODE_SET;
    }

    @Override // i.a.d
    public byte[] r() {
        byte[] bArr = this.q;
        return (bArr == null || bArr.length <= 0) ? h.f21780i : bArr;
    }

    @Override // i.a.d
    public String s() {
        String str;
        String g2 = g();
        String n = n();
        String f2 = f();
        StringBuilder sb = new StringBuilder();
        int length = f2.length();
        String str2 = HttpUrl.FRAGMENT_ENCODE_SET;
        if (length > 0) {
            str = "_" + f2 + ".";
        } else {
            str = HttpUrl.FRAGMENT_ENCODE_SET;
        }
        sb.append(str);
        if (n.length() > 0) {
            str2 = "_" + n + ".";
        }
        sb.append(str2);
        sb.append(g2);
        sb.append(".");
        return sb.toString();
    }

    @Override // i.a.d
    public int t() {
        return this.o;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[" + q.class.getSimpleName() + "@" + System.identityHashCode(this) + " ");
        sb.append("name: '");
        StringBuilder sb2 = new StringBuilder();
        int length = k().length();
        String str = HttpUrl.FRAGMENT_ENCODE_SET;
        sb2.append(length > 0 ? k() + "." : HttpUrl.FRAGMENT_ENCODE_SET);
        sb2.append(O());
        sb.append(sb2.toString());
        sb.append("' address: '");
        InetAddress[] j2 = j();
        if (j2.length > 0) {
            for (InetAddress inetAddress : j2) {
                sb.append(inetAddress);
                sb.append(':');
                sb.append(l());
                sb.append(' ');
            }
        } else {
            sb.append("(null):");
            sb.append(l());
        }
        sb.append("' status: '");
        sb.append(this.x.toString());
        sb.append(w() ? "' is persistent," : "',");
        sb.append(" has ");
        if (!u()) {
            str = "NO ";
        }
        sb.append(str);
        sb.append("data");
        if (r().length > 0) {
            Map<String, byte[]> M = M();
            if (!M.isEmpty()) {
                sb.append("\n");
                for (String str2 : M.keySet()) {
                    sb.append("\t" + str2 + ": " + new String(M.get(str2)) + "\n");
                }
            } else {
                sb.append(" empty");
            }
        }
        sb.append(']');
        return sb.toString();
    }

    @Override // i.a.d
    public synchronized boolean u() {
        boolean z;
        if (p() != null && P() && r() != null) {
            z = r().length > 0;
        }
        return z;
    }

    @Override // i.a.d
    public boolean v(i.a.d dVar) {
        if (dVar == null) {
            return false;
        }
        if (dVar instanceof q) {
            q qVar = (q) dVar;
            return this.s.size() == qVar.s.size() && this.t.size() == qVar.t.size() && this.s.equals(qVar.s) && this.t.equals(qVar.t);
        }
        InetAddress[] j2 = j();
        InetAddress[] j3 = dVar.j();
        return j2.length == j3.length && new HashSet(Arrays.asList(j2)).equals(new HashSet(Arrays.asList(j3)));
    }

    @Override // i.a.d
    public boolean w() {
        return this.v;
    }

    public q(Map<d.a, String> map, int i2, int i3, int i4, boolean z, Map<String, ?> map2) {
        this(map, i2, i3, i4, z, h0(map2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(Map<d.a, String> map, int i2, int i3, int i4, boolean z, String str) {
        this(map, i2, i3, i4, z, (byte[]) null);
        this.m = str;
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(str.length());
            l0(byteArrayOutputStream, str);
            this.q = byteArrayOutputStream.toByteArray();
        } catch (IOException e2) {
            throw new RuntimeException("unexpected exception: " + e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(Map<d.a, String> map, int i2, int i3, int i4, boolean z, byte[] bArr) {
        Map<d.a, String> G = G(map);
        this.f21848h = G.get(d.a.Domain);
        this.f21849i = G.get(d.a.Protocol);
        this.f21850j = G.get(d.a.Application);
        this.f21851k = G.get(d.a.Instance);
        this.l = G.get(d.a.Subtype);
        this.n = i2;
        this.o = i3;
        this.p = i4;
        this.q = bArr;
        f0(false);
        this.x = new b(this);
        this.v = z;
        this.s = Collections.synchronizedSet(new LinkedHashSet());
        this.t = Collections.synchronizedSet(new LinkedHashSet());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(i.a.d dVar) {
        this.s = Collections.synchronizedSet(new LinkedHashSet());
        this.t = Collections.synchronizedSet(new LinkedHashSet());
        if (dVar != null) {
            this.f21848h = dVar.g();
            this.f21849i = dVar.n();
            this.f21850j = dVar.f();
            this.f21851k = dVar.k();
            this.l = dVar.q();
            this.n = dVar.l();
            this.o = dVar.t();
            this.p = dVar.m();
            this.q = dVar.r();
            this.v = dVar.w();
            for (Inet6Address inet6Address : dVar.i()) {
                this.t.add(inet6Address);
            }
            for (Inet4Address inet4Address : dVar.h()) {
                this.s.add(inet4Address);
            }
        }
        this.x = new b(this);
    }
}
