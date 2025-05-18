package kotlin.reflect.y.internal.j0.i;

import cm.aptoide.pt.install.installer.RootCommandOnSubscribe;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Queue;
import java.util.ServiceLoader;
import java.util.Set;
import kotlin.Pair;
import kotlin.collections.c0;
import kotlin.collections.s;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.reflect.jvm.internal.impl.descriptors.b;
import kotlin.reflect.jvm.internal.impl.descriptors.d0;
import kotlin.reflect.jvm.internal.impl.descriptors.i1;
import kotlin.reflect.jvm.internal.impl.descriptors.m;
import kotlin.reflect.jvm.internal.impl.descriptors.p1.b0;
import kotlin.reflect.jvm.internal.impl.descriptors.p1.p;
import kotlin.reflect.jvm.internal.impl.descriptors.q;
import kotlin.reflect.jvm.internal.impl.descriptors.s0;
import kotlin.reflect.jvm.internal.impl.descriptors.t;
import kotlin.reflect.jvm.internal.impl.descriptors.t0;
import kotlin.reflect.jvm.internal.impl.descriptors.w0;
import kotlin.reflect.jvm.internal.impl.descriptors.y;
import kotlin.reflect.y.internal.j0.i.e;
import kotlin.reflect.y.internal.j0.l.d1;
import kotlin.reflect.y.internal.j0.l.e0;
import kotlin.reflect.y.internal.j0.l.e1;
import kotlin.reflect.y.internal.j0.l.g0;
import kotlin.reflect.y.internal.j0.l.t1.e;
import kotlin.reflect.y.internal.j0.l.t1.f;
import kotlin.reflect.y.internal.j0.l.t1.g;
import kotlin.u;

/* compiled from: OverridingUtil.java */
/* loaded from: classes3.dex */
public class j {
    private static final List<kotlin.reflect.y.internal.j0.i.e> a;

    /* renamed from: b, reason: collision with root package name */
    public static final j f24327b;

    /* renamed from: c, reason: collision with root package name */
    private static final e.a f24328c;

    /* renamed from: d, reason: collision with root package name */
    private final kotlin.reflect.y.internal.j0.l.t1.g f24329d;

    /* renamed from: e, reason: collision with root package name */
    private final kotlin.reflect.y.internal.j0.l.t1.f f24330e;

    /* renamed from: f, reason: collision with root package name */
    private final e.a f24331f;

    /* renamed from: g, reason: collision with root package name */
    private final Function2<e0, e0, Boolean> f24332g;

    /* compiled from: OverridingUtil.java */
    /* loaded from: classes3.dex */
    static class a implements e.a {
        a() {
        }

