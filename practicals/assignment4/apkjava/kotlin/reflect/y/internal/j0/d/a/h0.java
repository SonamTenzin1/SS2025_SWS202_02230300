package kotlin.reflect.y.internal.j0.d.a;

import cm.aptoide.pt.database.room.RoomInstalled;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.collections.c0;
import kotlin.collections.n0;
import kotlin.collections.p0;
import kotlin.collections.q0;
import kotlin.collections.v;
import kotlin.collections.w0;
import kotlin.collections.x0;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.m;
import kotlin.ranges.l;
import kotlin.reflect.y.internal.j0.d.b.x;
import kotlin.reflect.y.internal.j0.f.f;
import kotlin.reflect.y.internal.j0.i.u.e;
import kotlin.s;
import okhttp3.HttpUrl;

/* compiled from: SpecialGenericSignatures.kt */
/* loaded from: classes2.dex */
public class h0 {
    public static final a a = new a(null);

    /* renamed from: b, reason: collision with root package name */
    private static final List<a.C0327a> f23378b;

    /* renamed from: c, reason: collision with root package name */
    private static final List<String> f23379c;

    /* renamed from: d, reason: collision with root package name */
    private static final List<String> f23380d;

    /* renamed from: e, reason: collision with root package name */
    private static final Map<a.C0327a, c> f23381e;

    /* renamed from: f, reason: collision with root package name */
    private static final Map<String, c> f23382f;

    /* renamed from: g, reason: collision with root package name */
    private static final Set<f> f23383g;

    /* renamed from: h, reason: collision with root package name */
    private static final Set<String> f23384h;

    /* renamed from: i, reason: collision with root package name */
    private static final a.C0327a f23385i;

    /* renamed from: j, reason: collision with root package name */
    private static final Map<a.C0327a, f> f23386j;

    /* renamed from: k, reason: collision with root package name */
    private static final Map<String, f> f23387k;
    private static final List<f> l;
    private static final Map<f, f> m;

    /* compiled from: SpecialGenericSignatures.kt */
    /* loaded from: classes2.dex */
    public static final class a {

        /* compiled from: SpecialGenericSignatures.kt */
        /* renamed from: kotlin.f0.y.e.j0.d.a.h0$a$a, reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public static final class C0327a {
            private final f a;

            /* renamed from: b, reason: collision with root package name */
            private final String f23388b;

            public C0327a(f fVar, String str) {
                m.f(fVar, "name");
                m.f(str, RoomInstalled.SIGNATURE);
                this.a = fVar;
                this.f23388b = str;
            }

            public final f a() {
                return this.a;
            }

