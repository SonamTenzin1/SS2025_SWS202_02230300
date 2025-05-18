package kotlin.reflect.jvm.internal.impl.utils;

import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.collections.n;
import kotlin.collections.w0;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.l0;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.markers.KMappedMarker;

/* compiled from: SmartSet.kt */
/* loaded from: classes3.dex */
public final class f<T> extends AbstractSet<T> {

    /* renamed from: f, reason: collision with root package name */
    public static final b f25524f = new b(null);

    /* renamed from: g, reason: collision with root package name */
    private Object f25525g;

    /* renamed from: h, reason: collision with root package name */
    private int f25526h;

    /* compiled from: SmartSet.kt */
    /* loaded from: classes3.dex */
    private static final class a<T> implements Iterator<T>, KMappedMarker {

        /* renamed from: f, reason: collision with root package name */
        private final Iterator<T> f25527f;

        public a(T[] tArr) {
            m.f(tArr, "array");
            this.f25527f = kotlin.jvm.internal.b.a(tArr);
        }

        @Override // java.util.Iterator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Void remove() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f25527f.hasNext();
        }

        @Override // java.util.Iterator
        public T next() {
            return this.f25527f.next();
        }
    }

    /* compiled from: SmartSet.kt */
    /* loaded from: classes3.dex */
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(g gVar) {
            this();
        }

        public final <T> f<T> a() {
            return new f<>(null);
        }

        public final <T> f<T> b(Collection<? extends T> collection) {
            m.f(collection, "set");
            f<T> fVar = new f<>(null);
            fVar.addAll(collection);
            return fVar;
        }
    }

    /* compiled from: SmartSet.kt */
    /* loaded from: classes3.dex */
    private static final class c<T> implements Iterator<T>, KMappedMarker {

        /* renamed from: f, reason: collision with root package name */
        private final T f25528f;

        /* renamed from: g, reason: collision with root package name */
        private boolean f25529g = true;

        public c(T t) {
            this.f25528f = t;
        }

        @Override // java.util.Iterator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Void remove() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f25529g;
        }

        @Override // java.util.Iterator
        public T next() {
            if (this.f25529g) {
                this.f25529g = false;
                return this.f25528f;
            }
            throw new NoSuchElementException();
        }
    }

    private f() {
    }

    public /* synthetic */ f(g gVar) {
        this();
    }

    public static final <T> f<T> c() {
        return f25524f.a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean add(T t) {
        boolean t2;
        Object[] objArr;
        LinkedHashSet f2;
        if (size() == 0) {
            this.f25525g = t;
        } else if (size() == 1) {
            if (m.a(this.f25525g, t)) {
                return false;
            }
            this.f25525g = new Object[]{this.f25525g, t};
        } else if (size() < 5) {
            Object obj = this.f25525g;
            m.d(obj, "null cannot be cast to non-null type kotlin.Array<T of org.jetbrains.kotlin.utils.SmartSet>");
            Object[] objArr2 = (Object[]) obj;
            t2 = n.t(objArr2, t);
            if (t2) {
                return false;
            }
            if (size() == 4) {
                f2 = w0.f(Arrays.copyOf(objArr2, objArr2.length));
                f2.add(t);
                objArr = f2;
            } else {
                Object[] copyOf = Arrays.copyOf(objArr2, size() + 1);
                m.e(copyOf, "copyOf(this, newSize)");
                copyOf[copyOf.length - 1] = t;
                objArr = copyOf;
            }
            this.f25525g = objArr;
        } else {
            Object obj2 = this.f25525g;
            m.d(obj2, "null cannot be cast to non-null type kotlin.collections.MutableSet<T of org.jetbrains.kotlin.utils.SmartSet>");
            if (!l0.d(obj2).add(t)) {
                return false;
            }
        }
        g(size() + 1);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        this.f25525g = null;
        g(0);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        boolean t;
        if (size() == 0) {
            return false;
        }
        if (size() == 1) {
            return m.a(this.f25525g, obj);
        }
        if (size() >= 5) {
            Object obj2 = this.f25525g;
            m.d(obj2, "null cannot be cast to non-null type kotlin.collections.Set<T of org.jetbrains.kotlin.utils.SmartSet>");
            return ((Set) obj2).contains(obj);
        }
        Object obj3 = this.f25525g;
        m.d(obj3, "null cannot be cast to non-null type kotlin.Array<T of org.jetbrains.kotlin.utils.SmartSet>");
        t = n.t((Object[]) obj3, obj);
        return t;
    }

    public int f() {
        return this.f25526h;
    }

    public void g(int i2) {
        this.f25526h = i2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator<T> iterator() {
        if (size() == 0) {
            return Collections.emptySet().iterator();
        }
        if (size() == 1) {
            return new c(this.f25525g);
        }
        if (size() < 5) {
            Object obj = this.f25525g;
            m.d(obj, "null cannot be cast to non-null type kotlin.Array<T of org.jetbrains.kotlin.utils.SmartSet>");
            return new a((Object[]) obj);
        }
        Object obj2 = this.f25525g;
        m.d(obj2, "null cannot be cast to non-null type kotlin.collections.MutableSet<T of org.jetbrains.kotlin.utils.SmartSet>");
        return l0.d(obj2).iterator();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final /* bridge */ int size() {
        return f();
    }
}
