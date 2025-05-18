package kotlin.reflect.y.internal.calls;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.collections.c0;
import kotlin.collections.j;
import kotlin.collections.n;
import kotlin.collections.v;
import kotlin.i;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.m;
import kotlin.reflect.KClass;
import kotlin.reflect.y.internal.KotlinReflectionInternalError;
import okhttp3.HttpUrl;

/* compiled from: AnnotationConstructorCaller.kt */
@Metadata(d1 = {"\u00004\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u001aI\u0010\u0000\u001a\u0002H\u0001\"\b\b\u0000\u0010\u0001*\u00020\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00010\u00042\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00020\u00062\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0000¢\u0006\u0002\u0010\u000b\u001a$\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00072\n\u0010\u0011\u001a\u0006\u0012\u0002\b\u00030\u0004H\u0002\u001a\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0002*\u0004\u0018\u00010\u00022\n\u0010\u0013\u001a\u0006\u0012\u0002\b\u00030\u0004H\u0002¨\u0006\u0014²\u0006\u0014\u0010\u0015\u001a\u00020\u000f\"\b\b\u0000\u0010\u0001*\u00020\u0002X\u008a\u0084\u0002²\u0006\u0014\u0010\u0016\u001a\u00020\u0007\"\b\b\u0000\u0010\u0001*\u00020\u0002X\u008a\u0084\u0002"}, d2 = {"createAnnotationInstance", "T", HttpUrl.FRAGMENT_ENCODE_SET, "annotationClass", "Ljava/lang/Class;", "values", HttpUrl.FRAGMENT_ENCODE_SET, HttpUrl.FRAGMENT_ENCODE_SET, "methods", HttpUrl.FRAGMENT_ENCODE_SET, "Ljava/lang/reflect/Method;", "(Ljava/lang/Class;Ljava/util/Map;Ljava/util/List;)Ljava/lang/Object;", "throwIllegalArgumentType", HttpUrl.FRAGMENT_ENCODE_SET, "index", HttpUrl.FRAGMENT_ENCODE_SET, "name", "expectedJvmType", "transformKotlinToJvm", "expectedType", "kotlin-reflection", "hashCode", "toString"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes2.dex */
public final class b {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AnnotationConstructorCaller.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", HttpUrl.FRAGMENT_ENCODE_SET, "T", HttpUrl.FRAGMENT_ENCODE_SET, "invoke", "()Ljava/lang/Integer;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class a extends Lambda implements Function0<Integer> {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ Map<String, Object> f23119f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(Map<String, ? extends Object> map) {
            super(0);
            this.f23119f = map;
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Integer invoke() {
            int hashCode;
            Iterator<T> it = this.f23119f.entrySet().iterator();
            int i2 = 0;
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                String str = (String) entry.getKey();
                Object value = entry.getValue();
                if (value instanceof boolean[]) {
                    hashCode = Arrays.hashCode((boolean[]) value);
                } else if (value instanceof char[]) {
                    hashCode = Arrays.hashCode((char[]) value);
                } else if (value instanceof byte[]) {
                    hashCode = Arrays.hashCode((byte[]) value);
                } else if (value instanceof short[]) {
                    hashCode = Arrays.hashCode((short[]) value);
                } else if (value instanceof int[]) {
                    hashCode = Arrays.hashCode((int[]) value);
                } else if (value instanceof float[]) {
                    hashCode = Arrays.hashCode((float[]) value);
                } else if (value instanceof long[]) {
                    hashCode = Arrays.hashCode((long[]) value);
                } else if (value instanceof double[]) {
                    hashCode = Arrays.hashCode((double[]) value);
                } else {
                    hashCode = value instanceof Object[] ? Arrays.hashCode((Object[]) value) : value.hashCode();
                }
                i2 += hashCode ^ (str.hashCode() * 127);
            }
            return Integer.valueOf(i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AnnotationConstructorCaller.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001\"\b\b\u0000\u0010\u0003*\u00020\u00012\u000e\u0010\u0004\u001a\n \u0002*\u0004\u0018\u00010\u00010\u00012\u000e\u0010\u0005\u001a\n \u0002*\u0004\u0018\u00010\u00060\u00062,\u0010\u0007\u001a(\u0012\f\u0012\n \u0002*\u0004\u0018\u00010\u00010\u0001 \u0002*\u0014\u0012\u000e\b\u0001\u0012\n \u0002*\u0004\u0018\u00010\u00010\u0001\u0018\u00010\b0\bH\n¢\u0006\u0004\b\t\u0010\n"}, d2 = {"<anonymous>", HttpUrl.FRAGMENT_ENCODE_SET, "kotlin.jvm.PlatformType", "T", "<anonymous parameter 0>", "method", "Ljava/lang/reflect/Method;", "args", HttpUrl.FRAGMENT_ENCODE_SET, "invoke", "(Ljava/lang/Object;Ljava/lang/reflect/Method;[Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* renamed from: kotlin.f0.y.e.i0.b$b, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class C0318b implements InvocationHandler {
        final /* synthetic */ Class<T> a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Map<String, Object> f23120b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Lazy<String> f23121c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Lazy<Integer> f23122d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ List<Method> f23123e;

        C0318b(Class<T> cls, Map<String, ? extends Object> map, Lazy<String> lazy, Lazy<Integer> lazy2, List<Method> list) {
            this.a = cls;
            this.f23120b = map;
            this.f23121c = lazy;
            this.f23122d = lazy2;
            this.f23123e = list;
        }

        @Override // java.lang.reflect.InvocationHandler
        public final Object invoke(Object obj, Method method, Object[] objArr) {
            List Z;
            String name = method.getName();
            if (name != null) {
                int hashCode = name.hashCode();
                if (hashCode != -1776922004) {
                    if (hashCode != 147696667) {
                        if (hashCode == 1444986633 && name.equals("annotationType")) {
                            return this.a;
                        }
                    } else if (name.equals("hashCode")) {
                        return Integer.valueOf(b.i(this.f23122d));
                    }
                } else if (name.equals("toString")) {
                    return b.j(this.f23121c);
                }
            }
            if (m.a(name, "equals")) {
                if (objArr != null && objArr.length == 1) {
                    Class<T> cls = this.a;
                    List<Method> list = this.f23123e;
                    Map<String, Object> map = this.f23120b;
                    m.e(objArr, "args");
                    return Boolean.valueOf(b.h(cls, list, map, j.N(objArr)));
                }
            }
            if (this.f23120b.containsKey(name)) {
                return this.f23120b.get(name);
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Method is not supported: ");
            sb.append(method);
            sb.append(" (args: ");
            if (objArr == null) {
                objArr = new Object[0];
            }
            Z = n.Z(objArr);
            sb.append(Z);
            sb.append(')');
            throw new KotlinReflectionInternalError(sb.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AnnotationConstructorCaller.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", HttpUrl.FRAGMENT_ENCODE_SET, "T", HttpUrl.FRAGMENT_ENCODE_SET, "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class c extends Lambda implements Function0<String> {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ Class<T> f23124f;

        /* renamed from: g, reason: collision with root package name */
        final /* synthetic */ Map<String, Object> f23125g;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: AnnotationConstructorCaller.kt */
        @Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010&\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00030\u0005H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", HttpUrl.FRAGMENT_ENCODE_SET, "T", HttpUrl.FRAGMENT_ENCODE_SET, "entry", HttpUrl.FRAGMENT_ENCODE_SET, HttpUrl.FRAGMENT_ENCODE_SET, "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
        /* loaded from: classes2.dex */
        public static final class a extends Lambda implements Function1<Map.Entry<? extends String, ? extends Object>, CharSequence> {

            /* renamed from: f, reason: collision with root package name */
            public static final a f23126f = new a();

            a() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public final CharSequence invoke(Map.Entry<String, ? extends Object> entry) {
                String obj;
                m.f(entry, "entry");
                String key = entry.getKey();
                Object value = entry.getValue();
                if (value instanceof boolean[]) {
                    obj = Arrays.toString((boolean[]) value);
                    m.e(obj, "toString(this)");
                } else if (value instanceof char[]) {
                    obj = Arrays.toString((char[]) value);
                    m.e(obj, "toString(this)");
                } else if (value instanceof byte[]) {
                    obj = Arrays.toString((byte[]) value);
                    m.e(obj, "toString(this)");
                } else if (value instanceof short[]) {
                    obj = Arrays.toString((short[]) value);
                    m.e(obj, "toString(this)");
                } else if (value instanceof int[]) {
                    obj = Arrays.toString((int[]) value);
                    m.e(obj, "toString(this)");
                } else if (value instanceof float[]) {
                    obj = Arrays.toString((float[]) value);
                    m.e(obj, "toString(this)");
                } else if (value instanceof long[]) {
                    obj = Arrays.toString((long[]) value);
                    m.e(obj, "toString(this)");
                } else if (value instanceof double[]) {
                    obj = Arrays.toString((double[]) value);
                    m.e(obj, "toString(this)");
                } else if (value instanceof Object[]) {
                    obj = Arrays.toString((Object[]) value);
                    m.e(obj, "toString(this)");
                } else {
                    obj = value.toString();
                }
                return key + '=' + obj;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(Class<T> cls, Map<String, ? extends Object> map) {
            super(0);
            this.f23124f = cls;
            this.f23125g = map;
        }

        @Override // kotlin.jvm.functions.Function0
        public final String invoke() {
            Class<T> cls = this.f23124f;
            Map<String, Object> map = this.f23125g;
            StringBuilder sb = new StringBuilder();
            sb.append('@');
            sb.append(cls.getCanonicalName());
            c0.c0(map.entrySet(), sb, ", ", "(", ")", 0, null, a.f23126f, 48, null);
            String sb2 = sb.toString();
            m.e(sb2, "StringBuilder().apply(builderAction).toString()");
            return sb2;
        }
    }

    public static final <T> T f(Class<T> cls, Map<String, ? extends Object> map, List<Method> list) {
        Lazy b2;
        Lazy b3;
        m.f(cls, "annotationClass");
        m.f(map, "values");
        m.f(list, "methods");
        b2 = i.b(new a(map));
        b3 = i.b(new c(cls, map));
        T t = (T) Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, new C0318b(cls, map, b3, b2, list));
        m.d(t, "null cannot be cast to non-null type T of kotlin.reflect.jvm.internal.calls.AnnotationConstructorCallerKt.createAnnotationInstance");
        return t;
    }

    public static /* synthetic */ Object g(Class cls, Map map, List list, int i2, Object obj) {
        int u;
        if ((i2 & 4) != 0) {
            Set keySet = map.keySet();
            u = v.u(keySet, 10);
            ArrayList arrayList = new ArrayList(u);
            Iterator it = keySet.iterator();
            while (it.hasNext()) {
                arrayList.add(cls.getDeclaredMethod((String) it.next(), new Class[0]));
            }
            list = arrayList;
        }
        return f(cls, map, list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <T> boolean h(Class<T> cls, List<Method> list, Map<String, ? extends Object> map, Object obj) {
        boolean a2;
        boolean z;
        KClass a3;
        Class cls2 = null;
        Annotation annotation = obj instanceof Annotation ? (Annotation) obj : null;
        if (annotation != null && (a3 = kotlin.jvm.a.a(annotation)) != null) {
            cls2 = kotlin.jvm.a.b(a3);
        }
        if (m.a(cls2, cls)) {
            if (!(list instanceof Collection) || !list.isEmpty()) {
                for (Method method : list) {
                    Object obj2 = map.get(method.getName());
                    Object invoke = method.invoke(obj, new Object[0]);
                    if (obj2 instanceof boolean[]) {
                        m.d(invoke, "null cannot be cast to non-null type kotlin.BooleanArray");
                        a2 = Arrays.equals((boolean[]) obj2, (boolean[]) invoke);
                    } else if (obj2 instanceof char[]) {
                        m.d(invoke, "null cannot be cast to non-null type kotlin.CharArray");
                        a2 = Arrays.equals((char[]) obj2, (char[]) invoke);
                    } else if (obj2 instanceof byte[]) {
                        m.d(invoke, "null cannot be cast to non-null type kotlin.ByteArray");
                        a2 = Arrays.equals((byte[]) obj2, (byte[]) invoke);
                    } else if (obj2 instanceof short[]) {
                        m.d(invoke, "null cannot be cast to non-null type kotlin.ShortArray");
                        a2 = Arrays.equals((short[]) obj2, (short[]) invoke);
                    } else if (obj2 instanceof int[]) {
                        m.d(invoke, "null cannot be cast to non-null type kotlin.IntArray");
                        a2 = Arrays.equals((int[]) obj2, (int[]) invoke);
                    } else if (obj2 instanceof float[]) {
                        m.d(invoke, "null cannot be cast to non-null type kotlin.FloatArray");
                        a2 = Arrays.equals((float[]) obj2, (float[]) invoke);
                    } else if (obj2 instanceof long[]) {
                        m.d(invoke, "null cannot be cast to non-null type kotlin.LongArray");
                        a2 = Arrays.equals((long[]) obj2, (long[]) invoke);
                    } else if (obj2 instanceof double[]) {
                        m.d(invoke, "null cannot be cast to non-null type kotlin.DoubleArray");
                        a2 = Arrays.equals((double[]) obj2, (double[]) invoke);
                    } else if (obj2 instanceof Object[]) {
                        m.d(invoke, "null cannot be cast to non-null type kotlin.Array<*>");
                        a2 = Arrays.equals((Object[]) obj2, (Object[]) invoke);
                    } else {
                        a2 = m.a(obj2, invoke);
                    }
                    if (!a2) {
                        z = false;
                        break;
                    }
                }
            }
            z = true;
            if (z) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int i(Lazy<Integer> lazy) {
        return lazy.getValue().intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String j(Lazy<String> lazy) {
        return lazy.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Void k(int i2, String str, Class<?> cls) {
        KClass b2;
        String p;
        if (m.a(cls, Class.class)) {
            b2 = g0.b(KClass.class);
        } else {
            b2 = (cls.isArray() && m.a(cls.getComponentType(), Class.class)) ? g0.b(KClass[].class) : kotlin.jvm.a.e(cls);
        }
        if (m.a(b2.p(), g0.b(Object[].class).p())) {
            StringBuilder sb = new StringBuilder();
            sb.append(b2.p());
            sb.append('<');
            Class<?> componentType = kotlin.jvm.a.b(b2).getComponentType();
            m.e(componentType, "kotlinClass.java.componentType");
            sb.append(kotlin.jvm.a.e(componentType).p());
            sb.append('>');
            p = sb.toString();
        } else {
            p = b2.p();
        }
        throw new IllegalArgumentException("Argument #" + i2 + ' ' + str + " is not of the required type " + p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object l(Object obj, Class<?> cls) {
        if (obj instanceof Class) {
            return null;
        }
        if (obj instanceof KClass) {
            obj = kotlin.jvm.a.b((KClass) obj);
        } else if (obj instanceof Object[]) {
            Object[] objArr = (Object[]) obj;
            if (objArr instanceof Class[]) {
                return null;
            }
            if (objArr instanceof KClass[]) {
                m.d(obj, "null cannot be cast to non-null type kotlin.Array<kotlin.reflect.KClass<*>>");
                KClass[] kClassArr = (KClass[]) obj;
                ArrayList arrayList = new ArrayList(kClassArr.length);
                for (KClass kClass : kClassArr) {
                    arrayList.add(kotlin.jvm.a.b(kClass));
                }
                obj = arrayList.toArray(new Class[0]);
                m.d(obj, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            } else {
                obj = objArr;
            }
        }
        if (cls.isInstance(obj)) {
            return obj;
        }
        return null;
    }
}
