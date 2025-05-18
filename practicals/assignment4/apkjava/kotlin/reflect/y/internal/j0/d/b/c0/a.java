package kotlin.reflect.y.internal.j0.d.b.c0;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.p0;
import kotlin.collections.u;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.m;
import kotlin.ranges.l;
import kotlin.reflect.y.internal.j0.e.a0.b.e;

/* compiled from: KotlinClassHeader.kt */
/* loaded from: classes3.dex */
public final class a {
    private final EnumC0345a a;

    /* renamed from: b, reason: collision with root package name */
    private final e f23756b;

    /* renamed from: c, reason: collision with root package name */
    private final String[] f23757c;

    /* renamed from: d, reason: collision with root package name */
    private final String[] f23758d;

    /* renamed from: e, reason: collision with root package name */
    private final String[] f23759e;

    /* renamed from: f, reason: collision with root package name */
    private final String f23760f;

    /* renamed from: g, reason: collision with root package name */
    private final int f23761g;

    /* renamed from: h, reason: collision with root package name */
    private final String f23762h;

    /* renamed from: i, reason: collision with root package name */
    private final byte[] f23763i;

    /* compiled from: KotlinClassHeader.kt */
    /* renamed from: kotlin.f0.y.e.j0.d.b.c0.a$a, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public enum EnumC0345a {
        UNKNOWN(0),
        CLASS(1),
        FILE_FACADE(2),
        SYNTHETIC_CLASS(3),
        MULTIFILE_CLASS(4),
        MULTIFILE_CLASS_PART(5);


        /* renamed from: f, reason: collision with root package name */
        public static final C0346a f23764f = new C0346a(null);

        /* renamed from: g, reason: collision with root package name */
        private static final Map<Integer, EnumC0345a> f23765g;
        private final int o;

        /* compiled from: KotlinClassHeader.kt */
        /* renamed from: kotlin.f0.y.e.j0.d.b.c0.a$a$a, reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public static final class C0346a {
            private C0346a() {
            }

            public /* synthetic */ C0346a(g gVar) {
                this();
            }

            public final EnumC0345a a(int i2) {
                EnumC0345a enumC0345a = (EnumC0345a) EnumC0345a.f23765g.get(Integer.valueOf(i2));
                return enumC0345a == null ? EnumC0345a.UNKNOWN : enumC0345a;
            }
        }

        static {
            int e2;
            int b2;
            EnumC0345a[] values = values();
            e2 = p0.e(values.length);
            b2 = l.b(e2, 16);
            LinkedHashMap linkedHashMap = new LinkedHashMap(b2);
            for (EnumC0345a enumC0345a : values) {
                linkedHashMap.put(Integer.valueOf(enumC0345a.o), enumC0345a);
            }
            f23765g = linkedHashMap;
        }

        EnumC0345a(int i2) {
            this.o = i2;
        }

        public static final EnumC0345a q(int i2) {
            return f23764f.a(i2);
        }
    }

    public a(EnumC0345a enumC0345a, e eVar, String[] strArr, String[] strArr2, String[] strArr3, String str, int i2, String str2, byte[] bArr) {
        m.f(enumC0345a, "kind");
        m.f(eVar, "metadataVersion");
        this.a = enumC0345a;
        this.f23756b = eVar;
        this.f23757c = strArr;
        this.f23758d = strArr2;
        this.f23759e = strArr3;
        this.f23760f = str;
        this.f23761g = i2;
        this.f23762h = str2;
        this.f23763i = bArr;
    }

    private final boolean h(int i2, int i3) {
        return (i2 & i3) != 0;
    }

    public final String[] a() {
        return this.f23757c;
    }

    public final String[] b() {
        return this.f23758d;
    }

    public final EnumC0345a c() {
        return this.a;
    }

    public final e d() {
        return this.f23756b;
    }

    public final String e() {
        String str = this.f23760f;
        if (this.a == EnumC0345a.MULTIFILE_CLASS_PART) {
            return str;
        }
        return null;
    }

    public final List<String> f() {
        List<String> j2;
        String[] strArr = this.f23757c;
        if (!(this.a == EnumC0345a.MULTIFILE_CLASS)) {
            strArr = null;
        }
        List<String> c2 = strArr != null ? kotlin.collections.m.c(strArr) : null;
        if (c2 != null) {
            return c2;
        }
        j2 = u.j();
        return j2;
    }

    public final String[] g() {
        return this.f23759e;
    }

    public final boolean i() {
        return h(this.f23761g, 2);
    }

    public final boolean j() {
        return h(this.f23761g, 64) && !h(this.f23761g, 32);
    }

    public final boolean k() {
        return h(this.f23761g, 16) && !h(this.f23761g, 32);
    }

    public String toString() {
        return this.a + " version=" + this.f23756b;
    }
}
