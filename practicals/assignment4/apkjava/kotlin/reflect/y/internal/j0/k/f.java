package kotlin.reflect.y.internal.j0.k;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.utils.WrappedValues;
import kotlin.text.v;
import kotlin.u;
import okhttp3.HttpUrl;

/* compiled from: LockBasedStorageManager.java */
/* loaded from: classes3.dex */
public class f implements kotlin.reflect.y.internal.j0.k.n {
    private static final String a;

    /* renamed from: b, reason: collision with root package name */
    public static final kotlin.reflect.y.internal.j0.k.n f24650b;

    /* renamed from: c, reason: collision with root package name */
    protected final kotlin.reflect.y.internal.j0.k.k f24651c;

    /* renamed from: d, reason: collision with root package name */
    private final InterfaceC0392f f24652d;

    /* renamed from: e, reason: collision with root package name */
    private final String f24653e;

    /* compiled from: LockBasedStorageManager.java */
    /* loaded from: classes3.dex */
    static class a extends f {
        a(String str, InterfaceC0392f interfaceC0392f, kotlin.reflect.y.internal.j0.k.k kVar) {
            super(str, interfaceC0392f, kVar, null);
        }

        private static /* synthetic */ void j(int i2) {
            String str = i2 != 1 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
            Object[] objArr = new Object[i2 != 1 ? 3 : 2];
            if (i2 != 1) {
                objArr[0] = "source";
            } else {
                objArr[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$1";
            }
            if (i2 != 1) {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$1";
            } else {
                objArr[1] = "recursionDetectedDefault";
            }
            if (i2 != 1) {
                objArr[2] = "recursionDetectedDefault";
            }
            String format = String.format(str, objArr);
            if (i2 == 1) {
                throw new IllegalStateException(format);
            }
        }

        @Override // kotlin.reflect.y.internal.j0.k.f
        protected <K, V> o<V> p(String str, K k2) {
            if (str == null) {
                j(0);
            }
            o<V> a = o.a();
            if (a == null) {
                j(1);
            }
            return a;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: LockBasedStorageManager.java */
    /* loaded from: classes3.dex */
    class b<T> extends j<T> {

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ Object f24654i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(f fVar, Function0 function0, Object obj) {
            super(fVar, function0);
            this.f24654i = obj;
        }

        private static /* synthetic */ void b(int i2) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$4", "recursionDetected"));
        }

        @Override // kotlin.f0.y.e.j0.k.f.h
        protected o<T> e(boolean z) {
            o<T> d2 = o.d(this.f24654i);
            if (d2 == null) {
                b(0);
            }
            return d2;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: LockBasedStorageManager.java */
    /* loaded from: classes3.dex */
    class c<T> extends k<T> {

        /* renamed from: j, reason: collision with root package name */
        final /* synthetic */ Function1 f24656j;

        /* renamed from: k, reason: collision with root package name */
        final /* synthetic */ Function1 f24657k;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(f fVar, Function0 function0, Function1 function1, Function1 function12) {
            super(fVar, function0);
            this.f24656j = function1;
            this.f24657k = function12;
        }

        private static /* synthetic */ void b(int i2) {
            String str = i2 != 2 ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
            Object[] objArr = new Object[i2 != 2 ? 2 : 3];
            if (i2 != 2) {
                objArr[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$5";
            } else {
                objArr[0] = "value";
            }
            if (i2 != 2) {
                objArr[1] = "recursionDetected";
            } else {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$5";
            }
            if (i2 == 2) {
                objArr[2] = "doPostCompute";
            }
            String format = String.format(str, objArr);
            if (i2 == 2) {
                throw new IllegalArgumentException(format);
            }
        }

        @Override // kotlin.f0.y.e.j0.k.f.h
        protected o<T> e(boolean z) {
            Function1 function1 = this.f24656j;
            if (function1 == null) {
                o<T> e2 = super.e(z);
                if (e2 == null) {
                    b(0);
                }
                return e2;
            }
            o<T> d2 = o.d(function1.invoke(Boolean.valueOf(z)));
            if (d2 == null) {
                b(1);
            }
            return d2;
        }

        @Override // kotlin.f0.y.e.j0.k.f.i
        protected void g(T t) {
            if (t == null) {
                b(2);
            }
            this.f24657k.invoke(t);
        }
    }

    /* compiled from: LockBasedStorageManager.java */
    /* loaded from: classes3.dex */
    private static class d<K, V> extends e<K, V> implements kotlin.reflect.y.internal.j0.k.a<K, V> {
        /* synthetic */ d(f fVar, ConcurrentMap concurrentMap, a aVar) {
            this(fVar, concurrentMap);
        }

        private static /* synthetic */ void c(int i2) {
            String str = i2 != 3 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
            Object[] objArr = new Object[i2 != 3 ? 3 : 2];
            if (i2 == 1) {
                objArr[0] = "map";
            } else if (i2 == 2) {
                objArr[0] = "computation";
            } else if (i2 != 3) {
                objArr[0] = "storageManager";
            } else {
                objArr[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$CacheWithNotNullValuesBasedOnMemoizedFunction";
            }
            if (i2 != 3) {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$CacheWithNotNullValuesBasedOnMemoizedFunction";
            } else {
                objArr[1] = "computeIfAbsent";
            }
            if (i2 == 2) {
                objArr[2] = "computeIfAbsent";
            } else if (i2 != 3) {
                objArr[2] = "<init>";
            }
            String format = String.format(str, objArr);
            if (i2 == 3) {
                throw new IllegalStateException(format);
            }
        }

        @Override // kotlin.f0.y.e.j0.k.f.e, kotlin.reflect.y.internal.j0.k.a
        public V b(K k2, Function0<? extends V> function0) {
            if (function0 == null) {
                c(2);
            }
            V v = (V) super.b(k2, function0);
            if (v == null) {
                c(3);
            }
            return v;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        private d(f fVar, ConcurrentMap<g<K, V>, Object> concurrentMap) {
            super(fVar, concurrentMap, null);
            if (fVar == null) {
                c(0);
            }
            if (concurrentMap == null) {
                c(1);
            }
        }
    }

    /* compiled from: LockBasedStorageManager.java */
    /* loaded from: classes3.dex */
    private static class e<K, V> extends l<g<K, V>, V> implements kotlin.reflect.y.internal.j0.k.b<K, V> {

        /* compiled from: LockBasedStorageManager.java */
        /* loaded from: classes3.dex */
        class a implements Function1<g<K, V>, V> {
            a() {
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public V invoke(g<K, V> gVar) {
                return (V) ((g) gVar).f24658b.invoke();
            }
        }

        /* synthetic */ e(f fVar, ConcurrentMap concurrentMap, a aVar) {
            this(fVar, concurrentMap);
        }

        private static /* synthetic */ void c(int i2) {
            Object[] objArr = new Object[3];
            if (i2 == 1) {
                objArr[0] = "map";
            } else if (i2 != 2) {
                objArr[0] = "storageManager";
            } else {
                objArr[0] = "computation";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$CacheWithNullableValuesBasedOnMemoizedFunction";
            if (i2 != 2) {
                objArr[2] = "<init>";
            } else {
                objArr[2] = "computeIfAbsent";
            }
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        public V b(K k2, Function0<? extends V> function0) {
            if (function0 == null) {
                c(2);
            }
            return invoke(new g(k2, function0));
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        private e(f fVar, ConcurrentMap<g<K, V>, Object> concurrentMap) {
            super(fVar, concurrentMap, new a());
            if (fVar == null) {
                c(0);
            }
            if (concurrentMap == null) {
                c(1);
            }
        }
    }

    /* compiled from: LockBasedStorageManager.java */
    /* renamed from: kotlin.f0.y.e.j0.k.f$f, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0392f {
        public static final InterfaceC0392f a = new a();

        /* compiled from: LockBasedStorageManager.java */
        /* renamed from: kotlin.f0.y.e.j0.k.f$f$a */
        /* loaded from: classes3.dex */
        static class a implements InterfaceC0392f {
            a() {
            }

            private static /* synthetic */ void b(int i2) {
                throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", "throwable", "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$ExceptionHandlingStrategy$1", "handleException"));
            }

            @Override // kotlin.reflect.y.internal.j0.k.f.InterfaceC0392f
            public RuntimeException a(Throwable th) {
                if (th == null) {
                    b(0);
                }
                throw kotlin.reflect.jvm.internal.impl.utils.c.b(th);
            }
        }

        RuntimeException a(Throwable th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: LockBasedStorageManager.java */
    /* loaded from: classes3.dex */
    public static class g<K, V> {
        private final K a;

        /* renamed from: b, reason: collision with root package name */
        private final Function0<? extends V> f24658b;

        public g(K k2, Function0<? extends V> function0) {
            this.a = k2;
            this.f24658b = function0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && g.class == obj.getClass() && this.a.equals(((g) obj).a);
        }

        public int hashCode() {
            return this.a.hashCode();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: LockBasedStorageManager.java */
    /* loaded from: classes3.dex */
    public static class h<T> implements kotlin.reflect.y.internal.j0.k.j<T> {

        /* renamed from: f, reason: collision with root package name */
        private final f f24659f;

        /* renamed from: g, reason: collision with root package name */
        private final Function0<? extends T> f24660g;

        /* renamed from: h, reason: collision with root package name */
        private volatile Object f24661h;

        public h(f fVar, Function0<? extends T> function0) {
            if (fVar == null) {
                b(0);
            }
            if (function0 == null) {
                b(1);
            }
            this.f24661h = n.NOT_COMPUTED;
            this.f24659f = fVar;
            this.f24660g = function0;
        }

        private static /* synthetic */ void b(int i2) {
            String str = (i2 == 2 || i2 == 3) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
            Object[] objArr = new Object[(i2 == 2 || i2 == 3) ? 2 : 3];
            if (i2 == 1) {
                objArr[0] = "computable";
            } else if (i2 == 2 || i2 == 3) {
                objArr[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$LockBasedLazyValue";
            } else {
                objArr[0] = "storageManager";
            }
            if (i2 == 2) {
                objArr[1] = "recursionDetected";
            } else if (i2 != 3) {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$LockBasedLazyValue";
            } else {
                objArr[1] = "renderDebugInformation";
            }
            if (i2 != 2 && i2 != 3) {
                objArr[2] = "<init>";
            }
            String format = String.format(str, objArr);
            if (i2 != 2 && i2 != 3) {
                throw new IllegalArgumentException(format);
            }
            throw new IllegalStateException(format);
        }

        public boolean a() {
            return (this.f24661h == n.NOT_COMPUTED || this.f24661h == n.COMPUTING) ? false : true;
        }

        protected void c(T t) {
        }

        protected o<T> e(boolean z) {
            o<T> p = this.f24659f.p("in a lazy value", null);
            if (p == null) {
                b(2);
            }
            return p;
        }

        @Override // kotlin.jvm.functions.Function0
        public T invoke() {
            T invoke;
            Object obj = this.f24661h;
            if (!(obj instanceof n)) {
                return (T) WrappedValues.f(obj);
            }
            this.f24659f.f24651c.lock();
            try {
                Object obj2 = this.f24661h;
                if (obj2 instanceof n) {
                    n nVar = n.COMPUTING;
                    if (obj2 == nVar) {
                        this.f24661h = n.RECURSION_WAS_DETECTED;
                        o<T> e2 = e(true);
                        if (!e2.c()) {
                            invoke = e2.b();
                        }
                    }
                    if (obj2 == n.RECURSION_WAS_DETECTED) {
                        o<T> e3 = e(false);
                        if (!e3.c()) {
                            invoke = e3.b();
                        }
                    }
                    this.f24661h = nVar;
                    try {
                        invoke = this.f24660g.invoke();
                        c(invoke);
                        this.f24661h = invoke;
                    } catch (Throwable th) {
                        if (!kotlin.reflect.jvm.internal.impl.utils.c.a(th)) {
                            if (this.f24661h == n.COMPUTING) {
                                this.f24661h = WrappedValues.c(th);
                            }
                            throw this.f24659f.f24652d.a(th);
                        }
                        this.f24661h = n.NOT_COMPUTED;
                        throw th;
                    }
                } else {
                    invoke = (T) WrappedValues.f(obj2);
                }
                return invoke;
            } finally {
                this.f24659f.f24651c.unlock();
            }
        }
    }

    /* compiled from: LockBasedStorageManager.java */
    /* loaded from: classes3.dex */
    private static abstract class i<T> extends h<T> {

        /* renamed from: i, reason: collision with root package name */
        private volatile kotlin.reflect.y.internal.j0.k.l<T> f24662i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(f fVar, Function0<? extends T> function0) {
            super(fVar, function0);
            if (fVar == null) {
                b(0);
            }
            if (function0 == null) {
                b(1);
            }
            this.f24662i = null;
        }

        private static /* synthetic */ void b(int i2) {
            Object[] objArr = new Object[3];
            if (i2 != 1) {
                objArr[0] = "storageManager";
            } else {
                objArr[0] = "computable";
            }
            objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$LockBasedLazyValueWithPostCompute";
            objArr[2] = "<init>";
            throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
        }

        @Override // kotlin.f0.y.e.j0.k.f.h
        protected final void c(T t) {
            this.f24662i = new kotlin.reflect.y.internal.j0.k.l<>(t);
            try {
                g(t);
            } finally {
                this.f24662i = null;
            }
        }

        protected abstract void g(T t);

        @Override // kotlin.f0.y.e.j0.k.f.h, kotlin.jvm.functions.Function0
        public T invoke() {
            kotlin.reflect.y.internal.j0.k.l<T> lVar = this.f24662i;
            if (lVar != null && lVar.b()) {
                return lVar.a();
            }
            return (T) super.invoke();
        }
    }

    /* compiled from: LockBasedStorageManager.java */
    /* loaded from: classes3.dex */
    private static class j<T> extends h<T> implements kotlin.reflect.y.internal.j0.k.i<T> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(f fVar, Function0<? extends T> function0) {
            super(fVar, function0);
            if (fVar == null) {
                b(0);
            }
            if (function0 == null) {
                b(1);
            }
        }

        private static /* synthetic */ void b(int i2) {
            String str = i2 != 2 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
            Object[] objArr = new Object[i2 != 2 ? 3 : 2];
            if (i2 == 1) {
                objArr[0] = "computable";
            } else if (i2 != 2) {
                objArr[0] = "storageManager";
            } else {
                objArr[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$LockBasedNotNullLazyValue";
            }
            if (i2 != 2) {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$LockBasedNotNullLazyValue";
            } else {
                objArr[1] = "invoke";
            }
            if (i2 != 2) {
                objArr[2] = "<init>";
            }
            String format = String.format(str, objArr);
            if (i2 == 2) {
                throw new IllegalStateException(format);
            }
        }

        @Override // kotlin.f0.y.e.j0.k.f.h, kotlin.jvm.functions.Function0
        public T invoke() {
            T t = (T) super.invoke();
            if (t == null) {
                b(2);
            }
            return t;
        }
    }

    /* compiled from: LockBasedStorageManager.java */
    /* loaded from: classes3.dex */
    private static abstract class k<T> extends i<T> implements kotlin.reflect.y.internal.j0.k.i<T> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k(f fVar, Function0<? extends T> function0) {
            super(fVar, function0);
            if (fVar == null) {
                b(0);
            }
            if (function0 == null) {
                b(1);
            }
        }

        private static /* synthetic */ void b(int i2) {
            String str = i2 != 2 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
            Object[] objArr = new Object[i2 != 2 ? 3 : 2];
            if (i2 == 1) {
                objArr[0] = "computable";
            } else if (i2 != 2) {
                objArr[0] = "storageManager";
            } else {
                objArr[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$LockBasedNotNullLazyValueWithPostCompute";
            }
            if (i2 != 2) {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$LockBasedNotNullLazyValueWithPostCompute";
            } else {
                objArr[1] = "invoke";
            }
            if (i2 != 2) {
                objArr[2] = "<init>";
            }
            String format = String.format(str, objArr);
            if (i2 == 2) {
                throw new IllegalStateException(format);
            }
        }

        @Override // kotlin.f0.y.e.j0.k.f.i, kotlin.f0.y.e.j0.k.f.h, kotlin.jvm.functions.Function0
        public T invoke() {
            T t = (T) super.invoke();
            if (t == null) {
                b(2);
            }
            return t;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: LockBasedStorageManager.java */
    /* loaded from: classes3.dex */
    public static class l<K, V> implements kotlin.reflect.y.internal.j0.k.h<K, V> {

        /* renamed from: f, reason: collision with root package name */
        private final f f24663f;

        /* renamed from: g, reason: collision with root package name */
        private final ConcurrentMap<K, Object> f24664g;

        /* renamed from: h, reason: collision with root package name */
        private final Function1<? super K, ? extends V> f24665h;

        public l(f fVar, ConcurrentMap<K, Object> concurrentMap, Function1<? super K, ? extends V> function1) {
            if (fVar == null) {
                c(0);
            }
            if (concurrentMap == null) {
                c(1);
            }
            if (function1 == null) {
                c(2);
            }
            this.f24663f = fVar;
            this.f24664g = concurrentMap;
            this.f24665h = function1;
        }

        private static /* synthetic */ void c(int i2) {
            String str = (i2 == 3 || i2 == 4) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
            Object[] objArr = new Object[(i2 == 3 || i2 == 4) ? 2 : 3];
            if (i2 == 1) {
                objArr[0] = "map";
            } else if (i2 == 2) {
                objArr[0] = "compute";
            } else if (i2 == 3 || i2 == 4) {
                objArr[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$MapBasedMemoizedFunction";
            } else {
                objArr[0] = "storageManager";
            }
            if (i2 == 3) {
                objArr[1] = "recursionDetected";
            } else if (i2 != 4) {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$MapBasedMemoizedFunction";
            } else {
                objArr[1] = "raceCondition";
            }
            if (i2 != 3 && i2 != 4) {
                objArr[2] = "<init>";
            }
            String format = String.format(str, objArr);
            if (i2 != 3 && i2 != 4) {
                throw new IllegalArgumentException(format);
            }
            throw new IllegalStateException(format);
        }

        private AssertionError e(K k2, Object obj) {
            AssertionError assertionError = (AssertionError) f.q(new AssertionError("Race condition detected on input " + k2 + ". Old value is " + obj + " under " + this.f24663f));
            if (assertionError == null) {
                c(4);
            }
            return assertionError;
        }

        @Override // kotlin.reflect.y.internal.j0.k.h
        public boolean f(K k2) {
            Object obj = this.f24664g.get(k2);
            return (obj == null || obj == n.COMPUTING) ? false : true;
        }

        protected o<V> g(K k2, boolean z) {
            o<V> p = this.f24663f.p(HttpUrl.FRAGMENT_ENCODE_SET, k2);
            if (p == null) {
                c(3);
            }
            return p;
        }

        @Override // kotlin.jvm.functions.Function1
        public V invoke(K k2) {
            V v;
            Object obj = this.f24664g.get(k2);
            if (obj != null && obj != n.COMPUTING) {
                return (V) WrappedValues.d(obj);
            }
            this.f24663f.f24651c.lock();
            try {
                Object obj2 = this.f24664g.get(k2);
                n nVar = n.COMPUTING;
                if (obj2 == nVar) {
                    obj2 = n.RECURSION_WAS_DETECTED;
                    o<V> g2 = g(k2, true);
                    if (!g2.c()) {
                        v = g2.b();
                        return v;
                    }
                }
                if (obj2 == n.RECURSION_WAS_DETECTED) {
                    o<V> g3 = g(k2, false);
                    if (!g3.c()) {
                        v = g3.b();
                        return v;
                    }
                }
                if (obj2 != null) {
                    v = (V) WrappedValues.d(obj2);
                    return v;
                }
                AssertionError assertionError = null;
                try {
                    this.f24664g.put(k2, nVar);
                    V invoke = this.f24665h.invoke(k2);
                    Object put = this.f24664g.put(k2, WrappedValues.b(invoke));
                    if (put == nVar) {
                        return invoke;
                    }
                    assertionError = e(k2, put);
                    throw assertionError;
                } catch (Throwable th) {
                    if (kotlin.reflect.jvm.internal.impl.utils.c.a(th)) {
                        this.f24664g.remove(k2);
                        throw th;
                    }
                    if (th == assertionError) {
                        throw this.f24663f.f24652d.a(th);
                    }
                    Object put2 = this.f24664g.put(k2, WrappedValues.c(th));
                    if (put2 == n.COMPUTING) {
                        throw this.f24663f.f24652d.a(th);
                    }
                    throw e(k2, put2);
                }
            } finally {
                this.f24663f.f24651c.unlock();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: LockBasedStorageManager.java */
    /* loaded from: classes3.dex */
    public static class m<K, V> extends l<K, V> implements kotlin.reflect.y.internal.j0.k.g<K, V> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public m(f fVar, ConcurrentMap<K, Object> concurrentMap, Function1<? super K, ? extends V> function1) {
            super(fVar, concurrentMap, function1);
            if (fVar == null) {
                c(0);
            }
            if (concurrentMap == null) {
                c(1);
            }
            if (function1 == null) {
                c(2);
            }
        }

        private static /* synthetic */ void c(int i2) {
            String str = i2 != 3 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
            Object[] objArr = new Object[i2 != 3 ? 3 : 2];
            if (i2 == 1) {
                objArr[0] = "map";
            } else if (i2 == 2) {
                objArr[0] = "compute";
            } else if (i2 != 3) {
                objArr[0] = "storageManager";
            } else {
                objArr[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$MapBasedMemoizedFunctionToNotNull";
            }
            if (i2 != 3) {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager$MapBasedMemoizedFunctionToNotNull";
            } else {
                objArr[1] = "invoke";
            }
            if (i2 != 3) {
                objArr[2] = "<init>";
            }
            String format = String.format(str, objArr);
            if (i2 == 3) {
                throw new IllegalStateException(format);
            }
        }

        @Override // kotlin.f0.y.e.j0.k.f.l, kotlin.jvm.functions.Function1
        public V invoke(K k2) {
            V v = (V) super.invoke(k2);
            if (v == null) {
                c(3);
            }
            return v;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: LockBasedStorageManager.java */
    /* loaded from: classes3.dex */
    public enum n {
        NOT_COMPUTED,
        COMPUTING,
        RECURSION_WAS_DETECTED
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: LockBasedStorageManager.java */
    /* loaded from: classes3.dex */
    public static class o<T> {
        private final T a;

        /* renamed from: b, reason: collision with root package name */
        private final boolean f24670b;

        private o(T t, boolean z) {
            this.a = t;
            this.f24670b = z;
        }

        public static <T> o<T> a() {
            return new o<>(null, true);
        }

        public static <T> o<T> d(T t) {
            return new o<>(t, false);
        }

        public T b() {
            return this.a;
        }

        public boolean c() {
            return this.f24670b;
        }

        public String toString() {
            return c() ? "FALL_THROUGH" : String.valueOf(this.a);
        }
    }

    static {
        String N0;
        N0 = v.N0(f.class.getCanonicalName(), ".", HttpUrl.FRAGMENT_ENCODE_SET);
        a = N0;
        f24650b = new a("NO_LOCKS", InterfaceC0392f.a, kotlin.reflect.y.internal.j0.k.e.f24649b);
    }

    /* synthetic */ f(String str, InterfaceC0392f interfaceC0392f, kotlin.reflect.y.internal.j0.k.k kVar, a aVar) {
        this(str, interfaceC0392f, kVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00be  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static /* synthetic */ void j(int i2) {
        String format;
        String str = (i2 == 10 || i2 == 13 || i2 == 20 || i2 == 37) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i2 == 10 || i2 == 13 || i2 == 20 || i2 == 37) ? 2 : 3];
        if (i2 != 1 && i2 != 3 && i2 != 5) {
            if (i2 != 6) {
                switch (i2) {
                    case 8:
                        break;
                    case 9:
                    case 11:
                    case 14:
                    case 16:
                    case 19:
                    case 21:
                        objArr[0] = "compute";
                        break;
                    case 10:
                    case 13:
                    case 20:
                    case 37:
                        objArr[0] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager";
                        break;
                    case 12:
                    case 17:
                    case 25:
                    case 27:
                        objArr[0] = "onRecursiveCall";
                        break;
                    case 15:
                    case 18:
                    case 22:
                        objArr[0] = "map";
                        break;
                    case 23:
                    case 24:
                    case 26:
                    case 28:
                    case 30:
                    case 31:
                    case 32:
                    case 34:
                        objArr[0] = "computable";
                        break;
                    case 29:
                    case 33:
                        objArr[0] = "postCompute";
                        break;
                    case 35:
                        objArr[0] = "source";
                        break;
                    case 36:
                        objArr[0] = "throwable";
                        break;
                    default:
                        objArr[0] = "debugText";
                        break;
                }
            } else {
                objArr[0] = "lock";
            }
            if (i2 != 10 || i2 == 13) {
                objArr[1] = "createMemoizedFunction";
            } else if (i2 == 20) {
                objArr[1] = "createMemoizedFunctionWithNullableValues";
            } else if (i2 != 37) {
                objArr[1] = "kotlin/reflect/jvm/internal/impl/storage/LockBasedStorageManager";
            } else {
                objArr[1] = "sanitizeStackTrace";
            }
            switch (i2) {
                case 4:
                case 5:
                case 6:
                    objArr[2] = "<init>";
                    break;
                case 7:
                case 8:
                    objArr[2] = "replaceExceptionHandling";
                    break;
                case 9:
                case 11:
                case 12:
                case 14:
                case 15:
                case 16:
                case 17:
                case 18:
                    objArr[2] = "createMemoizedFunction";
                    break;
                case 10:
                case 13:
                case 20:
                case 37:
                    break;
                case 19:
                case 21:
                case 22:
                    objArr[2] = "createMemoizedFunctionWithNullableValues";
                    break;
                case 23:
                case 24:
                case 25:
                    objArr[2] = "createLazyValue";
                    break;
                case 26:
                case 27:
                    objArr[2] = "createRecursionTolerantLazyValue";
                    break;
                case 28:
                case 29:
                    objArr[2] = "createLazyValueWithPostCompute";
                    break;
                case 30:
                    objArr[2] = "createNullableLazyValue";
                    break;
                case 31:
                    objArr[2] = "createRecursionTolerantNullableLazyValue";
                    break;
                case 32:
                case 33:
                    objArr[2] = "createNullableLazyValueWithPostCompute";
                    break;
                case 34:
                    objArr[2] = "compute";
                    break;
                case 35:
                    objArr[2] = "recursionDetectedDefault";
                    break;
                case 36:
                    objArr[2] = "sanitizeStackTrace";
                    break;
                default:
                    objArr[2] = "createWithExceptionHandling";
                    break;
            }
            format = String.format(str, objArr);
            if (i2 == 10 && i2 != 13 && i2 != 20 && i2 != 37) {
                throw new IllegalArgumentException(format);
            }
            throw new IllegalStateException(format);
        }
        objArr[0] = "exceptionHandlingStrategy";
        if (i2 != 10) {
        }
        objArr[1] = "createMemoizedFunction";
        switch (i2) {
        }
        format = String.format(str, objArr);
        if (i2 == 10) {
        }
        throw new IllegalStateException(format);
    }

    private static <K> ConcurrentMap<K, Object> m() {
        return new ConcurrentHashMap(3, 1.0f, 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <T extends Throwable> T q(T t) {
        if (t == null) {
            j(36);
        }
        StackTraceElement[] stackTrace = t.getStackTrace();
        int length = stackTrace.length;
        int i2 = -1;
        int i3 = 0;
        while (true) {
            if (i3 >= length) {
                break;
            }
            if (!stackTrace[i3].getClassName().startsWith(a)) {
                i2 = i3;
                break;
            }
            i3++;
        }
        List subList = Arrays.asList(stackTrace).subList(i2, length);
        t.setStackTrace((StackTraceElement[]) subList.toArray(new StackTraceElement[subList.size()]));
        return t;
    }

    @Override // kotlin.reflect.y.internal.j0.k.n
    public <K, V> kotlin.reflect.y.internal.j0.k.b<K, V> a() {
        return new e(this, m(), null);
    }

    @Override // kotlin.reflect.y.internal.j0.k.n
    public <K, V> kotlin.reflect.y.internal.j0.k.a<K, V> b() {
        return new d(this, m(), null);
    }

    @Override // kotlin.reflect.y.internal.j0.k.n
    public <T> kotlin.reflect.y.internal.j0.k.i<T> c(Function0<? extends T> function0, T t) {
        if (function0 == null) {
            j(26);
        }
        if (t == null) {
            j(27);
        }
        return new b(this, function0, t);
    }

    @Override // kotlin.reflect.y.internal.j0.k.n
    public <T> kotlin.reflect.y.internal.j0.k.i<T> d(Function0<? extends T> function0) {
        if (function0 == null) {
            j(23);
        }
        return new j(this, function0);
    }

    @Override // kotlin.reflect.y.internal.j0.k.n
    public <T> T e(Function0<? extends T> function0) {
        if (function0 == null) {
            j(34);
        }
        this.f24651c.lock();
        try {
            return function0.invoke();
        } finally {
        }
    }

    @Override // kotlin.reflect.y.internal.j0.k.n
    public <T> kotlin.reflect.y.internal.j0.k.j<T> f(Function0<? extends T> function0) {
        if (function0 == null) {
            j(30);
        }
        return new h(this, function0);
    }

    @Override // kotlin.reflect.y.internal.j0.k.n
    public <T> kotlin.reflect.y.internal.j0.k.i<T> g(Function0<? extends T> function0, Function1<? super Boolean, ? extends T> function1, Function1<? super T, u> function12) {
        if (function0 == null) {
            j(28);
        }
        if (function12 == null) {
            j(29);
        }
        return new c(this, function0, function1, function12);
    }

    @Override // kotlin.reflect.y.internal.j0.k.n
    public <K, V> kotlin.reflect.y.internal.j0.k.g<K, V> h(Function1<? super K, ? extends V> function1) {
        if (function1 == null) {
            j(9);
        }
        kotlin.reflect.y.internal.j0.k.g<K, V> n2 = n(function1, m());
        if (n2 == null) {
            j(10);
        }
        return n2;
    }

    @Override // kotlin.reflect.y.internal.j0.k.n
    public <K, V> kotlin.reflect.y.internal.j0.k.h<K, V> i(Function1<? super K, ? extends V> function1) {
        if (function1 == null) {
            j(19);
        }
        kotlin.reflect.y.internal.j0.k.h<K, V> o2 = o(function1, m());
        if (o2 == null) {
            j(20);
        }
        return o2;
    }

    public <K, V> kotlin.reflect.y.internal.j0.k.g<K, V> n(Function1<? super K, ? extends V> function1, ConcurrentMap<K, Object> concurrentMap) {
        if (function1 == null) {
            j(14);
        }
        if (concurrentMap == null) {
            j(15);
        }
        return new m(this, concurrentMap, function1);
    }

    public <K, V> kotlin.reflect.y.internal.j0.k.h<K, V> o(Function1<? super K, ? extends V> function1, ConcurrentMap<K, Object> concurrentMap) {
        if (function1 == null) {
            j(21);
        }
        if (concurrentMap == null) {
            j(22);
        }
        return new l(this, concurrentMap, function1);
    }

    protected <K, V> o<V> p(String str, K k2) {
        String str2;
        if (str == null) {
            j(35);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Recursion detected ");
        sb.append(str);
        if (k2 == null) {
            str2 = HttpUrl.FRAGMENT_ENCODE_SET;
        } else {
            str2 = "on input: " + k2;
        }
        sb.append(str2);
        sb.append(" under ");
        sb.append(this);
        throw ((AssertionError) q(new AssertionError(sb.toString())));
    }

    public String toString() {
        return getClass().getSimpleName() + "@" + Integer.toHexString(hashCode()) + " (" + this.f24653e + ")";
    }

    private f(String str, InterfaceC0392f interfaceC0392f, kotlin.reflect.y.internal.j0.k.k kVar) {
        if (str == null) {
            j(4);
        }
        if (interfaceC0392f == null) {
            j(5);
        }
        if (kVar == null) {
            j(6);
        }
        this.f24651c = kVar;
        this.f24652d = interfaceC0392f;
        this.f24653e = str;
    }

    public f(String str) {
        this(str, (Runnable) null, (Function1<InterruptedException, u>) null);
    }

    public f(String str, Runnable runnable, Function1<InterruptedException, u> function1) {
        this(str, InterfaceC0392f.a, kotlin.reflect.y.internal.j0.k.k.a.a(runnable, function1));
    }
}
