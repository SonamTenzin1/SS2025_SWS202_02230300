package kotlin.reflect.y.internal.j0.e.a0.b;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.collections.IndexedValue;
import kotlin.collections.c0;
import kotlin.collections.p0;
import kotlin.collections.u;
import kotlin.collections.v;
import kotlin.jvm.internal.m;
import kotlin.ranges.l;
import kotlin.reflect.y.internal.j0.e.a0.a;
import kotlin.reflect.y.internal.j0.e.z.c;
import okhttp3.HttpUrl;

/* compiled from: JvmNameResolverBase.kt */
/* loaded from: classes3.dex */
public class g implements c {
    public static final a a = new a(null);

    /* renamed from: b, reason: collision with root package name */
    private static final String f23893b;

    /* renamed from: c, reason: collision with root package name */
    private static final List<String> f23894c;

    /* renamed from: d, reason: collision with root package name */
    private static final Map<String, Integer> f23895d;

    /* renamed from: e, reason: collision with root package name */
    private final String[] f23896e;

    /* renamed from: f, reason: collision with root package name */
    private final Set<Integer> f23897f;

    /* renamed from: g, reason: collision with root package name */
    private final List<a.e.c> f23898g;

    /* compiled from: JvmNameResolverBase.kt */
    /* loaded from: classes3.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
            this();
        }
    }

    /* compiled from: JvmNameResolverBase.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[a.e.c.EnumC0359c.values().length];
            iArr[a.e.c.EnumC0359c.NONE.ordinal()] = 1;
            iArr[a.e.c.EnumC0359c.INTERNAL_TO_CLASS_ID.ordinal()] = 2;
            iArr[a.e.c.EnumC0359c.DESC_TO_CLASS_ID.ordinal()] = 3;
            a = iArr;
        }
    }

    static {
        List m;
        String e0;
        List<String> m2;
        Iterable<IndexedValue> K0;
        int u;
        int e2;
        int b2;
        m = u.m('k', 'o', 't', 'l', 'i', 'n');
        e0 = c0.e0(m, HttpUrl.FRAGMENT_ENCODE_SET, null, null, 0, null, null, 62, null);
        f23893b = e0;
        m2 = u.m(e0 + "/Any", e0 + "/Nothing", e0 + "/Unit", e0 + "/Throwable", e0 + "/Number", e0 + "/Byte", e0 + "/Double", e0 + "/Float", e0 + "/Int", e0 + "/Long", e0 + "/Short", e0 + "/Boolean", e0 + "/Char", e0 + "/CharSequence", e0 + "/String", e0 + "/Comparable", e0 + "/Enum", e0 + "/Array", e0 + "/ByteArray", e0 + "/DoubleArray", e0 + "/FloatArray", e0 + "/IntArray", e0 + "/LongArray", e0 + "/ShortArray", e0 + "/BooleanArray", e0 + "/CharArray", e0 + "/Cloneable", e0 + "/Annotation", e0 + "/collections/Iterable", e0 + "/collections/MutableIterable", e0 + "/collections/Collection", e0 + "/collections/MutableCollection", e0 + "/collections/List", e0 + "/collections/MutableList", e0 + "/collections/Set", e0 + "/collections/MutableSet", e0 + "/collections/Map", e0 + "/collections/MutableMap", e0 + "/collections/Map.Entry", e0 + "/collections/MutableMap.MutableEntry", e0 + "/collections/Iterator", e0 + "/collections/MutableIterator", e0 + "/collections/ListIterator", e0 + "/collections/MutableListIterator");
        f23894c = m2;
        K0 = c0.K0(m2);
        u = v.u(K0, 10);
        e2 = p0.e(u);
        b2 = l.b(e2, 16);
        LinkedHashMap linkedHashMap = new LinkedHashMap(b2);
        for (IndexedValue indexedValue : K0) {
            linkedHashMap.put((String) indexedValue.d(), Integer.valueOf(indexedValue.c()));
        }
        f23895d = linkedHashMap;
    }

    public g(String[] strArr, Set<Integer> set, List<a.e.c> list) {
        m.f(strArr, "strings");
        m.f(set, "localNameIndices");
        m.f(list, "records");
        this.f23896e = strArr;
        this.f23897f = set;
        this.f23898g = list;
    }

    @Override // kotlin.reflect.y.internal.j0.e.z.c
    public String a(int i2) {
        return getString(i2);
    }

    @Override // kotlin.reflect.y.internal.j0.e.z.c
    public boolean b(int i2) {
        return this.f23897f.contains(Integer.valueOf(i2));
    }

    @Override // kotlin.reflect.y.internal.j0.e.z.c
    public String getString(int i2) {
        String str;
        a.e.c cVar = this.f23898g.get(i2);
        if (cVar.P()) {
            str = cVar.I();
        } else {
            if (cVar.N()) {
                List<String> list = f23894c;
                int size = list.size();
                int E = cVar.E();
                if (E >= 0 && E < size) {
                    str = list.get(cVar.E());
                }
            }
            str = this.f23896e[i2];
        }
        if (cVar.K() >= 2) {
            List<Integer> L = cVar.L();
            m.e(L, "substringIndexList");
            Integer num = L.get(0);
            Integer num2 = L.get(1);
            m.e(num, "begin");
            if (num.intValue() >= 0) {
                int intValue = num.intValue();
                m.e(num2, "end");
                if (intValue <= num2.intValue() && num2.intValue() <= str.length()) {
                    m.e(str, "string");
                    str = str.substring(num.intValue(), num2.intValue());
                    m.e(str, "this as java.lang.String…ing(startIndex, endIndex)");
                }
            }
        }
        String str2 = str;
        if (cVar.G() >= 2) {
            List<Integer> H = cVar.H();
            m.e(H, "replaceCharList");
            Integer num3 = H.get(0);
            Integer num4 = H.get(1);
            m.e(str2, "string");
            str2 = kotlin.text.u.z(str2, (char) num3.intValue(), (char) num4.intValue(), false, 4, null);
        }
        String str3 = str2;
        a.e.c.EnumC0359c D = cVar.D();
        if (D == null) {
            D = a.e.c.EnumC0359c.NONE;
        }
        int i3 = b.a[D.ordinal()];
        if (i3 == 2) {
            m.e(str3, "string");
            str3 = kotlin.text.u.z(str3, '$', '.', false, 4, null);
        } else if (i3 == 3) {
            if (str3.length() >= 2) {
                m.e(str3, "string");
                str3 = str3.substring(1, str3.length() - 1);
                m.e(str3, "this as java.lang.String…ing(startIndex, endIndex)");
            }
            String str4 = str3;
            m.e(str4, "string");
            str3 = kotlin.text.u.z(str4, '$', '.', false, 4, null);
        }
        m.e(str3, "string");
        return str3;
    }
}