        private static /* synthetic */ void b(int i2) {
            Object[] objArr = new Object[3];
            if (i2 != 1) {
                objArr[0] = "a";
            } else {
                objArr[0] = "b";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil$1";
            objArr[2] = "equals";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // kotlin.f0.y.e.j0.l.t1.e.a
        public boolean a(e1 e1Var, e1 e1Var2) {
            if (e1Var == null) {
                b(0);
            }
            if (e1Var2 == null) {
                b(1);
            }
            return e1Var.equals(e1Var2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: Add missing generic type declarations: [D] */
    /* compiled from: OverridingUtil.java */
    /* loaded from: classes3.dex */
    public static class b<D> implements Function2<D, D, Pair<kotlin.reflect.jvm.internal.impl.descriptors.a, kotlin.reflect.jvm.internal.impl.descriptors.a>> {
        b() {
        }

        /* JADX WARN: Incorrect types in method signature: (TD;TD;)Lkotlin/m<Lkotlin/reflect/jvm/internal/impl/descriptors/a;Lkotlin/reflect/jvm/internal/impl/descriptors/a;>; */
        @Override // kotlin.jvm.functions.Function2
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Pair invoke(kotlin.reflect.jvm.internal.impl.descriptors.a aVar, kotlin.reflect.jvm.internal.impl.descriptors.a aVar2) {
            return new Pair(aVar, aVar2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OverridingUtil.java */
    /* loaded from: classes3.dex */
    public static class c implements Function1<kotlin.reflect.jvm.internal.impl.descriptors.b, Boolean> {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ m f24333f;

        c(m mVar) {
            this.f24333f = mVar;
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Boolean invoke(kotlin.reflect.jvm.internal.impl.descriptors.b bVar) {
            return Boolean.valueOf(bVar.b() == this.f24333f);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OverridingUtil.java */
    /* loaded from: classes3.dex */
    public static class d implements Function1<kotlin.reflect.jvm.internal.impl.descriptors.b, kotlin.reflect.jvm.internal.impl.descriptors.a> {
        d() {
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public kotlin.reflect.jvm.internal.impl.descriptors.b invoke(kotlin.reflect.jvm.internal.impl.descriptors.b bVar) {
            return bVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OverridingUtil.java */
    /* loaded from: classes3.dex */
    public static class e implements Function1<kotlin.reflect.jvm.internal.impl.descriptors.b, Boolean> {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ kotlin.reflect.jvm.internal.impl.descriptors.e f24334f;

        e(kotlin.reflect.jvm.internal.impl.descriptors.e eVar) {
            this.f24334f = eVar;
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Boolean invoke(kotlin.reflect.jvm.internal.impl.descriptors.b bVar) {
            boolean z = false;
            if (!t.g(bVar.getVisibility()) && t.h(bVar, this.f24334f, false)) {
                z = true;
            }
            return Boolean.valueOf(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OverridingUtil.java */
    /* loaded from: classes3.dex */
    public static class f implements Function1<kotlin.reflect.jvm.internal.impl.descriptors.b, kotlin.reflect.jvm.internal.impl.descriptors.a> {
        f() {
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public kotlin.reflect.jvm.internal.impl.descriptors.a invoke(kotlin.reflect.jvm.internal.impl.descriptors.b bVar) {
            return bVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OverridingUtil.java */
    /* loaded from: classes3.dex */
    public static class g implements Function1<kotlin.reflect.jvm.internal.impl.descriptors.b, u> {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ kotlin.reflect.y.internal.j0.i.i f24335f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ kotlin.reflect.jvm.internal.impl.descriptors.b f24336g;

        g(kotlin.reflect.y.internal.j0.i.i iVar, kotlin.reflect.jvm.internal.impl.descriptors.b bVar) {
            this.f24335f = iVar;
            this.f24336g = bVar;
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public u invoke(kotlin.reflect.jvm.internal.impl.descriptors.b bVar) {
            this.f24335f.b(this.f24336g, bVar);
            return u.a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OverridingUtil.java */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class h {
        static final /* synthetic */ int[] a;

        /* renamed from: b, reason: collision with root package name */
        static final /* synthetic */ int[] f24337b;

        /* renamed from: c, reason: collision with root package name */
        static final /* synthetic */ int[] f24338c;

        static {
            int[] iArr = new int[d0.values().length];
            f24338c = iArr;
            try {
                iArr[d0.FINAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f24338c[d0.SEALED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f24338c[d0.OPEN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f24338c[d0.ABSTRACT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[i.a.values().length];
            f24337b = iArr2;
            try {
                iArr2[i.a.OVERRIDABLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f24337b[i.a.CONFLICT.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f24337b[i.a.INCOMPATIBLE.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            int[] iArr3 = new int[e.b.values().length];
            a = iArr3;
            try {
                iArr3[e.b.OVERRIDABLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                a[e.b.CONFLICT.ordinal()] = 2;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                a[e.b.INCOMPATIBLE.ordinal()] = 3;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                a[e.b.UNKNOWN.ordinal()] = 4;
            } catch (NoSuchFieldError unused11) {
            }
        }
    }

    /* compiled from: OverridingUtil.java */
    /* loaded from: classes3.dex */
    public static class i {
        private static final i a = new i(a.OVERRIDABLE, "SUCCESS");

        /* renamed from: b, reason: collision with root package name */
        private final a f24339b;

        /* renamed from: c, reason: collision with root package name */
        private final String f24340c;

        /* compiled from: OverridingUtil.java */
        /* loaded from: classes3.dex */
        public enum a {
            OVERRIDABLE,
            INCOMPATIBLE,
            CONFLICT
        }

        public i(a aVar, String str) {
            if (aVar == null) {
                a(3);
            }
            if (str == null) {
                a(4);
            }
            this.f24339b = aVar;
            this.f24340c = str;
        }

        /* JADX WARN: Removed duplicated region for block: B:19:0x0038  */
        /* JADX WARN: Removed duplicated region for block: B:21:0x0049  */
        /* JADX WARN: Removed duplicated region for block: B:36:0x005a  */
        /* JADX WARN: Removed duplicated region for block: B:37:0x003b  */
        /* JADX WARN: Removed duplicated region for block: B:38:0x0040  */
        /* JADX WARN: Removed duplicated region for block: B:39:0x0045  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private static /* synthetic */ void a(int i2) {
            String format;
            String str = (i2 == 1 || i2 == 2 || i2 == 3 || i2 == 4) ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
            Object[] objArr = new Object[(i2 == 1 || i2 == 2 || i2 == 3 || i2 == 4) ? 3 : 2];
            if (i2 != 1 && i2 != 2) {
                if (i2 == 3) {
                    objArr[0] = RootCommandOnSubscribe.SUCCESS_OUTPUT_CONFIRMATION;
                } else if (i2 != 4) {
                    objArr[0] = "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil$OverrideCompatibilityInfo";
                }
                switch (i2) {
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                        objArr[1] = "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil$OverrideCompatibilityInfo";
                        break;
                    case 5:
                        objArr[1] = "getResult";
                        break;
                    case 6:
                        objArr[1] = "getDebugMessage";
                        break;
                    default:
                        objArr[1] = RootCommandOnSubscribe.SUCCESS_OUTPUT_CONFIRMATION;
                        break;
                }
                if (i2 != 1) {
                    objArr[2] = "incompatible";
                } else if (i2 == 2) {
                    objArr[2] = "conflict";
                } else if (i2 == 3 || i2 == 4) {
                    objArr[2] = "<init>";
                }
                format = String.format(str, objArr);
                if (i2 == 1 && i2 != 2 && i2 != 3 && i2 != 4) {
                    throw new IllegalStateException(format);
                }
                throw new IllegalArgumentException(format);
            }
            objArr[0] = "debugMessage";
            switch (i2) {
            }
            if (i2 != 1) {
            }
            format = String.format(str, objArr);
            if (i2 == 1) {
            }
            throw new IllegalArgumentException(format);
        }

        public static i b(String str) {
            if (str == null) {
                a(2);
            }
            return new i(a.CONFLICT, str);
        }

        public static i d(String str) {
            if (str == null) {
                a(1);
            }
            return new i(a.INCOMPATIBLE, str);
        }

        public static i e() {
            i iVar = a;
            if (iVar == null) {
                a(0);
            }
            return iVar;
        }

        public a c() {
            a aVar = this.f24339b;
            if (aVar == null) {
                a(5);
            }
            return aVar;
        }
    }

    static {
        List<kotlin.reflect.y.internal.j0.i.e> E0;
        E0 = c0.E0(ServiceLoader.load(kotlin.reflect.y.internal.j0.i.e.class, kotlin.reflect.y.internal.j0.i.e.class.getClassLoader()));
        a = E0;
        a aVar = new a();
        f24328c = aVar;
        f24327b = new j(aVar, g.a.a, f.a.a, null);
    }

    private j(e.a aVar, kotlin.reflect.y.internal.j0.l.t1.g gVar, kotlin.reflect.y.internal.j0.l.t1.f fVar, Function2<e0, e0, Boolean> function2) {
        if (aVar == null) {
            a(5);
        }
        if (gVar == null) {
            a(6);
        }
        if (fVar == null) {
            a(7);
        }
        this.f24331f = aVar;
        this.f24329d = gVar;
        this.f24330e = fVar;
        this.f24332g = function2;
    }

    private static boolean A(s0 s0Var, s0 s0Var2) {
        if (s0Var == null || s0Var2 == null) {
            return true;
        }
        return H(s0Var, s0Var2);
    }

    public static boolean B(kotlin.reflect.jvm.internal.impl.descriptors.a aVar, kotlin.reflect.jvm.internal.impl.descriptors.a aVar2) {
        if (aVar == null) {
            a(67);
        }
        if (aVar2 == null) {
            a(68);
        }
        e0 returnType = aVar.getReturnType();
        e0 returnType2 = aVar2.getReturnType();
        if (!H(aVar, aVar2)) {
            return false;
        }
        d1 l = f24327b.l(aVar.getTypeParameters(), aVar2.getTypeParameters());
        if (aVar instanceof y) {
            return G(aVar, returnType, aVar2, returnType2, l);
        }
        if (aVar instanceof t0) {
            t0 t0Var = (t0) aVar;
            t0 t0Var2 = (t0) aVar2;
            if (!A(t0Var.getSetter(), t0Var2.getSetter())) {
                return false;
            }
            if (t0Var.j0() && t0Var2.j0()) {
                return kotlin.reflect.y.internal.j0.l.f.a.k(l, returnType.R0(), returnType2.R0());
            }
            return (t0Var.j0() || !t0Var2.j0()) && G(aVar, returnType, aVar2, returnType2, l);
        }
        throw new IllegalArgumentException("Unexpected callable: " + aVar.getClass());
    }

    private static boolean C(kotlin.reflect.jvm.internal.impl.descriptors.a aVar, Collection<kotlin.reflect.jvm.internal.impl.descriptors.a> collection) {
        if (aVar == null) {
            a(71);
        }
        if (collection == null) {
            a(72);
        }
        Iterator<kotlin.reflect.jvm.internal.impl.descriptors.a> it = collection.iterator();
        while (it.hasNext()) {
            if (!B(aVar, it.next())) {
                return false;
            }
        }
        return true;
    }

    private static boolean G(kotlin.reflect.jvm.internal.impl.descriptors.a aVar, e0 e0Var, kotlin.reflect.jvm.internal.impl.descriptors.a aVar2, e0 e0Var2, d1 d1Var) {
        if (aVar == null) {
            a(73);
        }
        if (e0Var == null) {
            a(74);
        }
        if (aVar2 == null) {
            a(75);
        }
        if (e0Var2 == null) {
            a(76);
        }
        if (d1Var == null) {
            a(77);
        }
        return kotlin.reflect.y.internal.j0.l.f.a.r(d1Var, e0Var.R0(), e0Var2.R0());
    }

    private static boolean H(q qVar, q qVar2) {
        if (qVar == null) {
            a(69);
        }
        if (qVar2 == null) {
            a(70);
        }
        Integer d2 = t.d(qVar.getVisibility(), qVar2.getVisibility());
        return d2 == null || d2.intValue() >= 0;
    }

    public static boolean I(kotlin.reflect.jvm.internal.impl.descriptors.c0 c0Var, kotlin.reflect.jvm.internal.impl.descriptors.c0 c0Var2, boolean z) {
        if (c0Var == null) {
            a(57);
        }
        if (c0Var2 == null) {
            a(58);
        }
        return !t.g(c0Var2.getVisibility()) && t.h(c0Var2, c0Var, z);
    }

    public static <D extends kotlin.reflect.jvm.internal.impl.descriptors.a> boolean J(D d2, D d3, boolean z, boolean z2) {
        if (d2 == null) {
            a(13);
        }
        if (d3 == null) {
            a(14);
        }
        if (!d2.equals(d3) && kotlin.reflect.y.internal.j0.i.b.a.d(d2.a(), d3.a(), z, z2)) {
            return true;
        }
        kotlin.reflect.jvm.internal.impl.descriptors.a a2 = d3.a();
        Iterator it = kotlin.reflect.y.internal.j0.i.d.d(d2).iterator();
        while (it.hasNext()) {
            if (kotlin.reflect.y.internal.j0.i.b.a.d(a2, (kotlin.reflect.jvm.internal.impl.descriptors.a) it.next(), z, z2)) {
                return true;
            }
        }
        return false;
    }

    public static void K(kotlin.reflect.jvm.internal.impl.descriptors.b bVar, Function1<kotlin.reflect.jvm.internal.impl.descriptors.b, u> function1) {
        kotlin.reflect.jvm.internal.impl.descriptors.u uVar;
        if (bVar == null) {
            a(107);
        }
        for (kotlin.reflect.jvm.internal.impl.descriptors.b bVar2 : bVar.e()) {
            if (bVar2.getVisibility() == t.f25370g) {
                K(bVar2, function1);
            }
        }
        if (bVar.getVisibility() != t.f25370g) {
            return;
        }
        kotlin.reflect.jvm.internal.impl.descriptors.u h2 = h(bVar);
        if (h2 == null) {
            if (function1 != null) {
                function1.invoke(bVar);
            }
            uVar = t.f25368e;
        } else {
            uVar = h2;
        }
        if (bVar instanceof kotlin.reflect.jvm.internal.impl.descriptors.p1.c0) {
            ((kotlin.reflect.jvm.internal.impl.descriptors.p1.c0) bVar).d1(uVar);
            Iterator<s0> it = ((t0) bVar).x().iterator();
            while (it.hasNext()) {
                K(it.next(), h2 == null ? null : function1);
            }
            return;
        }
        if (bVar instanceof p) {
            ((p) bVar).k1(uVar);
            return;
        }
        b0 b0Var = (b0) bVar;
        b0Var.P0(uVar);
        if (uVar != b0Var.B0().getVisibility()) {
            b0Var.N0(false);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <H> H L(Collection<H> collection, Function1<H, kotlin.reflect.jvm.internal.impl.descriptors.a> function1) {
        List j0;
        if (collection == null) {
            a(78);
        }
        if (function1 == 0) {
            a(79);
        }
        if (collection.size() == 1) {
            H h2 = (H) s.T(collection);
            if (h2 == null) {
                a(80);
            }
            return h2;
        }
        ArrayList arrayList = new ArrayList(2);
        j0 = c0.j0(collection, function1);
        H h3 = (H) s.T(collection);
        kotlin.reflect.jvm.internal.impl.descriptors.a aVar = (kotlin.reflect.jvm.internal.impl.descriptors.a) function1.invoke(h3);
        for (H h4 : collection) {
            kotlin.reflect.jvm.internal.impl.descriptors.a aVar2 = (kotlin.reflect.jvm.internal.impl.descriptors.a) function1.invoke(h4);
            if (C(aVar2, j0)) {
                arrayList.add(h4);
            }
            if (B(aVar2, aVar) && !B(aVar, aVar2)) {
                h3 = h4;
            }
        }
        if (arrayList.isEmpty()) {
            if (h3 == null) {
                a(81);
            }
            return h3;
        }
        if (arrayList.size() == 1) {
            H h5 = (H) s.T(arrayList);
            if (h5 == null) {
                a(82);
            }
            return h5;
        }
        H h6 = null;
        Iterator it = arrayList.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (!kotlin.reflect.y.internal.j0.l.b0.b(((kotlin.reflect.jvm.internal.impl.descriptors.a) function1.invoke(next)).getReturnType())) {
                h6 = next;
                break;
            }
        }
        if (h6 != null) {
            return h6;
        }
        H h7 = (H) s.T(arrayList);
        if (h7 == null) {
            a(84);
        }
        return h7;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:93:0x0265. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:94:0x0268. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:95:0x026b. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:100:0x0277 A[FALL_THROUGH] */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x0120  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x0139  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x0141  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x014b  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x0150  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x0155  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x0058 A[FALL_THROUGH] */
    /* JADX WARN: Removed duplicated region for block: B:157:0x0035 A[FALL_THROUGH] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x016f A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x01b0  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x01b6  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x01bc  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x01c2  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x01c8  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x01ce  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x01d2  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x01d6  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x01da  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x01e0  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x01e4  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x01ea  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x01f0  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x01f6  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x01fb  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0200  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0205  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x020a  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x020f  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0214  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0219  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x021e  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0221  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0226  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0229  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x022c  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0231  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0234  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0239  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x023c  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0241  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0246  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x024b  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0255 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0268  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static /* synthetic */ void a(int i2) {
        String str;
        int i3;
        Object[] objArr;
        if (i2 != 11 && i2 != 12 && i2 != 16 && i2 != 21 && i2 != 95 && i2 != 98 && i2 != 103 && i2 != 44 && i2 != 45) {
            switch (i2) {
                default:
                    switch (i2) {
                        default:
                            switch (i2) {
                                default:
                                    switch (i2) {
                                        case 90:
                                        case 91:
                                        case 92:
                                            break;
                                        default:
                                            str = "Argument for @NotNull parameter '%s' of %s.%s must not be null";
                                            break;
                                    }
                                case 80:
                                case 81:
                                case 82:
                                case 83:
                                case 84:
                                    str = "@NotNull method %s.%s must not return null";
                                    break;
                            }
                        case 32:
                        case 33:
                        case 34:
                        case 35:
                        case 36:
                        case 37:
                        case 38:
                        case 39:
                            break;
                    }
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                    break;
            }
            if (i2 != 11 && i2 != 12 && i2 != 16 && i2 != 21 && i2 != 95 && i2 != 98 && i2 != 103 && i2 != 44 && i2 != 45) {
                switch (i2) {
                    default:
                        switch (i2) {
                            default:
                                switch (i2) {
                                    default:
                                        switch (i2) {
                                            case 90:
                                            case 91:
                                            case 92:
                                                break;
                                            default:
                                                i3 = 3;
                                                break;
                                        }
                                    case 80:
                                    case 81:
                                    case 82:
                                    case 83:
                                    case 84:
                                        i3 = 2;
                                        break;
                                }
                            case 32:
                            case 33:
                            case 34:
                            case 35:
                            case 36:
                            case 37:
                            case 38:
                            case 39:
                                break;
                        }
                    case 24:
                    case 25:
                    case 26:
                    case 27:
                    case 28:
                    case 29:
                        break;
                }
                objArr = new Object[i3];
                switch (i2) {
                    case 1:
                    case 7:
                        objArr[0] = "kotlinTypePreparator";
                        break;
                    case 2:
                        objArr[0] = "customSubtype";
                        break;
                    case 3:
                    case 6:
                    default:
                        objArr[0] = "kotlinTypeRefiner";
                        break;
                    case 4:
                        objArr[0] = "equalityAxioms";
                        break;
                    case 5:
                        objArr[0] = "axioms";
                        break;
                    case 8:
                    case 9:
                        objArr[0] = "candidateSet";
                        break;
                    case 10:
                        objArr[0] = "transformFirst";
                        break;
                    case 11:
                    case 12:
                    case 16:
                    case 21:
                    case 24:
                    case 25:
                    case 26:
                    case 27:
                    case 28:
                    case 29:
                    case 32:
                    case 33:
                    case 34:
                    case 35:
                    case 36:
                    case 37:
                    case 38:
                    case 39:
                    case 44:
                    case 45:
                    case 80:
                    case 81:
                    case 82:
                    case 83:
                    case 84:
                    case 90:
                    case 91:
                    case 92:
                    case 95:
                    case 98:
                    case 103:
                        objArr[0] = "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil";
                        break;
                    case 13:
                        objArr[0] = "f";
                        break;
                    case 14:
                        objArr[0] = "g";
                        break;
                    case 15:
                    case 17:
                        objArr[0] = "descriptor";
                        break;
                    case 18:
                        objArr[0] = "result";
                        break;
                    case 19:
                    case 22:
                    case 30:
                    case 40:
                        objArr[0] = "superDescriptor";
                        break;
                    case 20:
                    case 23:
                    case 31:
                    case 41:
                        objArr[0] = "subDescriptor";
                        break;
                    case 42:
                        objArr[0] = "firstParameters";
                        break;
                    case 43:
                        objArr[0] = "secondParameters";
                        break;
                    case 46:
                        objArr[0] = "typeInSuper";
                        break;
                    case 47:
                        objArr[0] = "typeInSub";
                        break;
                    case 48:
                    case 51:
                    case 77:
                        objArr[0] = "typeCheckerState";
                        break;
                    case 49:
                        objArr[0] = "superTypeParameter";
                        break;
                    case 50:
                        objArr[0] = "subTypeParameter";
                        break;
                    case 52:
                        objArr[0] = "name";
                        break;
                    case 53:
                        objArr[0] = "membersFromSupertypes";
                        break;
                    case 54:
                        objArr[0] = "membersFromCurrent";
                        break;
                    case 55:
                    case 61:
                    case 64:
                    case 86:
                    case 89:
                    case 96:
                        objArr[0] = "current";
                        break;
                    case 56:
                    case 62:
                    case 66:
                    case 87:
                    case 106:
                        objArr[0] = "strategy";
                        break;
                    case 57:
                        objArr[0] = "overriding";
                        break;
                    case 58:
                        objArr[0] = "fromSuper";
                        break;
                    case 59:
                        objArr[0] = "fromCurrent";
                        break;
                    case 60:
                        objArr[0] = "descriptorsFromSuper";
                        break;
                    case 63:
                    case 65:
                        objArr[0] = "notOverridden";
                        break;
                    case 67:
                    case 69:
                    case 73:
                        objArr[0] = "a";
                        break;
                    case 68:
                    case 70:
                    case 75:
                        objArr[0] = "b";
                        break;
                    case 71:
                        objArr[0] = "candidate";
                        break;
                    case 72:
                    case 88:
                    case 93:
                    case 109:
                        objArr[0] = "descriptors";
                        break;
                    case 74:
                        objArr[0] = "aReturnType";
                        break;
                    case 76:
                        objArr[0] = "bReturnType";
                        break;
                    case 78:
                    case 85:
                        objArr[0] = "overridables";
                        break;
                    case 79:
                    case 101:
                        objArr[0] = "descriptorByHandle";
                        break;
                    case 94:
                        objArr[0] = "classModality";
                        break;
                    case 97:
                        objArr[0] = "toFilter";
                        break;
                    case 99:
                    case 104:
                        objArr[0] = "overrider";
                        break;
                    case 100:
                    case 105:
                        objArr[0] = "extractFrom";
                        break;
                    case 102:
                        objArr[0] = "onConflict";
                        break;
                    case 107:
                    case 108:
                        objArr[0] = "memberDescriptor";
                        break;
                }
                if (i2 != 11 || i2 == 12) {
                    objArr[1] = "filterOverrides";
                } else if (i2 != 16) {
                    if (i2 != 21) {
                        if (i2 == 95) {
                            objArr[1] = "getMinimalModality";
                        } else if (i2 == 98) {
                            objArr[1] = "filterVisibleFakeOverrides";
                        } else if (i2 == 103) {
                            objArr[1] = "extractMembersOverridableInBothWays";
                        } else if (i2 != 44 && i2 != 45) {
                            switch (i2) {
                                case 24:
                                case 25:
                                case 26:
                                case 27:
                                case 28:
                                case 29:
                                    break;
                                default:
                                    switch (i2) {
                                        case 32:
                                        case 33:
                                        case 34:
                                        case 35:
                                        case 36:
                                        case 37:
                                        case 38:
                                        case 39:
                                            objArr[1] = "isOverridableByWithoutExternalConditions";
                                            break;
                                        default:
                                            switch (i2) {
                                                case 80:
                                                case 81:
                                                case 82:
                                                case 83:
                                                case 84:
                                                    objArr[1] = "selectMostSpecificMember";
                                                    break;
                                                default:
                                                    switch (i2) {
                                                        case 90:
                                                        case 91:
                                                        case 92:
                                                            objArr[1] = "determineModalityForFakeOverride";
                                                            break;
                                                        default:
                                                            objArr[1] = "kotlin/reflect/jvm/internal/impl/resolve/OverridingUtil";
                                                            break;
                                                    }
                                            }
                                    }
                            }
                        } else {
                            objArr[1] = "createTypeCheckerState";
                        }
                    }
                    objArr[1] = "isOverridableBy";
                } else {
                    objArr[1] = "getOverriddenDeclarations";
                }
                switch (i2) {
                    case 1:
                    case 2:
                        objArr[2] = "createWithTypePreparatorAndCustomSubtype";
                        break;
                    case 3:
                    case 4:
                        objArr[2] = "create";
                        break;
                    case 5:
                    case 6:
                    case 7:
                        objArr[2] = "<init>";
                        break;
                    case 8:
                        objArr[2] = "filterOutOverridden";
                        break;
                    case 9:
                    case 10:
                        objArr[2] = "filterOverrides";
                        break;
                    case 11:
                    case 12:
                    case 16:
                    case 21:
                    case 24:
                    case 25:
                    case 26:
                    case 27:
                    case 28:
                    case 29:
                    case 32:
                    case 33:
                    case 34:
                    case 35:
                    case 36:
                    case 37:
                    case 38:
                    case 39:
                    case 44:
                    case 45:
                    case 80:
                    case 81:
                    case 82:
                    case 83:
                    case 84:
                    case 90:
                    case 91:
                    case 92:
                    case 95:
                    case 98:
                    case 103:
                        break;
                    case 13:
                    case 14:
                        objArr[2] = "overrides";
                        break;
                    case 15:
                        objArr[2] = "getOverriddenDeclarations";
                        break;
                    case 17:
                    case 18:
                        objArr[2] = "collectOverriddenDeclarations";
                        break;
                    case 19:
                    case 20:
                    case 22:
                    case 23:
                        objArr[2] = "isOverridableBy";
                        break;
                    case 30:
                    case 31:
                        objArr[2] = "isOverridableByWithoutExternalConditions";
                        break;
                    case 40:
                    case 41:
                        objArr[2] = "getBasicOverridabilityProblem";
                        break;
                    case 42:
                    case 43:
                        objArr[2] = "createTypeCheckerState";
                        break;
                    case 46:
                    case 47:
                    case 48:
                        objArr[2] = "areTypesEquivalent";
                        break;
                    case 49:
                    case 50:
                    case 51:
                        objArr[2] = "areTypeParametersEquivalent";
                        break;
                    case 52:
                    case 53:
                    case 54:
                    case 55:
                    case 56:
                        objArr[2] = "generateOverridesInFunctionGroup";
                        break;
                    case 57:
                    case 58:
                        objArr[2] = "isVisibleForOverride";
                        break;
                    case 59:
                    case 60:
                    case 61:
                    case 62:
                        objArr[2] = "extractAndBindOverridesForMember";
                        break;
                    case 63:
                        objArr[2] = "allHasSameContainingDeclaration";
                        break;
                    case 64:
                    case 65:
                    case 66:
                        objArr[2] = "createAndBindFakeOverrides";
                        break;
                    case 67:
                    case 68:
                        objArr[2] = "isMoreSpecific";
                        break;
                    case 69:
                    case 70:
                        objArr[2] = "isVisibilityMoreSpecific";
                        break;
                    case 71:
                    case 72:
                        objArr[2] = "isMoreSpecificThenAllOf";
                        break;
                    case 73:
                    case 74:
                    case 75:
                    case 76:
                    case 77:
                        objArr[2] = "isReturnTypeMoreSpecific";
                        break;
                    case 78:
                    case 79:
                        objArr[2] = "selectMostSpecificMember";
                        break;
                    case 85:
                    case 86:
                    case 87:
                        objArr[2] = "createAndBindFakeOverride";
                        break;
                    case 88:
                    case 89:
                        objArr[2] = "determineModalityForFakeOverride";
                        break;
                    case 93:
                    case 94:
                        objArr[2] = "getMinimalModality";
                        break;
                    case 96:
                    case 97:
                        objArr[2] = "filterVisibleFakeOverrides";
                        break;
                    case 99:
                    case 100:
                    case 101:
                    case 102:
                    case 104:
                    case 105:
                    case 106:
                        objArr[2] = "extractMembersOverridableInBothWays";
                        break;
                    case 107:
                        objArr[2] = "resolveUnknownVisibilityForMember";
                        break;
                    case 108:
                        objArr[2] = "computeVisibilityToInherit";
                        break;
                    case 109:
                        objArr[2] = "findMaxVisibility";
                        break;
                    default:
                        objArr[2] = "createWithTypeRefiner";
                        break;
                }
                String format = String.format(str, objArr);
                if (i2 != 11 && i2 != 12 && i2 != 16 && i2 != 21 && i2 != 95 && i2 != 98 && i2 != 103 && i2 != 44 && i2 != 45) {
                    switch (i2) {
                        default:
                            switch (i2) {
                                default:
                                    switch (i2) {
                                        default:
                                            switch (i2) {
                                                case 90:
                                                case 91:
                                                case 92:
                                                    break;
                                                default:
                                                    throw new IllegalArgumentException(format);
                                            }
                                        case 80:
                                        case 81:
                                        case 82:
                                        case 83:
                                        case 84:
                                            throw new IllegalStateException(format);
                                    }
                                case 32:
                                case 33:
                                case 34:
                                case 35:
                                case 36:
                                case 37:
                                case 38:
                                case 39:
                                    break;
                            }
                        case 24:
                        case 25:
                        case 26:
                        case 27:
                        case 28:
                        case 29:
                            break;
                    }
                }
                throw new IllegalStateException(format);
            }
            i3 = 2;
            objArr = new Object[i3];
            switch (i2) {
            }
            if (i2 != 11) {
            }
            objArr[1] = "filterOverrides";
            switch (i2) {
            }
            String format2 = String.format(str, objArr);
            if (i2 != 11) {
                switch (i2) {
                }
            }
            throw new IllegalStateException(format2);
        }
        str = "@NotNull method %s.%s must not return null";
        if (i2 != 11) {
            switch (i2) {
            }
            objArr = new Object[i3];
            switch (i2) {
            }
            if (i2 != 11) {
            }
            objArr[1] = "filterOverrides";
            switch (i2) {
            }
            String format22 = String.format(str, objArr);
            if (i2 != 11) {
            }
            throw new IllegalStateException(format22);
        }
        i3 = 2;
        objArr = new Object[i3];
        switch (i2) {
        }
        if (i2 != 11) {
        }
        objArr[1] = "filterOverrides";
        switch (i2) {
        }
        String format222 = String.format(str, objArr);
        if (i2 != 11) {
        }
        throw new IllegalStateException(format222);
    }

    private static boolean b(Collection<kotlin.reflect.jvm.internal.impl.descriptors.b> collection) {
        boolean I;
        if (collection == null) {
            a(63);
        }
        if (collection.size() < 2) {
            return true;
        }
        I = c0.I(collection, new c(collection.iterator().next().b()));
        return I;
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0054, code lost:
    
        r1.remove();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static boolean c(kotlin.reflect.jvm.internal.impl.descriptors.e1 e1Var, kotlin.reflect.jvm.internal.impl.descriptors.e1 e1Var2, d1 d1Var) {
        if (e1Var == null) {
            a(49);
        }
        if (e1Var2 == null) {
            a(50);
        }
        if (d1Var == null) {
            a(51);
        }
        List<e0> upperBounds = e1Var.getUpperBounds();
        ArrayList arrayList = new ArrayList(e1Var2.getUpperBounds());
        if (upperBounds.size() != arrayList.size()) {
            return false;
        }
        for (e0 e0Var : upperBounds) {
            ListIterator listIterator = arrayList.listIterator();
            while (listIterator.hasNext()) {
                if (d(e0Var, (e0) listIterator.next(), d1Var)) {
                    break;
                }
            }
            return false;
        }
        return true;
    }

    private static boolean d(e0 e0Var, e0 e0Var2, d1 d1Var) {
        if (e0Var == null) {
            a(46);
        }
        if (e0Var2 == null) {
            a(47);
        }
        if (d1Var == null) {
            a(48);
        }
        if (g0.a(e0Var) && g0.a(e0Var2)) {
            return true;
        }
        return kotlin.reflect.y.internal.j0.l.f.a.k(d1Var, e0Var.R0(), e0Var2.R0());
    }

    private static i e(kotlin.reflect.jvm.internal.impl.descriptors.a aVar, kotlin.reflect.jvm.internal.impl.descriptors.a aVar2) {
        if ((aVar.m0() == null) != (aVar2.m0() == null)) {
            return i.d("Receiver presence mismatch");
        }
        if (aVar.f().size() != aVar2.f().size()) {
            return i.d("Value parameter number mismatch");
        }
        return null;
    }

    private static void f(kotlin.reflect.jvm.internal.impl.descriptors.b bVar, Set<kotlin.reflect.jvm.internal.impl.descriptors.b> set) {
        if (bVar == null) {
            a(17);
        }
        if (set == null) {
            a(18);
        }
        if (bVar.i().g()) {
            set.add(bVar);
            return;
        }
        if (!bVar.e().isEmpty()) {
            Iterator<? extends kotlin.reflect.jvm.internal.impl.descriptors.b> it = bVar.e().iterator();
            while (it.hasNext()) {
                f(it.next(), set);
            }
        } else {
            throw new IllegalStateException("No overridden descriptors found for (fake override) " + bVar);
        }
    }

    private static List<e0> g(kotlin.reflect.jvm.internal.impl.descriptors.a aVar) {
        w0 m0 = aVar.m0();
        ArrayList arrayList = new ArrayList();
        if (m0 != null) {
            arrayList.add(m0.getType());
        }
        Iterator<i1> it = aVar.f().iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getType());
        }
        return arrayList;
    }

    private static kotlin.reflect.jvm.internal.impl.descriptors.u h(kotlin.reflect.jvm.internal.impl.descriptors.b bVar) {
        if (bVar == null) {
            a(108);
        }
        Collection<? extends kotlin.reflect.jvm.internal.impl.descriptors.b> e2 = bVar.e();
        kotlin.reflect.jvm.internal.impl.descriptors.u u = u(e2);
        if (u == null) {
            return null;
        }
        if (bVar.i() == b.a.FAKE_OVERRIDE) {
            for (kotlin.reflect.jvm.internal.impl.descriptors.b bVar2 : e2) {
                if (bVar2.j() != d0.ABSTRACT && !bVar2.getVisibility().equals(u)) {
                    return null;
                }
            }
            return u;
        }
        return u.f();
    }

    public static j i(kotlin.reflect.y.internal.j0.l.t1.g gVar, e.a aVar) {
        if (gVar == null) {
            a(3);
        }
        if (aVar == null) {
            a(4);
        }
        return new j(aVar, gVar, f.a.a, null);
    }

    private static void j(Collection<kotlin.reflect.jvm.internal.impl.descriptors.b> collection, kotlin.reflect.jvm.internal.impl.descriptors.e eVar, kotlin.reflect.y.internal.j0.i.i iVar) {
        if (collection == null) {
            a(85);
        }
        if (eVar == null) {
            a(86);
        }
        if (iVar == null) {
            a(87);
        }
        Collection<kotlin.reflect.jvm.internal.impl.descriptors.b> t = t(eVar, collection);
        boolean isEmpty = t.isEmpty();
        if (!isEmpty) {
            collection = t;
        }
        kotlin.reflect.jvm.internal.impl.descriptors.b k0 = ((kotlin.reflect.jvm.internal.impl.descriptors.b) L(collection, new d())).k0(eVar, n(collection, eVar), isEmpty ? t.f25371h : t.f25370g, b.a.FAKE_OVERRIDE, false);
        iVar.d(k0, collection);
        iVar.a(k0);
    }

    private static void k(kotlin.reflect.jvm.internal.impl.descriptors.e eVar, Collection<kotlin.reflect.jvm.internal.impl.descriptors.b> collection, kotlin.reflect.y.internal.j0.i.i iVar) {
        if (eVar == null) {
            a(64);
        }
        if (collection == null) {
            a(65);
        }
        if (iVar == null) {
            a(66);
        }
        if (b(collection)) {
            Iterator<kotlin.reflect.jvm.internal.impl.descriptors.b> it = collection.iterator();
            while (it.hasNext()) {
                j(Collections.singleton(it.next()), eVar, iVar);
            }
        } else {
            LinkedList linkedList = new LinkedList(collection);
            while (!linkedList.isEmpty()) {
                j(q(p.a(linkedList), linkedList, iVar), eVar, iVar);
            }
        }
    }

    private d1 l(List<kotlin.reflect.jvm.internal.impl.descriptors.e1> list, List<kotlin.reflect.jvm.internal.impl.descriptors.e1> list2) {
        if (list == null) {
            a(42);
        }
        if (list2 == null) {
            a(43);
        }
        if (list.isEmpty()) {
            d1 H0 = new k(null, this.f24331f, this.f24329d, this.f24330e, this.f24332g).H0(true, true);
            if (H0 == null) {
                a(44);
            }
            return H0;
        }
        HashMap hashMap = new HashMap();
        for (int i2 = 0; i2 < list.size(); i2++) {
            hashMap.put(list.get(i2).h(), list2.get(i2).h());
        }
        d1 H02 = new k(hashMap, this.f24331f, this.f24329d, this.f24330e, this.f24332g).H0(true, true);
        if (H02 == null) {
            a(45);
        }
        return H02;
    }

    public static j m(kotlin.reflect.y.internal.j0.l.t1.g gVar) {
        if (gVar == null) {
            a(0);
        }
        return new j(f24328c, gVar, f.a.a, null);
    }

    private static d0 n(Collection<kotlin.reflect.jvm.internal.impl.descriptors.b> collection, kotlin.reflect.jvm.internal.impl.descriptors.e eVar) {
        if (collection == null) {
            a(88);
        }
        if (eVar == null) {
            a(89);
        }
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        for (kotlin.reflect.jvm.internal.impl.descriptors.b bVar : collection) {
            int i2 = h.f24338c[bVar.j().ordinal()];
            if (i2 == 1) {
                d0 d0Var = d0.FINAL;
                if (d0Var == null) {
                    a(90);
                }
                return d0Var;
            }
            if (i2 == 2) {
                throw new IllegalStateException("Member cannot have SEALED modality: " + bVar);
            }
            if (i2 == 3) {
                z2 = true;
            } else if (i2 == 4) {
                z3 = true;
            }
        }
        if (eVar.M() && eVar.j() != d0.ABSTRACT && eVar.j() != d0.SEALED) {
            z = true;
        }
        if (z2 && !z3) {
            d0 d0Var2 = d0.OPEN;
            if (d0Var2 == null) {
                a(91);
            }
            return d0Var2;
        }
        if (!z2 && z3) {
            d0 j2 = z ? eVar.j() : d0.ABSTRACT;
            if (j2 == null) {
                a(92);
            }
            return j2;
        }
        HashSet hashSet = new HashSet();
        Iterator<kotlin.reflect.jvm.internal.impl.descriptors.b> it = collection.iterator();
        while (it.hasNext()) {
            hashSet.addAll(z(it.next()));
        }
        return y(r(hashSet), z, eVar.j());
    }

    private Collection<kotlin.reflect.jvm.internal.impl.descriptors.b> o(kotlin.reflect.jvm.internal.impl.descriptors.b bVar, Collection<? extends kotlin.reflect.jvm.internal.impl.descriptors.b> collection, kotlin.reflect.jvm.internal.impl.descriptors.e eVar, kotlin.reflect.y.internal.j0.i.i iVar) {
        if (bVar == null) {
            a(59);
        }
        if (collection == null) {
            a(60);
        }
        if (eVar == null) {
            a(61);
        }
        if (iVar == null) {
            a(62);
        }
        ArrayList arrayList = new ArrayList(collection.size());
        kotlin.reflect.jvm.internal.impl.utils.f c2 = kotlin.reflect.jvm.internal.impl.utils.f.c();
        for (kotlin.reflect.jvm.internal.impl.descriptors.b bVar2 : collection) {
            i.a c3 = D(bVar2, bVar, eVar).c();
            boolean I = I(bVar, bVar2, false);
            int i2 = h.f24337b[c3.ordinal()];
            if (i2 == 1) {
                if (I) {
                    c2.add(bVar2);
                }
                arrayList.add(bVar2);
            } else if (i2 == 2) {
                if (I) {
                    iVar.c(bVar2, bVar);
                }
                arrayList.add(bVar2);
            }
        }
        iVar.d(bVar, c2);
        return arrayList;
    }

    public static <H> Collection<H> p(H h2, Collection<H> collection, Function1<H, kotlin.reflect.jvm.internal.impl.descriptors.a> function1, Function1<H, u> function12) {
        if (h2 == null) {
            a(99);
        }
        if (collection == null) {
            a(100);
        }
        if (function1 == null) {
            a(101);
        }
        if (function12 == null) {
            a(102);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(h2);
        kotlin.reflect.jvm.internal.impl.descriptors.a invoke = function1.invoke(h2);
        Iterator<H> it = collection.iterator();
        while (it.hasNext()) {
            H next = it.next();
            kotlin.reflect.jvm.internal.impl.descriptors.a invoke2 = function1.invoke(next);
            if (h2 == next) {
                it.remove();
            } else {
                i.a x = x(invoke, invoke2);
                if (x == i.a.OVERRIDABLE) {
                    arrayList.add(next);
                    it.remove();
                } else if (x == i.a.CONFLICT) {
                    function12.invoke(next);
                    it.remove();
                }
            }
        }
        return arrayList;
    }

    private static Collection<kotlin.reflect.jvm.internal.impl.descriptors.b> q(kotlin.reflect.jvm.internal.impl.descriptors.b bVar, Queue<kotlin.reflect.jvm.internal.impl.descriptors.b> queue, kotlin.reflect.y.internal.j0.i.i iVar) {
        if (bVar == null) {
            a(104);
        }
        if (queue == null) {
            a(105);
        }
        if (iVar == null) {
            a(106);
        }
        return p(bVar, queue, new f(), new g(iVar, bVar));
    }

    public static <D extends kotlin.reflect.jvm.internal.impl.descriptors.a> Set<D> r(Set<D> set) {
        if (set == null) {
            a(8);
        }
        return s(set, !set.isEmpty() && kotlin.reflect.y.internal.j0.i.t.a.q(kotlin.reflect.y.internal.j0.i.t.a.l(set.iterator().next())), null, new b());
    }

    public static <D> Set<D> s(Set<D> set, boolean z, Function0<?> function0, Function2<? super D, ? super D, Pair<kotlin.reflect.jvm.internal.impl.descriptors.a, kotlin.reflect.jvm.internal.impl.descriptors.a>> function2) {
        if (set == null) {
            a(9);
        }
        if (function2 == null) {
            a(10);
        }
        if (set.size() <= 1) {
            return set;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (Object obj : set) {
            if (function0 != null) {
                function0.invoke();
            }
            Iterator it = linkedHashSet.iterator();
            while (true) {
                if (it.hasNext()) {
                    Pair<kotlin.reflect.jvm.internal.impl.descriptors.a, kotlin.reflect.jvm.internal.impl.descriptors.a> invoke = function2.invoke(obj, (Object) it.next());
                    kotlin.reflect.jvm.internal.impl.descriptors.a a2 = invoke.a();
                    kotlin.reflect.jvm.internal.impl.descriptors.a b2 = invoke.b();
                    if (J(a2, b2, z, true)) {
                        it.remove();
                    } else if (J(b2, a2, z, true)) {
                        break;
                    }
                } else {
                    linkedHashSet.add(obj);
                    break;
                }
            }
        }
        return linkedHashSet;
    }

    private static Collection<kotlin.reflect.jvm.internal.impl.descriptors.b> t(kotlin.reflect.jvm.internal.impl.descriptors.e eVar, Collection<kotlin.reflect.jvm.internal.impl.descriptors.b> collection) {
        List Q;
        if (eVar == null) {
            a(96);
        }
        if (collection == null) {
            a(97);
        }
        Q = c0.Q(collection, new e(eVar));
        if (Q == null) {
            a(98);
        }
        return Q;
    }

    public static kotlin.reflect.jvm.internal.impl.descriptors.u u(Collection<? extends kotlin.reflect.jvm.internal.impl.descriptors.b> collection) {
        kotlin.reflect.jvm.internal.impl.descriptors.u uVar;
        if (collection == null) {
            a(109);
        }
        if (collection.isEmpty()) {
            return t.l;
        }
        Iterator<? extends kotlin.reflect.jvm.internal.impl.descriptors.b> it = collection.iterator();
        loop0: while (true) {
            uVar = null;
            while (it.hasNext()) {
                kotlin.reflect.jvm.internal.impl.descriptors.u visibility = it.next().getVisibility();
                if (uVar != null) {
                    Integer d2 = t.d(visibility, uVar);
                    if (d2 == null) {
                        break;
                    }
                    if (d2.intValue() > 0) {
                    }
                }
                uVar = visibility;
            }
        }
        if (uVar == null) {
            return null;
        }
        Iterator<? extends kotlin.reflect.jvm.internal.impl.descriptors.b> it2 = collection.iterator();
        while (it2.hasNext()) {
            Integer d3 = t.d(uVar, it2.next().getVisibility());
            if (d3 == null || d3.intValue() < 0) {
                return null;
            }
        }
        return uVar;
    }

    public static i w(kotlin.reflect.jvm.internal.impl.descriptors.a aVar, kotlin.reflect.jvm.internal.impl.descriptors.a aVar2) {
        boolean z;
        if (aVar == null) {
            a(40);
        }
        if (aVar2 == null) {
            a(41);
        }
        boolean z2 = aVar instanceof y;
        if ((z2 && !(aVar2 instanceof y)) || (((z = aVar instanceof t0)) && !(aVar2 instanceof t0))) {
            return i.d("Member kind mismatch");
        }
        if (!z2 && !z) {
            throw new IllegalArgumentException("This type of CallableDescriptor cannot be checked for overridability: " + aVar);
        }
        if (!aVar.getName().equals(aVar2.getName())) {
            return i.d("Name mismatch");
        }
        i e2 = e(aVar, aVar2);
        if (e2 != null) {
            return e2;
        }
        return null;
    }

    public static i.a x(kotlin.reflect.jvm.internal.impl.descriptors.a aVar, kotlin.reflect.jvm.internal.impl.descriptors.a aVar2) {
        j jVar = f24327b;
        i.a c2 = jVar.D(aVar2, aVar, null).c();
        i.a c3 = jVar.D(aVar, aVar2, null).c();
        i.a aVar3 = i.a.OVERRIDABLE;
        if (c2 == aVar3 && c3 == aVar3) {
            return aVar3;
        }
        i.a aVar4 = i.a.CONFLICT;
        return (c2 == aVar4 || c3 == aVar4) ? aVar4 : i.a.INCOMPATIBLE;
    }

    private static d0 y(Collection<kotlin.reflect.jvm.internal.impl.descriptors.b> collection, boolean z, d0 d0Var) {
        if (collection == null) {
            a(93);
        }
        if (d0Var == null) {
            a(94);
        }
        d0 d0Var2 = d0.ABSTRACT;
        for (kotlin.reflect.jvm.internal.impl.descriptors.b bVar : collection) {
            d0 j2 = (z && bVar.j() == d0.ABSTRACT) ? d0Var : bVar.j();
            if (j2.compareTo(d0Var2) < 0) {
                d0Var2 = j2;
            }
        }
        if (d0Var2 == null) {
            a(95);
        }
        return d0Var2;
    }

    public static Set<kotlin.reflect.jvm.internal.impl.descriptors.b> z(kotlin.reflect.jvm.internal.impl.descriptors.b bVar) {
        if (bVar == null) {
            a(15);
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        f(bVar, linkedHashSet);
        return linkedHashSet;
    }

    public i D(kotlin.reflect.jvm.internal.impl.descriptors.a aVar, kotlin.reflect.jvm.internal.impl.descriptors.a aVar2, kotlin.reflect.jvm.internal.impl.descriptors.e eVar) {
        if (aVar == null) {
            a(19);
        }
        if (aVar2 == null) {
            a(20);
        }
        i E = E(aVar, aVar2, eVar, false);
        if (E == null) {
            a(21);
        }
        return E;
    }

    public i E(kotlin.reflect.jvm.internal.impl.descriptors.a aVar, kotlin.reflect.jvm.internal.impl.descriptors.a aVar2, kotlin.reflect.jvm.internal.impl.descriptors.e eVar, boolean z) {
        if (aVar == null) {
            a(22);
        }
        if (aVar2 == null) {
            a(23);
        }
        i F = F(aVar, aVar2, z);
        boolean z2 = F.c() == i.a.OVERRIDABLE;
        for (kotlin.reflect.y.internal.j0.i.e eVar2 : a) {
            if (eVar2.a() != e.a.CONFLICTS_ONLY && (!z2 || eVar2.a() != e.a.SUCCESS_ONLY)) {
                int i2 = h.a[eVar2.b(aVar, aVar2, eVar).ordinal()];
                if (i2 == 1) {
                    z2 = true;
                } else {
                    if (i2 == 2) {
                        i b2 = i.b("External condition failed");
                        if (b2 == null) {
                            a(24);
                        }
                        return b2;
                    }
                    if (i2 == 3) {
                        i d2 = i.d("External condition");
                        if (d2 == null) {
                            a(25);
                        }
                        return d2;
                    }
                }
            }
        }
        if (!z2) {
            return F;
        }
        for (kotlin.reflect.y.internal.j0.i.e eVar3 : a) {
            if (eVar3.a() == e.a.CONFLICTS_ONLY) {
                int i3 = h.a[eVar3.b(aVar, aVar2, eVar).ordinal()];
                if (i3 == 1) {
                    throw new IllegalStateException("Contract violation in " + eVar3.getClass().getName() + " condition. It's not supposed to end with success");
                }
                if (i3 == 2) {
                    i b3 = i.b("External condition failed");
                    if (b3 == null) {
                        a(27);
                    }
                    return b3;
                }
                if (i3 == 3) {
                    i d3 = i.d("External condition");
                    if (d3 == null) {
                        a(28);
                    }
                    return d3;
                }
            }
        }
        i e2 = i.e();
        if (e2 == null) {
            a(29);
        }
        return e2;
    }

    public i F(kotlin.reflect.jvm.internal.impl.descriptors.a aVar, kotlin.reflect.jvm.internal.impl.descriptors.a aVar2, boolean z) {
        if (aVar == null) {
            a(30);
        }
        if (aVar2 == null) {
            a(31);
        }
        i w = w(aVar, aVar2);
        if (w != null) {
            return w;
        }
        List<e0> g2 = g(aVar);
        List<e0> g3 = g(aVar2);
        List<kotlin.reflect.jvm.internal.impl.descriptors.e1> typeParameters = aVar.getTypeParameters();
        List<kotlin.reflect.jvm.internal.impl.descriptors.e1> typeParameters2 = aVar2.getTypeParameters();
        int i2 = 0;
        if (typeParameters.size() != typeParameters2.size()) {
            while (i2 < g2.size()) {
                if (!kotlin.reflect.y.internal.j0.l.t1.e.a.b(g2.get(i2), g3.get(i2))) {
                    i d2 = i.d("Type parameter number mismatch");
                    if (d2 == null) {
                        a(33);
                    }
                    return d2;
                }
                i2++;
            }
            i b2 = i.b("Type parameter number mismatch");
            if (b2 == null) {
                a(34);
            }
            return b2;
        }
        d1 l = l(typeParameters, typeParameters2);
        for (int i3 = 0; i3 < typeParameters.size(); i3++) {
            if (!c(typeParameters.get(i3), typeParameters2.get(i3), l)) {
                i d3 = i.d("Type parameter bounds mismatch");
                if (d3 == null) {
                    a(35);
                }
                return d3;
            }
        }
        for (int i4 = 0; i4 < g2.size(); i4++) {
            if (!d(g2.get(i4), g3.get(i4), l)) {
                i d4 = i.d("Value parameter type mismatch");
                if (d4 == null) {
                    a(36);
                }
                return d4;
            }
        }
        if ((aVar instanceof y) && (aVar2 instanceof y) && ((y) aVar).isSuspend() != ((y) aVar2).isSuspend()) {
            i b3 = i.b("Incompatible suspendability");
            if (b3 == null) {
                a(37);
            }
            return b3;
        }
        if (z) {
            e0 returnType = aVar.getReturnType();
            e0 returnType2 = aVar2.getReturnType();
            if (returnType != null && returnType2 != null) {
                if (g0.a(returnType2) && g0.a(returnType)) {
                    i2 = 1;
                }
                if (i2 == 0 && !kotlin.reflect.y.internal.j0.l.f.a.r(l, returnType2.R0(), returnType.R0())) {
                    i b4 = i.b("Return type mismatch");
                    if (b4 == null) {
                        a(38);
                    }
                    return b4;
                }
            }
        }
        i e2 = i.e();
        if (e2 == null) {
            a(39);
        }
        return e2;
    }

    public void v(kotlin.reflect.y.internal.j0.f.f fVar, Collection<? extends kotlin.reflect.jvm.internal.impl.descriptors.b> collection, Collection<? extends kotlin.reflect.jvm.internal.impl.descriptors.b> collection2, kotlin.reflect.jvm.internal.impl.descriptors.e eVar, kotlin.reflect.y.internal.j0.i.i iVar) {
        if (fVar == null) {
            a(52);
        }
        if (collection == null) {
            a(53);
        }
        if (collection2 == null) {
            a(54);
        }
        if (eVar == null) {
            a(55);
        }
        if (iVar == null) {
            a(56);
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet(collection);
        Iterator<? extends kotlin.reflect.jvm.internal.impl.descriptors.b> it = collection2.iterator();
        while (it.hasNext()) {
            linkedHashSet.removeAll(o(it.next(), collection, eVar, iVar));
        }
        k(eVar, linkedHashSet, iVar);
    }
}
