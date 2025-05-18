package kotlin.reflect.y.internal.j0.i.w;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.c0;
import kotlin.collections.u;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.m;

/* compiled from: MemberScope.kt */
/* loaded from: classes3.dex */
public final class d {
    public static final a a;

    /* renamed from: b, reason: collision with root package name */
    private static int f24401b;

    /* renamed from: c, reason: collision with root package name */
    private static final int f24402c;

    /* renamed from: d, reason: collision with root package name */
    private static final int f24403d;

    /* renamed from: e, reason: collision with root package name */
    private static final int f24404e;

    /* renamed from: f, reason: collision with root package name */
    private static final int f24405f;

    /* renamed from: g, reason: collision with root package name */
    private static final int f24406g;

    /* renamed from: h, reason: collision with root package name */
    private static final int f24407h;

    /* renamed from: i, reason: collision with root package name */
    private static final int f24408i;

    /* renamed from: j, reason: collision with root package name */
    private static final int f24409j;

    /* renamed from: k, reason: collision with root package name */
    private static final int f24410k;
    private static final int l;
    public static final d m;
    public static final d n;
    public static final d o;
    public static final d p;
    public static final d q;
    public static final d r;
    public static final d s;
    public static final d t;
    public static final d u;
    public static final d v;
    private static final List<a.C0381a> w;
    private static final List<a.C0381a> x;
    private final List<c> y;
    private final int z;

    /* compiled from: MemberScope.kt */
    /* loaded from: classes3.dex */
    public static final class a {

        /* compiled from: MemberScope.kt */
        /* renamed from: kotlin.f0.y.e.j0.i.w.d$a$a, reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        private static final class C0381a {
            private final int a;

            /* renamed from: b, reason: collision with root package name */
            private final String f24411b;

            public C0381a(int i2, String str) {
                m.f(str, "name");
                this.a = i2;
                this.f24411b = str;
            }

            public final int a() {
                return this.a;
            }

            public final String b() {
                return this.f24411b;
            }
        }

        private a() {
        }

