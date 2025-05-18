package kotlin.reflect.y.internal;

import java.lang.annotation.Annotation;
import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.collections.q0;
import kotlin.collections.s;
import kotlin.collections.v;
import kotlin.collections.z;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.b0;
import kotlin.jvm.internal.i0;
import kotlin.jvm.internal.m;
import kotlin.reflect.KCallable;
import kotlin.reflect.KType;
import kotlin.reflect.KVisibility;
import kotlin.reflect.jvm.internal.impl.descriptors.e;
import kotlin.reflect.jvm.internal.impl.descriptors.r1.a.k;
import kotlin.reflect.jvm.internal.impl.descriptors.r1.a.l;
import kotlin.reflect.jvm.internal.impl.descriptors.r1.b.p;
import kotlin.reflect.jvm.internal.impl.descriptors.t;
import kotlin.reflect.jvm.internal.impl.descriptors.w0;
import kotlin.reflect.jvm.internal.impl.descriptors.z0;
import kotlin.reflect.jvm.internal.impl.protobuf.o;
import kotlin.reflect.y.internal.j0.b.h;
import kotlin.reflect.y.internal.j0.b.i;
import kotlin.reflect.y.internal.j0.d.b.q;
import kotlin.reflect.y.internal.j0.f.c;
import kotlin.reflect.y.internal.j0.f.d;
import kotlin.reflect.y.internal.j0.i.f;
import kotlin.reflect.y.internal.j0.i.r.b;
import kotlin.reflect.y.internal.j0.i.r.g;
import kotlin.reflect.y.internal.j0.i.r.j;
import kotlin.reflect.y.internal.j0.i.r.q;
import kotlin.reflect.y.internal.j0.j.b.n;
import kotlin.reflect.y.internal.j0.j.b.w;
import kotlin.reflect.y.internal.j0.l.e0;
import kotlin.reflect.y.internal.j0.l.g1;
import kotlin.text.u;
import okhttp3.HttpUrl;

