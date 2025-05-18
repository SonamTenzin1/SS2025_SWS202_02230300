package kotlin.reflect.jvm.internal.impl.descriptors.r1.b;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Function;
import kotlin.collections.q0;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function10;
import kotlin.jvm.functions.Function11;
import kotlin.jvm.functions.Function12;
import kotlin.jvm.functions.Function13;
import kotlin.jvm.functions.Function14;
import kotlin.jvm.functions.Function15;
import kotlin.jvm.functions.Function16;
import kotlin.jvm.functions.Function17;
import kotlin.jvm.functions.Function18;
import kotlin.jvm.functions.Function19;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function20;
import kotlin.jvm.functions.Function21;
import kotlin.jvm.functions.Function22;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.functions.Function7;
import kotlin.jvm.functions.Function8;
import kotlin.jvm.functions.Function9;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.g0;
import kotlin.reflect.KClass;
import kotlin.sequences.Sequence;

/* compiled from: reflectClassUtil.kt */
/* loaded from: classes2.dex */
public final class d {
    private static final List<KClass<? extends Object>> a;

    /* renamed from: b, reason: collision with root package name */
    private static final Map<Class<? extends Object>, Class<? extends Object>> f25337b;

    /* renamed from: c, reason: collision with root package name */
    private static final Map<Class<? extends Object>, Class<? extends Object>> f25338c;

    /* renamed from: d, reason: collision with root package name */
    private static final Map<Class<? extends Function<?>>, Integer> f25339d;

    /* compiled from: reflectClassUtil.kt */
    /* loaded from: classes2.dex */
    static final class a extends Lambda implements Function1<ParameterizedType, ParameterizedType> {

        /* renamed from: f, reason: collision with root package name */
        public static final a f25340f = new a();

        a() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final ParameterizedType invoke(ParameterizedType parameterizedType) {
            kotlin.jvm.internal.m.f(parameterizedType, "it");
            Type ownerType = parameterizedType.getOwnerType();
            if (ownerType instanceof ParameterizedType) {
                return (ParameterizedType) ownerType;
            }
            return null;
        }
    }

    /* compiled from: reflectClassUtil.kt */
    /* loaded from: classes2.dex */
    static final class b extends Lambda implements Function1<ParameterizedType, Sequence<? extends Type>> {

        /* renamed from: f, reason: collision with root package name */
        public static final b f25341f = new b();

        b() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Sequence<Type> invoke(ParameterizedType parameterizedType) {
            Sequence<Type> r;
            kotlin.jvm.internal.m.f(parameterizedType, "it");
            Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
            kotlin.jvm.internal.m.e(actualTypeArguments, "it.actualTypeArguments");
            r = kotlin.collections.n.r(actualTypeArguments);
            return r;
        }
    }