        public /* synthetic */ a(g gVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final int j() {
            int i2 = d.f24401b;
            a aVar = d.a;
            d.f24401b <<= 1;
            return i2;
        }

        public final int b() {
            return d.f24408i;
        }

        public final int c() {
            return d.f24409j;
        }

        public final int d() {
            return d.f24406g;
        }

        public final int e() {
            return d.f24402c;
        }

        public final int f() {
            return d.f24405f;
        }

        public final int g() {
            return d.f24403d;
        }

        public final int h() {
            return d.f24404e;
        }

        public final int i() {
            return d.f24407h;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static {
        a.C0381a c0381a;
        a.C0381a c0381a2;
        a aVar = new a(null);
        a = aVar;
        f24401b = 1;
        int j2 = aVar.j();
        f24402c = j2;
        int j3 = aVar.j();
        f24403d = j3;
        int j4 = aVar.j();
        f24404e = j4;
        int j5 = aVar.j();
        f24405f = j5;
        int j6 = aVar.j();
        f24406g = j6;
        int j7 = aVar.j();
        f24407h = j7;
        int j8 = aVar.j() - 1;
        f24408i = j8;
        int i2 = j2 | j3 | j4;
        f24409j = i2;
        int i3 = j3 | j6 | j7;
        f24410k = i3;
        int i4 = j6 | j7;
        l = i4;
        int i5 = 2;
        m = new d(j8, 0 == true ? 1 : 0, i5, 0 == true ? 1 : 0);
        n = new d(i4, 0 == true ? 1 : 0, i5, 0 == true ? 1 : 0);
        o = new d(j2, 0 == true ? 1 : 0, i5, 0 == true ? 1 : 0);
        p = new d(j3, 0 == true ? 1 : 0, i5, 0 == true ? 1 : 0);
        q = new d(j4, 0 == true ? 1 : 0, i5, 0 == true ? 1 : 0);
        r = new d(i2, 0 == true ? 1 : 0, i5, 0 == true ? 1 : 0);
        s = new d(j5, 0 == true ? 1 : 0, i5, 0 == true ? 1 : 0);
        t = new d(j6, 0 == true ? 1 : 0, i5, 0 == true ? 1 : 0);
        u = new d(j7, 0 == true ? 1 : 0, i5, 0 == true ? 1 : 0);
        v = new d(i3, 0 == true ? 1 : 0, i5, 0 == true ? 1 : 0);
        Field[] fields = d.class.getFields();
        m.e(fields, "T::class.java.fields");
        ArrayList<Field> arrayList = new ArrayList();
        for (Field field : fields) {
            if (Modifier.isStatic(field.getModifiers())) {
                arrayList.add(field);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (Field field2 : arrayList) {
            Object obj = field2.get(null);
            d dVar = obj instanceof d ? (d) obj : null;
            if (dVar != null) {
                int i6 = dVar.z;
                String name = field2.getName();
                m.e(name, "field.name");
                c0381a2 = new a.C0381a(i6, name);
            } else {
                c0381a2 = null;
            }
            if (c0381a2 != null) {
                arrayList2.add(c0381a2);
            }
        }
        w = arrayList2;
        Field[] fields2 = d.class.getFields();
        m.e(fields2, "T::class.java.fields");
        ArrayList arrayList3 = new ArrayList();
        for (Field field3 : fields2) {
            if (Modifier.isStatic(field3.getModifiers())) {
                arrayList3.add(field3);
            }
        }
        ArrayList<Field> arrayList4 = new ArrayList();
        for (Object obj2 : arrayList3) {
            if (m.a(((Field) obj2).getType(), Integer.TYPE)) {
                arrayList4.add(obj2);
            }
        }
        ArrayList arrayList5 = new ArrayList();
        for (Field field4 : arrayList4) {
            Object obj3 = field4.get(null);
            m.d(obj3, "null cannot be cast to non-null type kotlin.Int");
            int intValue = ((Integer) obj3).intValue();
            if (intValue == ((-intValue) & intValue)) {
                String name2 = field4.getName();
                m.e(name2, "field.name");
                c0381a = new a.C0381a(intValue, name2);
            } else {
                c0381a = null;
            }
            if (c0381a != null) {
                arrayList5.add(c0381a);
            }
        }
        x = arrayList5;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public d(int i2, List<? extends c> list) {
        m.f(list, "excludes");
        this.y = list;
        Iterator it = list.iterator();
        while (it.hasNext()) {
            i2 &= ((c) it.next()).a() ^ (-1);
        }
        this.z = i2;
    }

    public final boolean a(int i2) {
        return (i2 & this.z) != 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!m.a(d.class, obj != null ? obj.getClass() : null)) {
            return false;
        }
        m.d(obj, "null cannot be cast to non-null type org.jetbrains.kotlin.resolve.scopes.DescriptorKindFilter");
        d dVar = (d) obj;
        return m.a(this.y, dVar.y) && this.z == dVar.z;
    }

    public int hashCode() {
        return (this.y.hashCode() * 31) + this.z;
    }

    public final List<c> l() {
        return this.y;
    }

    public final int m() {
        return this.z;
    }

    public final d n(int i2) {
        int i3 = i2 & this.z;
        if (i3 == 0) {
            return null;
        }
        return new d(i3, this.y);
    }

    public String toString() {
        Object obj;
        Iterator<T> it = w.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (((a.C0381a) obj).a() == this.z) {
                break;
            }
        }
        a.C0381a c0381a = (a.C0381a) obj;
        String b2 = c0381a != null ? c0381a.b() : null;
        if (b2 == null) {
            List<a.C0381a> list = x;
            ArrayList arrayList = new ArrayList();
            for (a.C0381a c0381a2 : list) {
                String b3 = a(c0381a2.a()) ? c0381a2.b() : null;
                if (b3 != null) {
                    arrayList.add(b3);
                }
            }
            b2 = c0.e0(arrayList, " | ", null, null, 0, null, null, 62, null);
        }
        return "DescriptorKindFilter(" + b2 + ", " + this.y + ')';
    }

    public /* synthetic */ d(int i2, List list, int i3, g gVar) {
        this(i2, (i3 & 2) != 0 ? u.j() : list);
    }
}
