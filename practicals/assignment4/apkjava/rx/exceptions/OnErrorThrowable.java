package rx.exceptions;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import rx.q.f;

/* loaded from: classes3.dex */
public final class OnErrorThrowable extends RuntimeException {

    /* loaded from: classes3.dex */
    public static class OnNextValue extends RuntimeException {

        /* renamed from: f, reason: collision with root package name */
        private final Object f26094f;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes3.dex */
        public static final class a {
            static final Set<Class<?>> a = a();

            private static Set<Class<?>> a() {
                HashSet hashSet = new HashSet();
                hashSet.add(Boolean.class);
                hashSet.add(Character.class);
                hashSet.add(Byte.class);
                hashSet.add(Short.class);
                hashSet.add(Integer.class);
                hashSet.add(Long.class);
                hashSet.add(Float.class);
                hashSet.add(Double.class);
                return hashSet;
            }
        }

        public OnNextValue(Object obj) {
            super("OnError while emitting onNext value: " + b(obj));
            if (!(obj instanceof Serializable)) {
                try {
                    obj = String.valueOf(obj);
                } catch (Throwable th) {
                    obj = th.getMessage();
                }
            }
            this.f26094f = obj;
        }

        static String b(Object obj) {
            if (obj == null) {
                return "null";
            }
            if (a.a.contains(obj.getClass())) {
                return obj.toString();
            }
            if (obj instanceof String) {
                return (String) obj;
            }
            if (obj instanceof Enum) {
                return ((Enum) obj).name();
            }
            String b2 = f.c().b().b(obj);
            if (b2 != null) {
                return b2;
            }
            return obj.getClass().getName() + ".class";
        }

        public Object a() {
            return this.f26094f;
        }
    }

    public static Throwable a(Throwable th, Object obj) {
        if (th == null) {
            th = new NullPointerException();
        }
        Throwable b2 = a.b(th);
        if ((b2 instanceof OnNextValue) && ((OnNextValue) b2).a() == obj) {
            return th;
        }
        a.a(th, new OnNextValue(obj));
        return th;
    }
}
