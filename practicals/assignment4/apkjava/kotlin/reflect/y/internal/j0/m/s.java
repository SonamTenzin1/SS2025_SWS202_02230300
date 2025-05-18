package kotlin.reflect.y.internal.j0.m;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.m;
import kotlin.reflect.KClass;

/* compiled from: ArrayMapOwner.kt */
/* loaded from: classes3.dex */
public abstract class s<K, V> {
    private final ConcurrentHashMap<KClass<? extends K>, Integer> a = new ConcurrentHashMap<>();

    /* renamed from: b, reason: collision with root package name */
    private final AtomicInteger f24935b = new AtomicInteger(0);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ArrayMapOwner.kt */
    /* loaded from: classes3.dex */
    public static final class a extends Lambda implements Function1<KClass<? extends K>, Integer> {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ s<K, V> f24936f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(s<K, V> sVar) {
            super(1);
            this.f24936f = sVar;
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Integer invoke(KClass<? extends K> kClass) {
            m.f(kClass, "it");
            return Integer.valueOf(((s) this.f24936f).f24935b.getAndIncrement());
        }
    }

    public abstract <T extends K> int b(ConcurrentHashMap<KClass<? extends K>, Integer> concurrentHashMap, KClass<T> kClass, Function1<? super KClass<? extends K>, Integer> function1);

    /* JADX WARN: Multi-variable type inference failed */
    public final <T extends V, KK extends K> n<K, V, T> c(KClass<KK> kClass) {
        m.f(kClass, "kClass");
        return new n<>(kClass, d(kClass));
    }

    public final <T extends K> int d(KClass<T> kClass) {
        m.f(kClass, "kClass");
        return b(this.a, kClass, new a(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Collection<Integer> e() {
        Collection<Integer> values = this.a.values();
        m.e(values, "idPerType.values");
        return values;
    }
}
