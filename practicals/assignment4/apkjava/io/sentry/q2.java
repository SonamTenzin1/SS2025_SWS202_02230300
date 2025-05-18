package io.sentry;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.net.InetAddress;
import java.net.URI;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Currency;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicIntegerArray;
import org.jetbrains.annotations.ApiStatus;

/* compiled from: JsonReflectionObjectSerializer.java */
@ApiStatus.Internal
/* loaded from: classes2.dex */
public final class q2 {
    private final Set<Object> a = new HashSet();

    /* renamed from: b, reason: collision with root package name */
    private final int f22680b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q2(int i2) {
        this.f22680b = i2;
    }

    private List<Object> a(Collection<?> collection, w1 w1Var) throws Exception {
        ArrayList arrayList = new ArrayList();
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            arrayList.add(d(it.next(), w1Var));
        }
        return arrayList;
    }

    private List<Object> b(Object[] objArr, w1 w1Var) throws Exception {
        ArrayList arrayList = new ArrayList();
        for (Object obj : objArr) {
            arrayList.add(d(obj, w1Var));
        }
        return arrayList;
    }

    private Map<String, Object> c(Map<?, ?> map, w1 w1Var) throws Exception {
        HashMap hashMap = new HashMap();
        for (Object obj : map.keySet()) {
            Object obj2 = map.get(obj);
            if (obj2 != null) {
                hashMap.put(obj.toString(), d(obj2, w1Var));
            } else {
                hashMap.put(obj.toString(), null);
            }
        }
        return hashMap;
    }

    public Object d(Object obj, w1 w1Var) throws Exception {
        Object obj2;
        Object obj3 = null;
        if (obj == null) {
            return null;
        }
        if (obj instanceof Character) {
            return obj.toString();
        }
        if ((obj instanceof Number) || (obj instanceof Boolean) || (obj instanceof String)) {
            return obj;
        }
        if (obj instanceof Locale) {
            return obj.toString();
        }
        if (obj instanceof AtomicIntegerArray) {
            return io.sentry.util.n.a((AtomicIntegerArray) obj);
        }
        if (obj instanceof AtomicBoolean) {
            return Boolean.valueOf(((AtomicBoolean) obj).get());
        }
        if (obj instanceof URI) {
            return obj.toString();
        }
        if (obj instanceof InetAddress) {
            return obj.toString();
        }
        if (obj instanceof UUID) {
            return obj.toString();
        }
        if (obj instanceof Currency) {
            return obj.toString();
        }
        if (obj instanceof Calendar) {
            return io.sentry.util.n.c((Calendar) obj);
        }
        if (obj.getClass().isEnum()) {
            return obj.toString();
        }
        if (this.a.contains(obj)) {
            w1Var.c(s4.INFO, "Cyclic reference detected. Calling toString() on object.", new Object[0]);
            return obj.toString();
        }
        this.a.add(obj);
        try {
            if (this.a.size() > this.f22680b) {
                this.a.remove(obj);
                w1Var.c(s4.INFO, "Max depth exceeded. Calling toString() on object.", new Object[0]);
                return obj.toString();
            }
            try {
            } catch (Exception e2) {
                w1Var.b(s4.INFO, "Not serializing object due to throwing sub-path.", e2);
            }
            if (obj.getClass().isArray()) {
                obj2 = b((Object[]) obj, w1Var);
            } else if (obj instanceof Collection) {
                obj2 = a((Collection) obj, w1Var);
            } else if (obj instanceof Map) {
                obj2 = c((Map) obj, w1Var);
            } else {
                Map<String, Object> e3 = e(obj, w1Var);
                if (!e3.isEmpty()) {
                    obj3 = e3;
                    return obj3;
                }
                obj2 = obj.toString();
            }
            obj3 = obj2;
            return obj3;
        } finally {
            this.a.remove(obj);
        }
    }

    public Map<String, Object> e(Object obj, w1 w1Var) throws Exception {
        Field[] declaredFields = obj.getClass().getDeclaredFields();
        HashMap hashMap = new HashMap();
        for (Field field : declaredFields) {
            if (!Modifier.isTransient(field.getModifiers()) && !Modifier.isStatic(field.getModifiers())) {
                String name = field.getName();
                try {
                    field.setAccessible(true);
                    hashMap.put(name, d(field.get(obj), w1Var));
                    field.setAccessible(false);
                } catch (Exception unused) {
                    w1Var.c(s4.INFO, "Cannot access field " + name + ".", new Object[0]);
                }
            }
        }
        return hashMap;
    }
}