/* compiled from: util.kt */
@Metadata(d1 = {"\u0000Ê\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0012\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0000\u001al\u0010\u0011\u001a\u0002H\u0012\"\b\b\u0000\u0010\u0013*\u00020\u0014\"\b\b\u0001\u0010\u0012*\u00020\u00062\n\u0010\u0015\u001a\u0006\u0012\u0002\b\u00030\u00162\u0006\u0010\u0017\u001a\u0002H\u00132\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u001d\u0010\u001e\u001a\u0019\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u0002H\u0013\u0012\u0004\u0012\u0002H\u00120\u001f¢\u0006\u0002\b!H\u0000¢\u0006\u0002\u0010\"\u001a.\u0010#\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00162\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020'2\u0006\u0010)\u001a\u00020*H\u0002\u001a(\u0010#\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00162\u0006\u0010$\u001a\u00020%2\u0006\u0010+\u001a\u00020,2\b\b\u0002\u0010)\u001a\u00020*H\u0002\u001a%\u0010-\u001a\u0002H.\"\u0004\b\u0000\u0010.2\f\u0010/\u001a\b\u0012\u0004\u0012\u0002H.00H\u0080\bø\u0001\u0000¢\u0006\u0002\u00101\u001a\u0016\u00102\u001a\u0004\u0018\u00010\u000e*\u0002032\u0006\u0010$\u001a\u00020%H\u0002\u001a\u0014\u00104\u001a\b\u0012\u0002\b\u0003\u0018\u000105*\u0004\u0018\u00010\u000eH\u0000\u001a\u0010\u00106\u001a\u0004\u0018\u000107*\u0004\u0018\u00010\u000eH\u0000\u001a\u0014\u00108\u001a\b\u0012\u0002\b\u0003\u0018\u000109*\u0004\u0018\u00010\u000eH\u0000\u001a\u0012\u0010:\u001a\b\u0012\u0004\u0012\u00020<0;*\u00020=H\u0000\u001a\u0014\u0010>\u001a\u0006\u0012\u0002\b\u00030\u0016*\u0006\u0012\u0002\b\u00030\u0016H\u0000\u001a\u000e\u0010?\u001a\u0004\u0018\u00010<*\u00020@H\u0002\u001a\u0012\u0010A\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0016*\u00020BH\u0000\u001a\u000e\u0010C\u001a\u0004\u0018\u00010D*\u00020EH\u0000\u001a\u001a\u0010F\u001a\u0004\u0018\u00010\u000e*\u0006\u0012\u0002\b\u00030G2\u0006\u0010$\u001a\u00020%H\u0002\u001a\u0018\u0010H\u001a\b\u0012\u0004\u0012\u00020<0;*\b\u0012\u0004\u0012\u00020<0;H\u0002\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u0005*\u00020\u00068@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b\"\u0018\u0010\t\u001a\u00020\n*\u00020\u000b8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\f\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006I"}, d2 = {"JVM_STATIC", "Lkotlin/reflect/jvm/internal/impl/name/FqName;", "getJVM_STATIC", "()Lorg/jetbrains/kotlin/name/FqName;", "instanceReceiverParameter", "Lkotlin/reflect/jvm/internal/impl/descriptors/ReceiverParameterDescriptor;", "Lkotlin/reflect/jvm/internal/impl/descriptors/CallableDescriptor;", "getInstanceReceiverParameter", "(Lorg/jetbrains/kotlin/descriptors/CallableDescriptor;)Lorg/jetbrains/kotlin/descriptors/ReceiverParameterDescriptor;", "isInlineClassType", HttpUrl.FRAGMENT_ENCODE_SET, "Lkotlin/reflect/KType;", "(Lkotlin/reflect/KType;)Z", "defaultPrimitiveValue", HttpUrl.FRAGMENT_ENCODE_SET, "type", "Ljava/lang/reflect/Type;", "deserializeToDescriptor", "D", "M", "Lkotlin/reflect/jvm/internal/impl/protobuf/MessageLite;", "moduleAnchor", "Ljava/lang/Class;", "proto", "nameResolver", "Lkotlin/reflect/jvm/internal/impl/metadata/deserialization/NameResolver;", "typeTable", "Lkotlin/reflect/jvm/internal/impl/metadata/deserialization/TypeTable;", "metadataVersion", "Lkotlin/reflect/jvm/internal/impl/metadata/deserialization/BinaryVersion;", "createDescriptor", "Lkotlin/Function2;", "Lkotlin/reflect/jvm/internal/impl/serialization/deserialization/MemberDeserializer;", "Lkotlin/ExtensionFunctionType;", "(Ljava/lang/Class;Lorg/jetbrains/kotlin/protobuf/MessageLite;Lorg/jetbrains/kotlin/metadata/deserialization/NameResolver;Lorg/jetbrains/kotlin/metadata/deserialization/TypeTable;Lorg/jetbrains/kotlin/metadata/deserialization/BinaryVersion;Lkotlin/jvm/functions/Function2;)Lorg/jetbrains/kotlin/descriptors/CallableDescriptor;", "loadClass", "classLoader", "Ljava/lang/ClassLoader;", "packageName", HttpUrl.FRAGMENT_ENCODE_SET, "className", "arrayDimensions", HttpUrl.FRAGMENT_ENCODE_SET, "kotlinClassId", "Lkotlin/reflect/jvm/internal/impl/name/ClassId;", "reflectionCall", "R", "block", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "arrayToRuntimeValue", "Lkotlin/reflect/jvm/internal/impl/resolve/constants/ArrayValue;", "asKCallableImpl", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "asKFunctionImpl", "Lkotlin/reflect/jvm/internal/KFunctionImpl;", "asKPropertyImpl", "Lkotlin/reflect/jvm/internal/KPropertyImpl;", "computeAnnotations", HttpUrl.FRAGMENT_ENCODE_SET, HttpUrl.FRAGMENT_ENCODE_SET, "Lkotlin/reflect/jvm/internal/impl/descriptors/annotations/Annotated;", "createArrayType", "toAnnotationInstance", "Lkotlin/reflect/jvm/internal/impl/descriptors/annotations/AnnotationDescriptor;", "toJavaClass", "Lkotlin/reflect/jvm/internal/impl/descriptors/ClassDescriptor;", "toKVisibility", "Lkotlin/reflect/KVisibility;", "Lkotlin/reflect/jvm/internal/impl/descriptors/DescriptorVisibility;", "toRuntimeValue", "Lkotlin/reflect/jvm/internal/impl/resolve/constants/ConstantValue;", "unwrapRepeatableAnnotations", "kotlin-reflection"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes2.dex */
public final class g0 {
    private static final c a = new c("kotlin.jvm.JvmStatic");

    /* compiled from: util.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes2.dex */
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[i.values().length];
            iArr[i.BOOLEAN.ordinal()] = 1;
            iArr[i.CHAR.ordinal()] = 2;
            iArr[i.BYTE.ordinal()] = 3;
            iArr[i.SHORT.ordinal()] = 4;
            iArr[i.INT.ordinal()] = 5;
            iArr[i.FLOAT.ordinal()] = 6;
            iArr[i.LONG.ordinal()] = 7;
            iArr[i.DOUBLE.ordinal()] = 8;
            a = iArr;
        }
    }

    /* JADX WARN: Incorrect type for immutable var: ssa=boolean[], code=short[], for r7v12, types: [boolean[]] */
    /* JADX WARN: Incorrect type for immutable var: ssa=byte[], code=short[], for r7v14, types: [byte[]] */
    /* JADX WARN: Incorrect type for immutable var: ssa=char[], code=short[], for r7v13, types: [char[]] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v10, types: [java.lang.Class[]] */
    /* JADX WARN: Type inference failed for: r7v11, types: [java.lang.String[]] */
    /* JADX WARN: Type inference failed for: r7v16, types: [int[]] */
    /* JADX WARN: Type inference failed for: r7v17, types: [float[]] */
    /* JADX WARN: Type inference failed for: r7v18, types: [long[]] */
    /* JADX WARN: Type inference failed for: r7v20, types: [double[]] */
    /* JADX WARN: Type inference failed for: r7v9, types: [java.lang.Object[]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final Object a(b bVar, ClassLoader classLoader) {
        e0 c2;
        int u;
        Class n;
        short[] sArr;
        n nVar = bVar instanceof n ? (n) bVar : null;
        if (nVar == null || (c2 = nVar.c()) == null) {
            return null;
        }
        List<? extends g<?>> b2 = bVar.b();
        u = v.u(b2, 10);
        ArrayList arrayList = new ArrayList(u);
        Iterator<T> it = b2.iterator();
        while (it.hasNext()) {
            arrayList.add(r((g) it.next(), classLoader));
        }
        i N = h.N(c2);
        int i2 = 0;
        switch (N == null ? -1 : a.a[N.ordinal()]) {
            case -1:
                if (h.c0(c2)) {
                    e0 type = ((g1) s.s0(c2.M0())).getType();
                    m.e(type, "type.arguments.single().type");
                    kotlin.reflect.jvm.internal.impl.descriptors.h w = type.O0().w();
                    e eVar = w instanceof e ? (e) w : null;
                    if (eVar != null) {
                        if (h.u0(type)) {
                            int size = bVar.b().size();
                            sArr = new String[size];
                            while (i2 < size) {
                                Object obj = arrayList.get(i2);
                                m.d(obj, "null cannot be cast to non-null type kotlin.String");
                                sArr[i2] = (String) obj;
                                i2++;
                            }
                        } else if (h.k0(eVar)) {
                            int size2 = bVar.b().size();
                            sArr = new Class[size2];
                            while (i2 < size2) {
                                Object obj2 = arrayList.get(i2);
                                m.d(obj2, "null cannot be cast to non-null type java.lang.Class<*>");
                                sArr[i2] = (Class) obj2;
                                i2++;
                            }
                        } else {
                            kotlin.reflect.y.internal.j0.f.b g2 = kotlin.reflect.y.internal.j0.i.t.a.g(eVar);
                            if (g2 == null || (n = n(classLoader, g2, 0, 4, null)) == null) {
                                return null;
                            }
                            Object newInstance = Array.newInstance((Class<?>) n, bVar.b().size());
                            m.d(newInstance, "null cannot be cast to non-null type kotlin.Array<in kotlin.Any?>");
                            sArr = (Object[]) newInstance;
                            int size3 = arrayList.size();
                            while (i2 < size3) {
                                sArr[i2] = arrayList.get(i2);
                                i2++;
                            }
                        }
                        return sArr;
                    }
                    throw new IllegalStateException(("Not a class type: " + type).toString());
                }
                throw new IllegalStateException(("Not an array type: " + c2).toString());
            case 0:
            default:
                throw new NoWhenBranchMatchedException();
            case 1:
                int size4 = bVar.b().size();
                sArr = new boolean[size4];
                while (i2 < size4) {
                    Object obj3 = arrayList.get(i2);
                    m.d(obj3, "null cannot be cast to non-null type kotlin.Boolean");
                    sArr[i2] = ((Boolean) obj3).booleanValue();
                    i2++;
                }
                return sArr;
            case 2:
                int size5 = bVar.b().size();
                sArr = new char[size5];
                while (i2 < size5) {
                    Object obj4 = arrayList.get(i2);
                    m.d(obj4, "null cannot be cast to non-null type kotlin.Char");
                    sArr[i2] = ((Character) obj4).charValue();
                    i2++;
                }
                return sArr;
            case 3:
                int size6 = bVar.b().size();
                sArr = new byte[size6];
                while (i2 < size6) {
                    Object obj5 = arrayList.get(i2);
                    m.d(obj5, "null cannot be cast to non-null type kotlin.Byte");
                    sArr[i2] = ((Byte) obj5).byteValue();
                    i2++;
                }
                return sArr;
            case 4:
                int size7 = bVar.b().size();
                sArr = new short[size7];
                while (i2 < size7) {
                    Object obj6 = arrayList.get(i2);
                    m.d(obj6, "null cannot be cast to non-null type kotlin.Short");
                    sArr[i2] = ((Short) obj6).shortValue();
                    i2++;
                }
                return sArr;
            case 5:
                int size8 = bVar.b().size();
                sArr = new int[size8];
                while (i2 < size8) {
                    Object obj7 = arrayList.get(i2);
                    m.d(obj7, "null cannot be cast to non-null type kotlin.Int");
                    sArr[i2] = ((Integer) obj7).intValue();
                    i2++;
                }
                return sArr;
            case 6:
                int size9 = bVar.b().size();
                sArr = new float[size9];
                while (i2 < size9) {
                    Object obj8 = arrayList.get(i2);
                    m.d(obj8, "null cannot be cast to non-null type kotlin.Float");
                    sArr[i2] = ((Float) obj8).floatValue();
                    i2++;
                }
                return sArr;
            case 7:
                int size10 = bVar.b().size();
                sArr = new long[size10];
                while (i2 < size10) {
                    Object obj9 = arrayList.get(i2);
                    m.d(obj9, "null cannot be cast to non-null type kotlin.Long");
                    sArr[i2] = ((Long) obj9).longValue();
                    i2++;
                }
                return sArr;
            case 8:
                int size11 = bVar.b().size();
                sArr = new double[size11];
                while (i2 < size11) {
                    Object obj10 = arrayList.get(i2);
                    m.d(obj10, "null cannot be cast to non-null type kotlin.Double");
                    sArr[i2] = ((Double) obj10).doubleValue();
                    i2++;
                }
                return sArr;
        }
    }

    public static final KCallableImpl<?> b(Object obj) {
        KCallableImpl<?> kCallableImpl = obj instanceof KCallableImpl ? (KCallableImpl) obj : null;
        if (kCallableImpl != null) {
            return kCallableImpl;
        }
        KFunctionImpl c2 = c(obj);
        return c2 != null ? c2 : d(obj);
    }

    public static final KFunctionImpl c(Object obj) {
        KFunctionImpl kFunctionImpl = obj instanceof KFunctionImpl ? (KFunctionImpl) obj : null;
        if (kFunctionImpl != null) {
            return kFunctionImpl;
        }
        kotlin.jvm.internal.i iVar = obj instanceof kotlin.jvm.internal.i ? (kotlin.jvm.internal.i) obj : null;
        KCallable compute = iVar != null ? iVar.compute() : null;
        if (compute instanceof KFunctionImpl) {
            return (KFunctionImpl) compute;
        }
        return null;
    }

    public static final KPropertyImpl<?> d(Object obj) {
        KPropertyImpl<?> kPropertyImpl = obj instanceof KPropertyImpl ? (KPropertyImpl) obj : null;
        if (kPropertyImpl != null) {
            return kPropertyImpl;
        }
        b0 b0Var = obj instanceof b0 ? (b0) obj : null;
        KCallable compute = b0Var != null ? b0Var.compute() : null;
        if (compute instanceof KPropertyImpl) {
            return (KPropertyImpl) compute;
        }
        return null;
    }

    public static final List<Annotation> e(kotlin.reflect.jvm.internal.impl.descriptors.n1.a aVar) {
        m.f(aVar, "<this>");
        kotlin.reflect.jvm.internal.impl.descriptors.n1.g annotations = aVar.getAnnotations();
        ArrayList arrayList = new ArrayList();
        for (kotlin.reflect.jvm.internal.impl.descriptors.n1.c cVar : annotations) {
            z0 t = cVar.t();
            Annotation annotation = null;
            if (t instanceof kotlin.reflect.jvm.internal.impl.descriptors.r1.a.b) {
                annotation = ((kotlin.reflect.jvm.internal.impl.descriptors.r1.a.b) t).d();
            } else if (t instanceof l.a) {
                p b2 = ((l.a) t).b();
                kotlin.reflect.jvm.internal.impl.descriptors.r1.b.e eVar = b2 instanceof kotlin.reflect.jvm.internal.impl.descriptors.r1.b.e ? (kotlin.reflect.jvm.internal.impl.descriptors.r1.b.e) b2 : null;
                if (eVar != null) {
                    annotation = eVar.R();
                }
            } else {
                annotation = o(cVar);
            }
            if (annotation != null) {
                arrayList.add(annotation);
            }
        }
        return s(arrayList);
    }

    public static final Class<?> f(Class<?> cls) {
        m.f(cls, "<this>");
        return Array.newInstance(cls, 0).getClass();
    }

    public static final Object g(Type type) {
        m.f(type, "type");
        if (!(type instanceof Class) || !((Class) type).isPrimitive()) {
            return null;
        }
        if (m.a(type, Boolean.TYPE)) {
            return Boolean.FALSE;
        }
        if (m.a(type, Character.TYPE)) {
            return (char) 0;
        }
        if (m.a(type, Byte.TYPE)) {
            return (byte) 0;
        }
        if (m.a(type, Short.TYPE)) {
            return (short) 0;
        }
        if (m.a(type, Integer.TYPE)) {
            return 0;
        }
        if (m.a(type, Float.TYPE)) {
            return Float.valueOf(0.0f);
        }
        if (m.a(type, Long.TYPE)) {
            return 0L;
        }
        if (m.a(type, Double.TYPE)) {
            return Double.valueOf(0.0d);
        }
        if (m.a(type, Void.TYPE)) {
            throw new IllegalStateException("Parameter with void type is illegal");
        }
        throw new UnsupportedOperationException("Unknown primitive: " + type);
    }

    public static final <M extends o, D extends kotlin.reflect.jvm.internal.impl.descriptors.a> D h(Class<?> cls, M m, kotlin.reflect.y.internal.j0.e.z.c cVar, kotlin.reflect.y.internal.j0.e.z.g gVar, kotlin.reflect.y.internal.j0.e.z.a aVar, Function2<? super w, ? super M, ? extends D> function2) {
        List<kotlin.reflect.y.internal.j0.e.s> n0;
        m.f(cls, "moduleAnchor");
        m.f(m, "proto");
        m.f(cVar, "nameResolver");
        m.f(gVar, "typeTable");
        m.f(aVar, "metadataVersion");
        m.f(function2, "createDescriptor");
        k a2 = z.a(cls);
        if (m instanceof kotlin.reflect.y.internal.j0.e.i) {
            n0 = ((kotlin.reflect.y.internal.j0.e.i) m).m0();
        } else {
            if (!(m instanceof kotlin.reflect.y.internal.j0.e.n)) {
                throw new IllegalStateException(("Unsupported message: " + m).toString());
            }
            n0 = ((kotlin.reflect.y.internal.j0.e.n) m).n0();
        }
        List<kotlin.reflect.y.internal.j0.e.s> list = n0;
        kotlin.reflect.y.internal.j0.j.b.k a3 = a2.a();
        kotlin.reflect.jvm.internal.impl.descriptors.g0 b2 = a2.b();
        kotlin.reflect.y.internal.j0.e.z.h b3 = kotlin.reflect.y.internal.j0.e.z.h.a.b();
        m.e(list, "typeParameters");
        return function2.invoke(new w(new kotlin.reflect.y.internal.j0.j.b.m(a3, cVar, b2, gVar, b3, aVar, null, null, list)), m);
    }

    public static final w0 i(kotlin.reflect.jvm.internal.impl.descriptors.a aVar) {
        m.f(aVar, "<this>");
        if (aVar.f0() == null) {
            return null;
        }
        kotlin.reflect.jvm.internal.impl.descriptors.m b2 = aVar.b();
        m.d(b2, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
        return ((e) b2).K0();
    }

    public static final c j() {
        return a;
    }

    public static final boolean k(KType kType) {
        e0 f25005g;
        m.f(kType, "<this>");
        KTypeImpl kTypeImpl = kType instanceof KTypeImpl ? (KTypeImpl) kType : null;
        return (kTypeImpl == null || (f25005g = kTypeImpl.getF25005g()) == null || !f.c(f25005g)) ? false : true;
    }

    private static final Class<?> l(ClassLoader classLoader, String str, String str2, int i2) {
        String z;
        String w;
        if (m.a(str, "kotlin")) {
            switch (str2.hashCode()) {
                case -901856463:
                    if (str2.equals("BooleanArray")) {
                        return boolean[].class;
                    }
                    break;
                case -763279523:
                    if (str2.equals("ShortArray")) {
                        return short[].class;
                    }
                    break;
                case -755911549:
                    if (str2.equals("CharArray")) {
                        return char[].class;
                    }
                    break;
                case -74930671:
                    if (str2.equals("ByteArray")) {
                        return byte[].class;
                    }
                    break;
                case 22374632:
                    if (str2.equals("DoubleArray")) {
                        return double[].class;
                    }
                    break;
                case 63537721:
                    if (str2.equals("Array")) {
                        return Object[].class;
                    }
                    break;
                case 601811914:
                    if (str2.equals("IntArray")) {
                        return int[].class;
                    }
                    break;
                case 948852093:
                    if (str2.equals("FloatArray")) {
                        return float[].class;
                    }
                    break;
                case 2104330525:
                    if (str2.equals("LongArray")) {
                        return long[].class;
                    }
                    break;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append('.');
        z = u.z(str2, '.', '$', false, 4, null);
        sb.append(z);
        String sb2 = sb.toString();
        if (i2 > 0) {
            StringBuilder sb3 = new StringBuilder();
            w = u.w("[", i2);
            sb3.append(w);
            sb3.append('L');
            sb3.append(sb2);
            sb3.append(';');
            sb2 = sb3.toString();
        }
        return kotlin.reflect.jvm.internal.impl.descriptors.r1.a.e.a(classLoader, sb2);
    }

    private static final Class<?> m(ClassLoader classLoader, kotlin.reflect.y.internal.j0.f.b bVar, int i2) {
        kotlin.reflect.y.internal.j0.b.q.c cVar = kotlin.reflect.y.internal.j0.b.q.c.a;
        d j2 = bVar.b().j();
        m.e(j2, "kotlinClassId.asSingleFqName().toUnsafe()");
        kotlin.reflect.y.internal.j0.f.b n = cVar.n(j2);
        if (n != null) {
            bVar = n;
        }
        String b2 = bVar.h().b();
        m.e(b2, "javaClassId.packageFqName.asString()");
        String b3 = bVar.i().b();
        m.e(b3, "javaClassId.relativeClassName.asString()");
        return l(classLoader, b2, b3, i2);
    }

    static /* synthetic */ Class n(ClassLoader classLoader, kotlin.reflect.y.internal.j0.f.b bVar, int i2, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            i2 = 0;
        }
        return m(classLoader, bVar, i2);
    }

    private static final Annotation o(kotlin.reflect.jvm.internal.impl.descriptors.n1.c cVar) {
        Map q;
        e e2 = kotlin.reflect.y.internal.j0.i.t.a.e(cVar);
        Class<?> p = e2 != null ? p(e2) : null;
        if (!(p instanceof Class)) {
            p = null;
        }
        if (p == null) {
            return null;
        }
        Set<Map.Entry<kotlin.reflect.y.internal.j0.f.f, g<?>>> entrySet = cVar.a().entrySet();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = entrySet.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            kotlin.reflect.y.internal.j0.f.f fVar = (kotlin.reflect.y.internal.j0.f.f) entry.getKey();
            g gVar = (g) entry.getValue();
            ClassLoader classLoader = p.getClassLoader();
            m.e(classLoader, "annotationClass.classLoader");
            Object r = r(gVar, classLoader);
            Pair a2 = r != null ? kotlin.s.a(fVar.k(), r) : null;
            if (a2 != null) {
                arrayList.add(a2);
            }
        }
        q = q0.q(arrayList);
        return (Annotation) kotlin.reflect.y.internal.calls.b.g(p, q, null, 4, null);
    }

    public static final Class<?> p(e eVar) {
        m.f(eVar, "<this>");
        z0 t = eVar.t();
        m.e(t, "source");
        if (t instanceof kotlin.reflect.y.internal.j0.d.b.s) {
            q d2 = ((kotlin.reflect.y.internal.j0.d.b.s) t).d();
            m.d(d2, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.runtime.components.ReflectKotlinClass");
            return ((kotlin.reflect.jvm.internal.impl.descriptors.r1.a.f) d2).d();
        }
        if (t instanceof l.a) {
            p b2 = ((l.a) t).b();
            m.d(b2, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.runtime.structure.ReflectJavaClass");
            return ((kotlin.reflect.jvm.internal.impl.descriptors.r1.b.l) b2).w();
        }
        kotlin.reflect.y.internal.j0.f.b g2 = kotlin.reflect.y.internal.j0.i.t.a.g(eVar);
        if (g2 == null) {
            return null;
        }
        return m(kotlin.reflect.jvm.internal.impl.descriptors.r1.b.d.e(eVar.getClass()), g2, 0);
    }

    public static final KVisibility q(kotlin.reflect.jvm.internal.impl.descriptors.u uVar) {
        m.f(uVar, "<this>");
        if (m.a(uVar, t.f25368e)) {
            return KVisibility.PUBLIC;
        }
        if (m.a(uVar, t.f25366c)) {
            return KVisibility.PROTECTED;
        }
        if (m.a(uVar, t.f25367d)) {
            return KVisibility.INTERNAL;
        }
        if (m.a(uVar, t.a) ? true : m.a(uVar, t.f25365b)) {
            return KVisibility.PRIVATE;
        }
        return null;
    }

    private static final Object r(g<?> gVar, ClassLoader classLoader) {
        if (gVar instanceof kotlin.reflect.y.internal.j0.i.r.a) {
            return o(((kotlin.reflect.y.internal.j0.i.r.a) gVar).b());
        }
        if (gVar instanceof b) {
            return a((b) gVar, classLoader);
        }
        if (gVar instanceof j) {
            Pair<? extends kotlin.reflect.y.internal.j0.f.b, ? extends kotlin.reflect.y.internal.j0.f.f> b2 = ((j) gVar).b();
            kotlin.reflect.y.internal.j0.f.b a2 = b2.a();
            kotlin.reflect.y.internal.j0.f.f b3 = b2.b();
            Class n = n(classLoader, a2, 0, 4, null);
            if (n != null) {
                return f0.a(n, b3.k());
            }
            return null;
        }
        if (gVar instanceof kotlin.reflect.y.internal.j0.i.r.q) {
            q.b b4 = ((kotlin.reflect.y.internal.j0.i.r.q) gVar).b();
            if (b4 instanceof q.b.C0379b) {
                q.b.C0379b c0379b = (q.b.C0379b) b4;
                return m(classLoader, c0379b.b(), c0379b.a());
            }
            if (!(b4 instanceof q.b.a)) {
                throw new NoWhenBranchMatchedException();
            }
            kotlin.reflect.jvm.internal.impl.descriptors.h w = ((q.b.a) b4).a().O0().w();
            e eVar = w instanceof e ? (e) w : null;
            if (eVar != null) {
                return p(eVar);
            }
            return null;
        }
        if (gVar instanceof kotlin.reflect.y.internal.j0.i.r.k ? true : gVar instanceof kotlin.reflect.y.internal.j0.i.r.s) {
            return null;
        }
        return gVar.b();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final List<Annotation> s(List<? extends Annotation> list) {
        boolean z;
        List e2;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                if (m.a(kotlin.jvm.a.b(kotlin.jvm.a.a((Annotation) it.next())).getSimpleName(), "Container")) {
                    z = true;
                    break;
                }
            }
        }
        z = false;
        if (!z) {
            return list;
        }
        ArrayList arrayList = new ArrayList();
        for (Annotation annotation : list) {
            Class b2 = kotlin.jvm.a.b(kotlin.jvm.a.a(annotation));
            if (m.a(b2.getSimpleName(), "Container") && b2.getAnnotation(i0.class) != null) {
                Object invoke = b2.getDeclaredMethod("value", new Class[0]).invoke(annotation, new Object[0]);
                m.d(invoke, "null cannot be cast to non-null type kotlin.Array<out kotlin.Annotation>");
                e2 = kotlin.collections.m.c((Annotation[]) invoke);
            } else {
                e2 = kotlin.collections.t.e(annotation);
            }
            z.z(arrayList, e2);
        }
        return arrayList;
    }
}
