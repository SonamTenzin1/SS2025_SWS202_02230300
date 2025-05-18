package com.squareup.moshi.x.reflect;

import com.squareup.moshi.e;
import com.squareup.moshi.f;
import com.squareup.moshi.i;
import com.squareup.moshi.r;
import com.squareup.moshi.u;
import com.squareup.moshi.v;
import com.squareup.moshi.w.c;
import com.squareup.moshi.x.reflect.KotlinJsonAdapter;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.c0;
import kotlin.collections.p0;
import kotlin.collections.z;
import kotlin.jvm.a;
import kotlin.jvm.internal.l0;
import kotlin.jvm.internal.m;
import kotlin.ranges.l;
import kotlin.reflect.KClass;
import kotlin.reflect.KClassifier;
import kotlin.reflect.KFunction;
import kotlin.reflect.KMutableProperty1;
import kotlin.reflect.KParameter;
import kotlin.reflect.KProperty1;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeParameter;
import kotlin.reflect.KTypeProjection;
import okhttp3.HttpUrl;

/* compiled from: KotlinJsonAdapter.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\u0010\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J.\u0010\u0003\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u000e\u0010\u0007\u001a\n\u0012\u0006\b\u0001\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"}, d2 = {"Lcom/squareup/moshi/kotlin/reflect/KotlinJsonAdapterFactory;", "Lcom/squareup/moshi/JsonAdapter$Factory;", "()V", "create", "Lcom/squareup/moshi/JsonAdapter;", "type", "Ljava/lang/reflect/Type;", "annotations", HttpUrl.FRAGMENT_ENCODE_SET, HttpUrl.FRAGMENT_ENCODE_SET, "moshi", "Lcom/squareup/moshi/Moshi;", "reflect"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* renamed from: com.squareup.moshi.x.a.b, reason: from Kotlin metadata */
/* loaded from: classes2.dex */
public final class KotlinJsonAdapterFactory implements f.e {
    /* JADX WARN: Code restructure failed: missing block: B:111:0x01db, code lost:
    
        if (r9 == null) goto L117;
     */
    @Override // com.squareup.moshi.f.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public f<?> a(Type type, Set<? extends Annotation> set, r rVar) {
        Class<? extends Annotation> cls;
        int u;
        int e2;
        int b2;
        List R;
        int u2;
        Object obj;
        List G0;
        String m;
        Type f2;
        Object obj2;
        m.f(type, "type");
        m.f(set, "annotations");
        m.f(rVar, "moshi");
        boolean z = true;
        if (!set.isEmpty()) {
            return null;
        }
        Class<?> a = v.a(type);
        if (a.isInterface() || a.isEnum()) {
            return null;
        }
        cls = c.a;
        if (!a.isAnnotationPresent(cls) || c.i(a)) {
            return null;
        }
        try {
            f<?> d2 = c.d(rVar, type, a);
            if (d2 != null) {
                return d2;
            }
        } catch (RuntimeException e3) {
            if (!(e3.getCause() instanceof ClassNotFoundException)) {
                throw e3;
            }
        }
        if (!a.isLocalClass()) {
            KClass e4 = a.e(a);
            if (!e4.isAbstract()) {
                if (!e4.m()) {
                    if (e4.r() == null) {
                        if (!e4.o()) {
                            KFunction b3 = kotlin.reflect.full.a.b(e4);
                            if (b3 == null) {
                                return null;
                            }
                            List<KParameter> parameters = b3.getParameters();
                            u = kotlin.collections.v.u(parameters, 10);
                            e2 = p0.e(u);
                            b2 = l.b(e2, 16);
                            LinkedHashMap linkedHashMap = new LinkedHashMap(b2);
                            for (Object obj3 : parameters) {
                                linkedHashMap.put(((KParameter) obj3).getName(), obj3);
                            }
                            kotlin.reflect.y.a.a(b3, true);
                            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                            for (KProperty1 kProperty1 : kotlin.reflect.full.a.a(e4)) {
                                KParameter kParameter = (KParameter) linkedHashMap.get(kProperty1.getM());
                                kotlin.reflect.y.a.a(kProperty1, z);
                                Iterator<T> it = kProperty1.getAnnotations().iterator();
                                while (true) {
                                    if (!it.hasNext()) {
                                        obj = null;
                                        break;
                                    }
                                    obj = it.next();
                                    if (((Annotation) obj) instanceof e) {
                                        break;
                                    }
                                }
                                e eVar = (e) obj;
                                G0 = c0.G0(kProperty1.getAnnotations());
                                if (kParameter != null) {
                                    z.z(G0, kParameter.getAnnotations());
                                    if (eVar == null) {
                                        Iterator<T> it2 = kParameter.getAnnotations().iterator();
                                        while (true) {
                                            if (!it2.hasNext()) {
                                                obj2 = null;
                                                break;
                                            }
                                            obj2 = it2.next();
                                            if (((Annotation) obj2) instanceof e) {
                                                break;
                                            }
                                        }
                                        eVar = (e) obj2;
                                    }
                                }
                                Field b4 = kotlin.reflect.y.c.b(kProperty1);
                                if (Modifier.isTransient(b4 != null ? b4.getModifiers() : 0)) {
                                    if (!(kParameter == null || kParameter.k())) {
                                        throw new IllegalArgumentException(("No default value for transient constructor " + kParameter).toString());
                                    }
                                } else if (eVar != null && eVar.ignore() == z) {
                                    if (!(kParameter == null || kParameter.k())) {
                                        throw new IllegalArgumentException(("No default value for ignored constructor " + kParameter).toString());
                                    }
                                } else if (kParameter == null || m.a(kParameter.getType(), kProperty1.getReturnType())) {
                                    if ((kProperty1 instanceof KMutableProperty1) || kParameter != null) {
                                        if (eVar != null && (m = eVar.name()) != null) {
                                            if (m.a(m, "\u0000")) {
                                                m = null;
                                            }
                                        }
                                        m = kProperty1.getM();
                                        String str = m;
                                        KClassifier c2 = kProperty1.getReturnType().c();
                                        if (c2 instanceof KClass) {
                                            KClass kClass = (KClass) c2;
                                            if (kClass.l()) {
                                                f2 = a.b(kClass);
                                                if (!kProperty1.getReturnType().b().isEmpty()) {
                                                    List<KTypeProjection> b5 = kProperty1.getReturnType().b();
                                                    ArrayList arrayList = new ArrayList();
                                                    Iterator<T> it3 = b5.iterator();
                                                    while (it3.hasNext()) {
                                                        KType c3 = ((KTypeProjection) it3.next()).c();
                                                        Type f3 = c3 != null ? kotlin.reflect.y.c.f(c3) : null;
                                                        if (f3 != null) {
                                                            arrayList.add(f3);
                                                        }
                                                    }
                                                    Object[] array = arrayList.toArray(new Type[0]);
                                                    m.d(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                                                    Type[] typeArr = (Type[]) array;
                                                    f2 = u.j(f2, (Type[]) Arrays.copyOf(typeArr, typeArr.length));
                                                }
                                            } else {
                                                f2 = kotlin.reflect.y.c.f(kProperty1.getReturnType());
                                            }
                                        } else if (c2 instanceof KTypeParameter) {
                                            f2 = kotlin.reflect.y.c.f(kProperty1.getReturnType());
                                        } else {
                                            throw new IllegalStateException("Not possible!".toString());
                                        }
                                        Type p = c.p(type, a, f2);
                                        Object[] array2 = G0.toArray(new Annotation[0]);
                                        m.d(array2, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                                        f f4 = rVar.f(p, c.k((Annotation[]) array2), kProperty1.getM());
                                        String m2 = kProperty1.getM();
                                        m.e(f4, "adapter");
                                        m.d(kProperty1, "null cannot be cast to non-null type kotlin.reflect.KProperty1<kotlin.Any, kotlin.Any?>");
                                        linkedHashMap2.put(m2, new KotlinJsonAdapter.Binding(str, f4, kProperty1, kParameter, kParameter != null ? kParameter.getF24980h() : -1));
                                        z = true;
                                    }
                                } else {
                                    StringBuilder sb = new StringBuilder();
                                    sb.append('\'');
                                    sb.append(kProperty1.getM());
                                    sb.append("' has a constructor parameter of type ");
                                    m.c(kParameter);
                                    sb.append(kParameter.getType());
                                    sb.append(" but a property of type ");
                                    sb.append(kProperty1.getReturnType());
                                    sb.append('.');
                                    throw new IllegalArgumentException(sb.toString().toString());
                                }
                            }
                            ArrayList arrayList2 = new ArrayList();
                            for (KParameter kParameter2 : b3.getParameters()) {
                                KotlinJsonAdapter.Binding binding = (KotlinJsonAdapter.Binding) l0.c(linkedHashMap2).remove(kParameter2.getName());
                                if (binding != null || kParameter2.k()) {
                                    arrayList2.add(binding);
                                } else {
                                    throw new IllegalArgumentException(("No property for required constructor " + kParameter2).toString());
                                }
                            }
                            int size = arrayList2.size();
                            Iterator it4 = linkedHashMap2.entrySet().iterator();
                            while (true) {
                                int i2 = size;
                                if (!it4.hasNext()) {
                                    break;
                                }
                                size = i2 + 1;
                                arrayList2.add(KotlinJsonAdapter.Binding.b((KotlinJsonAdapter.Binding) ((Map.Entry) it4.next()).getValue(), null, null, null, null, i2, 15, null));
                            }
                            R = c0.R(arrayList2);
                            u2 = kotlin.collections.v.u(R, 10);
                            ArrayList arrayList3 = new ArrayList(u2);
                            Iterator it5 = R.iterator();
                            while (it5.hasNext()) {
                                arrayList3.add(((KotlinJsonAdapter.Binding) it5.next()).getJsonName());
                            }
                            Object[] array3 = arrayList3.toArray(new String[0]);
                            m.d(array3, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                            String[] strArr = (String[]) array3;
                            i.a a2 = i.a.a((String[]) Arrays.copyOf(strArr, strArr.length));
                            m.e(a2, "options");
                            return new KotlinJsonAdapter(b3, arrayList2, R, a2).nullSafe();
                        }
                        throw new IllegalArgumentException(("Cannot reflectively serialize sealed class " + a.getName() + ". Please register an adapter.").toString());
                    }
                    throw new IllegalArgumentException(("Cannot serialize object declaration " + a.getName()).toString());
                }
                throw new IllegalArgumentException(("Cannot serialize inner class " + a.getName()).toString());
            }
            throw new IllegalArgumentException(("Cannot serialize abstract class " + a.getName()).toString());
        }
        throw new IllegalArgumentException(("Cannot serialize local class or object expression " + a.getName()).toString());
    }
}