    static {
        List<KClass<? extends Object>> m;
        int u;
        Map<Class<? extends Object>, Class<? extends Object>> q;
        int u2;
        Map<Class<? extends Object>, Class<? extends Object>> q2;
        List m2;
        int u3;
        Map<Class<? extends Function<?>>, Integer> q3;
        int i2 = 0;
        m = kotlin.collections.u.m(g0.b(Boolean.TYPE), g0.b(Byte.TYPE), g0.b(Character.TYPE), g0.b(Double.TYPE), g0.b(Float.TYPE), g0.b(Integer.TYPE), g0.b(Long.TYPE), g0.b(Short.TYPE));
        a = m;
        u = kotlin.collections.v.u(m, 10);
        ArrayList arrayList = new ArrayList(u);
        Iterator<T> it = m.iterator();
        while (it.hasNext()) {
            KClass kClass = (KClass) it.next();
            arrayList.add(kotlin.s.a(kotlin.jvm.a.c(kClass), kotlin.jvm.a.d(kClass)));
        }
        q = q0.q(arrayList);
        f25337b = q;
        List<KClass<? extends Object>> list = a;
        u2 = kotlin.collections.v.u(list, 10);
        ArrayList arrayList2 = new ArrayList(u2);
        Iterator<T> it2 = list.iterator();
        while (it2.hasNext()) {
            KClass kClass2 = (KClass) it2.next();
            arrayList2.add(kotlin.s.a(kotlin.jvm.a.d(kClass2), kotlin.jvm.a.c(kClass2)));
        }
        q2 = q0.q(arrayList2);
        f25338c = q2;
        m2 = kotlin.collections.u.m(Function0.class, Function1.class, Function2.class, Function3.class, Function4.class, Function5.class, Function6.class, Function7.class, Function8.class, Function9.class, Function10.class, Function11.class, Function12.class, Function13.class, Function14.class, Function15.class, Function16.class, Function17.class, Function18.class, Function19.class, Function20.class, Function21.class, Function22.class);
        u3 = kotlin.collections.v.u(m2, 10);
        ArrayList arrayList3 = new ArrayList(u3);
        for (Object obj : m2) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                kotlin.collections.u.t();
            }
            arrayList3.add(kotlin.s.a((Class) obj, Integer.valueOf(i2)));
            i2 = i3;
        }
        q3 = q0.q(arrayList3);
        f25339d = q3;
    }

    public static final kotlin.reflect.y.internal.j0.f.b a(Class<?> cls) {
        kotlin.reflect.y.internal.j0.f.b m;
        kotlin.reflect.y.internal.j0.f.b a2;
        kotlin.jvm.internal.m.f(cls, "<this>");
        if (!cls.isPrimitive()) {
            if (!cls.isArray()) {
                if (cls.getEnclosingMethod() == null && cls.getEnclosingConstructor() == null) {
                    String simpleName = cls.getSimpleName();
                    kotlin.jvm.internal.m.e(simpleName, "simpleName");
                    if (!(simpleName.length() == 0)) {
                        Class<?> declaringClass = cls.getDeclaringClass();
                        if (declaringClass == null || (a2 = a(declaringClass)) == null || (m = a2.d(kotlin.reflect.y.internal.j0.f.f.x(cls.getSimpleName()))) == null) {
                            m = kotlin.reflect.y.internal.j0.f.b.m(new kotlin.reflect.y.internal.j0.f.c(cls.getName()));
                        }
                        kotlin.jvm.internal.m.e(m, "declaringClass?.classId?…Id.topLevel(FqName(name))");
                        return m;
                    }
                }
                kotlin.reflect.y.internal.j0.f.c cVar = new kotlin.reflect.y.internal.j0.f.c(cls.getName());
                return new kotlin.reflect.y.internal.j0.f.b(cVar.e(), kotlin.reflect.y.internal.j0.f.c.k(cVar.g()), true);
            }
            throw new IllegalArgumentException("Can't compute ClassId for array type: " + cls);
        }
        throw new IllegalArgumentException("Can't compute ClassId for primitive type: " + cls);
    }

    public static final String b(Class<?> cls) {
        String z;
        String z2;
        kotlin.jvm.internal.m.f(cls, "<this>");
        if (cls.isPrimitive()) {
            String name = cls.getName();
            switch (name.hashCode()) {
                case -1325958191:
                    if (name.equals("double")) {
                        return "D";
                    }
                    break;
                case 104431:
                    if (name.equals("int")) {
                        return "I";
                    }
                    break;
                case 3039496:
                    if (name.equals("byte")) {
                        return "B";
                    }
                    break;
                case 3052374:
                    if (name.equals("char")) {
                        return "C";
                    }
                    break;
                case 3327612:
                    if (name.equals("long")) {
                        return "J";
                    }
                    break;
                case 3625364:
                    if (name.equals("void")) {
                        return "V";
                    }
                    break;
                case 64711720:
                    if (name.equals("boolean")) {
                        return "Z";
                    }
                    break;
                case 97526364:
                    if (name.equals("float")) {
                        return "F";
                    }
                    break;
                case 109413500:
                    if (name.equals("short")) {
                        return "S";
                    }
                    break;
            }
            throw new IllegalArgumentException("Unsupported primitive type: " + cls);
        }
        if (cls.isArray()) {
            String name2 = cls.getName();
            kotlin.jvm.internal.m.e(name2, "name");
            z2 = kotlin.text.u.z(name2, '.', '/', false, 4, null);
            return z2;
        }
        StringBuilder sb = new StringBuilder();
        sb.append('L');
        String name3 = cls.getName();
        kotlin.jvm.internal.m.e(name3, "name");
        z = kotlin.text.u.z(name3, '.', '/', false, 4, null);
        sb.append(z);
        sb.append(';');
        return sb.toString();
    }

    public static final List<Type> c(Type type) {
        Sequence f2;
        Sequence p;
        List<Type> A;
        List<Type> Z;
        List<Type> j2;
        kotlin.jvm.internal.m.f(type, "<this>");
        if (!(type instanceof ParameterizedType)) {
            j2 = kotlin.collections.u.j();
            return j2;
        }
        ParameterizedType parameterizedType = (ParameterizedType) type;
        if (parameterizedType.getOwnerType() == null) {
            Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
            kotlin.jvm.internal.m.e(actualTypeArguments, "actualTypeArguments");
            Z = kotlin.collections.n.Z(actualTypeArguments);
            return Z;
        }
        f2 = kotlin.sequences.l.f(type, a.f25340f);
        p = kotlin.sequences.n.p(f2, b.f25341f);
        A = kotlin.sequences.n.A(p);
        return A;
    }

    public static final Class<?> d(Class<?> cls) {
        kotlin.jvm.internal.m.f(cls, "<this>");
        return f25337b.get(cls);
    }

    public static final ClassLoader e(Class<?> cls) {
        kotlin.jvm.internal.m.f(cls, "<this>");
        ClassLoader classLoader = cls.getClassLoader();
        if (classLoader != null) {
            return classLoader;
        }
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        kotlin.jvm.internal.m.e(systemClassLoader, "getSystemClassLoader()");
        return systemClassLoader;
    }

    public static final Class<?> f(Class<?> cls) {
        kotlin.jvm.internal.m.f(cls, "<this>");
        return f25338c.get(cls);
    }

    public static final boolean g(Class<?> cls) {
        kotlin.jvm.internal.m.f(cls, "<this>");
        return Enum.class.isAssignableFrom(cls);
    }
}