            public final String b() {
                return this.f23388b;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof C0327a)) {
                    return false;
                }
                C0327a c0327a = (C0327a) obj;
                return m.a(this.a, c0327a.a) && m.a(this.f23388b, c0327a.f23388b);
            }

            public int hashCode() {
                return (this.a.hashCode() * 31) + this.f23388b.hashCode();
            }

            public String toString() {
                return "NameAndSignature(name=" + this.a + ", signature=" + this.f23388b + ')';
            }
        }

        private a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final C0327a m(String str, String str2, String str3, String str4) {
            f x = f.x(str2);
            m.e(x, "identifier(name)");
            return new C0327a(x, x.a.k(str, str2 + '(' + str3 + ')' + str4));
        }

        public final f b(f fVar) {
            m.f(fVar, "name");
            return f().get(fVar);
        }

        public final List<String> c() {
            return h0.f23379c;
        }

        public final Set<f> d() {
            return h0.f23383g;
        }

        public final Set<String> e() {
            return h0.f23384h;
        }

        public final Map<f, f> f() {
            return h0.m;
        }

        public final List<f> g() {
            return h0.l;
        }

        public final C0327a h() {
            return h0.f23385i;
        }

        public final Map<String, c> i() {
            return h0.f23382f;
        }

        public final Map<String, f> j() {
            return h0.f23387k;
        }

        public final boolean k(f fVar) {
            m.f(fVar, "<this>");
            return g().contains(fVar);
        }

        public final b l(String str) {
            m.f(str, "builtinSignature");
            if (c().contains(str)) {
                return b.ONE_COLLECTION_PARAMETER;
            }
            if (((c) n0.j(i(), str)) == c.f23395f) {
                return b.OBJECT_PARAMETER_GENERIC;
            }
            return b.OBJECT_PARAMETER_NON_GENERIC;
        }
    }

    /* compiled from: SpecialGenericSignatures.kt */
    /* loaded from: classes2.dex */
    public enum b {
        ONE_COLLECTION_PARAMETER("Ljava/util/Collection<+Ljava/lang/Object;>;", false),
        OBJECT_PARAMETER_NON_GENERIC(null, true),
        OBJECT_PARAMETER_GENERIC("Ljava/lang/Object;", true);


        /* renamed from: j, reason: collision with root package name */
        private final String f23393j;

        /* renamed from: k, reason: collision with root package name */
        private final boolean f23394k;

        b(String str, boolean z) {
            this.f23393j = str;
            this.f23394k = z;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: SpecialGenericSignatures.kt */
    /* loaded from: classes2.dex */
    public static final class c {

        /* renamed from: f, reason: collision with root package name */
        public static final c f23395f = new c("NULL", 0, null);

        /* renamed from: g, reason: collision with root package name */
        public static final c f23396g = new c("INDEX", 1, -1);

        /* renamed from: h, reason: collision with root package name */
        public static final c f23397h = new c("FALSE", 2, Boolean.FALSE);

        /* renamed from: i, reason: collision with root package name */
        public static final c f23398i = new a("MAP_GET_OR_DEFAULT", 3);

        /* renamed from: j, reason: collision with root package name */
        private static final /* synthetic */ c[] f23399j = g();

        /* renamed from: k, reason: collision with root package name */
        private final Object f23400k;

        /* compiled from: SpecialGenericSignatures.kt */
        /* loaded from: classes2.dex */
        static final class a extends c {
            /* JADX WARN: Illegal instructions before constructor call */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            a(String str, int i2) {
                super(str, i2, r0, r0);
                g gVar = null;
            }
        }

        private c(String str, int i2, Object obj) {
            this.f23400k = obj;
        }

        public /* synthetic */ c(String str, int i2, Object obj, g gVar) {
            this(str, i2, obj);
        }

        private static final /* synthetic */ c[] g() {
            return new c[]{f23395f, f23396g, f23397h, f23398i};
        }

        public static c valueOf(String str) {
            return (c) Enum.valueOf(c.class, str);
        }

        public static c[] values() {
            return (c[]) f23399j.clone();
        }
    }

    static {
        Set<String> i2;
        int u;
        int u2;
        int u3;
        Map<a.C0327a, c> l2;
        int e2;
        Set l3;
        int u4;
        Set<f> I0;
        int u5;
        Set<String> I02;
        Map<a.C0327a, f> l4;
        int e3;
        int u6;
        int u7;
        int u8;
        int e4;
        int b2;
        i2 = w0.i("containsAll", "removeAll", "retainAll");
        u = v.u(i2, 10);
        ArrayList arrayList = new ArrayList(u);
        for (String str : i2) {
            a aVar = a;
            String u9 = e.BOOLEAN.u();
            m.e(u9, "BOOLEAN.desc");
            arrayList.add(aVar.m("java/util/Collection", str, "Ljava/util/Collection;", u9));
        }
        f23378b = arrayList;
        u2 = v.u(arrayList, 10);
        ArrayList arrayList2 = new ArrayList(u2);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(((a.C0327a) it.next()).b());
        }
        f23379c = arrayList2;
        List<a.C0327a> list = f23378b;
        u3 = v.u(list, 10);
        ArrayList arrayList3 = new ArrayList(u3);
        Iterator<T> it2 = list.iterator();
        while (it2.hasNext()) {
            arrayList3.add(((a.C0327a) it2.next()).a().k());
        }
        f23380d = arrayList3;
        x xVar = x.a;
        a aVar2 = a;
        String i3 = xVar.i("Collection");
        e eVar = e.BOOLEAN;
        String u10 = eVar.u();
        m.e(u10, "BOOLEAN.desc");
        a.C0327a m2 = aVar2.m(i3, "contains", "Ljava/lang/Object;", u10);
        c cVar = c.f23397h;
        String i4 = xVar.i("Collection");
        String u11 = eVar.u();
        m.e(u11, "BOOLEAN.desc");
        String i5 = xVar.i("Map");
        String u12 = eVar.u();
        m.e(u12, "BOOLEAN.desc");
        String i6 = xVar.i("Map");
        String u13 = eVar.u();
        m.e(u13, "BOOLEAN.desc");
        String i7 = xVar.i("Map");
        String u14 = eVar.u();
        m.e(u14, "BOOLEAN.desc");
        a.C0327a m3 = aVar2.m(xVar.i("Map"), "get", "Ljava/lang/Object;", "Ljava/lang/Object;");
        c cVar2 = c.f23395f;
        String i8 = xVar.i("List");
        e eVar2 = e.INT;
        String u15 = eVar2.u();
        m.e(u15, "INT.desc");
        a.C0327a m4 = aVar2.m(i8, "indexOf", "Ljava/lang/Object;", u15);
        c cVar3 = c.f23396g;
        String i9 = xVar.i("List");
        String u16 = eVar2.u();
        m.e(u16, "INT.desc");
        l2 = q0.l(s.a(m2, cVar), s.a(aVar2.m(i4, "remove", "Ljava/lang/Object;", u11), cVar), s.a(aVar2.m(i5, "containsKey", "Ljava/lang/Object;", u12), cVar), s.a(aVar2.m(i6, "containsValue", "Ljava/lang/Object;", u13), cVar), s.a(aVar2.m(i7, "remove", "Ljava/lang/Object;Ljava/lang/Object;", u14), cVar), s.a(aVar2.m(xVar.i("Map"), "getOrDefault", "Ljava/lang/Object;Ljava/lang/Object;", "Ljava/lang/Object;"), c.f23398i), s.a(m3, cVar2), s.a(aVar2.m(xVar.i("Map"), "remove", "Ljava/lang/Object;", "Ljava/lang/Object;"), cVar2), s.a(m4, cVar3), s.a(aVar2.m(i9, "lastIndexOf", "Ljava/lang/Object;", u16), cVar3));
        f23381e = l2;
        e2 = p0.e(l2.size());
        LinkedHashMap linkedHashMap = new LinkedHashMap(e2);
        Iterator<T> it3 = l2.entrySet().iterator();
        while (it3.hasNext()) {
            Map.Entry entry = (Map.Entry) it3.next();
            linkedHashMap.put(((a.C0327a) entry.getKey()).b(), entry.getValue());
        }
        f23382f = linkedHashMap;
        l3 = x0.l(f23381e.keySet(), f23378b);
        u4 = v.u(l3, 10);
        ArrayList arrayList4 = new ArrayList(u4);
        Iterator it4 = l3.iterator();
        while (it4.hasNext()) {
            arrayList4.add(((a.C0327a) it4.next()).a());
        }
        I0 = c0.I0(arrayList4);
        f23383g = I0;
        u5 = v.u(l3, 10);
        ArrayList arrayList5 = new ArrayList(u5);
        Iterator it5 = l3.iterator();
        while (it5.hasNext()) {
            arrayList5.add(((a.C0327a) it5.next()).b());
        }
        I02 = c0.I0(arrayList5);
        f23384h = I02;
        a aVar3 = a;
        e eVar3 = e.INT;
        String u17 = eVar3.u();
        m.e(u17, "INT.desc");
        a.C0327a m5 = aVar3.m("java/util/List", "removeAt", u17, "Ljava/lang/Object;");
        f23385i = m5;
        x xVar2 = x.a;
        String h2 = xVar2.h("Number");
        String u18 = e.BYTE.u();
        m.e(u18, "BYTE.desc");
        String h3 = xVar2.h("Number");
        String u19 = e.SHORT.u();
        m.e(u19, "SHORT.desc");
        String h4 = xVar2.h("Number");
        String u20 = eVar3.u();
        m.e(u20, "INT.desc");
        String h5 = xVar2.h("Number");
        String u21 = e.LONG.u();
        m.e(u21, "LONG.desc");
        String h6 = xVar2.h("Number");
        String u22 = e.FLOAT.u();
        m.e(u22, "FLOAT.desc");
        String h7 = xVar2.h("Number");
        String u23 = e.DOUBLE.u();
        m.e(u23, "DOUBLE.desc");
        String h8 = xVar2.h("CharSequence");
        String u24 = eVar3.u();
        m.e(u24, "INT.desc");
        String u25 = e.CHAR.u();
        m.e(u25, "CHAR.desc");
        l4 = q0.l(s.a(aVar3.m(h2, "toByte", HttpUrl.FRAGMENT_ENCODE_SET, u18), f.x("byteValue")), s.a(aVar3.m(h3, "toShort", HttpUrl.FRAGMENT_ENCODE_SET, u19), f.x("shortValue")), s.a(aVar3.m(h4, "toInt", HttpUrl.FRAGMENT_ENCODE_SET, u20), f.x("intValue")), s.a(aVar3.m(h5, "toLong", HttpUrl.FRAGMENT_ENCODE_SET, u21), f.x("longValue")), s.a(aVar3.m(h6, "toFloat", HttpUrl.FRAGMENT_ENCODE_SET, u22), f.x("floatValue")), s.a(aVar3.m(h7, "toDouble", HttpUrl.FRAGMENT_ENCODE_SET, u23), f.x("doubleValue")), s.a(m5, f.x("remove")), s.a(aVar3.m(h8, "get", u24, u25), f.x("charAt")));
        f23386j = l4;
        e3 = p0.e(l4.size());
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(e3);
        Iterator<T> it6 = l4.entrySet().iterator();
        while (it6.hasNext()) {
            Map.Entry entry2 = (Map.Entry) it6.next();
            linkedHashMap2.put(((a.C0327a) entry2.getKey()).b(), entry2.getValue());
        }
        f23387k = linkedHashMap2;
        Set<a.C0327a> keySet = f23386j.keySet();
        u6 = v.u(keySet, 10);
        ArrayList arrayList6 = new ArrayList(u6);
        Iterator<T> it7 = keySet.iterator();
        while (it7.hasNext()) {
            arrayList6.add(((a.C0327a) it7.next()).a());
        }
        l = arrayList6;
        Set<Map.Entry<a.C0327a, f>> entrySet = f23386j.entrySet();
        u7 = v.u(entrySet, 10);
        ArrayList<Pair> arrayList7 = new ArrayList(u7);
        Iterator<T> it8 = entrySet.iterator();
        while (it8.hasNext()) {
            Map.Entry entry3 = (Map.Entry) it8.next();
            arrayList7.add(new Pair(((a.C0327a) entry3.getKey()).a(), entry3.getValue()));
        }
        u8 = v.u(arrayList7, 10);
        e4 = p0.e(u8);
        b2 = l.b(e4, 16);
        LinkedHashMap linkedHashMap3 = new LinkedHashMap(b2);
        for (Pair pair : arrayList7) {
            linkedHashMap3.put((f) pair.d(), (f) pair.c());
        }
        m = linkedHashMap3;
    }
}
